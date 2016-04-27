/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7010001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001.HanyorisutoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7010001.HanyorisutoPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 汎用リスト 居宅サービス計画
 *
 * @reamsid_L DBC-3091-010 zhangrui
 */
public class HanyorisutoPanel {

    /**
     * onLoad事件ことです。
     *
     * @param div HanyorisutoPanelDiv
     * @return ResponseData
     */
    public ResponseData<HanyorisutoPanelDiv> onLoad(HanyorisutoPanelDiv div) {
        getHandler(div).initialize(div);
        return createResponse(div);
    }

    /**
     * onBeforeOpenDialog_btnSienJigyosyano事件ことです。
     *
     * @param div HanyorisutoPanelDiv
     * @return ResponseData
     */
    public ResponseData<HanyorisutoPanelDiv> onBeforeOpenDialog_btnSienJigyosyano(HanyorisutoPanelDiv div) {
        JigyoshaMode mode = new JigyoshaMode();
        mode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.code());
        div.getChushutsuJokenPanel().setHiddenJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(div).respond();
    }

    /**
     * onOkClose_btnSienJigyosyano事件です。
     *
     * @param div HanyorisutoPanelDiv
     * @return ResponseData
     */
    public ResponseData<HanyorisutoPanelDiv> onOkClose_btnSienJigyosyano(HanyorisutoPanelDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getChushutsuJokenPanel().getHiddenJigyoshaMode(), JigyoshaMode.class);
        div.getTxtSienJigyosya().setValue(new RString(mode.getJigyoshaName().toString()));
        div.getTxtSienJigyosyano().setValue(new RString(mode.getJigyoshaNo().toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnBatchRegister事件です。
     *
     * @param div HanyorisutoPanelDiv
     * @return ResponseData
     */
    public ResponseData<HanyorisutoPanelDiv> onClick_btnBatchRegister(HanyorisutoPanelDiv div) {
        //TODO  batchが完成した継続します。
//        HanyoList_KyotakuServiceKeikakuBatchParameter bparam = new HanyoList_KyotakuServiceKeikakuBatchParameter();
//        bparam.set構成市町村コード(div.getCcdHokensya().getSelectedItem().get市町村コード());
//        bparam.set作成区分(SakuseiKubun.toValue(div.getRadSakuseiKubun().getSelectedKey()));
//        RString radchusyutukubunkey = div.getRadChusyutuKubun().getSelectedKey();
//        bparam.set抽出区分(ChushutsuKubun.toValue(radchusyutukubunkey));
//        if (ChushutsuKubun.全有効データ.getコード().equals(radchusyutukubunkey)) {
//            bparam.set基準年月日(new FlexibleDate(div.getTxtKijunYMD().getValue().toString()));
//        } else {
//            bparam.set基準年月日(null);
//        }
//        bparam.set改頁出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID().toString()));
//        bparam.set出力項目ID(div.getCcdChohyoShutsuryokukoumoku().get出力項目ID());
//        div.getCcdChohyoShutsuryokukoumoku().get選択項目ID();
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_radChusyutuKubun事件です。
     *
     * @param div HanyorisutoPanelDiv
     * @return ResponseData
     */
    public ResponseData<HanyorisutoPanelDiv> onChange_radChusyutuKubun(HanyorisutoPanelDiv div) {
        getHandler(div).set抽出区分表示制御処理();
        return createResponse(div);
    }

    private HanyorisutoPanelHandler getHandler(HanyorisutoPanelDiv div) {
        return new HanyorisutoPanelHandler(div);
    }

    private ResponseData<HanyorisutoPanelDiv> createResponse(HanyorisutoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
