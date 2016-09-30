/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsamoshitatetouroku;

import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費再審査申立書作成のMybatisParameterです。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SaishinsaMoshitateTourokuMybatisParameter implements IMyBatisParameter {

    private static final RString EMPTY保険者番号 = new RString("000000");
    private final RString 被保険者番号;
    private final RString 事業所番号;
    private final RString 保険者番号;
    private final boolean 被保険者番号フラグ;
    private final boolean 事業所番号フラグ;
    private final boolean 保険者番号フラグ;
    private final RString サービス提供年月;
    private final RString 提供年月開始;
    private final RString 提供年月終了;
    private final RString 保険者種別;
    private final RString 行番号;
    private final int num行番号;
    private final RString 給付実績区分コード;
    private final RString twentyThree;
    private final RString twentyTwo;
    private final RString twentyFive;
    private final RString twentySix;
    private final RString fiftyTwo;
    private final RString fiftyThree;
    private final RString sixty;
    private final RString seventy;
    private final RString doubleZero;

    private SaishinsaMoshitateTourokuMybatisParameter(
            RString 被保険者番号,
            boolean 被保険者番号フラグ,
            RString 事業所番号,
            boolean 事業所番号フラグ,
            RString 保険者番号,
            boolean 保険者番号フラグ,
            RString サービス提供年月,
            RString 提供年月開始,
            RString 提供年月終了) {
        this.被保険者番号 = 被保険者番号;
        this.事業所番号 = 事業所番号;
        this.保険者番号 = 保険者番号;
        this.被保険者番号フラグ = 被保険者番号フラグ;
        this.事業所番号フラグ = 事業所番号フラグ;
        this.保険者番号フラグ = 保険者番号フラグ;
        if (!RString.isNullOrEmpty(サービス提供年月)) {
            this.サービス提供年月 = (new RDate(サービス提供年月.toString()).getYearMonth().toDateString());
        } else {
            this.サービス提供年月 = RString.EMPTY;
        }
        if (!RString.isNullOrEmpty(提供年月開始)) {
            this.提供年月開始 = (new RDate(提供年月開始.toString()).getYearMonth().toDateString());
        } else {
            this.提供年月開始 = RString.EMPTY;
        }
        if (!RString.isNullOrEmpty(提供年月終了)) {
            this.提供年月終了 = (new RDate(提供年月終了.toString()).getYearMonth().toDateString());
        } else {
            this.提供年月終了 = RString.EMPTY;
        }
        this.保険者種別 = new RString("08");
        this.行番号 = new RString("1");
        this.給付実績区分コード = KyufuJissekiKubun.現物.getコード();
        this.twentyThree = new RString("23");
        this.twentyTwo = new RString("22");
        this.twentyFive = new RString("25");
        this.twentySix = new RString("26");
        this.fiftyTwo = new RString("52");
        this.fiftyThree = new RString("53");
        this.sixty = new RString("60");
        this.seventy = new RString("70");
        this.doubleZero = new RString("00");
        this.num行番号 = Integer.parseInt(行番号.toString());
    }

    /**
     * 介護給付費再審査申立書作成のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @return 介護給付費再審査申立書作成ののパラメータ
     */
    public static SaishinsaMoshitateTourokuMybatisParameter createMybatisParameter(
            RString 被保険者番号,
            RString サービス提供年月,
            RString 事業所番号) {
        return new SaishinsaMoshitateTourokuMybatisParameter(
                被保険者番号,
                !RString.isNullOrEmpty(被保険者番号),
                事業所番号,
                !RString.isNullOrEmpty(事業所番号),
                RString.EMPTY,
                false,
                サービス提供年月,
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * 介護給付費再審査申立書作成のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 保険者番号 保険者番号
     * @param 提供年月開始 提供年月開始
     * @param 提供年月終了 提供年月終了
     * @param 事業所番号 事業所番号
     * @return 介護給付費再審査申立書作成のパラメータ
     */
    public static SaishinsaMoshitateTourokuMybatisParameter createMybatisParameter(
            RString 被保険者番号,
            RString 事業所番号,
            RString 保険者番号,
            RString 提供年月開始,
            RString 提供年月終了) {
        return new SaishinsaMoshitateTourokuMybatisParameter(
                被保険者番号,
                !RString.isNullOrEmpty(被保険者番号),
                事業所番号,
                !RString.isNullOrEmpty(事業所番号),
                保険者番号,
                !RString.isNullOrEmpty(保険者番号) && (!EMPTY保険者番号.equals(保険者番号)),
                RString.EMPTY,
                提供年月開始,
                提供年月終了);
    }
}
