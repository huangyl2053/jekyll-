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
 * {@link TandokuJoseiShuruiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseiShuruiBuilderTest extends DbcTestBase {

    private static DbT3099TandokuJoseiShuruiEntity TandokuJoseiShuruiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static TandokuJoseiShuruiBuilder sut;
        private static TandokuJoseiShurui business;

        @Before
        public void setUp() {
            TandokuJoseiShuruiEntity = new DbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShuruiEntity.setXXX(主キー名1);
            TandokuJoseiShuruiEntity.setXXX(主キー名2);

            business = new TandokuJoseiShurui(TandokuJoseiShuruiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の市町村単独助成種類は_設定した値と同じ市町村単独助成種類を返す() {
            business = sut.set市町村単独助成種類(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類).build();
            assertThat(business.get市町村単独助成種類(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類));
        }

        @Test
        public void 戻り値の助成サービス種類コードは_設定した値と同じ助成サービス種類コードを返す() {
            business = sut.set助成サービス種類コード(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード).build();
            assertThat(business.get助成サービス種類コード(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            business = sut.set適用開始年月(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月).build();
            assertThat(business.get適用開始年月(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            business = sut.set適用終了年月(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用終了年月).build();
            assertThat(business.get適用終了年月(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の助成サービス種類名称は_設定した値と同じ助成サービス種類名称を返す() {
            business = sut.set助成サービス種類名称(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類名称).build();
            assertThat(business.get助成サービス種類名称(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類名称));
        }

        @Test
        public void 戻り値の市町村単独助成単位は_設定した値と同じ市町村単独助成単位を返す() {
            business = sut.set市町村単独助成単位(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成単位).build();
            assertThat(business.get市町村単独助成単位(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成単位));
        }

        @Test
        public void 戻り値の市町村単独助成内容は_設定した値と同じ市町村単独助成内容を返す() {
            business = sut.set市町村単独助成内容(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成内容).build();
            assertThat(business.get市町村単独助成内容(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成内容));
        }

    }
}
