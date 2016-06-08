/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票Parameter
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class ShokanFushikyuKetteiInMybatisParameter implements IMyBatisParameter {

    private RString outputOrderBy;

    /**
     * ShokanFushikyuKetteiInMybatisParameter
     */
    public ShokanFushikyuKetteiInMybatisParameter() {
    }
}
