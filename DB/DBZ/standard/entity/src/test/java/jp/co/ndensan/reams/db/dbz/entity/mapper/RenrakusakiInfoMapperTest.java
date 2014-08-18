/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.KaigoRenrakusaki;
import jp.co.ndensan.reams.db.dbz.business.helper.KaigoRenrakusakiMock;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.RenrakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 連絡先情報マッパークラスのテストクラスです。
 *
 * @author n9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class RenrakusakiInfoMapperTest extends DbzTestBase {

    public static class to連絡先情報 extends DbzTestBase {

        private final DbT5050RenrakusakiJohoEntity entity
                = RenrakusakiJohoEntityMock.create連絡先情報Entity();
        private KaigoRenrakusaki sut;

        @Before
        public void setUp() {
            sut = RenrakusakiInfoMapper.toRenrakusakiInfo(
                    entity);
        }

        @Test
        public void 連絡先情報entityに_nullを設定した時_nullを返す() {
            sut = RenrakusakiInfoMapper.toRenrakusakiInfo(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void get氏名が_Entityの氏名と同一になる() {
            assertThat(sut.get氏名(), is(entity.getRenrakusakiShimei()));
        }

        @Test
        public void get氏名カナが_Entityの氏名カナと同一になる() {
            assertThat(sut.get氏名カナ(), is(entity.getRenrakusakiKanaSimei()));
        }

        @Test
        public void get続柄が_Entityの続柄と同一になる() {
            assertThat(sut.get続柄(), is(entity.getRenrakusakiTuzukigara()));
        }

        @Test
        public void get郵便番号が_Entityの郵便番号と同一になる() {
            assertThat(sut.get郵便番号(), is(entity.getRenrakusakiYubinNo()));
        }

        @Test
        public void get住所が_Entityの住所と同一になる() {
            assertThat(sut.get住所(), is(entity.getRenrakusakiJusho()));
        }

        @Test
        public void get電話番号が_Entityの電話番号と同一になる() {
            assertThat(sut.get電話番号(), is(entity.getRenrakusakiTelNo()));
        }

        @Test
        public void get携帯番号が_Entityの携帯番号と同一になる() {
            assertThat(sut.get携帯番号(), is(entity.getRenrakusakiKeitaiTelNo()));
        }

        @Test
        public void get保険者番号が_Entityの保険者番号と同一になる() {
            assertThat(sut.get保険者番号(), is(entity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号が_Entityの被保険者番号と同一になる() {
            assertThat(sut.get被保険者番号(), is(entity.getHihokenshaNo()));
        }

        @Test
        public void get連絡先区分番号が_Entityの連絡先区分番号と同一になる() {
            assertThat(sut.get連絡先区分番号().value(), is(entity.getRenrakusakiKubunNo()));
        }

        @Test
        public void get支所コードが_Entityの支所コードと同一になる() {
            assertThat(sut.get支所コード(), is(entity.getShishoCode()));
        }
    }

    public static class to連絡先情報Entity extends DbzTestBase {

        private DbT5050RenrakusakiJohoEntity sut;
        private final KaigoRenrakusaki 介護連絡先 = KaigoRenrakusakiMock.create介護連絡先();

        @Before
        public void setUp() {
            sut = RenrakusakiInfoMapper.toRenrakusakiJohoEntity(介護連絡先);
        }

        @Test
        public void 引数にnullが渡された時_nullを返す() {
            sut = RenrakusakiInfoMapper.toRenrakusakiJohoEntity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void Entityの氏名と_介護連絡先の氏名が同一になる() {
            assertThat(sut.getRenrakusakiShimei(), is(介護連絡先.get氏名()));
        }

        @Test
        public void Entityの氏名カナと_介護連絡先の氏名カナが同一になる() {
            assertThat(sut.getRenrakusakiKanaSimei(), is(介護連絡先.get氏名カナ()));
        }

        @Test
        public void Entityの続柄と_介護連絡先の続柄が同一になる() {
            assertThat(sut.getRenrakusakiTuzukigara(), is(介護連絡先.get続柄()));
        }

        @Test
        public void Entityの郵便番号と_介護連絡先の郵便番号が同一になる() {
            assertThat(sut.getRenrakusakiYubinNo(), is(介護連絡先.get郵便番号()));
        }

        @Test
        public void Entityの住所と_介護連絡先の住所が同一になる() {
            assertThat(sut.getRenrakusakiJusho(), is(介護連絡先.get住所()));
        }

        @Test
        public void Entityの電話番号と_介護連絡先の電話番号が同一になる() {
            assertThat(sut.getRenrakusakiTelNo(), is(介護連絡先.get電話番号()));
        }

        @Test
        public void Entityの携帯番号と_介護連絡先の携帯番号が同一になる() {
            assertThat(sut.getRenrakusakiKeitaiTelNo(), is(介護連絡先.get携帯番号()));
        }

        @Test
        public void Entityの保険者番号と_介護連絡先の保険者番号が同一になる() {
            assertThat(sut.getShoKisaiHokenshaNo(), is(介護連絡先.get保険者番号()));
        }

        @Test
        public void Entityの被保険者番号と_介護連絡先の被保険者番号が同一になる() {
            assertThat(sut.getHihokenshaNo(), is(介護連絡先.get被保険者番号()));
        }

        @Test
        public void Entityの連絡先区分番号と_介護連絡先の連絡先区分番号が同一になる() {
            assertThat(sut.getRenrakusakiKubunNo(), is(介護連絡先.get連絡先区分番号().value()));
        }

        @Test
        public void Entityの支所コードと_介護連絡先の支所コードが同一になる() {
            assertThat(sut.getShishoCode(), is(介護連絡先.get支所コード()));
        }
    }
}
