/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonMasterMapperParameter}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KoseiShichosonMasterMapperParameterTest extends DbzTestBase {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private static RString 主キー1;

// テストクラス名は適切に変更してください
    public static class createSelectByKeyParamテスト extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            KoseiShichosonMasterMapperParameter sut = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            KoseiShichosonMasterMapperParameter sut = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(主キー1);

            assertThat(sut.get主キー1(), is(主キー1));
//            assertThat(sut.uses主キー1(), is(true));
        }
    }

// テストクラス名は適切に変更してください
// 用途に応じたパラメータ生成メソッドのテストクラスを追加してください。
    public static class createSelectListParamテスト extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            KoseiShichosonMasterMapperParameter sut = KoseiShichosonMasterMapperParameter.createSelectListParam(null);
        }

        @Test
        public void 引数にNull意外を指定すると_パラメータが生成できる() {
            KoseiShichosonMasterMapperParameter sut = KoseiShichosonMasterMapperParameter.createSelectListParam(主キー1);

            assertThat(sut.get主キー1(), is(主キー1));
//            assertThat(sut.uses主キー1(), is(true));
        }
    }

}
