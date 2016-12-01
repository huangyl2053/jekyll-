/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeishotoroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業分自己負担額証明書登録（単）用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikofutangakuShomeishoTorokuParameter {

    private RString 被保険者番号;
    private RString 対象年度;
    private RString 支給申請書整理番号;
    private RString 証記載保険者番号;
    private RString 転入前保険者番号;
    private int 履歴番号;
    private boolean use支給申請書整理番号;
    private RString システム日付;
}
