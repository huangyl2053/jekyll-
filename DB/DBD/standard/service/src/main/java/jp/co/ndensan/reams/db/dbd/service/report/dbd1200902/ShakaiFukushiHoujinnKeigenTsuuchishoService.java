/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd1200902;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei.IShakaiFukushiHoujinnKeigenTsuuchishoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 障がい者控除対象者認定ハンドラクラスです
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public class ShakaiFukushiHoujinnKeigenTsuuchishoService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShakaiFukushiHoujinnKeigenTsuuchishoService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 利用者負担割合を取得します。
     *
     * @param 利用者負担割合検索条件 利用者負担割合検索条件
     * @return int 利用者負担割合件数
     */
    @Transaction
    public int get利用者負担割合(ShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter 利用者負担割合検索条件) {
        IShakaiFukushiHoujinnKeigenTsuuchishoMapper mapper
                = mapperProvider.create(IShakaiFukushiHoujinnKeigenTsuuchishoMapper.class);
        List<ShakaiFukushiHoujinnKeigenTsuuchishoEntity> result
                = mapper.get社会福祉法人等軽減の通知書発行情報(利用者負担割合検索条件);
        if (result == null || result.isEmpty()) {
            return 0;
        }
        return result.size();
    }
}
