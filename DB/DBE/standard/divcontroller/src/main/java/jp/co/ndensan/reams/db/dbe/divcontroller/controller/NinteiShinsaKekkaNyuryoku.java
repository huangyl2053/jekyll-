/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.ShinsaTaishoshaItiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 認定審査結果入力用Divの制御を行います。
 *
 * @author N1013 松本直樹
 */
public class NinteiShinsaKekkaNyuryoku {

    private static final int TSUKISU_5 = 5;
    private static final int TSUKISU_6 = 6;
    private static final int TSUKISU_11 = 11;
    private static final int TSUKISU_12 = 12;
    private static final int TSUKISU_23 = 23;
    private static final int TSUKISU_24 = 24;
    private static int cntSelectSu = 0;
    private static int selectIdx = 0;

    /**
     *
     * @param div 認定審査結果入力用Div
     * @param shinsaTaishoshaItiranDiv 認定審査結果入力対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onLoadData(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

//        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getClickedItem();
        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx);

        System.out.println("被保険者＝" + dataRow.getHihokenshaNo());
        div.getHihokenshaJoho().getTxtHihokenshaShimei().setValue(dataRow.getShimei());
        div.getHihokenshaJoho().getTxtBirthDay().setValue(new RDate(dataRow.getSeinengappi().toString()));
        div.getHihokenshaJoho().getTxtHihokenshaKubun().setValue(new RString("１号"));
        div.getHihokenshaJoho().getTxtHihokenshaNo().setValue(dataRow.getHihokenshaNo());
        div.getHihokenshaJoho().getTxtHokenshaNo().setValue(dataRow.getHokenshaNo());
        div.getHihokenshaJoho().getTxtHokenshaMeisho().setValue(dataRow.getShichoson());
        div.getHihokenshaJoho().getTxtNenrei().setValue(dataRow.getNenrei());
        div.getHihokenshaJoho().getTxtShinseiKubun().setValue(dataRow.getShinseiKubun());
        div.getHihokenshaJoho().getTxtNinteiShinseiYMD().setValue(dataRow.getShinseibi().getValue());
        div.getHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(dataRow.getBeforeYokaigodo());
        div.getHihokenshaJoho().getTxtZenYukokikanStart().setValue(dataRow.getBeforeYukoStartDate().getValue());
        div.getHihokenshaJoho().getTxtZenYukokikanEnd().setValue(dataRow.getBeforeYukoEndDate().getValue());

        div.getNinteiKekkaNyuryoku().getTxtShinseibi().setValue(dataRow.getShinseibi().getValue());
        div.getNinteiKekkaNyuryoku().getTxtShinseiKubunShinsei().setValue(dataRow.getShinseiKubun());
        div.getNinteiKekkaNyuryoku().getTxtIchijiHanteiKekka().setValue(dataRow.getIchijiHantei());
        div.getNinteiKekkaNyuryoku().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
        div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setSelectedItem(new RString("01"));
        div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().setSelectedItem(new RString("0"));
        div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate(RString.EMPTY));
        div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate(RString.EMPTY));

        div.getNinteiKekkaNyuryoku().setEraseBorderBottom(true);
        div.getNinteiKekkaNyuryoku().setEraseBorderLeft(true);
        div.getNinteiKekkaNyuryoku().setEraseBorderRight(true);
        div.getNinteiKekkaNyuryoku().setEraseBorderTop(true);

        if (shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().size() == 1) {
            div.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);
        } else {
            cntSelectSu = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().size();
        }

        response.data = div;
        return response;
    }

    /**
     * 審査結果入力タブの今回認定結果情報タブの認定区分ドロップダウンリストの選択時の動きを表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaItiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNinteiKubun(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        if (div.getNinteiKekkaNyuryoku().getDdlNinteiKubun().getSelectedValue().equalsIgnoreCase("再調査")) {
            div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setDisabled(true);
        } else {
            div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setDisabled(false);
        }

        response.data = div;
        return response;

    }

    /**
     * 審査結果入力タブの今回認定結果情報タブの二次判定結果ドロップダウンリストの選択時の動きを表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaItiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNijiHanteiKekka(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx);

        if (div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().getSelectedValue().equalsIgnoreCase(new RString("非該当"))) {
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(FlexibleDate.EMPTY);
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setDisabled(true);
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(FlexibleDate.EMPTY);
            div.getNinteiKekkaNyuryoku().getDdlJotaiZo().setDisabled(true);
            div.getNinteiKekkaNyuryoku().getDdlJotaiZo().setDisplayNone(true);
            div.getNinteiKekkaNyuryoku().getTxtShinseiKubunHorei().setValue(RString.EMPTY);
            response.data = div;
        } else {
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(dataRow.getBeforeYukoEndDate().getValue().plusDay(1));
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setDisabled(false);
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("20160630"));
            div.getNinteiKekkaNyuryoku().getTxtShinseiKubunHorei().setValue(new RString("更新"));
            div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().setSelectedItem(new RString("24"));
            if (div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().getSelectedValue().equalsIgnoreCase(new RString("要介護１"))) {
                div.getNinteiKekkaNyuryoku().getDdlJotaiZo().setDisabled(false);
                div.getNinteiKekkaNyuryoku().getDdlJotaiZo().setDisplayNone(false);
            } else {
                div.getNinteiKekkaNyuryoku().getDdlJotaiZo().setDisabled(true);
                div.getNinteiKekkaNyuryoku().getDdlJotaiZo().setDisplayNone(true);
            }
            response = onSelect_ddlNinteiYukoTsukisu(div, shinsaTaishoshaItiranDiv);
        }
        return response;

    }

    /**
     * 審査結果入力タブの今回認定結果情報タブの認定有効月数ドロップダウンリストの選択時の動きを表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaItiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNinteiYukoTsukisu(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        FlexibleDate startYmd;
        FlexibleDate endYmd;

        startYmd = div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().getValue();
        endYmd = startYmd;

        if (div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("６")) {
            if (startYmd.getDayValue() == 1) {
                endYmd = startYmd.plusMonth(TSUKISU_5);
            } else {
                endYmd = startYmd.plusMonth(TSUKISU_6);
            }
        } else if (div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("１２")) {
            if (startYmd.getDayValue() == 1) {
                endYmd = startYmd.plusMonth(TSUKISU_11);
            } else {
                endYmd = startYmd.plusMonth(TSUKISU_12);
            }
        } else if (div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("２４")) {
            div.getNinteiKekkaNyuryoku().getTxtShinsakaiIken().setValue(new RString("・認定有効期間を２年間とする"));
            if (startYmd.getDayValue() == 1) {
                endYmd = startYmd.plusMonth(TSUKISU_23);
            } else {
                endYmd = startYmd.plusMonth(TSUKISU_24);
            }
        }

        endYmd = new FlexibleDate(endYmd.getYearValue(), endYmd.getMonthValue(), endYmd.getLastDay());
        div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(endYmd);

        response.data = div;
        return response;
    }

    /**
     * 「入力内容で登録する」ボタン押下時の処理を表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaItiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToroku(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        RString nijiHantei = div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().getSelectedValue();
        RString yukoTsukisu = div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue();
        TextBoxFlexibleDate yukoStartDate = div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart();
        TextBoxFlexibleDate yukoEndDate = div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd();

        shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx).setNinteiResult(nijiHantei);
        shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx).setYukoKikan(yukoTsukisu);
        shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx).setYukoStartDate(yukoStartDate);
        shinsaTaishoshaItiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx).setYukoEndDate(yukoEndDate);

        response.data = div;
        return response;
    }

    /**
     * 「次の候補者を選択する」ボタン押下時の処理を表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaItiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onClick_btnNext(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaItiranDiv shinsaTaishoshaItiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        response.data = div;

        selectIdx = ++selectIdx;
        if (selectIdx == (cntSelectSu - 1)) {
            div.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);
        }

        response = onLoadData(div, shinsaTaishoshaItiranDiv);

        return response;
    }

}
