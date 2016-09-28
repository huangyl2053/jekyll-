/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.nenreikaidanbetsuyokaigodujyokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001.ToukeiNinzuEntity;

/**
 * 年齢階級別要介護度状況（統計表）のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
public interface INenreiKaikyubetsuYokaigodoJokyoMapper {

    /**
     * 各年齢階級別の人数を取得します．
     *
     * @param parameter パラメター
     * @return List<ToukeiNinzuEntity>
     */
    List<ToukeiNinzuEntity> get人数(NenreiKaikyubetsuYokaigodoJokyoMybatisParameter parameter);

}
