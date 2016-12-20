/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorisha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT7501NinteiSaikinShorishaMapper;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;

/**
 * 認定支援用　最近処理者テーブルにアクセスするためのクラスです。
 */
public class DbT7501NinteiSaikinShorishaDac implements ISaveable<DbT7501NinteiSaikinShorishaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 指定キーに一致するデータを取得します。
     *
     * @param reamsLoginId ログインID
     * @param 証記載保険者番号 証記載ほけん車番号
     * @return 条件に一致する最近処理者情報
     */
    @Transaction
    public List<DbT7501NinteiSaikinShorishaEntity> selectByKey(RString reamsLoginId, ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(reamsLoginId, UrSystemErrorMessages.値がnull.getReplacedMessage("reamsLoginId"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7501NinteiSaikinShorisha.class).
                where(and(
                        eq(DbT7501NinteiSaikinShorisha.reamsLoginId, reamsLoginId),
                        eq(DbT7501NinteiSaikinShorisha.shoKisaiHokenshaNo, 証記載保険者番号))
                ).
                toList(DbT7501NinteiSaikinShorishaEntity.class);
    }

    /**
     * 最近処理者情報を更新します。
     *
     * @param entity
     * @return
     */
    @Transaction
    @Override
    public int save(DbT7501NinteiSaikinShorishaEntity entity) {
        return session.getMapper(IDbT7501NinteiSaikinShorishaMapper.class).save(entity);
    }

}
