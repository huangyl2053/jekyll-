/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.ShujiiIryoKikanMapper;
import jp.co.ndensan.reams.db.dbe.business.IShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.helper.KaigoIryoKikanTestHelper;
//import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
//import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
//import jp.co.ndensan.reams.ur.urz.definition.valueobject.IryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 主治医医療機関マッパーのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIryoKikanMapperTest extends TestBase {
//
//    private static final LasdecCode 市町村コード_000123 = new LasdecCode(new RString("000123"));
//    private static final KaigoIryoKikanCode 介護医療機関コード_B001 = new KaigoIryoKikanCode(new RString("B001"));
//    private static final IryokikanCode 医療機関コード_C00000001 = new IryokikanCode(new RString("C00000001"));
//    private static final IryoKikanJokyo 医療機関状況_有効 = IryoKikanJokyo.有効;
//    private static final IryoKikanKubun 医療機関区分_100 = new IryoKikanKubun(new RString("100"), new RString("名称"), new RString("略称"));
//
//    public static class toShujiiIryoKikanのテスト extends TestBase {
//
//        private IShujiiIryoKikan result;
//
//        @Override
//        public void setUp() {
//            setDummyControlData("DBE");
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikan(KaigoIryoKikanTestHelper.create主治医医療機関Entity());
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikan(null);
//        }
//
//        @Test
//        public void 市町村コードが000123の主治医医療機関エンティティを渡すと_市町村コードが000123の主治医医療機関クラスが作成される() {
//            assertThat(result.get市町村コード(), is(市町村コード_000123));
//        }
//
//        @Test
//        public void 介護医療機関コードがB001の主治医医療機関エンティティを渡すと_介護医療機関コードがB001の主治医医療機関クラスが作成される() {
//            assertThat(result.get介護医療機関コード(), is(介護医療機関コード_B001));
//        }
//
//        @Test
//        public void 医療機関コードがC001の主治医医療機関エンティティを渡すと_医療機関コードがC001の主治医医療機関クラスが作成される() {
//            assertThat(result.get医療機関コード(), is(医療機関コード_C00000001));
//        }
//
//        @Test
//        public void 医療機関状況が有効の主治医医療機関エンティティを渡すと_医療機関状況が有効の主治医医療機関クラスが作成される() {
//            assertThat(result.is有効(), is(医療機関状況_有効.is有効()));
//        }
//
//        @Test
//        public void 医療機関区分コードがABCの主治医医療機関エンティティを渡すと_医療機関区分コードがABCの主治医医療機関クラスが作成される() {
//            assertThat(result.get医療機関区分().getCode(), is(医療機関区分_100.getCode()));
//        }
//    }
//
//    public static class toShujiiIryoKikanEntityのテスト extends TestBase {
//
//        private DbT7011ShujiiIryoKikanJohoEntity result;
//
//        @Override
//        public void setUp() {
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(create主治医医療機関());
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(null);
//        }
//
//        @Test
//        public void 市町村コードが000123の主治医医療機関クラスを渡すと_市町村コードが000123の主治医医療機関エンティティが作成される() {
//            assertThat(result.getShichosonCode(), is(市町村コード_000123));
//        }
//
//        @Test
//        public void 介護医療機関コードがB001の主治医医療機関クラスを渡すと_介護医療機関コードがB001の主治医医療機関エンティティが作成される() {
//            assertThat(result.getKaigoIryokikanCode(), is(介護医療機関コード_B001));
//        }
//
//        @Test
//        public void 医療機関コードがC001の主治医医療機関クラスを渡すと_医療機関コードがC001の主治医医療機関エンティティが作成される() {
//            assertThat(result.getIryokikanCode(), is(医療機関コード_C00000001.value()));
//        }
//
//        @Test
//        public void 医療機関状況が有効の主治医医療機関クラスを渡すと_医療機関状況が有効の主治医医療機関エンティティが作成される() {
//            assertThat(result.getIryokikanJokyo(), is(医療機関状況_有効.is有効()));
//        }
//
//        @Test
//        public void 医療機関区分コードがABCの主治医医療機関クラスを渡すと_医療機関区分コードがABCの主治医医療機関エンティティが作成される() {
//            assertThat(result.getKikanKubunCode(), is(医療機関区分_100.getCode()));
//        }
//    }
//
//    public static class toShujiiIryoKikanEntityAnd状況変更のテスト extends TestBase {
//
//        private DbT7011ShujiiIryoKikanJohoEntity result;
//
//        @Test(expected = NullPointerException.class)
//        public void 主治医医療機関にnullが渡されたとき_NullPointerExceptionが発生する() {
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(null, IryoKikanJokyo.有効);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 医療機関状況にnullが渡されたとき_NullPointerExceptionが発生する() {
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(create主治医医療機関(), null);
//        }
//
//        @Test
//        public void 医療機関状況に有効を指定したとき_医療機関状況が有効になっている主治医医療機関エンティティが返る() {
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(create主治医医療機関(), IryoKikanJokyo.有効);
//            assertThat(result.getIryokikanJokyo(), is(IryoKikanJokyo.有効.is有効()));
//        }
//
//        @Test
//        public void 医療機関状況に無効を指定したとき_医療機関状況が無効になっている主治医医療機関エンティティが返る() {
//            result = ShujiiIryoKikanMapper.toShujiiIryoKikanEntity(create主治医医療機関(), IryoKikanJokyo.無効);
//            assertThat(result.getIryokikanJokyo(), is(IryoKikanJokyo.無効.is有効()));
//        }
//    }
//
//    private static IShujiiIryoKikan create主治医医療機関() {
//        return new ShujiiIryoKikan(市町村コード_000123, 介護医療機関コード_B001, 医療機関コード_C00000001, 医療機関状況_有効, 医療機関区分_100);
//    }
}
