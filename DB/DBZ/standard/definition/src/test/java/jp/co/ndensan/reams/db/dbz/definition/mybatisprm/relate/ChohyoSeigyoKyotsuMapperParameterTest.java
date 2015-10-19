/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ChohyoSeigyoKyotsuMapperParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoSeigyoKyotsuMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuMapperParameterTest extends DbzTestBase {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private static SubGyomuCode 主キー1;
    private static ReportId 主キー2;

// テストクラス名は適切に変更してください
    public static class createSelectByKeyParamテスト extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            ChohyoSeigyoKyotsuMapperParameter sut = ChohyoSeigyoKyotsuMapperParameter.createSelectByKeyParam(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー2にNullを指定すると_NullPointerExceptionが発生する() {
            ChohyoSeigyoKyotsuMapperParameter sut = ChohyoSeigyoKyotsuMapperParameter.createSelectByKeyParam(主キー1, null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            ChohyoSeigyoKyotsuMapperParameter sut = ChohyoSeigyoKyotsuMapperParameter.createSelectByKeyParam(主キー1, 主キー2);

            assertThat(sut.get主キー1().value(), is(主キー1.value()));
            assertThat(sut.get主キー2(), is(主キー2));
//            assertThat(sut.uses主キー1(), is(true));
//            assertThat(sut.uses主キー2(), is(true));
        }
    }

// テストクラス名は適切に変更してください
// 用途に応じたパラメータ生成メソッドのテストクラスを追加してください。
    public static class createSelectListParamテスト extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            ChohyoSeigyoKyotsuMapperParameter sut = ChohyoSeigyoKyotsuMapperParameter.createSelectListParam(null);
        }

        @Test
        public void 引数にNull意外を指定すると_パラメータが生成できる() {
            ChohyoSeigyoKyotsuMapperParameter sut = ChohyoSeigyoKyotsuMapperParameter.createSelectListParam(主キー1);

            assertThat(sut.get主キー1().value(), is(主キー1.value()));
//            assertThat(sut.uses主キー1(), is(true));
//            assertThat(sut.uses主キー2(), is(false));
        }
    }

}
