/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * {@link ShikibetsuCode 識別コード}が取得可能であることをあらわします。
 *
 * @author N3327 三浦 凌
 */
public interface IShikibetsuCodeGettable {

    /**
     * 識別コードを返します。
     *
     * @return {@link ShikibetsuCode 識別コード}
     */
    ShikibetsuCode get識別コード();
}
