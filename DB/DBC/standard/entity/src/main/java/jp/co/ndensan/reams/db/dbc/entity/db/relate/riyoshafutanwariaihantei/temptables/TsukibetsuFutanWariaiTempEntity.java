/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 月別負担割合の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuFutanWariaiTempEntity extends DbTableEntityBase<TsukibetsuFutanWariaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString taishoNendo;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private int rirekiNo;
    @TempTableColumnOrder(4)
    private boolean shokenFlag;
    @TempTableColumnOrder(5)
    private RString futanwariaiKubunAug;
    @TempTableColumnOrder(6)
    private RString futanwariaiKubunSept;
    @TempTableColumnOrder(7)
    private RString futanwariaiKubunOct;
    @TempTableColumnOrder(8)
    private RString futanwariaiKubunNov;
    @TempTableColumnOrder(9)
    private RString futanwariaiKubunDec;
    @TempTableColumnOrder(10)
    private RString futanwariaiKubunJan;
    @TempTableColumnOrder(11)
    private RString futanwariaiKubunFeb;
    @TempTableColumnOrder(12)
    private RString futanwariaiKubunMar;
    @TempTableColumnOrder(13)
    private RString futanwariaiKubunApr;
    @TempTableColumnOrder(14)
    private RString futanwariaiKubunMay;
    @TempTableColumnOrder(15)
    private RString futanwariaiKubunJun;
    @TempTableColumnOrder(16)
    private RString futanwariaiKubunJul;

}
