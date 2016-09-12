/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 被保険者一時TBL Entity
 *
 * @reamsid_L DBC-2520-011 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT0001Hihokensha extends
        DbTableEntityBase<DbWT0001Hihokensha> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private Decimal 被保険者連番;
    @TempTableColumnOrder(2)
    private HihokenshaNo 証記載保険者番号;
    @TempTableColumnOrder(3)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(4)
    private FlexibleDate サービス提供年月末日;
    @TempTableColumnOrder(5)
    private RString 被保険者カナ氏名;
    @TempTableColumnOrder(6)
    private RString 被保険者氏名;
    @TempTableColumnOrder(7)
    private RString 旧市町村コード;
    @TempTableColumnOrder(8)
    private HihokenshaNo 変換被保険者番号;
    @TempTableColumnOrder(9)
    private HihokenshaNo 登録被保険者番号;
    @TempTableColumnOrder(10)
    private RString 市町村コード;
    @TempTableColumnOrder(11)
    private RString 管内管外区分;
    @TempTableColumnOrder(12)
    private YubinNo 郵便番号;
    @TempTableColumnOrder(13)
    private LasdecCode 町域コード;
    @TempTableColumnOrder(14)
    private RString 行政区コード;
    @TempTableColumnOrder(15)
    private RString 行政区名;
    @TempTableColumnOrder(16)
    private RString 住所;
    @TempTableColumnOrder(17)
    private RString 番地;
    @TempTableColumnOrder(18)
    private RString 方書;
    @TempTableColumnOrder(19)
    private RString 宛名カナ名称;
    @TempTableColumnOrder(20)
    private RString 宛名名称;
    @TempTableColumnOrder(21)
    private RString 氏名50音カナ;
    @TempTableColumnOrder(22)
    private RString 識別コード;
    @TempTableColumnOrder(23)
    private FlexibleDate 資格取得日;
    @TempTableColumnOrder(24)
    private RString 資格取得事由コード;
    @TempTableColumnOrder(25)
    private FlexibleDate 資格喪失日;
    @TempTableColumnOrder(26)
    private RString 資格喪失事由コード;
    @TempTableColumnOrder(27)
    private RString 世帯集約番号;
}
