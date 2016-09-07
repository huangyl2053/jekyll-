/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seigoseichekkurisutosakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 整合性チェックリストのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class SeigoseiChekkuMybitisParamter implements IMyBatisParameter {

    private final FlexibleDate 年齢到達の設定日;
    private final FlexibleDate 対象生年月日;
    private final RString psmShikibetsuTaisho;
    private static final int 番号_65 = 65;

    private SeigoseiChekkuMybitisParamter(FlexibleDate 年齢到達の設定日, FlexibleDate 対象生年月日, RString psmShikibetsuTaisho) {
        this.年齢到達の設定日 = 年齢到達の設定日;
        this.対象生年月日 = 対象生年月日;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * @param 年齢到達の設定日 年齢到達の設定日
     * @param psmShikibetsuTaisho 宛名情報
     * @return SeigoseiChekkuMybitisParamter
     */
    public static SeigoseiChekkuMybitisParamter createParam(FlexibleDate 年齢到達の設定日, RString psmShikibetsuTaisho) {
        FlexibleDate 対象生年月日 = 年齢到達の設定日.minusYear(番号_65).plusDay(1);
        return new SeigoseiChekkuMybitisParamter(年齢到達の設定日, 対象生年月日, psmShikibetsuTaisho);
    }
}
