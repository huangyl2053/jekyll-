/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.FutanWariaiHanteiRelateEntity;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.HanteiKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KoseiJiyuType;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMNK1002_利用者負担割合判定（共通）のクラスです。 <br/>
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
public class RiyoshaFutanWariaiHantei {

    private static final RString LINE = new RString("|");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString なし = new RString("00");
    private static final RString 課税区分未申告 = new RString("3");
    private static final RString 課税区分所得調査中 = new RString("4");
    private static final RString 課税区分非課税 = new RString("2");

    private static final Integer NUM2 = 2;
    private static final Integer 西暦年の長さ = 4;
    private static final Integer 西暦年月の長さ = 6;
    private static final Integer NUM一月 = 1;
    private static final Integer NUM七月 = 7;
    private static final Integer NUM八月 = 8;
    private static final Integer NUM十二月 = 12;
    private static final Integer NUM三十一日 = 31;

    private static final RString 年のパターン = new RString("0000");
    private static final RString 月のパターン = new RString("00");
    private static final RString 八月 = new RString("08");
    private static final RString 九月 = new RString("09");
    private static final RString 十月 = new RString("10");
    private static final RString 十一月 = new RString("11");
    private static final RString 十二月 = new RString("12");
    private static final RString 一月 = new RString("01");
    private static final RString 二月 = new RString("02");
    private static final RString 三月 = new RString("03");
    private static final RString 四月 = new RString("04");
    private static final RString 五月 = new RString("05");
    private static final RString 六月 = new RString("06");
    private static final RString 七月 = new RString("07");
    private static final RString 一日 = new RString("01");
    private static final RString 二十八日 = new RString("28");
    private static final RString 二十九日 = new RString("29");
    private static final RString 三十日 = new RString("30");
    private static final RString 三十一日 = new RString("31");

    private static final RString 基準日がNULL = new RString("基準日がnullです。");
    private static final RString 負担割合判定情報がNULL = new RString("負担割合判定情報がnullです。");
    private static final RString 年度がNULL = new RString("年度がnullです。");

    /**
     * createInstanceのメソドです。
     *
     * @return RiyoshaFutanWariaiHantei
     */
    public static RiyoshaFutanWariaiHantei createInstance() {
        return InstanceProvider.create(RiyoshaFutanWariaiHantei.class);
    }

