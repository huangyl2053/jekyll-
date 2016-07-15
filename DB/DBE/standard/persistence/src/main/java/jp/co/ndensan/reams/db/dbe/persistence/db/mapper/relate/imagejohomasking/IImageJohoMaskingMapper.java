/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imagejohomasking;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking.ImageJohoMaskingParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imagejohomasking.ImageJohoMaskingRelateEntity;

/**
 * イメージ情報マスキングのマッパーインタフェースです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public interface IImageJohoMaskingMapper {

    /**
     * イメージ情報マスキング画面初期を検索します。
     *
     * @param param イメージ情報マスキングのパラメータ
     * @return イメージ情報マスキング
     */
    List<ImageJohoMaskingRelateEntity> getDataForLoad(ImageJohoMaskingParameter param);
}
