/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.HanteiTaishoshaTokuteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.HanteiTaishoshaTokuteiEntity;

/**
 *
 * 減免減額対象者判定用根拠作成対象者作成 Mapper
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public interface IHanteiTaishoshaTokuteiMapper {

    /**
     * 減免減額対象者判定用根拠作成対象者_負担限度額認定を取得する。
     *
     * @param parameter HanteiTaishoshaTokuteiMyBatisParameter
     * @return List<HanteiTaishoshaTokuteiEntity>
     */
    List<HanteiTaishoshaTokuteiEntity> get減免減額対象者判定用根拠作成対象者_負担限度額認定(HanteiTaishoshaTokuteiMyBatisParameter parameter);

    /**
     * 減免減額対象者判定用根拠作成対象者_利用者負担額減額を取得する。
     *
     * @param parameter HanteiTaishoshaTokuteiMyBatisParameter
     * @return List<HanteiTaishoshaTokuteiEntity>
     */
    List<HanteiTaishoshaTokuteiEntity> get減免減額対象者判定用根拠作成対象者_利用者負担額減額(HanteiTaishoshaTokuteiMyBatisParameter parameter);

    /**
     * 減免減額対象者判定用根拠作成対象者_訪問介護利用者負担額減額を取得する。
     *
     * @param parameter HanteiTaishoshaTokuteiMyBatisParameter
     * @return List<HanteiTaishoshaTokuteiEntity>
     */
    List<HanteiTaishoshaTokuteiEntity> get減免減額対象者判定用根拠作成対象者_訪問介護利用者負担額減額(HanteiTaishoshaTokuteiMyBatisParameter parameter);

    /**
     * 減免減額対象者判定用根拠作成対象者_社会福祉法人等利用者負担軽減を取得する。
     *
     * @param parameter HanteiTaishoshaTokuteiMyBatisParameter
     * @return List<HanteiTaishoshaTokuteiEntity>
     */
    List<HanteiTaishoshaTokuteiEntity> get減免減額対象者判定用根拠作成対象者_社会福祉法人等利用者負担軽減(HanteiTaishoshaTokuteiMyBatisParameter parameter);
}
