/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hyojundankaitemp;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 標準設定段階Temp一時
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HyojunDankaiTemp extends DbTableEntityBase<HyojunDankaiTemp> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(2)
    private RString 標準設定段階1;
    @TempTableColumnOrder(3)
    private RString 標準設定段階2;
}
