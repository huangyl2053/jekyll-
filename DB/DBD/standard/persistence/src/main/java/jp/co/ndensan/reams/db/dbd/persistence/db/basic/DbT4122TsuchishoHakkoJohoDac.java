/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.tsuchiKaishiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.tsuchiKanryoYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.tsuchiKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.tsuchiKubunKigenYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.tsuchiRiyu;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.tsuchiShuryoYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJoho.tsuchiYMD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 通知書発行情報のデータアクセスクラスです。
 *
 * @reamsid_L DBD-9999-013 chenxin
 */
public class DbT4122TsuchishoHakkoJohoDac implements ISaveable<DbT4122TsuchishoHakkoJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで通知書発行情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 通知区分 通知区分
     * @param 通知理由 通知理由
     * @param 通知年月日 通知年月日
     * @param 通知開始年月日 通知開始年月日
     * @param 通知終了年月日 通知終了年月日
     * @param 通知区分期限 通知区分期限
     * @param 通知完了年月日 通知完了年月日
     * @return DbT4122TsuchishoHakkoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4122TsuchishoHakkoJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            Code 通知区分,
            RString 通知理由,
            FlexibleDate 通知年月日,
            FlexibleDate 通知開始年月日,
            FlexibleDate 通知終了年月日,
            FlexibleDate 通知区分期限,
            FlexibleDate 通知完了年月日) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(通知区分, UrSystemErrorMessages.値がnull.getReplacedMessage("通知区分"));
        requireNonNull(通知理由, UrSystemErrorMessages.値がnull.getReplacedMessage("通知理由"));
        requireNonNull(通知年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知年月日"));
        requireNonNull(通知開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知開始年月日"));
        requireNonNull(通知終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知終了年月日"));
        requireNonNull(通知区分期限, UrSystemErrorMessages.値がnull.getReplacedMessage("通知区分期限"));
        requireNonNull(通知完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知完了年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4122TsuchishoHakkoJoho.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(tsuchiKubun, 通知区分),
                                eq(tsuchiRiyu, 通知理由),
                                eq(tsuchiYMD, 通知年月日),
                                eq(tsuchiKaishiYMD, 通知開始年月日),
                                eq(tsuchiShuryoYMD, 通知終了年月日),
                                eq(tsuchiKubunKigenYMD, 通知区分期限),
                                eq(tsuchiKanryoYMD, 通知完了年月日))).
                toObject(DbT4122TsuchishoHakkoJohoEntity.class);
    }

    /**
     * 通知書発行情報を全件返します。
     *
     * @return DbT4122TsuchishoHakkoJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4122TsuchishoHakkoJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4122TsuchishoHakkoJoho.class).
                toList(DbT4122TsuchishoHakkoJohoEntity.class);
    }

    /**
     * DbT4122TsuchishoHakkoJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4122TsuchishoHakkoJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書発行情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
