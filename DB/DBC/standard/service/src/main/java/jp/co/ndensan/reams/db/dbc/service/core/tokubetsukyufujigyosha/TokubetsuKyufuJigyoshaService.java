/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyosha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaSearchEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc2210011.ITokubetsuKyufuJigyoshaSearchMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author liuyl
 */
public class TokubetsuKyufuJigyoshaService {

    private final MapperProvider mapperProvider;

    TokubetsuKyufuJigyoshaService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    public TokubetsuKyufuJigyoshaService(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    public static TokubetsuKyufuJigyoshaService createTokubetsuKyufuJigyoshaService() {
        return InstanceProvider.create(TokubetsuKyufuJigyoshaService.class);
    }

    public List<ShichosonTokubetuKyufuService> selectサービス内容() {
        ITokubetsuKyufuJigyoshaSearchMapper mapper = mapperProvider.create(ITokubetsuKyufuJigyoshaSearchMapper.class);
        List<DbT3066ShichosonTokubetuKyufuServiceEntity> サービス内容 = mapper.selectサービス内容();
        List<ShichosonTokubetuKyufuService> businessList = new ArrayList<>();
        if (サービス内容 != null) {
            for (DbT3066ShichosonTokubetuKyufuServiceEntity entity : サービス内容) {
                ShichosonTokubetuKyufuService business = new ShichosonTokubetuKyufuService(entity);
                businessList.add(business);
            }
        }
        return businessList;
    }

    public List<TokubetsuKyufuJigyoshaSearchBusiness> select事業者情報(RString 事業者番号) {
        ITokubetsuKyufuJigyoshaSearchMapper mapper = mapperProvider.create(ITokubetsuKyufuJigyoshaSearchMapper.class);
        List<TokubetsuKyufuJigyoshaSearchBusiness> businessList = new ArrayList<>();
        List<TokubetsuKyufuJigyoshaSearchEntity> 事業者情報 = mapper.select事業者情報(事業者番号);
        if (事業者情報 != null) {
            for (TokubetsuKyufuJigyoshaSearchEntity entity : 事業者情報) {
                TokubetsuKyufuJigyoshaSearchBusiness business = new TokubetsuKyufuJigyoshaSearchBusiness(entity);
                businessList.add(business);
            }
        }
        return businessList;
    }
}
