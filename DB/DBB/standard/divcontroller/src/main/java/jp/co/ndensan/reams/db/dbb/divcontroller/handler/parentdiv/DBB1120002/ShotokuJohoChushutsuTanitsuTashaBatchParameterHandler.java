/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120002;

import java.io.File;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shutokujohochushutsurenkei.ShutokuJohoChushutsuRenkeiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002.ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeitanitu.ShotokuJohoChushutsuRenkeitanitu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 所得情報抽出・連携（単一他社）のHandlerクラスです。
 *
 * @reamsid_L DBB-1690-030 sunhui
 */
public class ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler {

    private final ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div;
    private static final RString 事務単一 = new RString("120");
    private static final RString 処理待ち = new RString("処理待ち");
    private static final RString 所得情報抽出_連携当初 = new RString("DBBMN51009");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51010");
    private static final RString REAMS以外 = new RString("3");
    private static final RString 更正なし = new RString("4");
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString 処理区分_2 = new RString("2");
    private static final RString 処理区分_3 = new RString("3");
    private static final RString 単一保険者でないため = new RString("単一保険者でないため");
    private static final RString 所得引出方法が不正のため = new RString("所得引出方法が不正のため");
    private static final RString 当初所得引出 = new RString("当初所得引出");
    private static final RString 所得引出 = new RString("所得引出");
    private static final RString 所得情報ファイル = new RString("BBKAIGO.CSV");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     */
    public ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler(ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のチェックし,初期化メソッドです
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @return ShotokuJohoChushutsuKoikiPanelHandler
     */
    public static ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler of(ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        return new ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler(div);
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
            if (!事務単一.equals(市町村形態コード)) {
                throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                        .replace(単一保険者でないため.toString()).evaluate());
            }
        }
        RString メニューID = ResponseHolder.getMenuID();
        RString config = DbBusinessConfig.get(ConfigNameDBB.所得引出_所得引出方法, currentTime, SubGyomuCode.DBB介護賦課);
        if (所得情報抽出_連携当初.equals(メニューID)) {
            if (!REAMS以外.equals(config) && !更正なし.equals(config)) {
                throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                        .replace(所得引出方法が不正のため.toString()).evaluate());
            }
        } else if (所得情報抽出_連携異動.equals(メニューID) && !REAMS以外.equals(config)) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage()
                    .replace(所得引出方法が不正のため.toString()).evaluate());
        }
    }

    /**
     * 所得情報取込処理状態の取得
     *
     * @param currentTime RDate
     */
    public void initTorikoShori(RDate currentTime) {
        RString path = new RString(SharedFile.getBasePath() + File.separator + 所得情報ファイル);
        File file = new File(path.toString());
        if (file.exists() && file.getName().contains(所得情報ファイル)) {
            div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().setValue(処理待ち);
        } else {
            div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().setValue(RString.EMPTY);
        }
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().setValue(RString.EMPTY);
        RString ログインユーザID = ControlDataHolder.getUserId();
        RString 遷移区分 = null;
        RString 年度 = null;
        if (ログインユーザID != null) {
            List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
            RString メニューID = ResponseHolder.getMenuID();
            if (所得情報抽出_連携当初.equals(メニューID)) {
                遷移区分 = 遷移区分_0;
                年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, currentTime,
                        SubGyomuCode.DBB介護賦課);
            } else if (所得情報抽出_連携異動.equals(メニューID)) {
                遷移区分 = 遷移区分_1;
                年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, currentTime,
                        SubGyomuCode.DBB介護賦課);
            }
            if (年度 != null) {
                RString 処理区分 = ShotokuJohoChushutsuRenkeitanitu.createInstance()
                        .getShoriKubun(市町村識別ID.get(0).getItemId(), 遷移区分, new FlexibleYear(年度));
                処理区分Handler(メニューID, 処理区分);
            }
        }
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータの設定します。
     *
     * @return ShotokuJohoTyushutuRenkeiTanituParameter 所得情報抽出・連携_バッチパラメータクラスです
     */
    public ShutokuJohoChushutsuRenkeiBatchParameter getBatchParamter() {
        ShutokuJohoChushutsuRenkeiBatchParameter batchparam = new ShutokuJohoChushutsuRenkeiBatchParameter();
        batchparam.set処理年度(new FlexibleYear(div.getTxtShoriNendoTanitsuTasha().getValue().getYear().toDateString()));
        batchparam.set出力順ID(div.getCcdChohyoShutsuryokujunTanitsuTasha().get出力順ID());
        return ShotokuJohoChushutsuRenkeitanitu.createInstance().createShotokuJohoParameter(batchparam);
    }

    private void 処理区分Handler(RString メニューID, RString 処理区分) {
        if (所得情報抽出_連携当初.equals(メニューID)) {
            if (処理区分_2.equals(処理区分)) {
                throw new ApplicationException(DbbErrorMessages.処理済み.getMessage()
                        .replace(当初所得引出.toString()).evaluate());
            } else if (処理区分_3.equals(処理区分)) {
                throw new ApplicationException(DbzErrorMessages.処理日付管理マスタなし.getMessage()
                        .replace(当初所得引出.toString()).evaluate());
            }
        } else if (所得情報抽出_連携異動.equals(メニューID) && 処理区分_2.equals(処理区分)) {
            throw new ApplicationException(DbbErrorMessages.処理不可_関連機能未処理済.getMessage()
                    .replace(当初所得引出.toString(), 所得引出.toString()).evaluate());
        }
    }

}
