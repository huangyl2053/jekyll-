/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.model.KaigoJogaiTokureiTaishoShisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.KaigoJogaiTokureiTaishoShisetsuRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * 介護除外住所地特例対象施設のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class KaigoJogaiTokureiTaishoShisetsuDac implements IModifiable<KaigoJogaiTokureiTaishoShisetsuRelateModel> {

    @InjectSession
    private SqlSession session;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac 介護除外住所地特例対象施設Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);

    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    /**
     * 介護除外住所地特例対象施設情報をキー検索で１件返します。
     *
     * @param 事業者種別 RString
     * @param 事業者番号 RString
     * @param 有効開始年月日 FlexibleDate
     * @return KaigoJogaiTokureiTaishoShisetsuRelateModel
     */
    @Transaction
    public KaigoJogaiTokureiTaishoShisetsuRelateModel select介護除外住所地特例対象施設ByKey(RString 事業者種別, RString 事業者番号, FlexibleDate 有効開始年月日) {

        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設種類"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設コード"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));

        return createModel(介護除外住所地特例対象施設Dac.selectByKey(事業者種別, 事業者番号, 有効開始年月日));
    }

    // TODO 一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    /**
     * 主キー1に合致する介護除外住所地特例対象施設のリストを返します。。
     *
     * @param 事業者種別 RString
     * @return List<KaigoJogaiTokureiTaishoShisetsuRelateModel>
     */
    @Transaction
    public List<KaigoJogaiTokureiTaishoShisetsuRelateModel> select介護除外住所地特例対象施設一覧By主キー1(RString 事業者種別) {

        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> 介護除外住所地特例対象施設List = accessor.select().
                table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).
                where(eq(DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaShubetsu, 事業者種別)).
                toList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);

        List<KaigoJogaiTokureiTaishoShisetsuRelateModel> 台帳リスト = new ArrayList<>();

        for (DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 介護除外住所地特例対象施設 : 介護除外住所地特例対象施設List) {
            台帳リスト.add(createModel(介護除外住所地特例対象施設));
        }

        return 台帳リスト;
    }

    private KaigoJogaiTokureiTaishoShisetsuRelateModel createModel(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 介護除外住所地特例対象施設エンティティ) {
        if (介護除外住所地特例対象施設エンティティ == null) {
            return null;
        }

        return new KaigoJogaiTokureiTaishoShisetsuRelateModel(new KaigoJogaiTokureiTaishoShisetsuModel(介護除外住所地特例対象施設エンティティ));
    }

    @Override
    public int insert(KaigoJogaiTokureiTaishoShisetsuRelateModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 介護除外住所地特例対象施設Dac.insert(data.get介護除外住所地特例対象施設モデル().getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(KaigoJogaiTokureiTaishoShisetsuRelateModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 介護除外住所地特例対象施設Dac.update(data.get介護除外住所地特例対象施設モデル().getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(KaigoJogaiTokureiTaishoShisetsuRelateModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 介護除外住所地特例対象施設Dac.delete(data.get介護除外住所地特例対象施設モデル().getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
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
