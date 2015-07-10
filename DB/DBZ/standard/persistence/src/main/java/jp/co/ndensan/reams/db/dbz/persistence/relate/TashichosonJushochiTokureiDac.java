/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.model.TashichosonJushochiTokureiModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 他市町村住所地特例Modelのデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class TashichosonJushochiTokureiDac implements IModifiable<TashichosonJushochiTokureiModel> {

    @InjectSession
    private SqlSession session;
    private final DbT1003TashichosonJushochiTokureiDac dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);

    /**
     * 他市町村住所地特例Model情報をキー検索で１件返します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 処理日時 YMDHMS
     * @return TashichosonJushochiTokureiModel
     */
    @Transaction
    public TashichosonJushochiTokureiModel select他市町村住所地特例ModelByKey(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(dac.selectByKey(市町村コード, 識別コード, 処理日時));
    }

    // TODO 一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    /**
     * 市町村コードと識別コードを指定し、特定の人物の他市町村住所地特例情報をListで取得します。<br/>
     * Listは適用日の降順で返却されます。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @return List<TashichosonJushochiTokureiModel>
     */
    @Transaction
    public List<TashichosonJushochiTokureiModel> select他市町村住所地特例List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT1003TashichosonJushochiTokureiEntity> List = accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(
                        and(
                                eq(DbT1003TashichosonJushochiTokurei.shichosonCode, 市町村コード),
                                eq(DbT1003TashichosonJushochiTokurei.shikibetsuCode, 識別コード)
                        )
                ).
                order(
                        by(DbT1003TashichosonJushochiTokurei.tekiyoYMD, Order.DESC)
                ).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);

        List<TashichosonJushochiTokureiModel> 台帳リスト = new ArrayList<>();

        for (DbT1003TashichosonJushochiTokureiEntity entity : List) {
            台帳リスト.add(createModel(entity));
        }

        return 台帳リスト;
    }

    private TashichosonJushochiTokureiModel createModel(DbT1003TashichosonJushochiTokureiEntity エンティティ) {
        if (エンティティ == null) {
            return null;
        }

        return new TashichosonJushochiTokureiModel(エンティティ);
    }

    @Override
    public int insert(TashichosonJushochiTokureiModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.insert(data.getEntity());
        return result;
    }

    @Override
    public int update(TashichosonJushochiTokureiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.update(data.getEntity());
        return result;
    }

    @Override
    public int delete(TashichosonJushochiTokureiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.delete(data.getEntity());
        return result;
    }

    /**
     * 他市町村住所地特例の情報を物理的に削除します。
     *
     * @param data 他市町村住所地特例情報
     * @return 削除件数
     */
    @Transaction
    public int deletePhysical(TashichosonJushochiTokureiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = dac.deletePhysical(data.getEntity());
        return result;
    }
}
