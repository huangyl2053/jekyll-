/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020031.YoshikiIchinoniIchinosanHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業報告（月報）補正発行_様式１の２、様式１の３補正のハンドラクラスです。
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class YoshikiIchinoniIchinosanHoseiHandler {

    private final YoshikiIchinoniIchinosanHoseiDiv div;
    private static final Code 集計番号_０７１０ = new Code("0710");
    private static final Code 集計番号_０６００ = new Code("0600");
    private static final Code 集計番号_０７２０ = new Code("0720");
    private static final Code 集計番号_０７０２ = new Code("0702");
    private static final Code 集計番号_１０１０ = new Code("1010");
    private static final Code 集計番号_０９００ = new Code("0900");
    private static final Code 集計番号_１０２０ = new Code("1020");
    private static final Code 集計番号_１００２ = new Code("1002");
    private static final RString 削除状態 = new RString("削除");
    private static final Decimal NUM_2 = new Decimal("2");
    private static final Decimal NUM_3 = new Decimal("3");
    private static final Decimal NUM_4 = new Decimal("4");
    private static final Decimal NUM_5 = new Decimal("5");
    private static final Decimal NUM_6 = new Decimal("6");
    private static final Decimal NUM_7 = new Decimal("7");
    private static final Decimal NUM_8 = new Decimal("8");
    private static final Decimal NUM_9 = new Decimal("9");
    private static final Decimal NUM_10 = new Decimal("10");
    private static final Decimal NUM_11 = new Decimal("11");
    private static final Decimal NUM_12 = new Decimal("12");
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
    private static final RString STR_002 = new RString("002");
    private static final RString STR_102 = new RString("102");
    private static final RString STR_202 = new RString("202");
    private static final RString STR_005 = new RString("005");
    private static final RString STR_105 = new RString("105");
    private static final RString STR_205 = new RString("205");
    private static final RString STR_003 = new RString("003");
    private static final RString STR_103 = new RString("103");
    private static final RString STR_203 = new RString("203");
    private static final RString STR_006 = new RString("006");
    private static final RString STR_106 = new RString("106");
    private static final RString STR_206 = new RString("206");
    private static final RString STR_004 = new RString("004");
    private static final RString STR_104 = new RString("104");
    private static final RString STR_204 = new RString("204");
    private static final RString STR_007 = new RString("007");
    private static final RString STR_107 = new RString("107");
    private static final RString STR_207 = new RString("207");
    private static final RString 様式種類_11 = new RString("11");
    private static final RString 様式種類_12 = new RString("12");
    private static final RString 様式種類_21 = new RString("21");
    private static final RString 様式種類_22 = new RString("22");
    private static final RString 様式種類_31 = new RString("31");
    private static final RString 様式種類_32 = new RString("32");

    /**
     * コンストラクタです。
     *
     * @param div YoshikiIchinoniIchinosanHoseiDiv
     */
    public YoshikiIchinoniIchinosanHoseiHandler(YoshikiIchinoniIchinosanHoseiDiv div) {
        this.div = div;
    }

    /**
     * 基本情報エリアが設定のメソッドます。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @param 状態 RString
     */
    public void set基本情報エリア(JigyoHokokuGeppoParameter 引き継ぎデータ, RString 状態) {
        if (削除状態.equals(状態)) {
            div.getPanelDaisan().setDisabled(true);
            div.getPanelDaiyon().setDisabled(true);
            div.getPanelDaigo().setDisabled(true);
        }
        FlexibleDate 報告年月 = new FlexibleDate(引き継ぎデータ.get報告年月());
        FlexibleDate 集計年月 = new FlexibleDate(引き継ぎデータ.get集計年月());
        div.getPanelHead().getTxtHokokuNengetsu().setValue(new RDate(報告年月.toString()));
        div.getPanelHead().getTxtShukeiNengetsu().setValue(new RDate(集計年月.toString()));
        div.getPanelHead().getTxtYosikiHosei().setValue(引き継ぎデータ.get保険者コード());
        div.getPanelHead().getTxtHokensyaName().setValue(引き継ぎデータ.get市町村名称());
    }

    /**
     * 食費_居住費の設定。
     *
     * @param 食費_居住費list List
     */
    public void set食費_居住費(List<JigyoHokokuTokeiData> 食費_居住費list) {
        for (JigyoHokokuTokeiData entity : 食費_居住費list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set食費居住費_申請件数(entity);
                        break;
                    case NUMBER_2:
                        set食費居住費_利用者負担第三段階認定件数(entity);
                        break;
                    case NUMBER_3:
                        set食費居住費_認定件数三当該月末現在(entity);
                        break;
                    case NUMBER_4:
                        set食費居住費_利用者負担第二段階認定件数(entity);
                        break;
                    case NUMBER_5:
                        set食費居住費_認定件数二当該月末現在(entity);
                        break;
                    case NUMBER_6:
                        set食費居住費_利用者負担第一段階認定件数(entity);
                        break;
                    case NUMBER_7:
                        set食費居住費_認定件数一当該月末現在(entity);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * 利用者負担滅額の設定。
     *
     * @param 利用者負担滅額list List
     */
    public void set利用者負担滅額(List<JigyoHokokuTokeiData> 利用者負担滅額list) {
        for (JigyoHokokuTokeiData entity : 利用者負担滅額list) {
            if (entity.get横番号().equals(Decimal.ONE) && entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        div.getPanelDaiyon().getTxtShinseiKensuRiyosha().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_2:
                        div.getPanelDaiyon().getTxtGengakuNinteiKensuRiyosha().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_3:
                        div.getPanelDaiyon().getTxtNinteiKensuGenzaiGengakuRiyosha().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_4:
                        div.getPanelDaiyon().getTxtMenjoNinteiKensuRiyosha().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_5:
                        div.getPanelDaiyon().getTxtNinteiKensuGenzaiMenjoRiyosha().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * 特定負担限度額と利用者負担の設定。
     *
     * @param 特定負担限度額5list List
     * @param 利用者負担5list List
     */
    public void set特定負担限度額と利用者負担(List<JigyoHokokuTokeiData> 特定負担限度額5list,
            List<JigyoHokokuTokeiData> 利用者負担5list) {
        for (JigyoHokokuTokeiData entity : 特定負担限度額5list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set特定負担限度額_申請件数(entity);
                        break;
                    case NUMBER_2:
                        set特定負担限度額_利用者負担第三段階認定件数(entity);
                        break;
                    case NUMBER_3:
                        set特定負担限度額_認定件数54(entity);
                        break;
                    case NUMBER_4:
                        set特定負担限度額_利用者負担第二段階認定件数(entity);
                        break;
                    case NUMBER_5:
                        set特定負担限度額_認定件数56(entity);
                        break;
                    case NUMBER_6:
                        set特定負担限度額_老福受給者等認定件数(entity);
                        break;
                    case NUMBER_7:
                        set特定負担限度額_認定件数58(entity);
                        break;
                    default:
                        break;
                }
            }
        }
        for (JigyoHokokuTokeiData entity : 利用者負担5list) {
            if (entity.get横番号().equals(Decimal.ONE) && entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        div.getPanelDaigo().getTxtShinseiKensu().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_2:
                        div.getPanelDaigo().getTxtGengakuNinteiKensu().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_3:
                        div.getPanelDaigo().getTxtNinteiKensuGenzaiGengaku().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_4:
                        div.getPanelDaigo().getTxtMenjoNinteiKensu().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    case NUMBER_5:
                        div.getPanelDaigo().getTxtNinteiKensuGenzaiMenjo().setValue(
                                new RString(entity.get集計結果値().toString()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void set食費居住費_申請件数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPanelDaisan().getTxtShinseiKensu1().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPanelDaisan().getTxtShinseiKensu2().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPanelDaisan().getTxtShinseiKensu3().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPanelDaisan().getTxtShinseiKensu4().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPanelDaisan().getTxtShinseiKensu5().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPanelDaisan().getTxtShinseiKensu6().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set食費居住費_利用者負担第三段階認定件数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu1().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu2().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu3().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu4().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu5().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu6().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu7().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu8().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu9().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu10().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu11().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_12:
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu12().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set食費居住費_認定件数三当該月末現在(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPanelDaisan().getTxtNinteiDaisanKensu1().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPanelDaisan().getTxtNinteiDaisanKensu2().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPanelDaisan().getTxtNinteiDaisanKensu3().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPanelDaisan().getTxtNinteiDaisanKensu4().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPanelDaisan().getTxtNinteiDaisanKensu5().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPanelDaisan().getTxtNinteiDaisanKensu6().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPanelDaisan().getTxtNinteiDaisanKensu7().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPanelDaisan().getTxtNinteiDaisanKensu8().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPanelDaisan().getTxtNinteiDaisanKensu9().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPanelDaisan().getTxtNinteiDaisanKensu10().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPanelDaisan().getTxtNinteiDaisanKensu11().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_12:
                div.getPanelDaisan().getTxtNinteiDaisanKensu12().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set食費居住費_利用者負担第二段階認定件数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu1().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu2().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu3().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu4().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu5().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu6().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu7().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu8().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu9().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu10().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu11().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_12:
                div.getPanelDaisan().getTxtRiyoshaDainiKensu12().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set食費居住費_認定件数二当該月末現在(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPanelDaisan().getTxtNinteiDainiKensu1().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPanelDaisan().getTxtNinteiDainiKensu2().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPanelDaisan().getTxtNinteiDainiKensu3().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPanelDaisan().getTxtNinteiDainiKensu4().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPanelDaisan().getTxtNinteiDainiKensu5().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPanelDaisan().getTxtNinteiDainiKensu6().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPanelDaisan().getTxtNinteiDainiKensu7().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPanelDaisan().getTxtNinteiDainiKensu8().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPanelDaisan().getTxtNinteiDainiKensu9().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPanelDaisan().getTxtNinteiDainiKensu10().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPanelDaisan().getTxtNinteiDainiKensu11().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_12:
                div.getPanelDaisan().getTxtNinteiDainiKensu12().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set食費居住費_利用者負担第一段階認定件数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu1().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu2().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu3().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu4().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu5().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu6().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu7().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu8().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu9().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu10().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu11().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_12:
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu12().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set食費居住費_認定件数一当該月末現在(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu1().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu2().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu3().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu4().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu5().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu6().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu7().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu8().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu9().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu10().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu11().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_12:
                div.getPanelDaisan().getTxtNinteiDaiichiKensu12().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set特定負担限度額_申請件数(JigyoHokokuTokeiData entity) {
        if (entity.get横番号().equals(Decimal.ONE)) {
            div.getPanelDaigo().getTxtKensu522().setValue(new RString(entity.get集計結果値().toString()));
        }
    }

    private void set特定負担限度額_利用者負担第三段階認定件数(JigyoHokokuTokeiData entity) {
        if (entity.get横番号().equals(Decimal.ONE)) {
            div.getPanelDaigo().getTxtKensu532().setValue(new RString(entity.get集計結果値().toString()));
        } else if (entity.get横番号().equals(NUM_2)) {
            div.getPanelDaigo().getTxtKensu533().setValue(new RString(entity.get集計結果値().toString()));
        }
    }

    private void set特定負担限度額_認定件数54(JigyoHokokuTokeiData entity) {
        if (entity.get横番号().equals(Decimal.ONE)) {
            div.getPanelDaigo().getTxtKensu542().setValue(new RString(entity.get集計結果値().toString()));
        } else if (entity.get横番号().equals(NUM_2)) {
            div.getPanelDaigo().getTxtKensu543().setValue(new RString(entity.get集計結果値().toString()));
        }
    }

    private void set特定負担限度額_利用者負担第二段階認定件数(JigyoHokokuTokeiData entity) {
        if (entity.get横番号().equals(Decimal.ONE)) {
            div.getPanelDaigo().getTxtKensu552().setValue(new RString(entity.get集計結果値().toString()));
        } else if (entity.get横番号().equals(NUM_2)) {
            div.getPanelDaigo().getTxtKensu553().setValue(new RString(entity.get集計結果値().toString()));
        }
    }

    private void set特定負担限度額_認定件数56(JigyoHokokuTokeiData entity) {
        if (entity.get横番号().equals(Decimal.ONE)) {
            div.getPanelDaigo().getTxtKensu562().setValue(new RString(entity.get集計結果値().toString()));
        } else if (entity.get横番号().equals(NUM_2)) {
            div.getPanelDaigo().getTxtKensu563().setValue(new RString(entity.get集計結果値().toString()));
        }
    }

    private void set特定負担限度額_老福受給者等認定件数(JigyoHokokuTokeiData entity) {
        if (entity.get横番号().equals(Decimal.ONE)) {
            div.getPanelDaigo().getTxtKensu572().setValue(new RString(entity.get集計結果値().toString()));
        } else if (entity.get横番号().equals(NUM_2)) {
            div.getPanelDaigo().getTxtKensu573().setValue(new RString(entity.get集計結果値().toString()));
        }
    }

    private void set特定負担限度額_認定件数58(JigyoHokokuTokeiData entity) {
        if (entity.get横番号().equals(Decimal.ONE)) {
            div.getPanelDaigo().getTxtKensu582().setValue(new RString(entity.get集計結果値().toString()));
        } else if (entity.get横番号().equals(NUM_2)) {
            div.getPanelDaigo().getTxtKensu583().setValue(new RString(entity.get集計結果値().toString()));
        }
    }

    /**
     * 引き継ぎデータより、事業報告月報詳細データリストを取得のメソッドます。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @param 集計番号 Code
     * @return List<JigyoHokokuNenpoResult>
     */
    public List<JigyoHokokuTokeiData> get事業報告月報詳細データリスト(
            JigyoHokokuGeppoParameter 引き継ぎデータ, Code 集計番号) {
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
        return JigyoHokokuGeppoHoseiHako.createInstance().getJigyoHokokuGeppoDetal(parameter);
    }

    /**
     * 引き継ぎデータより、画面修正データを抽出する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoHoseiHakoResult
     * @param 様式種類List11 List
     * @param 様式種類List12 List
     * @param 様式種類List21 List
     * @param 様式種類List22 List
     * @param 様式種類List31 List
     * @param 様式種類List32 List
     * @param 食費_居住費データリスト List
     * @param 利用者負担滅額データリスト List
     * @param 特定負担限度額データリスト List
     * @param 利用者負担データリスト List
     * @return List<JigyoHokokuNenpoUpdateParameter> 修正データリスト
     */
    public List<JigyoHokokuTokeiData> get修正データリスト(JigyoHokokuGeppoParameter 引き継ぎデータ,
            List<RString> 様式種類List11,
            List<RString> 様式種類List12,
            List<RString> 様式種類List21,
            List<RString> 様式種類List22,
            List<RString> 様式種類List31,
            List<RString> 様式種類List32,
            List<JigyoHokokuTokeiData> 食費_居住費データリスト,
            List<JigyoHokokuTokeiData> 利用者負担滅額データリスト,
            List<JigyoHokokuTokeiData> 特定負担限度額データリスト,
            List<JigyoHokokuTokeiData> 利用者負担データリスト) {
        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        if (様式種類List11.contains(様式種類) || 様式種類List21.contains(様式種類)) {
            修正データリスト = get食費_居住費修正データリスト(食費_居住費データリスト, 修正データリスト);
        } else if (様式種類List31.contains(様式種類) || 様式種類List12.contains(様式種類)) {
            修正データリスト = get利用者負担滅額修正データリスト(利用者負担滅額データリスト, 修正データリスト);
        } else if (様式種類List22.contains(様式種類) || 様式種類List32.contains(様式種類)) {
            修正データリスト = get特定と利用者修正データリスト(
                    特定負担限度額データリスト,
                    利用者負担データリスト,
                    修正データリスト,
                    様式種類,
                    様式種類List22,
                    様式種類List32);
        }
        return 修正データリスト;
    }

    private List<JigyoHokokuTokeiData> get食費_居住費修正データリスト(
            List<JigyoHokokuTokeiData> 食費_居住費リスト,
            List<JigyoHokokuTokeiData> 修正リスト) {
        修正リスト = get申請件数(食費_居住費リスト, 修正リスト);
        修正リスト = get認定件数(食費_居住費リスト, 修正リスト, NUM_2,
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu1().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu2().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu3().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu4().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu5().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu6().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu7().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu8().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu9().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu10().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu11().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaisanKensu12().getValue());
        修正リスト = get認定件数(食費_居住費リスト, 修正リスト, NUM_3,
                div.getPanelDaisan().getTxtNinteiDaisanKensu1().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu2().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu3().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu4().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu5().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu6().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu7().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu8().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu9().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu10().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu11().getValue(),
                div.getPanelDaisan().getTxtNinteiDaisanKensu12().getValue());
        修正リスト = get認定件数(食費_居住費リスト, 修正リスト, NUM_4,
                div.getPanelDaisan().getTxtRiyoshaDainiKensu1().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu2().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu3().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu4().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu5().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu6().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu7().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu8().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu9().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu10().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu11().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDainiKensu12().getValue());
        修正リスト = get認定件数(食費_居住費リスト, 修正リスト, NUM_5,
                div.getPanelDaisan().getTxtNinteiDainiKensu1().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu2().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu3().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu4().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu5().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu6().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu7().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu8().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu9().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu10().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu11().getValue(),
                div.getPanelDaisan().getTxtNinteiDainiKensu12().getValue());
        修正リスト = get認定件数(食費_居住費リスト, 修正リスト, NUM_6,
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu1().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu2().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu3().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu4().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu5().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu6().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu7().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu8().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu9().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu10().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu11().getValue(),
                div.getPanelDaisan().getTxtRiyoshaDaiichiKensu12().getValue());
        修正リスト = get認定件数(食費_居住費リスト, 修正リスト, NUM_7,
                div.getPanelDaisan().getTxtNinteiDaiichiKensu1().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu2().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu3().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu4().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu5().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu6().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu7().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu8().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu9().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu10().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu11().getValue(),
                div.getPanelDaisan().getTxtNinteiDaiichiKensu12().getValue());

        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get認定件数(
            List<JigyoHokokuTokeiData> 食費_居住費リスト,
            List<JigyoHokokuTokeiData> 修正リスト,
            Decimal 縦番号,
            RString 集計結果値1,
            RString 集計結果値2,
            RString 集計結果値3,
            RString 集計結果値4,
            RString 集計結果値5,
            RString 集計結果値6,
            RString 集計結果値7,
            RString 集計結果値8,
            RString 集計結果値9,
            RString 集計結果値10,
            RString 集計結果値11,
            RString 集計結果値12) {

        修正リスト = set集計結果値(集計結果値1, 修正リスト, 食費_居住費リスト, Decimal.ONE, 縦番号);
        修正リスト = set集計結果値(集計結果値2, 修正リスト, 食費_居住費リスト, NUM_2, 縦番号);
        修正リスト = set集計結果値(集計結果値3, 修正リスト, 食費_居住費リスト, NUM_3, 縦番号);
        修正リスト = set集計結果値(集計結果値4, 修正リスト, 食費_居住費リスト, NUM_4, 縦番号);
        修正リスト = set集計結果値(集計結果値5, 修正リスト, 食費_居住費リスト, NUM_5, 縦番号);
        修正リスト = set集計結果値(集計結果値6, 修正リスト, 食費_居住費リスト, NUM_6, 縦番号);
        修正リスト = set集計結果値(集計結果値7, 修正リスト, 食費_居住費リスト, NUM_7, 縦番号);
        修正リスト = set集計結果値(集計結果値8, 修正リスト, 食費_居住費リスト, NUM_8, 縦番号);
        修正リスト = set集計結果値(集計結果値9, 修正リスト, 食費_居住費リスト, NUM_9, 縦番号);
        修正リスト = set集計結果値(集計結果値10, 修正リスト, 食費_居住費リスト, NUM_10, 縦番号);
        修正リスト = set集計結果値(集計結果値11, 修正リスト, 食費_居住費リスト, NUM_11, 縦番号);
        修正リスト = set集計結果値(集計結果値12, 修正リスト, 食費_居住費リスト, NUM_12, 縦番号);
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get申請件数(
            List<JigyoHokokuTokeiData> 食費_居住費リスト,
            List<JigyoHokokuTokeiData> 修正リスト) {

        修正リスト = set集計結果値(div.getPanelDaisan().getTxtShinseiKensu1().getValue(),
                修正リスト, 食費_居住費リスト, Decimal.ONE, Decimal.ONE);
        修正リスト = set集計結果値(div.getPanelDaisan().getTxtShinseiKensu2().getValue(),
                修正リスト, 食費_居住費リスト, NUM_2, Decimal.ONE);
        修正リスト = set集計結果値(div.getPanelDaisan().getTxtShinseiKensu3().getValue(),
                修正リスト, 食費_居住費リスト, NUM_3, Decimal.ONE);
        修正リスト = set集計結果値(div.getPanelDaisan().getTxtShinseiKensu4().getValue(),
                修正リスト, 食費_居住費リスト, NUM_4, Decimal.ONE);
        修正リスト = set集計結果値(div.getPanelDaisan().getTxtShinseiKensu5().getValue(),
                修正リスト, 食費_居住費リスト, NUM_5, Decimal.ONE);
        修正リスト = set集計結果値(div.getPanelDaisan().getTxtShinseiKensu6().getValue(),
                修正リスト, 食費_居住費リスト, NUM_6, Decimal.ONE);
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> set集計結果値(
            RString 集計結果値,
            List<JigyoHokokuTokeiData> 修正リスト,
            List<JigyoHokokuTokeiData> 食費_居住費リスト,
            Decimal 横番号,
            Decimal 縦番号) {
        JigyoHokokuTokeiData entity = check事業報告統計データ(食費_居住費リスト, 横番号, 縦番号);
        if (集計結果値 == null || 集計結果値.isEmpty()) {
            if (entity != null && entity.get集計結果値() != null) {
                entity = entity.createBuilderForEdit().set集計結果値(null).build();
                entity = entity.modifiedModel();
                修正リスト.add(entity);
                return 修正リスト;
            }
        } else {
            if (entity == null) {
                entity = set事業報告統計データ(食費_居住費リスト, 横番号, 縦番号,
                        new Decimal(集計結果値.toString()));
                修正リスト.add(entity);
                return 修正リスト;
            } else if (entity.get集計結果値() == null) {
                entity = entity.createBuilderForEdit().set集計結果値(new Decimal(集計結果値.toString())).build();
                entity = entity.modifiedModel();
                修正リスト.add(entity);
                return 修正リスト;
            } else if (!entity.get集計結果値().equals(new Decimal(集計結果値.toString()))) {
                entity = entity.createBuilderForEdit().set集計結果値(new Decimal(集計結果値.toString())).build();
                entity = entity.modifiedModel();
                修正リスト.add(entity);
                return 修正リスト;
            }
        }
        return 修正リスト;
    }

    private JigyoHokokuTokeiData check事業報告統計データ(
            List<JigyoHokokuTokeiData> 食費_居住費リスト,
            Decimal 横番号,
            Decimal 縦番号) {
        for (JigyoHokokuTokeiData entity : 食費_居住費リスト) {
            if (entity.get縦番号().equals(縦番号) && entity.get横番号().equals(横番号)) {
                return entity;
            }
        }
        return null;
    }

    private JigyoHokokuTokeiData set事業報告統計データ(
            List<JigyoHokokuTokeiData> 食費_居住費リスト,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 集計結果値) {
        JigyoHokokuTokeiData entity = 食費_居住費リスト.get(0).createBuilderForEdit()
                .set横番号(横番号)
                .set縦番号(縦番号)
                .set集計結果値(集計結果値)
                .set集計項目名称(null)
                .set縦項目コード(null)
                .set横項目コード(null).build();
        entity = entity.addedModel();
        return entity;
    }

    private List<JigyoHokokuTokeiData> get利用者負担滅額修正データリスト(
            List<JigyoHokokuTokeiData> 利用者負担滅額リスト,
            List<JigyoHokokuTokeiData> 修正リスト) {

        修正リスト = set集計結果値(div.getPanelDaiyon().getTxtShinseiKensuRiyosha().getValue(),
                修正リスト, 利用者負担滅額リスト, Decimal.ONE, Decimal.ONE);
        修正リスト = set集計結果値(div.getPanelDaiyon().getTxtGengakuNinteiKensuRiyosha().getValue(),
                修正リスト, 利用者負担滅額リスト, Decimal.ONE, NUM_2);
        修正リスト = set集計結果値(div.getPanelDaiyon().getTxtNinteiKensuGenzaiGengakuRiyosha().getValue(),
                修正リスト, 利用者負担滅額リスト, Decimal.ONE, NUM_3);
        修正リスト = set集計結果値(div.getPanelDaiyon().getTxtMenjoNinteiKensuRiyosha().getValue(),
                修正リスト, 利用者負担滅額リスト, Decimal.ONE, NUM_4);
        修正リスト = set集計結果値(div.getPanelDaiyon().getTxtNinteiKensuGenzaiMenjoRiyosha().getValue(),
                修正リスト, 利用者負担滅額リスト, Decimal.ONE, NUM_5);
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get特定と利用者修正データリスト(
            List<JigyoHokokuTokeiData> 特定負担限度額リスト,
            List<JigyoHokokuTokeiData> 利用者負担リスト,
            List<JigyoHokokuTokeiData> 修正リスト,
            RString 様式種類,
            List<RString> list22,
            List<RString> list32) {

        Code 特定負担限度額集計番号 = null;
        Code 利用者負担集計番号 = null;
        if (list22.contains(様式種類)) {
            特定負担限度額集計番号 = 集計番号_０７２０;
            利用者負担集計番号 = 集計番号_０７０２;
        } else if (list32.contains(様式種類)) {
            特定負担限度額集計番号 = 集計番号_１０２０;
            利用者負担集計番号 = 集計番号_１００２;
        }
        if (特定負担限度額リスト == null || 特定負担限度額リスト.isEmpty()) {
            特定負担限度額リスト = new ArrayList<>();
            JigyoHokokuTokeiData entity = 利用者負担リスト.get(0).createBuilderForEdit()
                    .set集計番号(特定負担限度額集計番号)
                    .set横番号(Decimal.ONE)
                    .set縦番号(Decimal.ONE)
                    .set集計結果値(null)
                    .set集計項目名称(null)
                    .set縦項目コード(null)
                    .set横項目コード(null).build();
            特定負担限度額リスト.add(entity);
        }
        if (利用者負担リスト == null || 利用者負担リスト.isEmpty()) {
            利用者負担リスト = new ArrayList<>();
            JigyoHokokuTokeiData entity = 特定負担限度額リスト.get(0).createBuilderForEdit()
                    .set集計番号(利用者負担集計番号)
                    .set横番号(Decimal.ONE)
                    .set縦番号(Decimal.ONE)
                    .set集計結果値(null)
                    .set集計項目名称(null)
                    .set縦項目コード(null)
                    .set横項目コード(null).build();
            利用者負担リスト.add(entity);
        }
        修正リスト = set集計結果値(div.getPanelDaigo().getTxtKensu522().getValue(),
                修正リスト, 特定負担限度額リスト, Decimal.ONE, Decimal.ONE);
        修正リスト = get特定負担限度額_認定件数(特定負担限度額リスト, 修正リスト, NUM_2,
                div.getPanelDaigo().getTxtKensu532().getValue(),
                div.getPanelDaigo().getTxtKensu533().getValue());
        修正リスト = get特定負担限度額_認定件数(特定負担限度額リスト, 修正リスト, NUM_3,
                div.getPanelDaigo().getTxtKensu542().getValue(),
                div.getPanelDaigo().getTxtKensu543().getValue());
        修正リスト = get特定負担限度額_認定件数(特定負担限度額リスト, 修正リスト, NUM_4,
                div.getPanelDaigo().getTxtKensu552().getValue(),
                div.getPanelDaigo().getTxtKensu553().getValue());
        修正リスト = get特定負担限度額_認定件数(特定負担限度額リスト, 修正リスト, NUM_5,
                div.getPanelDaigo().getTxtKensu562().getValue(),
                div.getPanelDaigo().getTxtKensu563().getValue());
        修正リスト = get特定負担限度額_認定件数(特定負担限度額リスト, 修正リスト, NUM_6,
                div.getPanelDaigo().getTxtKensu572().getValue(),
                div.getPanelDaigo().getTxtKensu573().getValue());
        修正リスト = get特定負担限度額_認定件数(特定負担限度額リスト, 修正リスト, NUM_7,
                div.getPanelDaigo().getTxtKensu582().getValue(),
                div.getPanelDaigo().getTxtKensu583().getValue());

        修正リスト = set集計結果値(div.getPanelDaigo().getTxtShinseiKensu().getValue(),
                修正リスト, 利用者負担リスト, Decimal.ONE, Decimal.ONE);
        修正リスト = set集計結果値(div.getPanelDaigo().getTxtGengakuNinteiKensu().getValue(),
                修正リスト, 利用者負担リスト, Decimal.ONE, NUM_2);
        修正リスト = set集計結果値(div.getPanelDaigo().getTxtNinteiKensuGenzaiGengaku().getValue(),
                修正リスト, 利用者負担リスト, Decimal.ONE, NUM_3);
        修正リスト = set集計結果値(div.getPanelDaigo().getTxtMenjoNinteiKensu().getValue(),
                修正リスト, 利用者負担リスト, Decimal.ONE, NUM_4);
        修正リスト = set集計結果値(div.getPanelDaigo().getTxtNinteiKensuGenzaiMenjo().getValue(),
                修正リスト, 利用者負担リスト, Decimal.ONE, NUM_5);
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get特定負担限度額_認定件数(
            List<JigyoHokokuTokeiData> 特定負担限度額リスト,
            List<JigyoHokokuTokeiData> 修正リスト,
            Decimal 縦番号,
            RString 集計結果値1,
            RString 集計結果値2) {
        修正リスト = set集計結果値(集計結果値1,
                修正リスト, 特定負担限度額リスト, Decimal.ONE, 縦番号);
        修正リスト = set集計結果値(集計結果値2,
                修正リスト, 特定負担限度額リスト, NUM_2, 縦番号);
        return 修正リスト;
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

    /**
     * 画面項目「計」で入力された値の整合性をチェックします。
     *
     * @return boolean チェック結果
     */
    public boolean is整合性チェック_NG() {
        RString 介護老人福祉施設 = div.getPanelDaisan().getTxtShinseiKensu1().getValue();
        RString 介護老人保健施設 = div.getPanelDaisan().getTxtShinseiKensu2().getValue();
        RString 介護療養型医療施設 = div.getPanelDaisan().getTxtShinseiKensu3().getValue();
        RString 地域密着型 = div.getPanelDaisan().getTxtShinseiKensu4().getValue();
        RString その他 = div.getPanelDaisan().getTxtShinseiKensu5().getValue();
        RString 計 = div.getPanelDaisan().getTxtShinseiKensu6().getValue();
        Decimal 福祉施設 = (null == 介護老人福祉施設 || 介護老人福祉施設.isEmpty())
                ? Decimal.ZERO : new Decimal(介護老人福祉施設.toString());
        Decimal 保健施設 = (null == 介護老人保健施設 || 介護老人保健施設.isEmpty())
                ? Decimal.ZERO : new Decimal(介護老人保健施設.toString());
        Decimal 医療施設 = (null == 介護療養型医療施設 || 介護療養型医療施設.isEmpty())
                ? Decimal.ZERO : new Decimal(介護療養型医療施設.toString());
        Decimal 密着型 = (null == 地域密着型 || 地域密着型.isEmpty())
                ? Decimal.ZERO : new Decimal(地域密着型.toString());
        Decimal その他data = (null == その他 || その他.isEmpty()) ? Decimal.ZERO : new Decimal(その他.toString());
        Decimal 計data = (null == 計 || 計.isEmpty()) ? Decimal.ZERO : new Decimal(計.toString());
        return !計data.equals(福祉施設.add(保健施設).add(医療施設).add(密着型).add(その他data));
    }

    /**
     * 事業報告月報詳細データの更新する。
     *
     * @param 修正データリスト List<JigyoHokokuTokeiData>
     */
    public void update(List<JigyoHokokuTokeiData> 修正データリスト) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.updateJigyoHokokuGeppoEntity(修正データリスト);
    }

    /**
     * 様式種類の初期化のメソッドます。
     *
     * @return map 様式種類
     */
    public Map<RString, ArrayList<RString>> set様式種類() {
        Map<RString, ArrayList<RString>> map = new HashMap<>();
        ArrayList<RString> list11 = new ArrayList<>();
        list11.add(STR_002);
        list11.add(STR_102);
        list11.add(STR_202);
        map.put(様式種類_11, list11);
        ArrayList<RString> list12 = new ArrayList<>();
        list12.add(STR_005);
        list12.add(STR_105);
        list12.add(STR_205);
        map.put(様式種類_12, list12);
        ArrayList<RString> list21 = new ArrayList<>();
        list21.add(STR_003);
        list21.add(STR_103);
        list21.add(STR_203);
        map.put(様式種類_21, list21);
        ArrayList<RString> list22 = new ArrayList<>();
        list22.add(STR_006);
        list22.add(STR_106);
        list22.add(STR_206);
        map.put(様式種類_22, list22);
        ArrayList<RString> list31 = new ArrayList<>();
        list31.add(STR_004);
        list31.add(STR_104);
        list31.add(STR_204);
        map.put(様式種類_31, list31);
        ArrayList<RString> list32 = new ArrayList<>();
        list32.add(STR_007);
        list32.add(STR_107);
        list32.add(STR_207);
        map.put(様式種類_32, list32);
        return map;
    }
}
