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
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(処理日付管理テーブル更新MybatisParameter)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriHidukeKanriTeburuKoshiMybatisParameter implements IMyBatisParameter {

    private RString 処理名;

    /**
     *
     * @param 処理名 RString
     */
    public ShoriHidukeKanriTeburuKoshiMybatisParameter(RString 処理名) {
        this.処理名 = 処理名;
    }
}
