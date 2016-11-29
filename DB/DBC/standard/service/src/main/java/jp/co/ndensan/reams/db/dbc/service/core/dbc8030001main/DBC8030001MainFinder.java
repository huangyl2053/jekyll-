/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.dbc8030001main;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ux.uxx.definition.mybatisprm.kozafurikomi.furikomiitakushakosei.FurikomiItakushaKoseiMapperParameter;
import jp.co.ndensan.reams.ux.uxx.entity.db.basic.kozafurikomi.furikomigroup.UrT0717FurikomiGroupEntity;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.kozafurikomi.furikomigroup.FurikomiGroupItakushaRelateEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.kozafurikomi.furikomi.FurikomiGroupItakushaItakushaKoseiFinder;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込データ媒体書き込みのHandlerです。
 *
 * @reamsid_L DBC-2180-080 liwul
 */
public class DBC8030001MainFinder {

    /**
     * getGroupList
     *
     * @param parameter FurikomiItakushaKoseiMapperParameter
     * @return List<RString>
     */
    public List<RString> getGroupList(FurikomiItakushaKoseiMapperParameter parameter) {
        List<RString> list = new ArrayList<>();
        List<FurikomiGroupItakushaRelateEntity> furikomiGroupItakushaList
                = FurikomiGroupItakushaItakushaKoseiFinder.createInstance().getFurikomiGroupItakushItakushKosei(parameter);

        if (furikomiGroupItakushaList != null && !furikomiGroupItakushaList.isEmpty()) {
            for (FurikomiGroupItakushaRelateEntity data : furikomiGroupItakushaList) {
                UrT0717FurikomiGroupEntity furikomiGroupData = data.get振込グループEntity();
                if (furikomiGroupData != null) {
                    list.add(furikomiGroupData.getDaihyoKinyuKikanCode().value().concat(furikomiGroupData.getFurikomiGroupCode()));
                }
            }
        }
        return list;
    }

}
