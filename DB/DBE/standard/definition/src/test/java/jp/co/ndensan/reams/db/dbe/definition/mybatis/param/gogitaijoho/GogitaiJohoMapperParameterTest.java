///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho;
//
//import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//
///**
// * {@link GogitaiJohoMapperParameter}のテストクラスです。
// */
//@RunWith(Enclosed.class)
//public class GogitaiJohoMapperParameterTest extends DbeTestBase {
//
//    private static int gogitaiNo = 1;
//    private static FlexibleDate gogitaiYukoKikanKaishiYMD = new FlexibleDate(new RString("20151030"));
//    private static RString shinsakaiKaisaiBashoCode = new RString("20151030001");
//
//    public static class createSelectByKeyParamテスト extends DbeTestBase {
//
////        @Test(expected = NullPointerException.class)
////        public void gogitaiNoにNullを指定すると_NullPointerExceptionが発生する() {
////            GogitaiJohoMapperParameter sut = GogitaiJohoMapperParameter.createSelectByKeyParam(0, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
////        }
//        @Test(expected = NullPointerException.class)
//        public void gogitaiYukoKikanKaishiYMDにNullを指定すると_NullPointerExceptionが発生する() {
//            GogitaiJohoMapperParameter sut = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, null, shinsakaiKaisaiBashoCode);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void shinsakaiKaisaiBashoCodeにNullを指定すると_NullPointerExceptionが発生する() {
//            GogitaiJohoMapperParameter sut = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, null);
//        }
//
//        @Test
//        public void 引数にNull以外を指定すると_パラメータが生成できる() {
//            GogitaiJohoMapperParameter sut = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
//
//            assertThat(sut.getGogitaiNo(), is(gogitaiNo));
//            assertThat(sut.getGogitaiYukoKikanKaishiYMD(), is(gogitaiYukoKikanKaishiYMD));
//            assertThat(sut.getShinsakaiKaisaiBashoCode(), is(shinsakaiKaisaiBashoCode));
//
//        }
//    }
//
//}
