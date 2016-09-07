/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJoho;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJoho.hosokuM;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJoho.kisoNenkinNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJoho.nenkinCode;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJoho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJoho.shoriNendo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特徴未同定情報のデータアクセスクラスです。
 *
 * @reamsid_L DBB-9999-012 zhangrui
 */
public class DbT2019TokuchoMidoteiJohoDac implements ISaveable<DbT2019TokuchoMidoteiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで特徴未同定情報を取得します。
     *
     * @param 処理年度 処理年度
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @param 捕捉月 捕捉月
     * @param 識別コード 識別コード
     * @return DbT2019TokuchoMidoteiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2019TokuchoMidoteiJohoEntity selectByKey(
            FlexibleYear 処理年度,
            RString 基礎年金番号,
            RString 年金コード,
            RString 捕捉月,
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        requireNonNull(捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("捕捉月"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2019TokuchoMidoteiJoho.class).
                where(and(
                                eq(shoriNendo, 処理年度),
                                eq(kisoNenkinNo, 基礎年金番号),
                                eq(nenkinCode, 年金コード),
                                eq(hosokuM, 捕捉月),
                                eq(shikibetsuCode, 識別コード))).
                toObject(DbT2019TokuchoMidoteiJohoEntity.class);
    }

    /**
     * 特徴未同定情報を全件返します。
     *
     * @return DbT2019TokuchoMidoteiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT2019TokuchoMidoteiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2019TokuchoMidoteiJoho.class).
                toList(DbT2019TokuchoMidoteiJohoEntity.class);
    }

    /**
     * DbT2019TokuchoMidoteiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2019TokuchoMidoteiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴未同定情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで特徴未同定情報を取得します。
     *
     * @param 処理年度 処理年度
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @param 捕捉月 捕捉月
     * @param 識別コード 識別コード
     * @return List<DbT2019TokuchoMidoteiJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2019TokuchoMidoteiJohoEntity> selectNot識別コードByKey(
            FlexibleYear 処理年度,
            RString 基礎年金番号,
            RString 年金コード,
            RString 捕捉月,
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        requireNonNull(捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("捕捉月"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2019TokuchoMidoteiJoho.class).
                where(and(
                                eq(shoriNendo, 処理年度),
                                eq(kisoNenkinNo, 基礎年金番号),
                                eq(nenkinCode, 年金コード),
                                eq(hosokuM, 捕捉月),
                                not(eq(shikibetsuCode, 識別コード)))).
                toList(DbT2019TokuchoMidoteiJohoEntity.class);
    }
}
