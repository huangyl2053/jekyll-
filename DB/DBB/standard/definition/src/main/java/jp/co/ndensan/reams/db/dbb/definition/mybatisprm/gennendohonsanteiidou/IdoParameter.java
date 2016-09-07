/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 異動情報抽出用パラメータクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdoParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 賦課年度;
    private final FlexibleYear 調定年度;
    private final RDateTime 抽出開始日時;
    private final RDateTime 抽出終了日時;
    private final RDateTime 調定日時;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @param 調定日時 RDateTime
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     */
    private IdoParameter(FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時,
            RDateTime 調定日時,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        super(searchkey, list);
        this.賦課年度 = 賦課年度;
        this.調定年度 = 調定年度;
        this.抽出開始日時 = 抽出開始日時;
        this.抽出終了日時 = 抽出終了日時;
        this.調定日時 = 調定日時;
    }

    /**
     * 異動情報抽出のパラメータを生成します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @param 調定日時 RDateTime
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @return パラメータ
     */
    public static IdoParameter createParam(FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時,
            RDateTime 調定日時,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        return new IdoParameter(賦課年度, 調定年度, 抽出開始日時, 抽出終了日時, 調定日時, searchkey, list);
    }
}
