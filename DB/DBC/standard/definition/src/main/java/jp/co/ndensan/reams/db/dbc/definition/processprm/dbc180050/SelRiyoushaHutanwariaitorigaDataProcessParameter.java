/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050.SelRiyoushaHutanwariaitorigaDataMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
public class SelRiyoushaHutanwariaitorigaDataProcessParameter implements IBatchProcessParameter {

    private RDateTime 抽出期間開始日時;
    private RDateTime 抽出期間終了日時;

    public SelRiyoushaHutanwariaitorigaDataProcessParameter(RDateTime 抽出期間開始日時, RDateTime 抽出期間終了日時) {

        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
    }

    public SelRiyoushaHutanwariaitorigaDataMybatisParameter toSelRiyoushaHutanwariaitorigaDataMybatisParameter() {

        SelRiyoushaHutanwariaitorigaDataMybatisParameter parameter = new SelRiyoushaHutanwariaitorigaDataMybatisParameter();
        parameter.set抽出期間開始日時(抽出期間開始日時);
        parameter.set抽出期間終了日時(抽出期間終了日時);
        return parameter;
    }

}
