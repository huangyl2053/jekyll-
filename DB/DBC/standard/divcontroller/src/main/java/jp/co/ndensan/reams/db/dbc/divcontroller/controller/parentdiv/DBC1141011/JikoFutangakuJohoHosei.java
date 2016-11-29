/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1141011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040030.DBC040030_KogakugassanJikofutangakuInfoHoseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011.DBC1141011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011.JikoFutangakuJohoHoseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1141011.JikoFutangakuJohoHoseiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1141011.JikoFutangakuJohoHoseiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN62002_高額合算自己負担額情報補正（一括）のクラスです。
 *
 * @reamsid_L DBC-2320-010 chenyadong
 */
public class JikoFutangakuJohoHosei {

    private static final RString 送付取込区分 = new RString("2");
    private static final RString 処理状態区分 = new RString("3");
    private static final RString 交換情報識別番号 = new RString("37J%");
    private static final RString MAX = new RString("MAX");
    private static final RString MIN = new RString("MIN");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div DBC1120011PanelDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiDiv> onLoad(JikoFutangakuJohoHoseiDiv div) {

        RString メニューID = ResponseHolder.getMenuID();
        LockingKey 前排他キー = new LockingKey(メニューID);
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
        KokuhorenInterfaceKanri 国保連インターフェース管理Max;
        KokuhorenInterfaceKanri 国保連インターフェース管理Min;
        KokuhorenInterfaceKanriManager 国保連インターフェース管理Manager = new KokuhorenInterfaceKanriManager();
        国保連インターフェース管理Max = 国保連インターフェース管理Manager.get新国保連インターフェース管理(
                MAX, 送付取込区分, 処理状態区分, 交換情報識別番号);
        国保連インターフェース管理Min = 国保連インターフェース管理Manager.get新国保連インターフェース管理(
                MIN, 送付取込区分, 処理状態区分, 交換情報識別番号);
        if (国保連インターフェース管理Max != null) {
            FlexibleYearMonth 最新の処理年月 = 国保連インターフェース管理Max.get処理年月();
            FlexibleYearMonth 最古の処理年月 = 国保連インターフェース管理Min.get処理年月();
            ViewStateHolder.put(ViewStateKeys.最新の処理年月, 最新の処理年月);
            ViewStateHolder.put(ViewStateKeys.最古の処理年月, 最古の処理年月);
            getHandler(div).setCommonButtonVisible(false);
        } else {
            throw new ApplicationException(DbcErrorMessages.自己負担額確認情報取込前.getMessage());
        }
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC1141011StateName.自己負担額情報補正一括);
    }

    /**
     * txtKaishiYMDのonChange事件です。
     *
     * @param div JikoFutangakuJohoHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiDiv> onChange_txtKaishiYMD(JikoFutangakuJohoHoseiDiv div) {
        getHandler(div).onChangeKaishiYMD();
        return ResponseData.of(div).respond();
    }

    /**
     * txtShuryoYMDのonChange事件です。
     *
     * @param div JikoFutangakuJohoHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiDiv> onChange_txtShuryoYMD(JikoFutangakuJohoHoseiDiv div) {
        getHandler(div).onChangeShuryoYMD();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div JikoFutangakuJohoHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiDiv> onBeforeOpenCheck(JikoFutangakuJohoHoseiDiv div) {
        KokuhorenInterfaceKanriManager manager = new KokuhorenInterfaceKanriManager();
        List<KokuhorenInterfaceKanri> list = manager.get自己負担額確認情報(new FlexibleYearMonth(
                div.getTxtKakuninJouhouUketoriYM().getValue().getYearMonth().toDateString()),
                交換情報識別番号, 送付取込区分, 処理状態区分);
        ViewStateHolder.put(ViewStateKeys.自己負担額確認情報, (Serializable) list);
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div JikoFutangakuJohoHoseiDiv
     * @return ResponseData
     */
    public ResponseData<DBC040030_KogakugassanJikofutangakuInfoHoseiParameter> onClick_btn(
            JikoFutangakuJohoHoseiDiv div) {
        LockingKey 排他キー = new LockingKey(ResponseHolder.getMenuID());
        RealInitialLocker.release(排他キー);
        DBC040030_KogakugassanJikofutangakuInfoHoseiParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBC040030_KogakugassanJikofutangakuInfoHoseiParameter setBatchParameter(JikoFutangakuJohoHoseiDiv div) {
        DBC040030_KogakugassanJikofutangakuInfoHoseiParameter parameter;
        parameter = new DBC040030_KogakugassanJikofutangakuInfoHoseiParameter();
        parameter.setKakunin_UketoriYM(div.getTxtKakuninJouhouUketoriYM().getValue().getYearMonth().toDateString());
        parameter.setKaishiYMD(div.getTxtKaishiYMD().getValue().toDateString());
        parameter.setKaishiWeek(new RString(div.getTxtKaishiYoubi().getValue().toString()));
        parameter.setKaishiHHMM(new RString(div.getTxtKaishiJikanHH().getValue().toString().
                concat(div.getTxtKaishiJIkanMM().getValue().toString())));
        parameter.setShuryoYMD(div.getTxtShuryoYMD().getValue().toDateString());
        parameter.setShuryoWeek(new RString(div.getTxtShuryoYoubi().getValue().toString()));
        parameter.setShuryoHHMM(new RString(div.getTxtshuryoJikanHH().getValue().toString().
                concat(div.getTxtshuryoJikanMM().getValue().toString())));
        long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
        parameter.setShutsuryokujunId(new RString(Long.toString(出力順ID)));

        RString 国保連共同処理受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        parameter.setTreatmentType(国保連共同処理受託区分);
        parameter.setHandleTimestamp(RDate.getNowDateTime());
        return parameter;
    }

    private JikoFutangakuJohoHoseiHandler getHandler(JikoFutangakuJohoHoseiDiv div) {
        return new JikoFutangakuJohoHoseiHandler(div);
    }

    private JikoFutangakuJohoHoseiValidationHandler getValidationHandler(JikoFutangakuJohoHoseiDiv div) {
        return new JikoFutangakuJohoHoseiValidationHandler(div);
    }
}
