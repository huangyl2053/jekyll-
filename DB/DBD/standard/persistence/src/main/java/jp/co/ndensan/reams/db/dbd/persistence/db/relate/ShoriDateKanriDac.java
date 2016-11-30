/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.relate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri.nendoNaiRenban;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri.shichosonCode;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri.shoriName;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanri.subGyomuCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳リスト初期表示情報の取得
 *
 * @reamsid_L DBD-1760-010 xuejm
 */
public class ShoriDateKanriDac {

    @InjectSession
    private SqlSession session;
    private static final RString サブ業務コードメッセージ = new RString("サブ業務コード");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");
    private static final RString 処理日付管理マスタエンティティ = new RString("処理日付管理マスタエンティティ");
    private static final RString 年度内連番_1 = new RString("0001");

    /**
     * 主キーで処理日付管理マスタを削除します。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public void deletePhysicalByKey(
            DbT7022ShoriDateKanriEntity entity) throws NullPointerException {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        accessor.deletePhysical(entity);
    }

    /**
     * 処理日付管理マスタを全件返します。
     *
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * DbT7022ShoriDateKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT7022ShoriDateKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(処理日付管理マスタエンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(処理日付管理マスタエンティティ.toString()));
     *
     * DbT7022ShoriDateKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT7022ShoriDateKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(処理日付管理マスタエンティティ.toString()));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 抽出調定日時を取得します。
     *
     * @param サブ業務コード subGyomuCode
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectSubGyomuCode(SubGyomuCode サブ業務コード) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(eq(
                                subGyomuCode, サブ業務コード)).
                order(by(DbT7022ShoriDateKanri.nendo, Order.DESC),
                        by(DbT7022ShoriDateKanri.nendoNaiRenban, Order.DESC)).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 受給者台帳管理マスタを取得します。
     *
     * @param 市町村コード ShichosonCode
     *
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity select前回抽出期間情報の取得(LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(subGyomuCode, SubGyomuCode.DBD介護受給),
                                eq(shichosonCode, 市町村コード),
                                eq(shoriName, ShoriName.受給者台帳.get名称()),
                                eq(nendoNaiRenban, 年度内連番_1))).limit(1).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }
}
