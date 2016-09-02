/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査対象entity
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SaikaiObjectOutPutEntity {

    private RString 申請書管理番号;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RDateTime イメージ共有ファイルID;
}
