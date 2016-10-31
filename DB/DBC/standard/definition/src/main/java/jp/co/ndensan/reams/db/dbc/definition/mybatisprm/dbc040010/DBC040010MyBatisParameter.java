/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010;

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
public class DBC040010MyBatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private RString 処理名;
    private RString 市町村コード;

    /**
     * DBC020080MyBatisParameterのコンストラクタです。
     *
     * @param 出力順 RString
     * @param 処理名 RString
     * @param 市町村コード RString
     */
    public DBC040010MyBatisParameter(
            RString 出力順,
            RString 処理名,
            RString 市町村コード) {
        this.出力順 = RString.isNullOrEmpty(出力順) ? null : 出力順;
        this.処理名 = 処理名;
        this.市町村コード = 市町村コード;
    }

}
