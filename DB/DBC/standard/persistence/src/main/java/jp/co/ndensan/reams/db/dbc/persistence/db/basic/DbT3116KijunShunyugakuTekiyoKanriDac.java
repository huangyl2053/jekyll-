/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.nendo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanri.setaiCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準収入額適用管理のデータアクセスクラスです。
 */
public class DbT3116KijunShunyugakuTekiyoKanriDac implements ISaveable<DbT3116KijunShunyugakuTekiyoKanriEntity> {

    @InjectSession
    private SqlSession session;
    private static final int 定数_1 = 1;

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
            int 履歴番号,
            HihokenshaNo 被保険者番号) throws NullPointerException {
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
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 基準収入額適用管理マスタを取得します。
     *
     * @param 世帯コード SetaiCode
     * @param 年度 Nendo
     *
     * @return DbT3116KijunShunyugakuTekiyoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> selectJouhousootoNendo(
            RString 世帯コード,
            FlexibleYear 年度
    ) throws NullPointerException {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(and(
                                eq(setaiCode, 世帯コード),
                                eq(nendo, 年度))).
                toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

    /**
     * 基準収入額適用管理マスタねんど年度 によっての抽出。
     *
     * @param 年度 Nendo
     *
     * @return DbT3116KijunShunyugakuTekiyoKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public List<DbT3116KijunShunyugakuTekiyoKanriEntity> select基準収入額適用管理マスタ(
            FlexibleYear 年度
    ) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3116KijunShunyugakuTekiyoKanri.class).
                where(
                        eq(nendo, 年度)
                ).
                toList(DbT3116KijunShunyugakuTekiyoKanriEntity.class);
    }

}
