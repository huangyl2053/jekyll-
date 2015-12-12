/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiService;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiService.*;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.db.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者指定サービスのデータアクセスクラスです。
 */
public class DbT7063KaigoJigyoshaShiteiServiceDac implements ISaveable<DbT7063KaigoJigyoshaShiteiServiceEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護事業者指定サービスを取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 有効開始日 YukoKaishiYMD
     * @return DbT7063KaigoJigyoshaShiteiServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7063KaigoJigyoshaShiteiServiceEntity selectByKey(
            KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(yukoKaishiYMD, 有効開始日))).
                toObject(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 介護事業者指定サービスを全件返します。
     *
     * @return List<DbT7063KaigoJigyoshaShiteiServiceEntity>
     */
    @Transaction
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                toList(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * DbT7063KaigoJigyoshaShiteiServiceEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者指定サービスエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 事業者番号で介護事業者指定サービスを取得します。
     *
     * @param 事業者番号
     * @return List<DbT7063KaigoJigyoshaShiteiServiceEntity>
     */
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> selectBy事業者番号(KaigoJigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(eq(jigyoshaNo, 事業者番号)).
                toList(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }
}
