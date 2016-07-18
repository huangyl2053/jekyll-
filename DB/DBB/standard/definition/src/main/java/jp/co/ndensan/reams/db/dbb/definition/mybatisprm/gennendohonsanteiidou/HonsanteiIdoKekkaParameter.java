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
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（現年度）結果一覧表出力用パラメータクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HonsanteiIdoKekkaParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     */
    private HonsanteiIdoKekkaParameter(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 出力順,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        super(searchkey, list);
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.出力順 = 出力順;
    }

    /**
     * 本算定異動（現年度）結果一覧表出力のパラメータを生成します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @return パラメータ
     */
    public static HonsanteiIdoKekkaParameter createParam(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 出力順,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        return new HonsanteiIdoKekkaParameter(調定年度, 賦課年度, 調定日時, 出力順, searchkey, list);
    }
}
