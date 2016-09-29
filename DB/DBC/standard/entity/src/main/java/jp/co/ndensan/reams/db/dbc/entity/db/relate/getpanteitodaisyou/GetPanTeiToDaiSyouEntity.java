/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.getpanteitodaisyou;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 受給者の判定と受給者台帳の取得のエンティティクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GetPanTeiToDaiSyouEntity extends DbTableEntityBase<GetPanTeiToDaiSyouEntity> implements IDbAccessable {

    private DbWT2111ShokanShinseiTempEntity 償還払支給申請一時TBL;
    private DbT4001JukyushaDaichoEntity 受給者台帳TBL;

}
