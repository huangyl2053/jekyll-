/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.servicetype;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類検索結果を管理するクラスです。
 *
 */
public class ServiceTypeModel implements Serializable {

    private static final long serialVersionUID = 5346900601026939093L;

    private RString サービス種類コード;
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
     * サービス種類名称を返します。
     *
     * @return サービス種類名称
     */
    public RString getサービス種類名称() {
        return サービス種類名称;
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
     * サービス種類名称を設定します。
     *
     * @param サービス種類名称 サービス種類名称
     */
    public void setサービス種類名称(RString サービス種類名称) {
        this.サービス種類名称 = サービス種類名称;
    }
}
