/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaOutputPersonalDataEntity implements IDbAccessable {

    private RString 申請書管理番号;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
}
