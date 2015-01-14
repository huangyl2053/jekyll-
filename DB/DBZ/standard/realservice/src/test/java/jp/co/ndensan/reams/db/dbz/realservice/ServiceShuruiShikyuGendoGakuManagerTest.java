/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.ServiceShuruiShikyuGendoGakuModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ServiceShuruiShikyuGendoGakuManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ServiceShuruiShikyuGendoGakuManagerTest {

    private static ServiceShuruiShikyuGendoGakuDac dac;
    private static ServiceShuruiShikyuGendoGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(ServiceShuruiShikyuGendoGakuDac.class);
        sut = new ServiceShuruiShikyuGendoGakuManager(dac);
    }

    public static class getサービス種類支給限度額Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_サービス種類支給限度額が返る() {

            Optional<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額モデル = Optional.ofNullable(createModel());

            when(dac.selectByKey(any(ServiceShuruiCode.class), any(IYokaigoJotaiKubun.class), any(FlexibleYearMonth.class), any(YMDHMS.class))).thenReturn(サービス種類支給限度額モデル);

            Optional<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額 = sut.getサービス種類支給限度額(
                    DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード,
                    YokaigoJotaiKubun09.toValue(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分),
                    DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月,
                    DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_処理日時);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(サービス種類支給限度額.get().get支給限度単位数(), is(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }
    }

    public static class getサービス種類支給限度額一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_サービス種類支給限度額のリストが返る() {

            List<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額モデルリスト = new ArrayList<>();
            サービス種類支給限度額モデルリスト.add(createModel());
            サービス種類支給限度額モデルリスト.add(createModel());
            IItemList<ServiceShuruiShikyuGendoGakuModel> list = ItemList.of(サービス種類支給限度額モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額リスト = sut.getサービス種類支給限度額一覧();
            assertThat(サービス種類支給限度額リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(サービス種類支給限度額リスト.toList().get(0).get支給限度単位数(), is(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
            assertThat(サービス種類支給限度額リスト.toList().get(1).get支給限度単位数(), is(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }
    }

    public static class getサービス種類支給限度額一覧基準日ありByキーTest extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_サービス種類支給限度額のリストが返る() {

            List<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額モデルリスト = new ArrayList<>();
            サービス種類支給限度額モデルリスト.add(createModel());
            サービス種類支給限度額モデルリスト.add(createModel());
            IItemList<ServiceShuruiShikyuGendoGakuModel> list = ItemList.of(サービス種類支給限度額モデルリスト);

            when(dac.selectサービス種類支給限度額リスト(any(IYokaigoJotaiKubun.class), any(FlexibleDate.class))).thenReturn(list);

            IItemList<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額リスト = sut.getサービス種類支給限度額一覧(
                    YokaigoJotaiKubun09.toValue(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分),
                    new FlexibleDate(new RString("20140831")));
            assertThat(サービス種類支給限度額リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(サービス種類支給限度額リスト.toList().get(0).get支給限度単位数(), is(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
            assertThat(サービス種類支給限度額リスト.toList().get(1).get支給限度単位数(), is(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }
    }

    public static class getサービス種類支給限度額一覧基準日なしByキーTest extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_サービス種類支給限度額のリストが返る() {

            List<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額モデルリスト = new ArrayList<>();
            サービス種類支給限度額モデルリスト.add(createModel());
            サービス種類支給限度額モデルリスト.add(createModel());
            IItemList<ServiceShuruiShikyuGendoGakuModel> list = ItemList.of(サービス種類支給限度額モデルリスト);

            when(dac.selectサービス種類支給限度額リスト(any(IYokaigoJotaiKubun.class))).thenReturn(list);

            IItemList<ServiceShuruiShikyuGendoGakuModel> サービス種類支給限度額リスト = sut.getサービス種類支給限度額一覧(
                    YokaigoJotaiKubun09.toValue(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
            assertThat(サービス種類支給限度額リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(サービス種類支給限度額リスト.toList().get(0).get支給限度単位数(), is(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
            assertThat(サービス種類支給限度額リスト.toList().get(1).get支給限度単位数(), is(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }
    }

    public static class saveサービス種類支給限度額 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(ServiceShuruiShikyuGendoGakuModel.class))).thenReturn(1);

            ServiceShuruiShikyuGendoGakuModel サービス種類支給限度額モデル = createModel();

            assertThat(sut.saveサービス種類支給限度額(サービス種類支給限度額モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(ServiceShuruiShikyuGendoGakuModel.class))).thenReturn(1);

            ServiceShuruiShikyuGendoGakuModel サービス種類支給限度額モデル = createModel();
            サービス種類支給限度額モデル.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            サービス種類支給限度額モデル.set支給限度単位数(new Decimal("11"));

            assertThat(sut.saveサービス種類支給限度額(サービス種類支給限度額モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(ServiceShuruiShikyuGendoGakuModel.class))).thenReturn(1);

            ServiceShuruiShikyuGendoGakuModel サービス種類支給限度額モデル = createModel();
            サービス種類支給限度額モデル.getEntity().initializeMd5();
            サービス種類支給限度額モデル.setDeletedState(true);

            assertThat(sut.saveサービス種類支給限度額(サービス種類支給限度額モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            ServiceShuruiShikyuGendoGakuModel サービス種類支給限度額モデル = createModel();
            サービス種類支給限度額モデル.getEntity().initializeMd5();

            sut.saveサービス種類支給限度額(サービス種類支給限度額モデル);
        }
    }

    private static ServiceShuruiShikyuGendoGakuModel createModel() {
        return new ServiceShuruiShikyuGendoGakuModel(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity());
    }
}
