/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd560001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定データ一括更新のProcessのパラメータクラスです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD560001ProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 認定日;

    /**
     *
     * @param 認定日 FlexibleDate
     */
    public DBD560001ProcessParameter(FlexibleDate 認定日) {
        this.認定日 = 認定日;
    }
}
