/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo.KaigoRenrakusakiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo.dgRenrakusaki_Row;
import jp.co.ndensan.reams.db.dbz.realservice.RenrakusakiInfoFinder;
import jp.co.ndensan.reams.db.dbz.realservice.RenrakusakiInfoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 連絡先情報Divを制御します。
 *
 * @author n9606 漢那 憲作
 */
public class RenrakusakiInfo {

    private static final RString SHORIKBN_INSERT = new RString("1");
    private static final RString SHORIKBN_UPDATE = new RString("2");
    private static final int MAX_ROW = 5;

    /**
     * 画面ロード時の設定を行います。
     *
     * @param div 連絡先情報Div
     * @return ResponseData
     */
    public ResponseData onLoad(KaigoRenrakusakiInfoDiv div) {
        ResponseData<KaigoRenrakusakiInfoDiv> response = new ResponseData<>();

        List<RenrakusakiJoho> list = new ArrayList<>();

        if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
            list = new RenrakusakiInfoFinder().getRenrakusakiList(
                    new RString("999999"), new RString("0000000001"));

        } else {
            list = new RenrakusakiInfoFinder().getRenrakusakiList(
                    new RString("999999"), div.getHihokenshaNo());
        }

        if (list.isEmpty()) {
            div.getDgRenrakusaki().setDataSource(Collections.EMPTY_LIST);
            div.getSelectedContents().getTxtShimei().clearValue();
            div.getSelectedContents().getTxtShimeiKana().clearValue();
            div.getSelectedContents().getTxtTel().clearValue();
            div.getSelectedContents().getTxtKeitaiNo().clearValue();
            div.getSelectedContents().getTxtYubinNo().clearValue();
            div.getSelectedContents().getTxtJusho().clearValue();
            div.getSelectedContents().getTxtZokugara().clearValue();
            div.getSelectedContents().getTxtRenrakusakiKbnNo().clearValue();
            div.setShoriKbn(RString.EMPTY);
            div.getBtnKakutei().setDisabled(true);
            div.getBtnDelete().setDisabled(true);
            div.getBtnKoshin().setDisabled(true);
        } else {

            List<dgRenrakusaki_Row> renrakusakiList = new ArrayList<>();
            for (RenrakusakiJoho renrakusaki : list) {
                renrakusakiList.add(createRenrakusakiListRow(
                        renrakusaki.get氏名().value(),
                        renrakusaki.get電話番号().value(),
                        renrakusaki.get携帯番号().value(),
                        renrakusaki.get氏名カナ().value(),
                        renrakusaki.get郵便番号().value(),
                        renrakusaki.get住所().value(),
                        renrakusaki.get続柄(),
                        renrakusaki.get連絡先区分番号()
                ));
            }

            div.getDgRenrakusaki().setDataSource(renrakusakiList);

            List<dgRenrakusaki_Row> selectRenrakusakiList = new ArrayList<>();
            selectRenrakusakiList.add(div.getDgRenrakusaki().getDataSource().get(0));
            div.getDgRenrakusaki().setSelectedItems(selectRenrakusakiList);

            div.getSelectedContents().getTxtShimei().setValue(list.get(0).
                    get氏名().value());
            div.getSelectedContents().getTxtShimeiKana().setValue(list.get(0).
                    get氏名カナ().value());

            if (!list.get(0).get電話番号().value().isEmpty()) {

                div.getSelectedContents().getTxtTel().setValue(list.get(0).
                        get電話番号().value());
            }

            if (!list.get(0).get携帯番号().value().isEmpty()) {
                div.getSelectedContents().getTxtKeitaiNo().setValue(list.get(0).
                        get携帯番号().value());
            }

            if (!list.get(0).get郵便番号().value().isEmpty()) {
                div.getSelectedContents().getTxtYubinNo().setValue(
                        new YubinNo(list.get(0).get郵便番号().value()));
            }

            div.getSelectedContents().getTxtJusho().setValue(
                    list.get(0).get住所().value());
            div.getSelectedContents().getTxtZokugara().setValue(
                    list.get(0).get続柄());
            div.getSelectedContents().getTxtRenrakusakiKbnNo().setValue(
                    list.get(0).get連絡先区分番号());

            div.setShoriKbn(SHORIKBN_UPDATE);
        }

