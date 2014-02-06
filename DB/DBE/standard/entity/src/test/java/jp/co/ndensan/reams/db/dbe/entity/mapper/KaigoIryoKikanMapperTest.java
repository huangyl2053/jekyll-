/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoIryoKikanTestHelper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctors;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business._Doctors;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.entity.IryoKikanEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 介護医療機関Mapperのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoIryoKikanMapperTest extends TestBase {

    public static class toKaigoIryoKikanのテスト extends TestBase {

        private RString 識別コード;
        private RString 医療機関名称;
        private RString 医療機関略称;
        private RString 医療機関カナ略称;
        private RString 郵便番号;
        private RString 住所;
        private RString カナ住所;
        private RString 会員区分;
        private boolean 指定自立支援医療機関flag;
        private RDate 新設年月日;
        private RDate 廃止年月日;
        private RString 休止区分;
        private RString 異動事由;
        private RDate 異動年月日;
        private ShichosonCode 市町村コード;
        private KaigoIryoKikanCode 介護医療機関コード;
        private IIryoKikanCode 医療機関コード;
        private IryoKikanJokyo 医療機関状況;
        private IryoKikanKubun 医療機関区分;
        private List<IKoza> 口座;
        private KaigoIryoKikan sut;

        @Override
        public void setUp() {
            setDummyControlData("DB");

            識別コード = new RString("S02B00001");
            医療機関名称 = new RString("介護病院");
            医療機関略称 = new RString("介護病院");
            医療機関カナ略称 = new RString("カイゴビョウイン");
            郵便番号 = new RString("903-1111");
            住所 = new RString("A町B1-12-123");
            カナ住所 = new RString("エーマチ");
            会員区分 = new RString("会員");
            指定自立支援医療機関flag = true;
            新設年月日 = new RDate("19991212");
            廃止年月日 = new RDate("20091212");
            休止区分 = new RString("休止");
            異動事由 = new RString("疲れのため");
            異動年月日 = new RDate("20051212");
            市町村コード = new ShichosonCode(new RString("A001"));
            介護医療機関コード = new KaigoIryoKikanCode(new RString("B001"));
            医療機関コード = new _IryoKikanCode(new RString("C00000001"));
            医療機関状況 = IryoKikanJokyo.有効;
            医療機関区分 = new IryoKikanKubun(new RString("ABC"), new RString("名称"), new RString("略称"));
            口座 = KaigoIryoKikanTestHelper.create口座List(3);

            sut = KaigoIryoKikanMapper.toKaigoIryoKikan(create介護医療機関Entity(), 口座);
        }

        @Test
        public void 引数から渡された医療機関コードと_戻り値の介護医療機関クラスの医療機関コードが同一になる() {
            assertThat(sut.get医療機関コード().getValue(), is(医療機関コード.getValue()));
        }

        @Test
        public void 引数から渡された識別コードと_戻り値の介護医療機関クラスの識別コードが同一になる() {
            assertThat(sut.get識別コード().getValue(), is(識別コード));
        }

        @Test
        public void 引数から渡された医療機関名称と_戻り値の介護医療機関クラスの医療機関名称が同一になる() {
            assertThat(sut.get医療機関名称().getName(), is(医療機関名称));
        }

        @Test
        public void 引数から渡された医療機関略称と_戻り値の介護医療機関クラスの医療機関略称が同一になる() {
            assertThat(sut.get医療機関略称().getName(), is(医療機関略称));
        }

        @Test
        public void 引数から渡された所在地郵便番号と_戻り値の介護医療機関クラスの所在地郵便番号が同一になる() {
            assertThat(sut.get所在地郵便番号(), is(郵便番号));
        }

        @Test
        public void 引数から渡された所在地住所と_戻り値の介護医療機関クラスの所在地住所が同一になる() {
            assertThat(sut.get所在地住所(), is(住所));
        }

        @Test
        public void 引数から渡された所在地カナ住所と_戻り値の介護医療機関クラスの所在地カナ住所が同一になる() {
            assertThat(sut.get所在地カナ住所(), is(カナ住所));
        }

        @Test
        public void 引数から渡された開設期間の開始と_戻り値の介護医療機関クラスの新設年月日が同一になる() {
            assertThat(sut.get開設期間().getFrom(), is(新設年月日));
        }

        @Test
        public void 引数から渡された開設期間の終了と_戻り値の介護医療機関クラスの廃止年月日が同一になる() {
            assertThat(sut.get開設期間().getTo(), is(廃止年月日));
        }

        @Test
        public void 引数から渡された新設年月日から廃止年月日までの期間内に_基準日を設定すると_is有効医療機関がtrueを返す() {
            sut.is有効医療機関(new RDate("20051212"));
        }

        @Test
        public void 引数から渡された新設年月日から廃止年月日までの期間の外に_基準日を設定すると_is有効医療機関がfalseを返す() {
            sut.is有効医療機関(new RDate("20211212"));
        }

        @Test
        public void 引数から渡された所属医師が空である() {
            assertThat(sut.get所属医師().iterator().hasNext(), is(false));
        }

        @Test
        public void 引数から渡された口座Listと_戻り値の介護医療機関クラスの口座Listが同一になる() {
            assertThat(sut.get口座(), is(口座));
        }

        @Test
        public void 引数から渡された異動年月日と_戻り値の介護医療機関クラスの異動年月日が同一になる() {
            assertThat(sut.get異動年月日(), is(異動年月日));
        }

        @Test
        public void 引数から渡された休止区分と_戻り値の介護医療機関クラスの休止区分が同一になる() {
            assertThat(sut.get休止区分(), is(休止区分));
        }

        @Test
        public void 引数から渡された異動事由と_戻り値の介護医療機関クラスの異動事由が同一になる() {
            assertThat(sut.get異動事由(), is(異動事由));
        }

        @Test
        public void 引数から渡された会員区分と_戻り値の介護医療機関クラスの会員区分が同一になる() {
            assertThat(sut.get会員区分(), is(会員区分));
        }

        @Test
        public void 引数から渡された医療機関コードの点数表区分_戻り値の介護医療機関クラスの点数表が同一になる() {
            assertThat(sut.get点数表(), is(医療機関コード.get点数表区分()));
        }

        @Test
        public void 引数から渡された指定自立支援医療機関flagと_戻り値の介護医療機関クラスの指定自立支援医療機関flagが同一になる() {
            assertThat(sut.is指定自立支援医療機関(), is(指定自立支援医療機関flag));
        }

        @Test
        public void 引数から渡された市町村コードと_戻り値の介護医療機関クラスの市町村コードが同一になる() {
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 引数から渡された介護医療機関コードと_戻り値の介護医療機関クラスの介護医療機関コードが同一になる() {
            assertThat(sut.get介護医療機関コード(), is(介護医療機関コード));
        }

        @Test
        public void 引数から渡された医療機関状況と_戻り値の介護医療機関クラスの医療機関状況が同一になる() {
            assertThat(sut.is有効(), is(医療機関状況.is有効()));
        }

        @Test
        public void 引数から渡された医療機関区分と_戻り値の介護医療機関クラスの医療機関区分が同一になる() {
            assertThat(sut.get医療機関区分().getCode(), is(医療機関区分.getCode()));
        }

        private KaigoIryoKikanEntity create介護医療機関Entity() {
            KaigoIryoKikanEntity entity = new KaigoIryoKikanEntity();
            entity.setDbT7011ShujiiIryoKikanJohoEntity(KaigoIryoKikanTestHelper.create主治医医療機関Entity());
            entity.setIryoKikanEntity(KaigoIryoKikanTestHelper.create医療機関Entity());
            return entity;
        }
    }
}
