/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5011ShujiiIkenshoIraiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoDoctorMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiIkenshoSakuseiIraiMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書作成依頼情報を変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoSakuseiIraiJohoMapperTest {

    public static class toShujiiIkenshoSakuseiIrai {

        @Test
        public void 申請書管理番号の設定がある時_toShujiiIkenshoSakuseiIrai_get申請書管理番号は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get申請書管理番号(), is(new ShinseishoKanriNo(new RString("申請書管理番号"))));
        }

        @Test
        public void 意見書作成依頼履歴番号の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成依頼履歴番号は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成依頼履歴番号(), is(new IkenshosakuseiIraiRirekiNo(0)));
        }

        @Test
        public void 介護医師の設定がある時_toShujiiIkenshoSakuseiIrai_get介護医師は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get介護医師().get介護医師コード(), is(new KaigoDoctorCode(new RString("介護医師コード"))));
        }

        @Test
        public void 意見書作成依頼区分の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成依頼区分は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成依頼区分(), is(IkenshoIraiKubun.初回依頼));
        }

        @Test
        public void 意見書作成回数の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成回数は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成回数(), is(1));
        }

        @Test
        public void 医師区分の設定がある時_toShujiiIkenshoSakuseiIrai_get医師区分は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get医師区分(), is(IshiKubun.指定医));
        }

        @Test
        public void 意見書作成依頼年月日の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成依頼年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成依頼年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成期限年月日の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成期限年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成期限年月日(), is(FlexibleDate.MAX));
        }

        @Test
        public void 意見書出力年月日の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書出力年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書出力年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 請求書出力年月日の設定がある時_toShujiiIkenshoSakuseiIrai_get請求書出力年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get請求書出力年月日(), is(FlexibleDate.MAX));
        }

        @Test
        public void 作成料請求区分の設定がある時_toShujiiIkenshoSakuseiIrai_get作成料請求区分は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get作成料請求区分(), is(SakuseiryoSeikyuKubun.在宅継続));
        }

        @Test
        public void 意見書作成督促年月日の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成督促年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成督促年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成督促方法の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成督促方法は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成督促方法(), is(IkenshoSakuseiTokusokuHoho.電話));
        }

        @Test
        public void 意見書作成督促回数の設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成督促回数は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成督促回数(), is(2));
        }

        @Test
        public void 意見書作成督促メモの設定がある時_toShujiiIkenshoSakuseiIrai_get意見書作成督促メモは_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIrai().get意見書作成督促メモ(), is(new RString("意見書作成督促メモ")));
        }
    }

    public static class toDbT5011ShujiiIkenshoIraiJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("申請書管理番号"))));
        }

        @Test
        public void 意見書作成依頼履歴番号の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoIraiRirekiNoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoIraiRirekiNo(), is(0));
        }

        @Test
        public void 介護医療機関コードの設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getKaigoIryokikanCodeは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getKaigoIryokikanCode(), is(new RString("介護医療機関コード")));
        }

        @Test
        public void 介護医師コードの設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getKaigoIshiCodeは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getKaigoIshiCode(), is(new RString("介護医師コード")));
        }

        @Test
        public void 意見書作成依頼区分の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoIraiKubunは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoIraiKubun(), is(new RString("1")));
        }

        @Test
        public void 意見書作成回数の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoIraiKaisuは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoIraiKaisu(), is(1));
        }

        @Test
        public void 医師区分の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIshiKubunCodeは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIshiKubunCode(), is(new Code(new RString("2"))));
        }

        @Test
        public void 意見書作成依頼年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiIraiYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoSakuseiIraiYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成期限年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiKigenYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoSakuseiKigenYMD(), is(FlexibleDate.MAX));
        }

        @Test
        public void 意見書出力年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoShutsuryokuYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoShutsuryokuYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 請求書出力年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getSeikyushoShutsuryokuYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getSeikyushoShutsuryokuYMD(), is(FlexibleDate.MAX));
        }

        @Test
        public void 作成料請求区分の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getSakuseiryoSeikyuKubunは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getSakuseiryoSeikyuKubun(), is(new Code(new RString("12"))));
        }

        @Test
        public void 意見書作成督促年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiTokusokuYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoSakuseiTokusokuYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成督促方法の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiTokusokuHohoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoSakuseiTokusokuHoho(), is(new RString("3")));
        }

        @Test
        public void 意見書作成督促回数の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoTokusokuKaisuは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoTokusokuKaisu(), is(2));
        }

        @Test
        public void 意見書作成督促メモの設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoTokusokuMemoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiEntity().getIkenshoTokusokuMemo(), is(new RString("意見書作成督促メモ")));
        }
    }

    private static ShujiiIkenshoSakuseiIrai toShujiiIkenshoSakuseiIrai() {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIrai(DbT5011ShujiiIkenshoIraiJohoEntityMock.getSpiedInstance(), KaigoDoctorMock.getSpiedInstance());
    }

    private static DbT5011ShujiiIkenshoIraiJohoEntity toDbT5011ShujiiIkenshoIraiEntity() {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toDbT5011ShujiiIkenshoIraiJohoEntity(ShujiiIkenshoSakuseiIraiMock.getSpiedInstance());
    }
}
