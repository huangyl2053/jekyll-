/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定通知書一時テーブルに登録する用パラメータクラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiTsuchishoIkkatsuHakkoParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final RString 処理日;
    private final RString 科目コード;
    private final YMDHMS 最新調定日時;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     * @param 最新調定日時 YMDHMS
     */
    public HonsanteiTsuchishoIkkatsuHakkoParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード,
            YMDHMS 最新調定日時) {
        super(searchkey, list);
        this.科目コード = 科目コード;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.処理日 = 処理日;
        this.最新調定日時 = 最新調定日時;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     * @param 最新調定日時 YMDHMS
     * @return パラメータ
     */
    public static HonsanteiTsuchishoIkkatsuHakkoParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード,
            YMDHMS 最新調定日時) {
        return new HonsanteiTsuchishoIkkatsuHakkoParameter(調定年度, 賦課年度, 処理日, searchkey, list, 科目コード, 最新調定日時);
    }
}
