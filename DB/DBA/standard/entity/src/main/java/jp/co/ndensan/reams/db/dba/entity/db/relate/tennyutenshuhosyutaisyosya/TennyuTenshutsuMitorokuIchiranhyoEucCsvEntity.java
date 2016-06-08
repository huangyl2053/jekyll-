/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 転入転出未登録一覧表CSV用データEntity。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity {

    @CsvField(order = 10, name = "データ内容")
    private RString datanaiyo;
    @CsvField(order = 20, name = "識別コード")
    private RString shikibetsuCode;
    @CsvField(order = 30, name = "世帯コード")
    private RString setaiCode;
    @CsvField(order = 40, name = "市町村コード")
    private RString shichosonCode;
    @CsvField(order = 50, name = "市町村名")
    private RString shichosonName;
    @CsvField(order = 60, name = "カナ氏名")
    private RString kanaShimei;
    @CsvField(order = 70, name = "氏名")
    private RString shimei;
    @CsvField(order = 80, name = "住民状態")
    private RString juminJotai;
    @CsvField(order = 90, name = "生年月日")
    private RString seinengappiYMD;
    @CsvField(order = 100, name = "性別")
    private RString seibetsu;
    @CsvField(order = 110, name = "異動事由コード")
    private RString idoJiyuCode;
    @CsvField(order = 120, name = "異動事由")
    private RString idoJiyu;
    @CsvField(order = 130, name = "登録異動日")
    private RString torokuIdoYMD;
    @CsvField(order = 140, name = "登録届出日")
    private RString torokuTodokedeYMD;
    @CsvField(order = 150, name = "住所地特例")
    private RString jushochiTokurei;
    @CsvField(order = 160, name = "消除異動日")
    private RString shojoIdoYMD;
    @CsvField(order = 170, name = "消除届出日")
    private RString shojoTodokedeYMD;
    @CsvField(order = 180, name = "転出予定異動日")
    private RString tenshutsuYoteiIdoYMD;
    @CsvField(order = 190, name = "住所")
    private RString jusho;
    @CsvField(order = 200, name = "転出予定住所/前住所")
    private RString tenshutsuYoteiJusho;
    @CsvField(order = 210, name = "作成事由コード")
    private RString sakuseiJiyuCode;
    @CsvField(order = 220, name = "作成事由")
    private RString sakuseiJiyu;
}
