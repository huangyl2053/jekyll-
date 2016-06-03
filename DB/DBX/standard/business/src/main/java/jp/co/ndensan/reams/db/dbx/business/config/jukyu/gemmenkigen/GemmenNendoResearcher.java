/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen;

import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免の年度について調べる機能を持ちます。
 */
public class GemmenNendoResearcher {

    private static final RString FEBRUARY_29TH = new RString("0229");
    private static final RString FEBRUARY_28TH = new RString("0228");
    private static final int DECEMBER = 12;
    private static final int LAST_DAY_OF_DECEMBER = 31;

    private final GemmenGengakuShurui 減免減額種類;

    /**
     * 調査対象の減免の種類を指定してインスタンスを生成します。
     *
     * @param 減免減額種類 調査対象の減免の種類
     */
    protected GemmenNendoResearcher(GemmenGengakuShurui 減免減額種類) {
        this.減免減額種類 = 減免減額種類;
    }

    /**
     * 調査対象の減免の種類を指定してインスタンスを生成します。
     *
     * @param 減免減額種類 調査対象の減免の種類
     * @return 指定の減免について年度の情報を調査することができる{@link GemmenNendoResearcher}
     */
    public static GemmenNendoResearcher createInstance(GemmenGengakuShurui 減免減額種類) {
        return new GemmenNendoResearcher(減免減額種類);
    }

    /**
     * 指定の年度の情報を返却します。
     * <p/>
     * ○年度の「○年」に当たる値を指定してください。
     * 例えば、平成28年度の情報を求める場合、「2016年」という値を指定します。
     * <p/>
     * 指定の基準日が、非歴上日の場合、すべて空の情報を保持した{@link INendo}返却します。
     *
     * @param 年度 ○年度の「○年」に当たる情報
     * @return 指定の年度の情報
     */
    public INendo find年度(FlexibleYear 年度) {
        if (!年度.isValid()) {
            return NendoEmpty.getInstance();
        }
        return find年度Contains(
                new FlexibleDate(年度.getYearValue(), DECEMBER, LAST_DAY_OF_DECEMBER)
        );
    }

    /**
     * 指定の日付を含む年度の情報を返却します。
     * <p/>
     * 指定の基準日が、非歴上日の場合、すべて空の情報を保持したインスタンスを返却します。
     *
     * @param 基準日 どのような年度に含まれるか判定したい日
     * @return 指定の日付を含む年度の情報
     */
    public INendo find年度Contains(FlexibleDate 基準日) {
        if (!基準日.isValid()) {
            return NendoEmpty.getInstance();
        }
        final FlexibleDate 終了日 = find年度終了日(基準日);
        final FlexibleDate 開始日 = find年度終了日(
                new FlexibleDate(終了日.getYearValue() - 1, 1, 1)
        ).plusDay(1);
        return new GemmenNendo(開始日, 終了日, this.減免減額種類);
    }

    /**
     * 指定の基準日の年度について、年度の終了日を判定して、返却します。
     * <p/>
     * 指定の基準日が、非歴上日の場合、すべて空の情報を保持した{@link INendo}返却します。
     *
     * @param 基準日 年度の終了日を判断したい日
     * @return 年度の終了日
     */
    public FlexibleDate find年度終了日(FlexibleDate 基準日) {
        if (基準日 == null || !基準日.isValid()) {
            return FlexibleDate.EMPTY;
        }
        RString 期限日 = GemmmenKigenConfig.get期限月日(this.減免減額種類, 基準日);
        FlexibleDate 有効期限候補 = create有効期限(基準日.getYear(), 期限日);
        if (!有効期限候補.isBefore(基準日)) {
            return 有効期限候補;
        }
        return create有効期限(基準日.getYear().plusYear(1), 期限日);
    }

    private FlexibleDate create有効期限(FlexibleYear fYear, RString mmdd) {
        if (!fYear.isLeapYear() && mmdd.equals(FEBRUARY_29TH)) {
            return toFlexibleDate(fYear, FEBRUARY_28TH);
        }
        return toFlexibleDate(fYear, mmdd);
    }

    private FlexibleDate toFlexibleDate(FlexibleYear fYear, RString mmdd) {
        return new FlexibleDate(new StringBuilder()
                .append(fYear.getYearValue())
                .append(mmdd).toString()
        );
    }
}
