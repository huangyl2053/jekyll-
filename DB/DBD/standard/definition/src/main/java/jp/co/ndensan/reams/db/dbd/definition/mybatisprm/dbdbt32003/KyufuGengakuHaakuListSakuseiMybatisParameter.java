/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32003;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
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

    private Long 改頁出力順ID;

    /**
     * 給付額減額滞納者把握情報の引数を返します。
     *
     * @param 改頁出力順ID 改頁出力順ID
     */
    public KyufuGengakuHaakuListSakuseiMybatisParameter(Long 改頁出力順ID) {
        this.改頁出力順ID = 改頁出力順ID;
    }

}
