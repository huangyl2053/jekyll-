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
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuFukakijun1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuFukakijun3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuHokenryo3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuKarisanteiHonsanteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuKibetsuGaku1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuKibetsuGaku3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuZanteiGaku1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuZennendo1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.KariSantei1Div;
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
public class FukaHikakuKarisanteiHonsantei {

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
    public ResponseData<FukaHikakuKarisanteiHonsanteiDiv> getOnLoadDataMae(FukaHikakuKarisanteiHonsanteiDiv div) {
        div.getKariSantei1().getTxtChoteiNendo1().setValue(new RString(""));
        RString selectedShikibetsuCode = new RString("00000000000019");

        setLoadData(div, selectedShikibetsuCode);
        return Response(div);
    }

    private ResponseData<FukaHikakuKarisanteiHonsanteiDiv> Response(FukaHikakuKarisanteiHonsanteiDiv div) {
        ResponseData<FukaHikakuKarisanteiHonsanteiDiv> response = new ResponseData<>();
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
    private void setLoadData(FukaHikakuKarisanteiHonsanteiDiv div, RString selectedShikibetsuCode) {

        KariSantei1Div kariSantei1 = div.getKariSantei1();
        HonSantei1Div honSantei1 = div.getHonSantei1();

        List loadData;
        loadData = getMaeHikakuMode(selectedShikibetsuCode);

        for (int i = 0; i < loadData.size(); i++) {
            List nowLoad = (List) loadData.get(i);
            List nowKihon = (List) nowLoad.get(0);
            RString 状態 = (RString) nowKihon.get(0);
            if (状態.contains("本")) {
                setHonSantei(div, (List) loadData.get(i));
            } else if (状態.contains("仮")) {
                setKariSantei(div, (List) loadData.get(i));
            }
        }
    }

    private List getMaeHikakuMode(RString selectedShikibetsuCode) {

        List 比較情報 = new ArrayList();

        for (int i = 0; i < 2; i++) {

            RString jotai;
            if (i > 0) {
                jotai = new RString("本");
            } else {
                jotai = new RString("仮");
            }

            比較情報.add(getYamlDataHonsantei(selectedShikibetsuCode, jotai));
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

    private void setKariSantei(FukaHikakuKarisanteiHonsanteiDiv div, List hikakuData) {

        KariSantei1Div kariSantei1 = div.getKariSantei1();
        FukaHikakuFukakijun1Div fukakijunKari1 = kariSantei1.getFukaHikakuFukakijun1();
        FukaHikakuZennendo1Div zennendoKari1 = kariSantei1.getFukaHikakuZennendo1();
        FukaHikakuZanteiGaku1Div zanteiGaku1 = kariSantei1.getFukaHikakuZanteiGaku1();
        FukaHikakuKibetsuGaku1Div kibetsuGaku1 = kariSantei1.getFukaHikakuKibetsuGaku1();

        List kihon = (List) hikakuData.get(0);
        kariSantei1.getTxtChoteiNendo1().setValue((RString) kihon.get(1));
        kariSantei1.getTxtFukaNendo1().setValue((RString) kihon.get(2));
        kariSantei1.getTxtTsuchiNo1().setValue((RString) kihon.get(3));
        kariSantei1.getTxtKoseiYMD1().setValue((RString) kihon.get(4));
        kariSantei1.getTxtKoseiYM1().setValue((RString) kihon.get(5));
        kariSantei1.getTxtShimei1().setValue((RString) kihon.get(6));
        kariSantei1.getTblChoteiJiyu1().getTxtChoteiJiyu11().setValue((RString) kihon.get(7));
        kariSantei1.getTblChoteiJiyu1().getTxtChoteiJiyu12().setValue((RString) kihon.get(8));
        kariSantei1.getTblChoteiJiyu1().getTxtChoteiJiyu13().setValue((RString) kihon.get(9));
        kariSantei1.getTblChoteiJiyu1().getTxtChoteiJiyu14().setValue((RString) kihon.get(10));

        List fukaKijun = (List) hikakuData.get(1);
        List checkData = new ArrayList();
        checkData.add(0, fukaKijun.get(0));
        Boolean 資格取得日 = rDateChecker(checkData);
        checkData.add(0, fukaKijun.get(1));
        Boolean 資格喪失日 = rDateChecker(checkData);
        if (資格取得日 == true) {
            fukakijunKari1.getTxtShikakuShutokuYMD1().setValue((RDate) fukaKijun.get(0));
        }
        if (資格喪失日 == true) {
            fukakijunKari1.getTxtShikakuSoshitsuYMD1().setValue((RDate) fukaKijun.get(1));
        }

        List zennendo = (List) hikakuData.get(2);
        zennendoKari1.getTxtHokenryoDankai1().setValue((RString) zennendo.get(0));
        zennendoKari1.getTxtHokenryoRitsu1().setValue((RString) zennendo.get(1));
        zennendoKari1.getTxtNengakuHokensryo1().setValue((RString) zennendo.get(2));

        List zanteiHokenryogaku = (List) hikakuData.get(3);
        zanteiGaku1.getTxtGemmenGaku1().setValue((RString) zanteiHokenryogaku.get(0));
        zanteiGaku1.getTxtGemmenGaku1().setValue((RString) zanteiHokenryogaku.get(1));

        List kibetsugaku = (List) hikakuData.get(4);
        List tokuchoKibetsu = (List) kibetsugaku.get(0);
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuKibetsuGaku1().setText((RString) tokuchoKibetsu.get(0));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuKibetsuGaku2().setText((RString) tokuchoKibetsu.get(1));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuKibetsuGaku3().setText((RString) tokuchoKibetsu.get(2));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuKibetsuGaku4().setText((RString) tokuchoKibetsu.get(3));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuKibetsuGaku5().setText((RString) tokuchoKibetsu.get(4));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuKibetsuGaku6().setText((RString) tokuchoKibetsu.get(5));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuKibetsuGakuKei().setText((RString) tokuchoKibetsu.get(6));

        List tokuchoNofugaku = (List) kibetsugaku.get(1);
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuNofuGaku1().setText((RString) tokuchoNofugaku.get(0));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuNofuGaku2().setText((RString) tokuchoNofugaku.get(1));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuNofuGaku3().setText((RString) tokuchoNofugaku.get(2));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuNofuGaku4().setText((RString) tokuchoNofugaku.get(3));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuNofuGaku5().setText((RString) tokuchoNofugaku.get(4));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuNofuGaku6().setText((RString) tokuchoNofugaku.get(5));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblTokuNofuGakuKei().setText((RString) tokuchoNofugaku.get(6));

        List fuchoKibetsu = (List) kibetsugaku.get(2);
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku1().setText((RString) fuchoKibetsu.get(0));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku2().setText((RString) fuchoKibetsu.get(1));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku3().setText((RString) fuchoKibetsu.get(2));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku4().setText((RString) fuchoKibetsu.get(3));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku5().setText((RString) fuchoKibetsu.get(4));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku6().setText((RString) fuchoKibetsu.get(5));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku7().setText((RString) fuchoKibetsu.get(6));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku8().setText((RString) fuchoKibetsu.get(7));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku9().setText((RString) fuchoKibetsu.get(8));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku10().setText((RString) fuchoKibetsu.get(9));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku11().setText((RString) fuchoKibetsu.get(10));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku12().setText((RString) fuchoKibetsu.get(11));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku13().setText((RString) fuchoKibetsu.get(12));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGaku14().setText((RString) fuchoKibetsu.get(13));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoKibetsuGakuKei().setText((RString) fuchoKibetsu.get(14));

        List fuchoNofugaku = (List) kibetsugaku.get(3);
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku1().setText((RString) fuchoNofugaku.get(0));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku2().setText((RString) fuchoNofugaku.get(1));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku3().setText((RString) fuchoNofugaku.get(2));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku4().setText((RString) fuchoNofugaku.get(3));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku5().setText((RString) fuchoNofugaku.get(4));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku6().setText((RString) fuchoNofugaku.get(5));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku7().setText((RString) fuchoNofugaku.get(6));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku8().setText((RString) fuchoNofugaku.get(7));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku9().setText((RString) fuchoNofugaku.get(8));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku10().setText((RString) fuchoNofugaku.get(9));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku11().setText((RString) fuchoNofugaku.get(10));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku12().setText((RString) fuchoNofugaku.get(11));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku13().setText((RString) fuchoNofugaku.get(12));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGaku14().setText((RString) fuchoNofugaku.get(13));
        kibetsuGaku1.getTblFukaHikakuKibetsuGaku1().getTblKiwariGaku().getLblFuchoNofuGakuKei().setText((RString) fuchoNofugaku.get(14));

    }

    private void setHonSantei(FukaHikakuKarisanteiHonsanteiDiv div, List hikakuData) {

        HonSantei1Div honSantei1 = div.getHonSantei1();
        FukaHikakuFukakijun3Div fukakijun3 = honSantei1.getFukaHikakuFukakijun3();
        FukaHikakuHokenryo3Div hokenryo3 = honSantei1.getFukaHikakuHokenryo3();
        FukaHikakuKibetsuGaku3Div kibetsuGaku3 = honSantei1.getFukaHikakuKibetsuGaku3();

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
    }
}
