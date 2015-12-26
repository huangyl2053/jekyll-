/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.shikakujiyu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.shikakujiyushutoku.ShikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * {@link jp.co.ndensan.reams.db.dbu.business.core.shikakuJiyuShutoku}のテストです。
 */
@RunWith(Enclosed.class)
public class SikakuJiyuShutokuManagerTest extends DbuTestBase {

    @RunWith(PowerMockRunner.class)
    public static class methodTest extends DbuTestBase {

        @BeforeClass
        public static void test() {

        }

        private List<ShikakuJiyuShutoku> コード種別が_0126以外の場合() {
            UzT0007CodeEntity uzT0007CodeEntity1 = new UzT0007CodeEntity();
            uzT0007CodeEntity1.setコード(new Code("01"));
            uzT0007CodeEntity1.setコード略称(new RString("コード１"));

            List<UzT0007CodeEntity> codeMasterlist = new ArrayList<>();
            codeMasterlist.add(uzT0007CodeEntity1);

            PowerMockito.mockStatic(CodeMaster.class);
            PowerMockito.when(CodeMaster.getCode(new CodeShubetsu("0127"), new FlexibleDate(new RString("20150101")))).
                    thenReturn(codeMasterlist);
            SikakuJiyuShutokuManager sikakuJiyuShutokuManager = new SikakuJiyuShutokuManager();
            List<ShikakuJiyuShutoku> result = sikakuJiyuShutokuManager.shikakuJiyuShutoku(
                    new CodeShubetsu("0127"), new FlexibleDate(new RString("20150101")),
                    DonyukeitaiCode.事務構成市町村.getCode(), new RString("0"));
            return result;
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126以外の場合_オブジェクトShikakuJiyuShutokuのListのコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126以外の場合();
            assertThat(result.get(0).getCode(), is(new Code("01")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126以外の場合_オブジェクトShikakuJiyuShutokuのListの略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126以外の場合();
            assertThat(result.get(0).getCodeRyakusho(), is(new RString("コード１")));
        }

        private List<ShikakuJiyuShutoku> コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併なしの場合() {
            UzT0007CodeEntity uzT0007CodeEntity1 = new UzT0007CodeEntity();
            uzT0007CodeEntity1.setコード(new Code("01"));
            uzT0007CodeEntity1.setコード略称(new RString("コード１"));
            uzT0007CodeEntity1.setオプション１(new RString("1"));
            UzT0007CodeEntity uzT0007CodeEntity2 = new UzT0007CodeEntity();
            uzT0007CodeEntity2.setコード(new Code("02"));
            uzT0007CodeEntity2.setコード略称(new RString("コード２"));
            uzT0007CodeEntity2.setオプション１(new RString("2"));

            List<UzT0007CodeEntity> codeMasterlist = new ArrayList<>();
            codeMasterlist.add(uzT0007CodeEntity1);
            codeMasterlist.add(uzT0007CodeEntity2);

            PowerMockito.mockStatic(CodeMaster.class);
            PowerMockito.when(CodeMaster.getCode(new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")))).
                    thenReturn(codeMasterlist);
            SikakuJiyuShutokuManager sikakuJiyuShutokuManager = new SikakuJiyuShutokuManager();
            List<ShikakuJiyuShutoku> result = sikakuJiyuShutokuManager.shikakuJiyuShutoku(
                    new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")),
                    DonyukeitaiCode.事務構成市町村.getCode(), new RString("0"));
            return result;
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併なしの場合_オプション１が1のデータのコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併なしの場合();
            assertThat(result.get(0).getCode(), is(new Code("01")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併なしの場合_オプション１が1のデータの略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併なしの場合();
            assertThat(result.get(0).getCodeRyakusho(), is(new RString("コード１")));
        }

        private List<ShikakuJiyuShutoku> コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併なしの場合() {
            UzT0007CodeEntity uzT0007CodeEntity1 = new UzT0007CodeEntity();
            uzT0007CodeEntity1.setコード(new Code("01"));
            uzT0007CodeEntity1.setコード略称(new RString("コード１"));
            uzT0007CodeEntity1.setオプション２(new RString("1"));
            UzT0007CodeEntity uzT0007CodeEntity2 = new UzT0007CodeEntity();
            uzT0007CodeEntity2.setコード(new Code("02"));
            uzT0007CodeEntity2.setコード略称(new RString("コード２"));
            uzT0007CodeEntity2.setオプション２(new RString("2"));

            List<UzT0007CodeEntity> codeMasterlist = new ArrayList<>();
            codeMasterlist.add(uzT0007CodeEntity1);
            codeMasterlist.add(uzT0007CodeEntity2);

            PowerMockito.mockStatic(CodeMaster.class);
            PowerMockito.when(CodeMaster.getCode(new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")))).
                    thenReturn(codeMasterlist);
            SikakuJiyuShutokuManager sikakuJiyuShutokuManager = new SikakuJiyuShutokuManager();
            List<ShikakuJiyuShutoku> result = sikakuJiyuShutokuManager.shikakuJiyuShutoku(
                    new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")),
                    DonyukeitaiCode.事務広域.getCode(), new RString("0"));
            return result;
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併なしの場合_オプション２が1のデータのコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併なしの場合();
            assertThat(result.get(0).getCode(), is(new Code("01")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併なしの場合_オプション２が1のデータの略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併なしの場合();
            assertThat(result.get(0).getCodeRyakusho(), is(new RString("コード１")));
        }

        private List<ShikakuJiyuShutoku> コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合() {
            UzT0007CodeEntity uzT0007CodeEntity1 = new UzT0007CodeEntity();
            uzT0007CodeEntity1.setコード(new Code("01"));
            uzT0007CodeEntity1.setコード略称(new RString("コード１"));
            uzT0007CodeEntity1.setオプション１(new RString("1"));
            uzT0007CodeEntity1.setオプション３(new RString("2"));
            UzT0007CodeEntity uzT0007CodeEntity2 = new UzT0007CodeEntity();
            uzT0007CodeEntity2.setコード(new Code("02"));
            uzT0007CodeEntity2.setコード略称(new RString("コード２"));
            uzT0007CodeEntity2.setオプション１(new RString("2"));
            uzT0007CodeEntity2.setオプション３(new RString("1"));
            UzT0007CodeEntity uzT0007CodeEntity3 = new UzT0007CodeEntity();
            uzT0007CodeEntity3.setコード(new Code("03"));
            uzT0007CodeEntity3.setコード略称(new RString("コード３"));
            uzT0007CodeEntity3.setオプション１(new RString("1"));
            uzT0007CodeEntity3.setオプション３(new RString("1"));
            UzT0007CodeEntity uzT0007CodeEntity4 = new UzT0007CodeEntity();
            uzT0007CodeEntity4.setコード(new Code("02"));
            uzT0007CodeEntity4.setコード略称(new RString("コード４"));
            uzT0007CodeEntity4.setオプション１(new RString("2"));
            uzT0007CodeEntity4.setオプション３(new RString("2"));

            List<UzT0007CodeEntity> codeMasterlist = new ArrayList<>();
            codeMasterlist.add(uzT0007CodeEntity1);
            codeMasterlist.add(uzT0007CodeEntity2);
            codeMasterlist.add(uzT0007CodeEntity3);
            codeMasterlist.add(uzT0007CodeEntity4);

            PowerMockito.mockStatic(CodeMaster.class);
            PowerMockito.when(CodeMaster.getCode(new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")))).
                    thenReturn(codeMasterlist);
            SikakuJiyuShutokuManager sikakuJiyuShutokuManager = new SikakuJiyuShutokuManager();
            List<ShikakuJiyuShutoku> result = sikakuJiyuShutokuManager.shikakuJiyuShutoku(
                    new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")),
                    DonyukeitaiCode.事務構成市町村.getCode(), new RString("1"));
            return result;
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合_オプション１と３が1のデータ1のコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合();
            assertThat(result.get(0).getCode(), is(new Code("01")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合_オプション１と３が1のデータ2のコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合();

            assertThat(result.get(1).getCode(), is(new Code("02")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合_オプション１と３が1のデータ3のコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合();

            assertThat(result.get(2).getCode(), is(new Code("03")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション１と３が1のデータ1の略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合();

            assertThat(result.get(0).getCodeRyakusho(), is(new RString("コード１")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション１と３が1のデータ2の略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合();

            assertThat(result.get(1).getCodeRyakusho(), is(new RString("コード２")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション１と３が1のデータ3の略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_112又は_120且つ合併情報区分が合併ありの場合();

            assertThat(result.get(2).getCodeRyakusho(), is(new RString("コード３")));
        }

        private List<ShikakuJiyuShutoku> コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合() {
            UzT0007CodeEntity uzT0007CodeEntity1 = new UzT0007CodeEntity();
            uzT0007CodeEntity1.setコード(new Code("01"));
            uzT0007CodeEntity1.setコード略称(new RString("コード１"));
            uzT0007CodeEntity1.setオプション２(new RString("1"));
            uzT0007CodeEntity1.setオプション３(new RString("2"));
            UzT0007CodeEntity uzT0007CodeEntity2 = new UzT0007CodeEntity();
            uzT0007CodeEntity2.setコード(new Code("02"));
            uzT0007CodeEntity2.setコード略称(new RString("コード２"));
            uzT0007CodeEntity2.setオプション２(new RString("2"));
            uzT0007CodeEntity2.setオプション３(new RString("1"));
            UzT0007CodeEntity uzT0007CodeEntity3 = new UzT0007CodeEntity();
            uzT0007CodeEntity3.setコード(new Code("03"));
            uzT0007CodeEntity3.setコード略称(new RString("コード３"));
            uzT0007CodeEntity3.setオプション２(new RString("1"));
            uzT0007CodeEntity3.setオプション３(new RString("1"));
            UzT0007CodeEntity uzT0007CodeEntity4 = new UzT0007CodeEntity();
            uzT0007CodeEntity4.setコード(new Code("04"));
            uzT0007CodeEntity4.setコード略称(new RString("コード４"));
            uzT0007CodeEntity4.setオプション２(new RString("2"));
            uzT0007CodeEntity4.setオプション３(new RString("2"));

            List<UzT0007CodeEntity> codeMasterlist = new ArrayList<>();
            codeMasterlist.add(uzT0007CodeEntity1);
            codeMasterlist.add(uzT0007CodeEntity2);
            codeMasterlist.add(uzT0007CodeEntity3);
            codeMasterlist.add(uzT0007CodeEntity4);

            PowerMockito.mockStatic(CodeMaster.class);
            PowerMockito.when(CodeMaster.getCode(new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")))).
                    thenReturn(codeMasterlist);
            SikakuJiyuShutokuManager sikakuJiyuShutokuManager = new SikakuJiyuShutokuManager();
            List<ShikakuJiyuShutoku> result = sikakuJiyuShutokuManager.shikakuJiyuShutoku(
                    new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")),
                    DonyukeitaiCode.事務広域.getCode(), new RString("1"));
            return result;
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション２と３が1のデータ1のコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合();
            assertThat(result.get(0).getCode(), is(new Code("01")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション２と３が1のデータ2のコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合();
            assertThat(result.get(1).getCode(), is(new Code("02")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション２と３が1のデータ3のコードを戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合();
            assertThat(result.get(2).getCode(), is(new Code("03")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション２と３が1のデータ1の略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合();
            assertThat(result.get(0).getCodeRyakusho(), is(new RString("コード１")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション２と３が1のデータ2の略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合();
            assertThat(result.get(1).getCodeRyakusho(), is(new RString("コード２")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合_オプション２と３が1のデータ3の略称を戻る() {

            List<ShikakuJiyuShutoku> result = コード種別が_0126且つ導入形態コードは_111且つ合併情報区分が合併ありの場合();
            assertThat(result.get(2).getCodeRyakusho(), is(new RString("コード３")));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0126且つ導入形態コードは空の値の場合_空の値を戻る() {

            List<UzT0007CodeEntity> codeMasterlist = new ArrayList<>();

            PowerMockito.mockStatic(CodeMaster.class);
            PowerMockito.when(CodeMaster.getCode(new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")))).
                    thenReturn(codeMasterlist);
            SikakuJiyuShutokuManager sikakuJiyuShutokuManager = new SikakuJiyuShutokuManager();
            List<ShikakuJiyuShutoku> result = sikakuJiyuShutokuManager.shikakuJiyuShutoku(
                    new CodeShubetsu("0126"), new FlexibleDate(new RString("20150101")),
                    DonyukeitaiCode.事務構成市町村.getCode(), new RString("0"));

            assertThat(result.size(), is(0));
        }

        @Test
        @PrepareForTest({SikakuJiyuShutokuManager.class, CodeMaster.class})
        public void コード種別が_0127且つ導入形態コードは空の値の場合_空の値を戻る() {

            List<UzT0007CodeEntity> codeMasterlist = new ArrayList<>();

            PowerMockito.mockStatic(CodeMaster.class);
            PowerMockito.when(CodeMaster.getCode(new CodeShubetsu("0127"), new FlexibleDate(new RString("20150101")))).
                    thenReturn(codeMasterlist);
            SikakuJiyuShutokuManager sikakuJiyuShutokuManager = new SikakuJiyuShutokuManager();
            List<ShikakuJiyuShutoku> result = sikakuJiyuShutokuManager.shikakuJiyuShutoku(
                    new CodeShubetsu("0127"), new FlexibleDate(new RString("20150101")),
                    DonyukeitaiCode.事務構成市町村.getCode(), new RString("0"));

            assertThat(result.size(), is(0));

        }
    }
}
