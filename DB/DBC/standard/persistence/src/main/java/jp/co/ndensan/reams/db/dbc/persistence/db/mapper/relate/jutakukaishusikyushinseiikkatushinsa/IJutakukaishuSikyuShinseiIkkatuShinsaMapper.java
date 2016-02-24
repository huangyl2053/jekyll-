/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishusikyushinseiikkatushinsa;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinseiikkatushinsa.MiShinasaShikyuShinseiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinseiikkatushinsa.MiShinsaSikyuShinseiEntity;

/**
 * 住宅改修費支給申請一括審査のマッパーインタフェースです。
 */
public interface IJutakukaishuSikyuShinseiIkkatuShinsaMapper {

    /**
     * 未審査支給申請情報取得
     *
     * @param parameter
     * @return List<MiShinsaSikyuShinseiEntity>
     */
    List<MiShinsaSikyuShinseiEntity> get未審査支給申請情報(MiShinasaShikyuShinseiParameter parameter);

}
