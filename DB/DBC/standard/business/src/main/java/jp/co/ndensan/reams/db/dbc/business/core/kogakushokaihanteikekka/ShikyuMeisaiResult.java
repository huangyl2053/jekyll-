/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakushokaihanteikekka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 支給明細Entity
 *
 * @reamsid_L DBC-3000-050 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuMeisaiResult {

    private JigyoshaNo 事業者番号;
    private AtenaMeisho 事業者名称;
    private ServiceShuruiCode サービス種類コード;
    private Decimal サービス費用合計;
    private Decimal 利用者負担額;
    private Decimal 算定基準額;
    private Decimal 支払済金額;
    private Decimal 高額支給額;
}
