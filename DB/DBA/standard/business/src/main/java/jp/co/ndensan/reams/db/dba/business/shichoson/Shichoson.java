/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.shichoson;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class Shichoson {

    private LasdecCode 旧市町村コード;
    private RString 旧市町村名称;

    /**
     * コンストラクタです。
     */
    public Shichoson() {
    }

    /**
     * コンストラクタです。
     *
     * @param 旧市町村コード 旧市町村コード
     * @param 旧市町村名称 旧市町村名称
     */
    public Shichoson(
            LasdecCode 旧市町村コード,
            RString 旧市町村名称) {
        this.旧市町村コード = 旧市町村コード;
        this.旧市町村名称 = 旧市町村名称;
    }

    /**
     * 旧市町村コードを取得します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return 旧市町村コード;
    }

    /**
     * 旧市町村名称を取得します。
     *
     * @return 旧市町村名称
     */
    public RString get旧市町村名称() {
        return 旧市町村名称;
    }

    /**
     *
     * @param 旧市町村コード 旧市町村コード
     */
    public void set旧市町村コード(LasdecCode 旧市町村コード) {
        this.旧市町村コード = 旧市町村コード;
    }

    /**
     *
     * @param 旧市町村名称 旧市町村名称
     */
    public void set旧市町村名称(RString 旧市町村名称) {
        this.旧市町村名称 = 旧市町村名称;
    }

}
