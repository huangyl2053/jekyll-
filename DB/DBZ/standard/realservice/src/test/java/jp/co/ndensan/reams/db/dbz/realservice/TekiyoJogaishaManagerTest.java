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
import jp.co.ndensan.reams.db.dbz.model.TekiyoJogaishaModel;
import jp.co.ndensan.reams.db.dbz.model.helper.TekiyoJogaishaModelTestHelper;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TekiyoJogaishaDac;
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
 * {link TekiyoJogaishaModelManager}のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaManagerTest {

    private static TekiyoJogaishaDac dac;
    private static TekiyoJogaishaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(TekiyoJogaishaDac.class);
        sut = new TekiyoJogaishaManager(dac);
    }

    public static class get適用除外者ModelTest extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_適用除外者Modelが返る() {

            TekiyoJogaishaModel 適用除外者Modelモデル = TekiyoJogaishaModelTestHelper.createModel();

            when(dac.select適用除外者ModelByKey(any(LasdecCode.class), any(ShikibetsuCode.class), any(YMDHMS.class)))
                    .thenReturn(適用除外者Modelモデル);

            Optional<TekiyoJogaishaModel> 適用除外者Model = sut.get適用除外者Model(LasdecCode.EMPTY, ShikibetsuCode.EMPTY, new YMDHMS("20140101000000"));
            assertThat(適用除外者Model.get().get識別コード(), is(適用除外者Modelモデル.get識別コード()));
        }
    }

    public static class get適用除外者情報ListTest extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_適用除外者Modelのリストが返る() {

            List<TekiyoJogaishaModel> 適用除外者Modelモデルリスト = new ArrayList<>();
            適用除外者Modelモデルリスト.add(TekiyoJogaishaModelTestHelper.createModel());
            適用除外者Modelモデルリスト.add(TekiyoJogaishaModelTestHelper.createModel());

            when(dac.select適用除外者List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(適用除外者Modelモデルリスト);

            IItemList<TekiyoJogaishaModel> 適用除外者Modelリスト = sut.get適用除外者情報List(LasdecCode.EMPTY, ShikibetsuCode.EMPTY);

            assertThat(適用除外者Modelリスト.size(), is(2));
            assertThat(適用除外者Modelリスト.toList().get(0).get識別コード(), is(適用除外者Modelモデルリスト.get(0).get識別コード()));
            assertThat(適用除外者Modelリスト.toList().get(1).get識別コード(), is(適用除外者Modelモデルリスト.get(0).get識別コード()));
        }
    }

    public static class save適用除外者Model extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(TekiyoJogaishaModel.class))).thenReturn(1);

            TekiyoJogaishaModel 適用除外者Modelモデル = TekiyoJogaishaModelTestHelper.createModel();

            assertThat(sut.save適用除外者Model(適用除外者Modelモデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(TekiyoJogaishaModel.class))).thenReturn(1);

            TekiyoJogaishaModel 適用除外者Modelモデル = TekiyoJogaishaModelTestHelper.createModel();
            適用除外者Modelモデル.getEntity().initializeMd5();
            適用除外者Modelモデル.set解除年月日(FlexibleDate.MAX);

            assertThat(sut.save適用除外者Model(適用除外者Modelモデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(TekiyoJogaishaModel.class))).thenReturn(1);

            TekiyoJogaishaModel 適用除外者Modelモデル = TekiyoJogaishaModelTestHelper.createModel();
            適用除外者Modelモデル.getEntity().initializeMd5();
            適用除外者Modelモデル.setDeletedState(true);

            assertThat(sut.save適用除外者Model(適用除外者Modelモデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            TekiyoJogaishaModel 適用除外者Modelモデル = TekiyoJogaishaModelTestHelper.createModel();
            適用除外者Modelモデル.getEntity().initializeMd5();

            sut.save適用除外者Model(適用除外者Modelモデル);
        }
    }
}
