/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110060;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成のバッチProcessParameter
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyushinseishoOutProcessParameter implements IBatchProcessParameter {

    private RString 再処理区分;
    private FlexibleYearMonth 処理年月;
    private int 件数;
    private int レコード件数;
    private HokenshaNo 保険者番号;
    private RString 保険者情報_保険者番号;
    private RString 保険者情報_保険者名称;

}
