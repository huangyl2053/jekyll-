/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.KaigoTeikeibun;
import jp.co.ndensan.reams.db.dbz.business.helper.KaigoTeikeibunMock;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.TeikeibunJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 定型文情報マッパークラスのテストクラスです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class KaigoTeikeibunMapperTest extends DbzTestBase {

    public static class to定型文情報 extends DbzTestBase {

        private final DbT7103TeikeibunJohoEntity entity
                = TeikeibunJohoEntityMock.create定型文情報Entity();
        private KaigoTeikeibun sut;

        @Before
        public void setUp() {
            sut = KaigoTeikeibunMapper.toKaigoTeikeibun(entity);
        }

        @Test
        public void 定型文情報entityに_nullを設定した時_nullを返す() {
            sut = KaigoTeikeibunMapper.toKaigoTeikeibun(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void get区分が_Entityの区分と同一になる() {
            assertThat(sut.get区分(), is(entity.getTeikeiKubun()));
        }

        @Test
        public void get種別が_Entityの種別と同一になる() {
            assertThat(sut.get種別(), is(entity.getShubetsu()));
        }

        @Test
        public void getコードが_Entityのコードと同一になる() {
            assertThat(sut.getコード(), is(entity.getTeikeibunCd()));
        }

        @Test
        public void get内容が_Entityの内容と同一になる() {
            assertThat(sut.get内容(), is(entity.getTeikeibunNaiyo()));
        }
    }

    public static class to定型文情報Entity extends DbzTestBase {

        private DbT7103TeikeibunJohoEntity sut;
        private final KaigoTeikeibun 介護定型文 = KaigoTeikeibunMock.create介護定型文();

        @Before
        public void setUp() {
            sut = KaigoTeikeibunMapper.toKaigoTeikeibunEntity(介護定型文);
        }

        @Test
        public void 引数にnullが渡された時_nullを返す() {
            sut = KaigoTeikeibunMapper.toKaigoTeikeibunEntity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void Entityの区分と_介護定型文の区分が同一になる() {
            assertThat(sut.getTeikeiKubun(), is(介護定型文.get区分()));
        }

        @Test
        public void Entityの種別と_介護定型文の種別が同一になる() {
            assertThat(sut.getShubetsu(), is(介護定型文.get種別()));
        }

        @Test
        public void Entityのコードと_介護定型文のコードが同一になる() {
            assertThat(sut.getTeikeibunCd(), is(介護定型文.getコード()));
        }

        @Test
        public void Entityの内容と_介護定型文の内容が同一になる() {
            assertThat(sut.getTeikeibunNaiyo(), is(介護定型文.get内容()));
        }
    }
}
