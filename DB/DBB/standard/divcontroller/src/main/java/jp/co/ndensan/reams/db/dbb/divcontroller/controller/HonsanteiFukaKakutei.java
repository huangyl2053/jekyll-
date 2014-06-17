/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310002.HonsanteiFukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8211
 */
public class HonsanteiFukaKakutei {
    public ResponseData<HonsanteiFukaKakuteiDiv> onLoad(HonsanteiFukaKakuteiDiv honsanteiFukaKakuteiDiv) {
        ResponseData<HonsanteiFukaKakuteiDiv> response = new ResponseData<>();

        setParam(honsanteiFukaKakuteiDiv);

        response.data = honsanteiFukaKakuteiDiv;
        return response;
    }

    private void setParam(HonsanteiFukaKakuteiDiv honsanteiFukaKakuteiDiv) {
        List<HashMap> fukaKakuteiData = YamlLoader.DBB.loadAsList(new RString("DBB0310002/FukaKakutei.yml"));
        
        
        String 処理日 = (String) fukaKakuteiData.get(0).get("処理日");
        String 処理時 = (String) fukaKakuteiData.get(0).get("処理時");
        String 賦課年度 = (String) fukaKakuteiData.get(0).get("賦課年度");
        
        StringBuilder buf = new StringBuilder();
        buf.append(処理日);
        buf.append(" ");
        buf.append(処理時);
        
        String 処理日時 = buf.toString();
        
        honsanteiFukaKakuteiDiv.getHonsanteiShoriNichiji().getTxtKakuteiFukaNendo().setValue(new RString(賦課年度));
        honsanteiFukaKakuteiDiv.getHonsanteiShoriNichiji().getTxtHonsanteiShoriNichiji().setValue(new RString(処理日時));
    }
}
