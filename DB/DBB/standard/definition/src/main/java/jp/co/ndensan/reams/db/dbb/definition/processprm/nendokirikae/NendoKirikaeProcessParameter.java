/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 年度切替ProcessParameterのパラメータです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendoKirikaeProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;

}
