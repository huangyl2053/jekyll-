/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanrenrakuhyooutputreport;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 帳票出力のエンティティクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanRenrakuhyoOutputReportEntity extends DbTableEntityBase<ShokanRenrakuhyoOutputReportEntity> implements IDbAccessable {

    private DbWT2111ShokanShinseiTempEntity 償還払支給申請一時TBL;
    private DbWT1001HihokenshaTempEntity 被保険者一時TBL;
    private JigyoshaNo 基本_事業者番号;
    private RString 基本_様式番号;
    private RString 識別番号_略称;

}
