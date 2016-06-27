/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaitaisho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaitaishosha.ShinsakaiTaishoshaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaitaishosha.ShinsakaiTaishoshaMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitaishosha.ShinsakaiTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaitaishosha.IShinsakaiTaishoshaRelateMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会個人別状況照会のServiceクラスです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
public class ShinsakaiTaishoshaFinder {

    private final MapperProvider mapperProvider;

    /**
     *
     * コンストラクタです。
     */
    ShinsakaiTaishoshaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    ShinsakaiTaishoshaFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiTaishoshaFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiTaishoshaFinder}のインスタンス
     */
    public static ShinsakaiTaishoshaFinder createInstance() {
        return InstanceProvider.create(ShinsakaiTaishoshaFinder.class);
    }

    /**
     * 予定情報と結果情報の一覧データ取得です。
     *
     * @param 審査会開催番号 RString
     * @return 該当者一覧照会情報
     */
    public ShinsakaiTaishoshaBusiness get予定情報と結果情報(RString 審査会開催番号) {
        IShinsakaiTaishoshaRelateMapper mapper = mapperProvider.create(IShinsakaiTaishoshaRelateMapper.class);
        List<ShinsakaiTaishoshaRelateEntity> entity = mapper.
                get予定情報と結果情報(ShinsakaiTaishoshaMapperParameter.createSelectBy情報(審査会開催番号));
        if (entity == null || entity.isEmpty()) {
            return null;
        }
        return new ShinsakaiTaishoshaBusiness(entity.get(0));
    }

    /**
     * 審査会対象者一覧の検索です。
     *
     * @param 審査会開催番号 RString
     * @return 審査会対象者一覧情報
     */
    public SearchResult<ShinsakaiTaishoshaBusiness> get情報(RString 審査会開催番号) {
        IShinsakaiTaishoshaRelateMapper mapper = mapperProvider.create(IShinsakaiTaishoshaRelateMapper.class);
        List<ShinsakaiTaishoshaBusiness> list = new ArrayList<>();
        List<ShinsakaiTaishoshaRelateEntity> entityList = mapper.get情報(審査会開催番号);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiTaishoshaBusiness>emptyList(), 0, false);
        }
        for (ShinsakaiTaishoshaRelateEntity entity : entityList) {
            list.add(new ShinsakaiTaishoshaBusiness(entity));
        }
        return SearchResult.of(list, 0, false);
    }
}
