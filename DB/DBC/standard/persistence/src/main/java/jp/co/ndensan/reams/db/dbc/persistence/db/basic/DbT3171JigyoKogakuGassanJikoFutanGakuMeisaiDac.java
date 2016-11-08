/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisai;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisai.hokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisai.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisai.shikyuShinseishoSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisai.taishoM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisai.taishoNendo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
 * 事業高額合算自己負担額明細のデータアクセスクラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
public class DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiDac implements ISaveable<DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業高額合算自己負担額明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @param 履歴番号 int
     * @param 対象月 RString
     * @return DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity
     */
    @Transaction
    public DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号,
            RString 対象月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象月"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3171JigyoKogakuGassanJikoFutanGakuMeisai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(rirekiNo, 履歴番号),
                                eq(taishoM, 対象月))).
                toObject(DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity.class);

    }

    /**
     * DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額合算自己負担額明細エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
