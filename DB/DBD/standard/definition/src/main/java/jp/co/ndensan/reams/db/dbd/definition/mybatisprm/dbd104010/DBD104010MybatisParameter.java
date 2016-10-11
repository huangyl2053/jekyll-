/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd104010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.JukyushaGenmenJissijokyo.NinteijokyohyoKijyunbiKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.hyojunfutangakugemmen.GengakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者減免実施状況のMybatisパラメータクラスです。
 *
 * @reamsid_L DBD-3770-060 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD104010MybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private IShikibetsuTaishoPSMSearchKey searchKey;
    private FlexibleDate 抽出期間開始日;
    private FlexibleDate 抽出期間終了日;
    private AtenaSelectBatchParameter 宛名抽出条件;
    private RString 基準日区分;
    private RString 基準日;

    private boolean 宛名生年月日1;
    private boolean 宛名生年月日2;
    private boolean 宛名生年月日3;
    private boolean 宛名生年月日4;
    private boolean 直近被保;
    private boolean 基準日flag;
    private FlexibleDate 年齢基準日from;
    private FlexibleDate 年齢基準日to;
    private FlexibleDate 生年月日from;
    private FlexibleDate 生年月日to;
    private FlexibleYear 対象年度;
    private LasdecCode 市町村コード;

    private final RString 年齢 = new RString("年齢");
    private final RString 生年月日 = new RString("生年月日");
    private final RString 全て = new RString("全て");
    private final RString 月2 = new RString("02");
    private final RString 月4 = new RString("04");
    private final RString 月6 = new RString("06");
    private final RString 月9 = new RString("09");
    private final RString 月11 = new RString("11");
    private final RString 基準日区分_基準日 = NinteijokyohyoKijyunbiKubun.基準日.getコード();

    private FlexibleDate date2;
    private FlexibleDate date4;
    private FlexibleDate date6;
    private FlexibleDate date9;
    private FlexibleDate date11;

    private final RString 法別区分施行時ホームヘルプ = HobetsuKubun.施行時ホームヘルプ.getコード();

    private final RString 決定区分承認する = KetteiKubun.承認する.getコード();
    private final RString 決定区分承認しない = KetteiKubun.承認しない.getコード();

    private final RString 旧措置者区分旧措置者実質的負担軽減者 = KyuSochishaKubun.旧措置者実質的負担軽減者.getコード();
    private final RString 旧措置者区分旧措置者 = KyuSochishaKubun.旧措置者.getコード();
    private final RString 旧措置者区分非該当 = KyuSochishaKubun.非該当.getコード();

    private final RString 減額区分_市町村民税非課税 = GengakuKubun.市町村民税非課税.getコード();
    private final RString 減額区分_老齢福祉年金受給 = GengakuKubun.老齢福祉年金受給.getコード();

    private final RString 利用者負担段階1 = RiyoshaFutanDankai.第一段階.getコード();
    private final RString 利用者負担段階2 = RiyoshaFutanDankai.第二段階.getコード();
    private final RString 利用者負担段階3 = RiyoshaFutanDankai.第三段階.getコード();
    private final RString 利用者負担段階4 = RiyoshaFutanDankai.第四段階.getコード();
    private final RString 利用者負担段階_課税層 = RiyoshaFutanDankai.課税層第三段階.getコード();

    private RString 基準日付2;
    private RString 基準日付4;
    private RString 基準日付6;
    private RString 基準日付9;
    private RString 基準日付11;

    /**
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 抽出期間開始日 FlexibleDate
     * @param 抽出期間終了日 FlexibleDate
     * @param 基準日区分 RString
     * @param 宛名抽出条件 AtenaSelectBatchParameter
     * @param 基準日 RString
     * @param 対象年度 FlexibleYear
     */
    public DBD104010MybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey, FlexibleDate 抽出期間開始日,
            FlexibleDate 抽出期間終了日, RString 基準日区分, RString 基準日, AtenaSelectBatchParameter 宛名抽出条件, FlexibleYear 対象年度) {
        super(searchKey);
        this.抽出期間開始日 = 抽出期間開始日;
        this.抽出期間終了日 = 抽出期間終了日;
        this.基準日区分 = 基準日区分;
        this.宛名抽出条件 = 宛名抽出条件;
        this.基準日 = 基準日;
        this.対象年度 = 対象年度;
        this.市町村コード = 宛名抽出条件.getShichoson_Code();
        set宛名生年月日(宛名抽出条件);
        set直近被保(宛名抽出条件);
        set年齢基準日の対応日(宛名抽出条件);
        set生年月日の対応日(宛名抽出条件);
        set基準日付(対象年度, 基準日);
        this.基準日flag = 基準日区分_基準日.equals(基準日区分);
    }

    private void set宛名生年月日(AtenaSelectBatchParameter 宛名抽出条件) {
        宛名生年月日1 = false;
        宛名生年月日2 = false;
        宛名生年月日3 = false;
        宛名生年月日4 = false;
        if (年齢.equals(宛名抽出条件.getAgeSelectKijun().get名称()) && !宛名抽出条件.getNenreiKijunbi().toDateString().isEmpty()) {
            if (!宛名抽出条件.getNenreiRange().getFrom().toString().isEmpty()) {
                宛名生年月日1 = true;
            }
            if (!宛名抽出条件.getNenreiRange().getTo().toString().isEmpty()) {
                宛名生年月日2 = true;
            }
        } else if (生年月日.equals(宛名抽出条件.getAgeSelectKijun().get名称())) {
            if (!宛名抽出条件.getSeinengappiRange().getFrom().toDateString().isEmpty()) {
                宛名生年月日3 = true;
            }
            if (!宛名抽出条件.getSeinengappiRange().getTo().toDateString().isEmpty()) {
                宛名生年月日4 = true;
            }
        }
    }

    private void set直近被保(AtenaSelectBatchParameter 宛名抽出条件) {
        直近被保 = !全て.equals(宛名抽出条件.getShichoson_Code().value()) && !宛名抽出条件.getShichoson_Code().isEmpty();
    }

    private void set年齢基準日の対応日(AtenaSelectBatchParameter 宛名抽出条件) {
        年齢基準日from = new FlexibleDate(宛名抽出条件.getNenreiKijunbi().minusYear(宛名抽出条件.getNenreiRange().getFrom().intValue()).toDateString());
        年齢基準日to = new FlexibleDate(宛名抽出条件.getNenreiKijunbi().minusYear(宛名抽出条件.getNenreiRange().getTo().intValue()).toDateString());
    }

    private void set生年月日の対応日(AtenaSelectBatchParameter 宛名抽出条件) {
        生年月日from = new FlexibleDate(宛名抽出条件.getSeinengappiRange().getFrom().toDateString());
        生年月日to = new FlexibleDate(宛名抽出条件.getSeinengappiRange().getTo().toDateString());
    }

    private void set基準日付(FlexibleYear 対象年度, RString 基準日) {

        if (基準日 != null) {
            date2 = new FlexibleDate(対象年度.plusYear(1).toDateString().concat(月2).concat(基準日));
            date4 = new FlexibleDate(対象年度.plusYear(1).toDateString().concat(月4).concat(基準日));
            date6 = new FlexibleDate(対象年度.toDateString().concat(月6).concat(基準日));
            date9 = new FlexibleDate(対象年度.toDateString().concat(月9).concat(基準日));
            date11 = new FlexibleDate(対象年度.toDateString().concat(月11).concat(基準日));
        } else {
            date2 = FlexibleDate.EMPTY;
            date4 = FlexibleDate.EMPTY;
            date6 = FlexibleDate.EMPTY;
            date9 = FlexibleDate.EMPTY;
            date11 = FlexibleDate.EMPTY;
        }
        if (date2.isValid()) {
            基準日付2 = new RString(date2.getDayValue());
        } else {
            FlexibleYearMonth 年度2 = new FlexibleYearMonth(対象年度.plusYear(1).toDateString().concat(月2));
            基準日付2 = new RString(年度2.getLastDay());
        }
        if (date4.isValid()) {
            基準日付4 = new RString(date4.getDayValue());
        } else {
            基準日付4 = new RString(date4.getYearMonth().getLastDay());
        }
        if (date6.isValid()) {
            基準日付6 = new RString(date6.getDayValue());
        } else {
            基準日付6 = new RString(date6.getYearMonth().getLastDay());
        }
        if (date9.isValid()) {
            基準日付9 = new RString(date9.getDayValue());
        } else {
            基準日付9 = new RString(date9.getYearMonth().getLastDay());
        }
        if (date11.isValid()) {
            基準日付11 = new RString(date11.getDayValue());
        } else {
            基準日付11 = new RString(date11.getYearMonth().getLastDay());
        }

    }
}
