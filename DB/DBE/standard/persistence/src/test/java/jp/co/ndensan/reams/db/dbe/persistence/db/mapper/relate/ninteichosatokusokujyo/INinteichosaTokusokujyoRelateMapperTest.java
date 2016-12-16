/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujyo.NinteiChosaTokusokujoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * {@link INinteichosaTokusokujyoRelateMapper}のテストクラスです。
 */
@Ignore
public class INinteichosaTokusokujyoRelateMapperTest extends DbeTestDacBase {

    private static INinteichosaTokusokujyoRelateMapper sut;

    @Before
    public void setUp() {
        sut = sqlSession.getMapper(INinteichosaTokusokujyoRelateMapper.class);
    }

    @Test
    public void 要介護認定調査督促状データ取得SQLにエラーがないこと() {
        NinteiChosaTokusokujoMybatisParameter param = new NinteiChosaTokusokujoMybatisParameter(
                FlexibleDate.getNowDate(),
                new Decimal(100),
                new RString("1"),
                new RString("1"),
                new RString("1"),
                new RString("1"),
                new LasdecCode("209007"));
        sut.select要介護認定調査督促状ByKey(param);
    }
}
