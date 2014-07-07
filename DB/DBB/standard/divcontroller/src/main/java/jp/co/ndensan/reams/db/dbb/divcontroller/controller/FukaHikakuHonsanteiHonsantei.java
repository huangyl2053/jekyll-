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
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaHikakuFukakijun3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaHikakuFukakijun4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaHikakuHokenryo3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaHikakuHokenryo4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaHikakuHonsanteiHonsanteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaHikakuKibetsuGaku3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaHikakuKibetsuGaku4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.HonSantei2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * @author N8211 田辺 紘一
 */
public class FukaHikakuHonsanteiHonsantei {

    private static final RString FUKARIREKIALL = new RString("DBB0320001/FukaRirekiAll.yml");
    private static final RString FUKARIREKI = new RString("DBB0320001/FukaRireki.yml");
    private static final RString FUKAKONKYO = new RString("DBB0320002/FukaKonkyo.yml");
    private static final RString SETAISHOTOKU = new RString("DBB0320002/SetaiShotoku.yml");

    /**
     * 賦課照会比較ロード
     *
     * @param div
     * @return
     */
    public ResponseData<FukaHikakuHonsanteiHonsanteiDiv> getOnLoadDataNarabete(FukaHikakuHonsanteiHonsanteiDiv div) {

        List<RString> selectedShikibetsuCodeList = new ArrayList();

        // 比較データ固定
        div.getHonSantei1().getTxtChoteiNendo3().setValue(new RString(""));
        selectedShikibetsuCodeList.add(new RString("00000000000019"));
        selectedShikibetsuCodeList.add(new RString("00000000000027"));

        setLoadData(div, selectedShikibetsuCodeList);
        return Response(div);
    }

