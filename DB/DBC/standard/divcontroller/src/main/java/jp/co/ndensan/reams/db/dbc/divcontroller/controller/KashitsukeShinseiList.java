/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinList.dgKyufuhiKashitsukekinList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付費貸付金申請登録の給付費貸付金一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KashitsukeShinseiList {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc1800000/KashitsukeShinseiList.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiListDiv> onLoad(KashitsukeShinseiListDiv panel) {
        setKashitsukeShinseiListData(panel);
        ControlGenerator cg = new ControlGenerator(getYaml().get(4));
        panel.getKashitsukeShinseisho().getKyufuhiKariireShinseishoPrintSetting().getTxtIssueDate().
                setValue(new RDate(cg.getAsRString("発効日").toString()));

        ResponseData<KashitsukeShinseiListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * 申請書一覧で行の「削除」を押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiListDiv> onClickDelete(KashitsukeShinseiListDiv panel) {
        List<dgKyufuhiKashitsukekinList_Row> dgList = panel.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource();
        int index = panel.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getClickedRowId();

        dgKyufuhiKashitsukekinList_Row row = dgList.get(index);
        row.setRowState(RowState.Deleted);
        dgList.remove(index);
        dgList.add(index, row);

        ResponseData<KashitsukeShinseiListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * 給付費貸付金申請情報で「入力内容を確定する」を押下したときの給付費貸付金一覧パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiListDiv> onClickKashitsukeKakutei(KashitsukeShinseiListDiv panel) {
        RString selectedIndex = (RString) ViewStateHolder.get("selectedIndex", RString.class);
        List<dgKyufuhiKashitsukekinList_Row> dgRowList = panel.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource();
        if (selectedIndex.equals(new RString("-1"))) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(3));
            dgKyufuhiKashitsukekinList_Row row = create給付費貸付金一覧アイテム(
                    cg.getAsRString("被保番号"),
                    cg.getAsRString("被保険者氏名"),
                    cg.getAsRString("被保険者カナ"),
                    cg.getAsRString("借入受付日"),
                    cg.getAsRString("借入申請日"),
                    cg.getAsRString("借入利用開始日"),
                    cg.getAsRString("借入利用終了日"),
                    cg.getAsRString("貸付対象サービス種類"),
                    cg.getAsRString("事業者の支払請求額"),
                    cg.getAsRString("申請金額"),
                    cg.getAsRString("貸付審査決定日"),
                    cg.getAsRString("貸付承認不承認"),
                    cg.getAsRString("借受日"),
                    cg.getAsRString("償還期限延長申請日"));
            row.setRowState(RowState.Added);
            dgRowList.add(row);
        } else {
            int index = Integer.parseInt(selectedIndex.toString());
            dgKyufuhiKashitsukekinList_Row row = dgRowList.get(index);
            row.setRowState(RowState.Modified);
            dgRowList.remove(index);
            dgRowList.add(index, row);
        }
        Collections.sort(dgRowList, new DateComparator());

        ResponseData<KashitsukeShinseiListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private static class DateComparator implements Comparator<dgKyufuhiKashitsukekinList_Row> {

        @Override
        public int compare(dgKyufuhiKashitsukekinList_Row o1, dgKyufuhiKashitsukekinList_Row o2) {
            return new FlexibleDate(o2.getTxtUketsukeYMD().replace(".", "")).compareTo(new FlexibleDate(o1.getTxtUketsukeYMD().replace(".", "")));
        }
    }

    private void setKashitsukeShinseiListData(KashitsukeShinseiListDiv panel) {

        List<HashMap> sourceList = getYaml();
        DataGrid<dgKyufuhiKashitsukekinList_Row> dgRow = panel.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList();
        List<dgKyufuhiKashitsukekinList_Row> dgRowList = dgRow.getDataSource();

        for (int i = 0; i < 3; i++) {
            ControlGenerator cg = new ControlGenerator(sourceList.get(i));
            dgRowList.add(create給付費貸付金一覧アイテム(
                    cg.getAsRString("被保番号"),
                    cg.getAsRString("被保険者氏名"),
                    cg.getAsRString("被保険者カナ"),
                    cg.getAsRString("借入受付日"),
                    cg.getAsRString("借入申請日"),
                    cg.getAsRString("借入利用開始日"),
                    cg.getAsRString("借入利用終了日"),
                    cg.getAsRString("貸付対象サービス種類"),
                    cg.getAsRString("事業者の支払請求額"),
                    cg.getAsRString("申請金額"),
                    cg.getAsRString("貸付審査決定日"),
                    cg.getAsRString("貸付承認不承認"),
                    cg.getAsRString("借受日"),
                    cg.getAsRString("償還期限延長申請日")
            ));
        }
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
        Button btnSelect = new Button();
        Button btnDelete = new Button();
        dgKyufuhiKashitsukekinList_Row item = new dgKyufuhiKashitsukekinList_Row(
                btnSelect,
                btnDelete,
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
