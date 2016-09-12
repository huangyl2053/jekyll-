/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutokokuho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutokokuho.HanyoRisutoKokuhoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutokokuho.HanyoRisutoKokuhoEntity;

/**
 * 汎用リスト出力(国保)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-5510-030 mawy
 */
public interface IHanyoRisutoKokuhoMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<HanyoRisutoKokuhoEntity>
     */
    List<HanyoRisutoKokuhoEntity> get汎用リスト(HanyoRisutoKokuhoMybatisParameter parameter);
}
