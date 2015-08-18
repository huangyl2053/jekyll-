/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaicho.edaban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaicho.jukyuShinseiJiyu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaicho.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaicho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳Aliveのデータアクセスクラスです。
 */
public class DbV4001JukyushaDaichoAliveDac implements ISaveable<DbV4001JukyushaDaichoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受給者台帳Aliveを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @return DbV4001JukyushaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV4001JukyushaDaichoEntity selectByKey(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV4001JukyushaDaicho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(edaban, 枝番),
                                eq(jukyuShinseiJiyu, 受給申請事由))).
                toObject(DbV4001JukyushaDaichoEntity.class);
    }

    /**
     * 受給者台帳Aliveを全件返します。
     *
     * @return DbV4001JukyushaDaichoEntityの{@code list}
     */
    @Transaction
    public List<DbV4001JukyushaDaichoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV4001JukyushaDaicho.class).
                toList(DbV4001JukyushaDaichoEntity.class);
    }

    /**
     * DbV4001JukyushaDaichoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV4001JukyushaDaichoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
