/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 介護業務専用に作成したアクセスログ制御クラスです。<br>
 * ※Dbは介護業務の業務コードです。
 */
public class DbAccessLogger {

    private final List<PersonalData> personalData = new ArrayList<>();

    private static final Code コード = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    /**
     * アクセスログを追加します。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     */
    @Deprecated
    public void store(ShoKisaiHokenshaNo shoKisaiHokenshaNo, RString hihokenshaNo) {
        store(shoKisaiHokenshaNo, hihokenshaNo, new ExpandedInformation(コード, 被保険者番号, hihokenshaNo));
    }

    /**
     * アクセスログを追加します。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     * @param expandedInformation
     */
    public void store(ShoKisaiHokenshaNo shoKisaiHokenshaNo, RString hihokenshaNo, ExpandedInformation expandedInformation) {
        personalData.add(PersonalData.of(new ShikibetsuCode(shoKisaiHokenshaNo.value().substring(0, 5).concat(hihokenshaNo)), expandedInformation));
    }

    /**
     * アクセスログを追加します。
     *
     * @param shoKisaiHokenshaNo
     * @param hihokenshaNo
     * @param expandedInformations
     */
    public void store(ShoKisaiHokenshaNo shoKisaiHokenshaNo, RString hihokenshaNo, ExpandedInformation... expandedInformations) {
        personalData.add(PersonalData.of(new ShikibetsuCode(shoKisaiHokenshaNo.value().substring(0, 5).concat(hihokenshaNo)), expandedInformations));
    }

    /**
     * アクセスログを実際に書き出します。
     *
     * @param accessLogType
     */
    public void flushBy(AccessLogType accessLogType) {
        jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger.log(accessLogType, personalData);
        personalData.clear();
    }

    /**
     * EUCに関するアクセスログを実際に書き出します。
     *
     * @param spoolOutputType {@link UzUDE0835SpoolOutputType}
     * @return {@link AccessLogUUID} （ファイルスプールの引数に用いる）
     */
    public AccessLogUUID flushByEUC(UzUDE0835SpoolOutputType spoolOutputType) {
        AccessLogUUID uuid = jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger.logEUC(spoolOutputType, personalData);
        personalData.clear();
        return uuid;
    }
}
