/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmen.shinseisho.hakko;

import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_4_介護保険負担限度額認定申請書のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuMybatisParameter implements IMyBatisParameter {

    private final UUID 発行処理ID;
    private final boolean 出力フラグ;
    private final RString 出力順;
    private final FlexibleDate 基準日;
    private final FlexibleDate 発行日;

    /**
     * コンストラクタです。
     *
     * @param 発行処理ID 発行処理ID
     * @param 出力フラグ 出力フラグ
     * @param 出力順 出力順
     * @param 基準日 基準日
     * @param 発行日 発行日
     */
    public FutanGendogakuMybatisParameter(
            UUID 発行処理ID,
            boolean 出力フラグ,
            RString 出力順,
            FlexibleDate 基準日,
            FlexibleDate 発行日) {
        this.発行処理ID = 発行処理ID;
        this.出力フラグ = 出力フラグ;
        this.出力順 = 出力順;
        this.基準日 = 基準日;
        this.発行日 = 発行日;
    }

}
