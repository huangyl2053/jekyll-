/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.common;

import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 要介護認定情報です。
 *
 * @reamsid_L DBD-4342-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NursingCareInformationEntity {

    private ShinseiJokyoKubun 申請状況区分;
    private FlexibleDate 受給申請年月日;
    private JukyuShinseiJiyu 受給申請事由;
    private boolean 旧措置者フラグ;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 認定年月日;
    private IYokaigoJotaiKubun 要介護度;

}
