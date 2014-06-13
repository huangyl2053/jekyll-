/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.FutanGendogakuNinteiData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.FutanGendogakuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.FutanGendogakuNinteiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.FutanGendogakuNinteiRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.dgFutanGendogakuNinteiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * FutanGendogakuNinteiを操作します。
 *
 * @author N3327 三浦 凌
 */
public class FutanGendogakuNintei {

    /**
     * onLoad
     *
     * @param div FutanGendogakuNinteiDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiDiv> onLoad(FutanGendogakuNinteiDiv div) {
        RString hihokenshaNo = div.getTxtHiddenHihokenshaNo().getValue();
        _list(div).setDataSource(search負担限度額認定履歴(hihokenshaNo));
        return _createResponseData(div);
    }

    private DataGrid<dgFutanGendogakuNinteiList_Row> _list(FutanGendogakuNinteiDiv div) {
        return div.getDgFutanGendogakuNinteiList();
    }

    private List<dgFutanGendogakuNinteiList_Row> search負担限度額認定履歴(RString hihokenshaNo) {
        return new FutanGendogakuNinteiData().get負担限度額認定履歴of(hihokenshaNo).asConvertedType();
    }

    /**
     * onSelect dgFutanGendogakuNinteiList
     *
     * @param div FutanGendogakuNinteiDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiDiv> onSelect_dgFutanGendogakuNinteiList(FutanGendogakuNinteiDiv div) {
        for (dgFutanGendogakuNinteiList_Row row : _list(div).getDataSource()) {
            if (row.getSelected()) {
                setUp(div, row);
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setUp(FutanGendogakuNinteiDiv div, dgFutanGendogakuNinteiList_Row rowValue) {
        _setUp(div, rowValue);
    }

    private void _setUp(FutanGendogakuNinteiDiv div, dgFutanGendogakuNinteiList_Row rowValue) {
        div.getFutanGendogakuNinteiDetail().getTxtShinseiDate().setValue(rowValue.getShinseiDate().getValue());
        div.getFutanGendogakuNinteiDetail().getTxtShinseiRiyu().setValue(rowValue.getShinseiRiyu());
        _setUp_riyoshaFutan(div, rowValue);
        _setUp_futanGendogaku(div, rowValue);
    }

    private void _setUp_riyoshaFutan(FutanGendogakuNinteiDiv div, dgFutanGendogakuNinteiList_Row rowValue) {
        _riyoshaFutan(div).getTxtKetteiDate().setValue(rowValue.getKetteiDate().getValue());
        _riyoshaFutan(div).getTxtKetteiKubun().setValue(rowValue.getKetteiKubun());
        _riyoshaFutan(div).getTxtTekiyoDate().setValue(rowValue.getTekiyoDate().getValue());
        _riyoshaFutan(div).getTxtYukokigenDate().setValue(rowValue.getYukoKigen().getValue());
        _riyoshaFutan(div).getTxtFushoninRiyu().setValue(rowValue.getFushoninRiyu());
        _riyoshaFutan(div).getTxtFutanDankai().setValue(rowValue.getFutanDankai());
        _riyoshaFutan(div).getTxtKyushochisha().setValue(rowValue.getKyushochisha());
        _riyoshaFutan(div).getTxtFutanDankai().setValue(rowValue.getFutanDankai());
        _riyoshaFutan(div).getTxtKyoshitsuType().setValue(rowValue.getKyoshitsuType());
        _riyoshaFutan(div).getTxtKyokaiso().setValue(rowValue.getKyokaiso());
        _riyoshaFutan(div).getTxtGekihenKanwa().setValue(rowValue.getGekihenKanwa());
    }

    private FutanGendogakuNinteiRiyoshaFutanDiv _riyoshaFutan(FutanGendogakuNinteiDiv div) {
        return div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan();
    }

    private void _setUp_futanGendogaku(FutanGendogakuNinteiDiv div, dgFutanGendogakuNinteiList_Row rowValue) {
        _futanGendogaku(div).getTxtUnitKoshitsu().setValue(rowValue.getUnitJunKoshitsu().getValue());
        _futanGendogaku(div).getTxtUnitJunKoshitsu().setValue(rowValue.getUnitJunKoshitsu().getValue());
        _futanGendogaku(div).getTxtTashoshitsu().setValue(rowValue.getTashoshitsu().getValue());
        _futanGendogaku(div).getTxtShokuhi().setValue(rowValue.getShokuhi().getValue());
        _futanGendogaku(div).getTxtJuraigataKoshitsuTokuyo().setValue(rowValue.getJuraigataKoshitsuTokuyo().getValue());
        _futanGendogaku(div).getTxtJuraigataKoshitsuRoken().setValue(rowValue.getJuraigataKoshitsuRoken().getValue());
    }

    private FutanGendogakuDiv _futanGendogaku(FutanGendogakuNinteiDiv div) {
        return _riyoshaFutan(div).getFutanGendogaku();
    }

    /**
     * creates ResponceData
     *
     * @param div FutanGendogakuNinteiDiv
     * @return ResponseData
     */
    private ResponseData<FutanGendogakuNinteiDiv> _createResponseData(FutanGendogakuNinteiDiv div) {
        ResponseData<FutanGendogakuNinteiDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

}
