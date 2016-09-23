/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushateiseirenrakuhyotorokumanager;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushateiseirenrakuhyotorokumanager.JukyushaTeiseiRenrakuhyoTorokuManagerParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;

/**
 * ビジネス設計_DBCMN81002_受給者訂正連絡票登録（画面）
 *
 * @reamsid_L DBC-2101-030 quxiaodong
 */
public interface IJukyushaTeiseiRenrakuhyoTorokuManagerMapper {

    /**
     * 当該情報より異動日が未来のMIN
     *
     * @param parameter JukyushaTeiseiRenrakuhyoTorokuManagerParameter
     * @return DbT3001JukyushaIdoRenrakuhyoEntity
     */
    DbT3001JukyushaIdoRenrakuhyoEntity selectMaxRirekiNoByMinIdoYMD(JukyushaTeiseiRenrakuhyoTorokuManagerParameter parameter);

}
