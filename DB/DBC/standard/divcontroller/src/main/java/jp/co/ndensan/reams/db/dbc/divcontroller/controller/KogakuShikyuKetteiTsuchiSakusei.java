/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KogakuShikyuKetteiTsuchiSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 高額サービス費支給決定通知書作成パネルです。
 * @author n8223
 */
public class KogakuShikyuKetteiTsuchiSakusei {
    
    public  ResponseData<KogakuShikyuKetteiTsuchiSakuseiDiv> onLoad(KogakuShikyuKetteiTsuchiSakuseiDiv panel) {
         ResponseData<KogakuShikyuKetteiTsuchiSakuseiDiv> response = new ResponseData<>();

        //初期値を設定したいものに値を入れる。決定年月　通知送達日　
        panel.getTxtKetteiYM().setValue(new RDate("201406"));
        panel.getTxtTsuchiSotatsuYMD().setValue(new RDate("20140701"));
        
        //初期値を設定したいものに値を入れる。出力対象区分（
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("ForRiyosha"), new RString("利用者向け決定通知書")));
        dataSource.add(new KeyValueDataSource(new RString("ForJuryoininsha"), new RString("受領委任者向け決定通知書")));
        panel.getChkOutputTargetKubun().setSelectedItems(dataSource);
        
        //初期値を設定したいものに値を入れる。  高額介護サービス費支給（不支給）決定者一覧表       
        panel.getKariPanel().getTxtNewPageItem().setValue(new RString("氏名５０音カナ"));
        panel.getKariPanel().getTxt1().setValue(new RString("被保険者番号"));
        panel.getKariPanel().getTxt2().setValue(new RString("行政区コード"));
        panel.getKariPanel().getTxt3().setValue(new RString("氏名５０音カナ"));
        panel.getKariPanel().getTxt4().setValue(new RString("決定通知番号"));
        panel.getKariPanel().getTxt5().setValue(new RString("市町村コード"));

        response.data = panel;        
        return response;
    }

 
    
}
