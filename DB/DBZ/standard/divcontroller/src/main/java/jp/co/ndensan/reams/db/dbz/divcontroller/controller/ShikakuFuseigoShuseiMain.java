/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShikakuFuseigoIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShikakuFuseigoShuseiMainDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShikakuShuseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgShikakuFuseigoIchiran_Row;
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
 * @author N1319
 */
public class ShikakuFuseigoShuseiMain {

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
        response.data = panel;
        return response;
    }

    private void setFuseigoData(ShikakuFuseigoIchiranDiv panel) {
        List<dgShikakuFuseigoIchiran_Row> arrayData = createRowShikakuFuseigoTestData();
        DataGrid<dgShikakuFuseigoIchiran_Row> grid = panel.getDgShikakuFuseigoIchiran();
        grid.setDataSource(arrayData);
    }

    private List<dgShikakuFuseigoIchiran_Row> createRowShikakuFuseigoTestData() {
        List<dgShikakuFuseigoIchiran_Row> arrayData = new ArrayList<>();
        dgShikakuFuseigoIchiran_Row item;

        List<HashMap> demoDataList = YamlLoader.FOR_DBZ.loadAsList(new RString("ShikakuFuseigoData.yml"));
        for (HashMap demoData : demoDataList) {
            item = createRowShikakuFuseigoData(
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
                    demoData.get("資格喪失届出日").toString());
            arrayData.add(item);
        }
        return arrayData;
    }

    private dgShikakuFuseigoIchiran_Row createRowShikakuFuseigoData(String 被保番号, String 識別コード, String カナ氏名, String 氏名, String 住民種別,
            String 生年月日, String 性別, String 年齢, String 不整合内容, String 住登事由, String 住登日, String 資格取得事由, String 資格取得日,
            String 消除事由, String 消除日, String 資格喪失事由, String 資格喪失日, String 住基登録届出日, String 住基消除届出日, String 資格取得届出日, String 資格喪失届出日) {
        dgShikakuFuseigoIchiran_Row row = new dgShikakuFuseigoIchiran_Row(false, new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate());

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

        createRowKetsugo(row);
        return row;
    }

    /*
     データグリッド内に挿入する際に二行として表示させるための成型メソッドです。
     */
    private void createRowKetsugo(dgShikakuFuseigoIchiran_Row row) {
        row.setTxtKetsugo01(row.getTxtHihoNo().concat(new RString("<br>")).concat(row.getTxtShikibetsuCode()).concat(new RString("  ")));
        row.setTxtKetsugo02(row.getTxtKanaShimei().concat(new RString("<br>")).concat(row.getTxtShimei()).concat(new RString("  ")));
        row.setTxtKetsugo03(row.getTxtJuminShu().concat(new RString("<br>")).concat(new FlexibleDate(row.getTxtSeiYmd().getValue().toString()).wareki().toDateString()).concat(new RString("  ")));
        row.setTxtKetsugo04(row.getTxtSeibetsu().concat(new RString("<br>")).concat(row.getTxtNenrei()).concat(new RString("  ")));
        row.setTxtKetsugo05(row.getTxtJukiTorokuJiyu().concat(new RString("<br>")).concat(row.getTxtShikakuShutokuJiyu()).concat(new RString("  ")));
        row.setTxtKetsugo06(new FlexibleDate(row.getTxtJukiTorokuYmd().getValue().toString()).wareki().toDateString().concat(new RString("<br>")).concat(new FlexibleDate(row.getTxtShikakuShutokuYmd().getValue().toString()).wareki().toDateString()).concat(new RString("  ")));
        row.setTxtKetsugo07(row.getTxtJukiShojoJiyu().concat(new RString("<br>")).concat(row.getTxtShikakuSoshitsuJiyu()).concat(new RString("  ")));
        row.setTxtKetsugo06(new FlexibleDate(row.getTxtJukiShojoYmd().getValue().toString()).wareki().toDateString().concat(new RString("<br>")).concat(new FlexibleDate(row.getTxtShikakuSoshitsuYmd().getValue().toString()).wareki().toDateString()).concat(new RString("  ")));

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

        List<dgShikakuFuseigoIchiran_Row> selectRow = panel.getShikakuFuseigoIchiran().getDgShikakuFuseigoIchiran().getDataSource();
        ShikakuShuseiDiv shuseiPanel = panel.getShikakuShusei();
        for (dgShikakuFuseigoIchiran_Row row : selectRow) {
            if (row.getSelected()) {
                row.setTxtShikakuShutokuJiyu(shuseiPanel.getShutokuKei().getDdlShikakuShutokuJiyu().getSelectedValue());
                createRowKetsugo(row);
            }
        }
        panel.getShikakuFuseigoIchiran().getDgShikakuFuseigoIchiran().setDataSource(selectRow);
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
        DdlShikakuShutokuJiyu.select(panel.getShikakuShusei().getShutokuKei().getDdlShikakuShutokuJiyu(), ShikakuShutokuJiyu.toValue(new RString("01")));
        DdlShikakuSoshitsuJiyu.onLoad(panel.getShikakuShusei().getSoushitsuKei().getDdlShikakuSoshitsuJiyu());
        DdlShikakuSoshitsuJiyu.select(panel.getShikakuShusei().getSoushitsuKei().getDdlShikakuSoshitsuJiyu(), ShikakuSoshitsuJiyu.toValue(new RString("51")));
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
    }

    private static final class DdlShikakuSoshitsuJiyu {

        private DdlShikakuSoshitsuJiyu() {
        }

        public static void onLoad(DropDownList ddl) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (ShikakuSoshitsuJiyu jiyu : ShikakuSoshitsuJiyu.values()) {
                dataSource.add(new KeyValueDataSource(jiyu.getCode(), jiyu.getName()));
            }
            ddl.setDataSource(dataSource);
        }

        public static void select(DropDownList ddl, ShikakuSoshitsuJiyu jiyu) {
            ddl.setSelectedItem(jiyu.getCode());
        }
    }

}
