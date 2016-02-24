/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員情報
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaInJoho {

    private RString 世帯員識別コード;
    private RString 世帯員氏名;
    private RString 世帯員性別;
    private RString 世帯員生年月日;
    private RString 世帯員続柄;
    private RString 世帯員合計取得金額;
    private RString 世帯員課税区分;

}
