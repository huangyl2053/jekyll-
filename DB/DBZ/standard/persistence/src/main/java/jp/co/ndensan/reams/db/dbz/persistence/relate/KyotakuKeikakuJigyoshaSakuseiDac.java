/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJigyoshaSakuseiModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画事業者作成のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuJigyoshaSakuseiDac implements IModifiable<KyotakuKeikakuJigyoshaSakuseiModel> {

    @InjectSession
    private SqlSession session;
    private final DbT3006KyotakuKeikakuJigyoshaSakuseiDac 居宅給付計画事業者作成Dac = InstanceProvider.create(DbT3006KyotakuKeikakuJigyoshaSakuseiDac.class);

    /**
     * 居宅給付計画事業者作成情報をキー検索で１件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @param 処理日時 処理日時
     * @return KyotakuKeikakuJigyoshaSakuseiModel
     */
    @Transaction
    public KyotakuKeikakuJigyoshaSakuseiModel selectByKey(RString 被保険者番号,
            RString 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月,
            YMDHMS 処理日時) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(居宅給付計画事業者作成Dac.selectByKey(被保険者番号, 証記載保険者番号,
                識別コード, 対象年月, 処理日時));
    }

    /**
     * 居宅給付計画事業者作成を全件返します。
     *
     * @return JukyushaDaichoModel
     */
    @Transaction
    public IItemList<KyotakuKeikakuJigyoshaSakuseiModel> selectAll() {

        List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成List = 居宅給付計画事業者作成Dac.selectAll();
        List<KyotakuKeikakuJigyoshaSakuseiModel> list = new ArrayList<>();

        for (DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成 : 居宅給付計画事業者作成List) {
            list.add(createModel(居宅給付計画事業者作成));
        }
        IItemList<KyotakuKeikakuJigyoshaSakuseiModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 指定されたキーに合致する居宅給付計画事業者作成の直近の一件を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @return KyotakuKeikakuJigyoshaSakuseiModel
     */
    @Transaction
    public KyotakuKeikakuJigyoshaSakuseiModel select直近居宅給付計画事業者作成(RString 被保険者番号,
            RString 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成List = accessor.select().
                table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                where(and(
                                eq(DbT3006KyotakuKeikakuJigyoshaSakusei.hihokenshano, 被保険者番号),
                                eq(DbT3006KyotakuKeikakuJigyoshaSakusei.shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(DbT3006KyotakuKeikakuJigyoshaSakusei.shikibetsuCode, 識別コード),
                                eq(DbT3006KyotakuKeikakuJigyoshaSakusei.taishoYM, 対象年月))).
                order(by(DbT3006KyotakuKeikakuJigyoshaSakusei.shoriTimestamp, Order.DESC)).
                toList(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class);

        if (居宅給付計画事業者作成List.isEmpty()) {
            return null;
        }

        return createModel(居宅給付計画事業者作成List.get(0));
    }

    private KyotakuKeikakuJigyoshaSakuseiModel createModel(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成エンティティ) {
        if (居宅給付計画事業者作成エンティティ == null) {
            return null;
        }

        return new KyotakuKeikakuJigyoshaSakuseiModel(居宅給付計画事業者作成エンティティ);
    }

    @Override
    public int insert(KyotakuKeikakuJigyoshaSakuseiModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(KyotakuKeikakuJigyoshaSakuseiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(KyotakuKeikakuJigyoshaSakuseiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data KyotakuKeikakuJigyoshaSakuseiModel
     * @return int 件数
     */
    public int deletePhysical(KyotakuKeikakuJigyoshaSakuseiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
