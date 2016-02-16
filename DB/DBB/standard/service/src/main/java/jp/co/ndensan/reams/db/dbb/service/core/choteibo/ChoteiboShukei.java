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
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DanKai;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiChoteigakuShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiShokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokei;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Gokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.Kibetsu;
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
public class ChoteiboShukei {

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
        Decimal 特別徴収第1期の調定額 = Decimal.ZERO;
        Decimal 特別徴収第2期の調定額 = Decimal.ZERO;
        Decimal 特別徴収第3期の調定額 = Decimal.ZERO;
        Decimal 特別徴収第4期の調定額 = Decimal.ZERO;
        Decimal 特別徴収第5期の調定額 = Decimal.ZERO;
        Decimal 特別徴収第6期の調定額 = Decimal.ZERO;
        Decimal 第1期の調定額 = Decimal.ZERO;
        Decimal 第2期の調定額 = Decimal.ZERO;
        Decimal 第3期の調定額 = Decimal.ZERO;
        Decimal 第4期の調定額 = Decimal.ZERO;
        Decimal 第5期の調定額 = Decimal.ZERO;
        Decimal 第6期の調定額 = Decimal.ZERO;
        Decimal 第7期の調定額 = Decimal.ZERO;
        Decimal 第8期の調定額 = Decimal.ZERO;
        Decimal 第9期の調定額 = Decimal.ZERO;
        Decimal 第10期の調定額 = Decimal.ZERO;
        Decimal 第11期の調定額 = Decimal.ZERO;
        Decimal 第12期の調定額 = Decimal.ZERO;
        Decimal 第13期の調定額 = Decimal.ZERO;
        Decimal 第14期の調定額 = Decimal.ZERO;
        FlexibleYear 調定年度 = FlexibleYear.EMPTY;
        FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
        for (Kibetsu kibetsu : kiBetsuList) {
            if (ChoshuHohoKibetsu.特別徴収.code().equals(kibetsu.getChoshuHouhou())) {
                調定年度 = kibetsu.getChoteiNendo();
                賦課年度 = kibetsu.getFukaNendo();
                switch (kibetsu.getKi()) {
                    case 1:
                        特別徴収第1期の調定額 = 特別徴収第1期の調定額.add(kibetsu.getDai1kiChoteiGaku());
                        break;
                    case 2:
                        特別徴収第2期の調定額 = 特別徴収第2期の調定額.add(kibetsu.getDai2kiChoteiGaku());
                        break;
                    case 3:
                        特別徴収第3期の調定額 = 特別徴収第3期の調定額.add(kibetsu.getDai3kiChoteiGaku());
                        break;
                    case 4:
                        特別徴収第4期の調定額 = 特別徴収第4期の調定額.add(kibetsu.getDai4kiChoteiGaku());
                        break;
                    case 5:
                        特別徴収第5期の調定額 = 特別徴収第5期の調定額.add(kibetsu.getDai5kiChoteiGaku());
                        break;
                    case 6:
                        特別徴収第6期の調定額 = 特別徴収第6期の調定額.add(kibetsu.getDai6kiChoteiGaku());
                        break;
                    default:
                        break;
                }
            } else if (ChoshuHohoKibetsu.普通徴収.code().equals(kibetsu.getChoshuHouhou())) {
                調定年度 = kibetsu.getChoteiNendo();
                賦課年度 = kibetsu.getFukaNendo();
                switch (kibetsu.getKi()) {
                    case 1:
                        第1期の調定額 = 第1期の調定額.add(kibetsu.getDai1kiChoteiGaku());
                        break;
                    case 2:
                        第2期の調定額 = 第2期の調定額.add(kibetsu.getDai2kiChoteiGaku());
                        break;
                    case 3:
                        第3期の調定額 = 第3期の調定額.add(kibetsu.getDai3kiChoteiGaku());
                        break;
                    case 4:
                        第4期の調定額 = 第4期の調定額.add(kibetsu.getDai4kiChoteiGaku());
                        break;
                    case 5:
                        第5期の調定額 = 第5期の調定額.add(kibetsu.getDai5kiChoteiGaku());
                        break;
                    case 6:
                        第6期の調定額 = 第6期の調定額.add(kibetsu.getDai6kiChoteiGaku());
                        break;
                    case 7:
                        第7期の調定額 = 第7期の調定額.add(kibetsu.getDai7kiChoteiGaku());
                        break;
                    case 8:
                        第8期の調定額 = 第8期の調定額.add(kibetsu.getDai8kiChoteiGaku());
                        break;
                    case 9:
                        第9期の調定額 = 第9期の調定額.add(kibetsu.getDai9kiChoteiGaku());
                        break;
                    case 10:
                        第10期の調定額 = 第10期の調定額.add(kibetsu.getDai10kiChoteiGaku());
                        break;
                    case 11:
                        第11期の調定額 = 第11期の調定額.add(kibetsu.getDai11kiChoteiGaku());
                        break;
                    case 12:
                        第12期の調定額 = 第12期の調定額.add(kibetsu.getDai12kiChoteiGaku());
                        break;
                    case 13:
                        第13期の調定額 = 第13期の調定額.add(kibetsu.getDai13kiChoteiGaku());
                        break;
                    case 14:
                        第14期の調定額 = 第14期の調定額.add(kibetsu.getDai14kiChoteiGaku());
                        break;
                    default:
                        break;
                }
            }
        }

