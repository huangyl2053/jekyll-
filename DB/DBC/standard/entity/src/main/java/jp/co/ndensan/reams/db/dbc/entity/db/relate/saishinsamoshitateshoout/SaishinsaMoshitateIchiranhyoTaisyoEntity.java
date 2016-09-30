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
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表のEntity
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateIchiranhyoTaisyoEntity {

    private int 被保険者_連番;
    private HokenshaNo 被保険者_保険者番号;
    private RString 被保険者_保険者名;
    private ShoKisaiHokenshaNo 被保険者_証記載保険者番号;
    private HihokenshaNo 被保険者_被保険者番号;
    private FlexibleYearMonth 被保険者_サービス提供年月;
    private boolean 被保険者_変換対象フラグ;
    private LasdecCode 被保険者_旧市町村コード;
    private HihokenshaNo 被保険者_送付被保険者番号;
    private LasdecCode 被保険者_市町村コード;
    private RString 被保険者_管内管外区分;
    private RString 被保険者_郵便番号;
    private RString 被保険者_町域コード;
    private RString 被保険者_行政区コード;
    private RString 被保険者_行政区名;
    private RString 被保険者_住所;
    private RString 被保険者_番地;
    private RString 被保険者_方書;
    private RString 被保険者_宛名カナ名称;
    private RString 被保険者_宛名名称;
    private RString 被保険者_氏名50音カナ;
    private ShikibetsuCode 被保険者_識別コード;
    private FlexibleDate 被保険者_資格取得日;
    private RString 被保険者_資格取得事由コード;
    private FlexibleDate 被保険者_資格喪失日;
    private RString 被保険者_資格喪失事由コード;
    private RString 被保険者_世帯集約番号;
    private FlexibleDate 被保険者_生年月日;
    private RString 被保険者_性別コード;
    private FlexibleDate 被保険者_市町村加入年月日;
    private FlexibleDate 被保険者_市町村脱退年月日;
    private int 再審査申立_連番;
    private JigyoshaNo 再審査申立_事業所番号;
    private HihokenshaNo 再審査申立_被保険者番号;
    private FlexibleYearMonth 再審査申立_サービス提供年月;
    private ServiceShuruiCode 再審査申立_サービス種類コード;
    private ServiceKomokuCode 再審査申立_サービス項目コード;
    private int 再審査申立_履歴番号;
    private FlexibleDate 再審査申立_申立年月日;
    private RString 再審査申立_申立者区分コード;
    private ShoKisaiHokenshaNo 再審査申立_証記載保険者番号;
    private int 再審査申立_申立単位数;
    private RString 再審査申立_申立事由コード;
    private FlexibleYearMonth 再審査申立_国保連送付年月;
    private boolean 再審査申立_国保連再送付有フラグ;
    private RString 再審査申立_備考;
    private HokenshaNo 再審査申立_保険者番号;
    private RString 再審査申立_保険者名;
    private RString 再審査申立_証記載保険者名;
    private RString 再審査申立_事業者名;
    private RString 再審査申立_サービス名称;
    private boolean 再審査申立_送付除外フラグ;

}