    /**
     * 負担割合判定。
     *
     * @param 負担割合判定情報 FutanWariaiHanteiRelateEntity
     * @return FutanWariaiHanteiResult 負担割合判定結果
     * @throws NullPointerException
     */
    public FutanWariaiHanteiResult futanWariaiHantei(FutanWariaiHanteiRelateEntity 負担割合判定情報) {
        if (負担割合判定情報 == null) {
            throw new NullPointerException(負担割合判定情報がNULL.toString());
        }
        FutanWariaiHanteiResult 負担割合判定結果 = new FutanWariaiHanteiResult();
        HanteiTaishoshaTempEntity 判定対象者Temp = 負担割合判定情報.get判定対象者Temp();
        SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp = 負担割合判定情報.get生活保護該当情報Temp();
        List<SetaiinShotoku> 介護所得情報 = 負担割合判定情報.get介護所得情報();
        FlexibleDate 判定基準日 = 負担割合判定情報.get判定基準日();
        FlexibleYearMonth 判定基準日の年月 = 判定基準日 == null ? null : 判定基準日.getYearMonth();
        FlexibleDate 認定有効期間開始年月日 = 判定対象者Temp == null ? null
                : 判定対象者Temp.getNinteiYukoKaishiDate();
        FlexibleYearMonth 認定有効期間開始年月 = 認定有効期間開始年月日 == null ? null
                : 認定有効期間開始年月日.getYearMonth();
        if (判定基準日の年月 != null && 認定有効期間開始年月 != null && 判定基準日の年月.isBefore(認定有効期間開始年月)) {
            負担割合判定結果.set負担割合区分(なし);
            負担割合判定結果.set判定区分(HanteiKubunType.対象外.code());
            return 負担割合判定結果;
        }
        if (判定対象者Temp != null && TWO.equals(判定対象者Temp.getHihokenshaKubunCode())) {
            負担割合判定結果.set負担割合区分(FutanwariaiKubun._１割.getコード());
            負担割合判定結果.set判定区分(HanteiKubunType.第２号被保険者.code());
            return 負担割合判定結果;
        }
        if (生活保護該当情報Temp != null && RString.isNullOrEmpty(生活保護該当情報Temp.getShikibetsuCode())) {
            負担割合判定結果.set負担割合区分(FutanwariaiKubun._１割.getコード());
            負担割合判定結果.set判定区分(HanteiKubunType.生活保護.code());
            return 負担割合判定結果;
        }
        if (判定対象者Temp != null && 判定対象者Temp.isKyuSochishaFlag()) {
            負担割合判定結果.set負担割合区分(FutanwariaiKubun._１割.getコード());
            負担割合判定結果.set判定区分(HanteiKubunType.旧措置.code());
            return 負担割合判定結果;
        }
        負担割合判定結果 = 課税区分負担割合判定(判定対象者Temp);
        if (負担割合判定結果 != null) {
            return 負担割合判定結果;
        }
        Decimal 合計所得金額 = noMinusDecimal(負担割合判定情報.get判定対象者Temp().getGokeiShotokuGaku());
        Decimal 年金収入 = get公的年金収入額世帯員分の合計(介護所得情報);
        Decimal その他の合計所得金額 = getその他の合計所得金額世帯員分の合計(介護所得情報);
        int 世帯員数 = 介護所得情報.size();
        RString 負担割合区分 = getFutanWariaiKubun(合計所得金額, 年金収入, その他の合計所得金額, 世帯員数);
        負担割合判定結果 = new FutanWariaiHanteiResult();
        負担割合判定結果.set負担割合区分(負担割合区分);
        負担割合判定結果.set判定区分(HanteiKubunType.負担割合判定.code());
        return 負担割合判定結果;
    }

    private Decimal get公的年金収入額世帯員分の合計(List<SetaiinShotoku> 介護所得情報リスト) {
        Decimal sum = Decimal.ZERO;
        for (SetaiinShotoku 介護所得情報 : 介護所得情報リスト) {
            sum.add(介護所得情報.get年金収入額());
        }
        return sum;
    }

    private Decimal getその他の合計所得金額世帯員分の合計(List<SetaiinShotoku> 介護所得情報リスト) {
        Decimal sum = Decimal.ZERO;
        for (SetaiinShotoku 介護所得情報 : 介護所得情報リスト) {
            sum.add(noMinusDecimal(nonullSubstract(介護所得情報.get合計所得金額(),
                    介護所得情報.get年金所得額())));
        }
        return sum;
    }

    private FutanWariaiHanteiResult 課税区分負担割合判定(HanteiTaishoshaTempEntity 判定対象者Temp) {
        if (判定対象者Temp == null) {
            return null;
        }
        RDate now = RDate.getNowDate();
        RString 課税区分 = 判定対象者Temp.getKazeiKubun();
        FutanWariaiHanteiResult 負担割合判定結果 = new FutanWariaiHanteiResult();
        if (RString.isNullOrEmpty(課税区分)) {
            負担割合判定結果.set負担割合区分(FutanwariaiKubun._１割.getコード());
            負担割合判定結果.set判定区分(HanteiKubunType.非課税.code());
        } else if (課税区分未申告.equals(課税区分)) {
            RString 本人未申告区分 = BusinessConfig.get(ConfigNameDBC.利用者負担割合判定基準_本人未申告区分,
                    now, SubGyomuCode.DBC介護給付);
            if (ONE.equals(本人未申告区分)) {
                負担割合判定結果.set負担割合区分(FutanwariaiKubun._１割.getコード());
            }
            if (TWO.equals(本人未申告区分)) {
                負担割合判定結果.set負担割合区分(FutanwariaiKubun._２割.getコード());
            }
            負担割合判定結果.set判定区分(HanteiKubunType.非課税.code());
        } else if (課税区分所得調査中.equals(課税区分)) {
            RString 本人所得調査中区分 = BusinessConfig.get(ConfigNameDBC.利用者負担割合判定基準_本人所得調査中区分,
                    now, SubGyomuCode.DBC介護給付);
            if (ONE.equals(本人所得調査中区分)) {
                負担割合判定結果.set負担割合区分(FutanwariaiKubun._１割.getコード());
            }
            if (TWO.equals(本人所得調査中区分)) {
                負担割合判定結果.set負担割合区分(FutanwariaiKubun._２割.getコード());
            }
            負担割合判定結果.set判定区分(HanteiKubunType.非課税.code());
        } else if (課税区分非課税.equals(課税区分)) {
            負担割合判定結果.set負担割合区分(FutanwariaiKubun._１割.getコード());
            負担割合判定結果.set判定区分(HanteiKubunType.非課税.code());
        } else {
            負担割合判定結果 = null;
        }
        return 負担割合判定結果;
    }

