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
//年度
    private RString taishoNendo;
    @TempTableColumnOrder(2)
//被保険者番号
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
//履歴番号
    private int rirekiNo;
    @TempTableColumnOrder(4)
//職権変更フラグ
    private boolean shokenFlag;
    @TempTableColumnOrder(5)
//"負担割合区分（８月）"
    private RString futanwariaiKubunAug;
    @TempTableColumnOrder(6)
//"負担割合区分（9月）"
    private RString futanwariaiKubunSept;
    @TempTableColumnOrder(7)
//"負担割合区分（10月）"
    private RString futanwariaiKubunOct;
    @TempTableColumnOrder(8)
//"負担割合区分（11月）"
    private RString futanwariaiKubunNov;
    @TempTableColumnOrder(9)
//"負担割合区分（12月）"
    private RString futanwariaiKubunDec;
    @TempTableColumnOrder(10)
//"負担割合区分（1月）"
    private RString futanwariaiKubunJan;
    @TempTableColumnOrder(11)
//"負担割合区分（2月）"
    private RString futanwariaiKubunFeb;
    @TempTableColumnOrder(12)
//"負担割合区分（3月）"
    private RString futanwariaiKubunMar;
    @TempTableColumnOrder(13)
//"負担割合区分（4月）"
    private RString futanwariaiKubunApr;
    @TempTableColumnOrder(14)
//"負担割合区分（5月）"
    private RString futanwariaiKubunMay;
    @TempTableColumnOrder(15)
//"負担割合区分（6月）"
    private RString futanwariaiKubunJun;
    @TempTableColumnOrder(16)
//"負担割合区分（7月）"
    private RString futanwariaiKubunJul;

}
