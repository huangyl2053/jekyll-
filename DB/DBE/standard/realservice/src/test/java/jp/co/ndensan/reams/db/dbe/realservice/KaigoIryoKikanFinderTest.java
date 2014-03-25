/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikanCollection;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IKaigoIryoKikanDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.KaigoIryoKikanTestHelper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.realservice.IKozaManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * 介護医療機関Finderのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoIryoKikanFinderTest extends TestBase {

    private static KaigoIryoKikanFinder sut;
    public static ShichosonCode 市町村コード = new ShichosonCode(new RString("A001"));
    public static KaigoIryoKikanCode 介護医療機関コード = new KaigoIryoKikanCode(new RString("B001"));

    public static class get介護医療機関_市町村コードと介護医療機関コードが引数の場合のテスト extends TestBase {

        @Override
        public void setUp() {
            setGyomuCD("DBE");
        }

        @Test
        public void 指定した市町村コードを持つ_介護医療機関が取得できる() {
            sut = new KaigoIryoKikanFinder(createDac(), createKozaManager());
            KaigoIryoKikan result = sut.get介護医療機関(市町村コード, 介護医療機関コード);
            assertThat(result.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 介護医療機関Entityが取得できなかった場合_nullが返る() {
            IKaigoIryoKikanDac dac = createDac();
            when(dac.select(市町村コード, 介護医療機関コード)).thenReturn(null);
            sut = new KaigoIryoKikanFinder(dac, createKozaManager());
            KaigoIryoKikan result = sut.get介護医療機関(市町村コード, 介護医療機関コード);
            assertThat(result, is(nullValue()));
        }
    }

    public static class get介護医療機関Collection_市町村コードと介護医療機関コード_医療機関状況が引数の場合のテスト extends TestBase {

        @Override
        public void setUp() {
            setGyomuCD("DBE");
        }

        @Test
        public void 指定した市町村コードを持つ_介護医療機関が取得できる() {
            sut = new KaigoIryoKikanFinder(createDac(), createKozaManager());
            KaigoIryoKikan result = sut.get介護医療機関(市町村コード, 介護医療機関コード, IryoKikanJokyo.有効);
            assertThat(result.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 介護医療機関Entityが取得できなかった場合_nullが返る() {
            IKaigoIryoKikanDac dac = createDac();
            when(dac.select(市町村コード, 介護医療機関コード, IryoKikanJokyo.有効)).thenReturn(null);
            sut = new KaigoIryoKikanFinder(dac, createKozaManager());
            KaigoIryoKikan result = sut.get介護医療機関(市町村コード, 介護医療機関コード, IryoKikanJokyo.有効);
            assertThat(result, is(nullValue()));
        }
    }

    public static class get介護医療機関_市町村コードが引数の場合のテスト extends TestBase {

        @Override
        public void setUp() {
            setGyomuCD("DBE");
        }

        @Test
        public void 指定した市町村コードを持つ_介護医療機関を要素として持つCollectionが取得できる() {
            sut = new KaigoIryoKikanFinder(createDac(), createKozaManager());
            KaigoIryoKikanCollection results = sut.get介護医療機関Collection(市町村コード);
            assertThat(results.get介護医療機関(市町村コード, 介護医療機関コード).get市町村コード(), is(市町村コード));
        }

        @Test
        public void 介護医療機関Entityのリストが取得できずEMPTY_LISTが戻り値だった場合_空のCollectionが返る() {
            IKaigoIryoKikanDac dac = createDac();
            when(dac.select(市町村コード)).thenReturn(Collections.EMPTY_LIST);
            sut = new KaigoIryoKikanFinder(dac, createKozaManager());
            KaigoIryoKikanCollection results = sut.get介護医療機関Collection(市町村コード);
            assertThat(results.isEmpty(), is(true));
        }
    }

    public static class get介護医療機関Collection_市町村コードと医療機関状況が引数の場合のテスト extends TestBase {

        @Override
        public void setUp() {
            setGyomuCD("DBE");
        }

        @Test
        public void 指定した市町村コードを持つ_介護医療機関を要素として持つCollectionが取得できる() {
            sut = new KaigoIryoKikanFinder(createDac(), createKozaManager());
            KaigoIryoKikanCollection results = sut.get介護医療機関Collection(市町村コード, IryoKikanJokyo.有効);
            assertThat(results.get介護医療機関(市町村コード, 介護医療機関コード).get市町村コード(), is(市町村コード));
        }

        @Test
        public void 介護医療機関Entityのリストが取得できずEMPTY_LISTが戻り値だった場合_空のCollectionが返る() {
            IKaigoIryoKikanDac dac = createDac();
            when(dac.select(市町村コード, IryoKikanJokyo.有効)).thenReturn(Collections.EMPTY_LIST);
            sut = new KaigoIryoKikanFinder(dac, createKozaManager());
            KaigoIryoKikanCollection results = sut.get介護医療機関Collection(市町村コード, IryoKikanJokyo.有効);
            assertThat(results.isEmpty(), is(true));
        }
    }

    private static IKaigoIryoKikanDac createDac() {
        IKaigoIryoKikanDac dac = mock(IKaigoIryoKikanDac.class);

        KaigoIryoKikanEntity entity = create介護医療機関Entity();
        when(dac.select(any(ShichosonCode.class), any(KaigoIryoKikanCode.class))).thenReturn(entity);
        when(dac.select(any(ShichosonCode.class), any(KaigoIryoKikanCode.class), any(IryoKikanJokyo.class))).thenReturn(entity);

        List<KaigoIryoKikanEntity> 介護医療機関リスト_2件 = create介護医療機関EntityList(2);
        when(dac.select(any(ShichosonCode.class))).thenReturn(介護医療機関リスト_2件);

        List<KaigoIryoKikanEntity> 介護医療機関リスト_3件 = create介護医療機関EntityList(3);
        when(dac.select(any(ShichosonCode.class), any(IryoKikanJokyo.class))).thenReturn(介護医療機関リスト_3件);
        return dac;
    }

    private static IKozaManager createKozaManager() {
        IKozaManager manager = mock(IKozaManager.class);
        when(manager.get口座(any(RDate.class), any(ShikibetsuCode.class))).thenReturn(KaigoIryoKikanTestHelper.create口座List(3));
        return manager;
    }

    private static KaigoIryoKikanEntity create介護医療機関Entity() {
        KaigoIryoKikanEntity entity = new KaigoIryoKikanEntity();
        entity.setIryoKikanEntity(KaigoIryoKikanTestHelper.create医療機関Entity());
        entity.setDbT7011ShujiiIryoKikanJohoEntity(KaigoIryoKikanTestHelper.create主治医医療機関Entity());
        return entity;
    }

    private static List<KaigoIryoKikanEntity> create介護医療機関EntityList(int 件数) {
        List<KaigoIryoKikanEntity> entities = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            entities.add(create介護医療機関Entity());
        }
        return entities;
    }
}
