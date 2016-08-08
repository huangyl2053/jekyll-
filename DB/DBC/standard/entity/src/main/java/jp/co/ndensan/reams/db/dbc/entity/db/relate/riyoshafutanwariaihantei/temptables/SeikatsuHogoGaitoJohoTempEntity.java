/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 生活保護該当情報の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuHogoGaitoJohoTempEntity extends DbTableEntityBase<SeikatsuHogoGaitoJohoTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    //対象年度
    private RString taishoNendo;
    @TempTableColumnOrder(2)
    //対象月
    private RString taishoGetsu;
    @TempTableColumnOrder(3)
    //識別コード
    private RString shikibetsuCode;
    @TempTableColumnOrder(4)
    //受給開始日
    private FlexibleDate jukyuKaishibi;
    @TempTableColumnOrder(5)
    //受給廃止日
    private FlexibleDate jukyuShuryobi;

}
