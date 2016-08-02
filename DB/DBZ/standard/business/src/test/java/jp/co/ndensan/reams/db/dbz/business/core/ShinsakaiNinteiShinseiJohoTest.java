/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiNinteiShinseiJoho}のテストクラスです。
 *
 * @author n8235 船山洋介
 */
@RunWith(Enclosed.class)
public class ShinsakaiNinteiShinseiJohoTest extends DbdTestBase {

    public static class getterSetterTest extends DbdTestBase {

        private static ShinsakaiNinteiShinseiJoho sut;

        @BeforeClass
        public static void setUp() {
            sut = new ShinsakaiNinteiShinseiJoho(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の申請年度は_設定した値と同じ申請年度を返す() {
            assertThat(sut.get申請年度(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請年度));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の認定申請年月日は_設定した値と同じ認定申請年月日を返す() {
            assertThat(sut.get認定申請年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請年月日));
        }

        @Test
        public void 戻り値の認定申請枝番コードは_設定した値と同じ認定申請枝番コードを返す() {
            assertThat(sut.get認定申請枝番コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請枝番コード));
        }

        @Test
        public void 戻り値の認定申請区分_法令_コードは_設定した値と同じ認定申請区分_法令_コードを返す() {
            assertThat(sut.get認定申請区分_法令_コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分_法令_コード));
        }

        @Test
        public void 戻り値の認定申請区分_申請時_コードは_設定した値と同じ認定申請区分_申請時_コードを返す() {
            assertThat(sut.get認定申請区分_申請時_コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分_申請時_コード));
        }

