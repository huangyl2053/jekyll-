/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.homonkaigogemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;

/**
 * 訪問介護利用者負担額減額申請（画面）Mapperです。
 *
 * @reamsid_L DBD-3730-030 wangjie2
 */
public interface IHomonKaigoRiryoshaFutangakuGengakuMapper {

    /**
     * 訪問介護利用者負担額減額申請の取得します。
     *
     * @param parameter パラメータ
     * @return List<HomonKaigoRiyoshaFutangakuGengakuEntity>
     */
    List<HomonKaigoRiyoshaFutangakuGengakuEntity> get訪問介護利用者負担額減額の情報List(ShakaiFukushiHojinKeigenParameter parameter);

}
