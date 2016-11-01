/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shichosontokubetukyufuservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shichosontokubetukyufuservice.ShichosonTokubetuKyufuServiceEntityResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shichosontokubetukyufuservice.ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shichosontokubetukyufuservice.IShichosonTokubetuKyufuServiceMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村特別給付サービス内容を管理するクラスです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public class ShichosonTokubetuKyufuServiceFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShichosonTokubetuKyufuServiceFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShichosonTokubetuKyufuServiceFinder}のインスタンスを返します。
     *
     * @return ShichosonTokubetuKyufuServiceFinder
     */
    public static ShichosonTokubetuKyufuServiceFinder createInstance() {
        return InstanceProvider.create(ShichosonTokubetuKyufuServiceFinder.class);
    }

    /**
     * 市町村特別給付サービス内容一覧情報の取得。
     *
     * @return List<ShichosonTokubetuKyufuServiceEntityResult>
     */
    public List<ShichosonTokubetuKyufuServiceEntityResult> get一覧情報() {
        IShichosonTokubetuKyufuServiceMapper mapper = mapperProvider.create(IShichosonTokubetuKyufuServiceMapper.class);
        List<ShichosonTokubetuKyufuServiceEntity> 市町村特別給付サービス内容一覧情報 = mapper.get一覧情報();
        List<ShichosonTokubetuKyufuServiceEntityResult> resultList = new ArrayList<>();
        if (市町村特別給付サービス内容一覧情報 != null) {
            for (ShichosonTokubetuKyufuServiceEntity entity : 市町村特別給付サービス内容一覧情報) {
                ShichosonTokubetuKyufuServiceEntityResult result = new ShichosonTokubetuKyufuServiceEntityResult();
                result.setサービスコード(entity.getサービスコード());
                result.set有効期間開始年月日(entity.get有効期間開始年月日());
                result.set有効期間終了年月日(entity.get有効期間終了年月日());
                result.set正式名称(entity.get正式名称());
                result.setサービス区分(entity.getサービス区分());
                result.set単位(entity.get単位());
                result.set支給限度基準額(entity.get支給限度基準額());
                result.set略称(entity.get略称());
                result.set履歴番号(entity.get履歴番号());
                result.set直近フラグ(entity.get直近フラグ());
                resultList.add(result);
            }
        }
        return resultList;
    }

    /**
     * 最大履歴番号の取得。
     *
     * @param serviceCode serviceCode
     * @return 最大履歴番号
     */
    public Integer get最大履歴番号(RString serviceCode) {
        IShichosonTokubetuKyufuServiceMapper mapper = mapperProvider.create(IShichosonTokubetuKyufuServiceMapper.class);
        return mapper.get最大履歴番号(serviceCode);
    }
}
