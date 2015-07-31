/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1800000.KashitsukeShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1800000.KashitsukeShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuhiKashitsukekinList.dgKyufuhiKashitsukekinList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 給付費貸付金申請登録の給付費貸付金一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KashitsukeShinseiList {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiTorokuDiv> onLoad(KashitsukeShinseiTorokuDiv panel) {
        setKashitsukeShinseiListData(panel.getKashitsukeShinseiList());
//        ControlGenerator cg = new ControlGenerator(getYaml().get(4));
//        panel.getKashitsukeShinseiList().getKashitsukeShinseisho().getKyufuhiKariireShinseishoPrintSetting().getTxtIssueDate().
//                setValue(new RDate(cg.getAsRString("発効日").toString()));

        return ResponseData.of(panel).respond();
    }

    /**
     * 申請書一覧で行の「削除」を押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiTorokuDiv> onClickDelete(KashitsukeShinseiTorokuDiv panel) {
        List<dgKyufuhiKashitsukekinList_Row> dgList = panel.getKashitsukeShinseiList().getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource();
        int index = panel.getKashitsukeShinseiList().getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getClickedRowId();

        dgKyufuhiKashitsukekinList_Row row = dgList.get(index);
        row.setRowState(RowState.Deleted);
        dgList.remove(index);
        dgList.add(index, row);

        return ResponseData.of(panel).respond();
    }

    /**
     * 給付費貸付金申請情報で「入力内容を確定する」を押下したときの給付費貸付金一覧パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiTorokuDiv> onClickKashitsukeKakutei(KashitsukeShinseiTorokuDiv panel) {
//        RString selectedIndex = (RString) ViewStateHolder.get("selectedIndex", RString.class);
//        List<dgKyufuhiKashitsukekinList_Row> dgRowList = panel.getKashitsukeShinseiList().getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource();
//        if (selectedIndex.equals(new RString("-1"))) {
//            ControlGenerator cg = new ControlGenerator(getYaml().get(3));
//            dgKyufuhiKashitsukekinList_Row row = create給付費貸付金一覧アイテム(
//                    cg.getAsRString("被保番号"),
//                    cg.getAsRString("被保険者氏名"),
//                    cg.getAsRString("被保険者カナ"),
//                    panel.getKashitsukeShinseiInfo().getTxtUketsukeYMD().getText(),
//                    panel.getKashitsukeShinseiInfo().getTxtShinseiYMD().getText(),
//                    panel.getKashitsukeShinseiInfo().getTxtRiyoKikan().getFromText(),
//                    panel.getKashitsukeShinseiInfo().getTxtRiyoKikan().getToText(),
//                    cg.getAsRString("貸付対象サービス種類"),
//                    cg.getAsRString("事業者の支払請求額"),
//                    cg.getAsRString("申請金額"),
//                    RString.EMPTY,
//                    RString.EMPTY,
//                    RString.EMPTY,
//                    RString.EMPTY);
//            row.setRowState(RowState.Added);
//            dgRowList.add(row);
//        } else {
//            int index = Integer.parseInt(selectedIndex.toString());
//            dgKyufuhiKashitsukekinList_Row row = dgRowList.get(index);
//            row.setRowState(RowState.Modified);
//            dgRowList.remove(index);
//            dgRowList.add(index, row);
//        }
//        Collections.sort(dgRowList, new DateComparator());

        return ResponseData.of(panel).respond();
    }

    private static class DateComparator implements Comparator<dgKyufuhiKashitsukekinList_Row> {

        @Override
        public int compare(dgKyufuhiKashitsukekinList_Row o1, dgKyufuhiKashitsukekinList_Row o2) {
            return new FlexibleDate(o2.getTxtUketsukeYMD().replace(".", "")).compareTo(new FlexibleDate(o1.getTxtUketsukeYMD().replace(".", "")));
        }
    }

    private void setKashitsukeShinseiListData(KashitsukeShinseiListDiv panel) {

        DataGrid<dgKyufuhiKashitsukekinList_Row> dgRow = panel.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList();
        List<dgKyufuhiKashitsukekinList_Row> dgRowList = dgRow.getDataSource();
        dgRowList.add(new dgKyufuhiKashitsukekinList_Row());
    }

    private dgKyufuhiKashitsukekinList_Row create給付費貸付金一覧アイテム(
            RString txtHihoNo,
            RString txtHihokenshaName,
            RString txtHihokenshaKana,
            RString txtUketsukeYMD,
            RString txtShinseiYMD,
            RString txtKaishiYMD,
            RString txtShuryoYMD,
            RString txtServiceShurui,
            RString txtSeikyugaku,
            RString txtShinseigaku,
            RString txtKetteiYMD,
            RString txtShonin,
            RString txtKariukeYMD,
            RString txtEnchoShinseiYMD
    ) {
        dgKyufuhiKashitsukekinList_Row item = new dgKyufuhiKashitsukekinList_Row(
                txtHihoNo,
                txtHihokenshaName,
                txtHihokenshaKana,
                txtUketsukeYMD,
                txtShinseiYMD,
                txtKaishiYMD,
                txtShuryoYMD,
                txtServiceShurui,
                txtSeikyugaku,
                txtShinseigaku,
                txtKetteiYMD,
                txtShonin,
                txtKariukeYMD,
                txtEnchoShinseiYMD
        );
        return item;
    }
}
