
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払不支給決定者一覧表 償還払不支給決定者Entity
 *
 * @reamsid_L DBC-2590-010 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFushikyuKetteiInEntity implements Serializable {

    private RString 国保連合会名;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private RString 決定通知;
    private RString 整理番号;
    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private RString 町域コード;
    private RString 管内管外区分;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 行政区名;
    private LasdecCode 市町村コード;
    private RString 行政区コード;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業者番号;
    private RString 事業者名;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Decimal 単位数;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失日;
    private RString 備考1;
    private RString 備考2;
    private RString 更新DB無;
    private ShikibetsuCode 識別コード;
    private int 連番コード;
    private RString 郵便番号;
    private RString 氏名５０音カナ;

}
