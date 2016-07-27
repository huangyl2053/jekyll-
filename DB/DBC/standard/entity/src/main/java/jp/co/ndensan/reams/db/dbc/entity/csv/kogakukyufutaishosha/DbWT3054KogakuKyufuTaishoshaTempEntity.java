/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付対象者一時TBL
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3054KogakuKyufuTaishoshaTempEntity {

    /**
     * コンストラクタです。
     */
    public DbWT3054KogakuKyufuTaishoshaTempEntity() {
        this.連番 = 0;
        this.レコード番号 = 0;
        this.帳票レコード種別 = RString.EMPTY;
        this.証記載保険者名 = RString.EMPTY;
        this.国保連合会名 = RString.EMPTY;
        this.no = RString.EMPTY;
        this.事業所名 = RString.EMPTY;
        this.サービス種類名 = RString.EMPTY;
        this.サービス費用合計額 = Decimal.ZERO;
        this.利用者負担額 = Decimal.ZERO;
        this.備考 = RString.EMPTY;
        this.サービス費用合計額合計 = Decimal.ZERO;
        this.利用者負担額合計 = Decimal.ZERO;
        this.算定基準額 = Decimal.ZERO;
        this.支払済金額合計 = Decimal.ZERO;
        this.高額支給額 = Decimal.ZERO;
        this.再処理不可フラグ = false;
    }

    private int 連番;
    private int レコード番号;
    private RString 帳票レコード種別;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString no;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Decimal サービス費用合計額;
    private Decimal 利用者負担額;
    private RString 備考;
    private Decimal サービス費用合計額合計;
    private Decimal 利用者負担額合計;
    private Decimal 算定基準額;
    private Decimal 支払済金額合計;
    private Decimal 高額支給額;
    private boolean 再処理不可フラグ;

}
