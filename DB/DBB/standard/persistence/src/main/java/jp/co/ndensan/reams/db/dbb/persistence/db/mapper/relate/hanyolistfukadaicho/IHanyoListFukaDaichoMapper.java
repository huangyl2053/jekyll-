/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.hanyolistfukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hanyolistfukadaicho.HanyoListDaichoMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoTmpEntity;

/**
 * 汎用リスト 賦課台帳のマッパーインタフェースです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
public interface IHanyoListFukaDaichoMapper {

    /**
     * 賦課台帳情報を取得します。
     *
     * @param parameter HanyoListDaichoMybatisParameter
     * @return List<HanyoListFukaDaichoTmpEntity>
     */
    List<HanyoListFukaDaichoTmpEntity> getHanyoListFukaDaicho(HanyoListDaichoMybatisParameter parameter);
}
