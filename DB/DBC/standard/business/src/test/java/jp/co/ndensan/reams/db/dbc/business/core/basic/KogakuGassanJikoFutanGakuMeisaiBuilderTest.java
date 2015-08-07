/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanJikoFutanGakuMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanJikoFutanGakuMeisaiBuilderTest extends DbcTestBase {

    private static DbT3071KogakuGassanJikoFutanGakuMeisaiEntity KogakuGassanJikoFutanGakuMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KogakuGassanJikoFutanGakuMeisaiBuilder sut;
        private static KogakuGassanJikoFutanGakuMeisai business;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuMeisaiEntity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
            KogakuGassanJikoFutanGakuMeisaiEntity.setXXX(主キー名1);
            KogakuGassanJikoFutanGakuMeisaiEntity.setXXX(主キー名2);

            business = new KogakuGassanJikoFutanGakuMeisai(KogakuGassanJikoFutanGakuMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            business = sut.set対象年度(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象年度).build();
            assertThat(business.get対象年度(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            business = sut.set支給申請書整理番号(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_支給申請書整理番号).build();
            assertThat(business.get支給申請書整理番号(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の対象月は_設定した値と同じ対象月を返す() {
            business = sut.set対象月(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象月).build();
            assertThat(business.get対象月(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の自己負担額は_設定した値と同じ自己負担額を返す() {
            business = sut.set自己負担額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_自己負担額).build();
            assertThat(business.get自己負担額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_自己負担額));
        }

        @Test
        public void 戻り値の70-74自己負担額（内数）は_設定した値と同じ70-74自己負担額（内数）を返す() {
            business = sut.set70-74自己負担額（内数）(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70-74自己負担額（内数）).build();
            assertThat(business.get70-74自己負担額（内数）(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70-74自己負担額（内数）));
        }

        @Test
        public void 戻り値の70未満高額支給額は_設定した値と同じ70未満高額支給額を返す() {
            business = sut.set70未満高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70未満高額支給額).build();
            assertThat(business.get70未満高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70未満高額支給額));
        }

        @Test
        public void 戻り値の70-74高額支給額は_設定した値と同じ70-74高額支給額を返す() {
            business = sut.set70-74高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70-74高額支給額).build();
            assertThat(business.get70-74高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70-74高額支給額));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の補正済・自己負担額は_設定した値と同じ補正済・自己負担額を返す() {
            business = sut.set補正済・自己負担額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・自己負担額).build();
            assertThat(business.get補正済・自己負担額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・自己負担額));
        }

        @Test
        public void 戻り値の補正済・70-74自己負担額（内数）は_設定した値と同じ補正済・70-74自己負担額（内数）を返す() {
            business = sut.set補正済・70-74自己負担額（内数）(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・70-74自己負担額（内数）).build();
            assertThat(business.get補正済・70-74自己負担額（内数）(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・70-74自己負担額（内数）));
        }

        @Test
        public void 戻り値の補正済・70未満高額支給額は_設定した値と同じ補正済・70未満高額支給額を返す() {
            business = sut.set補正済・70未満高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・70未満高額支給額).build();
            assertThat(business.get補正済・70未満高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・70未満高額支給額));
        }

        @Test
        public void 戻り値の補正済・70-74高額支給額は_設定した値と同じ補正済・70-74高額支給額を返す() {
            business = sut.set補正済・70-74高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・70-74高額支給額).build();
            assertThat(business.get補正済・70-74高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・70-74高額支給額));
        }

        @Test
        public void 戻り値の補正済・摘要は_設定した値と同じ補正済・摘要を返す() {
            business = sut.set補正済・摘要(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・摘要).build();
            assertThat(business.get補正済・摘要(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済・摘要));
        }

    }
}
