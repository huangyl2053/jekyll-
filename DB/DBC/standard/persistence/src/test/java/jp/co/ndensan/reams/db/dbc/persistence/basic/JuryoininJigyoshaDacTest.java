/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Before;

/**
 * 受領委任事業者データアクセスクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JuryoininJigyoshaDacTest extends DbcTestDacBase {

    private static IJuryoininJigyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceCreator.create(IJuryoininJigyoshaDac.class);
    }

//    public static class insertOrUpdate extends DbcTestDacBase {
//
//        @Test
//        public void 指定した受領委任事業者情報がない時_insertOrUpdateは_指定した情報を追加する() {
//            int result = sut.insertOrUpdate(create受領委任事業者Entity(new RString("1111111111")));
//            assertThat(result, is(1));
//        }
//
//        @Test
//        public void 指定した受領委任事業者情報がある時_insertOrUpdateは_指定した情報を更新する() {
//
//            initializeEntityData();
//            RString 契約番号 = new RString("1111111111");
//            RString 送付先部署 = new RString("１課");
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = create受領委任事業者Entity(契約番号);
//            entity.setSofusakiBusho(送付先部署);
//            sut.insertOrUpdate(entity);
//            DbT3077JuryoininKeiyakuJigyoshaEntity result = sut.select(new KeiyakuNo(契約番号));
//
//            assertThat(result.getSofusakiBusho(), is(送付先部署));
//        }
//}
    public static class insert extends DbcTestDacBase {

        RString 契約番号 = new RString("1111111111");

        @Test
        public void 新規にデータをinsertできる() {

            int result = sut.insert(create受領委任事業者Entity(契約番号));
            assertThat(result, is(1));
        }

        @Test
        public void 既存のデータがある時でもinsertできる() {

            sut.insert(create受領委任事業者Entity(契約番号));
            int result = sut.insert(create受領委任事業者Entity(契約番号));
            assertThat(result, is(1));
        }
    }

    public static class select extends DbcTestDacBase {

        @Test
        public void 該当の受領委任事業者情報が存在しない時_select契約番号は_NULLを返す() {

            KeiyakuNo 契約番号 = new KeiyakuNo(new RString("0000000000"));
            DbT3077JuryoininKeiyakuJigyoshaEntity result = sut.select(契約番号);

            assertThat(result, nullValue());
        }

        @Test
        public void 該当の受領委任事業者情報が存在する時_select契約番号は_該当entityを返す() {

            initializeEntityData();
            KeiyakuNo 契約番号 = new KeiyakuNo(new RString("1111111111"));
            DbT3077JuryoininKeiyakuJigyoshaEntity result = sut.select(契約番号);

            assertThat(result, instanceOf(DbT3077JuryoininKeiyakuJigyoshaEntity.class));
        }
    }

    private static void initializeEntityData() {

        sut.insert(create受領委任事業者Entity(new RString("1111111111")));
        sut.insert(create受領委任事業者Entity(new RString("2222222222")));
        sut.insert(create受領委任事業者Entity(new RString("3333333333")));
    }

    private static DbT3077JuryoininKeiyakuJigyoshaEntity create受領委任事業者Entity(RString keiyakuNo) {

        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(keiyakuNo);
        entity.setKaishiYMD(new FlexibleDate("20110303"));
        entity.setShoriTimestamp(RDateTime.of(2014, 1, 10, 11, 12));
        entity.setShuryoYMD(new FlexibleDate("20130303"));
        entity.setTodokedeYMD(new FlexibleDate("20110203"));
        entity.setTodokedeAddress(new RString("長野市高田"));
        entity.setTodokedeJigyoshaName(new RString("ひまわり"));
        entity.setTodokedeDaihyoshaName(new RString("田中良夫"));
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0000000001")));
        entity.setJigyoshaFaxNo(new TelNo(new RString("0262222222")));
        entity.setKeiyakuTorokuYMD(new FlexibleDate("20110208"));
        entity.setSofusakiBusho(new RString("担当課"));
        entity.setEigyoKeitai(EigyoKeitai.法人.getCode());
        entity.setJutakuKaishuKeiyakuUmu(true);
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(true);
        entity.setShokanbaraiKyufuKeiyakuUmu(true);
        entity.setKogakuKyufuKeiyakuUmu(true);
        entity.setKeiyakuJigyoshaNo(new JigyoshaNo(new RString("1234567890")));
        entity.setToriatsukaiKakuyakushoUmu(true);

        return entity;
    }
}
