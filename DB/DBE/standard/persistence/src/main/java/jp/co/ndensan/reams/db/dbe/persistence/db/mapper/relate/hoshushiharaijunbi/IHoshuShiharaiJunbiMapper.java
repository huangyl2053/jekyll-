/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbi.HoshuShiharaiJunbiMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBE621001_報酬支払い通知書請求書・確認書マッパーインタフェースです
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
public interface IHoshuShiharaiJunbiMapper {

    /**
     * 検索条件より、適当な条件を連結して、認定調査報酬請求書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get認定調査報酬請求書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、認定調査報酬支払通知書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get認定調査報酬支払通知書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、認定調査報酬支払明細書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get認定調査報酬支払明細書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、主治医意見書作成報酬請求書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get主治医意見書作成報酬請求書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、主治医意見書作成報酬支払通知書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get主治医意見書作成報酬支払通知書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、主治医意見書作成報酬支払明細書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get主治医意見書作成報酬支払明細書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、主治医意見書作成報酬支払内訳確認書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get主治医意見書作成報酬支払内訳確認書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、介護認定審査会委員報酬支払通知書所を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get介護認定審査会委員報酬支払通知書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、介護認定審査会委員報酬費用弁償等明細書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get費用弁償等明細書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、介護認定審査会委員報酬支払明細書を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    List<HoshuShiharaiJunbiRelateEntity> get介護認定審査会委員報酬支払明細書(HoshuShiharaiJunbiMybatisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、消費税率を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshuShiharaiJunbiRelateEntity 検索結果の{@link HoshuShiharaiJunbiRelateEntity}
     */
    RString get消費税率(HoshuShiharaiJunbiMybatisParameter 検索条件);
}
