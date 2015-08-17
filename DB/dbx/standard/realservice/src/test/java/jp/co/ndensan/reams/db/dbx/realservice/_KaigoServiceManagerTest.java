/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoService;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceNaiyo;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceTani;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceNaiyo;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceTani;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.business.mapper.KaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IDbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IDbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.persistence.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.persistence.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;

/**
 * 介護サービスに関する情報を取得するためのマネージャークラスのテストクラスです。
 *
 * @author N9935 知念 広宰
 */
@RunWith(Enclosed.class)
public class _KaigoServiceManagerTest extends DbxTestBase {
    
    private static _KaigoServiceManager sut;
    private static IDbT7131KaigoServiceNaiyouDac mockDbT7131KaigoServiceNaiyouDac;
    private static IDbT7130KaigoServiceShuruiDac mockDbT7130KaigoServiceShuruiDac;
    private static IKaigoServiceShurui kaigoServiceShurui1;
    private static IKaigoServiceShurui kaigoServiceShurui2;
    private static IKaigoServiceShurui kaigoServiceShurui3;
    private static IKaigoServiceShurui kaigoServiceShurui4;
    private static IKaigoServiceCode kaigoServiceCode1;
    private static IKaigoServiceCode kaigoServiceCode2;
    private static IKaigoServiceCode kaigoServiceCode3;
    private static IKaigoServiceNaiyo kaigoServiceNaiyo1;
    private static IKaigoServiceNaiyo kaigoServiceNaiyo2;
    private static IKaigoServiceNaiyo kaigoServiceNaiyo3;
    private static IKaigoServiceNaiyo kaigoServiceNaiyo4;
    private static Range<FlexibleYearMonth> 提供年月1;
    private static Range<FlexibleYearMonth> 提供年月2;
    private static Range<FlexibleYearMonth> 提供年月3;
    private static Range<FlexibleYearMonth> 提供年月4;
    private static List<IKaigoServiceShurui> kaigoServiceShuruiList;
    private static List<IKaigoServiceShurui> kaigoServiceShuruiBunruiList;
    private static List<DbT7130KaigoServiceShuruiEntity> kaigoServiceShuruiEntityList1;
    private static List<DbT7130KaigoServiceShuruiEntity> kaigoServiceShuruiEntityList2;
    private static List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoEntityList;
    private static List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoEntityList2;
    private static List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoEntityNullList;
    private static List<DbT7130KaigoServiceShuruiEntity> kaigoServiceShuruiBunruiEntityList;
    private static List<DbT7130KaigoServiceShuruiEntity> kaigoServiceShuruiEntityNullList;
    private static DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity1;
    private static DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity2;
    private static DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity3;
    private static DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity4;
    private static DbT7131KaigoServiceNaiyouEntity KaigoServiceNaiyoEntity1;
    private static DbT7131KaigoServiceNaiyouEntity KaigoServiceNaiyoEntity2;
    private static DbT7131KaigoServiceNaiyouEntity KaigoServiceNaiyoEntity3;
    private static DbT7131KaigoServiceNaiyouEntity KaigoServiceNaiyoEntity4;
    final static int SUCCESS_NUMBER = 1;
    final static int FAILED_NUMBER = 0;
    private static IKaigoServiceTani サービス単位1;
    private static IKaigoServiceTani サービス単位2;
    private static IKaigoServiceTani サービス単位3;
    private static IKaigoServiceTani サービス単位4;

