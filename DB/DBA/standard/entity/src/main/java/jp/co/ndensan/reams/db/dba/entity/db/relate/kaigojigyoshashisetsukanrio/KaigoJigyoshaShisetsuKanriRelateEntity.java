/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;

/**
 *
 * 介護事業者・施設管理のEntityクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJigyoshaShisetsuKanriRelateEntity implements Cloneable, Serializable {

    /**
     * @param dbT7060KaigoJigyoshaEntity 被保険者台帳管理Entity
     */
    private final DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyoshaEntity;

    /**
     * @param dbT7062KaigoJigyoshaDaihyoshaEntity 受給者台帳Entity
     */
    private final DbT7062KaigoJigyoshaDaihyoshaEntity dbT7062KaigoJigyoshaDaihyoshaEntity;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaShisetsuKanriRelateEntity() {
        dbT7060KaigoJigyoshaEntity = new DbT7060KaigoJigyoshaEntity();
        dbT7062KaigoJigyoshaDaihyoshaEntity = new DbT7062KaigoJigyoshaDaihyoshaEntity();
    }

}
