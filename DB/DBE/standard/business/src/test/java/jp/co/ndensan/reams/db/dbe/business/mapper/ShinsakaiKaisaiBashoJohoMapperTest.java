/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.ShinsakaiKaisaiBashoMapper;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催場所情報Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoJohoMapperTest {

    private static ShinsakaiKaisaiBashoCode 開催場所コード_A001 = new ShinsakaiKaisaiBashoCode(new RString("A001"));
    private static RString 開催場所名_山田家 = new RString("山田家");
    private static ShinsakaiKaisaiChiku 開催地区_chiku01_name01 = new ShinsakaiKaisaiChiku(new RString("chiku01"), new RString("name01"));
    private static AtenaJusho 開催場所住所_山田市 = new AtenaJusho(new RString("山田市"));
    private static TelNo 電話番号_0981234567 = new TelNo("0981234567");
    private static ShinsakaiKaisaiBashoJokyo 開催場所状況_有効 = ShinsakaiKaisaiBashoJokyo.有効;

    public static class to審査会開催場所のテスト extends DbeTestBase {

        private ShinsakaiKaisaiBasho sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 開催場所コードにA001を持つEntityが渡されたとき_開催場所コードにA001を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所コード(), is(開催場所コード_A001));
        }

        @Test
        public void 開催場所名に山田家を持つEntityが渡されたとき_開催場所名に山田家を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所名称(), is(開催場所名_山田家));
        }

        @Test
        public void 開催地区コードにchiku01を持つEntityが渡されたとき_開催地区にchiku01を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催地区().getCode(), is(開催地区_chiku01_name01.getCode()));
        }

        @Test
        public void 開催場所住所に山田市を持つEntityが渡されたとき_開催場所住所に山田市を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所住所(), is(開催場所住所_山田市));
        }

        @Test
        public void 電話番号に0981234567を持つEntityが渡されたとき_電話番号に0981234567を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所電話番号(), is(電話番号_0981234567));
        }

        @Test
        public void 開催場所状況に有効を持つEntityが渡されたとき_開催場所状況に有効を持つ審査会開催場所が返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所(createEntity());
            assertThat(sut.get開催場所状況(), is(開催場所状況_有効));
        }
    }

    public static class to審査会開催場所Entityのテスト extends DbeTestBase {

        private DbT5104ShinsakaiKaisaiBashoJohoEntity sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 開催場所コードにA001を持つ審査会開催場所が渡されたとき_開催場所コードにA001を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoCode(), is(開催場所コード_A001.value()));
        }

        @Test
        public void 開催場所名に山田家を持つ審査会開催場所が渡されたとき_開催場所名に山田家を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoMei(), is(開催場所名_山田家));
        }

        @Test
        public void 開催地区コードにchiku01を持つ審査会開催場所が渡されたとき_開催地区コードにchiku01を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiChikuCode(), is((Code) 開催地区_chiku01_name01));
        }

        @Test
        public void 開催場所住所に山田市を持つ審査会開催場所が渡されたとき_開催場所住所に山田市を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoJusho(), is(開催場所住所_山田市));
        }

        @Test
        public void 電話番号に0981234567を持つ審査会開催場所が渡されたとき_電話番号に0981234567を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoTelNo(), is(電話番号_0981234567));
        }

        @Test
        public void 開催場所状況に有効を持つ審査会開催場所が渡されたとき_開催場所状況に有効を持つEntityが返る() {
            sut = ShinsakaiKaisaiBashoMapper.to審査会開催場所Entity(createKaisaiBasho());
            assertThat(sut.getShinsakaiKaisaiBashoJokyo(), is(開催場所状況_有効.is有効()));
        }
    }

    private static DbT5104ShinsakaiKaisaiBashoJohoEntity createEntity() {

        DbT5104ShinsakaiKaisaiBashoJohoEntity 審査会開催場所Entity =
                GogitaiMockEntityCreator.create開催場所EntitySpy(開催場所コード_A001.value().toString());
        審査会開催場所Entity.setShinsakaiKaisaiBashoCode(開催場所コード_A001.value());
        審査会開催場所Entity.setShinsakaiKaisaiBashoMei(開催場所名_山田家);
        審査会開催場所Entity.setShinsakaiKaisaiChikuCode(開催地区_chiku01_name01);
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
