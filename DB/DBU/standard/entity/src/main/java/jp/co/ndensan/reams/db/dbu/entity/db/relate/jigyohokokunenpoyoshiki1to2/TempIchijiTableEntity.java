/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 事業状況報告年報　様式１・２の一時テーブルのEntityクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class TempIchijiTableEntity extends DbTableEntityBase<TempIchijiTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private FlexibleYear choteiNendo;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(4)
    private RString kazeiKubun;
    @TempTableColumnOrder(5)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(6)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(7)
    private int shotokuDankaiIndex;
    @TempTableColumnOrder(8)
    private RString shotokuDankai;
    @TempTableColumnOrder(9)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(10)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(11)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(12)
    private LasdecCode kyuShichosonCode;
}
