/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.imageinput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageinputRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput.IImageinputMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * イメージ取込み（規定・規定外）のサービスクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class ImageinputFindler {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ImageinputFindler() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     * @param IkenshoImageJohoManager {@link dbt5305}
     * @param NinteichosahyoTokkijikoManager {@link dbt5205}
     */
    ImageinputFindler(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ImageinputFindler}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ImageinputFindler}のインスタンス
     */
    public static ImageinputFindler createInstance() {
        return InstanceProvider.create(ImageinputFindler.class);
    }

    /**
     * 当該被保険者の申請データが存在するかどうかチェックを実行します。
     *
     * @param paramter 検索用のパラメータ
     * @return 当該被保険者の申請データが存在するかどうかチェック結果
     */
    public boolean get当該被保険者の申請データが存在するかどうかチェック(ImageinputMapperParamter paramter) {
        boolean flag = true;
        IImageinputMapper mapper = mapperProvider.create(IImageinputMapper.class);
        List<RString> dataList = mapper.get申請データ(paramter);
        if (dataList.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    /**
     * 関連データを取得します。
     *
     * @param paramter 検索用のパラメータ
     * @return 関連データ
     */
    public SearchResult<ImageinputResult> get関連データ(ImageinputMapperParamter paramter) {
        List<ImageinputResult> imageinputList = new ArrayList<>();
        IImageinputMapper mapper = mapperProvider.create(IImageinputMapper.class);
        List<ImageinputRelateEntity> entityList = mapper.get関連データ(paramter);
        for (ImageinputRelateEntity entity : entityList) {
            imageinputList.add(new ImageinputResult(entity));
        }
        return SearchResult.of(imageinputList, 0, false);
    }
}
