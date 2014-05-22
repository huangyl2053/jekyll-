/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NyuryokuSeigyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaTaishoshaItiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N1013
 */
public class NinteiShinsaKekkaNyuryoku {

    /**
     *
     * @param ninteiShinsaKekkaNyuryoikuDiv
     * @param shinsaTaishoshaItiranDiv
     * @return
     */
    public ResponseData getOnloadData(NinteiShinsaKekkaNyuryokuDiv ninteiShinsaKekkaNyuryoikuDiv,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getClickedItem();

        System.out.println("被保険者＝" + dataRow.get被保番号());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaShimei().setValue(dataRow.get氏名());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtBirthDay().setValue(new RDate("1935/08/19"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaKubun().setValue(new RString("１号"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaNo().setValue(dataRow.get被保番号());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHokenshaNo().setValue(dataRow.get保険者());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtNenrei().setValue(new RString("79"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(new RString("要支援１"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanStart().setValue(new RDate("20130601"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanEnd().setValue(new RDate("20140531"));

        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseibi().setValue(new RDate(dataRow.get申請日().toString()));
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseiKubunShinsei().setValue(new RString("更新"));
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtIchijiHanteiKekka().setValue(dataRow.get一次判定結果());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setSelectedItem(RString.EMPTY);
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate("20140601"));
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("20160531"));

        ninteiShinsaKekkaNyuryoikuDiv.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);

        response.data = ninteiShinsaKekkaNyuryoikuDiv;
        return response;
    }

    public ResponseData setOnloadData(NinteiShinsaKekkaNyuryokuDiv ninteiShinsaKekkaNyuryoikuDiv,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getClickedItem();

        System.out.println("被保険者＝" + dataRow.get被保番号());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaShimei().setValue(dataRow.get氏名());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtBirthDay().setValue(new RDate("1935/08/19"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaKubun().setValue(new RString("１号"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaNo().setValue(dataRow.get被保番号());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHokenshaNo().setValue(dataRow.get保険者());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtNenrei().setValue(new RString("79才"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(new RString("要支援１"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanStart().setValue(new RDate("2013/06/01"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanEnd().setValue(new RDate("2014/05/31"));

        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseibi().setValue(new RDate(dataRow.get申請日().toString()));
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseiKubunShinsei().setValue(new RString("更新"));
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtIchijiHanteiKekka().setValue(dataRow.get一次判定結果());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setSelectedItem(RString.EMPTY);
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate("2014/06/01"));
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("2016/05/31"));

        ninteiShinsaKekkaNyuryoikuDiv.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);

        response.data = ninteiShinsaKekkaNyuryoikuDiv;
        return response;
    }

}
