/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.kaigokakushushinseishohakko;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護各種申請書発行情報リストEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKakushuShinseishoHakkoEntity {

    private RString 申請書ID;
    private RString 業務;
    private RString 申請書;
}
