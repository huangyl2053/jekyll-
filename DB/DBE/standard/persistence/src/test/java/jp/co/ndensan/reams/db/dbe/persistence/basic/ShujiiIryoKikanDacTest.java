/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 主治医医療機関DACのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIryoKikanDacTest extends TestDacBase {
    //TODO n8178 城間篤人 業務固有クラス、enumのマッピングが上手くいかないため未実装。マッピングができるようになった時点で実装予定 2014年2月末
//
//    private static IShuJiiIryoKikanDac sut;
//    private static IShujiiIryoKikanDacMock selecter;
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceCreator.create(IShuJiiIryoKikanDac.class);
//        selecter = InstanceCreator.create(IShujiiIryoKikanDacMock.class);
//    }
//
//    public static class insertOrUpdateのテスト extends TestDacBase {
//
//        private ShoKisaiHokenshaNo 証記載保険者番号;
//        private KaigoIryoKikanCode 介護医療機関コード;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A00001"));
//            介護医療機関コード = new KaigoIryoKikanCode(new RString("B001"));
//
//            sut.insert(create主治医医療機関情報Entity(証記載保険者番号, 介護医療機関コード, new RString("001")));
//        }
//
//        @Test
//        public void すでに存在するデータをinsertOrUpdateすると_データが更新される() {
//            sut.insertOrUpdate(create主治医医療機関情報Entity(証記載保険者番号, 介護医療機関コード, new RString("002")));
//            assertThat(selecter.select(証記載保険者番号, 介護医療機関コード).getIryokikanCode(), is(new RString("002")));
//        }
//
//        @Test
//        public void 新規のデータをinsertOrUpdateすると_データが新しく登録される() {
//            ShoKisaiHokenshaNo 証記載保険者番号2 = new ShoKisaiHokenshaNo(new RString("A00002"));
//            KaigoIryoKikanCode 介護医療機関コード2 = new KaigoIryoKikanCode(new RString("B002"));
//
//            sut.insertOrUpdate(create主治医医療機関情報Entity(証記載保険者番号2, 介護医療機関コード2, new RString("002")));
//            assertThat(selecter.select(証記載保険者番号2, 介護医療機関コード2).getIryokikanCode(), is(new RString("002")));
//        }
//    }
//
//    public static class deleteのテスト extends TestDacBase {
//
//        private ShoKisaiHokenshaNo 証記載保険者番号;
//        private KaigoIryoKikanCode 介護医療機関コード;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A00001"));
//            介護医療機関コード = new KaigoIryoKikanCode(new RString("B001"));
//
//            sut.insert(create主治医医療機関情報Entity(証記載保険者番号, 介護医療機関コード, new RString("001")));
//        }
//
//        @Test
//        public void 実行することで_データが削除される() {
//            sut.delete(create主治医医療機関情報Entity(証記載保険者番号, 介護医療機関コード, new RString("001")));
//            assertThat(selecter.select(証記載保険者番号, 介護医療機関コード).getIryokikanCode(), nullValue());
//        }
//
//        @Test
//        public void 存在しないデータを削除しようとしたとき_0が返る() {
//            int 削除件数 = sut.delete(create主治医医療機関情報Entity(証記載保険者番号, 介護医療機関コード, new RString("001")));
//            assertThat(削除件数, is(0));
//        }
//    }
//
//    private static DbT7011ShujiiIryoKikanJohoEntity create主治医医療機関情報Entity(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, RString 医療機関コード) {
//        DbT7011ShujiiIryoKikanJohoEntity entity = KaigoIryoKikanTestHelper.create主治医医療機関Entity();
//        entity.setShoKisaiHokenshaNo(証記載保険者番号);
//        entity.setKaigoIryokikanCode(介護医療機関コード);
//        entity.setIryokikanCode(医療機関コード);
//        return entity;
//    }
}
