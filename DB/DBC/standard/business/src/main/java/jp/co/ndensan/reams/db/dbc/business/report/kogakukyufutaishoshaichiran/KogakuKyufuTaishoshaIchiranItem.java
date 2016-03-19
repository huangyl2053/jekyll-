/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付対象者一覧表帳票Item
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaIchiranItem {

    private RString 送付元団体名;
    private RString 保険者番号;
    private RString 保険者名称;
    private RString 並び順１;
    private RString 並び順２;
    private RString 並び順３;
    private RString 並び順４;
    private RString 並び順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString ページ番号;
    private RString 作成日時;
    private RString 通知書番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString サービス提供年月;
    private RString 事業者番号;
    private RString 事業者名;
    private RString サービス種類コード;
    private RString サービス種類名称;
    private RString サービス費用合計額;
    private RString 利用者負担額;
    private RString 算定基準額;
    private RString 支払済金額;
    private RString 高額支給額;
    private RString 資格喪失日;
    private RString 備考;

}