    private Decimal rstringToDecimal(RString rstr) {
        if (RString.isNullOrEmpty(rstr)) {
            return Decimal.ZERO;
        }
        return new Decimal(rstr.toString().trim());
    }

    /**
     * 負担割合区分取得。
     *
     * @param 合計所得金額 合計所得金額 nullまたマイナス値の場合は0として扱う。
     * @param 年金収入 年金収入
     * @param その他の合計所得金額 その他の合計所得金額
     * @param 世帯員数 世帯員数
     * @return 負担割合区分[10:１割、20:２割]
     */
    public RString getFutanWariaiKubun(Decimal 合計所得金額, Decimal 年金収入, Decimal その他の合計所得金額, int 世帯員数) {
        if (合計所得金額 == null || 年金収入 == null || その他の合計所得金額 == null) {
            return null;
        }
        RDate now = RDate.getNowDate();
        Decimal 本人合計所得金額基準 = rstringToDecimal(BusinessConfig.get(
                ConfigNameDBC.利用者負担割合判定基準_本人合計所得金額基準,
                now, SubGyomuCode.DBC介護給付));
        Decimal 世帯年金収入等基準単身 = rstringToDecimal(BusinessConfig.get(
                ConfigNameDBC.利用者負担割合判定基準_世帯年金収入等基準単身,
                now, SubGyomuCode.DBC介護給付));
        Decimal 世帯年金収入等基準複数 = rstringToDecimal(BusinessConfig.get(
                ConfigNameDBC.利用者負担割合判定基準_世帯年金収入等基準複数,
                now, SubGyomuCode.DBC介護給付));
        Decimal 合計所得金額Temp = noMinusDecimal(合計所得金額);
        Decimal その他の合計所得金額Temp = noMinusDecimal(その他の合計所得金額);
        Decimal 合計Temp = 年金収入.add(その他の合計所得金額Temp);
        if (合計所得金額Temp.compareTo(本人合計所得金額基準) < 0) {
            return FutanwariaiKubun._１割.getコード();
        }
        if (世帯員数 == 1) {
            if (合計Temp.compareTo(世帯年金収入等基準単身) < 0) {
                return FutanwariaiKubun._１割.getコード();
            } else {
                return FutanwariaiKubun._２割.getコード();
            }
        }
        if (世帯員数 >= NUM2) {
            if (合計Temp.compareTo(世帯年金収入等基準複数) < 0) {
                return FutanwariaiKubun._１割.getコード();
            } else {
                return FutanwariaiKubun._２割.getコード();
            }
        }
        return null;
    }

    private Decimal noMinusDecimal(Decimal decimal) {
        if (decimal.compareTo(Decimal.ZERO) < 0) {
            return Decimal.ZERO;
        }
        return decimal;
    }

    /**
     * 対象月の初期化
     *
     * @return List<RString>
     */
    public List<RString> initializeTaishoGetsu() {
        List<RString> taishoGetsu = new ArrayList<>();
        for (int month = NUM八月; month <= NUM十二月; month++) {
            taishoGetsu.add(対象月の取得(month));
        }
        for (int month = NUM一月; month <= NUM七月; month++) {
            taishoGetsu.add(対象月の取得(month));
        }
        return taishoGetsu;
    }

