/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiSearchDataBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShukeiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShukeiKekkaDataBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 給付実績照会_給付実績照会検索一覧画面
 *
 * @reamsid_L DBC-2970-010 linghuhang
 */
public class KyufuJissekiShokaiHandler2 {

    private final KyufuJissekiShokaiDiv div;
    private static final RString KEY = new RString("key0");
    private static final int 年度始 = 2000;
    private static final int INT_SAN = 3;
    private static final int INT_YON = 4;
    private static final int INT_GO = 5;
    private static final int INT_ROKU = 6;
    private static final int INT_NANA = 7;
    private static final int INT_HACHI = 8;
    private static final int INT_KYU = 9;
    private static final int INT_JYU = 10;
    private static final int INT_JYUI = 11;
    private static final int INT_JYUN = 12;
    private static final int INT_JYUS = 13;
    private static final int INT_JYUY = 14;
    private static final int INT_JYUG = 15;
    private static final int INT_JYUR = 16;
    private static final int INT_JYUNA = 17;
    private static final int INT_JYUH = 18;
    private static final int INT_JYUK = 19;
    private static final int INT_NJYU = 20;
    private static final int INT_NJYUI = 21;
    private static final int INT_NJYUN = 22;
    private static final int INT_NJYUS = 23;
    private static final int INT_NJYUY = 24;
    private static final int INT_NJYUG = 25;
    private static final int INT_NJYUR = 26;
    private static final int INT_NJYUNA = 27;
    private static final int INT_NJYUH = 28;
    private static final int INT_NJYUK = 29;
    private static final int INT_SJYU = 30;
    private static final int INT_SJYUI = 31;
    private static final int INT_SJYUN = 32;
    private static final int INT_SJYUS = 33;
    private static final int INT_SJYUY = 34;
    private static final int INT_SJYUG = 35;
    private static final int INT_SJYUR = 36;
    private static final int INT_SJYUNA = 37;
    private static final int INT_SJYUH = 38;
    private static final int INT_SJYUK = 39;
    private static final int INT_YJYU = 40;
    private static final int INT_YJYUI = 41;
    private static final int INT_YJYUN = 42;
    private static final int INT_YJYUS = 43;
    private static final int INT_YJYUY = 44;
    private static final int INT_YJYUG = 45;
    private static final int INT_YJYUR = 46;
    private static final int INT_47 = 47;
    private static final int INT_YJYUH = 48;
    private static final int INT_49 = 49;
    private static final int INT_50 = 50;
    private static final int INT_51 = 51;
    private static final int INT_52 = 52;
    private static final int INT_53 = 53;
    private static final int INT_54 = 54;
    private static final int INT_55 = 55;
    private static final int INT_56 = 56;
    private static final int INT_57 = 57;
    private static final int INT_58 = 58;

    private static final RString GOKEI_PATTERN1_1 = new RString("居宅_単位数");
    private static final RString GOKEI_PATTERN1_2 = new RString("居宅_単位数＋出来高単位数");
    private static final RString GOKEI_PATTERN2_1 = new RString("施設_単位数");
    private static final RString GOKEI_PATTERN2_2 = new RString("施設_単位数＋出来高単位数");
    private static final RString GOKEI_PATTERN3 = new RString("地域密着型");
    private static final RString GOKEI_PATTERN4 = new RString("生活支援");
    private static final RString GOKEI_PATTERN5 = new RString("高額介護");
    private static final RString GOKEI_PATTERN6_1 = new RString("福祉用具販売");
    private static final RString GOKEI_PATTERN6_2 = new RString("住宅改修");
    private static final RString GOKEI_PATTERN_NOTHING = new RString("");

    /**
     * コンストラクタです。
     *
     * @param div 給付実績照会検索一覧画面Div
     */
    public KyufuJissekiShokaiHandler2(KyufuJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        div.getDdlKyufuJissekiSearchNendo().setDataSource(get年度());
        div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(true);
    }

