/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.euc.hikazeinenkintaishosha;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 汎用リスト出力(非課税年金対象者)連番があるCSV用データEntityです。
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class HikazeiNenkinTaishoshaReibanAriEUCEntity implements IHikazeiNenkinTaishoshaEUCEntity {

    @CsvField(order = 1, name = "連番")
    private RString 連番;
    @CsvField(order = 2, name = "識別コード")
    private ShikibetsuCode 識別コード;
    @CsvField(order = 3, name = "住民種別")
    private JuminShubetsu 住民種別;
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
    private ZenkokuJushoCode 住所コード;
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
    @CsvField(order = 23, name = "連絡先１")
    private TelNo 連絡先１;
    @CsvField(order = 24, name = "連絡先２")
    private TelNo 連絡先２;
    @CsvField(order = 25, name = "登録異動日")
    private RString 登録異動日;
    @CsvField(order = 26, name = "登録事由")
    private IIdoJiyu 登録事由;
    @CsvField(order = 27, name = "登録届出日")
    private RString 登録届出日;
    @CsvField(order = 28, name = "住定異動日")
    private RString 住定異動日;
    @CsvField(order = 29, name = "住定事由")
    private IIdoJiyu 住定事由;
    @CsvField(order = 30, name = "住定届出日")
    private RString 住定届出日;
    @CsvField(order = 31, name = "消除異動日")
    private RString 消除異動日;
    @CsvField(order = 32, name = "消除事由")
    private IIdoJiyu 消除事由;
    @CsvField(order = 33, name = "消除届出日")
    private RString 消除届出日;
    @CsvField(order = 34, name = "転出入理由")
    private RString 転出入理由;
    @CsvField(order = 35, name = "前住所郵便番号")
    private YubinNo 前住所郵便番号;
    @CsvField(order = 36, name = "前住所＋番地＋方書")
    private RString 前住所_番地_方書;
    @CsvField(order = 37, name = "前住所")
    private RString 前住所;
    @CsvField(order = 38, name = "前住所番地")
    private RString 前住所番地;
    @CsvField(order = 39, name = "前住所方書")
    private RString 前住所方書;
    @CsvField(order = 40, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 41, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 42, name = "保険者コード")
    private LasdecCode 保険者コード;
    @CsvField(order = 43, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 44, name = "空白")
    private RString 空白;
    @CsvField(order = 45, name = "送付先氏名")
    private AtenaMeisho 送付先氏名;
    @CsvField(order = 46, name = "送付先氏名カナ")
    private AtenaKanaMeisho 送付先氏名カナ;
    @CsvField(order = 47, name = "送付先住所コード")
    private ZenkokuJushoCode 送付先住所コード;
    @CsvField(order = 48, name = "送付先郵便番号")
    private RString 送付先郵便番号;
    @CsvField(order = 49, name = "送付先住所＋番地＋方書")
    private RString 送付先住所_番地_方書;
    @CsvField(order = 50, name = "送付先住所")
    private RString 送付先住所;
    @CsvField(order = 51, name = "送付先番地")
    private RString 送付先番地;
    @CsvField(order = 52, name = "送付先方書")
    private RString 送付先方書;
    @CsvField(order = 53, name = "送付先行政区コード")
    private GyoseikuCode 送付先行政区コード;
    @CsvField(order = 54, name = "送付先行政区名")
    private RString 送付先行政区名;
    @CsvField(order = 55, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 56, name = "年度")
    private RString 年度;
    @CsvField(order = 57, name = "処理区分")
    private RString 処理区分;
    @CsvField(order = 58, name = "対象月")
    private RString 対象月;
    @CsvField(order = 59, name = "基礎年金番号")
    private RString 基礎年金番号;
    @CsvField(order = 60, name = "現基礎年金番号")
    private RString 現基礎年金番号;
    @CsvField(order = 61, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 62, name = "IF市町村コード")
    private RString if市町村コード;
    @CsvField(order = 63, name = "IF年金保険者コード")
    private RString if年金保険者コード;
    @CsvField(order = 64, name = "IF通知内容コード")
    private RString if通知内容コード;
    @CsvField(order = 65, name = "IF作成年月日")
    private RString if作成年月日;
    @CsvField(order = 66, name = "IF性別")
    private RString if性別;
    @CsvField(order = 67, name = "IFカナ氏名")
    private RString ifカナ氏名;
    @CsvField(order = 68, name = "IF漢字氏名")
    private RString if漢字氏名;
    @CsvField(order = 69, name = "IF郵便番号")
    private RString if郵便番号;
    @CsvField(order = 70, name = "IFカナ住所")
    private RString ifカナ住所;
    @CsvField(order = 71, name = "IF漢字住所")
    private RString if漢字住所;
    @CsvField(order = 72, name = "IF対象年")
    private RString if対象年;
    @CsvField(order = 73, name = "IF訂正表示")
    private RString if訂正表示;
    @CsvField(order = 74, name = "IF各種区分")
    private RString if各種区分;
    @CsvField(order = 75, name = "IF処理結果")
    private RString if処理結果;
    @CsvField(order = 76, name = "IF金額１")
    private RString if金額１;
    @CsvField(order = 77, name = "登録区分")
    private RString 登録区分;

}
