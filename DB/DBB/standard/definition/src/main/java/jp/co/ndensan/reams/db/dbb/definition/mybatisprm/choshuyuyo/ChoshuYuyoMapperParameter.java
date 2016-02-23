/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 介護賦課徴収猶予を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ChoshuYuyoMapperParameter {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final TsuchishoNo tsuchishoNo;
    private final int rirekiNo;

    /**
     * コンストラクタです。
     *
     * @param FlexibleYear 調定年度
     * @param FlexibleYear 賦課年度
     * @param TsuchishoNo 通知書番号
     * @param Decimal 履歴番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ChoshuYuyoMapperParameter(
            FlexibleYear choteiNendo,
            FlexibleYear fukaNendo,
            TsuchishoNo tsuchishoNo,
            int rirekiNo) {

        this.choteiNendo = requireNonNull(choteiNendo, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        this.fukaNendo = requireNonNull(fukaNendo, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        this.tsuchishoNo = requireNonNull(tsuchishoNo, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        this.rirekiNo = requireNonNull(rirekiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
    }

    /**
     * 介護賦課徴収猶予を特定するためのMyBatis用パラメータを生成します。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param tsuchishoNo 通知書番号
     * @param rirekiNo 履歴番号
     * @return 介護賦課徴収猶予を特定するためのMyBatis用パラメータ
     */
    public static ChoshuYuyoMapperParameter createParam(
            FlexibleYear choteiNendo,
            FlexibleYear fukaNendo,
            TsuchishoNo tsuchishoNo,
            int rirekiNo) {
        return new ChoshuYuyoMapperParameter(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
    }

}
