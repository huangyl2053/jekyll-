/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkan.kyuChosaItakusakiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkan.kyuChosainNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧調査委託先調査員番号変換テーブルのデータアクセスクラスです。
 */
public class DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac implements ISaveable<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧調査委託先調査員番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧調査委託先番号 KyuChosaItakusakiNo
     * @param 旧調査員番号 KyuChosainNo
     * @return DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧調査委託先番号,
            RString 旧調査員番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号"));
        requireNonNull(旧調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7029ShinKyuChosaItakusakiChosainNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuChosaItakusakiNo, 旧調査委託先番号),
                                eq(kyuChosainNo, 旧調査員番号))).
                toObject(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity.class);
    }

    /**
     * 新旧調査委託先調査員番号変換テーブルを全件返します。
     *
     * @return List<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity>
     */
    @Transaction
    public List<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7029ShinKyuChosaItakusakiChosainNoHenkan.class).
                toList(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity.class);
    }

    /**
     * DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧調査委託先調査員番号変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
