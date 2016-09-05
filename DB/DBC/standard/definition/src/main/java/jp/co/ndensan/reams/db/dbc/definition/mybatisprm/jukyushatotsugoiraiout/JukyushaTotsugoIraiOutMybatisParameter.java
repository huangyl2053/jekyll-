/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushatotsugoiraiout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 * バッチ設計_DBCMNF1003_536_受給者突合依頼情報作成Mybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JukyushaTotsugoIraiOutMybatisParameter implements IMyBatisParameter {

    /**
     * コンストラクタです。
     *
     */
    protected JukyushaTotsugoIraiOutMybatisParameter() {
    }

    /**
     * @return JukyushaTotsugoIraiOutMybatisParameter
     */
    public static JukyushaTotsugoIraiOutMybatisParameter createParam() {
        return new JukyushaTotsugoIraiOutMybatisParameter();
    }
}
