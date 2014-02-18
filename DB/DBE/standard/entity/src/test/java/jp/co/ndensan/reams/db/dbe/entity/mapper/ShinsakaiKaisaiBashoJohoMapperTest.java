/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoChikuCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbztesthelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ShinsakaiKaisaiBashoJohoMapperのテストクラスです
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoJohoMapperTest extends DbeTestBase {

    public static class toShinsakaiKaisaiBashoのテスト extends DbeTestBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private RString 開催場所名称;
        private ShinsakaiKaisaiBashoChikuCode 開催場所地区コード;
        private RString 開催場所住所;
        private RString 開催場所電話番号;
        private ShinsakaiKaisaiBashoJokyo 開催場所状況;
        private ShinsakaiKaisaiBasho sut;

        @Override
        public void setUp() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            開催場所名称 = new RString("市役所会議室");
            開催場所地区コード = new ShinsakaiKaisaiBashoChikuCode(new RString("00001"));
            開催場所住所 = new RString("長野市鶴賀");
            開催場所電話番号 = new RString("0262362222");
            開催場所状況 = 開催場所状況.有効;
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(create審査会開催場所情報Entity());

        }

        @Test
        public void 引き渡した開催場所コードとtoShinsakaiKaisaiBashoの結果は一致する() {
            assertThat(sut.get開催場所コード(), is(開催場所コード));
        }

        @Test
        public void 引き渡した開催場所名称とtoShinsakaiKaisaiBashoの結果は一致する() {
            assertThat(sut.get開催場所名称(), is(開催場所名称));
        }

        @Test
        public void 引き渡した開催場所地区コードとtoShinsakaiKaisaiBashoの結果は一致する() {
            assertThat(sut.get開催場所地区コード(), is(開催場所地区コード));
        }

        @Test
        public void 引き渡した開催場所住所とtoShinsakaiKaisaiBashoの結果は一致する() {
            assertThat(sut.get開催場所住所(), is(開催場所住所));
        }

        @Test
        public void 引き渡した開催場所電話番号とtoShinsakaiKaisaiBashoの結果は一致する() {
            assertThat(sut.get開催場所電話番号(), is(開催場所電話番号));
        }

        @Test
        public void 引き渡した開催場所状況とtoShinsakaiKaisaiBashoの結果は一致する() {
            assertThat(sut.get開催場所状況(), is(開催場所状況));
        }

        private DbT5104ShinsakaiKaisaiBashoJohoEntity create審査会開催場所情報Entity() {
            DbT5104ShinsakaiKaisaiBashoJohoEntity entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
            entity.setShinsakaiKaisaiBashoCode(開催場所コード);
            entity.setShinsakaiKaisaiBashoMei(開催場所名称);
            entity.setShinsakaiKaisaiChikuCode(開催場所地区コード);
            entity.setShinsakaiKaisaiBashoJusho(開催場所住所);
            entity.setShinsakaiKaisaiBashoTelNo(開催場所電話番号);
            entity.setShinsakaiKaisaiBashoJokyo(true);
            return entity;
        }
    }
}
