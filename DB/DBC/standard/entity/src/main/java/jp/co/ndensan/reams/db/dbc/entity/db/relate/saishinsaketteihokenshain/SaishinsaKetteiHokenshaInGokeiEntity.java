/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 *
 * 再審査決定通知書情報取込（保険者分）一時テーブル（集計）Entity
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInGokeiEntity
        extends DbTableEntityBase<SaishinsaKetteiHokenshaInGokeiEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private FlexibleYearMonth toriatsukaiYM;
    @TempTableColumnOrder(2)
    private int rirekiNo;
    @TempTableColumnOrder(3)
    private Decimal kaigoKyufuhiSeikyuKensu;
    @TempTableColumnOrder(4)
    private Decimal kaigoKyufuhiSeikyuTanisu;
    @TempTableColumnOrder(5)
    private Decimal kaigoKyufuhiSeikyuFutangaku;
    @TempTableColumnOrder(6)
    private Decimal kaigoKyufuhiKetteiKensu;
    @TempTableColumnOrder(7)
    private Decimal kaigoKyufuhiKetteiTanisu;
    @TempTableColumnOrder(8)
    private Decimal kaigoKyufuhiKetteiFutangaku;
    @TempTableColumnOrder(9)
    private Decimal kaigoKyufuhiChoseiKensu;
    @TempTableColumnOrder(10)
    private Decimal kaigoKyufuhiChoseiTanisu;
    @TempTableColumnOrder(11)
    private Decimal kaigoKyufuhiChoseiFutangaku;
    @TempTableColumnOrder(12)
    private Decimal kogakuKaigoServicehiSeikyuKensu;
    @TempTableColumnOrder(13)
    private Decimal kogakuKaigoServicehiSeikyuTanisu;
    @TempTableColumnOrder(14)
    private Decimal kogakuKaigoServicehiSeikyuFutangaku;
    @TempTableColumnOrder(15)
    private Decimal kogakuKaigoServicehiKetteiKensu;
    @TempTableColumnOrder(16)
    private Decimal kogakuKaigoServicehiKetteiTanisu;
    @TempTableColumnOrder(17)
    private Decimal kogakuKaigoServicehiKetteiFutangaku;
    @TempTableColumnOrder(18)
    private Decimal kogakuKaigoServicehiChoseiKensu;
    @TempTableColumnOrder(19)
    private Decimal kogakuKaigoServicehiChoseiTanisu;
    @TempTableColumnOrder(20)
    private Decimal kogakuKaigoServicehiChoseiFutangaku;
    @TempTableColumnOrder(21)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(22)
    private RString shoKisaiHokenshaName;
    @TempTableColumnOrder(23)
    private FlexibleDate sakuseiYMD;
    @TempTableColumnOrder(24)
    private RString kokukoRengoukaiNa;
    @TempTableColumnOrder(25)
    private RString sinsaiinkaiName;
}
