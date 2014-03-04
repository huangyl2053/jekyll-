/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医情報を管理するインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IShujiiJohoDac {

    /**
     * 市町村コード、介護医療機関コード、医師コードで指定された主治医情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医師コード 医師コード
     * @return 主治医情報エンティティ
     */
    @Transaction
    DbT7012ShujiiJohoEntity select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, ShikibetsuCode 医師コード);
}
