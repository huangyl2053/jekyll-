/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4036FutanGendogakuNinteiBatchTestResults;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4036FutanGendogakuNinteiBatchTestResultsEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 負担限度額認定一括テスト結果のデータアクセスクラスです。
 */
public class DbT4036FutanGendogakuNinteiBatchTestResultsDac implements ISaveable<DbT4036FutanGendogakuNinteiBatchTestResultsEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで支払方法変更減額明細を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT4036FutanGendogakuNinteiBatchTestResultsEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT4036FutanGendogakuNinteiBatchTestResultsEntity> selectByHihokenshaNo(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4036FutanGendogakuNinteiBatchTestResults.class).
                where(eq(DbT4036FutanGendogakuNinteiBatchTestResults.hihokenshaNo, 被保険者番号)).
                toList(DbT4036FutanGendogakuNinteiBatchTestResultsEntity.class);
    }

    /**
     * DbT4036FutanGendogakuNinteiBatchTestResultsEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4036FutanGendogakuNinteiBatchTestResultsEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額明細エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
