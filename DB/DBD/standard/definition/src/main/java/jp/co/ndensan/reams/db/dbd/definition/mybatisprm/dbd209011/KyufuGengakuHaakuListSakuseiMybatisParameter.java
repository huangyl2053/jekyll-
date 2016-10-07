/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd209011;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
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

    /**
     * 給付額減額滞納者把握情報の引数を返します。
     *
     * @param 出力順 出力順
     */
    public KyufuGengakuHaakuListSakuseiMybatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }

}
