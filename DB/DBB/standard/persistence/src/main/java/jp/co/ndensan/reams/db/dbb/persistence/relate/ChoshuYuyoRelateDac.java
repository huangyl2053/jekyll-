/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.relate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2006ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2007KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbz.model.fuka.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.ChoshuYuyoRelate;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 徴収猶予Relateのデータアクセスクラスです。
 *
 * @author n3317 塚田 萌
 */
public class ChoshuYuyoRelateDac implements IModifiable<ChoshuYuyoRelate> {

    @InjectSession
    private SqlSession session;
    private final DbT2006ChoshuYuyoDac 徴収猶予Dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
    private final DbT2007KibetsuChoshuYuyoDac 期別徴収猶予Dac = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);

    /**
     * 徴収猶予Relate情報をキーと状態区分の検索で１件返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 状態区分 状態区分
     * @param 履歴番号 履歴番号
     * @return ChoshuYuyoRelate
     */
    @Transaction
    public Optional<ChoshuYuyoRelate> select徴収猶予RelateByKeyAndState(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, int 履歴番号, GemmenChoshuYuyoStateKubun 状態区分) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("状態区分"));

        return createRelateModel(select徴収猶予ByKeyAndState(調定年度, 賦課年度, 通知書番号, 履歴番号, 状態区分));
    }

    @Transaction
    private Optional<ChoshuYuyo> select徴収猶予ByKeyAndState(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, int 履歴番号, GemmenChoshuYuyoStateKubun 状態区分) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        DbT2006ChoshuYuyoEntity entity = accessor.select().
                table(DbT2006ChoshuYuyo.class).
                where(and(
                                eq(DbT2006ChoshuYuyo.choteiNendo, 調定年度.value()),
                                eq(DbT2006ChoshuYuyo.fukaNendo, 賦課年度.value()),
                                eq(DbT2006ChoshuYuyo.tsuchishoNo, 通知書番号),
                                eq(DbT2006ChoshuYuyo.rirekiNo, 履歴番号),
                                eq(DbT2006ChoshuYuyo.jotaiKubun, 状態区分.code()))).
                toObject(DbT2006ChoshuYuyoEntity.class);

        return createChoshuYuyo(entity);
    }

    private Optional<ChoshuYuyo> createChoshuYuyo(DbT2006ChoshuYuyoEntity 徴収猶予エンティティ) {
        if (徴収猶予エンティティ == null) {
            return Optional.empty();
        }

        return Optional.of(new ChoshuYuyo(徴収猶予エンティティ));
    }

    private Optional<ChoshuYuyoRelate> createRelateModel(Optional<ChoshuYuyo> modeloid) {
        if (!modeloid.isPresent()) {
            return Optional.empty();
        }
        ChoshuYuyo model = modeloid.getClass();

        return Optional.of(new ChoshuYuyoRelate(
                model,
                select期別徴収猶予(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get履歴番号())));
    }

    private List<KibetsuChoshuYuyo> select期別徴収猶予(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, int 履歴番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT2007KibetsuChoshuYuyoEntity> entityList = accessor.select().
                table(DbT2007KibetsuChoshuYuyo.class).
                where(and(
                                eq(DbT2007KibetsuChoshuYuyo.choteiNendo, 調定年度.value()),
                                eq(DbT2007KibetsuChoshuYuyo.fukaNendo, 賦課年度.value()),
                                eq(DbT2007KibetsuChoshuYuyo.tsuchishoNo, 通知書番号),
                                eq(DbT2007KibetsuChoshuYuyo.rirekiNo, 履歴番号))).
                order(
                        by(DbT2007KibetsuChoshuYuyo.ki, Order.ASC)).
                toList(DbT2007KibetsuChoshuYuyoEntity.class);

        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<KibetsuChoshuYuyo> list = new ArrayList<>();
        for (DbT2007KibetsuChoshuYuyoEntity entity : entityList) {
            list.add(new KibetsuChoshuYuyo(entity));
        }
        return list;
    }

    @Override
    public int insert(ChoshuYuyoRelate data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        if (data.get期別徴収猶予モデルリスト() != null) {
            for (KibetsuChoshuYuyo model : data.get期別徴収猶予モデルリスト()) {
                期別徴収猶予Dac.insert(model.getEntity());
            }
        }
        return result;
    }

    @Override
    public int update(ChoshuYuyoRelate data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        if (data.get徴収猶予モデル() != null) {
            result = 徴収猶予Dac.update(data.get徴収猶予モデル().getEntity());
        }

        if (data.get期別徴収猶予モデルリスト() != null) {
            EntityDataState state;
            DbT2007KibetsuChoshuYuyoEntity entity;

            for (KibetsuChoshuYuyo model : data.get期別徴収猶予モデルリスト()) {
                state = model.getState();
                entity = model.getEntity();

                if (state == EntityDataState.Added) {
                    期別徴収猶予Dac.insert(entity);
                } else if (state == EntityDataState.Modified) {
                    期別徴収猶予Dac.update(entity);
                } else if (state == EntityDataState.Deleted) {
                    期別徴収猶予Dac.deletePhysical(entity);
                }
            }
        }

        return result;
    }

    @Override
    public int delete(ChoshuYuyoRelate data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        if (data.get徴収猶予モデル() != null) {
            result = 徴収猶予Dac.delete(data.get徴収猶予モデル().getEntity());
        }

        if (data.get期別徴収猶予モデルリスト() != null) {
            for (KibetsuChoshuYuyo model : data.get期別徴収猶予モデルリスト()) {
                期別徴収猶予Dac.delete(model.getEntity());
            }
        }
        return result;
    }
}
