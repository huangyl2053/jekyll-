/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.KaigoRenrakusaki;
import jp.co.ndensan.reams.db.dbz.persistence.basic.RenrakusakiInfoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.RenrakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * RenrakusakiInfoFinderのテストです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class RenrakusakiInfoFinderTest extends DbzTestBase {

    private static RenrakusakiInfoFinder sut;
    private static final int 情報なし_0件 = 0;
    private static final int 情報あり_1件 = 1;
    private static final int 情報あり_2件 = 2;

    public static class get連絡先情報リスト {

        private static final ShoKisaiHokenshaNo 保険者番号
                = new ShoKisaiHokenshaNo(new RString("123456"));
        private static final KaigoHihokenshaNo 被保険者番号
                = new KaigoHihokenshaNo(new RString("1111111111"));
        private static final ShoKisaiHokenshaNo notFound保険者番号
                = new ShoKisaiHokenshaNo(new RString("987654"));

        @Test
        public void 該当の連絡先情報がない時_get連絡先情報リストは_空のリストを返す() {

            sut = new RenrakusakiInfoFinder(createDacMock(情報なし_0件));
            List<KaigoRenrakusaki> result = sut.getRenrakusakiList(notFound保険者番号, 被保険者番号);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 該当の連絡先情報が１件存在する時_get連絡先情報リストは_１件のデータを返す() {

            sut = new RenrakusakiInfoFinder(createDacMock(情報あり_1件));
            List<KaigoRenrakusaki> result = sut.getRenrakusakiList(保険者番号, 被保険者番号);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 該当の連絡先情報が２件存在する時_get連絡先情報リストは_２件のデータを返す() {

            sut = new RenrakusakiInfoFinder(createDacMock(情報あり_2件));
            List<KaigoRenrakusaki> result = sut.getRenrakusakiList(保険者番号, 被保険者番号);
            assertThat(result.size(), is(2));
        }

        private RenrakusakiInfoDac createDacMock(int kensu) {
            RenrakusakiInfoDac 連絡先情報dac = mock(RenrakusakiInfoDac.class);
            List<DbT5050RenrakusakiJohoEntity> entityList = new ArrayList<>();
            DbT5050RenrakusakiJohoEntity entity = RenrakusakiJohoEntityMock.create連絡先情報Entity();
            entityList.add(entity);
            if (kensu == 情報あり_2件) {
                entity.setRenrakusakiKubunNo(new RString("00000002"));
                entityList.add(entity);
            }

            when(連絡先情報dac.select(保険者番号, 被保険者番号)).thenReturn(entityList);
            //when(連絡先情報dac.select(any(ShoKisaiHokenshaNo.class), any(KaigoHihokenshaNo.class))).thenReturn(entityList);
            return 連絡先情報dac;

        }
    }
}
