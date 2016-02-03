/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.ShokanShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * 福祉用具購入費支給申請一括審査・決定のTest
 *
 * @author chenaoqi
 */
public class FukushiyoguKonyuhiShikyuIkkatuShinsaTest extends DbcTestBase {

    private FukushiyoguKonyuhiShikyuIkkatuShinsa sut;
    private FlexibleDate 決定日;
    private List<ShokanShinseiEntity> 支給申請一括審査List;

    @Before
    public void setUp() {

        sut = mock(FukushiyoguKonyuhiShikyuIkkatuShinsa.class);

    }

    @Test
    public void getMiShinsaShinseiListTest() {
        List<ShokanShinseiEntity> miShinsaShinseiList = sut.getMiShinsaShinseiList(new RDate("20150101"), new RDate("20160101"));
    }

    @Test
    public void updShikyuShinseiTest() {
        ShokanShinseiEntity entity = ShokanShinseiEntityGenerator.createShokanShinseiEntity();
        支給申請一括審査List = new ArrayList<>();
        支給申請一括審査List.add(entity);
        決定日 = ShokanShinseiEntityGenerator.DEFAULT_決定日;
        sut.updShikyuShinsei(決定日, 支給申請一括審査List);
    }

}
