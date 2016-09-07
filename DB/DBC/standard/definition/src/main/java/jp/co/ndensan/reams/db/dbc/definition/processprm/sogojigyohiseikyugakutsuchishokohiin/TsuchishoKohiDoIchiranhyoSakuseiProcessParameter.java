/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohiseikyugakutsuchishokohiin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * DoIchiranhyoSakuseiProcessパラメータです。
 *
 * @reamsid_L DBC-4700-030 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchishoKohiDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private YMDHMS システム日付;

}