        @Test
        public void 戻り値の取下区分コードは_設定した値と同じ取下区分コードを返す() {
            assertThat(sut.get取下区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_取下区分コード));
        }

        @Test
        public void 戻り値の被保険者区分コードは_設定した値と同じ被保険者区分コードを返す() {
            assertThat(sut.get被保険者区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者区分コード));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            assertThat(sut.get生年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の年齢は_設定した値と同じ年齢を返す() {
            assertThat(sut.get年齢(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_年齢));
        }

        @Test
        public void 戻り値の性別は_設定した値と同じ性別を返す() {
            assertThat(sut.get性別(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_性別));
        }

        @Test
        public void 戻り値の被保険者氏名カナは_設定した値と同じ被保険者氏名カナを返す() {
            assertThat(sut.get被保険者氏名カナ(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者氏名カナ));
        }

        @Test
        public void 戻り値の被保険者氏名は_設定した値と同じ被保険者氏名を返す() {
            assertThat(sut.get被保険者氏名(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者氏名));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            assertThat(sut.get住所(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            assertThat(sut.get電話番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値の支所コードは_設定した値と同じ支所コードを返す() {
            assertThat(sut.get支所コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_支所コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            assertThat(sut.get識別コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の地区コードは_設定した値と同じ地区コードを返す() {
            assertThat(sut.get地区コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_地区コード));
        }

        @Test
        public void 戻り値のみなし二号等対象フラグは_設定した値と同じみなし二号等対象フラグを返す() {
            assertThat(sut.isみなし二号等対象フラグ(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_みなし二号等対象フラグ));
        }

        @Test
        public void 戻り値の広域内転居区分は_設定した値と同じ広域内転居区分を返す() {
            assertThat(sut.get広域内転居区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_広域内転居区分));
        }

        @Test
        public void 戻り値の認定申請有効区分は_設定した値と同じ認定申請有効区分を返す() {
            assertThat(sut.get認定申請有効区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請有効区分));
        }

        @Test
        public void 戻り値の要介護申請_要支援申請の区分は_設定した値と同じ要介護申請_要支援申請の区分を返す() {
            assertThat(sut.get要介護申請_要支援申請の区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_要介護申請_要支援申請の区分));
        }

        @Test
        public void 戻り値の認定申請理由は_設定した値と同じ認定申請理由を返す() {
            assertThat(sut.get認定申請理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請理由));
        }

        @Test
        public void 戻り値の申請サービス削除の理由は_設定した値と同じ申請サービス削除の理由を返す() {
            assertThat(sut.get申請サービス削除の理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請サービス削除の理由));
        }

        @Test
        public void 戻り値の前回要介護状態区分コードは_設定した値と同じ前回要介護状態区分コードを返す() {
            assertThat(sut.get前回要介護状態区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回要介護状態区分コード));
        }

        @Test
        public void 戻り値の前回認定年月日は_設定した値と同じ前回認定年月日を返す() {
            assertThat(sut.get前回認定年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定年月日));
        }

        @Test
        public void 戻り値の前回認定有効期間_開始は_設定した値と同じ前回認定有効期間_開始を返す() {
            assertThat(sut.get前回認定有効期間_開始(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定有効期間_開始));
        }

        @Test
        public void 戻り値の前回認定有効期間_終了は_設定した値と同じ前回認定有効期間_終了を返す() {
            assertThat(sut.get前回認定有効期間_終了(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定有効期間_終了));
        }

        @Test
        public void 戻り値の二号医療保険者名は_設定した値と同じ二号医療保険者名を返す() {
            assertThat(sut.get二号医療保険者名(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_二号医療保険者名));
        }

        @Test
        public void 戻り値の二号医療保険記号番号は_設定した値と同じ二号医療保険記号番号を返す() {
            assertThat(sut.get二号医療保険記号番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_二号医療保険記号番号));
        }

        @Test
        public void 戻り値の二号特定疾病コードは_設定した値と同じ二号特定疾病コードを返す() {
            assertThat(sut.get二号特定疾病コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_二号特定疾病コード));
        }

        @Test
        public void 戻り値の自動割当除外者区分は_設定した値と同じ自動割当除外者区分を返す() {
            assertThat(sut.get自動割当除外者区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_自動割当除外者区分));
        }

        @Test
        public void 戻り値の情報提供への同意有無は_設定した値と同じ情報提供への同意有無を返す() {
            assertThat(sut.is情報提供への同意有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_情報提供への同意有無));
        }

        @Test
        public void 戻り値の情報提供資料出力年月日は_設定した値と同じ情報提供資料出力年月日を返す() {
            assertThat(sut.get情報提供資料出力年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_情報提供資料出力年月日));
        }

        @Test
        public void 戻り値の調査区分は_設定した値と同じ調査区分を返す() {
            assertThat(sut.get調査区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_調査区分));
        }

        @Test
        public void 戻り値の認定調査委託先コードは_設定した値と同じ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void 戻り値の認定調査員コードは_設定した値と同じ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査員コード));
        }

        @Test
        public void 戻り値の調査員への連絡事項は_設定した値と同じ調査員への連絡事項を返す() {
            assertThat(sut.get調査員への連絡事項(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_調査員への連絡事項));
        }

        @Test
        public void 戻り値の主治医医療機関コードは_設定した値と同じ主治医医療機関コードを返す() {
            assertThat(sut.get主治医医療機関コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主治医医療機関コード.value()));
        }

