/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryoa4;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用介護認定審査対象者一覧表のParameterです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaishiryoA4Parameter {

    private final int 合議体番号;
    private final FlexibleDate 介護認定審査会開催予定年月日;
    private final RDate システム日付;
    private final RString 介護認定審査会開催番号;

    /**
     * インスタンスを生成します。
     *
     * @param 合議体番号 合議体番号
     * @param 介護認定審査会開催予定年月日 介護認定審査会開催予定年月日
     * @param システム日付 システム日付
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    private ShinsakaishiryoA4Parameter(
            int 合議体番号,
            FlexibleDate 介護認定審査会開催予定年月日,
            RDate システム日付,
            RString 介護認定審査会開催番号) {
        this.合議体番号 = 合議体番号;
        this.介護認定審査会開催予定年月日 = 介護認定審査会開催予定年月日;
        this.システム日付 = システム日付;
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
    }

    private static ShinsakaishiryoA4Parameter create_Parameter(
            int 合議体番号,
            FlexibleDate 介護認定審査会開催予定年月日,
            RString 介護認定審査会開催番号) {
        return new ShinsakaishiryoA4Parameter(合議体番号, 介護認定審査会開催予定年月日, RDate.getNowDate(), 介護認定審査会開催番号);
    }

    /**
     *
     * @param 合議体番号 合議体番号
     * @param 介護認定審査会開催予定年月日 介護認定審査会開催予定年月日
     * @return ShinsakaishiryoA4Parameter
     */
    public static ShinsakaishiryoA4Parameter create_審査員一覧取得(int 合議体番号,
            FlexibleDate 介護認定審査会開催予定年月日) {
        return create_Parameter(合議体番号, 介護認定審査会開催予定年月日, null);
    }

    /**
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return ShinsakaishiryoA4Parameter
     */
    public static ShinsakaishiryoA4Parameter create_審査員一覧取得(RString 介護認定審査会開催番号) {
        return create_Parameter(0, FlexibleDate.EMPTY, 介護認定審査会開催番号);
    }

}
