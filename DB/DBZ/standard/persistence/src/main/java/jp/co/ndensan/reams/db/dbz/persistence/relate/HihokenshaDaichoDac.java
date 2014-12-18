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
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class HihokenshaDaichoDac implements IModifiable<HihokenshaDaichoModel> {

    @InjectSession
    private SqlSession session;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);

    /**
     * 被保険者台帳情報をキー検索で１件返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return HihokenshaDaichoModel
     */
    @Transaction
    public HihokenshaDaichoModel selectByKey(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            YMDHMS 処理日時) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(被保険者台帳Dac.selectByKey(市町村コード, 被保険者番号, 処理日時));
    }

    /**
     * 被保険者台帳を全件返します。
     *
     * @return IItemList<HihokenshaDaichoModel>
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> selectAll() {

        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = 被保険者台帳Dac.selectAll();
        List<HihokenshaDaichoModel> list = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            list.add(createModel(被保険者台帳));
        }
        IItemList<HihokenshaDaichoModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 被保険者番号に合致する直近の被保険者台帳を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return HihokenshaDaichoModel
     */
    @Transaction
    public IOptional<HihokenshaDaichoModel> select直近被保険者台帳(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(eq(DbT1001HihokenshaDaicho.hihokenshaNo, 被保険者番号)).
                toList(DbT1001HihokenshaDaichoEntity.class);

        if (被保険者台帳List.isEmpty()) {
            return null;
        }

        return DbOptional.of(createModel(被保険者台帳List.get(0)));
    }

    private HihokenshaDaichoModel createModel(DbT1001HihokenshaDaichoEntity 被保険者台帳エンティティ) {
        if (被保険者台帳エンティティ == null) {
            return null;
        }

        return new HihokenshaDaichoModel(被保険者台帳エンティティ);
    }

    @Override
    public int insert(HihokenshaDaichoModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 被保険者台帳Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(HihokenshaDaichoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 被保険者台帳Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(HihokenshaDaichoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 被保険者台帳Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data HihokenshaDaichoModel
     * @return int 件数
     */
    public int deletePhysical(HihokenshaDaichoModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 被保険者台帳Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
