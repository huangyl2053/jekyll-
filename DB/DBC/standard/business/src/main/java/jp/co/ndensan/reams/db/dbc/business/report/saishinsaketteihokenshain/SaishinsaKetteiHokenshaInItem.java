/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込一覧表帳票用Item
 *
 * @reamsid_L DBC-2520-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInItem {

    private RString 帳票タイトル;
    private RString 処理年月;
    private RString 証記載保険者番号;
    private RString 証記載保険者名;
    private RString 並び順1;
    private RString 並び順2;
    private RString 並び順3;
    private RString 並び順4;
    private RString 並び順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private RString 国保連合会名;
    private RString 審査委員会名;
    private RString 作成日時;
    private RString no;
    private RString 取扱年月;
    private RString 事業所番号;
    private RString 事業所名;
    private RString 被保険者番号;
    private RString 被保険者名;
    private RString サービス提供年月;
    private RString サービス種類コード;
    private RString サービス種類名;
    private RString 申立事由コード;
    private RString 申立事由;
    private RString 再審査結果;
    private RString 当初請求単位数;
    private RString 原番単位数;
    private RString 申立単位数;
    private RString 決定単位数;
    private RString 調整単位数;
    private RString 保険者負担額;
    private RString 介護給付費請求件数;
    private RString 介護給付費決定件数;
    private RString 介護給付費調整件数;
    private RString 高額介護サービス費請求件数;
    private RString 高額介護サービス費決定件数;
    private RString 高額介護サービス費調整件数;
    private RString 介護給付費請求負担額;
    private RString 介護給付費決定負担額;
    private RString 介護給付費調整負担額;
    private RString 高額介護サービス費請求負担額;
    private RString 高額介護サービス費決定負担額;
    private RString 高額介護サービス費調整負担額;
    private RString 再審査結果コード;
    private RString 再審査申立タイトル;
    private RString 調査件数タイトル;
    private RString 調査単位数タイトル;
    private RString 調査保険者負担額タイトル;
    private RString 介護給付費タイトル;
    private RString 高額介護サービス費タイトル;
    private RString 再審査決定タイトル;
    private RString 調整タイトル;
    private RString 請求件数タイトル;
    private RString 請求単位数タイトル;
    private RString 請求保険者負担額タイトル;
    private RString 決定件数タイトル;
    private RString 決定単位数タイトル;
    private RString 決定保険者負担額タイトル;
    private RString ページ数;
    private RString 証記載保険者名タイトル;
    private RString 証記載保険者番号タイトル;
    private RString 介護給付費請求単位数;
    private RString 介護給付費決定単位数;
    private RString 介護給付費調整単位数;
    private RString 高額介護サービス費請求単位数;
    private RString 高額介護サービス費決定単位数;
    private RString 高額介護サービス費調整単位数;
    private RString 取込年月;
}
