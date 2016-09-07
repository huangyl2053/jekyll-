/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.serviceriyohyobeppyo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiRiyoNissuResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TeikyohyoBeppyoEntityResult;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 帳票設計_DBC0150011_1_サービス提供票別表のParameterクラスです。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceRiyohyoBeppyoParameter {

    private Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 帳票情報マップ;
    private KyufuJikoSakuseiEntityResult 合計情報;
    private TeikyohyoBeppyoEntityResult 帳票ヘッダー;
    private FlexibleDate 作成日時;
    private FlexibleYearMonth 利用年月;
    private List<ServiceTypeTotal> 種類別支給限度情報;
    private List<TankiRiyoNissuResult> 短期入所情報;
}
