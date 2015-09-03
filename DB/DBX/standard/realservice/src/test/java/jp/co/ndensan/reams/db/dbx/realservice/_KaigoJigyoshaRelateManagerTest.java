/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.relate.helper.KaigoJigyoshaRelateEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.relate.KaigoJigyoshaRelateDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link _KaigoJigyoshaRelateManager}のテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class _KaigoJigyoshaRelateManagerTest {

    private static KaigoJigyoshaRelateDac dac;
    private static _KaigoJigyoshaRelateManager sut;
    private static final FlexibleDate 有効開始日1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
    private static final FlexibleDate 有効開始日2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日.minusDay(10);
    private static final KaigoJigyoshaNo 事業者番号 = new KaigoJigyoshaNo("9999999999");

    @BeforeClass
    public static void test() {
        dac = mock(KaigoJigyoshaRelateDac.class);
        sut = new _KaigoJigyoshaRelateManager(dac);
    }

    public static class findLatestJigyoshaTest extends DbxTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_最新の介護事業者RelateEntityが返る() {
            List<KaigoJigyoshaRelateEntity> 介護事業者RelateEntityリスト = new ArrayList<>();
            介護事業者RelateEntityリスト.add(
                    KaigoJigyoshaRelateEntityGenerator.createKaigoJigyoshaRelateEntity(有効開始日1));
            介護事業者RelateEntityリスト.add(
                    KaigoJigyoshaRelateEntityGenerator.createKaigoJigyoshaRelateEntity(有効開始日2));
            when(dac.selectByJigyoshaNo(介護事業者RelateEntityリスト.get(0).get事業者エンティティ().getJigyoshaNo())).thenReturn(介護事業者RelateEntityリスト);

            KaigoJigyosha 介護事業者 = sut.findLatestJigyosha(介護事業者RelateEntityリスト.get(0).get事業者エンティティ().getJigyoshaNo());

            assertThat(介護事業者.get事業者番号(), is(介護事業者RelateEntityリスト.get(0).get事業者エンティティ().getJigyoshaNo()));
            assertThat(介護事業者.get有効開始日(), is(介護事業者RelateEntityリスト.get(0).get事業者エンティティ().getYukoKaishiYMD()));
            assertThat(介護事業者.createDaihyosha().get有効開始日(), is(介護事業者RelateEntityリスト.get(0).get事業者代表者エンティティ().getYukoKaishiYMD()));
            assertThat(介護事業者.createShiteiServiceList().size(), is(介護事業者RelateEntityリスト.get(0).get事業者指定サービスエンティティリスト().size()));
        }

        @Test
        public void データが見つからない検索条件を指定した場合_nullが返る() {
            List<KaigoJigyoshaRelateEntity> 介護事業者RelateEntityリスト = new ArrayList<>();
            when(dac.selectByJigyoshaNo(事業者番号)).thenReturn(介護事業者RelateEntityリスト);
            assertThat(sut.findLatestJigyosha(事業者番号), is(nullValue()));
        }
    }

    public static class saveTest extends DbxTestBase {

        @Test(expected = ApplicationException.class)
        public void 引数がnullの場合_savaは_ApplicationExceptionを返る() {
            sut.save(null);
        }

    }
    //TODO n3317塚田萌　更新方法が確定したら対応する
    //    public static class saveTest extends DbxTestBase {
    //
    //        @Test
    //        public void insertに成功すると1が返る() {
    //            when(dac.insert(any(KaigoJigyoshaRelateEntity.class))).thenReturn(1);
    //            KaigoJigyoshaRelateEntity 介護事業者RelateEntity = KaigoJigyoshaRelateEntityTestHelper.createEntity1();
    //
    //            assertThat(sut.save(介護事業者RelateEntity), is(1));
    //        }
    //
    //        @Test
    //        public void updateに成功すると1が返る() {
    //            when(dac.update(any(KaigoJigyoshaRelateEntity.class))).thenReturn(1);
    //
    //            KaigoJigyoshaRelateEntity 介護事業者RelateEntity = KaigoJigyoshaRelateEntityTestHelper.createEntity1();
    //            介護事業者RelateEntity.get介護事業者Entity().getEntity().initializeMd5();
    //            介護事業者RelateEntity.get介護事業者代表者Entity().getEntity().initializeMd5();
    //            for (KaigoJigyoshaShiteiServiceEntity item : 介護事業者RelateEntity.get介護事業者指定サービスEntityList()) {
    //                item.getEntity().initializeMd5();
    //            }
    //            介護事業者RelateEntity.get介護事業者Entity().set宛先人名(new AtenaMeisho("テスト"));
    //            介護事業者RelateEntity.get介護事業者代表者Entity().set有効開始日(有効開始日.plusDay(1));
    //            介護事業者RelateEntity.get介護事業者指定サービスEntityList().get(0).set事業開始日(
    //                    UrT0521KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業開始日.plusDay(1));
    //
    //            assertThat(sut.save(介護事業者RelateEntity), is(1));
    //        }
    //
    //        @Test
    //        public void deleteに成功すると1が返る() {
    //            when(dac.delete(any(KaigoJigyoshaRelateEntity.class))).thenReturn(1);
    //
    //            KaigoJigyoshaRelateEntity 介護事業者RelateEntity = KaigoJigyoshaRelateEntityTestHelper.createEntity1();
    //            介護事業者RelateEntity.get介護事業者Entity().getEntity().initializeMd5();
    //            介護事業者RelateEntity.get介護事業者代表者Entity().getEntity().initializeMd5();
    //            for (KaigoJigyoshaShiteiServiceEntity item : 介護事業者RelateEntity.get介護事業者指定サービスEntityList()) {
    //                item.getEntity().initializeMd5();
    //            }
    //            介護事業者RelateEntity.get介護事業者Entity().setDeletedState(true);
    //            介護事業者RelateEntity.get介護事業者代表者Entity().setDeletedState(true);
    //            for (KaigoJigyoshaShiteiServiceEntity item : 介護事業者RelateEntity.get介護事業者指定サービスEntityList()) {
    //                item.setDeletedState(true);
    //            }
    //
    //            assertThat(sut.save(介護事業者RelateEntity), is(1));
    //        }
    //
    //        @Test(expected = ApplicationException.class)
    //        public void Entityの状態がUnchangedの場合_ApplicationExceptionが発生する() {
    //
    //            KaigoJigyoshaRelateEntity 介護事業者RelateEntity = KaigoJigyoshaRelateEntityTestHelper.createEntity1();
    //            介護事業者RelateEntity.get介護事業者Entity().getEntity().initializeMd5();
    //            介護事業者RelateEntity.get介護事業者代表者Entity().getEntity().initializeMd5();
    //            for (KaigoJigyoshaShiteiServiceEntity item : 介護事業者RelateEntity.get介護事業者指定サービスEntityList()) {
    //                item.getEntity().initializeMd5();
    //            }
    //
    //            sut.save(介護事業者RelateEntity);
    //        }
    //    }
}
