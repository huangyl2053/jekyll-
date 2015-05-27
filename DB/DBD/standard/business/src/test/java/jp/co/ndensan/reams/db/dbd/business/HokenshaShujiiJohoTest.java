/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiCode;
import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4912ShujiiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenshaShujiiJoho}のテストクラスです。
 *
 * @author n8235 船山洋介
 */
@RunWith(Enclosed.class)
public class HokenshaShujiiJohoTest extends DbdTestBase {

    public static class getterSetterTest extends DbdTestBase {

        private static HokenshaShujiiJoho sut;

        @BeforeClass
        public static void test() {
            sut = new HokenshaShujiiJoho(DbT4912ShujiiJohoEntityGenerator.createDbT4912ShujiiJohoEntity());
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(new LasdecCode("100001")));
        }

        @Test
        public void 戻り値の主治医医療機関コードは_設定した値と同じ主治医医療機関コードを返す() {
            assertThat(sut.get主治医医療機関コード(), is(new ShujiiIryokikanCode("1000000001")));
        }

        @Test
        public void 戻り値の主治医コードは_設定した値と同じ主治医コードを返す() {
            assertThat(sut.get主治医コード(), is(new ShujiiCode("10000001")));
        }

        @Test
        public void 戻り値の主治医氏名は_設定した値と同じ主治医氏名を返す() {
            assertThat(sut.get主治医氏名(), is(new AtenaMeisho("主治医氏名")));
        }

        @Test
        public void 戻り値の主治医カナは_設定した値と同じ主治医カナを返す() {
            assertThat(sut.get主治医カナ(), is(new AtenaKanaMeisho("シュジイカナ")));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(new YubinNo("1234567")));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            assertThat(sut.get住所(), is(new AtenaJusho("住所")));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            assertThat(sut.get電話番号(), is(new TelNo("99999999999")));
        }

        @Test
        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(new TelNo("99999999990")));
        }

        @Test
        public void 戻り値の診療科名称は_設定した値と同じ診療科名称を返す() {
            assertThat(sut.get診療科名称(), is(new RString("診療科名称")));
        }

        @Test
        public void 戻り値の指定医フラグは_設定した値と同じ指定医フラグを返す() {
            assertThat(sut.is指定医フラグ(), is(true));
        }

        @Test
        public void 戻り値の状況フラグは_設定した値と同じ状況フラグを返す() {
            assertThat(sut.is状況フラグ(), is(true));
        }
    }

    public static class getStateTest extends DbdTestBase {

        @Test
        public void 状態Addedの取得確認() {
            HokenshaShujiiJoho sut = new HokenshaShujiiJoho();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            HokenshaShujiiJoho sut = new HokenshaShujiiJoho();
            sut.setEntity(DbT4912ShujiiJohoEntityGenerator.createDbT4912ShujiiJohoEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setShinryokaName(new RString("あいうえお"));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            HokenshaShujiiJoho sut = new HokenshaShujiiJoho();
            sut.setEntity(DbT4912ShujiiJohoEntityGenerator.createDbT4912ShujiiJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            HokenshaShujiiJoho sut = new HokenshaShujiiJoho();
            sut.setEntity(DbT4912ShujiiJohoEntityGenerator.createDbT4912ShujiiJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }

    public static class BuilderTest {

        @Test
        public void setShichosonCodeで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setShichosonCode(new LasdecCode("100001")).build();
            assertThat(result.get市町村コード(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void setShujiiIryokikanCodeで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setShujiiIryokikanCode(new ShujiiIryokikanCode("1000000001")).build();
            assertThat(result.get主治医医療機関コード().value(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_主治医医療機関コード.value()));
        }

        @Test
        public void setShujiiCodeで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setShujiiCode(new ShujiiCode("10000001")).build();
            assertThat(result.get主治医コード().value(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_主治医コード.value()));
        }

        @Test
        public void setShujiiNameで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setShujiiName(new AtenaMeisho("主治医氏名")).build();
            assertThat(result.get主治医氏名(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_主治医氏名));
        }

        @Test
        public void setShujiiKanaで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setShujiiKana(new AtenaKanaMeisho("シュジイカナ")).build();
            assertThat(result.get主治医カナ(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_主治医カナ));
        }

        @Test
        public void setYubinNoで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setYubinNo(new YubinNo("1234567")).build();
            assertThat(result.get郵便番号(), is(new YubinNo("1234567")));
        }

        @Test
        public void setJushoで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setJusho(new AtenaJusho("住所")).build();
            assertThat(result.get住所(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void setTelNoで設定した値を_生成されたShujiiIryoKikanJohoNinteiも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setTelNo(new TelNo("99999999999")).build();
            assertThat(result.get電話番号(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void setFaxNoで設定した値を_生成されたShujiiIryoKikanJohoNinteiも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setFaxNo(new TelNo("99999999990")).build();
            assertThat(result.getFAX番号(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void setShinryokaNameで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setShinryokaName(new RString("診療科名称")).build();
            assertThat(result.get診療科名称(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_診療科名称));
        }

        @Test
        public void setShiteiiFlagで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setShiteiiFlag(true).build();
            assertThat(result.is指定医フラグ(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_指定医フラグ));
        }

        @Test
        public void setJokyoFlagで設定した値を_生成されたShujiiJohoJukyuも保持する() {
            HokenshaShujiiJoho result = HokenshaShujiiJoho.newBuilder().setJokyoFlag(true).build();
            assertThat(result.is状況フラグ(), is(DbT4912ShujiiJohoEntityGenerator.DEFAULT_指定医フラグ));
        }
    }

    public static class SerializationProxyTest {

        private HokenshaShujiiJoho sut;

        @Before
        public void setUp() {
            sut = HokenshaShujiiJoho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            String b64 = _Base64Serializer.serialize(sut.serialize());
            HokenshaShujiiJoho desirialized = _Base64Serializer.deSerialize(b64, HokenshaShujiiJoho.class);
            assertThat(desirialized.get主治医医療機関コード(), is(sut.get主治医医療機関コード()));
        }
    }
}
