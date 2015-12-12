/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5009NinteichosahyoJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115Image;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115Image.imageSharedFileId;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * イメージ情報のデータアクセスクラスです。
 */
public class DbT5115ImageDac implements ISaveable<DbT5115ImageEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーでイメージ情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param イメージ共有ファイルID イメージ共有ファイルID
     * @return DbT5115ImageEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5115ImageEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            RDateTime イメージ共有ファイルID) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("イメージ共有ファイルID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5115Image.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(imageSharedFileId, イメージ共有ファイルID))).
                toObject(DbT5115ImageEntity.class);
    }

    /**
     * イメージ情報を全件返します。
     *
     * @return DbT5115ImageEntityの{@code list}
     */
    @Transaction
    public List<DbT5115ImageEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5115Image.class).
                toList(DbT5115ImageEntity.class);
    }

    /**
     * DbT5115ImageEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5115ImageEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("イメージ情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
