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
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;

/**
 *
 * @author SE1007
 */
public interface IShokanbaraiJyokyoShokaiMapper {

    List<ServiceTeikyoShomeisho> getサービス提供証明書一覧(ShokanbaraiJyokyoShokaiParameter parameter);

    List<ShokanMeisaiEntity> get償還払請求明細一覧();

    List<ShokanMeisaiJushochiTokureiEntity> get償還払請求明細住特一覧(ShokanbaraiJyokyoShokaiParameter parameter);

    List<ShokanServicePlan200904Entity> get償還払請求サービス計画200904データ(ShokanbaraiJyokyoShokaiParameter parameter);

    List<ShokanServicePlan200604Entity> get償還払請求サービス計画200604データ(ShokanbaraiJyokyoShokaiParameter parameter);

    List<ShokanServicePlan200004Entity> get償還払請求サービス計画200004データ(ShokanbaraiJyokyoShokaiParameter parameter);

    List<ShokanShukeiEntity> get償還払請求集計データ(ShokanbaraiJyokyoShokaiParameter parameter);

    List<ShokanShakaiFukushiHojinKeigengakuEntity> get償還払請求社会福祉法人軽減額データ(ShokanbaraiJyokyoShokaiParameter parameter);

    List<DbT3118ShikibetsuNoKanriEntity> get識別番号管理データ(ShokanbaraiJyokyoShokaiParameter parameter);

    List<DbT7060KaigoJigyoshaEntity> get介護事業者情報(ShokanbaraiJyokyoShokaiParameter parameter);

    List<DbT7120TokuteiShinryoServiceCodeEntity> get特定診療サービスコード(ShokanbaraiJyokyoShokaiParameter parameter);

}
