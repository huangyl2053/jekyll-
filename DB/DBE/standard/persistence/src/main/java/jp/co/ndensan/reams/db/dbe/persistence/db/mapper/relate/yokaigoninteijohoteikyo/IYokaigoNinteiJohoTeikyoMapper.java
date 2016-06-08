/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.HihokenshaJyuhouRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinnteiRiriRelateEntity;

/**
 * 要介護認定情報提供のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public interface IYokaigoNinteiJohoTeikyoMapper {

    /**
     * 検索条件より、被保険者情報を検索する。
     *
     * @param param 被保険者情報検索条件
     * @return HihokenshaJyuhouRelateEntityの{@code list}
     */
    HihokenshaJyuhouRelateEntity get被保険者情報(YokaigoNinteiJohoTeiParameter param);

    /**
     * 検索条件より、認定履歴一覧情報を検索する。
     *
     * @param param 認定履歴一覧情報検索条件
     * @return NinnteiRiriRelateEntityの{@code list}
     */
    List<NinnteiRiriRelateEntity> get認定履歴一覧(YokaigoNinteiJohoTeiParameter param);
}
