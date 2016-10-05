/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.shikakushogohyoin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import lombok.Getter;
import lombok.Setter;

/**
 * ShikakuShogohyoInDoIchiranhyoSakuseiProcessParameterパラメータです。
 *
 * @reamsid_L DBC-2890-010 wangxingpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShogohyoInDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private YMDHMS システム日付;

}
