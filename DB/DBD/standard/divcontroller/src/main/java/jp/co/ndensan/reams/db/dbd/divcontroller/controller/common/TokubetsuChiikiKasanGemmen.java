/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.TokubetsuChiikiKasanGemmenData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.tokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.tokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.tokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmenRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.tokubetsuChiikiKasanGemmen.dgTokubetsuChiikiKasanGemmenList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author N3327 三浦 凌
 */
public class TokubetsuChiikiKasanGemmen {

    /**
     * onLoad
     *
     * @param div TokubetsuChiikiKasanGemmenDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChiikiKasanGemmenDiv> onLoad(TokubetsuChiikiKasanGemmenDiv div) {
        RString hihokenshaNo = div.getTxtHiddenHihokenshaNo().getValue();
        _list(div).setDataSource(search特別地域加算減免履歴Of(hihokenshaNo));
        return _createResponseData(div);
    }

    private DataGrid<dgTokubetsuChiikiKasanGemmenList_Row>
            _list(TokubetsuChiikiKasanGemmenDiv div) {
        return div.getDgTokubetsuChiikiKasanGemmenList();
    }

    private List<dgTokubetsuChiikiKasanGemmenList_Row> search特別地域加算減免履歴Of(RString hihokenshaNo) {
        return new TokubetsuChiikiKasanGemmenData().get特別地域加算減免履歴Of(hihokenshaNo).asConvertedType();
    }

    /**
     * onSelect dgTokubetsuChiikiKasanGemmenList
     *
     * @param div TokubetsuChiikiKasanGemmenDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChiikiKasanGemmenDiv>
            onSelect_dgTokubetsuChiikiKasanGemmenList(TokubetsuChiikiKasanGemmenDiv div) {
        for (dgTokubetsuChiikiKasanGemmenList_Row row : _list(div).getDataSource()) {
            if (row.getSelected()) {
                setUp(div, row);
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setUp(TokubetsuChiikiKasanGemmenDiv div, dgTokubetsuChiikiKasanGemmenList_Row rowValue) {
        _setUp_Detail(div, rowValue);
    }

    private void _setUp_Detail(TokubetsuChiikiKasanGemmenDiv div, dgTokubetsuChiikiKasanGemmenList_Row rowValue) {
        TokubetsuChiikiKasanGemmenDetailDiv detail = div.getTokubetsuChiikiKasanGemmenDetail();
        detail.getTxtShinseiDate().setValue(rowValue.getShinseiDate().getValue());
        _setUp_RiyoshaFutan(detail, rowValue);
    }

    private void _setUp_RiyoshaFutan(TokubetsuChiikiKasanGemmenDetailDiv div, dgTokubetsuChiikiKasanGemmenList_Row rowValue) {
        TokubetsuChiikiKasanGemmenRiyoshaFutanDiv riyoshaFutan = div.getTokubetsuChiikiKasanGemmenRiyoshaFutan();
        riyoshaFutan.getTxtFushoninRiyu().setValue(rowValue.getFushoninRiyu());
        riyoshaFutan.getTxtGengakuRitsu().setValue(rowValue.getGengakuRitsu().getValue());
        riyoshaFutan.getTxtKakuninNo().setValue(rowValue.getKakuninNo());
        riyoshaFutan.getTxtKetteiDate().setValue(rowValue.getKetteiDate().getValue());
        riyoshaFutan.getTxtKetteiKubun().setValue(rowValue.getKetteiKubun());
        riyoshaFutan.getTxtTekiyoDate().setValue(rowValue.getTekiyoDate().getValue());
        riyoshaFutan.getTxtYukokigenDate().setValue(rowValue.getYukoKigen().getValue());
    }

    private ResponseData<TokubetsuChiikiKasanGemmenDiv> _createResponseData(TokubetsuChiikiKasanGemmenDiv div) {
        ResponseData<TokubetsuChiikiKasanGemmenDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
