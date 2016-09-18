/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DoIchiranhyoSakuseiProcessパラメータです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private RString 出力順ID;
    private FlexibleYearMonth 処理年月;
    private RDateTime システム日付;

}
