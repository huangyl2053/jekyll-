/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0490011.KogakuShikyuKetteiTsuchiSakuseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 高額サービス費支給決定通知書作成パネルです。
 * @author n8223
 * @author n8223 
 */
public class KogakuShikyuKetteiTsuchiSakusei {
    
    public  ResponseData<KogakuShikyuKetteiTsuchiSakuseiDiv> onLoad(KogakuShikyuKetteiTsuchiSakuseiDiv panel) {
         ResponseData<KogakuShikyuKetteiTsuchiSakuseiDiv> response = new ResponseData<>();

        setKogakuShikyuKetteiTsuchiSakusei(panel);  
         
        //初期値を設定したいものに値を入れる。決定年月　通知送達日　
        //初期値を設定したいものに値を入れる。出力対象区分
        //初期値を設定したいものに値を入れる。  高額介護サービス費支給（不支給）決定者一覧表       
//        panel.getKariPanel().getTxtNewPageItem().setValue(new RString("氏名５０音カナ"));
//        panel.getKariPanel().getTxt1().setValue(new RString("被保険者番号"));
//        panel.getKariPanel().getTxt2().setValue(new RString("行政区コード"));
//        panel.getKariPanel().getTxt3().setValue(new RString("氏名５０音カナ"));
//        panel.getKariPanel().getTxt4().setValue(new RString("決定通知番号"));
//        panel.getKariPanel().getTxt5().setValue(new RString("市町村コード"));

        response.data = panel;        
        return response;
    }

    private void setKogakuShikyuKetteiTsuchiSakusei(KogakuShikyuKetteiTsuchiSakuseiDiv panel) {
        //初期値を設定したいものに値を入れる。出力対象区分
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("ForRiyosha"), new RString("利用者向け決定通知書")));
        dataSource.add(new KeyValueDataSource(new RString("ForJuryoininsha"), new RString("受領委任者向け決定通知書")));
        panel.getChkOutputTargetKubun().setSelectedItems(dataSource);
 
        List<HashMap> ymlData = ymlData("dbc0490011/KogakuShikyuKetteiTsuchiSakusei.yml");
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);
        
        //初期値を設定したいものに値を入れる。決定年月　通知送達日　
        panel.getTxtKetteiYM().setValue(ymlDt.getAsRDate("KetteiYM"));
        panel.getTxtTsuchiSotatsuYMD().setValue(ymlDt.getAsRDate("TsuchiSotatsuYMD"));
        
        //発行日 20140630 park 追加
        panel.getKogakuShikyuKetteiTsuchiSakuseiListPanel().
                getKogakuShikyuKetteiTsuchiSakuseiListtHakkoDate().getTxtIssueDate()
                .setValue(ymlDt.getAsRDate("IssueDate1"));
        
        //出力順序・改頁の情の初期値を設定する。
        panel.getKogakuShikyuKetteiTsuchiSakuseiListPanel().
                getCommonKariChildDiv1().getKaigoChohyoShutsuryokujun().getTxtSortName()
                .setValue(ymlDt.getAsRString("SortName1"));
        panel.getKogakuShikyuKetteiTsuchiSakuseiListPanel().
                getCommonKariChildDiv1().getKaigoChohyoShutsuryokujun().getTxtKaiPage().
                setValue(ymlDt.getAsRString("KaiPage1"));
        panel.getKogakuShikyuKetteiTsuchiSakuseiListPanel().
                getCommonKariChildDiv1().getKaigoChohyoShutsuryokujun().getTxtSort().
                setValue(ymlDt.getAsRString("Sort1"));
       
        //発行日 20140630 park 追加 
        //　発行日の初期値を設定する。
        panel.getKogakuShikyuKetteiTsuchiSakuseishoPanel().
                getKogakuShikyuKetteiTsuchiSakuseishoHakkoDate().getTxtIssueDate().
                setValue(ymlDt.getAsRDate("IssueDate2"));
        
        //口座払い日 
        panel.getKogakuShikyuKetteiTsuchiSakuseishoPanel().getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().
                getPayToKoza().getTxtKozaPaymentDate()
                .setValue(ymlDt.getAsRDate("KozaPaymentDate"));
       // 窓口払い開始日
        panel.getKogakuShikyuKetteiTsuchiSakuseishoPanel().getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().
                getPayToMadoguchi().getTxtShiharaiDateRange().setFromValue(ymlDt.getAsRDate("ShiharaiDateRangeFrom"));
       //窓口払い終了日 
        panel.getKogakuShikyuKetteiTsuchiSakuseishoPanel().getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod().
                getPayToMadoguchi().getTxtShiharaiDateRange().setToValue(ymlDt.getAsRDate("ShiharaiDateRangeTo"));
        

        //出力順序・改頁の情の初期値を設定する。
        panel.getKogakuShikyuKetteiTsuchiSakuseishoPanel().
                getCommonKariChildDiv2().getKaigoChohyoShutsuryokujun().getTxtSortName()
                .setValue(ymlDt.getAsRString("SortName2"));
        panel.getKogakuShikyuKetteiTsuchiSakuseishoPanel().
                getCommonKariChildDiv2().getKaigoChohyoShutsuryokujun().getTxtKaiPage().
                setValue(ymlDt.getAsRString("KaiPage2"));
        panel.getKogakuShikyuKetteiTsuchiSakuseishoPanel().
                getCommonKariChildDiv2().getKaigoChohyoShutsuryokujun().getTxtSort().
                setValue(ymlDt.getAsRString("Sort2"));
        
    }

    private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }

    

 
    
}
