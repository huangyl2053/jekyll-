/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import lombok.Getter;

/**
 * 認定調査督促対象者一覧表Csvを定義したEntityクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity {

    @CsvField(order = 3, name = "市町村コード")
    private RString cityCode;

    @CsvField(order = 4, name = "市町村名称")
    private RString cityName;

    @CsvField(order = 5, name = "No")
    private RString no;

    @CsvField(order = 6, name = "保険者")
    private RString hokenshaName;

    @CsvField(order = 7, name = "被保険者番号")
    private RString hihokenshaNo;

    @CsvField(order = 8, name = "被保険者氏名カナ")
    private RString hihokenshaKanaName;

    @CsvField(order = 9, name = "被保険者氏名")
    private RString hihokenshaName;

    @CsvField(order = 10, name = "申請日")
    private RString shinseiYMD;

    @CsvField(order = 11, name = "督促状発行日")
    private RString tokusokujoHakkoYMD;

    @CsvField(order = 12, name = "事業者コード")
    private RString jigyoshaCode;

    @CsvField(order = 13, name = "事業者名称")
    private RString kikanName;

    @CsvField(order = 14, name = "調査員氏名")
    private RString chosainShime;

    @CsvField(order = 15, name = "事業者住所")
    private RString kikanJusho;

    @CsvField(order = 16, name = "事業者電話番号")
    private RString kikanTel;

    /**
     * コンストラクタです。
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity() {
    }

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
     * @param jigyoshaCode 事業者コード
     * @param kikanName 事業者名称
     * @param chosainShime 調査員氏名
     * @param kikanJusho 事業者住所
     * @param kikanTel 事業者電話番号
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity(RString cityCode,
            RString cityName,
            RString no,
            RString hokenshaName,
            RString hihokenshaNo,
            RString hihokenshaKanaName,
            RString hihokenshaName,
            RString shinseiYMD,
            RString tokusokujoHakkoYMD,
            RString jigyoshaCode,
            RString kikanName,
            RString chosainShime,
            RString kikanJusho,
            RString kikanTel) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.no = no;
        this.hokenshaName = hokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaKanaName = hihokenshaKanaName;
        this.hihokenshaName = hihokenshaName;
        this.shinseiYMD = shinseiYMD;
        this.tokusokujoHakkoYMD = tokusokujoHakkoYMD;
        this.jigyoshaCode = jigyoshaCode;
        this.kikanName = kikanName;
        this.chosainShime = chosainShime;
        this.kikanJusho = kikanJusho;
        this.kikanTel = kikanTel;
    }

    /**
     * CSVデータを作成します
     *
     * @param entity 認定調査督促対象者一覧表の取得のEntity
     * @return CSVデータ
     */
    public static NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity createCsvEntity(NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity entity) {
        NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity csvEntity = new NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity();
        csvEntity.cityCode = entity.getTemp_市町村コード() == null ? RString.EMPTY : entity.getTemp_市町村コード().getColumnValue();
        csvEntity.cityName = entity.getTemp_市町村名称();
        csvEntity.no = new RString(String.valueOf(entity.get行番号()));
        csvEntity.hokenshaName = entity.getTemp_保険者名称();
        csvEntity.hihokenshaNo = entity.getTemp_被保険者番号();
        csvEntity.hihokenshaKanaName = entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue();
        csvEntity.hihokenshaName = entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue();
        csvEntity.shinseiYMD = entity.getTemp_申請日() == null ? RString.EMPTY : entity.getTemp_申請日().wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        csvEntity.tokusokujoHakkoYMD = entity.getTemp_督促状発行日() == null ? RString.EMPTY : entity.getTemp_督促状発行日().wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        csvEntity.jigyoshaCode = entity.getTemp_事業者コード() == null ? RString.EMPTY : entity.getTemp_事業者コード().getColumnValue();
        csvEntity.kikanName = entity.getTemp_事業者名称() == null ? RString.EMPTY : entity.getTemp_事業者名称();
        csvEntity.chosainShime = entity.getTemp_調査員氏名();
        csvEntity.kikanJusho = entity.getTemp_事業者住所();
        csvEntity.kikanTel = entity.getTemp_事業者電話番号() == null ? RString.EMPTY : entity.getTemp_事業者電話番号().getColumnValue();
        return csvEntity;

    }
}
