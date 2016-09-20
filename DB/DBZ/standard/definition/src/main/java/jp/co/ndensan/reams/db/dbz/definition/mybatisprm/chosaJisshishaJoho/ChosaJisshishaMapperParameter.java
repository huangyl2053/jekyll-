/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chosaJisshishaJoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果登録1を特定するためのMyBatis用パラメータクラスです。
 * @reamsid_L DBE-0040-010 jiangqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaJisshishaMapperParameter {
    private RString shinseishoKanriNo;
    private RString ninteiChosaItakusakiCode;  
}
