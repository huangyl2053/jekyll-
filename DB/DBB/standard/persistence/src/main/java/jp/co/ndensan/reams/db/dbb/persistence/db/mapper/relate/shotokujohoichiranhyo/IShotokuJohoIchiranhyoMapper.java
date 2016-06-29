/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokujohoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyo.ShotokuJohoIchiranhyoKouikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyo.ShotokuJohoIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyo.TaishoShuryoYmdEntity;

/**
 * ビジネス設計_DBBBZ51003_所得情報一覧表作成のMapper
 *
 * @reamsid_L DBB-1650-030 lijunjun
 */
public interface IShotokuJohoIchiranhyoMapper {

    /**
     * select対象終了日時_広域
     *
     * @param par ShotokuJohoIchiranhyoParameter
     * @return List<TaishoShuryoYmdEntity>
     */
    List<TaishoShuryoYmdEntity> select対象終了日時_広域(ShotokuJohoIchiranhyoParameter par);

    /**
     * select対象終了日時
     *
     * @param par ShotokuJohoIchiranhyoKouikiParameter
     * @return List<TaishoShuryoYmdEntity>
     */
    List<TaishoShuryoYmdEntity> select対象終了日時(ShotokuJohoIchiranhyoKouikiParameter par);
}
