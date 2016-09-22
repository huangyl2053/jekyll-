/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkain;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 共同処理用受給者情報一覧表のEntityです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoJukyushaKoshinkekkaIchiranEntity {

    private Decimal 連番;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 集約被保険者番号;
    private RString 集約異動年月日;
    private RString 基_交換情報識別番号;
    private RString 基_異動年月日;
    private RString 基_異動区分コード;
    private RString 基_訂正年月日;
    private RString 基_訂正区分コード;
    private RString 基_異動事由;
    private RString 基_証記載保険者番号;
    private RString 基_被保険者番号;
    private RString 基_被保険者氏名;
    private RString 基_電話番号;
    private RString 基_郵便番号;
    private RString 基_住所カナ;
    private RString 基_住所;
    private RString 基_帳票出力順序コード;
    private RString 償_交換情報識別番号;
    private RString 償_異動年月日;
    private RString 償_異動区分コード;
    private RString 償_訂正年月日;
    private RString 償_訂正区分コード;
    private RString 償_異動事由;
    private RString 償_証記載保険者番号;
    private RString 償_被保険者番号;
    private RString 償_保険給付支払の一時差止の開始年月日;
    private RString 償_保険給付支払の一時差止の終了年月日;
    private RString 償_保険給付支払の一時差止区分;
    private RString 償_保険給付支払の一時差止金額;
    private RString 高_交換情報識別番号;
    private RString 高_異動年月日;
    private RString 高_異動区分コード;
    private RString 高_訂正年月日;
    private RString 高_訂正区分コード;
    private RString 高_異動事由;
    private RString 高_証記載保険者番号;
    private RString 高_被保険者番号;
    private RString 高_世帯主被保険者番号;
    private RString 高_世帯所得区分コード;
    private RString 高_所得区分コード;
    private RString 高_老齢福祉年金受給の有無;
    private RString 高_利用者負担第２段階;
    private RString 高_支給申請書出力の有無;
    private Decimal t0001連番;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate サービス提供年月末日;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private LasdecCode 旧市町村コード;
    private HihokenshaNo 変換被保険者番号;
    private HihokenshaNo 登録被保険者番号;
    private LasdecCode 市町村コード;
    private RString 管内管外区分;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 行政区名;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 宛名カナ名称;
    private RString 宛名名称;
    private RString 氏名50音カナ;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 資格取得日;
    private RString 資格取得事由コード;
    private FlexibleDate 資格喪失日;
    private RString 資格喪失事由コード;
    private HihokenshaNo 世帯集約番号;
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleDate idoYMD;
    private int rirekiNo;
    private RString idoKubunCode;
    private RString jukyushaIdoJiyu;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString hiHokenshaName;
    private YubinNo yubinNo;
    private RString ddressKana;
    private RString address;
    private TelNo telNo;
    private RString chohyoOutputJunjyoCode;
    private boolean teiseiRenrakuhyoFlag;
    private FlexibleYearMonth sofuYM;
    private RString teiseiKubunCode;
    private FlexibleDate teiseiYMD;
    private boolean logicalDeletedFlag;

}
