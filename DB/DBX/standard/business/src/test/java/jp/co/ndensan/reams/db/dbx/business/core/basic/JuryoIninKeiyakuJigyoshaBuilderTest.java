/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.ServiceShubetsuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JuryoIninKeiyakuJigyoshaBuilder}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class JuryoIninKeiyakuJigyoshaBuilderTest extends DbxTestBase {

    private static DbT7061JuryoIninJigyoshaEntity JuryoIninKeiyakuJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static ServiceShubetsuCode 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号;
        主キー名2 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static JuryoIninKeiyakuJigyoshaBuilder sut;
        private static JuryoIninKeiyakuJigyosha business;

        @Before
        public void setUp() {
            JuryoIninKeiyakuJigyoshaEntity = new DbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);

            business = new JuryoIninKeiyakuJigyosha(JuryoIninKeiyakuJigyoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の受領委任契約事業者番号は_設定した値と同じ受領委任契約事業者番号を返す() {
            business = sut.set受領委任契約事業者番号(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号).build();
            assertThat(business.get受領委任契約事業者番号(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号));
        }

        @Test
        public void 戻り値の受領委任契約開始日は_設定した値と同じ受領委任契約開始日を返す() {
            business = sut.set受領委任契約開始日(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日).build();
            assertThat(business.get受領委任契約開始日(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日));
        }

        @Test
        public void 戻り値の受領委任契約終了日は_設定した値と同じ受領委任契約終了日を返す() {
            business = sut.set受領委任契約終了日(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約終了日).build();
            assertThat(business.get受領委任契約終了日(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約終了日));
        }

        @Test
        public void 戻り値の契約サービス種別は_設定した値と同じ契約サービス種別を返す() {
            business = sut.set契約サービス種別(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約サービス種別).build();
            assertThat(business.get契約サービス種別(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約サービス種別));
        }

        @Test
        public void 戻り値の契約事業者郵便番号は_設定した値と同じ契約事業者郵便番号を返す() {
            business = sut.set契約事業者郵便番号(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者郵便番号).build();
            assertThat(business.get契約事業者郵便番号(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者郵便番号));
        }

        @Test
        public void 戻り値の契約事業者住所は_設定した値と同じ契約事業者住所を返す() {
            business = sut.set契約事業者住所(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者住所).build();
            assertThat(business.get契約事業者住所(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者住所));
        }

        @Test
        public void 戻り値の契約事業者電話番号は_設定した値と同じ契約事業者電話番号を返す() {
            business = sut.set契約事業者電話番号(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者電話番号).build();
            assertThat(business.get契約事業者電話番号(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者電話番号));
        }

        @Test
        public void 戻り値の契約事業者FAX番号は_設定した値と同じ契約事業者FAX番号を返す() {
            business = sut.set契約事業者FAX番号(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者FAX番号).build();
            assertThat(business.get契約事業者FAX番号(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_契約事業者FAX番号));
        }

    }
}
