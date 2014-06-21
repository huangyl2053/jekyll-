/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaTaishoshaItiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査結果入力用Divの制御を行います。
 *
 * @author N1013 松本直樹
 */
public class NinteiShinsaKekkaNyuryoku {

    static final int TSUKISU_5 = 5;
    static final int TSUKISU_6 = 6;
    static final int TSUKISU_11 = 11;
    static final int TSUKISU_12 = 12;
    static final int TSUKISU_23 = 23;
    static final int TSUKISU_24 = 24;

    /**
     *
     * @param ninteiShinsaKekkaNyuryoikuDiv 認定審査結果入力用Div
     * @param shinsaTaishoshaItiranDiv 認定審査結果入力対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onLoadData(NinteiShinsaKekkaNyuryokuDiv ninteiShinsaKekkaNyuryoikuDiv,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getClickedItem();

        System.out.println("被保険者＝" + dataRow.get被保番号());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaShimei().setValue(dataRow.get氏名());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtBirthDay().setValue(new RDate(dataRow.get生年月日().toString()));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaKubun().setValue(new RString("１号"));
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaNo().setValue(dataRow.get被保番号());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHokenshaNo().setValue(dataRow.get保険者番号());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHokenshaMeisho().setValue(dataRow.get市町村());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtNenrei().setValue(dataRow.get年齢());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtShinseiKubun().setValue(dataRow.get申請区分());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtNinteiShinseiYMD().setValue(dataRow.get申請日().getValue());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(dataRow.get前回要介護度());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanStart().setValue(dataRow.get前回有効期間開始日().getValue());
        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanEnd().setValue(dataRow.get前回有効期間終了日().getValue());

        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseibi().setValue(dataRow.get申請日().getValue());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseiKubunShinsei().setValue(dataRow.get申請区分());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtIchijiHanteiKekka().setValue(dataRow.get一次判定結果());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setSelectedItem(RString.EMPTY);
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate("20140601"));
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("20160531"));

        ninteiShinsaKekkaNyuryoikuDiv.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);

        response.data = ninteiShinsaKekkaNyuryoikuDiv;
        return response;
    }

//    public ResponseData setOnloadData(NinteiShinsaKekkaNyuryokuDiv ninteiShinsaKekkaNyuryoikuDiv,
//            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
//        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();
//
//        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getClickedItem();
//
//        System.out.println("被保険者＝" + dataRow.get被保番号());
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaShimei().setValue(dataRow.get氏名());
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtBirthDay().setValue(new RDate("1935/08/19"));
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaKubun().setValue(new RString("１号"));
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHihokenshaNo().setValue(dataRow.get被保番号());
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHokenshaNo().setValue(dataRow.get保険者番号());
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtHokenshaMeisho().setValue(dataRow.get市町村());
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtNenrei().setValue(new RString("79才"));
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(new RString("要支援１"));
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanStart().setValue(new FlexibleDate("2013/06/01"));
//        ninteiShinsaKekkaNyuryoikuDiv.getHihokenshaJoho().getTxtZenYukokikanEnd().setValue(new FlexibleDate("2014/05/31"));
//
//        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseibi().setValue(dataRow.get申請日().getValue());
//        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtShinseiKubunShinsei().setValue(new RString("更新"));
//        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtIchijiHanteiKekka().setValue(dataRow.get一次判定結果());
//        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
//        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setSelectedItem(RString.EMPTY);
//        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate("2014/06/01"));
//        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("2016/05/31"));
//
//        ninteiShinsaKekkaNyuryoikuDiv.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);
//
//        response.data = ninteiShinsaKekkaNyuryoikuDiv;
//        return response;
//    }
    /**
     * 審査結果入力タブの今回認定結果情報タブの認定区分ドロップダウンリストの選択時の動きを表します。
     *
     * @param ninteiShinsaKekkaNyuryoikuDiv 審査結果入力詳細Div
     * @param shinsaTaishoshaItiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNinteiKubun(NinteiShinsaKekkaNyuryokuDiv ninteiShinsaKekkaNyuryoikuDiv,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        if (ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNinteiKubun().getSelectedValue().equalsIgnoreCase("再調査")) {
            ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setDisabled(true);
        } else {
            ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setDisabled(false);
        }

        response.data = ninteiShinsaKekkaNyuryoikuDiv;
        return response;

    }

    /**
     * 審査結果入力タブの今回認定結果情報タブの認定有効月数ドロップダウンリストの選択時の動きを表します。
     *
     * @param ninteiShinsaKekkaNyuryoikuDiv 審査結果入力詳細Div
     * @param shinsaTaishoshaItiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNinteiYukoTsukisu(NinteiShinsaKekkaNyuryokuDiv ninteiShinsaKekkaNyuryoikuDiv,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        FlexibleDate startYmd;
        FlexibleDate endYmd;

        startYmd = ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().getValue();
        endYmd = startYmd;

        if (ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("６")) {
            if (startYmd.getDayValue() == 1) {
                endYmd = startYmd.plusMonth(TSUKISU_5);
            } else {
                endYmd = startYmd.plusMonth(TSUKISU_6);
            }
        } else if (ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("１２")) {
            if (startYmd.getDayValue() == 1) {
                endYmd = startYmd.plusMonth(TSUKISU_11);
            } else {
                endYmd = startYmd.plusMonth(TSUKISU_12);
            }
        } else if (ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("２４")) {
            if (startYmd.getDayValue() == 1) {
                endYmd = startYmd.plusMonth(TSUKISU_23);
            } else {
                endYmd = startYmd.plusMonth(TSUKISU_24);
            }
        }

        endYmd = new FlexibleDate(endYmd.getYearValue(), endYmd.getMonthValue(), endYmd.getLastDay());
        ninteiShinsaKekkaNyuryoikuDiv.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(endYmd);

        response.data = ninteiShinsaKekkaNyuryoikuDiv;
        return response;

    }

}
