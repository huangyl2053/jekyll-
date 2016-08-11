/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.ShikakuFuseigoIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.ShikakuFuseigoShuseiMainDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dgShikakuFuseigoIchiranForDemo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.dgShikakuFuseigoIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author N1319 荻原 宏二
 */
public class ShikakuFuseigoShuseiMain {

    private static final List<dgShikakuFuseigoIchiran_Row> ROWS = new ArrayList<>();
    private static final List<dgShikakuFuseigoIchiranForDemo_Row> KAKUSHI_ROWS = new ArrayList<>();
    private static final RString BR = new RString("<br>");
    private static final RString SPACE = new RString("  ");

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param panel 資格不整合一覧Div
     * @return 資格不整合一覧DivのResponseData
     */
    //TODO N1319荻原　宏二 各種DB項目はDBアクセスが可能になった時点でデータの取得部分を差し替える。
    public ResponseData<ShikakuFuseigoShuseiMainDiv> getOnLoadData(ShikakuFuseigoShuseiMainDiv panel) {
        ResponseData<ShikakuFuseigoShuseiMainDiv> response = new ResponseData<>();
        setFuseigoData(panel.getShikakuFuseigoIchiran());
        onChange_chkMushi(panel);
        response.data = panel;
        return response;
    }

    private void setFuseigoData(ShikakuFuseigoIchiranDiv panel) {
        List<dgShikakuFuseigoIchiranForDemo_Row> arrayData = createRowShikakuFuseigoTestData();
        DataGrid<dgShikakuFuseigoIchiranForDemo_Row> grid = panel.getDgShikakuFuseigoIchiranForDemo();
        grid.setDataSource(arrayData);
    }

    private List<dgShikakuFuseigoIchiranForDemo_Row> createRowShikakuFuseigoTestData() {
        dgShikakuFuseigoIchiranForDemo_Row kakushiItem;

        KAKUSHI_ROWS.clear();

        List<HashMap> demoDataList = YamlLoader.DBZ.loadAsList(new RString("DBZA010001/ShikakuFuseigoData.yml"));
        for (HashMap demoData : demoDataList) {
            kakushiItem = createRowShikakuFuseigoDataForDemo(
                    demoData.get("無視判定").toString(),
                    demoData.get("修正済").toString(),
                    demoData.get("被保番号").toString(),
                    demoData.get("識別コード").toString(),
                    demoData.get("カナ氏名").toString(),
                    demoData.get("氏名").toString(),
                    demoData.get("住民種別").toString(),
                    demoData.get("生年月日").toString(),
                    demoData.get("性別").toString(),
                    demoData.get("年齢").toString(),
                    demoData.get("不整合内容").toString(),
                    demoData.get("住登事由").toString(),
                    demoData.get("住登日").toString(),
                    demoData.get("資格取得事由").toString(),
                    demoData.get("資格取得日").toString(),
                    demoData.get("消除事由").toString(),
                    demoData.get("消除日").toString(),
                    demoData.get("資格喪失事由").toString(),
                    demoData.get("資格喪失日").toString(),
                    demoData.get("住基登録届出日").toString(),
                    demoData.get("住基消除届出日").toString(),
                    demoData.get("資格取得届出日").toString(),
                    demoData.get("資格喪失届出日").toString(),
                    demoData.get("デモ用主キー").toString());
            KAKUSHI_ROWS.add(kakushiItem);
        }

        return KAKUSHI_ROWS;
    }

