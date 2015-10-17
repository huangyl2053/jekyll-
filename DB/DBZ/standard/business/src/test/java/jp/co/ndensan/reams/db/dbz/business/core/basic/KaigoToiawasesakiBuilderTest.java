/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoToiawasesakiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoToiawasesakiBuilderTest extends DbzTestBase {

    private static DbT7069KaigoToiawasesakiEntity KaigoToiawasesakiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode サブ業務コード;
    private static ReportId 帳票分類ID;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        サブ業務コード = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
        帳票分類ID = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoToiawasesakiBuilder sut;
        private static KaigoToiawasesaki business;

        @Before
        public void setUp() {
            KaigoToiawasesakiEntity = new DbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesakiEntity.setSubGyomuCode(サブ業務コード);
            KaigoToiawasesakiEntity.setChohyoBunruiID(帳票分類ID);

            business = new KaigoToiawasesaki(KaigoToiawasesakiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
            business = sut.setサブ業務コード(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード).build();
            assertThat(business.getサブ業務コード(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード));
        }

        @Test
        public void 戻り値の帳票分類IDは_設定した値と同じ帳票分類IDを返す() {
            business = sut.set帳票分類ID(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID).build();
            assertThat(business.get帳票分類ID(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の所在地は_設定した値と同じ所在地を返す() {
            business = sut.set所在地(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_所在地).build();
            assertThat(business.get所在地(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_所在地));
        }

        @Test
        public void 戻り値の庁舎名は_設定した値と同じ庁舎名を返す() {
            business = sut.set庁舎名(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_庁舎名).build();
            assertThat(business.get庁舎名(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_庁舎名));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値の内線番号は_設定した値と同じ内線番号を返す() {
            business = sut.set内線番号(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_内線番号).build();
            assertThat(business.get内線番号(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_内線番号));
        }

        @Test
        public void 戻り値の部署名は_設定した値と同じ部署名を返す() {
            business = sut.set部署名(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_部署名).build();
            assertThat(business.get部署名(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_部署名));
        }

        @Test
        public void 戻り値の担当者名は_設定した値と同じ担当者名を返す() {
            business = sut.set担当者名(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_担当者名).build();
            assertThat(business.get担当者名(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_担当者名));
        }

    }
}
