/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteishinseishakihoninfo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.param.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteishinseishakihoninfo.INinteiShinseishaKihonInfoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
     * 認定申請者基本情報Divの初期化時intializeメッソドの検索処理します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請者基本情報のBusinessクラスです
     */
    public NinteiShinseishaKihonInfoBusiness initialize(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        INinteiShinseishaKihonInfoMapper mapper = mapperProvider.create(INinteiShinseishaKihonInfoMapper.class);

        return new NinteiShinseishaKihonInfoBusiness(mapper.getSelect(NinteiShinseishaKihonInfoParameter.createParam(申請書管理番号)));

    }
}
