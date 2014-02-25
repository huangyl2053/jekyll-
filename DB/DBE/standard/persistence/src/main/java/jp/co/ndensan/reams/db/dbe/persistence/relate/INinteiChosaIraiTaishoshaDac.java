/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼対象者を取得するインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface INinteiChosaIraiTaishoshaDac {

    /**
     * 要介護認定進捗情報から、指定した市町村コードに該当する、認定調査完了年月日が”00000000”のデータを取得する
     *
     * @param 市町村コード 市町村コード
     * @return 要介護認定進捗情報データのリスト
     */
    @Transaction
    List<DbT5005NinteiShinchokuJohoEntity> select(ShichosonCode 市町村コード);
}
