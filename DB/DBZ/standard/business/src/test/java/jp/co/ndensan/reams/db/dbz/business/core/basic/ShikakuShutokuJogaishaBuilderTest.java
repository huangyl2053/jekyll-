/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1009ShikakuShutokuJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShikakuShutokuJogaishaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShikakuShutokuJogaishaBuilderTest extends DbzTestBase {

    private static DbT1009ShikakuShutokuJogaishaEntity ShikakuShutokuJogaishaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShikakuShutokuJogaishaBuilder sut;
        private static ShikakuShutokuJogaisha business;

        @Before
        public void setUp() {
            ShikakuShutokuJogaishaEntity = new DbT1009ShikakuShutokuJogaishaEntity();
            ShikakuShutokuJogaishaEntity.setShikibetsuCode(識別コード);
            ShikakuShutokuJogaishaEntity.setRirekiNo(履歴番号);

            business = new ShikakuShutokuJogaisha(ShikakuShutokuJogaishaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の資格取得除外理由は_設定した値と同じ資格取得除外理由を返す() {
            business = sut.set資格取得除外理由(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外理由).build();
            assertThat(business.get資格取得除外理由(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外理由));
        }

        @Test
        public void 戻り値の資格取得除外年月日は_設定した値と同じ資格取得除外年月日を返す() {
            business = sut.set資格取得除外年月日(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外年月日).build();
            assertThat(business.get資格取得除外年月日(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外年月日));
        }

        @Test
        public void 戻り値の資格取得除外解除年月日は_設定した値と同じ資格取得除外解除年月日を返す() {
            business = sut.set資格取得除外解除年月日(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外解除年月日).build();
            assertThat(business.get資格取得除外解除年月日(), is(DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_資格取得除外解除年月日));
        }

    }
}
