/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4030011;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 障がい者控除対象者認定書リスト_SQLパラメータクラスです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaListMyBatisParameter implements IMyBatisParameter {

    private RString 出力順;

    public ShogaishaKojoTaishoshaListMyBatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }

}
