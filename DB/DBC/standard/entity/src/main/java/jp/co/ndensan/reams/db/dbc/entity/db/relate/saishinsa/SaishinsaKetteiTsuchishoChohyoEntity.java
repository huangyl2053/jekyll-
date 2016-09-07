/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 再審査決定通知書情報取込（公費負担者分）帳票出力対象
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiTsuchishoChohyoEntity implements Serializable {

    private RString 国保連合会名;
    private RString 審査委員会名;
    private ShoKisaiHokenshaNo 公費負担者番号;
    private RString 公費負担者名;
    private FlexibleYearMonth 取扱年月;
    private JigyoshaNo 事業者番号;
    private RString 事業者名;
    private RString 公費受給者番号;
    private RString 公費受給者名;
    private RString 公費証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Code 申立事由コード;
    private RString 申立事由;
    private Code 再審査結果コード;
//    private RString 再審査結果;
    private Decimal 当初請求単位数;
    private Decimal 原審単位数;
    private Decimal 申立単位数;
    private Decimal 決定単位数;
    private Decimal 調整単位数;
    private Decimal 公費負担額;
    private Decimal 介護給付費_申立_件数;
    private Decimal 介護給付費_申立_単位数;
    private Decimal 介護給付費_申立_負担額;
    private Decimal 介護給付費_決定_件数;
    private Decimal 介護給付費_決定_単位数;
    private Decimal 介護給付費_決定_負担額;
    private Decimal 介護給付費_調整_件数;
    private Decimal 介護給付費_調整_単位数;
    private Decimal 介護給付費_調整_負担額;
    private Decimal 高額介護サービス費_申立_件数;
    private Decimal 高額介護サービス費_申立_単位数;
    private Decimal 高額介護サービス費_申立_負担額;
    private Decimal 高額介護サービス費_決定_件数;
    private Decimal 高額介護サービス費_決定_単位数;
    private Decimal 高額介護サービス費_決定_負担額;
    private Decimal 高額介護サービス費_調整_件数;
    private Decimal 高額介護サービス費_調整_単位数;
    private Decimal 高額介護サービス費_調整_負担額;
    private ShikibetsuCode 識別コード;
    private int 連番;
}
