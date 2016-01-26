/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanfukushiyoguhanbaihi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanfukushiyoguhanbaihi.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * 福祉用具購入費支給申請一括審査・決定のTest
 *
 * @author chenaoqi
 */
public class FukushiyoguKonyuhiShikyuIkkatuShinsaManagerTest extends DbcTestBase {

    private FukushiyoguKonyuhiShikyuIkkatuShinsaManager sut;

    @Before
    public void setUp() {

        sut = mock(FukushiyoguKonyuhiShikyuIkkatuShinsaManager.class);
    }

    @Test
    public void getMiShinsaShinseiListTest() {
        List<ShokanShinseiEntity> miShinsaShinseiList = sut.getMiShinsaShinseiList(new FlexibleDate("20150101"), new FlexibleDate("20160101"));
    }
}
