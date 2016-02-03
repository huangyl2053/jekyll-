/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfukushiyoguhanbaihi.ShokanFukushiYoguHanbaihiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfukushiyoguhanbaihi.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanfukushiyoguhanbaihi.IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
        RDate 支給申請日From = new RDate("20150201");
        RDate 支給申請日To = new RDate("20160830");
        List<ShokanShinseiEntity> shokanShinseiEntity = mapper.select未審査申請(ShokanFukushiYoguHanbaihiParameter.
                createSelectByKeyParam(支給申請日From, 支給申請日To));
    }
}
