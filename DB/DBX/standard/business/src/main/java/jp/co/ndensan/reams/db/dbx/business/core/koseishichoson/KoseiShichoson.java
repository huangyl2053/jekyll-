/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.koseishichoson;

import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村のエンティティです。
 */
@lombok.Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiShichoson {

    private LasdecCode shichosonCode;
    private ShichosonShikibetsuID shichosonShokibetsuID;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString shichosonMeisho;
}
