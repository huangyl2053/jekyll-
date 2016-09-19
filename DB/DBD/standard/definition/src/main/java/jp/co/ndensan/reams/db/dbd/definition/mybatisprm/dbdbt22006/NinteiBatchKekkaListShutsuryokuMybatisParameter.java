/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt22006;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 負担限度額認定申請一括承認（バッチ）_結果一覧出力MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiBatchKekkaListShutsuryokuMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 認定期間_開始日;
    private FlexibleDate 認定期間_終了日;

    /**
     * コンストラクタです。
     *
     * @param 認定期間_開始日
     * @param 認定期間_終了日
     */
    public NinteiBatchKekkaListShutsuryokuMybatisParameter(
            FlexibleDate 認定期間_開始日,
            FlexibleDate 認定期間_終了日) {
        this.認定期間_開始日 = 認定期間_開始日;
        this.認定期間_終了日 = 認定期間_終了日;
    }

}
