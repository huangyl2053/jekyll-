/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 年齢到達予定者チェックリスト情報Entity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiToutatsuYoteishaCheckListJyohoEntity {

    private RString 市町村コード;
    private RString 市町村名;
    private RString 並び順;
    private RString 改頁;
    private boolean 項目名付加フラグ;
    private boolean 連番付加フラグ;
    private boolean 日付編集フラグ;
    private List<NenreiToutatsuYoteishaCheckListEntity> 年齢到達予定者チェックリスト;

}
