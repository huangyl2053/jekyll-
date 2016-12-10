/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteiinput;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBZ.NinteiInput_認定情報のdDataPassModelです。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiInputDataPassModel implements Serializable {

    private RString 認定区分;
    private List<RString> みなし更新認定;
    private RDate 認定年月日;
    private RString 要介護度コード;
    private RString 要介護度名称;
    private RDate 有効開始年月日;
    private RDate 有効終了年月日;
    private RString 審査会意見;
    private ShinseishoKanriNo 申請書管理番号;
    private RString subGyomuCode;
    private RString 厚労省IFコード;
    private List<RString> サービス一覧リスト;
}
