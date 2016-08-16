/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 再審査決定明細一時TBL,被保険者一時TBL Entity
 *
 * @reamsid_L DBC-2520-011 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaiShinsaKetteiMeisaiTempEntity extends
        DbTableEntityBase<SaiShinsaKetteiMeisaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private FlexibleYearMonth 取扱年月;
    @TempTableColumnOrder(2)
    private int 履歴番号;
    @TempTableColumnOrder(3)
    private Decimal 決定明細連番;
    @TempTableColumnOrder(4)
    private JigyoshaNo 事業所番号;
    @TempTableColumnOrder(5)
    private RString 事業所名;
    @TempTableColumnOrder(6)
    private RString 公費負担者番号;
    @TempTableColumnOrder(7)
    private RString 公費受給者番号;
    @TempTableColumnOrder(8)
//    private HokenshaNo 公費証記載保険者番号;
    private RString 公費証記載保険者番号;
    @TempTableColumnOrder(9)
    private FlexibleYearMonth サービス提供年月;
    @TempTableColumnOrder(10)
    private ServiceShuruiCode サービス種類コード;
    @TempTableColumnOrder(11)
    private RString サービス種類名;
    @TempTableColumnOrder(12)
    private RString 申立事由コード;
    @TempTableColumnOrder(13)
    private RString 申立事由;
    @TempTableColumnOrder(14)
    private RString 再審査結果コード;
    @TempTableColumnOrder(15)
    private Decimal 当初請求単位数;
    @TempTableColumnOrder(16)
    private Decimal 原審単位数;
    @TempTableColumnOrder(17)
    private Decimal 申立単位数;
    @TempTableColumnOrder(18)
    private Decimal 決定単位数;
    @TempTableColumnOrder(19)
    private Decimal 調整単位数;
    @TempTableColumnOrder(20)
    private Decimal 保険者負担額;
    @TempTableColumnOrder(21)
    private FlexibleYearMonth 取込年月;
    @TempTableColumnOrder(22)
    private Decimal 被保険者連番;
    @TempTableColumnOrder(23)
    private HihokenshaNo 証記載保険者番号;
    @TempTableColumnOrder(24)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(25)
    private FlexibleDate サービス提供年月末日;
    @TempTableColumnOrder(26)
    private RString 被保険者カナ氏名;
    @TempTableColumnOrder(27)
    private RString 被保険者氏名;
    @TempTableColumnOrder(28)
    private RString 旧市町村コード;
    @TempTableColumnOrder(29)
    private HihokenshaNo 変換被保険者番号;
    @TempTableColumnOrder(30)
    private HihokenshaNo 登録被保険者番号;
    @TempTableColumnOrder(31)
    private RString 市町村コード;
    @TempTableColumnOrder(32)
    private RString 管内管外区分;
    @TempTableColumnOrder(33)
    private YubinNo 郵便番号;
    @TempTableColumnOrder(34)
    private LasdecCode 町域コード;
    @TempTableColumnOrder(35)
    private RString 行政区コード;
    @TempTableColumnOrder(36)
    private RString 行政区名;
    @TempTableColumnOrder(37)
    private RString 住所;
    @TempTableColumnOrder(38)
    private RString 番地;
    @TempTableColumnOrder(39)
    private RString 方書;
    @TempTableColumnOrder(40)
    private RString 宛名カナ名称;
    @TempTableColumnOrder(41)
    private RString 宛名名称;
    @TempTableColumnOrder(42)
    private RString 氏名50音カナ;
    @TempTableColumnOrder(43)
    private RString 識別コード;
    @TempTableColumnOrder(44)
    private FlexibleDate 資格取得日;
    @TempTableColumnOrder(45)
    private RString 資格取得事由コード;
    @TempTableColumnOrder(46)
    private FlexibleDate 資格喪失日;
    @TempTableColumnOrder(47)
    private RString 資格喪失事由コード;
    @TempTableColumnOrder(48)
    private RString 世帯集約番号;
}
