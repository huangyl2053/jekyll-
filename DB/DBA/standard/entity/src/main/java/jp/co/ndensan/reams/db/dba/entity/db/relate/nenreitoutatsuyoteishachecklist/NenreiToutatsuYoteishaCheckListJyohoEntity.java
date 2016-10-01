/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitoutatsuyoteishachecklist;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 年齢到達予定者チェックリスト情報Entity。
 *
 * @reamsid_L DBA-0580-020 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiToutatsuYoteishaCheckListJyohoEntity {

    private RString 市町村コード;
    private RString 市町村名;
    private List<RString> 並び順;
    private List<RString> 改頁;
    private boolean 項目名付加フラグ;
    private boolean 連番付加フラグ;
    private boolean 日付編集フラグ;
    private List<NenreiToutatsuYoteishaCheckListEntity> 年齢到達予定者チェックリスト;
    private RString 抽出期間From;
    private RString 抽出期間To;
    private RString 出力対象;
    private RString 住民種別;

}
