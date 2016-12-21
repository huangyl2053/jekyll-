/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinbetsutanka;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinbetsutankasearchresult.ShinsakaiIinBetsuTankaRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * IShinsakaiIinBetsuTankaRelateMapperTest
 *
 * @author N2826
 */
@Ignore
public class IShinsakaiIinBetsuTankaRelateMapperTest extends DbeTestDacBase {

    private static IShinsakaiIinBetsuTankaRelateMapper sut;

    @Before
    public void setUp() {
        sut = sqlSession.getMapper(IShinsakaiIinBetsuTankaRelateMapper.class);
    }

    @Test
    public void 介護認定審査会委員別単価全件() {
        List<ShinsakaiIinBetsuTankaRelateEntity> result = sut.select介護認定審査会委員別単価全件();
        assertTrue(true);
    }

}
