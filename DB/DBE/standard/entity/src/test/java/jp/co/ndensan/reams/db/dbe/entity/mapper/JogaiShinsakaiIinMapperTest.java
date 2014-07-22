/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiMockBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.relate.JogaiShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JogaiShinsakaiIinMapperTest {

    private static JogaiShinsakaiIin 除外委員;
    private static JogaiShinsakaiIinEntity 除外対象委員Entity;

    private static ShoKisaiHokenshaNo 証記載保険者番号_123456;
    private static KaigoHihokenshaNo 被保険者番号_0000100012;
    private static int 管理番号_1;
    private static ShinsakaiIinCode 除外対象審査会委員コード_12345678;

    private static ShinsakaiIin 除外対象審査会委員_12345678;
    private static DbT5102ShinsakaiIinJohoEntity 審査会委員Entity;
    private static DbT5014ShinsakaiIinJogaiJohoEntity 審査会委員除外情報Entity;

    @BeforeClass
    public static void setUpBeforeClass() {

        証記載保険者番号_123456 = new ShoKisaiHokenshaNo(new RString("123456"));
        被保険者番号_0000100012 = new KaigoHihokenshaNo(new RString("0000100012"));
        管理番号_1 = 1;
        除外対象審査会委員コード_12345678 = new ShinsakaiIinCode(new RString("12345678"));
        除外対象審査会委員_12345678 = ShinsakaiMockBusinessCreator.create審査会委員(
                除外対象審査会委員コード_12345678.value().toString());
    }

    public static class toJogaiShinsakaiIinのテスト extends DbeTestBase {

        private JogaiShinsakaiIin sut;

        @Before
        public void setUp() {
            審査会委員Entity = ShinsakaiMockEntityCreator.create審査会委員EntitySpy(除外対象審査会委員コード_12345678.value().toString());
            審査会委員除外情報Entity = ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(証記載保険者番号_123456,
                    被保険者番号_0000100012, 管理番号_1, 除外対象審査会委員コード_12345678);
            除外対象委員Entity = new JogaiShinsakaiIinEntity(審査会委員Entity, 審査会委員除外情報Entity);

            sut = JogaiShinsakaiIinMapper.toJogaiShinsakaiIin(除外対象委員Entity);
        }

        @Test
        public void マッピング後の除外委員情報が持つ証記載保険者番号と_マッピング前のEntityが持つ証記載保険者番号が_一致する() {
            assertThat(sut.get証記載保険者番号(), is(除外対象委員Entity.get除外委員情報Entity().getShoKisaiHokenshaNo()));
        }

        @Test
        public void マッピング後の除外委員情報が持つ被保険者番号と_マッピング前のEntityが持つ被保険者番号が_一致する() {
            assertThat(sut.get対象被保険者番号(), is(除外対象委員Entity.get除外委員情報Entity().getHihokenshaNo()));
        }

        @Test
        public void マッピング後の除外委員情報が持つ管理番号と_マッピング前のEntityが持つ管理番号が_一致する() {
            assertThat(sut.get管理番号(), is(除外対象委員Entity.get除外委員情報Entity().getKanriNo()));
        }

        @Test
        public void マッピング後の除外委員情報が持つ除外対象審査会委員コードと_マッピング前のEntityが持つ除外対象審査会委員コードが_一致する() {
            assertThat(sut.get除外対象審査会委員().get審査会委員コード().value(), is(除外対象委員Entity.get審査会委員Entity().getShinsakaiIinCode()));
        }
    }

    public static class toJogaiShinsakaiIinListのテスト extends DbeTestBase {

        private JogaiShinsakaiIinList sut;

        @Test
        public void 引数にnullが渡されたとき_空のリストが返る() {
            sut = JogaiShinsakaiIinMapper.toJogaiShinsakaiIinList(null);
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 要素を3つ持つ除外審査員EntityのListが渡されたとき_3件の要素を持つ除外審査会委員Listが返る() {
            sut = JogaiShinsakaiIinMapper.toJogaiShinsakaiIinList(createJogaiIinEntityList(3));
            assertThat(sut.size(), is(3));
        }

        public List<JogaiShinsakaiIinEntity> createJogaiIinEntityList(int 件数) {
            審査会委員Entity = ShinsakaiMockEntityCreator.create審査会委員EntitySpy(除外対象審査会委員コード_12345678.value().toString());
            審査会委員除外情報Entity = ShinsakaiMockEntityCreator.create審査会委員除外情報Entity(証記載保険者番号_123456,
                    被保険者番号_0000100012, 管理番号_1, 除外対象審査会委員コード_12345678);
            除外対象委員Entity = new JogaiShinsakaiIinEntity(審査会委員Entity, 審査会委員除外情報Entity);

            List<JogaiShinsakaiIinEntity> list = new ArrayList<>();
            for (int i = 0; i < 件数; i++) {
                list.add(除外対象委員Entity);
            }
            return list;
        }
    }

    public static class toShinsakaiIinJogaiJohoEntityのテスト extends DbeTestBase {

        private DbT5014ShinsakaiIinJogaiJohoEntity sut;

        @Before
        public void setUp() {
            除外委員 = new JogaiShinsakaiIin(証記載保険者番号_123456, 被保険者番号_0000100012, 管理番号_1, 除外対象審査会委員_12345678);
            sut = JogaiShinsakaiIinMapper.toShinsakaiIinJogaiJohoEntity(除外委員);
        }

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = JogaiShinsakaiIinMapper.toShinsakaiIinJogaiJohoEntity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void マッピング後のEntityが持つ証記載保険者番号と_マッピング前の除外委員情報が持つ証記載保険者番号が_一致する() {
            assertThat(sut.getShoKisaiHokenshaNo(), is(除外委員.get証記載保険者番号()));
        }

        @Test
        public void マッピング後のEntityが持つ被保険者番号と_マッピング前の除外委員情報が持つ被保険者番号が_一致する() {
            assertThat(sut.getHihokenshaNo(), is(除外委員.get対象被保険者番号()));
        }

        @Test
        public void マッピング後のEntityが持つ管理番号と_マッピング前の除外委員情報が持つ管理番号が_一致する() {
            assertThat(sut.getKanriNo(), is(除外委員.get管理番号()));
        }

        @Test
        public void マッピング後のEntityが持つ除外対象審査会委員コードと_マッピング前の除外委員情報が持つ除外対象審査会委員コードが_一致する() {
            assertThat(sut.getJogaiTaishoShinsakaiIinCode(), is(除外委員.get除外対象審査会委員().get審査会委員コード().value()));
        }
    }

    public static class toShinsakaiIinJogaiJohoEntityListのテスト extends DbeTestBase {

        private List<DbT5014ShinsakaiIinJogaiJohoEntity> sut;

        @Test
        public void 引数にnullが渡されたとき_空のリストが返る() {
            sut = JogaiShinsakaiIinMapper.toShinsakaiIinJogaiJohoEntityList(null);
            assertThat(sut, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 要素を3つ持つ除外審査員Listが渡されたとき_3件の要素を持つ審査会委員除外情報EntityのListが返る() {
            sut = JogaiShinsakaiIinMapper.toShinsakaiIinJogaiJohoEntityList(createJogaiIinList(3));
            assertThat(sut.size(), is(3));
        }

        public JogaiShinsakaiIinList createJogaiIinList(int 件数) {
            除外委員 = new JogaiShinsakaiIin(証記載保険者番号_123456, 被保険者番号_0000100012, 管理番号_1, 除外対象審査会委員_12345678);

            List<JogaiShinsakaiIin> list = new ArrayList<>();
            for (int i = 0; i < 件数; i++) {
                list.add(除外委員);
            }
            return new JogaiShinsakaiIinList(list);
        }
    }
}
