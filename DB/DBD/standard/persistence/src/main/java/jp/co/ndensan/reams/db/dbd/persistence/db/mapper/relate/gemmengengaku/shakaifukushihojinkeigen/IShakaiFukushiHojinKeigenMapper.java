/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.shakaifukushihojinkeigen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;

/**
 *
 * 社会福祉法人等利用者負担軽減申請（画面）Mapperです。
 *
 * @reamsid_L DBD-3660-030 wangjie2
 */
public interface IShakaiFukushiHojinKeigenMapper {

    /**
     * 訪問介護利用者負担額減額情報の取得します。
     *
     * @param parameter パラメータ
     * @return List<ShafukuRiyoshaFutanKeigenEntity>
     */
    List<ShafukuRiyoshaFutanKeigenEntity> get社会福祉法人等利用者負担軽減の情報List(ShakaiFukushiHojinKeigenParameter parameter);

}