    /**
     * 判定基準日取得。
     *
     * @param 基準日 ※YYYYMMDD
     * @return 判定基準日リスト※YYYYMMDD
     * @throws NullPointerException
     */
    public List<RString> getHanteiKijunbi(RString 基準日) {
        if (基準日 == null) {
            throw new NullPointerException(基準日がNULL.toString());
        }
        List<RString> 判定基準日リスト = new ArrayList<>();
        Integer 年度 = 年度の設定(基準日);
        RString 基準日の年月 = 基準日.substring(0, 西暦年月の長さ);
        for (int month = NUM八月; month <= NUM十二月; month++) {
            判定基準日リスト.add(判定基準年月日の取得(年度, month, 基準日の年月));
        }
        for (int month = NUM一月; month <= NUM七月; month++) {
            判定基準日リスト.add(判定基準年月日の取得(年度 + 1, month, 基準日の年月));
        }
        return 判定基準日リスト;
    }

    private int 年度の設定(RString 基準日) {
        int 基準日の年 = Integer.parseInt(基準日.substring(0, 西暦年の長さ).toString());
        int 基準日の月 = Integer.parseInt(基準日.substring(西暦年の長さ, 西暦年月の長さ).toString());
        if (基準日の月 >= NUM八月 && 基準日の月 <= NUM十二月) {
            return 基準日の年;
        }
        return 基準日の年 - 1;
    }

    private RString 判定基準年月日の取得(int 対象年, int 対象月, RString 基準日の年月) {
        RString 対象年月 = new RString(new Decimal(対象年).toString(年のパターン.toString()))
                .concat(new RString(new Decimal(対象月).toString(月のパターン.toString())));
        if (対象年月.equals(基準日の年月)) {
            return RString.EMPTY;
        }
        return 対象年月.concat(一日);
    }

    private RString 対象月の取得(int 対象月) {
        if (対象月 < NUM一月 && 対象月 > NUM十二月) {
            return RString.EMPTY;
        }
        return new RString(new Decimal(対象月).toString(月のパターン.toString()));
    }

    /**
     * 8月から7月の対象開始日をListで取得する。
     *
     * @param 年度 年度
     * @return 8月から7月の対象開始日のリスト
     * @throws NullPointerException
     */
    public List<RString> getTaishoKaishibi(RYear 年度) {
        if (年度 == null) {
            throw new NullPointerException(年度がNULL.toString());
        }
        RString 今年 = 年度.toDateString();
        RString 来年 = 年度.plusYear(1).toDateString();
        List<RString> 対象開始日リスト = new ArrayList<>();
        対象開始日リスト.add(今年.concat(八月).concat(一日));
        対象開始日リスト.add(今年.concat(九月).concat(一日));
        対象開始日リスト.add(今年.concat(十月).concat(一日));
        対象開始日リスト.add(今年.concat(十一月).concat(一日));
        対象開始日リスト.add(今年.concat(十二月).concat(一日));
        対象開始日リスト.add(来年.concat(一月).concat(一日));
        対象開始日リスト.add(来年.concat(二月).concat(一日));
        対象開始日リスト.add(来年.concat(三月).concat(一日));
        対象開始日リスト.add(来年.concat(四月).concat(一日));
        対象開始日リスト.add(来年.concat(五月).concat(一日));
        対象開始日リスト.add(来年.concat(六月).concat(一日));
        対象開始日リスト.add(来年.concat(七月).concat(一日));
        return 対象開始日リスト;
    }

    /**
     * 8月から7月の対象終了日をListで取得する。
     *
     * @param 年度 年度
     * @return 8月から7月の対象終了日のリスト
     * @throws NullPointerException
     */
    public List<RString> getTaishoShuryobi(RYear 年度) {
        if (年度 == null) {
            throw new NullPointerException(年度がNULL.toString());
        }
        RString 今年 = 年度.toDateString();
        RString 来年 = 年度.plusYear(1).toDateString();
        List<RString> 対象終了日リスト = new ArrayList<>();
        対象終了日リスト.add(今年.concat(八月).concat(三十一日));
        対象終了日リスト.add(今年.concat(九月).concat(三十日));
        対象終了日リスト.add(今年.concat(十月).concat(三十一日));
        対象終了日リスト.add(今年.concat(十一月).concat(三十日));
        対象終了日リスト.add(今年.concat(十二月).concat(三十一日));
        対象終了日リスト.add(来年.concat(一月).concat(三十一日));
        if (年度.isLeapYear()) {
            対象終了日リスト.add(来年.concat(二月).concat(二十九日));
        } else {
            対象終了日リスト.add(来年.concat(二月).concat(二十八日));
        }
        対象終了日リスト.add(来年.concat(三月).concat(三十一日));
        対象終了日リスト.add(来年.concat(四月).concat(三十日));
        対象終了日リスト.add(来年.concat(五月).concat(三十一日));
        対象終了日リスト.add(来年.concat(六月).concat(三十日));
        対象終了日リスト.add(来年.concat(七月).concat(三十一日));
        return 対象終了日リスト;
    }

