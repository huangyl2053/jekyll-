/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.NinteiKekkaMapper;
import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiResultIdoJiyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TsuchiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TokuteiShippeiCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.YokaigoJotaiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5002NinteiKekkaJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteiResultMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.ur.urz.business._KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 要介護認定結果情報を変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteiKekkaMapperTest extends DbeTestBase {

    private static NinteiKekkaMapper sut;
    private static final ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("1234567890"));
    private static final YMDHMS 処理日時 = new YMDHMS(new RString("20140808102030"));
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static final KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("1000000000"));
    private static final FlexibleDate 要介護度認定年月日 = new FlexibleDate("20140101");
    private static final YokaigoJotaiKubunCode 要介護状態区分コード = new YokaigoJotaiKubunCode(new Code(new RString("1111111111")));
    private static final YokaigoJotaizoReiCode 要介護状態像例コード = new YokaigoJotaizoReiCode(new Code(new RString("2222222222")));
    private static final NinteiYukoKikanTsukisu 有効期間月数 = new NinteiYukoKikanTsukisu(1);
    private static final Range<FlexibleDate> 有効期間 = new Range(new FlexibleDate("20140202"), new FlexibleDate("20140303"));
    private static final IKaigoServiceShurui 介護サービス種類01 = create介護サービス種類("01");
    private static final IKaigoServiceShurui 介護サービス種類02 = create介護サービス種類("02");
    private static final IKaigoServiceShurui 介護サービス種類03 = create介護サービス種類("03");
    private static final IKaigoServiceShurui 介護サービス種類04 = create介護サービス種類("04");
    private static final IKaigoServiceShurui 介護サービス種類05 = create介護サービス種類("05");
    private static final IKaigoServiceShurui 介護サービス種類06 = create介護サービス種類("06");
    private static final IKaigoServiceShurui 介護サービス種類07 = create介護サービス種類("07");
    private static final IKaigoServiceShurui 介護サービス種類08 = create介護サービス種類("08");
    private static final IKaigoServiceShurui 介護サービス種類09 = create介護サービス種類("09");
    private static final IKaigoServiceShurui 介護サービス種類10 = create介護サービス種類("10");
    private static final IKaigoServiceShurui 介護サービス種類11 = create介護サービス種類("11");
    private static final IKaigoServiceShurui 介護サービス種類12 = create介護サービス種類("12");
    private static final IKaigoServiceShurui 介護サービス種類13 = create介護サービス種類("13");
    private static final IKaigoServiceShurui 介護サービス種類14 = create介護サービス種類("14");
    private static final IKaigoServiceShurui 介護サービス種類15 = create介護サービス種類("15");
    private static final IKaigoServiceShurui 介護サービス種類16 = create介護サービス種類("16");
    private static final IKaigoServiceShurui 介護サービス種類17 = create介護サービス種類("17");
    private static final IKaigoServiceShurui 介護サービス種類18 = create介護サービス種類("18");
    private static final IKaigoServiceShurui 介護サービス種類19 = create介護サービス種類("19");
    private static final IKaigoServiceShurui 介護サービス種類20 = create介護サービス種類("20");
    private static final IKaigoServiceShurui 介護サービス種類21 = create介護サービス種類("21");
    private static final IKaigoServiceShurui 介護サービス種類22 = create介護サービス種類("22");
    private static final IKaigoServiceShurui 介護サービス種類23 = create介護サービス種類("23");
    private static final IKaigoServiceShurui 介護サービス種類24 = create介護サービス種類("24");
    private static final IKaigoServiceShurui 介護サービス種類25 = create介護サービス種類("25");
    private static final IKaigoServiceShurui 介護サービス種類26 = create介護サービス種類("26");
    private static final IKaigoServiceShurui 介護サービス種類27 = create介護サービス種類("27");
    private static final IKaigoServiceShurui 介護サービス種類28 = create介護サービス種類("28");
    private static final IKaigoServiceShurui 介護サービス種類29 = create介護サービス種類("29");
    private static final IKaigoServiceShurui 介護サービス種類30 = create介護サービス種類("30");
    private static final ShisetsuNyushoKubun 施設入所区分 = ShisetsuNyushoKubun.入所している;
    private static final TokuteiShippeiCode 特定疾病コード = new TokuteiShippeiCode(new Code(new RString("3333333333")));
    private static final ShinsakaiKaisaiNo 審査会開催番号 = new ShinsakaiKaisaiNo(123);
    private static final ShinsakaiIkenType 審査会意見種類 = ShinsakaiIkenType.サービス利用への意見;
    private static final RString 審査会意見 = new RString("審査会意見");
    private static final RString 審査会メモ = new RString("審査会メモ");
    private static final RString 一次判定結果変更理由 = new RString("一次判定結果変更理由");
    private static final NinteiResultIdoJiyuKubun 認定結果異動事由区分 = NinteiResultIdoJiyuKubun.職権追加;
    private static final FlexibleDate 認定結果異動年月日 = new FlexibleDate("20140404");
    private static final RString 認定取消理由 = new RString("認定取消理由");
    private static final FlexibleDate 認定取消年月日 = new FlexibleDate("20140505");
    private static final TsuchiKubun 通知区分 = TsuchiKubun.認定;
    private static final RString 認定理由 = new RString("認定理由");
    private static final FlexibleDate IF送付年月日 = new FlexibleDate("20140601");

    public static class toNinteiResult extends DbeTestBase {

        private DbT5002NinteiKekkaJohoEntity entity;

        @Before
        public void setUp() {
            entity = DbT5002NinteiKekkaJohoEntityMock.getSpiedInstance();
        }

        @Test
        public void 申請書管理番号の設定がある時_toNinteiResultで生成した_NinteiResult_get申請書管理番号は_設定値を返す() {
            entity.setShinseishoKanriNo(申請書管理番号);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 証記載保険者番号の設定がある時_toNinteiResultで生成した_NinteiResult_get証記載保険者番号は_設定値を返す() {
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get証記載保険者番号(), is(証記載保険者番号));
        }

        @Test
        public void 被保険者番号の設定がある時_toNinteiResultで生成した_NinteiResult_get被保険者番号は_設定値を返す() {
            entity.setHihokenshaNo(被保険者番号);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 要介護度認定年月日の設定がある時_toNinteiResultで生成した_NinteiResult_get要介護度認定年月日は_設定値を返す() {
            entity.setYoukaigodoNinteiYMD(要介護度認定年月日);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get要介護度認定年月日(), is(要介護度認定年月日));
        }

        @Test
        public void 要介護状態区分コードの設定がある時_toNinteiResultで生成した_NinteiResult_get要介護状態_get要介護状態区分_getYokaigoJotaiKubunCode_設定値を返す() {
            entity.setYoukaigoJotaiKubunCode(要介護状態区分コード.asCode());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get要介護状態().get要介護状態区分().getYokaigoJotaiKubunCode(), is(要介護状態区分コード));
        }

        @Test
        public void 有効期間月数の設定がある時_toNinteiResultで生成した_NinteiResult_get要介護状態_get認定有効期間_get有効期間月数は_設定値を返す() {
            entity.setNinteiYukoKikan(有効期間月数.value());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get要介護状態().get認定有効期間().get有効期間月数(), is(有効期間月数));
        }

        @Test
        public void 有効開始年月日の設定がある時_toNinteiResultで生成した_NinteiResult_get要介護状態_get認定有効期間_get有効期間_getFromは_設定値を返す() {
            entity.setNinteiYukoKaishiYMD(有効期間.getFrom());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get要介護状態().get認定有効期間().get有効期間().getFrom(), is(有効期間.getFrom()));
        }

        @Test
        public void 有効終了年月日の設定がある時_toNinteiResultで生成した_NinteiResult_get要介護状態_get認定有効期間_get有効期間_getToは_設定値を返す() {
            entity.setNinteiYukoShuryoYMD(有効期間.getTo());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get要介護状態().get認定有効期間().get有効期間().getTo(), is(有効期間.getTo()));
        }

        @Test
        public void 要介護状態像例コードの設定がある時_toNinteiResultで生成した_NinteiResult_get要介護状態像例_getYokaigoJotaizoReiCodeは_設定値を返す() {
            entity.setYokaigoJotaizoReiCode(要介護状態像例コード.asCode());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get要介護状態像例().getYokaigoJotaizoReiCode(), is(要介護状態像例コード));
        }

        @Test
        public void 介護サービス種類の設定がある時_toNinteiResultで生成した_NinteiResult_get介護サービス種類は_設定値を返す() {
            entity.setKaigoServiceShurui01(介護サービス種類01.getサービス種類コード());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get介護サービス種類０１(), is(介護サービス種類01));
        }

        @Test
        public void 施設入所区分の設定がある時_toNinteiResultで生成した_NinteiResult_is施設入所区分は_設定値を返す() {
            entity.setShisetsuNyushoFlag(施設入所区分.is施設入所());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get施設入所区分(), is(施設入所区分));
        }

        @Test
        public void 特定疾病コードの設定がある時_toNinteiResultで生成した_NinteiResult_get特定疾病_getTokuteiShippeiKubunCodeは_設定値を返す() {
            entity.setTokuteiShippeiCode(特定疾病コード.asCode());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get特定疾病().getTokuteiShippeiKubunCode(), is(特定疾病コード));
        }

        @Test
        public void 審査会開催番号の設定がある時_toNinteiResultで生成した_NinteiResult_get認定審査会意見_get審査会開催番号は_設定値を返す() {
            entity.setShinsakaiKaisaiNo(審査会開催番号.value());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定審査会意見().get審査会開催番号(), is(審査会開催番号));
        }

        @Test
        public void 審査会意見種類の設定がある時_toNinteiResultで生成した_NinteiResult_get認定審査会意見_get審査会意見種類は_設定値を返す() {
            entity.setNinteishinsakaiIkenShurui(審査会意見種類.getCode());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定審査会意見().get審査会意見種類(), is(審査会意見種類));
        }

        @Test
        public void 審査会意見の設定がある時_toNinteiResultで生成した_NinteiResult_get認定審査会意見_get審査会意見は_設定値を返す() {
            entity.setShinsakaiIken(審査会意見);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定審査会意見().get審査会意見(), is(審査会意見));
        }

        @Test
        public void 審査会メモの設定がある時_toNinteiResultで生成した_NinteiResult_get認定審査会意見_get審査会メモは_設定値を返す() {
            entity.setShinsakaiMemo(審査会メモ);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定審査会意見().get審査会メモ(), is(審査会メモ));
        }

        @Test
        public void 一次判定結果変更理由の設定がある時_toNinteiResultで生成した_NinteiResult_get認定審査会意見_get一次判定結果変更理由は_設定値を返す() {
            entity.setIchijiHnateiKekkaHenkoRiyu(一次判定結果変更理由);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定審査会意見().get一次判定結果変更理由(), is(一次判定結果変更理由));
        }

        @Test
        public void 認定結果異動事由区分の設定がある時_toNinteiResultで生成した_NinteiResult_get認定結果異動_get認定結果異動事由区分は_設定値を返す() {
            entity.setNinteiKekkaIdoJiyu(認定結果異動事由区分.getCode());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定結果異動().get認定結果異動事由区分(), is(認定結果異動事由区分));
        }

        @Test
        public void 認定結果異動年月日の設定がある時_toNinteiResultで生成した_NinteiResult_get認定結果異動_get認定結果異動年月日は_設定値を返す() {
            entity.setNinteiKekkaIdoYMD(認定結果異動年月日);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定結果異動().get認定結果異動年月日(), is(認定結果異動年月日));
        }

        @Test
        public void 認定取消理由の設定がある時_toNinteiResultで生成した_NinteiResult_get認定取消_get認定取消理由は_設定値を返す() {
            entity.setNinteiTorikeshiRiyu(認定取消理由);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定取消().get認定取消理由(), is(認定取消理由));
        }

        @Test
        public void 認定取消年月日の設定がある時_toNinteiResultで生成した_NinteiResult_get認定取消_get認定取消年月日は_設定値を返す() {
            entity.setNinteiTorikeshiYMD(認定取消年月日);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定取消().get認定取消年月日(), is(認定取消年月日));
        }

        @Test
        public void 通知区分の設定がある時_toNinteiResultで生成した_NinteiResult_get通知区分は_設定値を返す() {
            entity.setTuchiKubun(通知区分.getCode());
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get通知区分(), is(通知区分));
        }

        @Test
        public void 認定理由の設定がある時_toNinteiResultで生成した_NinteiResult_get認定理由は_設定値を返す() {
            entity.setNinteiRiyu(認定理由);
            NinteiResult result = sut.toNinteiResult(entity, 介護サービス種類01, 介護サービス種類02, 介護サービス種類03, 介護サービス種類04,
                    介護サービス種類05, 介護サービス種類06, 介護サービス種類07, 介護サービス種類08, 介護サービス種類09, 介護サービス種類10,
                    介護サービス種類11, 介護サービス種類12, 介護サービス種類13, 介護サービス種類14, 介護サービス種類15, 介護サービス種類16,
                    介護サービス種類17, 介護サービス種類18, 介護サービス種類19, 介護サービス種類20, 介護サービス種類21, 介護サービス種類22,
                    介護サービス種類23, 介護サービス種類24, 介護サービス種類25, 介護サービス種類26, 介護サービス種類27, 介護サービス種類28,
                    介護サービス種類29, 介護サービス種類30);
            assertThat(result.get認定理由(), is(認定理由));
        }
    }

    public static class toDbT5002NinteiKekkaJohoEntity extends DbeTestBase {

        private NinteiResult ninteiResult;

        @Before
        public void setUp() {
            ninteiResult = NinteiResultMock.getSpiedInstance();
        }

        @Test
        public void 申請書管理番号の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            when(ninteiResult.get申請書管理番号()).thenReturn(申請書管理番号);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getShinseishoKanriNo(), is(申請書管理番号));
        }

        @Test
        public void 証記載保険者番号の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getShoKisaiHokenshaNoは_設定値を返す() {
            when(ninteiResult.get証記載保険者番号()).thenReturn(証記載保険者番号);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getShoKisaiHokenshaNo(), is(証記載保険者番号));
        }

        @Test
        public void 被保険者番号の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getHihokenshaNoは_設定値を返す() {
            when(ninteiResult.get被保険者番号()).thenReturn(被保険者番号);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getHihokenshaNo(), is(被保険者番号));
        }

        @Test
        public void 要介護度認定年月日の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getYoukaigodoNinteiYMDは_設定値を返す() {
            when(ninteiResult.get要介護度認定年月日()).thenReturn(要介護度認定年月日);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getYoukaigodoNinteiYMD(), is(要介護度認定年月日));
        }

        @Test
        public void 要介護状態区分コードの設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getYoukaigoJotaiKubunCodeは_設定値を返す() {
            when(ninteiResult.get要介護状態().get要介護状態区分().getYokaigoJotaiKubunCode()).thenReturn(要介護状態区分コード);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getYoukaigoJotaiKubunCode(), is(要介護状態区分コード.asCode()));
        }

        @Test
        public void 有効期間月数の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiYukoKikanは_設定値を返す() {
            when(ninteiResult.get要介護状態().get認定有効期間().get有効期間月数()).thenReturn(有効期間月数);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiYukoKikan(), is(有効期間月数.value()));
        }

        @Test
        public void 有効開始年月日の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiYukoKaishiYMDは_設定値を返す() {
            when(ninteiResult.get要介護状態().get認定有効期間().get有効期間()).thenReturn(有効期間);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiYukoKaishiYMD(), is(有効期間.getFrom()));
        }

        @Test
        public void 有効終了年月日の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiYukoShuryoYMDは_設定値を返す() {
            when(ninteiResult.get要介護状態().get認定有効期間().get有効期間()).thenReturn(有効期間);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiYukoShuryoYMD(), is(有効期間.getTo()));
        }

        @Test
        public void 特定疾病コードの設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getTokuteiShippeiCodeは_設定値を返す() {
            when(ninteiResult.get特定疾病().getTokuteiShippeiKubunCode()).thenReturn(特定疾病コード);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getTokuteiShippeiCode(), is(特定疾病コード.asCode()));
        }

        @Test
        public void 施設入所区分の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getShisetsuNyushoFlagは_設定値を返す() {
            when(ninteiResult.get施設入所区分()).thenReturn(施設入所区分);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getShisetsuNyushoFlag(), is(施設入所区分.is施設入所()));
        }

        @Test
        public void 審査会開催番号の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getShinsakaiKaisaiNoは_設定値を返す() {
            when(ninteiResult.get認定審査会意見().get審査会開催番号()).thenReturn(審査会開催番号);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getShinsakaiKaisaiNo(), is(審査会開催番号.value()));
        }

        @Test
        public void 審査会意見の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getShinsakaiIkenは_設定値を返す() {
            when(ninteiResult.get認定審査会意見().get審査会意見()).thenReturn(審査会意見);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getShinsakaiIken(), is(審査会意見));
        }

        @Test
        public void 一次判定結果変更理由の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getIchijiHnateiKekkaHenkoRiyuは_設定値を返す() {
            when(ninteiResult.get認定審査会意見().get一次判定結果変更理由()).thenReturn(一次判定結果変更理由);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getIchijiHnateiKekkaHenkoRiyu(), is(一次判定結果変更理由));
        }

        @Test
        public void 要介護状態像例コードの設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getYokaigoJotaizoReiCodeは_設定値を返す() {
            when(ninteiResult.get要介護状態像例().getYokaigoJotaizoReiCode()).thenReturn(要介護状態像例コード);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getYokaigoJotaizoReiCode(), is(要介護状態像例コード.asCode()));
        }

        @Test
        public void 審査会意見種類の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteishinsakaiIkenShuruiは_設定値を返す() {
            when(ninteiResult.get認定審査会意見().get審査会意見種類()).thenReturn(審査会意見種類);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteishinsakaiIkenShurui(), is(審査会意見種類.getCode()));
        }

        @Test
        public void 介護サービス種類の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getKaigoServiceShuruiは_設定値を返す() {
            when(ninteiResult.get介護サービス種類０１()).thenReturn(介護サービス種類01);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getKaigoServiceShurui01(), is(介護サービス種類01.getサービス種類コード()));
        }

        @Test
        public void 認定結果異動事由区分の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiKekkaIdoJiyuは_設定値を返す() {
            when(ninteiResult.get認定結果異動().get認定結果異動事由区分()).thenReturn(認定結果異動事由区分);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiKekkaIdoJiyu(), is(認定結果異動事由区分.getCode()));
        }

        @Test
        public void 認定結果異動年月日の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiKekkaIdoYMDは_設定値を返す() {
            when(ninteiResult.get認定結果異動().get認定結果異動年月日()).thenReturn(認定結果異動年月日);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiKekkaIdoYMD(), is(認定結果異動年月日));
        }

        @Test
        public void 認定取消理由の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiTorikeshiRiyuは_設定値を返す() {
            when(ninteiResult.get認定取消().get認定取消理由()).thenReturn(認定取消理由);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiTorikeshiRiyu(), is(認定取消理由));
        }

        @Test
        public void 認定取消年月日の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiTorikeshiYMDは_設定値を返す() {
            when(ninteiResult.get認定取消().get認定取消年月日()).thenReturn(認定取消年月日);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiTorikeshiYMD(), is(認定取消年月日));
        }

        @Test
        public void 認定理由の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getNinteiRiyuは_設定値を返す() {
            when(ninteiResult.get認定理由()).thenReturn(認定理由);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getNinteiRiyu(), is(認定理由));
        }

        @Test
        public void 通地区分の設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getTuchiKubunは_設定値を返す() {
            when(ninteiResult.get通知区分()).thenReturn(通知区分);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getTuchiKubun(), is(通知区分.getCode()));
        }

        @Test
        public void 審査会メモの設定がある時_toDbT5002NinteiKekkaJohoEntityで生成した_DbT5002NinteiKekkaJohoEntity_getShinsakaiMemoは_設定値を返す() {
            when(ninteiResult.get認定審査会意見().get審査会メモ()).thenReturn(審査会メモ);
            DbT5002NinteiKekkaJohoEntity result = sut.toDbT5002NinteiKekkaJohoEntity(ninteiResult);
            assertThat(result.getShinsakaiMemo(), is(審査会メモ));
        }
    }

    private static IKaigoServiceShurui create介護サービス種類(String code) {
        return new _KaigoServiceShurui(
                new RString(code), new Range<>(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX), new RString("サービス種類名称"),
                new RString("サービス種類名称略称"), new RString("サービス分類"));
    }
}
