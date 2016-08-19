/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.dbc120840;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120840.SogojigyohiKagoKetteiHokenshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120840.ISogojigyohiKagoKetteiHokenshaChohyoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshainkouhifutann.KagoKetteiHokenshaInKouhiFutann;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合事業費過誤決定通知書情報取込（保険者分）データ編集
 *
 * @reamsid_L DBC-2550-011 jiangxiaolong
 */
public class SogojigyohiKagoKetteiHokenshaChohyoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SogojigyohiKagoKetteiHokenshaChohyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SogojigyohiKagoKetteiHokenshaChohyoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンス
     */
    public static SogojigyohiKagoKetteiHokenshaChohyoManager createInstance() {
        return InstanceProvider.create(SogojigyohiKagoKetteiHokenshaChohyoManager.class);
    }

    /**
     * 再審査決定通知書情報取込一覧表（公費負担者分）の帳票出力対象データ取得
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<SaishinsaKetteiTsuchishoChohyoEntity>
     */
    @Transaction
    public List<SogojigyohiKagoKetteiHokenshaChohyoEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter) {
        ISogojigyohiKagoKetteiHokenshaChohyoMapper mapper = mapperProvider.create(ISogojigyohiKagoKetteiHokenshaChohyoMapper.class);
        List<SogojigyohiKagoKetteiHokenshaChohyoEntity> list = mapper.get帳票出力対象データ(parameter);
        if (null == list) {
            return new ArrayList<>();
        }
        return list;
    }
}
