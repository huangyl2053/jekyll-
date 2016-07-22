/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0070011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator.RiyoshaFutangakuBusiness;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011.DBU0070011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011.RenrakuhyoDataCreatorDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0070011.RenrakuhyoDataCreatorHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0070011.RenrakuhyoDataCreatorValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.renrakuhyodatacreator.RenrakuhyoDataCreatorFinder;
import jp.co.ndensan.reams.db.dbu.service.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dbu.service.report.kaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護保険連絡票作成のハンドラークラスです。
 *
 * @reamsid_L DBA-1290-010 linghuhang
 */
public class RenrakuhyoDataCreator {

    private static final int 給付率 = 95;

    /**
     * 介護保険連絡票作成に初期化を設定します。
     *
     * @param div 介護保険連絡票作成Div
     * @return ResponseData<RenrakuhyoDataCreatorDiv>
     */
    public ResponseData<RenrakuhyoDataCreatorDiv> onLoad(RenrakuhyoDataCreatorDiv div) {
        TaishoshaKey 資格対象者キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者キー.get被保険者番号();
        FlexibleDate 基準日 = FlexibleDate.getNowDate();
        RenrakuhyoDataCreatorFinder finder = RenrakuhyoDataCreatorFinder.createInstance();
        HihokenshaDaichoAlive 被保険者台帳情報
                = finder.get被保険者台帳情報(被保険者番号);
        ValidationMessageControlPairs validPairs = getValidationHandler().validateForAction(被保険者台帳情報);
        if (validPairs.iterator().hasNext()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnReportPublish"), true);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        boolean is非該当 = false;
        RiyoshaFutangakuBusiness 旧措置情報 = finder.get旧措置情報(被保険者番号, 基準日);
        if (旧措置情報 != null) {
            if (!旧措置情報.is旧措置情報() || (旧措置情報.is旧措置情報() && (旧措置情報.get給付率().getColumnValue().intValue()) < 給付率)) {
                is非該当 = true;
            }
            if (旧措置情報.is旧措置情報() && 給付率 <= (旧措置情報.get給付率().getColumnValue().intValue())) {
                is非該当 = false;
            }
        }
        Decimal 算定基準額 = new Decimal(0);
        KogakuKyufuTaishoshaGokei 高額介護サービス = finder.get高額介護サービス費給付対象者合計(被保険者番号, 基準日);
        if (高額介護サービス != null) {
            KogakuKyufuTaishoshaGokei 高額介護サービス費
                    = finder.get高額介護サービス費給付対象者合計(高額介護サービス.get対象者受取年月(), 高額介護サービス.get世帯集約番号());
            if (高額介護サービス費 != null) {
                算定基準額 = 高額介護サービス費.get算定基準額();
            }
        }

        getHandler(div).onLoad(資格対象者キー, finder.get支払方法変更(被保険者番号, 基準日),
                finder.get利用者負担額(被保険者番号, finder.get給付実績基本(被保険者番号, 基準日).getサービス提供年月()),
                finder.get負担限度額(被保険者番号, 基準日), finder.get保険料段階(基準日).records(),
                算定基準額, is非該当, finder.get介護賦課(被保険者番号, 基準日));
        if (is非該当) {
            return ResponseData.of(div).setState(DBU0070011StateName.Higaito);
        } else {
            return ResponseData.of(div).setState(DBU0070011StateName.Gaito);
        }
    }

    /**
     * 適用除外者台帳を発行するボタンを押下します。
     *
     * @param div RenrakuhyoDataCreatorDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(RenrakuhyoDataCreatorDiv div) {
        TaishoshaKey 資格対象者キー = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者キー.get被保険者番号();
        FlexibleDate 基準日 = FlexibleDate.getNowDate();
        RenrakuhyoDataCreatorFinder finder = RenrakuhyoDataCreatorFinder.createInstance();

        boolean is非該当 = false;
        RiyoshaFutangakuBusiness 旧措置情報 = finder.get旧措置情報(被保険者番号, 基準日);
        if (旧措置情報 != null) {
            if (!旧措置情報.is旧措置情報() || (旧措置情報.is旧措置情報() && 給付率 < (旧措置情報.get給付率().getColumnValue().intValue()))) {
                is非該当 = true;
            }
            if (旧措置情報.is旧措置情報() && 給付率 <= (旧措置情報.get給付率().getColumnValue().intValue())) {
                is非該当 = false;
            }
        }
        if (is非該当) {
            return ResponseData.of(new KaigohokenRenrakuhyoPrintService().print(getHandler(div).set帳票の項目(finder.get負担限度額(被保険者番号, 基準日), is非該当, finder.get受給者台帳(被保険者番号), finder.get被保険者台帳(被保険者番号)))).respond();
        } else {
            return ResponseData.of(new KaigohokenRenrakuhyoJisshitsuFutanPrintService().print(getHandler(div).set帳票の項目(finder.get負担限度額(被保険者番号, 基準日), is非該当, finder.get受給者台帳(被保険者番号), finder.get被保険者台帳(被保険者番号)))).respond();
        }
    }

    private RenrakuhyoDataCreatorHandler getHandler(RenrakuhyoDataCreatorDiv div) {
        return new RenrakuhyoDataCreatorHandler(div);
    }

    private RenrakuhyoDataCreatorValidationHandler getValidationHandler() {
        return new RenrakuhyoDataCreatorValidationHandler();
    }
}
