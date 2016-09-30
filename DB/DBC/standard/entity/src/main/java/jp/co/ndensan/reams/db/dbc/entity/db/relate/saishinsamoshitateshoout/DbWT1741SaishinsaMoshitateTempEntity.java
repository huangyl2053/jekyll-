/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査申立一時TBL
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1741SaishinsaMoshitateTempEntity {

    private int 連番;
    private JigyoshaNo 事業所番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private int 履歴番号;
    private FlexibleDate 申立年月日;
    private RString 申立者区分コード;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private int 申立単位数;
    private RString 申立事由コード;
    private FlexibleYearMonth 国保連送付年月;
    private boolean 国保連再送付有フラグ;
    private RString 備考;
    private HokenshaNo 保険者番号;
    private RString 保険者名;
    private RString 証記載保険者名;
    private RString 事業者名;
    private RString サービス名称;
    private boolean 送付除外フラグ;

}
