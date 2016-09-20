/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakujuryoininkeiyakujigyosha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakujuryoininkeiyakujigyosha.IKogakuJuryoininKeiyakuJigyoshaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author Administrator
 */
public class KogakuJuryoininKeiyakuJigyoshaFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KogakuJuryoininKeiyakuJigyoshaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KogakuJuryoininKeiyakuJigyoshaFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンス
     */
    public static KogakuJuryoininKeiyakuJigyoshaFinder createInstance() {
        return InstanceProvider.create(KogakuJuryoininKeiyakuJigyoshaFinder.class);
    }

    /**
     * 高額受領委任契約事業者の情報を取得します。
     *
     * @param param KogakuJuryoininKeiyakuJigyoshaParameter
     * @return KogakuJuryoininKeiyakuJigyoshaResultのリスト
     */
    @Transaction
    public List<KogakuJuryoininKeiyakuJigyoshaResult> get高額受領委任契約事業者情報(KogakuJuryoininKeiyakuJigyoshaParameter param) {
        IKogakuJuryoininKeiyakuJigyoshaMapper mapper = mapperProvider.create(IKogakuJuryoininKeiyakuJigyoshaMapper.class);
        List<KogakuJuryoininKeiyakuJigyoshaEntity> entityList = mapper.select高額受領委任契約事業者情報(param);
        List<KogakuJuryoininKeiyakuJigyoshaResult> resultList = new ArrayList<>();
        if (null != entityList) {
            for (KogakuJuryoininKeiyakuJigyoshaEntity entity : entityList) {
                resultList.add(new KogakuJuryoininKeiyakuJigyoshaResult(entity.getKogakuJuryoininKeiyakuJigyoshaEntity(),
                        entity.getJigyoshaNo(), entity.getJigyoshaName()));
            }
        }
        return resultList;
    }
}
