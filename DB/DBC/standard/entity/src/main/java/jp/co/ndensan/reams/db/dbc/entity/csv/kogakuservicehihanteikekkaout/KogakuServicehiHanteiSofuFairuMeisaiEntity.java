/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakuservicehihanteikekkaout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費給付判定結果情報作成のデータレコードです。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiHanteiSofuFairuMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 70, name = "受付年月日")
    private RString 受付年月日;
    @CsvField(order = 80, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 90, name = "本人支払額")
    private RString 本人支払額;
    @CsvField(order = 100, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 110, name = "支給金額")
    private RString 支給金額;
    @CsvField(order = 120, name = "不支給理由")
    private RString 不支給理由;
    @CsvField(order = 130, name = "支払方法区分コード")
    private RString 支払方法区分コード;
    @CsvField(order = 140, name = "窓口払・支払場所")
    private RString 窓口払_支払場所;
    @CsvField(order = 150, name = "窓口払・支払期間・開始年月日")
    private RString 窓口払_支払期間_開始年月日;
    @CsvField(order = 160, name = "窓口払・支払期間・終了年月日")
    private RString 窓口払_支払期間_終了年月日;
    @CsvField(order = 170, name = "窓口払・支払期間・開始曜日")
    private RString 窓口払_支払期間_開始曜日;
    @CsvField(order = 180, name = "窓口払・支払期間・終了曜日")
    private RString 窓口払_支払期間_終了曜日;
    @CsvField(order = 190, name = "窓口払・支払期間・開始時間")
    private RString 窓口払_支払期間_開始時間;
    @CsvField(order = 200, name = "窓口払・支払期間・終了時間")
    private RString 窓口払_支払期間_終了時間;
    @CsvField(order = 210, name = "口座払・金融機関コード")
    private RString 口座払_金融機関コード;
    @CsvField(order = 220, name = "口座払・金融機関支店コード")
    private RString 口座払_金融機関支店コード;
    @CsvField(order = 230, name = "口座払・口座種目")
    private RString 口座払_口座種目;
    @CsvField(order = 240, name = "口座払・口座番号")
    private RString 口座払_口座番号;
    @CsvField(order = 250, name = "口座払・口座名義人（カナ）")
    private RString 口座払_口座名義人_カナ;
    @CsvField(order = 260, name = "審査方法区分コード")
    private RString 審査方法区分コード;

}
