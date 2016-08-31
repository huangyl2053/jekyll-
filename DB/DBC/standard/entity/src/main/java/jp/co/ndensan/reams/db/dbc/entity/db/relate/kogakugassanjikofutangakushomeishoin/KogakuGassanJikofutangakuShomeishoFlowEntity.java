/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算自己負担額情報取込共通処理（ファイル読込）のflowEntity
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuShomeishoFlowEntity {

    private FlexibleYearMonth shoriYM;
    private int codeNum;
    private int 連番;
    private int 高額合算自己負担額一時TBL登録件数;
}
