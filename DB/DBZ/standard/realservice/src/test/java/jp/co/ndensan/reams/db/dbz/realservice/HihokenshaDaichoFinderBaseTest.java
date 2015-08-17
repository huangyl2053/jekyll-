/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link HihokenshaDaichoFinder}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoFinderBaseTest {

    private static HihokenshaDaichoDac dac;
    private static HihokenshaDaichoFinderBase sut;

    @BeforeClass
    public static void test() {
        dac = mock(HihokenshaDaichoDac.class);
        sut = new HihokenshaDaichoFinderBase(dac);
    }

    public static class find被保険者台帳 extends DbaTestBase {

        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
        @Test
        public void Test1() {
        }
    }

    public static class find被保険者台帳List__市町村コード_被保険者番号を引数で受け取る場合 extends DbaTestBase {

        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
        //
        //例：
        //1, 3件のListを返すMockDacを用意。
        //2, MockDacをテスト用コンストラクタに渡して、HihokenshaDaichoFinderのインスタンスを生成。
        //3, get被保険者台帳Listを実行して、3件のListが返るかを確認する。
        @Test
        public void Test1() {
        }
    }

    public static class find被保険者台帳List__市町村コード_識別コードを引数で受け取る場合 extends DbaTestBase {

        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
        @Test
        public void Test1() {
        }
    }

    public static class find被保険者台帳List__市町村コード_被保険者番号_資格取得日を引数で受け取る場合 extends DbaTestBase {

        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
        @Test
        public void Test1() {
        }
    }

    public static class find直近被保険者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            Optional<DbT1001HihokenshaDaichoEntity> 被保険者台帳モデル = Optional.of(createModel());

            when(dac.select最新被保険者台帳(any(HihokenshaNo.class))).thenReturn(被保険者台帳モデル);

            Optional<DbT1001HihokenshaDaichoEntity> 被保険者台帳 = sut.find最新被保険者台帳(
                    DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(被保険者台帳.get().getHihokenshaNo(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }
    }

    private static DbT1001HihokenshaDaichoEntity createModel() {
        return new DbT1001HihokenshaDaichoEntity();
    }

}
