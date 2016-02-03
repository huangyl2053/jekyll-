/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.choteibo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 段階用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class DanKai {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final TsuchishoNo tsuchishoNo;
    private final Decimal rirekiNo;
    private final RString hihokenshaNo;
    private final RString dankai;
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
            RString 被保険者番号,
            RString 段階,
            RString 徴収方法,
            Decimal 調定ID,
            Integer 当月フラグ,
            Decimal 該当する段階の前月末の調定額,
            Decimal 該当する段階の増の調定額,
            Decimal 該当する段階の減の調定額,
            Decimal 該当する段階の当月末の調定額) {

        this.choteiNendo = requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        this.fukaNendo = requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        this.tsuchishoNo = requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        this.rirekiNo = requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.hihokenshaNo = requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.dankai = requireNonNull(段階, UrSystemErrorMessages.値がnull.getReplacedMessage("段階"));
        this.choshuHouhou = requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        this.choteiId = requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));
        this.dogetsuFlag = requireNonNull(当月フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("当月フラグ"));
        this.zengetsusueChoteigaku = requireNonNull(該当する段階の前月末の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の前月末の調定額"));
        this.fueChoteigaku = requireNonNull(該当する段階の増の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の増の調定額"));
        this.genChoteigaku = requireNonNull(該当する段階の減の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の減の調定額"));
        this.dogetsusueChoteigaku = requireNonNull(該当する段階の当月末の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の当月末の調定額"));
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
            RString 被保険者番号,
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
