/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiIkenTokusokujoMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link IDbe233001RelateMapper}のテストクラスです。
 */
public class IDbe233001RelateMapperTest extends DbeTestDacBase {

    private static IDbe233001RelateMapper sut;

    @Before
    public void setUp() {
        sut = sqlSession.getMapper(IDbe233001RelateMapper.class);
    }

    @Test
    public void このような条件の時_このメソッドは_このような結果を返す() {
        ShujiiIkenTokusokujoMybitisParamter param
                = ShujiiIkenTokusokujoMybitisParamter.createParam(
                        FlexibleDate.getNowDate(), RString.EMPTY, null, null, null, false, false, false, false, null);
        List<ShujiiIkenTokusokujoRelateEntity> result = sut.select主治医意見書督促状ByKey(param);
        assertTrue(true);
    }
}
