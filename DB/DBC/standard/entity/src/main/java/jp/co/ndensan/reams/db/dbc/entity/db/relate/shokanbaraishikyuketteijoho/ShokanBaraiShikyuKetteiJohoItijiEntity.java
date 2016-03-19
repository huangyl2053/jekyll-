/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給決定情報一時TBL一覧表エンティティです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanBaraiShikyuKetteiJohoItijiEntity implements Serializable {

    private KokanShikibetsuNo 交換情報識別番号;
    private RString 帳票レコード種別_ヘッダ;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 保険者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString 帳票レコード種別;
    private RString no;
    private RString 整理番号;
    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名_漢字;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 事業所名_漢字;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Decimal 単位数_金額;
    private Decimal 支払金額;
    private int 増減単位数;
    private RString 支払方法区分コード;
    private RString 備考;
    private ShikibetsuCode 識別コード;
    private ZenkokuJushoCode 全国住所コード;
    private RString 住所;
    private GyoseikuCode 行政区コード;
    private RString 行政区名;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 支払日;
    private RString 支給不支給区分;
    private Boolean 更新DB無;
}
