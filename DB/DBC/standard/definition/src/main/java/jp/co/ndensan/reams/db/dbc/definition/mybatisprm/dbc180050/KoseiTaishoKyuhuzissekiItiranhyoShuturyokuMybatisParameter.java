/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(更正対象給付実績情報取得MybatisParameter)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter implements IMyBatisParameter {

    private RString 出力順;

    public KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter(RString 出力順) {

        this.出力順 = 出力順;
    }
}
