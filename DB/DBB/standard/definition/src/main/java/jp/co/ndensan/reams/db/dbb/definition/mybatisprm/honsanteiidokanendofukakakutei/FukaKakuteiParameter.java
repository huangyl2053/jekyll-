/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofukakakutei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（過年度）賦課確定（削除込）用パラメータです
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaKakuteiParameter {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final TsuchishoNo tsuchishoNo;
    private final int rirekiNo;
    private final int ki;
    private final RString choshuHouhou;
    private final YMDHMS choteiNichiji;

    /**
     * コンストラクタです。
     *
     * @param choteiNendo FlexibleYear
     * @param fukaNendo FlexibleYear
     * @param tsuchishoNo TsuchishoNo
     * @param rirekiNo int
     * @param ki int
     * @param choshuHouhou RString
     * @param choteiNichiji YMDHMS
     */
    public FukaKakuteiParameter(
            FlexibleYear choteiNendo,
            FlexibleYear fukaNendo,
            TsuchishoNo tsuchishoNo,
            int rirekiNo, int ki,
            RString choshuHouhou,
            YMDHMS choteiNichiji) {
        this.choteiNendo = choteiNendo;
        this.fukaNendo = fukaNendo;
        this.tsuchishoNo = tsuchishoNo;
        this.rirekiNo = rirekiNo;
        this.ki = ki;
        this.choshuHouhou = choshuHouhou;
        this.choteiNichiji = choteiNichiji;
    }

}
