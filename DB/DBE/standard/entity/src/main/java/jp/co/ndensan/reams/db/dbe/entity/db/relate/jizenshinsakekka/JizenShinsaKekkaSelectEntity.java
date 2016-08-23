/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBE526002_事前審査結果登録データ作成 Builderクラスです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JizenShinsaKekkaSelectEntity {

    private FlexibleDate 介護認定審査会開催予定年月日;
    private RString 介護認定審査会開催場所名称;
    private RString 介護認定審査会開始予定時刻;
    private FlexibleDate 介護認定審査会資料作成年月日;
    private int 合議体番号;
    private RString 合議体名称;
    private int 介護認定審査会予定定員;
    private int 介護認定審査会割当済み人数;

}
