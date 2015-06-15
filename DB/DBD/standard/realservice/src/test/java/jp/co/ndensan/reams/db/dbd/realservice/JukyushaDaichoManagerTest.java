/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * * {link JukyushaDaichoManager}のテストクラスです。
 *
 * @author n8235 船山洋介
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoManagerTest {

    private static DbT4001JukyushaDaichoDac dac;
    private static JukyushaDaichoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT4001JukyushaDaichoDac.class);
        sut = new JukyushaDaichoManager(dac);
    }

    public static class get受給者台帳Test extends DbdTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_受給者台帳が返る() {

            DbT4001JukyushaDaichoEntity 受給者台帳モデル = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();

            when(dac.selectByKey(any(LasdecCode.class), any(HihokenshaNo.class), any(RString.class), any(RString.class), any(Code.class))).thenReturn(受給者台帳モデル);

            Optional<JukyushaDaicho> 受給者台帳 = sut.get受給者台帳(
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード,
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号,
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号,
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_枝番,
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(受給者台帳.get().getデータ区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_データ区分));
        }
    }

    public static class get受給者台帳一覧Test extends DbdTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_受給者台帳のリストが返る() {

            List<DbT4001JukyushaDaichoEntity> 受給者台帳エンティティリスト = new ArrayList<>();
            受給者台帳エンティティリスト.add(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            when(dac.selectAll()).thenReturn(受給者台帳エンティティリスト);

            IItemList<JukyushaDaicho> 受給者台帳リスト = sut.get受給者台帳一覧();

            assertThat(受給者台帳リスト.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(受給者台帳リスト.toList().get(0).get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class get受給者台帳履歴Test extends DbdTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_受給者台帳のリストが返る() {

            List<DbT4001JukyushaDaichoEntity> 受給者台帳エンティティリスト = new ArrayList<>();
            受給者台帳エンティティリスト.add(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            when(dac.select受給者台帳履歴By被保険者番号(any(HihokenshaNo.class))).thenReturn(受給者台帳エンティティリスト);

            IItemList<JukyushaDaicho> 受給者台帳リスト = sut.get受給者台帳履歴(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号);

            assertThat(受給者台帳リスト.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(受給者台帳リスト.toList().get(0).get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class save受給者台帳 extends DbdTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(1);

            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            assertThat(sut.save受給者台帳(受給者台帳), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(1);

            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
            受給者台帳.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            受給者台帳.set支給限度単位数(new Decimal("20"));

            assertThat(sut.save受給者台帳(受給者台帳), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT4001JukyushaDaichoEntity.class))).thenReturn(1);

            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
            受給者台帳.getEntity().initializeMd5();
            受給者台帳.setDeletedState(true);

            assertThat(sut.save受給者台帳(受給者台帳), is(1));
        }

        @Test(expected = IllegalArgumentException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            JukyushaDaicho 受給者台帳 = new JukyushaDaicho(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
            受給者台帳.getEntity().initializeMd5();

            sut.save受給者台帳(受給者台帳);
        }
    }

}
