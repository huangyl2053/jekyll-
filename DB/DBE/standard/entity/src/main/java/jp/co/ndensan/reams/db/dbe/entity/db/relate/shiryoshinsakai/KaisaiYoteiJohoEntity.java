/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定情報です。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaisaiYoteiJohoEntity {

    private RString 開催番号;
    private FlexibleDate 予定年月日;
    private RString 予定場所コード;
    private RString 開催場所名称;
    private RString 開始予定時刻;
    private boolean 資料作成済フラグ;
    private int 合議体番号;
    private int 予定定員;
    private int 割当済み人数;
    private RString 合議体名称;
    private FlexibleDate 資料作成年月日;
}
