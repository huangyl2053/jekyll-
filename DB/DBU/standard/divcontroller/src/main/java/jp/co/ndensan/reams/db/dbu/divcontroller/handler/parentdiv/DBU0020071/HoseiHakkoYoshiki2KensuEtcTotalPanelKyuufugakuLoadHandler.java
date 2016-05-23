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
public class HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuLoadHandler {

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
    private static final Code 集計番号_0104 = new Code("0104");
    private static final Code 集計番号_0204 = new Code("0204");
    private static final Code 集計番号_0304 = new Code("0304");
    private static final Code 集計番号_0404 = new Code("0404");
    private static final RString 給付額総数 = new RString("01");
    private static final RString 給付額第２号被保険者分再掲 = new RString("02");
    private static final RString 給付額総数特例分 = new RString("03");
    private static final RString 給付額第２号被保険者分再掲特例分 = new RString("04");

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuLoadHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
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
    public void 給付額OnLoad(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        List<JigyoHokokuTokeiData> 給付額 = new ArrayList<>();

        if (引き継ぎデータ.get行集計番号().startsWith(給付額総数.toString())) {
            給付額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0104);
        } else if (引き継ぎデータ.get行集計番号().startsWith(給付額第２号被保険者分再掲.toString())) {
            給付額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0204);
        } else if (引き継ぎデータ.get行集計番号().startsWith(給付額総数特例分.toString())) {
            給付額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0304);
        } else if (引き継ぎデータ.get行集計番号().startsWith(給付額第２号被保険者分再掲特例分.toString())) {
            給付額 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0404);
        }
        loopList(給付額);
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
                    div.getPnlMain().getTbl4().getTextBox1509().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1510().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1511().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1512().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1513().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1514().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1515().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1516().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1517().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1518().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1437().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1438().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1439().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1440().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1441().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1442().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1443().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1444().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1445().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1446().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1499().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1500().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1501().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1502().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1503().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1504().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1505().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1506().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1507().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1508().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1489().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1490().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1491().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1492().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1493().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1494().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1495().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1496().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1497().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1498().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1468().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1469().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1470().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1471().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1472().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1473().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1474().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1475().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1476().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1477().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1478().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1457().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1458().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1459().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1460().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1461().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1462().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1463().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1464().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1465().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1466().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1467().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1447().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1448().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1449().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1450().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1451().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1452().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1453().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1454().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1455().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1456().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1426().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1427().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1428().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1429().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1430().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1431().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1432().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1433().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1434().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1435().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1436().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1283().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1284().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1285().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1286().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1287().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1288().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1289().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1290().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1291().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1292().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1293().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1415().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1416().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1417().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1418().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1419().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1420().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1421().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1422().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1423().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1424().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1425().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1404().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1405().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1406().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1407().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1408().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1409().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1410().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1411().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1412().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1413().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1414().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1479().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1480().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1481().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1482().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1483().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1484().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1485().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1486().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1487().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1488().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1272().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1273().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1274().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1275().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1276().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1277().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1278().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1279().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1280().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1281().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1282().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1349().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1350().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1351().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1352().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1353().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1354().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1355().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1356().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1357().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1358().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1359().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1338().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1339().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1340().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1341().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1342().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1343().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1344().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1345().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1346().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1347().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1348().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1327().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1328().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1329().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1330().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1331().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1332().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1333().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1334().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1335().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1336().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1337().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1371().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1372().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1373().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1374().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1375().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1376().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1377().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1378().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1379().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1380().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1381().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1305().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1306().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1307().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1308().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1309().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1310().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1311().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1312().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1313().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1314().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1315().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1294().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1295().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1296().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1297().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1298().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1299().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1300().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1301().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1302().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1303().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1304().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1261().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1262().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1263().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1264().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1265().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1266().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1267().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1268().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1269().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1270().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1271().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1250().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1251().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1252().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1253().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1254().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1255().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1256().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1257().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1258().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1259().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1260().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1239().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1240().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1241().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1242().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1243().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1244().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1245().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1246().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1247().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1248().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1249().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1228().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1229().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1230().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1231().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1232().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1233().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1234().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1235().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1236().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1237().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1238().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1603().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_2:
                    div.getPnlMain().getTbl4().getTextBox1604().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1605().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1606().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1607().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1608().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1609().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1610().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1611().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1612().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1613().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1614().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1593().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1594().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1595().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1596().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1597().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1598().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1599().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1600().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1601().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1602().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1583().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1584().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1585().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1586().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1587().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1588().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1589().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1590().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1591().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1592().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1572().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1573().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1574().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1575().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1576().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1577().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1578().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1579().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1580().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1581().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1582().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1561().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1562().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1563().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1564().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1565().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1566().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1567().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1568().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1569().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1570().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1571().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1551().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1552().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1553().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1554().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1555().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1556().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1557().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1558().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1559().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1560().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1541().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1542().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1543().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1544().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1545().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1546().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1547().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1548().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1549().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1550().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1530().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1531().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1532().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1533().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1534().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1535().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1536().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1537().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1538().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1539().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1540().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1519().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1520().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1521().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1522().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1523().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1524().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1525().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1526().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1527().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1528().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1529().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1393().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1394().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1395().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1396().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1397().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1398().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1399().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1400().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1401().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1402().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1403().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1382().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1383().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1384().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1385().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1386().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1387().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1388().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1389().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1390().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1391().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1392().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1360().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1361().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1362().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1363().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1364().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1365().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1366().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1367().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1368().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1369().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1370().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1316().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1317().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1318().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1319().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1320().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1321().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1322().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1323().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1324().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1325().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1326().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1217().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1218().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1219().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1220().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1221().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1222().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1223().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1224().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1225().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1226().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1227().setValue(new RString(entity.get集計結果値().toString()));
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
                    div.getPnlMain().getTbl4().getTextBox1206().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_3:
                    div.getPnlMain().getTbl4().getTextBox1207().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_4:
                    div.getPnlMain().getTbl4().getTextBox1208().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_5:
                    div.getPnlMain().getTbl4().getTextBox1209().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_6:
                    div.getPnlMain().getTbl4().getTextBox1210().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_7:
                    div.getPnlMain().getTbl4().getTextBox1211().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_8:
                    div.getPnlMain().getTbl4().getTextBox1212().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_9:
                    div.getPnlMain().getTbl4().getTextBox1213().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_10:
                    div.getPnlMain().getTbl4().getTextBox1214().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_11:
                    div.getPnlMain().getTbl4().getTextBox1215().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                case NUMBER_12:
                    div.getPnlMain().getTbl4().getTextBox1216().setValue(new RString(entity.get集計結果値().toString()));
                    break;
                default:
                    break;
            }
        }
    }

}
