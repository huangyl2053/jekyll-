/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.model.TekiyoJogaishaModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
 * 適用除外者Modelのデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaishaDac implements IModifiable<TekiyoJogaishaModel> {

    @InjectSession
    private SqlSession session;
    private final DbT1002TekiyoJogaishaDac dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);

    /**
     * 適用除外者Model情報をキー検索で１件返します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 処理日時 YMDHMS
     * @return TekiyoJogaishaModel
     */
    @Transaction
    public TekiyoJogaishaModel select適用除外者ModelByKey(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(dac.selectByKey(市町村コード, 識別コード, 処理日時));
    }

    /**
     * 市町村コードと識別コードを指定し、特定の人物の適用除外者情報をListで取得します。<br/>
     * Listは適用日の降順で返却されます。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @return List<TekiyoJogaishaModel>
     */
    @Transaction
    public List<TekiyoJogaishaModel> select適用除外者List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1002TekiyoJogaishaEntity> List = accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                where(
                        and(
                                eq(DbT1002TekiyoJogaisha.shichosonCode, 市町村コード),
                                eq(DbT1002TekiyoJogaisha.shikibetsuCode, 識別コード)
                        )
                ).
                order(
                        by(DbT1002TekiyoJogaisha.tekiyoYMD, Order.DESC)
                ).
                toList(DbT1002TekiyoJogaishaEntity.class);

        List<TekiyoJogaishaModel> 台帳リスト = new ArrayList<>();

        for (DbT1002TekiyoJogaishaEntity entity : List) {
            台帳リスト.add(createModel(entity));
        }

        return 台帳リスト;
    }

    private TekiyoJogaishaModel createModel(DbT1002TekiyoJogaishaEntity エンティティ) {
        if (エンティティ == null) {
            return null;
        }

        return new TekiyoJogaishaModel(エンティティ);
    }

    @Override
    public int insert(TekiyoJogaishaModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.insert(data.getEntity());
        return result;
    }

    @Override
    public int update(TekiyoJogaishaModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.update(data.getEntity());
        return result;
    }

    @Override
    public int delete(TekiyoJogaishaModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.delete(data.getEntity());
        return result;
    }

    /**
     * 適用除外者の情報を物理的に削除します。
     *
     * @param data 適用除外者Model
     * @return 削除した件数
     */
    @Transaction
    public int deletePhysical(TekiyoJogaishaModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.deletePhysical(data.getEntity());
        return result;
    }
}
