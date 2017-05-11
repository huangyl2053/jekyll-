/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gensenchoshudatasakusei;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE631001.GensenChoshuMapperParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import org.junit.Test;

/**
 *
 * @author N3327 三浦 凌
 */
public class IGensenChoshuDataSakuseiRelateMapperTest extends DbeTestDacBase {

    public IGensenChoshuDataSakuseiRelateMapperTest() {
    }

    public static void setUpClass() {
        beforeSetUpClass();
    }

    @Test
    public void testSomeMethod() {
        IGensenChoshuDataSakuseiRelateMapper sut = this.sqlSession.getMapper(IGensenChoshuDataSakuseiRelateMapper.class);
        GensenChoshuMapperParameter p = GensenChoshuMapperParameter.createParamter(new RYear("2017"));
        System.out.println(sut.getデータ情報(p).size());
    }

}
