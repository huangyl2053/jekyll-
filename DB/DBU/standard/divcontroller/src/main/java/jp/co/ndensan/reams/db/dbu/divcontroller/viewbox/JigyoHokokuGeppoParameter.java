/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.viewbox;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 遷移画面と事業状況報告（月報）補正検索画面は渡す項目Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoParameter implements Serializable {

    private RString 行報告年;
    private RString 行報告月;
    private RString 行集計対象年;
    private RString 行集計対象月;
    private RString 行統計対象区分;
    private RString 行市町村コード;
    private RString 行表番号;
    private RString 行集計番号;
    private RString 行様式種類コード;
    private RString 報告年月;
    private RString 集計年月;
    private RString 市町村名称;
    private RString 保険者コード;
    private RString 選択した市町村コード;

}