    private List<KeyValueDataSource> get年度() {
        RDate システム日付 = RDate.getNowDate();
        List<KeyValueDataSource> keyValue = new ArrayList<>();
        for (int 年度 = 年度始; 年度 <= システム日付.getYearValue(); 年度++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(年度));
            dataSource.setValue(new RDate(年度).wareki().getYear());
            keyValue.add(dataSource);
        }
        Collections.sort(keyValue, new DateComparator());
        return keyValue;
    }

    private static class DateComparator implements Comparator<KeyValueDataSource>, Serializable {

        @Override
        public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
            return o2.getKey().compareTo(o1.getKey());
        }
    }

    /**
     * 「条件をクリアする」ボタン押下する、検索条件パネル内の状態を初期状態にする。
     */
    public void onClick_btnKyufuJissekiSearchClear() {
        RDate システム日付 = RDate.getNowDate();
        div.getRadNendo().setSelectedKey(KEY);
        div.getDdlKyufuJissekiSearchNendo().setSelectedKey(new RString(システム日付.getYearValue()));
        div.getRadKyufuJissekiSearchDateType().clearSelectedItem();
        div.getTxtKyufuJissekiSearchServiceTeikyoYM().clearFromValue();
        div.getTxtKyufuJissekiSearchServiceTeikyoYM().clearToValue();
        div.getRadTaisho1().setSelectedKey(KEY);
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(false);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(true);
        } else {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(true);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(false);
        }
    }

    /**
     * 抽出範囲を変更する場合、画面を表示する。
     */
    public void onChange_radKyufuJissekiSearchDateType() {
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(false);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(true);
        } else {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(true);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(false);
        }
    }

    /**
     * 集計データを取得する。
     *
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param is経過措置 is経過措置
     * @param 一覧データ 一覧データ
     * @param 被保険者番号 被保険者番号
     * @return 集計データ
     */
    public List<KyufuJissekiShukeiKekkaDataBusiness> edit集計データ(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            boolean is経過措置, KyufuJissekiSearchDataBusiness 一覧データ, HihokenshaNo 被保険者番号) {
        List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ
                = KyufuJissekiShokaiFinder.createInstance().get集計データ(is経過措置, サービス提供年月_開始, サービス提供年月_終了, 被保険者番号);
        List<KyufuJissekiShukeiKekka> 集計結果List;
        if (is経過措置) {
            集計結果List = edit集計結果_経過措置(集計データ, サービス提供年月_開始, サービス提供年月_終了);
        } else {
            集計結果List = edit集計結果(集計データ, サービス提供年月_開始, サービス提供年月_終了);
        }
        一覧データ.set給付実績集計結果明細データ(集計結果List);
        return 集計データ;
    }

    private List<KyufuJissekiShukeiKekka> edit集計結果_経過措置(List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        List<KyufuJissekiShukeiKekka> 集計結果List = new ArrayList<>();
        FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(サービス提供年月_終了.toDateString());
        int index = 0;
        while (処理対象年月.isBeforeOrEquals(サービス提供年月_終了) && サービス提供年月_開始.isBeforeOrEquals(処理対象年月)) {
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List = 初期化処理対象年月集計結果List(処理対象年月, true);
            while (集計データ.size() > index && 処理対象年月.equals(集計データ.get(index).getServiceTeikyoYM())) {
                KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ = 集計データ.get(index);
                for (int i = 0; i < INT_NJYUI; i++) {
                    if (isServiceShuruiCodeNullOrEmpty(処理対象集計データ.getServiceSyuruiCode())) {
                        break;
                    }
                    if (chk単位数加算対象_経過措置(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getTanisu())));
                    }
                    if (chk出来高単位数加算対象_経過措置(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
                    }
                }
                RString パターン番号
                        = get合計パターン番号_経過措置(serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()));
                edit合計一覧用集計結果_経過措置(パターン番号, 処理対象年月集計結果List, 処理対象集計データ);
                index++;
            }
            集計結果List.addAll(処理対象年月集計結果List);
            処理対象年月 = new FlexibleYearMonth(処理対象年月.minusMonth(1).toDateString());
        }
        return 集計結果List;
    }

    private void edit合計一覧用集計結果_経過措置(RString パターン番号,
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List,
            KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ) {
        if (GOKEI_PATTERN1_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUI), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN1_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUI),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN3.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUN), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN4.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUS), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        }
    }

    private List<KyufuJissekiShukeiKekka> edit集計結果(List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        List<KyufuJissekiShukeiKekka> 集計結果List = new ArrayList<>();
        FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(サービス提供年月_終了.toDateString());
        int index = 0;
        while (処理対象年月.isBeforeOrEquals(サービス提供年月_終了) && サービス提供年月_開始.isBeforeOrEquals(処理対象年月)) {
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List = 初期化処理対象年月集計結果List(処理対象年月, false);
            while (集計データ.size() > index && 処理対象年月.equals(集計データ.get(index).getServiceTeikyoYM())) {
                KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ = 集計データ.get(index);
                for (int i = 0; i < INT_47; i++) {
                    if (isServiceShuruiCodeNullOrEmpty(処理対象集計データ.getServiceSyuruiCode())) {
                        break;
                    }
                    if (chk単位数加算対象(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getTanisu())));
                    }
                    if (chk出来高単位数加算対象(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
                    }
                }
                RString パターン番号;
                if (isServiceShuruiCodeNullOrEmpty(処理対象集計データ.getServiceSyuruiCode())) {
                    パターン番号 = GOKEI_PATTERN5;
                } else {
                    パターン番号 = get合計パターン番号(serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()));
                }
                edit合計一覧用集計結果(パターン番号, 処理対象年月集計結果List, 処理対象集計データ);
                index++;
            }
            集計結果List.addAll(処理対象年月集計結果List);
            処理対象年月 = new FlexibleYearMonth(処理対象年月.minusMonth(1).toDateString());
        }
        return 集計結果List;
    }

    private void edit合計一覧用集計結果(RString パターン番号,
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List,
            KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ) {
        if (GOKEI_PATTERN1_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_47), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN1_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_47),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN2_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_YJYUH), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN2_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_YJYUH),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN3.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_49),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN4.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_50),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_52), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_54), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN5.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_55), 処理対象集計データ.getSeikyugaku());
        } else if (GOKEI_PATTERN6_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_56), 処理対象集計データ.getSeikyugaku());
        } else if (GOKEI_PATTERN6_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_57), 処理対象集計データ.getSeikyugaku());
        }
    }

    private void 金額単位数加算(KyufuJissekiShukeiKekka 集計結果, Decimal 金額) {
        集計結果.setKensu(集計結果.getKensu().add(Decimal.ONE));
        集計結果.setKingaku(集計結果.getKingaku().add(nullToZero(金額)));
    }

    private Decimal nullToZero(Decimal value) {
        if (null == value) {
            return Decimal.ZERO;
        }
        return value;
    }

    private boolean isServiceShuruiCodeNullOrEmpty(ServiceShuruiCode code) {
        return null == code || code.isEmpty();
    }

    private ServiceCategoryShurui serviceSyuruiCodeToServiceCategoryShurui(ServiceShuruiCode code) {
        return ServiceCategoryShurui.toValue(code.getColumnValue());
    }

    private List<KyufuJissekiShukeiKekka> 初期化処理対象年月集計結果List(FlexibleYearMonth 処理対象年月, boolean is経過措置) {
        int count = INT_58;
        if (is経過措置) {
            count = INT_NJYUR;
        }
        List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            処理対象年月集計結果List.add(初期化集計結果(処理対象年月));
        }
        return 処理対象年月集計結果List;
    }

    private KyufuJissekiShukeiKekka 初期化集計結果(FlexibleYearMonth 処理対象年月) {
        KyufuJissekiShukeiKekka 集計結果 = new KyufuJissekiShukeiKekka();
        集計結果.setServiceTeikyoYM(処理対象年月);
        集計結果.setKensu(Decimal.ZERO);
        集計結果.setKingaku(Decimal.ZERO);
        return 集計結果;
    }

    private boolean chk単位数加算対象9(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_YJYUN:
                switch (サービス種類) {
                    case 配食定額:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUS:
                switch (サービス種類) {
                    case 見守定率:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUY:
                switch (サービス種類) {
                    case 見守定額:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUG:
                switch (サービス種類) {
                    case その他率:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUR:
                switch (サービス種類) {
                    case その他額:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private boolean chk単位数加算対象8(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_SJYUNA:
                switch (サービス種類) {
                    case 通所独自:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUH:
                switch (サービス種類) {
                    case 通所定率:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUK:
                switch (サービス種類) {
                    case 通所定額:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYU:
                switch (サービス種類) {
                    case 予防ケア:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUI:
                switch (サービス種類) {
                    case 配食定率:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象9(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象7(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_SJYUN:
                switch (サービス種類) {
                    case 訪問みな:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUS:
                switch (サービス種類) {
                    case 訪問独自:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUY:
                switch (サービス種類) {
                    case 訪問定率:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUG:
                switch (サービス種類) {
                    case 訪問定額:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUR:
                switch (サービス種類) {
                    case 通所みな:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象8(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象6(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_NJYUR:
                switch (サービス種類) {
                    case 居宅支援:
                    case 予防支援:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUNA:
                switch (サービス種類) {
                    case 福祉施設:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUH:
                switch (サービス種類) {
                    case 老健施設:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUK:
                switch (サービス種類) {
                    case 医療施設:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYU:
                switch (サービス種類) {
                    case 地福祉生:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象7(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象5(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_NJYUI:
                switch (サービス種類) {
                    case 地小規単:
                    case 地予小短:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUN:
                switch (サービス種類) {
                    case 定期随時:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUS:
                switch (サービス種類) {
                    case 看小短外:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUY:
                switch (サービス種類) {
                    case 看小規短:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUG:
                switch (サービス種類) {
                    case 地域通所:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象6(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象4(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUR:
                switch (サービス種類) {
                    case 地施短期:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUNA:
                switch (サービス種類) {
                    case 地共同短:
                    case 地予共短:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUH:
                switch (サービス種類) {
                    case 地夜間訪:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUK:
                switch (サービス種類) {
                    case 地通所介:
                    case 地予通所:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYU:
                switch (サービス種類) {
                    case 地小短外:
                    case 地予小外:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象5(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象3(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUI:
                switch (サービス種類) {
                    case 療養指導:
                    case 予療養指:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUN:
                switch (サービス種類) {
                    case 特施短外:
                    case 予特施設:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUS:
                switch (サービス種類) {
                    case 特施短期:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUY:
                switch (サービス種類) {
                    case 地共同介:
                    case 地予共同:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUG:
                switch (サービス種類) {
                    case 地施短外:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象4(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象2(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_GO:
                switch (サービス種類) {
                    case 通所リハ:
                    case 予通リハ:
                        return true;
                    default:
                        return false;
                }
            case INT_ROKU:
                switch (サービス種類) {
                    case 用具貸与:
                    case 予用貸与:
                        return true;
                    default:
                        return false;
                }
            case INT_NANA:
                switch (サービス種類) {
                    case 短期生活:
                    case 予短介護:
                        return true;
                    default:
                        return false;
                }
            case INT_HACHI:
                switch (サービス種類) {
                    case 短期老健:
                    case 予短老健:
                        return true;
                    default:
                        return false;
                }
            case INT_KYU:
                switch (サービス種類) {
                    case 短期医療:
                    case 予短医療:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象3(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case 0:
                switch (サービス種類) {
                    case 訪問介護:
                    case 予訪介護:
                        return true;
                    default:
                        return false;
                }
            case 1:
                switch (サービス種類) {
                    case 訪問入浴:
                    case 予訪入浴:
                        return true;
                    default:
                        return false;
                }
            case 2:
                switch (サービス種類) {
                    case 訪問看護:
                    case 予訪看護:
                        return true;
                    default:
                        return false;
                }
            case INT_SAN:
                switch (サービス種類) {
                    case 訪問リハ:
                    case 予訪リハ:
                        return true;
                    default:
                        return false;
                }
            case INT_YON:
                switch (サービス種類) {
                    case 通所介護:
                    case 予通介護:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象2(i, サービス種類);
        }
    }

    private boolean chk出来高単位数加算対象(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYU:
                switch (サービス種類) {
                    case 短期老健:
                    case 予短老健:
                    case 短期医療:
                    case 予短医療:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUI:
                switch (サービス種類) {
                    case 老健施設:
                    case 医療施設:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private RString get合計パターン番号(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 訪問介護:
            case 予訪介護:
            case 訪問入浴:
            case 予訪入浴:
            case 訪問看護:
            case 予訪看護:
            case 訪問リハ:
            case 予訪リハ:
            case 通所介護:
            case 予通介護:
            case 通所リハ:
            case 予通リハ:
                return GOKEI_PATTERN1_1;
            default:
                return get合計パターン番号1(サービス種類);
        }
    }

    private RString get合計パターン番号1(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 用具貸与:
            case 予用貸与:
            case 短期生活:
            case 短期老健:
            case 短期医療:
            case 予短介護:
            case 予短老健:
            case 予短医療:
            case 特施短外:
            case 予療養指:
            case 予特施設:
            case 療養指導:
            case 特施短期:
                return GOKEI_PATTERN1_1;
            default:
                return get合計パターン番号2(サービス種類);
        }
    }

    private RString get合計パターン番号2(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 短期老健:
            case 予短老健:
            case 短期医療:
            case 予短医療:
                return GOKEI_PATTERN1_2;
            case 福祉施設:
                return GOKEI_PATTERN2_1;
            case 老健施設:
            case 医療施設:
                return GOKEI_PATTERN2_2;
            default:
                return get合計パターン番号3(サービス種類);
        }
    }

    private RString get合計パターン番号3(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 地共同介:
            case 地予共同:
            case 地施短外:
            case 地施短期:
            case 地共同短:
            case 地予共短:
            case 地夜間訪:
            case 地通所介:
            case 地予通所:
            case 地小短外:
            case 地予小外:
            case 地小規単:
            case 地予小短:
            case 定期随時:
            case 看小短外:
            case 看小規短:
            case 地域通所:
            case 地福祉生:
                return GOKEI_PATTERN3;
            default:
                return get合計パターン番号4(サービス種類);
        }
    }

    private RString get合計パターン番号4(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 訪問みな:
            case 訪問独自:
            case 訪問定率:
            case 訪問定額:
            case 通所みな:
            case 通所独自:
            case 通所定率:
            case 通所定額:
            case 予防ケア:
            case 配食定率:
            case 配食定額:
            case 見守定率:
            case 見守定額:
            case その他率:
            case その他額:
                return GOKEI_PATTERN4;
            default:
                return get合計パターン番号5(サービス種類);
        }
    }

    private RString get合計パターン番号5(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 用具販売:
            case 予用販売:
                return GOKEI_PATTERN6_1;
            case 住宅改修:
            case 予住改修:
                return GOKEI_PATTERN6_2;
            default:
                return GOKEI_PATTERN_NOTHING;
        }
    }

    private boolean chk単位数加算対象_経過措置(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case 0:
                switch (サービス種類) {
                    case 総訪予防:
                        return true;
                    default:
                        return false;
                }
            case 1:
                switch (サービス種類) {
                    case 総訪入浴:
                        return true;
                    default:
                        return false;
                }
            case 2:
                switch (サービス種類) {
                    case 総訪看護:
                        return true;
                    default:
                        return false;
                }
            case INT_SAN:
                switch (サービス種類) {
                    case 総訪リハ:
                        return true;
                    default:
                        return false;
                }
            case INT_YON:
                switch (サービス種類) {
                    case 総通予防:
                        return true;
                    default:
                        return false;
                }
            case INT_GO:
                switch (サービス種類) {
                    case 総通リハ:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象_経過措置2(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象_経過措置2(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_ROKU:
                switch (サービス種類) {
                    case 総用貸与:
                        return true;
                    default:
                        return false;
                }
            case INT_NANA:
                switch (サービス種類) {
                    case 総短介護:
                        return true;
                    default:
                        return false;
                }
            case INT_HACHI:
                switch (サービス種類) {
                    case 総短老健:
                        return true;
                    default:
                        return false;
                }
            case INT_KYU:
                switch (サービス種類) {
                    case 総短医療:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUI:
                switch (サービス種類) {
                    case 総療養指:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象_経過措置3(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象_経過措置3(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUN:
                switch (サービス種類) {
                    case 総特施設:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUS:
                switch (サービス種類) {
                    case 地総通所:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUY:
                switch (サービス種類) {
                    case 地総共短:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUG:
                switch (サービス種類) {
                    case 地総共同:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUR:
                switch (サービス種類) {
                    case 地総小規:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象_経過措置4(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象_経過措置4(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUNA:
                switch (サービス種類) {
                    case ケアマネ:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUH:
                switch (サービス種類) {
                    case 生活配食:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUK:
                switch (サービス種類) {
                    case 生活見守:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYU:
                switch (サービス種類) {
                    case 生活他:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private boolean chk出来高単位数加算対象_経過措置(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYU:
                switch (サービス種類) {
                    case 総短老健:
                    case 総短医療:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private RString get合計パターン番号_経過措置(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 総訪予防:
            case 総訪入浴:
            case 総訪看護:
            case 総訪リハ:
            case 総通予防:
            case 総通リハ:
            case 総用貸与:
            case 総短介護:
            case 総療養指:
            case 総特施設:
                return GOKEI_PATTERN1_1;
            default:
                return get合計パターン番号_経過措置2(サービス種類);
        }
    }

    private RString get合計パターン番号_経過措置2(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 総短老健:
            case 総短医療:
                return GOKEI_PATTERN1_2;
            case 地総通所:
            case 地総共短:
            case 地総共同:
            case 地総小規:
            case ケアマネ:
                return GOKEI_PATTERN3;
            case 生活配食:
            case 生活見守:
            case 生活他:
                return GOKEI_PATTERN4;
            default:
                return GOKEI_PATTERN_NOTHING;
        }
    }

}
