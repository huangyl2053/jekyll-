/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeikoiki.ShotokuJohoTyushutuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 所得情報抽出・連携（広域用）のHandlerクラスです。
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class ShotokuJohoChushutsuKoikiBatchParameterHandler {

    private final ShotokuJohoChushutsuKoikiBatchParameterDiv div;
    private static final RString 事務広域 = new RString("111");
    private static final RString 処理区分_3 = new RString("3");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 広域保険者でないため = new RString("広域保険者でないため");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51008");
    private static final RString 当初所得引出 = new RString("当初所得引出");
    private static final RString 所得引出 = new RString("所得引出");
    private static final RString 広域職員でないため = new RString("広域職員でないため");
    private static final RString なし = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     */
    public ShotokuJohoChushutsuKoikiBatchParameterHandler(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のチェックし,初期化メソッドです
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @return ShotokuJohoChushutsuKoikiPanelHandler
     */
    public static ShotokuJohoChushutsuKoikiBatchParameterHandler of(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        return new ShotokuJohoChushutsuKoikiBatchParameterHandler(div);
    }

    /**
     * 画面初期化のチェック
     *
     * @param currentTime RDate
     */
    public void initCheck(RDate currentTime) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            RString 市町村形態コード = new RString(市町村セキュリティ情報.get導入形態コード().value().toString());
            if (!事務広域.equals(市町村形態コード)) {
                throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                        .replace(広域保険者でないため.toString()).evaluate());
            }
        }

        RString メニューID = ResponseHolder.getMenuID();
        RString config = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, currentTime, SubGyomuCode.DBB介護賦課);
        RString config2 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, currentTime, SubGyomuCode.DBB介護賦課);
        if (所得情報抽出_連携異動.equals(メニューID) && !config.equals(config2)) {
            throw new ApplicationException(DbbErrorMessages.処理不可_関連機能未処理済.getMessage().replace(当初所得引出.toString())
                    .replace(所得引出.toString()).evaluate());
        }
    }

    /**
     * 市町村一覧情報の取得し,初期化設定のメソッドです
     *
     * @param currentTime RDate
     * @param shichosonJohoList List<ShichosonJohoResult>
     */
    public void shichosonIchiran(RDate currentTime, List<ShichosonJohoResult> shichosonJohoList) {
        RString ログインユーザID = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        List<KoikiZenShichosonJoho> list = new ArrayList<>();
        if (ログインユーザID != null) {
            List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
            if (市町村識別ID != null) {
                handler市町村識別ID(市町村識別ID, list);
            }
        }
        for (ShichosonJohoResult entity : shichosonJohoList) {
            if (処理区分_3.equals(entity.getEntity().get処理区分())) {
                throw new ApplicationException(DbzErrorMessages.処理日付管理マスタなし.getMessage()
                        .replace(当初所得引出.toString()).evaluate());
            }
        }
    }

    /**
     * 共有ファイル化したCSVファイルのチェックを行う。
     *
     * @param files FileData[]
     * @return ValidationMessageControlPairs
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ValidationMessageControlPairs checkFilesStates(FileData[] files) {
        ShotokuJohoChushutsuKoikiBatchParameterValidationHandler validation
                = new ShotokuJohoChushutsuKoikiBatchParameterValidationHandler(div);
        ValidationMessageControlPairs pairs = validation.必須チェックValidate(files);
        return pairs;
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @return ShotokuJohoTyushutuRenkeiKoikiParameter 所得情報抽出・連携_バッチパラメータクラスです
     */
    public ShotokuJohoTyushutuRenkeiKoikiParameter getBatchParamter() {
        // to-do
        ShotokuJohoTyushutuRenkeiKoikiParameter batchparam = new ShotokuJohoTyushutuRenkeiKoikiParameter();
        batchparam.set共有ファイルID(null);
        batchparam.set共有ファイル名(null);
        batchparam.set処理区分(null);
        batchparam.set処理年度(null);
        batchparam.set出力順ID(null);
        batchparam.set市町村情報List(null);
        batchparam.set帳票ID(null);
        return batchparam;
    }

    private void handler市町村識別ID(List<AuthorityItem> 市町村識別ID,
            List<KoikiZenShichosonJoho> list) {
        if (!市町村識別ID_00.equals(new RString(市町村識別ID.get(0).toString()))) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                    .replace(広域職員でないため.toString()).evaluate());
        }
        SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJohoList = KoikiShichosonJohoFinder
                .createInstance().getGenShichosonJoho();
        list.addAll(koikiZenShichosonJohoList.records());
        if (市町村識別ID_00.equals(new RString(市町村識別ID.get(0).toString()))) {
            koikiZenShichosonJohoList = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
            for (KoikiZenShichosonJoho entity : koikiZenShichosonJohoList.records()) {
                if (entity.get所得引出方法() != なし) {
                    list.remove(entity);
                }

            }
        }
    }

}
