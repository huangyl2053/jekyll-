/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choteiboshukei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.DanKai;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.DankaiChoteigakuShokei;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.DankaiGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.DankaiShokei;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.Gokei;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.Gokeigo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.KibetsuGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.KibetsuShokei;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 調定簿集計(編集バッチ)用のクラス。
 *
 * @author yebangqiang
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
            throw new NullPointerException(UrSystemErrorMessages.値がnull.getReplacedMessage("期別リスト"));
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
                        特別徴収第1期の調定額 = 特別徴収第1期の調定額.add(kibetsu.getDai1kiChoteiIdGaku());
                        break;
                    case 2:
                        特別徴収第2期の調定額 = 特別徴収第2期の調定額.add(kibetsu.getDai2kiChoteiIdGaku());
                        break;
                    case 3:
                        特別徴収第3期の調定額 = 特別徴収第3期の調定額.add(kibetsu.getDai3kiChoteiIdGaku());
                        break;
                    case 4:
                        特別徴収第4期の調定額 = 特別徴収第4期の調定額.add(kibetsu.getDai4kiChoteiIdGaku());
                        break;
                    case 5:
                        特別徴収第5期の調定額 = 特別徴収第5期の調定額.add(kibetsu.getDai5kiChoteiIdGaku());
                        break;
                    case 6:
                        特別徴収第6期の調定額 = 特別徴収第6期の調定額.add(kibetsu.getDai6kiChoteiIdGaku());
                        break;
                    default:
                        break;
                }
            } else if (ChoshuHohoKibetsu.普通徴収.code().equals(kibetsu.getChoshuHouhou())) {
                調定年度 = kibetsu.getChoteiNendo();
                賦課年度 = kibetsu.getFukaNendo();
                switch (kibetsu.getKi()) {
                    case 1:
                        第1期の調定額 = 第1期の調定額.add(kibetsu.getDai1kiChoteiIdGaku());
                        break;
                    case 2:
                        第2期の調定額 = 第2期の調定額.add(kibetsu.getDai2kiChoteiIdGaku());
                        break;
                    case 3:
                        第3期の調定額 = 第3期の調定額.add(kibetsu.getDai3kiChoteiIdGaku());
                        break;
                    case 4:
                        第4期の調定額 = 第4期の調定額.add(kibetsu.getDai4kiChoteiIdGaku());
                        break;
                    case 5:
                        第5期の調定額 = 第5期の調定額.add(kibetsu.getDai5kiChoteiIdGaku());
                        break;
                    case 6:
                        第6期の調定額 = 第6期の調定額.add(kibetsu.getDai6kiChoteiIdGaku());
                        break;
                    case 7:
                        第7期の調定額 = 第7期の調定額.add(kibetsu.getDai7kiChoteiIdGaku());
                        break;
                    case 8:
                        第8期の調定額 = 第8期の調定額.add(kibetsu.getDai8kiChoteiIdGaku());
                        break;
                    case 9:
                        第9期の調定額 = 第9期の調定額.add(kibetsu.getDai9kiChoteiIdGaku());
                        break;
                    case 10:
                        第10期の調定額 = 第10期の調定額.add(kibetsu.getDai10kiChoteiIdGaku());
                        break;
                    case 11:
                        第11期の調定額 = 第11期の調定額.add(kibetsu.getDai11kiChoteiIdGaku());
                        break;
                    case 12:
                        第12期の調定額 = 第12期の調定額.add(kibetsu.getDai12kiChoteiIdGaku());
                        break;
                    case 13:
                        第13期の調定額 = 第13期の調定額.add(kibetsu.getDai13kiChoteiIdGaku());
                        break;
                    case 14:
                        第14期の調定額 = 第14期の調定額.add(kibetsu.getDai14kiChoteiIdGaku());
                        break;
                    default:
                        break;
                }
            }
        }

        List<KibetsuShokei> kibetsuShokeiList = new ArrayList<>();
        KibetsuShokei 特別徴収 = KibetsuShokei.createParam(調定年度, 賦課年度,
                new RString("1"), 特別徴収第1期の調定額, 特別徴収第2期の調定額, 特別徴収第3期の調定額,
                特別徴収第4期の調定額, 特別徴収第5期の調定額, 特別徴収第6期の調定額, Decimal.ZERO, Decimal.ZERO,
                Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO
        );
        kibetsuShokeiList.add(特別徴収);
        KibetsuShokei 普通徴収 = KibetsuShokei.createParam(調定年度, 賦課年度, new RString("2"), 第1期の調定額,
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
        for (DanKai dankai : danKaiList) {
            // TODO QA中　QA番号86
        }
        return null;
    }

    /**
     * 入力したパラメータより、期別の調定額、段階の件数、段階の調定額等の集計メソッド。
     *
     * @param gokeiList 合計用リスト
     * @return DankaiChoteigakuShokeiList 段階調定額小計リスト
     */
    public static List<Gokeigo> choteiboDataGokei(List<Gokei> gokeiList) {
        if (gokeiList == null || gokeiList.isEmpty()) {
            throw new NullPointerException(UrSystemErrorMessages.値がnull.getReplacedMessage("合計リスト"));
        }
        List<Gokeigo> gokeigoList = new ArrayList<>();
        for (Gokei gokei : gokeiList) {
            List<KibetsuShokei> 期別小計リスト = gokei.getKibetsuShokeiList();
            Decimal 特別徴収調合計 = Decimal.ZERO;
            Decimal 普通徴収調合計 = Decimal.ZERO;
            FlexibleYear 調定年度 = FlexibleYear.EMPTY;
            FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
            if (期別小計リスト == null || 期別小計リスト.isEmpty()) {
                throw new NullPointerException(UrSystemErrorMessages.値がnull.getReplacedMessage("期別小計リスト"));
            }
            for (KibetsuShokei 期別小計 : 期別小計リスト) {
                if (ChoshuHohoKibetsu.特別徴収.code().equals(期別小計.getChoshuHouhou())) {
                    調定年度 = 期別小計.getChoteiNendo();
                    賦課年度 = 期別小計.getFukaNendo();
                    特別徴収調合計 = 特別徴収調合計.add(期別小計.getDai1kiChoteiIdGakuCount()).add(
                            期別小計.getDai2kiChoteiIdGakuCount()).add(期別小計.getDai3kiChoteiIdGakuCount())
                            .add(期別小計.getDai4kiChoteiIdGakuCount()).add(期別小計.getDai5kiChoteiIdGakuCount())
                            .add(期別小計.getDai6kiChoteiIdGakuCount());
                } else if (ChoshuHohoKibetsu.普通徴収.code().equals(期別小計.getChoshuHouhou())) {
                    調定年度 = 期別小計.getChoteiNendo();
                    賦課年度 = 期別小計.getFukaNendo();
                    普通徴収調合計 = 普通徴収調合計.add(期別小計.getDai1kiChoteiIdGakuCount()).add(
                            期別小計.getDai2kiChoteiIdGakuCount()).add(期別小計.getDai3kiChoteiIdGakuCount())
                            .add(期別小計.getDai4kiChoteiIdGakuCount()).add(期別小計.getDai5kiChoteiIdGakuCount())
                            .add(期別小計.getDai6kiChoteiIdGakuCount()).add(期別小計.getDai7kiChoteiIdGakuCount())
                            .add(期別小計.getDai8kiChoteiIdGakuCount()).add(期別小計.getDai9kiChoteiIdGakuCount())
                            .add(期別小計.getDai10kiChoteiIdGakuCount()).add(期別小計.getDai11kiChoteiIdGakuCount())
                            .add(期別小計.getDai12kiChoteiIdGakuCount()).add(期別小計.getDai13kiChoteiIdGakuCount())
                            .add(期別小計.getDai14kiChoteiIdGakuCount());
                }
            }
            KibetsuGokeigo 特別期別合計後 = KibetsuGokeigo.createParam(調定年度, 賦課年度, new RString("1"),
                    特別徴収調合計, Decimal.ZERO, Decimal.ZERO);
            KibetsuGokeigo 普通期別合計後 = KibetsuGokeigo.createParam(調定年度, 賦課年度, new RString("2"),
                    Decimal.ZERO, 普通徴収調合計, Decimal.ZERO);
            KibetsuGokeigo 期別調定額総計 = KibetsuGokeigo.createParam(調定年度, 賦課年度, new RString(""),
                    Decimal.ZERO, Decimal.ZERO, 特別徴収調合計.add(普通徴収調合計));
            List<KibetsuGokeigo> kibetsuGokeigoList = new ArrayList<>();
            kibetsuGokeigoList.add(特別期別合計後);
            kibetsuGokeigoList.add(普通期別合計後);
            kibetsuGokeigoList.add(期別調定額総計);

            List<DankaiShokei> 段階小計リスト = gokei.getDankaiShokeiList();
            if (段階小計リスト == null || 段階小計リスト.isEmpty()) {
                throw new NullPointerException(UrSystemErrorMessages.値がnull.getReplacedMessage("段階小計リスト"));
            }
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
                    if (段階小計.getDogetsuFlag() == 1) {
                        特別徴収当月末の全部件数の合計 = 特別徴収当月末の全部件数の合計.add(段階小計.getDogetsusueKensu());
                        特別徴収当月末の全部調定額の合計 = 特別徴収当月末の全部調定額の合計.add(
                                段階小計.getDogetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(段階小計.getNaiheisyaKensu());
                    } else if (段階小計.getDogetsuFlag() == 0) {
                        特別徴収前月末の全部件数の合計 = 特別徴収前月末の全部件数の合計.add(段階小計.getZengetsusueKensu());
                        特別徴収前月末の全部調定額の合計 = 特別徴収前月末の全部調定額の合計.add(
                                段階小計.getZengetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(段階小計.getNaiheisyaKensu());
                    }
                } else if (ChoshuHohoKibetsu.普通徴収.code().equals(段階小計.getChoshuHouhou())) {
                    if (段階小計.getDogetsuFlag() == 1) {
                        普通徴収当月末の全部件数の合計 = 普通徴収当月末の全部件数の合計.add(段階小計.getDogetsusueKensu());
                        普通徴収当月末の全部調定額の合計 = 普通徴収当月末の全部調定額の合計.add(段階小計.getDogetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(段階小計.getNaiheisyaKensu());
                    } else if (段階小計.getDogetsuFlag() == 0) {
                        普通徴収前月末の全部件数の合計 = 普通徴収前月末の全部件数の合計.add(段階小計.getZengetsusueKensu());
                        普通徴収前月末の全部調定額の合計 = 普通徴収前月末の全部調定額の合計.add(段階小計.getZengetsusueChoteigakuCount());
                        全て段階の特徴者数の合計 = 全て段階の特徴者数の合計.add(段階小計.getTokuchosyaKensu());
                        全て段階の普徴者数の合計 = 全て段階の普徴者数の合計.add(段階小計.getFuchosyaKensu());
                        全て段階の内併徴者数の合計 = 全て段階の内併徴者数の合計.add(段階小計.getNaiheisyaKensu());
                    }
                }
            }
            DankaiGokeigo 特別徴収当月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, new RString("1"),
                    1, Decimal.ZERO, Decimal.ZERO, 特別徴収当月末の全部件数の合計, 特別徴収当月末の全部調定額の合計,
                    Decimal.ZERO, Decimal.ZERO, Decimal.ZERO
            );
            DankaiGokeigo 特別徴収前月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, new RString("1"),
                    0, 特別徴収前月末の全部件数の合計, 特別徴収前月末の全部調定額の合計, Decimal.ZERO, Decimal.ZERO,
                    Decimal.ZERO, Decimal.ZERO, Decimal.ZERO
            );
            DankaiGokeigo 普通徴収当月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, new RString("2"),
                    1, Decimal.ZERO, Decimal.ZERO, 普通徴収当月末の全部件数の合計, 普通徴収当月末の全部調定額の合計,
                    Decimal.ZERO, Decimal.ZERO, Decimal.ZERO
            );
            DankaiGokeigo 普通徴収前月末段階合計後 = DankaiGokeigo.createParam(調定年度, 賦課年度, new RString("2"),
                    0, 普通徴収前月末の全部件数の合計, 普通徴収前月末の全部調定額の合計, Decimal.ZERO, Decimal.ZERO,
                    Decimal.ZERO, Decimal.ZERO, Decimal.ZERO
            );
            DankaiGokeigo 所得段階別の特徴普徴者数の合計 = DankaiGokeigo.createParam(調定年度, 賦課年度, new RString(""),
                    0, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, 全て段階の特徴者数の合計,
                    全て段階の普徴者数の合計, 全て段階の内併徴者数の合計
            );
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
