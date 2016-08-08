/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.jukyushajaicho.JukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;

/**
 * 受給者台帳情報を取得。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public interface IJukyushaDaichoMapper {

    /**
     * 受給者台帳情報を取得。
     *
     * @param parameter JukyushaDaichoParameter
     * @return DbT4001JukyushaDaichoEntity
     */
    DbT4001JukyushaDaichoEntity get受給者台帳(JukyushaDaichoParameter parameter);
}
