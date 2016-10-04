/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassanhoseisumijikofutangaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan.SyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan.IKogakugassanHoseisumiJikofutangakuOutMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額合算補正済自己負担額情報作成のFinderです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class KogakugassanFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KogakugassanFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link KogakugassanFinder}のインスタンスを返します。
     *
     * @return KogakugassanFinder
     */
    public static KogakugassanFinder createInstance() {
        return InstanceProvider.create(KogakugassanFinder.class);
    }

    /**
     * 高額合算補正済自己負担額情報作成のデータを取得。
     *
     * @return List<SyuturyokuEntity>
     */
    public List<SyuturyokuEntity> get出力対象データ() {
        IKogakugassanHoseisumiJikofutangakuOutMapper mapper = mapperProvider.create(IKogakugassanHoseisumiJikofutangakuOutMapper.class);
        List<SyuturyokuEntity> list = mapper.get出力対象データ();
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }
}
