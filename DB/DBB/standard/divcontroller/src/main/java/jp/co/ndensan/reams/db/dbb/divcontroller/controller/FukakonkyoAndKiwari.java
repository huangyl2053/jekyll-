/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukakonkyoAndKiwariDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukakonkyoNengakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblFukaKonkyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblFukakonkyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblKikanDiv;
// TODO N8156 宮本 康 期割額Div変更に伴いコメント化
//import jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku.tblKiwariGakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8211
 */
public class FukakonkyoAndKiwari {

    private static final RString FUKAKONKYO = new RString("DBB0320002/FukaKonkyo.yml");

    public ResponseData<FukakonkyoAndKiwariDiv> onSelect(FukakonkyoAndKiwariDiv div) {

        FukaRirekiDiv rirekiDiv = (FukaRirekiDiv) ViewStateHolder.get("賦課履歴", FukaRirekiDiv.class);

        div.setDisplayNone(false);

        loadFukaKonkyoAndKiwarigaku(div, rirekiDiv, "select");

        return returnResponse(div);
    }

    public ResponseData<FukakonkyoAndKiwariDiv> onClick(FukakonkyoAndKiwariDiv div, FukaRirekiDiv rirekiDiv) {

        div.setDisplayNone(false);

        loadFukaKonkyoAndKiwarigaku(div, rirekiDiv, "click");

        return returnResponse(div);
    }

    public ResponseData<FukakonkyoAndKiwariDiv> onClick_setDisplayNone(FukakonkyoAndKiwariDiv div, FukaRirekiDiv rirekiDiv) {

        div.setDisplayNone(false);

        return returnResponse(div);
    }

