/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LDNS lijunjun
 */
@Getter
@Setter
public class GeifuEntity {

    ShikibetsuCode shikibetsuCode;
    RString shoKisaiHokenshaNo;
    FlexibleYearMonth shinsaYM;
    RString kyufuSakuseiKubunCode;
}
