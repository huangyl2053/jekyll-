/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連IF取込レコードファイルEntityです。
 *
 * @reamsid_L DBC-2280-010 chenxiangyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuTsuchiSakuseiIkatuCsvEntity {

    @CsvField(order = 1, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 2, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 3, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 4, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 5, name = "保険者番号 ")
    private RString 保険者番号;
    @CsvField(order = 6, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 7, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 8, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 9, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 10, name = "事業所名(漢字)")
    private RString 事業所名_漢字;
    @CsvField(order = 11, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 12, name = "サービス項目コード")
    private RString サービス項目コード;
    @CsvField(order = 13, name = "サービス略称")
    private RString サービス略称;
    @CsvField(order = 14, name = "ＣＣＴＡコード")
    private RString CCTAコード;
    @CsvField(order = 15, name = "福祉用具貸与品目コード")
    private RString 福祉用具貸与品目コード;
    @CsvField(order = 16, name = "福祉用具商品名")
    private RString 福祉用具商品名;
    @CsvField(order = 17, name = "費用額")
    private RString 費用額;
    @CsvField(order = 18, name = "希望小売価格")
    private RString 希望小売価格;
    @CsvField(order = 19, name = "全国請求件数")
    private RString 全国_請求件数;
    @CsvField(order = 20, name = "全国最低費用額")
    private RString 全国_最低費用額;
    @CsvField(order = 21, name = "全国最頻費用額")
    private RString 全国_最頻費用額;
    @CsvField(order = 22, name = "全国最高費用額")
    private RString 全国_最高費用額;
    @CsvField(order = 23, name = "全国平均費用額")
    private RString 全国_平均費用額;
    @CsvField(order = 24, name = "都道府県請求件数")
    private RString 都道府県_請求件数;
    @CsvField(order = 25, name = "都道府県最低費用額")
    private RString 都道府県_最低費用額;
    @CsvField(order = 26, name = "都道府県最頻費用額")
    private RString 都道府県_最頻費用額;
    @CsvField(order = 27, name = "都道府県最高費用額")
    private RString 都道府県_最高費用額;
    @CsvField(order = 28, name = "都道府県平均費用額")
    private RString 都道府県_平均費用額;
    @CsvField(order = 29, name = "保険者請求件数")
    private RString 保険者請求件数;
    @CsvField(order = 30, name = "保険者最低費用額")
    private RString 保険者最低費用額;
    @CsvField(order = 31, name = "保険者最頻費用額")
    private RString 保険者最頻費用額;
    @CsvField(order = 32, name = "保険者最高費用額")
    private RString 保険者最高費用額;
    @CsvField(order = 33, name = "保険者平均費用額")
    private RString 保険者平均費用額;
    @CsvField(order = 34, name = "全国単位数範囲１")
    private RString 全国_単位数範囲1;
    @CsvField(order = 35, name = "全国単位数範囲２")
    private RString 全国_単位数範囲2;
    @CsvField(order = 36, name = "全国単位数範囲３")
    private RString 全国_単位数範囲3;
    @CsvField(order = 37, name = "全国単位数範囲４")
    private RString 全国_単位数範囲4;
    @CsvField(order = 38, name = "全国単位数範囲５")
    private RString 全国_単位数範囲5;
    @CsvField(order = 39, name = "全国単位数範囲６")
    private RString 全国_単位数範囲6;
    @CsvField(order = 40, name = "全国単位数範囲７")
    private RString 全国_単位数範囲7;
    @CsvField(order = 41, name = "全国単位数範囲８")
    private RString 全国_単位数範囲8;
    @CsvField(order = 42, name = "全国単位数範囲９")
    private RString 全国_単位数範囲9;
    @CsvField(order = 43, name = "全国単位数範囲１０")
    private RString 全国_単位数範囲10;
    @CsvField(order = 44, name = "全国単位数範囲１の度数")
    private RString 全国_単位数範囲1の度数;
    @CsvField(order = 45, name = "全国単位数範囲２の度数")
    private RString 全国_単位数範囲2の度数;
    @CsvField(order = 46, name = "全国単位数範囲３の度数")
    private RString 全国_単位数範囲3の度数;
    @CsvField(order = 47, name = "全国単位数範囲４の度数")
    private RString 全国_単位数範囲4の度数;
    @CsvField(order = 48, name = "全国単位数範囲５の度数")
    private RString 全国_単位数範囲5の度数;
    @CsvField(order = 49, name = "全国単位数範囲６の度数")
    private RString 全国_単位数範囲6の度数;
    @CsvField(order = 50, name = "全国単位数範囲７の度数")
    private RString 全国_単位数範囲7の度数;
    @CsvField(order = 51, name = "全国単位数範囲８の度数")
    private RString 全国_単位数範囲8の度数;
    @CsvField(order = 52, name = "全国単位数範囲９の度数")
    private RString 全国_単位数範囲9の度数;
    @CsvField(order = 53, name = "全国単位数範囲１０の度数")
    private RString 全国_単位数範囲10の度数;
    @CsvField(order = 54, name = "都道府県単位数範囲１")
    private RString 都道府県_単位数範囲1;
    @CsvField(order = 55, name = "都道府県単位数範囲２")
    private RString 都道府県_単位数範囲2;
    @CsvField(order = 56, name = "都道府県単位数範囲３")
    private RString 都道府県_単位数範囲3;
    @CsvField(order = 57, name = "都道府県単位数範囲４")
    private RString 都道府県_単位数範囲4;
    @CsvField(order = 58, name = "都道府県単位数範囲５")
    private RString 都道府県_単位数範囲5;
    @CsvField(order = 59, name = "都道府県単位数範囲６")
    private RString 都道府県_単位数範囲6;
    @CsvField(order = 60, name = "都道府県単位数範囲７")
    private RString 都道府県_単位数範囲7;
    @CsvField(order = 61, name = "都道府県単位数範囲８")
    private RString 都道府県_単位数範囲8;
    @CsvField(order = 62, name = "都道府県単位数範囲９")
    private RString 都道府県_単位数範囲9;
    @CsvField(order = 63, name = "都道府県単位数範囲１０")
    private RString 都道府県_単位数範囲10;
    @CsvField(order = 64, name = "都道府県単位数範囲１の度数")
    private RString 都道府県_単位数範囲1の度数;
    @CsvField(order = 65, name = "都道府県単位数範囲２の度数")
    private RString 都道府県_単位数範囲2の度数;
    @CsvField(order = 66, name = "都道府県単位数範囲３の度数")
    private RString 都道府県_単位数範囲3の度数;
    @CsvField(order = 67, name = "都道府県単位数範囲４の度数")
    private RString 都道府県_単位数範囲4の度数;
    @CsvField(order = 68, name = "都道府県単位数範囲５の度数")
    private RString 都道府県_単位数範囲5の度数;
    @CsvField(order = 69, name = "都道府県単位数範囲６の度数")
    private RString 都道府県_単位数範囲6の度数;
    @CsvField(order = 70, name = "都道府県単位数範囲７の度数")
    private RString 都道府県_単位数範囲7の度数;
    @CsvField(order = 71, name = "都道府県単位数範囲８の度数")
    private RString 都道府県_単位数範囲8の度数;
    @CsvField(order = 72, name = "都道府県単位数範囲９の度数")
    private RString 都道府県_単位数範囲9の度数;
    @CsvField(order = 73, name = "都道府県単位数範囲１０の度数")
    private RString 都道府県_単位数範囲10の度数;
    @CsvField(order = 74, name = "ブランク")
    private RString ブランク;
}
