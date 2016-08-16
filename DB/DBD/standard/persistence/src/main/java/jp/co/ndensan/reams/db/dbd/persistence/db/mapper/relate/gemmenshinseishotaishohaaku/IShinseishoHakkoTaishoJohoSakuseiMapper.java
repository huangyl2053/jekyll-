/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.ShinseishoHakkoTaishoJohoSakuseiEntity;

/**
 *
 * 申請書発行対象者情報作成 Mapper
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public interface IShinseishoHakkoTaishoJohoSakuseiMapper {

    /**
     * get申請書発行対象者情報_負担限度額認定のメソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<ShinseishoHakkoTaishoJohoSakuseiEntity> 更新申請対象外者情報
     */
    List<ShinseishoHakkoTaishoJohoSakuseiEntity> get申請書発行対象者情報_負担限度額認定(ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter Parameter);

    /**
     * get申請書発行対象者情報_利用者負担額減額のメソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<ShinseishoHakkoTaishoJohoSakuseiEntity> 更新申請対象外者情報
     */
    List<ShinseishoHakkoTaishoJohoSakuseiEntity> get申請書発行対象者情報_利用者負担額減額(ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter Parameter);

    /**
     * get申請書発行対象者情報_訪問介護利用者負担額減額のメソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<ShinseishoHakkoTaishoJohoSakuseiEntity> 更新申請対象外者情報
     */
    List<ShinseishoHakkoTaishoJohoSakuseiEntity> get申請書発行対象者情報_訪問介護利用者負担額減額(ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter Parameter);

    /**
     * get申請書発行対象者情報_社会福祉法人等利用者負担軽減のメソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<ShinseishoHakkoTaishoJohoSakuseiEntity> 更新申請対象外者情報
     */
    List<ShinseishoHakkoTaishoJohoSakuseiEntity> get申請書発行対象者情報_社会福祉法人等利用者負担軽減(ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter Parameter);

}
