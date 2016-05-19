/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定法改正管理のdEntityです。
 *
 * @reamsid_L DBE-1300-080 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT7202KaigoNinteiHokaiseiKanriEntity {

    private FlexibleDate hokaiseiShikoYMD;
    private RString koroshoIfShikibetsuCode;
    private boolean isChosaGaikyoKomokuChangeFlag;
    private boolean isChosaKihonKomokuChangeFlag;
    private boolean isChujiiIkenshoKomokuChangeFlag;
}
