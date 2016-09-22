/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定情報クラスです．
 *
 * @reamsid_L DBD-3970-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinnteiJohoEntity {

    private HihokenshaNo 認定情報_被保険者番号;
    private RString 認定情報_要介護状態区分コード;
    private FlexibleDate 認定情報_認定年月日;
    private FlexibleDate 認定情報_認定有効期間開始年月日;
    private FlexibleDate 認定情報_認定有効期間終了年月日;
}
