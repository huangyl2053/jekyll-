/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigohihokenshainfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2009RentaiGimushaDac;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.mapper.IUaFt200FindShikibetsuTaishoFunctionMapper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 連帯納付義務者登録Mangerです。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public class KaigoHihokenshaInfoPanelManger {

    private final DbT2009RentaiGimushaDac rentaiGimushaDac;
    private final MapperProvider mapperProvider;

    /**
     * サービス種類登録クラスのコンストラクタです。
     */
    public KaigoHihokenshaInfoPanelManger() {

        rentaiGimushaDac = InstanceProvider.create(DbT2009RentaiGimushaDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 利サービス種類登録クラスのコンストラクタです(テスト用)。
     *
     * @param kaigoServiceDac rentaigimushaDac
     */
    KaigoHihokenshaInfoPanelManger(DbT2009RentaiGimushaDac rentaiGimushaDac) {

        this.rentaiGimushaDac = rentaiGimushaDac;
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 連帯納付義務者登録を取得します。
     *
     * @param entity DbT2009RentaiGimushaEntity
     */
    public void save(RentaiGimusha entity) {
        rentaiGimushaDac.save(entity.toEntity());
    }

    /**
     * 画面．宛名情報を取得する。
     *
     * @param parameter IShikibetsuTaishoPSMSearchKey
     * @return 宛名情報
     */
    public IShikibetsuTaisho get宛名情報(IShikibetsuTaishoPSMSearchKey parameter) {
        UaFt200FindShikibetsuTaishoParam param = new UaFt200FindShikibetsuTaishoParam(parameter);
        IUaFt200FindShikibetsuTaishoFunctionMapper mapper = mapperProvider.create(IUaFt200FindShikibetsuTaishoFunctionMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSMlist = mapper.selectByParameterClass(param);
        if (宛名PSMlist == null || 宛名PSMlist.isEmpty()) {
            return null;
        } else {
            IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名PSMlist.get(0));
            return 宛名情報;
        }
    }
}
