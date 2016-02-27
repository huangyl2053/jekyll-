/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 資格期間情報クラス
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuKikanJoho {

    private FlexibleDate 資格期間開始日;
    private FlexibleDate 資格期間終了日;
    private int 月数;
}
