/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.soufujouhou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.soufujouhou.SoufuJouhouBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou.SoufuJouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.soufujouhou.SoufuJouhouRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.soufujouhou.ISoufuJouhouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBC0080011_再審査申立送付情報照会のクラスです。
 *
 * @reamsid_L DBC-3050-010 zhangzhiming
 */
public class SoufuJouhouFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SoufuJouhouFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    SoufuJouhouFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SoufuJouhouFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SoufuJouhouFinder}のインスタンス
     */
    public static SoufuJouhouFinder createInstance() {
        return InstanceProvider.create(SoufuJouhouFinder.class);
    }

    /**
     * 検索条件より、再審査申立書情報を取得します。
     *
     * @param parameter 再審査申立書検索条件
     * @return SearchResult<SoufuJouhouBusiness> 再審査申立書情報リスト
     */
    @Transaction
    public SearchResult<SoufuJouhouBusiness> get再審査申立書情報(SoufuJouhouParameter parameter) {
        ISoufuJouhouMapper mapper = mapperProvider.create(ISoufuJouhouMapper.class);
        List<SoufuJouhouBusiness> businessList = new ArrayList<>();
        List<SoufuJouhouRelateEntity> entityList = mapper.select再審査申立送付情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<SoufuJouhouBusiness>emptyList(), 0, false);
        }
        for (SoufuJouhouRelateEntity entity : entityList) {
            businessList.add(new SoufuJouhouBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

}
