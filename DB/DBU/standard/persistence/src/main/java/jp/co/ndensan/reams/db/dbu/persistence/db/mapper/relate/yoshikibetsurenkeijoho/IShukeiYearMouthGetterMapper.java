/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.yoshikibetsurenkeijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.yoshikibetsurenkeijoho.ShukeiYearMouthGetterParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;

/**
 * 集計年月取得のマッパーインタフェースです。
 *
 * @reamsid_L DBU-4050-030 suguangjun
 */
public interface IShukeiYearMouthGetterMapper {

    /**
     * 一般状況１～１０の集計年月を取得します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    DbT7021JigyoHokokuTokeiDataEntity selectCollectionDate1_10(ShukeiYearMouthGetterParameter parameter);

    /**
     * 一般状況１１・１２～１４【現物分】の集計年月を取得します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    DbT7021JigyoHokokuTokeiDataEntity selectCollectionDate12_14(ShukeiYearMouthGetterParameter parameter);

    /**
     * 一般状況１１・１２～１４【償還分】の審査年月を取得します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    DbT7021JigyoHokokuTokeiDataEntity selectReviewDate12_14(ShukeiYearMouthGetterParameter parameter);

    /**
     * 一般状況１１・１２～１４【償還分】の決定年月を取得します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    DbT7021JigyoHokokuTokeiDataEntity selectDecisionDate12_14(ShukeiYearMouthGetterParameter parameter);

    /**
     * 保険給付決定状況【現物分】の集計年月を取得します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    DbT7021JigyoHokokuTokeiDataEntity selectCollectionDate(ShukeiYearMouthGetterParameter parameter);

    /**
     * 保険給付決定状況【償還分】の審査年月を取得します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    DbT7021JigyoHokokuTokeiDataEntity selectReviewDate(ShukeiYearMouthGetterParameter parameter);

    /**
     * 保険給付決定状況【償還分】の決定年月を取得します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    DbT7021JigyoHokokuTokeiDataEntity selectDecisionDate(ShukeiYearMouthGetterParameter parameter);

    /**
     * 過去報告年月を取得します。
     *
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> selectKakoHokokuYM();
}
