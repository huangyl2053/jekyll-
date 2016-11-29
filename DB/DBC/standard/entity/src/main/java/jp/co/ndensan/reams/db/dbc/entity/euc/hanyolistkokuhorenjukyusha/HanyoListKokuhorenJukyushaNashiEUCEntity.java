package jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistkokuhorenjukyusha;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 汎用リスト_事業分高額合算支給決定情報連番がなしCSV用データEntityです。
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class HanyoListKokuhorenJukyushaNashiEUCEntity implements IHanyoListKokuhorenJukyushaEUCEntity {

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
    private RString 住所コード;
    @CsvField(order = 12, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 13, name = "住所＋番地＋方書")
    private RString 住所番地方書;
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
    @CsvField(order = 35, name = "前住所＋番地＋方書")
    private RString 前住所番地方書;
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
    @CsvField(order = 48, name = "処理対象年月")
    private RString 処理対象年月;
    @CsvField(order = 49, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 50, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 51, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 52, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 53, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 54, name = "（給付）証記載保険者番号")
    private RString 給付証記載保険者番号;
    @CsvField(order = 55, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 56, name = "送付生年月日")
    private RString 送付生年月日;
    @CsvField(order = 57, name = "送付性別")
    private RString 送付性別;
    @CsvField(order = 58, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 59, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 60, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 61, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 62, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 63, name = "広域保険者番号")
    private RString 広域保険者番号;
    @CsvField(order = 64, name = "申請種別")
    private RString 申請種別;
    @CsvField(order = 65, name = "変更申請中区分")
    private RString 変更申請中区分;
    @CsvField(order = 66, name = "申請日")
    private RString 申請日;
    @CsvField(order = 67, name = "みなし更新認定")
    private RString みなし更新認定;
    @CsvField(order = 68, name = "要介護状態度")
    private RString 要介護状態度;
    @CsvField(order = 69, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 70, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 71, name = "居宅計画作成区分")
    private RString 居宅計画作成区分;
    @CsvField(order = 72, name = "居宅支援事業者番号")
    private RString 居宅支援事業者番号;
    @CsvField(order = 73, name = "居宅支援事業者名")
    private RString 居宅支援事業者名;
    @CsvField(order = 74, name = "サービス計画適用開始日")
    private RString サービス計画適用開始日;
    @CsvField(order = 75, name = "サービス計画適用終了日")
    private RString サービス計画適用終了日;
    @CsvField(order = 76, name = "訪問通所支給限度基準額")
    private RString 訪問通所支給限度基準額;
    @CsvField(order = 77, name = "訪問通所管理適用開始日")
    private RString 訪問通所管理適用開始日;
    @CsvField(order = 78, name = "訪問通所管理適用終了日")
    private RString 訪問通所管理適用終了日;
    @CsvField(order = 79, name = "短期入所支給限度基準額")
    private RString 短期入所支給限度基準額;
    @CsvField(order = 80, name = "短期入所管理適用開始日")
    private RString 短期入所管理適用開始日;
    @CsvField(order = 81, name = "短期入所管理適用終了日")
    private RString 短期入所管理適用終了日;
    @CsvField(order = 82, name = "公費負担上限額減額の有無")
    private RString 公費負担上限額減額の有無;
    @CsvField(order = 83, name = "償還払化開始日")
    private RString 償還払化開始日;
    @CsvField(order = 84, name = "償還払化終了日")
    private RString 償還払化終了日;
    @CsvField(order = 85, name = "給付率引下げ開始日")
    private RString 給付率引下げ開始日;
    @CsvField(order = 86, name = "給付率引下げ終了日")
    private RString 給付率引下げ終了日;
    @CsvField(order = 87, name = "減免申請中区分")
    private RString 減免申請中区分;
    @CsvField(order = 88, name = "利用者負担区分")
    private RString 利用者負担区分;
    @CsvField(order = 89, name = "利用者負担給付率")
    private RString 利用者負担給付率;
    @CsvField(order = 90, name = "利用者負担適用開始日")
    private RString 利用者負担適用開始日;
    @CsvField(order = 91, name = "利用者負担適用終了日")
    private RString 利用者負担適用終了日;
    @CsvField(order = 92, name = "標準負担区分")
    private RString 標準負担区分;
    @CsvField(order = 93, name = "標準負担額")
    private RString 標準負担額;
    @CsvField(order = 94, name = "標準負担適用開始日")
    private RString 標準負担適用開始日;
    @CsvField(order = 95, name = "標準負担適用終了日")
    private RString 標準負担適用終了日;
    @CsvField(order = 96, name = "特定入所者認定申請中区分コード")
    private RString 特定入所者認定申請中区分コード;
    @CsvField(order = 97, name = "特定入所介護サービス区分コード")
    private RString 特定入所介護サービス区分コード;
    @CsvField(order = 98, name = "課税層の特例減額措置対象")
    private RString 課税層の特例減額措置対象;
    @CsvField(order = 99, name = "食費負担限度額")
    private RString 食費負担限度額;
    @CsvField(order = 100, name = "居住費（ユ個）負担限度額")
    private RString 居住費ユ個負担限度額;
    @CsvField(order = 101, name = "居住費（ユ準）負担限度額")
    private RString 居住費ユ準負担限度額;
    @CsvField(order = 102, name = "居住費（従特養）負担限度額")
    private RString 居住費従特養負担限度額;
    @CsvField(order = 103, name = "居住費（従老療）負担限度額")
    private RString 居住費従老療負担限度額;
    @CsvField(order = 104, name = "居住費（多床室）負担限度額")
    private RString 居住費多床室負担限度額;
    @CsvField(order = 105, name = "負担限度額適用開始日")
    private RString 負担限度額適用開始日;
    @CsvField(order = 106, name = "負担限度額適用終了日")
    private RString 負担限度額適用終了日;
    @CsvField(order = 107, name = "社会福祉法人軽減率")
    private RString 社会福祉法人軽減率;
    @CsvField(order = 108, name = "社会福祉法人軽減率適用開始日")
    private RString 社会福祉法人軽減率適用開始日;
    @CsvField(order = 109, name = "社会福祉法人軽減率適用終了日")
    private RString 社会福祉法人軽減率適用終了日;
    @CsvField(order = 110, name = "小規模居宅サービス有無")
    private RString 小規模居宅サービス有無;
    @CsvField(order = 111, name = "保険者番号（後期）")
    private RString 保険者番号後期;
    @CsvField(order = 112, name = "被保険者番号（後期）")
    private RString 被保険者番号後期;
    @CsvField(order = 113, name = "保険者番号（国保）")
    private RString 保険者番号国保;
    @CsvField(order = 114, name = "被保険者証番号（国保）")
    private RString 被保険者証番号国保;
    @CsvField(order = 115, name = "個人番号（国保）")
    private RString 個人番号国保;
    @CsvField(order = 116, name = "二次予防事業開始日")
    private RString 二次予防事業開始日;
    @CsvField(order = 117, name = "二次予防事業終了日")
    private RString 二次予防事業終了日;
    @CsvField(order = 118, name = "二次予防事業区分")
    private RString 二次予防事業区分;
    @CsvField(order = 119, name = "住所地特例対象者区分コード")
    private RString 住所地特例対象者区分コード;
    @CsvField(order = 120, name = "施設所在保険者番号")
    private RString 施設所在保険者番号;
    @CsvField(order = 121, name = "住所地特例適用開始日")
    private RString 住所地特例適用開始日;
    @CsvField(order = 122, name = "住所地特例適用終了日")
    private RString 住所地特例適用終了日;
    @CsvField(order = 123, name = "居宅費（新１）負担限度額")
    private RString 居宅費新１負担限度額;
    @CsvField(order = 124, name = "居宅費（新２）負担限度額")
    private RString 居宅費新２負担限度額;
    @CsvField(order = 125, name = "居宅費（新３）負担限度額")
    private RString 居宅費新３負担限度額;
    @CsvField(order = 126, name = "利用者負担割合有効開始日")
    private RString 利用者負担割合有効開始日;
    @CsvField(order = 127, name = "利用者負担割合有効終了日")
    private RString 利用者負担割合有効終了日;

}
