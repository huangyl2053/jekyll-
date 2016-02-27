/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choteibo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Choteigaku;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.ChoteigakuSyukei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DanKai;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiChoteigakuShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiGakuGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuGakuGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuShokei;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 調定簿集計(編集バッチ)用のクラス。
 *
 */
public final class ChoteiboShukei {

    private static final int 期_1 = 1;
    private static final int 期_2 = 2;
    private static final int 期_3 = 3;
    private static final int 期_4 = 4;
    private static final int 期_5 = 5;
    private static final int 期_6 = 6;
    private static final int 期_7 = 7;
    private static final int 期_8 = 8;
    private static final int 期_9 = 9;
    private static final int 期_10 = 10;
    private static final int 期_11 = 11;
    private static final int 期_12 = 12;
    private static final int 期_13 = 13;
    private static final int 期_14 = 14;

    /**
     * コンストラクタです。
     */
    private ChoteiboShukei() {

    }

    /**
     * 入力したパラメータより、毎期の調定額を集計するメソッド。
     *
     * @param kiBetsuList 期別リスト
     * @return kibetsuShokeiList 期別調定額小計リスト
     */
    public static List<KibetsuShokei> kibetsuChoteigakuShokei(List<Kibetsu> kiBetsuList) {
        if (kiBetsuList == null || kiBetsuList.isEmpty()) {
            return new ArrayList<>();
        }
        return get期別調定額リスト(kiBetsuList);
    }

