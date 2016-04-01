/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020091;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091.YoshikiNinonanaHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業報告（月報）補正発行_様式２の７補正のクラス
 */
public class YoshikiNinonanaHoseiHandler {

    private static final Code 集計番号_0701 = new Code("0701");
    private static final Code 集計番号_0702 = new Code("0702");
    private static final Code 集計番号_0703 = new Code("0703");
    private static final Code 集計番号_0704 = new Code("0704");
    private static final Code 集計番号_0705 = new Code("0705");
    private static final Code 集計番号_0706 = new Code("0706");
    private static final Code 集計番号_0707 = new Code("0707");
    private static final Code 集計番号_0801 = new Code("0801");
    private static final Code 集計番号_0802 = new Code("0802");
    private static final Code 集計番号_0803 = new Code("0803");
    private static final Code 集計番号_0804 = new Code("0804");
    private static final Code 集計番号_0805 = new Code("0805");
    private static final Decimal 横番号_0001 = new Decimal("0001");
    private static final Decimal 横番号_0002 = new Decimal("0002");
    private static final Decimal 横番号_0003 = new Decimal("0003");
    private static final Decimal 縦番号_0001 = new Decimal("0001");
    private static final Decimal 縦番号_0002 = new Decimal("0002");
    private static final Code 表番号_06 = new Code("06");
    private static final Code 表番号_07 = new Code("07");
    private static final RString 様式種類_039 = new RString("039");
    private static final RString 様式種類_139 = new RString("139");
    private static final RString 様式種類_239 = new RString("239");
    private static final RString 様式種類_040 = new RString("040");
    private static final RString 様式種類_140 = new RString("140");
    private static final RString 様式種類_240 = new RString("240");

    private final YoshikiNinonanaHoseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YoshikiNinonanaHoseiDiv
     */
    public YoshikiNinonanaHoseiHandler(YoshikiNinonanaHoseiDiv div) {
        this.div = div;
    }

    /**
     * setViewState
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     */
    public void setViewState(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        initializeKihoneria(引き継ぎデータ);
    }

    /**
     * 修正データリストより、修正データがないかどうかを判断する。
     *
     * @param 修正データリスト List<JigyoHokokuNenpoUpdateParameter>
     * @return boolean
     */
    public boolean is修正データ無し(List<JigyoHokokuTokeiData> 修正データリスト) {
        return (null == 修正データリスト || 修正データリスト.isEmpty());
    }

