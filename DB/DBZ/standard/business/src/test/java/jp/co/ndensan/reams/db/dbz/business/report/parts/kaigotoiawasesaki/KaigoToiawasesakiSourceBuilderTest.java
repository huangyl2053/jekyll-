/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki;

import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoToiawasesakiSourceBuilder}のテストです。
 */
@RunWith(Enclosed.class)
public class KaigoToiawasesakiSourceBuilderTest {

    private static KaigoToiawasesakiSourceBuilder sut;
    private static CompKaigoToiawasesakiSource source;
    private static final RString 庁舎名 = new RString("庁舎名");
    private static final RString 部署名 = new RString("部署名");
    private static final RString 内線番号 = new RString("1234");

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数の介護問合せ先にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new KaigoToiawasesakiSourceBuilder(null);
            fail();
        }
    }

    public static class buildSource extends DbzTestBase {

        @Before
        public void setUp() {
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity());
            sut = new KaigoToiawasesakiSourceBuilder(介護問合せ先);
            source = sut.buildSource();
        }

        @Test
        public void 介護問合せ先ソース編集_郵便番号() {
            assertThat(source.yubinBango, is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_郵便番号.value()));
        }

        @Test
        public void 介護問合せ先ソース編集_所在地() {
            assertThat(source.shozaichi, is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_所在地));
        }

        @Test
        public void 介護問合せ先ソース編集_担当者名() {
            assertThat(source.tantoName, is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_担当者名));
        }

        @Test
        public void 介護問合せ先ソース編集_電話番号() {
            assertThat(source.telNo, is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_電話番号.value()));
        }

        @Test
        public void 介護問合せ先ソース編集_内線番号() {
            assertThat(source.naisenNo, is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_内線番号));
        }
    }

    public static class buildSource庁舎部署名 extends DbzTestBase {

        @Test
        public void 介護問合せ先ソース編集_庁舎部署名_庁舎名あり_部署名あり() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setChoshaName(庁舎名);
            entity.setBushoName(部署名);
            sut = new KaigoToiawasesakiSourceBuilder(new KaigoToiawasesaki(entity));
            source = sut.buildSource();
            RString expected = new RStringBuilder(庁舎名).
                    append(RString.HALF_SPACE).
                    append(部署名).
                    toRString();

            assertThat(source.choshaBushoName, is(expected));
        }

        @Test
        public void 介護問合せ先ソース編集_庁舎部署名_庁舎名あり_部署名なし() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setChoshaName(庁舎名);
            entity.setBushoName(RString.EMPTY);
            sut = new KaigoToiawasesakiSourceBuilder(new KaigoToiawasesaki(entity));
            source = sut.buildSource();
            RString expected = new RStringBuilder(庁舎名).
                    toRString();

            assertThat(source.choshaBushoName, is(expected));
        }

        @Test
        public void 介護問合せ先ソース編集_庁舎部署名_庁舎名なし_部署名あり() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setChoshaName(RString.EMPTY);
            entity.setBushoName(部署名);
            sut = new KaigoToiawasesakiSourceBuilder(new KaigoToiawasesaki(entity));
            source = sut.buildSource();
            RString expected = new RStringBuilder(部署名).
                    toRString();

            assertThat(source.choshaBushoName, is(expected));
        }

        @Test
        public void 介護問合せ先ソース編集_庁舎部署名_庁舎名なし_部署名なし() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setChoshaName(RString.EMPTY);
            entity.setBushoName(RString.EMPTY);
            sut = new KaigoToiawasesakiSourceBuilder(new KaigoToiawasesaki(entity));
            source = sut.buildSource();
            RString expected = RString.EMPTY;

            assertThat(source.choshaBushoName, is(expected));
        }

    }

    public static class buildSource内線ラベル extends DbzTestBase {

        @Test
        public void 介護問合せ先ソース編集_内線ラベル_内線番号あり() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setNaisenNo(内線番号);
            sut = new KaigoToiawasesakiSourceBuilder(new KaigoToiawasesaki(entity));
            source = sut.buildSource();
            RString expected = new RString("（内線）");

            assertThat(source.naisenLabel, is(expected));
        }

        @Test
        public void 介護問合せ先ソース編集_内線ラベル_内線番号なし() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setNaisenNo(RString.EMPTY);
            sut = new KaigoToiawasesakiSourceBuilder(new KaigoToiawasesaki(entity));
            source = sut.buildSource();
            RString expected = RString.EMPTY;

            assertThat(source.naisenLabel, is(expected));
        }
    }

}
