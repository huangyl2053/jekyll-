/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CenterTransmissionRecords.CenterTransmissionRecordsBuilder;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget.CreateTargetCsvRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link CenterTransmissionRecords}のテストです。
 */
@RunWith(Enclosed.class)
public class CenterTransmissionRecordsTest {

    public CenterTransmissionRecordsTest() {
    }

    public static class Edaban {

        RString 申請書管理番号1 = new RString("000000000000001");
        RString 申請書管理番号2 = new RString("000000000000002");
        RString 保険者番号 = new RString("123456");
        RString 被保険者番号 = new RString("0000000001");
        RString 認定申請日 = new RString("20010101");
        List<ApplicationsResultMain> list = new ArrayList<>();

        @Test
        public void 最初の1件の枝番は_0() {
            list.add(create(申請書管理番号1, 保険者番号, 被保険者番号, 認定申請日));
            CenterTransmissionRecords sut = new CenterTransmissionRecordsBuilder()
                    .setMain(list)
                    .build();
            assertThat(sut.get(申請書管理番号1).get枝番(), is(0));
        }

        @Test
        public void _2件目の枝番は_1() {
            list.add(create(申請書管理番号1, 保険者番号, 被保険者番号, 認定申請日));
            list.add(create(申請書管理番号2, 保険者番号, 被保険者番号, 認定申請日));
            CenterTransmissionRecords sut = new CenterTransmissionRecordsBuilder()
                    .setMain(list)
                    .build();
            assertThat(sut.get(申請書管理番号1).get枝番(), is(0));
            assertThat(sut.get(申請書管理番号2).get枝番(), is(1));
        }
    }

    private static ApplicationsResultMain create(RString 申請書管理番号, RString 保険者番号, RString 被保険者番号, RString 認定申請日) {
        CreateTargetCsvRelateEntity entity = new CreateTargetCsvRelateEntity();
        entity.set申請書管理番号(申請書管理番号);
        entity.set保険者番号(保険者番号);
        entity.set被保険者番号(被保険者番号);
        entity.set認定申請日(認定申請日);
        return ApplicationsResultMain.creatCreateTargetCsvBusiness(entity);
    }

}
