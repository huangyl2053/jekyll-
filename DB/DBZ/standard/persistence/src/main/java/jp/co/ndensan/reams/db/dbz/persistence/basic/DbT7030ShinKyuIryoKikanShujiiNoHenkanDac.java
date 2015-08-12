/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkan.kyuIryoKikanNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkan.kyuShujiiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
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
 * 新旧医療機関主治医番号変換テーブルのデータアクセスクラスです。
 */
public class DbT7030ShinKyuIryoKikanShujiiNoHenkanDac implements ISaveable<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧医療機関主治医番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧医療機関番号 KyuIryoKikanNo
     * @param 旧主治医番号 KyuShujiiNo
     * @return DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧医療機関番号,
            RString 旧主治医番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号"));
        requireNonNull(旧主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7030ShinKyuIryoKikanShujiiNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuIryoKikanNo, 旧医療機関番号),
                                eq(kyuShujiiNo, 旧主治医番号))).
                toObject(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class);
    }

    /**
     * 新旧医療機関主治医番号変換テーブルを全件返します。
     *
     * @return List<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity>
     */
    @Transaction
    public List<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7030ShinKyuIryoKikanShujiiNoHenkan.class).
                toList(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class);
    }

    /**
     * DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧医療機関主治医番号変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
