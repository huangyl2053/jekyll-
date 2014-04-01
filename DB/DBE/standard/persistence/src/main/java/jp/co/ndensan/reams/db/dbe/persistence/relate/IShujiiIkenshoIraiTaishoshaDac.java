/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼対象者を取得するインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IShujiiIkenshoIraiTaishoshaDac {

    /**
     * 指定した証記載保険者番号に該当する、主治医意見書登録完了年月日が”00000000”のデータを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 介護認定進捗情報エンティティ
     */
    @Transaction
    List<DbT5005NinteiShinchokuJohoEntity> select主治医意見書作成依頼対象者(ShoKisaiHokenshaNo 証記載保険者番号);

    /**
     * 指定した証記載保険者番号、支所コードに該当する、主治医意見書登録完了年月日が”00000000”のデータを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 介護認定進捗情報エンティティ
     */
    @Transaction
    List<DbT5005NinteiShinchokuJohoEntity> select主治医意見書作成依頼対象者(ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード);
}
