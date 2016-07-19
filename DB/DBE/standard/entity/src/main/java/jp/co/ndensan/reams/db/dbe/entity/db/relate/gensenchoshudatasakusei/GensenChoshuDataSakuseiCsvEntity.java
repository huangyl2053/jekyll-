/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gensenchoshudatasakusei;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 源泉徴収データ作成CSVを定義したEntityクラスです。
 *
 * @reamsid_L DBE-2000-020 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class GensenChoshuDataSakuseiCsvEntity implements IGensenChoshuCsvEucEntity {

    @CsvField(order = 1, name = "審査員コード")
    private final RString 審査員コード;
    @CsvField(order = 2, name = "審査員名")
    private final AtenaMeisho 審査員名;
    @CsvField(order = 3, name = "職種")
    private final RString 職種;
    @CsvField(order = 4, name = "所属機関")
    private final RString 所属機関;
    @CsvField(order = 5, name = "郵便番号")
    private final YubinNo 郵便番号;
    @CsvField(order = 6, name = "住所")
    private final AtenaJusho 住所;
    @CsvField(order = 7, name = "電話番号")
    private final TelNo 電話番号;
    @CsvField(order = 8, name = "FAX番号")
    private final TelNo 番号_FAX;
    @CsvField(order = 9, name = "生年月日")
    private final FillTypeFormatted 生年月日;
    @CsvField(order = 10, name = "年齢")
    private final int 年齢;
    @CsvField(order = 11, name = "認定審査会報酬合計")
    private final int 認定審査会報酬合計;
    @CsvField(order = 12, name = "その他随時報酬合計")
    private final int その他随時報酬合計;
    @CsvField(order = 13, name = "認定審査交通費等合計")
    private final int 認定審査交通費等合計;
    @CsvField(order = 14, name = "源泉徴収額")
    private final int 源泉徴収額;
    @CsvField(order = 15, name = "合計")
    private final int 合計;

    /**
     * コンストラクタです。
     *
     * @param 審査員コード 審査員コード
     * @param 審査員名 審査員名
     * @param 職種 職種
     * @param 所属機関 所属機関
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param 番号_FAX FAX番号
     * @param 生年月日 生年月日
     * @param 年齢 年齢
     * @param 認定審査会報酬合計 認定審査会報酬合計
     * @param その他随時報酬合計 その他随時報酬合計
     * @param 認定審査交通費等合計 認定審査交通費等合計
     * @param 源泉徴収額 源泉徴収額
     * @param 合計 合計
     */
    public GensenChoshuDataSakuseiCsvEntity(RString 審査員コード, AtenaMeisho 審査員名, RString 職種, RString 所属機関,
            YubinNo 郵便番号, AtenaJusho 住所, TelNo 電話番号, TelNo 番号_FAX, FillTypeFormatted 生年月日, int 年齢, int 認定審査会報酬合計,
            int その他随時報酬合計, int 認定審査交通費等合計, int 源泉徴収額, int 合計) {
        this.審査員コード = 審査員コード;
        this.審査員名 = 審査員名;
        this.職種 = 職種;
        this.所属機関 = 所属機関;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.電話番号 = 電話番号;
        this.番号_FAX = 番号_FAX;
        this.生年月日 = 生年月日;
        this.年齢 = 年齢;
        this.認定審査会報酬合計 = 認定審査会報酬合計;
        this.その他随時報酬合計 = その他随時報酬合計;
        this.認定審査交通費等合計 = 認定審査交通費等合計;
        this.源泉徴収額 = 源泉徴収額;
        this.合計 = 合計;
    }
}
