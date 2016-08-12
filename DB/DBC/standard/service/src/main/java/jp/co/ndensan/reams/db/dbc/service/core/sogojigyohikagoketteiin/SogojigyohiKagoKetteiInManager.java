/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sogojigyohikagoketteiin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikagoketteiin.ISogojigyohiKagoKetteiInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込一覧表の帳票出力対象データ取得
 *
 * @reamsid_L DBC-2550-010 fzou
 */
public class SogojigyohiKagoKetteiInManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SogojigyohiKagoKetteiInManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SogojigyohiKagoKetteiInManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンス
     */
    public static SogojigyohiKagoKetteiInManager createInstance() {
        return InstanceProvider.create(SogojigyohiKagoKetteiInManager.class);
    }

    /**
     * 総合事業費（経過措置）過誤決定通知書情報取込一覧表の帳票出力対象データ取得
     *
     * @param parameter Map<String,Object>
     * @return List<SogojigyohiKagoKetteiInEntity>
     */
    @Transaction
    public List<SogojigyohiKagoKetteiInEntity> get帳票出力対象データ(Map<String, Object> parameter) {
        ISogojigyohiKagoKetteiInMapper mapper = mapperProvider.create(ISogojigyohiKagoKetteiInMapper.class);

        List<SogojigyohiKagoKetteiInEntity> list = mapper.get帳票出力対象データ(parameter);
        if (null == list) {
            return new ArrayList<>();
        }
        return list;
    }
}
