/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaKekkaNyuryokuShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaShienTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka1_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka2_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosakekka3_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran1_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 審査会支援での、審査結果入力支援用画面を編集します。
 *
 * @author N1013 松本直樹
 */
public class ShinsaKekkaNyuryokuShosai {

    public ResponseData onLoadData(ShinsaKekkaNyuryokuShosaiDiv div, ShinsaShienTaishoshaIchiranDiv ichiranDiv) {
        ResponseData<ShinsaKekkaNyuryokuShosaiDiv> response = new ResponseData<>();

        dgShinsaTaishoshaIchiran1_Row dataRow = ichiranDiv.getDgShinsaTaishoshaIchiran1().getClickedItem();

        div.getTabChosaKekka().getTabChosaKekkaShosai().getDgChosakekka1().setDataSource(createRowChosaKekkaTest1Data());
        div.getTabChosaKekka().getTabChosaKekkaShosai().getDgChosakekka2().setDataSource(createRowChosaKekkaTest2Data());
        div.getTabChosaKekka().getTabChosaKekkaShosai().getDgChosakekka3().setDataSource(createRowChosaKekkaTest3Data());
        div.getShinsaTaishoshaShosai().getTxtShinseiKubun()
                .setValue(new RString("更新"));
        // .setValue(dataRow.get申請());
        div.getShinsaTaishoshaShosai().getTxtHihokenshaKubun().setValue(new RString("１号"));
        div.getShinsaTaishoshaShosai().getTxtNenrei().setValue(new RString("75才"));
        div.getShinsaTaishoshaShosai().getTxtSeibetsu().setValue(new RString("男"));
        div.getShinsaTaishoshaShosai().getTxtZenIchiji().setValue(new RString("介１"));
        div.getShinsaTaishoshaShosai().getTxtZenNiji().setValue(new RString("介１"));

        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().getDdlNinteiKubun().setSelectedItem(new RString("認定"));
        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().getTxtIchijiHanteiKekka().setValue(new RString("要介護２"));
        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().getTxtShinseibi().setValue(RDate.getNowDate());
        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().getTxtShinseiKubunShinsei().setValue(new RString("更新"));
        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate("20140501"));
        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("20160430"));
        div.getTabChosaKekka().getTabShinsaKekka().getNinteiKekkaNyuryoku().setTitle(new RString("今回認定結果"));

        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().setDisabled(true);
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().getDdlNinteiKubun().setSelectedItem(new RString("認定"));
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().getTxtIchijiHanteiKekka().setValue(new RString("要介護１"));
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().getTxtNinteibi().setValue(FlexibleDate.getNowDate());
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().getTxtShinseibi().setValue(new RDate("20120318"));
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().getTxtShinseiKubunShinsei().setValue(new RString("更新"));
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().getTxtNinteiYukoKikanStart().setValue(new FlexibleDate("20120501"));
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("20140430"));
        div.getTabChosaKekka().getTabShinsaKekka().getZenkaiNinteiKekka().setTitle(new RString("前回認定結果"));

        div.getTabChosaKekka().getTabShinsaKekka().getZenZenkaiNinteiKekka().setDisabled(true);
        div.getTabChosaKekka().getTabShinsaKekka().getZenZenkaiNinteiKekka().setTitle(new RString("前々回認定結果"));

        response.data = div;
        return response;
    }

    private List<dgChosakekka1_Row> createRowChosaKekkaTest1Data() {
        List<dgChosakekka1_Row> arrayData = new ArrayList<>();
        dgChosakekka1_Row item;

        item = createRowChosakekka1Data(" ", "1群", "身体機能", "計：");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "1-1", "左上肢麻痺", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "1-2", "右上肢麻痺", "ある");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "1-3", "左下肢麻痺", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "1-4", "右下肢麻痺", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "2-1", "肩関節拘縮", "ある");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "2-2", "股関節拘縮", "ある");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "2-3", "膝関節拘縮", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "2-4", "その他拘縮", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "3", "寝返り", "つかまれば可");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "4", "起き上がり", "つかまれば可");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "5", "座位保持", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "6", "両足での立位", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "7", "歩行", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "8", "立ち上がり", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "9", "片足での立位", "支えが必要");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "10", "洗身", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "11", "つめ切り", "一部介助");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "12", "視力", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "13", "聴力", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "2群", "生活機能", "計：　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "1", "移乗", "見守り等");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "2", "移動", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "3", "えん下", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "4", "食事摂取", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "5", "排尿", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "6", "排便", "見守り等");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "7", "口腔清潔", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "8", "洗顔", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "9", "整髪", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "10", "上衣の着脱", "見守り等");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "11", "ズボン等の着脱", "　");
        arrayData.add(item);
        item = createRowChosakekka1Data(" ", "12", "外出頻度", "　");
        arrayData.add(item);

        return arrayData;
    }

    private List<dgChosakekka2_Row> createRowChosaKekkaTest2Data() {
        List<dgChosakekka2_Row> arrayData = new ArrayList<>();
        dgChosakekka2_Row item;

        item = createRowChosakekka2Data(" ", "3群", "認知機能", "計：");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "1", "意思の伝達", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "2", "日課を理解", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "3", "生年月日をいう", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "4", "短期記憶", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "5", "自分の名前", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "6", "今の季節を理解", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "7", "場所の理解", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "8", "徘徊", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "9", "外出戻れず", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "4群", "精神・行動障害", "計：");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "1", "被害的", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "2", "作話", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "3", "感情が不安定", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "4", "昼夜逆転", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "5", "同じ話をする", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "6", "大声を出す", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "7", "介護に抵抗", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "8", "落ち着きなし", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "9", "一人で出たがる", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "10", "収集癖", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "11", "物等を壊す", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "12", "ひどい物忘れ", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "13", "独り言独り笑い", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "14", "勝手に行動", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "15", "話がまとまらず", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "5群", "社会への適応", "計：");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "1", "薬の内服", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "2", "金銭の管理", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "3", "意思決定", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "4", "集団への不適応", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "5", "買い物", "　");
        arrayData.add(item);
        item = createRowChosakekka2Data(" ", "6", "簡単な調理", "　");
        arrayData.add(item);

        return arrayData;
    }

    private List<dgChosakekka3_Row> createRowChosaKekkaTest3Data() {
        List<dgChosakekka3_Row> arrayData = new ArrayList<>();
        dgChosakekka3_Row item;

        item = createRowChosakekka3Data(" ", "　", "特別な医療", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "点滴の管理", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "中心静脈栄養", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "透析", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "ストーマの処置", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "酸素療法", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "レスピレーター", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "気管切開", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "疼痛の看護", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "経菅栄養", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "モニター測定", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "じょくそうの処置", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "カテーテル", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "自立度", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "1", "調寝たきり度", "J2");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "2", "意寝たきり度", "J2");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "3", "調認知症度", "Ⅰ");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "4", "意認知症度", "Ⅰ");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "主治医意見書", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "1", "短期記録", "問題なし");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "2", "認知能力", "自立");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "3", "伝達能力", "伝えられる");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "4", "食事行為", "自立");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);
        item = createRowChosakekka3Data(" ", "　", "　", "　");
        arrayData.add(item);

        return arrayData;
    }

    private dgChosakekka1_Row createRowChosakekka1Data(String チェック, String 群, String 内容, String 結果) {

        Button btn = new Button();
        dgChosakekka1_Row rowChosakekka1Data = new dgChosakekka1_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        rowChosakekka1Data.set群(new RString(群));
        rowChosakekka1Data.set内容(new RString(内容));
        rowChosakekka1Data.set結果(new RString(結果));

        return rowChosakekka1Data;
    }

    private dgChosakekka2_Row createRowChosakekka2Data(String チェック, String 群, String 内容, String 結果) {

        Button btn = new Button();
        dgChosakekka2_Row rowChosakekka2Data = new dgChosakekka2_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        rowChosakekka2Data.set群(new RString(群));
        rowChosakekka2Data.set内容(new RString(内容));
        rowChosakekka2Data.set結果(new RString(結果));

        return rowChosakekka2Data;
    }

    private dgChosakekka3_Row createRowChosakekka3Data(String チェック, String 群, String 内容, String 結果) {

        Button btn = new Button();
        dgChosakekka3_Row rowChosakekka3Data = new dgChosakekka3_Row(
                btn, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        rowChosakekka3Data.set群(new RString(群));
        rowChosakekka3Data.set内容(new RString(内容));
        rowChosakekka3Data.set結果(new RString(結果));

        return rowChosakekka3Data;
    }

    static class forDemo {

    }

}
