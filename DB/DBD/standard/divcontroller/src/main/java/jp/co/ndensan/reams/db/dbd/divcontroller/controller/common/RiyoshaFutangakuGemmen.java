/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.RiyoshaFutangakuGemmenData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen.RiyoshaFutangakuGemmenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen.RiyoshaFutangakuGemmenRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen.dgRiyoshaFutangakuGemmenList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * RiyoshaFutangakuGemmenDivを操作します。
 *
 * @author N3327 三浦 凌
 */
public class RiyoshaFutangakuGemmen {

    /**
     * ロード時の処理です。
     *
     * @param div RiyoshaFutangakuGemmenDiv
     * @return ResponseData
     */
    public ResponseData<RiyoshaFutangakuGemmenDiv> onLoad(RiyoshaFutangakuGemmenDiv div) {
        RString hihokenshaNo = div.getTxtHiddenHihokenshaNo().getValue();
        _list(div).setDataSource(search利用者負担額減免履歴(hihokenshaNo));
        return _createResponseData(div);
    }

    private List<dgRiyoshaFutangakuGemmenList_Row> search利用者負担額減免履歴(RString hihokenshaNo) {
        return new RiyoshaFutangakuGemmenData().get利用者負担額減免履歴Of(hihokenshaNo).asConvertedType();
    }

    /**
     * onSelect dgRiyoshaFutangakuGemmenList
     *
     * @param div RiyoshaFutangakuGemmenDiv
     * @return ResponseData
     */
    public ResponseData<RiyoshaFutangakuGemmenDiv> onSelect_dgRiyoshaFutangakuGemmenList(RiyoshaFutangakuGemmenDiv div) {
        for (dgRiyoshaFutangakuGemmenList_Row row : _list(div).getDataSource()) {
            if (row.getSelected()) {
                setUp(div, row);
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setUp(RiyoshaFutangakuGemmenDiv div, dgRiyoshaFutangakuGemmenList_Row rowValue) {
        div.getRiyoshaFutangakuGemmenDetail().getTxtShinseiDate().setValue(rowValue.getShinseiDate().getValue());
        _riyoshaFutan(div).getTxtFushoninRiyu().setValue(rowValue.getFushoninRiyu());
        _riyoshaFutan(div).getTxtKyufuRitsu().setValue(rowValue.getKyufuRitsu().getValue());
        _riyoshaFutan(div).getTxtKetteiDate().setValue(rowValue.getKetteiDate().getValue());
        _riyoshaFutan(div).getTxtKetteiKubun().setValue(rowValue.getKetteiKubun());
        _riyoshaFutan(div).getTxtTekiyoDate().setValue(rowValue.getTekiyoDate().getValue());
        _riyoshaFutan(div).getTxtYukokigenDate().setValue(rowValue.getYukoKigen().getValue());
    }

    private DataGrid<dgRiyoshaFutangakuGemmenList_Row> _list(RiyoshaFutangakuGemmenDiv div) {
        return div.getDgRiyoshaFutangakuGemmenList();
    }

    private RiyoshaFutangakuGemmenRiyoshaFutanDiv _riyoshaFutan(RiyoshaFutangakuGemmenDiv div) {
        return div.getRiyoshaFutangakuGemmenDetail().getRiyoshaFutangakuGemmenRiyoshaFutan();
    }

    private ResponseData<RiyoshaFutangakuGemmenDiv> _createResponseData(RiyoshaFutangakuGemmenDiv div) {
        ResponseData<RiyoshaFutangakuGemmenDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
