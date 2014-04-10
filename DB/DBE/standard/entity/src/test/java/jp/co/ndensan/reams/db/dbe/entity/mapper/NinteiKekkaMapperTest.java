/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiResultIdoJiyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TokuteiShippeiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.YokaigoJotaiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5002NinteiKekkaJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiResultMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定結果情報を変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteiKekkaMapperTest extends DbeTestBase {

    private static final ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("1234567890"));
    private static final FlexibleDate 要介護度認定年月日 = new FlexibleDate("20140101");
    private static final YokaigoJotaiKubunCode 要介護状態区分コード = new YokaigoJotaiKubunCode(new Code(new RString("1111111111")));
    private static final YokaigoJotaizoReiCode 要介護状態像例コード = new YokaigoJotaizoReiCode(new Code(new RString("2222222222")));
    private static final NinteiYukoKikanTsukisu 有効期間月数 = new NinteiYukoKikanTsukisu(1);
    private static final FlexibleDate 有効開始年月日 = new FlexibleDate("20140202");
    private static final FlexibleDate 有効終了年月日 = new FlexibleDate("20140303");
    private static final KaigoServiceType 介護サービス種類 = KaigoServiceType.訪問介護;
    private static final ShisetsuNyushoKubun 施設入所区分 = ShisetsuNyushoKubun.入所している;
    private static final TokuteiShippeiKubunCode 特定疾病区分コード = new TokuteiShippeiKubunCode(new Code(new RString("3333333333")));
    private static final ShinsakaiKaisaiNo 審査会開催番号 = new ShinsakaiKaisaiNo(123);
    private static final ShinsakaiIkenType 審査会意見種類 = ShinsakaiIkenType.サービス利用への意見;
    private static final RString 審査会意見 = new RString("審査会意見");
    private static final RString 審査会メモ = new RString("審査会メモ");
    private static final RString 一次判定結果変更理由 = new RString("一次判定結果変更理由");
    private static final NinteiResultIdoJiyuKubun 認定結果異動事由区分 = NinteiResultIdoJiyuKubun.職権追加;
    private static final FlexibleDate 認定結果異動年月日 = new FlexibleDate("20140404");
    private static final RString 認定取消理由 = new RString("認定取消理由");
    private static final FlexibleDate 認定取消年月日 = new FlexibleDate("20140505");
    private static final RString 認定理由 = new RString("認定理由");

    public static class toNinteiResult extends DbeTestBase {

        private NinteiResult result;

        @Before
        public void setUp() {
            result = NinteiKekkaMapper.toNinteiResult(DbT5002NinteiKekkaJohoEntityMock.getSpiedInstance());
        }

        @Test
        public void 申請書管理番号の設定がある時_toNinteiResult_get申請書管理番号は_設定値を返す() {
            assertThat(result.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 要介護度認定年月日の設定がある時_toNinteiResult_get要介護度認定年月日は_設定値を返す() {
            assertThat(result.get要介護度認定年月日(), is(要介護度認定年月日));
        }

        @Test
        public void 要介護状態区分の設定がある時_toNinteiResult_get要介護状態区分は_設定値を返す() {
            assertThat(result.get要介護状態().get要介護状態区分().getYokaigoJotaiKubunCode(), is(要介護状態区分コード));
        }

        @Test
        public void 要介護状態像例の設定がある時_toNinteiResult_get要介護状態像例は_設定値を返す() {
            assertThat(result.get要介護状態像例().getYokaigoJotaizoReiCode(), is(要介護状態像例コード));
        }

        @Test
        public void 有効期間月数の設定がある時_toNinteiResult_get有効期間月数は_設定値を返す() {
            assertThat(result.get要介護状態().get認定有効期間().get有効期間月数(), is(有効期間月数));
        }

        @Test
        public void 有効開始年月日の設定がある時_toNinteiResult_get有効開始年月日は_設定値を返す() {
            assertThat(result.get要介護状態().get認定有効期間().get有効期間().getFrom(), is(有効開始年月日));
        }

        @Test
        public void 有効終了年月日の設定がある時_toNinteiResult_get有効終了年月日は_設定値を返す() {
            assertThat(result.get要介護状態().get認定有効期間().get有効期間().getTo(), is(有効終了年月日));
        }

        @Test
        public void 介護サービス種類の設定がある時_toNinteiResult_get介護サービス種類は_設定値を返す() {
            assertThat(result.get介護サービス種類(), is(介護サービス種類));
        }

        @Test
        public void 施設入所区分の設定がある時_toNinteiResult_is施設入所区分は_設定値を返す() {
            assertThat(result.get施設入所区分(), is(施設入所区分));
        }

        @Test
        public void 特定疾病区分の設定がある時_toNinteiResult_get特定疾病区分は_設定値を返す() {
            assertThat(result.get特定疾病区分().getTokuteiShippeiKubunCode(), is(特定疾病区分コード));
        }

        @Test
        public void 審査会開催番号の設定がある時_toNinteiResult_get審査会開催番号は_設定値を返す() {
            assertThat(result.get認定審査会意見().get審査会開催番号(), is(審査会開催番号));
        }

        @Test
        public void 審査会意見種類の設定がある時_toNinteiResult_get審査会意見種類は_設定値を返す() {
            assertThat(result.get認定審査会意見().get審査会意見種類(), is(審査会意見種類));
        }

        @Test
        public void 審査会意見の設定がある時_toNinteiResult_get審査会意見は_設定値を返す() {
            assertThat(result.get認定審査会意見().get審査会意見(), is(審査会意見));
        }

        @Test
        public void 審査会メモの設定がある時_toNinteiResult_get審査会メモは_設定値を返す() {
            assertThat(result.get認定審査会意見().get審査会メモ(), is(審査会メモ));
        }

        @Test
        public void 一次判定結果変更理由の設定がある時_toNinteiResult_get一次判定結果変更理由は_設定値を返す() {
            assertThat(result.get認定理由().get一次判定結果変更理由(), is(一次判定結果変更理由));
        }

        @Test
        public void 認定結果異動事由区分の設定がある時_toNinteiResult_get認定結果異動事由区分は_設定値を返す() {
            assertThat(result.get認定理由().get認定結果異動事由().get認定結果異動事由区分(), is(認定結果異動事由区分));
        }

        @Test
        public void 認定結果異動年月日の設定がある時_toNinteiResult_get認定結果異動年月日は_設定値を返す() {
            assertThat(result.get認定理由().get認定結果異動事由().get認定結果異動年月日(), is(認定結果異動年月日));
        }

        @Test
        public void 認定取消理由の設定がある時_toNinteiResult_get認定取消理由は_設定値を返す() {
            assertThat(result.get認定理由().get認定取消理由().get認定取消理由(), is(認定取消理由));
        }

        @Test
        public void 認定取消年月日の設定がある時_toNinteiResult_get認定取消年月日は_設定値を返す() {
            assertThat(result.get認定理由().get認定取消理由().get認定取消年月日(), is(認定取消年月日));
        }

        @Test
        public void 認定理由の設定がある時_toNinteiResult_get認定理由は_設定値を返す() {
            assertThat(result.get認定理由().get認定理由(), is(認定理由));
        }
    }

    public static class toDbT5002NinteiKekkaJohoEntity extends DbeTestBase {

        private DbT5002NinteiKekkaJohoEntity result;

        @Before
        public void setUp() {
            result = NinteiKekkaMapper.toDbT5002NinteiKekkaJohoEntity(NinteiResultMock.getSpiedInstance());
        }

        @Test
        public void 申請書管理番号の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(result.getShinseishoKanriNo(), is(申請書管理番号.value()));
        }

        @Test
        public void 要介護度認定年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getYoukaigodoNinteiYMDは_設定値を返す() {
            assertThat(result.getYoukaigodoNinteiYMD(), is(要介護度認定年月日));
        }

        @Test
        public void 要介護状態区分の設定がある時_toDbT5002NinteiKekkaJohoEntity_getYoukaigoJotaiKubunCodeは_設定値を返す() {
            assertThat(result.getYoukaigoJotaiKubunCode(), is(要介護状態区分コード.asCode()));
        }

        @Test
        public void 有効期間月数の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiYukoKikanは_設定値を返す() {
            assertThat(result.getNinteiYukoKikan(), is(有効期間月数.value()));
        }

        @Test
        public void 有効開始年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiYukoKaishiYMDは_設定値を返す() {
            assertThat(result.getNinteiYukoKaishiYMD(), is(有効開始年月日));
        }

        @Test
        public void 有効終了年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiYukoShuryoYMDは_設定値を返す() {
            assertThat(result.getNinteiYukoShuryoYMD(), is(有効終了年月日));
        }

        @Test
        public void 特定疾病区分の設定がある時_toDbT5002NinteiKekkaJohoEntity_getTokuteiShippeiCodeは_設定値を返す() {
            assertThat(result.getTokuteiShippeiCode(), is(特定疾病区分コード.asCode()));
        }

        @Test
        public void 施設入所区分の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShisetsuNyushoFlagは_設定値を返す() {
            assertThat(result.getShisetsuNyushoFlag(), is(施設入所区分.is施設入所()));
        }

        @Test
        public void 審査会開催番号の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinsakaiKaisaiNoは_設定値を返す() {
            assertThat(result.getShinsakaiKaisaiNo(), is(審査会開催番号.value()));
        }

        @Test
        public void 審査会意見の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinsakaiIkenは_設定値を返す() {
            assertThat(result.getShinsakaiIken(), is(審査会意見));
        }

        @Test
        public void 一次判定結果変更理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getIchijiHnateiKekkaHenkoRiyuは_設定値を返す() {
            assertThat(result.getIchijiHnateiKekkaHenkoRiyu(), is(一次判定結果変更理由));
        }

        @Test
        public void 要介護状態像例の設定がある時_toDbT5002NinteiKekkaJohoEntity_getYokaigoJotaizoReiCodeは_設定値を返す() {
            assertThat(result.getYokaigoJotaizoReiCode(), is(要介護状態像例コード.asCode()));
        }

        @Test
        public void 審査会意見種類の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteishinsakaiIkenShuruiは_設定値を返す() {
            assertThat(result.getNinteishinsakaiIkenShurui(), is(審査会意見種類.getCode()));
        }

        @Test
        public void 介護サービス種類の設定がある時_toDbT5002NinteiKekkaJohoEntity_getKaigoServiceShuruiは_設定値を返す() {
            assertThat(result.getKaigoServiceShurui(), is(介護サービス種類.getCode()));
        }

        @Test
        public void 認定結果異動事由区分の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiKekkaIdoJiyuは_設定値を返す() {
            assertThat(result.getNinteiKekkaIdoJiyu(), is(認定結果異動事由区分.getCode()));
        }

        @Test
        public void 認定結果異動年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiKekkaIdoYMDは_設定値を返す() {
            assertThat(result.getNinteiKekkaIdoYMD(), is(認定結果異動年月日));
        }

        @Test
        public void 認定取消理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiTorikeshiRiyuは_設定値を返す() {
            assertThat(result.getNinteiTorikeshiRiyu(), is(認定取消理由));
        }

        @Test
        public void 認定取消年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiTorikeshiYMDは_設定値を返す() {
            assertThat(result.getNinteiTorikeshiYMD(), is(認定取消年月日));
        }

        @Test
        public void 認定理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiRiyuは_設定値を返す() {
            assertThat(result.getNinteiRiyu(), is(認定理由));
        }

        @Test
        public void 認定理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinsakaiMemoは_設定値を返す() {
            assertThat(result.getShinsakaiMemo(), is(審査会メモ));
        }
    }
}
