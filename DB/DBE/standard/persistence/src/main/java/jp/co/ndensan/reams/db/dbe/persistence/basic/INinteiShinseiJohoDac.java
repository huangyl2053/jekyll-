/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報を管理するインターフェースです
 *
 * @author N8187 久保田 英男
 */
public interface INinteiShinseiJohoDac {

    /**
     * 市町村コード・申請書管理番号から要介護認定申請情報を取得する。
     *
     * @param 市町村コード 市町村コード
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定申請情報データ
     */
    @Transaction
    DbT5001NinteiShinseiJohoEntity select(ShichosonCode 市町村コード, RString 申請書管理番号);

    /**
     * 申請書管理番号から要介護認定申請情報を取得する。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定申請情報データ
     */
    @Transaction
    DbT5001NinteiShinseiJohoEntity select申請書管理番号(RString 申請書管理番号);
}
