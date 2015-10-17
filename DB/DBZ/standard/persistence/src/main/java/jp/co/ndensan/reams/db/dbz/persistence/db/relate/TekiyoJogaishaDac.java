/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
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
public class TekiyoJogaishaDac implements IModifiable<DbT1002TekiyoJogaishaEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT1002TekiyoJogaishaDac dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);

    /**
     * 適用除外者Model情報をキー検索で１件返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @param 枝番 RString
     * @return DbT1002TekiyoJogaishaEntity
     */
    @Transaction
    public DbT1002TekiyoJogaishaEntity select適用除外者ModelByKey(ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {

        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        return createModel(dac.selectByKey(識別コード, 異動日, 枝番));
    }

    /**
     * 市町村コードと識別コードを指定し、特定の人物の適用除外者情報をListで取得します。<br/>
     * Listは適用日の降順で返却されます。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @return List<DbT1002TekiyoJogaishaEntity>
     */
    @Transaction
    public List<DbT1002TekiyoJogaishaEntity> select適用除外者List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
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

        List<DbT1002TekiyoJogaishaEntity> 台帳リスト = new ArrayList<>();

        for (DbT1002TekiyoJogaishaEntity entity : List) {
            台帳リスト.add(createModel(entity));
        }

        return 台帳リスト;
    }

    private DbT1002TekiyoJogaishaEntity createModel(DbT1002TekiyoJogaishaEntity エンティティ) {
        if (エンティティ == null) {
            return null;
        }

        return new DbT1002TekiyoJogaishaEntity();
    }

    @Override
    public int insert(DbT1002TekiyoJogaishaEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.save(data);
        return result;
    }

    @Override
    public int update(DbT1002TekiyoJogaishaEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.save(data);
        return result;
    }

    @Override
    public int delete(DbT1002TekiyoJogaishaEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.save(data);
        return result;
    }

    /**
     * 適用除外者の情報を物理的に削除します。
     *
     * @param data 適用除外者Model
     * @return 削除した件数
     */
    @Transaction
    public int deletePhysical(DbT1002TekiyoJogaishaEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.save(data);
        return result;
    }
}
