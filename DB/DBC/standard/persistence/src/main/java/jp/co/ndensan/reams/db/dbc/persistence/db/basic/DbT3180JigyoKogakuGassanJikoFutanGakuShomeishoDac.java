/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.shikyuShinseishoSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.shokisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.taishoNendo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.tennyumaeHokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額合算自己負担額証明書のデータアクセスクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoDac implements ISaveable<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業高額合算自己負担額証明書を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 転入前保険者番号 転入前保険者番号
     * @param 履歴番号 履歴番号
     * @return DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            HokenshaNo 転入前保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(転入前保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("転入前保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(tennyumaeHokenshaNo, 転入前保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity.class);
    }

    /**
     * 主キーで事業高額合算自己負担額証明書を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 転入前保険者番号 転入前保険者番号
     * @return DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity select最新履歴番号(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            HokenshaNo 転入前保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(転入前保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("転入前保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(tennyumaeHokenshaNo, 転入前保険者番号)
                        )).
                toObject(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity.class);
    }

    /**
     * 事業高額合算自己負担額証明書を全件返します。
     *
     * @return DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntityの{@code list}
     */
    @Transaction
    public List<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho.class).
                toList(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity.class);
    }

    /**
     * DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額合算自己負担額証明書エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
