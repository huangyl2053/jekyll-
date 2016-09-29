/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

//    private DbWT1001HihokenshaEntity 被保険者一時TBL;
//    private DbT3038ShokanKihonEntity 償還払請求基本Entity;
//    private DbWT2111ShokanShinseiEntity 償還払支給申請Entity;
//    private DbT3118ShikibetsuNoKanriEntity 識別番号管理Entity;
    private DbWT2111ShokanShinseiTempEntity 償還払支給申請一時TBL;
    private DbWT1001HihokenshaTempEntity 被保険者一時TBL;
    private JigyoshaNo 基本_事業者番号;
    private RString 基本_様式番号;
    private RString 識別番号_略称;
}
