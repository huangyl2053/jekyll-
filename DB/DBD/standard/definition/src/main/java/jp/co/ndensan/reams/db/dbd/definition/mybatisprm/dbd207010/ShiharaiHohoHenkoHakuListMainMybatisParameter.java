/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更滞納者把握情報取得SQL用クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShiharaiHohoHenkoHakuListMainMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 基準日;
    private RString psmShikibetsuTaisho;
    private RDate 基準日RDate;

    /**
     * コンストラクタです。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 基準日 基準日
     */
    public ShiharaiHohoHenkoHakuListMainMybatisParameter(RString psmShikibetsuTaisho, FlexibleDate 基準日) {
        this.基準日 = 基準日;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        if (基準日 != null && !基準日.isEmpty()) {
            基準日RDate = new RDate(基準日.toString());
        }
    }
}
