/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050.KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(利用者負担割合トリガデータ抽出ProcessParameter)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter implements IBatchProcessParameter {

    private RString 出力順;
    private RDateTime 抽出期間開始日時;
    private RDateTime 抽出期間終了日時;

    /**
     *
     * @param 出力順 RString
     * @param 抽出期間開始日時 RDateTime
     * @param 抽出期間終了日時 RDateTime
     */
    public KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter(RString 出力順, RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時) {
        this.出力順 = 出力順;
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
    }

    public KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter toKoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter() {
        return new KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter(出力順);
    }
}
