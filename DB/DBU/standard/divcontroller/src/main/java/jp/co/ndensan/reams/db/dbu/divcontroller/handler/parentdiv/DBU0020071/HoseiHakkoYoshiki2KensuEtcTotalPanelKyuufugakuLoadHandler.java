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
public class HoseiHakkoYoshiki2KensuEtcTotalPanelKyuufugakuLoadHandler {

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
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> 給付額OnLoad(JigyoHokokuGeppoParameter 引き継ぎデータ) {
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
        return 給付額;
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
                div.getPnlMain().getTbl4().getTextBox1509().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1510().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1511().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1512().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1513().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1514().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1515().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1516().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1517().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1518().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load定期巡回随時対応型訪問介護看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1437().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1438().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1439().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1440().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1441().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1442().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1443().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1444().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1445().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1446().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型介護老人福祉施設入所者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1499().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1500().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1501().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1502().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1503().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1504().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1505().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1506().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1507().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1508().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1489().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1490().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1491().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1492().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1493().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1494().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1495().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1496().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1497().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1498().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load小規模多機能型居宅介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1468().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1469().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1470().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1471().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1472().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1473().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1474().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1475().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1476().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1477().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1478().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load認知症対応型通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1457().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1458().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1459().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1460().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1461().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1462().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1463().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1464().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1465().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1466().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1467().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load夜間対応型訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1447().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1448().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1449().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1450().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1451().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1452().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1453().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1454().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1455().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1456().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load地域密着型介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1426().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1427().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1428().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1429().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1430().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1431().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1432().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1433().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1434().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1435().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1436().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1283().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1284().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1285().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1286().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1287().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1288().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1289().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1290().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1291().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1292().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1293().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護予防支援居宅介護支援(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1415().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1416().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1417().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1418().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1419().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1420().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1421().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1422().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1423().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1424().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1425().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1404().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1405().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1406().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1407().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1408().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1409().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1410().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1411().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1412().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1413().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1414().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load認知症対応型共同生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1479().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1480().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1481().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1482().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1483().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1484().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1485().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1486().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1487().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1488().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load居宅療養管理指導(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1272().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1273().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1274().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1275().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1276().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1277().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1278().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1279().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1280().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1281().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1282().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所療養介護介護療養型医療施設等(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1349().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1350().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1351().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1352().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1353().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1354().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1355().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1356().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1357().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1358().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1359().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所療養介護介護老人保健施設(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1338().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1339().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1340().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1341().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1342().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1343().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1344().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1345().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1346().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1347().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1348().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1327().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1328().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1329().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1330().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1331().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1332().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1333().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1334().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1335().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1336().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1337().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具貸与(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1371().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1372().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1373().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1374().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1375().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1376().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1377().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1378().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1379().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1380().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1381().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1305().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1306().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1307().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1308().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1309().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1310().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1311().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1312().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1313().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1314().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1315().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1294().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1295().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1296().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1297().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1298().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1299().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1300().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1301().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1302().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1303().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1304().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1261().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1262().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1263().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1264().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1265().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1266().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1267().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1268().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1269().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1270().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1271().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1250().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1251().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1252().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1253().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1254().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1255().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1256().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1257().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1258().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1259().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1260().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問入浴介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1239().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1240().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1241().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1242().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1243().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1244().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1245().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1246().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1247().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1248().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1249().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1228().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1229().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1230().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1231().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1232().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1233().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1234().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1235().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1236().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1237().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1238().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load総計(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl4().getTextBox1603().setValue(entity.get集計結果値());
                break;
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1604().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1605().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1606().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1607().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1608().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1609().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1610().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1611().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1612().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1613().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1614().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護療養型医療施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1593().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1594().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1595().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1596().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1597().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1598().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1599().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1600().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1601().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1602().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人保健施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1583().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1584().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1585().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1586().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1587().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1588().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1589().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1590().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1591().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1592().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人福祉施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl4().getTextBox1572().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1573().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1574().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1575().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1576().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1577().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1578().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1579().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1580().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1581().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1582().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load食事提供費用再掲(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl4().getTextBox1561().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1562().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1563().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1564().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1565().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1566().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1567().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1568().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1569().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1570().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1571().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護療養型医療施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1551().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1552().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1553().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1554().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1555().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1556().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1557().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1558().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1559().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1560().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人保健施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1541().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1542().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1543().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1544().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1545().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1546().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1547().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1548().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1549().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1550().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load介護老人福祉施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl4().getTextBox1530().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1531().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1532().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1533().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1534().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1535().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1536().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1537().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1538().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1539().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1540().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load施設サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl4().getTextBox1519().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1520().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1521().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1522().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1523().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1524().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1525().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1526().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1527().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1528().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1529().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load住宅改修費(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1393().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1394().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1395().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1396().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1397().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1398().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1399().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1400().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1401().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1402().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1403().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具購入費(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1382().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1383().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1384().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1385().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1386().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1387().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1388().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1389().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1390().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1391().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1392().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load福祉用具住宅改修サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1360().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1361().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1362().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1363().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1364().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1365().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1366().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1367().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1368().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1369().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1370().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load短期入所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1316().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1317().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1318().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1319().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1320().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1321().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1322().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1323().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1324().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1325().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1326().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load訪問サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1217().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1218().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1219().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1220().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1221().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1222().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1223().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1224().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1225().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1226().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1227().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

    private void load居宅介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl4().getTextBox1206().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl4().getTextBox1207().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl4().getTextBox1208().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl4().getTextBox1209().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl4().getTextBox1210().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl4().getTextBox1211().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl4().getTextBox1212().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl4().getTextBox1213().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl4().getTextBox1214().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl4().getTextBox1215().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl4().getTextBox1216().setValue(entity.get集計結果値());
                break;
            default:
                break;
        }
    }

}
