/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGenndoGakuNinnteiTempTableEntity extends DbTableEntityBase<FutanGenndoGakuNinnteiTempTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("FutanGenndoGakuNinnteiTempTable");

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private boolean ninteishoHakkoZumi;
    @TempTableColumnOrder(3)
    private boolean tsuchiHakkoZumi;
    @TempTableColumnOrder(4)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(5)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(6)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(7)
    private FlexibleDate tekiyoYMD;
    @TempTableColumnOrder(8)
    private FlexibleDate yukoKigenYMD;
    @TempTableColumnOrder(9)
    private RString ketteiKubun;
    @TempTableColumnOrder(10)
    private RString riyoshaFutanDankai;
}
