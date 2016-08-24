/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4010011;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * バッチ設計_DBDMN41001_障がい者控除対象者把握のMybatisのパラメータクラスです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter implements IMyBatisParameter {

    private final FlexibleDate 基準日;
    private final FlexibleYear 対象年度;
    private final boolean 基準日より後に資格喪失した者;
    private final boolean 前回把握時の非該当者;
    private FlexibleYear last対象年度;

    /**
     *
     * @param 基準日 FlexibleDate
     * @param 対象年度 FlexibleYear
     * @param 基準日より後に資格喪失した者 boolean
     * @param 前回把握時の非該当者 boolean
     */
    public ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter(FlexibleDate 基準日, FlexibleYear 対象年度, boolean 基準日より後に資格喪失した者, boolean 前回把握時の非該当者) {
        this.基準日 = 基準日;
        this.対象年度 = 対象年度;
        this.基準日より後に資格喪失した者 = 基準日より後に資格喪失した者;
        this.前回把握時の非該当者 = 前回把握時の非該当者;
        this.last対象年度 = getlast対象年度(対象年度);
    }

    private FlexibleYear getlast対象年度(FlexibleYear 対象年度) {
        return 対象年度.minusYear(1);
    }
}
