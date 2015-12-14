/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.servicecode;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * サービスコード入力ガイドのダイアログパラメータクラスです。
 */
public class ServiceCodeModel implements Serializable {

    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString サービス種類名称;

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public RString getサービス種類コード() {
        return サービス種類コード;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public void setサービス種類コード(RString サービス種類コード) {
        this.サービス種類コード = サービス種類コード;
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public RString getサービス項目コード() {
        return サービス項目コード;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public void setサービス項目コード(RString サービス項目コード) {
        this.サービス項目コード = サービス項目コード;
    }

    /**
     * サービス種類名称を返します。
     *
     * @return サービス項目コード
     */
    public RString getサービス種類名称() {
        return サービス種類名称;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス種類名称 サービス種類名称
     */
    public void setサービス種類名称(RString サービス種類名称) {
        this.サービス種類名称 = サービス種類名称;
    }

}
