/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosakekkatorikomiocr;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr.NinteiOcrResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaKekkaTorikomiOcrRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosakekkatorikomiocr.INinteiOcrMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果取込み（OCR）のサービスクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiOcrFindler {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiOcrFindler() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     * @param IkenshoImageJohoManager {@link dbt5305}
     * @param NinteichosahyoTokkijikoManager {@link dbt5205}
     */
    NinteiOcrFindler(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiOcrFindler}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiOcrFindler}のインスタンス
     */
    public static NinteiOcrFindler createInstance() {
        return InstanceProvider.create(NinteiOcrFindler.class);
    }

    /**
     * 関連データを取得します。
     *
     * @param paramter 検索用のパラメータ
     * @return 関連データ
     */
    public SearchResult<NinteiOcrResult> get関連データ(NinteiOcrMapperParamter paramter) {
        List<NinteiOcrResult> imageinputList = new ArrayList<>();
        INinteiOcrMapper mapper = mapperProvider.create(INinteiOcrMapper.class);
        List<NinteiChosaKekkaTorikomiOcrRelateEntity> entityList = mapper.get関連データ(paramter);
        for (NinteiChosaKekkaTorikomiOcrRelateEntity entity : entityList) {
            imageinputList.add(new NinteiOcrResult(entity));
        }
        return SearchResult.of(imageinputList, 0, false);
    }
}