    private ResponseData<FukaHikakuHonsanteiHonsanteiDiv> Response(FukaHikakuHonsanteiHonsanteiDiv div) {
        ResponseData<FukaHikakuHonsanteiHonsanteiDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 比較用データを取得し反映
     *
     * @param div
     * @param shotokuDiv
     * @param rirekiDiv
     */
    private void setLoadData(FukaHikakuHonsanteiHonsanteiDiv div, List<RString> selectedShikibetsuCodeList) {

        List loadData = null;
        loadData = getNarabeteHyojiMode(selectedShikibetsuCodeList);

        for (int i = 0; i < loadData.size(); i++) {
            setHonSantei(div, (List) loadData.get(i));
        }
    }

    /**
     * 並べて表示ボタン押下時に実行
     *
     * @param shotokuDiv
     * @return
     */
    private List getNarabeteHyojiMode(List<RString> selectedShikibetsuCode) {

        List 比較情報 = new ArrayList();

        for (RString shikibetsuCode : selectedShikibetsuCode) {
            比較情報.add(getYamlDataHonsantei(shikibetsuCode, new RString("本")));
        }

        return 比較情報;
    }

    /**
     * 本算定の基本情報を含むYamlデータを必要箇所のみ取得
     *
     * @param yamlFileName
     * @param key 識別コード
     * @param key2 状態（本 or 仮）
     * @return
     */
    private List getYamlDataHonsantei(RString key, RString key2) {

        List keyList = null;
        List getYamlKihon = null;
        List getYamlZennendo = null;
        List getYamlHokenryogaku;
        List getYamlFukaKijun;
        List getYamlDataList = new ArrayList();

        List yamlKihonFormatData = null;
        List yamlFukaKijunFormatData = null;
        List yamlZennendFormatData = null;
        List yamlHokenryogakuFormatData = null;
        List yamlKibetsugakuFormatData = new ArrayList();

        RString key3 = RString.EMPTY;
        RString key4 = RString.EMPTY;
        RString key5 = RString.EMPTY;

        //Yaml データ読み込み
        List<HashMap> fukaRirekiAll = YamlLoader.DBB.loadAsList(FUKARIREKIALL);

        for (int i = 0; i < (int) fukaRirekiAll.size(); i++) {
            ControlGenerator cg = new ControlGenerator(fukaRirekiAll.get(i));

            if (key.contains(cg.getAsRString("識別番号"))) {
                // keyList取得
                keyList = getYamlListKey(cg);

                break;
            }
        }

        //Yaml データ読み込み
        List<HashMap> fukaRireki = YamlLoader.DBB.loadAsList(FUKARIREKI);

        for (int i = 0; i < (int) fukaRireki.size(); i++) {

            ControlGenerator cg = new ControlGenerator(fukaRireki.get(i));

            key3 = (RString) keyList.get(0);
            key4 = (RString) keyList.get(1);
            key5 = (RString) keyList.get(2);

            if (key.contains(cg.getAsRString("識別コード"))
                    & key2.contains(cg.getAsRString("状態"))
                    & key3.contains(cg.getAsRString("調定年度"))
                    & key4.contains(cg.getAsRString("賦課年度"))
                    & key5.contains(cg.getAsRString("通知書番号"))) {

                // 状態 調定年度 賦課年度 通知書番号 更正日 更正時  を追加
                getYamlKihon = getYamlListKihon(cg);

                break;
            }
        }

        //Yaml データ読み込み
        List<HashMap> fukaSetai = YamlLoader.DBB.loadAsList(SETAISHOTOKU);

        for (int i = 0; i < (int) fukaSetai.size(); i++) {

            ControlGenerator cg = new ControlGenerator(fukaSetai.get(i));

            if (key.contains(cg.getAsRString("識別コード"))) {

                // 氏名  を追加
                getYamlKihon = getYamlListShimei(cg, getYamlKihon);

                break;
            }
        }

        //Yaml データ読み込み
        List<HashMap> fukaKonkyo = YamlLoader.DBB.loadAsList(FUKAKONKYO);

        for (int i = 0; i < (int) fukaKonkyo.size(); i++) {

            ControlGenerator cg = new ControlGenerator(fukaKonkyo.get(i));

            if (key2.contains(cg.getAsRString("状態"))
                    & key3.contains(cg.getAsRString("調定年度"))
                    & key4.contains(cg.getAsRString("賦課年度"))
                    & key5.contains(cg.getAsRString("通知書番号"))) {

                // 調定事由 を追加
                getYamlKihon = getYamlListChoteiJiyu(cg, getYamlKihon);

                // 本算定時　資格取得日 資格喪失日 合計所得金額 年金収入額 本人課税 世帯課税 世帯員数  を追加
                // 仮算定時  資格取得日 資格喪失日
                getYamlFukaKijun = getYamlFukaKijun(cg, key2);

                if (key2.contains("仮")) {
                    getYamlZennendo = getYamlListZennendo(cg);
                }

                // 本算定時  保険料段階 計算上年間保険料額 減免額 確定年間保険料額  を追加
                // 仮算定時  減免額　暫定保険料合計額(確定年間保険料額)
                getYamlHokenryogaku = getYamlHokenryogaku(cg, key2);

                // 特徴 期別額 を追加
                List getYamlListTokuchoKibetsugaku = getYamlListTokuchoKibetsugaku(cg);

                // 特徴 納付額 を追加
                List getYamlListTokuchoNofugaku = getYamlListTokuchoNofugaku(cg);

                // 普徴 期別額 を追加
                List getYamlListFuchoKibetsugaku = getYamlListFuchoKibetsugaku(cg);

                // 普徴 納付額 を追加
                List getYamlListFuchoNofugaku = getYamlListFuchoNofugaku(cg);

                // データをフォーマット
                yamlKihonFormatData = getFormatData(getYamlKihon);
                yamlFukaKijunFormatData = getFormatData(getYamlFukaKijun);
                if (key2.contains("仮")) {
                    yamlZennendFormatData = getFormatData(getYamlZennendo);
                }
                yamlHokenryogakuFormatData = getFormatData(getYamlHokenryogaku);
                yamlKibetsugakuFormatData.add(getFormatData(getYamlListTokuchoKibetsugaku));
                yamlKibetsugakuFormatData.add(getFormatData(getYamlListTokuchoNofugaku));
                yamlKibetsugakuFormatData.add(getFormatData(getYamlListFuchoKibetsugaku));
                yamlKibetsugakuFormatData.add(getFormatData(getYamlListFuchoNofugaku));

                break;
            }
        }

        getYamlDataList.add(yamlKihonFormatData);
        getYamlDataList.add(yamlFukaKijunFormatData);
        if (key2.contains("仮")) {
            getYamlDataList.add(yamlZennendFormatData);
        }
        getYamlDataList.add(yamlHokenryogakuFormatData);
        getYamlDataList.add(yamlKibetsugakuFormatData);

        return getYamlDataList;
    }

    private List getYamlListKey(ControlGenerator cg) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.getAsRString("調定年度"));
        yamlValue.add(cg.getAsRString("賦課年度"));
        yamlValue.add(cg.getAsRString("通知書番号"));