    private static List<KibetsuShokei> get期別調定額リスト(List<Kibetsu> kiBetsuList) {
        Choteigaku 特別徴収調定額 = new Choteigaku();
        Choteigaku 普通徴収調定額 = new Choteigaku();
        FlexibleYear 調定年度 = FlexibleYear.EMPTY;
        FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
        for (Kibetsu kibetsu : kiBetsuList) {
            if (ChoshuHohoKibetsu.特別徴収.code().equals(kibetsu.getChoshuHouhou())) {
                調定年度 = kibetsu.getChoteiNendo();
                賦課年度 = kibetsu.getFukaNendo();
                set特別徴収期の調定額(kibetsu, 特別徴収調定額);
            } else if (ChoshuHohoKibetsu.普通徴収.code().equals(kibetsu.getChoshuHouhou())) {
                調定年度 = kibetsu.getChoteiNendo();
                賦課年度 = kibetsu.getFukaNendo();
                set普通徴収期の調定額(kibetsu, 普通徴収調定額);
            }
        }
        List<KibetsuShokei> kibetsuShokeiList = new ArrayList<>();
        KibetsuShokei 特別徴収 = KibetsuShokei.createParam(調定年度, 賦課年度,
                ChoshuHohoKibetsu.特別徴収.code(), 特別徴収調定額.get第1期の調定額(),
                特別徴収調定額.get第2期の調定額(), 特別徴収調定額.get第3期の調定額(),
                特別徴収調定額.get第4期の調定額(), 特別徴収調定額.get第5期の調定額(),
                特別徴収調定額.get第6期の調定額(), null, null, null, null, null, null, null, null);
        kibetsuShokeiList.add(特別徴収);
        KibetsuShokei 普通徴収 = KibetsuShokei.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.code(),
                普通徴収調定額.get第1期の調定額(), 普通徴収調定額.get第2期の調定額(), 普通徴収調定額.get第3期の調定額(),
                普通徴収調定額.get第4期の調定額(), 普通徴収調定額.get第5期の調定額(), 普通徴収調定額.get第6期の調定額(),
                普通徴収調定額.get第7期の調定額(), 普通徴収調定額.get第8期の調定額(), 普通徴収調定額.get第9期の調定額(),
                普通徴収調定額.get第10期の調定額(), 普通徴収調定額.get第11期の調定額(), 普通徴収調定額.get第12期の調定額(),
                普通徴収調定額.get第13期の調定額(), 普通徴収調定額.get第14期の調定額());
        kibetsuShokeiList.add(普通徴収);
        return kibetsuShokeiList;
    }

    private static void set普通徴収期の調定額(Kibetsu kibetsu, Choteigaku 普通徴収調定額) {
        switch (kibetsu.getKi()) {
            case 期_1:
                普通徴収調定額.set第1期の調定額(普通徴収調定額.get第1期の調定額().add(
                        kibetsu.getDai1kiChoteiGaku()));
                break;
            case 期_2:
                普通徴収調定額.set第2期の調定額(普通徴収調定額.get第2期の調定額().add(
                        kibetsu.getDai2kiChoteiGaku()));
                break;
            case 期_3:
                普通徴収調定額.set第3期の調定額(普通徴収調定額.get第3期の調定額().add(
                        kibetsu.getDai3kiChoteiGaku()));
                break;
            case 期_4:
                普通徴収調定額.set第4期の調定額(普通徴収調定額.get第4期の調定額().add(
                        kibetsu.getDai4kiChoteiGaku()));
                break;
            case 期_5:
                普通徴収調定額.set第5期の調定額(普通徴収調定額.get第5期の調定額().add(
                        kibetsu.getDai5kiChoteiGaku()));
                break;
            case 期_6:
                普通徴収調定額.set第6期の調定額(普通徴収調定額.get第6期の調定額().add(
                        kibetsu.getDai6kiChoteiGaku()));
                break;
            case 期_7:
                普通徴収調定額.set第7期の調定額(普通徴収調定額.get第7期の調定額().add(
                        kibetsu.getDai7kiChoteiGaku()));
                break;
            case 期_8:
                普通徴収調定額.set第8期の調定額(普通徴収調定額.get第8期の調定額().add(
                        kibetsu.getDai8kiChoteiGaku()));
                break;
            case 期_9:
                普通徴収調定額.set第9期の調定額(普通徴収調定額.get第9期の調定額().add(
                        kibetsu.getDai9kiChoteiGaku()));
                break;
            case 期_10:
                普通徴収調定額.set第10期の調定額(普通徴収調定額.get第10期の調定額().add(
                        kibetsu.getDai10kiChoteiGaku()));
                break;
            case 期_11:
                普通徴収調定額.set第11期の調定額(普通徴収調定額.get第11期の調定額().add(
                        kibetsu.getDai11kiChoteiGaku()));
                break;
            case 期_12:
                普通徴収調定額.set第12期の調定額(普通徴収調定額.get第12期の調定額().add(
                        kibetsu.getDai12kiChoteiGaku()));
                break;
            case 期_13:
                普通徴収調定額.set第13期の調定額(普通徴収調定額.get第13期の調定額().add(
                        kibetsu.getDai13kiChoteiGaku()));
                break;
            case 期_14:
                普通徴収調定額.set第14期の調定額(普通徴収調定額.get第14期の調定額().add(
                        kibetsu.getDai14kiChoteiGaku()));
                break;
            default:
                break;
        }
    }

    private static void set特別徴収期の調定額(
            Kibetsu kibetsu,
            Choteigaku 特別徴収調定額) {
        switch (kibetsu.getKi()) {
            case 期_1:
                特別徴収調定額.set第1期の調定額(特別徴収調定額.get第1期の調定額().add(
                        kibetsu.getDai1kiChoteiGaku()));
                break;
            case 期_2:
                特別徴収調定額.set第2期の調定額(特別徴収調定額.get第2期の調定額().add(
                        kibetsu.getDai2kiChoteiGaku()));
                break;
            case 期_3:
                特別徴収調定額.set第3期の調定額(特別徴収調定額.get第3期の調定額().add(
                        kibetsu.getDai3kiChoteiGaku()));
                break;
            case 期_4:
                特別徴収調定額.set第4期の調定額(特別徴収調定額.get第4期の調定額().add(
                        kibetsu.getDai4kiChoteiGaku()));
                break;
            case 期_5:
                特別徴収調定額.set第5期の調定額(特別徴収調定額.get第5期の調定額().add(
                        kibetsu.getDai5kiChoteiGaku()));
                break;
            case 期_6:
                特別徴収調定額.set第6期の調定額(特別徴収調定額.get第6期の調定額().add(
                        kibetsu.getDai6kiChoteiGaku()));
                break;
            default:
                break;
        }
    }

    /**
     * 入力したパラメータより、前月末または当月末の毎段階の調定額を集計するメソッド。
     *
     * @param danKaiList 段階リスト
     * @return DankaiChoteigakuShokeiList 段階調定額小計リスト
     */
    public static List<DankaiChoteigakuShokei> dankaiChoteigakuShokei(List<DanKai> danKaiList) {
        List<DankaiChoteigakuShokei> resultList = new ArrayList<>();
        if (null == danKaiList || danKaiList.isEmpty()) {
            return resultList;
        }
        List<RString> 段階元リスト = new ArrayList<>();
        for (DanKai dankai : danKaiList) {
            段階元リスト.add(dankai.getDankaiField());
        }
        Set<RString> 重複排除セット = new HashSet<>(段階元リスト);
        List<RString> 重複排除リスト = new ArrayList<>(重複排除セット);
        set段階調定額リスト(重複排除リスト, danKaiList, resultList);

        return resultList;
    }

    private static void set段階調定額リスト(
            List<RString> 重複排除リスト,
            List<DanKai> danKaiList,
            List<DankaiChoteigakuShokei> resultList) {
        for (RString 段階 : 重複排除リスト) {
            ChoteigakuSyukei 調定額集計 = new ChoteigakuSyukei();
            for (DanKai dankai : danKaiList) {
                set調定額集計(dankai, 調定額集計, 段階);
            }
            if (!Decimal.ZERO.equals(調定額集計.get特別徴収当月末の調定額集計())) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定額集計.get調定年度(), 調定額集計.get賦課年度(), 段階,
                        ChoshuHohoKibetsu.特別徴収.code(), 1, null, 調定額集計.get特別徴収当月末の調定額集計()));
            }
            if (!Decimal.ZERO.equals(調定額集計.get特別徴収前月末の調定額集計())) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定額集計.get調定年度(), 調定額集計.get賦課年度(), 段階,
                        ChoshuHohoKibetsu.特別徴収.code(), 0, 調定額集計.get特別徴収前月末の調定額集計(), null));
            }
            if (!Decimal.ZERO.equals(調定額集計.get普通徴収当月末の調定額集計())) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定額集計.get調定年度(), 調定額集計.get賦課年度(), 段階,
                        ChoshuHohoKibetsu.普通徴収.code(), 1, null, 調定額集計.get普通徴収当月末の調定額集計()));
            }
            if (!Decimal.ZERO.equals(調定額集計.get普通徴収前月末の調定額集計())) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定額集計.get調定年度(), 調定額集計.get賦課年度(), 段階,
                        ChoshuHohoKibetsu.普通徴収.code(), 0, 調定額集計.get普通徴収前月末の調定額集計(), null));
            }
        }
    }

    private static void set調定額集計(DanKai dankai, ChoteigakuSyukei 調定額集計, RString 段階) {
        if (ChoshuHohoKibetsu.特別徴収.code().equals(dankai.getChoshuHouhou())) {
            if ((1 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankaiField())) {
                調定額集計.set調定年度(dankai.getChoteiNendo());
                調定額集計.set賦課年度(dankai.getFukaNendo());
                調定額集計.set特別徴収当月末の調定額集計(調定額集計.get特別徴収当月末の調定額集計().add(
                        dankai.getDogetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getDogetsusueChoteigaku()));
            } else if ((0 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankaiField())) {
                調定額集計.set調定年度(dankai.getChoteiNendo());
                調定額集計.set賦課年度(dankai.getFukaNendo());
                調定額集計.set特別徴収前月末の調定額集計(調定額集計.get特別徴収前月末の調定額集計().add(
                        dankai.getZengetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getZengetsusueChoteigaku()));
            }
        } else if (ChoshuHohoKibetsu.普通徴収.code().equals(dankai.getChoshuHouhou())) {
            if ((1 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankaiField())) {
                調定額集計.set調定年度(dankai.getChoteiNendo());
                調定額集計.set賦課年度(dankai.getFukaNendo());
                調定額集計.set普通徴収当月末の調定額集計(調定額集計.get普通徴収当月末の調定額集計().add(
                        dankai.getDogetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getDogetsusueChoteigaku()));
            } else if ((0 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankaiField())) {
                調定額集計.set調定年度(dankai.getChoteiNendo());
                調定額集計.set賦課年度(dankai.getFukaNendo());
                調定額集計.set普通徴収前月末の調定額集計(調定額集計.get普通徴収前月末の調定額集計().add(
                        dankai.getZengetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getZengetsusueChoteigaku()));
            }
        }
    }

    /**
     * 入力したパラメータより、期別の調定額、段階の件数、段階の調定額等の集計メソッド。
     *
     * @param gokeiList 合計用リスト
     * @return GokeigoList 合計後リスト
     */
    public static List<Gokeigo> choteiboDataGokei(List<Gokei> gokeiList) {
        if (gokeiList == null || gokeiList.isEmpty()) {
            return new ArrayList<>();
        }
        List<Gokeigo> gokeigoList = new ArrayList<>();
        set合計用リスト(gokeiList, gokeigoList);
        return gokeigoList;
    }

    private static void set合計用リスト(List<Gokei> gokeiList, List<Gokeigo> gokeigoList) {
        for (Gokei gokei : gokeiList) {
            List<KibetsuShokei> 期別小計リスト = gokei.getKibetsuShokeiList();
            KibetsuGakuGokeigo 期別合計後調定額合計 = new KibetsuGakuGokeigo();
            for (KibetsuShokei 期別小計 : 期別小計リスト) {
                set期別合計後調定額合計(期別小計, 期別合計後調定額合計);
            }
            KibetsuGokeigo 特別期別合計後 = KibetsuGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), ChoshuHohoKibetsu.特別徴収.code(),
                    期別合計後調定額合計.get特別徴収調合計(), null, null);
            KibetsuGokeigo 普通期別合計後 = KibetsuGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), ChoshuHohoKibetsu.普通徴収.code(),
                    null, 期別合計後調定額合計.get普通徴収調合計(), null);
            KibetsuGokeigo 期別調定額総計 = KibetsuGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), null,
                    null, null, 期別合計後調定額合計.get特別徴収調合計().add(期別合計後調定額合計.get普通徴収調合計()));
            List<KibetsuGokeigo> kibetsuGokeigoList = new ArrayList<>();
            kibetsuGokeigoList.add(特別期別合計後);
            kibetsuGokeigoList.add(普通期別合計後);
            kibetsuGokeigoList.add(期別調定額総計);

            List<DankaiShokei> 段階小計リスト = gokei.getDankaiShokeiList();
            DankaiGakuGokeigo 段階合計後調定額合計 = new DankaiGakuGokeigo();
            for (DankaiShokei 段階小計 : 段階小計リスト) {
                set段階合計後調定額合計(段階小計, 段階合計後調定額合計);
            }
            DankaiGokeigo 特別徴収当月末段階合計後 = DankaiGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), ChoshuHohoKibetsu.特別徴収.code(),
                    1, null, null, 段階合計後調定額合計.get特別徴収当月末の全部件数の合計(),
                    段階合計後調定額合計.get特別徴収当月末の全部調定額の合計(), null, null, null);
            DankaiGokeigo 特別徴収前月末段階合計後 = DankaiGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), ChoshuHohoKibetsu.特別徴収.code(),
                    0, 段階合計後調定額合計.get特別徴収前月末の全部件数の合計(),
                    段階合計後調定額合計.get特別徴収前月末の全部調定額の合計(), null, null, null, null, null);
            DankaiGokeigo 普通徴収当月末段階合計後 = DankaiGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), ChoshuHohoKibetsu.普通徴収.code(),
                    1, null, null, 段階合計後調定額合計.get普通徴収当月末の全部件数の合計(),
                    段階合計後調定額合計.get普通徴収当月末の全部調定額の合計(), null, null, null);
            DankaiGokeigo 普通徴収前月末段階合計後 = DankaiGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), ChoshuHohoKibetsu.普通徴収.code(),
                    0, 段階合計後調定額合計.get普通徴収前月末の全部件数の合計(),
                    段階合計後調定額合計.get普通徴収前月末の全部調定額の合計(), null, null, null, null, null);
            DankaiGokeigo 所得段階別の特徴普徴者数の合計 = DankaiGokeigo.createParam(期別合計後調定額合計.get調定年度(),
                    期別合計後調定額合計.get賦課年度(), null, null, null,
                    null, null, null, 段階合計後調定額合計.get全て段階の特徴者数の合計(),
                    段階合計後調定額合計.get全て段階の普徴者数の合計(),
                    段階合計後調定額合計.get全て段階の内併徴者数の合計());
            List<DankaiGokeigo> dankaiGokeigoList = new ArrayList<>();
            dankaiGokeigoList.add(特別徴収当月末段階合計後);
            dankaiGokeigoList.add(特別徴収前月末段階合計後);
            dankaiGokeigoList.add(普通徴収当月末段階合計後);
            dankaiGokeigoList.add(普通徴収前月末段階合計後);
            dankaiGokeigoList.add(所得段階別の特徴普徴者数の合計);
            Gokeigo gokeigo = Gokeigo.createParam(kibetsuGokeigoList, dankaiGokeigoList);
            gokeigoList.add(gokeigo);
        }
    }

    private static void set段階合計後調定額合計(DankaiShokei 段階小計, DankaiGakuGokeigo 段階合計後調定額合計) {
        if (ChoshuHohoKibetsu.特別徴収.code().equals(段階小計.getChoshuHouhou())) {
            set特別段階合計後調定額合計(段階小計, 段階合計後調定額合計);
        } else if (ChoshuHohoKibetsu.普通徴収.code().equals(段階小計.getChoshuHouhou())) {
            set普通段階合計後調定額合計(段階小計, 段階合計後調定額合計);
        }
    }

    private static void set普通段階合計後調定額合計(DankaiShokei 段階小計, DankaiGakuGokeigo 段階合計後調定額合計) {
        if (段階小計.getDogetsuFlag().intValue() == 1) {
            段階合計後調定額合計.set普通徴収当月末の全部件数の合計(段階合計後調定額合計.get普通徴収当月末の全部件数の合計().add(
                    段階小計.getDogetsusueKensu() == null ? Decimal.ZERO : 段階小計.getDogetsusueKensu()));
            段階合計後調定額合計.set普通徴収当月末の全部調定額の合計(段階合計後調定額合計.get普通徴収当月末の全部調定額の合計().add(
                    段階小計.getDogetsusueChoteigakuCount() == null ? Decimal.ZERO : 段階小計.getDogetsusueChoteigakuCount()));
            段階合計後調定額合計.set全て段階の特徴者数の合計(段階合計後調定額合計.get全て段階の特徴者数の合計().add(
                    段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu()));
            段階合計後調定額合計.set全て段階の普徴者数の合計(段階合計後調定額合計.get全て段階の普徴者数の合計().add(
                    段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu()));
            段階合計後調定額合計.set全て段階の内併徴者数の合計(段階合計後調定額合計.get全て段階の内併徴者数の合計().add(
                    段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu()));
        } else if (段階小計.getDogetsuFlag().intValue() == 0) {
            段階合計後調定額合計.set普通徴収前月末の全部件数の合計(段階合計後調定額合計.get普通徴収前月末の全部件数の合計().add(
                    段階小計.getZengetsusueKensu() == null ? Decimal.ZERO : 段階小計.getZengetsusueKensu()));
            段階合計後調定額合計.set普通徴収前月末の全部調定額の合計(段階合計後調定額合計.get普通徴収前月末の全部調定額の合計().add(
                    段階小計.getZengetsusueChoteigakuCount() == null ? Decimal.ZERO : 段階小計.getZengetsusueChoteigakuCount()));
            段階合計後調定額合計.set全て段階の特徴者数の合計(段階合計後調定額合計.get全て段階の特徴者数の合計().add(
                    段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu()));
            段階合計後調定額合計.set全て段階の普徴者数の合計(段階合計後調定額合計.get全て段階の普徴者数の合計().add(
                    段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu()));
            段階合計後調定額合計.set全て段階の内併徴者数の合計(段階合計後調定額合計.get全て段階の内併徴者数の合計().add(
                    段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu()));
        }
    }

    private static void set特別段階合計後調定額合計(DankaiShokei 段階小計, DankaiGakuGokeigo 段階合計後調定額合計) {
        if (段階小計.getDogetsuFlag().intValue() == 1) {
            段階合計後調定額合計.set特別徴収当月末の全部件数の合計(
                    段階合計後調定額合計.get特別徴収当月末の全部件数の合計().add(
                            段階小計.getDogetsusueKensu() == null ? Decimal.ZERO : 段階小計.getDogetsusueKensu()));
            段階合計後調定額合計.set特別徴収当月末の全部調定額の合計(
                    段階合計後調定額合計.get特別徴収当月末の全部調定額の合計().add(
                            段階小計.getDogetsusueChoteigakuCount() == null ? Decimal.ZERO
                            : 段階小計.getDogetsusueChoteigakuCount()));
            段階合計後調定額合計.set全て段階の特徴者数の合計(
                    段階合計後調定額合計.get全て段階の特徴者数の合計().add(
                            段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu()));
            段階合計後調定額合計.set全て段階の普徴者数の合計(段階合計後調定額合計.get全て段階の普徴者数の合計().add(
                    段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu()));
            段階合計後調定額合計.set全て段階の内併徴者数の合計(段階合計後調定額合計.get全て段階の内併徴者数の合計().add(
                    段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu()));
        } else if (段階小計.getDogetsuFlag().intValue() == 0) {
            段階合計後調定額合計.set特別徴収前月末の全部件数の合計(
                    段階合計後調定額合計.get特別徴収前月末の全部件数の合計().add(
                            段階小計.getZengetsusueKensu() == null ? Decimal.ZERO : 段階小計.getZengetsusueKensu()));
            段階合計後調定額合計.set特別徴収前月末の全部調定額の合計(
                    段階合計後調定額合計.get特別徴収前月末の全部調定額の合計().add(
                            段階小計.getZengetsusueChoteigakuCount() == null ? Decimal.ZERO
                            : 段階小計.getZengetsusueChoteigakuCount()));
            段階合計後調定額合計.set全て段階の特徴者数の合計(
                    段階合計後調定額合計.get全て段階の特徴者数の合計().add(
                            段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu()));
            段階合計後調定額合計.set全て段階の普徴者数の合計(段階合計後調定額合計.get全て段階の普徴者数の合計().add(
                    段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu()));
            段階合計後調定額合計.set全て段階の内併徴者数の合計(段階合計後調定額合計.get全て段階の内併徴者数の合計().add(
                    段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu()));
        }
    }

    private static void set期別合計後調定額合計(KibetsuShokei 期別小計, KibetsuGakuGokeigo 期別合計後調定額合計) {
        if (ChoshuHohoKibetsu.特別徴収.code().equals(期別小計.getChoshuHouhou())) {
            期別合計後調定額合計.set調定年度(期別小計.getChoteiNendo());
            期別合計後調定額合計.set賦課年度(期別小計.getFukaNendo());
            期別合計後調定額合計.set特別徴収調合計(期別合計後調定額合計.get特別徴収調合計().
                    add(期別小計.getDai1kiChoteiGakuCount()).add(期別小計.getDai2kiChoteiGakuCount()).
                    add(期別小計.getDai3kiChoteiGakuCount()).add(期別小計.getDai4kiChoteiGakuCount()).
                    add(期別小計.getDai5kiChoteiGakuCount()).add(期別小計.getDai6kiChoteiGakuCount()));
        } else if (ChoshuHohoKibetsu.普通徴収.code().equals(期別小計.getChoshuHouhou())) {
            期別合計後調定額合計.set調定年度(期別小計.getChoteiNendo());
            期別合計後調定額合計.set賦課年度(期別小計.getFukaNendo());
            期別合計後調定額合計.set普通徴収調合計(期別合計後調定額合計.get普通徴収調合計().
                    add(期別小計.getDai1kiChoteiGakuCount()).add(期別小計.getDai2kiChoteiGakuCount()).
                    add(期別小計.getDai3kiChoteiGakuCount()).add(期別小計.getDai4kiChoteiGakuCount()).
                    add(期別小計.getDai5kiChoteiGakuCount()).add(期別小計.getDai6kiChoteiGakuCount()).
                    add(期別小計.getDai7kiChoteiGakuCount()).add(期別小計.getDai8kiChoteiGakuCount()).
                    add(期別小計.getDai9kiChoteiGakuCount()).add(期別小計.getDai10kiChoteiGakuCount()).
                    add(期別小計.getDai11kiChoteiGakuCount()).add(期別小計.getDai12kiChoteiGakuCount()).
                    add(期別小計.getDai13kiChoteiGakuCount()).add(期別小計.getDai14kiChoteiGakuCount()));
        }
    }
}
