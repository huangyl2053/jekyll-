/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sogojigyohiseiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohisei.ISogojigyohiSeikyugakuTsuchishoKeikaSochiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 総合事業費（経過措置）請求額通知書のバッチのビジネス。
 *
 * @reamsid_L DBC-2480-011 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiManager {

    private final MapperProvider mapperProvider;
    private final ISogojigyohiSeikyugakuTsuchishoKeikaSochiMapper mapper;

    /**
     * コンストラクタです。
     */
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(ISogojigyohiSeikyugakuTsuchishoKeikaSochiMapper.class);
    }

    /**
     * get帳票出力対象データ
     *
     * @return List<DbWT1511SeikyugakuTsuchishoTempEntity>
     */
    public List<DbWT1511SeikyugakuTsuchishoTempEntity> get帳票出力対象データ() {
        List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト = mapper.select帳票出力対象データ();
        if (null == 帳票出力対象データリスト) {
            return Collections.EMPTY_LIST;
        }
        return 帳票出力対象データリスト;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuKyufuTaishoshaInManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuKyufuTaishoshaInManager}のインスタンス
     */
    public static SogojigyohiSeikyugakuTsuchishoKeikaSochiManager createInstance() {
        return InstanceProvider.create(SogojigyohiSeikyugakuTsuchishoKeikaSochiManager.class);
    }

}
