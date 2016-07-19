/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定計算後賦課情報Entityに設定のParameter
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsenteiKeisangojohoParameter extends KozaSearchParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private RString 出力順;

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
    public HonsenteiKeisangojohoParameter(FlexibleYear 調定年度,
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
     * パラメータメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順 RString
     * @param key RString
     * @param list List<KamokuCode>
     * @return HonsenteiKeisangojohoParameter
     */
    public static HonsenteiKeisangojohoParameter createSelectByKeyParam(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 出力順,
            IKozaSearchKey key,
            List<KamokuCode> list) {
        return new HonsenteiKeisangojohoParameter(調定年度, 賦課年度, 調定日時, 出力順, key, list);

    }

}
