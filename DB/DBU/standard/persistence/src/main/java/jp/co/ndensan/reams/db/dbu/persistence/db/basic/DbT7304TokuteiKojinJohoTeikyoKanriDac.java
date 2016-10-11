/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanri;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanri.dataSetRecordKey;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanri.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanri.teikyoKubun;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特定個人情報提供管理のデータアクセスクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class DbT7304TokuteiKojinJohoTeikyoKanriDac implements ISaveable<DbT7304TokuteiKojinJohoTeikyoKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで特定個人情報提供管理を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param データセットレコードキー データセットレコードキー
     * @return DbT7304TokuteiKojinJohoTeikyoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7304TokuteiKojinJohoTeikyoKanriEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString データセットレコードキー) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(データセットレコードキー, UrSystemErrorMessages.値がnull.getReplacedMessage("データセットレコードキー"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7304TokuteiKojinJohoTeikyoKanri.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(dataSetRecordKey, データセットレコードキー))).
                toObject(DbT7304TokuteiKojinJohoTeikyoKanriEntity.class);
    }

    /**
     * 特定個人情報提供管理を全件返します。
     *
     * @return DbT7304TokuteiKojinJohoTeikyoKanriEntityの{@code list}
     */
    @Transaction
    public List<DbT7304TokuteiKojinJohoTeikyoKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7304TokuteiKojinJohoTeikyoKanri.class).
                toList(DbT7304TokuteiKojinJohoTeikyoKanriEntity.class);
    }

    /**
     * DbT7304TokuteiKojinJohoTeikyoKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7304TokuteiKojinJohoTeikyoKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報提供管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 特定個人情報提供管理の版番号カウントを取得します。
     *
     * @param 初回提供区分 初回提供区分
     * @return 版番号カウント{@code list}
     */
    @Transaction
    public int get版番号カウント(RString 初回提供区分) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT7304TokuteiKojinJohoTeikyoKanri.class).
                where(eq(teikyoKubun, 初回提供区分)).getCount();
    }
}
