/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.TashichosonJushochiTokureiModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TashichosonJushochiTokureiDac}のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiDacTest {

    private static TashichosonJushochiTokureiDac sut;
    private static DbT1003TashichosonJushochiTokureiDac 他市町村住所地特例Dac;
    private static final LasdecCode 市町村コード1 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_市町村コード;
    private static final ShikibetsuCode 識別コード1 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
    private static final ShikibetsuCode 識別コード2 = new ShikibetsuCode("012012012012012");
    private static final YMDHMS 処理日時1 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_処理日時;
    private static final YMDHMS 処理日時2 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_処理日時.plusDay(1);
    private static final YMDHMS 処理日時3 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_処理日時.plusDay(2);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(TashichosonJushochiTokureiDac.class);
        他市町村住所地特例Dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
    }

    public static class select他市町村住所地特例ModelByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1003(市町村コード1, 識別コード1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select他市町村住所地特例ModelByKey(null, 識別コード1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select他市町村住所地特例ModelByKey(市町村コード1, null, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select他市町村住所地特例ModelByKey(市町村コード1, 識別コード1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_適用除外者Modelモデル返す() {
            TashichosonJushochiTokureiModel result = sut.select他市町村住所地特例ModelByKey(市町村コード1, 識別コード1, 処理日時1);
            assertThat(result.get識別コード(), is(識別コード1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            TashichosonJushochiTokureiModel result = sut.select他市町村住所地特例ModelByKey(市町村コード1, 識別コード1, 処理日時2);
            assertThat(result, is(nullValue()));
        }
    }

    public static class select他市町村住所地特例List extends DbzTestDacBase {

        private FlexibleDate 適用日20141231;
        private FlexibleDate 適用日20140612;
        private FlexibleDate 適用日20131109;

        @Before
        public void setUp() {
            適用日20141231 = new FlexibleDate("20141231");
            適用日20140612 = new FlexibleDate("20140612");
            適用日20131109 = new FlexibleDate("20131109");

            TestSupport.insertDbT1003(市町村コード1, 識別コード1, 処理日時1, 適用日20140612);
            TestSupport.insertDbT1003(市町村コード1, 識別コード1, 処理日時2, 適用日20141231);
            TestSupport.insertDbT1003(市町村コード1, 識別コード1, 処理日時3, 適用日20131109);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select他市町村住所地特例List(null, 識別コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select他市町村住所地特例List(市町村コード1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            List<TashichosonJushochiTokureiModel> result = sut.select他市町村住所地特例List(市町村コード1, 識別コード1);
            assertThat(result.size(), is(3));
            assertThat(result.get(0).get市町村コード(), is(市町村コード1));
            assertThat(result.get(0).get識別コード(), is(識別コード1));
            assertThat(result.get(1).get市町村コード(), is(市町村コード1));
            assertThat(result.get(1).get識別コード(), is(識別コード1));
            assertThat(result.get(2).get市町村コード(), is(市町村コード1));
            assertThat(result.get(2).get識別コード(), is(識別コード1));
        }

        @Test
        public void 検索結果は適用日の降順によってソートされ_順番は2番目_1番目_3番目の順になる() {
            List<TashichosonJushochiTokureiModel> result = sut.select他市町村住所地特例List(市町村コード1, 識別コード1);
            assertThat(result.get(0).get適用年月日(), is(適用日20141231));
            assertThat(result.get(1).get適用年月日(), is(適用日20140612));
            assertThat(result.get(2).get適用年月日(), is(適用日20131109));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            List<TashichosonJushochiTokureiModel> result = sut.select他市町村住所地特例List(市町村コード1, 識別コード2);
            assertThat(result.isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO TashichosonJushochiTokureiModelModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つTashichosonJushochiTokureiModelモデルを渡した時_insertは_1を返す() {
            TashichosonJushochiTokureiModel model
                    = new TashichosonJushochiTokureiModel(DbT1003TashichosonJushochiTokureiEntityGenerator.
                            createDbT1003TashichosonJushochiTokureiEntity());

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO TashichosonJushochiTokureiModelModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            TashichosonJushochiTokureiModel model
                    = new TashichosonJushochiTokureiModel(DbT1003TashichosonJushochiTokureiEntityGenerator.
                            createDbT1003TashichosonJushochiTokureiEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            model.getEntity().setKaijoYMD(FlexibleDate.MAX);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO TashichosonJushochiTokureiModelModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つTashichosonJushochiTokureiModelモデルを渡した時_deleteは_1を返す() {
            TashichosonJushochiTokureiModel model
                    = new TashichosonJushochiTokureiModel(DbT1003TashichosonJushochiTokureiEntityGenerator.
                            createDbT1003TashichosonJushochiTokureiEntity());

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        // TODO TashichosonJushochiTokureiModelModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つTashichosonJushochiTokureiModelモデルを渡した時_deletePhysicalは_1を返す() {
            TashichosonJushochiTokureiModel model
                    = new TashichosonJushochiTokureiModel(DbT1003TashichosonJushochiTokureiEntityGenerator.
                            createDbT1003TashichosonJushochiTokureiEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT1003(
                LasdecCode shichosonCode,
                ShikibetsuCode shikibetsuCode,
                YMDHMS ymdhms) {
            DbT1003TashichosonJushochiTokureiEntity entity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            entity.setShichosonCode(shichosonCode);
            entity.setShikibetsuCode(shikibetsuCode);
            entity.setShoriTimestamp(ymdhms);
            他市町村住所地特例Dac.insert(entity);
        }

        public static void insertDbT1003(
                LasdecCode shichosonCode,
                ShikibetsuCode shikibetsuCode,
                YMDHMS ymdhms,
                FlexibleDate tekiyoDate) {
            DbT1003TashichosonJushochiTokureiEntity entity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            entity.setShichosonCode(shichosonCode);
            entity.setShikibetsuCode(shikibetsuCode);
            entity.setShoriTimestamp(ymdhms);
            entity.setTekiyoYMD(tekiyoDate);
            他市町村住所地特例Dac.insert(entity);
        }
    }

}
