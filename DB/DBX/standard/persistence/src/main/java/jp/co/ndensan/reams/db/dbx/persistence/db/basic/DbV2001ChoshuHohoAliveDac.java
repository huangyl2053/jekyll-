/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHoho10gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHoho11gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHoho12gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHoho1gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHoho2gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHoho3gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHoho9gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHohoYoku4gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.choshuHohoYoku5gatsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.fukaNendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHoho.rirekiNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護徴収方法Aliveのデータアクセスクラスです。
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
public class DbV2001ChoshuHohoAliveDac implements ISaveable<DbV2001ChoshuHohoEntity> {

    private static final RString 普徴 = new RString("3");
    private static final RString MSG_賦課年度 = new RString("賦課年度");
    private static final RString 特別徴収厚生労働省 = new RString("1");
    private static final RString 特別徴収地共済 = new RString("2");
    private static final RString 普通徴収 = new RString("3");

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護徴収方法Aliveを取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbV2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV2001ChoshuHohoEntity selectByKey(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_賦課年度.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbV2001ChoshuHohoEntity.class);
    }

    /**
     * 介護徴収方法Aliveを全件返します。
     *
     * @return List<DbV2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbV2001ChoshuHohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                toList(DbV2001ChoshuHohoEntity.class);
    }

    /**
     * DbV2001ChoshuHohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV2001ChoshuHohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護徴収方法Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 被保険者徴収方法情報の取得。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @return DbV2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV2001ChoshuHohoEntity selectChoshuhohonojohoAll(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_賦課年度.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号))).
                toObject(DbV2001ChoshuHohoEntity.class);
    }

    /**
     * 最新介護徴収方法情報の取得。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @return DbT2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2001ChoshuHohoEntity select最新介護徴収方法(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_賦課年度.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号))).
                toObject(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 徴収方法情報の取得。
     *
     * @param 賦課年度 FlexibleYear
     * @return List<DbV2001ChoshuHohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2001ChoshuHohoEntity> select徴収方法情報(
            FlexibleYear 賦課年度) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_賦課年度.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(choshuHoho10gatsu, 普徴),
                                or(eq(choshuHoho9gatsu, 特別徴収厚生労働省),
                                        eq(choshuHoho9gatsu, 特別徴収地共済)))).
                toList(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 12月特別徴収開始者を抽出する
     *
     * @param 賦課年度 FlexibleYear
     * @return List<DbV2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbV2001ChoshuHohoEntity> get特別徴収開始者_12月(FlexibleYear 賦課年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(choshuHoho10gatsu, 普通徴収),
                                eq(choshuHoho11gatsu, 普通徴収),
                                or(eq(choshuHoho12gatsu, 特別徴収厚生労働省),
                                        eq(choshuHoho12gatsu, 特別徴収地共済)),
                                or(eq(choshuHoho1gatsu, 特別徴収厚生労働省),
                                        eq(choshuHoho1gatsu, 特別徴収地共済))
                        )).
                toList(DbV2001ChoshuHohoEntity.class);

    }

    /**
     * 2月特別徴収開始者を抽出する
     *
     * @param 賦課年度 FlexibleYear
     * @return List<DbV2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbV2001ChoshuHohoEntity> get特別徴収開始者_2月(FlexibleYear 賦課年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(choshuHoho12gatsu, 普通徴収),
                                eq(choshuHoho1gatsu, 普通徴収),
                                or(eq(choshuHoho2gatsu, 特別徴収厚生労働省),
                                        eq(choshuHoho2gatsu, 特別徴収地共済)),
                                or(eq(choshuHoho3gatsu, 特別徴収厚生労働省),
                                        eq(choshuHoho3gatsu, 特別徴収地共済))
                        )).
                toList(DbV2001ChoshuHohoEntity.class);

    }

    /**
     * 4月特別徴収開始者を抽出する
     *
     * @param 賦課年度 FlexibleYear
     * @return List<DbV2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbV2001ChoshuHohoEntity> get特別徴収開始者_4月(FlexibleYear 賦課年度) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(choshuHoho2gatsu, 普通徴収),
                                eq(choshuHoho3gatsu, 普通徴収),
                                or(eq(choshuHohoYoku4gatsu, 特別徴収厚生労働省),
                                        eq(choshuHohoYoku4gatsu, 特別徴収地共済)),
                                or(eq(choshuHohoYoku5gatsu, 特別徴収厚生労働省),
                                        eq(choshuHohoYoku5gatsu, 特別徴収地共済))
                        )).
                toList(DbV2001ChoshuHohoEntity.class);

    }
}
