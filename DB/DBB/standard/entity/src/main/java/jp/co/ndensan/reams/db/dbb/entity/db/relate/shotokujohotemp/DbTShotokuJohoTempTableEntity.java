/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotemp;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 所得情報抽出・連携_広域のバッチ 所得情報TempのEntity
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbTShotokuJohoTempTableEntity extends DbTableEntityBase<DbTShotokuJohoTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(2)
    private RString shikibetuId;
    @TempTableColumnOrder(3)
    private RString timeStep;
    @TempTableColumnOrder(4)
    private RString saisyuRecordKunbun;
    @TempTableColumnOrder(5)
    private int renben;
    @TempTableColumnOrder(6)
    private RString filler;
    @TempTableColumnOrder(7)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(8)
    private ShikibetsuCode jyuuminCode;
    @TempTableColumnOrder(9)
    private RString shotoKunbun;
    @TempTableColumnOrder(10)
    private RString hiKazeiKunbun;
    @TempTableColumnOrder(11)
    private RString jyuuminseiKiru;
    @TempTableColumnOrder(12)
    private RString jyuuminseiIziKiru;
    @TempTableColumnOrder(13)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(14)
    private Decimal agiShunyuGaku;
    @TempTableColumnOrder(15)
    private Decimal nenkiniShunyuGaku;
    @TempTableColumnOrder(16)
    private Decimal nenkiniShotokuGaku;
    @TempTableColumnOrder(17)
    private RString sonotaSyutoku1;
    @TempTableColumnOrder(18)
    private RString sonotaSyutoku2;
    @TempTableColumnOrder(19)
    private RString yobi;
    @TempTableColumnOrder(20)
    private RString gekihenkanwaKubun;
    @TempTableColumnOrder(21)
    private RString dataShubetsu;
    @TempTableColumnOrder(22)
    private Decimal shotoZei;
    @TempTableColumnOrder(23)
    private RString updateTimestamp;
}
