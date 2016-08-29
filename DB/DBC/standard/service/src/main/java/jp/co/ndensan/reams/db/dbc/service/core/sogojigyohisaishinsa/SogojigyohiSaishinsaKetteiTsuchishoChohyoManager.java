/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sogojigyohisaishinsa;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohisaishinsa.ISogojigyohiSaishinsaKetteiTsuchishoChohyoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査決定通知書情報取込（公費負担者分）データ編集
 *
 * @reamsid_L DBC-4730-030 liuxiaoyu
 */
public class SogojigyohiSaishinsaKetteiTsuchishoChohyoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SogojigyohiSaishinsaKetteiTsuchishoChohyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SogojigyohiSaishinsaKetteiTsuchishoChohyoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンス
     */
    public static SogojigyohiSaishinsaKetteiTsuchishoChohyoManager createInstance() {
        return InstanceProvider.create(SogojigyohiSaishinsaKetteiTsuchishoChohyoManager.class);
    }

    /**
     * 再審査決定通知書情報取込一覧表（公費負担者分）の帳票出力対象データ取得
     *
     * @param parameter Map<String,Object>
     * @return List<ISogojigyohiSaishinsaKetteiTsuchishoChohyoMapper>
     */
    @Transaction
    public List<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter) {
        ISogojigyohiSaishinsaKetteiTsuchishoChohyoMapper mapper = mapperProvider.create(ISogojigyohiSaishinsaKetteiTsuchishoChohyoMapper.class);
        List<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity> list = mapper.get帳票出力対象データ(parameter);
        if (null == list) {
            return new ArrayList<>();
        }
        return list;
    }
}
