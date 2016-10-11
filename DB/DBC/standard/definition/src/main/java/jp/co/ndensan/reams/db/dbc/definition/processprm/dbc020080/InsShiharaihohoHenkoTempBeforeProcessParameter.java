/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.InsShiharaihohoHenkoTempBeforeMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class InsShiharaihohoHenkoTempBeforeProcessParameter implements IBatchProcessParameter {

    private boolean 事業分フラグ;

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     */
    public InsShiharaihohoHenkoTempBeforeProcessParameter() {
    }

    /**
     * InsShiharaihohoHenkoTempBeforeProcessParameterのコンストラクタです。
     *
     * @param 事業分フラグ boolean
     */
    public InsShiharaihohoHenkoTempBeforeProcessParameter(boolean 事業分フラグ) {
        this.事業分フラグ = 事業分フラグ;
    }

    /**
     * toInsShiharaihohoHenkoTempBeforeMyBatisParameterのコンストラクタです
     *
     * @return InsShiharaihohoHenkoTempBeforeMyBatisParameter
     */
    public InsShiharaihohoHenkoTempBeforeMyBatisParameter toInsShiharaihohoHenkoTempBeforeMyBatisParameter() {
        return new InsShiharaihohoHenkoTempBeforeMyBatisParameter(事業分フラグ);
    }
}
