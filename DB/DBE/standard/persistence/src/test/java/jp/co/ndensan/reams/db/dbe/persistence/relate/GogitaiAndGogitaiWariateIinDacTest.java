/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.helper.IGogitaiWariateSelector;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体と合議体割当委員の情報を同時に更新するDACのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiAndGogitaiWariateIinDacTest {

    private static IGogitaiAndGogitaiWariateIinDac sut;
    private static IGogitaiJohoDac gogitaiDac;
    private static IGogitaiWariateSelector gogitaiWariateSelecter;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceCreator.create(IGogitaiAndGogitaiWariateIinDac.class);
        gogitaiDac = InstanceCreator.create(IGogitaiJohoDac.class);
        gogitaiWariateSelecter = InstanceCreator.create(IGogitaiWariateSelector.class);
    }

    public static class insertOrUpdateのテスト extends DbeTestDacBase {

        DbT5103GogitaiJohoEntity 合議体Entity;
        List<DbT5107GogitaiWariateIinJohoEntity> 割当委員Entities;

        @Before
        public void setUp() {
            合議体Entity = create合議体Entity(1, "19990101", "20010101", "合議体1");
            割当委員Entities = new ArrayList<>();
            割当委員Entities.add(create合議体割当Entity(1, "A001", "19990101", "20010101"));
            割当委員Entities.add(create合議体割当Entity(1, "A002", "19990101", "20010101"));
            割当委員Entities.add(create合議体割当Entity(1, "A003", "19990101", "20010101"));
        }

        @Test
        public void 割当委員を3件持つ合議体の情報を引数に渡したとき_合計更新件数として4が返る() {
            assertThat(sut.insertOrUpdate合議体割当審査会委員情報(合議体Entity, 割当委員Entities), is(4));
        }

        @Test
        public void 割当委員を3件持つ合議体の情報を引数に渡したとき_合議体の情報が1件挿入される() {
            sut.insertOrUpdate合議体割当審査会委員情報(合議体Entity, 割当委員Entities);
            assertThat(gogitaiDac.select(new GogitaiNo(1)).size(), is(1));
        }

        @Test
        public void 割当委員を3件持つ合議体の情報を引数に渡したとき_合議体に割り当てられた委員の情報が3件挿入される() {
            sut.insertOrUpdate合議体割当審査会委員情報(合議体Entity, 割当委員Entities);
            assertThat(gogitaiWariateSelecter.select(new GogitaiNo(1), new FlexibleDate("19990101")).size(), is(3));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        DbT5103GogitaiJohoEntity 合議体Entity;
        List<DbT5107GogitaiWariateIinJohoEntity> 割当委員Entities;

        @Before
        public void setUp() {
            合議体Entity = create合議体Entity(1, "19990101", "20010101", "合議体1");
            割当委員Entities = new ArrayList<>();
            割当委員Entities.add(create合議体割当Entity(1, "A001", "19990101", "20010101"));
            割当委員Entities.add(create合議体割当Entity(1, "A002", "19990101", "20010101"));
            割当委員Entities.add(create合議体割当Entity(1, "A003", "19990101", "20010101"));
            sut.insertOrUpdate合議体割当審査会委員情報(合議体Entity, 割当委員Entities);
        }

        @Test
        public void 割当委員を3件持つ合議体の情報を引数に渡したとき_合計削除件数として4が返る() {
            assertThat(sut.delete合議体割当審査会委員情報(合議体Entity, 割当委員Entities), is(4));
        }

        @Test
        public void 割当委員を3件持つ合議体の情報を引数に渡したとき_合議体の削除され_selectで取得できない() {
            sut.delete合議体割当審査会委員情報(合議体Entity, 割当委員Entities);
            assertThat(gogitaiDac.select(new GogitaiNo(1)).size(), is(0));
        }

        @Test
        public void 割当委員を3件持つ合議体の情報を引数に渡したとき_割当委員の情報が削除され_selectで取得できない() {
            sut.delete合議体割当審査会委員情報(合議体Entity, 割当委員Entities);
            assertThat(gogitaiWariateSelecter.select(new GogitaiNo(1), new FlexibleDate("19990101")).size(), is(0));
        }
    }

    private static DbT5103GogitaiJohoEntity create合議体Entity(int 合議体番号, String 開始年月日, String 終了年月日, String 合議体名称) {
        DbT5103GogitaiJohoEntity entity = new DbT5103GogitaiJohoEntity();
        entity.setGogitaiNo(合議体番号);
        entity.setGogitaiMei(new RString(合議体名称));
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(開始年月日));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(終了年月日));
        entity.setGogitaiKaishiYoteiTime(new RString("0830"));
        entity.setGogitaiShuryoYoteiTime(new RString("0830"));
        entity.setShinsakaiKaisaiBashoCode(new RString("A001"));
        entity.setShinsakaiYoteiTeiin(5);
        entity.setShinsakaiJidoWariateTeiin(6);
        entity.setShinsakaiIinTeiin(7);
        entity.setGogitaiSeishinkaSonzaiFlag(true);
        entity.setGogitaiDummyFlag(false);
        return entity;
    }

    private static DbT5107GogitaiWariateIinJohoEntity create合議体割当Entity(int 合議体番号, String 割当委員コード, String 開始年月日, String 終了年月日) {
        DbT5107GogitaiWariateIinJohoEntity entity = new DbT5107GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(合議体番号);
        entity.setShinsakaiIinCode(new RString(割当委員コード));
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(開始年月日));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(終了年月日));
        entity.setGogitaichoKubunCode(new Code(new RString("1")));
        entity.setShinsainKubunCode(new Code(new RString("1")));
        return entity;
    }
}
