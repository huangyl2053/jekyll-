/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力用一時TBL
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3470chohyouShutsuryokuyouTempEntity
        extends DbTableEntityBase<DbWT3470chohyouShutsuryokuyouTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString serviceShuruiCode;
    @TempTableColumnOrder(3)
    private RString sortYouKomokuCode;
    @TempTableColumnOrder(4)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(5)
    private Decimal nissuKaisuSyukeichi;
    @TempTableColumnOrder(6)
    private Decimal taniSuSyukeichi;
    @TempTableColumnOrder(7)
    private RString serviceRyakushou;
}
