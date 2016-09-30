/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 所得情報抽出・連携_広域のバッチ 介護所得TempのEntity
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoShotoTempTableEntity extends DbTableEntityBase<KaigoShotoTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(2)
    private RString shichosonShikibetuId;
    @TempTableColumnOrder(3)
    @PrimaryKey
    private FlexibleYear shotoNendo;
    @TempTableColumnOrder(4)
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(5)
    @PrimaryKey
    private int rirekiNo;
    @TempTableColumnOrder(6)
    private RString kazeiKubun;
    @TempTableColumnOrder(7)
    private RString kazeiKubunGemmenGo;
    @TempTableColumnOrder(8)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(9)
    private Decimal nenkiniShunyuGaku;
    @TempTableColumnOrder(10)
    private Decimal nenkiniShotokuGaku;
    @TempTableColumnOrder(11)
    private Decimal kazeiShotoGaku;
    @TempTableColumnOrder(12)
    private RString gekihenkanwaKubun;
    @TempTableColumnOrder(13)
    private RString yuusenKunbun;
    @TempTableColumnOrder(14)
    private YMDHMS shoriTimeStamp;
}
