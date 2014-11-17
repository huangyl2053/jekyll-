/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static java.util.Objects.requireNonNull;

/**
 * 介護資格基本情報の検索キーを作成するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoShikakuKihonSearchKeyBuilder {

    private final LasdecCode 市町村コード;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @throws NullPointerException 引数がnullの場合
     */
    public KaigoShikakuKihonSearchKeyBuilder(LasdecCode 市町村コード, ShikibetsuCode 識別コード) throws NullPointerException {
        this.市町村コード = requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.識別コード = requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村コード;
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
     * 設定値を元に検索キークラスを作成して返します。
     *
     * @return 介護資格基本情報の検索キー
     */
    public KaigoShikakuKihonSearchKey build() {
        return new KaigoShikakuKihonSearchKey(this);
    }
}
