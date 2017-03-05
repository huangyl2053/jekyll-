/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosaimaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.SonotaKikanMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster.SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@link ISonotaKikanMasterMapper}のテストです。
 */
public class ISonotaKikanMasterMapperTest extends DbeTestDacBase {

    public ISonotaKikanMasterMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    @Test
    public void testSelectSonotaKikanichiranList() {
        SonotaKikanMasterMapperParameter param = SonotaKikanMasterMapperParameter.createSelectByKeyParam(false,
                /* 保険者番号 */ ShoKisaiHokenshaNo.EMPTY,
                /* 機関コードFrom */ RString.EMPTY,
                /* 機関コードTo */ RString.EMPTY,
                /* 機関名称 */ RString.EMPTY,
                /* 機関カナ名称 */ RString.EMPTY,
                /* 調査委託区分 */ RString.EMPTY,
                /* 機関の区分 */ RString.EMPTY,
                /* 最大表示件数 */ new Decimal("100"),
                /* ddlKikanMeishoKey */ new RString("2"),
                /* ddlKikanKanaMeishoKey */ new RString("2")
        );
        ISonotaKikanMasterMapper sut = this.sqlSession.getMapper(ISonotaKikanMasterMapper.class);
        List<SonotaKikanJohoEntity> list = sut.selectSonotaKikanichiranList(param);
        System.out.println(list.size());
    }

}
