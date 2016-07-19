/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka.choteijiyu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.ChoteiJiyuParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.FukaJohoList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 調定事由のビジネスクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
public class ChoteiJiyuHantei {

    private static final RString 特別徴収_厚生労働省 = new RString("1");
    private static final RString 特別徴収_地共済 = new RString("2");
    private static final RString 普通徴収 = new RString("3");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int DAY = 31;

    /**
     * コンストラクタです
     */
    public ChoteiJiyuHantei() {

    }

    /**
     * にて生成した{@link ChoteiJiyuHantei}のインスタンスを返します。
     *
     * @return ChoteiJiyuHantei
     */
    public static ChoteiJiyuHantei createInstance() {
        return InstanceProvider.create(ChoteiJiyuHantei.class);
    }

    /**
     * 調定事由判定設定メソッド
     *
     * @param param ChoteiJiyuParameter
     * @return List<FukaJohoList>
     */
    public List<FukaJohoList> set調定事由(ChoteiJiyuParameter param) {
        List<FukaJohoList> 更正後賦課 = new ArrayList<>();
        List<FukaJohoList> 更正後賦課リスト = param.get更正後賦課リスト();
        for (FukaJohoList 更正後賦課の情報 : 更正後賦課リスト) {
            List<RString> 調定事由 = new ArrayList<>();
            boolean is徴収方法更正あり;
            if (更正後賦課の情報.get現年度() != null) {
                if (param.get現年度() != null && (param.get過年度() == null
                        || (param.get過年度() != null && 更正後賦課の情報.get過年度() != null))) {
                    is徴収方法更正あり = true;
                    set更正_異動(調定事由, param.get現年度(), 更正後賦課の情報.get現年度(), param.get更正後徴収方法(),
                            is徴収方法更正あり);
                } else if (param.get現年度() == null && param.get過年度() == null && 更正後賦課の情報.get過年度() == null) {
                    set新規(調定事由, 更正後賦課の情報.get現年度());
                }
            } else {
                if (param.get現年度() == null && param.get過年度() == null && 更正後賦課の情報.get過年度() != null) {
                    set新規(調定事由, 更正後賦課の情報.get過年度());
                } else if (param.get現年度() == null && param.get過年度() != null && 更正後賦課の情報.get過年度() != null) {
                    is徴収方法更正あり = false;
                    set更正_異動(調定事由, param.get過年度(), 更正後賦課の情報.get過年度(), param.get更正後徴収方法(),
                            is徴収方法更正あり);
                }
            }
            if (param.get現年度() != null && 更正後賦課の情報.get現年度() != null) {
                更正後賦課の情報.set現年度(set現年度調定事由(調定事由, param.get現年度(), 更正後賦課の情報.get現年度()));
            }
            if (更正後賦課の情報.get過年度() != null) {
                更正後賦課の情報.set過年度(set過年度調定事由(調定事由, 更正後賦課の情報.get過年度()));
            }
            更正後賦課.add(更正後賦課の情報);
        }
        return 更正後賦課;
    }

    private void set更正_異動(List<RString> 調定事由, FukaJoho 更正前, FukaJoho 更正後, ChoshuHoho 徴収方法_更正後,
            boolean is徴収方法更正あり) {
        if (is金額変更あり(更正前, 更正後)) {
            get更正(調定事由, 更正前, 更正後, 徴収方法_更正後, is徴収方法更正あり);
        } else {
            get異動(調定事由, 更正前, 更正後);
        }
    }

