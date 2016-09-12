/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakushokaihanteikekka;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaParam;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka.JigyoKogakuShokaiHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaEntity;

/**
 * ビジネス設計_DBCMN11004_世帯合算並列表示（画面）のMapperです。
 *
 * @reamsid_L DBC-3000-050 gongliang
 */
public interface IKogakuShokaiHanteiKekkaMapper {

    /**
     * 高額介護サービス費照会の場合、支給判定結果を取得する。
     *
     * @param param KogakuShokaiHanteiKekkaParam
     * @return KogakuShokaiHanteiKekkaIchiEntity
     */
    List<KogakuShokaiHanteiKekkaEntity> get高額介護支給判定結果(KogakuShokaiHanteiKekkaParam param);

    /**
     * 事業高額介護サービス費照会の場合、支給判定結果を取得する。
     *
     * @param param KogakuShokaiHanteiKekkaParam
     * @return JigyoKogakuShokaiHanteiKekkaIchiEntity
     */
    List<JigyoKogakuShokaiHanteiKekkaEntity> get事業高額介護支給判定結果(KogakuShokaiHanteiKekkaParam param);
}
