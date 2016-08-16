/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1120011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc1120011panel.DBC1120011PanelBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1120011.DBC1120011PanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1120011.DBC1120011PanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1120011.DBC1120011PanelValidationHandler;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN62006_自己負担額計算（一括）のクラスです。
 *
 * @reamsid_L DBC-2060-010 chenyadong
 */
public class DBC1120011Panel {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div DBC1120011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1120011PanelDiv> onLoad(DBC1120011PanelDiv div) {

        RString メニューID = ResponseHolder.getMenuID();
        LockingKey 前排他キー = new LockingKey(メニューID);
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div DBC1120011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1120011PanelDiv> onBeforeOpenCheck(DBC1120011PanelDiv div) {
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
    public ResponseData<DBC1120011PanelBatchParameter> onClick_JikoFutangakuKeisanIkkatsuPanel(DBC1120011PanelDiv div) {
        LockingKey 排他キー = new LockingKey(ResponseHolder.getMenuID());
        RealInitialLocker.release(排他キー);
        DBC1120011PanelBatchParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBC1120011PanelBatchParameter setBatchParameter(DBC1120011PanelDiv div) {
        DBC1120011PanelBatchParameter parameter = new DBC1120011PanelBatchParameter();
        parameter.setShoriTimestamp(RDate.getNowDate());
        if (div.getTxtShinseiTaishoYMD().getFromValue().toString().isEmpty()) {
            parameter.setTaishoKaishiDay(RDate.MIN);
        } else {
            parameter.setTaishoKaishiDay(div.getTxtShinseiTaishoYMD().getFromValue());
        }
        if (div.getTxtShinseiTaishoYMD().getToValue().toString().isEmpty()) {
            parameter.setTaishoShuryoDay(RDate.MAX);
        } else {
            parameter.setTaishoShuryoDay(div.getTxtShinseiTaishoYMD().getToValue());
        }
        boolean 出力フラグ;
        if (div.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().isIsPublish()) {
            long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
            parameter.setShutsuryokujunId(出力順ID);
            出力フラグ = true;
        } else {
            出力フラグ = false;
            parameter.setShutsuryokujunId(null);
        }
        parameter.setShuturyokuFlg(出力フラグ);
        Association 市町村コード_Temp = AssociationFinderFactory.createInstance().getAssociation();
        parameter.setDantaiCd(市町村コード_Temp.get地方公共団体コード());
        return parameter;
    }
     //TODO QA.1044
    /**
     * 出力CHKのonOpen事件です。
     *
     * @param div DBC1120011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1120011PanelDiv> onOpen_ccdChohyoShutsuryokujun(DBC1120011PanelDiv div) {
        getHandler(div).onOpen出力CHK();
        return ResponseData.of(div).respond();
    }

    /**
     * 出力CHKのonClose事件です。
     *
     * @param div DBC1120011PanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC1120011PanelDiv> onClose_ccdChohyoShutsuryokujun(DBC1120011PanelDiv div) {
        getHandler(div).onClose出力CHK();
        return ResponseData.of(div).respond();
    }

    private DBC1120011PanelHandler getHandler(DBC1120011PanelDiv div) {
        return new DBC1120011PanelHandler(div);
    }

    private DBC1120011PanelValidationHandler getValidationHandler(DBC1120011PanelDiv div) {
        return new DBC1120011PanelValidationHandler(div);
    }
}
