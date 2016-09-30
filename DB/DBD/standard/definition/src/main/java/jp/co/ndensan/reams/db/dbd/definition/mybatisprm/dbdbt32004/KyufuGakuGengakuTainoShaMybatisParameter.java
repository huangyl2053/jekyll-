/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32004;

import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoMukoKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付額減額滞納者把握情報取得MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGakuGengakuTainoShaMybatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private RString 支払方法変更管理区分_１号給付額減額;
    private RString 支払方法変更無効区分_有効;

    /**
     * コンストラクタです。
     *
     * @param 出力順 出力順
     */
    public KyufuGakuGengakuTainoShaMybatisParameter(RString 出力順) {
        this.出力順 = 出力順;
        支払方法変更管理区分_１号給付額減額 = ShiharaiHenkoKanriKubun._１号給付額減額.getコード();
        支払方法変更無効区分_有効 = ShiharaiHenkoMukoKubun.有効.getコード();
    }

}
