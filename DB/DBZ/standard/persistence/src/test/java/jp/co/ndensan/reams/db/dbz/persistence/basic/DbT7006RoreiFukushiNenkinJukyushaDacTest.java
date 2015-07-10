/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7006RoreiFukushiNenkinJukyushaEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7006RoreiFukushiNenkinJukyushaDac}のテストです。
 *
 * @author LDNS 賈楽楽
 */
@RunWith(Enclosed.class)
public class DbT7006RoreiFukushiNenkinJukyushaDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7006RoreiFukushiNenkinJukyushaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new ShikibetsuCode("5241611"),
                    DEFAULT_受給開始日);
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_受給開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 受給開始日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7006RoreiFukushiNenkinJukyushaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7006RoreiFukushiNenkinJukyushaEntity insertedRecord = sut.selectByKey(
                    new ShikibetsuCode("46542"),
                    DEFAULT_受給開始日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 老齢福祉年金受給者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new ShikibetsuCode("5241611"),
                    DEFAULT_受給開始日);
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 老齢福祉年金受給者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 老齢福祉年金受給者エンティティを渡すと_insertは_老齢福祉年金受給者を追加する() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日);
        }

        @Test
        public void 老齢福祉年金受給者エンティティを渡すと_updateは_老齢福祉年金受給者を更新する() {
            DbT7006RoreiFukushiNenkinJukyushaEntity updateRecord = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            //TODO  主キー以外の項目を変更してください
// updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7006RoreiFukushiNenkinJukyushaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日);

            //TODO  主キー以外の項目を変更してください
//assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日);
        }

        @Test
        public void 老齢福祉年金受給者エンティティを渡すと_deleteは_老齢福祉年金受給者を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日));
            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_受給開始日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShikibetsuCode 識別コード,
                FlexibleDate 受給開始日) {
            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            entity.setShikibetsuCode(識別コード);
            entity.setJukyuKaishiYMD(受給開始日);
            sut.insert(entity);
        }
    }
}
