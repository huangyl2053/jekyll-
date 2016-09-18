/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBC200025_償還連絡票送付一覧表のEntityクラスです
 *
 * @reamsid_L DBC-2570-040 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanRenrakuhyoSofuIchiranEntity {

    private DbWT1001HihokenshaEntity 被保険者一時TBL;
    private DbT3038ShokanKihonEntity 償還払請求基本Entity;
    private DbWT2111ShokanShinseiEntity 償還払支給申請Entity;
    private DbT3118ShikibetsuNoKanriEntity 識別番号管理Entity;

}
