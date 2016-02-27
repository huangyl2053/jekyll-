/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.shikakushutokujogaishakanri;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 資格取得除外者一覧取得を特定するためのMyBatis用パラメータクラスです。
 */
public class ShikakuShutokuJogaishaKanriParameter {

    private ShikibetsuCode 識別コード;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     *
     * @param 識別コード ShikibetsuCode
     * @param psmShikibetsuTaisho RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public ShikakuShutokuJogaishaKanriParameter(
            ShikibetsuCode 識別コード,
            RString psmShikibetsuTaisho
    ) {

        this.識別コード = 識別コード;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * psmShikibetsuTaishoを返します
     *
     * @return psmShikibetsuTaisho
     */
    public RString getPsmShikibetsuTaisho() {
        return psmShikibetsuTaisho;
    }

}
