/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020051;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020051.YoshikiIchinogoHoseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBUMN91003_事業報告（月報）補正発行_様式１の５補正
 *
 * @reamsid_L DBU-1100-050 quxiaodong
 */
public class YoshikiIchinogoHoseiHandler {

    private final YoshikiIchinogoHoseiDiv div;
    private static final RString 削除状態 = new RString("削除");
    private static final RString 様式種類_11 = new RString("11");
    private static final RString 様式種類_21 = new RString("21");
    private static final RString 様式種類_31 = new RString("31");
    private static final RString 様式種類_41 = new RString("41");
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
    private static final RString STR_010 = new RString("010");
    private static final RString STR_110 = new RString("110");
    private static final RString STR_210 = new RString("210");
    private static final RString STR_011 = new RString("011");
    private static final RString STR_012 = new RString("012");
    private static final RString STR_013 = new RString("013");
    private static final RString STR_111 = new RString("111");
    private static final RString STR_112 = new RString("112");
    private static final RString STR_113 = new RString("113");
    private static final RString STR_211 = new RString("211");
    private static final RString STR_212 = new RString("212");
    private static final RString STR_213 = new RString("213");
    private static final RString STR_014 = new RString("014");
    private static final RString STR_015 = new RString("015");
    private static final RString STR_016 = new RString("016");
    private static final RString STR_114 = new RString("114");
    private static final RString STR_115 = new RString("115");
    private static final RString STR_116 = new RString("116");
    private static final RString STR_214 = new RString("214");
    private static final RString STR_215 = new RString("215");
    private static final RString STR_216 = new RString("216");
    private static final RString STR_017 = new RString("017");
    private static final RString STR_018 = new RString("018");
    private static final RString STR_019 = new RString("019");
    private static final RString STR_117 = new RString("117");
    private static final RString STR_118 = new RString("118");
    private static final RString STR_119 = new RString("119");
    private static final RString STR_217 = new RString("217");
    private static final RString STR_218 = new RString("218");
    private static final RString STR_219 = new RString("219");

