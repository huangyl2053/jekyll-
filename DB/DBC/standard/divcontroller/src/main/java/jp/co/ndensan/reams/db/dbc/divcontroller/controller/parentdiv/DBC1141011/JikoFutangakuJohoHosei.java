/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1141011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc040030.DBC040030_KogakugassanJikofutangakuInfoHoseiParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011.DBC1141011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011.JikoFutangakuJohoHoseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1141011.JikoFutangakuJohoHoseiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1141011.JikoFutangakuJohoHoseiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN62002_高額合算自己負担額情報補正（一括）のクラスです。
 *
 * @reamsid_L DBC-2320-010 chenyadong
 */
public class JikoFutangakuJohoHosei {

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
     * @param div DBC1120011PanelDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiDiv> onBeforeOpenCheck(JikoFutangakuJohoHoseiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div DBC1120011PanelDiv
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
        parameter.setKakunin_UketoriYM(div.getTxtKakuninJouhouUketoriYM().getValue().toDateString());
        parameter.setKaishiYMD(div.getTxtKaishiYMD().getValue().toDateString());
        parameter.setKaishiWeek(new RString(div.getTxtKaishiYoubi().getValue().toString()));
        parameter.setKaishiHHMM(new RString(div.getTxtKaishiJikanHH().getValue().toString().
                concat(div.getTxtKaishiJIkanMM().getValue().toString())));
        parameter.setShuryoYMD(div.getTxtShuryoYMD().getValue().toDateString());
        parameter.setShuryoWeek(new RString(div.getTxtShuryoYoubi().getValue().toString()));
        parameter.setShuryoHHMM(new RString(div.getTxtshuryoJikanHH().getValue().toString().
                concat(div.getTxtshuryoJikanMM().getValue().toString())));
        if (div.getJikoFutangakuHoseiPrint().isIsPublish()) {
            long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
            parameter.setShutsuryokujunId(出力順ID);
        } else {
            parameter.setShutsuryokujunId(0);
        }
        RString 国保連共同処理受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        parameter.setTreatmentType(国保連共同処理受託区分);
        Association 市町村コード_Temp = AssociationFinderFactory.createInstance().getAssociation();
        parameter.setDantaiCd(市町村コード_Temp.get地方公共団体コード());
        parameter.setHandleTimestamp(RDate.getNowDate());
        return parameter;
    }

    private JikoFutangakuJohoHoseiHandler getHandler(JikoFutangakuJohoHoseiDiv div) {
        return new JikoFutangakuJohoHoseiHandler(div);
    }

    private JikoFutangakuJohoHoseiValidationHandler getValidationHandler(JikoFutangakuJohoHoseiDiv div) {
        return new JikoFutangakuJohoHoseiValidationHandler(div);
    }
}