        response.data = div;
        return response;
    }

    private dgRenrakusaki_Row createRenrakusakiListRow(
            RString shimei,
            RString tel,
            RString keitaiNo,
            RString shimeiKana,
            RString yubinNo,
            RString jusho,
            RString zokugara,
            RString renrakusakiKbnNo
    ) {

        return new dgRenrakusaki_Row(
                shimei,
                tel,
                keitaiNo,
                shimeiKana,
                yubinNo,
                jusho,
                zokugara,
                renrakusakiKbnNo);
    }

    /**
     * 連絡先情報登録画面-「連絡先データグリッド」選択時の処理を表します。
     *
     * @param div KaigoRenrakusakiInfoDiv
     * @return ResponseData
     */
    public ResponseData onSelect_Renrakusaki(KaigoRenrakusakiInfoDiv div) {
        ResponseData<KaigoRenrakusakiInfoDiv> response = new ResponseData<>();

        div.getSelectedContents().getTxtShimei().setValue(
                div.getDgRenrakusaki().getClickedItem().getShimei());
        div.getSelectedContents().getTxtShimeiKana().setValue(
                div.getDgRenrakusaki().getClickedItem().getShimeiKana());
        div.getSelectedContents().getTxtTel().setValue(
                div.getDgRenrakusaki().getClickedItem().getTel());
        div.getSelectedContents().getTxtKeitaiNo().setValue(
                div.getDgRenrakusaki().getClickedItem().getKeitaiNo());
        div.getSelectedContents().getTxtYubinNo().setValue(new YubinNo(
                div.getDgRenrakusaki().getClickedItem().getYubinNo()));
        div.getSelectedContents().getTxtJusho().setValue(
                div.getDgRenrakusaki().getClickedItem().getJusho());
        div.getSelectedContents().getTxtZokugara().setValue(
                div.getDgRenrakusaki().getClickedItem().getZokugara());
        div.getSelectedContents().getTxtRenrakusakiKbnNo().setValue(
                div.getDgRenrakusaki().getClickedItem().getRenrakusakiKbnNo());

        if (div.getDgRenrakusaki().getClickedItem().getRowState().equals(RowState.Deleted)) {
            div.getBtnKakutei().setDisabled(true);
        } else {
            div.getBtnKakutei().setDisabled(false);
            div.setShoriKbn(SHORIKBN_UPDATE);
            response.setFocusId(div.getSelectedContents().getTxtShimei().getSelectControlID());
        }

        response.data = div;
        return response;
    }

    /**
     * 連絡先情報登録画面-「追加」ボタン押下時の処理を表します。
     *
     * @param div KaigoRenrakusakiInfoDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnAdd(KaigoRenrakusakiInfoDiv div) {
        ResponseData<KaigoRenrakusakiInfoDiv> response = new ResponseData<>();

        div.getSelectedContents().getTxtShimei().clearValue();
        div.getSelectedContents().getTxtShimeiKana().clearValue();
        div.getSelectedContents().getTxtTel().clearValue();
        div.getSelectedContents().getTxtKeitaiNo().clearValue();
        div.getSelectedContents().getTxtYubinNo().clearValue();
        div.getSelectedContents().getTxtJusho().clearValue();
        div.getSelectedContents().getTxtZokugara().clearValue();
        DecimalFormat df = new DecimalFormat("00000000");
        div.getSelectedContents().getTxtRenrakusakiKbnNo().setValue(
                new RString(df.format(div.getDgRenrakusaki().getTotalRecords() + 1)));

        div.setShoriKbn(SHORIKBN_INSERT);
        div.getBtnKakutei().setDisabled(false);

        response.setFocusId(div.getSelectedContents().getTxtShimei().getSelectControlID());

        response.data = div;
        return response;
    }

    /**
     * 連絡先情報登録画面-「削除」ボタン押下時の処理を表します。
     *
     * @param div KaigoRenrakusakiInfoDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnDelete(KaigoRenrakusakiInfoDiv div) {
        ResponseData<KaigoRenrakusakiInfoDiv> response = new ResponseData<>();

        if (div.getDgRenrakusaki().getSelectedItems().get(0).getRowState().
                equals(RowState.Added)) {

            div.getDgRenrakusaki().getDataSource().remove(div.getDgRenrakusaki().
                    getSelectedItems().get(0));

            div.getBtnAdd().setDisabled(false);

        } else {
            div.getDgRenrakusaki().getSelectedItems().get(0).setRowState(RowState.Deleted);
        }

        response.data = div;
        return response;
    }

    /**
     * 連絡先情報登録画面-「確定」ボタン押下時の処理を表します。
     *
     * @param div KaigoRenrakusakiInfoDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnKakutei(KaigoRenrakusakiInfoDiv div) {
        ResponseData<KaigoRenrakusakiInfoDiv> response = new ResponseData<>();

        if (div.getShoriKbn().equals(SHORIKBN_INSERT)) {

            List<dgRenrakusaki_Row> renrakusakiList = div.getDgRenrakusaki().getDataSource();
            renrakusakiList.add(createRenrakusakiListRow(
                    div.getSelectedContents().getTxtShimei().getValue(),
                    div.getSelectedContents().getTxtTel().getValue(),
                    div.getSelectedContents().getTxtKeitaiNo().getValue(),
                    div.getSelectedContents().getTxtShimeiKana().getValue(),
                    div.getSelectedContents().getTxtYubinNo().getText(),
                    div.getSelectedContents().getTxtJusho().getValue(),
                    div.getSelectedContents().getTxtZokugara().getValue(),
                    div.getSelectedContents().getTxtRenrakusakiKbnNo().getValue()
            ));
            div.getDgRenrakusaki().setDataSource(renrakusakiList);

            List<dgRenrakusaki_Row> selectRenrakusakiList = new ArrayList<>();
            selectRenrakusakiList.add(div.getDgRenrakusaki().getDataSource().get(
                    div.getDgRenrakusaki().getTotalRecords() - 1));
            div.getDgRenrakusaki().setSelectedItems(selectRenrakusakiList);

            div.getDgRenrakusaki().getDataSource().get(
                    div.getDgRenrakusaki().getTotalRecords() - 1).
                    setRowState(RowState.Added);

            div.setShoriKbn(SHORIKBN_UPDATE);

            if (div.getDgRenrakusaki().getTotalRecords() == MAX_ROW) {
                div.getBtnAdd().setDisabled(true);
            }

            div.getBtnDelete().setDisabled(false);
            div.getBtnKoshin().setDisabled(false);
        } else if (div.getShoriKbn().equals(SHORIKBN_UPDATE)) {
            div.getDgRenrakusaki().getSelectedItems().get(0).setShimei(
                    div.getSelectedContents().getTxtShimei().getValue());

            div.getDgRenrakusaki().getSelectedItems().get(0).setShimeiKana(
                    div.getSelectedContents().getTxtShimeiKana().getValue());

            div.getDgRenrakusaki().getSelectedItems().get(0).setTel(
                    div.getSelectedContents().getTxtTel().getValue());

            div.getDgRenrakusaki().getSelectedItems().get(0).setKeitaiNo(
                    div.getSelectedContents().getTxtKeitaiNo().getValue());

            div.getDgRenrakusaki().getSelectedItems().get(0).setYubinNo(
                    div.getSelectedContents().getTxtYubinNo().getText());

            div.getDgRenrakusaki().getSelectedItems().get(0).setJusho(
                    div.getSelectedContents().getTxtJusho().getValue());

            div.getDgRenrakusaki().getSelectedItems().get(0).setZokugara(
                    div.getSelectedContents().getTxtZokugara().getValue());

            div.getDgRenrakusaki().getSelectedItems().get(0).setRenrakusakiKbnNo(
                    div.getSelectedContents().getTxtRenrakusakiKbnNo().getValue());

            if (div.getDgRenrakusaki().getSelectedItems().get(0).getRowState().
                    equals(RowState.Modified) || div.getDgRenrakusaki().
                    getSelectedItems().get(0).getRowState().equals(RowState.Unchanged)) {
                div.getDgRenrakusaki().getSelectedItems().get(0).setRowState(RowState.Modified);
            }
        }

        response.data = div;
        return response;
    }

    /**
     * 連絡先情報登録画面-「更新」ボタン押下時の処理を表します。
     *
     * @param div KaigoRenrakusakiInfoDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnKoshin(KaigoRenrakusakiInfoDiv div) {
        ResponseData<KaigoRenrakusakiInfoDiv> response = new ResponseData<>();

        RString hokenshaNo;
        RString hihokenshaNo;
        Boolean result = Boolean.FALSE;

        hokenshaNo = new RString("999999");
        if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
            hihokenshaNo = new RString("0000000001");
        } else {
            hihokenshaNo = div.getHihokenshaNo();
        }

        List<dgRenrakusaki_Row> list = div.getDgRenrakusaki().getDataSource();
        for (dgRenrakusaki_Row rowRenrakusaki : list) {
            if (!rowRenrakusaki.getRowState().equals(RowState.Unchanged)) {
                RenrakusakiJoho renrakusakiJoho = new RenrakusakiJoho(
                        new AtenaMeisho(rowRenrakusaki.getShimei()),
                        new AtenaKanaMeisho(rowRenrakusaki.getShimeiKana()),
                        new TelNo(rowRenrakusaki.getTel()),
                        new TelNo(rowRenrakusaki.getKeitaiNo()),
                        new YubinNo(rowRenrakusaki.getYubinNo()),
                        new AtenaJusho(rowRenrakusaki.getJusho()),
                        rowRenrakusaki.getZokugara(),
                        rowRenrakusaki.getRenrakusakiKbnNo(),
                        hokenshaNo,
                        hihokenshaNo);

                if ((rowRenrakusaki.getRowState().equals(RowState.Added))
                        || (rowRenrakusaki.getRowState().equals(RowState.Modified))) {

                    result = new RenrakusakiInfoManager().save(renrakusakiJoho);
                } else if (rowRenrakusaki.getRowState().equals(RowState.Deleted)) {

                    result = new RenrakusakiInfoManager().remove(renrakusakiJoho);
                }
            }

        }

        response.data = div;
        return response;
    }
}
