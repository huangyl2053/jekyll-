/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020071;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020071.HoseiHakkoYoshiki2KensuEtcTotalPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
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
    private static final int NUMBER_10 = 9;
    private static final int NUMBER_9 = 10;
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
    public HoseiHakkoYoshiki2KensuEtcTotalPanelHiyougakuLoadHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
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
     */
    public void 費用額OnLoad(JigyoHokokuGeppoParameter 引き継ぎデータ) {
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

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1100().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1101().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1102().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1103().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1104().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1105().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1106().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1107().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1108().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1109().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;

            }
        }
    }

    private void load定期巡回随時対応型訪問介護看護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1028().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1029().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1030().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1031().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1032().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1033().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1034().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1035().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1036().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1037().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load地域密着型介護老人福祉施設入所者生活介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1090().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1091().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1092().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1093().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1094().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1095().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1096().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1097().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1098().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1099().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load地域密着型特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1080().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1081().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1082().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1083().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1084().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1085().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1086().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1087().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1088().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1089().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load小規模多機能型居宅介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox1059().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1060().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1061().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1062().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1063().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1064().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1065().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1066().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1067().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1068().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1069().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load認知症対応型通所介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox1048().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1049().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1050().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1051().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1052().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1053().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1054().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1055().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1056().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1057().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1058().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load夜間対応型訪問介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1038().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1039().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1040().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1041().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1042().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1043().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1044().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1045().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1046().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1047().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load地域密着型介護予防サービス(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox1017().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1018().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1019().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1020().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1021().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1022().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1023().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1024().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1025().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1026().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1027().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load通所サービス(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox874().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox875().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox876().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox877().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox878().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox879().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox880().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox881().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox882().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox883().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox884().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load介護予防支援居宅介護支援(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox1006().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1007().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1008().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1009().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1010().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1011().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1012().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1013().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1014().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1015().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1016().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox995().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox996().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox997().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox998().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox999().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1000().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1001().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1002().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1003().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1004().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1005().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load認知症対応型共同生活介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1070().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1071().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1072().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1073().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1074().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1075().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1076().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1077().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1078().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1079().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load居宅療養管理指導(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox863().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox864().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox865().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox866().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox867().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox868().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox869().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox870().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox871().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox872().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox873().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load短期入所療養介護介護療養型医療施設等(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox940().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox941().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox942().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox943().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox944().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox945().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox946().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox947().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox948().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox949().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox950().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load短期入所療養介護介護老人保健施設(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox929().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox930().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox931().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox932().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox933().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox934().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox935().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox936().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox937().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox938().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox939().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load短期入所生活介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox918().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox919().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox920().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox921().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox922().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox923().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox924().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox925().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox926().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox927().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox928().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load福祉用具貸与(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox962().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox963().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox964().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox965().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox966().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox967().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox968().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox969().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox970().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox971().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox972().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load通所リハビリテーション(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox896().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox897().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox898().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox899().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox900().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox901().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox902().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox903().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox904().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox905().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox906().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load通所介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox885().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox886().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox887().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox888().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox889().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox890().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox891().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox892().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox893().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox894().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox895().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load訪問リハビリテーション(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox852().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox853().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox854().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox855().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox856().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox857().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox858().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox859().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox860().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox861().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox862().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load訪問看護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox841().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox842().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox843().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox844().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox845().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox846().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox847().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox848().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox849().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox850().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox851().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load訪問入浴介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox830().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox831().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox832().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox833().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox834().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox835().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox836().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox837().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox838().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox839().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox840().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load訪問介護(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox819().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox820().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox821().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox822().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox823().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox824().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox825().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox826().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox827().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox828().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox829().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load総計(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_1:
                    div.getPnlMain().getTbl3().getTextBox1194().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox1195().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1196().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1197().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1198().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1199().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1200().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1201().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1202().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1203().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1204().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1205().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load介護療養型医療施設_2(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1184().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1185().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1186().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1187().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1188().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1189().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1190().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1191().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1192().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1193().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load介護老人保健施設_2(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1174().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1175().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1176().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1177().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1178().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1179().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1180().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1181().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1182().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1183().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load介護老人福祉施設_2(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_1:
                    div.getPnlMain().getTbl3().getTextBox1163().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1164().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1165().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1166().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1167().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1168().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1169().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1170().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1171().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1172().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1173().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load食事提供費用再掲(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_1:
                    div.getPnlMain().getTbl3().getTextBox1152().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1153().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1154().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1155().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1156().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1157().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1158().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1159().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1160().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1161().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1162().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load介護療養型医療施設_1(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1142().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1143().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1144().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1145().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1146().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1147().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1148().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1149().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1150().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1151().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load介護老人保健施設_1(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1132().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1133().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1134().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1135().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1136().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1137().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1138().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1139().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1140().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1141().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load介護老人福祉施設_1(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_1:
                    div.getPnlMain().getTbl3().getTextBox1121().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1122().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1123().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1124().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1125().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1126().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1127().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1128().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1129().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1130().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1131().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load施設サービス(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_1:
                    div.getPnlMain().getTbl3().getTextBox1110().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox1111().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox1112().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox1113().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox1114().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox1115().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox1116().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox1117().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox1118().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox1119().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox1120().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load住宅改修費(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox984().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox985().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox986().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox987().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox988().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox989().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox990().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox991().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox992().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox993().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox994().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load福祉用具購入費(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox973().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox974().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox975().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox976().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox977().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox978().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox979().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox980().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox981().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox982().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox983().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load福祉用具住宅改修サービス(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox951().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox952().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox953().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox954().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox955().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox956().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox957().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox958().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox959().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox960().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox961().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load短期入所サービス(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox907().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox908().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox909().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox910().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox911().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox912().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox913().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox914().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox915().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox916().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox917().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load訪問サービス(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox597().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox598().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox599().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox600().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox601().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox602().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox603().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox604().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox605().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox606().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox607().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

    private void load居宅介護予防サービス(JigyoHokokuTokeiData entity) {

        if (entity.get集計結果値() != null) {
            switch (entity.get横番号().intValue()) {
                case NUMBER_2:
                    div.getPnlMain().getTbl3().getTextBox586().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl3().getTextBox587().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl3().getTextBox588().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl3().getTextBox589().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl3().getTextBox590().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl3().getTextBox591().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl3().getTextBox592().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl3().getTextBox593().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl3().getTextBox594().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl3().getTextBox595().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl3().getTextBox596().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }
}
