/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査特記事項Dacのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaTokkijikoDacTest extends TestDacBase {
    //TODO n8178 城間篤人 業務独自ドメインができた後に改めて実装予定 2014年2月末
//
//    private static INinteichosaTokkijikoDac sut;
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceCreator.create(INinteichosaTokkijikoDac.class);
//    }
//
//    public static class select_申請書管理番号と認定調査依頼履歴番号が引数の場合のテスト extends TestDacBase {
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//
//            sut.insert(create認定調査特記事項Entity(create申請書管理番号("A002"), create認定調査依頼履歴番号(1), "Op01"));
//            sut.insert(create認定調査特記事項Entity(create申請書管理番号("A001"), create認定調査依頼履歴番号(1), "Op02"));
//            sut.insert(create認定調査特記事項Entity(create申請書管理番号("A002"), create認定調査依頼履歴番号(1), "Op03"));
//            sut.insert(create認定調査特記事項Entity(create申請書管理番号("A001"), create認定調査依頼履歴番号(2), "Op04"));
//            sut.insert(create認定調査特記事項Entity(create申請書管理番号("A002"), create認定調査依頼履歴番号(2), "Op05"));
//        }
//
//        @Test
//        public void 申請書管理番号_A001_認定調査依頼履歴番号_1_を指定したとき_1件のリストが返る() {
//            List<DbT5010NinteichosaTokkijikoEntity> result = sut.select(create申請書管理番号("A001"), create認定調査依頼履歴番号(1));
//            assertThat(result.size(), is(2));
//        }
//
//        @Test
//        public void 申請書管理番号_A002_認定調査依頼履歴番号_1_を指定したとき_2件のリストが返る() {
//            List<DbT5010NinteichosaTokkijikoEntity> result = sut.select(create申請書管理番号("A002"), create認定調査依頼履歴番号(1));
//            assertThat(result.size(), is(1));
//        }
//    }
//
//    public static class select_申請書管理番号が引数の場合のテスト extends TestDacBase {
//
//        private ShinseishoKanriNo 申請書管理番号_A001;
//        private ShinseishoKanriNo 申請書管理番号_B001;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            申請書管理番号_A001 = create申請書管理番号("A001");
//            申請書管理番号_B001 = create申請書管理番号("B001");
//
//            sut.insert(create認定調査特記事項Entity(申請書管理番号_A001, create認定調査依頼履歴番号(1)));
//            sut.insert(create認定調査特記事項Entity(申請書管理番号_A001, create認定調査依頼履歴番号(2)));
//            sut.insert(create認定調査特記事項Entity(申請書管理番号_B001, create認定調査依頼履歴番号(1)));
//            sut.insert(create認定調査特記事項Entity(申請書管理番号_A001, create認定調査依頼履歴番号(3)));
//            sut.insert(create認定調査特記事項Entity(申請書管理番号_B001, create認定調査依頼履歴番号(2)));
//        }
//
//        @Test
//        public void 申請書管理番号_A001を指定したとき_3件のEntityを持つリストが返る() {
//            List<DbT5010NinteichosaTokkijikoEntity> results = sut.select(申請書管理番号_A001);
//            assertThat(results.size(), is(3));
//        }
//
//        @Test
//        public void 申請書管理番号_B001を指定したとき_2件のEntityを持つリストが返る() {
//            List<DbT5010NinteichosaTokkijikoEntity> results = sut.select(申請書管理番号_B001);
//            assertThat(results.size(), is(2));
//        }
//    }
//
//    public static class insertのテスト extends TestDacBase {
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        public void insertできる() {
//            int 件数 = sut.insert(create認定調査特記事項Entity());
//            assertThat(件数, is(1));
//        }
//
//        public void 主キーが同値のデータがすでに存在している場合_insertに失敗する() {
//
//            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
//            NinteichosaIraiRirekiNo 認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
//            sut.insert(create認定調査特記事項Entity(申請書管理番号, 認定調査依頼履歴番号));
//
//            int 件数 = sut.insert(create認定調査特記事項Entity(申請書管理番号, 認定調査依頼履歴番号));
//            assertThat(件数, is(0));
//        }
//    }
//
//    public static class updateのテスト extends TestDacBase {
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        public void updateできる() {
//            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
//            NinteichosaIraiRirekiNo 認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
//            sut.update(create認定調査特記事項Entity(申請書管理番号, 認定調査依頼履歴番号));
//
//            int 件数 = sut.update(create認定調査特記事項Entity(申請書管理番号, 認定調査依頼履歴番号));
//            assertThat(件数, is(1));
//        }
//
//        public void 指定したデータが存在しない場合_updateに失敗する() {
//            int 件数 = sut.update(create認定調査特記事項Entity());
//            assertThat(件数, is(0));
//        }
//    }
//
//    public static class deleteのテスト extends TestDacBase {
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        public void deleteできる() {
//            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
//            NinteichosaIraiRirekiNo 認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
//            sut.insert(create認定調査特記事項Entity(申請書管理番号, 認定調査依頼履歴番号));
//
//            int 件数 = sut.delete(create認定調査特記事項Entity(申請書管理番号, 認定調査依頼履歴番号));
//            assertThat(件数, is(1));
//        }
//
//        public void 指定したデータが存在しない場合_deleteに失敗する() {
//            int 件数 = sut.delete(create認定調査特記事項Entity());
//            assertThat(件数, is(0));
//        }
//    }
//
//    public static class insertOrUpdateのテスト extends TestDacBase {
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        //TODO n8178 城間篤人 updateCountの取得法を確認してから実装予定 2014年2月末
//        @Test
//        public void updateCountが0のとき_insertを実行する() {
//        }
//
//        @Test
//        public void updateCountが1以上のとき_updateを実行する() {
//        }
//    }
//
//    private static DbT5010NinteichosaTokkijikoEntity create認定調査特記事項Entity(ShinseishoKanriNo 申請書管理番号,
//            NinteichosaIraiRirekiNo 認定調査依頼履歴番号, String 特記事項番号) {
//        DbT5010NinteichosaTokkijikoEntity entity = new DbT5010NinteichosaTokkijikoEntity();
//        entity.setShinseishoKanriNo(申請書管理番号);
//        entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
//        entity.setNinteichosaTokkijikoNo(new RString(特記事項番号));
//        entity.setNinteichosaTokkijiko(new RString("特記"));
//        return entity;
//    }
//
//    private static DbT5010NinteichosaTokkijikoEntity create認定調査特記事項Entity(ShinseishoKanriNo 申請書管理番号,
//            NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
//        return create認定調査特記事項Entity(申請書管理番号, 認定調査依頼履歴番号, "B001");
//    }
//
//    private static DbT5010NinteichosaTokkijikoEntity create認定調査特記事項Entity() {
//        return create認定調査特記事項Entity(new ShinseishoKanriNo(new RString("A001")), new NinteichosaIraiRirekiNo((1)));
//    }
//
//    private static ShinseishoKanriNo create申請書管理番号(String str) {
//        return new ShinseishoKanriNo(new RString(str));
//    }
//
//    private static NinteichosaIraiRirekiNo create認定調査依頼履歴番号(int i) {
//        return new NinteichosaIraiRirekiNo(i);
//    }
}
