/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 給付実績基本抽出02のデータを抽出するのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsSetaiinHaakuNyuryokuKogakuTmpEntity1
        extends DbTableEntityBase<InsSetaiinHaakuNyuryokuKogakuTmpEntity1> implements IDbAccessable {

    private DbT3017KyufujissekiKihonEntity 給付実績基本情報高額一時３;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;

}
