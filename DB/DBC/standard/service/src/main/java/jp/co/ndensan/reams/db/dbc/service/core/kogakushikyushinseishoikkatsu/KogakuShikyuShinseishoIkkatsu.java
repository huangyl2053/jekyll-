/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakushikyushinseishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.koga.KogakuShikyuShinseishoIkkatsuHakkoMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.koga.IKogakuShikyuShinseishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額サービス費給付お知らせ通知書作成のハンドラクラスです。
 *
 * @reamsid DBC-4770-010 zhengshenlei
 */
public class KogakuShikyuShinseishoIkkatsu {

    private final MapperProvider mapperProvider;

    public KogakuShikyuShinseishoIkkatsu() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link TokuchoHeijunkaKakutei}のインスタンスを返します。
     *
     * @return KogakuShikyuShinseishoIkkatsuHakko
     */
    public static KogakuShikyuShinseishoIkkatsu createInstance() {
        return InstanceProvider.create(KogakuShikyuShinseishoIkkatsu.class);
    }

    /**
     * サービス提供年月の取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 HokenshaNo
     * @return List<KogakuShikyuShinsei>
     */
    @Transaction
    public List<KogakuShikyuShinsei> getServiceTeikyoByDbT3056(HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号) {
        KogakuShikyuShinseishoIkkatsuHakkoMapperParameter parameter = KogakuShikyuShinseishoIkkatsuHakkoMapperParameter
                .createSelectByKeyParam(被保険者番号, 証記載保険者番号);
        IKogakuShikyuShinseishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKogakuShikyuShinseishoIkkatsuHakkoMapper.class);
        List<DbT3056KogakuShikyuShinseiEntity> entityList = mapper.getServiceTeikyoByDbT3056(parameter);
        List<KogakuShikyuShinsei> list = new ArrayList<>();
        for (DbT3056KogakuShikyuShinseiEntity entity : entityList) {
            list.add(new KogakuShikyuShinsei(entity));
        }
        return list;
    }

    /**
     * サービス提供年月の取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 HokenshaNo
     * @return List<JigyoKogakuShikyuShinsei>
     */
    @Transaction
    public List<JigyoKogakuShikyuShinsei> getServiceTeikyoByDbT3110(HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号) {
        KogakuShikyuShinseishoIkkatsuHakkoMapperParameter parameter = KogakuShikyuShinseishoIkkatsuHakkoMapperParameter
                .createSelectByKeyParam(被保険者番号, 証記載保険者番号);
        IKogakuShikyuShinseishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKogakuShikyuShinseishoIkkatsuHakkoMapper.class);
        List<DbT3110JigyoKogakuShikyuShinseiEntity> entityList = mapper.getServiceTeikyoByDbT3110(parameter);
        List<JigyoKogakuShikyuShinsei> list = new ArrayList<>();
        for (DbT3110JigyoKogakuShikyuShinseiEntity entity : entityList) {
            list.add(new JigyoKogakuShikyuShinsei(entity));
        }
        return list;
    }
}
