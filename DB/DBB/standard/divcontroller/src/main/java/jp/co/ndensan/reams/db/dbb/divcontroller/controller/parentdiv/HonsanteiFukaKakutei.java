/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310002.HonsanteiFukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

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

        RString 処理日 = (RString) fukaKakuteiData.get(0).get("処理日");
        RString 処理時 = (RString) fukaKakuteiData.get(0).get("処理時");
        RString 賦課年度 = (RString) fukaKakuteiData.get(0).get("賦課年度");

        RStringBuilder buf = new RStringBuilder();
        buf.append(処理日);
        buf.append(" ");
        buf.append(処理時);

        RString 処理日時 = buf.toRString();

        honsanteiFukaKakuteiDiv.getHonsanteiShoriNichiji().getTxtKakuteiFukaNendo().setValue(賦課年度);
        honsanteiFukaKakuteiDiv.getHonsanteiShoriNichiji().getTxtHonsanteiShoriNichiji().setValue(処理日時);
    }
}
