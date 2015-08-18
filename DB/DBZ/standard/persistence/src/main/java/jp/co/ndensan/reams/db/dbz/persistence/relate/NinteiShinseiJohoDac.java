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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
 * 要介護認定申請情報のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiShinseiJohoDac implements IModifiable<DbT4101NinteiShinseiJohoEntity> {

    @InjectSession
    private SqlSession session;
    //TODO n8235 船山洋介 要介護認定申請情報情報のテーブルが変更されたため、最新化が必要
//    private final DbT5001NinteiShinseiJohoDac 要介護認定申請情報Dac = InstanceProvider.create(DbT5001NinteiShinseiJohoDac.class);
    private final DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);

    /**
     * 要介護認定申請情報情報をキー検索で１件返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 処理日時 処理日時
     * @return DbT4101NinteiShinseiJohoEntity
     */
    @Transaction
    public Optional<DbT4101NinteiShinseiJohoEntity> selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            YMDHMS 処理日時) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
//TODO n8235 船山洋介 要介護認定申請情報情報のテーブルが変更されたため、最新化が必要
//        return Optional.ofNullable(createModel(要介護認定申請情報Dac.selectByKey(申請書管理番号.value(), 処理日時)));
        return Optional.empty();
    }

    /**
     * 要介護認定申請情報のリストを返します。
     *
     * @return IItemList<DbT4101NinteiShinseiJohoEntity>
     */
    @Transaction
    public IItemList<DbT4101NinteiShinseiJohoEntity> selectAll() {
//TODO n8235 船山洋介 要介護認定申請情報情報のテーブルが変更されたため、最新化が必要
//        List<DbT5001NinteiShinseiJohoEntity> 要介護認定申請情報List = 要介護認定申請情報Dac.selectAll();
        List<DbT4101NinteiShinseiJohoEntity> list = new ArrayList<>();

//        for (DbT5001NinteiShinseiJohoEntity 要介護認定申請情報 : 要介護認定申請情報List) {
//            list.add(createModel(要介護認定申請情報));
//        }
        IItemList<DbT4101NinteiShinseiJohoEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 要介護認定申請情報の申請書管理番号を指定して、最新の１件を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4101NinteiShinseiJohoEntity
     */
    @Transaction
    public Optional<DbT4101NinteiShinseiJohoEntity> select要介護認定申請情報By申請書管理番号(ShinseishoKanriNo 申請書管理番号) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT5001NinteiShinseiJohoEntity> 認定申請情報List = accessor.select().
                table(DbT5001NinteiShinseiJoho.class).
                where(eq(DbT5001NinteiShinseiJoho.shinseishoKanriNo, 申請書管理番号.value())).
                order(by(DbT5001NinteiShinseiJoho.shoriTimestamp, Order.DESC)).
                toList(DbT5001NinteiShinseiJohoEntity.class);

        if (認定申請情報List.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(createModel(認定申請情報List.get(0)));
    }

    private DbT4101NinteiShinseiJohoEntity createModel(DbT5001NinteiShinseiJohoEntity 要介護認定申請情報エンティティ) {
        if (要介護認定申請情報エンティティ == null) {
            return null;
        }

        return new DbT4101NinteiShinseiJohoEntity();
    }

    @Override
    public int insert(DbT4101NinteiShinseiJohoEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }
//TODO n8235 船山洋介 要介護認定申請情報情報のテーブルが変更されたため、最新化が必要
//        result = 要介護認定申請情報Dac.insert(data.getEntity());
        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(DbT4101NinteiShinseiJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }
//TODO n8235 船山洋介 要介護認定申請情報情報のテーブルが変更されたため、最新化が必要
//        result = 要介護認定申請情報Dac.update(data.getEntity());
        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(DbT4101NinteiShinseiJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

//        result = 要介護認定申請情報Dac.delete(data.getEntity());
        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT4101NinteiShinseiJohoEntity
     * @return int 件数
     */
    public int deletePhysical(DbT4101NinteiShinseiJohoEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }
//TODO n8235 船山洋介 要介護認定申請情報情報のテーブルが変更されたため、最新化が必要
//        result = 要介護認定申請情報Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
