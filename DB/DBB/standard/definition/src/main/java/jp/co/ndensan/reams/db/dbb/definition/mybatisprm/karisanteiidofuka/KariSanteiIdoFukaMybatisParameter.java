/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidofuka;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 仮算定異動賦課のビジネス用パラメータクラスです。
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiIdoFukaMybatisParameter extends KozaSearchParameter {

    private FlexibleYear 賦課年度;
    private FlexibleYear 調定年度;
    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
    private YMDHMS 調定日時;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 調定日時 YMDHMS
     */
    public KariSanteiIdoFukaMybatisParameter(
            FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            YMDHMS 調定日時) {
        super(searchkey, list);
        this.賦課年度 = 賦課年度;
        this.調定年度 = 調定年度;
        this.抽出開始日時 = 抽出開始日時;
        this.抽出終了日時 = 抽出終了日時;
        this.調定日時 = 調定日時;
    }

}
