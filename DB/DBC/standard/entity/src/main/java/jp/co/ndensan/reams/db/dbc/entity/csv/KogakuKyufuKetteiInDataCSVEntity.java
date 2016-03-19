/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費決定情報一時TBLのcsv項目定義クラスです
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiInDataCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString kokanJohoShikibetsuNo;
    @CsvField(order = 20, name = "帳票レコード種別ヘッダ")
    private RString chohyoRecordShubetsuHeader;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;
    @CsvField(order = 40, name = "保険者名")
    private RString hokensha;
    @CsvField(order = 50, name = "作成年月日")
    private RString sakuseiYMD;
    @CsvField(order = 60, name = "国保連合会名")
    private RString guobaolianhe;
    @CsvField(order = 70, name = "帳票レコード種別")
    private RString chohyoRecordShubetsu;
    @CsvField(order = 80, name = "No")
    private RString no;
    @CsvField(order = 90, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 100, name = "被保険者氏名")
    private RString hihokenshaShimei;
    @CsvField(order = 110, name = "サービス提供年月")
    private RString serviceTeikyoYM;
    @CsvField(order = 120, name = "利用者負担額")
    private RString riyoshaFutangaku;
    @CsvField(order = 130, name = "支給区分コード")
    private RString shikyuKubunCode;
    @CsvField(order = 140, name = "決定年月")
    private RString ketteiYM;
    @CsvField(order = 150, name = "高額支給額")
    private RString kogakuShikyuGaku;
    @CsvField(order = 160, name = "支払方法区分コード")
    private RString shiharaiHohoKubunCode;
    @CsvField(order = 170, name = "支払場所")
    private RString shiharaiBasho;
    @CsvField(order = 180, name = "開始年月日")
    private RString yukoFromYMD;
    @CsvField(order = 190, name = "終了年月日")
    private RString shuryoYMD;
    @CsvField(order = 200, name = "開始曜日")
    private RString zhouFromD;
    @CsvField(order = 210, name = "終了曜日")
    private RString zhoutoD;
    @CsvField(order = 220, name = "開始時間")
    private RString kaishiTime;
    @CsvField(order = 230, name = "終了時間")
    private RString endTime;
    @CsvField(order = 240, name = "金融機関コード")
    private RString kinyuKikanCode;
    @CsvField(order = 250, name = "金融機関名")
    private RString kinyuKikanName;
    @CsvField(order = 260, name = "金融機関支店コード")
    private RString kinyuKikanzhidianCode;
    @CsvField(order = 270, name = "金融機関支店名")
    private RString kinyuKikanzhidianName;
    @CsvField(order = 280, name = "口座種目")
    private RString kozaZhongMu;
    @CsvField(order = 290, name = "口座種目名")
    private RString kozaZhongMuName;
    @CsvField(order = 300, name = "口座番号")
    private RString kozaNo;
    @CsvField(order = 310, name = "口座名義人_カナ")
    private RString kozaMeiginin;
    @CsvField(order = 320, name = "識別コード")
    private RString shikibetsuCode;
    @CsvField(order = 330, name = "資格喪失事由")
    private RString shikakuSoshitsuJiyu;
    @CsvField(order = 340, name = "資格喪失年月日")
    private RString shikakuSoshitsuYMD;
    @CsvField(order = 350, name = "全国住所コード")
    private RString zenkokuJushoCode;
    @CsvField(order = 360, name = "郵便番号")
    private RString yubinNo;
    @CsvField(order = 370, name = "住所")
    private RString wuchi;
    @CsvField(order = 380, name = "行政区コード")
    private RString gyoseikuCode;
    @CsvField(order = 390, name = "行政区")
    private RString gyoseiku;
    @CsvField(order = 400, name = "氏名カナ")
    private RString atenaKanaMeisho;
    @CsvField(order = 410, name = "氏名")
    private RString atenaMeisho;

}
