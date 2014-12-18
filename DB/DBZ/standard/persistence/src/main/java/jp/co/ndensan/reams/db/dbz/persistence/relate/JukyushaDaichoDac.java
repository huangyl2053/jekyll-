/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.JukyushaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class JukyushaDaichoDac implements IModifiable<JukyushaDaichoModel> {

    @InjectSession
    private SqlSession session;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);

    /**
     * 受給者台帳情報をキー検索で１件返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 申請書管理番号 申請書管理番号
     * @param 処理日時 処理日時
     * @return JukyushaDaichoModel
     */
    @Transaction
    public JukyushaDaichoModel selectByKey(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            ShinseishoKanriNo 申請書管理番号,
            YMDHMS 処理日時) {

        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(受給者台帳Dac.selectByKey(証記載保険者番号, 被保険者番号, 申請書管理番号, 処理日時));
    }

    /**
     * 受給者台帳を全件返します。
     *
     * @return JukyushaDaichoModel
     */
    @Transaction
    public IItemList<JukyushaDaichoModel> selectAll() {

        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = 受給者台帳Dac.selectAll();
        List<JukyushaDaichoModel> list = new ArrayList<>();

        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            list.add(createModel(受給者台帳));
        }
        IItemList<JukyushaDaichoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 被保険者番号に合致する受給者台帳の履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return JukyushaDaichoModel
     */
    @Transaction
    public IItemList<JukyushaDaichoModel> select受給者台帳履歴By被保険者番号(
            HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(eq(DbT4001JukyushaDaicho.hihokenshaNo, 被保険者番号)).
                order(by(DbT4001JukyushaDaicho.shinseishoKanriNo, Order.DESC)).
                toList(DbT4001JukyushaDaichoEntity.class);

        List<JukyushaDaichoModel> list = new ArrayList<>();

        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            list.add(createModel(受給者台帳));
        }
        IItemList<JukyushaDaichoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    private JukyushaDaichoModel createModel(DbT4001JukyushaDaichoEntity 受給者台帳エンティティ) {
        if (受給者台帳エンティティ == null) {
            return null;
        }

        return new JukyushaDaichoModel(受給者台帳エンティティ);
    }

    @Override
    public int insert(JukyushaDaichoModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(JukyushaDaichoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(JukyushaDaichoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data JukyushaDaichoModel
     * @return int 件数
     */
    public int deletePhysical(JukyushaDaichoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
