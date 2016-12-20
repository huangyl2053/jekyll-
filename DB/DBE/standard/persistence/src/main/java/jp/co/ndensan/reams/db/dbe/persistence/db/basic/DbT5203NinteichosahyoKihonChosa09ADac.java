/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa09A;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa09A.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa09A.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa09AEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（基本調査）09A情報を取得します。
 *
 * @author n8429
 */
public class DbT5203NinteichosahyoKihonChosa09ADac  implements ISaveable<DbT5203NinteichosahyoKihonChosa09AEntity> {
         @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票（基本調査）09A情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号
     * @return DbT5203NinteichosahyoKihonChosa09AEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5203NinteichosahyoKihonChosa09AEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号, 
            int 認定調査依頼履歴番号 
            ) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5203NinteichosahyoKihonChosa09A.class).
                 where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号))).
                toObject(DbT5203NinteichosahyoKihonChosa09AEntity.class);
    }

    @Override
    public int save(DbT5203NinteichosahyoKihonChosa09AEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査）09Aエンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