    /**
     * イベント処理後のレスポンスデータをリターン
     *
     * @param div
     * @return
     */
    private ResponseData<FukakonkyoAndKiwariDiv> returnResponse(FukakonkyoAndKiwariDiv div) {
        ResponseData<FukakonkyoAndKiwariDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 賦課根拠・期割額Div のロード
     *
     * @param
     */
    private void loadFukaKonkyoAndKiwarigaku(FukakonkyoAndKiwariDiv div, FukaRirekiDiv rirekiDiv, String mode) {
        List formatData = new ArrayList();

        List key = getRirekiKey(rirekiDiv, mode);

        List fukaKonkyoData = getYamlFukaKonkyo(key);

        for (int i = 0; i < fukaKonkyoData.size(); i++) {
            formatData.add(getFormatData((List) fukaKonkyoData.get(i)));
        }

        setFukaKonkyo(div, formatData);

        //setControl(div, formatData);
    }

    /**
     * 履歴一覧から選択行の情報取得
     *
     * @param fukaRirekiDiv
     * @param mode
     * @return
     */
    private List getRirekiKey(FukaRirekiDiv fukaRirekiDiv, String mode) {

        List keyList = new ArrayList();

        switch (mode) {
            case "select":
                // 選択行の情報を取得
                List<dgFukaRirekiFukaRireki_Row> selectedItem = fukaRirekiDiv.getDgFukaRirekiFukaRireki().getSelectedItems();
                for (dgFukaRirekiFukaRireki_Row selectData : selectedItem) {
                    keyList.add(selectData.getTxtTsuchishoNo());
                    keyList.add(selectData.getTxtChoteiNendo());
                    keyList.add(fukaRirekiDiv.getTxtFukaNendoFukaRireki().getValue());
                    keyList.add(selectData.getTxtHokenryoDankai());
                    keyList.add(selectData.getTxtRirekiNo());
                }

                break;
            case "click":
                dgFukaRirekiFukaRireki_Row clickedItem = fukaRirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem();
                keyList.add(clickedItem.getTxtTsuchishoNo());
                keyList.add(clickedItem.getTxtChoteiNendo());
                keyList.add(fukaRirekiDiv.getTxtFukaNendoFukaRireki().getValue());
                keyList.add(clickedItem.getTxtHokenryoDankai());
                keyList.add(clickedItem.getTxtRirekiNo());
                break;
        }

        return keyList;
    }

    /**
     * YamlLoader から 賦課根拠データを取り込み、Listに格納
     *
     * @param yamlFileName Yamlファイル名
     * @return YamlデータのList
     */
    private List getYamlFukaKonkyo(List keyList) {

        //Yaml データ読み込み
        List<HashMap> fukaKonkyo = YamlLoader.DBB.loadAsList(FUKAKONKYO);

        List yamlDatalist = new ArrayList();

        // 通知書番号
        RString key1 = (RString) keyList.get(0);
        // 調定年度
        RString key2 = (RString) keyList.get(1);
        // 賦課年度
        RString key3 = (RString) keyList.get(2);
        // 保険料段階
        RString key4 = (RString) keyList.get(3);
        // 状態
        RString key5;
        if (key4 == null) {
            key5 = new RString("仮");
        } else {
            key5 = new RString("本");
        }
        // 賦課根拠No
        RString key6 = (RString) keyList.get(4);

        for (int i = 0; i < (int) fukaKonkyo.size(); i++) {
            ControlGenerator cg = new ControlGenerator(fukaKonkyo.get(i));
            if (key1.contains(cg.getAsRString("通知書番号"))
                    & key2.contains(cg.getAsRString("調定年度"))
                    & key3.contains(cg.getAsRString("賦課年度"))
                    // & key5.contains(cg.getAsRString("状態"))
                    & key6.contains(cg.getAsRString("賦課根拠No"))) {
                yamlDatalist.add(getYamlListFukaKonkyo(cg, key4));
                yamlDatalist.add(getFuchoKibetsugaku(cg));
                yamlDatalist.add(getFuchoNofugaku(cg));
                yamlDatalist.add(getTokuchoKibetsugaku(cg));
                yamlDatalist.add(getTokuchoNofugaku(cg));
                yamlDatalist.add(getYamlListKikan(cg));
                yamlDatalist.add(getYamlListNengaku(cg));
                yamlDatalist.add(getYamlListChoteiJiyu(cg));
                break;
            }
        }

        return yamlDatalist;
    }

    /**
     * 賦課根拠データをList化
     *
     * @param cg
     * @return
     */
    private List getYamlListFukaKonkyo(ControlGenerator cg, RString key) {

        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.getAsRString("賦課基準日"));
        yamlDatalist.add(cg.getAsRString("資格取得日"));
        yamlDatalist.add(cg.getAsRString("資格喪失日"));
        yamlDatalist.add(cg.getAsRString("生保開始日"));
        yamlDatalist.add(cg.getAsRString("生保終了日"));
        yamlDatalist.add(cg.getAsRString("老年開始日"));
        yamlDatalist.add(cg.getAsRString("老年終了日"));
        yamlDatalist.add(cg.getAsRString("住所地特例"));

        if (!key.isEmpty()) {
            yamlDatalist.add(key);
            yamlDatalist.add(cg.getAsRString("本人課税"));
            yamlDatalist.add(cg.getAsRString("世帯課税"));
            yamlDatalist.add(cg.get("合計所得"));
        } else {
            yamlDatalist.add(key);
            yamlDatalist.add(cg.getAsRString("保険料段階_前年"));
            yamlDatalist.add(cg.getAsRString("保険料率_前年"));
            yamlDatalist.add(cg.getAsRString("年額保険料_前年"));
        }
        yamlDatalist.add(cg.get("年金収入額"));
        yamlDatalist.add(cg.getAsRString("保険料段階"));

        return yamlDatalist;
    }

    private List getTokuchoNofugaku(ControlGenerator cg) {
        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.get("特徴納付額1"));
        yamlDatalist.add(cg.get("特徴納付額2"));
        yamlDatalist.add(cg.get("特徴納付額3"));
        yamlDatalist.add(cg.get("特徴納付額4"));
        yamlDatalist.add(cg.get("特徴納付額5"));
        yamlDatalist.add(cg.get("特徴納付額6"));
        yamlDatalist.add(cg.get("特徴納付合計"));

