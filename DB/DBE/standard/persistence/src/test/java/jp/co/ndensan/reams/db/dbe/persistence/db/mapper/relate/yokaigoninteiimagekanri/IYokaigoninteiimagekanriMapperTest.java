/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagekanri;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteiimagekanri.ImagekanriJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@link IYokaigoninteiimagekanriMapper}のテストです。
 */
public class IYokaigoninteiimagekanriMapperTest extends DbeTestDacBase {

    public IYokaigoninteiimagekanriMapperTest() {
    }

    @BeforeClass
    public static void beforeClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    @Test
    public void testGetImageJoho() {
        IYokaigoninteiimagekanriMapper sut = this.sqlSession.getMapper(IYokaigoninteiimagekanriMapper.class);
        ImagekanriJohoEntity entity = sut.getImageJoho(new RString("20211920110100065"));
        if (entity == null) {
            System.out.println("null");
            return;
        }
        System.out.println(entity.getShisakaiWariateEntities().size());
    }
}
