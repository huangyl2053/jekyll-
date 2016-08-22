/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携パターン情報が取得です。
 *
 * @reamsid_L DBU-0350-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class RendoPatternEntity {

    private RString sakiFormatVersion;
    private RString sakiEncodeKeitai;
    private RString codeHenkanKubun;
    private RString renkeiFileName;
}