        return yamlDatalist;
    }

    private List getTokuchoKibetsugaku(ControlGenerator cg) {
        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.get("特徴期別額1"));
        yamlDatalist.add(cg.get("特徴期別額2"));
        yamlDatalist.add(cg.get("特徴期別額3"));
        yamlDatalist.add(cg.get("特徴期別額4"));
        yamlDatalist.add(cg.get("特徴期別額5"));
        yamlDatalist.add(cg.get("特徴期別額6"));
        yamlDatalist.add(cg.get("特徴期別合計"));

        return yamlDatalist;
    }

    private List getFuchoNofugaku(ControlGenerator cg) {
        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.get("普徴納付額1"));
        yamlDatalist.add(cg.get("普徴納付額2"));
        yamlDatalist.add(cg.get("普徴納付額3"));
        yamlDatalist.add(cg.get("普徴納付額4"));
        yamlDatalist.add(cg.get("普徴納付額5"));
        yamlDatalist.add(cg.get("普徴納付額6"));
        yamlDatalist.add(cg.get("普徴納付額7"));
        yamlDatalist.add(cg.get("普徴納付額8"));
        yamlDatalist.add(cg.get("普徴納付額9"));
        yamlDatalist.add(cg.get("普徴納付額10"));
        yamlDatalist.add(cg.get("普徴納付額11"));
        yamlDatalist.add(cg.get("普徴納付額12"));
        yamlDatalist.add(cg.get("普徴納付額13"));
        yamlDatalist.add(cg.get("普徴納付額14"));
        yamlDatalist.add(cg.get("普徴納付合計"));

        return yamlDatalist;
    }

    private List getFuchoKibetsugaku(ControlGenerator cg) {
        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.get("普徴期別額1"));
        yamlDatalist.add(cg.get("普徴期別額2"));
        yamlDatalist.add(cg.get("普徴期別額3"));
        yamlDatalist.add(cg.get("普徴期別額4"));
        yamlDatalist.add(cg.get("普徴期別額5"));
        yamlDatalist.add(cg.get("普徴期別額6"));
        yamlDatalist.add(cg.get("普徴期別額7"));
        yamlDatalist.add(cg.get("普徴期別額8"));
        yamlDatalist.add(cg.get("普徴期別額9"));
        yamlDatalist.add(cg.get("普徴期別額10"));
        yamlDatalist.add(cg.get("普徴期別額11"));
        yamlDatalist.add(cg.get("普徴期別額12"));
        yamlDatalist.add(cg.get("普徴期別額13"));
        yamlDatalist.add(cg.get("普徴期別額14"));
        yamlDatalist.add(cg.get("普徴期別合計"));

        return yamlDatalist;
    }

    private List getYamlListKikan(ControlGenerator cg) {

        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.getAsRString("期間"));
        yamlDatalist.add(cg.getAsRString("月数"));
        yamlDatalist.add(cg.getAsRString("保険料段階"));
        yamlDatalist.add(cg.get("保険料率"));
        yamlDatalist.add(cg.get("保険料算出額"));
        yamlDatalist.add(cg.get("保険料額"));

        return yamlDatalist;
    }

    private List getYamlListNengaku(ControlGenerator cg) {

        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.getAsRString("計算上年間保険料額"));
        yamlDatalist.add(cg.getAsRString("減免額"));
        yamlDatalist.add(cg.getAsRString("確定年間保険料額"));

        return yamlDatalist;
    }

    private List getYamlListChoteiJiyu(ControlGenerator cg) {

        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.getAsRString("調定事由1"));
        yamlDatalist.add(cg.getAsRString("調定事由2"));
        yamlDatalist.add(cg.getAsRString("調定事由3"));
        yamlDatalist.add(cg.getAsRString("調定事由4"));

        return yamlDatalist;
    }

    /**
     * List の 値を確認し、int なら setComma を実行
     *
     * @param listData
     * @return
     */
    private List getFormatData(List listData) {
        List checkData = new ArrayList();
        List formatData = new ArrayList();

        for (int i = 0; i < listData.size(); i++) {

            checkData.clear();
            checkData.add(listData.get(i));

            if (checkData.get(0) == null) {
                formatData.add(RString.EMPTY);
            } else {
                boolean intCheck = intChecker(checkData);

                if (intCheck == true) {
                    formatData.add(setComma((int) listData.get(i)));
                } else {
                    formatData.add(listData.get(i));
                }
            }
        }

        return formatData;
    }

    /**
     * int かどうかチェック
     *
     * @param checkData
     * @return
     */
    private boolean intChecker(List checkData) {
        return checkData.get(0).getClass().getName().equals("java.lang.Integer");
    }

    /**
     * int をカンマ付で String に変換
     *
     * @param intData
     * @return
     */
    private RString setComma(int intData) {
        NumberFormat isComma = NumberFormat.getNumberInstance();

        RString commaData = new RString(isComma.format(intData));

        return commaData;
    }

    private void setFukaKonkyo(FukakonkyoAndKiwariDiv div, List formatData) {
        tblFukaKonkyoDiv tFukaKonkyo = div.getTblFukaKonkyo();
// TODO N8156 宮本 康 期割額Div変更に伴いコメント化
//        tblKiwariGakuDiv tKiwariGaku = div.getTblFukaKonkyo().getFukaShokaiKiwarigaku().getTblKiwariGaku();

        setKonkyo(tFukaKonkyo.getTblFukakonkyoMeisai(), (List) formatData.get(0));
// TODO N8156 宮本 康 期割額Div変更に伴いコメント化
//        setFuchoKibetsugaku(tKiwariGaku, (List) formatData.get(1));
//        setFuchoNofugaku(tKiwariGaku, (List) formatData.get(2));
//        setTokuKibetsugaku(tKiwariGaku, (List) formatData.get(3));
//        setTokuNofugaku(tKiwariGaku, (List) formatData.get(4));
        setKikan(tFukaKonkyo.getTblKikan(), (List) formatData.get(5));
        setNengaku(tFukaKonkyo.getFukakonkyoNengaku(), (List) formatData.get(6));
        setChoteiJiyu(tFukaKonkyo, (List) formatData.get(7));
    }

    private void setKonkyo(tblFukakonkyoMeisaiDiv konkyoDiv, List formatData) {
        // 賦課基準日
        konkyoDiv.getLblFukakijunYMD().setText((RString) formatData.get(0));
        // 資格取得日
        konkyoDiv.getLblShikakuShutokuYMD().setText((RString) formatData.get(1));
        // 資格喪失日
        konkyoDiv.getLblShikakuSoshitsuYMD().setText((RString) formatData.get(2));
        // 生保開始日
        konkyoDiv.getLblSeihoKaishiYMD().setText((RString) formatData.get(3));
        // 生保終了日
        konkyoDiv.getLblSeihoShuryoYMD().setText((RString) formatData.get(4));
        // 老年開始日
        konkyoDiv.getLblRonenKaishiYMD().setText((RString) formatData.get(5));
        // 老年終了日
        konkyoDiv.getLblRonenShuryoYMD().setText((RString) formatData.get(6));
        // 住所地特例

        RString key = (RString) formatData.get(8);

        if (!key.isEmpty()) {
            // 本人課税
            konkyoDiv.getLblHonninKazei().setDisplayNone(false);
            konkyoDiv.getLblZenHokenryoDankai().setDisplayNone(true);
            konkyoDiv.getLblHonninKazeiValue().setDisplayNone(false);
            konkyoDiv.getLblZenHokenryoDankaiValue().setDisplayNone(true);
            konkyoDiv.getLblHonninKazeiValue().setText((RString) formatData.get(9));
            konkyoDiv.getLblNenkinShunyu().setDisplayNone(false);
            konkyoDiv.getLblHokenryoDankai().setDisplayNone(false);

            // 世帯課税
            konkyoDiv.getLblSetaiKazei().setDisplayNone(false);
            konkyoDiv.getLblZenHokenryoritsu().setDisplayNone(true);
            konkyoDiv.getLblSetaiKazeiValue().setDisplayNone(false);
            konkyoDiv.getLblZenHokenryoritsuValue().setDisplayNone(true);
            konkyoDiv.getLblSetaiKazeiValue().setText((RString) formatData.get(10));
            // 合計所得
            konkyoDiv.getLblShotokuSum().setDisplayNone(false);
            konkyoDiv.getLblZenNengakuHokenryo().setDisplayNone(true);
            konkyoDiv.getLblShotokuSumValue().setDisplayNone(false);
            konkyoDiv.getLblZenNengakuHokenryoValue().setDisplayNone(true);
            konkyoDiv.getLblShotokuSumValue().setText((RString) formatData.get(11));
        } else {
            // 保険料段階
            konkyoDiv.getLblHonninKazei().setDisplayNone(true);
            konkyoDiv.getLblZenHokenryoDankai().setDisplayNone(false);
            konkyoDiv.getLblHonninKazeiValue().setDisplayNone(true);
            konkyoDiv.getLblZenHokenryoDankaiValue().setDisplayNone(false);
            konkyoDiv.getLblZenHokenryoDankaiValue().setText((RString) formatData.get(9));
            konkyoDiv.getLblNenkinShunyu().setDisplayNone(true);
            konkyoDiv.getLblHokenryoDankai().setDisplayNone(true);
            // 世帯課税
            konkyoDiv.getLblSetaiKazei().setDisplayNone(true);
            konkyoDiv.getLblZenHokenryoritsu().setDisplayNone(false);
            konkyoDiv.getLblSetaiKazeiValue().setDisplayNone(true);
            konkyoDiv.getLblZenHokenryoritsuValue().setDisplayNone(false);
            konkyoDiv.getLblZenHokenryoritsuValue().setText((RString) formatData.get(10));
            // 合計所得
            konkyoDiv.getLblShotokuSum().setDisplayNone(true);
            konkyoDiv.getLblZenNengakuHokenryo().setDisplayNone(false);
            konkyoDiv.getLblShotokuSumValue().setDisplayNone(true);
            konkyoDiv.getLblZenNengakuHokenryoValue().setDisplayNone(false);
            konkyoDiv.getLblZenNengakuHokenryoValue().setText((RString) formatData.get(11));
        }

        // 年金収入額
        konkyoDiv.getLblNenkinShunyuValue().setText((RString) formatData.get(12));

        // 保険料段階
        konkyoDiv.getLblHokenryoDankaiValue().setText((RString) formatData.get(13));
    }

