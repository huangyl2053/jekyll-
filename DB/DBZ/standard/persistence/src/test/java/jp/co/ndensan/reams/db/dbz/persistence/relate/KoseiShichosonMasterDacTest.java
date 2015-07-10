/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
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
 * {@link KoseiShichosonMasterDac}のテストクラスです。
 *
 * @author n3331 山邉 大貴
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterDacTest {

    private static KoseiShichosonMasterDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KoseiShichosonMasterDac.class);
    }

    public static class selectByContainsKyuShichosonTest extends DbzTestDacBase {

        @Test
        public void 旧市町村を含まない条件を指定した場合_GappeiKyuShichosonKubunが1であるものを除いたリストを返す() {
            IItemList<KoseiShichosonMasterModel> modelList = sut.selectBy(ContainsKyuShichoson.旧市町村を含まない);
            assertThat(modelList.size(), is(3));
        }

        @Test
        public void 旧市町村を含む条件を指定した場合_全件リストを返す() {
            IItemList<KoseiShichosonMasterModel> modelList = sut.selectBy(ContainsKyuShichoson.旧市町村を含む);
            assertThat(modelList.size(), is(6));
        }
    }

    public static class selectByContainsKyuShichoson_ShichosonCodeTest extends DbzTestDacBase {

        @Test
        public void 市町村コードに合致し旧市町村を含まない条件を指定した場合_該当データを1件返す() {
            IItemList<KoseiShichosonMasterModel> modelList = sut.selectBy(new LasdecCode("223456"), ContainsKyuShichoson.旧市町村を含まない);
            assertThat(modelList.size(), is(1));
            assertThat(modelList.findFirst().get().get市町村名(), is(new RString("構成市町村1")));
        }

        @Test
        public void 市町村コードに合致し旧市町村を含む条件を指定した場合_該当データを1件返す() {
            IItemList<KoseiShichosonMasterModel> modelList = sut.selectBy(new LasdecCode("123458"), ContainsKyuShichoson.旧市町村を含む);
            assertThat(modelList.size(), is(1));
        }

        @Test
        public void 条件に合致するデータが存在しない場合_サイズ0のリストを返す() {
            IItemList<KoseiShichosonMasterModel> modelList = sut.selectBy(new LasdecCode("333333"), ContainsKyuShichoson.旧市町村を含む);
            assertThat(modelList.size(), is(0));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        @Test
        public void 広域構成市町村モデルを渡すと_updateは_広域構成市町村を更新する() {
            KoseiShichosonMasterModel model
                    = new KoseiShichosonMasterModel(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
            sut.insert(model);
            model.getEntity().initializeMd5();
            model.set市町村名称(new RString("テスト市"));
            assertThat(sut.update(model), is(1));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つ広域構成市町村モデルを渡した時_insertは_1を返す() {
            KoseiShichosonMasterModel model
                    = new KoseiShichosonMasterModel(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
            assertThat(sut.insert(model), is(1));
        }
    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つ広域構成市町村モデルを渡した時_deleteは_1を返す() {
            KoseiShichosonMasterModel model
                    = new KoseiShichosonMasterModel(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }
}
