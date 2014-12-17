/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.model.shisetsuNyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
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

    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    /**
     * 介護保険施設入退所情報をキー検索で１件返します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @return ShisetsuNyutaishoModel
     */
    @Transaction
    public ShisetsuNyutaishoRelateModel select介護保険施設入退所ByKey(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        return createModel(介護保険施設入退所Dac.selectByKey(市町村コード, 識別コード));
    }

    // TODO 一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    /**
     * 主キー1に合致する介護保険施設入退所のリストを返します。。
     *
     * @param 識別コード ShikibetsuCode
     * @return List<ShisetsuNyutaishoRelateModel>
     */
    @Transaction
    public List<ShisetsuNyutaishoRelateModel> select介護保険施設入退所一覧By主キー1(ShikibetsuCode 識別コード) {

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

        return 台帳リスト;
    }

    private ShisetsuNyutaishoRelateModel createModel(DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所エンティティ) {
        if (介護保険施設入退所エンティティ == null) {
            return null;
        }
        return new ShisetsuNyutaishoRelateModel(new ShisetsuNyutaishoModel(介護保険施設入退所エンティティ));
    }

    @Override
    public int insert(ShisetsuNyutaishoRelateModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 介護保険施設入退所Dac.insert(data.get介護保険施設入退所モデル().getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(ShisetsuNyutaishoRelateModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 介護保険施設入退所Dac.update(data.get介護保険施設入退所モデル().getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(ShisetsuNyutaishoRelateModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 介護保険施設入退所Dac.delete(data.get介護保険施設入退所モデル().getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
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