    /**
     * 負担割合判定マージ
     *
     * @param 利用者負担割合明細情報 List<RiyoshaFutanWariaiMeisaiEntity>
     * @param 対象年度 FlexibleYear
     * @return List<RiyoshaFutanWariaiMeisaiEntity>
     * @throws NullPointerException
     */
    public List<RiyoshaFutanWariaiMeisaiTempEntity> futanWariaiHanteiMerge(
            List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細情報, FlexibleYear 対象年度) {
        if (利用者負担割合明細情報 == null || 対象年度 == null) {
            throw new NullPointerException();
        }
        List<RiyoshaFutanWariaiMeisaiTempEntity> result = new ArrayList<>();
        List<Boolean> flags = new ArrayList<>();
        int oldSize = 利用者負担割合明細情報.size();
        for (int i = 0; i < oldSize; i++) {
            flags.add(Boolean.TRUE);
        }
        RString keyi;
        RString keyj;
        for (int i = 0; i < oldSize; i++) {
            if (!flags.get(i)) {
                continue;
            }
            keyi = getKey利用者負担割合明細情報(利用者負担割合明細情報.get(i));
            for (int j = i + 1; j < oldSize; j++) {
                keyj = getKey利用者負担割合明細情報(利用者負担割合明細情報.get(j));
                if (keyi.equals(keyj)) {
                    flags.set(j, Boolean.FALSE);
                }
            }
        }
        for (int i = 0; i < oldSize; i++) {
            if (flags.get(i)) {
                result.add(利用者負担割合明細情報.get(i));
            }
        }
        int newSize = result.size();
        for (int i = 0; i < newSize; i++) {
            result.get(i).setEdaNo(i + 1);
        }
        RiyoshaFutanWariaiMeisaiTempEntity before = null;
        RString beforeKubn = null;
        RString nowKubun;
        RString 現判定区分;
        RString 前判定区分 = null;
        for (RiyoshaFutanWariaiMeisaiTempEntity now : result) {
            if (before == null) {
                before = now.clone();
                beforeKubn = before.getFutanWariaiKubun();
                前判定区分 = before.getHanteiKubun();
                continue;
            }
            before.setYukoShuryoYMD(now.getYukoKaishiYMD().minusDay(1));
            nowKubun = now.getFutanWariaiKubun();
            現判定区分 = now.getHanteiKubun();
            if (!equalsRString(nowKubun, beforeKubn)) {
                負担割合判定マージ(前判定区分, 現判定区分, now, 対象年度, before);

            } else {
                now.setKoseiJiyu(before.getKoseiJiyu());
                now.setYukoKaishiYMD(before.getYukoKaishiYMD());
            }
        }
        result.get(result.size() - 1).setYukoShuryoYMD(new FlexibleDate(対象年度.getYearValue() + 1, NUM七月, NUM三十一日));
        return result;
    }

