/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 認定審査会割当委員情報一時デーブルクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class TmpNinteiShinsakaiWariateIinJohoItijiEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString shinsakaiKaisaiNo;
    @TempTableColumnOrder(2)
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    @TempTableColumnOrder(3)
    private RString shinsakaiKaishiYoteiTime;
    @TempTableColumnOrder(4)
    private RString shinsakaiShuryoYoteiTime;
    @TempTableColumnOrder(5)
    private RString shinsakaiKaisaiBashoCode;
    @TempTableColumnOrder(6)
    private int gogitaiNo;
    @TempTableColumnOrder(7)
    private int shinsakaiYoteiTeiin;
    @TempTableColumnOrder(8)
    private int shinsakaiSaidaiTeiin;
    @TempTableColumnOrder(9)
    private int shinsakaiJidoWariateTeiin;
    @TempTableColumnOrder(10)
    private int shinsakaiIinTeiin;
    @TempTableColumnOrder(11)
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    @TempTableColumnOrder(12)
    private Code shinsakaiShinchokuJokyo;
    @TempTableColumnOrder(13)
    private int shinsakaiWariateZumiNinzu;
    @TempTableColumnOrder(14)
    private boolean shiryoSakuseiZumiFlag;
    @TempTableColumnOrder(15)
    private RString shinsakaiIinCode;
    @TempTableColumnOrder(16)
    private FlexibleDate shinsakaiKaisaiYMD;
    @TempTableColumnOrder(17)
    private Code kaigoninteiShinsakaiGichoKubunCode;
    @TempTableColumnOrder(18)
    private boolean shussekiFlag;
    @TempTableColumnOrder(19)
    private boolean existChikokuFlag;
    @TempTableColumnOrder(20)
    private RString shussekiTime;
    @TempTableColumnOrder(21)
    private boolean existSotaiFlag;
    @TempTableColumnOrder(22)
    private RString taisekiTime;
}
