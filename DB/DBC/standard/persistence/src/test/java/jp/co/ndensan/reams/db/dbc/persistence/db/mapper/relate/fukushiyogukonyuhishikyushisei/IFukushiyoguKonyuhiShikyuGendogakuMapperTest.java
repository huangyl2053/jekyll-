/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyushisei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ServiceShuruiCodeParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShibaraiKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShokanShikyuShinseiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShichosonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author GC 張鋭
 */
public class IFukushiyoguKonyuhiShikyuGendogakuMapperTest extends DbcTestDacBase {

    private IFukushiyoguKonyuhiShikyuGendogakuMapper mapper;

    @Before
    public void setUp() {
        sqlSession.getConfiguration().addMapper(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
        mapper = sqlSession.getMapper(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
    }

    @Test
    public void TEST_select支給申請一覧_データ無し() {
        ShokanShikyuShinseiParameter parameter
                = ShokanShikyuShinseiParameter.createParameter(new HihokenshaNo("123"), new RString("123"));
        List<FukushiyouguKonyuhiShikyuShinsei> resultList = mapper.select支給申請一覧(parameter);
        assertThat(resultList.size(), is(0));
    }

    @Test
    public void TEST_select要介護認定状態区分コード_データ無し() {
        ServiceShuruiCodeParameter parameter = ServiceShuruiCodeParameter.createParameter(
                HihokenshaNo.EMPTY, FlexibleYearMonth.MAX);
        Code code = mapper.select要介護認定状態区分コード(parameter);
        assertThat(code, is(nullValue()));
    }

    @Test
    public void TEST_select措置元市町村データ_データ無し() {
        ServiceShuruiCodeParameter parameter = ServiceShuruiCodeParameter.createParameter(
                HihokenshaNo.EMPTY, FlexibleYearMonth.MAX);
        List<ShichosonEntity> resultList = mapper.select措置元市町村データ(parameter);
        assertThat(resultList.size(), is(0));
    }

    @Test
    public void TEST_select支払結果情報_データ無し() {
        ShibaraiKekkaParameter parameter = ShibaraiKekkaParameter.createParameter(
                HihokenshaNo.EMPTY, RString.EMPTY, RString.EMPTY);
        SokanbaraiShiharaiKekka result = mapper.select支払結果情報(parameter);
        assertThat(result, is(nullValue()));
    }
}