    private void 負担割合判定マージ(RString 前判定区分, RString 現判定区分, RiyoshaFutanWariaiMeisaiTempEntity now,
            FlexibleYear 対象年度, RiyoshaFutanWariaiMeisaiTempEntity before) {
        if (HanteiKubunType.対象外.code().equals(前判定区分)
                && Arrays.asList(HanteiKubunType.values()).contains(HanteiKubunType.toValue(現判定区分))
                && !HanteiKubunType.対象外.code().equals(現判定区分)) {
            now.setKoseiJiyu(KoseiJiyuType.当初_継続_新規認定.getコード());
            now.setYukoKaishiYMD(now.getNinteiYukoKaishiDate());
        }
        if (HanteiKubunType.非課税.code().equals(現判定区分)
                && HanteiKubunType.負担割合判定.code().equals(前判定区分)) {
            now.setKoseiJiyu(KoseiJiyuType.本人所得更正.getコード());
            now.setYukoKaishiYMD(get有効開始日１(対象年度, now.getNinteiYukoKaishiDate()));
        }
        if (HanteiKubunType.負担割合判定.code().equals(現判定区分)
                && (HanteiKubunType.第２号被保険者.code().equals(前判定区分)
                || HanteiKubunType.負担割合判定.code().equals(前判定区分))) {
            handle数額変更(now, before, 対象年度);
        }
        if (HanteiKubunType.負担割合判定.code().equals(現判定区分)
                && HanteiKubunType.生活保護.code().equals(前判定区分)) {
            now.setKoseiJiyu(KoseiJiyuType.その他.getコード());
            FlexibleDate 受給廃止日 = now.getJukyuHaishiYMD();
            if (受給廃止日 != null) {
                now.setYukoKaishiYMD(new FlexibleDate(受給廃止日.getYearValue(), 受給廃止日.getMonthValue() + 1, 1));
            }
        }
        if (HanteiKubunType.負担割合判定.code().equals(現判定区分)
                && HanteiKubunType.旧措置.code().equals(前判定区分)) {
            now.setKoseiJiyu(KoseiJiyuType.本人所得更正.getコード());
            now.setYukoKaishiYMD(get有効開始日１(対象年度, now.getNinteiYukoKaishiDate()));
        }
        if (HanteiKubunType.負担割合判定.code().equals(現判定区分)
                && HanteiKubunType.非課税.code().equals(前判定区分)) {
            now.setKoseiJiyu(KoseiJiyuType.その他.getコード());
            now.setYukoKaishiYMD(get有効開始日１(対象年度, now.getNinteiYukoKaishiDate()));
        }
    }

    private void handle数額変更(RiyoshaFutanWariaiMeisaiTempEntity now, RiyoshaFutanWariaiMeisaiTempEntity before,
            FlexibleYear 対象年度) {
        if (now == null || before == null || 対象年度 == null) {
            return;
        }
        if (!equalsDecimal(now.getHonninGoukeiShotokuGaku(), before.getHonninGoukeiShotokuGaku())) {
            now.setKoseiJiyu(KoseiJiyuType.本人所得更正.getコード());
            now.setYukoKaishiYMD(get有効開始日１(対象年度, now.getNinteiYukoKaishiDate()));
        }
        if (!equalsDecimal(now.getNenkinShunyuGoukei(), before.getNenkinShunyuGoukei())
                && (!equalsDecimal(now.getSonotanoGoukeiShotokuKingakuGoukei(),
                        before.getSonotanoGoukeiShotokuKingakuGoukei()))) {
            now.setKoseiJiyu(KoseiJiyuType.世帯員所得更正.getコード());
            now.setYukoKaishiYMD(get有効開始日１(対象年度, now.getNinteiYukoKaishiDate()));
        }
        if (!equalsInteger(now.getSetaiIchigouHihokenshaSu(), before.getSetaiIchigouHihokenshaSu())) {
            now.setKoseiJiyu(KoseiJiyuType.世帯構成変更.getコード());
            now.setYukoKaishiYMD(get有効開始日２(対象年度, now.getAtenaIdobi()));
        }
    }

    private FlexibleDate get有効開始日１(FlexibleYear 対象年度, FlexibleDate 認定有効開始日) {
        if (対象年度 == null || 認定有効開始日 == null) {
            return null;
        }
        FlexibleDate date = new FlexibleDate(対象年度.getYearValue(), NUM八月, 1);
        if (date.isBefore(認定有効開始日)) {
            return 認定有効開始日;
        }
        return date;
    }

