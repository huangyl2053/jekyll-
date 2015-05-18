/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.db.dbz.persistence.IUpdatable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査特記事項テーブルの情報を取得するDACのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface INinteichosaTokkijikoDac extends IInsertable<DbT5010NinteichosaTokkijikoEntity>,
        IUpdatable<DbT5010NinteichosaTokkijikoEntity>, IDeletable<DbT5010NinteichosaTokkijikoEntity>,
        IReplaceable<DbT5010NinteichosaTokkijikoEntity> {

    /**
     * 申請書管理番号と認定調査依頼履歴番号を指定して、認定調査特記事項の情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定調査特記事項Entity
     */
    @Transaction
    List<DbT5010NinteichosaTokkijikoEntity> select(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号);

    /**
     * 申請書管理番号を指定して、認定調査特記事項Entityのリストを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査特記事項Entityのリスト
     */
    @Transaction
    List<DbT5010NinteichosaTokkijikoEntity> select(ShinseishoKanriNo 申請書管理番号);

    @Override
    int delete(DbT5010NinteichosaTokkijikoEntity data);

    @Override
    int insertOrUpdate(DbT5010NinteichosaTokkijikoEntity data);
}
