/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt22006;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 負担限度額認定申請一括承認（バッチ）_処理対象の特定MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiBatchTaishoTokuteiMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 申請日開始;
    private FlexibleDate 申請日終了;

    /**
     * コンストラクタです。
     *
     * @param 申請日開始 FlexibleDate
     * @param 申請日終了 FlexibleDate
     */
    public NinteiBatchTaishoTokuteiMybatisParameter(
            FlexibleDate 申請日開始,
            FlexibleDate 申請日終了) {
        this.申請日開始 = 申請日開始;
        this.申請日終了 = 申請日終了;
    }
}
