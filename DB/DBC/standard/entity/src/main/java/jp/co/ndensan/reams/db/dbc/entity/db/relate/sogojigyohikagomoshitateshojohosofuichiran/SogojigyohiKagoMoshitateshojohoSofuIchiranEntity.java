/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;

/**
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表 のEntityクラスです。
 *
 * @reamsid_L DBC-2530-042 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiKagoMoshitateshojohoSofuIchiranEntity {

    private DbWT1731KagoMoshitateTempEntity 過誤申立一時TBL;
    private DbWT1001HihokenshaTempEntity 被保険者一時TBL;
}
