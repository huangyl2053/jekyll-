/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJoho.*;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShuJiiIryoKikanDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiIryoKikanDacMock;
import jp.co.ndensan.reams.db.dbe.persistence.testhelper.KaigoIryoKikanTestHelper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.definition.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IIryoKikanDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護医療機関DACのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoIryoKikanDacTest extends TestDacBase {
    //TODO n8178 城間篤人
    //IryoKikanEntityに対応するテーブルが存在しないためテスト不可。
    //テーブルができた時点で改めて対応予定 2014年2月末
//
//    private static IKaigoIryoKikanDac sut;
//    private static IIryoKikanDac iryoKikanInserter;
//    private static IShuJiiIryoKikanDac shujiiIryoKikanInserter;
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceCreator.create(IKaigoIryoKikanDac.class);
//        iryoKikanInserter = InstanceCreator.create(IIryoKikanDac.class);
//        shujiiIryoKikanInserter = InstanceCreator.create(IShuJiiIryoKikanDac.class);
//    }
//
//    public static class select_UI画面から検索条件を渡した場合のテスト extends TestDacBase {
//
//        private ShichosonCode 市町村コード;
//        private KaigoIryoKikanCode 介護医療区分コード;
//
//        static {
//            setGyomuCD("UZ");
//        }
//
//        @Override
//        public void setUp() {
//            iryoKikanInserter.insert(KaigoIryoKikanTestHelper.create医療機関Entity());
//            市町村コード = new ShichosonCode(new RString("A001"));
//            介護医療区分コード = new KaigoIryoKikanCode(new RString("B001"));
//            shujiiIryoKikanInserter.insert(create主治医医療機関情報Entity(市町村コード, 介護医療区分コード, new RString("001")));
//        }
//
//        @Test
//        public void 引数に作成した業務条件を渡し_指定した情報に対応したEntityが取得できる() {
//            ITrueFalseCriteria criteria = and(eq(shichosonCode, 市町村コード), eq(kaigoIryokikanCode, 介護医療区分コード));
//            assertThat(sut.select(criteria).get(0).getDbT7011ShujiiIryoKikanJohoEntity().getIryokikanCode(), is(new RString("001")));
//        }
//    }
//
//    public static class select_市町村コードと介護医療機関コードを指定した場合のテスト extends TestDacBase {
//
//        private ShichosonCode 市町村コード;
//        private KaigoIryoKikanCode 介護医療区分コード;
//
//        static {
//            setGyomuCD("UZ");
//        }
//
//        @Override
//        public void setUp() {
//            iryoKikanInserter.insert(KaigoIryoKikanTestHelper.create医療機関Entity());
//            市町村コード = new ShichosonCode(new RString("A001"));
//            介護医療区分コード = new KaigoIryoKikanCode(new RString("B001"));
//            shujiiIryoKikanInserter.insert(create主治医医療機関情報Entity(市町村コード, 介護医療区分コード, new RString("001")));
//        }
//
//        @Test
//        public void 市町村コードと介護医療機関コードを指定して_対応した情報が取得できる() {
//            assertThat(sut.select(市町村コード, 介護医療区分コード).getDbT7011ShujiiIryoKikanJohoEntity().getIryokikanCode(), is(new RString("001")));
//        }
//    }
//
//    public static class select_市町村コードと介護医療機関コードと医療機関状況を指定した場合のテスト extends TestDacBase {
//
//        private ShichosonCode 市町村コード;
//        private KaigoIryoKikanCode 介護医療区分コード;
//
//        static {
//            setGyomuCD("UZ");
//        }
//
//        @Override
//        public void setUp() {
//            iryoKikanInserter.insert(KaigoIryoKikanTestHelper.create医療機関Entity());
//            市町村コード = new ShichosonCode(new RString("A001"));
//            介護医療区分コード = new KaigoIryoKikanCode(new RString("B001"));
//            DbT7011ShujiiIryoKikanJohoEntity shujiiIryoKikanEntity = create主治医医療機関情報Entity(市町村コード, 介護医療区分コード, new RString("001"));
//            shujiiIryoKikanEntity.setIryokikanJokyo(true);
//            shujiiIryoKikanInserter.insert(shujiiIryoKikanEntity);
//        }
//
//        @Test
//        public void 市町村コードと介護医療機関コードと医療機関状況を指定して_対応した情報が取得できる() {
//            assertThat(sut.select(市町村コード, 介護医療区分コード, IryoKikanJokyo.有効).getDbT7011ShujiiIryoKikanJohoEntity().getIryokikanJokyo(), is(true));
//        }
//    }
//
//    public static class select_市町村コードを指定してリストで返ってくる場合のテスト extends TestDacBase {
//
//        private ShichosonCode 市町村コード;
//        private KaigoIryoKikanCode 介護医療区分コード;
//
//        static {
//            setGyomuCD("UZ");
//        }
//
//        @Override
//        public void setUp() {
//            iryoKikanInserter.insert(KaigoIryoKikanTestHelper.create医療機関Entity());
//            市町村コード = new ShichosonCode(new RString("A001"));
//            介護医療区分コード = new KaigoIryoKikanCode(new RString("B001"));
//            shujiiIryoKikanInserter.insert(create主治医医療機関情報Entity(市町村コード, 介護医療区分コード, new RString("001")));
//        }
//
//        @Test
//        public void 市町村コードを指定して_対応した情報が取得できる() {
//            assertThat(sut.select(市町村コード).get(0).getDbT7011ShujiiIryoKikanJohoEntity().getIryokikanCode(), is(new RString("001")));
//        }
//    }
//
//    public static class select_市町村コードと医療機関状況を指定してリストで返ってくる場合のテスト extends TestDacBase {
//
//        private ShichosonCode 市町村コード;
//        private KaigoIryoKikanCode 介護医療区分コード;
//
//        static {
//            setGyomuCD("UZ");
//        }
//
//        @Override
//        public void setUp() {
//            iryoKikanInserter.insert(KaigoIryoKikanTestHelper.create医療機関Entity());
//            市町村コード = new ShichosonCode(new RString("A001"));
//            介護医療区分コード = new KaigoIryoKikanCode(new RString("B001"));
//            DbT7011ShujiiIryoKikanJohoEntity shujiiIryoKikanEntity = create主治医医療機関情報Entity(市町村コード, 介護医療区分コード, new RString("001"));
//            shujiiIryoKikanEntity.setIryokikanJokyo(true);
//            shujiiIryoKikanInserter.insert(shujiiIryoKikanEntity);
//        }
//
//        @Test
//        public void 市町村コードと医療機関状況を指定して_対応した情報が取得できる() {
//            assertThat(sut.select(市町村コード, IryoKikanJokyo.有効).get(0).getDbT7011ShujiiIryoKikanJohoEntity().getIryokikanJokyo(), is(true));
//        }
//    }
//
//    private static DbT7011ShujiiIryoKikanJohoEntity create主治医医療機関情報Entity(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, RString 医療機関コード) {
//        DbT7011ShujiiIryoKikanJohoEntity entity = KaigoIryoKikanTestHelper.create主治医医療機関Entity();
//        entity.setShichosonCode(市町村コード);
//        entity.setKaigoIryokikanCode(介護医療機関コード);
//        entity.setIryokikanCode(医療機関コード);
//        return entity;
//    }
//
//    private static KaigoIryoKikanEntity create介護医療機関Entity(DbT7011ShujiiIryoKikanJohoEntity 主治医慮機関情報Entity) {
//        KaigoIryoKikanEntity entity = new KaigoIryoKikanEntity();
//        entity.setDbT7011ShujiiIryoKikanJohoEntity(主治医慮機関情報Entity);
//        entity.setIryoKikanEntity(KaigoIryoKikanTestHelper.create医療機関Entity());
//        return entity;
//    }
}
