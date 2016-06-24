/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査決定明細一時TBL
 *
 * @reamsid_L DBC-2520-012 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3064SaishinsaKetteiMeisaiTempEntity {

    private FlexibleYearMonth 取扱年月;
    private int 履歴番号;
    private int 連番;
    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private RString 公費負担者番号;
    private RString 公費受給者番号;
    private ShoKisaiHokenshaNo 公費証記載保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Code 申立事由コード;
    private RString 申立事由;
    private Code 再審査結果コード;
    private Decimal 当初請求単位数;
    private Decimal 原審単位数;
    private Decimal 申立単位数;
    private Decimal 決定単位数;
    private Decimal 調整単位数;
    private Decimal 保険者負担額;
    private FlexibleYearMonth 取込年月;

}
