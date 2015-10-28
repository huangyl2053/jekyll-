/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyou.*;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.db.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス内容のデータアクセスクラスです。
 */
public class DbT7131KaigoServiceNaiyouDac implements ISaveable<DbT7131KaigoServiceNaiyouEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護サービス内容を取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKoumokuCode
     * @param 提供開始年月 TeikyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT7131KaigoServiceNaiyouEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7131KaigoServiceNaiyouEntity selectByKey(
            KaigoServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 提供開始年月,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(serviceKoumokuCode, サービス項目コード),
                                eq(teikyoKaishiYM, 提供開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7131KaigoServiceNaiyouEntity.class);
    }

    /**
     * 介護サービス内容を全件返します。
     *
     * @return List<DbT7131KaigoServiceNaiyouEntity>
     */
    @Transaction
    public List<DbT7131KaigoServiceNaiyouEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7131KaigoServiceNaiyou.class).
                toList(DbT7131KaigoServiceNaiyouEntity.class);
    }

    /**
     * DbT7131KaigoServiceNaiyouEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7131KaigoServiceNaiyouEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス内容エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    public List<DbT7131KaigoServiceNaiyouEntity> selectList(ITrueFalseCriteria makeNaiyoConditions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
