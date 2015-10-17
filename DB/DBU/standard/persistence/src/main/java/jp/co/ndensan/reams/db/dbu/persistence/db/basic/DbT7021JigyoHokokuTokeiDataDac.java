/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.hokokuM;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.hokokuYSeireki;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.hyoNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.shichosonCode;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.shukeiNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.shukeiTaishoM;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.shukeiTaishoYSeireki;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.shukeiTani;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.tateNo;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.toukeiTaishoKubun;
import static jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiData.yokoNo;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業報告統計データのデータアクセスクラスです。
 */
public class DbT7021JigyoHokokuTokeiDataDac implements ISaveable<DbT7021JigyoHokokuTokeiDataEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業報告統計データを取得します。
     *
     * @param 報告年 HokokuYSeireki
     * @param 報告月 HokokuM
     * @param 集計対象年 ShukeiTaishoYSeireki
     * @param 集計対象月 ShukeiTaishoM
     * @param 統計対象区分 ToukeiTaishoKubun
     * @param 市町村コード ShichosonCode
     * @param 表番号 HyoNo
     * @param 集計番号 ShukeiNo
     * @param 集計単位 ShukeiTani
     * @param 縦番号 TateNo
     * @param 横番号 YokoNo
     * @return DbT7021JigyoHokokuTokeiDataEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7021JigyoHokokuTokeiDataEntity selectByKey(
            FlexibleYear 報告年,
            RString 報告月,
            FlexibleYear 集計対象年,
            RString 集計対象月,
            RString 統計対象区分,
            LasdecCode 市町村コード,
            Code 表番号,
            Code 集計番号,
            Code 集計単位,
            Decimal 縦番号,
            Decimal 横番号) throws NullPointerException {
        requireNonNull(報告年, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年"));
        requireNonNull(報告月, UrSystemErrorMessages.値がnull.getReplacedMessage("報告月"));
        requireNonNull(集計対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象年"));
        requireNonNull(集計対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象月"));
        requireNonNull(統計対象区分, UrSystemErrorMessages.値がnull.getReplacedMessage("統計対象区分"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(表番号, UrSystemErrorMessages.値がnull.getReplacedMessage("表番号"));
        requireNonNull(集計番号, UrSystemErrorMessages.値がnull.getReplacedMessage("集計番号"));
        requireNonNull(集計単位, UrSystemErrorMessages.値がnull.getReplacedMessage("集計単位"));
        requireNonNull(縦番号, UrSystemErrorMessages.値がnull.getReplacedMessage("縦番号"));
        requireNonNull(横番号, UrSystemErrorMessages.値がnull.getReplacedMessage("横番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7021JigyoHokokuTokeiData.class).
                where(and(
                                eq(hokokuYSeireki, 報告年),
                                eq(hokokuM, 報告月),
                                eq(shukeiTaishoYSeireki, 集計対象年),
                                eq(shukeiTaishoM, 集計対象月),
                                eq(toukeiTaishoKubun, 統計対象区分),
                                eq(shichosonCode, 市町村コード),
                                eq(hyoNo, 表番号),
                                eq(shukeiNo, 集計番号),
                                eq(shukeiTani, 集計単位),
                                eq(tateNo, 縦番号),
                                eq(yokoNo, 横番号))).
                toObject(DbT7021JigyoHokokuTokeiDataEntity.class);
    }

    /**
     * 事業報告統計データを全件返します。
     *
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>
     */
    @Transaction
    public List<DbT7021JigyoHokokuTokeiDataEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7021JigyoHokokuTokeiData.class).
                toList(DbT7021JigyoHokokuTokeiDataEntity.class);
    }

    /**
     * DbT7021JigyoHokokuTokeiDataEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7021JigyoHokokuTokeiDataEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業報告統計データエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
