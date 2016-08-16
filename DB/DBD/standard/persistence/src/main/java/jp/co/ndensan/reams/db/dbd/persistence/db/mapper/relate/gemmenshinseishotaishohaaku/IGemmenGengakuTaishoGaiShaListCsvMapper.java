/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.GemmenGengakuTaishoGaiShaListMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.GemmenGengakuTaishoGaiShaEntity;

/**
 *
 * 減免・減額更新申請対象外者一覧CSV作成 Mapper
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public interface IGemmenGengakuTaishoGaiShaListCsvMapper {

    /**
     * 減免減額更新申請対象外者一覧CSV情報_負担限度額認定を取得する。
     *
     * @param parameter GemmenGengakuTaishoGaiShaListMyBatisParameter
     * @return List<GemmenGengakuTaishoGaiShaEntity>
     */
    List<GemmenGengakuTaishoGaiShaEntity> get減免減額更新申請対象外者一覧CSV情報_負担限度額認定(GemmenGengakuTaishoGaiShaListMyBatisParameter parameter);

    /**
     * 減免減額更新申請対象外者一覧CSV情報_利用者負担額減額を取得する。
     *
     * @param parameter GemmenGengakuTaishoGaiShaListMyBatisParameter
     * @return List<GemmenGengakuTaishoGaiShaEntity>
     */
    List<GemmenGengakuTaishoGaiShaEntity> get減免減額更新申請対象外者一覧CSV情報_利用者負担額減額(GemmenGengakuTaishoGaiShaListMyBatisParameter parameter);

    /**
     * 減免減額更新申請対象外者一覧CSV情報_訪問介護利用者負担額減額を取得する。
     *
     * @param parameter GemmenGengakuTaishoGaiShaListMyBatisParameter
     * @return List<GemmenGengakuTaishoGaiShaEntity>
     */
    List<GemmenGengakuTaishoGaiShaEntity> get減免減額更新申請対象外者一覧CSV情報_訪問介護利用者負担額減額(GemmenGengakuTaishoGaiShaListMyBatisParameter parameter);

    /**
     * 減免減額更新申請対象外者一覧CSV情報_社会福祉法人等利用者負担軽減を取得する。
     *
     * @param parameter GemmenGengakuTaishoGaiShaListMyBatisParameter
     * @return List<GemmenGengakuTaishoGaiShaEntity>
     */
    List<GemmenGengakuTaishoGaiShaEntity> get減免減額更新申請対象外者一覧CSV情報_社会福祉法人等利用者負担軽減(GemmenGengakuTaishoGaiShaListMyBatisParameter parameter);
}
