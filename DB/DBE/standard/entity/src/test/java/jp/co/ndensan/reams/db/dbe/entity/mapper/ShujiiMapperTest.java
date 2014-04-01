/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT7012ShujiiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 主治医情報を変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiMapperTest {

    public static class toShujii {

        @Test
        public void 証記載保険者番号の設定がある時_toShujii_get証記載保険者番号は_設定値を返す() {
            assertThat(createShujii().get証記載保険者番号().getValue(), is(new RString("証記載保険者番号")));
        }

        @Test
        public void 介護医療機関コードの設定がある時_toShujii_get介護医療機関コードは_設定値を返す() {
            assertThat(createShujii().get介護医療機関コード().getValue(), is(new RString("介護医療機関コード")));
        }

        @Test
        public void 介護医師コードの設定がある時_toShujii_get介護医師コードは_設定値を返す() {
            assertThat(createShujii().get介護医師コード().value(), is(new RString("介護医師コード")));
        }

        @Test
        public void 医療機関コードの設定がある時_toShujii_get医療機関コードは_設定値を返す() {
            assertThat(createShujii().get医療機関コード().getValue(), is(new RString("1234567890")));
        }

        @Test
        public void 医師識別番号の設定がある時_toShujii_get医師識別番号は_設定値を返す() {
            assertThat(createShujii().get医師識別番号(), is(new RString("医師識別番号")));
        }

        @Test
        public void 医師の状況の設定がある時_toShujii_is有効は_設定値を返す() {
            assertThat(createShujii().is有効(), is(IshiJokyo.有効.is有効()));
        }

        @Test
        public void 郵便番号の設定がある時_toShujii_get郵便番号は_設定値を返す() {
            assertThat(createShujii().get郵便番号().value(), is(new RString("123-4567")));
        }

        @Test
        public void 住所の設定がある時_toShujii_get住所は_設定値を返す() {
            assertThat(createShujii().get住所().value(), is(new RString("住所")));
        }

        @Test
        public void 電話番号の設定がある時_toShujii_get電話番号は_設定値を返す() {
            assertThat(createShujii().get電話番号().value(), is(new RString("電話番号")));
        }

        @Test
        public void FAX番号の設定がある時_toShujii_getFAX番号は_設定値を返す() {
            assertThat(createShujii().getFAX番号(), is(new RString("FAX番号")));
        }
    }

    public static class toShujiiEntity {

        @Test
        public void 証記載保険者番号の設定がある時_toShujiiEntity_getShoKisaiHokenshaNoは_設定値を返す() {
            assertThat(createShujiiEntity().getShoKisaiHokenshaNo(), is(new ShoKisaiHokenshaNo(new RString("証記載保険者番号"))));
        }

        @Test
        public void 介護医療機関コードの設定がある時_toShujiiEntity_getKaigoIryokikanCodeは_設定値を返す() {
            KaigoIryoKikanCode kaigoIryoKikanCode = new KaigoIryoKikanCode(new RString("介護医療機関コード"));
            assertThat(createShujiiEntity().getKaigoIryokikanCode(), is(kaigoIryoKikanCode));
        }

        @Test
        public void 介護医師コードの設定がある時_toShujiiEntity_getKaigoIshiCodeは_設定値を返す() {
            assertThat(createShujiiEntity().getKaigoIshiCode(), is(new RString("介護医師コード")));
        }

        @Test
        public void 医療機関コードの設定がある時_toShujiiEntity_getIryokikanCodeは_設定値を返す() {
            assertThat(createShujiiEntity().getIryokikanCode(), is(new RString("1234567890")));
        }

        @Test
        public void 医師識別番号の設定がある時_toShujiiEntity_getShujiiCodeは_設定値を返す() {
            assertThat(createShujiiEntity().getIshiShikibetsuNo(), is(new RString("医師識別番号")));
        }

        @Test
        public void 医師の状況の設定がある時_toShujiiEntity_getShujiiJokyoは_設定値を返す() {
            assertThat(createShujiiEntity().getShujiiJokyo(), is(IshiJokyo.有効.is有効()));
        }

        @Test
        public void 郵便番号の設定がある時_toShujiiEntity_getYubinNoは_設定値を返す() {
            YubinNo yubinNo = new YubinNo(new RString("123-4567"));
            assertThat(createShujiiEntity().getYubinNo(), is(yubinNo));
        }

        @Test
        public void 住所の設定がある時_toShujiiEntity_getJushoは_設定値を返す() {
            assertThat(createShujiiEntity().getJusho(), is(new AtenaJusho(new RString("住所"))));
        }

        @Test
        public void 電話番号の設定がある時_toShujiiEntity_getTelNoは_設定値を返す() {
            TelNo telNo = new TelNo(new RString("電話番号"));
            assertThat(createShujiiEntity().getTelNo(), is(telNo));
        }

        @Test
        public void FAX番号の設定がある時_toShujiiEntity_getFaxNoは_設定値を返す() {
            assertThat(createShujiiEntity().getFaxNo(), is(new RString("FAX番号")));
        }
    }

    private static IShujii createShujii() {
        return ShujiiMapper.toShujii(DbT7012ShujiiJohoEntityMock.getSpiedInstance());
    }

    private static DbT7012ShujiiJohoEntity createShujiiEntity() {
        return ShujiiMapper.toEntity(ShujiiMock.getSpiedInstance());
    }
}
