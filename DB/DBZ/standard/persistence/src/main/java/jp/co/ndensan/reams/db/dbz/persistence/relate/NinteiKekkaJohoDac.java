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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiKekkaJohoDac implements IModifiable<DbT4102NinteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT4102NinteiKekkaJohoDac 要介護認定結果情報Dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);

    /**
     * 要介護認定結果情報をキー検索で１件返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4102NinteiKekkaJohoEntity
     */
    @Transaction
    public Optional<DbT4102NinteiKekkaJohoEntity> selectByKey(ShinseishoKanriNo 申請書管理番号) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        return Optional.ofNullable(createModel(要介護認定結果情報Dac.selectByKey(申請書管理番号)));
    }

    /**
     * 要介護認定結果情報のリストを返します。
     *
     * @return IItemList<DbT4102NinteiKekkaJohoEntity>
     */
    @Transaction
    public IItemList<DbT4102NinteiKekkaJohoEntity> selectAll() {

        List<DbT4102NinteiKekkaJohoEntity> 要介護認定結果情報List = 要介護認定結果情報Dac.selectAll();
        List<DbT4102NinteiKekkaJohoEntity> list = new ArrayList<>();

        for (DbT4102NinteiKekkaJohoEntity 要介護認定結果情報 : 要介護認定結果情報List) {
            list.add(createModel(要介護認定結果情報));
        }
        IItemList<DbT4102NinteiKekkaJohoEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 要介護認定結果情報の申請書管理番号を指定して直近の１件を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiShinseiJohoModel
     */
    @Transaction
    public Optional<DbT4102NinteiKekkaJohoEntity> select直近要介護認定結果情報By申請書管理番号(ShinseishoKanriNo 申請書管理番号) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT4102NinteiKekkaJohoEntity> 認定結果情報List = accessor.select().
                table(DbT4102NinteiKekkaJoho.class).
                where(eq(DbT4102NinteiKekkaJoho.shinseishoKanriNo, 申請書管理番号.value())).
                order(by(DbT4102NinteiKekkaJoho.shinseishoKanriNo, Order.DESC)).
                toList(DbT4102NinteiKekkaJohoEntity.class);

        if (認定結果情報List.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(createModel(認定結果情報List.get(0)));
    }

    private DbT4102NinteiKekkaJohoEntity createModel(DbT4102NinteiKekkaJohoEntity 要介護認定結果情報エンティティ) {
        if (要介護認定結果情報エンティティ == null) {
            return null;
        }

        return new DbT4102NinteiKekkaJohoEntity();
    }

    @Override
    public int insert(DbT4102NinteiKekkaJohoEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(DbT4102NinteiKekkaJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(DbT4102NinteiKekkaJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT4102NinteiKekkaJohoEntity
     * @return int 件数
     */
    public int deletePhysical(DbT4102NinteiKekkaJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
