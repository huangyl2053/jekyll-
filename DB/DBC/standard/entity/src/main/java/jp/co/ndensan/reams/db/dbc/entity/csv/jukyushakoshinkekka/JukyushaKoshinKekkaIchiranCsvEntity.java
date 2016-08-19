/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票のCSVファイル作成のCsvEntity
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKoshinKekkaIchiranCsvEntity {

    @CsvField(order = 10, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 20, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 30, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 40, name = "訂正年月日")
    private RString 訂正年月日;
    @CsvField(order = 50, name = "訂正区分")
    private RString 訂正区分;
    @CsvField(order = 60, name = "訂正区分名称")
    private RString 訂正区分名称;
    @CsvField(order = 70, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 80, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 90, name = "異動区分名称")
    private RString 異動区分名称;
    @CsvField(order = 100, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 110, name = "異動事由名称")
    private RString 異動事由名称;
    @CsvField(order = 120, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 130, name = "被保険者氏名カナ")
    private RString 被保険者氏名カナ;
    @CsvField(order = 140, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 150, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 160, name = "行政区")
    private RString 行政区;
    @CsvField(order = 170, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 180, name = "住所")
    private RString 住所;
    @CsvField(order = 190, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 200, name = "性別")
    private RString 性別;
    @CsvField(order = 210, name = "性別名称")
    private RString 性別名称;
    @CsvField(order = 220, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 230, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 240, name = "みなし区分")
    private RString みなし区分;
    @CsvField(order = 250, name = "みなし区分名称")
    private RString みなし区分名称;
    @CsvField(order = 260, name = "要介護区分")
    private RString 要介護区分;
    @CsvField(order = 270, name = "要介護区分名称")
    private RString 要介護区分名称;
    @CsvField(order = 280, name = "有効開始日")
    private RString 有効開始日;
    @CsvField(order = 290, name = "有効終了日")
    private RString 有効終了日;
    @CsvField(order = 300, name = "申請種別")
    private RString 申請種別;
    @CsvField(order = 310, name = "申請種別名称")
    private RString 申請種別名称;
    @CsvField(order = 320, name = "変更申請区分")
    private RString 変更申請区分;
    @CsvField(order = 330, name = "変更申請区分名称")
    private RString 変更申請区分名称;
    @CsvField(order = 340, name = "申請日")
    private RString 申請日;
    @CsvField(order = 350, name = "計画作成区分")
    private RString 計画作成区分;
    @CsvField(order = 360, name = "計画作成区分名称")
    private RString 計画作成区分名称;
    @CsvField(order = 370, name = "計画作成適用開始日")
    private RString 計画作成適用開始日;
    @CsvField(order = 380, name = "計画作成適用終了日")
    private RString 計画作成適用終了日;
    @CsvField(order = 390, name = "支援事業者番号")
    private RString 支援事業者番号;
    @CsvField(order = 400, name = "訪問通所支給限度基準額")
    private RString 訪問通所支給限度基準額;
    @CsvField(order = 410, name = "訪問通所管理開始日")
    private RString 訪問通所管理開始日;
    @CsvField(order = 420, name = "訪問通所管理終了日")
    private RString 訪問通所管理終了日;
    @CsvField(order = 430, name = "短期入所支給限度基準額")
    private RString 短期入所支給限度基準額;
    @CsvField(order = 440, name = "短期入所管理開始日")
    private RString 短期入所管理開始日;
    @CsvField(order = 450, name = "短期入所管理終了日")
    private RString 短期入所管理終了日;
    @CsvField(order = 460, name = "標準負担区分")
    private RString 標準負担区分;
    @CsvField(order = 470, name = "標準負担区分名称")
    private RString 標準負担区分名称;
    @CsvField(order = 480, name = "標準負担額")
    private RString 標準負担額;
    @CsvField(order = 490, name = "標準負担適用開始日")
    private RString 標準負担適用開始日;
    @CsvField(order = 500, name = "標準負担適用終了日")
    private RString 標準負担適用終了日;
    @CsvField(order = 510, name = "減免中区分")
    private RString 減免中区分;
    @CsvField(order = 520, name = "減免中区分名称")
    private RString 減免中区分名称;
    @CsvField(order = 530, name = "利用者負担区分")
    private RString 利用者負担区分;
    @CsvField(order = 540, name = "利用者負担区分名称")
    private RString 利用者負担区分名称;
    @CsvField(order = 550, name = "給付率")
    private RString 給付率;
    @CsvField(order = 560, name = "利用者負担適用開始日")
    private RString 利用者負担適用開始日;
    @CsvField(order = 570, name = "利用者負担適用終了日")
    private RString 利用者負担適用終了日;
    @CsvField(order = 580, name = "公費負担上限額減額")
    private RString 公費負担上限額減額;
    @CsvField(order = 590, name = "公費負担上限額減額名称")
    private RString 公費負担上限額減額名称;
    @CsvField(order = 600, name = "償還払化開始日")
    private RString 償還払化開始日;
    @CsvField(order = 610, name = "償還払化終了日")
    private RString 償還払化終了日;
    @CsvField(order = 620, name = "給付率引下げ開始日")
    private RString 給付率引下げ開始日;
    @CsvField(order = 630, name = "給付率引下げ終了日")
    private RString 給付率引下げ終了日;
    @CsvField(order = 640, name = "住所地特例区分")
    private RString 住所地特例区分;
    @CsvField(order = 650, name = "住所地特例区分名称")
    private RString 住所地特例区分名称;
    @CsvField(order = 660, name = "住所地特例施設所在保険者番号")
    private RString 住所地特例施設所在保険者番号;
    @CsvField(order = 670, name = "住所地特例適用開始日")
    private RString 住所地特例適用開始日;
    @CsvField(order = 680, name = "住所地特例適用終了日")
    private RString 住所地特例適用終了日;
    @CsvField(order = 690, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 700, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 710, name = "広域(政令市)保険者番号")
    private RString 広域_政令市_保険者番号;
    @CsvField(order = 720, name = "小規模居宅サービス利用の有無")
    private RString 小規模居宅サービス利用の有無;
    @CsvField(order = 730, name = "小規模居宅サービス利用の有無名称")
    private RString 小規模居宅サービス利用の有無名称;
    @CsvField(order = 740, name = "二次予防事業区分")
    private RString 二次予防事業区分;
    @CsvField(order = 750, name = "二次予防事業区分名称")
    private RString 二次予防事業区分名称;
    @CsvField(order = 760, name = "二次予防事業開始日")
    private RString 二次予防事業開始日;
    @CsvField(order = 770, name = "二次予防事業終了日")
    private RString 二次予防事業終了日;
    @CsvField(order = 780, name = "特定入所者認定申請中区分")
    private RString 特定入所者認定申請中区分;
    @CsvField(order = 790, name = "特定入所者認定申請中区分名称")
    private RString 特定入所者認定申請中区分名称;
    @CsvField(order = 800, name = "特定入所者介護サービス区分")
    private RString 特定入所者介護サービス区分;
    @CsvField(order = 810, name = "特定入所者介護サービス区分名称")
    private RString 特定入所者介護サービス区分名称;
    @CsvField(order = 820, name = "課税層の特例減額措置対象")
    private RString 課税層の特例減額措置対象;
    @CsvField(order = 830, name = "課税層の特例減額措置対象名称")
    private RString 課税層の特例減額措置対象名称;
    @CsvField(order = 840, name = "課税層の特例減額適用開始日")
    private RString 課税層の特例減額適用開始日;
    @CsvField(order = 850, name = "課税層の特例減額適用終了日")
    private RString 課税層の特例減額適用終了日;
    @CsvField(order = 860, name = "特定入所者食費負担限度額")
    private RString 特定入所者食費負担限度額;
    @CsvField(order = 870, name = "居住費（ユニット型個室）負担限度額")
    private RString 居住費_ユニット型個室_負担限度額;
    @CsvField(order = 880, name = "居住費（従来型個室（特養等））負担限度額")
    private RString 居住費_従来型個室_特養等_負担限度額;
    @CsvField(order = 890, name = "居住費（多床室）負担限度額")
    private RString 居住費_多床室_負担限度額;
    @CsvField(order = 900, name = "居住費（新１）負担限度額")
    private RString 居住費_新１_負担限度額;
    @CsvField(order = 910, name = "居住費（新２）負担限度額")
    private RString 居住費_新２_負担限度額;
    @CsvField(order = 920, name = "居住費（新３）負担限度額")
    private RString 居住費_新３_負担限度額;
    @CsvField(order = 930, name = "居住費（ユニット型準個室）負担限度額")
    private RString 居住費_ユニット型準個室_負担限度額;
    @CsvField(order = 940, name = "居住費（従来型個室（老健、療養等））負担限度額")
    private RString 居住費_従来型個室_老健_療養等_負担限度額;
    @CsvField(order = 950, name = "二割割合適用開始日")
    private RString 二割割合適用開始日;
    @CsvField(order = 960, name = "二割割合適用終了日")
    private RString 二割割合適用終了日;
    @CsvField(order = 970, name = "社会福祉法人軽減率")
    private RString 社会福祉法人軽減率;
    @CsvField(order = 980, name = "社会福祉法人適用開始日")
    private RString 社会福祉法人適用開始日;
    @CsvField(order = 990, name = "社会福祉法人適用終了日")
    private RString 社会福祉法人適用終了日;
    @CsvField(order = 1000, name = "後期被保険者番号")
    private RString 後期被保険者番号;
    @CsvField(order = 1010, name = "後期保険者番号")
    private RString 後期保険者番号;
    @CsvField(order = 1020, name = "国保保険者番号")
    private RString 国保保険者番号;
    @CsvField(order = 1030, name = "国保被保険者証番号")
    private RString 国保被保険者証番号;
    @CsvField(order = 1040, name = "個人番号")
    private RString 個人番号;

}
