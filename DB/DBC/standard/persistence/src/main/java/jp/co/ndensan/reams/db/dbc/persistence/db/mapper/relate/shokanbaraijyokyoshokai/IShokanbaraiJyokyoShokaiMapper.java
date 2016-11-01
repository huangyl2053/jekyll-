/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraijyokyoshokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ServiceTeikyoShomeisho;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;

/**
 * 償還払い状況照会
 *
 * @reamsid_L DBC-1010-180 panhe
 */
public interface IShokanbaraiJyokyoShokaiMapper {

    /**
     * サービス提供証明書一覧
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ServiceTeikyoShomeisho>
     */
    List<ServiceTeikyoShomeisho> getサービス提供証明書一覧(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求明細一覧
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanMeisaiEntity>
     */
    List<ShokanMeisaiEntity> get償還払請求明細一覧(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求明細一覧取得（指定サービス種類以外）
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanMeisaiEntity>
     */
    List<ShokanMeisaiEntity> get償還払請求明細一覧_指定サービス種類以外(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求明細住特一覧
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanMeisaiJushochiTokureiEntity>
     */
    List<ShokanMeisaiJushochiTokureiEntity> get償還払請求明細住特一覧(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求サービス計画200904データ
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanServicePlan200904Entity>
     */
    List<ShokanServicePlan200904Entity> get償還払請求サービス計画200904データ(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求サービス計画200604データ
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanServicePlan200604Entity>
     */
    List<ShokanServicePlan200604Entity> get償還払請求サービス計画200604データ(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求サービス計画200004データ
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanServicePlan200004Entity>
     */
    List<ShokanServicePlan200004Entity> get償還払請求サービス計画200004データ(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求集計データ
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanShukeiEntity>
     */
    List<ShokanShukeiEntity> get償還払請求集計データ(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 償還払請求社会福祉法人軽減額データ
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<ShokanShakaiFukushiHojinKeigengakuEntity>
     */
    List<ShokanShakaiFukushiHojinKeigengakuEntity> get償還払請求社会福祉法人軽減額データ(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 識別番号管理データ
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     */
    List<DbT3118ShikibetsuNoKanriEntity> get識別番号管理データ(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 介護事業者情報
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<DbT7060KaigoJigyoshaEntity>
     */
    List<DbT7060KaigoJigyoshaEntity> get介護事業者情報(ShokanbaraiJyokyoShokaiParameter parameter);

    /**
     * 特定診療サービスコード
     *
     * @param parameter ShokanbaraiJyokyoShokaiParameter
     * @return List<DbT7120TokuteiShinryoServiceCodeEntity>
     */
    List<DbT7120TokuteiShinryoServiceCodeEntity> get特定診療サービスコード(ShokanbaraiJyokyoShokaiParameter parameter);
}
