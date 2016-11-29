/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 汎用リスト出力(総合事業費情報)_基本情報_連番ありのCSV用データEntityクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class HanyoListSogoJigyoHiKiHonReibanAriEUCEntity implements IHanyoListSogoJigyoHiEUCEntity {

    @CsvField(order = 1, name = "連番")
    private RString 連番;
    @CsvField(order = 2, name = "識別コード")
    private ShikibetsuCode 識別コード;
    @CsvField(order = 3, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 4, name = "氏名")
    private AtenaMeisho 氏名;
    @CsvField(order = 5, name = "氏名カナ")
    private AtenaKanaMeisho 氏名カナ;
    @CsvField(order = 6, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 7, name = "年齢")
    private RString 年齢;
    @CsvField(order = 8, name = "性別")
    private RString 性別;
    @CsvField(order = 9, name = "続柄コード")
    private TsuzukigaraCode 続柄コード;
    @CsvField(order = 10, name = "世帯コード")
    private SetaiCode 世帯コード;
    @CsvField(order = 11, name = "世帯主名")
    private AtenaMeisho 世帯主名;
    @CsvField(order = 12, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 13, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 14, name = "住所＋番地＋方書")
    private RString 住所_番地_方書;
    @CsvField(order = 15, name = "住所")
    private RString 住所;
    @CsvField(order = 16, name = "番地")
    private RString 番地;
    @CsvField(order = 17, name = "方書")
    private RString 方書;
    @CsvField(order = 18, name = "行政区コード")
    private GyoseikuCode 行政区コード;
    @CsvField(order = 19, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 20, name = "地区１")
    private ChikuCode 地区１;
    @CsvField(order = 21, name = "地区２")
    private ChikuCode 地区２;
    @CsvField(order = 22, name = "地区３")
    private ChikuCode 地区３;
    @CsvField(order = 23, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 24, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 25, name = "保険者コード")
    private RString 保険者コード;
    @CsvField(order = 26, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 27, name = "空白")
    private RString 空白;
    @CsvField(order = 28, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 29, name = "給付実績情報作成区分")
    private RString 給付実績情報作成区分;
    @CsvField(order = 30, name = "給付実績区分")
    private RString 給付実績区分;
    @CsvField(order = 31, name = "(給付)証記載保険者番号")
    private RString 給付証記載保険者番号;
    @CsvField(order = 32, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 33, name = "給付実績事業者番号")
    private RString 給付実績事業者番号;
    @CsvField(order = 34, name = "給付実績事業者名")
    private RString 給付実績事業者名;
    @CsvField(order = 35, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 36, name = "給付実績生年月日")
    private RString 給付実績生年月日;
    @CsvField(order = 37, name = "給付実績性別")
    private RString 給付実績性別;
    @CsvField(order = 38, name = "給付実績要介護状態区分")
    private RString 給付実績要介護状態区分;
    @CsvField(order = 39, name = "給付実績認定開始日")
    private RString 給付実績認定開始日;
    @CsvField(order = 40, name = "給付実績認定終了日")
    private RString 給付実績認定終了日;
    @CsvField(order = 41, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 42, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 43, name = "保険者番号(後期)")
    private RString 保険者番号後期;
    @CsvField(order = 44, name = "被保険者番号(後期)")
    private RString 被保険者番号後期;
    @CsvField(order = 45, name = "保険者番号(国保)")
    private RString 保険者番号国保;
    @CsvField(order = 46, name = "被保険者証番号(国保)")
    private RString 被保険者証番号国保;
    @CsvField(order = 47, name = "個人番号(国保)")
    private RString 個人番号国保;
    @CsvField(order = 48, name = "開始年月日")
    private RString 開始年月日;
    @CsvField(order = 49, name = "中止年月日")
    private RString 中止年月日;
    @CsvField(order = 50, name = "(前)保険サービス単位数")
    private int 前保険サービス単位数;
    @CsvField(order = 51, name = "(前)保険請求額")
    private int 前保険請求額;
    @CsvField(order = 52, name = "(前)保険利用者負担額")
    private int 前保険利用者負担額;
    @CsvField(order = 53, name = "(後)保険サービス単位数")
    private int 後サービス単位数;
    @CsvField(order = 54, name = "(後)保険請求額")
    private int 後保険請求額;
    @CsvField(order = 55, name = "(後)保険利用者負担額")
    private int 後保険利用者負担額;
    @CsvField(order = 56, name = "警告区分")
    private RString 警告区分;
    @CsvField(order = 57, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 58, name = "取込年月")
    private RString 取込年月;

}
