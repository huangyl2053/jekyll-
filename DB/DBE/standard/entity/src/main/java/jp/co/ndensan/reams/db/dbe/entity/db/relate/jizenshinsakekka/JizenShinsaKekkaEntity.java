/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka;

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
public class JizenShinsaKekkaEntity {

    private RString 介護認定審査会開催予定年月日;
    private RString 介護認定審査会開催場所名称;
    private RString 介護認定審査会開始予定時刻;
    private RString 介護認定審査会資料作成年月日;
    private RString 合議体番号;
    private RString 合議体名称;
    private RString 介護認定審査会予定定員;
    private RString 介護認定審査会割当済み人数;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催予定年月日 介護認定審査会開催予定年月日
     * @param 介護認定審査会開催場所名称 介護認定審査会開催場所名称
     * @param 介護認定審査会開始予定時刻 介護認定審査会開始予定時刻
     * @param 介護認定審査会資料作成年月日 介護認定審査会資料作成年月日
     * @param 合議体番号 合議体番号
     * @param 合議体名称 合議体名称
     * @param 介護認定審査会予定定員 介護認定審査会予定定員
     * @param 介護認定審査会割当済み人数 介護認定審査会割当済み人数
     */
    public JizenShinsaKekkaEntity(RString 介護認定審査会開催予定年月日,
            RString 介護認定審査会開催場所名称,
            RString 介護認定審査会開始予定時刻,
            RString 介護認定審査会資料作成年月日,
            RString 合議体番号,
            RString 合議体名称,
            RString 介護認定審査会予定定員,
            RString 介護認定審査会割当済み人数) {
        介護認定審査会開催予定年月日 = this.介護認定審査会開催予定年月日;
        介護認定審査会開催場所名称 = this.介護認定審査会開催場所名称;
        介護認定審査会開始予定時刻 = this.介護認定審査会開始予定時刻;
        介護認定審査会資料作成年月日 = this.介護認定審査会資料作成年月日;
        合議体番号 = this.合議体番号;
        合議体名称 = this.合議体名称;
        介護認定審査会予定定員 = this.介護認定審査会予定定員;
        介護認定審査会割当済み人数 = this.介護認定審査会割当済み人数;
    }
}
