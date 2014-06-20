/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaKekkaShosaiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaKekkaShuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.ChosaKekkaShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosakekka1_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosakekka2_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosakekka3_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 調査票OCR取込みデータ詳細表示Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ChosaKekkaShosaiMain {

    /**
     * 調査票取込み対象者一覧データグリッド上の対象者選択時の処理を表します。
     *
     * @param panel chosaKekkaShosaiMainDiv,ChosaOcrTorikomiDiv
     * @param panel2 ChosaOcrTorikomiDiv
     * @return ResponseData
     */
    public ResponseData<ChosaKekkaShosaiMainDiv> dispChosaKekkaShosai(ChosaKekkaShosaiMainDiv panel, ChosaOCRTorikomiDiv panel2) {
        ResponseData<ChosaKekkaShosaiMainDiv> response = new ResponseData<>();
        int iSelectId = panel2.getDgChosahyoTorikomiKekka().getClickedRowId();
        setChosaKekkaShosaiData(panel, iSelectId);

        panel.getChosaKekkaShosai().getDgChosakekka1().setDataSource(createRowChosaKekkaTest1Data());
        panel.getChosaKekkaShosai().getDgChosakekka2().setDataSource(createRowChosaKekkaTest2Data());
        panel.getChosaKekkaShosai().getDgChosakekka3().setDataSource(createRowChosaKekkaTest3Data());

        response.data = panel;
        return response;

    }

    private enum Sentakushi {

        Type1("つかまらないでできる", "何かにつかまればできる", "できない"),
        Type2("できる", "自分の手で支えればできる", "支えてもらえればできる", "できない"),
        Type3("支えなしでできる", "何か支えがあればできる", "できない"),
        Type4("介助されていない", "一部介助", "全部介助", "行っていない"),
        Type5("介助されていない", "一部介助", "全部介助"),
        Type6("普通", "約１ｍ離れた視力表", "目の前の視力表", "ほとんど見えない", "判断不能"),
        Type7("普通", "普通がやっと", "かなり大きい声でやっと", "ほとんど聞こえない", "判断不能");
        private final List<KeyValueDataSource> dataSource;

        private Sentakushi(String... values) {
            this.dataSource = _toDataSource(values);
        }

        private static List<KeyValueDataSource> _toDataSource(String... values) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            int index = 0;
            for (String value : values) {
                dataSource.add(new KeyValueDataSource(
                        new RString(String.valueOf(++index)), new RString(value))
                );
            }
            return dataSource;
        }

        public List<KeyValueDataSource> getDataSource() {
            return this.dataSource;
        }

    }

    /**
     * 調査結果確認データグリッド上のボタン押下時の処理を表します。
     *
     * @param panel ChosaKekkaShuseiDiv
     * @param panel2 chosaKekkaShosaiDiv
     * @return ResponseData
     */
    public ResponseData<ChosaKekkaShuseiDiv> onClickChosaKekka(ChosaKekkaShuseiDiv panel, ChosaKekkaShosaiDiv panel2) {
        ResponseData<ChosaKekkaShuseiDiv> response = new ResponseData<>();
        dgChosakekka1_Row dataRow = panel2.getDgChosakekka1().getClickedItem();

        panel.setTitle(dataRow.get内容());
        panel.getRadChosaKekka().setVisible(true);
        if (dataRow.get選択肢().equalsIgnoreCase("1")) {
            panel.getRadChosaKekka().setDataSource(Sentakushi.Type1.getDataSource());
            panel.getRadChosaKekka().setSelectedItem(new RString("2"));
        } else if (dataRow.get選択肢().equalsIgnoreCase("2")) {
            panel.getRadChosaKekka().setDataSource(Sentakushi.Type2.getDataSource());
        } else if (dataRow.get選択肢().equalsIgnoreCase("3")) {
            panel.getRadChosaKekka().setDataSource(Sentakushi.Type3.getDataSource());
        } else if (dataRow.get選択肢().equalsIgnoreCase("4")) {
            panel.getRadChosaKekka().setDataSource(Sentakushi.Type4.getDataSource());
        } else if (dataRow.get選択肢().equalsIgnoreCase("5")) {
            panel.getRadChosaKekka().setDataSource(Sentakushi.Type5.getDataSource());
        } else if (dataRow.get選択肢().equalsIgnoreCase("6")) {
            panel.getRadChosaKekka().setDataSource(Sentakushi.Type6.getDataSource());
        } else if (dataRow.get選択肢().equalsIgnoreCase("7")) {
            panel.getRadChosaKekka().setDataSource(Sentakushi.Type7.getDataSource());
        }
        response.data = panel;

        return response;
    }

    /*
     *調査票結果詳細情報を取得します。
     */
    private void setChosaKekkaShosaiData(ChosaKekkaShosaiMainDiv panel, int iSelectId) {

        List<HashMap> chosaKekkaShosai = YamlLoader.DBE.loadAsList(new RString("dbe2060005/ChosaKekkaShosaiMain.yml"));

//        HashMap hashMap = chosaKekkaShosai.get(iSelectId);
        ControlGenerator cg = new ControlGenerator(chosaKekkaShosai.get(iSelectId));
        RString strHokensha = cg.getAsRString("hokenshaNo");
        RString strHihokenNo = cg.getAsRString("hihokenNo");
        RDate strShinseibi = new RDate(cg.getAsRString("shinseibi").toString());
        RString strShinseiKbn = cg.getAsRString("shinseiKbn");
        RString strChosaKikanNo = cg.getAsRString("chosaKikanNo");
        RString strChosainNo = cg.getAsRString("chosainNo");
        RString strChosaKikanMei = cg.getAsRString("chosaKikanMei");
        RString strChosainMei = cg.getAsRString("chosainMei");
        RDate strChosaJissibi = new RDate(cg.getAsRString("chosaJissibi").toString());
        RDate strChosahyoJuryobi = new RDate(cg.getAsRString("chosahyoJuryobi").toString());

        panel.getKihonJoho().getTxtHokenNo().setValue(strHokensha);
        panel.getKihonJoho().getTxtHihokenNo().setValue(strHihokenNo);
        panel.getKihonJoho().getTxtShinseibi().setValue(strShinseibi);
        panel.getKihonJoho().getDdlShinseiKbn().setSelectedItem(strShinseiKbn);
        panel.getChosaItakuJoho().getTxtChosakikanNo().setValue(strChosaKikanNo);
        panel.getChosaItakuJoho().getTxtChosainNo().setValue(strChosainNo);
        panel.getChosaItakuJoho().getTxtChosakikanMei().setValue(strChosaKikanMei);
        panel.getChosaItakuJoho().getTxtChosainMei().setValue(strChosainMei);
        panel.getChosaItakuJoho().getTxtChosaJissibi().setValue(strChosaJissibi);
        panel.getChosaItakuJoho().getTxtChosahyoJuryobi().setValue(strChosahyoJuryobi);

    }

    /*
     *調査結果１データグリッドに設定する調査結果情報を入力します。
     */
    private List<dgChosakekka1_Row> createRowChosaKekkaTest1Data() {
        List<dgChosakekka1_Row> arrayData = new ArrayList<>();
        dgChosakekka1_Row item;

        item = createRowChosakekka1Data(true, "1群", "身体機能", "　", "", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "1-1", "左上肢麻痺", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "1-2", "右上肢麻痺", "ある", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "1-3", "左下肢麻痺", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "1-4", "右下肢麻痺", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "2-1", "肩関節拘縮", "ある", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "2-2", "股関節拘縮", "ある", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "2-3", "膝関節拘縮", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "2-4", "その他拘縮", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "3", "寝返り", "つかまれば可", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "4", "起き上がり", "つかまれば可", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "5", "座位保持", "　", "2", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "6", "両足での立位", "　", "3", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "7", "歩行", "　", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "8", "立ち上がり", "　", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "9", "片足での立位", "支えが必要", "3", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "10", "洗身", "　", "4", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "11", "つめ切り", "一部介助", "5", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "12", "視力", "　", "6", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "13", "聴力", "　", "7", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(true, "2群", "生活機能", "　　", "", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "1", "移乗", "見守り等", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "2", "移動", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "3", "えん下", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "4", "食事摂取", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "5", "排尿", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "6", "排便", "見守り等", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "7", "口腔清潔", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "8", "洗顔", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "9", "整髪", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "10", "上衣の着脱", "見守り等", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "11", "ズボン等の着脱", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, "12", "外出頻度", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);

        return arrayData;
    }

    /*
     *調査結果２データグリッドに設定する調査結果情報を入力します。
     */
    private List<dgChosakekka2_Row> createRowChosaKekkaTest2Data() {
        List<dgChosakekka2_Row> arrayData = new ArrayList<>();
        dgChosakekka2_Row item;

        item = createRowChosakekka2Data(true, "3群", "認知機能", "", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "1", "意思の伝達", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "2", "日課を理解", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "3", "生年月日をいう", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "4", "短期記憶", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "5", "自分の名前", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "6", "今の季節を理解", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "7", "場所の理解", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "8", "徘徊", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "9", "外出戻れず", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(true, "4群", "精神・行動障害", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "1", "被害的", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "2", "作話", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "3", "感情が不安定", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "4", "昼夜逆転", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "5", "同じ話をする", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "6", "大声を出す", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "7", "介護に抵抗", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "8", "落ち着きなし", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "9", "一人で出たがる", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "10", "収集癖", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "11", "物等を壊す", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "12", "ひどい物忘れ", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "13", "独り言独り笑い", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "14", "勝手に行動", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "15", "話がまとまらず", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(true, "5群", "社会への適応", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "1", "薬の内服", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "2", "金銭の管理", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "3", "意思決定", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "4", "集団への不適応", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "5", "買い物", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, "6", "簡単な調理", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);

        return arrayData;
    }

    /*
     *調査結果３データグリッドに設定する調査結果情報を入力します。
     */
    private List<dgChosakekka3_Row> createRowChosaKekkaTest3Data() {
        List<dgChosakekka3_Row> arrayData = new ArrayList<>();
        dgChosakekka3_Row item;

        item = createRowChosakekka3Data(true, "　", "特別な医療", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "点滴の管理", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "中心静脈栄養", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "透析", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "ストーマの処置", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "酸素療法", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "レスピレーター", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "気管切開", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "疼痛の看護", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "経菅栄養", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "モニター測定", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "じょくそうの処置", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "　", "カテーテル", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(true, "　", "自立度", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "1", "調寝たきり度", "J2", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "2", "意寝たきり度", "J2", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "3", "調認知症度", "Ⅰ", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "4", "意認知症度", "Ⅰ", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(true, "　", "主治医意見書", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "1", "短期記録", "問題なし", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "2", "認知能力", "自立", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "3", "伝達能力", "伝えられる", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, "4", "食事行為", "自立", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);

        return arrayData;
    }

    /*
     *調査結果１データグリッドの行情報を設定します。
     */
    private dgChosakekka1_Row createRowChosakekka1Data(boolean isDisable,
            String 群, String 内容, String 結果, String 選択肢, DataGridCellBgColor bgColor) {

        Button btn = new Button();
        dgChosakekka1_Row rowChosakekka1Data = new dgChosakekka1_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        btn.setDisabled(isDisable);
        btn.setDisplayNone(isDisable);
        btn.setText(RString.EMPTY);
        rowChosakekka1Data.set編集(btn);
        rowChosakekka1Data.set群(new RString(群));
        rowChosakekka1Data.set内容(new RString(内容));
        rowChosakekka1Data.set結果(new RString(結果));
        rowChosakekka1Data.set選択肢(new RString(選択肢));
        rowChosakekka1Data.setRowBgColor(bgColor);

        return rowChosakekka1Data;
    }

    /*
     *調査結果２データグリッドの行情報を設定します。
     */
    private dgChosakekka2_Row createRowChosakekka2Data(boolean isDisable,
            String 群, String 内容, String 結果, DataGridCellBgColor bgColor) {

        Button btn = new Button();
        dgChosakekka2_Row rowChosakekka2Data = new dgChosakekka2_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        btn.setDisabled(isDisable);
        btn.setText(RString.EMPTY);
        rowChosakekka2Data.set群(new RString(群));
        rowChosakekka2Data.set内容(new RString(内容));
        rowChosakekka2Data.set結果(new RString(結果));
        rowChosakekka2Data.setRowBgColor(bgColor);

        return rowChosakekka2Data;
    }

    /*
     *調査結果３データグリッドの行情報を設定します。
     */
    private dgChosakekka3_Row createRowChosakekka3Data(boolean isDisable,
            String 群, String 内容, String 結果, DataGridCellBgColor bgColor) {

        Button btn = new Button();
        dgChosakekka3_Row rowChosakekka3Data = new dgChosakekka3_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        btn.setDisabled(isDisable);
        btn.setText(RString.EMPTY);
        rowChosakekka3Data.set群(new RString(群));
        rowChosakekka3Data.set内容(new RString(内容));
        rowChosakekka3Data.set結果(new RString(結果));
        rowChosakekka3Data.setRowBgColor(bgColor);

        return rowChosakekka3Data;
    }
}
