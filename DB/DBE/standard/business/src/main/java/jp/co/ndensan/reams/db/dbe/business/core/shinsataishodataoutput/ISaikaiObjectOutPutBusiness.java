/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @reamsid_L DBA-1230-010 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ISaikaiObjectOutPutBusiness implements Serializable {

    private RString 申請書管理番号;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RDateTime イメージ共有ファイルID;

    /**
     * コンストラクタです。
     */
    public ISaikaiObjectOutPutBusiness() {
    }
}
