/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 調査実施者情報の親画面から受け取ったパラメータです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaJisshishaJohoModel {
    
    private RString 調査実施日;
    private RString 調査実施場所;
    private RString 実施場所名称;
    private RString 所属機関;
    private RString 記入者;
    private RString 調査区分;
    private RString 申請書管理番号;
    
}
