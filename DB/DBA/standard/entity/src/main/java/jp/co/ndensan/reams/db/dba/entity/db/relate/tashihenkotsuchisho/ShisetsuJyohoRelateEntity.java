/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他住特施設連絡票データEntity
 *
 * @reamsid_L DBA-0380-050 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuJyohoRelateEntity {

    private RString 台帳種別;
    private RString 入所施設種類;
    private JigyoshaNo 入所施設コード;
    private FlexibleDate 適用日;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private RString 退所事由;
    private RString 事業者名称;
    private RString 電話番号;
    private RString fax番号;
    private RString 郵便番号;
    private RString 事業者住所;

}
