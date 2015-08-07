/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkan.kyuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkan.noKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 各種新旧番号変換テーブルのデータアクセスクラスです。
 */
public class DbT7028KakushuShinKyuNoHenkanDac implements ISaveable<DbT7028KakushuShinKyuNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで各種新旧番号変換テーブルを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 番号区分 NoKubun
     * @param 旧番号 KyuNo
     * @return DbT7028KakushuShinKyuNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7028KakushuShinKyuNoHenkanEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 番号区分,
            RString 旧番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("番号区分"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7028KakushuShinKyuNoHenkan.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(noKubun, 番号区分),
                                eq(kyuNo, 旧番号))).
                toObject(DbT7028KakushuShinKyuNoHenkanEntity.class);
    }

    /**
     * 各種新旧番号変換テーブルを全件返します。
     *
     * @return List<DbT7028KakushuShinKyuNoHenkanEntity>
     */
    @Transaction
    public List<DbT7028KakushuShinKyuNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7028KakushuShinKyuNoHenkan.class).
                toList(DbT7028KakushuShinKyuNoHenkanEntity.class);
    }

    /**
     * DbT7028KakushuShinKyuNoHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("各種新旧番号変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
