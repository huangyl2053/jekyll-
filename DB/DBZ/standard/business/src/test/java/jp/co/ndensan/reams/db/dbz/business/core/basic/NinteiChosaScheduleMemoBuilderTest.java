/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiChosaScheduleMemoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiChosaScheduleMemoBuilderTest extends DbzTestBase {

    private static DbT5222NinteiChosaScheduleMemoEntity NinteiChosaScheduleMemoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate メモ年月日;
    private static Code メモ区分;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        メモ年月日 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ年月日;
        メモ区分 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ区分;
        連番 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_連番;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteiChosaScheduleMemoBuilder sut;
        private static NinteiChosaScheduleMemo business;

        @Before
        public void setUp() {
            NinteiChosaScheduleMemoEntity = new DbT5222NinteiChosaScheduleMemoEntity();

            business = new NinteiChosaScheduleMemo(NinteiChosaScheduleMemoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のメモ年月日は_設定した値と同じメモ年月日を返す() {
            business = sut.setメモ年月日(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ年月日).build();
            assertThat(business.getメモ年月日(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ年月日));
        }

        @Test
        public void 戻り値の調査地区コードは_設定した値と同じ調査地区コードを返す() {
            business = sut.set調査地区コード(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_調査地区コード).build();
            assertThat(business.get調査地区コード(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_調査地区コード));
        }

        @Test
        public void 戻り値のメモ区分は_設定した値と同じメモ区分を返す() {
            business = sut.setメモ区分(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ区分).build();
            assertThat(business.getメモ区分(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ区分));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_連番).build();
//            assertThat(business.get連番(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_連番));
            assertThat(business.get連番(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値のメモ指定調査地区コードは_設定した値と同じメモ指定調査地区コードを返す() {
            business = sut.setメモ指定調査地区コード(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ指定調査地区コード).build();
            assertThat(business.getメモ指定調査地区コード(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ指定調査地区コード));
        }

        @Test
        public void 戻り値の作成者は_設定した値と同じ作成者を返す() {
            business = sut.set作成者(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_作成者).build();
            assertThat(business.get作成者(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_作成者));
        }

        @Test
        public void 戻り値のメモ重要度は_設定した値と同じメモ重要度を返す() {
            business = sut.setメモ重要度(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ重要度).build();
            assertThat(business.getメモ重要度(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ重要度));
        }

        @Test
        public void 戻り値のメモ内容は_設定した値と同じメモ内容を返す() {
            business = sut.setメモ内容(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ内容).build();
            assertThat(business.getメモ内容(), is(DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ内容));
        }

    }
}
