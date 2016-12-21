/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.ShinsaTaishoDataOutPutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.KihonChosaKomokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * IShinsaTaishoDataOutPutMapperのテストクラスです
 */
public class IShinsaTaishoDataOutPutMapperTest extends DbeTestDacBase {

    private IShinsaTaishoDataOutPutMapper sut;

    @Before
    public void setUp() {
        sut = sqlSession.getMapper(IShinsaTaishoDataOutPutMapper.class);
    }

    @Test
    public void get介護認定審査会情報_動作確認のみ() {
        ShinsaTaishoDataOutPutMybatisParameter parameter = new ShinsaTaishoDataOutPutMybatisParameter(new RString("20160075"));

        List<ShinsakaiJohoRelateEntity> entity = sut.get介護認定審査会情報(parameter);
        assertThat(entity, is(notNullValue()));
    }

    @Test
    public void get介護認定審査会委員情報_動作確認のみ() {
        ShinsaTaishoDataOutPutMybatisParameter parameter = new ShinsaTaishoDataOutPutMybatisParameter(new RString("20160075"));

        List<ShinsakaiIinJohoRelateEntity> entity = sut.get介護認定審査会委員情報(parameter);
        assertThat(entity, is(notNullValue()));
    }

    @Test
    public void get基本調査項目データ_動作確認のみ() {
        ShinsaTaishoDataOutPutMybatisParameter parameter = new ShinsaTaishoDataOutPutMybatisParameter(
                new RString("20160075"), KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード());

        List<KihonChosaKomokuDataRelateEntity> entity = sut.get基本調査項目データ(parameter);
        assertThat(entity, is(notNullValue()));
    }

    @Test
    public void get概況調査データ_動作確認のみ() {
        ShinsaTaishoDataOutPutMybatisParameter parameter = new ShinsaTaishoDataOutPutMybatisParameter(new RString("20160075"));

        List<GaikyoChosaDataRelateEntity> entity = sut.get概況調査データ(parameter);
        assertThat(entity, is(notNullValue()));
    }

}
