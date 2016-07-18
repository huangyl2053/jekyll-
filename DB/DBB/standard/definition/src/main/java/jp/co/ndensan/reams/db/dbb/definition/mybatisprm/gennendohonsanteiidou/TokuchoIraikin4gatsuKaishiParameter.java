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

/**
 * 特徴依頼金計算 (4月開始)用パラメータクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoIraikin4gatsuKaishiParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final YMDHMS 調定日時;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     */
    private TokuchoIraikin4gatsuKaishiParameter(FlexibleYear 調定年度,
            YMDHMS 調定日時,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        super(searchkey, list);
        this.調定年度 = 調定年度;
        this.調定日時 = 調定日時;
    }

    /**
     * 特徴依頼金計算 (4月開始)のパラメータを生成します。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @return パラメータ
     */
    public static TokuchoIraikin4gatsuKaishiParameter createParam(FlexibleYear 調定年度,
            YMDHMS 調定日時,
            IKozaSearchKey searchkey,
            List<KamokuCode> list) {
        return new TokuchoIraikin4gatsuKaishiParameter(調定年度, 調定日時, searchkey, list);
    }
}
