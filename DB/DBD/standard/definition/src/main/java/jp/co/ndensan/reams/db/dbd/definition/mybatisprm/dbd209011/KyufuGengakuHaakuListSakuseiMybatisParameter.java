/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd209011;

import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付額減額滞納者把握情報の取得SQL用パラメターくらすです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KyufuGengakuHaakuListSakuseiMybatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private final UaFt200FindShikibetsuTaishoFunction shikibetsutaishoParam;
    private RString 基準日;
    private RDate 基準日RDATE;

    /**
     * 給付額減額滞納者把握情報の引数を返します。
     *
     * @param 基準日 基準日
     * @param 出力順 出力順
     * @param shikibetsutaishoParam UaFt200FindShikibetsuTaishoFunction
     */
    public KyufuGengakuHaakuListSakuseiMybatisParameter(FlexibleDate 基準日, RString 出力順,
            UaFt200FindShikibetsuTaishoFunction shikibetsutaishoParam) {
        if (基準日 != null && !基準日.isEmpty()) {
            this.基準日 = new RString(基準日.toString());
            this.基準日RDATE = new RDate(基準日.toString());
        }
        this.出力順 = 出力順;
        this.shikibetsutaishoParam = shikibetsutaishoParam;
    }

}
