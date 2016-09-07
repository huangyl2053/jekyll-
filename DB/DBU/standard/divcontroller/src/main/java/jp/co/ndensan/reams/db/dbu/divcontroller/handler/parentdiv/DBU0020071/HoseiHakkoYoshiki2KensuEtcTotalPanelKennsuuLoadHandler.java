/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業報告（月報）補正発行_様式２件数、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuLoadHandler {

    private static final int NUMBER_1 = 1;
    private static final int NUMBER_2 = 2;
    private static final int NUMBER_3 = 3;
    private static final int NUMBER_4 = 4;
    private static final int NUMBER_5 = 5;
    private static final int NUMBER_6 = 6;
    private static final int NUMBER_7 = 7;
    private static final int NUMBER_8 = 8;
    private static final int NUMBER_9 = 9;
    private static final int NUMBER_10 = 10;
    private static final int NUMBER_11 = 11;
    private static final int NUMBER_12 = 12;
    private static final int NUMBER_13 = 13;
    private static final int NUMBER_14 = 14;
    private static final int NUMBER_15 = 15;
    private static final int NUMBER_16 = 16;
    private static final int NUMBER_17 = 17;
    private static final int NUMBER_18 = 18;
    private static final int NUMBER_19 = 19;
    private static final int NUMBER_20 = 20;
    private static final int NUMBER_21 = 21;
    private static final int NUMBER_22 = 22;
    private static final int NUMBER_23 = 23;
    private static final int NUMBER_24 = 24;
    private static final int NUMBER_25 = 25;
    private static final int NUMBER_26 = 26;
    private static final int NUMBER_27 = 27;
    private static final int NUMBER_28 = 28;
    private static final int NUMBER_29 = 29;
    private static final int NUMBER_30 = 30;
    private static final int NUMBER_31 = 31;
    private static final int NUMBER_32 = 32;
    private static final int NUMBER_33 = 33;
    private static final int NUMBER_34 = 34;
    private static final int NUMBER_35 = 35;
    private static final int NUMBER_36 = 36;
    private static final int NUMBER_37 = 37;
    private static final int NUMBER_38 = 38;
    private static final Code 集計番号_0101 = new Code("0101");
    private static final Code 集計番号_0201 = new Code("0201");
    private static final Code 集計番号_0301 = new Code("0301");
    private static final Code 集計番号_0401 = new Code("0401");
    private static final Code 集計番号_0102 = new Code("0102");
    private static final Code 集計番号_0202 = new Code("0202");
    private static final Code 集計番号_0302 = new Code("0302");
    private static final Code 集計番号_0402 = new Code("0402");
    private static final Code 集計番号_0103 = new Code("0103");
    private static final Code 集計番号_0203 = new Code("0203");
    private static final Code 集計番号_0303 = new Code("0303");
    private static final Code 集計番号_0403 = new Code("0403");
    private static final Code 集計番号_0104 = new Code("0104");
    private static final Code 集計番号_0204 = new Code("0204");
    private static final Code 集計番号_0304 = new Code("0304");
    private static final Code 集計番号_0404 = new Code("0404");
    private static final RString 件数総数 = new RString("01");
    private static final RString 件数第２号被保険者分再掲 = new RString("02");
    private static final RString 件数総数特例分 = new RString("03");
    private static final RString 件数第２号被保険者分再掲特例分 = new RString("04");

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelKennsuuLoadHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
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
     * 引き継ぎデータより、データ削除する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     */
    public void delete(List<JigyoHokokuTokeiData> 引き継ぎデータ) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.deleteJigyoHokokuGeppoData(引き継ぎデータ);
    }

    private List<JigyoHokokuTokeiData> get事業報告月報詳細データリスト(
            JigyoHokokuGeppoParameter 引き継ぎデータ, Code 集計番号) {
        JigyoHokokuGeppoHoseiHako finder = new JigyoHokokuGeppoHoseiHako();
        JigyoHokokuGeppoDetalSearchParameter parameter
                = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear(引き継ぎデータ.get行報告年()),
                        引き継ぎデータ.get行報告月(),
                        new FlexibleYear(引き継ぎデータ.get行集計対象年()),
                        引き継ぎデータ.get行集計対象月(),
                        引き継ぎデータ.get行統計対象区分(),
                        new LasdecCode(引き継ぎデータ.get行市町村コード()),
                        new Code(引き継ぎデータ.get行表番号()),
                        集計番号);
        return finder.getJigyoHokokuGeppoDetal(parameter);
    }

    /**
     * onLoad画面初期化処理
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> 件数OnLoad(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        List<JigyoHokokuTokeiData> 件数 = new ArrayList<>();

        if (引き継ぎデータ.get行集計番号().startsWith(件数総数.toString())) {
            件数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0101);
        } else if (引き継ぎデータ.get行集計番号().startsWith(件数第２号被保険者分再掲.toString())) {
            件数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0201);
        } else if (引き継ぎデータ.get行集計番号().startsWith(件数総数特例分.toString())) {
            件数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0301);
        } else if (引き継ぎデータ.get行集計番号().startsWith(件数第２号被保険者分再掲特例分.toString())) {
            件数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0401);
        }
        loopList(件数);
        return 件数;
    }

    private void loopList(List<JigyoHokokuTokeiData> list) {
        for (JigyoHokokuTokeiData entity : list) {
            loadList(entity);
        }
    }

    private void loadList(JigyoHokokuTokeiData entity) {
        loadList_1(entity);
        loadList_2(entity);
        loadList_3(entity);
        loadList_4(entity);
    }

    private void loadList_1(JigyoHokokuTokeiData entity) {
        switch (entity.get縦番号().intValue()) {
            case NUMBER_1:
                load訪問サービス(entity);
                break;
            case NUMBER_2:
                load短期入所サービス(entity);
                break;
            case NUMBER_3:
                load福祉用具住宅改修サービス(entity);
                break;
            case NUMBER_4:
                load福祉用具購入費(entity);
                break;
            case NUMBER_5:
                load住宅改修費(entity);
                break;
            case NUMBER_6:
                load施設サービス(entity);
                break;
            case NUMBER_7:
                load介護老人福祉施設_1(entity);
                break;
            case NUMBER_8:
                load介護老人保健施設_1(entity);
                break;
            case NUMBER_9:
                load介護療養型医療施設_1(entity);
                break;
            case NUMBER_10:
                load食事提供費用再掲(entity);
                break;
            default:
                break;
        }
    }

    private void loadList_2(JigyoHokokuTokeiData entity) {
        switch (entity.get縦番号().intValue()) {
            case NUMBER_11:
                load介護老人福祉施設_2(entity);
                break;
            case NUMBER_12:
                load介護老人保健施設_2(entity);
                break;
            case NUMBER_13:
                load介護療養型医療施設_2(entity);
                break;
            case NUMBER_14:
                load総計(entity);
                break;
            case NUMBER_15:
                load居宅介護予防サービス(entity);
                break;
            case NUMBER_16:
                load訪問介護(entity);
                break;
            case NUMBER_17:
                load訪問入浴介護(entity);
                break;
            case NUMBER_18:
                load訪問看護(entity);
                break;
            case NUMBER_19:
                load訪問リハビリテーション(entity);
                break;
            case NUMBER_20:
                load通所介護(entity);
                break;
            default:
                break;
        }
    }

    private void loadList_3(JigyoHokokuTokeiData entity) {
        switch (entity.get縦番号().intValue()) {
            case NUMBER_21:
                load通所リハビリテーション(entity);
                break;
            case NUMBER_22:
                load福祉用具貸与(entity);
                break;
            case NUMBER_23:
                load短期入所生活介護(entity);
                break;
            case NUMBER_24:
                load短期入所療養介護介護老人保健施設(entity);
                break;
            case NUMBER_25:
                load短期入所療養介護介護療養型医療施設等(entity);
                break;
            case NUMBER_26:
                load居宅療養管理指導(entity);
                break;
            case NUMBER_27:
                load認知症対応型共同生活介護(entity);
                break;
            case NUMBER_28:
                load特定施設入居者生活介護(entity);
                break;
            case NUMBER_29:
                load介護予防支援居宅介護支援(entity);
                break;
            case NUMBER_30:
                load通所サービス(entity);
                break;
            default:
                break;
        }
    }

    private void loadList_4(JigyoHokokuTokeiData entity) {
        switch (entity.get縦番号().intValue()) {
            case NUMBER_31:
                load地域密着型介護予防サービス(entity);
                break;
            case NUMBER_32:
                load夜間対応型訪問介護(entity);
                break;
            case NUMBER_33:
                load認知症対応型通所介護(entity);
                break;
            case NUMBER_34:
                load小規模多機能型居宅介護(entity);
                break;
            case NUMBER_35:
                load地域密着型特定施設入居者生活介護(entity);
                break;
            case NUMBER_36:
                load地域密着型介護老人福祉施設入所者生活介護(entity);
                break;
            case NUMBER_37:
                load定期巡回随時対応型訪問介護看護(entity);
                break;
            case NUMBER_38:
                load複合型サービス(entity);
                break;
            default:
                break;
        }
    }

    private void load複合型サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox304().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox305().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox306().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox307().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox308().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox309().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox310().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox311().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox312().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox313().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load定期巡回随時対応型訪問介護看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox232().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox233().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox234().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox235().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox236().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox237().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox238().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox239().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox240().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox241().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型介護老人福祉施設入所者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox294().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox295().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox296().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox297().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox298().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox299().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox300().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox301().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox302().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox303().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox284().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox285().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox286().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox287().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox288().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox289().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox290().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox291().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox292().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox293().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load小規模多機能型居宅介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox263().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox264().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox265().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox266().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox267().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox268().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox269().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox270().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox271().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox272().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox273().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load認知症対応型通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox252().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox253().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox254().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox255().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox256().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox257().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox258().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox259().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox260().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox261().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox262().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load夜間対応型訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox242().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox243().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox244().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox245().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox246().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox247().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox248().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox249().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox250().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox251().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox221().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox222().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox223().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox224().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox225().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox226().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox227().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox228().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox229().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox230().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox231().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox78().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox79().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox80().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox81().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox82().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox83().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox84().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox85().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox86().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox87().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox88().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護予防支援居宅介護支援(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox210().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox211().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox212().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox213().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox214().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox215().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox216().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox217().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox218().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox219().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox220().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox199().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox200().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox201().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox202().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox203().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox204().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox205().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox206().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox207().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox208().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox209().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load認知症対応型共同生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox274().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox275().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox276().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox277().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox278().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox279().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox280().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox281().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox282().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox283().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load居宅療養管理指導(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox67().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox68().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox69().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox70().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox71().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox72().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox73().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox74().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox75().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox76().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox77().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所療養介護介護療養型医療施設等(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox144().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox145().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox146().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox147().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox148().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox149().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox150().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox151().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox152().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox153().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox154().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所療養介護介護老人保健施設(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox133().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox134().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox135().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox136().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox137().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox138().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox139().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox140().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox141().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox142().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox143().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox122().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox123().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox124().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox125().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox126().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox127().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox128().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox129().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox130().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox131().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox132().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具貸与(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox166().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox167().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox168().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox169().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox170().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox171().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox172().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox173().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox174().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox175().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox176().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox100().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox101().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox102().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox103().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox104().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox105().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox106().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox107().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox108().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox109().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox110().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox89().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox90().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox91().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox92().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox93().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox94().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox95().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox96().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox97().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox98().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox99().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox56().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox57().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox58().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox59().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox60().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox61().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox62().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox63().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox64().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox65().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox66().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox45().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox46().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox47().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox48().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox49().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox50().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox51().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox52().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox53().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox54().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox55().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問入浴介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox35().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox36().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox37().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox38().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox39().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox40().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox41().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox42().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox43().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox44().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox34().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox23().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox24().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox25().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox26().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox27().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox28().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox29().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox30().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox31().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox32().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox33().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load総計(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl1().getTextBox398().setValue(entity.get集計結果値());
                break;
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox399().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox400().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox401().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox402().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox403().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox404().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox405().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox406().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox407().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox408().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox409().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護療養型医療施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox388().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox389().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox390().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox391().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox392().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox393().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox394().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox395().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox396().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox397().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人保健施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox378().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox379().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox380().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox381().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox382().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox383().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox384().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox385().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox386().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox387().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人福祉施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl1().getTextBox367().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox368().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox369().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox370().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox371().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox372().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox373().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox374().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox375().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox376().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox377().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load食事提供費用再掲(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl1().getTextBox356().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox357().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox358().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox359().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox360().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox361().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox362().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox363().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox364().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox365().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox366().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護療養型医療施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox346().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox347().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox348().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox349().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox350().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox351().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox352().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox353().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox354().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox355().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人保健施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox336().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox337().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox338().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox339().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox340().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox341().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox342().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox343().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox344().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox345().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人福祉施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl1().getTextBox325().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox326().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox327().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox328().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox329().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox330().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox331().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox332().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox333().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox334().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox335().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load施設サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl1().getTextBox314().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox315().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox316().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox317().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox318().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox319().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox320().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox321().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox322().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox323().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox324().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load住宅改修費(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox188().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox189().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox190().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox191().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox192().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox193().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox194().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox195().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox196().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox197().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox198().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具購入費(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox177().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox178().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox179().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox180().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox181().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox182().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox183().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox184().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox185().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox186().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox187().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具住宅改修サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox155().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox156().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox157().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox158().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox159().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox160().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox161().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox162().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox163().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox164().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox165().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox111().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox112().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox113().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox114().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox115().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox116().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox117().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox118().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox119().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox120().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox121().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox12().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox13().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox14().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox15().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox16().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox17().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox18().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox19().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox20().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox21().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox22().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load居宅介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl1().getTextBox1().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl1().getTextBox2().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl1().getTextBox3().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl1().getTextBox4().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl1().getTextBox5().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl1().getTextBox6().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl1().getTextBox7().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl1().getTextBox8().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl1().getTextBox9().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl1().getTextBox10().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl1().getTextBox11().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

}
