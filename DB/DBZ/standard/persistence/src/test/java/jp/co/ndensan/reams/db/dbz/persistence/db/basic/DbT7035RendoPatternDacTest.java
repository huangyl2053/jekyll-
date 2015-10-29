/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7035RendoPatternDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_種別;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7035RendoPatternDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7035RendoPatternDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7035RendoPatternDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7035RendoPatternDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
            TestSupport.insert(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 送信元市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 送信先市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 種別がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効終了年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7035RendoPatternEntity insertedRecord = sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7035RendoPatternEntity insertedRecord = sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 連動パターンが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
            TestSupport.insert(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 連動パターンが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 連動パターンエンティティを渡すと_insertは_連動パターンを追加する() {
            TestSupport.insert(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);

            assertThat(sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test
        public void 連動パターンエンティティを渡すと_updateは_連動パターンを更新する() {
            DbT7035RendoPatternEntity updateRecord = sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7035RendoPatternEntity updatedRecord = sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
        }

        @Test
        public void 連動パターンエンティティを渡すと_deleteは_連動パターンを削除する() {
            DbT7035RendoPatternEntity deletedEntity = sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_送信元市町村コード,
                    DEFAULT_送信先市町村コード,
                    DEFAULT_種別,
                    DEFAULT_有効開始年月日,
                    DEFAULT_有効終了年月日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 送信元市町村コード,
                LasdecCode 送信先市町村コード,
                RString 種別,
                FlexibleDate 有効開始年月日,
                FlexibleDate 有効終了年月日) {
            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            entity.setMotoShichosonCode(送信元市町村コード);
            entity.setSakiShichosonCode(送信先市町村コード);
            entity.setShubetsu(種別);
            entity.setYukoKaishiYMD(有効開始年月日);
            entity.setYukoShuryoYMD(有効終了年月日);
            sut.save(entity);
        }
    }
}
