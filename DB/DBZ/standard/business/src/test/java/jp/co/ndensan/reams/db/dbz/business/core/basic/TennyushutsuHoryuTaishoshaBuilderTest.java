/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishoshaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
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
 * {@link TennyushutsuHoryuTaishoshaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TennyushutsuHoryuTaishoshaBuilderTest extends DbzTestBase {

    private static DbT1010TennyushutsuHoryuTaishoshaEntity TennyushutsuHoryuTaishoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static TennyushutsuHoryuTaishoshaBuilder sut;
        private static TennyushutsuHoryuTaishosha business;

        @Before
        public void setUp() {
            TennyushutsuHoryuTaishoshaEntity = new DbT1010TennyushutsuHoryuTaishoshaEntity();
            TennyushutsuHoryuTaishoshaEntity.setXXX(主キー名1);
            TennyushutsuHoryuTaishoshaEntity.setXXX(主キー名2);

            business = new TennyushutsuHoryuTaishosha(TennyushutsuHoryuTaishoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の作成事由コードは_設定した値と同じ作成事由コードを返す() {
            business = sut.set作成事由コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_作成事由コード).build();
            assertThat(business.get作成事由コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_作成事由コード));
        }

        @Test
        public void 戻り値の世帯コードは_設定した値と同じ世帯コードを返す() {
            business = sut.set世帯コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_世帯コード).build();
            assertThat(business.get世帯コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_世帯コード));
        }

        @Test
        public void 戻り値の住民種別コードは_設定した値と同じ住民種別コードを返す() {
            business = sut.set住民種別コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_住民種別コード).build();
            assertThat(business.get住民種別コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_住民種別コード));
        }

        @Test
        public void 戻り値の住民状態コードは_設定した値と同じ住民状態コードを返す() {
            business = sut.set住民状態コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_住民状態コード).build();
            assertThat(business.get住民状態コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_住民状態コード));
        }

        @Test
        public void 戻り値の宛名氏名は_設定した値と同じ宛名氏名を返す() {
            business = sut.set宛名氏名(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_宛名氏名).build();
            assertThat(business.get宛名氏名(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_宛名氏名));
        }

        @Test
        public void 戻り値の宛名カナ氏名は_設定した値と同じ宛名カナ氏名を返す() {
            business = sut.set宛名カナ氏名(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_宛名カナ氏名).build();
            assertThat(business.get宛名カナ氏名(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_宛名カナ氏名));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            business = sut.set生年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_生年月日).build();
            assertThat(business.get生年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            business = sut.set性別コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_性別コード).build();
            assertThat(business.get性別コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の異動事由コードは_設定した値と同じ異動事由コードを返す() {
            business = sut.set異動事由コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_異動事由コード).build();
            assertThat(business.get異動事由コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_異動事由コード));
        }

        @Test
        public void 戻り値の登録異動年月日は_設定した値と同じ登録異動年月日を返す() {
            business = sut.set登録異動年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_登録異動年月日).build();
            assertThat(business.get登録異動年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_登録異動年月日));
        }

        @Test
        public void 戻り値の登録届出年月日は_設定した値と同じ登録届出年月日を返す() {
            business = sut.set登録届出年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_登録届出年月日).build();
            assertThat(business.get登録届出年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_登録届出年月日));
        }

        @Test
        public void 戻り値の消除異動年月日は_設定した値と同じ消除異動年月日を返す() {
            business = sut.set消除異動年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_消除異動年月日).build();
            assertThat(business.get消除異動年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_消除異動年月日));
        }

        @Test
        public void 戻り値の消除届出年月日は_設定した値と同じ消除届出年月日を返す() {
            business = sut.set消除届出年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_消除届出年月日).build();
            assertThat(business.get消除届出年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_消除届出年月日));
        }

        @Test
        public void 戻り値の転出予定異動年月日は_設定した値と同じ転出予定異動年月日を返す() {
            business = sut.set転出予定異動年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定異動年月日).build();
            assertThat(business.get転出予定異動年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定異動年月日));
        }

        @Test
        public void 戻り値の転出確定異動年月日は_設定した値と同じ転出確定異動年月日を返す() {
            business = sut.set転出確定異動年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定異動年月日).build();
            assertThat(business.get転出確定異動年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定異動年月日));
        }

        @Test
        public void 戻り値の転出確定異動通知年月日は_設定した値と同じ転出確定異動通知年月日を返す() {
            business = sut.set転出確定異動通知年月日(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定異動通知年月日).build();
            assertThat(business.get転出確定異動通知年月日(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定異動通知年月日));
        }

        @Test
        public void 戻り値の全国住所コードは_設定した値と同じ全国住所コードを返す() {
            business = sut.set全国住所コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_全国住所コード).build();
            assertThat(business.get全国住所コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_全国住所コード));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            business = sut.set住所(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_住所).build();
            assertThat(business.get住所(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の番地は_設定した値と同じ番地を返す() {
            business = sut.set番地(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_番地).build();
            assertThat(business.get番地(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_番地));
        }

        @Test
        public void 戻り値の方書は_設定した値と同じ方書を返す() {
            business = sut.set方書(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_方書).build();
            assertThat(business.get方書(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_方書));
        }

        @Test
        public void 戻り値の転出予定全国住所コードは_設定した値と同じ転出予定全国住所コードを返す() {
            business = sut.set転出予定全国住所コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定全国住所コード).build();
            assertThat(business.get転出予定全国住所コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定全国住所コード));
        }

        @Test
        public void 戻り値の転出予定住所は_設定した値と同じ転出予定住所を返す() {
            business = sut.set転出予定住所(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定住所).build();
            assertThat(business.get転出予定住所(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定住所));
        }

        @Test
        public void 戻り値の転出予定番地は_設定した値と同じ転出予定番地を返す() {
            business = sut.set転出予定番地(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定番地).build();
            assertThat(business.get転出予定番地(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定番地));
        }

        @Test
        public void 戻り値の転出予定方書は_設定した値と同じ転出予定方書を返す() {
            business = sut.set転出予定方書(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定方書).build();
            assertThat(business.get転出予定方書(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出予定方書));
        }

        @Test
        public void 戻り値の転出確定全国住所コードは_設定した値と同じ転出確定全国住所コードを返す() {
            business = sut.set転出確定全国住所コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定全国住所コード).build();
            assertThat(business.get転出確定全国住所コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定全国住所コード));
        }

        @Test
        public void 戻り値の転出確定住所は_設定した値と同じ転出確定住所を返す() {
            business = sut.set転出確定住所(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定住所).build();
            assertThat(business.get転出確定住所(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定住所));
        }

        @Test
        public void 戻り値の転出確定番地は_設定した値と同じ転出確定番地を返す() {
            business = sut.set転出確定番地(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定番地).build();
            assertThat(business.get転出確定番地(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定番地));
        }

        @Test
        public void 戻り値の転出確定方書は_設定した値と同じ転出確定方書を返す() {
            business = sut.set転出確定方書(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定方書).build();
            assertThat(business.get転出確定方書(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_転出確定方書));
        }

    }
}
