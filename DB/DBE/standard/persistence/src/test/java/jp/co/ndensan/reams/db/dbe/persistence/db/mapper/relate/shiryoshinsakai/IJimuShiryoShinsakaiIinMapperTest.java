/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 * {@link  IJimuShiryoShinsakaiIinMapper} のテストです。
 */
public class IJimuShiryoShinsakaiIinMapperTest extends DbeTestDacBase {

    public IJimuShiryoShinsakaiIinMapperTest() {
    }

    @Test
    public void testSomeMethod() {
        IJimuShiryoShinsakaiIinMapper sut = sqlSession.getMapper(IJimuShiryoShinsakaiIinMapper.class);
        JimuShinsakaiIinJohoMyBatisParameter param = new JimuShinsakaiIinJohoMyBatisParameter(
                0,
                0,
                RString.EMPTY, false,
                /* isSakuseiJokenHani */ false,
                /* isSakuseiJokenTuika */ false,
                /*shinsakaiKaisaiNo*/ new RString("20160333"),
                /*合議体番号*/ 32,
                new FlexibleDate("20170326"),
                /*isGogitaiDummyFlag*/ false);
        param.setOrderKakuteiFlg(true);
        param.setShoriJotaiKubun0(new RString("0"));
        param.setShoriJotaiKubun3(new RString("3"));
        System.out.println("テスト");
        for (ShinsakaiSiryoKyotsuEntity e : sut.get共通情報(param)) {
            System.out.println(e.getMaskedTokki());
        }
    }

}
