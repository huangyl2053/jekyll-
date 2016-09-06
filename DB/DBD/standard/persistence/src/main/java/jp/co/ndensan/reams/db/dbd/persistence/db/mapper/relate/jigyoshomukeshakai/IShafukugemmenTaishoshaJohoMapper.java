/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jigyoshomukeshakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.ShafukugemmenTaishoshaJohoEntity;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行の社福減免対象者取得のMapperです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public interface IShafukugemmenTaishoshaJohoMapper {

    /**
     * 社福減免対象者情報を取得する。
     *
     * @return List<ShafukugemmenTaishoshaJohoEntity>
     */
    List<ShafukugemmenTaishoshaJohoEntity> get社福減免対象者情報();
}
