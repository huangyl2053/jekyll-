/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 世帯員把握入力高額一時検索用Entityです。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiinHaakuNyuryokuEntity implements Serializable {

    private DbT3017KyufujissekiKihonEntity 給付実績基本情報高額一時;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
}