    @BeforeClass
    public static void setUpClass() {
        mockDbT7130KaigoServiceShuruiDac = mock(DbT7130KaigoServiceShuruiDac.class);
        mockDbT7131KaigoServiceNaiyouDac = mock(DbT7131KaigoServiceNaiyouDac.class);
        提供年月1 = new Range<>(new FlexibleYearMonth("201304"), new FlexibleYearMonth("201305"));
        提供年月2 = new Range<>(new FlexibleYearMonth("201304"), new FlexibleYearMonth("201307"));
        提供年月3 = new Range<>(new FlexibleYearMonth("201304"), new FlexibleYearMonth("201309"));
        提供年月4 = new Range<>(new FlexibleYearMonth("201304"), new FlexibleYearMonth("201309"));
        kaigoServiceShurui1 = new _KaigoServiceShurui(new KaigoServiceShuruiCode(new RString("01")), 提供年月1, new RString("種類名称１"), new RString("種類名称略称１"), new KaigoServiceBunruiCode(new RString("001")));
        kaigoServiceShurui2 = new _KaigoServiceShurui(new KaigoServiceShuruiCode(new RString("02")), 提供年月2, new RString("種類名称２"), new RString("種類名称略称２"), new KaigoServiceBunruiCode(new RString("002")));
        kaigoServiceShurui3 = new _KaigoServiceShurui(new KaigoServiceShuruiCode(new RString("03")), 提供年月3, new RString("種類名称３"), new RString("種類名称略称３"), new KaigoServiceBunruiCode(new RString("003")));
        kaigoServiceShurui4 = new _KaigoServiceShurui(new KaigoServiceShuruiCode(new RString("04")), 提供年月4, new RString("種類名称４"), new RString("種類名称略称４"), new KaigoServiceBunruiCode(new RString("001")));
        kaigoServiceShuruiList = new ArrayList<>();
        kaigoServiceShuruiList.add(kaigoServiceShurui1);
        kaigoServiceShuruiList.add(kaigoServiceShurui2);
        kaigoServiceShuruiList.add(kaigoServiceShurui3);
        kaigoServiceShuruiEntityList1 = new ArrayList<>();
        kaigoServiceShuruiEntity1 = KaigoServiceShuruiMapper.to介護サービス種類Entity(kaigoServiceShurui1);
        kaigoServiceShuruiEntity2 = KaigoServiceShuruiMapper.to介護サービス種類Entity(kaigoServiceShurui2);
        kaigoServiceShuruiEntity3 = KaigoServiceShuruiMapper.to介護サービス種類Entity(kaigoServiceShurui3);
        kaigoServiceShuruiEntityList2 = new ArrayList<>();
        kaigoServiceShuruiEntityList2.add(kaigoServiceShuruiEntity1);
        kaigoServiceShuruiEntityList1.add(kaigoServiceShuruiEntity1);
        kaigoServiceShuruiEntityList1.add(kaigoServiceShuruiEntity2);
        kaigoServiceShuruiEntityList1.add(kaigoServiceShuruiEntity3);
        kaigoServiceShuruiEntityNullList = new ArrayList<>();
        kaigoServiceShuruiEntityNullList = Collections.EMPTY_LIST;
        kaigoServiceShuruiBunruiEntityList = new ArrayList<>();
        kaigoServiceShuruiEntity1 = KaigoServiceShuruiMapper.to介護サービス種類Entity(kaigoServiceShurui1);
        kaigoServiceShuruiEntity4 = KaigoServiceShuruiMapper.to介護サービス種類Entity(kaigoServiceShurui4);
        kaigoServiceShuruiBunruiEntityList.add(kaigoServiceShuruiEntity1);
        kaigoServiceShuruiBunruiEntityList.add(kaigoServiceShuruiEntity4);
        kaigoServiceShuruiBunruiList = new ArrayList<>();
        kaigoServiceShuruiBunruiList.add(kaigoServiceShurui1);
        kaigoServiceShuruiBunruiList.add(kaigoServiceShurui4);
        kaigoServiceCode1 = new _KaigoServiceCode(new KaigoServiceShuruiCode(new RString("01")), new RString("2345"));
        kaigoServiceCode2 = new _KaigoServiceCode(new KaigoServiceShuruiCode(new RString("01")), new RString("8901"));
        kaigoServiceCode3 = new _KaigoServiceCode(new KaigoServiceShuruiCode(new RString("01")), new RString("4567"));
        サービス単位1 = new _KaigoServiceTani(3, new TanisuShikibetsu(new RString("001")), new TanisuSanteiTani(new RString("3000")));
        サービス単位2 = new _KaigoServiceTani(4, new TanisuShikibetsu(new RString("002")), new TanisuSanteiTani(new RString("3500")));
        サービス単位3 = new _KaigoServiceTani(5, new TanisuShikibetsu(new RString("003")), new TanisuSanteiTani(new RString("4000")));
        サービス単位4 = new _KaigoServiceTani(3, new TanisuShikibetsu(new RString("004")), new TanisuSanteiTani(new RString("3000")));
        kaigoServiceNaiyo1 = new _KaigoServiceNaiyo(kaigoServiceCode1, 提供年月1, 0, new RString("内容名称１"), new RString("内容名称略称１"), サービス単位1);
        kaigoServiceNaiyo2 = new _KaigoServiceNaiyo(kaigoServiceCode2, 提供年月2, 1, new RString("内容名称２"), new RString("内容名称略称２"), サービス単位2);
        kaigoServiceNaiyo3 = new _KaigoServiceNaiyo(kaigoServiceCode3, 提供年月3, 2, new RString("内容名称３"), new RString("内容名称略称３"), サービス単位3);
        kaigoServiceNaiyo4 = new _KaigoServiceNaiyo(kaigoServiceCode1, 提供年月1, 1, new RString("内容名称４"), new RString("内容名称略称４"), サービス単位4);
        KaigoServiceNaiyoEntity1 = makeKaigoServiceNaiyoEntity(kaigoServiceNaiyo1);
        KaigoServiceNaiyoEntity2 = makeKaigoServiceNaiyoEntity(kaigoServiceNaiyo2);
        KaigoServiceNaiyoEntity3 = makeKaigoServiceNaiyoEntity(kaigoServiceNaiyo3);
        KaigoServiceNaiyoEntity4 = makeKaigoServiceNaiyoEntity(kaigoServiceNaiyo4);
        kaigoServiceNaiyoEntityList = new ArrayList<>();
        kaigoServiceNaiyoEntityList.add(KaigoServiceNaiyoEntity1);
        kaigoServiceNaiyoEntityList.add(KaigoServiceNaiyoEntity2);
        kaigoServiceNaiyoEntityList.add(KaigoServiceNaiyoEntity3);
        kaigoServiceNaiyoEntityList2 = new ArrayList<>();
        kaigoServiceNaiyoEntityList2.add(KaigoServiceNaiyoEntity1);
        kaigoServiceNaiyoEntityList2.add(KaigoServiceNaiyoEntity4);
        kaigoServiceNaiyoEntityNullList = new ArrayList<>();
        kaigoServiceNaiyoEntityNullList = Collections.EMPTY_LIST;
    }

