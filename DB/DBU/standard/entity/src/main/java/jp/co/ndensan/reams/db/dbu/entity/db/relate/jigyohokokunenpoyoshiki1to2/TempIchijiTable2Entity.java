/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 事業状況報告年報　様式１・２の一時テーブル2のEntityクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class TempIchijiTable2Entity extends DbTableEntityBase<TempIchijiTable2Entity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(2)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(3)
    private RString serviceSeishikiName;
    @TempTableColumnOrder(4)
    private Decimal serviceTanisu;
    @TempTableColumnOrder(5)
    private Decimal hokenTanisuTani;
    @TempTableColumnOrder(6)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(7)
    private HokenKyufuRitsu hokenKyufuritsu;
    @TempTableColumnOrder(8)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(9)
    private LasdecCode kyuShichosonCode;
    @TempTableColumnOrder(10)
    private Decimal shuukeiGoHiyouGaku;
    @TempTableColumnOrder(11)
    private Decimal shuukeiGoKyuuhuGaku;
}
