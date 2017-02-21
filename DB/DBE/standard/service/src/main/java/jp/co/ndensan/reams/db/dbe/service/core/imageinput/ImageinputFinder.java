/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.imageinput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageInputSontaRelate;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputRelate;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageInputSontaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageinputRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput.IImageinputMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * イメージ取込み（規定・規定外）のサービスクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class ImageinputFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ImageinputFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     * @param IkenshoImageJohoManager {@link dbt5305}
     * @param NinteichosahyoTokkijikoManager {@link dbt5205}
     */
    ImageinputFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ImageinputFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ImageinputFinder}のインスタンス
     */
    public static ImageinputFinder createInstance() {
        return InstanceProvider.create(ImageinputFinder.class);
    }

    /**
     * 関連データを取得します。
     *
     * @param paramter 検索用のパラメータ
     * @return 関連データ
     */
    public List<ImageinputRelate> get意見書関連データ(ImageinputMapperParamter paramter) {
        List<ImageinputRelate> imageinputList = new ArrayList<>();
        IImageinputMapper mapper = mapperProvider.create(IImageinputMapper.class);
        List<ImageinputRelateEntity> entityList = mapper.get意見書関連データ(paramter);
        for (ImageinputRelateEntity entity : entityList) {
            initMd5(entity.get主治医意見書情報());
            imageinputList.add(new ImageinputRelate(entity));
        }
        return imageinputList;
    }

    /**
     * その他資料の関連データを取得します。
     *
     * @param parameter 検索用のパラメータ
     * @return 関連データ
     */
    public List<ImageInputSontaRelate> getその他資料関連データ(ImageinputMapperParamter parameter) {
        List<ImageInputSontaRelate> list = new ArrayList<>();
        IImageinputMapper mapper = mapperProvider.create(IImageinputMapper.class);
        for (ImageInputSontaRelateEntity entity : mapper.getその他資料関連データ(parameter)) {
            list.add(new ImageInputSontaRelate(entity));
        }
        return list;
    }

    private static void initMd5(List<? extends DbTableEntityBase<?>> entities) {
        for (DbTableEntityBase<?> entity : entities) {
            entity.initializeMd5();
        }
    }
}