    private boolean is整合性チェック_NG_1() {
        if (div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu3().getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean is整合性チェック_NG_2() {
        if (div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku1().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu1().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku3().getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean is整合性チェック_NG_3() {
        if (div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku1().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku1().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu3().getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean is整合性チェック_NG_4() {
        if (div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku3().getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean is整合性チェック_NG_5() {
        if (div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu3().getValue())) {
                return true;
            }
        }
        if (div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku1().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku2().getValue() != null
                && div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku3().getValue() != null) {
            if (!div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku1().getValue().add(
                    div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku2().getValue()).equals(
                            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku3().getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * is整合性チェック_NG
     *
     * @return boolean
     */
    public boolean is整合性チェック_NG() {

        return is整合性チェック_NG_1() || is整合性チェック_NG_2() || is整合性チェック_NG_3()
                || is整合性チェック_NG_4() || is整合性チェック_NG_5();
    }

    /**
     * 画面から修正データリストをDBに更新する。
     *
     * @param 修正データリスト List<JigyoHokokuNenpoUpdateParameter>
     */
    public void update(List<JigyoHokokuTokeiData> 修正データリスト) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.updateJigyoHokokuGeppoEntity(修正データリスト);
    }

    /**
     * 引き継ぎデータより、データ1削除する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @return boolean
     */
    public boolean delete削除状態1(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        int row = deleteByParameter(引き継ぎデータ, 表番号_06, 集計番号_0701);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_06, 集計番号_0702);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_06, 集計番号_0703);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_06, 集計番号_0704);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_06, 集計番号_0705);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_06, 集計番号_0706);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_06, 集計番号_0707);
        return 0 <= row;
    }

    /**
     * 引き継ぎデータより、データ2削除する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @return boolean
     */
    public boolean delete削除状態2(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        int row = deleteByParameter(引き継ぎデータ, 表番号_07, 集計番号_0801);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_07, 集計番号_0802);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_07, 集計番号_0803);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_07, 集計番号_0804);
        row = row + deleteByParameter(引き継ぎデータ, 表番号_07, 集計番号_0805);
        return 0 <= row;
    }

//    private int deleteByParameter(JigyoHokokuGeppoParameter 引き継ぎデータ, Code 表番号, Code 集計番号) {
//        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
//        JigyoHokokuGeppoDetalSearchParameter parameter
//                = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(
//                        new FlexibleYear(new RString("2010")),
//                        new RString("06"),
//                        new FlexibleYear(new RString("2010")),
//                        new RString("06"),
//                        new RString("3"),
//                        new LasdecCode(new RString("209008")),
//                        表番号,
//                        集計番号);
//        return finder.deleteJigyoHokokuGeppoData(parameter);
//    }
    private int deleteByParameter(JigyoHokokuGeppoParameter 引き継ぎデータ, Code 表番号, Code 集計番号) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        JigyoHokokuGeppoDetalSearchParameter parameter
                = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear(引き継ぎデータ.get行報告年()),
                        引き継ぎデータ.get行報告月(),
                        new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                        引き継ぎデータ.get行集計対象月(),
                        引き継ぎデータ.get行統計対象区分(),
                        new LasdecCode(引き継ぎデータ.get行市町村コード()),
                        表番号,
                        集計番号);
        return finder.deleteJigyoHokokuGeppoData(parameter);
    }

    /**
     * initializeKihoneria
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     */
    public void initializeKihoneria(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        FlexibleDate 報告年月 = new FlexibleDate(引き継ぎデータ.get報告年月());
        FlexibleDate 集計年月 = new FlexibleDate(引き継ぎデータ.get集計年月());
        RString 保険者コード = 引き継ぎデータ.get保険者コード();
        RString 保険者名 = 引き継ぎデータ.get市町村名称();
        div.getPnlMain().getTbdHokokuNengetsu().setValue(new RDate(報告年月.toString()));
        div.getPnlMain().getTbdShukeiNengetsu().setValue(new RDate(集計年月.toString()));
        div.getPnlMain().getPnlYosikiHosei().setValue(保険者コード);
        div.getPnlMain().getTbHokensyaName().setValue(保険者名);
    }

    /**
     * 修正データリスト
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @param 様式種類 RString
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get修正データリスト(
            JigyoHokokuGeppoParameter 引き継ぎデータ, RString 様式種類) {
        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        List<JigyoHokokuTokeiData> 事業報告月報詳細データリスト = new ArrayList<>();
        if (様式種類.equalsIgnoreCase(様式種類_039) || 様式種類.equalsIgnoreCase(様式種類_139) || 様式種類.equalsIgnoreCase(様式種類_239)) {
            List<JigyoHokokuTokeiData> 利用者負担第四段階
                    = ViewStateHolder.get(ViewStateKeys.利用者負担第四段階, List.class);
            List<JigyoHokokuTokeiData> 利用者負担第三段階
                    = ViewStateHolder.get(ViewStateKeys.利用者負担第三段階, List.class);
            List<JigyoHokokuTokeiData> 利用者負担第二段階
                    = ViewStateHolder.get(ViewStateKeys.利用者負担第二段階, List.class);
            List<JigyoHokokuTokeiData> 利用者負担第一段階
                    = ViewStateHolder.get(ViewStateKeys.利用者負担第一段階, List.class);
            List<JigyoHokokuTokeiData> 高額介護_合計
                    = ViewStateHolder.get(ViewStateKeys.高額介護_合計, List.class);
            List<JigyoHokokuTokeiData> 再掲利用者負担第三段階
                    = ViewStateHolder.get(ViewStateKeys.再掲利用者負担第三段階, List.class);
            List<JigyoHokokuTokeiData> 再掲利用者負担第二段階
                    = ViewStateHolder.get(ViewStateKeys.再掲利用者負担第二段階, List.class);
            事業報告月報詳細データリスト.addAll(利用者負担第四段階);
            事業報告月報詳細データリスト.addAll(利用者負担第三段階);
            事業報告月報詳細データリスト.addAll(利用者負担第二段階);
            事業報告月報詳細データリスト.addAll(利用者負担第一段階);
            事業報告月報詳細データリスト.addAll(高額介護_合計);
            事業報告月報詳細データリスト.addAll(再掲利用者負担第三段階);
            事業報告月報詳細データリスト.addAll(再掲利用者負担第二段階);
            修正データリスト = get高額介護修正リスト(事業報告月報詳細データリスト, 修正データリスト);
        } else if (様式種類.equalsIgnoreCase(様式種類_040) || 様式種類.equalsIgnoreCase(様式種類_140) || 様式種類.equalsIgnoreCase(様式種類_240)) {
            List<JigyoHokokuTokeiData> 現役並み所得者
                    = ViewStateHolder.get(ViewStateKeys.現役並み所得者, List.class);
            List<JigyoHokokuTokeiData> 一般
                    = ViewStateHolder.get(ViewStateKeys.一般, List.class);
            List<JigyoHokokuTokeiData> 低所得者Ⅱ
                    = ViewStateHolder.get(ViewStateKeys.低所得者Ⅱ, List.class);
            List<JigyoHokokuTokeiData> 低所得者Ⅰ
                    = ViewStateHolder.get(ViewStateKeys.低所得者Ⅰ, List.class);
            List<JigyoHokokuTokeiData> 高額医療合算介護_合計
                    = ViewStateHolder.get(ViewStateKeys.高額医療合算介護_合計, List.class);

            事業報告月報詳細データリスト.addAll(現役並み所得者);
            事業報告月報詳細データリスト.addAll(一般);
            事業報告月報詳細データリスト.addAll(低所得者Ⅱ);
            事業報告月報詳細データリスト.addAll(低所得者Ⅰ);
            事業報告月報詳細データリスト.addAll(高額医療合算介護_合計);
            修正データリスト = get高額医療合算介護修正リスト(事業報告月報詳細データリスト, 修正データリスト);
        }
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get高額介護修正リスト(
            List<JigyoHokokuTokeiData> 更新前データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0701,
                div.getPnlMain().getTxtRiyoshaDaiyonKensu1().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiyonKensu2().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiyonKensu3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0701,
                div.getPnlMain().getTxtRiyoshaDaiyonKyufugaku1().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiyonKyufugaku2().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiyonKyufugaku3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0702,
                div.getPnlMain().getTxtRiyoshaDaisanKensu1().getValue(),
                div.getPnlMain().getTxtRiyoshaDaisanKensu2().getValue(),
                div.getPnlMain().getTxtRiyoshaDaisanKensu3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0702,
                div.getPnlMain().getTxtRiyoshaDaisanKyufugaku1().getValue(),
                div.getPnlMain().getTxtRiyoshaDaisanKyufugaku2().getValue(),
                div.getPnlMain().getTxtRiyoshaDaisanKyufugaku3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0703,
                div.getPnlMain().getTxtRiyoshaDainiKensu1().getValue(),
                div.getPnlMain().getTxtRiyoshaDainiKensu2().getValue(),
                div.getPnlMain().getTxtRiyoshaDainiKensu3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0703,
                div.getPnlMain().getTxtRiyoshaDainiKyufugaku1().getValue(),
                div.getPnlMain().getTxtRiyoshaDainiKyufugaku2().getValue(),
                div.getPnlMain().getTxtRiyoshaDainiKyufugaku3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0704,
                div.getPnlMain().getTxtRiyoshaDaiichiKensu1().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiichiKensu2().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiichiKensu3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0704,
                div.getPnlMain().getTxtRiyoshaDaiichiKyufugaku1().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiichiKyufugaku2().getValue(),
                div.getPnlMain().getTxtRiyoshaDaiichiKyufugaku3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0705,
                div.getPnlMain().getTxtGokeiKensu1().getValue(),
                div.getPnlMain().getTxtGokeiKensu2().getValue(),
                div.getPnlMain().getTxtGokeiKensu3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0705,
                div.getPnlMain().getTxtGokeiKyufugaku1().getValue(),
                div.getPnlMain().getTxtGokeiKyufugaku2().getValue(),
                div.getPnlMain().getTxtGokeiKyufugaku3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0706,
                div.getPnlMain().getTxtSaikeiRiyoshaDaisanKensu1().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDaisanKensu2().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDaisanKensu3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0706,
                div.getPnlMain().getTxtSaikeiRiyoshaDaisanKyufugaku1().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDaisanKyufugaku2().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDaisanKyufugaku3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0707,
                div.getPnlMain().getTxtSaikeiRiyoshaDainiKensu1().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDainiKensu2().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDainiKensu3().getValue());
        修正データリスト = get高額介護介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0707,
                div.getPnlMain().getTxtSaikeiRiyoshaDainiKyufugaku1().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDainiKyufugaku2().getValue(),
                div.getPnlMain().getTxtSaikeiRiyoshaDainiKyufugaku3().getValue());

        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get高額医療合算介護修正リスト(
            List<JigyoHokokuTokeiData> 更新前データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト) {
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0801,
                div.getPnlMain().getTxtGenekiKensu().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0801,
                div.getPnlMain().getTxtGenekiKyufugaku().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0802,
                div.getPnlMain().getTxtIppanKensu().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0802,
                div.getPnlMain().getTxtIppanKyufugaku().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0803,
                div.getPnlMain().getTxtTeishotokushaIIKensu().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0803,
                div.getPnlMain().getTxtTeishotokushaIIKyufugaku().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0804,
                div.getPnlMain().getTxtTeishotokushaIKensu().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0804,
                div.getPnlMain().getTxtTeishotokushaIKyufugaku().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0001, 集計番号_0805,
                div.getPnlMain().getTxtGokeiKensu().getValue());
        修正データリスト = get高額医療合算介護予防(更新前データリスト, 修正データリスト, 縦番号_0002, 集計番号_0805,
                div.getPnlMain().getTxtGokeiKyufugaku().getValue()
        );

        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get高額介護介護予防(
            List<JigyoHokokuTokeiData> 更新前データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Code 集計番号,
            Decimal 集計結果値1,
            Decimal 集計結果値2,
            Decimal 集計結果値3) {

        修正データリスト = set集計結果値(集計結果値1, 修正データリスト, 更新前データリスト, 横番号_0001, 縦番号, 集計番号);
        修正データリスト = set集計結果値(集計結果値2, 修正データリスト, 更新前データリスト, 横番号_0002, 縦番号, 集計番号);
        修正データリスト = set集計結果値(集計結果値3, 修正データリスト, 更新前データリスト, 横番号_0003, 縦番号, 集計番号);

        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get高額医療合算介護予防(
            List<JigyoHokokuTokeiData> 更新前データリスト,
            List<JigyoHokokuTokeiData> 修正データリスト,
            Decimal 縦番号,
            Code 集計番号,
            Decimal 集計結果値) {
        修正データリスト = set集計結果値(集計結果値, 修正データリスト, 更新前データリスト, 横番号_0001, 縦番号, 集計番号);

        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> set集計結果値(
            Decimal 集計結果値,
            List<JigyoHokokuTokeiData> 修正リスト,
            List<JigyoHokokuTokeiData> 更新前データリスト,
            Decimal 横番号,
            Decimal 縦番号,
            Code 集計番号) {
        JigyoHokokuTokeiData entity = check事業報告統計データ(更新前データリスト, 横番号, 縦番号, 集計番号);
        if (集計結果値 == null) {
            entity = entity.createBuilderForEdit().set集計結果値(null).build();
            entity = entity.modifiedModel();
            修正リスト.add(entity);
            return 修正リスト;
        } else {
            if (entity == null) {
                entity = set事業報告統計データ(更新前データリスト, 横番号, 縦番号, 集計結果値);
                修正リスト.add(entity);
                return 修正リスト;
            } else if (entity.get集計結果値() == null) {
                entity = entity.createBuilderForEdit().set集計結果値(集計結果値).build();
                entity = entity.modifiedModel();
                修正リスト.add(entity);
                return 修正リスト;
            } else if (!(entity.get集計結果値().equals(集計結果値))) {
                entity = entity.createBuilderForEdit().set集計結果値(集計結果値).build();
                entity = entity.modifiedModel();
                修正リスト.add(entity);
                return 修正リスト;
            }
        }
        return 修正リスト;
    }

    private JigyoHokokuTokeiData set事業報告統計データ(
            List<JigyoHokokuTokeiData> 更新前データリスト,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 集計結果値) {
        JigyoHokokuTokeiData entity = 更新前データリスト.get(0).createBuilderForEdit()
                .set横番号(横番号)
                .set縦番号(縦番号)
                .set集計結果値(集計結果値)
                .set集計項目名称(null)
                .set縦項目コード(null)
                .set横項目コード(null).build();
        entity = entity.addedModel();
        return entity;
    }

    private JigyoHokokuTokeiData check事業報告統計データ(
            List<JigyoHokokuTokeiData> 更新前データリスト,
            Decimal 横番号,
            Decimal 縦番号,
            Code 集計番号) {
        for (JigyoHokokuTokeiData entity : 更新前データリスト) {
            if (entity.get縦番号().equals(縦番号) && entity.get横番号().equals(横番号) && entity.get集計番号().equals(集計番号)) {
                return entity;
            }
        }
        return null;
    }

    /**
     * onLoad画面初期化処理
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @param 様式種類 RString
     */
    public void onLoad(JigyoHokokuGeppoParameter 引き継ぎデータ, RString 様式種類) {

        if (様式種類.equalsIgnoreCase(様式種類_039) || 様式種類.equalsIgnoreCase(様式種類_139) || 様式種類.equalsIgnoreCase(様式種類_239)) {
            List<JigyoHokokuTokeiData> 利用者負担第四段階 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_06, 集計番号_0701);
            List<JigyoHokokuTokeiData> 利用者負担第三段階 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_06, 集計番号_0702);
            List<JigyoHokokuTokeiData> 利用者負担第二段階 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_06, 集計番号_0703);
            List<JigyoHokokuTokeiData> 利用者負担第一段階 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_06, 集計番号_0704);
            List<JigyoHokokuTokeiData> 高額介護_合計 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_06, 集計番号_0705);
            List<JigyoHokokuTokeiData> 再掲利用者負担第三段階 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_06, 集計番号_0706);
            List<JigyoHokokuTokeiData> 再掲利用者負担第二段階 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_06, 集計番号_0707);
            loadList(利用者負担第四段階);
            loadList(利用者負担第三段階);
            loadList(利用者負担第二段階);
            loadList(利用者負担第一段階);
            loadList(高額介護_合計);
            loadList(再掲利用者負担第三段階);
            loadList(再掲利用者負担第二段階);
            ViewStateHolder.put(ViewStateKeys.利用者負担第四段階, (Serializable) 利用者負担第四段階);
            ViewStateHolder.put(ViewStateKeys.利用者負担第三段階, (Serializable) 利用者負担第三段階);
            ViewStateHolder.put(ViewStateKeys.利用者負担第二段階, (Serializable) 利用者負担第二段階);
            ViewStateHolder.put(ViewStateKeys.利用者負担第一段階, (Serializable) 利用者負担第一段階);
            ViewStateHolder.put(ViewStateKeys.高額介護_合計, (Serializable) 高額介護_合計);
            ViewStateHolder.put(ViewStateKeys.再掲利用者負担第三段階, (Serializable) 再掲利用者負担第三段階);
            ViewStateHolder.put(ViewStateKeys.再掲利用者負担第二段階, (Serializable) 再掲利用者負担第二段階);
        } else if (様式種類.equalsIgnoreCase(様式種類_040) || 様式種類.equalsIgnoreCase(様式種類_140) || 様式種類.equalsIgnoreCase(様式種類_240)) {
            List<JigyoHokokuTokeiData> 現役並み所得者 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_07, 集計番号_0801);
            List<JigyoHokokuTokeiData> 一般 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_07, 集計番号_0802);
            List<JigyoHokokuTokeiData> 低所得者Ⅱ = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_07, 集計番号_0803);
            List<JigyoHokokuTokeiData> 低所得者Ⅰ = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_07, 集計番号_0804);
            List<JigyoHokokuTokeiData> 高額医療合算介護_合計 = get事業報告月報詳細データリスト(
                    引き継ぎデータ, 表番号_07, 集計番号_0805);
            loadList1(現役並み所得者);
            loadList1(一般);
            loadList1(低所得者Ⅱ);
            loadList1(低所得者Ⅰ);
            loadList1(高額医療合算介護_合計);
            ViewStateHolder.put(ViewStateKeys.現役並み所得者, (Serializable) 現役並み所得者);
            ViewStateHolder.put(ViewStateKeys.一般, (Serializable) 一般);
            ViewStateHolder.put(ViewStateKeys.低所得者Ⅱ, (Serializable) 低所得者Ⅱ);
            ViewStateHolder.put(ViewStateKeys.低所得者Ⅰ, (Serializable) 低所得者Ⅰ);
            ViewStateHolder.put(ViewStateKeys.高額医療合算介護_合計, (Serializable) 高額医療合算介護_合計);
        }
    }

    private void loadList1(List<JigyoHokokuTokeiData> datalist) {
        for (JigyoHokokuTokeiData entity : datalist) {
            if (集計番号_0801.equals(entity.get集計番号())) {
                load現役並み所得者(entity);
            } else if (集計番号_0802.equals(entity.get集計番号())) {
                load一般(entity);
            } else if (集計番号_0803.equals(entity.get集計番号())) {
                load低所得者Ⅱ(entity);
            } else if (集計番号_0804.equals(entity.get集計番号())) {
                load低所得者Ⅰ(entity);
            } else if (集計番号_0805.equals(entity.get集計番号())) {
                load高額医療合算介護_合計(entity);
            }
        }
    }

    private void load現役並み所得者(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            if (縦番号_0001.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlA().getTxtGenekiKensu().setValue(entity.get集計結果値());
            }
            if (縦番号_0002.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlA().getTxtGenekiKyufugaku().setValue(entity.get集計結果値());
            }
        }
    }

    private void load一般(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            if (縦番号_0001.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlI().getTxtIppanKensu().setValue(entity.get集計結果値());
            }
            if (縦番号_0002.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlI().getTxtIppanKyufugaku().setValue(entity.get集計結果値());
            }
        }
    }

    private void load低所得者Ⅱ(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            if (縦番号_0001.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlU().getTxtTeishotokushaIIKensu().setValue(entity.get集計結果値());
            }
            if (縦番号_0002.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlU().getTxtTeishotokushaIIKyufugaku().setValue(entity.get集計結果値());
            }
        }
    }

    private void load低所得者Ⅰ(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            if (縦番号_0001.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlE().getTxtTeishotokushaIKensu().setValue(entity.get集計結果値());
            }
            if (縦番号_0002.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlE().getTxtTeishotokushaIKyufugaku().setValue(entity.get集計結果値());
            }
        }
    }

    private void load高額医療合算介護_合計(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            if (縦番号_0001.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlO().getTxtGokeiKensu().setValue(entity.get集計結果値());
            }
            if (縦番号_0002.equals(entity.get縦番号())) {
                div.getPnlMain().getPnlService2().getPnlO().getTxtGokeiKyufugaku().setValue(entity.get集計結果値());
            }
        }
    }

    private void loadList(List<JigyoHokokuTokeiData> datalist) {
        for (JigyoHokokuTokeiData entity : datalist) {
            if (集計番号_0701.equals(entity.get集計番号())) {
                load利用者負担第四段階(entity);
            }
            if (集計番号_0702.equals(entity.get集計番号())) {
                load利用者負担第三段階(entity);
            }
            if (集計番号_0703.equals(entity.get集計番号())) {
                load利用者負担第二段階(entity);
            }
            if (集計番号_0704.equals(entity.get集計番号())) {
                load利用者負担第一段階(entity);
            }
            if (集計番号_0705.equals(entity.get集計番号())) {
                load合計(entity);
            }
            if (集計番号_0706.equals(entity.get集計番号())) {
                load再掲利用者負担第三段階(entity);
            }
            if (集計番号_0707.equals(entity.get集計番号())) {
                load再掲利用者負担第二段階(entity);
            }
        }
    }

    private void load再掲利用者負担第二段階(JigyoHokokuTokeiData entity) {
        if (縦番号_0001.equals(entity.get縦番号())) {
            load再掲利用者負担第二段階_件数(entity);
        }
        if (縦番号_0002.equals(entity.get縦番号())) {
            load再掲利用者負担第二段階_給付額(entity);
        }
    }

    private void load再掲利用者負担第二段階_件数(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKensu3().setValue(entity.get集計結果値());
        }
    }

    private void load再掲利用者負担第二段階_給付額(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaini().getTxtSaikeiRiyoshaDainiKyufugaku3().setValue(entity.get集計結果値());
        }
    }

    private void load再掲利用者負担第三段階(JigyoHokokuTokeiData entity) {
        if (縦番号_0001.equals(entity.get縦番号())) {
            load再掲利用者負担第三段階_件数(entity);
        }
        if (縦番号_0002.equals(entity.get縦番号())) {
            load再掲利用者負担第三段階_給付額(entity);
        }
    }

    private void load再掲利用者負担第三段階_件数(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKensu3().setValue(entity.get集計結果値());
        }
    }

    private void load再掲利用者負担第三段階_給付額(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlSaikeiDaisan().getTxtSaikeiRiyoshaDaisanKyufugaku3().setValue(entity.get集計結果値());
        }
    }

    private void load合計(JigyoHokokuTokeiData entity) {
        if (縦番号_0001.equals(entity.get縦番号())) {
            load合計_件数(entity);
        }
        if (縦番号_0002.equals(entity.get縦番号())) {
            load合計_給付額(entity);
        }
    }

    private void load合計_件数(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKensu3().setValue(entity.get集計結果値());
        }
    }

    private void load合計_給付額(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlGokei().getTxtGokeiKyufugaku3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第一段階(JigyoHokokuTokeiData entity) {
        if (縦番号_0001.equals(entity.get縦番号())) {
            load利用者負担第一段階_件数(entity);
        }
        if (縦番号_0002.equals(entity.get縦番号())) {
            load利用者負担第一段階_給付額(entity);
        }
    }

    private void load利用者負担第一段階_件数(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKensu3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第一段階_給付額(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiitu().getTxtRiyoshaDaiichiKyufugaku3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第二段階(JigyoHokokuTokeiData entity) {
        if (縦番号_0001.equals(entity.get縦番号())) {
            load利用者負担第二段階_件数(entity);
        }
        if (縦番号_0002.equals(entity.get縦番号())) {
            load利用者負担第二段階_給付額(entity);
        }
    }

    private void load利用者負担第二段階_件数(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKensu3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第二段階_給付額(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaini().getTxtRiyoshaDainiKyufugaku3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第三段階(JigyoHokokuTokeiData entity) {
        if (縦番号_0001.equals(entity.get縦番号())) {
            load利用者負担第三段階_件数(entity);
        }
        if (縦番号_0002.equals(entity.get縦番号())) {
            load利用者負担第三段階_給付額(entity);
        }
    }

    private void load利用者負担第三段階_件数(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKensu3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第三段階_給付額(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaisan().getTxtRiyoshaDaisanKyufugaku3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第四段階(JigyoHokokuTokeiData entity) {
        if (縦番号_0001.equals(entity.get縦番号())) {
            load利用者負担第四段階_件数(entity);
        }
        if (縦番号_0002.equals(entity.get縦番号())) {
            load利用者負担第四段階_給付額(entity);
        }
    }

    private void load利用者負担第四段階_件数(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKensu3().setValue(entity.get集計結果値());
        }
    }

    private void load利用者負担第四段階_給付額(JigyoHokokuTokeiData entity) {
        if (横番号_0001.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku1().setValue(entity.get集計結果値());
        }
        if (横番号_0002.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku2().setValue(entity.get集計結果値());
        }
        if (横番号_0003.equals(entity.get横番号())) {
            div.getPnlMain().getPnlServive1().getPnlDaiyon().getTxtRiyoshaDaiyonKyufugaku3().setValue(entity.get集計結果値());
        }
    }

//    private List<JigyoHokokuTokeiData> get事業報告月報詳細データリスト(
//            JigyoHokokuGeppoParameter 引き継ぎデータ, Code 表番号, Code 集計番号) {
//        JigyoHokokuGeppoHoseiHako finder = new JigyoHokokuGeppoHoseiHako();
//        JigyoHokokuGeppoDetalSearchParameter parameter
//                = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(
//                        new FlexibleYear(new RString("2010")),
//                        new RString("06"),
//                        new FlexibleYear(new RString("2010")),
//                        new RString("06"),
//                        new RString("3"),
//                        new LasdecCode(new RString("209008")),
//                        表番号,
//                        集計番号);
//        return finder.getJigyoHokokuGeppoDetal(parameter);
//    }
    private List<JigyoHokokuTokeiData> get事業報告月報詳細データリスト(
            JigyoHokokuGeppoParameter 引き継ぎデータ, Code 表番号, Code 集計番号) {
        JigyoHokokuGeppoHoseiHako finder = new JigyoHokokuGeppoHoseiHako();
        JigyoHokokuGeppoDetalSearchParameter parameter
                = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear(引き継ぎデータ.get行報告年()),
                        引き継ぎデータ.get行報告月(),
                        new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                        引き継ぎデータ.get行集計対象月(),
                        引き継ぎデータ.get行統計対象区分(),
                        new LasdecCode(引き継ぎデータ.get行市町村コード()),
                        表番号,
                        集計番号);
        return finder.getJigyoHokokuGeppoDetal(parameter);
    }
}
