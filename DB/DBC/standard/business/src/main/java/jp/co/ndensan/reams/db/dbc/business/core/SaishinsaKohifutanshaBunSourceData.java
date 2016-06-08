/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査決定通知書情報取込一覧表帳票用ソースデータ
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKohifutanshaBunSourceData {

    private RString 印刷日時;
    private RString ページ数;
    private RString 処理年月;
    private RString 国保連合会名;
    private RString 審査委員会名;
    private RString 公費負担者番号;
    private RString 公費負担者名;
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
    private RString no;
    private RString 取扱年月;
    private RString 事業者番号;
    private RString 事業者名;
    private RString サービス提供年月;
    private RString サービス種類コード;
    private RString サービス種類名;
    private RString 再審査結果コード;
    private RString 当初請求単位数;
    private RString 申立単位数;
    private RString 調整単位数;
    private RString 被保険者番号;
    private RString 被保険者名;
    private RString 申立事由コード;
    private RString 申立事由;
    private RString 再審査結果;
    private RString 原番単位数;
    private RString 決定単位数;
    private RString 公費負担額;
    private RString 再審査申立タイトル;
    private RString 再審査決定タイトル;
    private RString 調整タイトル;
    private RString 件数タイトル1;
    private RString 単位数タイトル1;
    private RString 公費負担額タイトル1;
    private RString 件数タイトル2;
    private RString 単位数タイトル2;
    private RString 公費負担額タイトル2;
    private RString 件数タイトル3;
    private RString 単位数タイトル3;
    private RString 公費負担額タイトル3;
    private RString 介護給付費タイトル;
    private RString 高額介護サービス費タイトル;

    private RString 介護給付費請求件数;
    private RString 介護給付費決定件数;
    private RString 介護給付費調整件数;
    private RString 介護給付費請求単位数;
    private RString 介護給付費決定単位数;
    private RString 介護給付費調整単位数;
    private RString 介護給付費請求公費負担額;
    private RString 介護給付費決定公費負担額;
    private RString 介護給付費調整公費負担額;
    private RString 高額介護サービス費請求件数;
    private RString 高額介護サービス費決定件数;
    private RString 高額介護サービス費調整件数;
    private RString 高額介護サービス費請求公費負担額;
    private RString 高額介護サービス費決定公費負担額;
    private RString 高額介護サービス費調整公費負担額;
    private RString 高額介護サービス費請求単位数;
    private RString 高額介護サービス費決定単位数;
    private RString 高額介護サービス費調整単位数;
}
