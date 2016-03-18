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
public class FukaKakuteiParameter {

    FlexibleYear choteiNendo;
    FlexibleYear fukaNendo;
    TsuchishoNo tsuchishoNo;
    int rirekiNo;
    int ki;
    RString choshuHouhou;
    YMDHMS choteiNichiji;

    /**
     * コンストラクタです。
     *
     * @param choteiNendo
     * @param fukaNendo
     * @param tsuchishoNo
     * @param rirekiNo
     * @param ki
     * @param choshuHouhou
     * @param choteiNichiji
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
