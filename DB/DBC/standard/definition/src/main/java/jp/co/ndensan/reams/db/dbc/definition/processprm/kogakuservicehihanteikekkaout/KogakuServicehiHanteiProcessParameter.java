/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費給付判定結果情報作成Processのパラメータです。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiHanteiProcessParameter implements IBatchProcessParameter {

    private RString 再処理区分;
    private FlexibleYearMonth 処理年月;
    private List<RString> 送付ファイルエントリ情報List;
    private RString 保険者番号;

}
