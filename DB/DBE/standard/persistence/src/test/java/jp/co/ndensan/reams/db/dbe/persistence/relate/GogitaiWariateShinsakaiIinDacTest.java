/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiWariateDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.helper.IShinsakaiIInDacMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * 合議体割当審査会委員Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiWariateShinsakaiIinDacTest {

    private static IGogitaiWariateShinsakaiIinDac sut;
    private static IShinsakaiIInDacMock shinsakaiInserter;
    private static IGogitaiWariateDac wariateInserter;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceCreator.create(IGogitaiWariateShinsakaiIinDac.class);
        shinsakaiInserter = InstanceCreator.create(IShinsakaiIInDacMock.class);
        wariateInserter = InstanceCreator.create(IGogitaiWariateDac.class);
    }

    public static class selectのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            GogitaiWariateShinsakaiIinEntity entity1 = create合議体割当審査会委員Entity(1, "割当委員01", "19990101", "20010101", "委員コード01");
            shinsakaiInserter.insert(entity1.get審査会委員Entity());
            wariateInserter.insert(entity1.get合議体割当Entity());
            GogitaiWariateShinsakaiIinEntity entity2 = create合議体割当審査会委員Entity(1, "割当委員02", "19990101", "20010101", "委員コード02");
            shinsakaiInserter.insert(entity2.get審査会委員Entity());
            wariateInserter.insert(entity2.get合議体割当Entity());
            GogitaiWariateShinsakaiIinEntity entity3 = create合議体割当審査会委員Entity(1, "割当委員03", "19990101", "20010101", "委員コード03");
            shinsakaiInserter.insert(entity3.get審査会委員Entity());
            wariateInserter.insert(entity3.get合議体割当Entity());
            GogitaiWariateShinsakaiIinEntity entity4 = create合議体割当審査会委員Entity(2, "割当委員01", "19990101", "20010101", "委員コード04");
            shinsakaiInserter.insert(entity4.get審査会委員Entity());
            wariateInserter.insert(entity4.get合議体割当Entity());
        }

        @Test
        public void 引数に合議体番号1を指定した場合_3件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(1), new FlexibleDate("19990101"));
            assertThat(result.size(), is(3));
        }

        @Test
        public void 引数に合議体番号2を指定した場合_1件のリストが取得できる() {
            List<GogitaiWariateShinsakaiIinEntity> result = sut.select(new GogitaiNo(2), new FlexibleDate("19990101"));
            assertThat(result.size(), is(1));
        }
    }

    //TODO n8178 城間篤人 openSessionで落ちてしまうため、一時的にダミーを追加。後日削除予定 2014年3月末
    public static class dummy extends DbeTestDacBase {

        @Test
        public void dummy() {
        }
    }

    private static DbT5107GogitaiWariateIinJohoEntity create合議体割当Entity(int 合議体番号, String 割当委員コード,
            String 開始年月日, String 終了年月日) {
        DbT5107GogitaiWariateIinJohoEntity entity = new DbT5107GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(合議体番号);
        entity.setShinsakaiIinCode(new RString(割当委員コード));
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(開始年月日));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(終了年月日));
        entity.setGogitaichoKubunCode(new Code(new RString("1")));
        entity.setShinsainKubunCode(new Code(new RString("1")));
        return entity;
    }

    private static GogitaiWariateShinsakaiIinEntity create合議体割当審査会委員Entity(int 合議体番号, String 割当委員コード,
            String 開始年月日, String 終了年月日, String 委員コード) {
        GogitaiWariateShinsakaiIinEntity entity = new GogitaiWariateShinsakaiIinEntity();
        entity.set割当Entity(create合議体割当Entity(合議体番号, 割当委員コード, 開始年月日, 終了年月日));
        entity.set委員Entity(create審査会委員Entity(委員コード));
        return entity;
    }

    private static DbT5102ShinsakaiIinJohoEntity create審査会委員Entity(String 委員コード) {
        DbT5102ShinsakaiIinJohoEntity 委員Entity = new DbT5102ShinsakaiIinJohoEntity();
        委員Entity.setShinsakaiIinCode(new RString(委員コード));
        委員Entity.setShinsakaiIinKaishiYMD(FlexibleDate.MIN);
        委員Entity.setShinsakaiIinShuryoYMD(FlexibleDate.MAX);
        委員Entity.setShinsakaiIinJokyo(Boolean.TRUE);
        委員Entity.setJigyoushaNo(new JigyoshaNo(new RString("ABCD00021")));
        委員Entity.setShinsakaiIinShimei(new AtenaMeisho(RString.EMPTY));
        委員Entity.setShinsakaiIinKanaShimei(new AtenaKanaMeisho(RString.EMPTY));
        委員Entity.setSeibetsu(Gender.FEMALE.getCode());
        委員Entity.setShinsakaiIinShikakuCode(new Code(RString.EMPTY));
        委員Entity.setShinsainYusoKubun(RString.EMPTY);
        委員Entity.setYubinNo(new YubinNo(new RString("123-1234")));
        委員Entity.setJusho(new AtenaJusho(RString.EMPTY));
        委員Entity.setTelNo(new TelNo(RString.EMPTY));
        委員Entity.setKinyuKikanCode(new KinyuKikanCode(RString.HALF_SPACE));
        委員Entity.setKinyuKikanShitenCode(new KinyuKikanShitenCode(RString.HALF_SPACE));
        委員Entity.setKozaShubetsu(RString.EMPTY);
        委員Entity.setKozaMeigi(RString.EMPTY);
        委員Entity.setKozaMeigiKana(RString.EMPTY);
        委員Entity.setKozaNo(RString.EMPTY);
        return 委員Entity;
    }
}