    public static class get介護サービス種類All extends DbxTestBase {

        @Test
        public void 基準年月が201304に該当するレコードが存在する時_getサービス種類ALLは該当する全てのI介護サービス種類を返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList1);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            List<IKaigoServiceShurui> result = sut.get介護サービス種類All(new FlexibleYearMonth("201304"));
            assertThat(result.size(), is(3));
            assertThat(result.get(0).getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get(0).get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get(0).get提供年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get(1).getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("02"))));
            assertThat(result.get(1).get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get(1).get提供年月().getTo(), is(new FlexibleYearMonth("201307")));
            assertThat(result.get(2).getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("03"))));
            assertThat(result.get(2).get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get(2).get提供年月().getTo(), is(new FlexibleYearMonth("201309")));
        }

        @Test
        public void 基準年月が201304に該当するレコードが存在しない時_getサービス種類ALLはCollections_EMPTY_LISTを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            List<IKaigoServiceShurui> result = sut.get介護サービス種類All(new FlexibleYearMonth("201304"));
            assertThat(result.size(), is(0));
        }

        @Test(expected = NullPointerException.class)
        public void 基準日がnullの時_getサービス種類ALLはNullPointerExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList1);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            List<IKaigoServiceShurui> result = sut.get介護サービス種類All(null);

        }
    }

    public static class get介護サービス extends DbxTestBase {

        @Test
        public void 条件_基準年月が201304_サービス種類が01に該当するレコードが存在する時_getサービス種類は該当する全てのI介護サービスを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList2);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス(new FlexibleYearMonth("201304"), new KaigoServiceShuruiCode(new RString("01")));
            assertThat(result.get介護サービス内容リスト().size(), is(3));
            assertThat(result.get介護サービス種類().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス種類().get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス種類().get提供年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get介護サービス内容リスト().get(0).getサービスコード().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス内容リスト().get(0).getサービスコード().getサービス項目コード(), is(new RString("2345")));
            assertThat(result.get介護サービス内容リスト().get(0).get適用年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス内容リスト().get(0).get適用年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get介護サービス内容リスト().get(1).getサービスコード().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス内容リスト().get(1).getサービスコード().getサービス項目コード(), is(new RString("8901")));
            assertThat(result.get介護サービス内容リスト().get(1).get適用年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス内容リスト().get(1).get適用年月().getTo(), is(new FlexibleYearMonth("201307")));
            assertThat(result.get介護サービス内容リスト().get(2).getサービスコード().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス内容リスト().get(2).getサービスコード().getサービス項目コード(), is(new RString("4567")));
            assertThat(result.get介護サービス内容リスト().get(2).get適用年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス内容リスト().get(2).get適用年月().getTo(), is(new FlexibleYearMonth("201309")));

        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準年月が201304_サービス種類のみ01に該当するレコードが存在しない時_getサービス種類はIllegalArgumentExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス(new FlexibleYearMonth("201304"), new KaigoServiceShuruiCode(new RString("01")));
        }

        @Test
        public void 基準年月が201304_サービス内容のみ01に該当するレコードが存在しない時_getサービス種類は該当する全てのI介護サービスを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList2);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス(new FlexibleYearMonth("201304"), new KaigoServiceShuruiCode(new RString("01")));
            assertThat(result.get介護サービス種類().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス種類().get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス種類().get提供年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get介護サービス内容リスト().size(), is(0));
        }

        @Test
        public void 基準年月が201304_サービス種類とサービス内容が01に該当するレコードが存在しない時_getサービス種類はnullを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス(new FlexibleYearMonth("201304"), new KaigoServiceShuruiCode(new RString("01")));
            assertThat(result, is(nullValue()));
        }

        @Test(expected = NullPointerException.class)
        public void 基準日がnullの時_get介護サービスはNullPointerExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList2);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス(null, new KaigoServiceShuruiCode(new RString("01")));
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類がnullの時_get介護サービスはNullPointerExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList2);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス(new FlexibleYearMonth("201304"), null);
        }
    }

    public static class get介護サービス種類 extends DbxTestBase {

        @Test
        public void 基準年月が201304_サービス分類が001に該当するレコードが存在する時_getサービス種類は該当する全てのI介護サービス種類を返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiBunruiEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            List<IKaigoServiceShurui> result = sut.get介護サービス種類(new FlexibleYearMonth("201304"), new RString("001"));
            assertThat(result.size(), is(2));
            assertThat(result.get(0).getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get(0).get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get(0).get提供年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get(0).getサービス分類(), is(new KaigoServiceBunruiCode(new RString("001"))));
            assertThat(result.get(1).getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("04"))));
            assertThat(result.get(1).get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get(1).get提供年月().getTo(), is(new FlexibleYearMonth("201309")));
            assertThat(result.get(1).getサービス分類(), is(new KaigoServiceBunruiCode(new RString("001"))));
        }

        @Test
        public void 基準年月が201304_サービス分類が001に該当するレコードが存在しない時_getサービス種類はCollections_EMPTY_LISTを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            List<IKaigoServiceShurui> result = sut.get介護サービス種類(new FlexibleYearMonth("201304"), new RString("001"));
            assertThat(result.size(), is(0));

        }

        @Test(expected = NullPointerException.class)
        public void 基準日がnullの時_get介護サービスはNullPointerExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiBunruiEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            List<IKaigoServiceShurui> result = sut.get介護サービス種類(null, new RString("001"));
        }

        @Test(expected = NullPointerException.class)
        public void サービス分類がnullの時_get介護サービスはNullPointerExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiBunruiEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            List<IKaigoServiceShurui> result = sut.get介護サービス種類(new FlexibleYearMonth("201304"), null);
        }
    }

    public static class get介護サービス内容 extends DbxTestBase {

        @Test
        public void 基準年月が201304_サービスコードが01_2345に該当するレコードが存在する時_getサービス内容は該当する全てのI介護サービスを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList2);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityList2);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス内容(new FlexibleYearMonth("201304"), kaigoServiceCode1);
            assertThat(result.get介護サービス内容リスト().size(), is(2));
            assertThat(result.get介護サービス種類().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス種類().get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス種類().get提供年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get介護サービス内容リスト().get(0).getサービスコード().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス内容リスト().get(0).getサービスコード().getサービス項目コード(), is(new RString("2345")));
            assertThat(result.get介護サービス内容リスト().get(0).get適用年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス内容リスト().get(0).get適用年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get介護サービス内容リスト().get(0).get履歴番号(), is(0));
            assertThat(result.get介護サービス内容リスト().get(1).getサービスコード().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス内容リスト().get(1).getサービスコード().getサービス項目コード(), is(new RString("2345")));
            assertThat(result.get介護サービス内容リスト().get(0).get適用年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス内容リスト().get(0).get適用年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get介護サービス内容リスト().get(1).get履歴番号(), is(1));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準年月が201304_サービス種類にサービスコードのサービス種類コードが01に該当するレコードが存在しない時_getサービス内容はIllegalArgumentExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス内容(new FlexibleYearMonth("201304"), kaigoServiceCode1);
        }

        @Test
        public void 基準年月が201304_サービス内容にサービスコードのサービス内容コードが01に該当するレコードが存在しない時_getサービス内容は該当する全てのI介護サービスを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityList2);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス内容(new FlexibleYearMonth("201304"), kaigoServiceCode1);
            assertThat(result.get介護サービス種類().getサービス種類コード(), is(new KaigoServiceShuruiCode(new RString("01"))));
            assertThat(result.get介護サービス種類().get提供年月().getFrom(), is(new FlexibleYearMonth("201304")));
            assertThat(result.get介護サービス種類().get提供年月().getTo(), is(new FlexibleYearMonth("201305")));
            assertThat(result.get介護サービス内容リスト().size(), is(0));
        }

        @Test
        public void 基準年月が201304_サービス種類とサービス内容が01に該当するレコードが存在しない時_getサービス内容はnullを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス内容(new FlexibleYearMonth("201304"), kaigoServiceCode1);
            assertThat(result, is(nullValue()));
        }

        @Test(expected = NullPointerException.class)
        public void 基準日がnullの時_get介護サービス内容はNullPointerExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス内容(null, kaigoServiceCode1);
        }

        @Test(expected = NullPointerException.class)
        public void サービスコードがnullの時_get介護サービス内容はNullPointerExceptionを返す() {
            when(mockDbT7130KaigoServiceShuruiDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceShuruiEntityNullList);
            when(mockDbT7131KaigoServiceNaiyouDac.selectList(any(ITrueFalseCriteria.class))).thenReturn(kaigoServiceNaiyoEntityNullList);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            IKaigoService result = sut.get介護サービス内容(new FlexibleYearMonth("201304"), null);
        }
    }

    public static class save介護サービス種類 extends DbxTestBase {

        @Test
        public void 介護サービス種類の更新が成功した時_save介護サービス内容は_1を返す() {
            when(mockDbT7130KaigoServiceShuruiDac.insertOrUpdate(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(SUCCESS_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.save介護サービス種類(kaigoServiceShurui1);
            assertThat(result, is(1));
        }

        @Test
        public void 介護サービス種類の更新が成功しなかった時_save介護サービス内容は_0を返す() {
            when(mockDbT7130KaigoServiceShuruiDac.insertOrUpdate(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(FAILED_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.save介護サービス種類(kaigoServiceShurui1);
            assertThat(result, is(0));
        }
    }

    public static class save介護サービス内容 extends DbxTestBase {

        @Test
        public void 介護サービス内容の更新が成功した時_save介護サービス内容は_1を返す() {
            when(mockDbT7131KaigoServiceNaiyouDac.insertOrUpdate(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(SUCCESS_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.save介護サービス内容(kaigoServiceNaiyo1);
            assertThat(result, is(1));
        }

        @Test
        public void 介護サービス内容の更新が成功しなかった時_save介護サービス内容は_0を返す() {
            when(mockDbT7131KaigoServiceNaiyouDac.insertOrUpdate(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(FAILED_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.save介護サービス内容(kaigoServiceNaiyo1);
            assertThat(result, is(0));
        }
    }

    public static class remove介護サービス種類 extends DbxTestBase {

        @Test
        public void 同一のサービス種類コードのデータが介護サービス種類に1件_介護サービス内容に1件で介護サービス種類の削除が成功した時_remove介護サービス内容は_2を返す() {
            when(mockDbT7130KaigoServiceShuruiDac.delete(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(SUCCESS_NUMBER);
            when(mockDbT7131KaigoServiceNaiyouDac.delete(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(SUCCESS_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.remove介護サービス種類(kaigoServiceShurui1);
            assertThat(result, is(2));
        }

        @Test
        public void 介護サービス種類のみに存在するデータで_介護サービス種類の削除が成功した時_remove介護サービス内容は_1を返す() {
            when(mockDbT7130KaigoServiceShuruiDac.delete(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(SUCCESS_NUMBER);
            when(mockDbT7131KaigoServiceNaiyouDac.delete(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(FAILED_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.remove介護サービス種類(kaigoServiceShurui1);
            assertThat(result, is(1));
        }

        @Test
        public void 介護サービス種類の削除が成功した時_remove介護サービス内容は_0を返す() {
            when(mockDbT7130KaigoServiceShuruiDac.delete(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(FAILED_NUMBER);
            when(mockDbT7131KaigoServiceNaiyouDac.delete(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(FAILED_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.remove介護サービス種類(kaigoServiceShurui1);
            assertThat(result, is(0));
        }
    }

    public static class remove介護サービス内容 extends DbxTestBase {

        @Test
        public void 介護サービス内容の削除が成功した時_remove介護サービス内容は_1を返す() {
            when(mockDbT7131KaigoServiceNaiyouDac.delete(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(SUCCESS_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.remove介護サービス内容(kaigoServiceNaiyo1);
            assertThat(result, is(1));
        }

        @Test
        public void 介護サービス内容の削除が成功した時_remove介護サービス内容は_0を返す() {
            when(mockDbT7131KaigoServiceNaiyouDac.delete(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(FAILED_NUMBER);
            _KaigoServiceManager sut = new _KaigoServiceManager(mockDbT7130KaigoServiceShuruiDac, mockDbT7131KaigoServiceNaiyouDac);
            int result = sut.remove介護サービス内容(kaigoServiceNaiyo1);
            assertThat(result, is(0));
        }
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoServiceManagerが呼び出される場合_KaigoServiceManager_インスタンス化成功() {
            sut = new _KaigoServiceManager();
        }
    }

    private static DbT7131KaigoServiceNaiyouEntity makeKaigoServiceNaiyoEntity(IKaigoServiceNaiyo kaigoServiceNaiyo) {
        DbT7131KaigoServiceNaiyouEntity entity = new DbT7131KaigoServiceNaiyouEntity();

        entity.setServiceShuruiCode(kaigoServiceNaiyo.getサービスコード().getサービス種類コード());
        entity.setServiceKoumokuCode(kaigoServiceNaiyo.getサービスコード().getサービス項目コード());
        entity.setTeikyoKaishiYM(kaigoServiceNaiyo.get適用年月().getFrom());
        entity.setTeikyoShuryoYM(kaigoServiceNaiyo.get適用年月().getTo());
        entity.setRirekiNo(new Decimal(kaigoServiceNaiyo.get履歴番号()));
        entity.setServiceName(kaigoServiceNaiyo.getサービス名称());
        entity.setServiceNameRyaku(kaigoServiceNaiyo.getサービス略称());
        entity.setTaniSu(kaigoServiceNaiyo.get介護サービス単位().get単位数());
        entity.setTanisuShikibetsuCode(kaigoServiceNaiyo.get介護サービス単位().get単位数識別());
        entity.setTanisuSanteiTani(kaigoServiceNaiyo.get介護サービス単位().get単位数算定単位());

        return entity;
    }
}
