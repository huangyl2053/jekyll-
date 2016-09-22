/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiout.IKogakugassanKyufujissekiOutMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額合算給付実績情報作成のserviceです。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiOutService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KogakugassanKyufujissekiOutService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link KogakugassanKyufujissekiOutService}のインスタンスを返します。
     *
     * @return KogakugassanFinder
     */
    public static KogakugassanKyufujissekiOutService createInstance() {
        return InstanceProvider.create(KogakugassanKyufujissekiOutService.class);
    }

    /**
     * 出力対象データ件数
     *
     * @return 件数
     */
    public int get出力対象データ件数() {
        int number;
        IKogakugassanKyufujissekiOutMapper mapper = mapperProvider.create(IKogakugassanKyufujissekiOutMapper.class);
        number = mapper.get送付ファイル作成データ件数();
        return number;
    }

}
