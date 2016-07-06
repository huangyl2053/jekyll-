/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikenshosakuseijissekishokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshojissekiichiran.IkenshoJissekiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojissekiichiran.IkenshoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshojissekiichiran.IIkenshoJissekiIchiranMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 意見書作成実績照会のデータを検索クラスです。
 *
 * @reamsid_L DBE-1690-010 dongyabin
 */
public class IkenshoSakuseiJissekiShokaiFindler {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    IkenshoSakuseiJissekiShokaiFindler() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    IkenshoSakuseiJissekiShokaiFindler(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IkenshoSakuseiJissekiShokaiFindler}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IkenshoSakuseiJissekiShokaiFindler}のインスタンス
     */
    public static IkenshoSakuseiJissekiShokaiFindler createInstance() {
        return InstanceProvider.create(IkenshoSakuseiJissekiShokaiFindler.class);
    }

    /**
     * 意見書作成実績照会を取得します。
     *
     * @param mapperParameter 検索用パラメータです。
     * @return SearchResult<IkenshoJissekiIchiran>
     */
    public SearchResult<IkenshoJissekiIchiran> get主治医意見書作成実績集計表(IkenshoJissekiIchiranMybitisParamter mapperParameter) {
        IIkenshoJissekiIchiranMapper mapper = mapperProvider.create(IIkenshoJissekiIchiranMapper.class);
        List<IkenshoJissekiIchiranRelateEntity> entityList = mapper.get主治医意見書作成実績集計表(mapperParameter);
        List<IkenshoJissekiIchiran> 主治医意見書作成実績集計表List = new ArrayList<>();
        for (IkenshoJissekiIchiranRelateEntity entity : entityList) {
            主治医意見書作成実績集計表List.add(new IkenshoJissekiIchiran(entity));
        }
        return SearchResult.of(主治医意見書作成実績集計表List, 0, false);
    }
}
