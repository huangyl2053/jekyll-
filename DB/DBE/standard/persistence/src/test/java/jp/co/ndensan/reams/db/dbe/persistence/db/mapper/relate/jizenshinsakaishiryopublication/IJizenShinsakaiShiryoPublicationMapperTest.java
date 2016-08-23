/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.jizenshinsakaishiryopublication;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.jizenshinsakaishiryopublication.JizenShinsakaiShiryoPublicationMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaSelectEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikensho.shujiiikenshojoho.IShujiiIkenshoJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IShujiiIkenshoJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IJizenShinsakaiShiryoPublicationMapperTest extends DbeTestDacBase {

    private static MapperProvider mapperProvider;

    public static class select介護認定審査会開催番号Test extends DbeTestDacBase {

        @Before
        public void mapperDate() {
            mapperProvider = InstanceProvider.create(MapperProvider.class);
        }

        @Test
        public void test_1() {
            IJizenShinsakaiShiryoPublicationMapper mapper = mapperProvider.create(IJizenShinsakaiShiryoPublicationMapper.class);

            JizenShinsakaiShiryoPublicationMybitisParamter param = JizenShinsakaiShiryoPublicationMybitisParamter
                    .createParamter(new RString("10"));
            JizenShinsaKekkaSelectEntity entity = mapper.select介護認定審査会開催番号(param);
            if (entity != null) {
                System.out.println(entity.get介護認定審査会開催予定年月日());
            }
        }
    }

}