    private void set新規(List<RString> 調定事由, FukaJoho 更正後) {
        FlexibleDate 年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(更正後.get賦課年度()).toDateString());
        FlexibleDate 年度終了日 = new FlexibleDate(更正後.get賦課年度().plusYear(INT_1).getYearValue(),
                Month.MARCH.getValue(), DAY);
        if (更正後.get資格取得日() != null && !更正後.get資格取得日().isEmpty()
                && 更正後.get資格取得日().isBefore(年度終了日)
                && 年度開始日.isBeforeOrEquals(更正後.get資格取得日())) {
            調定事由.add(更正後.get資格取得事由());
        }
    }

    private void get更正(List<RString> 調定事由, FukaJoho 更正前, FukaJoho 更正後, ChoshuHoho 徴収方法_更正後,
            boolean is徴収方法更正あり) {
        get賦課更正(調定事由, 更正前, 更正後);
        if (is徴収方法更正あり) {
            get徴収方法更正(調定事由, 徴収方法_更正後, 更正前, 更正後);
        }
    }

    private void get賦課更正(List<RString> 調定事由, FukaJoho 更正前, FukaJoho 更正後) {
        if (isFlexibleDate変更(更正前.get資格取得日(), 更正後.get資格取得日())
                || isFlexibleDate変更(更正前.get資格喪失日(), 更正後.get資格喪失日())) {
            調定事由.add(ChoteiJiyuCode.資格異動による更正.getコード());
        }
        if (isFlexibleDate変更(更正前.get老年開始日(), 更正後.get老年開始日())
                || isFlexibleDate変更(更正前.get老年廃止日(), 更正後.get老年廃止日())) {
            調定事由.add(ChoteiJiyuCode.老齢年金による更正.getコード());
        }
        if (isFlexibleDate変更(更正前.get生保開始日(), 更正後.get生保開始日())
                || isFlexibleDate変更(更正前.get生保廃止日(), 更正後.get生保廃止日())) {
            調定事由.add(ChoteiJiyuCode.生活保護による更正.getコード());
        }
        if (isRString変更(更正前.get課税区分(), 更正後.get課税区分())
                || isRString変更(更正前.get世帯課税区分(), 更正後.get世帯課税区分())
                || is金額変更(更正前.get合計所得金額(), 更正後.get合計所得金額())
                || is金額変更(更正前.get公的年金収入額(), 更正後.get公的年金収入額())) {
            調定事由.add(ChoteiJiyuCode.所得更正による更正.getコード());
        }
        if (is金額減少あり(更正前.get減免額(), 更正後.get減免額())) {
            調定事由.add(ChoteiJiyuCode.減免決定による更正.getコード());
        } else if (is金額減少あり(更正後.get減免額(), 更正前.get減免額())) {
            調定事由.add(ChoteiJiyuCode.減免取消による更正.getコード());
        }
        if (ShokkenKubun.該当.getコード().equals(更正後.get職権区分())) {
            調定事由.add(ChoteiJiyuCode.職権変更.getコード());
        }
        if (isRString変更(更正前.get口座区分(), 更正後.get口座区分())) {
            調定事由.add(ChoteiJiyuCode.口座情報変更.getコード());
        }
        if (ShokkenKubun.該当.getコード().equals(更正前.get境界層区分())
                && ShokkenKubun.非該当.getコード().equals(更正後.get境界層区分())) {
            調定事由.add(ChoteiJiyuCode.境界層該当.getコード());
        } else if (ShokkenKubun.非該当.getコード().equals(更正前.get境界層区分())
                && ShokkenKubun.該当.getコード().equals(更正後.get境界層区分())) {
            調定事由.add(ChoteiJiyuCode.境界層非該当.getコード());
        }
    }

    private void get徴収方法更正(List<RString> 調定事由, ChoshuHoho 徴収方法_更正後, FukaJoho 更正前, FukaJoho 更正後) {
        if (普通徴収.equals(徴収方法_更正後.get徴収方法10月())
                && (特別徴収_厚生労働省.equals(徴収方法_更正後.get徴収方法12月())
                || 特別徴収_地共済.equals(徴収方法_更正後.get徴収方法12月()))
                && 更正後.get特徴期別金額05() != null
                && Decimal.ZERO.compareTo(更正後.get特徴期別金額05()) < 0) {
            調定事由.add(ChoteiJiyuCode.捕捉により特徴開始.getコード());
        } else if (普通徴収.equals(徴収方法_更正後.get徴収方法12月())
                && (特別徴収_厚生労働省.equals(徴収方法_更正後.get徴収方法2月())
                || 特別徴収_地共済.equals(徴収方法_更正後.get徴収方法2月()))
                && 更正後.get特徴期別金額06() != null
                && Decimal.ZERO.compareTo(更正後.get特徴期別金額06()) < 0) {
            調定事由.add(ChoteiJiyuCode.捕捉により特徴開始.getコード());
        }
        if (is特徴期の金額減少あり(更正前, 更正後)) {
            if (ChoteiJiyuCode.年金保険者からの通知.getコード().equals(徴収方法_更正後.get特別徴収停止事由コード())) {
                調定事由.add(ChoteiJiyuCode.年金保険者からの通知.getコード());
            } else if (ChoteiJiyuCode.保険料額の減額変更.getコード().equals(徴収方法_更正後.get特別徴収停止事由コード())) {
                調定事由.add(ChoteiJiyuCode.保険料額の減額変更.getコード());
            }
            if (ShokkenKubun.該当.getコード().equals(更正後.get職権区分())) {
                調定事由.add(ChoteiJiyuCode.職権変更特徴中止.getコード());
            }
            if ((更正前.get資格喪失日() == null || 更正前.get資格喪失日().isEmpty())
                    && 更正後.get資格喪失日() != null && !更正後.get資格喪失日().isEmpty()) {
                調定事由.add(ChoteiJiyuCode.資格喪失特徴中止.getコード());
            }
        }
    }

    private void get異動(List<RString> 調定事由, FukaJoho 更正前, FukaJoho 更正後) {
        if (isFlexibleDate変更(更正前.get資格取得日(), 更正後.get資格取得日())) {
            調定事由.add(更正後.get資格取得事由());
        }
        if (isFlexibleDate変更(更正前.get資格喪失日(), 更正後.get資格喪失日())) {
            調定事由.add(更正後.get資格喪失事由());
        }
        if (isFlexibleDate変更(更正前.get老年開始日(), 更正後.get老年開始日())
                || isFlexibleDate変更(更正前.get老年廃止日(), 更正後.get老年廃止日())
                || isRString変更(更正前.get生活保護扶助種類(), 更正後.get生活保護扶助種類())
                || isFlexibleDate変更(更正前.get生保開始日(), 更正後.get生保開始日())
                || isFlexibleDate変更(更正前.get生保廃止日(), 更正後.get生保廃止日())) {
            調定事由.add(ChoteiJiyuCode.その他資格異動.getコード());
        }
        if (is金額変更(更正前.get合計所得金額(), 更正後.get合計所得金額())
                || is金額変更(更正前.get公的年金収入額(), 更正後.get公的年金収入額())) {
            調定事由.add(ChoteiJiyuCode.所得更正による更正.getコード());
        }
        if (isRString変更(更正前.get口座区分(), 更正後.get口座区分())) {
            調定事由.add(ChoteiJiyuCode.口座情報変更.getコード());
        }
    }

    private boolean is金額変更あり(FukaJoho 更正前, FukaJoho 更正後) {
        return is金額変更(更正前.get減免前介護保険料_年額(), 更正後.get減免前介護保険料_年額())
                || is特徴期別金額変更あり(更正前, 更正後)
                || is普徴期別金額変更あり(更正前, 更正後);
    }

    private boolean is特徴期別金額変更あり(FukaJoho 更正前, FukaJoho 更正後) {
        return is金額変更(更正前.get特徴期別金額01(), 更正後.get特徴期別金額01())
                || is金額変更(更正前.get特徴期別金額02(), 更正後.get特徴期別金額02())
                || is金額変更(更正前.get特徴期別金額03(), 更正後.get特徴期別金額03())
                || is金額変更(更正前.get特徴期別金額04(), 更正後.get特徴期別金額04())
                || is金額変更(更正前.get特徴期別金額05(), 更正後.get特徴期別金額05())
                || is金額変更(更正前.get特徴期別金額06(), 更正後.get特徴期別金額06());
    }

    private boolean is普徴期別金額変更あり(FukaJoho 更正前, FukaJoho 更正後) {
        return is金額変更(更正前.get普徴期別金額01(), 更正後.get普徴期別金額01())
                || is金額変更(更正前.get普徴期別金額02(), 更正後.get普徴期別金額02())
                || is金額変更(更正前.get普徴期別金額03(), 更正後.get普徴期別金額03())
                || is金額変更(更正前.get普徴期別金額04(), 更正後.get普徴期別金額04())
                || is金額変更(更正前.get普徴期別金額05(), 更正後.get普徴期別金額05())
                || is金額変更(更正前.get普徴期別金額06(), 更正後.get普徴期別金額06())
                || is金額変更(更正前.get普徴期別金額07(), 更正後.get普徴期別金額07())
                || is金額変更(更正前.get普徴期別金額08(), 更正後.get普徴期別金額08())
                || is金額変更(更正前.get普徴期別金額09(), 更正後.get普徴期別金額09())
                || is金額変更(更正前.get普徴期別金額10(), 更正後.get普徴期別金額10())
                || is金額変更(更正前.get普徴期別金額11(), 更正後.get普徴期別金額11())
                || is金額変更(更正前.get普徴期別金額12(), 更正後.get普徴期別金額12())
                || is金額変更(更正前.get普徴期別金額13(), 更正後.get普徴期別金額13())
                || is金額変更(更正前.get普徴期別金額14(), 更正後.get普徴期別金額14());
    }

    private boolean is金額変更(Decimal 更正前金額, Decimal 更正後金額) {
        if (更正後金額 != null && !更正後金額.equals(更正前金額)) {
            return true;
        } else if (更正後金額 == null && 更正前金額 != null) {
            return true;
        }
        return false;
    }

    private boolean is特徴期の金額減少あり(FukaJoho 更正前, FukaJoho 更正後) {
        return is金額減少あり(更正前.get特徴期別金額01(), 更正後.get特徴期別金額01())
                || is金額減少あり(更正前.get特徴期別金額02(), 更正後.get特徴期別金額02())
                || is金額減少あり(更正前.get特徴期別金額03(), 更正後.get特徴期別金額03())
                || is金額減少あり(更正前.get特徴期別金額04(), 更正後.get特徴期別金額04())
                || is金額減少あり(更正前.get特徴期別金額05(), 更正後.get特徴期別金額05())
                || is金額減少あり(更正前.get特徴期別金額06(), 更正後.get特徴期別金額06());
    }

    private boolean is金額減少あり(Decimal 更正前金額, Decimal 更正後金額) {
        return 更正前金額 != null && (更正後金額 == null || 更正後金額.compareTo(更正前金額) < 0);
    }

    private FukaJoho set現年度調定事由(List<RString> 調定事由, FukaJoho 更正前, FukaJoho 賦課情報) {
        FukaJohoBuilder builder = 賦課情報.createBuilderForEdit();
        if (調定事由.isEmpty()) {
            if (更正前.get調定事由1() != null) {
                builder.set調定事由1(更正前.get調定事由1());
            }
            if (更正前.get調定事由2() != null) {
                builder.set調定事由2(更正前.get調定事由2());
            }
            if (更正前.get調定事由3() != null) {
                builder.set調定事由3(更正前.get調定事由3());
            }
            if (更正前.get調定事由4() != null) {
                builder.set調定事由4(更正前.get調定事由4());
            }
        } else if (調定事由.size() == INT_1) {
            builder.set調定事由1(調定事由.get(0));
        } else if (調定事由.size() == INT_2) {
            builder.set調定事由1(調定事由.get(0))
                    .set調定事由2(調定事由.get(INT_1));
        } else if (調定事由.size() == INT_3) {
            builder.set調定事由1(調定事由.get(0))
                    .set調定事由2(調定事由.get(INT_1))
                    .set調定事由3(調定事由.get(INT_2));
        } else {
            builder.set調定事由1(調定事由.get(0))
                    .set調定事由2(調定事由.get(INT_1))
                    .set調定事由3(調定事由.get(INT_2))
                    .set調定事由4(調定事由.get(INT_3));
        }
        賦課情報 = builder.build();
        return 賦課情報;
    }

    private FukaJoho set過年度調定事由(List<RString> 調定事由, FukaJoho 賦課情報) {
        FukaJohoBuilder builder = 賦課情報.createBuilderForEdit();
        builder.set調定事由1(ChoteiJiyuCode.過年度更正.getコード());
        if (調定事由.isEmpty()) {
            賦課情報 = builder.build();
            return 賦課情報;
        } else if (調定事由.size() == INT_1) {
            builder.set調定事由2(調定事由.get(0));
        } else if (調定事由.size() == INT_2) {
            builder.set調定事由2(調定事由.get(0))
                    .set調定事由3(調定事由.get(INT_1));
        } else {
            builder.set調定事由2(調定事由.get(0))
                    .set調定事由3(調定事由.get(INT_1))
                    .set調定事由4(調定事由.get(INT_2));
        }
        賦課情報 = builder.build();
        return 賦課情報;
    }

    private boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isRString変更(RString 更正前, RString 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }
}
