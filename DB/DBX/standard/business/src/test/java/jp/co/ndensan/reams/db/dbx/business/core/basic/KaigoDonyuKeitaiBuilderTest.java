/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7908KaigoDonyuKeitaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoDonyuKeitaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoDonyuKeitaiBuilderTest extends DbxTestBase {

    private static DbT7908KaigoDonyuKeitaiEntity KaigoDonyuKeitaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static Code 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_業務分類;
        主キー名2 = DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_導入形態コード;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoDonyuKeitaiBuilder sut;
        private static KaigoDonyuKeitai business;

        @Before
        public void setUp() {
            KaigoDonyuKeitaiEntity = new DbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitaiEntity.setGyomuBunrui(主キー名1);
            KaigoDonyuKeitaiEntity.setDonyuKeitaiCode(主キー名2);

            business = new KaigoDonyuKeitai(KaigoDonyuKeitaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の業務分類は_設定した値と同じ業務分類を返す() {
            GyomuBunrui gyomuBunrui = GyomuBunrui.toValue(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_業務分類);
            business = sut.set業務分類(gyomuBunrui).build();
            assertThat(business.get業務分類(), is(gyomuBunrui));
        }

        @Test
        public void 戻り値の導入形態コードは_設定した値と同じ導入形態コードを返す() {
            DonyuKeitaiCode donyuKeitaiCode = DonyuKeitaiCode.toValue(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_導入形態コード.value());
            business = sut.set導入形態(donyuKeitaiCode).build();
            assertThat(business.get導入形態コード(), is(donyuKeitaiCode));
        }

        @Test
        public void 戻り値の支所管理有無フラグは_設定した値と同じ支所管理有無フラグを返す() {
            business = sut.set支所管理有無(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_支所管理有無フラグ).build();
            assertThat(business.exists支所管理(), is(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_支所管理有無フラグ));
        }

    }
}
