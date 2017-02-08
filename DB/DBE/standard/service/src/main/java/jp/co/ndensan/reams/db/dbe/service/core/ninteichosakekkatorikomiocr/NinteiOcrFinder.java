/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosakekkatorikomiocr;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr.NinteiOcrRelate;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaKekkaTorikomiOcrRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosahyoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosakekkatorikomiocr.INinteiOcrMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果取込み（OCR）のサービスクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiOcrFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiOcrFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     * @param IkenshoImageJohoManager {@link dbt5305}
     * @param NinteichosahyoTokkijikoManager {@link dbt5205}
     */
    NinteiOcrFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiOcrFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteiOcrFinder}のインスタンス
     */
    public static NinteiOcrFinder createInstance() {
        return InstanceProvider.create(NinteiOcrFinder.class);
    }

    /**
     * 関連データを取得します。
     *
     * @param paramter 検索用のパラメータ
     * @return 関連データ
     */
    public SearchResult<NinteiOcrRelate> get関連データ(NinteiOcrMapperParamter paramter) {
        List<NinteiOcrRelate> imageinputList = new ArrayList<>();
        INinteiOcrMapper mapper = mapperProvider.create(INinteiOcrMapper.class);
        List<NinteiChosaKekkaTorikomiOcrRelateEntity> entityList = mapper.get関連データ(paramter);
        for (NinteiChosaKekkaTorikomiOcrRelateEntity entity : entityList) {
            imageinputList.add(new NinteiOcrRelate(entity));
        }
        return SearchResult.of(imageinputList, 0, false);
    }

    /**
     * @param paramter 検索用のパラメータ
     * @return 認定調査票
     */
    public List<NinteiChosahyoEntity> get認定調査票(NinteiOcrMapperParamter paramter) {
        INinteiOcrMapper mapper = mapperProvider.create(INinteiOcrMapper.class);
        return mapper.get認定調査票(paramter);
    }
}