// TODO N8156 宮本 康 期割額Div変更に伴いコメント化
//    private void setTokuNofugaku(tblKiwariGakuDiv tKiwariGaku, List formatData) {
//
//        tKiwariGaku.getLblTokuNofuGaku1().setText((RString) formatData.get(0));
//        tKiwariGaku.getLblTokuNofuGaku2().setText((RString) formatData.get(1));
//        tKiwariGaku.getLblTokuNofuGaku3().setText((RString) formatData.get(2));
//        tKiwariGaku.getLblTokuNofuGaku4().setText((RString) formatData.get(3));
//        tKiwariGaku.getLblTokuNofuGaku5().setText((RString) formatData.get(4));
//        tKiwariGaku.getLblTokuNofuGaku6().setText((RString) formatData.get(5));
//        tKiwariGaku.getLblTokuNofuGakuKei().setText((RString) formatData.get(6));
//    }
//
//    private void setTokuKibetsugaku(tblKiwariGakuDiv tKiwariGaku, List formatData) {
//        tKiwariGaku.getLblTokuKibetsuGaku1().setText((RString) formatData.get(0));
//        tKiwariGaku.getLblTokuKibetsuGaku2().setText((RString) formatData.get(1));
//        tKiwariGaku.getLblTokuKibetsuGaku3().setText((RString) formatData.get(2));
//        tKiwariGaku.getLblTokuKibetsuGaku4().setText((RString) formatData.get(3));
//        tKiwariGaku.getLblTokuKibetsuGaku5().setText((RString) formatData.get(4));
//        tKiwariGaku.getLblTokuKibetsuGaku6().setText((RString) formatData.get(5));
//    }
//
//    private void setFuchoNofugaku(tblKiwariGakuDiv tKiwariGaku, List formatData) {
//        tKiwariGaku.getLblFuchoNofuGaku1().setText((RString) formatData.get(0));
//        tKiwariGaku.getLblFuchoNofuGaku2().setText((RString) formatData.get(1));
//        tKiwariGaku.getLblFuchoNofuGaku3().setText((RString) formatData.get(2));
//        tKiwariGaku.getLblFuchoNofuGaku4().setText((RString) formatData.get(3));
//        tKiwariGaku.getLblFuchoNofuGaku5().setText((RString) formatData.get(4));
//        tKiwariGaku.getLblFuchoNofuGaku6().setText((RString) formatData.get(5));
//        tKiwariGaku.getLblFuchoNofuGaku7().setText((RString) formatData.get(6));
//        tKiwariGaku.getLblFuchoNofuGaku8().setText((RString) formatData.get(7));
//        tKiwariGaku.getLblFuchoNofuGaku9().setText((RString) formatData.get(8));
//        tKiwariGaku.getLblFuchoNofuGaku10().setText((RString) formatData.get(9));
//        tKiwariGaku.getLblFuchoNofuGaku11().setText((RString) formatData.get(10));
//        tKiwariGaku.getLblFuchoNofuGaku12().setText((RString) formatData.get(11));
//        tKiwariGaku.getLblFuchoNofuGaku13().setText((RString) formatData.get(12));
//        tKiwariGaku.getLblFuchoNofuGaku14().setText((RString) formatData.get(13));
//    }
//
//    private void setFuchoKibetsugaku(tblKiwariGakuDiv tKiwariGaku, List formatData) {
//        tKiwariGaku.getLblFuchoKibetsuGaku1().setText((RString) formatData.get(0));
//        tKiwariGaku.getLblFuchoKibetsuGaku2().setText((RString) formatData.get(1));
//        tKiwariGaku.getLblFuchoKibetsuGaku3().setText((RString) formatData.get(2));
//        tKiwariGaku.getLblFuchoKibetsuGaku4().setText((RString) formatData.get(3));
//        tKiwariGaku.getLblFuchoKibetsuGaku5().setText((RString) formatData.get(4));
//        tKiwariGaku.getLblFuchoKibetsuGaku6().setText((RString) formatData.get(5));
//        tKiwariGaku.getLblFuchoKibetsuGaku7().setText((RString) formatData.get(6));
//        tKiwariGaku.getLblFuchoKibetsuGaku8().setText((RString) formatData.get(7));
//        tKiwariGaku.getLblFuchoKibetsuGaku9().setText((RString) formatData.get(8));
//        tKiwariGaku.getLblFuchoKibetsuGaku10().setText((RString) formatData.get(9));
//        tKiwariGaku.getLblFuchoKibetsuGaku11().setText((RString) formatData.get(10));
//        tKiwariGaku.getLblFuchoKibetsuGaku12().setText((RString) formatData.get(11));
//        tKiwariGaku.getLblFuchoKibetsuGaku13().setText((RString) formatData.get(12));
//        tKiwariGaku.getLblFuchoKibetsuGaku14().setText((RString) formatData.get(13));
//    }
    private void setKikan(tblKikanDiv tblKikan, List formatData) {
        tblKikan.getLblKikan1().setText((RString) formatData.get(0));
        tblKikan.getLblTsukiSu1().setText((RString) formatData.get(1));
        tblKikan.getLblHokenryoDankai1().setText((RString) formatData.get(2));
        tblKikan.getLblHokenryoritsu1().setText((RString) formatData.get(3));
        tblKikan.getLblHokenryoSansyutsu1().setText((RString) formatData.get(4));
        tblKikan.getLblHokenryo1().setText((RString) formatData.get(5));

        if (formatData.get(1).toString().isEmpty()
                && formatData.get(2).toString().isEmpty()
                && formatData.get(3).toString().isEmpty()
                && formatData.get(4).toString().isEmpty()
                && formatData.get(5).toString().isEmpty()) {
            tblKikan.setDisplayNone(true);
        } else {
            tblKikan.setDisplayNone(false);
        }
    }

    private void setNengaku(FukakonkyoNengakuDiv fukakonkyoNengaku, List formatData) {

        RString 計算上年間保険料 = (RString) formatData.get(0);
        RString 減免額 = (RString) formatData.get(1);
        RString 確定年間保険料 = (RString) formatData.get(2);

        if (計算上年間保険料.length() > 0) {
            fukakonkyoNengaku.getTxtKeisanjoNenkanHokenryo().setValue(new Decimal(formatData.get(0).toString()));
        }
        if (減免額.length() > 0) {
            fukakonkyoNengaku.getTxtGemmen().setValue(new Decimal(formatData.get(1).toString()));
        }
        if (確定年間保険料.length() > 0) {
            fukakonkyoNengaku.getTxtNenkanHokenryo().setValue(new Decimal(formatData.get(2).toString()));
        }

        if (計算上年間保険料.length() > 0) {
            fukakonkyoNengaku.getTxtKeisanjoNenkanHokenryo().setDisplayNone(false);
            fukakonkyoNengaku.getTxtNenkanHokenryo().setLabelLText(new RString(("確定年間保険料額")));
        } else {
            fukakonkyoNengaku.getTxtKeisanjoNenkanHokenryo().setDisplayNone(true);
            fukakonkyoNengaku.getTxtNenkanHokenryo().setLabelLText(new RString(("暫定年間保険料額")));
        }
    }

    private void setChoteiJiyu(tblFukaKonkyoDiv tFukaKonkyo, List formatData) {
        tFukaKonkyo.getTxtFukashokaiChoteiJiyu1().setValue((RString) formatData.get(0));
        tFukaKonkyo.getTxtFukashokaiChoteiJiyu2().setValue((RString) formatData.get(1));
        tFukaKonkyo.getTxtFukashokaiChoteiJiyu3().setValue((RString) formatData.get(2));
        tFukaKonkyo.getTxtFukashokaiChoteiJiyu4().setValue((RString) formatData.get(3));
    }

    private void setControl(FukakonkyoAndKiwariDiv div, List formatData) {
        //setVisibleFukakonkyo(div.getTblFukaKonkyo().getFukakonkyoNengaku(), (List) formatData.get(6));
        setControlFukakonkyo(div.getTblFukaKonkyo(), (List) formatData.get(6));
    }

    private void setControlFukakonkyo(tblFukaKonkyoDiv tFukaKonkyo, List formatData) {
        RString 計算上年間保険料 = (RString) formatData.get(0);
        // RString 減免額 = (RString) formatData.get(1);
        // RString 確定年間保険料 = (RString) formatData.get(2);
        if (計算上年間保険料.isEmpty()) {
            tFukaKonkyo.getTblFukakonkyoMeisai().getLblHonninKazei().setVisible(false);
            tFukaKonkyo.getTblFukakonkyoMeisai().getLblSetaiKazei().setVisible(false);
            tFukaKonkyo.getTblFukakonkyoMeisai().getLblShotokuSum().setVisible(false);
            tFukaKonkyo.getTblFukakonkyoMeisai().getLblNenkinShunyu().setVisible(false);
            tFukaKonkyo.getTblFukakonkyoMeisai().getLblHokenryoDankai().setVisible(false);
            tFukaKonkyo.getFukakonkyoNengaku().getTxtNenkanHokenryo().setLabelLText(new RString("暫定保険料額合計"));
        }
    }
}
