/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaTokkijiko;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査特記事項Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaTokkijikoMapperTest extends TestBase {

    private static ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
    private static NinteichosaIraiRirekiNo 認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
    private static RString 認定調査特記事項番号 = new RString("B001");
    private static RString 特記事項 = new RString("特記");

    public static class to認定調査特記事項のテスト extends TestBase {

        private NinteichosaTokkijiko sut;

        @Override
        public void setUp() {
            sut = NinteichosaTokkijikoMapper.to認定調査特記事項(create認定調査特記事項Entity());
        }

        @Test
        public void 引数にnullが渡されたとき_nullを返す() {
            sut = NinteichosaTokkijikoMapper.to認定調査特記事項(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数のEntityが持つ申請書管理番号と_戻り値の認定調査特記事項が持つ申請書管理番号が同一になる() {
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 引数のEntityが持つ認定調査依頼履歴番号と_戻り値の認定調査特記事項が持つ認定調査依頼履歴番号が同一になる() {
            assertThat(sut.get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 引数のEntityが持つ認定調査特記事項番号と_戻り値の認定調査特記事項が持つ認定調査特記事項番号が同一になる() {
            assertThat(sut.get認定調査特記事項番号(), is(認定調査特記事項番号));
        }

        @Test
        public void 引数のEntityが持つ特記事項と_戻り値の認定調査特記事項が持つ特記事項が同一になる() {
            assertThat(sut.get特記事項(), is(特記事項));
        }
    }

    public static class to認定調査特記事項Entityのテスト extends TestBase {

        private DbT5010NinteichosaTokkijikoEntity sut;

        @Override
        public void setUp() {
            sut = NinteichosaTokkijikoMapper.to認定調査特記事項Entity(create認定調査特記事項());
        }

        @Test
        public void 引数にnullが渡されたとき_nullを返す() {
            sut = NinteichosaTokkijikoMapper.to認定調査特記事項Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数のEntityが持つ申請書管理番号と_戻り値の認定調査特記事項が持つ申請書管理番号が同一になる() {
            assertThat(sut.getShinseishoKanriNo(), is(申請書管理番号));
        }

        @Test
        public void 引数のEntityが持つ認定調査依頼履歴番号と_戻り値の認定調査特記事項が持つ認定調査依頼履歴番号が同一になる() {
            assertThat(sut.getNinteichosaRirekiNo(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 引数のEntityが持つ認定調査特記事項番号と_戻り値の認定調査特記事項が持つ認定調査特記事項番号が同一になる() {
            assertThat(sut.getNinteichosaTokkijikoNo(), is(認定調査特記事項番号));
        }

        @Test
        public void 引数のEntityが持つ特記事項と_戻り値の認定調査特記事項が持つ特記事項が同一になる() {
            assertThat(sut.getNinteichosaTokkijiko(), is(特記事項));
        }
    }

    private static NinteichosaTokkijiko create認定調査特記事項() {
        return new NinteichosaTokkijiko(申請書管理番号, 認定調査依頼履歴番号,
                認定調査特記事項番号, 特記事項);
    }

    private static DbT5010NinteichosaTokkijikoEntity create認定調査特記事項Entity() {
        DbT5010NinteichosaTokkijikoEntity entity = new DbT5010NinteichosaTokkijikoEntity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        entity.setNinteichosaTokkijikoNo(認定調査特記事項番号);
        entity.setNinteichosaTokkijiko(特記事項);
        return entity;
    }
}
