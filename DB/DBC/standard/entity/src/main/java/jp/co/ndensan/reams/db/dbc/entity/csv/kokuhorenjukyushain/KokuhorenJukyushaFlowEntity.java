/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 国保連保有受給者情報取込CSVファイルレコード構成Entity
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenJukyushaFlowEntity {

    private FlexibleYearMonth shoriYM;
    private int codeNum;
    private int 集計データ登録件数;
    private int 明細データ登録件数;
    private int 連番;

}
