/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.tokuchokarisanteifukakakutei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴仮算定賦課確定のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoKarisanteiFukaKakuteiMapperParameter {

    private RString choteiTimestamp;
    private FlexibleYear fukaNendo;

    private TokuchoKarisanteiFukaKakuteiMapperParameter(RString choteiTimestamp, FlexibleYear fukaNendo) {
        this.choteiTimestamp = choteiTimestamp;
        this.fukaNendo = fukaNendo;
    }

    /**
     * 特徴仮算定賦課確定のMyBatis用パラメータを生成します。
     *
     * @param choteiTimestamp RDateTime
     * @param fukaNendo FlexibleYear
     * @return 特徴仮算定賦課確定するためのMyBatis用パラメータ
     */
    public static TokuchoKarisanteiFukaKakuteiMapperParameter createParam(RString choteiTimestamp, FlexibleYear fukaNendo) {

        return new TokuchoKarisanteiFukaKakuteiMapperParameter(choteiTimestamp, fukaNendo);

    }

}
