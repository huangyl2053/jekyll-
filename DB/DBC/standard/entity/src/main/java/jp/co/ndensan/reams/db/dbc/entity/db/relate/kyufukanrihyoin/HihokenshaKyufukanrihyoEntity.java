package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoTempEntity;

/**
 * 給付管理票一時TBLのデータのうち、交換情報識別番号＝1121/1122のデータ
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaKyufukanrihyoEntity {

    private DbWT0001HihokenshaTempEntity 被保険者;
    private DbWT1121KyufuKanrihyoTempEntity 給付管理票;

}
