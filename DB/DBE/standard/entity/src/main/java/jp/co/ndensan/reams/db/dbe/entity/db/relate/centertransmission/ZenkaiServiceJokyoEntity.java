/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 前回調査票（概況調査）サービスの状況のentityクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ZenkaiServiceJokyoEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private ShinseishoKanriNo zenkaiShinseishoKanriNo;
    private Code koroshoIfShikibetsuCode;
    private int remban;
    private int serviceJokyo;
}
