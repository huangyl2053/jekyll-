/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約サービス種別;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * {@link DbT7061JuryoIninJigyoshaDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7061JuryoIninJigyoshaDacTest extends DbxTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7061JuryoIninJigyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7061JuryoIninJigyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
        }

        @Test(expected = NullPointerException.class)
        public void 受領委任契約事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
        }

        @Test(expected = NullPointerException.class)
        public void 受領委任契約開始日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
        }

        @Test(expected = NullPointerException.class)
        public void 契約サービス種別がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7061JuryoIninJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7061JuryoIninJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 受領委任契約事業者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 受領委任契約事業者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 受領委任契約事業者エンティティを渡すと_insertは_受領委任契約事業者を追加する() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);

            assertThat(sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_updateは_受領委任契約事業者を更新する() {
            DbT7061JuryoIninJigyoshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
            updateRecord.setJigyoshaJusho(new AtenaJusho("なてな住所444"));

            sut.save(updateRecord);

            DbT7061JuryoIninJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);

            assertThat(updateRecord.getJigyoshaJusho(), is(updatedRecord.getJigyoshaJusho()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_deleteは_受領委任契約事業者を削除する() {
            DbT7061JuryoIninJigyoshaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                JigyoshaNo 受領委任契約事業者番号,
                FlexibleDate 受領委任契約開始日,
                RString 契約サービス種別) {
            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            entity.setJigyoshaNo(受領委任契約事業者番号);
            entity.setKeiyakuKaishiYMD(受領委任契約開始日);
            entity.setServiceShubetsuCode(契約サービス種別);
            sut.save(entity);
        }
    }
}
