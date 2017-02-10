/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 *
 * @author n3415
 * @deprecated 複数件のアクセスログを出力すると、パフォーマンスが大幅に低下します。{@link jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger}
 * を使ってください。
 */
public class NinteiAccessLogger {

    private final AccessLogType accessLogType;
    private final ShikibetsuCode shikibetsuCode;
    private final ExpandedInformation expandedInformation;
    private static final Code コード = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    public NinteiAccessLogger(AccessLogType getAccessLogType, ShoKisaiHokenshaNo getShoKisaiHokenshaNo, RString getHihokenshaNo) {
        this.accessLogType = getAccessLogType;
        this.shikibetsuCode = new ShikibetsuCode(getShoKisaiHokenshaNo.value().substring(0, 5).concat(getHihokenshaNo));
        this.expandedInformation = new ExpandedInformation(コード, 被保険者番号, getHihokenshaNo);
    }

    public NinteiAccessLogger(AccessLogType getAccessLogType,
            ShoKisaiHokenshaNo getShoKisaiHokenshaNo, RString getHihokenshaNo, ExpandedInformation getExpandedInformation) {
        this.accessLogType = getAccessLogType;
        this.shikibetsuCode = new ShikibetsuCode(getShoKisaiHokenshaNo.value().substring(0, 5).concat(getHihokenshaNo));
        this.expandedInformation = getExpandedInformation;
    }

    public void log() {
        PersonalData personalData = PersonalData.of(shikibetsuCode, expandedInformation);
        AccessLogger.log(accessLogType, personalData);
    }
}
