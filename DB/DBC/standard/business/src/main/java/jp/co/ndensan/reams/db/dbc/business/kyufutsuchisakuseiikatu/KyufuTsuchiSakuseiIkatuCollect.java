/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.kyufutsuchisakuseiikatu;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付費通知書作成(一括)の画面コレクションクラスです。
 *
 * @reamsid_L DBC-2280-010 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuTsuchiSakuseiIkatuCollect implements Serializable {

    private RString サービス年月開始;
    private RString サービス年月終了;
    private RString 被保険者番号;
    private RString 被保険者名称;
    private RString サービス種類集約区分;
    private RString 保険者番号;
    private RString 要介護度;
    private RString サービス種類;
    private RString 抽出条件;
    private RString 発行日;
    private RString 出力順ID;
    private RString 文書番号;
    private RString 給付費通知情報序列;

}
