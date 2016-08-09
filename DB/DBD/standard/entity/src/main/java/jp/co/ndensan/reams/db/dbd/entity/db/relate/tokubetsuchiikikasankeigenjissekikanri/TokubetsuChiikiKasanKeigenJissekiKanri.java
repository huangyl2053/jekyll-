/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別地域加算軽減実績管理リストEntityクラスです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class TokubetsuChiikiKasanKeigenJissekiKanri {

    private JigyoshaNo 事業者番号;
    private RString 事業者名称;
    private List<KyuhuJissekiHihokensha> 給付実績被保険者リスト;
}
