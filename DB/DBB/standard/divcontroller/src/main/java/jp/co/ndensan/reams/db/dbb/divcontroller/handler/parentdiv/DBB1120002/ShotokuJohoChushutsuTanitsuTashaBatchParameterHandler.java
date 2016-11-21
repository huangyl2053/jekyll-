/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120002;

import java.io.File;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shotokujohochushutsu.ShotokuJohoChushutsuGamenParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112001.DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112003.DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002.ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeitanitu.ShotokuJohoChushutsuRenkeitanitu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 所得情報抽出・連携（単一他社）のHandlerクラスです。
 *
 * @reamsid_L DBB-1690-030 sunhui
 */
public class ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler {

    private final ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div;
    private static final RString 処理待ち = new RString("処理待ち");
    private static final RString 所得情報抽出_連携当初 = new RString("DBBMN51009");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51010");
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString 処理区分_2 = new RString("2");
    private static final RString 処理区分_3 = new RString("3");
    private static final RString ファイル付箋 = new RString("ShotokuJohoChushutsuTanitsuTasha");
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
                処理区分Handler(メニューID, edit処理区分(遷移区分, 市町村識別ID, 年度));
            }
        }
    }

    private RString edit処理区分(RString 遷移区分, List<AuthorityItem> 市町村識別ID, RString 年度) {
        RString 処理区分;
        if (市町村識別ID != null && !市町村識別ID.isEmpty()) {
            処理区分 = ShotokuJohoChushutsuRenkeitanitu.createInstance()
                    .getShoriKubun(市町村識別ID.get(0).getItemId(), 遷移区分, new FlexibleYear(年度));
        } else {
            処理区分 = ShotokuJohoChushutsuRenkeitanitu.createInstance()
                    .getShoriKubun(RString.EMPTY, 遷移区分, new FlexibleYear(年度));
        }
        return 処理区分;
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータの設定します。
     *
     * @param 共有ファイルID RDateTime
     * @return DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter 所得情報抽出・連携_バッチパラメータクラスです
     */
    public DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter getBatchParamter_DBB112001(RDateTime 共有ファイルID) {
        ShotokuJohoChushutsuGamenParameter param = new ShotokuJohoChushutsuGamenParameter();
        param.set処理年度(new FlexibleYear(div.getTxtShoriNendoTanitsuTasha().getValue().getYear().toDateString()));
        param.set出力順ID(new RString(div.getCcdChohyoShutsuryokujunTanitsuTasha().get出力順ID()));
        param.set市町村情報List(Collections.EMPTY_LIST);
        param.set共有ファイルID(共有ファイルID);
        param.set共有ファイル名(ファイル付箋);
        param.setファイル名(div.getHiddenResult());
        return ShotokuJohoChushutsuRenkeitanitu.createInstance().createShotokuJohoDBB112001Parameter(param);
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータの設定します。
     *
     * @param 共有ファイルID RDateTime
     * @return DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter 所得情報抽出・連携_バッチパラメータクラスです
     */
    public DBB112003_ShotokuJohoChushutsuRenkeiTanitsuParameter getBatchParameter_DBB112003(RDateTime 共有ファイルID) {
        ShotokuJohoChushutsuGamenParameter param = new ShotokuJohoChushutsuGamenParameter();
        param.set処理年度(new FlexibleYear(div.getTxtShoriNendoTanitsuTasha().getValue().getYear().toDateString()));
        param.set出力順ID(new RString(div.getCcdChohyoShutsuryokujunTanitsuTasha().get出力順ID()));
        param.set市町村情報List(Collections.EMPTY_LIST);
        param.set共有ファイルID(共有ファイルID);
        param.set共有ファイル名(ファイル付箋);
        param.setファイル名(div.getHiddenResult());
        return ShotokuJohoChushutsuRenkeitanitu.createInstance().createShotokuJohoDBB112003Parameter(param);
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
