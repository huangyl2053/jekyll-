/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.helper.HihokenshaShikakuMock;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * HihokenshaMapperのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaMapperTest extends DbzTestBase {

    private static HihokenshaMapper sut;

    public static class ToHihokensha extends DbzTestBase {

        private IKojin profile;
        private DbT1001HihokenshaDaichoEntity entity;
        private Hihokensha converted;

        @Before
        public void setUp() {
            profile = mock(IKojin.class);
            entity = DbT1001HihokenshaDaichoEntityMock.getSpiedInstance();
        }

        @Test
        public void コンストラクタは_引数のIKojinがnullのとき_nullを返す() {
            converted = sut.toHihokensha(null, entity);
            assertThat(converted, is(nullValue()));
        }

        @Test
        public void コンストラクタは_引数のDbT1001HihokenshaDaichoEntityがnullのとき_nullを返す() {
            converted = sut.toHihokensha(profile, null);
            assertThat(converted, is(nullValue()));
        }

        @Test
        public void コンストラクタは_引数のどちらもnullではないとき_Hihokenshaを返す() {
            converted = sut.toHihokensha(profile, entity);
            assertThat(converted, is(instanceOf(Hihokensha.class)));
        }
    }
}
