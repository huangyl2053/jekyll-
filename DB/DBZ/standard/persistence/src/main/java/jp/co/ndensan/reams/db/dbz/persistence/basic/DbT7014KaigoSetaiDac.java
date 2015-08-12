/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.honninKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.kanriShikibetsuKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.kazeiHikazeiKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.kazeiNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.setaiHaakuKijunYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.setaiInkanriRenban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetai.setaiInshikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護世帯のデータアクセスクラスです。
 */
public class DbT7014KaigoSetaiDac implements ISaveable<DbT7014KaigoSetaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護世帯を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 管理識別区分 KanriShikibetsuKubun
     * @param 世帯把握基準年月日 SetaiHaakuKijunYMD
     * @param 世帯員管理連番 SetaiInkanriRenban
     * @param 世帯員識別コード SetaiInshikibetsuCode
     * @param 本人区分 HonninKubun
     * @param 課税年度 KazeiNendo
     * @param 課税非課税区分 KazeiHikazeiKubun
     * @return DbT7014KaigoSetaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7014KaigoSetaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 管理識別区分,
            FlexibleDate 世帯把握基準年月日,
            int 世帯員管理連番,
            ShikibetsuCode 世帯員識別コード,
            RString 本人区分,
            FlexibleYear 課税年度,
            RString 課税非課税区分) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理識別区分"));
        requireNonNull(世帯把握基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯把握基準年月日"));
        requireNonNull(世帯員管理連番, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員管理連番"));
        requireNonNull(世帯員識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コード"));
        requireNonNull(本人区分, UrSystemErrorMessages.値がnull.getReplacedMessage("本人区分"));
        requireNonNull(課税年度, UrSystemErrorMessages.値がnull.getReplacedMessage("課税年度"));
        requireNonNull(課税非課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("課税非課税区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7014KaigoSetai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kanriShikibetsuKubun, 管理識別区分),
                                eq(setaiHaakuKijunYMD, 世帯把握基準年月日),
                                eq(setaiInkanriRenban, 世帯員管理連番),
                                eq(setaiInshikibetsuCode, 世帯員識別コード),
                                eq(honninKubun, 本人区分),
                                eq(kazeiNendo, 課税年度),
                                eq(kazeiHikazeiKubun, 課税非課税区分))).
                toObject(DbT7014KaigoSetaiEntity.class);
    }

    /**
     * 介護世帯を全件返します。
     *
     * @return List<DbT7014KaigoSetaiEntity>
     */
    @Transaction
    public List<DbT7014KaigoSetaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7014KaigoSetai.class).
                toList(DbT7014KaigoSetaiEntity.class);
    }

    /**
     * DbT7014KaigoSetaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7014KaigoSetaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護世帯エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
