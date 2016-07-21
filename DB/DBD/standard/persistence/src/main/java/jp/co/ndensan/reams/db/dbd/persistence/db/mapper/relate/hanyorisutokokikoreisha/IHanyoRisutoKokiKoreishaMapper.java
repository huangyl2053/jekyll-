/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutokokikoreisha;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutokokikoreisha.HanyoRisutoKokiKoreishaMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutokokikoreisha.HanyoRisutoKokiKoreishaEntity;

/**
 * 汎用リスト出力(後期高齢者)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-5520-030 mawy
 */
public interface IHanyoRisutoKokiKoreishaMapper {

    /**
     * 要介護認定情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<HanyoRisutoKokiKoreishaEntity>
     */
    List<HanyoRisutoKokiKoreishaEntity> get汎用リスト(HanyoRisutoKokiKoreishaMybatisParameter parameter);
}
