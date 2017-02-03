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
 * 調査実施者情報の親画面から受け取ったパラメータです。
 *
 * @reamsid_L DBE-3000-100 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaJisshishaJohoModel {

    private RString 認定申請日;
    private RString 調査実施日;
    private RString 調査実施場所;
    private RString 実施場所名称;
    private RString 所属機関コード;
    private RString 所属機関名称;
    private RString 記入者コード;
    private RString 記入者名称;
    private RString 調査区分;
    private RString 申請書管理番号;
    private int 認定調査依頼履歴番号;

}
