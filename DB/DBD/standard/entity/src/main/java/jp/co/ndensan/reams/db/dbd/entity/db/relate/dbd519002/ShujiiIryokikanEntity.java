/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002;

import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報ＩＦのcsv情報。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIryokikanEntity {

    private IryoKikanCode 医療機関コード;
    private RString 医療機関名称;
    private RString 医療機関名称カナ;
    private YubinNo 郵便番号;
    private RString 住所;
    private TelNo 電話番号;
    private boolean 状況フラグ;
}
