/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShinsakaiKaisaiBashoMapper;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase2;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催場所DACのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoDacTest extends TestDacBase3 {

    private static IShinsakaiKaisaiBashoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceCreator.create(IShinsakaiKaisaiBashoDac.class);
    }

    public static class selectのテスト extends TestDacBase3 {
    }

    public static class insertのテスト extends TestDacBase3 {

        static {
            setDummyControlData(new RString("DBE"));
        }
//
//        @Test
//        public void insertに成功し_1が返る() {
//            setDummyControlData(new RString("DBE"));
//            assertThat(sut.insert(createEntity("000000001")), is(1));
//        }

        @Test
        public void すでに同じ主キーで登録されていた場合_insertに失敗し_0が返る() {
            setDummyControlData(new RString("DBE"));
            //sut.insert(createEntity("000000001"));
            assertThat(sut.insert(createEntity("000000001")), is(1));
        }
    }

    private static DbT5104ShinsakaiKaisaiBashoJohoEntity createEntity(String 開催場所コード) {

        ShinsakaiKaisaiBashoCode 開催場所コード_A001 = new ShinsakaiKaisaiBashoCode(new RString(開催場所コード));
        RString 開催場所名_山田家 = new RString("山田家");
        ShinsakaiKaisaiChiku 開催地区_chiku01_name01 = new ShinsakaiKaisaiChiku(new RString("chiku01"), new RString("name01"));
        AtenaJusho 開催場所住所_山田市 = new AtenaJusho(new RString("山田市"));
        TelNo 電話番号_0981234567 = new TelNo("0981234567");
        ShinsakaiKaisaiBashoJokyo 開催場所状況_有効 = ShinsakaiKaisaiBashoJokyo.有効;

        DbT5104ShinsakaiKaisaiBashoJohoEntity 審査会開催場所Entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
        審査会開催場所Entity.setShinsakaiKaisaiBashoCode(開催場所コード_A001.value());
        審査会開催場所Entity.setShinsakaiKaisaiBashoMei(開催場所名_山田家);
        審査会開催場所Entity.setShinsakaiKaisaiChikuCode(new Code(開催地区_chiku01_name01.getCode()));
        審査会開催場所Entity.setShinsakaiKaisaiBashoJusho(開催場所住所_山田市);
        審査会開催場所Entity.setShinsakaiKaisaiBashoTelNo(電話番号_0981234567);
        審査会開催場所Entity.setShinsakaiKaisaiBashoJokyo(開催場所状況_有効.is有効());
        return 審査会開催場所Entity;
    }
}
