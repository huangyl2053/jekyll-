/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbz.business.core.HokenshaShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4911ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenshaShujiiIryoKikanJoho}のテストクラスです。
 *
 * @author n8235 船山洋介
 */
@Ignore
@RunWith(Enclosed.class)
public class HokenshaShujiiIryoKikanJohoTest extends DbdTestBase {

    public static class getterSetterTest extends DbdTestBase {

        private static HokenshaShujiiIryoKikanJoho sut;

        @Before
        public void setUp() {
            sut = new HokenshaShujiiIryoKikanJoho(DbT4911ShujiiIryoKikanJohoEntityGenerator.createDbT4911ShujiiIryoKikanJohoEntity());
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
        public void 戻り値の医療機関コードは_設定した値と同じ医療機関コードを返す() {
            assertThat(sut.get医療機関コード().value(), is(new IryoKikanCode("1000000001").value()));
        }

        @Test
        public void 戻り値の医療機関名称は_設定した値と同じ医療機関名称を返す() {
            assertThat(sut.get医療機関名称(), is(new RString("医療機関名称")));
        }

        @Test
        public void 戻り値の医療機関名称カナは_設定した値と同じ医療機関名称カナを返す() {
            assertThat(sut.get医療機関名称カナ(), is(new RString("イリョウキカンメイショウカナ")));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(new YubinNo("1234567")));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            assertThat(sut.get住所(), is(new RString("住所")));
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
        public void 戻り値の代表者名は_設定した値と同じ代表者名を返す() {
            assertThat(sut.get代表者名(), is(new RString("代表者名")));
        }

        @Test
        public void 戻り値の代表者名カナは_設定した値と同じ代表者名カナを返す() {
            assertThat(sut.get代表者名カナ(), is(new RString("代表者名カナ")));
        }

        @Test
        public void 戻り値の状況フラグは_設定した値と同じ状況フラグを返す() {
            assertThat(sut.is状況フラグ(), is(true));
        }
    }

    public static class getStateTest extends DbdTestBase {

        @Test
        public void 状態Addedの取得確認() {
            HokenshaShujiiIryoKikanJoho sut = new HokenshaShujiiIryoKikanJoho();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            HokenshaShujiiIryoKikanJoho sut = new HokenshaShujiiIryoKikanJoho();
            sut.setEntity(DbT4911ShujiiIryoKikanJohoEntityGenerator.createDbT4911ShujiiIryoKikanJohoEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setIryoKikanMeisho(new RString("あいうえお"));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            HokenshaShujiiIryoKikanJoho sut = new HokenshaShujiiIryoKikanJoho();
            sut.setEntity(DbT4911ShujiiIryoKikanJohoEntityGenerator.createDbT4911ShujiiIryoKikanJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            HokenshaShujiiIryoKikanJoho sut = new HokenshaShujiiIryoKikanJoho();
            sut.setEntity(DbT4911ShujiiIryoKikanJohoEntityGenerator.createDbT4911ShujiiIryoKikanJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }

    public static class BuilderTest {

        @Test
        public void setShichosonCodeで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setShichosonCode(new LasdecCode("100001")).build();
            assertThat(result.get市町村コード(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void setShujiiIryokikanCodeで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setShujiiIryokikanCode(new ShujiiIryokikanCode("1000000001")).build();
            assertThat(result.get主治医医療機関コード(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード));
        }

        @Test
        public void setIryokikanCodeで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setIryokikanCode(new IryoKikanCode("1000000001")).build();
            assertThat(result.get医療機関コード().value(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関コード.value()));
        }

        @Test
        public void setIryoKikanMeishoで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setIryoKikanMeisho(new RString("医療機関名称")).build();
            assertThat(result.get医療機関名称(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関名称));
        }

        @Test
        public void setIryoKikanMeishoKanaで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().
                    setIryoKikanMeishoKana(new RString("イリョウキカンメイショウカナ")).build();
            assertThat(result.get医療機関名称カナ(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関名称カナ));
        }

        @Test
        public void setYubinNoで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setYubinNo(new YubinNo("1234567")).build();
            assertThat(result.get郵便番号(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void setJushoで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setJusho(new RString("住所")).build();
            assertThat(result.get住所(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void setTelNoで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setTelNo(new TelNo("99999999999")).build();
            assertThat(result.get電話番号(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void setFaxNoで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setFaxNo(new TelNo("99999999990")).build();
            assertThat(result.getFAX番号(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_FAX番号));

        }

        @Test
        public void setDaihyoshaNameで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setDaihyoshaName(new RString("代表者名")).build();
            assertThat(result.get代表者名(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_代表者名));
        }

        @Test
        public void setDaihyoshaNameKanaで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setDaihyoshaNameKana(new RString("代表者名カナ")).build();
            assertThat(result.get代表者名カナ(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_代表者名カナ));
        }

        @Test
        public void setJokyoFlagで設定した値を_生成されたShujiiIryoKikanJohoJukyuも保持する() {
            HokenshaShujiiIryoKikanJoho result = HokenshaShujiiIryoKikanJoho.newBuilder().setJokyoFlag(true).build();
            assertThat(result.is状況フラグ(), is(DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_状況フラグ));
        }
    }

    public static class SerializationProxyTest {

        private HokenshaShujiiIryoKikanJoho sut;

        @Before
        public void setUp() {
            sut = HokenshaShujiiIryoKikanJoho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            String b64 = _Base64Serializer.serialize(sut.serialize());
            HokenshaShujiiIryoKikanJoho desirialized = _Base64Serializer.deSerialize(b64, HokenshaShujiiIryoKikanJoho.class);
            assertThat(desirialized.get主治医医療機関コード(), is(sut.get主治医医療機関コード()));
        }
    }
}
