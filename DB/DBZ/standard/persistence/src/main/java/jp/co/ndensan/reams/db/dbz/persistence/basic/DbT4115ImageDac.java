/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4115Image;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4115Image.genponMaskKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4115Image.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4115Image.torikomiPageNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4115ImageEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * イメージ情報のデータアクセスクラスです。
 */
public class DbT4115ImageDac implements ISaveable<DbT4115ImageEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーでイメージ情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 取込ページ番号 取込ページ番号
     * @param 原本マスク分 原本マスク分
     * @return DbT4115ImageEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4115ImageEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 取込ページ番号,
            Code 原本マスク分) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(取込ページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込ページ番号"));
        requireNonNull(原本マスク分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4115Image.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(torikomiPageNo, 取込ページ番号),
                                eq(genponMaskKubun, 原本マスク分))).
                toObject(DbT4115ImageEntity.class);
    }

    /**
     * イメージ情報を全件返します。
     *
     * @return DbT4115ImageEntityの{@code list}
     */
    @Transaction
    public List<DbT4115ImageEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4115Image.class).
                toList(DbT4115ImageEntity.class);
    }

    /**
     * DbT4115ImageEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4115ImageEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("イメージ情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
