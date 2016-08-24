/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4010011;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBDMN41001_障がい者控除対象者把握のProcessのパラメータクラスです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaHaakuKekkaIchiranProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private FlexibleYear 対象年度;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private boolean 基準日より後に資格喪失した者;
    private boolean 前回把握時の非該当者;

    /**
     *
     * @return ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter
     */
    public ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter shogaishaKojoTaishoshaHaakuKekkaIchiranMybatisParameter() {
        return new ShogaishaKojoTaishoshaHaakuKekkaIchiranMapperParameter(基準日, 対象年度, 基準日より後に資格喪失した者, 前回把握時の非該当者);
    }
}
