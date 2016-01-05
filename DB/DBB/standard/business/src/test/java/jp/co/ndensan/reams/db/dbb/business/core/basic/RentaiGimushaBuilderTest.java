/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RentaiGimushaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RentaiGimushaBuilderTest extends DbbTestBase {

    private static DbT2009RentaiGimushaEntity RentaiGimushaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static RentaiGimushaBuilder sut;
        private static RentaiGimusha business;

        @Before
        public void setUp() {
            RentaiGimushaEntity = new DbT2009RentaiGimushaEntity();
            RentaiGimushaEntity.setHihokenshaNo(被保険者番号);
            RentaiGimushaEntity.setRirekiNo(履歴番号);

            business = new RentaiGimusha(RentaiGimushaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT2009RentaiGimushaEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            business = sut.set開始年月日(DbT2009RentaiGimushaEntityGenerator.DEFAULT_開始年月日).build();
            assertThat(business.get開始年月日(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の終了年月日は_設定した値と同じ終了年月日を返す() {
            business = sut.set終了年月日(DbT2009RentaiGimushaEntityGenerator.DEFAULT_終了年月日).build();
            assertThat(business.get終了年月日(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_終了年月日));
        }

    }
}
