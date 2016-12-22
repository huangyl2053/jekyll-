/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyo.ninteichosaRirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyo.remban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyo.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
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
 *
 * @author n8429
 */
public class DbT5207NinteichosahyoServiceJokyoDac implements ISaveable<DbT5207NinteichosahyoServiceJokyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査票（概況調査）サービスの状況を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号
     * @param 連番 int
     * @return DbT5207NinteichosahyoServiceJokyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5207NinteichosahyoServiceJokyoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番
    ) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5207NinteichosahyoServiceJokyo.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ninteichosaRirekiNo, 認定調査依頼履歴番号),
                                eq(remban, 連番))).
                toObject(DbT5207NinteichosahyoServiceJokyoEntity.class);
    }

    @Override
    public int save(DbT5207NinteichosahyoServiceJokyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）サービスの状況エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
