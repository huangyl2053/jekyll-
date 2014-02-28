/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChikuCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoJohoMapperTest extends TestBase {

    private static ShinsakaiKaisaiBashoCode 開催場所コード_A001 = new ShinsakaiKaisaiBashoCode(new RString("A001"));
    private static RString 開催場所名_山田家 = new RString("山田家");
    private static ShinsakaiKaisaiChiku 開催地区_chiku01_name01 =
            new ShinsakaiKaisaiChiku(new ShinsakaiKaisaiChikuCode(new RString("chiku01")), new RString("name01"));
    private static AtenaJusho 開催場所住所_山田市 = new AtenaJusho(new RString("山田市"));
    private static TelNo 電話番号_0981234567 = new TelNo("0981234567");
    private static ShinsakaiKaisaiBashoJokyo 開催場所状況_有効 = ShinsakaiKaisaiBashoJokyo.有効;

    public static class to審査会開催場所のテスト {

        private ShinsakaiKaisaiBasho sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 開催場所コードにA001を持つEntityが渡されたとき_開催場所コードにA001を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所コード(), is(開催場所コード_A001));
        }

        @Test
        public void 開催場所名に山田家を持つEntityが渡されたとき_開催場所名に山田家を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所名称(), is(開催場所名_山田家));
        }

        @Test
        public void 開催地区コードにchiku01を持つEntityが渡されたとき_開催地区にchiku01を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催地区().get地区コード(), is(開催地区_chiku01_name01.get地区コード()));
        }

        @Test
        public void 開催場所住所に山田市を持つEntityが渡されたとき_開催場所住所に山田市を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所住所(), is(開催場所住所_山田市));
        }

        @Test
        public void 電話番号に0981234567を持つEntityが渡されたとき_電話番号に0981234567を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所電話番号(), is(電話番号_0981234567));
        }

        @Test
        public void 開催場所状況に有効を持つEntityが渡されたとき_開催場所状況に有効を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所状況(), is(開催場所状況_有効));
        }
    }

    public static class to審査会開催場所Entityのテスト {

        private DbT5104ShinsakaiKaisaiBashoJohoEntity sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 開催場所コードにA001を持つ審査会開催場所が渡されたとき_開催場所コードにA001を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoCode(), is(開催場所コード_A001.value()));
        }

        @Test
        public void 開催場所名に山田家を持つ審査会開催場所が渡されたとき_開催場所名に山田家を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoMei(), is(開催場所名_山田家));
        }

        @Test
        public void 開催地区コードにchiku01を持つ審査会開催場所が渡されたとき_開催地区コードにchiku01を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiChikuCode(), is(new Code(開催地区_chiku01_name01.get地区コード().value())));
        }

        @Test
        public void 開催場所住所に山田市を持つ審査会開催場所が渡されたとき_開催場所住所に山田市を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoJusho(), is(開催場所住所_山田市));
        }

        @Test
        public void 電話番号に0981234567を持つ審査会開催場所が渡されたとき_電話番号に0981234567を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoTelNo(), is(電話番号_0981234567));
        }

        @Test
        public void 開催場所状況に有効を持つ審査会開催場所が渡されたとき_開催場所状況に有効を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoJokyo(), is(開催場所状況_有効.is有効()));
        }
    }

    private static DbT5104ShinsakaiKaisaiBashoJohoEntity createEntity() {

        DbT5104ShinsakaiKaisaiBashoJohoEntity 審査会開催場所Entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
        審査会開催場所Entity.setShinsakaiKaisaiBashoCode(開催場所コード_A001.value());
        審査会開催場所Entity.setShinsakaiKaisaiBashoMei(開催場所名_山田家);
        審査会開催場所Entity.setShinsakaiKaisaiChikuCode(new Code(開催地区_chiku01_name01.get地区コード().value()));
        審査会開催場所Entity.setShinsakaiKaisaiBashoJusho(開催場所住所_山田市);
        審査会開催場所Entity.setShinsakaiKaisaiBashoTelNo(電話番号_0981234567);
        審査会開催場所Entity.setShinsakaiKaisaiBashoJokyo(開催場所状況_有効.is有効());
        return 審査会開催場所Entity;
    }

    private static ShinsakaiKaisaiBasho createKaisaiBasho() {
        return new ShinsakaiKaisaiBasho(開催場所コード_A001, 開催場所名_山田家, 開催地区_chiku01_name01,
                開催場所住所_山田市, 電話番号_0981234567, 開催場所状況_有効);
    }
}
