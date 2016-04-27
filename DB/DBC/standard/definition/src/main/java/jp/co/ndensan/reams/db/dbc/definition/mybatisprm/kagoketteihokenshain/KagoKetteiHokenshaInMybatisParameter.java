/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteihokenshain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票Parameter
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KagoKetteiHokenshaInMybatisParameter implements IMyBatisParameter {

    private RString outputOrderBy;

    /**
     * KagoKetteiHokenshaInMybatisParameter
     */
    public KagoKetteiHokenshaInMybatisParameter() {
    }

}
