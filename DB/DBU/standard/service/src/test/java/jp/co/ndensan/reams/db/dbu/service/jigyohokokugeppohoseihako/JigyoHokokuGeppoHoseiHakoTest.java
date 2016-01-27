/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.JigyoHokokuNenpoResult;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataDeleteParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataUpdateParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.jigyohokokugeppohoseihako.IJigyoHokokuGeppoHoseiHakoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author sunhui
 */
public class JigyoHokokuGeppoHoseiHakoTest extends DbuTestBase {
    private JigyoHokokuGeppoHoseiHako hoseiHako;
    MapperProvider provider;
    IJigyoHokokuGeppoHoseiHakoMapper mapper;
    JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter;
    JigyoHokokuGeppoDetalSearchParameter jigyoHokokuGeppoDetalParameter;
    List<JigyoHokokuNenpoResult> jigyoHokokuNenpoResult;
    @Before
    public void setUp() {
        provider = mock(MapperProvider.class);
        mapper = mock(IJigyoHokokuGeppoHoseiHakoMapper.class);
        hoseiHako = new JigyoHokokuGeppoHoseiHako(provider);   
    }
    
    @Test 
    public void select市町村のリスト_null(){
      SearchResult<ShichosonCodeNameResult> list=hoseiHako.getShichosonCodeNameList();
//      assertThat(list.totalCount(), is(0));
    }
    @Test
    public void getJigyoHokokuGeppoList(){      
        jigyoHokokuGeppoParameter=JigyoHokokuGeppoSearchParameter.createParameterForJigyoHokokuGeppo(FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, LasdecCode.EMPTY);
        List<DbT7021JigyoHokokuTokeiDataEntity> entityList = new ArrayList<>();
        when(provider.create(IJigyoHokokuGeppoHoseiHakoMapper.class)).thenReturn(mapper);
        when(mapper.select事業報告集計一覧データ(jigyoHokokuGeppoParameter)).thenReturn(entityList);
        List<JigyoHokokuNenpoResult> entiotyList = hoseiHako.getJigyoHokokuGeppoList(jigyoHokokuGeppoParameter);
        assertThat(entiotyList.size(), is(1));
    }
     @Test
    public void getJigyoHokokuGeppoDetal(){
        List<DbT7021JigyoHokokuTokeiDataEntity> businessList = new ArrayList<>();
      JigyoHokokuGeppoDetalSearchParameter jigyoHokokuGeppoDetalParameter=JigyoHokokuGeppoDetalSearchParameter.createParameterForJigyoHokokuGeppoDetal(FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, RString.EMPTY, LasdecCode.EMPTY, Code.EMPTY, Code.EMPTY);
      when(provider.create(IJigyoHokokuGeppoHoseiHakoMapper.class)).thenReturn(mapper);
      when(mapper.select報告年度様式種類(jigyoHokokuGeppoDetalParameter)).thenReturn(businessList);
        List<DbT7021JigyoHokokuTokeiDataEntity> s= hoseiHako.getJigyoHokokuGeppoDetal(jigyoHokokuGeppoDetalParameter);      
    }
    @Test
    public void updateJigyoHokokuGeppoData(){
 
         List<JigyoHokokuNenpoResult> list=new ArrayList<>(); 
         JigyoHokokuGeppoDataUpdateParameter updateParameter=JigyoHokokuGeppoDataUpdateParameter.createParameterForJigyoHokokuGeppoData(Code.EMPTY, Decimal.ONE, FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, RString.EMPTY, LasdecCode.EMPTY, Code.EMPTY, Code.EMPTY, Decimal.ONE, Decimal.ONE);
        when(provider.create(IJigyoHokokuGeppoHoseiHakoMapper.class)).thenReturn(mapper);
        when(mapper.update事業報告集計一覧データ(updateParameter)).thenReturn(0);
       
       int i= hoseiHako.updateJigyoHokokuGeppoData(list); 
        
    }
    public void deleteJigyoHokokuGeppoData(){
        JigyoHokokuGeppoDataDeleteParameter parameter=JigyoHokokuGeppoDataDeleteParameter.createParameterForJigyoHokokuGeppoData(FlexibleYear.MAX, RString.EMPTY, FlexibleYear.MAX, RString.EMPTY, RString.EMPTY, LasdecCode.EMPTY, Code.EMPTY, Code.EMPTY);
        when(provider.create(IJigyoHokokuGeppoHoseiHakoMapper.class)).thenReturn(mapper);
        when(mapper.delete事業報告年報(parameter)).thenReturn(0);
        int i= hoseiHako.deleteJigyoHokokuGeppoData(parameter);
        
    }
}

