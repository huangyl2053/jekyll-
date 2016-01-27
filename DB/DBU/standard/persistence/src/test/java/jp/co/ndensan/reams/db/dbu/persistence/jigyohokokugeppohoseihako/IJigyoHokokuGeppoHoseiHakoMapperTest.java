/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.persistence.jigyohokokugeppohoseihako;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataDeleteParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataUpdateParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author sunhui
 */
public class IJigyoHokokuGeppoHoseiHakoMapperTest extends DbuTestDacBase {
    private IJigyoHokokuGeppoHoseiHakoMapper mapper;
    
    @Before
    public void setUp() {
//        sqlSession.getConfiguration().addMapper(IJigyoHokokuGeppoHoseiHakoMapper.class);
        mapper = sqlSession.getMapper(IJigyoHokokuGeppoHoseiHakoMapper.class);
    }
    
    @Test
    public void select事業報告集計一覧データ_null(){
        JigyoHokokuGeppoSearchParameter parameter = JigyoHokokuGeppoSearchParameter.createParameterForJigyoHokokuGeppo(FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, LasdecCode.EMPTY);
        List<DbT7021JigyoHokokuTokeiDataEntity> list = mapper.select事業報告集計一覧データ(parameter);
        assertThat(list.size(), is(3));
        assertThat(list.get(0).getHokokuM(), is(new RString("123")));
    }
     @Test
    public void select報告年度様式種類_null(){
        JigyoHokokuGeppoDetalSearchParameter parameter = JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(new FlexibleYear("5454"), new RString("55"), new FlexibleYear("4545"), new RString("6"), new RString("6"),new LasdecCode(new RString("646435")), new Code(new RString("4")),new Code(new RString("456")));
        List<DbT7021JigyoHokokuTokeiDataEntity> list = mapper.select報告年度様式種類(parameter);
        list.size();
        assertThat(list.size(), is(1));
        assertThat(list.get(0).getHokokuM(), is(new RString("123")));
    }
    
    @Test 
    public void update事業報告集計一覧データ_null(){
        JigyoHokokuGeppoDataUpdateParameter parameter=JigyoHokokuGeppoDataUpdateParameter.createParameterForJigyoHokokuGeppoData(Code.EMPTY, Decimal.ONE, FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, RString.EMPTY, LasdecCode.EMPTY, Code.EMPTY, Code.EMPTY, Decimal.ONE, Decimal.ONE);
        int i=mapper.update事業報告集計一覧データ(parameter);
        assertThat(i,is(1));
        
    }
    
    @Test
    public void delete事業報告年報(){
        JigyoHokokuGeppoDataDeleteParameter parameter=JigyoHokokuGeppoDataDeleteParameter.createParameterForJigyoHokokuGeppoData(FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, RString.EMPTY, LasdecCode.EMPTY, Code.EMPTY, Code.EMPTY);
        int i=mapper.delete事業報告年報(parameter);
        assertThat(i,is(1));
    }
}
