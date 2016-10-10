/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanri;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanri.dataSetNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanri.hanNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanri.tokuteiKojinJohoMeiCode;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
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
 * 特定個人情報版管理のデータアクセスクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class DbT7301TokuteiKojinJohoHanKanriDac implements ISaveable<DbT7301TokuteiKojinJohoHanKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで特定個人情報版管理を取得します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     * @return DbT7301TokuteiKojinJohoHanKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7301TokuteiKojinJohoHanKanriEntity selectByKey(
            RString 特定個人情報名コード,
            RString データセット番号,
            RString 版番号) throws NullPointerException {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage("データセット番号"));
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7301TokuteiKojinJohoHanKanri.class).
                where(and(
                                eq(tokuteiKojinJohoMeiCode, 特定個人情報名コード),
                                eq(dataSetNo, データセット番号),
                                eq(hanNo, 版番号))).
                toObject(DbT7301TokuteiKojinJohoHanKanriEntity.class);
    }

    /**
     * 特定個人情報版管理を全件返します。
     *
     * @return DbT7301TokuteiKojinJohoHanKanriEntityの{@code list}
     */
    @Transaction
    public List<DbT7301TokuteiKojinJohoHanKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7301TokuteiKojinJohoHanKanri.class).
                toList(DbT7301TokuteiKojinJohoHanKanriEntity.class);
    }

    /**
     * DbT7301TokuteiKojinJohoHanKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7301TokuteiKojinJohoHanKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報版管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
