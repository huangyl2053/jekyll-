/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka8batch;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 平準化計算結果TempEntity
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaHachiTempEntity
        extends DbTableEntityBase<TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity>
        implements IDbAccessable, IMyBatisParameter {

    @TempTableColumnOrder(1)
    private Decimal 変更後特徴期別額_１期;
    @TempTableColumnOrder(2)
    private Decimal 変更後特徴期別額_２期;
    @TempTableColumnOrder(3)
    private Decimal 変更後特徴期別額_３期;
    @TempTableColumnOrder(4)
    private TsuchishoNo 通知書番号;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaHachiTempEntity() {
        this.変更後特徴期別額_１期 = null;
        this.変更後特徴期別額_２期 = null;
        this.変更後特徴期別額_３期 = null;
        this.通知書番号 = null;
    }

    /**
     * コンストラクタです。
     *
     * @param 変更後特徴期別額_１期 Decimal
     * @param 変更後特徴期別額_２期 Decimal
     * @param 変更後特徴期別額_３期 Decimal
     * @param 通知書番号 TsuchishoNo
     */
    public TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaHachiTempEntity(Decimal 変更後特徴期別額_１期, Decimal 変更後特徴期別額_２期,
            Decimal 変更後特徴期別額_３期, TsuchishoNo 通知書番号) {
        this.変更後特徴期別額_１期 = 変更後特徴期別額_１期;
        this.変更後特徴期別額_２期 = 変更後特徴期別額_２期;
        this.変更後特徴期別額_３期 = 変更後特徴期別額_３期;
        this.通知書番号 = 通知書番号;
    }
}
