/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3082DaisanshaKoiKyusho;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3082DaisanshaKoiKyusho.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為求償のデータアクセスクラスです。
 */
public class DbT3082DaisanshaKoiKyushoDac implements ISaveable<DbT3082DaisanshaKoiKyushoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護第三者行為求償を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 第三者行為求償請求番号 KyushoSeikyuNo
     * @param 履歴番号 RirekiNo
     * @return DbT3082DaisanshaKoiKyushoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3082DaisanshaKoiKyushoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            RString 第三者行為求償請求番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3082DaisanshaKoiKyusho.class).
                where(and(
                eq(hihokenshaNo, 被保険者番号),
                eq(todokedeKanriNo, 第三者行為届出管理番号),
                eq(kyushoSeikyuNo, 第三者行為求償請求番号),
                eq(rirekiNo, 履歴番号))).
                toObject(DbT3082DaisanshaKoiKyushoEntity.class);
    }

    /**
     * 介護第三者行為求償を全件返します。
     *
     * @return List<DbT3082DaisanshaKoiKyushoEntity>
     */
    @Transaction
    public List<DbT3082DaisanshaKoiKyushoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3082DaisanshaKoiKyusho.class).
                toList(DbT3082DaisanshaKoiKyushoEntity.class);
    }

    /**
     * DbT3082DaisanshaKoiKyushoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3082DaisanshaKoiKyushoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為求償エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
