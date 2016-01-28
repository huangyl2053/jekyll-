/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.JuryoininJigyoshaList;
import jp.co.ndensan.reams.db.dbc.business.core.mapper.JuryoininJigyoshaMapper;
import jp.co.ndensan.reams.db.dbc.business.helper.JuryoininJigyoshaMock;
import jp.co.ndensan.reams.db.dbc.definition.core.valueobject.keiyakuno.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.JuryoininJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.hojin.IHojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 受領委任事業者のbusinessクラスとentityクラスのマッピングを行うテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
@Ignore
public class JuryoininJigyoshaMapperTest extends DbcTestBase {

    private static final KeiyakuNo 契約番号 = new KeiyakuNo(new RString("1234567890"));
    private static final RString 送付先部署 = new RString("１課");

    public static class Test_to受領委任事業者 extends DbcTestBase {

        private final DbT3077JuryoininKeiyakuJigyoshaEntity JuryoininJigyoshaEntity
                = JuryoininJigyoshaEntityMock.create受領委任事業者Entity(契約番号, 送付先部署);
        private JuryoininJigyosha sut;

        @Before
        public void setUp() {
            sut = JuryoininJigyoshaMapper.to受領委任事業者(
                    JuryoininJigyoshaEntity,
                    JuryoininJigyoshaMock.createHojin(),
                    mock(IKoza.class));
        }

        @Test
        public void 受領委任事業者entityに_nullを設定した時_nullを返す() {
            sut = JuryoininJigyoshaMapper.to受領委任事業者(null, null, null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void get契約番号の結果が_Entityの事業者契約番号と同一になる() {
            assertThat(sut.get契約番号().value(), is(JuryoininJigyoshaEntity.getKeiyakuJigyoshaNo()));
        }

        @Test
        public void get契約期間の開始年月日の結果が_Entityの開始年月日と同一になる() {
            assertThat(sut.get契約期間().getFrom(), is(JuryoininJigyoshaEntity.getKaishiYMD()));
        }

        @Test
        public void get契約期間の終了年月日の結果が_Entityの終了年月日と同一になる() {
            assertThat(sut.get契約期間().getTo(), is(JuryoininJigyoshaEntity.getShuryoYMD()));

        }

        @Test
        public void get契約事業者のget送付先部署の結果が_Entityの送付先部署と同一になる() {
            assertThat(sut.get契約事業者().get送付先部署(), is(JuryoininJigyoshaEntity.getSofusakiBusho()));
        }

    }

    public static class Test_to受領委任事業者List {

        private JuryoininJigyoshaList sut;

        @Test
        public void nullが渡された時_空のコレクションが返る() {
            sut = JuryoininJigyoshaMapper.to受領委任事業者List(null, null, null);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 空のリストが渡された時_空のコレクションが返る() {
            sut = JuryoininJigyoshaMapper.to受領委任事業者List(Collections.EMPTY_LIST, null, null);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void Entityを3件持つListが渡された場合_3件の要素を持つコレクションが返る() {
            final int LIST_SIZE = 3;
            sut = JuryoininJigyoshaMapper.to受領委任事業者List(
                    create受領委任事業者EntityList(LIST_SIZE), createHojinList(LIST_SIZE), createKozaList(LIST_SIZE));
            assertThat(sut.size(), is(3));
        }

        private List<DbT3077JuryoininKeiyakuJigyoshaEntity> create受領委任事業者EntityList(int listSize) {
            List<DbT3077JuryoininKeiyakuJigyoshaEntity> list = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                list.add(JuryoininJigyoshaEntityMock.create受領委任事業者Entity(契約番号, 送付先部署));
            }
            return list;
        }

        private List<IHojin> createHojinList(int listSize) {
            List<IHojin> list = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                list.add(JuryoininJigyoshaMock.createHojin());
            }
            return list;
        }

        private List<IKoza> createKozaList(int listSize) {
            List<IKoza> list = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                list.add(mock(IKoza.class));
            }
            return list;
        }
    }

    public static class Test_to受領委任事業者Entity extends DbcTestBase {

        private DbT3077JuryoininKeiyakuJigyoshaEntity sut;
        private final JuryoininJigyosha 受領委任事業者 = JuryoininJigyoshaMock.create受領委任事業者();

        @Before
        public void setUp() {
            sut = JuryoininJigyoshaMapper.to受領委任事業者Entity(受領委任事業者);
        }

        @Test
        public void 引数にnullが渡された時_nullを返す() {
            sut = JuryoininJigyoshaMapper.to受領委任事業者Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void Entityの事業者契約番号と_受領委任事業者の契約番号が同一になる() {
            assertThat(sut.getKeiyakuJigyoshaNo(), is(受領委任事業者.get契約番号().value()));
        }

        @Test
        public void Entityの開始年月日と_受領委任事業者の契約期間の開始年月日が同一になる() {
            assertThat(sut.getKaishiYMD(), is(受領委任事業者.get契約期間().getFrom()));
        }

        @Test
        public void Entityの終了年月日と_受領委任事業者の契約期間の終了年月日が同一になる() {
            assertThat(sut.getShuryoYMD(), is(受領委任事業者.get契約期間().getTo()));
        }

        @Test
        public void Entityの送付先部署と_契約事業者の送付先部署が同一になる() {
            assertThat(sut.getSofusakiBusho(), is(受領委任事業者.get契約事業者().get送付先部署()));
        }

    }
}
