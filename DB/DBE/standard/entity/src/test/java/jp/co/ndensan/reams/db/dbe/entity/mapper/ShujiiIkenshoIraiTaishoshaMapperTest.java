/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiTaishoshaMapperTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        private ShujiiIkenshoIraiTaishosha sut;
        private DbT5001NinteiShinseiJohoEntity 認定申請情報Entity;
        private IKojin 個人;
        private RString 氏名;
        private RString 住所;
        private KaigoIryoKikan 主治医医療機関;
        private IDoctor 主治医;

        @Override
        protected void setUp() {
            認定申請情報Entity = mock(DbT5001NinteiShinseiJohoEntity.class);
            個人 = mock(IKojin.class);
            氏名 = new RString("あああ");
            住所 = new RString("長野市");
            主治医医療機関 = mock(KaigoIryoKikan.class);
            主治医 = mock(IDoctor.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請情報Entityに_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請情報Entity = null;
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定申請情報Entity, 個人, 氏名, 住所, 主治医医療機関, 主治医);
        }
    }

    public static class toShujiiIkenshoIraiTaishoshaTest extends TestBase {

        private ShujiiIkenshoIraiTaishosha sut;
        private DbT5001NinteiShinseiJohoEntity 認定申請情報Entity;
        private IKojin 個人;
        private RString 氏名;
        private RString 住所;
        private KaigoIryoKikan 主治医医療機関;
        private IDoctor 主治医;

        @Override
        protected void setUp() {
            認定申請情報Entity = DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
            認定申請情報Entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("0001")));
            認定申請情報Entity.setShichosonCode(new ShichosonCode(new RString("1111")));
            認定申請情報Entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("0002")));
            認定申請情報Entity.setNinteiShinseiYMD(new NinteiShinseiDate(new FlexibleDate(new RString("20140101"))));
            認定申請情報Entity.setNinteiShinseiShinseijiKubunCode(new RString("0003"));
            個人 = mock(IKojin.class);
            氏名 = new RString("あああ");
            住所 = new RString("長野市");
            主治医医療機関 = mock(KaigoIryoKikan.class);
            主治医 = mock(IDoctor.class);
        }

        @Test
        public void 引き渡した_認定申請情報Entityの申請書管理番号_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定申請情報Entity, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get申請書管理番号(), is(認定申請情報Entity.getShinseishoKanriNo()));
        }

        @Test
        public void 引き渡した_認定申請情報Entityの市町村コード_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定申請情報Entity, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get市町村コード(), is(認定申請情報Entity.getShichosonCode()));
        }

        @Test
        public void 引き渡した_認定申請情報Entityの被保険者番号_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定申請情報Entity, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get被保険者番号(), is(認定申請情報Entity.getHihokenshaNo()));
        }

        @Test
        public void 引き渡した_認定申請情報Entityの認定申請年月日_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定申請情報Entity, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get認定申請年月日(), is(認定申請情報Entity.getNinteiShinseiYMD()));
        }

        @Test
        public void 引き渡した_認定申請情報Entityの認定申請区分_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定申請情報Entity, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get認定申請区分(), is(認定申請情報Entity.getNinteiShinseiShinseijiKubunCode()));
        }
    }
}
