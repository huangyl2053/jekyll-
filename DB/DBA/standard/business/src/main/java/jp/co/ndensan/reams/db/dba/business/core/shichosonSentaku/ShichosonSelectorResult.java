/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.shichosonSentaku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村選択検索結果を管理するクラスです。
 *
 */
public class ShichosonSelectorResult implements Serializable {

    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString 合併旧市町村区分;

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード　LasdecCode
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        this.市町村コード = 市町村コード;
    }

    /**
     * 市町村名を設定します。
     *
     * @param 市町村名　RString
     */
    public void set市町村名(RString 市町村名) {
        this.市町村名 = 市町村名;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村名
     */
    public RString get市町村名() {
        return 市町村名;
    }

    /**
     * 合併旧市町村区分を取得します。
     *
     * @return 合併旧市町村区分
     */
    public RString get合併旧市町村区分() {
        return 合併旧市町村区分;
    }

    /**
     * 合併旧市町村区分を設定します。
     *
     * @param 合併旧市町村区分　RString
     */
    public void set合併旧市町村区分(RString 合併旧市町村区分) {
        this.合併旧市町村区分 = 合併旧市町村区分;
    }
}
