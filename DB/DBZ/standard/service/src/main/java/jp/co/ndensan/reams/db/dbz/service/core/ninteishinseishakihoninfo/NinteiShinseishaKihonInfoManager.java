/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteishinseishakihoninfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.param.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shisetsunyushoinfo.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteishinseishakihoninfo.INinteiShinseishaKihonInfoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定申請者基本情報取得です。
 *
 */
public class NinteiShinseishaKihonInfoManager {

    private final MapperProvider mapperProvider;

    NinteiShinseishaKihonInfoManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    NinteiShinseishaKihonInfoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseishaKihonInfoManager}のインスタンスを返します。
     *
     * @return NinteiShinseishaKihonInfoManager
     *
     */
    public static NinteiShinseishaKihonInfoManager createInstance() {
        return InstanceProvider.create(NinteiShinseishaKihonInfoManager.class);

    }

    /**
     * 施設入所情報取得(識別コード)
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 施設入所情報RelateEntity
     */
    public NinteiShinseishaKihonInfoRelateEntity onLoad(ShinseishoKanriNo 申請書管理番号) {
        INinteiShinseishaKihonInfoMapper mapper = mapperProvider.create(INinteiShinseishaKihonInfoMapper.class);
        return mapper.getSelect(NinteiShinseishaKihonInfoParameter.createParam(申請書管理番号));
    }
}
