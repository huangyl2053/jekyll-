/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaishohakko.FutanwariaishoHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.RiyoshaFutanwariaishoTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * バッチ設計_DBCMNK3001_負担割合証発行（一括）Mapperクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public interface IFutanwariaishoHakkoMapper {

    /**
     *
     * @param para {@link FutanwariaishoHakkoMybatisParameter}
     * @return {@link List<DbT3113RiyoshaFutanWariaiEntity>}
     */
    List<DbT3114RiyoshaFutanWariaiMeisaiEntity> select利用者負担割合明細(FutanwariaishoHakkoMybatisParameter para);

    /**
     *
     * @param para {@link FutanwariaishoHakkoMybatisParameter}
     * @return {@link List<DbT7022ShoriDateKanriEntity>}
     */
    List<DbT7022ShoriDateKanriEntity> select処理日付管理(FutanwariaishoHakkoMybatisParameter para);

    /**
     *
     * @param para {@link FutanwariaishoHakkoMybatisParameter}
     * @return {@link List<RiyoshaFutanwariaishoTempEntity>}
     */
    List<RiyoshaFutanwariaishoTempEntity> select利用者負担割合証(FutanwariaishoHakkoMybatisParameter para);
}
