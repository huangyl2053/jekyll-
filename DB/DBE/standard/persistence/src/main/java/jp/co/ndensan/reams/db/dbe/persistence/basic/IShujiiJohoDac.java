/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医情報を管理するインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IShujiiJohoDac {

    /**
     * 証記載保険者番号、介護医療機関コード、医師コードで指定された主治医情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @return 主治医情報エンティティ
     */
    @Transaction
    DbT7012ShujiiJohoEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード);
}
