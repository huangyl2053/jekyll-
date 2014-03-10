/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報を管理するインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface INinteiChosaIraiJohoDac {

    /**
     * 申請書管理番号と認定調査依頼履歴番号から、認定調査依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査依頼情報
     */
    @Transaction
    DbT5006NinteichosaIraiJohoEntity select(RString 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号);
}
