/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.HomonkaigoRiyoshaFutangakuGengakuData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.ShogaishaTechoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.dgHomonkaigoRiyoshaFutangakuGengakuList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * HomonkaigoRiyoshaFutangakuGengakuDivを操作します。
 *
 * @author N3327 三浦 凌
 */
public class HomonkaigoRiyoshaFutangakuGengaku {

    /**
     * onLoad
     *
     * @param div HomonkaigoRiyoshaFutangakuGengakuDiv
     * @return ResponseData
     */
    public ResponseData<HomonkaigoRiyoshaFutangakuGengakuDiv>
            onLoad(HomonkaigoRiyoshaFutangakuGengakuDiv div) {
        RString hihokenshaNo = div.getTxtHiddenHihokenshaNo().getValue();
        _list(div).setDataSource(search訪問介護利用者負担額減額履歴Of(hihokenshaNo));
        return _createResponseData(div);
    }

    private DataGrid<dgHomonkaigoRiyoshaFutangakuGengakuList_Row>
            _list(HomonkaigoRiyoshaFutangakuGengakuDiv div) {
        return div.getDgHomonkaigoRiyoshaFutangakuGengakuList();
    }

    private List<dgHomonkaigoRiyoshaFutangakuGengakuList_Row>
            search訪問介護利用者負担額減額履歴Of(RString hihokenshaNo) {
        return new HomonkaigoRiyoshaFutangakuGengakuData()
                .get訪問介護利用者負担額減額履歴Of(hihokenshaNo).asConvertedType();
    }

    /**
     * onSelect dgHomonkaigoRiyoshaFutangakuGengakuList
     *
     * @param div HomonkaigoRiyoshaFutangakuGengakuDiv
     * @return ResponseData
     */
    public ResponseData<HomonkaigoRiyoshaFutangakuGengakuDiv>
            onSelect_dgHomonkaigoRiyoshaFutangakuGengakuList(HomonkaigoRiyoshaFutangakuGengakuDiv div) {
        for (dgHomonkaigoRiyoshaFutangakuGengakuList_Row row : _list(div).getDataSource()) {
            if (row.getSelected()) {
                setUp(div, row);
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setUp(HomonkaigoRiyoshaFutangakuGengakuDiv div,
            dgHomonkaigoRiyoshaFutangakuGengakuList_Row rowValue) {
        _setUp_Shinsei(div, rowValue);
        _setUp_RiyoshaFutan(div, rowValue);
        _setUp_ShogaishaTecho(div, rowValue);
    }

    private void _setUp_Shinsei(HomonkaigoRiyoshaFutangakuGengakuDiv div,
            dgHomonkaigoRiyoshaFutangakuGengakuList_Row rowValue) {
        HomonkaigoRiyoshaFutangakuGengakuShinseiDiv shinsei
                = div.getHomonkaigoRiyoshaFutangakuGengakuDetail()
                .getHomonkaigoRiyoshaFutangakuGengakuShinsei();
        shinsei.getTxtHobetsuKubun().setValue(rowValue.getHobetsuKubun());
        shinsei.getTxtShinseiDate().setValue(rowValue.getShinseiDate().getValue());
        shinsei.getTxtShinseiRiyu().setValue(rowValue.getShinseiRiyu());
    }

    private void _setUp_RiyoshaFutan(HomonkaigoRiyoshaFutangakuGengakuDiv div,
            dgHomonkaigoRiyoshaFutangakuGengakuList_Row rowValue) {
        HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv riyoshaFutan
                = div.getHomonkaigoRiyoshaFutangakuGengakuDetail()
                .getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan();
        riyoshaFutan.getTxtFushoninRiyu().setValue(rowValue.getFushoninRiyu());
        riyoshaFutan.getTxtKetteiDate().setValue(rowValue.getKetteiDate().getValue());
        riyoshaFutan.getTxtKetteiKubun().setValue(rowValue.getKetteiKubun());
        riyoshaFutan.getTxtKohiFutanshaNo().setValue(rowValue.getKohiFutanshaNo());
        riyoshaFutan.getTxtKohiJukyushaNo().setValue(rowValue.getKohiJukyushaNo());
        riyoshaFutan.getTxtKyufuRitsu().setValue(rowValue.getKyufuRitsu().getValue());
        riyoshaFutan.getTxtTekiyoDate().setValue(rowValue.getTekiyoDate().getValue());
        riyoshaFutan.getTxtYukokigenDate().setValue(rowValue.getYukoKigen().getValue());
    }

    private void _setUp_ShogaishaTecho(HomonkaigoRiyoshaFutangakuGengakuDiv div,
            dgHomonkaigoRiyoshaFutangakuGengakuList_Row rowValue) {
        ShogaishaTechoDiv shogaishaTecho = div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getShogaishaTecho();
        if (rowValue.getHasShogaishaTecho()) {
            shogaishaTecho.getTxtHasShogaishaTecho().setValue(new RString("有"));
            shogaishaTecho.getTxtShogaishaTechoNo().setValue(rowValue.getShogaishaTechoNo());
            shogaishaTecho.getTxtShogaishaTechoTokyu().setValue(rowValue.getShogaishaTechoTokyu());
        } else {
            shogaishaTecho.getTxtHasShogaishaTecho().setValue(new RString("無"));
            shogaishaTecho.getTxtShogaishaTechoNo().clearValue();
            shogaishaTecho.getTxtShogaishaTechoTokyu().clearValue();
        }
    }

    /**
     * creates ResponseData for HomonkaigoRiyoshaFutangakuGengakuDiv
     *
     * @param div HomonkaigoRiyoshaFutangakuGengakuDiv
     * @return ResponseData
     */
    private ResponseData<HomonkaigoRiyoshaFutangakuGengakuDiv>
            _createResponseData(HomonkaigoRiyoshaFutangakuGengakuDiv div) {
        ResponseData<HomonkaigoRiyoshaFutangakuGengakuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
