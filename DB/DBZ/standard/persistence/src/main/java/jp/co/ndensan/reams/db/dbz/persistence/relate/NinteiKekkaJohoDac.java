/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.model.NinteiKekkaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5002NinteiKekkaJohoDac;
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
 * 要介護認定結果情報のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiKekkaJohoDac implements IModifiable<NinteiKekkaJohoModel> {

    @InjectSession
    private SqlSession session;
    private final DbT5002NinteiKekkaJohoDac 要介護認定結果情報Dac = InstanceProvider.create(DbT5002NinteiKekkaJohoDac.class);

    /**
     * 要介護認定結果情報をキー検索で１件返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 処理日時 処理日時
     * @return NinteiKekkaJohoModel
     */
    @Transaction
    public Optional<NinteiKekkaJohoModel> selectByKey(ShinseishoKanriNo 申請書管理番号,
            YMDHMS 処理日時) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return Optional.ofNullable(createModel(要介護認定結果情報Dac.selectByKey(申請書管理番号.value(), 処理日時)));
    }

    /**
     * 要介護認定結果情報のリストを返します。
     *
     * @return IItemList<NinteiKekkaJohoModel>
     */
    @Transaction
    public IItemList<NinteiKekkaJohoModel> selectAll() {

        List<DbT5002NinteiKekkaJohoEntity> 要介護認定結果情報List = 要介護認定結果情報Dac.selectAll();
        List<NinteiKekkaJohoModel> list = new ArrayList<>();

        for (DbT5002NinteiKekkaJohoEntity 要介護認定結果情報 : 要介護認定結果情報List) {
            list.add(createModel(要介護認定結果情報));
        }
        IItemList<NinteiKekkaJohoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 要介護認定結果情報の申請書管理番号を指定して直近の１件を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiShinseiJohoModel
     */
    @Transaction
    public Optional<NinteiKekkaJohoModel> select直近要介護認定結果情報By申請書管理番号(ShinseishoKanriNo 申請書管理番号) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT5002NinteiKekkaJohoEntity> 認定結果情報List = accessor.select().
                table(DbT5002NinteiKekkaJoho.class).
                where(eq(DbT5002NinteiKekkaJoho.shinseishoKanriNo, 申請書管理番号.value())).
                order(by(DbT5002NinteiKekkaJoho.shoriTimestamp, Order.DESC)).
                toList(DbT5002NinteiKekkaJohoEntity.class);

        if (認定結果情報List.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(createModel(認定結果情報List.get(0)));
    }

    private NinteiKekkaJohoModel createModel(DbT5002NinteiKekkaJohoEntity 要介護認定結果情報エンティティ) {
        if (要介護認定結果情報エンティティ == null) {
            return null;
        }

        return new NinteiKekkaJohoModel(要介護認定結果情報エンティティ);
    }

    @Override
    public int insert(NinteiKekkaJohoModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(NinteiKekkaJohoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(NinteiKekkaJohoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data NinteiKekkaJohoModel
     * @return int 件数
     */
    public int deletePhysical(NinteiKekkaJohoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 要介護認定結果情報Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
