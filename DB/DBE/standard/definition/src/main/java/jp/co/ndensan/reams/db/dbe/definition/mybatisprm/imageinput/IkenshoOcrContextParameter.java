/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
@lombok.Value
public class IkenshoOcrContextParameter {

    private final RString 申請書管理番号;
    private final RString 主治医医療機関コード;
    private final RString 主治医コード;
}
