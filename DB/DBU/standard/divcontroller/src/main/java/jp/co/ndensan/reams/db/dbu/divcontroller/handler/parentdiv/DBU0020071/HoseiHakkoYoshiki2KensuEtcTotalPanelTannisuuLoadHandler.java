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
public class HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuLoadHandler {

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
    private static final Code 集計番号_0102 = new Code("0102");
    private static final Code 集計番号_0202 = new Code("0202");
    private static final Code 集計番号_0302 = new Code("0302");
    private static final Code 集計番号_0402 = new Code("0402");
    private static final RString 単位数総数 = new RString("01");
    private static final RString 単位数第２号被保険者分再掲 = new RString("02");
    private static final RString 単位数総数特例分 = new RString("03");
    private static final RString 単位数第２号被保険者分再掲特例分 = new RString("04");

    private final HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HoseiHakkoYoshiki2KensuEtcTotalPanelDiv
     */
    public HoseiHakkoYoshiki2KensuEtcTotalPanelTannisuuLoadHandler(HoseiHakkoYoshiki2KensuEtcTotalPanelDiv div) {
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
    public List<JigyoHokokuTokeiData> 単位数OnLoad(JigyoHokokuGeppoParameter 引き継ぎデータ) {
        List<JigyoHokokuTokeiData> 単位数 = new ArrayList<>();

        if (引き継ぎデータ.get行集計番号().startsWith(単位数総数.toString())) {
            単位数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0102);
        } else if (引き継ぎデータ.get行集計番号().startsWith(単位数第２号被保険者分再掲.toString())) {
            単位数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0202);
        } else if (引き継ぎデータ.get行集計番号().startsWith(単位数総数特例分.toString())) {
            単位数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0302);
        } else if (引き継ぎデータ.get行集計番号().startsWith(単位数第２号被保険者分再掲特例分.toString())) {
            単位数 = get事業報告月報詳細データリスト(引き継ぎデータ, 集計番号_0402);
        }
        loopList(単位数);
        return 単位数;
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
                div.getPnlMain().getTbl2().getTextBox713().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox714().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox715().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox716().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox717().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox718().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox719().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox720().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox721().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox722().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load定期巡回随時対応型訪問介護看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox641().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox642().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox643().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox644().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox645().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox646().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox647().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox648().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox649().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox650().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load地域密着型介護老人福祉施設入所者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox703().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox704().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox705().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox706().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox707().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox708().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox709().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox710().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox711().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox712().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load地域密着型特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox693().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox694().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox695().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox696().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox697().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox698().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox699().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox700().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox701().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox702().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load小規模多機能型居宅介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox672().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox673().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox674().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox675().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox676().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox677().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox678().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox679().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox680().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox681().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox682().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load認知症対応型通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox661().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox662().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox663().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox664().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox665().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox666().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox667().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox668().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox669().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox670().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox671().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load夜間対応型訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox651().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox652().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox653().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox654().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox655().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox656().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox657().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox658().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox659().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox660().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load地域密着型介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox630().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox631().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox632().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox633().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox634().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox635().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox636().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox637().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox638().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox639().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox640().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load通所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox487().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox488().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox489().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox490().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox491().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox492().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox493().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox494().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox495().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox496().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox497().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load介護予防支援居宅介護支援(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox619().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox620().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox621().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox622().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox623().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox624().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox625().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox626().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox627().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox628().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox629().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load特定施設入居者生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox608().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox609().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox610().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox611().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox612().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox613().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox614().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox615().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox616().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox617().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox618().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load認知症対応型共同生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox683().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox684().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox685().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox686().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox687().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox688().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox689().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox690().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox691().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox692().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load居宅療養管理指導(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox476().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox477().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox478().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox479().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox480().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox481().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox482().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox483().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox484().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox485().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox486().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load短期入所療養介護介護療養型医療施設等(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox553().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox554().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox555().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox556().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox557().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox558().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox559().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox560().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox561().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox562().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox563().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load短期入所療養介護介護老人保健施設(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox542().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox543().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox544().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox545().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox546().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox547().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox548().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox549().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox550().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox551().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox552().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load短期入所生活介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox531().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox532().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox533().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox534().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox535().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox536().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox537().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox538().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox539().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox540().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox541().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load福祉用具貸与(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox575().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox576().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox577().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox578().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox579().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox580().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox581().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox582().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox583().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox584().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox585().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load通所リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox509().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox510().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox511().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox512().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox513().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox514().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox515().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox516().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox517().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox518().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox519().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load通所介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox498().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox499().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox500().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox501().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox502().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox503().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox504().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox505().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox506().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox507().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox508().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load訪問リハビリテーション(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox465().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox466().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox467().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox468().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox469().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox470().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox471().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox472().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox473().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox474().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox475().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load訪問看護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox454().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox455().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox456().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox457().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox458().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox459().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox460().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox461().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox462().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox463().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox464().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load訪問入浴介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox443().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox444().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox445().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox446().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox447().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox448().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox449().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox450().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox451().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox452().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox453().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load訪問介護(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox432().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox433().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox434().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox435().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox436().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox437().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox438().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox439().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox440().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox441().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox442().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load総計(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl2().getTextBox807().setValue(entity.get集計結果値());
                break;
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox808().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox809().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox810().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox811().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox812().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox813().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox814().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox815().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox816().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox817().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox818().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load介護療養型医療施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox797().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox798().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox799().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox800().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox801().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox802().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox803().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox804().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox805().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox806().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load介護老人保健施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox787().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox788().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox789().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox790().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox791().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox792().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox793().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox794().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox795().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox796().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load介護老人福祉施設_2(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl2().getTextBox776().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox777().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox778().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox779().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox780().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox781().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox782().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox783().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox784().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox785().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox786().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load食事提供費用再掲(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl2().getTextBox765().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox766().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox767().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox768().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox769().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox770().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox771().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox772().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox773().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox774().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox775().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load介護療養型医療施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox755().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox756().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox757().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox758().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox759().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox760().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox761().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox762().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox763().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox764().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load介護老人保健施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox745().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox746().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox747().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox748().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox749().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox750().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox751().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox752().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox753().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox754().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load介護老人福祉施設_1(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl2().getTextBox734().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox735().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox736().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox737().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox738().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox739().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox740().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox741().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox742().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox743().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox744().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load施設サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnlMain().getTbl2().getTextBox723().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox724().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox725().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox726().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox727().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox728().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox729().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox730().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox731().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox732().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox733().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load福祉用具住宅改修サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox564().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox565().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox566().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox567().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox568().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox569().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox570().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox571().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox572().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox573().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox574().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load短期入所サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox520().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox521().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox522().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox523().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox524().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox525().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox526().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox527().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox528().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox529().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox530().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load訪問サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox421().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox422().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox423().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox424().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox425().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox426().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox427().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox428().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox429().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox430().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox431().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }

    private void load居宅介護予防サービス(JigyoHokokuTokeiData entity) {

        switch (entity.get横番号().intValue()) {
            case NUMBER_2:
                div.getPnlMain().getTbl2().getTextBox410().setValue(entity.get集計結果値());
                break;
            case NUMBER_3:
                div.getPnlMain().getTbl2().getTextBox411().setValue(entity.get集計結果値());
                break;
            case NUMBER_4:
                div.getPnlMain().getTbl2().getTextBox412().setValue(entity.get集計結果値());
                break;
            case NUMBER_5:
                div.getPnlMain().getTbl2().getTextBox413().setValue(entity.get集計結果値());
                break;
            case NUMBER_6:
                div.getPnlMain().getTbl2().getTextBox414().setValue(entity.get集計結果値());
                break;
            case NUMBER_7:
                div.getPnlMain().getTbl2().getTextBox415().setValue(entity.get集計結果値());
                break;
            case NUMBER_8:
                div.getPnlMain().getTbl2().getTextBox416().setValue(entity.get集計結果値());
                break;
            case NUMBER_9:
                div.getPnlMain().getTbl2().getTextBox417().setValue(entity.get集計結果値());
                break;
            case NUMBER_10:
                div.getPnlMain().getTbl2().getTextBox418().setValue(entity.get集計結果値());
                break;
            case NUMBER_11:
                div.getPnlMain().getTbl2().getTextBox419().setValue(entity.get集計結果値());
                break;
            case NUMBER_12:
                div.getPnlMain().getTbl2().getTextBox420().setValue(entity.get集計結果値());
                break;
            default:
                break;

        }
    }
}
