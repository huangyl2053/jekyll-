/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.mapper.kaigoninteiatenainfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigoninteiatenainfo.KaigoNinteiAtenaInfoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigoninteiatenainfo.KaigoNinteiAtenaInfoRelateEntity;

/**
 *
 * 介護認定宛名情報のマッパーインタフェースです。
 */
public interface IKaigoNinteiAtenaInfoMapper {

    /**
     * 介護認定宛名情報のリストを取得します。
     *
     * @param 介護認定宛名情報検索条件 介護認定宛名情報検索条件
     * @return KaigoNinteiAtenaInfoRelateEntity
     */
    List<KaigoNinteiAtenaInfoRelateEntity> getKaigoNinteiAtenaInfoList(KaigoNinteiAtenaInfoParameter 介護認定宛名情報検索条件);

}
