/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiShichosonCodeHenkanPatternBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiShichosonCodeHenkanPatternBuilderTest extends DbzTestBase {

    private static DbT7024KoikiShichosonCodeHenkanPatternEntity KoikiShichosonCodeHenkanPatternEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 広域内市町村番号;
    private static LasdecCode 市町村コード;
    private static RString コード区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        広域内市町村番号 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
        市町村コード = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
        コード区分 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPatternBuilder sut;
        private static KoikiShichosonCodeHenkanPattern business;

        @Before
        public void setUp() {
            KoikiShichosonCodeHenkanPatternEntity = new DbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPatternEntity.setKoikiShichosonNo(広域内市町村番号);
            KoikiShichosonCodeHenkanPatternEntity.setShichosonCode(市町村コード);
            KoikiShichosonCodeHenkanPatternEntity.setCodeKubun(コード区分);

            business = new KoikiShichosonCodeHenkanPattern(KoikiShichosonCodeHenkanPatternEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の広域内市町村番号は_設定した値と同じ広域内市町村番号を返す() {
            business = sut.set広域内市町村番号(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号).build();
            assertThat(business.get広域内市町村番号(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のコード区分は_設定した値と同じコード区分を返す() {
            business = sut.setコード区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分).build();
            assertThat(business.getコード区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分));
        }

        @Test
        public void 戻り値のコード変換テーブル使用区分は_設定した値と同じコード変換テーブル使用区分を返す() {
            business = sut.setコード変換テーブル使用区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード変換テーブル使用区分).build();
            assertThat(business.getコード変換テーブル使用区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード変換テーブル使用区分));
        }

        @Test
        public void 戻り値の自動採番区分は_設定した値と同じ自動採番区分を返す() {
            business = sut.set自動採番区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_自動採番区分).build();
            assertThat(business.get自動採番区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_自動採番区分));
        }

        @Test
        public void 戻り値の市町村用コード桁数は_設定した値と同じ市町村用コード桁数を返す() {
            business = sut.set市町村用コード桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード桁数).build();
            assertThat(business.get市町村用コード桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード桁数));
        }

        @Test
        public void 戻り値の市町村用コード開始位置は_設定した値と同じ市町村用コード開始位置を返す() {
            business = sut.set市町村用コード開始位置(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード開始位置).build();
            assertThat(business.get市町村用コード開始位置(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード開始位置));
        }

        @Test
        public void 戻り値の市町村用コード使用桁数は_設定した値と同じ市町村用コード使用桁数を返す() {
            business = sut.set市町村用コード使用桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード使用桁数).build();
            assertThat(business.get市町村用コード使用桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用コード使用桁数));
        }

        @Test
        public void 戻り値の市町村用チェックディジット有無区分は_設定した値と同じ市町村用チェックディジット有無区分を返す() {
            business = sut.set市町村用チェックディジット有無区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用チェックディジット有無区分).build();
            assertThat(business.get市町村用チェックディジット有無区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村用チェックディジット有無区分));
        }

        @Test
        public void 戻り値の広域用コード桁数は_設定した値と同じ広域用コード桁数を返す() {
            business = sut.set広域用コード桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード桁数).build();
            assertThat(business.get広域用コード桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード桁数));
        }

        @Test
        public void 戻り値の広域用コード開始位置は_設定した値と同じ広域用コード開始位置を返す() {
            business = sut.set広域用コード開始位置(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード開始位置).build();
            assertThat(business.get広域用コード開始位置(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード開始位置));
        }

        @Test
        public void 戻り値の広域用コード使用桁数は_設定した値と同じ広域用コード使用桁数を返す() {
            business = sut.set広域用コード使用桁数(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード使用桁数).build();
            assertThat(business.get広域用コード使用桁数(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用コード使用桁数));
        }

        @Test
        public void 戻り値の広域用チェックディジット有無区分は_設定した値と同じ広域用チェックディジット有無区分を返す() {
            business = sut.set広域用チェックディジット有無区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用チェックディジット有無区分).build();
            assertThat(business.get広域用チェックディジット有無区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域用チェックディジット有無区分));
        }

        @Test
        public void 戻り値の広域内市町村番号付加区分は_設定した値と同じ広域内市町村番号付加区分を返す() {
            business = sut.set広域内市町村番号付加区分(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号付加区分).build();
            assertThat(business.get広域内市町村番号付加区分(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号付加区分));
        }

    }
}
