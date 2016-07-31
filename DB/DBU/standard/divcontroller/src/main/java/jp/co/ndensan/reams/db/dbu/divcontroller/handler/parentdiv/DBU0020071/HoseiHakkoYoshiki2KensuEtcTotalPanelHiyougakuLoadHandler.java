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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告（月報）補正発行_様式２件数、単位数補正、費用額、給付費補正のクラス
 *
 * @reamsid_L DBU-1100-090 lijunjun
 */
public class HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuLoadHandler {

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
    private static final Code 集計番号_0103 = new Code("0103");
    private static final Code 集計番号_0203 = new Code("0203");
    private static final Code 集計番号_0303 = new Code("0303");
    private static final Code 集計番号_0403 = new Code("0403");
    private static final RString 費用額総数 = new RString("01");
    private static final RString 費用額第２号被保険者分再掲 = new RString("02");
    private static final RString 費用額総数特例分 = new RString("03");
    private static final RString 費用額第２号被保険者分再掲特例分 = new RString("04");

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuLoadHandler(
            HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
        this.div = div;
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
    public List<JigyoHokokuTokeiData> 費用額OnLoad(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        List<JigyoHokokuTokeiData> 費用額 = new ArrayList<>();

        if (引き継ぎデータ.get行集計番号().startsWith(費用額総数.toString())) {
            費用額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0103);
        } else if (引き継ぎデータ.get行集計番号().startsWith(費用額第２号被保険者分再掲.toString())) {
            費用額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0203);
        } else if (引き継ぎデータ.get行集計番号().startsWith(費用額総数特例分.toString())) {
            費用額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0303);
        } else if (引き継ぎデータ.get行集計番号().startsWith(費用額第２号被保険者分再掲特例分.toString())) {
            費用額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0403);
        }
        loopList(費用額);
        return 費用額;
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
                div.getPnlMain().getTbl3().getTextBox1100().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1101().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1102().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1103().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1104().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1105().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1106().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1107().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1108().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1109().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load定期巡回随時対応型訪問介護看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1028().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1029().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1030().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1031().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1032().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1033().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1034().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1035().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1036().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1037().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型介護老人福祉施設入所者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1090().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1091().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1092().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1093().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1094().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1095().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1096().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1097().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1098().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1099().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1080().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1081().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1082().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1083().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1084().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1085().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1086().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1087().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1088().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1089().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load小規模多機能型居宅介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox1059().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1060().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1061().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1062().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1063().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1064().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1065().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1066().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1067().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1068().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1069().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load認知症対応型通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox1048().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1049().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1050().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1051().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1052().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1053().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1054().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1055().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1056().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1057().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1058().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load夜間対応型訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1038().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1039().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1040().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1041().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1042().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1043().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1044().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1045().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1046().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1047().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox1017().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1018().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1019().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1020().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1021().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1022().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1023().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1024().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1025().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1026().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1027().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox874().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox875().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox876().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox877().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox878().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox879().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox880().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox881().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox882().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox883().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox884().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護予防支援居宅介護支援(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox1006().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1007().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1008().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1009().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1010().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1011().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1012().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1013().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1014().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1015().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1016().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox995().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox996().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox997().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox998().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox999().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1000().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1001().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1002().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1003().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1004().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1005().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load認知症対応型共同生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1070().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1071().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1072().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1073().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1074().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1075().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1076().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1077().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1078().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1079().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load居宅療養管理指導(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox863().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox864().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox865().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox866().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox867().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox868().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox869().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox870().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox871().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox872().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox873().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所療養介護介護療養型医療施設等(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox940().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox941().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox942().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox943().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox944().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox945().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox946().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox947().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox948().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox949().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox950().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所療養介護介護老人保健施設(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox929().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox930().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox931().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox932().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox933().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox934().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox935().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox936().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox937().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox938().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox939().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox918().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox919().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox920().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox921().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox922().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox923().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox924().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox925().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox926().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox927().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox928().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具貸与(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox962().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox963().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox964().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox965().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox966().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox967().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox968().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox969().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox970().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox971().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox972().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox896().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox897().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox898().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox899().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox900().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox901().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox902().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox903().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox904().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox905().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox906().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox885().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox886().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox887().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox888().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox889().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox890().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox891().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox892().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox893().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox894().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox895().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox852().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox853().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox854().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox855().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox856().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox857().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox858().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox859().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox860().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox861().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox862().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox841().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox842().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox843().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox844().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox845().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox846().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox847().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox848().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox849().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox850().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox851().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問入浴介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox830().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox831().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox832().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox833().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox834().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox835().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox836().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox837().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox838().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox839().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox840().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox819().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox820().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox821().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox822().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox823().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox824().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox825().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox826().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox827().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox828().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox829().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load総計(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl3().getTextBox1194().setValue(entity.get集計結果値());
                break;
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox1195().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1196().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1197().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1198().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1199().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1200().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1201().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1202().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1203().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1204().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1205().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護療養型医療施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1184().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1185().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1186().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1187().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1188().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1189().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1190().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1191().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1192().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1193().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人保健施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1174().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1175().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1176().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1177().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1178().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1179().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1180().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1181().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1182().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1183().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人福祉施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl3().getTextBox1163().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1164().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1165().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1166().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1167().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1168().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1169().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1170().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1171().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1172().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1173().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load食事提供費用再掲(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl3().getTextBox1152().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1153().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1154().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1155().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1156().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1157().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1158().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1159().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1160().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1161().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1162().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護療養型医療施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1142().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1143().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1144().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1145().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1146().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1147().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1148().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1149().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1150().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1151().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人保健施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1132().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1133().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1134().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1135().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1136().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1137().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1138().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1139().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1140().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1141().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人福祉施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl3().getTextBox1121().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1122().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1123().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1124().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1125().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1126().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1127().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1128().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1129().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1130().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1131().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load施設サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl3().getTextBox1110().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox1111().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox1112().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox1113().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox1114().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox1115().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox1116().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox1117().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox1118().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox1119().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox1120().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load住宅改修費(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox984().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox985().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox986().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox987().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox988().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox989().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox990().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox991().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox992().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox993().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox994().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具購入費(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox973().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox974().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox975().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox976().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox977().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox978().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox979().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox980().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox981().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox982().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox983().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具住宅改修サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox951().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox952().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox953().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox954().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox955().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox956().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox957().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox958().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox959().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox960().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox961().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox907().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox908().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox909().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox910().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox911().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox912().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox913().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox914().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox915().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox916().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox917().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox597().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox598().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox599().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox600().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox601().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox602().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox603().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox604().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox605().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox606().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox607().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load居宅介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl3().getTextBox586().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl3().getTextBox587().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl3().getTextBox588().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl3().getTextBox589().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl3().getTextBox590().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl3().getTextBox591().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl3().getTextBox592().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl3().getTextBox593().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl3().getTextBox594().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl3().getTextBox595().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl3().getTextBox596().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }
}
