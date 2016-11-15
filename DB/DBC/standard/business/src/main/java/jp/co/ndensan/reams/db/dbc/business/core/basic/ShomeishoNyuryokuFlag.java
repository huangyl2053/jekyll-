/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証明書入力済フラグのクラスです。
 *
 * @reamsid_L DBC-1030-180 zhuxj2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShomeishoNyuryokuFlag {

    private RString サービス計画費_証明書入力済フラグ;
    private RString 基本情報_証明書入力済フラグ;
    private RString 給付費明細住特_証明書入力済フラグ;
    private RString 給付費明細_証明書入力済フラグ;
    private RString 緊急時所定疾患_証明書入力済フラグ;
    private RString 緊急時施設療養費_証明書入力済フラグ;
    private RString 社福軽減額_証明書入力済フラグ;
    private RString 食事費用_証明書入力済フラグ;
    private RString 請求額集計_証明書入力済フラグ;
    private RString 特定診療費_証明書入力済フラグ;
    private RString 特定入所者費用_証明書入力済フラグ;
}
