/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyolisthikazeinenkintaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hikazeinenkintaishosha.HikazeiNenkinTaishoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisthikazeinenkintaishosha.HikazeiNenkinTaishoshaEntity;

/**
 * 汎用リスト出力(非課税年金対象者)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
public interface IHanyoListHikazeiNenkinTaishoshaMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param param param
     * @return List<HikazeiNenkinTaishoshaEntity>
     */
    List<HikazeiNenkinTaishoshaEntity> get汎用リスト(HikazeiNenkinTaishoshaMybatisParameter param);
}
