/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link KoseiShichosonMasterManager}のテストクラスです。
 *
 * @author n3331 山邉 大貴
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterManagerTest {

    private static KoseiShichosonMasterDac dac;
    private static KoseiShichosonMasterManager sut;

    @BeforeClass
    public static void test() {
        dac = InstanceProvider.create(KoseiShichosonMasterDac.class);
        sut = new KoseiShichosonMasterManager(dac);
    }

    public static class load広域構成市町村Test extends DbzTestDacBase {

        @Test
        public void 旧市町村を含まない条件を指定した場合_GappeiKyuShichosonKubunが1であるものを除いたリストを返す() {
            IItemList<KoseiShichosonMasterModel> modelList = sut.load広域構成市町村(ContainsKyuShichoson.旧市町村を含まない);
            assertThat(modelList.size(), is(3));
        }

        @Test
        public void 旧市町村を含む条件を指定した場合_全件リストを返す() {
            IItemList<KoseiShichosonMasterModel> modelList = sut.load広域構成市町村(ContainsKyuShichoson.旧市町村を含む);
            assertThat(modelList.size(), is(6));
        }
    }

    public static class find構成市町村Test extends DbzTestDacBase {

        @Test
        public void 市町村コードに合致し旧市町村を含まない条件を指定した場合_該当データを返す() {
            IOptional<KoseiShichosonMasterModel> modelList = sut.find構成市町村(new LasdecCode("223456"), ContainsKyuShichoson.旧市町村を含まない);
            assertThat(modelList.get().get市町村名(), is(new RString("構成市町村1")));
        }

        @Test
        public void 市町村コードに合致し旧市町村を含む条件を指定した場合_該当データを1件返す() {
            IOptional<KoseiShichosonMasterModel> modelList = sut.find構成市町村(new LasdecCode("123458"), ContainsKyuShichoson.旧市町村を含む);
            assertThat(modelList.get().get市町村名(), is(new RString("旧市町村3")));
        }

        @Test
        public void 条件に合致するデータが存在しない場合_該当データを1件返す() {
            IOptional<KoseiShichosonMasterModel> modelList = sut.find構成市町村(new LasdecCode("333333"), ContainsKyuShichoson.旧市町村を含む);
            assertThat(modelList.isPresent(), is(false));
        }
    }

}
