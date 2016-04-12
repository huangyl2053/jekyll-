/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.entity;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動期間のデータアクセスクラスです。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class Idokikan {

    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;
    private FlexibleDate idoYMD;
    private RString edaNo;
}
