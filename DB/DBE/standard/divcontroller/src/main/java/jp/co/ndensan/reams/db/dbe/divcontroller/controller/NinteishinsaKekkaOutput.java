/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5050001.NinteishinsaKekkaOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5050001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 認定審査結果出力画面の処理を表します。
 *
 * @author N1013 松本直樹
 */
public class NinteishinsaKekkaOutput {

    private static final RString CST_TSUJO = new RString("0");
    private static final RString CST_SAISHORI = new RString("1");
    private static RString shoriFlag = RString.EMPTY;

    /**
     * 認定審査結果出力画面ロード時の処理を表します。
     *
     * @param div 認定審査結果出力Div
     * @return ResponseData
     */
    public ResponseData onLoad(NinteishinsaKekkaOutputDiv div) {
        ResponseData<NinteishinsaKekkaOutputDiv> response = new ResponseData<>();
        ddlHokensha(div).setDataSource(new ArrayList<KeyValueDataSource>());

        RString key1 = new RString("1");
        RString densanTown = new RString("電算町");

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("DemoCity.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        if (!cg.getAsRString("保険者番号").equals(RString.EMPTY)) {

            RString key2 = new RString("2");
            RString hokenshaName = cg.getAsRString("保険者名称");
            ddlHokensha(div).getDataSource().add(new KeyValueDataSource(key2, hokenshaName));
            ddlHokensha(div).getDataSource().add(new KeyValueDataSource(key1, densanTown));

            ddlHokensha(div).setSelectedItem(key2);
        } else {
            ddlHokensha(div).getDataSource().add(new KeyValueDataSource(key1, densanTown));
            ddlHokensha(div).setSelectedItem(key1);
        }

        div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getTxtNinteiKekkaKakuninKikan().setDisplayNone(true);

        response.data = div;
        return response;
    }

    private DropDownList ddlHokensha(NinteishinsaKekkaOutputDiv div) {
        return div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getDdlHokensha();
    }

    /**
     * 出力区分ラジオボタンの選択項目を変更した際の処理を表します。
     *
     * @param div 認定審査結果出力Div
     * @return ResponseData
     */
    public ResponseData onChange_radShutsuryokuKubun(NinteishinsaKekkaOutputDiv div) {
        ResponseData<NinteishinsaKekkaOutputDiv> response = new ResponseData<>();

        if (div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getRadShutsuryokuKubun().getSelectedItem().equalsIgnoreCase(new RString("0"))) {
            div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getTxtNinteiKekkaKakuninKikan().setDisplayNone(true);
        } else {
            div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getTxtNinteiKekkaKakuninKikan().setDisplayNone(false);
            div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getTxtNinteiKekkaKakuninKikan().clearFromValue();
            div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getTxtNinteiKekkaKakuninKikan().clearToValue();
        }

        response.data = div;
        return response;
    }

    /**
     * 「対象被保険者を表示する」ボタン押下時の処理を表します。
     *
     * @param div 認定審査結果出力Div
     * @return ResponseData
     */
    public ResponseData onClick_btnHyoji(NinteishinsaKekkaOutputDiv div) {
        ResponseData<NinteishinsaKekkaOutputDiv> response = new ResponseData<>();

        if (div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getRadShutsuryokuKubun().getSelectedItem().equalsIgnoreCase(new RString("0"))) {
            if (shoriFlag.equalsIgnoreCase(RString.EMPTY)) {
                div.getShinsaKekkaJohoSakuseiTaishosha().getDgTaishoshaIchiran().setDataSource(createRowTaishoshaIchiranTestData(CST_TSUJO));
            }
        } else {
            if (!div.getShinsaKekkaSyutsuryokuJokenNyuryoku().getTxtNinteiKekkaKakuninKikan().getFromValue().toString().isEmpty()) {
                div.getShinsaKekkaJohoSakuseiTaishosha().getDgTaishoshaIchiran().setDataSource(createRowTaishoshaIchiranTestData(CST_SAISHORI));
            }
        }

        response.data = div;
        return response;
    }

    /**
     * 「結果情報を出力する」ボタン押下時の処理を表します。
     *
     * @param div 認定審査結果出力Div
     * @return ResponseData
     */
    public ResponseData onClick_btnDataSakusei(NinteishinsaKekkaOutputDiv div) {
        ResponseData<NinteishinsaKekkaOutputDiv> response = new ResponseData<>();

        List<dgTaishoshaIchiran_Row> arrayData = new ArrayList<>();
        div.getShinsaKekkaJohoSakuseiTaishosha().getDgTaishoshaIchiran().setDataSource(arrayData);
        shoriFlag = new RString("処理済");

        response.addMessage(new InformationMessage("i", "出力しました。"));

        response.data = div;
        return response;
    }

    private static List<dgTaishoshaIchiran_Row> createRowTaishoshaIchiranTestData(RString shoriKbn) {
        List<dgTaishoshaIchiran_Row> arrayData = new ArrayList<>();

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5050001/ninteiKekkaSofuList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgTaishoshaIchiran_Row(info, shoriKbn));
        }

        return arrayData;
    }

    private static dgTaishoshaIchiran_Row toDgTaishoshaIchiran_Row(Map map, RString shoriKbn) {
        ControlGenerator cg = new ControlGenerator(map);

        FlexibleDate sofuDate = new FlexibleDate(RString.EMPTY);
        if (shoriKbn.equalsIgnoreCase(CST_SAISHORI)) {
            sofuDate = FlexibleDate.getNowDate();
        }

        TextBoxFlexibleDate outputDate = new TextBoxFlexibleDate();
        outputDate.setValue(sofuDate);
        outputDate.setDisabled(true);

        dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row(
                cg.getAsTextBoxNum("Ｎｏ"),
                cg.getAsRString("被保番号"),
                cg.getAsRString("氏名"),
                cg.getAsRString("氏名カナ"),
                cg.getAsTextBoxFlexibleDate("申請日"),
                cg.getAsRString("申請区分申請時"),
                cg.getAsRString("申請区分法令"),
                cg.getAsRString("状態"),
                cg.getAsTextBoxFlexibleDate("二次判定日"),
                outputDate);
        return row;
    }

}
