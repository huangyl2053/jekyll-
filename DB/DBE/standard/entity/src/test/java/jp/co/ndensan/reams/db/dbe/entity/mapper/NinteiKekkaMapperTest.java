/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiKekkaIdoJiyu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5002NinteiKekkaJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiResultMock;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class NinteiKekkaMapperTest {

    public static class toNinteiResult {

        @Test
        public void 申請書管理番号の設定がある時_toNinteiResult_get申請書管理番号は_設定値を返す() {
            assertThat(toNinteiResult().get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護度認定年月日の設定がある時_toNinteiResult_get要介護度認定年月日は_設定値を返す() {
            assertThat(toNinteiResult().get要介護度認定年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 要介護状態区分の設定がある時_toNinteiResult_get要介護状態区分は_設定値を返す() {
            assertThat(toNinteiResult().get要介護状態区分().getYokaigoJotaiKubunCode().value(), is(new RString("コード")));
        }

        @Test
        public void 要介護状態像例の設定がある時_toNinteiResult_get要介護状態像例は_設定値を返す() {
            assertThat(toNinteiResult().get要介護状態像例().getYokaigoJotaizoReiCode().value(), is(new RString("コード")));
        }

        @Test
        public void 有効期間月数の設定がある時_toNinteiResult_get有効期間月数は_設定値を返す() {
            assertThat(toNinteiResult().get認定有効期間().get有効期間月数().value(), is(1));
        }

        @Test
        public void 有効開始年月日の設定がある時_toNinteiResult_get有効開始年月日は_設定値を返す() {
            assertThat(toNinteiResult().get認定有効期間().get有効期間().getFrom(), is(FlexibleDate.MIN));
        }

        @Test
        public void 有効終了年月日の設定がある時_toNinteiResult_get有効終了年月日は_設定値を返す() {
            assertThat(toNinteiResult().get認定有効期間().get有効期間().getTo(), is(FlexibleDate.MAX));
        }

        @Test
        public void 介護サービス種類の設定がある時_toNinteiResult_get介護サービス種類は_設定値を返す() {
            assertThat(toNinteiResult().get介護サービス種類(), is(KaigoServiceType.訪問介護));
        }

        @Test
        public void 施設入所有無の設定がある時_toNinteiResult_is施設入所有無は_設定値を返す() {
            assertThat(toNinteiResult().is施設入所有無(), is(true));
        }

        @Test
        public void 特定疾病区分の設定がある時_toNinteiResult_get特定疾病区分は_設定値を返す() {
            assertThat(toNinteiResult().get特定疾病区分().getTokuteiShippeiKubunCode().value(), is(new RString("コード")));
        }

        @Test
        public void 審査会開催番号の設定がある時_toNinteiResult_get審査会開催番号は_設定値を返す() {
            assertThat(toNinteiResult().get認定審査会意見().get審査会開催番号().value(), is(123));
        }

        @Test
        public void 審査会意見種類の設定がある時_toNinteiResult_get審査会意見種類は_設定値を返す() {
            assertThat(toNinteiResult().get認定審査会意見().get審査会意見種類(), is(ShinsakaiIkenShurui.サービス利用への意見));
        }

        @Test
        public void 審査会意見の設定がある時_toNinteiResult_get審査会意見は_設定値を返す() {
            assertThat(toNinteiResult().get認定審査会意見().get審査会意見(), is(new RString("審査会意見")));
        }

        @Test
        public void 審査会メモの設定がある時_toNinteiResult_get審査会メモは_設定値を返す() {
            assertThat(toNinteiResult().get認定審査会意見().get審査会メモ(), is(new RString("審査会メモ")));
        }

        @Test
        public void 一次判定結果変更理由の設定がある時_toNinteiResult_get一次判定結果変更理由は_設定値を返す() {
            assertThat(toNinteiResult().get認定理由().get一次判定結果変更理由(), is(new RString("一次判定結果変更理由")));
        }

        @Test
        public void 認定結果異動事由の設定がある時_toNinteiResult_get認定結果異動事由は_設定値を返す() {
            assertThat(toNinteiResult().get認定理由().get認定結果異動事由(), is(NinteiKekkaIdoJiyu.職権追加));
        }

        @Test
        public void 認定結果異動年月日の設定がある時_toNinteiResult_get認定結果異動年月日は_設定値を返す() {
            assertThat(toNinteiResult().get認定理由().get認定結果異動年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 認定取消理由の設定がある時_toNinteiResult_get認定取消理由は_設定値を返す() {
            assertThat(toNinteiResult().get認定理由().get認定取消理由(), is(new RString("認定取消理由")));
        }

        @Test
        public void 認定取消年月日の設定がある時_toNinteiResult_get認定取消年月日は_設定値を返す() {
            assertThat(toNinteiResult().get認定理由().get認定取消年月日(), is(FlexibleDate.MAX));
        }

        @Test
        public void 認定理由の設定がある時_toNinteiResult_get認定理由は_設定値を返す() {
            assertThat(toNinteiResult().get認定理由().get認定理由(), is(new RString("認定理由")));
        }
    }

    public static class toDbT5002NinteiKekkaJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getShinseishoKanriNo(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護度認定年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getYoukaigodoNinteiYMDは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getYoukaigodoNinteiYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 要介護状態区分の設定がある時_toDbT5002NinteiKekkaJohoEntity_getYoukaigoJotaiKubunCodeは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getYoukaigoJotaiKubunCode().value(), is(new RString("コード")));
        }

        @Test
        public void 有効期間月数の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiYukoKikanは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiYukoKikan(), is(1));
        }

        @Test
        public void 有効開始年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiYukoKaishiYMDは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiYukoKaishiYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 有効終了年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiYukoShuryoYMDは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiYukoShuryoYMD(), is(FlexibleDate.MAX));
        }

        @Test
        public void 特定疾病区分の設定がある時_toDbT5002NinteiKekkaJohoEntity_getTokuteiShippeiCodeは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getTokuteiShippeiCode().value(), is(new RString("コード")));
        }

        @Test
        public void 施設入所有無の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShisetsuNyushoFlagは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getShisetsuNyushoFlag(), is(true));
        }

        @Test
        public void 審査会開催番号の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinsakaiKaisaiNoは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getShinsakaiKaisaiNo(), is(123));
        }

        @Test
        public void 審査会意見の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinsakaiIkenは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getShinsakaiIken(), is(new RString("審査会意見")));
        }

        @Test
        public void 一次判定結果変更理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getIchijiHnateiKekkaHenkoRiyuは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getIchijiHnateiKekkaHenkoRiyu(), is(new RString("一次判定結果変更理由")));
        }

        @Test
        public void 要介護状態像例の設定がある時_toDbT5002NinteiKekkaJohoEntity_getYokaigoJotaizoReiCodeは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getYokaigoJotaizoReiCode().value(), is(new RString("コード")));
        }

        @Test
        public void 審査会意見種類の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteishinsakaiIkenShuruiは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteishinsakaiIkenShurui(), is(ShinsakaiIkenShurui.サービス利用への意見.getCode()));
        }

        @Test
        public void 介護サービス種類の設定がある時_toDbT5002NinteiKekkaJohoEntity_getKaigoServiceShuruiは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getKaigoServiceShurui(), is(KaigoServiceType.訪問介護.getCode()));
        }

        @Test
        public void 認定結果異動事由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiKekkaIdoJiyuは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiKekkaIdoJiyu(), is(NinteiKekkaIdoJiyu.職権追加.getCode()));
        }

        @Test
        public void 認定結果異動年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiKekkaIdoYMDは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiKekkaIdoYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 認定取消理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiTorikeshiRiyuは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiTorikeshiRiyu(), is(new RString("認定取消理由")));
        }

        @Test
        public void 認定取消年月日の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiTorikeshiYMDは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiTorikeshiYMD(), is(FlexibleDate.MAX));
        }

        @Test
        public void 認定理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getNinteiRiyuは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getNinteiRiyu(), is(new RString("認定理由")));
        }

        @Test
        public void 認定理由の設定がある時_toDbT5002NinteiKekkaJohoEntity_getShinsakaiMemoは_設定値を返す() {
            assertThat(toDbT5002NinteiKekkaJohoEntity().getShinsakaiMemo(), is(new RString("審査会メモ")));
        }
    }

    private static NinteiResult toNinteiResult() {
        return NinteiKekkaMapper.toNinteiResult(DbT5002NinteiKekkaJohoEntityMock.getSpiedInstance());
    }

    private static DbT5002NinteiKekkaJohoEntity toDbT5002NinteiKekkaJohoEntity() {
        return NinteiKekkaMapper.toDbT5002NinteiKekkaJohoEntity(NinteiResultMock.getSpiedInstance());
    }
}
