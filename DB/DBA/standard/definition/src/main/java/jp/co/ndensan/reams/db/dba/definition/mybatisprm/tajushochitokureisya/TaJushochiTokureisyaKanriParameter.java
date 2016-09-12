/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisya;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者管理のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBA-0400-050 hezhenzhen
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaJushochiTokureisyaKanriParameter {

    private final FlexibleDate nyuusyoYMD;
    private final FlexibleDate tayishoYMD;
    private final RString 状態;
    private final FlexibleDate kaijoYMD;
    private final FlexibleDate tekiyoYMD;

    /**
     * コンストラクタです
     *
     * @param nyuusyoYMD 入所日
     * @param tayishoYMD 退所日
     * @param kaijoYMD 解除日
     * @param tekiyoYMD 適用日
     * @param 状態 状態
     */
    protected TaJushochiTokureisyaKanriParameter(
            FlexibleDate nyuusyoYMD,
            FlexibleDate tayishoYMD,
            FlexibleDate kaijoYMD,
            FlexibleDate tekiyoYMD,
            RString 状態) {
        this.nyuusyoYMD = nyuusyoYMD;
        this.tayishoYMD = tayishoYMD;
        this.kaijoYMD = kaijoYMD;
        this.状態 = 状態;
        this.tekiyoYMD = tekiyoYMD;
    }

    /**
     * 他市町村住所地特例者管理のパラメータを生成します。
     *
     * @param nyuusyoYMD 入所日
     * @param tayishoYMD 退所日
     * @param kaijoYMD 解除日
     * @param tekiyoYMD 適用日
     * @param 状態 状態
     * @return 他市町村住所地特例者管理パラメータ
     */
    public static TaJushochiTokureisyaKanriParameter createParamBy他市町村住所地特例者管理(
            FlexibleDate nyuusyoYMD,
            FlexibleDate tayishoYMD,
            FlexibleDate kaijoYMD,
            FlexibleDate tekiyoYMD,
            RString 状態) {
        return new TaJushochiTokureisyaKanriParameter(nyuusyoYMD, tayishoYMD, kaijoYMD, tekiyoYMD, 状態);
    }

}
