/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.relate.JogaiShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiIinJogaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.helper.ShinsakaiIinDacMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JogaiShinsakaiIinDacTest {

    private static JogaiShinsakaiIinDac sut;
    private static ShinsakaiIinDacMock shinsakaiIinDacMock;
    private static ShinsakaiIinJogaiJohoDac shinsakaiIinJogaiJohoDac;

    private static ShoKisaiHokenshaNo 証記載保険者番号_123456;
    private static KaigoHihokenshaNo 被保険者番号_0123456789;
    private static ShoKisaiHokenshaNo 証記載保険者番号_654321;
    private static KaigoHihokenshaNo 被保険者番号_9876543210;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(JogaiShinsakaiIinDac.class);
        shinsakaiIinDacMock = InstanceProvider.create(ShinsakaiIinDacMock.class);
        shinsakaiIinJogaiJohoDac = InstanceProvider.create(ShinsakaiIinJogaiJohoDac.class);

        証記載保険者番号_123456 = new ShoKisaiHokenshaNo(new RString("123456"));
        被保険者番号_0123456789 = new KaigoHihokenshaNo(new RString("0123456789"));
        証記載保険者番号_654321 = new ShoKisaiHokenshaNo(new RString("654321"));
        被保険者番号_9876543210 = new KaigoHihokenshaNo(new RString("9876543210"));
    }

    public static class selectのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            createSelectData(証記載保険者番号_123456, 被保険者番号_0123456789, "00000001", "00000002", "00000003");
            createSelectData(証記載保険者番号_654321, 被保険者番号_9876543210, "00000004", "00000005");
        }

        @Test
        public void 証記載保険者番号に123456_被保険者番号に0123456789を渡すと_3件の情報が取得できる() {
            assertThat(sut.select(証記載保険者番号_123456, 被保険者番号_0123456789).size(), is(3));
        }

        @Test
        public void 証記載保険者番号に654321_被保険者番号に9876543210を渡すと_2件の情報が取得できる() {
            assertThat(sut.select(証記載保険者番号_654321, 被保険者番号_9876543210).size(), is(2));
        }

        @Test
        public void 証記載保険者番号に654321_被保険者番号に0123456789を渡すと_空のリストが返される() {
            assertThat(sut.select(証記載保険者番号_654321, 被保険者番号_0123456789).size(), is(0));
        }

        private List<JogaiShinsakaiIinEntity> createSelectData(ShoKisaiHokenshaNo 証記載保険者番号,
                KaigoHihokenshaNo 被保険者番号, String... 審査会委員コードs) {
            List<JogaiShinsakaiIinEntity> list = new ArrayList<>();

            int i = 0;
            for (String 審査会委員コード : 審査会委員コードs) {
                shinsakaiIinDacMock.insert(
                        ShinsakaiMockEntityCreator.create審査会委員Entity(審査会委員コード));
                shinsakaiIinJogaiJohoDac.insert(ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(
                        証記載保険者番号, 被保険者番号, i, new ShinsakaiIinCode(new RString(審査会委員コード))));
                i++;
            }
            return list;
        }
    }

}
