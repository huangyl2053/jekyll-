/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.kogakugassan;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算キー
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanNendoKey {

    private RString 整理番号;
    private RString 支給申請書整理番号;
    private int 履歴番号;

}
