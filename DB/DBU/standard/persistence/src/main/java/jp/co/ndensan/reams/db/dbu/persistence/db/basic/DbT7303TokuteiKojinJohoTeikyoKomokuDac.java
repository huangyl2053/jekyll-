/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7303TokuteiKojinJohoTeikyoKomoku;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7303TokuteiKojinJohoTeikyoKomoku.dataSetNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7303TokuteiKojinJohoTeikyoKomoku.hanNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7303TokuteiKojinJohoTeikyoKomoku.tokuteiKojinJohoMeiCode;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7303TokuteiKojinJohoTeikyoKomokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特定個人情報提供項目のデータアクセスクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class DbT7303TokuteiKojinJohoTeikyoKomokuDac implements ISaveable<DbT7303TokuteiKojinJohoTeikyoKomokuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで特定個人情報提供項目を取得します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     * @return DbT7303TokuteiKojinJohoTeikyoKomokuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7303TokuteiKojinJohoTeikyoKomokuEntity selectByKey(
            RString 特定個人情報名コード,
            RString データセット番号,
            RString 版番号) throws NullPointerException {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage("データセット番号"));
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7303TokuteiKojinJohoTeikyoKomoku.class).
                where(and(
                                eq(tokuteiKojinJohoMeiCode, 特定個人情報名コード),
                                eq(dataSetNo, データセット番号),
                                eq(hanNo, 版番号))).
                toObject(DbT7303TokuteiKojinJohoTeikyoKomokuEntity.class);
    }

    /**
     * 特定個人情報提供項目を全件返します。
     *
     * @return DbT7303TokuteiKojinJohoTeikyoKomokuEntityの{@code list}
     */
    @Transaction
    public List<DbT7303TokuteiKojinJohoTeikyoKomokuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7303TokuteiKojinJohoTeikyoKomoku.class).
                toList(DbT7303TokuteiKojinJohoTeikyoKomokuEntity.class);
    }

    /**
     * DbT7303TokuteiKojinJohoTeikyoKomokuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報提供項目エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
