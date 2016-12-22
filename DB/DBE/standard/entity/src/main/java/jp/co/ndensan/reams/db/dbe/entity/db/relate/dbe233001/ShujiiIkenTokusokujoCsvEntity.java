/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書督促対象者一覧表Csvを定義したEntityクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShujiiIkenTokusokujoCsvEntity {

    @CsvField(order = 1, name = "No")
    private final RString no;

    @CsvField(order = 3, name = "市町村コード")
    private final RString cityCode;

    @CsvField(order = 4, name = "市町村名称")
    private final RString cityName;

    @CsvField(order = 6, name = "保険者")
    private final RString hokenshaName;

    @CsvField(order = 7, name = "被保険者番号")
    private final RString hihokenshaNo;

    @CsvField(order = 8, name = "被保険者氏名カナ")
    private final RString hihokenshaKanaName;

    @CsvField(order = 9, name = "被保険者氏名")
    private final RString hihokenshaName;

    @CsvField(order = 10, name = "申請日")
    private final RString shinseiYMD;

    @CsvField(order = 11, name = "督促状発行日")
    private final RString tokusokujoHakkoYMD;

    @CsvField(order = 12, name = "事業者コード")
    private final RString kikanCode;

    @CsvField(order = 13, name = "事業者名称")
    private final RString kikanName;

    @CsvField(order = 14, name = "事業者住所")
    private final RString kikanJusho;

    @CsvField(order = 15, name = "事業者電話番号")
    private final RString kikanTel;

    @CsvField(order = 16, name = "主治医氏名")
    private final RString shujiiName;

    /**
     * コンストラクタです。
     *
     * @param cityCode 市町村コード
     * @param cityName 市町村名称
     * @param no No
     * @param hokenshaName 保険者
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaKanaName 被保険者氏名カナ
     * @param hihokenshaName 被保険者氏名
     * @param shinseiYMD 申請日
     * @param tokusokujoHakkoYMD 督促状発行日
     * @param kikanCode 事業者コード
     * @param kikanName 事業者名称
     * @param kikanJusho 事業者住所
     * @param kikanTel 事業者電話番号
     * @param shujiiName 主治医氏名
     */
    public ShujiiIkenTokusokujoCsvEntity(RString cityCode,
            RString cityName,
            RString no,
            RString hokenshaName,
            RString hihokenshaNo,
            RString hihokenshaKanaName,
            RString hihokenshaName,
            RString shinseiYMD,
            RString tokusokujoHakkoYMD,
            RString kikanCode,
            RString kikanName,
            RString kikanJusho,
            RString kikanTel,
            RString shujiiName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.no = no;
        this.hokenshaName = hokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaKanaName = hihokenshaKanaName;
        this.hihokenshaName = hihokenshaName;
        this.shinseiYMD = shinseiYMD;
        this.tokusokujoHakkoYMD = tokusokujoHakkoYMD;
        this.kikanCode = kikanCode;
        this.kikanName = kikanName;
        this.kikanJusho = kikanJusho;
        this.kikanTel = kikanTel;
        this.shujiiName = shujiiName;
    }
}
