/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004Gemmen;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004Gemmen.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbz.model.fuka.GemmenModel;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 減免のデータアクセスクラスです。
 *
 * @author N3317 塚田 萌
 */
public class GemmenDac implements IModifiable<GemmenModel> {

    @InjectSession
    private SqlSession session;
    private final DbT2004GemmenDac 減免Dac = InstanceProvider.create(DbT2004GemmenDac.class);

    /**
     * キーと状態区分で検索し、減免情報を１件返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @param 状態区分 状態区分
     * @return GemmenModel
     */
    @Transaction
    public Optional<GemmenModel> select減免ByKeyAndState(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, RDateTime 処理日時, GemmenChoshuYuyoStateKubun 状態区分) {

        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        requireNonNull(状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("状態区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        DbT2004GemmenEntity entity = accessor.select().
                table(DbT2004Gemmen.class).
                where(and(
                                eq(choteiNendo, 調定年度.value()),
                                eq(fukaNendo, 賦課年度.value()),
                                eq(tsuchishoNo, 通知書番号),
                                eq(shoriTimestamp, 処理日時),
                                eq(jotaiKubun, 状態区分.code()))).
                toObject(DbT2004GemmenEntity.class);

        return createModel(entity);
    }

    private Optional<GemmenModel> createModel(DbT2004GemmenEntity 減免エンティティ) {
        if (減免エンティティ == null) {
            return Optional.empty();
        }

        return Optional.of(new GemmenModel(減免エンティティ));
    }

    @Override
    public int insert(GemmenModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }
        result = 減免Dac.insert(data.getEntity());

        return result;
    }

    @Override
    public int update(GemmenModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }
        result = 減免Dac.update(data.getEntity());

        return result;
    }

    @Override
    public int delete(GemmenModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }
        result = 減免Dac.delete(data.getEntity());

        return result;
    }
}
