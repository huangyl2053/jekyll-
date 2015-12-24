/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.serviceShuruiCd;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.teikyoKaishiYM;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類のデータアクセスクラスです。
 */
public class DbT7130KaigoServiceShuruiDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param サービス種類コード ServiceShuruiCd
     * @param 提供開始年月 TeikyoKaishiYM
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7130KaigoServiceShuruiEntity selectByKey(
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(
                                eq(serviceShuruiCd, サービス種類コード),
                                eq(teikyoKaishiYM, 提供開始年月))).
                toObject(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 介護サービス種類を全件返します。
     *
     * @return DbT7130KaigoServiceShuruiEntityの{@code list}
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * DbT7130KaigoServiceShuruiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT7130KaigoServiceShuruiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
