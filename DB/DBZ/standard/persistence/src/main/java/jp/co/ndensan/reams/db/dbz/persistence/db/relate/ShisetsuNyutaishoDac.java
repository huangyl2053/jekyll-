/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoDac implements IModifiable<DbT1004ShisetsuNyutaishoEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT1004ShisetsuNyutaishoDac 介護保険施設入退所Dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);

    /**
     * 介護保険施設入退所情報をキー検索で１件返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 Decimal
     * @return Optional<ShisetsuNyutaishoModel>
     */
    @Transaction
    public Optional<DbT1004ShisetsuNyutaishoEntity> select介護保険施設入退所ByKey(ShikibetsuCode 識別コード,
            Decimal 履歴番号) {

        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        return Optional.ofNullable(createModel(介護保険施設入退所Dac.selectByKey(識別コード, 履歴番号)));
    }

    /**
     * 識別コードに合致する介護保険施設入退所のリストを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return IItemList<DbT1004ShisetsuNyutaishoEntity>
     */
    @Transaction
    public IItemList<DbT1004ShisetsuNyutaishoEntity> select介護保険施設入退所一覧By識別コード(ShikibetsuCode 識別コード) {

        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所List = accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(eq(DbT1004ShisetsuNyutaisho.shikibetsuCode, 識別コード)).
                toList(DbT1004ShisetsuNyutaishoEntity.class);

        List<DbT1004ShisetsuNyutaishoEntity> 台帳リスト = new ArrayList<>();

        for (DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所 : 介護保険施設入退所List) {
            台帳リスト.add(createModel(介護保険施設入退所));
        }

        return ItemList.of(台帳リスト);
    }

    /**
     * 指定した識別コードと台帳種別に合致する、介護保険施設入退所のリストを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 台帳種別 DaichoType
     * @return IItemList<DbT1004ShisetsuNyutaishoEntity>
     */
    @Transaction
    public IItemList<DbT1004ShisetsuNyutaishoEntity> select台帳別施設入退所一覧(ShikibetsuCode 識別コード, DaichoType 台帳種別) {

        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所List = accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(
                        and(
                                eq(DbT1004ShisetsuNyutaisho.shikibetsuCode, 識別コード),
                                eq(DbT1004ShisetsuNyutaisho.daichoShubetsu, 台帳種別.getCode())
                        )
                ).
                toList(DbT1004ShisetsuNyutaishoEntity.class);

        List<DbT1004ShisetsuNyutaishoEntity> 台帳リスト = new ArrayList<>();

        for (DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所 : 介護保険施設入退所List) {
            台帳リスト.add(createModel(介護保険施設入退所));
        }

        return ItemList.of(台帳リスト);
    }

    private DbT1004ShisetsuNyutaishoEntity createModel(DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所エンティティ) {
        if (介護保険施設入退所エンティティ == null) {
            return null;
        }
        return new DbT1004ShisetsuNyutaishoEntity();
    }

    @Override
    public int insert(DbT1004ShisetsuNyutaishoEntity data) {

        if (data == null) {
            return 0;
        }

        return 介護保険施設入退所Dac.save(data);
    }

    @Override
    public int update(DbT1004ShisetsuNyutaishoEntity data) {

        if (data == null) {
            return 0;
        }

        return 介護保険施設入退所Dac.save(data);
    }

    @Override
    public int delete(DbT1004ShisetsuNyutaishoEntity data) {

        if (data == null) {
            return 0;
        }

        return 介護保険施設入退所Dac.save(data);
    }

    /**
     * DbT1004ShisetsuNyutaishoEntityのデータを物理削除します。
     *
     * @param data data
     * @return 削除件数
     */
    public int deletePhysical(DbT1004ShisetsuNyutaishoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        // TODO リストで持っているクラスについては修正が必要になります。
        return 介護保険施設入退所Dac.save(data);

    }
}
