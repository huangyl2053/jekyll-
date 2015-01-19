/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.model.KaigoJogaiTokureiTaishoShisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護除外住所地特例対象施設のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class KaigoJogaiTokureiTaishoShisetsuDac implements IModifiable<KaigoJogaiTokureiTaishoShisetsuModel> {

    @InjectSession
    private SqlSession session;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac 介護除外住所地特例対象施設Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);

    /**
     * 介護除外住所地特例対象施設情報をキー検索で１件返します。
     *
     * @param 事業者種別 RString
     * @param 事業者番号 RString
     * @param 有効開始年月日 FlexibleDate
     * @return KaigoJogaiTokureiTaishoShisetsuRelateModel
     */
    @Transaction
    public Optional<KaigoJogaiTokureiTaishoShisetsuModel> select介護除外住所地特例対象施設ByKey(RString 事業者種別, RString 事業者番号, FlexibleDate 有効開始年月日) {

        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));

        return Optional.ofNullable(createModel(介護除外住所地特例対象施設Dac.selectByKey(事業者種別, 事業者番号, 有効開始年月日)));
    }

    /**
     * 事業者種別に合致する介護除外住所地特例対象施設のリストを返します。。
     *
     * @param 事業者種別 RString
     * @return IItemList<<KaigoJogaiTokureiTaishoShisetsuRelateModel>
     */
    @Transaction
    public IItemList<KaigoJogaiTokureiTaishoShisetsuModel> select介護除外住所地特例対象施設一覧By事業者種別(RString 事業者種別) {

        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> 介護除外住所地特例対象施設List = accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                where(eq(DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaShubetsu, 事業者種別)).
                toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);

        List<KaigoJogaiTokureiTaishoShisetsuModel> 台帳リスト = new ArrayList<>();

        for (DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 介護除外住所地特例対象施設 : 介護除外住所地特例対象施設List) {
            台帳リスト.add(createModel(介護除外住所地特例対象施設));
        }

        return ItemList.of(台帳リスト);
    }

    private KaigoJogaiTokureiTaishoShisetsuModel createModel(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 介護除外住所地特例対象施設エンティティ) {
        if (介護除外住所地特例対象施設エンティティ == null) {
            return null;
        }

        return new KaigoJogaiTokureiTaishoShisetsuModel(介護除外住所地特例対象施設エンティティ);
    }

    @Override
    public int insert(KaigoJogaiTokureiTaishoShisetsuModel data) {

        if (data == null) {
            return 0;
        }

        return 介護除外住所地特例対象施設Dac.insert(data.getEntity());
    }

    @Override
    public int update(KaigoJogaiTokureiTaishoShisetsuModel data) {

        if (data == null) {
            return 0;
        }

        return 介護除外住所地特例対象施設Dac.update(data.getEntity());
    }

    @Override
    public int delete(KaigoJogaiTokureiTaishoShisetsuModel data) {

        if (data == null) {
            return 0;
        }

        return 介護除外住所地特例対象施設Dac.delete(data.getEntity());
    }

//    @Override
//    public int deletePhysical(KaigoJogaiTokureiTaishoShisetsuRelateModel data) {
//        int result = 0;
//
//        if (data == null) {
//            return result;
//        }
//
//        if (data.get介護除外住所地特例対象施設モデル() != null) {
//            result = 介護除外住所地特例対象施設Dac.deletePhysical(data.get介護除外住所地特例対象施設モデル().getEntity());
//        }
//
//        // TODO リストで持っているクラスについては修正が必要になります。
//        return result;
//    }
}
