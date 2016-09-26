/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoRelateEntity;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成のDB操作です。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public interface IKaishuriyushoShikyuKetteitsuchishoMapper {

    /**
     * 前回の実行情報を取得します。
     *
     * @param parameter 住宅改修理由書作成手数料支給（不支給）決定通知書作成のMyBatis用パラメータ
     * @return Temp_前回決定日
     */
    KaishuriyushoShikyuKetteitsuchishoRelateEntity selectKetteiTimestamp(KaishuriyushoShikyuKetteitsuchishoMybatisParameter parameter);
}
