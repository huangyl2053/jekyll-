/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.choteibo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 段階用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class DanKai {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final TsuchishoNo tsuchishoNo;
    private final Decimal rirekiNo;
    private final HihokenshaNo hihokenshaNo;
    private final RString dankaiField;
    private final RString choshuHouhou;
    private final Decimal choteiId;
    private final Integer dogetsuFlag;
    private final Decimal zengetsusueChoteigaku;
    private final Decimal fueChoteigaku;
    private final Decimal genChoteigaku;
    private final Decimal dogetsusueChoteigaku;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 被保険者番号 被保険者番号
     * @param 段階 段階
     * @param 徴収方法 徴収方法
     * @param 調定ID 調定ID
     * @param 当月フラグ 当月フラグ
     * @param 該当する段階の前月末の調定額 該当する段階の前月末の調定額
     * @param 該当する段階の増の調定額 該当する段階の増の調定額
     * @param 該当する段階の減の調定額 該当する段階の減の調定額
     * @param 該当する段階の当月末の調定額 該当する段階の当月末の調定額
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private DanKai(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号,
            HihokenshaNo 被保険者番号,
            RString 段階,
            RString 徴収方法,
            Decimal 調定ID,
            Integer 当月フラグ,
            Decimal 該当する段階の前月末の調定額,
            Decimal 該当する段階の増の調定額,
            Decimal 該当する段階の減の調定額,
            Decimal 該当する段階の当月末の調定額) {

        this.choteiNendo = 調定年度;
        this.fukaNendo = 賦課年度;
        this.tsuchishoNo = 通知書番号;
        this.rirekiNo = 履歴番号;
        this.hihokenshaNo = 被保険者番号;
        this.dankaiField = 段階;
        this.choshuHouhou = 徴収方法;
        this.choteiId = 調定ID;
        this.dogetsuFlag = 当月フラグ;
        this.zengetsusueChoteigaku = 該当する段階の前月末の調定額;
        this.fueChoteigaku = 該当する段階の増の調定額;
        this.genChoteigaku = 該当する段階の減の調定額;
        this.dogetsusueChoteigaku = 該当する段階の当月末の調定額;
    }

    /**
     * 段階用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 被保険者番号 被保険者番号
     * @param 段階 段階
     * @param 徴収方法 徴収方法
     * @param 調定ID 調定ID
     * @param 当月フラグ 当月フラグ
     * @param 該当する段階の前月末の調定額 該当する段階の前月末の調定額
     * @param 該当する段階の増の調定額 該当する段階の増の調定額
     * @param 該当する段階の減の調定額 該当する段階の減の調定額
     * @param 該当する段階の当月末の調定額 該当する段階の当月末の調定額
     * @return 段階用パラメータ
     */
    public static DanKai createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号,
            HihokenshaNo 被保険者番号,
            RString 段階,
            RString 徴収方法,
            Decimal 調定ID,
            Integer 当月フラグ,
            Decimal 該当する段階の前月末の調定額,
            Decimal 該当する段階の増の調定額,
            Decimal 該当する段階の減の調定額,
            Decimal 該当する段階の当月末の調定額
    ) {
        return new DanKai(調定年度, 賦課年度, 通知書番号, 履歴番号, 被保険者番号, 段階, 徴収方法, 調定ID, 当月フラグ,
                該当する段階の前月末の調定額, 該当する段階の増の調定額, 該当する段階の減の調定額, 該当する段階の当月末の調定額);
    }

}
