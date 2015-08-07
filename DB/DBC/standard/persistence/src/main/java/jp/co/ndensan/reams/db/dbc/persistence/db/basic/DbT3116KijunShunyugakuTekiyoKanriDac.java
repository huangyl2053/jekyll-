/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
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
 * 基準収入額適用管理のデータアクセスクラスです。
 */
public class DbT3116KijunShunyugakuTekiyoKanriDac implements ISaveable<DbT3116KijunShunyugakuTekiyoKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで基準収入額適用管理を取得します。
     *
     * @param 世帯コード SetaiCode
     * @param 年度 Nendo
     * @param 履歴番号 RirekiNo
     * @param 被保険者番号 HihokenshaNo
     * @return DbT3116KijunShunyugakuTekiyoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3116KijunShunyugakuTekiyoKanriEntity selectByKey(
            SetaiCode 世帯コード,
            FlexibleYear 年度,
            Decimal 履歴番号,
            HokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(and(
                eq(setaiCode, 世帯コード),
                eq(nendo, 年度),
                eq(rirekiNo, 履歴番号),
                eq(hihokenshaNo, 被保険者番号))).
                toObject(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理を全件返します。
     *
     * @return List<DbT3116KijunShunyugakuTekiyoKanriEntity>
     */
    @Transaction
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * DbT3116KijunShunyugakuTekiyoKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3116KijunShunyugakuTekiyoKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("基準収入額適用管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
