/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoHakuListMainMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_Process1クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuOneProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     */
    public ShiharaiHohoHenkoHaakuOneProcessParameter(FlexibleDate 基準日) {
        this.基準日 = 基準日;
    }

    /**
     * SQL使用されたパラメターを取得します．
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return SQL使用されたパラメター
     */
    public ShiharaiHohoHenkoHakuListMainMybatisParameter toShiharaiHohoHenkoHakuListMainMybatisParameter(RString psmShikibetsuTaisho) {
        return new ShiharaiHohoHenkoHakuListMainMybatisParameter(psmShikibetsuTaisho, 基準日);
    }
}
