/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050.ShoriHidukeKanriTeburuKoshiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(処理日付管理テーブル更新ProcessParameter)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriHidukeKanriTeburuKoshiProcessParameter implements IBatchProcessParameter {

    private RDateTime 抽出期間開始日時;
    private RDateTime 抽出期間終了日時;

    /**
     *
     * @param 抽出期間開始日時 RDateTime
     * @param 抽出期間終了日時 RDateTime
     */
    public ShoriHidukeKanriTeburuKoshiProcessParameter(RDateTime 抽出期間開始日時, RDateTime 抽出期間終了日時) {

        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
    }

    public ShoriHidukeKanriTeburuKoshiMybatisParameter toMybatisParameter() {
        return new ShoriHidukeKanriTeburuKoshiMybatisParameter(ShoriName.更正対象給付実績一覧.get名称());
    }
}
