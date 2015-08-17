/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatis.param.relate;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaMapperParameterTest extends DbbTestBase {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private static final FlexibleYear 主キー1 = new FlexibleYear("1990");
    private static final FlexibleYear 主キー2 = new FlexibleYear("2001");

// テストクラス名は適切に変更してください
    public static class createSelectByKeyParamテスト extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            FukaMapperParameter sut = FukaMapperParameter.createSelectByKeyParam(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー2にNullを指定すると_NullPointerExceptionが発生する() {
            FukaMapperParameter sut = FukaMapperParameter.createSelectByKeyParam(主キー1, null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            FukaMapperParameter sut = FukaMapperParameter.createSelectByKeyParam(主キー1, 主キー2);

            assertThat(sut.get主キー1(), is(主キー1));
            assertThat(sut.get主キー2(), is(主キー2));
//            assertThat(sut.uses主キー1(), is(true));
//            assertThat(sut.uses主キー2(), is(true));
        }
    }

// テストクラス名は適切に変更してください
// 用途に応じたパラメータ生成メソッドのテストクラスを追加してください。
    public static class createSelectListParamテスト extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            FukaMapperParameter sut = FukaMapperParameter.createSelectListParam(null);
        }

        @Test
        public void 引数にNull意外を指定すると_パラメータが生成できる() {
            FukaMapperParameter sut = FukaMapperParameter.createSelectListParam(主キー1);

            assertThat(sut.get主キー1(), is(主キー1));
//            assertThat(sut.uses主キー1(), is(true));
//            assertThat(sut.uses主キー2(), is(false));
        }
    }

}