    private dgShikakuFuseigoIchiran_Row createRowShikakuFuseigoData(String 無視判定, String 修正済, String 被保番号, String 識別コード,
            String カナ氏名, String 氏名, String 住民種別, String 生年月日, String 性別, String 年齢,
            String 不整合内容, String 住登事由, String 住登日, String 資格取得事由, String 資格取得日, String 消除事由, String 消除日,
            String 資格喪失事由, String 資格喪失日, String 住基登録届出日, String 住基消除届出日, String 資格取得届出日, String 資格喪失届出日,
            String デモ用主キー) {
        dgShikakuFuseigoIchiran_Row row = new dgShikakuFuseigoIchiran_Row(RString.EMPTY, new Button(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY);

        row.setTxtIgnore(new RString(無視判定));
        row.setTxtShuseiZumi(new RString(修正済));
        row.setTxtHihoNo(new RString(被保番号));
        row.setTxtShikibetsuCode(new RString(識別コード));
        row.setTxtKanaShimei(new RString(カナ氏名));
        row.setTxtShimei(new RString(氏名));
        row.setTxtJuminShu(new RString(住民種別));
        row.getTxtSeiYmd().setValue(new FlexibleDate((new RString(生年月日))));
        row.setTxtSeibetsu(new RString(性別));
        row.setTxtNenrei(new RString(年齢));
        row.setTxtFuseigo(new RString(不整合内容));
        row.setTxtJukiTorokuJiyu(new RString(住登事由));
        row.setTxtShikakuShutokuJiyu(new RString(資格取得事由));
        row.getTxtJukiTorokuYmd().setValue(new FlexibleDate(new RString(住登日)));
        row.getTxtShikakuShutokuYmd().setValue(new FlexibleDate(new RString(資格取得日)));
        row.setTxtJukiShojoJiyu(new RString(消除事由));
        row.setTxtShikakuSoshitsuJiyu(new RString(資格喪失事由));
        row.getTxtJukiShojoYmd().setValue(new FlexibleDate(new RString(消除日)));
        row.getTxtShikakuSoshitsuYmd().setValue(new FlexibleDate(new RString(資格喪失日)));
        row.getTxtJukiTorokuTodokedeYmd().setValue(new FlexibleDate(new RString(住基登録届出日)));
        row.getTxtJukiShojoTodokedeYmd().setValue(new FlexibleDate(new RString(住基消除届出日)));
        row.getTxtShikakuShutokuTodokedeYmd().setValue(new FlexibleDate(new RString(資格取得届出日)));
        row.getTxtShikakuSoshitsuTodokedeYmd().setValue(new FlexibleDate(new RString(資格喪失届出日)));
        row.setTxtDemoKey(new RString(デモ用主キー));

        createRowKetsugo(row);
        return row;
    }

    private dgShikakuFuseigoIchiranForDemo_Row createRowShikakuFuseigoDataForDemo(String 無視判定, String 修正済, String 被保番号, String 識別コード,
            String カナ氏名, String 氏名, String 住民種別, String 生年月日, String 性別, String 年齢,
            String 不整合内容, String 住登事由, String 住登日, String 資格取得事由, String 資格取得日, String 消除事由, String 消除日,
            String 資格喪失事由, String 資格喪失日, String 住基登録届出日, String 住基消除届出日, String 資格取得届出日, String 資格喪失届出日,
            String デモ用主キー) {
        dgShikakuFuseigoIchiranForDemo_Row row = new dgShikakuFuseigoIchiranForDemo_Row(RString.EMPTY, new Button(), RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY);

        row.setTxtIgnore(new RString(無視判定));
        row.setTxtShuseiZumi(new RString(修正済));
        row.setTxtHihoNo(new RString(被保番号));
        row.setTxtShikibetsuCode(new RString(識別コード));
        row.setTxtKanaShimei(new RString(カナ氏名));
        row.setTxtShimei(new RString(氏名));
        row.setTxtJuminShu(new RString(住民種別));
        row.getTxtSeiYmd().setValue(new FlexibleDate((new RString(生年月日))));
        row.setTxtSeibetsu(new RString(性別));
        row.setTxtNenrei(new RString(年齢));
        row.setTxtFuseigo(new RString(不整合内容));
        row.setTxtJukiTorokuJiyu(new RString(住登事由));
        row.setTxtShikakuShutokuJiyu(new RString(資格取得事由));
        row.getTxtJukiTorokuYmd().setValue(new FlexibleDate(new RString(住登日)));
        row.getTxtShikakuShutokuYmd().setValue(new FlexibleDate(new RString(資格取得日)));
        row.setTxtJukiShojoJiyu(new RString(消除事由));
        row.setTxtShikakuSoshitsuJiyu(new RString(資格喪失事由));
        row.getTxtJukiShojoYmd().setValue(new FlexibleDate(new RString(消除日)));
        row.getTxtShikakuSoshitsuYmd().setValue(new FlexibleDate(new RString(資格喪失日)));
        row.getTxtJukiTorokuTodokedeYmd().setValue(new FlexibleDate(new RString(住基登録届出日)));
        row.getTxtJukiShojoTodokedeYmd().setValue(new FlexibleDate(new RString(住基消除届出日)));
        row.getTxtShikakuShutokuTodokedeYmd().setValue(new FlexibleDate(new RString(資格取得届出日)));
        row.getTxtShikakuSoshitsuTodokedeYmd().setValue(new FlexibleDate(new RString(資格喪失届出日)));
        row.setTxtDemoKey(new RString(デモ用主キー));

        createRowKetsugoForDemo(row);
        return row;
    }

    /*
     データグリッド内に挿入する際に二行として表示させるための成型メソッドです。
     */
    private void createRowKetsugo(dgShikakuFuseigoIchiran_Row row) {
        row.setTxtKetsugo01(row.getTxtHihoNo().concat(BR)
                .concat(row.getTxtShikibetsuCode()).concat(SPACE));
        row.setTxtKetsugo02(row.getTxtKanaShimei().concat(BR)
                .concat(row.getTxtShimei()).concat(SPACE));
        row.setTxtKetsugo03(row.getTxtJuminShu().concat(BR)
                .concat(new FlexibleDate(row.getTxtSeiYmd().getValue().toString()).wareki().toDateString()).concat(SPACE));
        row.setTxtKetsugo04(row.getTxtSeibetsu().concat(BR)
                .concat(row.getTxtNenrei()).concat(SPACE));
        row.setTxtKetsugo05(row.getTxtJukiTorokuJiyu().concat(BR)
                .concat(row.getTxtShikakuShutokuJiyu()).concat(SPACE));
        row.setTxtKetsugo06(new FlexibleDate(row.getTxtJukiTorokuYmd().getValue().toString()).wareki().toDateString().concat(BR)
                .concat(new FlexibleDate(row.getTxtShikakuShutokuYmd().getValue().toString()).wareki().toDateString()).concat(SPACE));
        row.setTxtKetsugo07(row.getTxtJukiShojoJiyu().concat(BR)
                .concat(row.getTxtShikakuSoshitsuJiyu()).concat(SPACE));
        row.setTxtKetsugo08(new FlexibleDate(row.getTxtJukiShojoYmd().getValue().toString()).wareki().toDateString().concat(BR)
                .concat(new FlexibleDate(row.getTxtShikakuSoshitsuYmd().getValue().toString()).wareki().toDateString()).concat(SPACE));
    }

    private void createRowKetsugoForDemo(dgShikakuFuseigoIchiranForDemo_Row row) {
        row.setTxtKetsugo01(row.getTxtHihoNo().concat(BR)
                .concat(row.getTxtShikibetsuCode()).concat(SPACE));
        row.setTxtKetsugo02(row.getTxtKanaShimei().concat(BR)
                .concat(row.getTxtShimei()).concat(SPACE));
        row.setTxtKetsugo03(row.getTxtJuminShu().concat(BR)
                .concat(new FlexibleDate(row.getTxtSeiYmd().getValue().toString()).wareki().toDateString()).concat(SPACE));
        row.setTxtKetsugo04(row.getTxtSeibetsu().concat(BR)
                .concat(row.getTxtNenrei()).concat(SPACE));
        row.setTxtKetsugo05(row.getTxtJukiTorokuJiyu().concat(BR)
                .concat(row.getTxtShikakuShutokuJiyu()).concat(SPACE));
        row.setTxtKetsugo06(new FlexibleDate(row.getTxtJukiTorokuYmd().getValue().toString()).wareki().toDateString().concat(BR)
                .concat(new FlexibleDate(row.getTxtShikakuShutokuYmd().getValue().toString()).wareki().toDateString()).concat(SPACE));
        row.setTxtKetsugo07(row.getTxtJukiShojoJiyu().concat(BR)
                .concat(row.getTxtShikakuSoshitsuJiyu()).concat(SPACE));
        row.setTxtKetsugo08(new FlexibleDate(row.getTxtJukiShojoYmd().getValue().toString()).wareki().toDateString().concat(BR)
                .concat(new FlexibleDate(row.getTxtShikakuSoshitsuYmd().getValue().toString()).wareki().toDateString()).concat(SPACE));
    }

    /**
     * データグリッド内のボタン押下時の処理です。
     *
     * @param panel ShikakuFuseigoIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onClick_BtnDecide(ShikakuFuseigoShuseiMainDiv panel) {
        ResponseData<ShikakuFuseigoShuseiMainDiv> response = new ResponseData<>();
        setSelectRowDataToShusei(panel);
        response.data = panel;
        return response;
    }

    /**
     * 資格修正に関し確定ボタン押下時の処理です。
     *
     * @param panel ShikakuFuseigoIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onClick_BtnCommit(ShikakuFuseigoShuseiMainDiv panel) {
        ResponseData<ShikakuFuseigoShuseiMainDiv> response = new ResponseData<>();
        RString selectedRow = panel.getShikakuShusei().getTxtSelectedRow().getValue();
        for (dgShikakuFuseigoIchiranForDemo_Row row : KAKUSHI_ROWS) {
            if (row.getTxtDemoKey().equals(selectedRow)) {
                if (!panel.getShikakuShusei().getChkMushi().getSelectedItems().isEmpty()) {
                    row.setTxtIgnore(new RString("無視"));
                } else {
                    row.setTxtIgnore(new RString(""));
                }
                row.setTxtShuseiZumi(new RString("修正済"));
                row.setTxtShikakuShutokuJiyu(panel.getShikakuShusei().getShutokuKei().getDdlShikakuShutokuJiyu().getSelectedValue());
                row.setTxtShikakuShutokuYmd(panel.getShikakuShusei().getShutokuKei().getTxtShikakuShutokuYmd());
                row.setTxtShikakuShutokuTodokedeYmd(panel.getShikakuShusei().getShutokuKei().getTxtShutokuTodokedeYmd());
                row.setTxtShikakuSoshitsuJiyu(panel.getShikakuShusei().getSoushitsuKei().getDdlShikakuSoshitsuJiyu().getSelectedValue());
                row.setTxtShikakuSoshitsuYmd(panel.getShikakuShusei().getSoushitsuKei().getTxtShikakuSoshitsuYmd());
                row.setTxtShikakuSoshitsuTodokedeYmd(panel.getShikakuShusei().getSoushitsuKei().getTxtSoshitsuTodokedeYmd());
                createRowKetsugoForDemo(row);
            }
        }

        onChange_chkMushi(panel);

        response.data = panel;
        return response;
    }

    /**
     * 実際に画面に表示されているDataGridに表示するデータを返す（無視を含むデータ）。
     *
     * @param panel
     */
    private void showDataIncludedMushi(ShikakuFuseigoShuseiMainDiv panel) {
        //dgShikakuFuseigoIchiran_Row row;
        ROWS.clear();
        for (dgShikakuFuseigoIchiranForDemo_Row temp : KAKUSHI_ROWS) {
            ROWS.add(createRowShikakuFuseigoData(
                    temp.getTxtIgnore().toString(),
                    temp.getTxtShuseiZumi().toString(),
                    temp.getTxtHihoNo().toString(),
                    temp.getTxtShikibetsuCode().toString(),
                    temp.getTxtKanaShimei().toString(),
                    temp.getTxtShimei().toString(),
                    temp.getTxtJuminShu().toString(),
                    temp.getTxtSeiYmd().getValue().toString(),
                    temp.getTxtSeibetsu().toString(),
                    temp.getTxtNenrei().toString(),
                    temp.getTxtFuseigo().toString(),
                    temp.getTxtJukiTorokuJiyu().toString(),
                    temp.getTxtJukiTorokuYmd().getValue().toString(),
                    temp.getTxtShikakuShutokuJiyu().toString(),
                    temp.getTxtShikakuShutokuYmd().getValue().toString(),
                    temp.getTxtJukiShojoJiyu().toString(),
                    temp.getTxtJukiShojoYmd().getValue().toString(),
                    temp.getTxtShikakuSoshitsuJiyu().toString(),
                    temp.getTxtShikakuSoshitsuYmd().getValue().toString(),
                    temp.getTxtJukiTorokuTodokedeYmd().getValue().toString(),
                    temp.getTxtJukiShojoTodokedeYmd().getValue().toString(),
                    temp.getTxtShikakuShutokuTodokedeYmd().getValue().toString(),
                    temp.getTxtShikakuSoshitsuTodokedeYmd().getValue().toString(),
                    temp.getTxtDemoKey().toString()));
        }
        DataGrid<dgShikakuFuseigoIchiran_Row> grid = panel.getShikakuFuseigoIchiran().getDgShikakuFuseigoIchiran();
        grid.setDataSource(ROWS);
    }

    /**
     * 実際に画面に表示されているDataGridに表示するデータを返す（無視は除くデータ）。
     *
     * @param panel
     */
    private void showDataNotIncludedMushi(ShikakuFuseigoShuseiMainDiv panel) {
        //dgShikakuFuseigoIchiran_Row row;
        ROWS.clear();
        for (dgShikakuFuseigoIchiranForDemo_Row temp : KAKUSHI_ROWS) {
            if (!temp.getTxtIgnore().equals(new RString("無視"))) {
                ROWS.add(createRowShikakuFuseigoData(
                        temp.getTxtIgnore().toString(),
                        temp.getTxtShuseiZumi().toString(),
                        temp.getTxtHihoNo().toString(),
                        temp.getTxtShikibetsuCode().toString(),
                        temp.getTxtKanaShimei().toString(),
                        temp.getTxtShimei().toString(),
                        temp.getTxtJuminShu().toString(),
                        temp.getTxtSeiYmd().getValue().toString(),
                        temp.getTxtSeibetsu().toString(),
                        temp.getTxtNenrei().toString(),
                        temp.getTxtFuseigo().toString(),
                        temp.getTxtJukiTorokuJiyu().toString(),
                        temp.getTxtJukiTorokuYmd().getValue().toString(),
                        temp.getTxtShikakuShutokuJiyu().toString(),
                        temp.getTxtShikakuShutokuYmd().getValue().toString(),
                        temp.getTxtJukiShojoJiyu().toString(),
                        temp.getTxtJukiShojoYmd().getValue().toString(),
                        temp.getTxtShikakuSoshitsuJiyu().toString(),
                        temp.getTxtShikakuSoshitsuYmd().getValue().toString(),
                        temp.getTxtJukiTorokuTodokedeYmd().getValue().toString(),
                        temp.getTxtJukiShojoTodokedeYmd().getValue().toString(),
                        temp.getTxtShikakuShutokuTodokedeYmd().getValue().toString(),
                        temp.getTxtShikakuSoshitsuTodokedeYmd().getValue().toString(),
                        temp.getTxtDemoKey().toString()));
            }
        }
        DataGrid<dgShikakuFuseigoIchiran_Row> grid = panel.getShikakuFuseigoIchiran().getDgShikakuFuseigoIchiran();
        grid.setDataSource(ROWS);
    }

    /**
     * 無視チェックボックスの値が替わったとき。
     *
     * @param panel ShikakuFuseigoShuseiMainDiv
     * @return ResponseData
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onChange_chkMushi(ShikakuFuseigoShuseiMainDiv panel) {
        ResponseData<ShikakuFuseigoShuseiMainDiv> response = new ResponseData<>();
        //DataGrid<dgShikakuFuseigoIchiran_Row> grid = panel.getShikakuFuseigoIchiran().getDgShikakuFuseigoIchiran();
        if (panel.getShikakuFuseigoIchiran().getChkMushiBunHihyoji().getSelectedItems().isEmpty()) { // 無視するデータも含む場合
            showDataIncludedMushi(panel);
        } else {
            showDataNotIncludedMushi(panel);
        }
        response.data = panel;
        return response;
    }

    private void setSelectRowDataToShusei(ShikakuFuseigoShuseiMainDiv panel) {
        dgShikakuFuseigoIchiran_Row selectRow = clickedItemOf(panel.getShikakuFuseigoIchiran());
        panel.getShikakuShusei().getTxtFusugoNaiyo().setValue(selectRow.getTxtFuseigo());
        panel.getShikakuShusei().getTxtHihoNo().setValue(selectRow.getTxtHihoNo());
        panel.getShikakuShusei().getTxtShikibetsuCode().setValue(selectRow.getTxtShikibetsuCode());
        panel.getShikakuShusei().getTxtShimei().setValue(selectRow.getTxtShimei());
        panel.getShikakuShusei().getTxtJuminShubetsu().setValue(selectRow.getTxtJuminShu());
        panel.getShikakuShusei().getTxtSeibetsu().setValue(selectRow.getTxtSeibetsu());
        panel.getShikakuShusei().getTxtUmareYmd().setValue(selectRow.getTxtSeiYmd().getValue());
        panel.getShikakuShusei().getTxtNenrei().setValue(selectRow.getTxtNenrei());

        panel.getShikakuShusei().getShutokuKei().getTxtJukiTorokuJiyu().setValue(selectRow.getTxtJukiTorokuJiyu());
        panel.getShikakuShusei().getShutokuKei().getTxtTorokuIdoYmd().setValue(selectRow.getTxtJukiTorokuYmd().getValue());
        panel.getShikakuShusei().getShutokuKei().getTxtTorokuTodokedeYmd().setValue(selectRow.getTxtJukiTorokuTodokedeYmd().getValue());
        panel.getShikakuShusei().getShutokuKei().getTxtShikakuShutokuYmd().setValue(selectRow.getTxtShikakuShutokuYmd().getValue());
        panel.getShikakuShusei().getShutokuKei().getTxtShutokuTodokedeYmd().setValue(selectRow.getTxtShikakuShutokuTodokedeYmd().getValue());

        panel.getShikakuShusei().getSoushitsuKei().getTxtJukiShojoJiyu().setValue(selectRow.getTxtJukiShojoJiyu());
        panel.getShikakuShusei().getSoushitsuKei().getTxtShojoIdoYmd().setValue(selectRow.getTxtJukiShojoYmd().getValue());
        panel.getShikakuShusei().getSoushitsuKei().getTxtShojoTodokedeYmd().setValue(selectRow.getTxtJukiShojoTodokedeYmd().getValue());
        panel.getShikakuShusei().getSoushitsuKei().getTxtShikakuSoshitsuYmd().setValue(selectRow.getTxtShikakuSoshitsuYmd().getValue());
        panel.getShikakuShusei().getSoushitsuKei().getTxtSoshitsuTodokedeYmd().setValue(selectRow.getTxtShikakuSoshitsuTodokedeYmd().getValue());

        DdlShikakuShutokuJiyu.onLoad(panel.getShikakuShusei().getShutokuKei().getDdlShikakuShutokuJiyu());
        DdlShikakuShutokuJiyu.select(panel.getShikakuShusei().getShutokuKei().getDdlShikakuShutokuJiyu(),
                DdlShikakuShutokuJiyu.getShikakuShutokuJiyuCode(selectRow.getTxtShikakuShutokuJiyu()));
        DdlShikakuSoshitsuJiyu.onLoad(panel.getShikakuShusei().getSoushitsuKei().getDdlShikakuSoshitsuJiyu());
        DdlShikakuSoshitsuJiyu.select(panel.getShikakuShusei().getSoushitsuKei().getDdlShikakuSoshitsuJiyu(),
                DdlShikakuSoshitsuJiyu.getShikakuSoshitsuJiyuCode(selectRow.getTxtShikakuSoshitsuJiyu()));

        panel.getShikakuShusei().getTxtSelectedRow().setValue(selectRow.getTxtDemoKey());
    }

    private dgShikakuFuseigoIchiran_Row clickedItemOf(ShikakuFuseigoIchiranDiv fuseigoDiv) {
        return fuseigoDiv.getDgShikakuFuseigoIchiran().getClickedItem();

    }

    private static final class DdlShikakuShutokuJiyu {

        private DdlShikakuShutokuJiyu() {
        }

        public static void onLoad(DropDownList ddl) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (ShikakuShutokuJiyu jiyu : ShikakuShutokuJiyu.values()) {
                dataSource.add(new KeyValueDataSource(jiyu.getCode(), jiyu.getName()));
            }
            ddl.setDataSource(dataSource);
        }

        public static void select(DropDownList ddl, ShikakuShutokuJiyu jiyu) {
            ddl.setSelectedItem(jiyu.getCode());
        }

        public static ShikakuShutokuJiyu getShikakuShutokuJiyuCode(RString shikakuShutokuJiyu) {
            for (ShikakuShutokuJiyu jiyu : ShikakuShutokuJiyu.values()) {
                if (jiyu.getName().equals(shikakuShutokuJiyu)) {
                    return jiyu;
                }
            }
            return ShikakuShutokuJiyu.その他;
        }
    }

    private static final class DdlShikakuSoshitsuJiyu {

        private DdlShikakuSoshitsuJiyu() {
        }

        public static void onLoad(DropDownList ddl) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (ShikakuSoshitsuJiyu jiyu : ShikakuSoshitsuJiyu.values()) {
                dataSource.add(new KeyValueDataSource(jiyu.getコード(), jiyu.get名称()));
            }
            ddl.setDataSource(dataSource);
        }

        public static void select(DropDownList ddl, ShikakuSoshitsuJiyu jiyu) {
            ddl.setSelectedKey(jiyu.getコード());
        }

        public static ShikakuSoshitsuJiyu getShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyu) {
            for (ShikakuSoshitsuJiyu jiyu : ShikakuSoshitsuJiyu.values()) {
                if (jiyu.get名称().equals(shikakuSoshitsuJiyu)) {
                    return jiyu;
                }
            }
            return ShikakuSoshitsuJiyu.その他;
        }
    }
}