    /**
     * コンストラクタです。
     *
     * @param div YoshikiIchinogoHoseiDiv
     */
    public YoshikiIchinogoHoseiHandler(YoshikiIchinogoHoseiDiv div) {
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
            div.getPnl11().setDisabled(true);
            div.getPnl12().setDisabled(true);
            div.getPnl13().setDisabled(true);
            div.getPnl14().setDisabled(true);
        }
        FlexibleDate 報告年月 = new FlexibleDate(引き継ぎデータ.get報告年月());
        FlexibleDate 集計年月 = new FlexibleDate(引き継ぎデータ.get集計年月());
        div.getPnlMain().getTxtHokokuNengetsu().setValue(new RDate(報告年月.toString()));
        div.getPnlMain().getTxtShukeiNengetsu().setValue(new RDate(集計年月.toString()));
        div.getPnlMain().getTxtYosikiHosei().setValue(引き継ぎデータ.get保険者コード());
        div.getPnlMain().getTxtHokensyaName().setValue(引き継ぎデータ.get市町村名称());
    }

    /**
     * 引き継ぎデータより、画面修正データを抽出する。
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     * @param list11 List<RString>
     * @param list21 List<RString>
     * @param list31 List<RString>
     * @param list41 List<RString>
     * @param 要介護データリスト List<JigyoHokokuTokeiData>
     * @param 居宅介護データリスト List<JigyoHokokuTokeiData>
     * @param 地域密着型データリスト List<JigyoHokokuTokeiData>
     * @param 施設介護1データリスト List<JigyoHokokuTokeiData>
     * @param 施設介護2データリスト List<JigyoHokokuTokeiData>
     * @param 施設介護3データリスト List<JigyoHokokuTokeiData>
     * @return List<JigyoHokokuTokeiData>
     */
    public List<JigyoHokokuTokeiData> get修正データリスト(JigyoHokokuGeppoParameter 引き継ぎデータ,
            List<RString> list11, List<RString> list21,
            List<RString> list31, List<RString> list41,
            List<JigyoHokokuTokeiData> 要介護データリスト, List<JigyoHokokuTokeiData> 居宅介護データリスト,
            List<JigyoHokokuTokeiData> 地域密着型データリスト,
            List<JigyoHokokuTokeiData> 施設介護1データリスト,
            List<JigyoHokokuTokeiData> 施設介護2データリスト,
            List<JigyoHokokuTokeiData> 施設介護3データリスト) {
        List<JigyoHokokuTokeiData> 修正データリスト = new ArrayList<>();
        RString 様式種類 = 引き継ぎデータ.get行様式種類コード();
        if (list11.contains(様式種類)) {
            修正データリスト = get要介護修正データリスト(要介護データリスト, 修正データリスト);
        } else if (list21.contains(様式種類)) {
            修正データリスト = get居宅介護データリスト(居宅介護データリスト, 修正データリスト);
        } else if (list31.contains(様式種類)) {
            修正データリスト = get地域密着型データリスト(地域密着型データリスト, 修正データリスト);
        } else if (list41.contains(様式種類)) {
            修正データリスト = get施設介護データリスト(
                    施設介護1データリスト, 施設介護2データリスト, 施設介護3データリスト, 修正データリスト);
        }
        return 修正データリスト;
    }

    /**
     * 引き継ぎデータより、データ削除する
     *
     * @param 引き継ぎデータ JigyoHokokuGeppoParameter
     */
    public void delete(List<JigyoHokokuTokeiData> 引き継ぎデータ) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class);
        finder.deleteJigyoHokokuGeppoData(引き継ぎデータ);
    }

    /**
     * 事業報告月報詳細データの更新する。
     *
     * @param 修正データリスト List<JigyoHokokuTokeiData>
     */
    public
            void update(List<JigyoHokokuTokeiData> 修正データリスト) {
        JigyoHokokuGeppoHoseiHako finder = InstanceProvider.create(JigyoHokokuGeppoHoseiHako.class
        );
        finder.updateJigyoHokokuGeppoEntity(修正データリスト);
    }

    private List<JigyoHokokuTokeiData> get要介護修正データリスト(
            List<JigyoHokokuTokeiData> 要介護データリスト,
            List<JigyoHokokuTokeiData> 修正リスト) {
        修正リスト = get画面データ(要介護データリスト, 修正リスト, Decimal.ONE,
                div.getPnl11().getTxt110202().getValue(),
                div.getPnl11().getTxt110203().getValue(),
                div.getPnl11().getTxt110204().getValue(),
                div.getPnl11().getTxt110205().getValue(),
                div.getPnl11().getTxt110206().getValue(),
                div.getPnl11().getTxt110207().getValue(),
                div.getPnl11().getTxt110208().getValue(),
                div.getPnl11().getTxt110209().getValue(),
                div.getPnl11().getTxt110210().getValue(),
                div.getPnl11().getTxt110211().getValue(),
                div.getPnl11().getTxt110212().getValue());
        修正リスト = get画面データ(要介護データリスト, 修正リスト, NUM_2,
                div.getPnl11().getTxt110302().getValue(),
                div.getPnl11().getTxt110303().getValue(),
                div.getPnl11().getTxt110304().getValue(),
                div.getPnl11().getTxt110305().getValue(),
                div.getPnl11().getTxt110306().getValue(),
                div.getPnl11().getTxt110307().getValue(),
                div.getPnl11().getTxt110308().getValue(),
                div.getPnl11().getTxt110309().getValue(),
                div.getPnl11().getTxt110310().getValue(),
                div.getPnl11().getTxt110311().getValue(),
                div.getPnl11().getTxt110312().getValue());
        修正リスト = get画面データ(要介護データリスト, 修正リスト, NUM_3,
                div.getPnl11().getTxt11040().getValue(),
                div.getPnl11().getTxt110403().getValue(),
                div.getPnl11().getTxt110404().getValue(),
                div.getPnl11().getTxt110405().getValue(),
                div.getPnl11().getTxt110406().getValue(),
                div.getPnl11().getTxt110407().getValue(),
                div.getPnl11().getTxt110408().getValue(),
                div.getPnl11().getTxt110409().getValue(),
                div.getPnl11().getTxt110410().getValue(),
                div.getPnl11().getTxt110411().getValue(),
                div.getPnl11().getTxt110412().getValue());
        修正リスト = get画面データ(要介護データリスト, 修正リスト, NUM_4,
                div.getPnl11().getTxt110502().getValue(),
                div.getPnl11().getTxt110503().getValue(),
                div.getPnl11().getTxt110504().getValue(),
                div.getPnl11().getTxt110505().getValue(),
                div.getPnl11().getTxt110506().getValue(),
                div.getPnl11().getTxt110507().getValue(),
                div.getPnl11().getTxt110508().getValue(),
                div.getPnl11().getTxt110509().getValue(),
                div.getPnl11().getTxt110510().getValue(),
                div.getPnl11().getTxt110511().getValue(),
                div.getPnl11().getTxt110512().getValue());
        修正リスト = get画面データ(要介護データリスト, 修正リスト, NUM_5,
                div.getPnl11().getTxt110602().getValue(),
                div.getPnl11().getTxt110603().getValue(),
                div.getPnl11().getTxt110604().getValue(),
                div.getPnl11().getTxt110605().getValue(),
                div.getPnl11().getTxt110606().getValue(),
                div.getPnl11().getTxt110607().getValue(),
                div.getPnl11().getTxt110608().getValue(),
                div.getPnl11().getTxt110609().getValue(),
                div.getPnl11().getTxt110610().getValue(),
                div.getPnl11().getTxt110611().getValue(),
                div.getPnl11().getTxt110612().getValue());
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get居宅介護データリスト(
            List<JigyoHokokuTokeiData> 居宅介護データリスト,
            List<JigyoHokokuTokeiData> 修正リスト) {
        修正リスト = get画面データ(居宅介護データリスト, 修正リスト, Decimal.ONE,
                div.getPnl12().getTxt120302().getValue(),
                div.getPnl12().getTxt120303().getValue(),
                div.getPnl12().getTxt120304().getValue(),
                div.getPnl12().getTxt120305().getValue(),
                div.getPnl12().getTxt120306().getValue(),
                div.getPnl12().getTxt120307().getValue(),
                div.getPnl12().getTxt120308().getValue(),
                div.getPnl12().getTxt120309().getValue(),
                div.getPnl12().getTxt120310().getValue(),
                div.getPnl12().getTxt120311().getValue(),
                div.getPnl12().getTxt120312().getValue());
        修正リスト = get画面データ(居宅介護データリスト, 修正リスト, NUM_2,
                div.getPnl12().getTxt120402().getValue(),
                div.getPnl12().getTxt120403().getValue(),
                div.getPnl12().getTxt120404().getValue(),
                div.getPnl12().getTxt120405().getValue(),
                div.getPnl12().getTxt120406().getValue(),
                div.getPnl12().getTxt120407().getValue(),
                div.getPnl12().getTxt120408().getValue(),
                div.getPnl12().getTxt120409().getValue(),
                div.getPnl12().getTxt120410().getValue(),
                div.getPnl12().getTxt120411().getValue(),
                div.getPnl12().getTxt120412().getValue());
        修正リスト = get画面データ(居宅介護データリスト, 修正リスト, NUM_3,
                div.getPnl12().getTxt120502().getValue(),
                div.getPnl12().getTxt120503().getValue(),
                div.getPnl12().getTxt120504().getValue(),
                div.getPnl12().getTxt120505().getValue(),
                div.getPnl12().getTxt120506().getValue(),
                div.getPnl12().getTxt120507().getValue(),
                div.getPnl12().getTxt120508().getValue(),
                div.getPnl12().getTxt120509().getValue(),
                div.getPnl12().getTxt120510().getValue(),
                div.getPnl12().getTxt120511().getValue(),
                div.getPnl12().getTxt120512().getValue());
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get地域密着型データリスト(
            List<JigyoHokokuTokeiData> 地域密着型データリスト,
            List<JigyoHokokuTokeiData> 修正リスト) {
        修正リスト = get画面データ(地域密着型データリスト, 修正リスト, Decimal.ONE,
                div.getPnl13().getTxt130302().getValue(),
                div.getPnl13().getTxt130303().getValue(),
                div.getPnl13().getTxt130304().getValue(),
                div.getPnl13().getTxt130305().getValue(),
                div.getPnl13().getTxt130306().getValue(),
                div.getPnl13().getTxt130307().getValue(),
                div.getPnl13().getTxt130308().getValue(),
                div.getPnl13().getTxt130309().getValue(),
                div.getPnl13().getTxt130310().getValue(),
                div.getPnl13().getTxt130311().getValue(),
                div.getPnl13().getTxt130312().getValue());
        修正リスト = get画面データ(地域密着型データリスト, 修正リスト, NUM_2,
                div.getPnl13().getTxt130402().getValue(),
                div.getPnl13().getTxt130403().getValue(),
                div.getPnl13().getTxt130404().getValue(),
                div.getPnl13().getTxt130405().getValue(),
                div.getPnl13().getTxt130406().getValue(),
                div.getPnl13().getTxt130407().getValue(),
                div.getPnl13().getTxt130408().getValue(),
                div.getPnl13().getTxt130409().getValue(),
                div.getPnl13().getTxt130410().getValue(),
                div.getPnl13().getTxt130411().getValue(),
                div.getPnl13().getTxt130412().getValue());
        修正リスト = get画面データ(地域密着型データリスト, 修正リスト, NUM_3,
                div.getPnl13().getTxt130502().getValue(),
                div.getPnl13().getTxt130503().getValue(),
                div.getPnl13().getTxt130504().getValue(),
                div.getPnl13().getTxt130505().getValue(),
                div.getPnl13().getTxt130506().getValue(),
                div.getPnl13().getTxt130507().getValue(),
                div.getPnl13().getTxt130508().getValue(),
                div.getPnl13().getTxt130509().getValue(),
                div.getPnl13().getTxt130510().getValue(),
                div.getPnl13().getTxt1305011().getValue(),
                div.getPnl13().getTxt130512().getValue());
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get施設介護データリスト(
            List<JigyoHokokuTokeiData> 施設介護1データリスト,
            List<JigyoHokokuTokeiData> 施設介護2データリスト,
            List<JigyoHokokuTokeiData> 施設介護3データリスト,
            List<JigyoHokokuTokeiData> 修正リスト) {
        修正リスト = get画面データ(施設介護1データリスト, 修正リスト, NUM_3,
                div.getPnl14().getTxt140302().getValue(),
                div.getPnl14().getTxt140303().getValue(),
                div.getPnl14().getTxt140304().getValue(),
                div.getPnl14().getTxt140305().getValue(),
                div.getPnl14().getTxt140306().getValue(),
                div.getPnl14().getTxt140307().getValue(),
                div.getPnl14().getTxt140308().getValue(),
                div.getPnl14().getTxt140309().getValue(),
                div.getPnl14().getTxt140310().getValue(),
                div.getPnl14().getTxt140311().getValue(),
                div.getPnl14().getTxt140312().getValue());
        修正リスト = get画面データ(施設介護1データリスト, 修正リスト, Decimal.ONE,
                div.getPnl14().getTxt140402().getValue(),
                div.getPnl14().getTxt140403().getValue(),
                div.getPnl14().getTxt140404().getValue(),
                div.getPnl14().getTxt140405().getValue(),
                div.getPnl14().getTxt140406().getValue(),
                div.getPnl14().getTxt140407().getValue(),
                div.getPnl14().getTxt140408().getValue(),
                div.getPnl14().getTxt140409().getValue(),
                div.getPnl14().getTxt140410().getValue(),
                div.getPnl14().getTxt140411().getValue(),
                div.getPnl14().getTxt140412().getValue());
        修正リスト = get画面データ(施設介護1データリスト, 修正リスト, NUM_2,
                div.getPnl14().getTxt140502().getValue(),
                div.getPnl14().getTxt140503().getValue(),
                div.getPnl14().getTxt140504().getValue(),
                div.getPnl14().getTxt140505().getValue(),
                div.getPnl14().getTxt140506().getValue(),
                div.getPnl14().getTxt140507().getValue(),
                div.getPnl14().getTxt140508().getValue(),
                div.getPnl14().getTxt140509().getValue(),
                div.getPnl14().getTxt140510().getValue(),
                div.getPnl14().getTxt140511().getValue(),
                div.getPnl14().getTxt140512().getValue());
        修正リスト = get画面データ(施設介護2データリスト, 修正リスト, NUM_3,
                div.getPnl14().getTxt140602().getValue(),
                div.getPnl14().getTxt140603().getValue(),
                div.getPnl14().getTxt140604().getValue(),
                div.getPnl14().getTxt140605().getValue(),
                div.getPnl14().getTxt140606().getValue(),
                div.getPnl14().getTxt140607().getValue(),
                div.getPnl14().getTxt140608().getValue(),
                div.getPnl14().getTxt140609().getValue(),
                div.getPnl14().getTxt140610().getValue(),
                div.getPnl14().getTxt140611().getValue(),
                div.getPnl14().getTxt140612().getValue());
        修正リスト = get画面データ(施設介護2データリスト, 修正リスト, Decimal.ONE,
                div.getPnl14().getTxt140702().getValue(),
                div.getPnl14().getTxt140703().getValue(),
                div.getPnl14().getTxt140704().getValue(),
                div.getPnl14().getTxt140705().getValue(),
                div.getPnl14().getTxt140706().getValue(),
                div.getPnl14().getTxt140707().getValue(),
                div.getPnl14().getTxt140708().getValue(),
                div.getPnl14().getTxt140709().getValue(),
                div.getPnl14().getTxt140710().getValue(),
                div.getPnl14().getTxt140711().getValue(),
                div.getPnl14().getTxt140712().getValue());
        修正リスト = get画面データ(施設介護2データリスト, 修正リスト, NUM_2,
                div.getPnl14().getTxt140802().getValue(),
                div.getPnl14().getTxt140803().getValue(),
                div.getPnl14().getTxt140804().getValue(),
                div.getPnl14().getTxt140805().getValue(),
                div.getPnl14().getTxt140806().getValue(),
                div.getPnl14().getTxt140807().getValue(),
                div.getPnl14().getTxt140808().getValue(),
                div.getPnl14().getTxt140809().getValue(),
                div.getPnl14().getTxt140810().getValue(),
                div.getPnl14().getTxt140811().getValue(),
                div.getPnl14().getTxt140812().getValue());
        修正リスト = get画面データ(施設介護3データリスト, 修正リスト, NUM_3,
                div.getPnl14().getTxt140902().getValue(),
                div.getPnl14().getTxt140903().getValue(),
                div.getPnl14().getTxt140904().getValue(),
                div.getPnl14().getTxt140905().getValue(),
                div.getPnl14().getTxt140906().getValue(),
                div.getPnl14().getTxt140907().getValue(),
                div.getPnl14().getTxt140908().getValue(),
                div.getPnl14().getTxt140909().getValue(),
                div.getPnl14().getTxt140910().getValue(),
                div.getPnl14().getTxt140911().getValue(),
                div.getPnl14().getTxt140912().getValue());
        修正リスト = get画面データ(施設介護3データリスト, 修正リスト, Decimal.ONE,
                div.getPnl14().getTxt141002().getValue(),
                div.getPnl14().getTxt141003().getValue(),
                div.getPnl14().getTxt141004().getValue(),
                div.getPnl14().getTxt141005().getValue(),
                div.getPnl14().getTxt141006().getValue(),
                div.getPnl14().getTxt141007().getValue(),
                div.getPnl14().getTxt141008().getValue(),
                div.getPnl14().getTxt141009().getValue(),
                div.getPnl14().getTxt141010().getValue(),
                div.getPnl14().getTxt141011().getValue(),
                div.getPnl14().getTxt141012().getValue());
        修正リスト = get画面データ(施設介護3データリスト, 修正リスト, NUM_2,
                div.getPnl14().getTxt141102().getValue(),
                div.getPnl14().getTxt141103().getValue(),
                div.getPnl14().getTxt141104().getValue(),
                div.getPnl14().getTxt141105().getValue(),
                div.getPnl14().getTxt141106().getValue(),
                div.getPnl14().getTxt141107().getValue(),
                div.getPnl14().getTxt141108().getValue(),
                div.getPnl14().getTxt141109().getValue(),
                div.getPnl14().getTxt141110().getValue(),
                div.getPnl14().getTxt141111().getValue(),
                div.getPnl14().getTxt141112().getValue());
        修正リスト = get画面データ(施設介護3データリスト, 修正リスト, NUM_4,
                div.getPnl14().getTxt141202().getValue(),
                div.getPnl14().getTxt141203().getValue(),
                div.getPnl14().getTxt141204().getValue(),
                div.getPnl14().getTxt141205().getValue(),
                div.getPnl14().getTxt141206().getValue(),
                div.getPnl14().getTxt141207().getValue(),
                div.getPnl14().getTxt141208().getValue(),
                div.getPnl14().getTxt141209().getValue(),
                div.getPnl14().getTxt141210().getValue(),
                div.getPnl14().getTxt141211().getValue(),
                div.getPnl14().getTxt141212().getValue());
        return 修正リスト;
    }

    private List<JigyoHokokuTokeiData> get画面データ(
            List<JigyoHokokuTokeiData> jigylist,
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
            RString 集計結果値11) {
        修正リスト = set集計結果値(集計結果値1, 修正リスト, jigylist, Decimal.ONE, 縦番号);
        修正リスト = set集計結果値(集計結果値2, 修正リスト, jigylist, NUM_2, 縦番号);
        修正リスト = set集計結果値(集計結果値3, 修正リスト, jigylist, NUM_3, 縦番号);
        修正リスト = set集計結果値(集計結果値4, 修正リスト, jigylist, NUM_4, 縦番号);
        修正リスト = set集計結果値(集計結果値5, 修正リスト, jigylist, NUM_5, 縦番号);
        修正リスト = set集計結果値(集計結果値6, 修正リスト, jigylist, NUM_6, 縦番号);
        修正リスト = set集計結果値(集計結果値7, 修正リスト, jigylist, NUM_7, 縦番号);
        修正リスト = set集計結果値(集計結果値8, 修正リスト, jigylist, NUM_8, 縦番号);
        修正リスト = set集計結果値(集計結果値9, 修正リスト, jigylist, NUM_9, 縦番号);
        修正リスト = set集計結果値(集計結果値10, 修正リスト, jigylist, NUM_10, 縦番号);
        修正リスト = set集計結果値(集計結果値11, 修正リスト, jigylist, NUM_11, 縦番号);
        return 修正リスト;

    }

    private List<JigyoHokokuTokeiData> set集計結果値(
            RString 集計結果値,
            List<JigyoHokokuTokeiData> 修正リスト,
            List<JigyoHokokuTokeiData> jigyolist,
            Decimal 横番号,
            Decimal 縦番号) {
        JigyoHokokuTokeiData entity = check事業報告統計データ(jigyolist, 横番号, 縦番号);
        if (集計結果値 == null || 集計結果値.isEmpty()) {
            if (entity != null && entity.get集計結果値() != null) {
                entity = entity.createBuilderForEdit().set集計結果値(null).build();
                entity = entity.modifiedModel();
                修正リスト.add(entity);
                return 修正リスト;
            }
        } else {
            if (entity == null) {
                entity = set事業報告統計データ(jigyolist, 横番号, 縦番号,
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
            List<JigyoHokokuTokeiData> jigyolist,
            Decimal 横番号,
            Decimal 縦番号) {
        for (JigyoHokokuTokeiData entity : jigyolist) {
            if (entity.get縦番号().equals(縦番号) && entity.get横番号().equals(横番号)) {
                return entity;
            }
        }
        return null;
    }

    private JigyoHokokuTokeiData set事業報告統計データ(
            List<JigyoHokokuTokeiData> jigyolist,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 集計結果値) {
        JigyoHokokuTokeiData entity = jigyolist.get(0).createBuilderForEdit()
                .set横番号(横番号)
                .set縦番号(縦番号)
                .set集計結果値(集計結果値)
                .set集計項目名称(null)
                .set縦項目コード(null)
                .set横項目コード(null).build();
        entity = entity.addedModel();
        return entity;
    }

    /**
     * set要介護認定者数
     *
     * @param 要介護list (List<JigyoHokokuTokeiData>
     */
    public void set要介護認定者数(List<JigyoHokokuTokeiData> 要介護list) {
        for (JigyoHokokuTokeiData entity : 要介護list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set要介護第１号被保険者(entity);
                        break;
                    case NUMBER_2:
                        set要介護65歳以上75歳未満(entity);
                        break;
                    case NUMBER_3:
                        set要介護75歳以上(entity);
                        break;
                    case NUMBER_4:
                        set第２号被保険者(entity);
                        break;
                    case NUMBER_5:
                        set要介護総数(entity);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * set居宅介護認定者数
     *
     * @param 居宅介護list List<JigyoHokokuTokeiData>
     */
    public void set居宅介護認定者数(List<JigyoHokokuTokeiData> 居宅介護list) {
        for (JigyoHokokuTokeiData entity : 居宅介護list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set居宅介護第１号被保険者(entity);
                        break;
                    case NUMBER_2:
                        set居宅介護第２号被保険者(entity);
                        break;
                    case NUMBER_3:
                        set居宅介護総数(entity);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * set地域密着型認定者数
     *
     * @param 地域密着型list List<JigyoHokokuTokeiData>
     */
    public void set地域密着型認定者数(List<JigyoHokokuTokeiData> 地域密着型list) {
        for (JigyoHokokuTokeiData entity : 地域密着型list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set地域密着型第１号被保険者(entity);
                        break;
                    case NUMBER_2:
                        set地域密着型第２号被保険者(entity);
                        break;
                    case NUMBER_3:
                        set地域密着型総数(entity);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * set施設介護認定者数1
     *
     * @param 施設介護list List<JigyoHokokuTokeiData>
     */
    public void set施設介護認定者数1(List<JigyoHokokuTokeiData> 施設介護list) {
        for (JigyoHokokuTokeiData entity : 施設介護list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set施設介護第１号被保険者91(entity);
                        break;
                    case NUMBER_2:
                        set施設介護第2号被保険者91(entity);
                        break;
                    case NUMBER_3:
                        set介護老人福祉情報(entity);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * set施設介護認定者数2
     *
     * @param 施設介護list List<JigyoHokokuTokeiData>
     */
    public void set施設介護認定者数2(List<JigyoHokokuTokeiData> 施設介護list) {
        for (JigyoHokokuTokeiData entity : 施設介護list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set施設介護第１号被保険者92(entity);
                        break;
                    case NUMBER_2:
                        set施設介護第2号被保険者92(entity);
                        break;
                    case NUMBER_3:
                        set介護老人保健情報(entity);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * set施設介護認定者数3
     *
     * @param 施設介護list List<JigyoHokokuTokeiData>
     */
    public void set施設介護認定者数3(List<JigyoHokokuTokeiData> 施設介護list) {
        for (JigyoHokokuTokeiData entity : 施設介護list) {
            if (entity.get集計結果値() != null) {
                switch (entity.get縦番号().intValue()) {
                    case NUMBER_1:
                        set施設介護第１号被保険者93(entity);
                        break;
                    case NUMBER_2:
                        set施設介護第2号被保険者93(entity);
                        break;
                    case NUMBER_3:
                        set介護療養型医療施設(entity);
                        break;
                    case NUMBER_4:
                        set施設介護総数(entity);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void set要介護第１号被保険者(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl11().getTxt110202().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl11().getTxt110203().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl11().getTxt110204().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl11().getTxt110205().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl11().getTxt110206().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl11().getTxt110207().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl11().getTxt110208().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl11().getTxt110209().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl11().getTxt110210().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl11().getTxt110211().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl11().getTxt110212().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set要介護65歳以上75歳未満(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl11().getTxt110302().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl11().getTxt110303().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl11().getTxt110304().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl11().getTxt110305().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl11().getTxt110306().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl11().getTxt110307().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl11().getTxt110308().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl11().getTxt110309().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl11().getTxt110310().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl11().getTxt110311().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl11().getTxt110312().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set要介護75歳以上(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl11().getTxt11040().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl11().getTxt110403().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl11().getTxt110404().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl11().getTxt110405().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl11().getTxt110406().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl11().getTxt110407().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl11().getTxt110408().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl11().getTxt110409().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl11().getTxt110410().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl11().getTxt110411().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl11().getTxt110412().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set第２号被保険者(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl11().getTxt110502().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl11().getTxt110503().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl11().getTxt110504().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl11().getTxt110505().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl11().getTxt110506().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl11().getTxt110507().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl11().getTxt110508().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl11().getTxt110509().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl11().getTxt110510().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl11().getTxt110511().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl11().getTxt110512().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set要介護総数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl11().getTxt110602().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl11().getTxt110603().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl11().getTxt110604().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl11().getTxt110605().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl11().getTxt110606().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl11().getTxt110607().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl11().getTxt110608().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl11().getTxt110609().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl11().getTxt110610().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl11().getTxt110611().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl11().getTxt110612().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set居宅介護第１号被保険者(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl12().getTxt120302().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl12().getTxt120303().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl12().getTxt120304().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl12().getTxt120305().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl12().getTxt120306().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl12().getTxt120307().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl12().getTxt120308().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl12().getTxt120309().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl12().getTxt120310().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl12().getTxt120311().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl12().getTxt120312().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set居宅介護第２号被保険者(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl12().getTxt120402().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl12().getTxt120403().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl12().getTxt120404().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl12().getTxt120405().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl12().getTxt120406().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl12().getTxt120407().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl12().getTxt120408().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl12().getTxt120409().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl12().getTxt120410().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl12().getTxt120411().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl12().getTxt120412().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set居宅介護総数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl12().getTxt120502().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl12().getTxt120503().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl12().getTxt120504().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl12().getTxt120505().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl12().getTxt120506().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl12().getTxt120507().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl12().getTxt120508().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl12().getTxt120509().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl12().getTxt120510().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl12().getTxt120511().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl12().getTxt120512().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set地域密着型第１号被保険者(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl13().getTxt130302().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl13().getTxt130303().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl13().getTxt130304().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl13().getTxt130305().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl13().getTxt130306().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl13().getTxt130307().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl13().getTxt130308().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl13().getTxt130309().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl13().getTxt130310().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl13().getTxt130311().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl13().getTxt130312().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set地域密着型第２号被保険者(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl13().getTxt130402().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl13().getTxt130403().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl13().getTxt130404().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl13().getTxt130405().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl13().getTxt130406().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl13().getTxt130407().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl13().getTxt130408().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl13().getTxt130409().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl13().getTxt130410().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl13().getTxt130411().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl13().getTxt130412().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set地域密着型総数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl13().getTxt130502().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl13().getTxt130503().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl13().getTxt130504().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl13().getTxt130505().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl13().getTxt130506().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl13().getTxt130507().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl13().getTxt130508().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl13().getTxt130509().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl13().getTxt130510().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl13().getTxt1305011().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl13().getTxt130512().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set介護老人福祉情報(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt140302().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt140303().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt140304().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt140305().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt140306().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt140307().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt140308().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt140309().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt140310().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt140311().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt140312().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set施設介護第１号被保険者91(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt140402().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt140403().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt140404().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt140405().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt140406().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt140407().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt140408().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt140409().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt140410().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt140411().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt140412().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set施設介護第2号被保険者91(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt140502().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt140503().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt140504().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt140505().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt140506().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt140507().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt140508().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt140509().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt140510().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt140511().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt140512().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set介護老人保健情報(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt140602().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt140603().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt140604().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt140605().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt140606().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt140607().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt140608().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt140609().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt140610().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt140611().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt140612().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set施設介護第１号被保険者92(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt140702().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt140703().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt140704().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt140705().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt140706().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt140707().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt140708().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt140709().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt140710().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt140711().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt140712().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set施設介護第2号被保険者92(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt140802().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt140803().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt140804().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt140805().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt140806().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt140807().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt140808().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt140809().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt140810().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt140811().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt140812().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set介護療養型医療施設(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt140902().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt140903().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt140904().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt140905().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt140906().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt140907().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt140908().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt140909().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt140910().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt140911().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt140912().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set施設介護第１号被保険者93(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt141002().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt141003().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt141004().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt141005().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt141006().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt141007().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt141008().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt141009().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt141010().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt141011().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt141012().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set施設介護第2号被保険者93(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt141102().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt141103().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt141104().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt141105().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt141106().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt141107().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt141108().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt141109().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt141110().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt141111().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt141112().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    private void set施設介護総数(JigyoHokokuTokeiData entity) {
        switch (entity.get横番号().intValue()) {
            case NUMBER_1:
                div.getPnl14().getTxt141202().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_2:
                div.getPnl14().getTxt141203().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_3:
                div.getPnl14().getTxt141204().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_4:
                div.getPnl14().getTxt141205().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_5:
                div.getPnl14().getTxt141206().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_6:
                div.getPnl14().getTxt141207().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_7:
                div.getPnl14().getTxt141208().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_8:
                div.getPnl14().getTxt141209().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_9:
                div.getPnl14().getTxt141210().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_10:
                div.getPnl14().getTxt141211().setValue(new RString(entity.get集計結果値().toString()));
                break;
            case NUMBER_11:
                div.getPnl14().getTxt141212().setValue(new RString(entity.get集計結果値().toString()));
                break;
            default:
                break;
        }
    }

    /**
     * 様式種類の初期化のメソッドます。
     *
     * @return Map<RString, ArrayList<RString>>
     */
    public Map<RString, ArrayList<RString>> set様式種類() {
        Map<RString, ArrayList<RString>> map = new HashMap<>();
        ArrayList<RString> list11 = new ArrayList<>();
        list11.add(STR_010);
        list11.add(STR_110);
        list11.add(STR_210);
        map.put(様式種類_11, list11);
        ArrayList<RString> list21 = new ArrayList<>();
        list21.add(STR_011);
        list21.add(STR_012);
        list21.add(STR_013);
        list21.add(STR_111);
        list21.add(STR_112);
        list21.add(STR_113);
        list21.add(STR_211);
        list21.add(STR_212);
        list21.add(STR_213);
        map.put(様式種類_21, list21);
        ArrayList<RString> list31 = new ArrayList<>();
        list31.add(STR_014);
        list31.add(STR_015);
        list31.add(STR_016);
        list31.add(STR_114);
        list31.add(STR_115);
        list31.add(STR_116);
        list31.add(STR_214);
        list31.add(STR_215);
        list31.add(STR_216);
        map.put(様式種類_31, list31);
        ArrayList<RString> list41 = new ArrayList<>();
        list41.add(STR_017);
        list41.add(STR_018);
        list41.add(STR_019);
        list41.add(STR_117);
        list41.add(STR_118);
        list41.add(STR_119);
        list41.add(STR_217);
        list41.add(STR_218);
        list41.add(STR_219);
        map.put(様式種類_41, list41);
        return map;
    }
}
