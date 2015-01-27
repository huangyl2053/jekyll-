/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoDac implements IModifiable<ShisetsuNyutaishoRelateModel> {

    @InjectSession
    private SqlSession session;
    private final DbT1004ShisetsuNyutaishoDac 介護保険施設入退所Dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);

    /**
     * 介護保険施設入退所情報をキー検索で１件返します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 処理日時 YMDHMS
     * @return Optional<ShisetsuNyutaishoModel>
     */
    @Transaction
    public Optional<ShisetsuNyutaishoRelateModel> select介護保険施設入退所ByKey(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return Optional.ofNullable(createModel(介護保険施設入退所Dac.selectByKey(市町村コード, 識別コード, 処理日時)));
    }

    /**
     * 識別コードに合致する介護保険施設入退所のリストを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return IItemList<ShisetsuNyutaishoRelateModel>
     */
    @Transaction
    public IItemList<ShisetsuNyutaishoRelateModel> select介護保険施設入退所一覧By識別コード(ShikibetsuCode 識別コード) {

        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所List = accessor.select().
                table(DbT1004ShisetsuNyutaisho.class).
                where(eq(DbT1004ShisetsuNyutaisho.shikibetsuCode, 識別コード)).
                toList(DbT1004ShisetsuNyutaishoEntity.class);

        List<ShisetsuNyutaishoRelateModel> 台帳リスト = new ArrayList<>();

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
     * @return IItemList<ShisetsuNyutaishoRelateModel>
     */
    @Transaction
    public IItemList<ShisetsuNyutaishoRelateModel> select台帳別施設入退所一覧(ShikibetsuCode 識別コード, DaichoType 台帳種別) {

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

        List<ShisetsuNyutaishoRelateModel> 台帳リスト = new ArrayList<>();

        for (DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所 : 介護保険施設入退所List) {
            台帳リスト.add(createModel(介護保険施設入退所));
        }

        return ItemList.of(台帳リスト);
    }

    private ShisetsuNyutaishoRelateModel createModel(DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所エンティティ) {
        if (介護保険施設入退所エンティティ == null) {
            return null;
        }
        return new ShisetsuNyutaishoRelateModel(new ShisetsuNyutaishoModel(介護保険施設入退所エンティティ));
    }

    @Override
    public int insert(ShisetsuNyutaishoRelateModel data) {

        if (data == null) {
            return 0;
        }

        return 介護保険施設入退所Dac.insert(data.get介護保険施設入退所モデル().getEntity());
    }

    @Override
    public int update(ShisetsuNyutaishoRelateModel data) {

        if (data == null) {
            return 0;
        }

        return 介護保険施設入退所Dac.update(data.get介護保険施設入退所モデル().getEntity());
    }

    @Override
    public int delete(ShisetsuNyutaishoRelateModel data) {

        if (data == null) {
            return 0;
        }

        return 介護保険施設入退所Dac.delete(data.get介護保険施設入退所モデル().getEntity());
    }

//    @Override
//    public int deletePhysical(ShisetsuNyutaishoRelateModel data) {
//        int result = 0;
//
//        if (data == null) {
//            return result;
//        }
//
//        result = 介護保険施設入退所Dac.deletePhysical(data.get介護保険施設入退所モデル().getEntity());
//
//        // TODO リストで持っているクラスについては修正が必要になります。
//        return result;
//    }
}
