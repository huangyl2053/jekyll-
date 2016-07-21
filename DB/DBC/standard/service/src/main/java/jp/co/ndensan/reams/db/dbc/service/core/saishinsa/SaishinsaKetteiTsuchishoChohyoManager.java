/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishinsaKetteiTsuchishoChohyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsa.ISaishinsaKetteiTsuchishoChohyoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査決定通知書情報取込（公費負担者分）データ編集
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class SaishinsaKetteiTsuchishoChohyoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiTsuchishoChohyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SaishinsaKetteiTsuchishoChohyoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンス
     */
    public static SaishinsaKetteiTsuchishoChohyoManager createInstance() {
        return InstanceProvider.create(SaishinsaKetteiTsuchishoChohyoManager.class);
    }

    /**
     * 再審査決定通知書情報取込一覧表（公費負担者分）の帳票出力対象データ取得
     *
     * @param parameter Map<String,Object>
     * @return List<SaishinsaKetteiTsuchishoChohyoEntity>
     */
    @Transaction
    public List<SaishinsaKetteiTsuchishoChohyoEntity> get帳票出力対象データ(Map<String, Object> parameter) {
        ISaishinsaKetteiTsuchishoChohyoMapper mapper = mapperProvider.create(ISaishinsaKetteiTsuchishoChohyoMapper.class);
        List<SaishinsaKetteiTsuchishoChohyoEntity> list = mapper.get帳票出力対象データ(parameter);
        if (null == list) {
            return new ArrayList<>();
        }
        return list;
    }
}
