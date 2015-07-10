/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.ITsuchishoAtesakiBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.TsuchishoAtesakiSource;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.HihokenshashoB4Builder}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoB4BuilderTest {

    private static HihokenshashoB4Builder sut;
    private static HihokenshashoB4 result;
    private static HihokenshashoB4SourceBuilder builder;
    private static ITsuchishoAtesakiBuilder tsuchishoAtesakiBuilder;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 被保険者証ソースビルダーにnullが渡されたとき_NullPointerExceptionが発生する() {
            builder = null;
            tsuchishoAtesakiBuilder = mock(ITsuchishoAtesakiBuilder.class);
            sut = new HihokenshashoB4Builder(builder, tsuchishoAtesakiBuilder);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 通知書宛先ソースビルダーにnullが渡されたとき_NullPointerExceptionが発生する() {
            builder = build.createHihoshoBuilder(HihokenshashoPrintPosition.上部);
            tsuchishoAtesakiBuilder = null;
            sut = new HihokenshashoB4Builder(builder, tsuchishoAtesakiBuilder);
            fail();
        }
    }

    public static class build extends DbzTestBase {

        @Test
        public void 被保険者証印字位置が上部の場合_被保険者証上部の宛先情報に値が設定される() {
            builder = createHihoshoBuilder(HihokenshashoPrintPosition.上部);
            tsuchishoAtesakiBuilder = createAtesakiBuidler();
            sut = new HihokenshashoB4Builder(builder, tsuchishoAtesakiBuilder);

            result = sut.build();
            assertThat(result.sofusakiAtena1, is(not(nullValue())));
        }

        @Test
        public void 被保険者証印字位置が上部の場合_被保険者証下部の宛先情報には値が設定されない() {
            builder = createHihoshoBuilder(HihokenshashoPrintPosition.上部);
            tsuchishoAtesakiBuilder = createAtesakiBuidler();
            sut = new HihokenshashoB4Builder(builder, tsuchishoAtesakiBuilder);

            result = sut.build();
            assertThat(result.sofusakiAtena2, is(nullValue()));
        }

        @Test
        public void 被保険者証印字位置が下部の場合_被保険者証上部の宛先情報には値が設定されない() {
            builder = createHihoshoBuilder(HihokenshashoPrintPosition.下部);
            tsuchishoAtesakiBuilder = createAtesakiBuidler();
            sut = new HihokenshashoB4Builder(builder, tsuchishoAtesakiBuilder);

            result = sut.build();
            assertThat(result.sofusakiAtena1, is(nullValue()));
        }

        @Test
        public void 被保険者証印字位置が下部の場合_被保険者証下部の宛先情報に値が設定される() {
            builder = createHihoshoBuilder(HihokenshashoPrintPosition.下部);
            tsuchishoAtesakiBuilder = createAtesakiBuidler();
            sut = new HihokenshashoB4Builder(builder, tsuchishoAtesakiBuilder);

            result = sut.build();
            assertThat(result.sofusakiAtena2, is(not(nullValue())));
        }

        private static HihokenshashoB4SourceBuilder createHihoshoBuilder(HihokenshashoPrintPosition position) {
            HihokenshashoB4Editor editor = mock(HihokenshashoB4Editor.class);
            when(editor.edit(any(HihokenshashoB4.class))).thenReturn(new HihokenshashoB4());
            HihokenshashoB4SourceBuilder builder = new HihokenshashoB4SourceBuilder(editor);
            when(builder.buildSource()).thenReturn(new HihokenshashoB4());
            when(builder.get印字位置()).thenReturn(position);
            return builder;
        }

        private static ITsuchishoAtesakiBuilder createAtesakiBuidler() {
            ITsuchishoAtesakiBuilder builder = mock(ITsuchishoAtesakiBuilder.class);
            when(builder.buildSource()).thenReturn(new TsuchishoAtesakiSource());
            return builder;
        }
    }

}