        List<KibetsuShokei> kibetsuShokeiList = new ArrayList<>();
        KibetsuShokei 特別徴収 = KibetsuShokei.createParam(調定年度, 賦課年度,
                ChoshuHohoKibetsu.特別徴収.code(), 特別徴収第1期の調定額, 特別徴収第2期の調定額, 特別徴収第3期の調定額,
                特別徴収第4期の調定額, 特別徴収第5期の調定額, 特別徴収第6期の調定額, null, null,
                null, null, null, null, null, null);
        kibetsuShokeiList.add(特別徴収);
        KibetsuShokei 普通徴収 = KibetsuShokei.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.code(), 第1期の調定額,
                第2期の調定額, 第3期の調定額, 第4期の調定額, 第5期の調定額, 第6期の調定額, 第7期の調定額, 第8期の調定額,
                第9期の調定額, 第10期の調定額, 第11期の調定額, 第12期の調定額, 第13期の調定額, 第14期の調定額);
        kibetsuShokeiList.add(普通徴収);
        return kibetsuShokeiList;
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
            段階元リスト.add(dankai.getDankai());
        }
        Set<RString> 重複排除セット = new HashSet<>(段階元リスト);
        List<RString> 重複排除リスト = new ArrayList<>(重複排除セット);
        for (RString 段階 : 重複排除リスト) {
            Decimal 特別徴収当月末の調定額集計 = Decimal.ZERO;
            Decimal 特別徴収前月末の調定額集計 = Decimal.ZERO;
            Decimal 普通徴収当月末の調定額集計 = Decimal.ZERO;
            Decimal 普通徴収前月末の調定額集計 = Decimal.ZERO;
            FlexibleYear 調定年度 = FlexibleYear.EMPTY;
            FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
            for (DanKai dankai : danKaiList) {
                if (ChoshuHohoKibetsu.特別徴収.code().equals(dankai.getChoshuHouhou())) {
                    if ((1 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankai())) {
                        調定年度 = dankai.getChoteiNendo();
                        賦課年度 = dankai.getFukaNendo();
                        特別徴収当月末の調定額集計 = 特別徴収当月末の調定額集計.add(
                                dankai.getDogetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getDogetsusueChoteigaku());
                    } else if ((0 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankai())) {
                        調定年度 = dankai.getChoteiNendo();
                        賦課年度 = dankai.getFukaNendo();
                        特別徴収前月末の調定額集計 = 特別徴収前月末の調定額集計.add(
                                dankai.getZengetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getZengetsusueChoteigaku());
                    }
                } else if (ChoshuHohoKibetsu.普通徴収.code().equals(dankai.getChoshuHouhou())) {
                    if ((1 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankai())) {
                        調定年度 = dankai.getChoteiNendo();
                        賦課年度 = dankai.getFukaNendo();
                        普通徴収当月末の調定額集計 = 普通徴収当月末の調定額集計.add(
                                dankai.getDogetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getDogetsusueChoteigaku());
                    } else if ((0 == dankai.getDogetsuFlag().intValue()) && 段階.equals(dankai.getDankai())) {
                        調定年度 = dankai.getChoteiNendo();
                        賦課年度 = dankai.getFukaNendo();
                        普通徴収前月末の調定額集計 = 普通徴収前月末の調定額集計.add(
                                dankai.getZengetsusueChoteigaku() == null ? Decimal.ZERO : dankai.getZengetsusueChoteigaku());
                    }
                }
            }
            if (!Decimal.ZERO.equals(特別徴収当月末の調定額集計)) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定年度,
                        賦課年度, 段階, ChoshuHohoKibetsu.特別徴収.code(), 1, null, 特別徴収当月末の調定額集計));
            }
            if (!Decimal.ZERO.equals(特別徴収前月末の調定額集計)) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定年度,
                        賦課年度, 段階, ChoshuHohoKibetsu.特別徴収.code(), 0, 特別徴収前月末の調定額集計, null));
            }
            if (!Decimal.ZERO.equals(普通徴収当月末の調定額集計)) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定年度,
                        賦課年度, 段階, ChoshuHohoKibetsu.普通徴収.code(), 1, null, 普通徴収当月末の調定額集計));
            }
            if (!Decimal.ZERO.equals(普通徴収前月末の調定額集計)) {
                resultList.add(DankaiChoteigakuShokei.createParam(調定年度,
                        賦課年度, 段階, ChoshuHohoKibetsu.普通徴収.code(), 0, 普通徴収前月末の調定額集計, null));
            }
        }

        return resultList;
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
        for (Gokei gokei : gokeiList) {
            List<KibetsuShokei> 期別小計リスト = gokei.getKibetsuShokeiList();
            Decimal 特別徴収調合計 = Decimal.ZERO;
            Decimal 普通徴収調合計 = Decimal.ZERO;
            FlexibleYear 調定年度 = FlexibleYear.EMPTY;
            FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
            for (KibetsuShokei 期別小計 : 期別小計リスト) {
                if (ChoshuHohoKibetsu.特別徴収.code().equals(期別小計.getChoshuHouhou())) {
                    調定年度 = 期別小計.getChoteiNendo();
                    賦課年度 = 期別小計.getFukaNendo();
                    特別徴収調合計 = 特別徴収調合計.add(期別小計.getDai1kiChoteiGakuCount()).add(
                            期別小計.getDai2kiChoteiGakuCount()).add(期別小計.getDai3kiChoteiGakuCount())
                            .add(期別小計.getDai4kiChoteiGakuCount()).add(期別小計.getDai5kiChoteiGakuCount())
                            .add(期別小計.getDai6kiChoteiGakuCount());
                } else if (ChoshuHohoKibetsu.普通徴収.code().equals(期別小計.getChoshuHouhou())) {
                    調定年度 = 期別小計.getChoteiNendo();
                    賦課年度 = 期別小計.getFukaNendo();
                    普通徴収調合計 = 普通徴収調合計.add(期別小計.getDai1kiChoteiGakuCount()).add(
                            期別小計.getDai2kiChoteiGakuCount()).add(期別小計.getDai3kiChoteiGakuCount())
                            .add(期別小計.getDai4kiChoteiGakuCount()).add(期別小計.getDai5kiChoteiGakuCount())
                            .add(期別小計.getDai6kiChoteiGakuCount()).add(期別小計.getDai7kiChoteiGakuCount())
                            .add(期別小計.getDai8kiChoteiGakuCount()).add(期別小計.getDai9kiChoteiGakuCount())
                            .add(期別小計.getDai10kiChoteiGakuCount()).add(期別小計.getDai11kiChoteiGakuCount())
                            .add(期別小計.getDai12kiChoteiGakuCount()).add(期別小計.getDai13kiChoteiGakuCount())
                            .add(期別小計.getDai14kiChoteiGakuCount());
                }
            }
            KibetsuGokeigo 特別期別合計後 = KibetsuGokeigo.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.code(),
                    特別徴収調合計, Decimal.ZERO, Decimal.ZERO);
            KibetsuGokeigo 普通期別合計後 = KibetsuGokeigo.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.code(),
                    Decimal.ZERO, 普通徴収調合計, Decimal.ZERO);
            KibetsuGokeigo 期別調定額総計 = KibetsuGokeigo.createParam(調定年度, 賦課年度, null,
                    Decimal.ZERO, Decimal.ZERO, 特別徴収調合計.add(普通徴収調合計));
            List<KibetsuGokeigo> kibetsuGokeigoList = new ArrayList<>();
            kibetsuGokeigoList.add(特別期別合計後);
            kibetsuGokeigoList.add(普通期別合計後);
            kibetsuGokeigoList.add(期別調定額総計);

            List<DankaiShokei> 段階小計リスト = gokei.getDankaiShokeiList();
            Decimal 特別徴収当月末の全部件数の合計 = Decimal.ZERO;
            Decimal 特別徴収当月末の全部調定額の合計 = Decimal.ZERO;
            Decimal 特別徴収前月末の全部件数の合計 = Decimal.ZERO;
            Decimal 特別徴収前月末の全部調定額の合計 = Decimal.ZERO;
            Decimal 普通徴収当月末の全部件数の合計 = Decimal.ZERO;
            Decimal 普通徴収当月末の全部調定額の合計 = Decimal.ZERO;
            Decimal 普通徴収前月末の全部件数の合計 = Decimal.ZERO;
            Decimal 普通徴収前月末の全部調定額の合計 = Decimal.ZERO;
            Decimal 全て段階の特徴者数の合計 = Decimal.ZERO;
            Decimal 全て段階の普徴者数の合計 = Decimal.ZERO;
            Decimal 全て段階の内併徴者数の合計 = Decimal.ZERO;
            for (DankaiShokei 段階小計 : 段階小計リスト) {
                if (ChoshuHohoKibetsu.特別徴収.code().equals(段階小計.getChoshuHouhou())) {
                    if (段階小計.getDogetsuFlag().intValue() == 1) {
                        特別徴収当月末の全部件数の合計 = 特別徴収当月末の全部件数の合計.add(
                                段階小計.getDogetsusueKensu() == null ? Decimal.ZERO : 段階小計.getDogetsusueKensu());
                        特別徴収当月末の全部調定額の合計 = 特別徴収当月末の全部調定額の合計.add(
                                段階小計.getDogetsusueChoteigakuCount() == null ? Decimal.ZERO : 段階小計.getDogetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(
                                段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(
                                段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(
                                段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu());
                    } else if (段階小計.getDogetsuFlag().intValue() == 0) {
                        特別徴収前月末の全部件数の合計 = 特別徴収前月末の全部件数の合計.add(
                                段階小計.getZengetsusueKensu() == null ? Decimal.ZERO : 段階小計.getZengetsusueKensu());
                        特別徴収前月末の全部調定額の合計 = 特別徴収前月末の全部調定額の合計.add(
                                段階小計.getZengetsusueChoteigakuCount() == null ? Decimal.ZERO : 段階小計.getZengetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(
                                段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(
                                段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(
                                段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu());
                    }
                } else if (ChoshuHohoKibetsu.普通徴収.code().equals(段階小計.getChoshuHouhou())) {
                    if (段階小計.getDogetsuFlag().intValue() == 1) {
                        普通徴収当月末の全部件数の合計 = 普通徴収当月末の全部件数の合計.add(
                                段階小計.getDogetsusueKensu() == null ? Decimal.ZERO : 段階小計.getDogetsusueKensu());
                        普通徴収当月末の全部調定額の合計 = 普通徴収当月末の全部調定額の合計.add(
                                段階小計.getDogetsusueChoteigakuCount() == null ? Decimal.ZERO : 段階小計.getDogetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(
                                段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(
                                段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(
                                段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu());
                    } else if (段階小計.getDogetsuFlag().intValue() == 0) {
                        普通徴収前月末の全部件数の合計 = 普通徴収前月末の全部件数の合計.add(
                                段階小計.getZengetsusueKensu() == null ? Decimal.ZERO : 段階小計.getZengetsusueKensu());
                        普通徴収前月末の全部調定額の合計 = 普通徴収前月末の全部調定額の合計.add(
                                段階小計.getZengetsusueChoteigakuCount() == null ? Decimal.ZERO : 段階小計.getZengetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(
                                段階小計.getTokuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(
                                段階小計.getFuchosyaKensu() == null ? Decimal.ZERO : 段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(
                                段階小計.getNaiheisyaKensu() == null ? Decimal.ZERO : 段階小計.getNaiheisyaKensu());
                    }
                }
            }
            DankaiGokeigo 特別徴収当月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.code(),
                    1, null, null, 特別徴収当月末の全部件数の合計, 特別徴収当月末の全部調定額の合計, null, null, null);
            DankaiGokeigo 特別徴収前月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.特別徴収.code(),
                    0, 特別徴収前月末の全部件数の合計, 特別徴収前月末の全部調定額の合計, null, null, null, null, null);
            DankaiGokeigo 普通徴収当月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.code(),
                    1, null, null, 普通徴収当月末の全部件数の合計, 普通徴収当月末の全部調定額の合計, null, null, null);
            DankaiGokeigo 普通徴収前月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, ChoshuHohoKibetsu.普通徴収.code(),
                    0, 普通徴収前月末の全部件数の合計, 普通徴収前月末の全部調定額の合計, null, null, null, null, null);
            DankaiGokeigo 所得段階別の特徴普徴者数の合計 = DankaiGokeigo.createParam(調定年度, 賦課年度, null, null, null,
                    null, null, null, 全て段階の特徴者数の合計, 全て段階の普徴者数の合計, 全て段階の内併徴者数の合計);
            List<DankaiGokeigo> dankaiGokeigoList = new ArrayList<>();
            dankaiGokeigoList.add(特別徴収当月末段階合計後);
            dankaiGokeigoList.add(特別徴収前月末段階合計後);
            dankaiGokeigoList.add(普通徴収当月末段階合計後);
            dankaiGokeigoList.add(普通徴収前月末段階合計後);
            dankaiGokeigoList.add(所得段階別の特徴普徴者数の合計);
            Gokeigo gokeigo = Gokeigo.createParam(kibetsuGokeigoList, dankaiGokeigoList);
            gokeigoList.add(gokeigo);
        }
        return gokeigoList;
    }
}
