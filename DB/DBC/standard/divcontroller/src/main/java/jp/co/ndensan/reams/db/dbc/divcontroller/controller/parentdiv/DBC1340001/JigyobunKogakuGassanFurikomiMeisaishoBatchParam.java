/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1340001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001.JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1340001.JigyobunKogakuGassanFurikomiMeisaishoBatchParamHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1340001.JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * DBCMNN2004_事業合算・事業分振込明細書作成（一括）のクラスです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class JigyobunKogakuGassanFurikomiMeisaishoBatchParam {

    /**
     * 画面初期化です。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv> onLoad(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        getHandler(div).initialize();
        getHandler(div).get取引先金融機関();
        getHandler(div).onChangeDdlHakkouTaisyou(div);
        boolean gotLocked = getHandler(div).前排他キーのセット();
        if (!gotLocked) {
            throw new PessimisticLockingException();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 支払方法のオンチェンジメソッドです。
     *
     * @param div 支払方法
     * @return ResponseData
     */
    public ResponseData<JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv> onChange_radSiharaihouhou(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        getHandler(div).initialize();
        getHandler(div).onChangeDdlHakkouTaisyou(div);
        getHandler(div).onChangeRadSiharaihouhou(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 発行対象ドロップダウンのクリックメソッドです。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv> onChange_ddlHakkouTaisyou(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        getHandler(div).onChangeDdlHakkouTaisyou(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンの必須チェックのメソッドです。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv> onClick_onBeforeCheck(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        ValidationMessageControlPairs messages = getValidationHandler(div).validate();
        if (messages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(messages).respond();
        }
        return getHandler(div).checkインフォメーション(div);
    }

    /**
     * 「実行する」ボタン事件のメソッドです。
     *
     * @param div DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchisho
     *
     * @return PanelBatchParameter
     */
    public ResponseData<DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter> onClick_btnExcute(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter parameter = getHandler(div).creatParameter();
        getHandler(div).前排他キーの解除();
        return ResponseData.of(parameter).respond();
    }

    private JigyobunKogakuGassanFurikomiMeisaishoBatchParamHandler getHandler(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        return new JigyobunKogakuGassanFurikomiMeisaishoBatchParamHandler(div);
    }

    private JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationHandler getValidationHandler(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        return new JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationHandler(div);
    }
}
