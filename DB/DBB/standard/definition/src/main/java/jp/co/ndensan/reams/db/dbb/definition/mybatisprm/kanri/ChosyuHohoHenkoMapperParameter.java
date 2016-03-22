/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 徴収方法変更のMyBatis用パラメータクラスです
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosyuHohoHenkoMapperParameter {

    private final FlexibleYear fukaNendo;
    private final FlexibleYear fukaNendoBak;
    private final HihokenshaNo hihokenshaNo;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     */
    private ChosyuHohoHenkoMapperParameter(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号
    ) {
        this.fukaNendo = 賦課年度;
        this.fukaNendoBak = 賦課年度.minusYear(1);
        this.hihokenshaNo = 被保険者番号;

    }

    /**
     * 徴収方法変更のパラメータを生成します。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @return パラメータ
     */
    public static ChosyuHohoHenkoMapperParameter createSelectByKeyParam(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号
    ) {
        return new ChosyuHohoHenkoMapperParameter(賦課年度, 被保険者番号);
    }
}
