package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * サービス提供年月時点で直近の被保険者台帳管理データです。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaKanriDataEntity implements Serializable {

    private DbWT0001HihokenshaTempEntity temp;
    private DbT1001HihokenshaDaichoEntity daicho;
}
