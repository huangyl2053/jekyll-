/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageinputRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込み（規定・規定外）を検索用クラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public interface IImageinputMapper {

    /**
     * 当該被保険者の申請データを取得します。
     *
     * @param paramter パラメータ
     * @return 申請データ
     */
    List<RString> get申請データ(ImageinputMapperParamter paramter);

    /**
     * 当該被保険者の申請データを取得します。
     *
     * @param paramter パラメータ
     * @return 申請データ
     */
    List<ImageinputRelateEntity> get関連データ(ImageinputMapperParamter paramter);
}