//        @Test
//        public void 戻り値の主治医コードは_設定した値と同じ主治医コードを返す() {
//            assertThat(sut.get主治医コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主治医コード));
//        }

        @Test
        public void 戻り値の指定医フラグは_設定した値と同じ指定医フラグを返す() {
            assertThat(sut.is指定医フラグ(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_指定医フラグ));
        }

        @Test
        public void 戻り値の意見書データ種別は_設定した値と同じ意見書データ種別を返す() {
            assertThat(sut.get意見書データ種別(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_意見書データ種別));
        }

        @Test
        public void 戻り値の主治医への連絡事項は_設定した値と同じ主治医への連絡事項を返す() {
            assertThat(sut.get主治医への連絡事項(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主治医への連絡事項));
        }

        @Test
        public void 戻り値の認定延期通知発行しないことに対する同意有無は_設定した値と同じ認定延期通知発行しないことに対する同意有無を返す() {
            assertThat(sut.is認定延期通知発行しないことに対する同意有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定延期通知発行しないことに対する同意有無));
        }

        @Test
        public void 戻り値の施設入所の有無は_設定した値と同じ施設入所の有無を返す() {
            assertThat(sut.is施設入所の有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_施設入所の有無));
        }

        @Test
        public void 戻り値の入所施設コードは_設定した値と同じ入所施設コードを返す() {
            assertThat(sut.get入所施設コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_入所施設コード));
        }

        @Test
        public void 戻り値の家庭訪問の有無は_設定した値と同じ家庭訪問の有無を返す() {
            assertThat(sut.is家庭訪問の有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_家庭訪問の有無));
        }

        @Test
        public void 戻り値の訪問調査先郵便番号は_設定した値と同じ訪問調査先郵便番号を返す() {
            assertThat(sut.get訪問調査先郵便番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先郵便番号));
        }

        @Test
        public void 戻り値の訪問調査先住所は_設定した値と同じ訪問調査先住所を返す() {
            assertThat(sut.get訪問調査先住所(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先住所));
        }

        @Test
        public void 戻り値の訪問調査先名称は_設定した値と同じ訪問調査先名称を返す() {
            assertThat(sut.get訪問調査先名称(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先名称));
        }

        @Test
        public void 戻り値の訪問調査先電話番号は_設定した値と同じ訪問調査先電話番号を返す() {
            assertThat(sut.get訪問調査先電話番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先電話番号));
        }

        @Test
        public void 戻り値の市町村連絡事項は_設定した値と同じ市町村連絡事項を返す() {
            assertThat(sut.get市町村連絡事項(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_市町村連絡事項));
        }

        @Test
        public void 戻り値の処理状態区分は_設定した値と同じ処理状態区分を返す() {
            assertThat(sut.get処理状態区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_処理状態区分));
        }

        @Test
        public void 戻り値の取下年月日は_設定した値と同じ取下年月日を返す() {
            assertThat(sut.get取下年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_取下年月日));
        }

        @Test
        public void 戻り値の取下理由は_設定した値と同じ取下理由を返す() {
            assertThat(sut.get取下理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_取下理由));
        }

        @Test
        public void 戻り値の却下年月日は_設定した値と同じ却下年月日を返す() {
            assertThat(sut.get却下年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_却下年月日));
        }

        @Test
        public void 戻り値の却下理由は_設定した値と同じ却下理由を返す() {
            assertThat(sut.get却下理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_却下理由));
        }

        @Test
        public void 戻り値の延期決定年月日は_設定した値と同じ延期決定年月日を返す() {
            assertThat(sut.get延期決定年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期決定年月日));
        }

        @Test
        public void 戻り値の延期理由は_設定した値と同じ延期理由を返す() {
            assertThat(sut.get延期理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期理由));
        }

        @Test
        public void 戻り値の延期通知発行年月日は_設定した値と同じ延期通知発行年月日を返す() {
            assertThat(sut.get延期通知発行年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期通知発行年月日));
        }

        @Test
        public void 戻り値の延期通知発行回数は_設定した値と同じ延期通知発行回数を返す() {
            assertThat(sut.get延期通知発行回数(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期通知発行回数));
        }

        @Test
        public void 戻り値の延期見込期間開始年月日は_設定した値と同じ延期見込期間開始年月日を返す() {
            assertThat(sut.get延期見込期間開始年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期見込期間開始年月日));
        }

        @Test
        public void 戻り値の延期見込期間終了年月日は_設定した値と同じ延期見込期間終了年月日を返す() {
            assertThat(sut.get延期見込期間終了年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期見込期間終了年月日));
        }

        @Test
        public void 戻り値の審査継続区分は_設定した値と同じ審査継続区分を返す() {
            assertThat(sut.is審査継続区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_審査継続区分));
        }

        @Test
        public void 戻り値の要介護認定審査会優先振分区分コードは_設定した値と同じ要介護認定審査会優先振分区分コードを返す() {
            assertThat(sut.get要介護認定審査会優先振分区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_要介護認定審査会優先振分区分コード));
        }

        @Test
        public void 戻り値の更新通知発行年月日は_設定した値と同じ更新通知発行年月日を返す() {
            assertThat(sut.get更新通知発行年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_更新通知発行年月日));
        }

        @Test
        public void 戻り値の更新通知発行完了年月日は_設定した値と同じ更新通知発行完了年月日を返す() {
            assertThat(sut.get更新通知発行完了年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_更新通知発行完了年月日));
        }

        @Test
        public void 戻り値の認定申請情報登録年月日は_設定した値と同じ認定申請情報登録年月日を返す() {
            assertThat(sut.get認定申請情報登録年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請情報登録年月日));
        }

        @Test
        public void 戻り値の再調査依頼回数は_設定した値と同じ再調査依頼回数を返す() {
            assertThat(sut.get再調査依頼回数(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_再調査依頼回数));
        }

        @Test
        public void 戻り値の再作成依頼回数は_設定した値と同じ再作成依頼回数を返す() {
            assertThat(sut.get再作成依頼回数(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_再作成依頼回数));
        }

        @Test
        public void 戻り値のＩＦ送付年月日は_設定した値と同じＩＦ送付年月日を返す() {
            assertThat(sut.getＩＦ送付年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_ＩＦ送付年月日));
        }
    }

    public static class getStateTest extends DbdTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinsakaiNinteiShinseiJoho sut = new ShinsakaiNinteiShinseiJoho();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShinsakaiNinteiShinseiJoho sut = new ShinsakaiNinteiShinseiJoho();
            sut.setEntity(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());

