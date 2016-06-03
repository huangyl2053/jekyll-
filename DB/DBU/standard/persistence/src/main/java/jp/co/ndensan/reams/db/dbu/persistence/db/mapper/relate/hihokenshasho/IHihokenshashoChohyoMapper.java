/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.AtenaMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashochohyo.HonninJohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashochohyo.SofusakiJohoEntity;

/**
 * 被保険者証帳票作成のマッパーインタフェースです。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
public interface IHihokenshashoChohyoMapper {

    /**
     * 本人情報取得です。
     *
     * @param parameter AtenaMybatisParameter
     * @return 本人情報取得リスト List<HonninJohoEntity>
     */
    List<HonninJohoEntity> get本人情報取得(AtenaMybatisParameter parameter);

    /**
     * 送付先情報取得です。
     *
     * @param parameter AtenaMybatisParameter
     * @return 送付先情報取得リスト List<SofusakiJohoEntity>
     */
    List<SofusakiJohoEntity> get送付先情報取得(AtenaMybatisParameter parameter);
}
