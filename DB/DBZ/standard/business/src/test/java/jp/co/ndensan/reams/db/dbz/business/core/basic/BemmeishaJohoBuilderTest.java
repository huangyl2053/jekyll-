/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link BemmeishaJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class BemmeishaJohoBuilderTest extends DbzTestBase {

    private static DbT7003BemmeishaJohoEntity BemmeishaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 主キー名1;
    private static ShikibetsuCode 主キー名2;
    private static HihokenshaNo 主キー名3;
    private static FlexibleDate 主キー名4;
    private static FlexibleDate 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static BemmeishaJohoBuilder sut;
        private static BemmeishaJoho business;

        @Before
        public void setUp() {
            BemmeishaJohoEntity = new DbT7003BemmeishaJohoEntity();
            BemmeishaJohoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeishaJohoEntity.setShikibetsuCode(主キー名2);

            business = new BemmeishaJoho(BemmeishaJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の原処分被保険者番号は_設定した値と同じ原処分被保険者番号を返す() {
            business = sut.set原処分被保険者番号(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_原処分被保険者番号).build();
            assertThat(business.get原処分被保険者番号(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_原処分被保険者番号));
        }

        @Test
        public void 戻り値の審査請求届出日は_設定した値と同じ審査請求届出日を返す() {
            business = sut.set審査請求届出日(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_審査請求届出日).build();
            assertThat(business.get審査請求届出日(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_審査請求届出日));
        }

        @Test
        public void 戻り値の弁明書作成日は_設定した値と同じ弁明書作成日を返す() {
            business = sut.set弁明書作成日(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明書作成日).build();
            assertThat(business.get弁明書作成日(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明書作成日));
        }

        @Test
        public void 戻り値の弁明者枝番は_設定した値と同じ弁明者枝番を返す() {
            business = sut.set弁明者枝番(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者枝番).build();
            assertThat(business.get弁明者枝番(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者枝番));
        }

        @Test
        public void 戻り値の職員コードは_設定した値と同じ職員コードを返す() {
            business = sut.set職員コード(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_職員コード).build();
            assertThat(business.get職員コード(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_職員コード));
        }

        @Test
        public void 戻り値の部署コードは_設定した値と同じ部署コードを返す() {
            business = sut.set部署コード(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_部署コード).build();
            assertThat(business.get部署コード(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_部署コード));
        }

        @Test
        public void 戻り値の役職名は_設定した値と同じ役職名を返す() {
            business = sut.set役職名(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_役職名).build();
            assertThat(business.get役職名(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_役職名));
        }

        @Test
        public void 戻り値の弁明者氏名は_設定した値と同じ弁明者氏名を返す() {
            business = sut.set弁明者氏名(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者氏名).build();
            assertThat(business.get弁明者氏名(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者氏名));
        }

    }
}
