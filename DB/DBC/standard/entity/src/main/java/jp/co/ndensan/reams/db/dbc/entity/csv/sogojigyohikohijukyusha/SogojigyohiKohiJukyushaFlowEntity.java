/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護予防・日常生活支援総合事業費公費受給者別一覧表情報取込CSVファイルレコード構成Entity
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiKohiJukyushaFlowEntity {

    private FlexibleYearMonth shoriYM;
    private int codeNum;
    private int 集計データ登録件数;
    private int 明細データ登録件数;
    private int 連番;
    private int 履歴番号;
}
