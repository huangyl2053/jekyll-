/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyoshaEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.ServiceShubetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7061JuryoIninKeiyakuJigyoshaDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7061JuryoIninKeiyakuJigyoshaDacTest extends DbxTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7061JuryoIninKeiyakuJigyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7061JuryoIninKeiyakuJigyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
        }

        @Test(expected = NullPointerException.class)
        public void 受領委任契約事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
        }

        @Test(expected = NullPointerException.class)
        public void 受領委任契約開始日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
        }

        @Test(expected = NullPointerException.class)
        public void 契約サービス種別がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7061JuryoIninKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7061JuryoIninKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 受領委任契約事業者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
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
                    DEFAULT_契約サービス種別.getColumnValue());

            assertThat(sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue()), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_updateは_受領委任契約事業者を更新する() {
            DbT7061JuryoIninKeiyakuJigyoshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
            updateRecord.setJigyoshaJusho(new AtenaJusho("なてな住所444"));

            sut.save(updateRecord);

            DbT7061JuryoIninKeiyakuJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());

            assertThat(updateRecord.getJigyoshaJusho(), is(updatedRecord.getJigyoshaJusho()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_deleteは_受領委任契約事業者を削除する() {
            DbT7061JuryoIninKeiyakuJigyoshaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue());
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_受領委任契約事業者番号,
                    DEFAULT_受領委任契約開始日,
                    DEFAULT_契約サービス種別.getColumnValue()), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KaigoJigyoshaNo 受領委任契約事業者番号,
                FlexibleDate 受領委任契約開始日,
                RString 契約サービス種別) {
            DbT7061JuryoIninKeiyakuJigyoshaEntity entity = DbT7061JuryoIninKeiyakuJigyoshaEntityGenerator.createDbT7061JuryoIninKeiyakuJigyoshaEntity();
            entity.setJigyoshaNo(受領委任契約事業者番号);
            entity.setKeiyakuKaishiYMD(受領委任契約開始日);
            entity.setServiceShubetsuCode(new ServiceShubetsuCode(契約サービス種別));
            sut.save(entity);
        }
    }
}
