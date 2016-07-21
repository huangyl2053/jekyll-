/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyojisshitsufutan;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険連絡票_実質負担軽減者用Entityクラスです。
 *
 * @reamsid_L DBA-1290-060 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigohokenRenrakuhyoJisshitsuFutan {

    private RString 作成年月日;
    private RString 被保険者番号;
    private RString 氏名フリガナ;
    private RString 被保険者氏名;
    private RString 生年月日;
    private RString 性別;
    private RString 住所;
    private RString 電話番号;
    private RString 要介護チェック;
    private RString 要介護度段階;
    private RString 要支援チェック;
    private RString 要支援段階;
    private RString 認定非該当チェック;
    private RString 未認定チェック;
    private RString 認定年月日;
    private RString 給付減額の記載チェック;
    private RString 給付減額;
    private RString 居住費の負担限度日額記載チェック;
    private RString 第1段階_個室チェック;
    private RString 第1段階_個室金額;
    private RString 第2段階_個室チェック;
    private RString 第2段階_個室金額;
    private RString 第3段階_個室チェック;
    private RString 第3段階_個室金額;
    private RString 基準額_個室チェック;
    private RString 基準額_個室金額;
    private RString 第1段階_準個室チェック;
    private RString 第1段階_準個室金額;
    private RString 第2_1段階_準個室チェック;
    private RString 第2_1段階_準個室金額;
    private RString 第2_2段階_準個室チェック;
    private RString 第2_2段階_準個室金額;
    private RString 第3段階_準個室チェック;
    private RString 第3段階_準個室金額;
    private RString 基準額_準個室チェック;
    private RString 基準額_準個室金額;
    private RString 第1段階_従来型個室_特養チェック;
    private RString 第1段階_従来型個室_特養金額;
    private RString 第2_1段階_従来型個室_特養チェック;
    private RString 第2_1段階_従来型個室_特養金額;
    private RString 第2_2段階_従来型個室_特養チェック;
    private RString 第2_2段階_従来型個室_特養金額;
    private RString 第2_3段階_従来型個室_特養チェック;
    private RString 第2_3段階_従来型個室_特養金額;
    private RString 第3段階_従来型個室_特養チェック;
    private RString 第3段階_従来型個室_特養金額;
    private RString 基準額_従来型個室_特養チェック;
    private RString 基準額_従来型個室_特養金額;
    private RString 第1段階_多床室チェック;
    private RString 第1段階_多床室金額;
    private RString 第2_1段階_多床室チェック;
    private RString 第2_1段階_多床室金額;
    private RString 第2_2段階_多床室チェック;
    private RString 第2_2段階_多床室金額;
    private RString 第3段階_多床室チェック;
    private RString 第3段階_多床室金額;
    private RString 基準額_多床室チェック;
    private RString 基準額_多床室金額;
    private RString 食費負担限度額記載チェック;
    private RString 食費チェック1;
    private RString 食費金額1;
    private RString 食費チェック2;
    private RString 食費金額2;
    private RString 食費チェック3;
    private RString 食費金額3;
    private RString 食費チェック4;
    private RString 食費金額4;
    private RString 食費金額その他;
    private RString 高額介護サービス費の支給による自己負担上限月額記載チェック;
    private RString 高額介護チェック1;
    private RString 高額介護金額1;
    private RString 高額介護チェック2;
    private RString 高額介護金額2;
    private RString 高額介護チェック3;
    private RString 高額介護金額3;
    private RString 高額介護チェック4;
    private RString 高額介護金額4;
    private RString 高額介護金額その他;
    private RString 介護保険料記載チェック;
    private RString 保険料チェック1;
    private RString 保険料金額1;
    private RString 保険料チェック2;
    private RString 保険料金額2;
    private RString 保険料チェック3;
    private RString 保険料金額3;
    private RString 保険料チェック4;
    private RString 保険料金額4;
    private RString 保険料チェック5;
    private RString 保険料金額5;
    private RString 保険料チェック6;
    private RString 保険料金額6;
    private RString 保険料チェック7;
    private RString 保険料金額7;
    private RString 保険料チェック8;
    private RString 保険料金額8;
    private RString 保険料チェック9;
    private RString 保険料金額9;
    private RString 保険料チェック10;
    private RString 保険料金額10;
    private RString 保険料チェック11;
    private RString 保険料金額11;
    private RString 保険料チェックその他;
    private RString 保険料金額その他;
    private RString 保険料段階1;
    private RString 保険料段階2;
    private RString 保険料段階3;
    private RString 保険料段階4;
    private RString 保険料段階5;
    private RString 保険料段階6;
    private RString 保険料段階7;
    private RString 保険料段階8;
    private RString 保険料段階9;
    private RString 保険料段階10;
    private RString 保険料段階11;
    private RString 保険料段階12;
    private RString 備考;
    private RString 保険料段階1_上段;
    private RString 保険料段階2_上段;
    private RString 保険料段階3_上段;
    private RString 保険料段階4_上段;
    private RString 保険料段階5_上段;
    private RString 保険料段階6_上段;
    private RString 保険料段階7_上段;
    private RString 保険料段階8_上段;
    private RString 保険料段階9_上段;
    private RString 保険料段階10_上段;
    private RString 保険料段階11_上段;
    private RString 保険料段階12_上段;
    private RString 保険料段階1_下段;
    private RString 保険料段階2_下段;
    private RString 保険料段階3_下段;
    private RString 保険料段階4_下段;
    private RString 保険料段階5_下段;
    private RString 保険料段階6_下段;
    private RString 保険料段階7_下段;
    private RString 保険料段階8_下段;
    private RString 保険料段階9_下段;
    private RString 保険料段階10_下段;
    private RString 保険料段階11_下段;
    private RString 保険料段階12_下段;

}
