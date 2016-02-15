/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyushisei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShokanFukushiYoguHanbaihiParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author chenaoqi
 */
public class IFukushiyoguKonyuhiShikyuIkkatuShinsaMapperTest extends DbcTestDacBase {

    private IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper mapper;

    @Before
    public void setUp() {
//        sqlSession.getConfiguration().addMapper(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);
        mapper = sqlSession.getMapper(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);
    }

    @Test
    public void select未審査申請_データなし() {

        FlexibleDate 支給申請日From = null;
        FlexibleDate 支給申請日To = null;
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey key = builder.build();
        ShokanFukushiYoguHanbaihiParameter parameter = new ShokanFukushiYoguHanbaihiParameter(key, 支給申請日From, 支給申請日To);

        List<ShokanShinseiEntity> lstShokanShinseiEntity = mapper.select未審査申請(parameter);
        if (lstShokanShinseiEntity == null) {
            System.out.println("lstShokanShinseiEntity is null ");
        } else {
            System.out.println("lstShokanShinseiEntity size " + lstShokanShinseiEntity.size());
        }
    }
}
