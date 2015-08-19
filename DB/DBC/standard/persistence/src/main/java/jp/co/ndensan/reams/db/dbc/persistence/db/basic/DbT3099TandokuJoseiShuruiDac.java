/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3099TandokuJoseiShurui;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3099TandokuJoseiShurui.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村単独助成種類のデータアクセスクラスです。
 */
public class DbT3099TandokuJoseiShuruiDac implements ISaveable<DbT3099TandokuJoseiShuruiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村単独助成種類を取得します。
     *
     * @param 市町村単独助成種類 TandokuJoseiShuruiCode
     * @param 助成サービス種類コード JoseiServiceShuruiCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT3099TandokuJoseiShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3099TandokuJoseiShuruiEntity selectByKey(
            RString 市町村単独助成種類,
            ServiceShuruiCode 助成サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        requireNonNull(助成サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3099TandokuJoseiShurui.class).
                where(and(
                                eq(tandokuJoseiShuruiCode, 市町村単独助成種類),
                                eq(joseiServiceShuruiCode, 助成サービス種類コード),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(rirekiNo, 履歴番号))).
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

    /**
     * DbT3099TandokuJoseiShuruiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3099TandokuJoseiShuruiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
