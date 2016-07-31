/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahoshujissekijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteiChosaHoshuTankaMybatisParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaRelateEntity;

/**
 *
 * 認定調査委託料入力Mapperクラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
public interface INinteiChosaHoshuJissekiJohoMapper {

    /**
     * 検索条件に従い、調査員情報の検索。
     *
     * @param paramter NinteiChosaHoshuJissekiJohoMybatisParameter
     * @return List<NinteiChosaHoshuJissekiJohoRelateEntity>
     */
    List<NinteiChosaHoshuJissekiJohoRelateEntity> get調査員情報検索(NinteiChosaHoshuJissekiJohoMybatisParameter paramter);

    /**
     * 検索条件に従い、調査員実績一覧検索。
     *
     * @param paramter NinteichosahyoGaikyoChosaMybatisParameter
     * @return List<NinteichosahyoGaikyoChosaRelateEntity>
     */
    List<NinteichosahyoGaikyoChosaRelateEntity> get調査員実績一覧検索(NinteichosahyoGaikyoChosaMybatisParameter paramter);

    /**
     * 検索条件に従い、調査員実績一覧検索。
     *
     * @param paramter NinteichosahyoGaikyoChosaMybatisParameter
     * @return List<NinteichosahyoGaikyoChosaRelateEntity>
     */
    List<NinteichosahyoGaikyoChosaRelateEntity> get認定調査報酬単価(NinteiChosaHoshuTankaMybatisParamter paramter);
}
