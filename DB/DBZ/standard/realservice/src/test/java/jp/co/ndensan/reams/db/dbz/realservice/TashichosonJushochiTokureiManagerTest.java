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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link DbT1003TashichosonJushochiTokureiEntityManager}のテストクラスです。
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

            DbT1003TashichosonJushochiTokureiEntity 他市町村住所地特例Modelモデル = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();

            when(dac.select他市町村住所地特例ModelByKey(any(ShikibetsuCode.class), any(FlexibleDate.class), any(RString.class)))
                    .thenReturn(他市町村住所地特例Modelモデル);

            Optional<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例Model = sut.get他市町村住所地特例Model(ShikibetsuCode.EMPTY, FlexibleDate.EMPTY, new RString(""));

            assertThat(他市町村住所地特例Model.get().getShikibetsuCode(), is(他市町村住所地特例Modelモデル.getShikibetsuCode()));
        }
    }

    public static class get他市町村住所地特例Model一覧By主キー1Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_他市町村住所地特例Modelのリストが返る() {

            List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例Modelモデルリスト = new ArrayList<>();
            他市町村住所地特例Modelモデルリスト.add(DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity());
            他市町村住所地特例Modelモデルリスト.add(DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity());

            when(dac.select他市町村住所地特例List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(他市町村住所地特例Modelモデルリスト);

            IItemList<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例Modelリスト = sut.get他市町村住所地特例List(LasdecCode.EMPTY, ShikibetsuCode.EMPTY);

            assertThat(他市町村住所地特例Modelリスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(他市町村住所地特例Modelリスト.toList().get(0).getShikibetsuCode(),
                    is(他市町村住所地特例Modelモデルリスト.get(0).getShikibetsuCode()));
            assertThat(他市町村住所地特例Modelリスト.toList().get(1).getShikibetsuCode(),
                    is(他市町村住所地特例Modelモデルリスト.get(1).getShikibetsuCode()));
        }
    }

    public static class save他市町村住所地特例Model extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT1003TashichosonJushochiTokureiEntity.class))).thenReturn(1);

            DbT1003TashichosonJushochiTokureiEntity 他市町村住所地特例Modelモデル = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();

            assertThat(sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT1003TashichosonJushochiTokureiEntity.class))).thenReturn(1);

            DbT1003TashichosonJushochiTokureiEntity 他市町村住所地特例Modelモデル = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            他市町村住所地特例Modelモデル.initializeMd5();
            他市町村住所地特例Modelモデル.setKaijoYMD(FlexibleDate.MAX);

            assertThat(sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT1003TashichosonJushochiTokureiEntity.class))).thenReturn(1);

            DbT1003TashichosonJushochiTokureiEntity 他市町村住所地特例Modelモデル = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            他市町村住所地特例Modelモデル.initializeMd5();
            他市町村住所地特例Modelモデル.setIsDeleted(true);

            assertThat(sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            DbT1003TashichosonJushochiTokureiEntity 他市町村住所地特例Modelモデル = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            他市町村住所地特例Modelモデル.initializeMd5();

            sut.save他市町村住所地特例Model(他市町村住所地特例Modelモデル);
        }
    }
}
