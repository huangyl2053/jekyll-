/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.HyojunFutangakuGengakuData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.hyojunFutangakuGemmen.HyojunFutangakuGemmenRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.hyojunFutangakuGemmen.HyojunFutangakuGengakuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.hyojunFutangakuGemmen.dgHyojunFutangakuGengakuList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * HyojunFutangakuGengakuDivを操作します。
 *
 * @author N3327 三浦 凌
 */
public class HyojunFutangakuGengaku {

    /**
     * onLoad
     *
     * @param div HyojunFutangakuGengakuDiv
     * @return ResponseData
     */
    public ResponseData<HyojunFutangakuGengakuDiv> onLoad(HyojunFutangakuGengakuDiv div) {

        RString hihokenshaNo = div.getTxtHiddenHihokenshaNo().getValue();
        _list(div).setDataSource(search標準負担額減額履歴(hihokenshaNo));

        return _createResponseData(div);
    }

    private List<dgHyojunFutangakuGengakuList_Row> search標準負担額減額履歴(RString hihokenshaNo) {
        return new HyojunFutangakuGengakuData().get標準負担額減額履歴Of(hihokenshaNo).asConvertedType();
    }

    /**
     * onSelect dgHyojunFutangakuGengakuList
     *
     * @param div HyojunFutangakuGengakuDiv
     * @return ResponseData
     */
    public ResponseData<HyojunFutangakuGengakuDiv> onSelect_dgHyojunFutangakuGengakuList(HyojunFutangakuGengakuDiv div) {
        for (dgHyojunFutangakuGengakuList_Row row : _list(div).getDataSource()) {
            if (row.getSelected()) {
                setUp(div, row);
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setUp(HyojunFutangakuGengakuDiv div, dgHyojunFutangakuGengakuList_Row rowValue) {
        div.getHyojunFutangakuGemmenDetail().getTxtShinseiDate().setValue(rowValue.getShinseiDate().getValue());
        _riyoshaFutan(div).getTxtFushoninRiyu().setValue(rowValue.getFushoninRiyu());
        _riyoshaFutan(div).getTxtFutangaku().setValue(rowValue.getFutangaku().getValue());
        _riyoshaFutan(div).getTxtGengakuKubun().setValue(rowValue.getGengakuKubun());
        _riyoshaFutan(div).getTxtKetteiDate().setValue(rowValue.getKetteiDate().getValue());
        _riyoshaFutan(div).getTxtKetteiKubun().setValue(rowValue.getKetteiKubun());
        _riyoshaFutan(div).getTxtTekiyoDate().setValue(rowValue.getTekiyoDate().getValue());
        _riyoshaFutan(div).getTxtYukokigenDate().setValue(rowValue.getYukoKigen().getValue());
    }

    private DataGrid<dgHyojunFutangakuGengakuList_Row> _list(HyojunFutangakuGengakuDiv div) {
        return div.getDgHyojunFutangakuGengakuList();
    }

    private HyojunFutangakuGemmenRiyoshaFutanDiv _riyoshaFutan(HyojunFutangakuGengakuDiv div) {
        return div.getHyojunFutangakuGemmenDetail().getHyojunFutangakuGemmenRiyoshaFutan();
    }

    private ResponseData<HyojunFutangakuGengakuDiv> _createResponseData(HyojunFutangakuGengakuDiv div) {
        ResponseData<HyojunFutangakuGengakuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
