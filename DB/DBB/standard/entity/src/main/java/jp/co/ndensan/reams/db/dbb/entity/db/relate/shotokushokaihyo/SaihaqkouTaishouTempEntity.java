/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 再発行対象者Tempのクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaihaqkouTaishouTempEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(2)
    private LasdecCode shokaisakiLasdecCode;
    @TempTableColumnOrder(3)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(4)
    private YMDHMS sakuseiTimestamp;
    @TempTableColumnOrder(5)
    private RString kazeiKubun;
    @TempTableColumnOrder(6)
    private RString kazeiKubunGemmenGo;
    @TempTableColumnOrder(7)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(8)
    private Decimal nenkiniShunyuGaku;
    @TempTableColumnOrder(9)
    private Decimal nenkiniShotokuGaku;
    @TempTableColumnOrder(10)
    private Decimal kazeiShotokuGaku;
    @TempTableColumnOrder(11)
    private RString torokuGyomu;

}
