/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.euc.riyojokyotokeihyomeisailistsakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力(処理結果確認リスト)CSVを定義したEntityクラスです。
 *
 * @reamsid_L DBC-3500-030 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaKakuninListCSVEntity {

    private RString 作成日時;
    private RString 処理名;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString サービス提供年月;
    private RString 事業者番号;
    private RString 入力識別番号;
    private RString 通し番号;
    private RString サービス種類コード;
    private RString エラー内容;
    private RString 備考;

    /**
     * ファイル出力(処理結果確認リスト)CSVを定義したEntityクラスです。
     */
    public ShoriKekkaKakuninListCSVEntity() {
    }
}
