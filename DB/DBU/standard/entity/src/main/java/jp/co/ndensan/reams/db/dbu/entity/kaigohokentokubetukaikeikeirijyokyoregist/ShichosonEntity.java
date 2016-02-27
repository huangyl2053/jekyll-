/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist;

import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 市町村のエンティティです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonEntity {

    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private ShoKisaiHokenshaNo 保険者コード;
    private TokeiTaishoKubun 保険者区分;

    public ShichosonEntity(LasdecCode 市町村コード, RString 市町村名称, ShoKisaiHokenshaNo 保険者コード, TokeiTaishoKubun 保険者区分) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.保険者コード = 保険者コード;
        this.保険者区分 = 保険者区分;
    }

}
