/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.business.core.kouikitenkyoresultlist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlist.KoikinaiTenkyoResultListCsvDataSakusei;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoCSVDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author GC xuhao
 */
public class KoikinaiTenkyoResultListCsvDataSakuseiTest extends DbuTestBase {
    
    private static KoikinaiTenkyoEntity entity;
    private KoikinaiTenkyoResultListCsvDataSakusei sut;
    
   @Before
    public void setUp() {
//          KoikinaiTenkyoResultListCsvDataSakusei koikinaiTenkyoResultListCsvDataSakusei = new KoikinaiTenkyoResultListCsvDataSakusei();
//          sut = koikinaiTenkyoResultListCsvDataSakusei.getKoikinaiTenkyoResultListCsvData(KoikinaiTenkyoEntityList);
        sut = new KoikinaiTenkyoResultListCsvDataSakusei();
    }
    @Test
    public void getKoikinaiTenkyoResultListCsvData() {
          List<KoikinaiTenkyoEntity> KoikinaiTenkyoEntityList = new ArrayList<>();
          entity = new KoikinaiTenkyoEntity();
          entity.set被保険者番号(new HihokenshaNo("123456"));
          entity.set氏名カナ(new AtenaKanaMeisho("カナ"));
          entity.set氏名(new AtenaMeisho("qqq"));
          entity.set旧住民コード(new ShikibetsuCode("1000"));
          entity.set前住所(new RString("qqq"));
          entity.set転出予定日(new FlexibleDate("19890108"));
          entity.set転出確定日(new FlexibleDate("20160114"));
          entity.set転出確定通知日(new FlexibleDate("20160114"));
          entity.set処理日(new FlexibleDate("20160114"));
          entity.set新住民コード(new ShikibetsuCode("1222"));
          entity.set現住所(new RString("qqq"));
          entity.set登録異動日(new FlexibleDate("20160114"));
          entity.set登録届出日(new FlexibleDate("20160114"));
          entity.set異動情報(new RString("qqq"));
          KoikinaiTenkyoEntityList.add(entity);
          entity = new KoikinaiTenkyoEntity();
          entity.set被保険者番号(new HihokenshaNo("2222"));
          entity.set氏名カナ(new AtenaKanaMeisho("aqqq"));
          entity.set氏名(new AtenaMeisho("aqqq"));
          entity.set旧住民コード(new ShikibetsuCode("100"));
          entity.set前住所(new RString("aqqq"));
          entity.set転出予定日(new FlexibleDate("3016114"));
          entity.set転出確定日(new FlexibleDate("30160114"));
          entity.set転出確定通知日(new FlexibleDate("30160114"));
          entity.set処理日(new FlexibleDate("30160114"));
          entity.set新住民コード(new ShikibetsuCode("100"));
          entity.set現住所(new RString("aqqq"));
          entity.set登録異動日(new FlexibleDate("30160114"));
          entity.set登録届出日(new FlexibleDate("30160114"));
          entity.set異動情報(new RString("aqqq"));
          KoikinaiTenkyoEntityList.add(entity);
          
          
          
         List<KoikinaiTenkyoCSVDataEntity> result = sut.getKoikinaiTenkyoResultListCsvData(KoikinaiTenkyoEntityList);
         for(int i = 0;i <2; i++) {
             System.out.println(result.get(i).get登録届出日());
         }
        assertThat(result.get(0).get氏名カナ(), is(new RString("カナ")));
    }
    
    @Test
    public void getKoikinaiTenkyoResultListCsvData1() {
        List<KoikinaiTenkyoEntity> KoikinaiTenkyoEntityList = null;
        List<KoikinaiTenkyoCSVDataEntity> result = sut.getKoikinaiTenkyoResultListCsvData(KoikinaiTenkyoEntityList);
        assertThat(result.size(), is(0));
    }
    
    @Test
    public void getKoikinaiTenkyoResultListCsvData2() {
        List<KoikinaiTenkyoEntity> KoikinaiTenkyoEntityList = new ArrayList();
        List<KoikinaiTenkyoCSVDataEntity> result = sut.getKoikinaiTenkyoResultListCsvData(KoikinaiTenkyoEntityList);
        assertThat(result.size(), is(0));
    }

}
