/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3080DaisanshaKoiJidan;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3080DaisanshaKoiJidan.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3080DaisanshaKoiJidanEntity;
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
 * 介護第三者行為示談のデータアクセスクラスです。
 */
public class DbT3080DaisanshaKoiJidanDac implements ISaveable<DbT3080DaisanshaKoiJidanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護第三者行為示談を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 示談報告書受付年月日 JidanHokokushoUketukeYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3080DaisanshaKoiJidanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3080DaisanshaKoiJidanEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            FlexibleDate 示談報告書受付年月日,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(示談報告書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3080DaisanshaKoiJidan.class).
                where(and(
                eq(hihokenshaNo, 被保険者番号),
                eq(todokedeKanriNo, 第三者行為届出管理番号),
                eq(jidanHokokushoUketukeYMD, 示談報告書受付年月日),
                eq(rirekiNo, 履歴番号))).
                toObject(DbT3080DaisanshaKoiJidanEntity.class);
    }

    /**
     * 介護第三者行為示談を全件返します。
     *
     * @return List<DbT3080DaisanshaKoiJidanEntity>
     */
    @Transaction
    public List<DbT3080DaisanshaKoiJidanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3080DaisanshaKoiJidan.class).
                toList(DbT3080DaisanshaKoiJidanEntity.class);
    }

    /**
     * DbT3080DaisanshaKoiJidanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3080DaisanshaKoiJidanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為示談エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
