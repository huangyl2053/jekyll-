/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic.tokkijiko;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特記事項入力のModelクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokkiJikoModel implements Serializable {

    private RString shinseishoKanriNo;
    private RString ikenshoIraiRirekiNo;
    private RString 特記事項モード;
    private RString イメージモード;
    private RString テキスト;
    private RString イメージ;
}
