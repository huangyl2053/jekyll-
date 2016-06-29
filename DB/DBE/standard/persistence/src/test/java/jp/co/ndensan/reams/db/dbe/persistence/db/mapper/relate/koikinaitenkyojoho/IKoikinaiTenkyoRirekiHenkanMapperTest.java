/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.koikinaitenkyojoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkanMapperParameter;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ITashichosonJushochiTokureiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IKoikinaiTenkyoRirekiHenkanMapperTest extends DbaTestDacBase {

    public static class test_1 extends DbaTestDacBase {

        @BeforeClass
        public static void test() {

        }

        @Test
        public void testSpool() {
            List<RString> list = new ArrayList<>();
            KoikinaiTenkyoRirekiHenkanMapperParameter para = KoikinaiTenkyoRirekiHenkanMapperParameter.createSelectByKeyParam(new RString("0789456123"),
                    new AtenaMeisho("氏名_zt1"),
                    new FlexibleDate("20160102"),
                    new FlexibleDate("20160102"),
                    new FlexibleDate("20160113"),
                    new FlexibleDate("20160113"),
                    new Code("4"),
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    list,
                    new Decimal(2));
            MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
            IKoikinaiTenkyoRirekiHenkanMapper mapper = mapperProvider.create(IKoikinaiTenkyoRirekiHenkanMapper.class);
            System.out.println(mapper.selectKoikinaiTenkyoListUpdate(para).size());

        }

    }

}
