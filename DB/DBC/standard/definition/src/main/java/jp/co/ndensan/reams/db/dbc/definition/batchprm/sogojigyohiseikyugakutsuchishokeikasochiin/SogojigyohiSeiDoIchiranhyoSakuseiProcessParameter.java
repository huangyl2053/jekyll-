/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohiseikyugakutsuchishokeikasochiin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * SogojigyohiSeiDoIchiranhyoSakuseiProcessパラメータです。
 *
 * @reamsid_L DBC-2480-031 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private RDateTime システム日付;
}
