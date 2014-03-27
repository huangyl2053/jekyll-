/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書取込対象者を取得するインターフェースです。
 * 要介護認定進捗情報から、主治医意見書作成依頼完了年月日が”00000000”以上で、主治医意見書登録完了年月日が”00000000”のデータを取得します。
 *
 * @author N8187 久保田 英男
 */
public interface IShujiiIkenshoTorikomiTaishoshaDac {

    /**
     * 主治医意見書取込対象者を全件取得します。
     *
     * @return 対象者のリスト
     */
    @Transaction
    List<DbT5001NinteiShinseiJohoEntity> selectAll();

    /**
     * 市町村コードを元に、主治医意見書取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 取込対象者のリスト
     */
    @Transaction
    List<DbT5001NinteiShinseiJohoEntity> select市町村コード(ShichosonCode 市町村コード);

    /**
     * 市町村コードと支所コードを元に、主治医意見書取込対象者を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return 取込対象者のリスト
     */
    @Transaction
    List<DbT5001NinteiShinseiJohoEntity> select市町村コード及び支所コード(ShichosonCode 市町村コード, RString 支所コード);
}
