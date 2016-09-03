/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBMN61002_介護保険料減免登録(一括)のCsvEntity
 *
 * @reamsid_L DBB-1670-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenCsvEntity {

    @CsvField(order = 10, name = "調定年度")
    private RString 調定年度;
    @CsvField(order = 20, name = "賦課年度")
    private RString 賦課年度;
    @CsvField(order = 30, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 40, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 70, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 80, name = "保険料段階")
    private RString 保険料段階;
    @CsvField(order = 90, name = "処理前減免前介護保険料（年額）")
    private RString 処理前減免前介護保険料年額;
    @CsvField(order = 100, name = "処理後減免前介護保険料（年額）")
    private RString 処理後減免前介護保険料年額;
    @CsvField(order = 110, name = "処理前減免額")
    private RString 処理前減免額;
    @CsvField(order = 120, name = "処理後減免額")
    private RString 処理後減免額;
    @CsvField(order = 130, name = "処理前確定介護保険料（年額）")
    private RString 処理前確定介護保険料年額;
    @CsvField(order = 140, name = "処理後確定介護保険料（年額）")
    private RString 処理後確定介護保険料年額;
    @CsvField(order = 150, name = "処理前特徴期別金額01")
    private RString 処理前特徴期別金額01;
    @CsvField(order = 160, name = "処理後特徴期別金額01")
    private RString 処理後特徴期別金額01;
    @CsvField(order = 170, name = "処理前特徴期別金額02")
    private RString 処理前特徴期別金額02;
    @CsvField(order = 180, name = "処理後特徴期別金額02")
    private RString 処理後特徴期別金額02;
    @CsvField(order = 190, name = "処理前特徴期別金額03")
    private RString 処理前特徴期別金額03;
    @CsvField(order = 200, name = "処理後特徴期別金額03")
    private RString 処理後特徴期別金額03;
    @CsvField(order = 210, name = "処理前特徴期別金額04")
    private RString 処理前特徴期別金額04;
    @CsvField(order = 220, name = "処理後特徴期別金額04")
    private RString 処理後特徴期別金額04;
    @CsvField(order = 230, name = "処理前特徴期別金額05")
    private RString 処理前特徴期別金額05;
    @CsvField(order = 240, name = "処理後特徴期別金額05")
    private RString 処理後特徴期別金額05;
    @CsvField(order = 250, name = "処理前特徴期別金額06")
    private RString 処理前特徴期別金額06;
    @CsvField(order = 260, name = "処理後特徴期別金額06")
    private RString 処理後特徴期別金額06;
    @CsvField(order = 270, name = "処理前普徴期別金額01")
    private RString 処理前普徴期別金額01;
    @CsvField(order = 280, name = "処理後普徴期別金額01")
    private RString 処理後普徴期別金額01;
    @CsvField(order = 290, name = "処理前普徴期別金額02")
    private RString 処理前普徴期別金額02;
    @CsvField(order = 300, name = "処理後普徴期別金額02")
    private RString 処理後普徴期別金額02;
    @CsvField(order = 310, name = "処理前普徴期別金額03")
    private RString 処理前普徴期別金額03;
    @CsvField(order = 320, name = "処理後普徴期別金額03")
    private RString 処理後普徴期別金額03;
    @CsvField(order = 330, name = "処理前普徴期別金額04")
    private RString 処理前普徴期別金額04;
    @CsvField(order = 340, name = "処理後普徴期別金額04")
    private RString 処理後普徴期別金額04;
    @CsvField(order = 350, name = "処理前普徴期別金額05")
    private RString 処理前普徴期別金額05;
    @CsvField(order = 360, name = "処理後普徴期別金額05")
    private RString 処理後普徴期別金額05;
    @CsvField(order = 370, name = "処理前普徴期別金額06")
    private RString 処理前普徴期別金額06;
    @CsvField(order = 380, name = "処理後普徴期別金額06")
    private RString 処理後普徴期別金額06;
    @CsvField(order = 390, name = "処理前普徴期別金額07")
    private RString 処理前普徴期別金額07;
    @CsvField(order = 400, name = "処理後普徴期別金額07")
    private RString 処理後普徴期別金額07;
    @CsvField(order = 410, name = "処理前普徴期別金額08")
    private RString 処理前普徴期別金額08;
    @CsvField(order = 420, name = "処理後普徴期別金額08")
    private RString 処理後普徴期別金額08;
    @CsvField(order = 430, name = "処理前普徴期別金額09")
    private RString 処理前普徴期別金額09;
    @CsvField(order = 440, name = "処理後普徴期別金額09")
    private RString 処理後普徴期別金額09;
    @CsvField(order = 450, name = "処理前普徴期別金額10")
    private RString 処理前普徴期別金額10;
    @CsvField(order = 460, name = "処理後普徴期別金額10")
    private RString 処理後普徴期別金額10;
    @CsvField(order = 470, name = "処理前普徴期別金額11")
    private RString 処理前普徴期別金額11;
    @CsvField(order = 480, name = "処理後普徴期別金額11")
    private RString 処理後普徴期別金額11;
    @CsvField(order = 490, name = "処理前普徴期別金額12")
    private RString 処理前普徴期別金額12;
    @CsvField(order = 500, name = "処理後普徴期別金額12")
    private RString 処理後普徴期別金額12;
    @CsvField(order = 510, name = "処理前普徴期別金額13")
    private RString 処理前普徴期別金額13;
    @CsvField(order = 520, name = "処理後普徴期別金額13")
    private RString 処理後普徴期別金額13;
    @CsvField(order = 530, name = "処理前普徴期別金額14")
    private RString 処理前普徴期別金額14;
    @CsvField(order = 540, name = "処理後普徴期別金額14")
    private RString 処理後普徴期別金額14;
    @CsvField(order = 550, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 560, name = "住所")
    private RString 住所;
    @CsvField(order = 570, name = "番地")
    private RString 番地;
    @CsvField(order = 580, name = "方書")
    private RString 方書;
    @CsvField(order = 590, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 600, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 610, name = "地区コード１")
    private RString 地区コード１;
    @CsvField(order = 620, name = "地区名１")
    private RString 地区名１;
    @CsvField(order = 630, name = "地区コード２")
    private RString 地区コード２;
    @CsvField(order = 640, name = "地区名２")
    private RString 地区名２;
    @CsvField(order = 650, name = "地区コード３")
    private RString 地区コード３;
    @CsvField(order = 660, name = "地区名３")
    private RString 地区名３;
    @CsvField(order = 670, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 680, name = "漢字氏名")
    private RString 漢字氏名;
    @CsvField(order = 690, name = "カナ氏名")
    private RString カナ氏名;

}
