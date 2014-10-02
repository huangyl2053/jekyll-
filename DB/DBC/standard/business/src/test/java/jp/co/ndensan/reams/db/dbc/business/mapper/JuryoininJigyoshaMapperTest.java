/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.mapper;

import jp.co.ndensan.reams.db.dbc.business.mapper.JuryoininJigyoshaMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyoshaList;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.business.helper.JuryoininJigyoshaMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.JuryoininJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 受領委任事業者のbusinessクラスとentityクラスのマッピングを行うテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
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
            assertThat(sut.get契約番号().value(), is(JuryoininJigyoshaEntity.getJigyoshaKeiyakuNo()));
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
        public void get処理日時の結果が_Entityの処理日時と同一になる() {
            assertThat(sut.get処理日時(), is(JuryoininJigyoshaEntity.getShoriTimestamp()));
        }

        @Test
        public void get届出年月日の結果が_Entityの届出年月日と同一になる() {
            assertThat(sut.get届出年月日(), is(JuryoininJigyoshaEntity.getTodokedeYMD()));
        }

        @Test
        public void get届出者のget住所の結果が_Entityの届出者住所と同一になる() {
            assertThat(sut.get届出者().get住所(), is(JuryoininJigyoshaEntity.getTodokedeAddress()));
        }

        @Test
        public void get届出者のget事業者名称の結果が_Entityの届出者事業者名称と同一になる() {
            assertThat(sut.get届出者().get事業者名称(), is(JuryoininJigyoshaEntity.getTodokedeJigyoshaName()));
        }

        @Test
        public void get届出者のget代表者氏名の結果が_Entityの届出者代表者氏名と同一になる() {
            assertThat(sut.get届出者().get代表者氏名(), is(JuryoininJigyoshaEntity.getTodokedeDaihyoshaName()));
        }

        @Test
        public void get識別コードの結果が_Entityの識別コードと同一になる() {
            assertThat(sut.get識別コード(), is(JuryoininJigyoshaEntity.getShikibetsuCode()));
        }

        @Test
        public void get契約事業者のget事業者番号の結果が_Entityの契約事業者番号と同一になる() {
            assertThat(sut.get契約事業者().get事業者番号(), is(JuryoininJigyoshaEntity.getKeiyakuJigyoshaNo()));
        }

        @Test
        public void get契約事業者のget事業者FAX番号の結果が_Entityの事業者FAX番号と同一になる() {
            assertThat(sut.get契約事業者().get事業者FAX番号(), is(JuryoininJigyoshaEntity.getJigyoshaFaxNo()));
        }

        @Test
        public void get契約事業者のget営業形態の結果が_Entityの営業形態と同一になる() {
            assertThat(sut.get契約事業者().get営業形態().getCode(), is(JuryoininJigyoshaEntity.getEigyoKeitai()));
        }

        @Test
        public void get契約事業者のget送付先部署の結果が_Entityの送付先部署と同一になる() {
            assertThat(sut.get契約事業者().get送付先部署(), is(JuryoininJigyoshaEntity.getSofusakiBusho()));
        }

        @Test
        public void get契約登録年月日の結果が_Entityの契約登録年月日と同一になる() {
            assertThat(sut.get契約登録年月日(), is(JuryoininJigyoshaEntity.getKeiyakuTorokuYMD()));
        }

        @Test
        public void has住宅改修契約の結果が_Entityの住宅改修契約有無と同一になる() {
            assertThat(sut.has住宅改修契約(), is(JuryoininJigyoshaEntity.getJutakuKaishuKeiyakuUmu()));
        }

        @Test
        public void has特定福祉用具販売契約の結果が_Entityの特定福祉用具販売契約有無と同一になる() {
            assertThat(sut.has特定福祉用具販売契約(), is(JuryoininJigyoshaEntity.getTokuteiFukushiYoguHanbaiKeiyakuUmu()));
        }

        @Test
        public void has償還払給付契約の結果が_Entityの償還払給付契約有無と同一になる() {
            assertThat(sut.has償還払給付契約(), is(JuryoininJigyoshaEntity.getShokanbaraiKyufuKeiyakuUmu()));
        }

        @Test
        public void has高額給付契約の結果が_Entityの高額給付契約有無と同一になる() {
            assertThat(sut.has高額給付契約(), is(JuryoininJigyoshaEntity.getKogakuKyufuKeiyakuUmu()));
        }

        @Test
        public void has取扱確約書の結果が_Entityの取扱確約書有無と同一になる() {
            assertThat(sut.has取扱確約書(), is(JuryoininJigyoshaEntity.getToriatsukaiKakuyakushoUmu()));
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
            assertThat(sut.getJigyoshaKeiyakuNo(), is(受領委任事業者.get契約番号().value()));
        }

        @Test
        public void Entityの開始年月日と_受領委任事業者の契約期間の開始年月日が同一になる() {
            assertThat(sut.getKaishiYMD(), is(受領委任事業者.get契約期間().getFrom()));
        }

        @Test
        public void Entityの処理日時と_受領委任事業者の処理日時が同一になる() {
            assertThat(sut.getShoriTimestamp(), is(受領委任事業者.get処理日時()));
        }

        @Test
        public void Entityの終了年月日と_受領委任事業者の契約期間の終了年月日が同一になる() {
            assertThat(sut.getShuryoYMD(), is(受領委任事業者.get契約期間().getTo()));
        }

        @Test
        public void Entityの届出年月日と_受領委任事業者の届出年月日が同一になる() {
            assertThat(sut.getTodokedeYMD(), is(受領委任事業者.get届出年月日()));
        }

        @Test
        public void Entityの届出者住所と_届出者の住所が同一になる() {
            assertThat(sut.getTodokedeAddress(), is(受領委任事業者.get届出者().get住所()));
        }

        @Test
        public void Entityの届出者事業者名称と_届出者の事業者名称が同一になる() {
            assertThat(sut.getTodokedeJigyoshaName(), is(受領委任事業者.get届出者().get事業者名称()));
        }

        @Test
        public void Entityの届出者代表者氏名と_届出者の代表者氏名が同一になる() {
            assertThat(sut.getTodokedeDaihyoshaName(), is(受領委任事業者.get届出者().get代表者氏名()));
        }

        @Test
        public void Entityの識別コードと_受領委任事業者のget識別コードが同一になる() {
            assertThat(sut.getShikibetsuCode(), is(受領委任事業者.get識別コード()));
        }

        @Test
        public void Entityの事業者FAX番号と_契約事業者の事業者FAX番号が同一になる() {
            assertThat(sut.getJigyoshaFaxNo(), is(受領委任事業者.get契約事業者().get事業者FAX番号()));
        }

        @Test
        public void Entityの契約登録年月日と_受領委任事業者の契約登録年月日が同一になる() {
            assertThat(sut.getKeiyakuTorokuYMD(), is(受領委任事業者.get契約登録年月日()));
        }

        @Test
        public void Entityの送付先部署と_契約事業者の送付先部署が同一になる() {
            assertThat(sut.getSofusakiBusho(), is(受領委任事業者.get契約事業者().get送付先部署()));
        }

        @Test
        public void Entityの営業形態と_契約事業者の営業形態が同一になる() {
            assertThat(sut.getEigyoKeitai(), is(受領委任事業者.get契約事業者().get営業形態().getCode()));
        }

        @Test
        public void Entityの住宅改修契約有無と_受領委任事業者のhas住宅改修契約が同一になる() {
            assertThat(sut.getJutakuKaishuKeiyakuUmu(), is(受領委任事業者.has住宅改修契約()));
        }

        @Test
        public void Entityの特定福祉用具販売契約有無と_受領委任事業者のhas特定福祉用具販売契約が同一になる() {
            assertThat(sut.getTokuteiFukushiYoguHanbaiKeiyakuUmu(), is(受領委任事業者.has特定福祉用具販売契約()));
        }

        @Test
        public void Entityの償還払給付契約有無と_受領委任事業者のhas償還払給付契約が同一になる() {
            assertThat(sut.getShokanbaraiKyufuKeiyakuUmu(), is(受領委任事業者.has償還払給付契約()));
        }

        @Test
        public void Entityの高額給付契約有無と_受領委任事業者のhas高額給付契約が同一になる() {
            assertThat(sut.getKogakuKyufuKeiyakuUmu(), is(受領委任事業者.has高額給付契約()));
        }

        @Test
        public void Entityの契約事業者番号と_契約事業者の事業者番号が同一になる() {
            assertThat(sut.getKeiyakuJigyoshaNo(), is(受領委任事業者.get契約事業者().get事業者番号()));
        }

        @Test
        public void Entityの取扱確約書有無と_受領委任事業者のhas取扱確約書が同一になる() {
            assertThat(sut.getToriatsukaiKakuyakushoUmu(), is(受領委任事業者.has取扱確約書()));
        }
    }
}
