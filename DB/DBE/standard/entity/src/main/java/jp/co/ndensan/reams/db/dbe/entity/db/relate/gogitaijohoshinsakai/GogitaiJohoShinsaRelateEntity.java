/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 合議体情報と介護認定審査会委員情報のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoShinsaRelateEntity {

    private int 合議体番号;
    private RString 合議体名称;
    private boolean 合議体精神科医存在フラグ;
    private RString 介護認定審査会委員氏名;
    private RString 介護認定審査会開催場所コード;
    private int 介護認定審査会予定定員;
    private int 介護認定審査会自動割当定員;
    private int 介護認定審査会委員定員;
    private FlexibleDate 介護認定審査会開催予定年月日;
    private RString 介護認定審査会開始予定時刻;
    private RString 介護認定審査会終了予定時刻;
}
