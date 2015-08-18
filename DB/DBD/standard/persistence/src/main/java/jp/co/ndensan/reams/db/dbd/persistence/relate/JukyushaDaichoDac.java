/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class JukyushaDaichoDac implements IModifiable<DbT4001JukyushaDaichoEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);

    /**
     * 受給者台帳情報をキー検索で１件返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @return DbT4001JukyushaDaichoEntity
     */
    @Transaction
    public Optional<DbT4001JukyushaDaichoEntity> selectByKey(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));
        return Optional.ofNullable(new DbT4001JukyushaDaichoEntity());
    }

    /**
     * 受給者台帳を全件返します。
     *
     * @return DbT4001JukyushaDaichoEntity
     */
    @Transaction
    public IItemList<DbT4001JukyushaDaichoEntity> selectAll() {

        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = 受給者台帳Dac.selectAll();
        List<DbT4001JukyushaDaichoEntity> list = new ArrayList<>();

        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            list.add(createModel(受給者台帳));
        }
        IItemList<DbT4001JukyushaDaichoEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 被保険者番号に合致する受給者台帳の履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT4001JukyushaDaichoEntity
     */
    @Transaction
    public IItemList<DbT4001JukyushaDaichoEntity> select受給者台帳履歴By被保険者番号(
            HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(eq(DbT4001JukyushaDaicho.hihokenshaNo, 被保険者番号)).
                order(by(DbT4001JukyushaDaicho.shinseishoKanriNo, Order.DESC)).
                toList(DbT4001JukyushaDaichoEntity.class);

        List<DbT4001JukyushaDaichoEntity> list = new ArrayList<>();

        for (DbT4001JukyushaDaichoEntity 受給者台帳 : 受給者台帳List) {
            list.add(createModel(受給者台帳));
        }
        IItemList<DbT4001JukyushaDaichoEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    private DbT4001JukyushaDaichoEntity createModel(DbT4001JukyushaDaichoEntity 受給者台帳エンティティ) {
        if (受給者台帳エンティティ == null) {
            return null;
        }

        return new DbT4001JukyushaDaichoEntity();
    }

    @Override
    public int insert(DbT4001JukyushaDaichoEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(DbT4001JukyushaDaichoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(DbT4001JukyushaDaichoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT4001JukyushaDaichoEntity
     * @return int 件数
     */
    public int deletePhysical(DbT4001JukyushaDaichoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 受給者台帳Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
