/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsaiinjissekiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsaiinjissekiichiran.IShinsaiinJissekiIchiranMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会委員実績照会のデータを検索クラスです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
public class ShinsaiinJissekiIchiranFindler {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsaiinJissekiIchiranFindler() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    ShinsaiinJissekiIchiranFindler(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsaiinJissekiIchiranFindler}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsaiinJissekiIchiranFindler}のインスタンス
     */
    public static ShinsaiinJissekiIchiranFindler createInstance() {
        return InstanceProvider.create(ShinsaiinJissekiIchiranFindler.class);
    }

    /**
     * 審査会委員実績データの取得します。
     *
     * @param mapperParameter 検索用パラメータです。
     * @return SearchResult<ShinsaiinJissekiIchiran>
     */
    public SearchResult<ShinsaiinJissekiIchiran> get介護認定審査会委員報酬集計表(ShinsaiinJissekiIchiranMybitisParamter mapperParameter) {
        IShinsaiinJissekiIchiranMapper mapper = mapperProvider.create(IShinsaiinJissekiIchiranMapper.class);
        List<ShinsaiinJissekiIchiranRelateEntity> entityList = mapper.get介護認定審査会委員報酬集計表(mapperParameter);
        List<ShinsaiinJissekiIchiran> 介護認定審査会委員報酬集計表List = new ArrayList<>();
        for (ShinsaiinJissekiIchiranRelateEntity entity : entityList) {
            介護認定審査会委員報酬集計表List.add(new ShinsaiinJissekiIchiran(entity));
        }
        return SearchResult.of(介護認定審査会委員報酬集計表List, 0, false);
    }
}