//            sut.getEntity().initializeMd5();
//
//            sut.getEntity().setAge(99);

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShinsakaiNinteiShinseiJoho sut = new ShinsakaiNinteiShinseiJoho();
            sut.setEntity(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());

//            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinsakaiNinteiShinseiJoho sut = new ShinsakaiNinteiShinseiJoho();
            sut.setEntity(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());

//            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }

    public static class BuilderTest extends DbdTestBase {

        @Test
        public void setShinseishoKanriNoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShinseishoKanriNo(new ShinseishoKanriNo("00000000000000999")).build();
            assertThat(result.get申請書管理番号().value(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }

        @Test
        public void setKoroshoIfShikibetsuCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setKoroshoIfShikibetsuCode(new Code("001")).build();
            assertThat(result.get厚労省IF識別コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void setShoKisaiHokenshaNoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShoKisaiHokenshaNo(new RString("000001")).build();
            assertThat(result.get証記載保険者番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void setShinseiNendoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShinseiNendo(new FlexibleYear("2014")).build();
            assertThat(result.get申請年度(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請年度));
        }

        @Test
        public void setHihokenshaNoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHihokenshaNo(new RString("000001")).build();
            assertThat(result.get被保険者番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void setNinteiShinseiYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiShinseiYMD(new FlexibleDate("20141212")).build();
            assertThat(result.get認定申請年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請年月日));
        }

        @Test
        public void setNinteiShinseiEdabanCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiShinseiEdabanCode(new EdabanCode("001")).build();
            assertThat(result.get認定申請枝番コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請枝番コード));
        }

        @Test
        public void setNinteiShinseiHoreiKubunCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiShinseiHoreiKubunCode(new Code("0001")).build();
            assertThat(result.get認定申請区分_法令_コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分_法令_コード));
        }

        @Test
        public void setNinteiShinseiShinseijiKubunCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiShinseiShinseijiKubunCode(new Code("0001")).build();
            assertThat(result.get認定申請区分_申請時_コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分_申請時_コード));
        }

        @Test
        public void setTorisageKubunCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setTorisageKubunCode(new Code("0001")).build();
            assertThat(result.get取下区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_取下区分コード));
        }

        @Test
        public void setHihokenshaKubunCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHihokenshaKubunCode(new RString("1")).build();
            assertThat(result.get被保険者区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者区分コード));
        }

        @Test
        public void setSeinengappiYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setSeinengappiYMD(new FlexibleDate("19700101")).build();
            assertThat(result.get生年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void setAgeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setAge(45).build();
            assertThat(result.get年齢(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_年齢));
        }

        @Test
        public void setSeibetsuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setSeibetsu(new Code("1")).build();
            assertThat(result.get性別().value(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_性別.value()));
        }

        @Test
        public void setHihokenshaKanaで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHihokenshaKana(new AtenaKanaMeisho("ヒホケンシャ")).build();
            assertThat(result.get被保険者氏名カナ(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者氏名カナ));
        }

        @Test
        public void setHihokenshaNameで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHihokenshaName(new AtenaMeisho("被保険者")).build();
            assertThat(result.get被保険者氏名(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者氏名));
        }

        @Test
        public void setYubinNoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setYubinNo(new YubinNo("1234567")).build();
            assertThat(result.get郵便番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void setJushoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setJusho(new AtenaJusho("住所")).build();
            assertThat(result.get住所(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void setTelNoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setTelNo(new TelNo("1234567890")).build();
            assertThat(result.get電話番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void setShishoCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShishoCode(new RString("123456789")).build();
            assertThat(result.get支所コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_支所コード));
        }

        @Test
        public void setShikibetsuCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShikibetsuCode(new ShikibetsuCode("0001")).build();
            assertThat(result.get識別コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void setChikuCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setChikuCode(new ChikuCode("00000001")).build();
            assertThat(result.get地区コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_地区コード));
        }

        @Test
        public void setMinashiNigoEtcTaishoFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setMinashiNigoEtcTaishoFlag(false).build();
            assertThat(result.isみなし二号等対象フラグ(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_みなし二号等対象フラグ));
        }

        @Test
        public void setKoikinaiTenkyoKubunで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setKoikinaiTenkyoKubun(new Code("1")).build();
            assertThat(result.get広域内転居区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_広域内転居区分));
        }

        @Test
        public void setNinteiShinseiYukoKubunCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiShinseiYukoKubunCode(new Code("1")).build();
            assertThat(result.get認定申請有効区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請有効区分));
        }

        @Test
        public void setShienShinseiKubunで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShienShinseiKubun(new RString("1")).build();
            assertThat(result.get要介護申請_要支援申請の区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_要介護申請_要支援申請の区分));
        }

        @Test
        public void setNinteiShinseiRiyuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiShinseiRiyu(new RString("認定申請理由")).build();
            assertThat(result.get認定申請理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請理由));
        }

        @Test
        public void setShinseiServiceDeleteRiyuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShinseiServiceDeleteRiyu(new RString("申請サービス削除理由")).build();
            assertThat(result.get申請サービス削除の理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請サービス削除の理由));
        }

        @Test
        public void setZenYokaigoKubunCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setZenYokaigoKubunCode(new Code("1")).build();
            assertThat(result.get前回要介護状態区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回要介護状態区分コード));
        }

        @Test
        public void setZenkaiNinteiYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setZenkaiNinteiYMD(new FlexibleDate("20150808")).build();
            assertThat(result.get前回認定年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定年月日));
        }

        @Test
        public void setZenkaiYukoKikanStartで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setZenkaiYukoKikanStart(new FlexibleDate("20150809")).build();
            assertThat(result.get前回認定有効期間_開始(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定有効期間_開始));
        }

        @Test
        public void setZenkaiYukoKikanEndで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setZenkaiYukoKikanEnd(new FlexibleDate("20160809")).build();
            assertThat(result.get前回認定有効期間_終了(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定有効期間_終了));
        }

        @Test
        public void setNigoIryoHokenshaNameで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNigoIryoHokenshaName(new RString("二号保険者名")).build();
            assertThat(result.get二号医療保険者名(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_二号医療保険者名));
        }

        @Test
        public void setNigoIryoHokenKigoBangoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNigoIryoHokenKigoBango(new RString("01223")).build();
            assertThat(result.get二号医療保険記号番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_二号医療保険記号番号));
        }

        @Test
        public void setNigoTokuteiShippeiCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNigoTokuteiShippeiCode(new Code("0001")).build();
            assertThat(result.get二号特定疾病コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_二号特定疾病コード));
        }

        @Test
        public void setJidoWariateJogaishaKubunで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setJidoWariateJogaishaKubun(new RString("1")).build();
            assertThat(result.get自動割当除外者区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_自動割当除外者区分));
        }

        @Test
        public void setJohoteikyoDoiFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setJohoteikyoDoiFlag(true).build();
            assertThat(result.is情報提供への同意有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_情報提供への同意有無));
        }

        @Test
        public void setJohoteikyoSiryoOutputYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setJohoteikyoSiryoOutputYMD(new FlexibleDate("20150807")).build();
            assertThat(result.get情報提供資料出力年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_情報提供資料出力年月日));
        }

        @Test
        public void setChosaKubunで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setChosaKubun(new Code("01")).build();
            assertThat(result.get調査区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_調査区分));
        }

        @Test
        public void setNinteiChosaItakusakiCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiChosaItakusakiCode(new ChosaItakusakiCode("0000000001")).build();
            assertThat(result.get認定調査委託先コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void setNinteiChosainCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiChosainCode(new ChosainCode("00000001")).build();
            assertThat(result.get認定調査員コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査員コード));
        }

        @Test
        public void setRenrakuJikoToChosainで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setRenrakuJikoToChosain(new RString("調査員への連絡事項")).build();
            assertThat(result.get調査員への連絡事項(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_調査員への連絡事項));
        }

        @Test
        public void setShujiiIryokikanCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShujiiIryokikanCode(new RString("0000000001")).build();
            assertThat(result.get主治医医療機関コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主治医医療機関コード.value()));
        }

