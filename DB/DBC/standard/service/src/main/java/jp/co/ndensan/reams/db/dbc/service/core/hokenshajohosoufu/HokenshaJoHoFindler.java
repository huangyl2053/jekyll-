/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hokenshajohosoufu;

import jp.co.ndensan.reams.db.dbc.business.core.hokenshajohosoufu.HokenshaJoHoData;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou.hokenshajohosoufu.HokenshaJoHoParamter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshajohosoufu.IHokenshaJoHoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 保険者情報送付の共有ファイルエントリ情報の取得のクラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public class HokenshaJoHoFindler {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public HokenshaJoHoFindler() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    public HokenshaJoHoFindler(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link  HokenshaJoHoFindler}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link  HokenshaJoHoFindler}のインスタンス
     */
    public static HokenshaJoHoFindler createInstance() {
        return InstanceProvider.create(HokenshaJoHoFindler.class);
    }

    /**
     * 共有ファイルエントリ情報を取得します。
     *
     * @param paramter パラメータク
     * @return HokenshaJoHoData
     */
    public HokenshaJoHoData get共有ファイルエントリ情報(HokenshaJoHoParamter paramter) {
        IHokenshaJoHoMapper mapper = mapperProvider.create(IHokenshaJoHoMapper.class);
        return new HokenshaJoHoData(mapper.get共有ファイルエントリ情報(paramter));
    }
}
