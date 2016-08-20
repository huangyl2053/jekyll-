/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufukanrihyoshokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoshokai.KyufuKanrihyoShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoshokai.KyufuKanrihyoShokaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyoshokai.IKyufuKanrihyoShokaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付管理票照会（画面）のビジネスです。
 *
 * @reamsid_L DBC-2960-060 chenxiangyu
 */
public class KyufuKanrihyoShokai {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KyufuKanrihyoShokai() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    public KyufuKanrihyoShokai(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuKanrihyoShokai}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyufuKanrihyoShokai}のインスタンス
     */
    public static KyufuKanrihyoShokai createInstance() {
        return InstanceProvider.create(KyufuKanrihyoShokai.class);
    }

    /**
     * 給付管理票一覧を取得します。
     *
     * @param 被保番号 被保番号
     * @param 支援事業者番号 支援事業者番号
     * @param 給付対象年月開始 給付対象年月開始
     * @param 給付対象年月終了 給付対象年月終了
     * @return List<KyufuKanrihyoShokaiBusiness>
     */
    public List<KyufuKanrihyoShokaiBusiness> selectKyufuKanrihyoList(
            RString 被保番号,
            RString 支援事業者番号,
            RString 給付対象年月開始,
            RString 給付対象年月終了) {
        KyufuKanrihyoShokaiMapperParameter parameter = KyufuKanrihyoShokaiMapperParameter.createKyufuKanrihyoParameter(
                被保番号,
                支援事業者番号,
                給付対象年月開始,
                給付対象年月終了);
        IKyufuKanrihyoShokaiMapper mapper = mapperProvider.create(IKyufuKanrihyoShokaiMapper.class);
        List<KyufuKanrihyoShokaiEntity> 給付管理票一覧Entity = mapper.select給付管理票一覧(parameter);
        List<KyufuKanrihyoShokaiBusiness> 給付管理票一覧 = null;
        if (給付管理票一覧Entity != null) {
            if (給付管理票一覧Entity.isEmpty()) {
                給付管理票一覧 = null;
            } else {
                給付管理票一覧 = new ArrayList<>();
                for (KyufuKanrihyoShokaiEntity entity : 給付管理票一覧Entity) {
                    給付管理票一覧.add(new KyufuKanrihyoShokaiBusiness(entity));
                }
            }
        }
        return 給付管理票一覧;
    }

    /**
     * 給付管理明細一覧を取得します。
     *
     * @param 審査年月 審査年月
     * @param サービス提供年月 サービス提供年月
     * @param 被保険者番号 被保険者番号
     * @return List<KyufuKanrihyoShokaiBusiness>
     */
    public List<KyufuKanrihyoShokaiBusiness> selectKyufuKanriMeisaiList(
            RString 審査年月,
            RString サービス提供年月,
            RString 被保険者番号) {
        KyufuKanrihyoShokaiMapperParameter parameter = KyufuKanrihyoShokaiMapperParameter.createKyufuKanriMeisaiParameter(
                審査年月,
                サービス提供年月,
                被保険者番号);
        IKyufuKanrihyoShokaiMapper mapper = mapperProvider.create(IKyufuKanrihyoShokaiMapper.class);
        List<KyufuKanrihyoShokaiEntity> 給付管理明細一覧Entity = mapper.select給付管理明細一覧(parameter);
        List<KyufuKanrihyoShokaiBusiness> 給付管理明細一覧 = null;
        if (給付管理明細一覧Entity != null) {
            if (給付管理明細一覧Entity.isEmpty()) {
                給付管理明細一覧 = null;
            } else {
                給付管理明細一覧 = new ArrayList<>();
                for (KyufuKanrihyoShokaiEntity entity : 給付管理明細一覧Entity) {
                    給付管理明細一覧.add(new KyufuKanrihyoShokaiBusiness(entity));
                }
            }
        }
        return 給付管理明細一覧;
    }
}
