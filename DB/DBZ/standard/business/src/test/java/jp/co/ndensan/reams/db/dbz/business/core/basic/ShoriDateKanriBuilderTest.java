/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanriBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShoriDateKanriBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoriDateKanriBuilderTest extends DbzTestBase {

    private static DbT7022ShoriDateKanriEntity ShoriDateKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode サブ業務コード;
    private static LasdecCode 市町村コード;
    private static RString 処理名;
    private static RString 処理枝番;
    private static FlexibleYear 年度;
    private static RString 年度内連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        サブ業務コード = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード;
        市町村コード = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード;
        処理名 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名;
        処理枝番 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番;
        年度 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度;
        年度内連番 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShoriDateKanriBuilder sut;
        private static ShoriDateKanri business;

        @Before
        public void setUp() {
            ShoriDateKanriEntity = new DbT7022ShoriDateKanriEntity();
            ShoriDateKanriEntity.setSubGyomuCode(サブ業務コード);
            ShoriDateKanriEntity.setShichosonCode(市町村コード);
            ShoriDateKanriEntity.setShoriName(処理名);
            ShoriDateKanriEntity.setShoriEdaban(処理枝番);
            ShoriDateKanriEntity.setNendo(年度);
            ShoriDateKanriEntity.setNendoNaiRenban(年度内連番);

            business = new ShoriDateKanri(ShoriDateKanriEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
            business = sut.setサブ業務コード(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード).build();
            assertThat(business.getサブ業務コード(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の処理名は_設定した値と同じ処理名を返す() {
            business = sut.set処理名(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名).build();
            assertThat(business.get処理名(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名));
        }

        @Test
        public void 戻り値の処理枝番は_設定した値と同じ処理枝番を返す() {
            business = sut.set処理枝番(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番).build();
            assertThat(business.get処理枝番(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番));
        }

        @Test
        public void 戻り値の年度は_設定した値と同じ年度を返す() {
            business = sut.set年度(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度).build();
            assertThat(business.get年度(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度));
        }

        @Test
        public void 戻り値の年度内連番は_設定した値と同じ年度内連番を返す() {
            business = sut.set年度内連番(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番).build();
            assertThat(business.get年度内連番(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番));
        }

        @Test
        public void 戻り値の基準年月日は_設定した値と同じ基準年月日を返す() {
            business = sut.set基準年月日(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_基準年月日).build();
            assertThat(business.get基準年月日(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_基準年月日));
        }

        @Test
        public void 戻り値の基準日時は_設定した値と同じ基準日時を返す() {
            business = sut.set基準日時(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_基準日時).build();
            assertThat(business.get基準日時(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_基準日時));
        }

        @Test
        public void 戻り値の対象開始年月日は_設定した値と同じ対象開始年月日を返す() {
            business = sut.set対象開始年月日(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始年月日).build();
            assertThat(business.get対象開始年月日(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始年月日));
        }

        @Test
        public void 戻り値の対象終了年月日は_設定した値と同じ対象終了年月日を返す() {
            business = sut.set対象終了年月日(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了年月日).build();
            assertThat(business.get対象終了年月日(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了年月日));
        }

        @Test
        public void 戻り値の対象開始日時は_設定した値と同じ対象開始日時を返す() {
            business = sut.set対象開始日時(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始日時).build();
            assertThat(business.get対象開始日時(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象開始日時));
        }

        @Test
        public void 戻り値の対象終了日時は_設定した値と同じ対象終了日時を返す() {
            business = sut.set対象終了日時(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了日時).build();
            assertThat(business.get対象終了日時(), is(DbT7022ShoriDateKanriEntityGenerator.DEFAULT_対象終了日時));
        }

    }
}
