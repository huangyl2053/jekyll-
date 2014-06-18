/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.ShakaiFukushiHojinKeigenData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigenRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.dgShakaiFukushiHojinKeigenList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author N3327 三浦 凌
 */
public class ShakaiFukushiHojinKeigen {

    /**
     * onLoad
     *
     * @param div ShakaiFukushiHojinKeigenDiv
     * @return ResponseData
     */
    public ResponseData<ShakaiFukushiHojinKeigenDiv> onLoad(ShakaiFukushiHojinKeigenDiv div) {
        RString hihokenshaNo = div.getTxtHiddenHihokenshaNo().getValue();
        _list(div).setDataSource(search社会福祉法人軽減履歴Of(hihokenshaNo));
        return _createResponseData(div);
    }

    private DataGrid<dgShakaiFukushiHojinKeigenList_Row>
            _list(ShakaiFukushiHojinKeigenDiv div) {
        return div.getDgShakaiFukushiHojinKeigenList();
    }

    private List<dgShakaiFukushiHojinKeigenList_Row> search社会福祉法人軽減履歴Of(RString hihokenshaNo) {
        return new ShakaiFukushiHojinKeigenData().get社会福祉法人軽減履歴Of(hihokenshaNo).asConvertedType();
    }

    /**
     * onSelect dgShakaiFukushiHojinKeigenList
     *
     * @param div ShakaiFukushiHojinKeigenDiv
     * @return ResponseData
     */
    public ResponseData<ShakaiFukushiHojinKeigenDiv> onSelect_dgShakaiFukushiHojinKeigenList(ShakaiFukushiHojinKeigenDiv div) {
        for (dgShakaiFukushiHojinKeigenList_Row row : _list(div).getDataSource()) {
            if (row.getSelected()) {
                setUp(div, row);
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setUp(ShakaiFukushiHojinKeigenDiv div, dgShakaiFukushiHojinKeigenList_Row rowValue) {
        _setUp_detail(div, rowValue);
    }

    private void _setUp_detail(ShakaiFukushiHojinKeigenDiv div, dgShakaiFukushiHojinKeigenList_Row rowValue) {
        ShakaiFukushiHojinKeigenDetailDiv detail
                = div.getShakaiFukushiHojinKeigenDetail();
        detail.getTxtKyotakuServiceOnly().setValue(rowValue.getKyotakuServiceOnly());
        detail.getTxtShinseiDate().setValue(rowValue.getShinseiDate().getValue());
        detail.getTxtUnitPrivateRoomOnly().setValue(rowValue.getUnitPrivateRoomOnly());
        detail.getTxtKyojuhiShokujiOnly().setValue(rowValue.getKyojuhiShokujiOnly());
        _setUp_riyoshaFutan(div, rowValue);
    }

    private void _setUp_riyoshaFutan(ShakaiFukushiHojinKeigenDiv div, dgShakaiFukushiHojinKeigenList_Row rowValue) {
        ShakaiFukushiHojinKeigenRiyoshaFutanDiv riyoshaFutan
                = div.getShakaiFukushiHojinKeigenDetail().getShakaiFukushiHojinKeigenRiyoshaFutan();
        riyoshaFutan.getTxtFushoninRiyu().setValue(rowValue.getFushoninRiyu());
        riyoshaFutan.getTxtKeigenRitsuBunbo().setValue(rowValue.getKeigenRitsuBunbo().getValue());
        riyoshaFutan.getTxtKeigenRitsuBunshi().setValue(rowValue.getKeigenRitsuBunshi().getValue());
        riyoshaFutan.getTxtKakuninNo().setValue(rowValue.getKakuninNo());
        riyoshaFutan.getTxtKeigenJiyu().setValue(rowValue.getKeigenJiyu());
        riyoshaFutan.getTxtKetteiDate().setValue(rowValue.getKetteiDate().getValue());
        riyoshaFutan.getTxtKetteiKubun().setValue(rowValue.getKetteiKubun());
        riyoshaFutan.getTxtTekiyoDate().setValue(rowValue.getTekiyoDate().getValue());
        riyoshaFutan.getTxtYukokigenDate().setValue(rowValue.getYukoKigen().getValue());
    }

    private ResponseData<ShakaiFukushiHojinKeigenDiv> _createResponseData(ShakaiFukushiHojinKeigenDiv div) {
        ResponseData<ShakaiFukushiHojinKeigenDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
