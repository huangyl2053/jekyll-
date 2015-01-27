/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.model.helper.TashichosonJushochiTokureiModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.TashichosonJushochiTokureiModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link TashichosonJushochiTokureiModelManager}のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiManagerTest {

    private static TashichosonJushochiTokureiDac dac;
    private static TashichosonJushochiTokureiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(TashichosonJushochiTokureiDac.class);
        sut = new TashichosonJushochiTokureiManager(dac);
    }

    public static class get他市町村住所地特例ModelTest extends DbzTestBase {

        // TODO 主キー型と変数名と主キー値を適切な値に置換してください
        // TODO 主キーの数が足りない場合、追加してください。
        @Test
        public void データが見つかる検索条件を指定した場合_他市町村住所地特例Modelが返る() {

            TashichosonJushochiTokureiModel 他市町村住所地特例Modelモデル = TashichosonJushochiTokureiModelTestHelper.createModel();

            when(dac.select他市町村住所地特例ModelByKey(any(LasdecCode.class), any(ShikibetsuCode.class), any(YMDHMS.class)))
                    .thenReturn(他市町村住所地特例Modelモデル);

            Optional<TashichosonJushochiTokureiModel> 他市町村住所地特例Model = sut.get他市町村住所地特例Model(LasdecCode.EMPTY, ShikibetsuCode.EMPTY, new YMDHMS("20140101000000"));

            assertThat(他市町村住所地特例Model.get().get識別コード(), is(他市町村住所地特例Modelモデル.get識別コード()));
        }
    }

    public static class get他市町村住所地特例Model一覧By主キー1Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_他市町村住所地特例Modelのリストが返る() {

            List<TashichosonJushochiTokureiModel> 他市町村住所地特例Modelモデルリスト = new ArrayList<>();
            他市町村住所地特例Modelモデルリスト.add(TashichosonJushochiTokureiModelTestHelper.createModel());
            他市町村住所地特例Modelモデルリスト.add(TashichosonJushochiTokureiModelTestHelper.createModel());

            when(dac.select他市町村住所地特例List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(他市町村住所地特例Modelモデルリスト);

            IItemList<TashichosonJushochiTokureiModel> 他市町村住所地特例Modelリスト = sut.get他市町村住所地特例List(LasdecCode.EMPTY, ShikibetsuCode.EMPTY);

            assertThat(他市町村住所地特例Modelリスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(他市町村住所地特例Modelリスト.toList().get(0).get識別コード(),
                    is(他市町村住所地特例Modelモデルリスト.get(0).get識別コード()));
            assertThat(他市町村住所地特例Modelリスト.toList().get(1).get識別コード(),
                    is(他市町村住所地特例Modelモデルリスト.get(1).get識別コード()));
        }
    }

    public static class save他市町村住所地特例Model extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(TashichosonJushochiTokureiModel.class))).thenReturn(1);

            TashichosonJushochiTokureiModel 他市町村住所地特例Modelモデル = TashichosonJushochiTokureiModelTestHelper.createModel();

            assertThat(sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(TashichosonJushochiTokureiModel.class))).thenReturn(1);

            TashichosonJushochiTokureiModel 他市町村住所地特例Modelモデル = TashichosonJushochiTokureiModelTestHelper.createModel();
            他市町村住所地特例Modelモデル.getEntity().initializeMd5();
            他市町村住所地特例Modelモデル.set解除年月日(FlexibleDate.MAX);

            assertThat(sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(TashichosonJushochiTokureiModel.class))).thenReturn(1);

            TashichosonJushochiTokureiModel 他市町村住所地特例Modelモデル = TashichosonJushochiTokureiModelTestHelper.createModel();
            他市町村住所地特例Modelモデル.getEntity().initializeMd5();
            他市町村住所地特例Modelモデル.setDeletedState(true);

            assertThat(sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            TashichosonJushochiTokureiModel 他市町村住所地特例Modelモデル = TashichosonJushochiTokureiModelTestHelper.createModel();
            他市町村住所地特例Modelモデル.getEntity().initializeMd5();

            sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル);
        }
    }
}
