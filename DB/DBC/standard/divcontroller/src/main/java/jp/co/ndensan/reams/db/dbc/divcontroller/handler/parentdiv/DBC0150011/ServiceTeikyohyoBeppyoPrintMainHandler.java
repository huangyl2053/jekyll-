/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TeikyohyoBeppyoEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.serviceriyohyobeppyo.ServiceRiyohyoBeppyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.teikyohyobeppyo.TeikyohyoBeppyoManager;
import jp.co.ndensan.reams.db.dbc.service.report.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 画面設計_DBC0150011_サービス提供票別表のHandlerクラス
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public class ServiceTeikyohyoBeppyoPrintMainHandler {

    private static final RString 引数_自己作成0件 = new RString("自己作成0件");

    private final ServiceTeikyohyoBeppyoPrintMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     */
    public ServiceTeikyohyoBeppyoPrintMainHandler(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     * @return ServiceTeikyohyoBeppyoPrintMainHandler
     */
    public static ServiceTeikyohyoBeppyoPrintMainHandler of(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        return new ServiceTeikyohyoBeppyoPrintMainHandler(div);
    }

    /**
     * 帳票発行処理時の処理です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param manager TeikyohyoBeppyoManager
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行処理(HihokenshaNo 被保険者番号, TeikyohyoBeppyoManager manager) {

        div.getTxtJikoSakuseiKeikakuYm().setVisible(true);
        ServiceRiyohyoBeppyoParameter param = new ServiceRiyohyoBeppyoParameter();
        FlexibleYearMonth 自己作成計画年月 = new FlexibleYearMonth(div.getTxtJikoSakuseiKeikakuYm().getValue().
                getYearMonth().toDateString());
        TeikyohyoBeppyoEntityResult 被保険者情報Result = manager.get被保険者情報(被保険者番号, 自己作成計画年月);
        被保険者情報Result.set被保険者番号(被保険者番号);
        FlexibleYearMonth 対象年月 = 被保険者情報Result.get対象年月();
        int 履歴番号 = 被保険者情報Result.get履歴番号();
        RString 居宅総合事業区分 = 被保険者情報Result.get総合事業区分();
        List<KyufuJikoSakuseiEntityResult> 帳票データ = manager.帳票データ抽出(被保険者番号, 対象年月, 履歴番号,
                自己作成計画年月);
        if (帳票データ.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.帳票印刷不可.getMessage().replace(引数_自己作成0件.toString()));
        } else {
            KyufuJikoSakuseiEntityResult 合計Entity = 帳票データ.get(帳票データ.size() - 1);
            帳票データ.remove(帳票データ.size() - 1);
            List<KyufuJikoSakuseiEntityResult> 計画EntityList = 帳票データ;
            合計Entity = manager.合計Entity単位設定(被保険者番号, 居宅総合事業区分, 自己作成計画年月, 合計Entity);
            param.set合計情報(合計Entity);
            param.set帳票情報マップ(manager.creat事業者別マップ(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月,
                    計画EntityList, 合計Entity));
        }
        param.set帳票ヘッダー(被保険者情報Result);
        param.set作成日時(new FlexibleDate(div.getTxtSakuseiYmd().getValue().toDateString()));
        param.set利用年月(自己作成計画年月);
        param.set種類別支給限度情報(manager.get種類別支給限度情報(自己作成計画年月, 帳票データ));
        param.set短期入所情報(manager.get短期入所利用日数(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月));
        ServiceRiyohyoBeppyoPrintService printService = new ServiceRiyohyoBeppyoPrintService();
        return printService.printSingle(param);
    }

}
