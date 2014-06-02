/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaKekkaShosaiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaOcrTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaKekkaShuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaKekkaShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka1_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka2_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka3_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author n9606
 */
public class ChosaKekkaShosaiMain {

    public ResponseData<ChosaKekkaShosaiMainDiv> onLoad(ChosaKekkaShosaiMainDiv panel, ChosaOcrTorikomiDiv panel2) {
        ResponseData<ChosaKekkaShosaiMainDiv> response = new ResponseData<>();

        return response;

    }

    public ResponseData<ChosaKekkaShosaiMainDiv> dispChosaKekkaShosai(ChosaKekkaShosaiMainDiv panel, ChosaOcrTorikomiDiv panel2) {
        ResponseData<ChosaKekkaShosaiMainDiv> response = new ResponseData<>();
        int iSelectId = panel2.getDgChosahyoTorikomiKekka().getClickedRowId();
        setChosaKekkaShosaiData(panel, iSelectId);

        panel.getChosaKekkaShosai().getDgChosakekka1().setDataSource(createRowChosaKekkaTest1Data());
        panel.getChosaKekkaShosai().getDgChosakekka2().setDataSource(createRowChosaKekkaTest2Data());
        panel.getChosaKekkaShosai().getDgChosakekka3().setDataSource(createRowChosaKekkaTest3Data());

        response.data = panel;
        return response;

    }

    /**
     * 調査結果確認データグリッド上のボタン押下時の処理を表します。
     *
     * @param div 調査結果修正Div
     * @param ichiranDiv 調査結果詳細Div
     * @return ResponseData
     */
    public ResponseData<ChosaKekkaShuseiDiv> onClickChosaKekka(ChosaKekkaShuseiDiv panel, ChosaKekkaShosaiDiv panel2) {
        ResponseData<ChosaKekkaShuseiDiv> response = new ResponseData<>();
        dgChosakekka1_Row dataRow = panel2.getDgChosakekka1().getClickedItem();

        panel.setTitle(dataRow.get内容());
        panel.getRadChosaKekka().setVisible(true);
        if (dataRow.get選択肢().equalsIgnoreCase("1")) {
            panel.getRadChosaKekka().setDataSource(createRadioButton1(new RString("つかまらないでできる"),
                    new RString("何かにつかまればできる"), new RString("できない"), null, null, null));
            panel.getRadChosaKekka().setSelectedItem(new RString("2"));
        } else if (dataRow.get選択肢().equalsIgnoreCase("2")) {
            panel.getRadChosaKekka().setDataSource(createRadioButton1(new RString("できる"),
                    new RString("自分の手で支えればできる"), new RString("支えてもらえればできる"),
                    new RString("できない"), null, null));
        } else if (dataRow.get選択肢().equalsIgnoreCase("3")) {
            panel.getRadChosaKekka().setDataSource(createRadioButton1(new RString("支えなしでできる"),
                    new RString("何か支えがあればできる"), new RString("できない"),
                    null, null, null));
        } else if (dataRow.get選択肢().equalsIgnoreCase("4")) {
            panel.getRadChosaKekka().setDataSource(createRadioButton1(new RString("介助されていない"),
                    new RString("一部介助"), new RString("全部介助"),
                    new RString("行っていない"), null, null));
        } else if (dataRow.get選択肢().equalsIgnoreCase("5")) {
            panel.getRadChosaKekka().setDataSource(createRadioButton1(new RString("介助されていない"),
                    new RString("一部介助"), new RString("全部介助"),
                    null, null, null));
        } else if (dataRow.get選択肢().equalsIgnoreCase("6")) {
            panel.getRadChosaKekka().setDataSource(createRadioButton1(new RString("普通"),
                    new RString("約１ｍ離れた視力表"), new RString("目の前の視力表"),
                    new RString("ほとんど見えない"), new RString("判断不能"), null));
        } else if (dataRow.get選択肢().equalsIgnoreCase("7")) {
            panel.getRadChosaKekka().setDataSource(createRadioButton1(new RString("普通"),
                    new RString("普通がやっと"), new RString("かなり大きい声でやっと"),
                    new RString("ほとんど聞こえない"), new RString("判断不能"), null));
        }
        response.data = panel;

        return response;
    }

