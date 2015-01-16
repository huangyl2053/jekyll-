/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShurui;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShurui.joseiServiceShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShurui.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShurui.tandokuJoseiShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShurui.tekiyoKaishiYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村単独助成種類のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3099TandokuJoseiShuruiDac implements IModifiable<DbT3099TandokuJoseiShuruiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村単独助成種類を取得します。
     *
     * @param 市町村単独助成種類 TandokuJoseiShuruiCode
     * @param 助成サービス種類コード JoseiServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3099TandokuJoseiShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3099TandokuJoseiShuruiEntity selectByKey(
            RString 市町村単独助成種類,
            ServiceShuruiCode 助成サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        requireNonNull(助成サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3099TandokuJoseiShurui.class).
                where(and(
                                eq(tandokuJoseiShuruiCode, 市町村単独助成種類),
                                eq(joseiServiceShuruiCode, 助成サービス種類コード),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3099TandokuJoseiShuruiEntity.class);
    }

    /**
     * 市町村単独助成種類を全件返します。
     *
     * @return List<DbT3099TandokuJoseiShuruiEntity>
     */
    @Transaction
    public List<DbT3099TandokuJoseiShuruiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3099TandokuJoseiShurui.class).
                toList(DbT3099TandokuJoseiShuruiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3099TandokuJoseiShuruiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3099TandokuJoseiShuruiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3099TandokuJoseiShuruiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3099TandokuJoseiShuruiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3099TandokuJoseiShuruiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