    private FlexibleDate get有効開始日２(FlexibleYear 対象年度, FlexibleDate 宛名異動年月日) {
        if (対象年度 == null || 宛名異動年月日 == null) {
            return null;
        }
        FlexibleDate date = new FlexibleDate(対象年度.getYearValue(), NUM八月, 1);
        if (date.isBeforeOrEquals(宛名異動年月日)) {
            if (宛名異動年月日.getDayValue() == 1) {

                return 宛名異動年月日;
            } else {
                FlexibleDate 翌月Date = 宛名異動年月日.plusMonth(1);
                return new FlexibleDate(翌月Date.getYearValue(), 翌月Date.getMonthValue(), 1);
            }
        }
        return date;
    }

    private Decimal nonullSubstract(Decimal d1, Decimal d2) {
        return nonullDecimal(d1).subtract(nonullDecimal(d2));
    }

    private boolean equalsRString(RString r1, RString r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if ((r1 != null && r2 == null) || (r1 == null && r2 != null)) {
            return false;
        }
        return r1 != null && r1.equals(r2);
    }

    private boolean equalsDecimal(Decimal d1, Decimal d2) {
        return nonullDecimal(d1).equals(nonullDecimal(d2));
    }

    private boolean equalsInteger(Integer i1, Integer i2) {
        return nonullInteger(i1).equals(nonullInteger(i2));
    }

    private RString getKey利用者負担割合明細情報(RiyoshaFutanWariaiMeisaiTempEntity entity) {
        if (entity == null) {
            return RString.EMPTY;
        }
        return nonullRStr(entity.getFutanWariaiKubun())
                .concat(LINE).concat(nonullRStr(entity.getHonninGoukeiShotokuGaku()))
                .concat(LINE).concat(nonullRStr(entity.getSetaiIchigouHihokenshaSu()))
                .concat(LINE).concat(nonullRStr(entity.getNenkinShunyuGoukei()))
                .concat(LINE).concat(nonullRStr(entity.getSonotanoGoukeiShotokuKingakuGoukei()));
    }

    private RString nonullRStr(RString rstr) {
        if (rstr == null) {
            return RString.EMPTY;
        }
        return rstr;
    }

    private RString nonullRStr(Decimal dec) {
        if (dec == null) {
            return RString.EMPTY;
        }
        return new RString(dec.toString());
    }

    private RString nonullRStr(Integer integer) {
        if (integer == null) {
            return RString.EMPTY;
        }
        return new RString(integer);
    }

    private Decimal nonullDecimal(Decimal dec) {
        if (dec == null) {
            return Decimal.ZERO;
        }
        return dec;
    }

    private Integer nonullInteger(Integer integer) {
        if (integer == null) {
            return 0;
        }
        return integer;
    }

    /**
     * 利用者負担割合明細マージ
     *
     * @param 入力明細リスト List<DbT3114RiyoshaFutanWariaiMeisaiEntity>
     * @return List<DbT3114RiyoshaFutanWariaiMeisaiEntity>
     * @throws NullPointerException
     */
    public List<DbT3114RiyoshaFutanWariaiMeisaiEntity> riyoshaFutanWariaiMeisaiMerge(
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 入力明細リスト) {
        if (入力明細リスト == null) {
            throw new NullPointerException();
        }
        RString nowKubun;
        DbT3114RiyoshaFutanWariaiMeisaiEntity beforeEntity = null;
        RString beforeKubun = null;
        FlexibleDate 有効開始日 = null;
        DbT3114RiyoshaFutanWariaiMeisaiEntity result;
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> resultList = new ArrayList<>();
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity 入力明細 : 入力明細リスト) {
            nowKubun = 入力明細.getFutanWariaiKubun();
            if (beforeEntity == null) {
                beforeEntity = 入力明細;
                beforeKubun = nowKubun;
                有効開始日 = 入力明細.getYukoKaishiYMD();
                continue;
            }
            if (beforeKubun != null && beforeKubun.equals(nowKubun)) {
                beforeEntity = 入力明細;
            } else if (beforeKubun != null && !beforeKubun.equals(nowKubun)) {
                result = beforeEntity.clone();
                result.setYukoKaishiYMD(有効開始日);
                resultList.add(result);
                有効開始日 = 入力明細.getYukoKaishiYMD();
                beforeEntity = 入力明細;
            }
        }
        return resultList;
    }
}
