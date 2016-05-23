/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績編集汎用Entityのクラス
 *
 * @reamsid_L DBC-0992-170 lijunjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GeifuEntity {

    private ShikibetsuCode shikibetsuCode;
    private HokenshaNo shoKisaiHokenshaNo;
    private FlexibleYearMonth shinsaYM;
    private RString kyufuSakuseiKubunCode;
}
