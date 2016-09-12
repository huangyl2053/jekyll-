/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagekanri;

import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagekanri.IYokaigoninteiimagekanriMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * イメージ管理情報を取得するクラスです。
 *
 * @reamsid_L DBE-1670-010 wangxiaodong
 */
public class YokaigoninteiimagekanriFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    YokaigoninteiimagekanriFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    YokaigoninteiimagekanriFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoninteiimagekanriFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YokaigoninteiimagekanriFinder}のインスタンス
     */
    public static YokaigoninteiimagekanriFinder createInstance() {
        return InstanceProvider.create(YokaigoninteiimagekanriFinder.class);
    }

    /**
     * イメージ管理情報を取得します。
     *
     * @param shinseishoKanriNo RString
     * @return イメージ管理情報
     */
    @Transaction
    public ImagekanriJoho getImageJoho(RString shinseishoKanriNo) {
        IYokaigoninteiimagekanriMapper mapper = mapperProvider.create(IYokaigoninteiimagekanriMapper.class);
        return new ImagekanriJoho(mapper.getImageJoho(shinseishoKanriNo));
    }
}
