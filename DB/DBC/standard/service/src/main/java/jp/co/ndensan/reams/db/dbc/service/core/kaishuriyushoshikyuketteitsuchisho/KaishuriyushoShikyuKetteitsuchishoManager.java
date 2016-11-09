/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kaishuriyushoshikyuketteitsuchisho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho.KetteiTimestampBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaishuriyushoshikyuketteitsuchisho.IKaishuriyushoShikyuKetteitsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成クラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public class KaishuriyushoShikyuKetteitsuchishoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KaishuriyushoShikyuKetteitsuchishoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    public KaishuriyushoShikyuKetteitsuchishoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaishuriyushoShikyuKetteitsuchishoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaishuriyushoShikyuKetteitsuchishoManager}のインスタンス
     */
    public static KaishuriyushoShikyuKetteitsuchishoManager createInstance() {
        return InstanceProvider.create(KaishuriyushoShikyuKetteitsuchishoManager.class);
    }

    /**
     * 前回の実行情報を取得します。
     *
     * @param parameter 住宅改修理由書作成手数料支給（不支給）決定通知書作成のMyBatis用パラメータ
     * @return KetteiTimestampBusiness nullが返る可能性があります。
     */
    public KetteiTimestampBusiness get前回の実行情報(KaishuriyushoShikyuKetteitsuchishoMybatisParameter parameter) {
        IKaishuriyushoShikyuKetteitsuchishoMapper mapper = mapperProvider.create(IKaishuriyushoShikyuKetteitsuchishoMapper.class);
        KaishuriyushoShikyuKetteitsuchishoRelateEntity entity = mapper.selectKetteiTimestamp(parameter);
        if (entity == null) {
            return null;
        } else {
            return new KetteiTimestampBusiness(entity);
        }
    }

    /**
     * ドロップダウンリスト項目セットです。
     *
     * @param parameter 決定通知書作成のMyBatis用パラメータ
     * @return KetteiTimestampBusiness nullが返る可能性があります。
     */
    public SearchResult<KetteiTimestampBusiness> getDDL事業者(KaishuriyushoShikyuKetteitsuchishoMybatisParameter parameter) {
        IKaishuriyushoShikyuKetteitsuchishoMapper mapper = mapperProvider.create(IKaishuriyushoShikyuKetteitsuchishoMapper.class);
        List<KaishuriyushoShikyuKetteitsuchishoRelateEntity> entityList = mapper.selectDDL事業者(parameter);
        List<KetteiTimestampBusiness> list = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<KetteiTimestampBusiness>emptyList(), 0, false);
        }
        for (KaishuriyushoShikyuKetteitsuchishoRelateEntity entity : entityList) {
            list.add(new KetteiTimestampBusiness(entity));
        }
        return SearchResult.of(list, 0, false);
    }
}
