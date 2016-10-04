/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.setaiinhaakuinputtable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 世帯員把握入力テーブル一時
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TmpSetaiHaaku extends DbTableEntityBase<TmpSetaiHaaku> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private FlexibleDate kijunYMD;
    @TempTableColumnOrder(4)
    private FlexibleYear shotokuNendo;
    @TempTableColumnOrder(5)
    private RString jushochiTokureiFlag;

}
