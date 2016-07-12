/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 平準化計算結果TempEntity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity implements IMyBatisParameter {

    private Decimal 変更後特徴期別額_１期;
    private Decimal 変更後特徴期別額_２期;
    private Decimal 変更後特徴期別額_３期;
    private TsuchishoNo 通知書番号;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity() {
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
    public TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity(Decimal 変更後特徴期別額_１期, Decimal 変更後特徴期別額_２期,
            Decimal 変更後特徴期別額_３期, TsuchishoNo 通知書番号) {
        this.変更後特徴期別額_１期 = 変更後特徴期別額_１期;
        this.変更後特徴期別額_２期 = 変更後特徴期別額_２期;
        this.変更後特徴期別額_３期 = 変更後特徴期別額_３期;
        this.通知書番号 = 通知書番号;
    }
}
