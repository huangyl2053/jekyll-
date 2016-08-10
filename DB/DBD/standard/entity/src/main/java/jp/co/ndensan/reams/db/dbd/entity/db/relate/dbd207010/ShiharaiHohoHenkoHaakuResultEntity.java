/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支払方法変更滞納者抽出結果情報クラスです.
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuResultEntity {

    private DbT2002FukaEntity 賦課NewestEntity;
    private DbT2003KibetsuEntity 介護期別Entity;
    private UrT0705ChoteiKyotsuEntity 調定共通_介護継承Entity;
    private DbT4023JikoKisambiKanriEntity 時効起算日管理Entity;
    private DbT3034ShokanShinseiEntity 償還払支給申請Entity;

    private RString 収入_収納ID;
    private Decimal 収入_SUM収入額;
}
