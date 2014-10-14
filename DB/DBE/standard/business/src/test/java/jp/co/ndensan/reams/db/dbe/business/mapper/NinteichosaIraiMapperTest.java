/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosaIraiMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import static jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaIraiTestHelper.create認定調査依頼情報;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper.*;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * * 認定調査依頼情報Mapperのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiMapperTest extends TestBase {

    public static class to認定調査依頼情報のテスト extends TestBase {

        NinteichosaIrai sut;

        @Override
        public void setUp() {
            sut = NinteichosaIraiMapper.to認定調査依頼情報(create認定調査依頼情報Entity());
        }

        @Test
        public void 引数にnullがわたったとき_戻り値はnullになる() {
            sut = NinteichosaIraiMapper.to認定調査依頼情報(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void entityから渡された申請書管理番号と_Mapping後の認定調査依頼情報が返す申請書管理番号が_同一になる() {
            assertThat(sut.get申請書管理番号(), is(shinseishoKanriNo));
        }

        @Test
        public void entityから渡された認定調査依頼履歴番号と_Mapping後の認定調査依頼情報が返す認定調査依頼履歴番号が_同一になる() {
            assertThat(sut.get認定調査依頼履歴番号(), is(ninteichosaIraiRirekiNo));
        }

        @Test
        public void entityから渡された認定調査委託先コードと_Mapping後の認定調査依頼情報が返す認定調査委託先コードが_同一になる() {
            assertThat(sut.get認定調査委託先コード(), is(ninteichosaItakusakiCode));
        }

        @Test
        public void entityから渡された調査員番号コードと_Mapping後の認定調査依頼情報が返す調査員番号コードが_同一になる() {
            assertThat(sut.get調査員番号コード(), is(chousainCode));
        }

        @Test
        public void entityから渡された認定調査依頼区分と_Mapping後の認定調査依頼情報が返す認定調査依頼区分が_同一になる() {
            assertThat(sut.get認定調査依頼区分().getCode(), is(ninteichousaIraiKubunCode));
        }

        @Test
        public void entityから渡された認定調査回数と_Mapping後の認定調査依頼情報が返す認定調査回数が_同一になる() {
            assertThat(sut.get認定調査回数(), is(ninteichosaIraiKaisu));
        }

        @Test
        public void entityから渡された認定調査依頼年月日と_Mapping後の認定調査依頼情報が返す認定調査依頼年月日が_同一になる() {
            assertThat(sut.get認定調査依頼年月日().toFlexibleDate(), is(ninteichosaIraiYMD));
        }

        @Test
        public void entityから渡された認定調査期限年月日と_Mapping後の認定調査依頼情報が返す認定調査期限年月日が_同一になる() {
            assertThat(sut.get認定調査期限年月日().toFlexibleDate(), is(ninteichosaKigenYMD));
        }

        @Test
        public void entityから渡された認定調査出力年月日と_Mapping後の認定調査依頼情報が返す認定調査出力年月日が_同一になる() {
            assertThat(sut.get認定調査出力年月日().toFlexibleDate(), is(iraishoShutsuryokuYMD));
        }

        @Test
        public void entityから渡された調査票等出力年月日と_Mapping後の認定調査依頼情報が返す調査票等出力年月日が_同一になる() {
            assertThat(sut.get調査票等出力年月日().toFlexibleDate(), is(chosahyoTouShutsuryokuYMD));
        }

        @Test
        public void entityから渡されたモバイルデータ出力部フラグと_Mapping後の認定調査依頼情報の_is出力済みが同一になる() {
            assertThat(sut.isモバイルデータ出力済み(), is(mobileDataShutsuryokuFlag));
        }

        @Test
        public void entityから渡された認定調査督促年月日と_Mapping後の認定調査依頼情報が返す認定調査督促年月日が_同一になる() {
            assertThat(sut.get認定調査督促年月日().toFlexibleDate(), is(ninteichosaTokusokuYMD));
        }

        @Test
        public void entityから渡された認定調査督促方法と_Mapping後の認定調査依頼情報が返す認定調査督促方法が_同一になる() {
            assertThat(sut.get認定調査督促方法().getCode(), is(ninteichosaTokusokuHoho));
        }

        @Test
        public void entityから渡された認定調査督促回数と_Mapping後の認定調査依頼情報が返す認定調査督促回数が_同一になる() {
            assertThat(sut.get認定調査督促回数(), is(ninteichosaTokusokuKaisu));
        }

        @Test
        public void entityから渡された認定調査督促メモと_Mapping後の認定調査依頼情報が返す認定調査督促メモが_同一になる() {
            assertThat(sut.get認定調査督促メモ(), is(ninteichosaTokusokuMemo));
        }
    }

    public static class to認定調査依頼情報Collectionのテスト {

        @Test
        public void 引数にNullが渡されたとき_空のコレクションが返る() {
            assertThat(NinteichosaIraiMapper.to認定調査依頼情報Collection(null).isEmpty(), is(true));
        }

        @Test
        public void 引数に一つも要素を持たないリストが渡されたとき_空のコレクションが返る() {
            assertThat(NinteichosaIraiMapper.to認定調査依頼情報Collection(createList(0)).isEmpty(), is(true));
        }

        @Test
        public void 引数に一つも空のリストが渡されたとき_空のコレクションが返る() {
            assertThat(NinteichosaIraiMapper.to認定調査依頼情報Collection(Collections.EMPTY_LIST).isEmpty(), is(true));
        }

        @Test
        public void 引数に4件のEntityを持つリストが渡されたとき_4件の認定調査依頼情報を持ったコレクションを返す() {
            assertThat(NinteichosaIraiMapper.to認定調査依頼情報Collection(createList(4)).size(), is(4));
        }

        private List<DbT5006NinteichosaIraiJohoEntity> createList(int 要素数) {
            List<DbT5006NinteichosaIraiJohoEntity> list = new ArrayList<>();
            for (int i = 0; i < 要素数; i++) {
                list.add(create認定調査依頼情報Entity());
            }
            return list;
        }
    }

    public static class to認定調査依頼情報Entityのテスト extends TestBase {

        DbT5006NinteichosaIraiJohoEntity sut;

        @Override
        public void setUp() {
            sut = NinteichosaIraiMapper.to認定調査依頼情報Entity(create認定調査依頼情報());
        }

        @Test
        public void 引数にnullがわたったとき_戻り値はnullになる() {
            sut = NinteichosaIraiMapper.to認定調査依頼情報Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数から渡された申請書管理番号と_Mapping後のEntityが返す申請書管理番号が_同一になる() {
            assertThat(sut.getShinseishoKanriNo(), is(shinseishoKanriNo));
        }

        @Test
        public void 引数から渡された認定調査依頼履歴番号と_Mapping後のEntityが返す認定調査依頼履歴番号が_同一になる() {
            assertThat(sut.getNinteichosaIraiRirekiNo(), is(ninteichosaIraiRirekiNo));
        }

        @Test
        public void 引数から渡された認定調査委託先コードと_Mapping後のEntityが返す認定調査委託先コードが_同一になる() {
            assertThat(sut.getNinteichosaItakusakiCode(), is(ninteichosaItakusakiCode));
        }

        @Test
        public void 引数から渡された調査員番号コードと_Mapping後のEntityが返す調査員番号コードが_同一になる() {
            assertThat(sut.getChousainCode(), is(chousainCode));
        }

        @Test
        public void 引数から渡された認定調査依頼区分と_Mapping後のEntityが返す認定調査依頼区分が_同一になる() {
            assertThat(sut.getNinteichousaIraiKubunCode(), is(ninteichousaIraiKubunCode));
        }

        @Test
        public void 引数から渡された認定調査回数と_Mapping後のEntityが返す認定調査回数が_同一になる() {
            assertThat(sut.getNinteichosaIraiKaisu(), is(ninteichosaIraiKaisu));
        }

        @Test
        public void 引数から渡された認定調査依頼年月日と_Mapping後のEntityが返す認定調査依頼年月日が_同一になる() {
            assertThat(sut.getNinteichosaIraiYMD(), is(ninteichosaIraiYMD));
        }

        @Test
        public void 引数から渡された認定調査期限年月日と_Mapping後のEntityが返す認定調査期限年月日が_同一になる() {
            assertThat(sut.getNinteichosaKigenYMD(), is(ninteichosaKigenYMD));
        }

        @Test
        public void 引数から渡された認定調査出力年月日と_Mapping後のEntityが返す認定調査出力年月日が_同一になる() {
            assertThat(sut.getIraishoShutsuryokuYMD(), is(iraishoShutsuryokuYMD));
        }

        @Test
        public void 引数から渡された調査票等出力年月日と_Mapping後のEntityが返す調査票等出力年月日が_同一になる() {
            assertThat(sut.getChosahyoTouShutsuryokuYMD(), is(chosahyoTouShutsuryokuYMD));
        }

        @Test
        public void 引数から渡されたモバイルデータ出力部フラグと_Mapping後のEntityの_is出力済みが同一になる() {
            assertThat(sut.getMobileDataShutsuryokuFlag(), is(mobileDataShutsuryokuFlag));
        }

        @Test
        public void 引数から渡された認定調査督促年月日と_Mapping後のEntityが返す認定調査督促年月日が_同一になる() {
            assertThat(sut.getNinteichosaTokusokuYMD(), is(ninteichosaTokusokuYMD));
        }

        @Test
        public void 引数から渡された認定調査督促方法と_Mapping後のEntityが返す認定調査督促方法が_同一になる() {
            assertThat(sut.getNinteichosaTokusokuHoho(), is(ninteichosaTokusokuHoho));
        }

        @Test
        public void 引数から渡された認定調査督促回数と_Mapping後のEntityが返す認定調査督促回数が_同一になる() {
            assertThat(sut.getNinteichosaTokusokuKaisu(), is(ninteichosaTokusokuKaisu));
        }

        @Test
        public void 引数から渡された認定調査督促メモと_Mapping後のEntityが返す認定調査督促メモが_同一になる() {
            assertThat(sut.getNinteichosaTokusokuMemo(), is(ninteichosaTokusokuMemo));
        }
    }
}