    private void setChosaKekkaShosaiData(ChosaKekkaShosaiMainDiv panel, int iSelectId) {

        List<HashMap> ChosaKekkaShosai = YamlLoader.FOR_DBE.loadAsList(new RString("ChosaKekkaShosaiMain.yml"));

        HashMap hashMap = ChosaKekkaShosai.get(iSelectId);
        String strHokensha = (String) hashMap.get("hokenshaNo");
        String strHihokenNo = (String) hashMap.get("hihokenNo");
        String strShinseibi = (String) hashMap.get("shinseibi");
        String strShinseiKbn = (String) hashMap.get("shinseiKbn");
        String strChosaKikanNo = (String) hashMap.get("chosaKikanNo");
        String strChosainNo = (String) hashMap.get("chosainNo");
        String strChosaKikanMei = (String) hashMap.get("chosaKikanMei");
        String strChosainMei = (String) hashMap.get("chosainMei");
        String strChosaJissibi = (String) hashMap.get("chosaJissibi");
        String strChosahyoJuryobi = (String) hashMap.get("chosahyoJuryobi");

        panel.getKihonJoho().getTxtHokenNo().setValue(new RString(strHokensha));
        panel.getKihonJoho().getTxtHihokenNo().setValue(new RString(strHihokenNo));
        panel.getKihonJoho().getTxtShinseibi().setValue(new RDate(strShinseibi));
        panel.getKihonJoho().getDdlShinseiKbn().setSelectedItem(new RString(strShinseiKbn));
        panel.getChosaItakuJoho().getTxtChosakikanNo().setValue(new RString(strChosaKikanNo));
        panel.getChosaItakuJoho().getTxtChosainNo().setValue(new RString(strChosainNo));
        panel.getChosaItakuJoho().getTxtChosakikanMei().setValue(new RString(strChosaKikanMei));
        panel.getChosaItakuJoho().getTxtChosainMei().setValue(new RString(strChosainMei));
        panel.getChosaItakuJoho().getTxtChosaJissibi().setValue(new RDate(strChosaJissibi));
        panel.getChosaItakuJoho().getTxtChosahyoJuryobi().setValue(new RDate(strChosahyoJuryobi));

    }

