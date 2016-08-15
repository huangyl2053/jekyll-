/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nendokirikae;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 年度切替MybatisParameterのパラメータです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendoKirikaeMybatisParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
}
