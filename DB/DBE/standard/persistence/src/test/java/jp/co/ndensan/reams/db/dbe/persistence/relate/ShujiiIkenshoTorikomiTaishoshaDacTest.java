/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.YokaigoNinteiShinseiTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteiShinchokuJohoDacMock;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteiShinseiJohoDacMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;

/**
 * 主治医意見書取込対象者Dacのテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoTorikomiTaishoshaDacTest extends DbeTestDacBase {

    private static ShujiiIkenshoTorikomiTaishoshaDac sut;
    private static NinteiShinchokuJohoDacMock ninteiShinchokuJohoDacMock;
    private static NinteiShinseiJohoDacMock ninteiShinseiJohoDacMock;
    private static FlexibleDate 未完了年月日 = new FlexibleDate("00000000");
    private static FlexibleDate 完了済年月日 = new FlexibleDate("20140101");
    private static RString 申請書管理番号0001 = new RString("0001");
    private static RString 申請書管理番号0002 = new RString("0002");
    private static ShoKisaiHokenshaNo 登録あり証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A00001"));
    private static ShoKisaiHokenshaNo 登録なし証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A00002"));
    private static RString 登録あり支所コード = new RString("0001");
    private static RString 登録なし支所コード = new RString("0002");

    enum IkenshoShinchoku {

        未依頼,
        意見書作成依頼済_登録未完了,
        意見書作成依頼済_登録完了済
    };

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShujiiIkenshoTorikomiTaishoshaDac.class);
        ninteiShinchokuJohoDacMock = InstanceProvider.create(NinteiShinchokuJohoDacMock.class);
        ninteiShinseiJohoDacMock = InstanceProvider.create(NinteiShinseiJohoDacMock.class);
    }

    public static class selectAll extends DbeTestDacBase {

        @Test
        public void selectAll_対象者がいない場合_対象者0件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録あり支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録完了済));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.selectAll().size(), is(0));
        }

        @Test
        public void selectAll_対象者が1人の場合_対象者1件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録あり支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.selectAll().size(), is(1));
        }
    }

    public static class select証記載保険者番号 extends DbeTestDacBase {

        @Test
        public void select証記載保険者番号_対象者がいない場合_対象者0件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録あり支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録完了済));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号(登録あり証記載保険者番号).size(), is(0));
        }

        @Test
        public void select証記載保険者番号_対象者が1人いて_証記載保険者番号に一致しない場合_対象者0件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録あり支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号(登録なし証記載保険者番号).size(), is(0));
        }

        @Test
        public void select証記載保険者番号_対象者が2人いて_証記載保険者番号に1人一致する場合_対象者1件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録なし証記載保険者番号, 登録なし支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号(登録あり証記載保険者番号).size(), is(1));
        }

        @Test
        public void select証記載保険者番号_対象者が2人いて_証記載保険者番号に2人一致する場合_対象者2件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録なし支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号(登録あり証記載保険者番号).size(), is(2));
        }
    }

    public static class select証記載保険者番号及び支所コード extends DbeTestDacBase {

        @Test
        public void select証記載保険者番号及び支所コード_対象者がいない場合_対象者0件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録あり支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録完了済));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号及び支所コード(登録あり証記載保険者番号, 登録あり支所コード).size(), is(0));
        }

        @Test
        public void select証記載保険者番号及び支所コード_対象者が1人いて_証記載保険者番号及び支所コードに一致しない場合_対象者0件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録あり支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号及び支所コード(登録なし証記載保険者番号, 登録なし支所コード).size(), is(0));
        }

        @Test
        public void select証記載保険者番号及び支所コード__対象者が2人いて_証記載保険者番号及び支所コードに1人一致する場合_対象者1件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録なし証記載保険者番号, 登録なし支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号及び支所コード(登録あり証記載保険者番号, 登録あり支所コード).size(), is(1));
        }

        @Test
        public void select証記載保険者番号及び支所コード__対象者が2人いて_証記載保険者番号及び支所コードに2人一致する場合_対象者2件の結果が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり証記載保険者番号, 登録あり支所コード));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり証記載保険者番号, 登録あり支所コード));
            assertThat(sut.select証記載保険者番号及び支所コード(登録あり証記載保険者番号, 登録あり支所コード).size(), is(2));
        }
    }

    private static DbT5005NinteiShinchokuJohoEntity create認定進捗情報Entity(RString 申請書管理番号, IkenshoShinchoku 調査進捗) {
        DbT5005NinteiShinchokuJohoEntity entity = NinteiShinchokuJohoEntityMock.create認定進捗情報Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        switch (調査進捗) {
            case 未依頼:
                entity.setIkenshoSakuseiIraiKanryoYMD(未完了年月日);
                entity.setIkenshoTorokuKanryoYMD(未完了年月日);
                break;
            case 意見書作成依頼済_登録未完了:
                entity.setIkenshoSakuseiIraiKanryoYMD(完了済年月日);
                entity.setIkenshoTorokuKanryoYMD(未完了年月日);
                break;
            case 意見書作成依頼済_登録完了済:
                entity.setIkenshoSakuseiIraiKanryoYMD(完了済年月日);
                entity.setIkenshoTorokuKanryoYMD(完了済年月日);
                break;
        }
        return entity;
    }

    private static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity(RString 申請書管理番号, ShoKisaiHokenshaNo 証記載保険者番号, RString 支所コード) {
        DbT5001NinteiShinseiJohoEntity entity = YokaigoNinteiShinseiTestHelper.create認定申請情報Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setShishoCode(new ShishoCode(支所コード));
        return entity;
    }
}
