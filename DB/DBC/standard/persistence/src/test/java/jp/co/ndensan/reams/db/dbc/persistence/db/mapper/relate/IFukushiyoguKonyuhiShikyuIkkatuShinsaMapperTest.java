/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shokanfukushiyoguhanbaihi.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfukushiyoguhanbaihi.ShokanFukushiYoguHanbaihiParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanfukushiyoguhanbaihi.IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Qi
 */
public class IFukushiyoguKonyuhiShikyuIkkatuShinsaMapperTest extends DbcTestDacBase {

    private IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper mapper;

    @Before
    public void setUp() {
        sqlSession.getConfiguration().addMapper(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);
        mapper = sqlSession.getMapper(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);
    }

    @Test
    public void select未審査申請_データなし() {
        Map<String, Object> 未審査申請取得検索条件 = new HashMap<>();
        FlexibleDate 支給申請日From = new FlexibleDate("20150201");
        FlexibleDate 支給申請日To = new FlexibleDate("20160830");
        未審査申請取得検索条件.put("支給申請日From", 支給申請日From);
        未審査申請取得検索条件.put("支給申請日To", 支給申請日To);
        List<ShokanShinseiEntity> shokanShinseiEntity = mapper.select未審査申請(ShokanFukushiYoguHanbaihiParameter.
                createSelectByKeyParam(支給申請日From, 支給申請日To));
    }
}
