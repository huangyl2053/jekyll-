/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeikoiki.ShotokuJohoTyushutuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeikoiki.ShotokuJohoChushutsuRenkeiKoiki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
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
    private static final RString 所得情報抽出_連携当初 = new RString("DBBMN51006");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51008");
    private static final RString 当初所得引出 = new RString("当初所得引出");
    private static final RString 所得引出 = new RString("所得引出");
    private static final RString 広域職員でないため = new RString("広域職員でないため");
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString なし = new RString("0");
    private static final RString BBKAIGO = new RString("BBKAIGO");
    private static final RString アップロードファイルが不正 = new RString("アップロードファイルが不正");

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
     */
    public void initCheck() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            RString 市町村形態コード = new RString(市町村セキュリティ情報.get導入形態コード().value().toString());
            if (!事務広域.equals(市町村形態コード)) {
                throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                        .replace(広域保険者でないため.toString()).evaluate());
            }
        } else {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }

        RString メニューID = ResponseHolder.getMenuID();
        RString config = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString config2 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (所得情報抽出_連携異動.equals(メニューID) && !config.equals(config2)) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage().replace(当初所得引出.toString())
                    .replace(所得引出.toString()).evaluate());
        }
    }

    /**
     * 市町村一覧情報の取得し,初期化設定のメソッドです
     *
     */
    public void shichosonIchiran() {
        RString 遷移区分 = null;
        FlexibleYear 年度 = null;
        RString ログインユーザID = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJohoList = KoikiShichosonJohoFinder
                .createInstance().getGenShichosonJoho();
        if (ログインユーザID != null) {
            List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
            if (市町村識別ID != null) {
                handler市町村識別ID(市町村識別ID, koikiZenShichosonJohoList);
            }
        }
        RString メニューID = ResponseHolder.getMenuID();
        if (所得情報抽出_連携当初.equals(メニューID)) {
            遷移区分 = 遷移区分_0;
            年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                    SubGyomuCode.DBB介護賦課));
        } else if (所得情報抽出_連携異動.equals(メニューID)) {
            遷移区分 = 遷移区分_1;
            年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(),
                    SubGyomuCode.DBB介護賦課));
        }
        List<ShichosonJohoResult> shichosonJohoList = ShotokuJohoChushutsuRenkeiKoiki.createInstance()
                .getShichosonJoho(koikiZenShichosonJohoList.records(), 遷移区分, 年度);
        for (ShichosonJohoResult entity : shichosonJohoList) {
            if (処理区分_3.equals(entity.getEntity().get処理区分())) {
                throw new ApplicationException(DbzErrorMessages.処理日付管理マスタなし.getMessage()
                        .replace(当初所得引出.toString()).evaluate());
            }
        }
        div.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki().setDisabled(true);
    }

    /**
     * 共有ファイル化したCSVファイルのチェックを行う。
     *
     * @param files FileData[]
     * @return ValidationMessageControlPairs
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ValidationMessageControlPairs checkFilesStates(FileData[] files) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!files[0].getFileName().startsWith(BBKAIGO) || files[0] == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShotokuJohoChushutsuKoikiBatchParameterHandler.IdocheckMessages(
                            DbbErrorMessages.valueOf(アップロードファイルが不正.toString()))));
            return validationMessages;
        }
        return validationMessages;
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @return ShotokuJohoTyushutuRenkeiKoikiParameter 所得情報抽出・連携_バッチパラメータクラスです
     */
    public ShotokuJohoTyushutuRenkeiKoikiParameter getBatchParamter() {
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
            SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJohoList) {
        if (!市町村識別ID_00.equals(new RString(市町村識別ID.get(0).toString()))) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                    .replace(広域職員でないため.toString()).evaluate());
        }
        if (市町村識別ID_00.equals(new RString(市町村識別ID.get(0).toString()))) {
            koikiZenShichosonJohoList = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
            for (KoikiZenShichosonJoho list : koikiZenShichosonJohoList.records()) {
                if (list.get所得引出方法() != なし) {
                    list.get所得引出方法().remove(0);
                }

            }
        }
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
