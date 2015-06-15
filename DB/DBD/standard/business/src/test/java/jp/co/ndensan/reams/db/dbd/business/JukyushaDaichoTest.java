/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaDaicho}のテストクラスです。
 *
 * @author n8235 船山洋介
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoTest extends DbdTestBase {

    public static class getterSetterTest extends DbdTestBase {

        private static JukyushaDaicho sut;

        @BeforeClass
        public static void test() {
            sut = new JukyushaDaicho(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の枝番は_設定した値と同じ枝番を返す() {
            assertThat(sut.get枝番(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_枝番));
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の申請状況区分は_設定した値と同じ申請状況区分を返す() {
            assertThat(sut.get申請状況区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請状況区分));
        }

        @Test
        public void 戻り値の支所コードは_設定した値と同じ支所コードを返す() {
            assertThat(sut.get支所コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支所コード));
        }

        @Test
        public void 戻り値の直近フラグは_設定した値と同じ直近フラグを返す() {
            assertThat(sut.get直近フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近フラグ));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            assertThat(sut.get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の受給申請事由は_設定した値と同じ受給申請事由を返す() {
            assertThat(sut.get受給申請事由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由));
        }

        @Test
        public void 戻り値の申請理由は_設定した値と同じ申請理由を返す() {
            assertThat(sut.get申請理由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void 戻り値の届出者_申請者関係コードは_設定した値と同じ届出者_申請者関係コードを返す() {
            assertThat(sut.get届出者_申請者関係コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_申請者関係コード));
        }

        @Test
        public void 戻り値の届出者_本人との関係は_設定した値と同じ届出者_本人との関係を返す() {
            assertThat(sut.get届出者_本人との関係(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_本人との関係));
        }

        @Test
        public void 戻り値の受給申請年月日は_設定した値と同じ受給申請年月日を返す() {
            assertThat(sut.get受給申請年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請年月日));
        }

        @Test
        public void 戻り値の二号特定疾病コードは_設定した値と同じ二号特定疾病コードを返す() {
            assertThat(sut.get二号特定疾病コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_二号特定疾病コード));
        }

        @Test
        public void 戻り値の審査会依頼年月日は_設定した値と同じ審査会依頼年月日を返す() {
            assertThat(sut.get審査会依頼年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_審査会依頼年月日));
        }

        @Test
        public void 戻り値の要介護認定状態区分コードは_設定した値と同じ要介護認定状態区分コードを返す() {
            assertThat(sut.get要介護認定状態区分コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要介護認定状態区分コード));
        }

        @Test
        public void 戻り値の認定有効期間開始年月日は_設定した値と同じ認定有効期間開始年月日を返す() {
            assertThat(sut.get認定有効期間開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間開始年月日));
        }

        @Test
        public void 戻り値の認定有効期間終了年月日は_設定した値と同じ認定有効期間終了年月日を返す() {
            assertThat(sut.get認定有効期間終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間終了年月日));
        }

        @Test
        public void 戻り値の認定年月日は_設定した値と同じ認定年月日を返す() {
            assertThat(sut.get認定年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定年月日));
        }

        @Test
        public void 戻り値の指定サービス種類01は_設定した値と同じ指定サービス種類01を返す() {
            assertThat(sut.get指定サービス種類01(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類01));
        }

        @Test
        public void 戻り値の指定サービス種類02は_設定した値と同じ指定サービス種類02を返す() {
            assertThat(sut.get指定サービス種類02(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類02));
        }

        @Test
        public void 戻り値の指定サービス種類03は_設定した値と同じ指定サービス種類03を返す() {
            assertThat(sut.get指定サービス種類03(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類03));
        }

        @Test
        public void 戻り値の指定サービス種類04は_設定した値と同じ指定サービス種類04を返す() {
            assertThat(sut.get指定サービス種類04(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類04));
        }

        @Test
        public void 戻り値の指定サービス種類05は_設定した値と同じ指定サービス種類05を返す() {
            assertThat(sut.get指定サービス種類05(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類05));
        }

        @Test
        public void 戻り値の指定サービス種類06は_設定した値と同じ指定サービス種類06を返す() {
            assertThat(sut.get指定サービス種類06(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類06));
        }

        @Test
        public void 戻り値の指定サービス種類07は_設定した値と同じ指定サービス種類07を返す() {
            assertThat(sut.get指定サービス種類07(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類07));
        }

        @Test
        public void 戻り値の指定サービス種類08は_設定した値と同じ指定サービス種類08を返す() {
            assertThat(sut.get指定サービス種類08(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類08));
        }

        @Test
        public void 戻り値の指定サービス種類09は_設定した値と同じ指定サービス種類09を返す() {
            assertThat(sut.get指定サービス種類09(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類09));
        }

        @Test
        public void 戻り値の指定サービス種類10は_設定した値と同じ指定サービス種類10を返す() {
            assertThat(sut.get指定サービス種類10(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類10));
        }

        @Test
        public void 戻り値の指定サービス種類11は_設定した値と同じ指定サービス種類11を返す() {
            assertThat(sut.get指定サービス種類11(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類11));
        }

        @Test
        public void 戻り値の指定サービス種類12は_設定した値と同じ指定サービス種類12を返す() {
            assertThat(sut.get指定サービス種類12(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類12));
        }

        @Test
        public void 戻り値の指定サービス種類13は_設定した値と同じ指定サービス種類13を返す() {
            assertThat(sut.get指定サービス種類13(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類13));
        }

        @Test
        public void 戻り値の指定サービス種類14は_設定した値と同じ指定サービス種類14を返す() {
            assertThat(sut.get指定サービス種類14(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類14));
        }

        @Test
        public void 戻り値の指定サービス種類15は_設定した値と同じ指定サービス種類15を返す() {
            assertThat(sut.get指定サービス種類15(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類15));
        }

        @Test
        public void 戻り値の指定サービス種類16は_設定した値と同じ指定サービス種類16を返す() {
            assertThat(sut.get指定サービス種類16(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類16));
        }

        @Test
        public void 戻り値の指定サービス種類17は_設定した値と同じ指定サービス種類17を返す() {
            assertThat(sut.get指定サービス種類17(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類17));
        }

        @Test
        public void 戻り値の指定サービス種類18は_設定した値と同じ指定サービス種類18を返す() {
            assertThat(sut.get指定サービス種類18(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類18));
        }

        @Test
        public void 戻り値の指定サービス種類19は_設定した値と同じ指定サービス種類19を返す() {
            assertThat(sut.get指定サービス種類19(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類19));
        }

        @Test
        public void 戻り値の指定サービス種類20は_設定した値と同じ指定サービス種類20を返す() {
            assertThat(sut.get指定サービス種類20(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類20));
        }

        @Test
        public void 戻り値の指定サービス種類21は_設定した値と同じ指定サービス種類21を返す() {
            assertThat(sut.get指定サービス種類21(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類21));
        }

        @Test
        public void 戻り値の指定サービス種類22は_設定した値と同じ指定サービス種類22を返す() {
            assertThat(sut.get指定サービス種類22(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類22));
        }

        @Test
        public void 戻り値の指定サービス種類23は_設定した値と同じ指定サービス種類23を返す() {
            assertThat(sut.get指定サービス種類23(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類23));
        }

        @Test
        public void 戻り値の指定サービス種類24は_設定した値と同じ指定サービス種類24を返す() {
            assertThat(sut.get指定サービス種類24(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類24));
        }

        @Test
        public void 戻り値の指定サービス種類25は_設定した値と同じ指定サービス種類25を返す() {
            assertThat(sut.get指定サービス種類25(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類25));
        }

        @Test
        public void 戻り値の指定サービス種類26は_設定した値と同じ指定サービス種類26を返す() {
            assertThat(sut.get指定サービス種類26(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類26));
        }

        @Test
        public void 戻り値の指定サービス種類27は_設定した値と同じ指定サービス種類27を返す() {
            assertThat(sut.get指定サービス種類27(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類27));
        }

        @Test
        public void 戻り値の指定サービス種類28は_設定した値と同じ指定サービス種類28を返す() {
            assertThat(sut.get指定サービス種類28(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類28));
        }

        @Test
        public void 戻り値の指定サービス種類29は_設定した値と同じ指定サービス種類29を返す() {
            assertThat(sut.get指定サービス種類29(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類29));
        }

        @Test
        public void 戻り値の指定サービス種類30は_設定した値と同じ指定サービス種類30を返す() {
            assertThat(sut.get指定サービス種類30(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類30));
        }

        @Test
        public void 戻り値の喪失年月日は_設定した値と同じ喪失年月日を返す() {
            assertThat(sut.get喪失年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_喪失年月日));
        }

        @Test
        public void 戻り値の直近異動年月日は_設定した値と同じ直近異動年月日を返す() {
            assertThat(sut.get直近異動年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動年月日));
        }

        @Test
        public void 戻り値の直近異動事由コードは_設定した値と同じ直近異動事由コードを返す() {
            assertThat(sut.get直近異動事由コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動事由コード));
        }

        @Test
        public void 戻り値の有効無効区分は_設定した値と同じ有効無効区分を返す() {
            assertThat(sut.get有効無効区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_有効無効区分));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            assertThat(sut.getデータ区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_データ区分));
        }

        @Test
        public void 戻り値の同一連番は_設定した値と同じ同一連番を返す() {
            assertThat(sut.get同一連番(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_同一連番));
        }

        @Test
        public void 戻り値の異動理由は_設定した値と同じ異動理由を返す() {
            assertThat(sut.get異動理由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_異動理由));
        }

        @Test
        public void 戻り値の申請書区分は_設定した値と同じ申請書区分を返す() {
            assertThat(sut.get申請書区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書区分));
        }

        @Test
        public void 戻り値の削除事由コードは_設定した値と同じ削除事由コードを返す() {
            assertThat(sut.get削除事由コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_削除事由コード));
        }

        @Test
        public void 戻り値の要支援者認定申請区分は_設定した値と同じ要支援者認定申請区分を返す() {
            assertThat(sut.get要支援者認定申請区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要支援者認定申請区分));
        }

        @Test
        public void 戻り値の支給限度単位数は_設定した値と同じ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度単位数));
        }

        @Test
        public void 戻り値の支給限度有効開始年月日は_設定した値と同じ支給限度有効開始年月日を返す() {
            assertThat(sut.get支給限度有効開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効開始年月日));
        }

        @Test
        public void 戻り値の支給限度有効終了年月日は_設定した値と同じ支給限度有効終了年月日を返す() {
            assertThat(sut.get支給限度有効終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効終了年月日));
        }

        @Test
        public void 戻り値の短期入所支給限度日数は_設定した値と同じ短期入所支給限度日数を返す() {
            assertThat(sut.get短期入所支給限度日数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度日数));
        }

        @Test
        public void 戻り値の短期入所支給限度開始年月日は_設定した値と同じ短期入所支給限度開始年月日を返す() {
            assertThat(sut.get短期入所支給限度開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度開始年月日));
        }

        @Test
        public void 戻り値の短期入所支給限度終了年月日は_設定した値と同じ短期入所支給限度終了年月日を返す() {
            assertThat(sut.get短期入所支給限度終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度終了年月日));
        }

        @Test
        public void 戻り値の当初認定有効開始年月日は_設定した値と同じ当初認定有効開始年月日を返す() {
            assertThat(sut.get当初認定有効開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効開始年月日));
        }

        @Test
        public void 戻り値の当初認定有効終了年月日は_設定した値と同じ当初認定有効終了年月日を返す() {
            assertThat(sut.get当初認定有効終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効終了年月日));
        }

        @Test
        public void 戻り値の受給資格証明書発行年月日１は_設定した値と同じ受給資格証明書発行年月日１を返す() {
            assertThat(sut.get受給資格証明書発行年月日１(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日１));
        }

        @Test
        public void 戻り値の受給資格証明書発行年月日２は_設定した値と同じ受給資格証明書発行年月日２を返す() {
            assertThat(sut.get受給資格証明書発行年月日２(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日２));
        }

        @Test
        public void 戻り値の診断命令書発行年月日は_設定した値と同じ診断命令書発行年月日を返す() {
            assertThat(sut.get診断命令書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_診断命令書発行年月日));
        }

        @Test
        public void 戻り値の二号申請受理通知書発行年月日は_設定した値と同じ二号申請受理通知書発行年月日を返す() {
            assertThat(sut.get二号申請受理通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_二号申請受理通知書発行年月日));
        }

        @Test
        public void 戻り値の認定結果通知書発行年月日は_設定した値と同じ認定結果通知書発行年月日を返す() {
            assertThat(sut.get認定結果通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定結果通知書発行年月日));
        }

        @Test
        public void 戻り値の区分変更通知書発行年月日は_設定した値と同じ区分変更通知書発行年月日を返す() {
            assertThat(sut.get区分変更通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_区分変更通知書発行年月日));
        }

        @Test
        public void 戻り値のサービス変更通知書発行年月日は_設定した値と同じサービス変更通知書発行年月日を返す() {
            assertThat(sut.getサービス変更通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_サービス変更通知書発行年月日));
        }

        @Test
        public void 戻り値の認定却下通知書発行年月日は_設定した値と同じ認定却下通知書発行年月日を返す() {
            assertThat(sut.get認定却下通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定却下通知書発行年月日));
        }

        @Test
        public void 戻り値の認定取消通知書発行年月日は_設定した値と同じ認定取消通知書発行年月日を返す() {
            assertThat(sut.get認定取消通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定取消通知書発行年月日));
        }

        @Test
        public void 戻り値の資格取得前申請フラグは_設定した値と同じ資格取得前申請フラグを返す() {
            assertThat(sut.get資格取得前申請フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_資格取得前申請フラグ));
        }

        @Test
        public void 戻り値の旧措置者フラグは_設定した値と同じ旧措置者フラグを返す() {
            assertThat(sut.get旧措置者フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_旧措置者フラグ));
        }

        @Test
        public void 戻り値の論理削除フラグは_設定した値と同じ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_論理削除フラグ));
        }
    }

    public static class getStateTest extends DbdTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JukyushaDaicho sut = new JukyushaDaicho();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            JukyushaDaicho sut = new JukyushaDaicho();
            sut.setEntity(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setIdoRiyu(new RString("異動理由"));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            JukyushaDaicho sut = new JukyushaDaicho();
            sut.setEntity(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JukyushaDaicho sut = new JukyushaDaicho();
            sut.setEntity(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }

    public static class BuilderTest {

        @Test
        public void setShichosonCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShichosonCode(new LasdecCode("900001")).build();
            assertThat(result.get市町村コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void setHihokenshaNoで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setHihokenshaNo(new HihokenshaNo("900000001")).build();
            assertThat(result.get被保険者番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void setRirekiNoで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setRirekiNo(new RString("9001")).build();
            assertThat(result.get履歴番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void setEdabanで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setEdaban(new RString("91")).build();
            assertThat(result.get枝番(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_枝番));
        }

        @Test
        public void setShinseishoKanriNoで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShinseishoKanriNo(new ShinseishoKanriNo("90000000000000001")).build();
            assertThat(result.get申請書管理番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void setShinseiJokyoKubunで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShinseiJokyoKubun(new RString("2")).build();
            assertThat(result.get申請状況区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請状況区分));
        }

        @Test
        public void setShishoCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShishoCode(new RString("900000001")).build();
            assertThat(result.get支所コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支所コード));
        }

        @Test
        public void setChokkinFlagで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setChokkinFlag(false).build();
            assertThat(result.get直近フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近フラグ));
        }

        @Test
        public void setShikibetsuCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShikibetsuCode(new ShikibetsuCode("0001")).build();
            assertThat(result.get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void setJukyuShinseiJiyuで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setJukyuShinseiJiyu(new Code("1")).build();
            assertThat(result.get受給申請事由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由));
        }

        @Test
        public void setShinseiRiyuで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShinseiRiyu(new RString("申請理由")).build();
            assertThat(result.get申請理由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void setShinseishaKankeiCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShinseishaKankeiCode(new Code("1")).build();
            assertThat(result.get届出者_申請者関係コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_申請者関係コード));
        }

        @Test
        public void setHomninKankeiで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setHomninKankei(new RString("本人との関係性")).build();
            assertThat(result.get届出者_本人との関係(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_届出者_本人との関係));
        }

        @Test
        public void setJukyuShinseiYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setJukyuShinseiYMD(new FlexibleDate("20141030")).build();
            assertThat(result.get受給申請年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請年月日));
        }

        @Test
        public void setNigoTokuteiShippeiCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNigoTokuteiShippeiCode(new Code("01")).build();
            assertThat(result.get二号特定疾病コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_二号特定疾病コード));
        }

        @Test
        public void setShinsakaiIraiYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShinsakaiIraiYMD(new FlexibleDate("20141101")).build();
            assertThat(result.get審査会依頼年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_審査会依頼年月日));
        }

        @Test
        public void setYokaigoJotaiKubunCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setYokaigoJotaiKubunCode(new Code("01")).build();
            assertThat(result.get要介護認定状態区分コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要介護認定状態区分コード));
        }

        @Test
        public void setNinteiYukoKikanKaishiYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNinteiYukoKikanKaishiYMD(new FlexibleDate("20141102")).build();
            assertThat(result.get認定有効期間開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間開始年月日));
        }

        @Test
        public void setNinteiYukoKikanShuryoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNinteiYukoKikanShuryoYMD(new FlexibleDate("20141103")).build();
            assertThat(result.get認定有効期間終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定有効期間終了年月日));
        }

        @Test
        public void setNinteiYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNinteiYMD(new FlexibleDate("20141104")).build();
            assertThat(result.get認定年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定年月日));
        }

        @Test
        public void setShiteiServiceShurui01で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui01(new ServiceShuruiCode("11")).build();
            assertThat(result.get指定サービス種類01(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類01));
        }

        @Test
        public void setShiteiServiceShurui02で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui02(new ServiceShuruiCode("12")).build();
            assertThat(result.get指定サービス種類02(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類02));
        }

        @Test
        public void setShiteiServiceShurui03で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui03(new ServiceShuruiCode("13")).build();
            assertThat(result.get指定サービス種類03(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類03));
        }

        @Test
        public void setShiteiServiceShurui04で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui04(new ServiceShuruiCode("14")).build();
            assertThat(result.get指定サービス種類04(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類04));
        }

        @Test
        public void setShiteiServiceShurui05で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui05(new ServiceShuruiCode("15")).build();
            assertThat(result.get指定サービス種類05(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類05));
        }

        @Test
        public void setShiteiServiceShurui06で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui06(new ServiceShuruiCode("16")).build();
            assertThat(result.get指定サービス種類06(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類06));
        }

        @Test
        public void setShiteiServiceShurui07で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui07(new ServiceShuruiCode("17")).build();
            assertThat(result.get指定サービス種類07(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類07));
        }

        @Test
        public void setShiteiServiceShurui08で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui08(new ServiceShuruiCode("21")).build();
            assertThat(result.get指定サービス種類08(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類08));
        }

        @Test
        public void setShiteiServiceShurui09で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui09(new ServiceShuruiCode("22")).build();
            assertThat(result.get指定サービス種類09(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類09));
        }

        @Test
        public void setShiteiServiceShurui10で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui10(new ServiceShuruiCode("23")).build();
            assertThat(result.get指定サービス種類10(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類10));
        }

        @Test
        public void setShiteiServiceShurui11で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui11(new ServiceShuruiCode("31")).build();
            assertThat(result.get指定サービス種類11(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類11));
        }

        @Test
        public void setShiteiServiceShurui12で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui12(new ServiceShuruiCode("71")).build();
            assertThat(result.get指定サービス種類12(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類12));
        }

        @Test
        public void setShiteiServiceShurui13で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui13(new ServiceShuruiCode("72")).build();
            assertThat(result.get指定サービス種類13(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類13));
        }

        @Test
        public void setShiteiServiceShurui14で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui14(new ServiceShuruiCode("73")).build();
            assertThat(result.get指定サービス種類14(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類14));
        }

        @Test
        public void setShiteiServiceShurui15で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui15(new ServiceShuruiCode("76")).build();
            assertThat(result.get指定サービス種類15(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類15));
        }

        @Test
        public void setShiteiServiceShurui16で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui16(new ServiceShuruiCode("77")).build();
            assertThat(result.get指定サービス種類16(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類16));
        }

        @Test
        public void setShiteiServiceShurui17で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui17(new ServiceShuruiCode("33")).build();
            assertThat(result.get指定サービス種類17(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類17));
        }

        @Test
        public void setShiteiServiceShurui18で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui18(new ServiceShuruiCode("36")).build();
            assertThat(result.get指定サービス種類18(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類18));
        }

        @Test
        public void setShiteiServiceShurui19で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui19(new ServiceShuruiCode("27")).build();
            assertThat(result.get指定サービス種類19(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類19));
        }

        @Test
        public void setShiteiServiceShurui20で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui20(new ServiceShuruiCode("28")).build();
            assertThat(result.get指定サービス種類20(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類20));
        }

        @Test
        public void setShiteiServiceShurui21で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui21(new ServiceShuruiCode("32")).build();
            assertThat(result.get指定サービス種類21(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類21));
        }

        @Test
        public void setShiteiServiceShurui22で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui22(new ServiceShuruiCode("38")).build();
            assertThat(result.get指定サービス種類22(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類22));
        }

        @Test
        public void setShiteiServiceShurui23で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui23(new ServiceShuruiCode("41")).build();
            assertThat(result.get指定サービス種類23(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類23));
        }

        @Test
        public void setShiteiServiceShurui24で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui24(new ServiceShuruiCode("42")).build();
            assertThat(result.get指定サービス種類24(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類24));
        }

        @Test
        public void setShiteiServiceShurui25で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui25(new ServiceShuruiCode("51")).build();
            assertThat(result.get指定サービス種類25(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類25));
        }

        @Test
        public void setShiteiServiceShurui26で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui26(new ServiceShuruiCode("52")).build();
            assertThat(result.get指定サービス種類26(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類26));
        }

        @Test
        public void setShiteiServiceShurui27で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui27(new ServiceShuruiCode("53")).build();
            assertThat(result.get指定サービス種類27(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類27));
        }

        @Test
        public void setShiteiServiceShurui28で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui28(new ServiceShuruiCode("54")).build();
            assertThat(result.get指定サービス種類28(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類28));
        }

        @Test
        public void setShiteiServiceShurui29で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui29(new ServiceShuruiCode("59")).build();
            assertThat(result.get指定サービス種類29(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類29));
        }

        @Test
        public void setShiteiServiceShurui30で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShiteiServiceShurui30(new ServiceShuruiCode("81")).build();
            assertThat(result.get指定サービス種類30(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_指定サービス種類30));
        }

        @Test
        public void setSoshitsuYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setSoshitsuYMD(new FlexibleDate("20141105")).build();
            assertThat(result.get喪失年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_喪失年月日));
        }

        @Test
        public void setChokkinIdoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setChokkinIdoYMD(new FlexibleDate("20141106")).build();
            assertThat(result.get直近異動年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動年月日));
        }

        @Test
        public void setChokkinIdoJiyuCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setChokkinIdoJiyuCode(new Code("00")).build();
            assertThat(result.get直近異動事由コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動事由コード));
        }

        @Test
        public void setYukoMukoKubunで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setYukoMukoKubun(new Code("0")).build();
            assertThat(result.get有効無効区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_有効無効区分));
        }

        @Test
        public void setDataKubunで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setDataKubun(new Code("01")).build();
            assertThat(result.getデータ区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_データ区分));
        }

        @Test
        public void setRembanで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setRemban(new RString("9001")).build();
            assertThat(result.get同一連番(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_同一連番));
        }

        @Test
        public void setIdoRiyuで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setIdoRiyu(new RString("異動事由")).build();
            assertThat(result.get異動理由(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_異動理由));
        }

        @Test
        public void setShinseishoKubunで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShinseishoKubun(new Code("0")).build();
            assertThat(result.get申請書区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書区分));
        }

        @Test
        public void setSakujoJiyuCodeで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setSakujoJiyuCode(new Code("01")).build();
            assertThat(result.get削除事由コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_削除事由コード));
        }

        @Test
        public void setYoshienshaNinteiShinseiFlagで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setYoshienshaNinteiShinseiFlag(false).build();
            assertThat(result.get要支援者認定申請区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_要支援者認定申請区分));
        }

        @Test
        public void setShikyuGendoTanisuで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShikyuGendoTanisu(new Decimal("1234")).build();
            assertThat(result.get支給限度単位数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度単位数));
        }

        @Test
        public void setShikyuGendoKaishiYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShikyuGendoKaishiYMD(new FlexibleDate("20141107")).build();
            assertThat(result.get支給限度有効開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効開始年月日));
        }

        @Test
        public void setShikyuGendoShuryoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShikyuGendoShuryoYMD(new FlexibleDate("20141108")).build();
            assertThat(result.get支給限度有効終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効終了年月日));
        }

        @Test
        public void setTankiSikyuGendoNissuで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setTankiSikyuGendoNissu(180).build();
            assertThat(result.get短期入所支給限度日数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度日数));
        }

        @Test
        public void setTankiShikyuGendoKaishiYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setTankiShikyuGendoKaishiYMD(new FlexibleDate("20141109")).build();
            assertThat(result.get短期入所支給限度開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度開始年月日));
        }

        @Test
        public void setTankiShikyuGendoShuryoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setTankiShikyuGendoShuryoYMD(new FlexibleDate("20141110")).build();
            assertThat(result.get短期入所支給限度終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度終了年月日));
        }

        @Test
        public void setToshoNinteiYukoKaishiYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setToshoNinteiYukoKaishiYMD(new FlexibleDate("20141111")).build();
            assertThat(result.get当初認定有効開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効開始年月日));
        }

        @Test
        public void setToshoNinteiYukoShuryoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setToshoNinteiYukoShuryoYMD(new FlexibleDate("20141112")).build();
            assertThat(result.get当初認定有効終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_当初認定有効終了年月日));
        }

        @Test
        public void setJukyuShikakuShomeishoHakkoYMD1で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setJukyuShikakuShomeishoHakkoYMD1(new FlexibleDate("20141113")).build();
            assertThat(result.get受給資格証明書発行年月日１(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日１));
        }

        @Test
        public void setJukyuShikakuShomeishoHakkoYMD2で設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setJukyuShikakuShomeishoHakkoYMD2(new FlexibleDate("20141114")).build();
            assertThat(result.get受給資格証明書発行年月日２(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給資格証明書発行年月日２));
        }

        @Test
        public void setShindanMeireishoHakkoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShindanMeireishoHakkoYMD(new FlexibleDate("20141115")).build();
            assertThat(result.get診断命令書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_診断命令書発行年月日));
        }

        @Test
        public void setNigoShinseiJuriTsuchishoHakkoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNigoShinseiJuriTsuchishoHakkoYMD(new FlexibleDate("20141116")).build();
            assertThat(result.get二号申請受理通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_二号申請受理通知書発行年月日));
        }

        @Test
        public void setNinteiKekkaTsuchishoHakkoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNinteiKekkaTsuchishoHakkoYMD(new FlexibleDate("20141117")).build();
            assertThat(result.get認定結果通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定結果通知書発行年月日));
        }

        @Test
        public void setKubunHenkoTsuchishoHakkoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setKubunHenkoTsuchishoHakkoYMD(new FlexibleDate("20141118")).build();
            assertThat(result.get区分変更通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_区分変更通知書発行年月日));
        }

        @Test
        public void setServiceHenkoTsuchishoHakkoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setServiceHenkoTsuchishoHakkoYMD(new FlexibleDate("20141119")).build();
            assertThat(result.getサービス変更通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_サービス変更通知書発行年月日));
        }

        @Test
        public void setNinteiKyakkaTsuchishoHakkoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNinteiKyakkaTsuchishoHakkoYMD(new FlexibleDate("20141120")).build();
            assertThat(result.get認定却下通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定却下通知書発行年月日));
        }

        @Test
        public void setNinteiTorikeshiTsuchishoHakkoYMDで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setNinteiTorikeshiTsuchishoHakkoYMD(new FlexibleDate("20141121")).build();
            assertThat(result.get認定取消通知書発行年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_認定取消通知書発行年月日));
        }

        @Test
        public void setShikakuShutokuMaeShinseiFlagで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setShikakuShutokuMaeShinseiFlag(false).build();
            assertThat(result.get資格取得前申請フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_資格取得前申請フラグ));
        }

        @Test
        public void setKyuSochishaFlagで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setKyuSochishaFlag(false).build();
            assertThat(result.get旧措置者フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_旧措置者フラグ));
        }

        @Test
        public void setLogicalDeletedFlagで設定した値を_生成されたJukyushaDaichoも保持する() {
            JukyushaDaicho result = JukyushaDaicho.newBuilder().setLogicalDeletedFlag(false).build();
            assertThat(result.get論理削除フラグ(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_論理削除フラグ));
        }
    }

    public static class SerializationProxyTest {

        private JukyushaDaicho sut;

        @Before
        public void setUp() {
            sut = JukyushaDaicho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            String b64 = _Base64Serializer.serialize(sut.serialize());
            JukyushaDaicho desirialized = _Base64Serializer.deSerialize(b64, JukyushaDaicho.class);
            assertThat(desirialized.get被保険者番号(), is(sut.get被保険者番号()));
        }
    }
}
