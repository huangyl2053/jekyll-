/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 汎用リスト出力(総合事業費情報)_基本マネジメント情報_連番なしのCSV用データEntityクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity implements IHanyoListSogoJigyoHiEUCEntity {

    @CsvField(order = 1, name = "識別コード")
    private ShikibetsuCode 識別コード;
    @CsvField(order = 2, name = "住民種別")
    private JuminJotai 住民種別;
    @CsvField(order = 3, name = "氏名")
    private AtenaMeisho 氏名;
    @CsvField(order = 4, name = "氏名カナ")
    private AtenaKanaMeisho 氏名カナ;
    @CsvField(order = 5, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 6, name = "年齢")
    private RString 年齢;
    @CsvField(order = 7, name = "性別")
    private RString 性別;
    @CsvField(order = 8, name = "続柄コード")
    private TsuzukigaraCode 続柄コード;
    @CsvField(order = 9, name = "世帯コード")
    private SetaiCode 世帯コード;
    @CsvField(order = 10, name = "世帯主名")
    private AtenaMeisho 世帯主名;
    @CsvField(order = 11, name = "住所コード")
    private ZenkokuJushoCode 住所コード;
    @CsvField(order = 12, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 13, name = "住所＋番地＋方書")
    private RString 住所_番地_方書;
    @CsvField(order = 14, name = "住所")
    private RString 住所;
    @CsvField(order = 15, name = "番地")
    private RString 番地;
    @CsvField(order = 16, name = "方書")
    private RString 方書;
    @CsvField(order = 17, name = "行政区コード")
    private GyoseikuCode 行政区コード;
    @CsvField(order = 18, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 19, name = "地区１")
    private ChikuCode 地区１;
    @CsvField(order = 20, name = "地区２")
    private ChikuCode 地区２;
    @CsvField(order = 21, name = "地区３")
    private ChikuCode 地区３;
    @CsvField(order = 22, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 23, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 24, name = "保険者コード")
    private RString 保険者コード;
    @CsvField(order = 25, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 26, name = "空白")
    private RString 空白;
    @CsvField(order = 27, name = "指定基準該当事業者区分")
    private RString 指定基準該当事業者区分;
    @CsvField(order = 28, name = "単位数単価")
    private int 単位数単価;
    @CsvField(order = 29, name = "サービスコード")
    private RString サービスコード;
    @CsvField(order = 30, name = "サービス名称")
    private RString サービス名称;
    @CsvField(order = 31, name = "単位数")
    private int 単位数;
    @CsvField(order = 32, name = "回数")
    private int 回数;
    @CsvField(order = 33, name = "サービス単位数")
    private int サービス単位数;
    @CsvField(order = 34, name = "サービス単位数合計")
    private int サービス単位数合計;
    @CsvField(order = 35, name = "請求金額")
    private int 請求金額;
    @CsvField(order = 36, name = "摘要")
    private RString 摘要;
    @CsvField(order = 37, name = "利用者負担額")
    private int 利用者負担額;
    @CsvField(order = 38, name = "(後)単位数")
    private int 後単位数;
    @CsvField(order = 39, name = "(後)回数")
    private int 後回数;
    @CsvField(order = 40, name = "(後)サービス単位数")
    private int 後サービス単位数;
    @CsvField(order = 41, name = "(後)サービス単位数合計")
    private int 後サービス単位数合計;
    @CsvField(order = 42, name = "(後)請求金額")
    private int 後請求金額;
    @CsvField(order = 43, name = "(後)利用者負担額")
    private int 後利用者負担額;
    @CsvField(order = 44, name = "再審査回数")
    private int 再審査回数;
    @CsvField(order = 45, name = "過誤回数")
    private int 過誤回数;
    @CsvField(order = 46, name = "開始年月日")
    private RString 開始年月日;
    @CsvField(order = 47, name = "中止年月日")
    private RString 中止年月日;
    @CsvField(order = 48, name = "(前)保険サービス単位数")
    private int 前保険サービス単位数;
    @CsvField(order = 49, name = "(前)保険請求額")
    private int 前保険請求額;
    @CsvField(order = 50, name = "(前)保険利用者負担額")
    private int 前保険利用者負担額;
    @CsvField(order = 51, name = "(後)保険サービス単位数")
    private int 後保険サービス単位数;
    @CsvField(order = 52, name = "(後)保険請求額")
    private int 後保険請求額;
    @CsvField(order = 53, name = "(後)保険利用者負担額")
    private int 後保険利用者負担額;
    @CsvField(order = 54, name = "警告区分")
    private RString 警告区分;
    @CsvField(order = 55, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 56, name = "取込年月")
    private RString 取込年月;
}
