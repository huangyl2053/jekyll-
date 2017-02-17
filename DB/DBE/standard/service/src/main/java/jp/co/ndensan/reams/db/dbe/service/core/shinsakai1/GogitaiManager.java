/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai1;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohoshinsakai.GogitaiJohoShinsaRelateBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai.GogitaiJohoShinsaRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohoshinsakai.IGogitaiJohoShinsaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyotei.GogitaiIchiranJohoMapperParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 合議体情報の取得処理クラスです。
 *
 * @reamsid_L DBE-0130-040 yaodongsheng
 */
public class GogitaiManager {

    private final MapperProvider mapperProvider;
    private final RString 月初日 = new RString("01");

    /**
     * コンストラクタです。
     */
    GogitaiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GogitaiManager}のインスタンスを返します。
     *
     * @return GogitaiManager
     */
    public static GogitaiManager createInstance() {

        return InstanceProvider.create(GogitaiManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    GogitaiManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 合議体情報のリストを取得処理です。
     *
     * @param 基準年月 RString
     * @param 末日 RString
     * @param 合議体No RString
     * @return 合議体情報
     */
    public SearchResult<GogitaiJohoShinsaRelateBusiness> get合議体情報(RString 基準年月, RString 末日, RString 合議体No) {
        List<GogitaiJohoShinsaRelateBusiness> 合議体情報 = new ArrayList<>();
        RString 開催予定開始日 = 基準年月.concat(末日);
        RString 開催予定終了日 = 基準年月.concat(月初日);
        GogitaiIchiranJohoMapperParameter param = GogitaiIchiranJohoMapperParameter.createGogitaiJoho(開催予定開始日, 開催予定終了日, 合議体No);
        IGogitaiJohoShinsaMapper mapper = mapperProvider.create(IGogitaiJohoShinsaMapper.class);
        List<GogitaiJohoShinsaRelateEntity> entityList = mapper.get合議体情報(param);
        for (GogitaiJohoShinsaRelateEntity entity : entityList) {
            合議体情報.add(new GogitaiJohoShinsaRelateBusiness(entity));
        }
        return SearchResult.of(合議体情報, 0, false);
    }

    /**
     * 合議体情報のリストを取得処理です。
     *
     * @param 開催予定日 RString
     * @param 合議体No RString
     * @return 合議体情報
     */
    public SearchResult<GogitaiJohoShinsaRelateBusiness> get合議体情報By開催予定日(RString 開催予定日, RString 合議体No) {
        List<GogitaiJohoShinsaRelateBusiness> 合議体情報 = new ArrayList<>();
        GogitaiIchiranJohoMapperParameter param = GogitaiIchiranJohoMapperParameter.createGogitaiJoho(開催予定日, 開催予定日, 合議体No);
        IGogitaiJohoShinsaMapper mapper = mapperProvider.create(IGogitaiJohoShinsaMapper.class);
        List<GogitaiJohoShinsaRelateEntity> entityList = mapper.get合議体情報(param);
        for (GogitaiJohoShinsaRelateEntity entity : entityList) {
            合議体情報.add(new GogitaiJohoShinsaRelateBusiness(entity));
        }
        return SearchResult.of(合議体情報, 0, false);
    }
}
