package jp.co.ndensan.reams.db.dbc.entity.euc.jigyobunkogakugassanshikyukettei;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 汎用リスト_事業分高額合算支給決定情報連番がなしCSV用データEntityです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity implements IJigyoBunKogakuGassanShikyuKetteiEUCEntity {

    @CsvField(order = 1, name = "識別コード")
    private ShikibetsuCode 識別コード;
    @CsvField(order = 2, name = "住民種別")
    private RString 住民種別;
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
    private ChoikiCode 住所コード;
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
    @CsvField(order = 22, name = "連絡先１")
    private TelNo 連絡先１;
    @CsvField(order = 23, name = "連絡先２")
    private TelNo 連絡先２;
    @CsvField(order = 24, name = "登録異動日")
    private RString 登録異動日;
    @CsvField(order = 25, name = "登録事由")
    private IIdoJiyu 登録事由;
    @CsvField(order = 26, name = "登録届出日")
    private RString 登録届出日;
    @CsvField(order = 27, name = "住定異動日")
    private RString 住定異動日;
    @CsvField(order = 28, name = "住定事由")
    private IIdoJiyu 住定事由;
    @CsvField(order = 29, name = "住定届出日")
    private RString 住定届出日;
    @CsvField(order = 30, name = "消除異動日")
    private RString 消除異動日;
    @CsvField(order = 31, name = "消除事由")
    private IIdoJiyu 消除事由;
    @CsvField(order = 32, name = "消除届出日")
    private RString 消除届出日;
    @CsvField(order = 33, name = "転出入理由")
    private RString 転出入理由;
    @CsvField(order = 34, name = "前住所郵便番号")
    private RString 前住所郵便番号;
    @CsvField(order = 35, name = "前住所+番地+方書")
    private RString 前住所_番地_方書;
    @CsvField(order = 36, name = "前住所")
    private RString 前住所;
    @CsvField(order = 37, name = "前住所番地")
    private RString 前住所番地;
    @CsvField(order = 38, name = "前住所方書")
    private RString 前住所方書;
    @CsvField(order = 39, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 40, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 41, name = "保険者コード")
    private RString 保険者コード;
    @CsvField(order = 42, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 43, name = "空白")
    private RString 空白;
    @CsvField(order = 44, name = "送付先氏名")
    private AtenaMeisho 送付先氏名;
    @CsvField(order = 45, name = "送付先氏名カナ")
    private AtenaKanaMeisho 送付先氏名カナ;
    @CsvField(order = 46, name = "送付先住所コード")
    private ZenkokuJushoCode 送付先住所コード;
    @CsvField(order = 47, name = "送付先郵便番号")
    private YubinNo 送付先郵便番号;
    @CsvField(order = 48, name = "送付先住所+番地+方書")
    private RString 送付先住所_番地_方書;
    @CsvField(order = 49, name = "送付先住所")
    private RString 送付先住所;
    @CsvField(order = 50, name = "送付先番地")
    private RString 送付先番地;
    @CsvField(order = 51, name = "送付先方書")
    private RString 送付先方書;
    @CsvField(order = 52, name = "送付先行政区コード")
    private GyoseikuCode 送付先行政区コード;
    @CsvField(order = 53, name = "送付先行政区名")
    private RString 送付先行政区名;
    @CsvField(order = 54, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 55, name = "資格取得事由")
    private RString 資格取得事由;
    @CsvField(order = 56, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 57, name = "資格取得届出日")
    private RString 資格取得届出日;
    @CsvField(order = 58, name = "喪失事由")
    private RString 喪失事由;
    @CsvField(order = 59, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 60, name = "資格喪失届日")
    private RString 資格喪失届日;
    @CsvField(order = 61, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 62, name = "住所地特例状態")
    private RString 住所地特例状態;
    @CsvField(order = 63, name = "受給申請事由")
    private RString 受給申請事由;
    @CsvField(order = 64, name = "受給申請日")
    private RString 受給申請日;
    @CsvField(order = 65, name = "受給要介護度")
    private RString 受給要介護度;
    @CsvField(order = 66, name = "受給認定開始日")
    private RString 受給認定開始日;
    @CsvField(order = 67, name = "受給認定終了日")
    private RString 受給認定終了日;
    @CsvField(order = 68, name = "受給認定日")
    private RString 受給認定日;
    @CsvField(order = 69, name = "受給旧措置")
    private RString 受給旧措置;
    @CsvField(order = 70, name = "受給みなし更新認定")
    private RString 受給みなし更新認定;
    @CsvField(order = 71, name = "受給直近事由")
    private RString 受給直近事由;
    @CsvField(order = 72, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 73, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 74, name = "連絡票整理番号")
    private RString 連絡票整理番号;
    @CsvField(order = 75, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 76, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 77, name = "対象計算期間（開始）")
    private RString 対象計算期間_開始;
    @CsvField(order = 78, name = "対象計算期間（終了）")
    private RString 対象計算期間_終了;
    @CsvField(order = 79, name = "申請日")
    private RString 申請日;
    @CsvField(order = 80, name = "決定日")
    private RString 決定日;
    @CsvField(order = 81, name = "自己負担総額")
    private Decimal 自己負担総額;
    @CsvField(order = 82, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 83, name = "支給額")
    private Decimal 支給額;
    @CsvField(order = 84, name = "給付の種類")
    private RString 給付の種類;
    @CsvField(order = 85, name = "不支給理由")
    private RString 不支給理由;
    @CsvField(order = 86, name = "支払方法区分")
    private RString 支払方法区分;
    @CsvField(order = 87, name = "支払場所")
    private RString 支払場所;
    @CsvField(order = 88, name = "支払期間開始日")
    private RString 支払期間開始日;
    @CsvField(order = 89, name = "支払期間終了日")
    private RString 支払期間終了日;
    @CsvField(order = 90, name = "支払期間開始日(曜日)")
    private RString 支払期間開始日_曜日;
    @CsvField(order = 91, name = "支払期間終了日(曜日)")
    private RString 支払期間終了日_曜日;
    @CsvField(order = 92, name = "支払期間開始日(時間)")
    private RString 支払期間開始日_時間;
    @CsvField(order = 93, name = "支払期間終了日(時間)")
    private RString 支払期間終了日_時間;
    @CsvField(order = 94, name = "金融機関コード")
    private KinyuKikanCode 金融機関コード;
    @CsvField(order = 95, name = "金融機関名")
    private RString 金融機関名;
    @CsvField(order = 96, name = "金融機関支店コード")
    private RString 金融機関支店コード;
    @CsvField(order = 97, name = "金融機関支店名")
    private RString 金融機関支店名;
    @CsvField(order = 98, name = "口座種目名")
    private RString 口座種目名;
    @CsvField(order = 99, name = "口座番号")
    private RString 口座番号;
    @CsvField(order = 100, name = "口座名義人（カナ）")
    private AtenaKanaMeisho 口座名義人_カナ;
    @CsvField(order = 101, name = "決定通知書作成日")
    private RString 決定通知書作成日;
    @CsvField(order = 102, name = "振込通知書作成日")
    private RString 振込通知書作成日;
    @CsvField(order = 103, name = "受取年月")
    private RString 受取年月;
    @CsvField(order = 104, name = "給付の種類(短)")
    private RString 給付の種類_短;
    @CsvField(order = 105, name = "不支給理由(短)")
    private RString 不支給理由_短;
    @CsvField(order = 106, name = "支払場所(短)")
    private RString 支払場所_短;
}
