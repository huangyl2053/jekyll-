/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;

/**
 * 証明書変更済フラグのクラスです。
 *
 * @reamsid_L DBC-1030-010 chenxt
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShomeishoHenkoFlag implements Serializable {

    private ShomeishoHenkoKubunType サービス計画費_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 基本情報_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 給付費明細住特_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 給付費明細_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 緊急時所定疾患_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 緊急時施設療養費_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 社福軽減額_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 食事費用_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 請求額集計_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 特定診療費_証明書変更済フラグ;
    private ShomeishoHenkoKubunType 特定入所者費用_証明書変更済フラグ;
}
