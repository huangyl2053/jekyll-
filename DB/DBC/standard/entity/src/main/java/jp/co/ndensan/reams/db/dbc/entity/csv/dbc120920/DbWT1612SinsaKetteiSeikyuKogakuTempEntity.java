/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求高額一時
 *
 * @reamsid_L DBC-2500-013 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1612SinsaKetteiSeikyuKogakuTempEntity extends DbTableEntityBase<DbWT1612SinsaKetteiSeikyuKogakuTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int kogakuRirekiNo;
    @TempTableColumnOrder(2)
    private Decimal kogakuGaitoKensu;
    @TempTableColumnOrder(3)
    private Decimal kogakuKaigoServicehi;
    @TempTableColumnOrder(4)
    private Decimal kogakuKohiFutangaku;
}
