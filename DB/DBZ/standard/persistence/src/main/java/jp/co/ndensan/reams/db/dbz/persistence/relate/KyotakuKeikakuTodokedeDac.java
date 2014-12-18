/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuTodokedeModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画届出のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuTodokedeDac implements IModifiable<KyotakuKeikakuTodokedeModel> {

    @InjectSession
    private SqlSession session;
    private final DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);

    /**
     * 居宅給付計画届出情報をキー検索で１件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @param 処理日時 処理日時
     * @return KyotakuKeikakuTodokedeModel
     */
    @Transaction
    public KyotakuKeikakuTodokedeModel selectByKey(
            HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月,
            YMDHMS 処理日時) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(居宅給付計画届出Dac.selectByKey(被保険者番号, 証記載保険者番号, 識別コード, 対象年月, 処理日時));
    }

    /**
     * 居宅給付計画届出情報を全件返します。
     *
     * @return IItemList<KyotakuKeikakuTodokedeModel>
     */
    @Transaction
    public IItemList<KyotakuKeikakuTodokedeModel> selectAll() {

        List<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出List = 居宅給付計画届出Dac.selectAll();
        List<KyotakuKeikakuTodokedeModel> list = new ArrayList<>();

        for (DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出 : 居宅給付計画届出List) {
            list.add(createModel(居宅給付計画届出));
        }
        IItemList<KyotakuKeikakuTodokedeModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 被保険者番号に合致する居宅給付計画届出の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<KyotakuKeikakuTodokedeModel>
     */
    @Transaction
    public IItemList<KyotakuKeikakuTodokedeModel> select居宅給付計画届出一覧By被保険者番号(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出List = accessor.select().
                table(DbT3005KyotakuKeikakuTodokede.class).
                where(eq(DbT3005KyotakuKeikakuTodokede.hihokenshaNo, 被保険者番号)).
                order(by(DbT3005KyotakuKeikakuTodokede.shoriTimestamp, Order.DESC)).
                toList(DbT3005KyotakuKeikakuTodokedeEntity.class);

        List<KyotakuKeikakuTodokedeModel> list = new ArrayList<>();

        for (DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出 : 居宅給付計画届出List) {
            list.add(createModel(居宅給付計画届出));
        }
        IItemList<KyotakuKeikakuTodokedeModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    private KyotakuKeikakuTodokedeModel createModel(DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出エンティティ) {
        if (居宅給付計画届出エンティティ == null) {
            return null;
        }

        return new KyotakuKeikakuTodokedeModel(居宅給付計画届出エンティティ);
    }

    @Override
    public int insert(KyotakuKeikakuTodokedeModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(KyotakuKeikakuTodokedeModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(KyotakuKeikakuTodokedeModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data KyotakuKeikakuTodokedeModel
     * @return int 件数
     */
    public int deletePhysical(KyotakuKeikakuTodokedeModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
