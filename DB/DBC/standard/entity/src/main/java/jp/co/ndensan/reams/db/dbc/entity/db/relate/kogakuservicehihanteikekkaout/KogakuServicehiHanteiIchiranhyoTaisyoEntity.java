/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBC200019_高額介護サービス費給付判定結果送付一覧表のEntity。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiHanteiIchiranhyoTaisyoEntity {

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
    private int 高額介護_連番;
    private HihokenshaNo 高額介護_被保険者番号;
    private FlexibleYearMonth 高額介護_サービス提供年月;
    private HokenshaNo 高額介護_証記載保険者番号;
    private Decimal 高額介護_履歴番号;
    private FlexibleDate 高額介護_受付年月日;
    private FlexibleDate 高額介護_申請年月日;
    private RString 高額介護_申請理由;
    private RString 高額介護_申請者区分;
    private AtenaMeisho 高額介護_申請者氏名;
    private AtenaKanaMeisho 高額介護_申請者氏名カナ;
    private RString 高額介護_申請者住所;
    private TelNo 高額介護_申請者電話番号;
    private JigyoshaNo 高額介護_申請事業者番号;
    private RString 高額介護_支払方法区分コード;
    private RString 高額介護_支払場所;
    private FlexibleDate 高額介護_支払期間開始年月日;
    private FlexibleDate 高額介護_支払期間終了年月日;
    private RString 高額介護_閉庁内容;
    private RString 高額介護_支払窓口開始時間;
    private RString 高額介護_支払窓口終了時間;
    private long 高額介護_口座ID;
    private RString 高額介護_受領委任契約番号;
    private FlexibleDate 高額介護_決定年月日;
    private Decimal 高額介護_本人支払額;
    private RString 高額介護_支給区分コード;
    private Decimal 高額介護_支給金額;
    private RString 高額介護_不支給理由;
    private RString 高額介護_審査方法区分;
    private FlexibleYearMonth 高額介護_判定結果送付年月;
    private boolean 高額介護_再送付フラグ;
    private boolean 高額介護_判定結果送付不要フラグ;
    private RString 高額介護_審査結果反映区分;
    private FlexibleDate 高額介護_決定通知書作成年月日;
    private FlexibleDate 高額介護_振込明細書作成年月日;
    private HokenshaNo 高額介護_保険者番号;
    private RString 高額介護_保険者名;
    private boolean 高額介護_送付除外フラグ;

}
