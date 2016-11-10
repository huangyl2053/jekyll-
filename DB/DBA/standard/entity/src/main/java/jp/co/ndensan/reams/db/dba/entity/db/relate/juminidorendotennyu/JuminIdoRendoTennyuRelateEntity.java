/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 住民異動連動資格登録_転入 のEntityクラスです。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuminIdoRendoTennyuRelateEntity implements Cloneable, Serializable {

    private static final long serialVersionUID = -8488005220642642798L;

    private UaFt200FindShikibetsuTaishoEntity 宛名識別対象Entity;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity;
}
