/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shakaifukushihojinkeigen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;

/**
 * 【共有子Div】 社会福祉法人軽減Mapperです。
 *
 * @reamsid_L DBD-3560-050 wangjie2
 */
public interface IShakaiFukushiHojinKeigenMapper {

    /**
     * 訪問介護利用者負担額減額情報の申請一覧情報取得します。
     *
     * @param parameter パラメータ
     * @return List<ShafukuRiyoshaFutanKeigenEntity>
     */
    List<ShafukuRiyoshaFutanKeigenEntity> get申請一覧_社会福祉法人等利用者負担軽減の情報(ShakaiFukushiHojinKeigenParameter parameter);

}
