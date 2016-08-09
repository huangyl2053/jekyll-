/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 今回利用者負担割合情報の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KonkaiRiyoshaFutanWariaiJohoTempEntity
        extends DbTableEntityBase<KonkaiRiyoshaFutanWariaiJohoTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    //年度
    private RString nendo;
    @TempTableColumnOrder(2)
    //被保険者番号
    private RString hihokenshaNo;
    @TempTableColumnOrder(3)
    //枝番号
    private RString edaNo;
    @TempTableColumnOrder(4)
    //負担割合区分
    private boolean futanWariaiKubun;
    @TempTableColumnOrder(5)
    //有効開始日
    private RString yukoKaishiDate;
    @TempTableColumnOrder(6)
    //有効終了日
    private RString yukoShuryoDate;
    @TempTableColumnOrder(7)
    //本人合計所得金額
    private RString honinGokeishotokuKingaku;
    @TempTableColumnOrder(8)
    //世帯１号被保険者数
    private Integer SetaiFirstHihokenshaNo;
    @TempTableColumnOrder(9)
    //年金収入合計
    private RString nenkinShunyuGokei;
    @TempTableColumnOrder(10)
    //その他の合計所得金額合計
    private RString sonotaGokeiShotokuKingakuGokei;
    @TempTableColumnOrder(11)
    //更正事由
    private RString koseiJiyu;

}
