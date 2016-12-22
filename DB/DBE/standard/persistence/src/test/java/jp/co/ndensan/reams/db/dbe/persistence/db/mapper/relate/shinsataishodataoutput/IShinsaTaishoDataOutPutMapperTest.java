/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.GaikyoChosaDataMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.ShinsaTaishoDataOutPutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaData5207_08_09_10RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataZenkaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.KihonChosaKomokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
        ShinsaTaishoDataOutPutMybatisParameter parameter = new ShinsaTaishoDataOutPutMybatisParameter(new RString("20160075"));

        List<KihonChosaKomokuDataRelateEntity> entity = sut.get基本調査項目データ(parameter);
        assertThat(entity, is(notNullValue()));
    }

    @Test
    public void get概況調査データ_動作確認のみ() {
        ShinsaTaishoDataOutPutMybatisParameter parameter = new ShinsaTaishoDataOutPutMybatisParameter(new RString("20160075"));

        List<GaikyoChosaDataRelateEntity> entity = sut.get概況調査データ(parameter);
        assertThat(entity, is(notNullValue()));
    }

    @Test
    public void get概況調査データサービスの状況等_動作確認のみ() {
        GaikyoChosaDataMybatisParameter parameter = GaikyoChosaDataMybatisParameter.createParamter(
                new RString("20211920160800133"),
                Decimal.ONE);

        GaikyoChosaData5207_08_09_10RelateEntity entity = sut.get概況調査データサービスの状況等(parameter);
        assertThat(entity, is(notNullValue()));
    }

    @Test
    public void get概況調査データ前回情報_動作確認のみ() {
        GaikyoChosaDataMybatisParameter parameter = GaikyoChosaDataMybatisParameter.createParamter(
                new RString("20211920160800133"));

        GaikyoChosaDataZenkaiJohoRelateEntity entity = sut.get概況調査データ前回情報(parameter);
        assertThat(entity, is(notNullValue()));
    }

    @Test
    public void get要介護認定主治医意見書意見項目_動作確認のみ() {
        GaikyoChosaDataMybatisParameter parameter = GaikyoChosaDataMybatisParameter.createParamter(
                new RString("20211920160800133"));

        List<DbT5304ShujiiIkenshoIkenItemEntity> entity = sut.get要介護認定主治医意見書意見項目(parameter);
        assertThat(entity, is(notNullValue()));
    }

}