    private List<dgChosakekka1_Row> createRowChosaKekkaTest1Data() {
        List<dgChosakekka1_Row> arrayData = new ArrayList<>();
        dgChosakekka1_Row item;

        item = createRowChosakekka1Data(true, " ", "1群", "身体機能", "　", "", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "1-1", "左上肢麻痺", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "1-2", "右上肢麻痺", "ある", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "1-3", "左下肢麻痺", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "1-4", "右下肢麻痺", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "2-1", "肩関節拘縮", "ある", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "2-2", "股関節拘縮", "ある", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "2-3", "膝関節拘縮", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "2-4", "その他拘縮", "　", "", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "3", "寝返り", "つかまれば可", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "4", "起き上がり", "つかまれば可", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "5", "座位保持", "　", "2", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "6", "両足での立位", "　", "3", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "7", "歩行", "　", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "8", "立ち上がり", "　", "1", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "9", "片足での立位", "支えが必要", "3", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "10", "洗身", "　", "4", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "11", "つめ切り", "一部介助", "5", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "12", "視力", "　", "6", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "13", "聴力", "　", "7", DataGridCellBgColor.bgColorLightBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(true, " ", "2群", "生活機能", "　　", "", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "1", "移乗", "見守り等", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "2", "移動", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "3", "えん下", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "4", "食事摂取", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "5", "排尿", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "6", "排便", "見守り等", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "7", "口腔清潔", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "8", "洗顔", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "9", "整髪", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "10", "上衣の着脱", "見守り等", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "11", "ズボン等の着脱", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);
        item = createRowChosakekka1Data(false, " ", "12", "外出頻度", "　", "1", DataGridCellBgColor.bgColorBlue);
        arrayData.add(item);

        return arrayData;
    }

    private List<dgChosakekka2_Row> createRowChosaKekkaTest2Data() {
        List<dgChosakekka2_Row> arrayData = new ArrayList<>();
        dgChosakekka2_Row item;

        item = createRowChosakekka2Data(true, " ", "3群", "認知機能", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "1", "意思の伝達", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "2", "日課を理解", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "3", "生年月日をいう", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "4", "短期記憶", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "5", "自分の名前", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "6", "今の季節を理解", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "7", "場所の理解", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "8", "徘徊", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "9", "外出戻れず", "　", DataGridCellBgColor.bgColorLightGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(true, " ", "4群", "精神・行動障害", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "1", "被害的", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "2", "作話", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "3", "感情が不安定", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "4", "昼夜逆転", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "5", "同じ話をする", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "6", "大声を出す", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "7", "介護に抵抗", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "8", "落ち着きなし", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "9", "一人で出たがる", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "10", "収集癖", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "11", "物等を壊す", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "12", "ひどい物忘れ", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "13", "独り言独り笑い", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "14", "勝手に行動", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "15", "話がまとまらず", "　", DataGridCellBgColor.bgColorGreen);
        arrayData.add(item);
        item = createRowChosakekka2Data(true, " ", "5群", "社会への適応", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "1", "薬の内服", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "2", "金銭の管理", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "3", "意思決定", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "4", "集団への不適応", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "5", "買い物", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);
        item = createRowChosakekka2Data(false, " ", "6", "簡単な調理", "　", DataGridCellBgColor.bgColorLightYellow);
        arrayData.add(item);

        return arrayData;
    }

    private List<dgChosakekka3_Row> createRowChosaKekkaTest3Data() {
        List<dgChosakekka3_Row> arrayData = new ArrayList<>();
        dgChosakekka3_Row item;

        item = createRowChosakekka3Data(true, " ", "　", "特別な医療", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "点滴の管理", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "中心静脈栄養", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "透析", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "ストーマの処置", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "酸素療法", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "レスピレーター", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "気管切開", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "疼痛の看護", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "経菅栄養", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "モニター測定", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "じょくそうの処置", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "　", "カテーテル", "　", DataGridCellBgColor.bgColorYellow);
        arrayData.add(item);
        item = createRowChosakekka3Data(true, " ", "　", "自立度", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "1", "調寝たきり度", "J2", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "2", "意寝たきり度", "J2", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "3", "調認知症度", "Ⅰ", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "4", "意認知症度", "Ⅰ", DataGridCellBgColor.bgColorLightRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(true, " ", "　", "主治医意見書", "　", DataGridCellBgColor.bgColorLightGray);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "1", "短期記録", "問題なし", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "2", "認知能力", "自立", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "3", "伝達能力", "伝えられる", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);
        item = createRowChosakekka3Data(false, " ", "4", "食事行為", "自立", DataGridCellBgColor.bgColorRed);
        arrayData.add(item);

        return arrayData;
    }

    private dgChosakekka1_Row createRowChosakekka1Data(boolean btnSelect, String チェック, String 群, String 内容, String 結果, String 選択肢,
            DataGridCellBgColor bgColor) {

        Button btn = new Button();
        dgChosakekka1_Row rowChosakekka1Data = new dgChosakekka1_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        btn.setDisabled(btnSelect);
        btn.setDisplayNone(btnSelect);
        btn.setText(RString.EMPTY);
        rowChosakekka1Data.set編集(btn);
        rowChosakekka1Data.set群(new RString(群));
        rowChosakekka1Data.set内容(new RString(内容));
        rowChosakekka1Data.set結果(new RString(結果));
        rowChosakekka1Data.set選択肢(new RString(選択肢));
        rowChosakekka1Data.setRowBgColor(bgColor);

        return rowChosakekka1Data;
    }

    private dgChosakekka2_Row createRowChosakekka2Data(boolean btnSelect, String チェック, String 群, String 内容, String 結果,
            DataGridCellBgColor bgColor) {

        Button btn = new Button();
        dgChosakekka2_Row rowChosakekka2Data = new dgChosakekka2_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        btn.setDisabled(btnSelect);
        btn.setDisplayNone(btnSelect);
        btn.setText(RString.EMPTY);
        rowChosakekka2Data.set群(new RString(群));
        rowChosakekka2Data.set内容(new RString(内容));
        rowChosakekka2Data.set結果(new RString(結果));
        rowChosakekka2Data.setRowBgColor(bgColor);

        return rowChosakekka2Data;
    }

    private dgChosakekka3_Row createRowChosakekka3Data(boolean btnSelect, String チェック, String 群, String 内容, String 結果,
            DataGridCellBgColor bgColor) {

        Button btn = new Button();
        dgChosakekka3_Row rowChosakekka3Data = new dgChosakekka3_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        btn.setDisabled(btnSelect);
        btn.setDisplayNone(btnSelect);
        btn.setText(RString.EMPTY);
        rowChosakekka3Data.set群(new RString(群));
        rowChosakekka3Data.set内容(new RString(内容));
        rowChosakekka3Data.set結果(new RString(結果));
        rowChosakekka3Data.setRowBgColor(bgColor);

        return rowChosakekka3Data;
    }

    private List<KeyValueDataSource> createRadioButton1(RString s1, RString s2, RString s3, RString s4, RString s5, RString s6) {
        List<KeyValueDataSource> arrayData = new ArrayList<>();
        KeyValueDataSource keyValue = new KeyValueDataSource();
        keyValue.setKey(new RString("1"));
        keyValue.setValue(s1);
        arrayData.add(0, keyValue);
        KeyValueDataSource keyValue2 = new KeyValueDataSource();
        keyValue2.setKey(new RString("2"));
        keyValue2.setValue(s2);
        arrayData.add(1, keyValue2);
        KeyValueDataSource keyValue3 = new KeyValueDataSource();
        keyValue3.setKey(new RString("3"));
        keyValue3.setValue(s3);
        arrayData.add(2, keyValue3);
        if (s4 != null) {
            KeyValueDataSource keyValue4 = new KeyValueDataSource();
            keyValue4.setKey(new RString("4"));
            keyValue4.setValue(s4);
            arrayData.add(3, keyValue4);
        }
        if (s5 != null) {
            KeyValueDataSource keyValue5 = new KeyValueDataSource();
            keyValue5.setKey(new RString("5"));
            keyValue5.setValue(s5);
            arrayData.add(4, keyValue5);
        }
        if (s6 != null) {
            KeyValueDataSource keyValue6 = new KeyValueDataSource();
            keyValue6.setKey(new RString("6"));
            keyValue6.setValue(s6);
            arrayData.add(5, keyValue6);
        }

        return arrayData;
    }
}
