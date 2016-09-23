/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistsaishinsakekka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト 再審査結果情報Entityクラスです。
 *
 * @reamsid_L DBC-3105-020 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListSaishinsaKekkaRelateEntity {

    private LasdecCode 市町村コード;
    private HihokenshaNo 被保険者番号;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 被保険者区分コード;
    private boolean 住所地特例フラグ;
    private boolean 広域内住所地特例フラグ;
    private RString 広住特措置元市町村コード;
    private FlexibleYearMonth 取扱年月;
    private RString 保険者区分;
    private JigyoshaNo 事業所番号;
    private AtenaMeisho 事業者名称;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private Decimal 申立単位数;
    private RString 申立事由コード;
    private RString 申立事由;
    private RString 再審査結果コード;
    private Decimal 当初請求件数;
    private Decimal 原審単位数;
    private Decimal 決定単位数;
    private Decimal 調整単位数;
    private Decimal 保険者負担額;
    private RString 公費受給者番号;
    private Code 受給申請事由;
    private FlexibleDate 受給申請年月日;
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 認定年月日;
    private boolean 旧措置者フラグ;
    private Code みなし要介護区分コード;
    private Code 直近異動事由コード;
    private boolean 要支援者認定申請区分;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
}
