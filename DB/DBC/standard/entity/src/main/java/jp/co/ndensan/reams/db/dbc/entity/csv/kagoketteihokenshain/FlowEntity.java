/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込共通処理（保険者分・ファイル読込）のflowEntity
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FlowEntity {

    private FlexibleYearMonth shoriYM;
    private int codeNum;
    private int 集計データ登録件数;
    private int 明細データ登録件数;
}
