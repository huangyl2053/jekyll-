/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshainkouhifutann;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainkouhifutann.IKohifutanshaChohyoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤決定通知書情報取込一覧表（公費負担者分）の帳票出力対象データ取得
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KagoKetteiKohifutanshaChohyoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KagoKetteiKohifutanshaChohyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KagoKetteiKohifutanshaChohyoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンス
     */
    public static KagoKetteiKohifutanshaChohyoManager createInstance() {
        return InstanceProvider.create(KagoKetteiKohifutanshaChohyoManager.class);
    }

    /**
     * 過誤決定通知書情報取込一覧表（公費負担者分）の帳票出力対象データ取得
     *
     * @param parameter Map<String,Object>
     * @return List<KagoKetteiKohifutanshaChohyoEntity>
     */
    @Transaction
    public List<KagoKetteiKohifutanshaChohyoEntity> get帳票出力対象データ(Map<String, Object> parameter) {
        IKohifutanshaChohyoMapper mapper = mapperProvider.create(IKohifutanshaChohyoMapper.class);
        List<KagoKetteiKohifutanshaChohyoEntity> list = mapper.get帳票出力対象データ(parameter);
        if (null == list) {
            return new ArrayList<>();
        }
        return list;
    }

}
