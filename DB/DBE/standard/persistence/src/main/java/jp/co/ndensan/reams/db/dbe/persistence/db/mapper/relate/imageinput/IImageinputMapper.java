/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageinputRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageInputSontaRelateEntity;

/**
 * イメージ取込み（規定・規定外）を検索用クラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public interface IImageinputMapper {

    /**
     * 当該被保険者の申請・意見書に関連する関連データを取得します。
     *
     * @param paramter パラメータ
     * @return 関連データ
     */
    List<ImageinputRelateEntity> get意見書関連データ(ImageinputMapperParamter paramter);

    /**
     * 当該被保険者の申請に関連するデータを取得します。
     *
     * @param paramter パラメータ
     * @return 関連データ
     */
    List<ImageInputSontaRelateEntity> getその他資料関連データ(ImageinputMapperParamter paramter);
}
