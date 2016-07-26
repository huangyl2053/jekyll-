/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.serviceriyohyobeppyo.ServiceRiyohyoBeppyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.teikyohyobeppyo.TeikyohyoBeppyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 画面設計_DBC0150011_サービス提供票別表のHandlerクラス
 *
 * @reamsid_L DBC-5110-010 xupeng
 */
public class ServiceTeikyohyoBeppyoPrintMainHandler {

    private final ServiceTeikyohyoBeppyoPrintMainDiv div;
    private static final RString 引数_被保険者番号 = new RString("被保険者番号なし");
    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_対象年月 = new RString("対象年月");
    private static final RString KEY_履歴番号 = new RString("履歴番号");
    private static final RString KEY_作成年月日 = new RString("作成年月日");
    private static final RString KEY_自己作成計画年月 = new RString("自己作成計画年月");

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
     * 画面初期化のメソッドます。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void initialize(HihokenshaNo 被保険者番号) {
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(
                    引数_被保険者番号.toString()));
        } else {
            div.getCccKaigoShiKakuKihon().initialize(被保険者番号);
        }
    }

    /**
     * 共同処理用受給者異動連絡票データ作成する。
     *
     * @param map Map<RString, Object>
     * @return 異動連絡票データ
     */
    public SourceDataCollection to帳票発行処理(Map<RString, Object> map) {
        ServiceRiyohyoBeppyoParameter param = new ServiceRiyohyoBeppyoParameter();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(map.get(KEY_被保険者番号).toString());
        FlexibleYearMonth 対象年月 = new FlexibleYearMonth(map.get(KEY_対象年月).toString());
        int 履歴番号 = Integer.parseInt(map.get(KEY_履歴番号).toString());
        FlexibleYearMonth 自己作成計画年月 = new FlexibleYearMonth(map.get(KEY_自己作成計画年月).toString());

        param.set作成日時(new FlexibleDate(map.get(KEY_作成年月日).toString()));
        param.set利用年月(自己作成計画年月);
//        TeikyohyoBeppyoManager manager = TeikyohyoBeppyoManager.createInstance();
//        KubunGendo 合計情報 = manager.get合計Entity(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月);
//        param.set合計情報(合計情報);
        param.set帳票ヘッダー(TeikyohyoBeppyoManager.createInstance().get被保険者情報(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月));
        param.set帳票情報マップ(TeikyohyoBeppyoManager.createInstance().get事業者別マップ(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月));
        param.set短期入所情報(TeikyohyoBeppyoManager.createInstance().get短期入所利用日数(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月));
        param.set種類別支給限度情報(TeikyohyoBeppyoManager.createInstance().get種類別支給限度情報(被保険者番号, 対象年月, 履歴番号, 自己作成計画年月));
        return null;
        //return KakushuTsuchishoSakusei.createInstance().publish(parameter); TODO
    }
}
