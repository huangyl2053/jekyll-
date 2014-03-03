/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIraiJoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IshiShikibetsuNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5011ShujiiIkenshoIraiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiIkenshoSakuseiIraiJohoMock;
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

    public static class toShujiiIkenshoSakuseiIraiJoho {

        @Test
        public void 申請書管理番号の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get申請書管理番号は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get申請書管理番号(), is(new ShinseishoKanriNo(new RString("申請書管理番号"))));
        }

        @Test
        public void 意見書作成依頼履歴番号の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成依頼履歴番号は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成依頼履歴番号(), is(new IkenshosakuseiIraiRirekiNo(0)));
        }

        @Test
        public void 主治医医療機関コードの設定がある時_toShujiiIkenshoSakuseiIraiJoho_get主治医医療機関コードは_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get主治医医療機関コード(), is(new ShujiiIryoKikanCode(new RString("主治医医療機関コード"))));
        }

        @Test
        public void 医師識別番号の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get医師識別番号は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get医師識別番号(), is(new IshiShikibetsuNo(new RString("医師識別番号"))));
        }

        @Test
        public void 意見書作成依頼区分の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成依頼区分は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成依頼区分(), is(IkenshoIraiKubun.初回依頼));
        }

        @Test
        public void 意見書作成回数の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成回数は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成回数(), is(1));
        }

        @Test
        public void 医師区分の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get医師区分は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get医師区分(), is(IshiKubun.指定医));
        }

        @Test
        public void 意見書作成依頼年月日の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成依頼年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成依頼年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成期限年月日の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成期限年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成期限年月日(), is(FlexibleDate.MAX));
        }

        @Test
        public void 意見書出力年月日の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書出力年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書出力年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 請求書出力年月日の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get請求書出力年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get請求書出力年月日(), is(FlexibleDate.MAX));
        }

        @Test
        public void 作成料請求区分の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get作成料請求区分は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get作成料請求区分(), is(SakuseiryoSeikyuKubun.在宅継続));
        }

        @Test
        public void 意見書作成督促年月日の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成督促年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成督促年月日(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成督促方法の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成督促方法は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成督促方法(), is(IkenshoSakuseiTokusokuHoho.電話));
        }

        @Test
        public void 意見書作成督促回数の設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成督促回数は_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成督促回数(), is(2));
        }

        @Test
        public void 意見書作成督促メモの設定がある時_toShujiiIkenshoSakuseiIraiJoho_get意見書作成督促メモは_設定値を返す() {
            assertThat(toShujiiIkenshoSakuseiIraiJoho().get意見書作成督促メモ(), is(new RString("意見書作成督促メモ")));
        }
    }

    public static class toShujiiIkenshoSakuseiIraiJohoList {

        @Test
        public void 主治医意見書作成依頼情報エンティティが10件の時_toShujiiIkenshoSakuseiIraiJohoListは_10件の主治医意見書作成依頼情報を返す() {
            assertThat(ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIraiJohoList(createDbT5011ShujiiIkenshoIraiJohoEntityList(10)).size(), is(10));
        }
    }

    public static class toDbT5011ShujiiIkenshoIraiJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("申請書管理番号"))));
        }

        @Test
        public void 意見書作成依頼履歴番号の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoIraiRirekiNoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoIraiRirekiNo(), is(0));
        }

        @Test
        public void 主治医医療機関コードの設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getShujiiIryoKikanCodeは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getShujiiIryoKikanCode(), is(new RString("主治医医療機関コード")));
        }

        @Test
        public void 医師識別番号の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIshiShikibetsuNoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIshiShikibetsuNo(), is(new RString("医師識別番号")));
        }

        @Test
        public void 意見書作成依頼区分の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoIraiKubunは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoIraiKubun(), is(new RString("1")));
        }

        @Test
        public void 意見書作成回数の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoIraiKaisuは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoIraiKaisu(), is(1));
        }

        @Test
        public void 医師区分の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIshiKubunCodeは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIshiKubunCode(), is(new Code(new RString("2"))));
        }

        @Test
        public void 意見書作成依頼年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiIraiYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoSakuseiIraiYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成期限年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiKigenYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoSakuseiKigenYMD(), is(FlexibleDate.MAX));
        }

        @Test
        public void 意見書出力年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoShutsuryokuYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoShutsuryokuYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 請求書出力年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getSeikyushoShutsuryokuYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getSeikyushoShutsuryokuYMD(), is(FlexibleDate.MAX));
        }

        @Test
        public void 作成料請求区分の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getSakuseiryoSeikyuKubunは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getSakuseiryoSeikyuKubun(), is(new Code(new RString("12"))));
        }

        @Test
        public void 意見書作成督促年月日の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiTokusokuYMDは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoSakuseiTokusokuYMD(), is(FlexibleDate.MIN));
        }

        @Test
        public void 意見書作成督促方法の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoSakuseiTokusokuHohoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoSakuseiTokusokuHoho(), is(new RString("3")));
        }

        @Test
        public void 意見書作成督促回数の設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoTokusokuKaisuは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoTokusokuKaisu(), is(2));
        }

        @Test
        public void 意見書作成督促メモの設定がある時_toDbT5011ShujiiIkenshoIraiJohoEntity_getIkenshoTokusokuMemoは_設定値を返す() {
            assertThat(toDbT5011ShujiiIkenshoIraiJohoEntity().getIkenshoTokusokuMemo(), is(new RString("意見書作成督促メモ")));
        }
    }

    private static ShujiiIkenshoSakuseiIraiJoho toShujiiIkenshoSakuseiIraiJoho() {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toShujiiIkenshoSakuseiIraiJoho(DbT5011ShujiiIkenshoIraiJohoEntityMock.getSpiedInstance());
    }

    private static DbT5011ShujiiIkenshoIraiJohoEntity toDbT5011ShujiiIkenshoIraiJohoEntity() {
        return ShujiiIkenshoSakuseiIraiJohoMapper.toDbT5011ShujiiIkenshoIraiJohoEntity(ShujiiIkenshoSakuseiIraiJohoMock.getSpiedInstance());
    }

    private static List<DbT5011ShujiiIkenshoIraiJohoEntity> createDbT5011ShujiiIkenshoIraiJohoEntityList(int size) {
        List<DbT5011ShujiiIkenshoIraiJohoEntity> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(DbT5011ShujiiIkenshoIraiJohoEntityMock.getSpiedInstance());
        }
        return list;
    }
}
