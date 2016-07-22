/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendotsuchishoikkatsuhakko;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（過年度）通知書一括発行（バッチ）用パラメータです。
 *
 * @reamsid_L DBB-0920-040 huzongcheng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoFukaJohoParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 調定年度前１年;
    private final FlexibleYear 調定年度前２年;
    private final YMDHMS 調定日時;
    private final RString 処理日;
    private final RString 科目コード;
    private final RString 判定フラグ;

    public IdoFukaJohoParameter(
            FlexibleYear 調定年度,
            FlexibleYear 調定年度前１年,
            FlexibleYear 調定年度前２年,
            YMDHMS 調定日時,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード,
            RString 判定フラグ) {
        super(searchkey, list);
        this.科目コード = 科目コード;
        this.調定年度 = 調定年度;
        this.調定年度前１年 = 調定年度前１年;
        this.調定年度前２年 = 調定年度前２年;
        this.調定日時 = 調定日時;
        this.処理日 = 処理日;
        this.判定フラグ = 判定フラグ;
    }

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定年度前１年 FlexibleYear
     * @param 調定年度前２年 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     * @param 判定フラグ RString
     * @return IdoFukaJohoParameter
     */
    public static IdoFukaJohoParameter createParameter(
            FlexibleYear 調定年度,
            FlexibleYear 調定年度前１年,
            FlexibleYear 調定年度前２年,
            YMDHMS 調定日時,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード,
            RString 判定フラグ) {
        return new IdoFukaJohoParameter(調定年度, 調定年度前１年, 調定年度前２年, 調定日時, 処理日, searchkey, list, 科目コード, 判定フラグ);
    }

}