//        @Test
//        public void setShujiiCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
//            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShujiiCode(new RString("00000001")).build();
//            assertThat(result.get主治医コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主治医コード));
//        }

        @Test
        public void setShiteiiFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShiteiiFlag(false).build();
            assertThat(result.is指定医フラグ(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_指定医フラグ));
        }

        @Test
        public void setIkenshoDataShubetsuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setIkenshoDataShubetsu(new Code("01")).build();
            assertThat(result.get意見書データ種別(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_意見書データ種別));
        }

        @Test
        public void setRenrakuJikoToShujiiで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setRenrakuJikoToShujii(new RString("主治医への連絡事項")).build();
            assertThat(result.get主治医への連絡事項(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主治医への連絡事項));
        }

        @Test
        public void setEnkitsuchiNashiDoiFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setEnkitsuchiNashiDoiFlag(false).build();
            assertThat(result.is認定延期通知発行しないことに対する同意有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定延期通知発行しないことに対する同意有無));
        }

        @Test
        public void setShisetsuNyushoFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShisetsuNyushoFlag(false).build();
            assertThat(result.is施設入所の有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_施設入所の有無));
        }

        @Test
        public void setNyushoShisetsuCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNyushoShisetsuCode(new JigyoshaNo("0000000001")).build();
            assertThat(result.get入所施設コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_入所施設コード));
        }

        @Test
        public void setKateiHomonFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setKateiHomonFlag(false).build();
            assertThat(result.is家庭訪問の有無(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_家庭訪問の有無));
        }

        @Test
        public void setHomonChosasakiYubinNoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHomonChosasakiYubinNo(new YubinNo("7654321")).build();
            assertThat(result.get訪問調査先郵便番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先郵便番号));
        }

        @Test
        public void setHomonChosasakiJushoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHomonChosasakiJusho(new AtenaJusho("訪問先受住所")).build();
            assertThat(result.get訪問調査先住所(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先住所));
        }

        @Test
        public void setHomonChosasakiNameで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHomonChosasakiName(new AtenaMeisho("訪問先名称")).build();
            assertThat(result.get訪問調査先名称(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先名称));
        }

        @Test
        public void setHomonChosasakiTelNoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setHomonChosasakiTelNo(new TelNo("0000111111")).build();
            assertThat(result.get訪問調査先電話番号(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_訪問調査先電話番号));
        }

        @Test
        public void setSichosonRenrakuJikoで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setSichosonRenrakuJiko(new RString("市町村連絡事項")).build();
            assertThat(result.get市町村連絡事項(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_市町村連絡事項));
        }

        @Test
        public void setShoriJotaiKubunで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShoriJotaiKubun(new Code("1")).build();
            assertThat(result.get処理状態区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_処理状態区分));
        }

        @Test
        public void setTorisageYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setTorisageYMD(new FlexibleDate("20150104")).build();
            assertThat(result.get取下年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_取下年月日));
        }

        @Test
        public void setTorisageRiyuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setTorisageRiyu(new RString("取下げ理由")).build();
            assertThat(result.get取下理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_取下理由));
        }

        @Test
        public void setKyakkaYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setKyakkaYMD(new FlexibleDate("20150106")).build();
            assertThat(result.get却下年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_却下年月日));
        }

        @Test
        public void setKyakkaRiyuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setKyakkaRiyu(new RString("却下理由")).build();
            assertThat(result.get却下理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_却下理由));
        }

        @Test
        public void setEnkiKetteiYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setEnkiKetteiYMD(new FlexibleDate("20150108")).build();
            assertThat(result.get延期決定年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期決定年月日));
        }

        @Test
        public void setEnkiRiyuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setEnkiRiyu(new RString("延期理由")).build();
            assertThat(result.get延期理由(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期理由));
        }

        @Test
        public void setEnkitsuchiHakkoYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setEnkiTsuchiHakkoYMD(new FlexibleDate("20150110")).build();
            assertThat(result.get延期通知発行年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期通知発行年月日));
        }

        @Test
        public void setEnkitsuchiHakkoKaisuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setEnkiTsuchiHakkoKaisu(1).build();
            assertThat(result.get延期通知発行回数(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期通知発行回数));
        }

        @Test
        public void setEnkiMikomiKaishiYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setEnkiMikomiKaishiYMD(new FlexibleDate("20150210")).build();
            assertThat(result.get延期見込期間開始年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期見込期間開始年月日));
        }

        @Test
        public void setEnkiMikomiShuryoYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setEnkiMikomiShuryoYMD(new FlexibleDate("20150211")).build();
            assertThat(result.get延期見込期間終了年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_延期見込期間終了年月日));
        }

        @Test
        public void setShinsaKeizokuFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShinsaKeizokuFlag(false).build();
            assertThat(result.is審査継続区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_審査継続区分));
        }

        @Test
        public void setShinsakaiYusenWaritsukeKubunCodeで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setShinsakaiYusenWaritsukeKubunCode(new Code("1")).build();
            assertThat(result.get要介護認定審査会優先振分区分コード(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_要介護認定審査会優先振分区分コード));
        }

        @Test
        public void setKosinTsuchiHakkoYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setKosinTsuchiHakkoYMD(new FlexibleDate("20160810")).build();
            assertThat(result.get更新通知発行年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_更新通知発行年月日));
        }

        @Test
        public void setKosinTsuchiHakkoKanryoYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setKosinTsuchiHakkoKanryoYMD(new FlexibleDate("20160811")).build();
            assertThat(result.get更新通知発行完了年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_更新通知発行完了年月日));
        }

        @Test
        public void setNinteiShinseiJohoTorokuYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setNinteiShinseiJohoTorokuYMD(new FlexibleDate("20150810")).build();
            assertThat(result.get認定申請情報登録年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請情報登録年月日));
        }

        @Test
        public void setSaiChosaIraiKaisuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setSaiChosaIraiKaisu(0).build();
            assertThat(result.get再調査依頼回数(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_再調査依頼回数));
        }

        @Test
        public void setSaiSakuseiIraiKaisuで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setSaiSakuseiIraiKaisu(1).build();
            assertThat(result.get再作成依頼回数(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_再作成依頼回数));
        }

        @Test
        public void setIfSofuYMDで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setIfSofuYMD(new FlexibleDate("20150102")).build();
            assertThat(result.getＩＦ送付年月日(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_ＩＦ送付年月日));
        }

        @Test
        public void setLogicalDeletedFlagで設定した値を_生成されたShinsakaiNinteiShinseiJohoも保持する() {
            ShinsakaiNinteiShinseiJoho result = ShinsakaiNinteiShinseiJoho.newBuilder().setLogicalDeletedFlag(false).build();
            assertThat(result.is論理削除区分(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_論理削除区分));
        }
    }

    public static class SerializationProxyTest {

        private ShinsakaiNinteiShinseiJoho sut;

        @Before
        public void setUp() {
            sut = ShinsakaiNinteiShinseiJoho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            String b64 = _Base64Serializer.serialize(sut.serialize());
            ShinsakaiNinteiShinseiJoho desirialized = _Base64Serializer.deSerialize(b64, ShinsakaiNinteiShinseiJoho.class);
            assertThat(desirialized.get二号医療保険者名(), is(sut.get二号医療保険者名()));

        }
    }
}