        return yamlValue;
    }

    private List getYamlListKihon(ControlGenerator cg) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.getAsRString("状態"));
        yamlValue.add(cg.getAsRString("調定年度"));
        yamlValue.add(cg.getAsRString("賦課年度"));
        yamlValue.add(cg.getAsRString("通知書番号"));

        RStringBuilder buf = new RStringBuilder();
        buf.append(cg.getAsRString("更正日"));
        buf.append(" ");
        buf.append(cg.getAsRString("更正時"));
        yamlValue.add(buf.toRString());
        yamlValue.add(cg.getAsRString("更正月"));

        return yamlValue;
    }

    private List getYamlListShimei(ControlGenerator cg, List yamlKihon) {
        yamlKihon.add(cg.getAsRString("氏名"));

        return yamlKihon;
    }

    private List getYamlListChoteiJiyu(ControlGenerator cg, List yamlKihon) {
        yamlKihon.add(cg.getAsRString("調定事由1"));
        yamlKihon.add(cg.getAsRString("調定事由2"));
        yamlKihon.add(cg.getAsRString("調定事由3"));
        yamlKihon.add(cg.getAsRString("調定事由4"));

        return yamlKihon;
    }

    private List getYamlListZennendo(ControlGenerator cg) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.getAsRString("保険料段階_前年"));
        yamlValue.add(cg.get("保険料率_前年"));
        yamlValue.add(cg.get("年額保険料_前年"));

        return yamlValue;
    }

    private List getYamlListFuchoKibetsugaku(ControlGenerator cg) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.get("普徴期別額1"));
        yamlValue.add(cg.get("普徴期別額2"));
        yamlValue.add(cg.get("普徴期別額3"));
        yamlValue.add(cg.get("普徴期別額4"));
        yamlValue.add(cg.get("普徴期別額5"));
        yamlValue.add(cg.get("普徴期別額6"));
        yamlValue.add(cg.get("普徴期別額7"));
        yamlValue.add(cg.get("普徴期別額8"));
        yamlValue.add(cg.get("普徴期別額9"));
        yamlValue.add(cg.get("普徴期別額10"));
        yamlValue.add(cg.get("普徴期別額11"));
        yamlValue.add(cg.get("普徴期別額12"));
        yamlValue.add(cg.get("普徴期別額13"));
        yamlValue.add(cg.get("普徴期別額14"));
        yamlValue.add(cg.get("普徴期別合計"));

        return yamlValue;
    }

    private List getYamlListFuchoNofugaku(ControlGenerator cg) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.get("普徴納付額1"));
        yamlValue.add(cg.get("普徴納付額2"));
        yamlValue.add(cg.get("普徴納付額3"));
        yamlValue.add(cg.get("普徴納付額4"));
        yamlValue.add(cg.get("普徴納付額5"));
        yamlValue.add(cg.get("普徴納付額6"));
        yamlValue.add(cg.get("普徴納付額7"));
        yamlValue.add(cg.get("普徴納付額8"));
        yamlValue.add(cg.get("普徴納付額9"));
        yamlValue.add(cg.get("普徴納付額10"));
        yamlValue.add(cg.get("普徴納付額11"));
        yamlValue.add(cg.get("普徴納付額12"));
        yamlValue.add(cg.get("普徴納付額13"));
        yamlValue.add(cg.get("普徴納付額14"));
        yamlValue.add(cg.get("普徴納付合計"));

        return yamlValue;
    }

    private List getYamlListTokuchoKibetsugaku(ControlGenerator cg) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.get("特徴期別額1"));
        yamlValue.add(cg.get("特徴期別額2"));
        yamlValue.add(cg.get("特徴期別額3"));
        yamlValue.add(cg.get("特徴期別額4"));
        yamlValue.add(cg.get("特徴期別額5"));
        yamlValue.add(cg.get("特徴期別額6"));
        yamlValue.add(cg.get("特徴期別合計"));

        return yamlValue;
    }

    private List getYamlListTokuchoNofugaku(ControlGenerator cg) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.get("特徴納付額1"));
        yamlValue.add(cg.get("特徴納付額2"));
        yamlValue.add(cg.get("特徴納付額3"));
        yamlValue.add(cg.get("特徴納付額4"));
        yamlValue.add(cg.get("特徴納付額5"));
        yamlValue.add(cg.get("特徴納付額6"));
        yamlValue.add(cg.get("特徴納付合計"));

        return yamlValue;
    }

    private List getYamlFukaKijun(ControlGenerator cg, RString key) {
        List yamlValue = new ArrayList();

        yamlValue.add(cg.getAsRDate("資格取得日"));
        yamlValue.add(cg.getAsRDate("資格喪失日"));

        if (key.contains("本")) {
            yamlValue.add(cg.get("合計所得"));
            yamlValue.add(cg.get("年金収入額"));
            yamlValue.add(cg.getAsRString("本人課税"));
            yamlValue.add(cg.getAsRString("世帯課税"));
            yamlValue.add(cg.getAsRString("世帯員数"));
        }

        return yamlValue;
    }

    private List getYamlHokenryogaku(ControlGenerator cg, RString key) {
        List yamlValue = new ArrayList();

        if (key.contains("本")) {
            yamlValue.add(0, cg.getAsRString("保険料段階"));
            yamlValue.add(1, cg.getAsRString("境界層変更"));
            yamlValue.add(2, cg.get("計算上年間保険料額"));
            yamlValue.add(3, cg.get("減免額"));
            yamlValue.add(4, cg.get("確定年間保険料額"));
            yamlValue.add(5, cg.get("特徴歳出還付額"));
            yamlValue.add(6, cg.get("普徴歳出還付額"));
        } else {
            yamlValue.add(cg.get("減免額"));
            yamlValue.add(cg.get("確定年間保険料額"));
        }

        return yamlValue;
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
                formatData.add(new RString(""));
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
     * RDate かどうかチェック
     *
     * @param checkData
     * @return
     */
    private boolean rDateChecker(List checkData) {
        return checkData.get(0).getClass().getName().equals("jp.co.ndensan.reams.uz.uza.lang.RDate");
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

    private void setHonSantei(FukaHikakuHonsanteiHonsanteiDiv div, List hikakuData) {

        HonSantei1Div honSantei1 = div.getHonSantei1();
        FukaHikakuFukakijun3Div fukakijun3 = honSantei1.getFukaHikakuFukakijun3();
        FukaHikakuHokenryo3Div hokenryo3 = honSantei1.getFukaHikakuHokenryo3();
        FukaHikakuKibetsuGaku3Div kibetsuGaku3 = honSantei1.getFukaHikakuKibetsuGaku3();

        HonSantei2Div honSantei2 = div.getHonSantei2();
        FukaHikakuFukakijun4Div fukakijun4 = honSantei2.getFukaHikakuFukakijun4();
        FukaHikakuHokenryo4Div hokenryo4 = honSantei2.getFukaHikakuHokenryo4();
        FukaHikakuKibetsuGaku4Div kibetsuGaku4 = honSantei2.getFukaHikakuKibetsuGaku4();

        if (honSantei1.getTxtChoteiNendo3().getValue().length() <= 0) {
            honSantei1.setDisplayNone(false);

            List kihon = (List) hikakuData.get(0);
            honSantei1.getTxtChoteiNendo3().setValue((RString) kihon.get(1));
            honSantei1.getTxtFukaNendo3().setValue((RString) kihon.get(2));
            honSantei1.getTxtTsuchiNo3().setValue((RString) kihon.get(3));
            honSantei1.getTxtKoseiYMD3().setValue((RString) kihon.get(4));
            honSantei1.getTxtKoseiYM3().setValue((RString) kihon.get(5));
            honSantei1.getTxtShimei3().setValue((RString) kihon.get(6));
            honSantei1.getTblChoteiJiyu3().getTxtChoteiJiyu31().setValue((RString) kihon.get(7));
            honSantei1.getTblChoteiJiyu3().getTxtChoteiJiyu32().setValue((RString) kihon.get(8));
            honSantei1.getTblChoteiJiyu3().getTxtChoteiJiyu33().setValue((RString) kihon.get(9));
            honSantei1.getTblChoteiJiyu3().getTxtChoteiJiyu34().setValue((RString) kihon.get(10));

            List fukaKijun = (List) hikakuData.get(1);
            List checkData = new ArrayList();
            checkData.add(0, fukaKijun.get(0));
            Boolean 資格取得日 = rDateChecker(checkData);
            checkData.add(0, fukaKijun.get(1));
            Boolean 資格喪失日 = rDateChecker(checkData);
            if (資格取得日 == true) {
                fukakijun3.getTxtShikakuShutokuYMD3().setValue((RDate) fukaKijun.get(0));
            }
            if (資格喪失日 == true) {
                fukakijun3.getTxtShikakusoshitsuYMD3().setValue((RDate) fukaKijun.get(1));
            }
            fukakijun3.getTxtGoukeiShotoku3().setValue((RString) fukaKijun.get(2));
            fukakijun3.getTxtNenkinShunyu3().setValue((RString) fukaKijun.get(3));
            fukakijun3.getTxtHonninKazei3().setValue((RString) fukaKijun.get(4));
            fukakijun3.getTxtSetaiKazei3().setValue((RString) fukaKijun.get(5));
            fukakijun3.getTxtSetaiinSu3().setValue((RString) fukaKijun.get(6));

            List fukaHokenryo = (List) hikakuData.get(2);
            hokenryo3.getTxtHokenryoDankai3().setValue((RString) fukaHokenryo.get(0));
            hokenryo3.getTxtKyokaiso3().setValue((RString) fukaHokenryo.get(1));
            hokenryo3.getTxtKeisanHokenryogaku3().setValue((RString) fukaHokenryo.get(2));
            hokenryo3.getTxtGemmenGaku3().setValue((RString) fukaHokenryo.get(3));
            hokenryo3.getTxtKakuteiHokenryo3().setValue((RString) fukaHokenryo.get(4));
            hokenryo3.getTxtTokuchoSaishutukanpu3().setValue((RString) fukaHokenryo.get(5));
            hokenryo3.getTxtFuchoSaishutukanpu3().setValue((RString) fukaHokenryo.get(6));

            List kibetsugaku = (List) hikakuData.get(3);
            List tokuchoKibetsu = (List) kibetsugaku.get(0);
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText((RString) tokuchoKibetsu.get(0));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuKibetsuGaku2().setText((RString) tokuchoKibetsu.get(1));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuKibetsuGaku3().setText((RString) tokuchoKibetsu.get(2));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuKibetsuGaku4().setText((RString) tokuchoKibetsu.get(3));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuKibetsuGaku5().setText((RString) tokuchoKibetsu.get(4));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuKibetsuGaku6().setText((RString) tokuchoKibetsu.get(5));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuKibetsuGakuKei().setText((RString) tokuchoKibetsu.get(6));

            List tokuchoNofugaku = (List) kibetsugaku.get(1);
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku1().setText((RString) tokuchoNofugaku.get(0));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku2().setText((RString) tokuchoNofugaku.get(1));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku3().setText((RString) tokuchoNofugaku.get(2));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku4().setText((RString) tokuchoNofugaku.get(3));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku5().setText((RString) tokuchoNofugaku.get(4));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGaku6().setText((RString) tokuchoNofugaku.get(5));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblTokuNofuGakuKei().setText((RString) tokuchoNofugaku.get(6));

            List fuchoKibetsu = (List) kibetsugaku.get(2);
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku1().setText((RString) fuchoKibetsu.get(0));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku2().setText((RString) fuchoKibetsu.get(1));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku3().setText((RString) fuchoKibetsu.get(2));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku4().setText((RString) fuchoKibetsu.get(3));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku5().setText((RString) fuchoKibetsu.get(4));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku6().setText((RString) fuchoKibetsu.get(5));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku7().setText((RString) fuchoKibetsu.get(6));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku8().setText((RString) fuchoKibetsu.get(7));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku9().setText((RString) fuchoKibetsu.get(8));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku10().setText((RString) fuchoKibetsu.get(9));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku11().setText((RString) fuchoKibetsu.get(10));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku12().setText((RString) fuchoKibetsu.get(11));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku13().setText((RString) fuchoKibetsu.get(12));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGaku14().setText((RString) fuchoKibetsu.get(13));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoKibetsuGakuKei().setText((RString) fuchoKibetsu.get(14));

            List fuchoNofugaku = (List) kibetsugaku.get(3);
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku1().setText((RString) fuchoNofugaku.get(0));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku2().setText((RString) fuchoNofugaku.get(1));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku3().setText((RString) fuchoNofugaku.get(2));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku4().setText((RString) fuchoNofugaku.get(3));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku5().setText((RString) fuchoNofugaku.get(4));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku6().setText((RString) fuchoNofugaku.get(5));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku7().setText((RString) fuchoNofugaku.get(6));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku8().setText((RString) fuchoNofugaku.get(7));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku9().setText((RString) fuchoNofugaku.get(8));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku10().setText((RString) fuchoNofugaku.get(9));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku11().setText((RString) fuchoNofugaku.get(10));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku12().setText((RString) fuchoNofugaku.get(11));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku13().setText((RString) fuchoNofugaku.get(12));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGaku14().setText((RString) fuchoNofugaku.get(13));
            kibetsuGaku3.getTblFukaHikakuKibetsuGaku3().getTblKiwariGaku().getLblFuchoNofuGakuKei().setText((RString) fuchoNofugaku.get(14));
        } else {

            honSantei2.setDisplayNone(false);

            List kihon = (List) hikakuData.get(0);
            honSantei2.getTxtChoteiNendo4().setValue((RString) kihon.get(1));
            honSantei2.getTxtFukaNendo4().setValue((RString) kihon.get(2));
            honSantei2.getTxtTsuchiNo4().setValue((RString) kihon.get(3));
            honSantei2.getTxtKoseiYMD4().setValue((RString) kihon.get(4));
            honSantei2.getTxtKoseiYM4().setValue((RString) kihon.get(5));
            honSantei2.getTxtShimei4().setValue((RString) kihon.get(6));
            honSantei2.getTblChoteiJiyu4().getTxtChoteiJiyu41().setValue((RString) kihon.get(7));
            honSantei2.getTblChoteiJiyu4().getTxtChoteiJiyu42().setValue((RString) kihon.get(8));
            honSantei2.getTblChoteiJiyu4().getTxtChoteiJiyu43().setValue((RString) kihon.get(9));
            honSantei2.getTblChoteiJiyu4().getTxtChoteiJiyu44().setValue((RString) kihon.get(10));

            List fukaKijun = (List) hikakuData.get(1);
            List checkData = new ArrayList();
            checkData.add(0, fukaKijun.get(0));
            Boolean 資格取得日 = rDateChecker(checkData);
            checkData.add(0, fukaKijun.get(1));
            Boolean 資格喪失日 = rDateChecker(checkData);
            if (資格取得日 == true) {
                fukakijun4.getTxtShikakuShutokuYMD4().setValue((RDate) fukaKijun.get(0));
            }
            if (資格喪失日 == true) {
                fukakijun4.getTxtShikakuSoshitsuYMD4().setValue((RDate) fukaKijun.get(1));
            }
            fukakijun4.getTxtGoukeiShotoku4().setValue((RString) fukaKijun.get(2));
            fukakijun4.getTxtNenkinShunyu4().setValue((RString) fukaKijun.get(3));
            fukakijun4.getTxtHonninKazei4().setValue((RString) fukaKijun.get(4));
            fukakijun4.getTxtSetaiKazei4().setValue((RString) fukaKijun.get(5));
            fukakijun4.getTxtSetaiinSu4().setValue((RString) fukaKijun.get(6));

            List fukaHokenryo = (List) hikakuData.get(2);
            hokenryo4.getTxtHokenryoDankai4().setValue((RString) fukaHokenryo.get(0));
            hokenryo4.getTxtKyokaiso4().setValue((RString) fukaHokenryo.get(1));
            hokenryo4.getTxtKeisanHokenryogaku4().setValue((RString) fukaHokenryo.get(2));
            hokenryo4.getTxtGemmenGaku4().setValue((RString) fukaHokenryo.get(3));
            hokenryo4.getTxtKakuteiHokenryo4().setValue((RString) fukaHokenryo.get(4));
            hokenryo4.getTxtTokuchoSaishutukanpu4().setValue((RString) fukaHokenryo.get(5));
            hokenryo4.getTxtFuchoSaishutukanpu4().setValue((RString) fukaHokenryo.get(6));

            List kibetsugaku = (List) hikakuData.get(3);
            List tokuchoKibetsu = (List) kibetsugaku.get(0);
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText((RString) tokuchoKibetsu.get(0));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku2().setText((RString) tokuchoKibetsu.get(1));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku3().setText((RString) tokuchoKibetsu.get(2));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku4().setText((RString) tokuchoKibetsu.get(3));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku5().setText((RString) tokuchoKibetsu.get(4));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGaku6().setText((RString) tokuchoKibetsu.get(5));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuKibetsuGakuKei().setText((RString) tokuchoKibetsu.get(6));

            List tokuchoNofugaku = (List) kibetsugaku.get(1);
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuNofuGaku1().setText((RString) tokuchoNofugaku.get(0));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuNofuGaku2().setText((RString) tokuchoNofugaku.get(1));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuNofuGaku3().setText((RString) tokuchoNofugaku.get(2));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuNofuGaku4().setText((RString) tokuchoNofugaku.get(3));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuNofuGaku5().setText((RString) tokuchoNofugaku.get(4));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuNofuGaku6().setText((RString) tokuchoNofugaku.get(5));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblTokuNofuGakuKei().setText((RString) tokuchoNofugaku.get(6));

            List fuchoKibetsu = (List) kibetsugaku.get(2);
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku1().setText((RString) fuchoKibetsu.get(0));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku2().setText((RString) fuchoKibetsu.get(1));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku3().setText((RString) fuchoKibetsu.get(2));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku4().setText((RString) fuchoKibetsu.get(3));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku5().setText((RString) fuchoKibetsu.get(4));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku6().setText((RString) fuchoKibetsu.get(5));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku7().setText((RString) fuchoKibetsu.get(6));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku8().setText((RString) fuchoKibetsu.get(7));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku9().setText((RString) fuchoKibetsu.get(8));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku10().setText((RString) fuchoKibetsu.get(9));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku11().setText((RString) fuchoKibetsu.get(10));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku12().setText((RString) fuchoKibetsu.get(11));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku13().setText((RString) fuchoKibetsu.get(12));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGaku14().setText((RString) fuchoKibetsu.get(13));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoKibetsuGakuKei().setText((RString) fuchoKibetsu.get(14));

            List fuchoNofugaku = (List) kibetsugaku.get(3);
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku1().setText((RString) fuchoNofugaku.get(0));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku2().setText((RString) fuchoNofugaku.get(1));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku3().setText((RString) fuchoNofugaku.get(2));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku4().setText((RString) fuchoNofugaku.get(3));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku5().setText((RString) fuchoNofugaku.get(4));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku6().setText((RString) fuchoNofugaku.get(5));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku7().setText((RString) fuchoNofugaku.get(6));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku8().setText((RString) fuchoNofugaku.get(7));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku9().setText((RString) fuchoNofugaku.get(8));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku10().setText((RString) fuchoNofugaku.get(9));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku11().setText((RString) fuchoNofugaku.get(10));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku12().setText((RString) fuchoNofugaku.get(11));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku13().setText((RString) fuchoNofugaku.get(12));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGaku14().setText((RString) fuchoNofugaku.get(13));
            kibetsuGaku4.getTblFukaHikakuKibetsuGaku4().getTblKiwariGaku().getLblFuchoNofuGakuKei().setText((RString) fuchoNofugaku.get(14));
        }
    }
}
