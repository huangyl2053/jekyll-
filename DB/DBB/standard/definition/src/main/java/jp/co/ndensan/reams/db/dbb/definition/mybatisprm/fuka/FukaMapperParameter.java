/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class FukaMapperParameter {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final TsuchishoNo tsuchishoNo;
    private final Decimal rirekiNo;

    /**
     * コンストラクタです。
     *
     * @param FlexibleYear 調定年度
     * @param FlexibleYear 賦課年度
     * @param TsuchishoNo 通知書番号
     * @param Decimal 履歴番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private FukaMapperParameter(
            FlexibleYear choteiNendo,
            FlexibleYear fukaNendo,
            TsuchishoNo tsuchishoNo,
            Decimal rirekiNo) {

        this.choteiNendo = requireNonNull(choteiNendo, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        this.fukaNendo = requireNonNull(fukaNendo, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        this.tsuchishoNo = requireNonNull(tsuchishoNo, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        this.rirekiNo = requireNonNull(rirekiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
    }

    /**
     * 介護賦課を特定するためのMyBatis用パラメータを生成します。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param tsuchishoNo 通知書番号
     * @param rirekiNo 履歴番号
     * @return 介護賦課を特定するためのMyBatis用パラメータ
     */
    public static FukaMapperParameter createParam(
            FlexibleYear choteiNendo,
            FlexibleYear fukaNendo,
            TsuchishoNo tsuchishoNo,
            Decimal rirekiNo) {
        return new FukaMapperParameter(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
    }

}
