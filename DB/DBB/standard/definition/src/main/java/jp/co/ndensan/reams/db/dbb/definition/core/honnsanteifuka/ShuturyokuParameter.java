/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuturyokuParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;

}
