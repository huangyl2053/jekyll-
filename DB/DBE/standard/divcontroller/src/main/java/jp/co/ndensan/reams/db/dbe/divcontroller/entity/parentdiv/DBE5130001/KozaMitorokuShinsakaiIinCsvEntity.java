/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座情報未登録審査会委員一覧出力用CSVEntityクラスです。
 *
 * @author N2512
 */
public class KozaMitorokuShinsakaiIinCsvEntity {

    @CsvField(order = 10, name = "介護認定審査会委員コード")
    private final RString shinsakaiIinCode;
    @CsvField(order = 20, name = "介護認定審査会委員開始年月日")
    private final RString shinsakaiIinStYMD;
    @CsvField(order = 30, name = "介護認定審査会委員終了年月日")
    private final RString shinsakaiIinEdYMD;
    @CsvField(order = 40, name = "介護認定審査会委員氏名")
    private final RString shisakaiIinShimei;
    @CsvField(order = 50, name = "介護認定審査会委員氏名カナ")
    private final RString shinsakaiIinShimeiKana;
    @CsvField(order = 60, name = "性別")
    private final RString seibetsu;
    @CsvField(order = 70, name = "生年月日")
    private final RString BarthYMD;
    @CsvField(order = 80, name = "介護認定審査員資格コード")
    private final RString shinsainShikakuCode;
    @CsvField(order = 90, name = "介護認定審査員資格")
    private final RString shinsainShikaku;
    @CsvField(order = 100, name = "状況")
    private final RString jokyo;
    @CsvField(order = 110, name = "備考")
    private final RString biko;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiIinCode 介護認定審査会委員コード
     * @param shinsakaiIinStYMD 介護認定審査会委員開始年月日
     * @param shinsakaiIinEdYMD 介護認定審査会委員終了年月日
     * @param shisakaiIinShimei 介護認定審査会委員氏名
     * @param shinsakaiIinShimeiKana 介護認定審査会委員氏名カナ
     * @param seibetsu 性別
     * @param BarthYMD 生年月日
     * @param shinsainShikakuCode 介護認定審査員資格コード
     * @param shinsainShikaku 介護認定審査員資格
     * @param jokyo 状況
     * @param biko 備考
     */
    public KozaMitorokuShinsakaiIinCsvEntity(
            RString shinsakaiIinCode,
            RString shinsakaiIinStYMD,
            RString shinsakaiIinEdYMD,
            RString shisakaiIinShimei,
            RString shinsakaiIinShimeiKana,
            RString seibetsu,
            RString BarthYMD,
            RString shinsainShikakuCode,
            RString shinsainShikaku,
            RString jokyo,
            RString biko) {
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shinsakaiIinStYMD = shinsakaiIinStYMD;
        this.shinsakaiIinEdYMD = shinsakaiIinEdYMD;
        this.shisakaiIinShimei = shisakaiIinShimei;
        this.shinsakaiIinShimeiKana = shinsakaiIinShimeiKana;
        this.seibetsu = seibetsu;
        this.BarthYMD = BarthYMD;
        this.shinsainShikakuCode = shinsainShikakuCode;
        this.shinsainShikaku = shinsainShikaku;
        this.jokyo = jokyo;
        this.biko = biko;
    }

}
