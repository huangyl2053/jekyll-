package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求明細表情報取込共通処理（CSVファイル取込）のFlowEntityクラスです
 *
 * @reamsid_L DBC-2500-013 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FlowEntity {

    private FlexibleYearMonth shoriYM;
    private int codeNum;
    private int 明細データ登録件数;
    private int 高額データ登録件数;
    private int 合計データ登録件数;
    private int 連番数;
}
