/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.ShinsaTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private static Integer cntSelectSu = 0;
    private static Integer cntSu = 0;
    private static Integer selectIdx = 0;

    /**
     *
     * @param div 認定審査結果入力用Div
     * @param shinsaTaishoshaIchiranDiv 認定審査結果入力対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onLoadData(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaIchiranDiv shinsaTaishoshaIchiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaIchiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx);

        div.getHihokenshaJoho().getTxtHihokenshaShimei().setValue(dataRow.getShimei());
        div.getHihokenshaJoho().getTxtBirthDay().setValue(new RDate(dataRow.getSeinengappi().toString()));
        div.getHihokenshaJoho().getTxtHihokenshaKubun().setValue(new RString("１号"));
        div.getHihokenshaJoho().getTxtHihokenshaNo().setValue(dataRow.getHihokenshaNo());
        div.getHihokenshaJoho().getTxtHokenshaNo().setValue(dataRow.getHokenshaNo());
        div.getHihokenshaJoho().getTxtHokenshaMeisho().setValue(dataRow.getShichoson());
        div.getHihokenshaJoho().getTxtNenrei().setValue(dataRow.getNenrei());
//        div.getHihokenshaJoho().getTxtShinseiKubun().setValue(dataRow.getShinseiKubun());
//        div.getHihokenshaJoho().getTxtNinteiShinseiYMD().setValue(dataRow.getShinseibi().getValue());
        div.getHihokenshaJoho().getTxtShinseiKubun().setDisplayNone(true);
        div.getHihokenshaJoho().getTxtNinteiShinseiYMD().setDisplayNone(true);
        div.getHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(dataRow.getBeforeYokaigodo());
        div.getHihokenshaJoho().getTxtZenYukokikanStart().setValue(dataRow.getBeforeYukoStartDate().getValue());
        div.getHihokenshaJoho().getTxtZenYukokikanEnd().setValue(dataRow.getBeforeYukoEndDate().getValue());

        div.getNinteiKekkaNyuryoku().getTxtShinsaJun().setValue(dataRow.getShinsaJun());
        div.getNinteiKekkaNyuryoku().getTxtShinseibi().setValue(dataRow.getShinseibi().getValue());
        div.getNinteiKekkaNyuryoku().getTxtShinseiKubunShinsei().setValue(dataRow.getShinseiKubun());
        div.getNinteiKekkaNyuryoku().getTxtIchijiHanteiKekka().setValue(dataRow.getIchijiHantei());
        div.getNinteiKekkaNyuryoku().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
        if (dataRow.getYukoKikan().equalsIgnoreCase(RString.EMPTY)) {
            div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setSelectedItem(new RString("01"));
            div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().setSelectedItem(new RString("0"));
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate(RString.EMPTY));
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate(RString.EMPTY));
            div.getNinteiKekkaNyuryoku().getTxtShinsakaiIken().setValue(RString.EMPTY);
        } else {
            div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().setSelectedItem(dataRow.getNinteiResultItem());
            div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().setSelectedItem(dataRow.getYukoKikanItem());
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(dataRow.getYukoStartDate().getValue());
            div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(dataRow.getYukoEndDate().getValue());
            div.getNinteiKekkaNyuryoku().getTxtShinsakaiIken().setValue(dataRow.getShinsakaiIken());
        }

        div.getNinteiKekkaNyuryoku().setEraseBorderBottom(true);
        div.getNinteiKekkaNyuryoku().setEraseBorderLeft(true);
        div.getNinteiKekkaNyuryoku().setEraseBorderRight(true);
        div.getNinteiKekkaNyuryoku().setEraseBorderTop(true);

        if (shinsaTaishoshaIchiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().size() == 1) {
            div.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);
        } else {
            div.getNyuryokuSeigyo().getBtnNext().setDisplayNone(false);
            cntSelectSu = shinsaTaishoshaIchiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().size();
            cntSu = cntSelectSu - 1;
            if (selectIdx.equals(cntSu)) {
                div.getNyuryokuSeigyo().getBtnNext().setDisplayNone(true);
            }
        }

        response.data = div;
        return response;
    }

    /**
     * 審査結果入力タブの今回認定結果情報タブの認定区分ドロップダウンリストの選択時の動きを表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaIchiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNinteiKubun(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaIchiranDiv shinsaTaishoshaIchiranDiv) {
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
     * @param shinsaTaishoshaIchiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNijiHanteiKekka(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaIchiranDiv shinsaTaishoshaIchiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        dgShinsaTaishoshaIchiran_Row dataRow = shinsaTaishoshaIchiranDiv.getDgShinsaTaishoshaIchiran().getSelectedItems().get(selectIdx);

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
            response = onSelect_ddlNinteiYukoTsukisu(div, shinsaTaishoshaIchiranDiv);
        }
        ViewStateHolder.put("二次判定結果", div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().getSelectedValue());
        ViewStateHolder.put("二次判定コード", div.getNinteiKekkaNyuryoku().getDdlNijiHanteiKekka().getSelectedItem());
        ViewStateHolder.put("被保番号", div.getHihokenshaJoho().getTxtHihokenshaNo().getValue());
        return response;

    }

    /**
     * 審査結果入力タブの今回認定結果情報タブの認定有効月数ドロップダウンリストの選択時の動きを表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaIchiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onSelect_ddlNinteiYukoTsukisu(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaIchiranDiv shinsaTaishoshaIchiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        FlexibleDate startYmd;
        FlexibleDate endYmd;

        startYmd = div.getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().getValue();
        endYmd = startYmd;

        div.getNinteiKekkaNyuryoku().getTxtShinsakaiIken().setValue(RString.EMPTY);
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

        ViewStateHolder.put("認定月数", div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedValue());
        ViewStateHolder.put("認定月数コード", div.getNinteiKekkaNyuryoku().getDdlNinteiYukoTsukisu().getSelectedItem());
        ViewStateHolder.put("審査会意見", div.getNinteiKekkaNyuryoku().getTxtShinsakaiIken().getValue());
        ViewStateHolder.put("有効開始日", startYmd);
        ViewStateHolder.put("有効終了日", endYmd);
        response.data = div;
        return response;
    }

    /**
     * 「次の候補者を選択する」ボタン押下時の処理を表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaIchiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onClick_btnNext(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaIchiranDiv shinsaTaishoshaIchiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        selectIdx = ++selectIdx;

        response = onLoadData(div, shinsaTaishoshaIchiranDiv);

        return response;
    }

    /**
     * 「一覧に戻る」ボタン押下時の処理を表します。
     *
     * @param div 審査結果入力詳細Div
     * @param shinsaTaishoshaIchiranDiv 審査対象者一覧Div
     * @return ResponseData
     */
    public ResponseData onClick_btnBackIchiran(NinteiShinsaKekkaNyuryokuDiv div,
            ShinsaTaishoshaIchiranDiv shinsaTaishoshaIchiranDiv) {
        ResponseData<NinteiShinsaKekkaNyuryokuDiv> response = new ResponseData<>();

        selectIdx = 0;

        return response;
    }

}
