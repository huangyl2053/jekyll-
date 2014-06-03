/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiChohyoHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;


/**
 *
 * @author n8211
 */
public class HonsanteiChohyoHakko {

    public ResponseData<HonsanteiChohyoHakkoDiv> onLoad(HonsanteiChohyoHakkoDiv honsanteiChohyoHakkoDiv) {
        ResponseData<HonsanteiChohyoHakkoDiv> response = new ResponseData<>();

        setParam(honsanteiChohyoHakkoDiv);

        response.data = honsanteiChohyoHakkoDiv;
        return response;
    }

    private void setParam(HonsanteiChohyoHakkoDiv honsanteiChohyoHakkoDiv) {
        setChoteibo(honsanteiChohyoHakkoDiv);
        setHonTokuKaishiTsuchi(honsanteiChohyoHakkoDiv);
        setHonNotsu(honsanteiChohyoHakkoDiv);
        setHonKetteTsuchi(honsanteiChohyoHakkoDiv);
    }

    private void setChoteibo(HonsanteiChohyoHakkoDiv honsanteiChohyoHakkoDiv) {
        honsanteiChohyoHakkoDiv.getHonChoteibo().getTxtChoteiboFromDate().setValue(RDateTime.now().getDate());
        honsanteiChohyoHakkoDiv.getHonChoteibo().getTxtChoteiboFromTime().setValue(RDateTime.now().getTime());
    }

    private void setHonTokuKaishiTsuchi(HonsanteiChohyoHakkoDiv honsanteiChohyoHakkoDiv) {
        honsanteiChohyoHakkoDiv.getHonTokuKaishiTsuchi().getTxtTokuKaishiTsuchiHakkoYMD().setValue(RDateTime.now().getDate());
    }

    private void setHonNotsu(HonsanteiChohyoHakkoDiv honsanteiChohyoHakkoDiv) {
        honsanteiChohyoHakkoDiv.getHonNotsu().getTxtNotsuHakkoYMD().setValue(RDateTime.now().getDate());
        
        List<KeyValueDataSource> test = new ArrayList<>();
        test.add(new KeyValueDataSource(new RString("isAllSelect"), new RString("")));
//        List<KeyValueDataSource> keyValueDataSources = honsanteiChohyoHakkoDiv.getHonNotsu().getChkNotsuTaishosha().getDataSource();
//        honsanteiChohyoHakkoDiv.getHonNotsu().getChkNotsuTaishosha().setSelectedItems(keyValueDataSources);
    }

    private void setHonKetteTsuchi(HonsanteiChohyoHakkoDiv honsanteiChohyoHakkoDiv) {
        honsanteiChohyoHakkoDiv.getHonKetteTsuchi().getTxtKetteTsuchiHakkoYMD().setValue(RDateTime.now().getDate());
        honsanteiChohyoHakkoDiv.getHonKetteTsuchi().getTxtKetteTsuchiBunshoNo().setValue(RDate.MAX);
    }
}
