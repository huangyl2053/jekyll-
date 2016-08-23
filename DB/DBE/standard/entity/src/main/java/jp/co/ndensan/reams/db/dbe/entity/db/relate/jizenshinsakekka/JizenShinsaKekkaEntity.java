/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
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
public class JizenShinsaKekkaEntity implements IJizenShinsaKekkaCsvEucEntity {

    @CsvField(order = 1, name = "介護認定審査会開催予定年月日")
    private final FlexibleDate 介護認定審査会開催予定年月日;
    @CsvField(order = 2, name = "介護認定審査会開催場所名称")
    private final RString 介護認定審査会開催場所名称;
    @CsvField(order = 3, name = "介護認定審査会開始予定時刻")
    private final RString 介護認定審査会開始予定時刻;
    @CsvField(order = 4, name = "介護認定審査会資料作成年月日")
    private final FlexibleDate 介護認定審査会資料作成年月日;
    @CsvField(order = 5, name = "合議体番号")
    private final int 合議体番号;
    @CsvField(order = 6, name = "合議体名称")
    private final RString 合議体名称;
    @CsvField(order = 7, name = "介護認定審査会予定定員")
    private final int 介護認定審査会予定定員;
    @CsvField(order = 8, name = "介護認定審査会割当済み人数")
    private final int 介護認定審査会割当済み人数;

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
    public JizenShinsaKekkaEntity(
            FlexibleDate 介護認定審査会開催予定年月日,
            RString 介護認定審査会開催場所名称,
            RString 介護認定審査会開始予定時刻,
            FlexibleDate 介護認定審査会資料作成年月日,
            int 合議体番号,
            RString 合議体名称,
            int 介護認定審査会予定定員,
            int 介護認定審査会割当済み人数
    ) {
        this.介護認定審査会開催予定年月日 = 介護認定審査会開催予定年月日;
        this.介護認定審査会開催場所名称 = 介護認定審査会開催場所名称;
        this.介護認定審査会開始予定時刻 = 介護認定審査会開始予定時刻;
        this.介護認定審査会資料作成年月日 = 介護認定審査会資料作成年月日;
        this.合議体番号 = 合議体番号;
        this.合議体名称 = 合議体名称;
        this.介護認定審査会予定定員 = 介護認定審査会予定定員;
        this.介護認定審査会割当済み人数 = 介護認定審査会割当済み人数;
    }
}
