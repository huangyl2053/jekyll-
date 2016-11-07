/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他住所地特例者情報Entity。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaJushochiTokureiShayouhouEntity {

    private ShikibetsuCode shikibetsuCode;
    private RString idoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private boolean logicalDeletedFlag;
    private RString lastUpdateTimestamp;
    private RString nyushoShisetsuCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private UaFt200FindShikibetsuTaishoEntity 宛名対象者;
}
