/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyotei.GogitaiIchiranJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai.GogitaiJohoShinsaRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 * {@link IGogitaiJohoShinsaMapper}のテストです。
 */
public class IGogitaiJohoShinsaMapperTest extends DbeTestDacBase {

    public IGogitaiJohoShinsaMapperTest() {
    }

    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    @Test
    public void testGet合議体情報() {
        IGogitaiJohoShinsaMapper sut = this.sqlSession.getMapper(IGogitaiJohoShinsaMapper.class);
        GogitaiIchiranJohoMapperParameter param = GogitaiIchiranJohoMapperParameter.createGogitaiJoho(new RString("20170301"), new RString("20170331"), RString.EMPTY);
        List<GogitaiJohoShinsaRelateEntity> entities = sut.get合議体情報(param);
        if (entities == null) {
            return;
        }
        GogitaiJohoShinsaRelateEntity e = entities.get(0);
        System.out.println(e.get年度内開催回数());
    }

}
