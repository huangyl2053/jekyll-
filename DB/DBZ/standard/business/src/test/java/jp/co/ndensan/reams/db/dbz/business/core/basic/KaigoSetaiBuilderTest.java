/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoSetaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoSetaiBuilderTest extends DbzTestBase {

    private static DbT7014KaigoSetaiEntity KaigoSetaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 管理識別区分;
    private static FlexibleDate 世帯把握基準年月日;
    private static int 世帯員管理連番;
    private static ShikibetsuCode 世帯員識別コード;
    private static RString 本人区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号;
        管理識別区分 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_管理識別区分;
        世帯把握基準年月日 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯把握基準年月日;
        世帯員管理連番 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員管理連番;
        世帯員識別コード = DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード;
        本人区分 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_本人区分;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoSetaiBuilder sut;
        private static KaigoSetai business;

        @Before
        public void setUp() {
            KaigoSetaiEntity = new DbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setHihokenshaNo(被保険者番号);
            KaigoSetaiEntity.setKanriShikibetsuKubun(管理識別区分);
            KaigoSetaiEntity.setSetaiHaakuKijunYMD(世帯把握基準年月日);
            KaigoSetaiEntity.setSetaiInkanriRenban(世帯員管理連番);
            KaigoSetaiEntity.setSetaiInshikibetsuCode(世帯員識別コード);
            KaigoSetaiEntity.setHonninKubun(本人区分);

            business = new KaigoSetai(KaigoSetaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の管理識別区分は_設定した値と同じ管理識別区分を返す() {
            business = sut.set管理識別区分(DbT7014KaigoSetaiEntityGenerator.DEFAULT_管理識別区分).build();
            assertThat(business.get管理識別区分(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_管理識別区分));
        }

        @Test
        public void 戻り値の世帯把握基準年月日は_設定した値と同じ世帯把握基準年月日を返す() {
            business = sut.set世帯把握基準年月日(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯把握基準年月日).build();
            assertThat(business.get世帯把握基準年月日(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯把握基準年月日));
        }

        @Test
        public void 戻り値の世帯員管理連番は_設定した値と同じ世帯員管理連番を返す() {
            business = sut.set世帯員管理連番(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員管理連番).build();
            assertThat(business.get世帯員管理連番(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員管理連番));
        }

        @Test
        public void 戻り値の世帯員識別コードは_設定した値と同じ世帯員識別コードを返す() {
            business = sut.set世帯員識別コード(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード).build();
            assertThat(business.get世帯員識別コード(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード));
        }

        @Test
        public void 戻り値の本人区分は_設定した値と同じ本人区分を返す() {
            business = sut.set本人区分(DbT7014KaigoSetaiEntityGenerator.DEFAULT_本人区分).build();
            assertThat(business.get本人区分(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_本人区分));
        }

    }
}
