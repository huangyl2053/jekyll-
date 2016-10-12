/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080MyBatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private RString 処理名;

    /**
     * DBC020080MyBatisParameterのコンストラクタです。
     *
     * @param 出力順 RString
     * @param 処理名 RString
     *
     */
    public DBC020080MyBatisParameter(
            RString 出力順,
            RString 処理名) {
        this.出力順 = RString.isNullOrEmpty(出力順) ? null : 出力順;
        this.処理名 = 処理名;
    }

}
