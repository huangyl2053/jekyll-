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
import jp.co.ndensan.reams.db.dbz.business.KaigoRenrakusaki;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo.KaigoRenrakusakiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo.dgRenrakusaki_Row;
import jp.co.ndensan.reams.db.dbz.realservice.RenrakusakiInfoFinder;
import jp.co.ndensan.reams.db.dbz.realservice.RenrakusakiInfoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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

        List<KaigoRenrakusaki> list = new ArrayList<>();

        if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
            list = new RenrakusakiInfoFinder().getRenrakusakiList(
                    new ShoKisaiHokenshaNo(new RString("999999")),
                    new KaigoHihokenshaNo(new RString("0000000001")));

        } else {
            list = new RenrakusakiInfoFinder().getRenrakusakiList(
                    new ShoKisaiHokenshaNo(new RString("999999")),
                    new KaigoHihokenshaNo(div.getHihokenshaNo()));
        }

        if (list.isEmpty()) {
            div.getDgRenrakusaki().setDataSource(Collections.EMPTY_LIST);
            div.setShoriKbn(RString.EMPTY);
            div.getBtnDelete().setDisabled(true);
        } else {

            List<dgRenrakusaki_Row> renrakusakiList = new ArrayList<>();
            for (KaigoRenrakusaki renrakusaki : list) {
                renrakusakiList.add(createRenrakusakiListRow(
                        renrakusaki.get連絡先区分番号().substring(
                                renrakusaki.get連絡先区分番号().length() - 1),
                        renrakusaki.get氏名().value(),
                        renrakusaki.get続柄(),
                        renrakusaki.get電話番号().value(),
                        renrakusaki.get携帯番号().value(),
                        renrakusaki.get氏名カナ().value(),
                        new YubinNo(renrakusaki.get郵便番号().value()).getEditedYubinNo(),
                        renrakusaki.get住所().value()
                ));
            }

            div.getDgRenrakusaki().setDataSource(renrakusakiList);

            if (div.getDgRenrakusaki().getTotalRecords() >= MAX_ROW) {
                div.getBtnAdd().setDisabled(true);
            }
        }

        response.data = div;
        return response;
    }

    private dgRenrakusaki_Row createRenrakusakiListRow(
            RString renrakusakiKbnNo,
            RString shimei,
            RString tsuzukigara,
            RString tel,
            RString keitaiNo,
            RString shimeiKana,
            RString yubinNo,
            RString jusho
    ) {

        return new dgRenrakusaki_Row(
                renrakusakiKbnNo,
                shimei,
                tsuzukigara,
                tel,
                keitaiNo,
                shimeiKana,
                yubinNo,
                jusho
        );
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
        div.getSelectedContents().getTxtTsuzukigara().setValue(
                div.getDgRenrakusaki().getClickedItem().getTsuzukigara());

        DecimalFormat df = new DecimalFormat("00000000");
        div.getSelectedContents().setRenrakusakiKbnNo(
                new RString(df.format(Integer.parseInt(div.getDgRenrakusaki().getClickedItem().
                                        getRenrakusakiKbnNo().toString()))));

        div.getSelectedContents().setDisplayNone(false);
        div.setShoriKbn(SHORIKBN_UPDATE);

        div.getBtnAdd().setDisabled(true);
        div.getBtnDelete().setDisabled(true);

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
        div.getSelectedContents().getTxtTsuzukigara().clearValue();
        DecimalFormat df = new DecimalFormat("00000000");
        div.getSelectedContents().setRenrakusakiKbnNo(
                new RString(df.format(div.getDgRenrakusaki().getTotalRecords() + 1)));

        div.getSelectedContents().setDisplayNone(false);
        div.setShoriKbn(SHORIKBN_INSERT);

        div.getBtnAdd().setDisabled(true);
        div.getBtnDelete().setDisabled(true);

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

        ShoKisaiHokenshaNo hokenshaNo;
        KaigoHihokenshaNo hihokenshaNo;
        Boolean result = Boolean.FALSE;

        hokenshaNo = new ShoKisaiHokenshaNo(new RString("999999"));
        if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
            hihokenshaNo = new KaigoHihokenshaNo(new RString("0000000001"));
        } else {
            hihokenshaNo = new KaigoHihokenshaNo(div.getHihokenshaNo());
        }

        dgRenrakusaki_Row rowRenrakusaki = div.getDgRenrakusaki().getSelectedItems().get(0);
        DecimalFormat df = new DecimalFormat("00000000");

        KaigoRenrakusaki renrakusakiJoho = new KaigoRenrakusaki(
                new AtenaMeisho(rowRenrakusaki.getShimei()),
                new AtenaKanaMeisho(rowRenrakusaki.getShimeiKana()),
                new TelNo(rowRenrakusaki.getTel()),
                new TelNo(rowRenrakusaki.getKeitaiNo()),
                new YubinNo(rowRenrakusaki.getYubinNo()),
                new AtenaJusho(rowRenrakusaki.getJusho()),
                rowRenrakusaki.getTsuzukigara(),
                new RString(df.format(Integer.parseInt(
                                        div.getDgRenrakusaki().getSelectedItems().get(0).
                                        getRenrakusakiKbnNo().toString()))),
                hokenshaNo,
                hihokenshaNo);

        result = new RenrakusakiInfoManager().remove(renrakusakiJoho);

        if (result == Boolean.TRUE) {
            div.getDgRenrakusaki().getDataSource().remove(div.getDgRenrakusaki().
                    getSelectedItems().get(0));

            div.getBtnAdd().setDisabled(false);
            if (div.getDgRenrakusaki().getTotalRecords() == 0) {
                div.getBtnDelete().setDisabled(true);
            }
        }

        response.data = div;
        return response;
    }

    /**
     * 連絡先情報登録画面-「取消」ボタン押下時の処理を表します。
     *
     * @param div KaigoRenrakusakiInfoDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnCancel(KaigoRenrakusakiInfoDiv div) {
        ResponseData<KaigoRenrakusakiInfoDiv> response = new ResponseData<>();

        div.getSelectedContents().setDisplayNone(true);

        if (div.getDgRenrakusaki().getTotalRecords() < MAX_ROW) {
            div.getBtnAdd().setDisabled(false);
        }

        if (div.getDgRenrakusaki().getTotalRecords() > 0) {
            div.getBtnDelete().setDisabled(false);
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

        if (chkInputJoho(div) == Boolean.TRUE) {
            hokenshaNo = new RString("999999");
            if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
                hihokenshaNo = new RString("0000000001");
            } else {
                hihokenshaNo = div.getHihokenshaNo();
            }

            KaigoRenrakusaki renrakusakiJoho = new KaigoRenrakusaki(
                    new AtenaMeisho(div.getSelectedContents().getTxtShimei().getValue()),
                    new AtenaKanaMeisho(div.getSelectedContents().getTxtShimeiKana().getValue()),
                    new TelNo(div.getSelectedContents().getTxtTel().getValue()),
                    new TelNo(div.getSelectedContents().getTxtKeitaiNo().getValue()),
                    new YubinNo(div.getSelectedContents().getTxtYubinNo().getText()),
                    new AtenaJusho(div.getSelectedContents().getTxtJusho().getValue()),
                    div.getSelectedContents().getTxtTsuzukigara().getValue(),
                    div.getSelectedContents().getRenrakusakiKbnNo(),
                    new ShoKisaiHokenshaNo(hokenshaNo),
                    new KaigoHihokenshaNo(hihokenshaNo));

            result = new RenrakusakiInfoManager().save(renrakusakiJoho);

            if (result == Boolean.TRUE) {
                div.getSelectedContents().setDisplayNone(true);

                if (div.getShoriKbn().equals(SHORIKBN_INSERT)) {

                    List<dgRenrakusaki_Row> renrakusakiList = div.getDgRenrakusaki().getDataSource();
                    renrakusakiList.add(createRenrakusakiListRow(
                            div.getSelectedContents().getRenrakusakiKbnNo().
                            substring(div.getSelectedContents().getRenrakusakiKbnNo().length() - 1),
                            div.getSelectedContents().getTxtShimei().getValue(),
                            div.getSelectedContents().getTxtTsuzukigara().getValue(),
                            div.getSelectedContents().getTxtTel().getValue(),
                            div.getSelectedContents().getTxtKeitaiNo().getValue(),
                            div.getSelectedContents().getTxtShimeiKana().getValue(),
                            div.getSelectedContents().getTxtYubinNo().getText(),
                            div.getSelectedContents().getTxtJusho().getValue()
                    ));
                    div.getDgRenrakusaki().setDataSource(renrakusakiList);

                    List<dgRenrakusaki_Row> selectRenrakusakiList = new ArrayList<>();
                    selectRenrakusakiList.add(div.getDgRenrakusaki().getDataSource().get(
                            div.getDgRenrakusaki().getTotalRecords() - 1));
                    div.getDgRenrakusaki().setSelectedItems(selectRenrakusakiList);

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

                    div.getDgRenrakusaki().getSelectedItems().get(0).setTsuzukigara(
                            div.getSelectedContents().getTxtTsuzukigara().getValue());

                }
                if (div.getDgRenrakusaki().getTotalRecords() >= MAX_ROW) {
                    div.getBtnAdd().setDisabled(true);
                } else {
                    div.getBtnAdd().setDisabled(false);
                }

                div.getBtnDelete().setDisabled(false);
            }
        }

        response.data = div;
        return response;
    }

    private boolean chkInputJoho(KaigoRenrakusakiInfoDiv div) {

        if ((div.getSelectedContents().getTxtShimei().getValue().isEmpty())
                || (div.getSelectedContents().getTxtShimeiKana().getValue().isEmpty())
                || (div.getSelectedContents().getTxtTel().getValue().isEmpty())
                || (div.getSelectedContents().getTxtKeitaiNo().getValue().isEmpty())
                || (div.getSelectedContents().getTxtYubinNo().getText().isEmpty())
                || (div.getSelectedContents().getTxtJusho().getValue().isEmpty())
                || (div.getSelectedContents().getTxtTsuzukigara().getValue().isEmpty())) {
            return false;
        } else {
            return true;
        }

    }
}
