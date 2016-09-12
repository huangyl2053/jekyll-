/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shakaifukushihojinkeigen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shakaifukushihojinkeigen.IShakaiFukushiHojinKeigenMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 【共有子Div】 社会福祉法人軽減Finderです。
 *
 * @reamsid_L DBD-3560-050 wangjie2
 */
public class ShakaiFukushiHojinKeigenFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShakaiFukushiHojinKeigenFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 【共有子Div】社会福祉法人軽減FinderのIntanceを作成します。
     *
     * @return ShakaiFukushiHojinKeigenFinder
     */
    public static ShakaiFukushiHojinKeigenFinder createIntance() {
        return InstanceProvider.create(ShakaiFukushiHojinKeigenFinder.class);
    }

    /**
     * 訪問介護利用者負担額減額情報の申請一覧情報取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<社会福祉法人等利用者負担軽減の情報>
     */
    @Transaction
    public List<ShakaifukuRiyoshaFutanKeigen> get申請一覧_社会福祉法人等利用者負担軽減の情報(HihokenshaNo 被保険者番号) {
        List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List = new ArrayList<>();
        ShakaiFukushiHojinKeigenParameter 検索条件 = new ShakaiFukushiHojinKeigenParameter(
                被保険者番号, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード());
        IShakaiFukushiHojinKeigenMapper mapper = mapperProvider.create(IShakaiFukushiHojinKeigenMapper.class);
        List<ShafukuRiyoshaFutanKeigenEntity> entityList = mapper.get申請一覧_社会福祉法人等利用者負担軽減の情報(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (ShafukuRiyoshaFutanKeigenEntity entity : entityList) {
                社会福祉法人等利用者負担軽減の情報List.add(new ShakaifukuRiyoshaFutanKeigen(entity));
            }
        }
        return 社会福祉法人等利用者負担軽減の情報List;
    }

}
