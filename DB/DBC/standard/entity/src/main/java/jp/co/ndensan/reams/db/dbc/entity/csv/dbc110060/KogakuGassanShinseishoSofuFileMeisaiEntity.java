/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110060;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給申請書情報作成の送付ファイルのデータレコードです。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoSofuFileMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "データレコード種別")
    private RString データレコード種別;
    @CsvField(order = 50, name = "被保険者氏名（カナ）")
    private RString 被保険者氏名_カナ;
    @CsvField(order = 60, name = "被保険者氏名（漢字）")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 70, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 80, name = "性別")
    private RString 性別;
    @CsvField(order = 90, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 100, name = "70歳以上の者に係る所得区分")
    private RString over70_所得区分;
    @CsvField(order = 110, name = "被保険者資格喪失年月日")
    private RString 被保険者資格喪失年月日;
    @CsvField(order = 120, name = "被保険者資格喪失事由")
    private RString 被保険者資格喪失事由;
    @CsvField(order = 130, name = "計算期間の始期")
    private RString 計算期間の始期;
    @CsvField(order = 140, name = "計算期間の終期")
    private RString 計算期間の終期;
    @CsvField(order = 150, name = "国保資格・保険者番号")
    private RString 国保資格_保険者番号;
    @CsvField(order = 160, name = "国保資格・被保険者証記号")
    private RString 国保資格_被保険者証記号;
    @CsvField(order = 170, name = "国保資格・被保険者証番号")
    private RString 国保資格_被保険者証番号;
    @CsvField(order = 180, name = "国保資格・世帯番号")
    private RString 国保資格_世帯番号;
    @CsvField(order = 190, name = "国保資格・続柄")
    private RString 国保資格_続柄;
    @CsvField(order = 200, name = "国保資格・保険者名称")
    private RString 国保資格_保険者名称;
    @CsvField(order = 210, name = "国保資格・加入期間（開始年月日）")
    private RString 国保資格_加入開始年月日;
    @CsvField(order = 220, name = "国保資格・加入期間（終了年月日）")
    private RString 国保資格_加入終了年月日;
    @CsvField(order = 230, name = "後期資格・保険者番号")
    private RString 後期資格_保険者番号;
    @CsvField(order = 240, name = "後期資格・被保険者番号")
    private RString 後期資格_被保険者番号;
    @CsvField(order = 250, name = "後期資格・広域連合名称")
    private RString 後期資格_広域連合名称;
    @CsvField(order = 260, name = "後期資格・加入期間（開始年月日）")
    private RString 後期資格_加入開始年月日;
    @CsvField(order = 270, name = "後期資格・加入期間（終了年月日）")
    private RString 後期資格_加入終了年月日;
    @CsvField(order = 280, name = "介護資格・証記載保険者番号")
    private RString 介護資格_証記載保険者番号;
    @CsvField(order = 290, name = "介護資格・被保険者番号")
    private RString 介護資格_被保険者番号;
    @CsvField(order = 300, name = "介護資格・保険者名称")
    private RString 介護資格_保険者名称;
    @CsvField(order = 310, name = "介護資格・加入期間（開始年月日）")
    private RString 介護資格_加入開始年月日;
    @CsvField(order = 320, name = "介護資格・加入期間（終了年月日）")
    private RString 介護資格_加入終了年月日;
    @CsvField(order = 330, name = "支給方法")
    private RString 支給方法;
    @CsvField(order = 340, name = "口座管理番号")
    private RString 口座管理番号;
    @CsvField(order = 350, name = "金融機関コード")
    private RString 金融機関コード;
    @CsvField(order = 360, name = "店舗コード")
    private RString 店舗コード;
    @CsvField(order = 370, name = "種目")
    private RString 種目;
    @CsvField(order = 380, name = "口座番号")
    private RString 口座番号;
    @CsvField(order = 390, name = "口座名義人（カナ）")
    private RString 口座名義人_カナ;
    @CsvField(order = 400, name = "振込先口座管理番号")
    private RString 振込先口座管理番号;
    @CsvField(order = 410, name = "保険者名①")
    private RString 保険者名1;
    @CsvField(order = 420, name = "加入期間（開始年月日）①")
    private RString 加入期間_開始年月日1;
    @CsvField(order = 430, name = "加入期間（終了年月日）①")
    private RString 加入期間_終了年月日1;
    @CsvField(order = 440, name = "自己負担額証明書整理番号①")
    private RString 自己負担額証明書整理番号1;
    @CsvField(order = 450, name = "保険者名②")
    private RString 保険者名2;
    @CsvField(order = 460, name = "加入期間（開始年月日）②")
    private RString 加入期間_開始年月日2;
    @CsvField(order = 470, name = "加入期間（終了年月日）②")
    private RString 加入期間_終了年月日2;
    @CsvField(order = 480, name = "自己負担額証明書整理番号②")
    private RString 自己負担額証明書整理番号2;
    @CsvField(order = 490, name = "保険者名③")
    private RString 保険者名3;
    @CsvField(order = 500, name = "加入期間（開始年月日）③")
    private RString 加入期間_開始年月日3;
    @CsvField(order = 510, name = "加入期間（終了年月日）③")
    private RString 加入期間_終了年月日3;
    @CsvField(order = 520, name = "自己負担額証明書整理番号③")
    private RString 自己負担額証明書整理番号3;
    @CsvField(order = 530, name = "保険者名④")
    private RString 保険者名4;
    @CsvField(order = 540, name = "加入期間（開始年月日）④")
    private RString 加入期間_開始年月日4;
    @CsvField(order = 550, name = "加入期間（終了年月日）④")
    private RString 加入期間_終了年月日4;
    @CsvField(order = 560, name = "自己負担額証明書整理番号④")
    private RString 自己負担額証明書整理番号4;
    @CsvField(order = 570, name = "保険者名⑤")
    private RString 保険者名5;
    @CsvField(order = 580, name = "加入期間（開始年月日）⑤")
    private RString 加入期間_開始年月日5;
    @CsvField(order = 590, name = "加入期間（終了年月日）⑤")
    private RString 加入期間_終了年月日5;
    @CsvField(order = 600, name = "自己負担額証明書整理番号⑤")
    private RString 自己負担額証明書整理番号5;
    @CsvField(order = 610, name = "保険者名⑥")
    private RString 保険者名6;
    @CsvField(order = 620, name = "加入期間（開始年月日）⑥")
    private RString 加入期間_開始年月日6;
    @CsvField(order = 630, name = "加入期間（終了年月日）⑥")
    private RString 加入期間_終了年月日6;
    @CsvField(order = 640, name = "自己負担額証明書整理番号⑥")
    private RString 自己負担額証明書整理番号6;
    @CsvField(order = 650, name = "保険者名⑦")
    private RString 保険者名7;
    @CsvField(order = 660, name = "加入期間（開始年月日）⑦")
    private RString 加入期間_開始年月日7;
    @CsvField(order = 670, name = "加入期間（終了年月日）⑦")
    private RString 加入期間_終了年月日7;
    @CsvField(order = 680, name = "自己負担額証明書整理番号⑦")
    private RString 自己負担額証明書整理番号7;
    @CsvField(order = 690, name = "保険者名⑧")
    private RString 保険者名8;
    @CsvField(order = 700, name = "加入期間（開始年月日）⑧")
    private RString 加入期間_開始年月日8;
    @CsvField(order = 710, name = "加入期間（終了年月日）⑧")
    private RString 加入期間_終了年月日8;
    @CsvField(order = 720, name = "自己負担額証明書整理番号⑧")
    private RString 自己負担額証明書整理番号8;
    @CsvField(order = 730, name = "保険者名⑨")
    private RString 保険者名9;
    @CsvField(order = 740, name = "加入期間（開始年月日）⑨")
    private RString 加入期間_開始年月日9;
    @CsvField(order = 750, name = "加入期間（終了年月日）⑨")
    private RString 加入期間_終了年月日9;
    @CsvField(order = 760, name = "自己負担額証明書整理番号⑨")
    private RString 自己負担額証明書整理番号9;
    @CsvField(order = 770, name = "保険者名⑩")
    private RString 保険者名10;
    @CsvField(order = 780, name = "加入期間（開始年月日）⑩")
    private RString 加入期間_開始年月日10;
    @CsvField(order = 790, name = "加入期間（終了年月日）⑩")
    private RString 加入期間_終了年月日10;
    @CsvField(order = 800, name = "自己負担額証明書整理番号⑩")
    private RString 自己負担額証明書整理番号10;
    @CsvField(order = 810, name = "備考")
    private RString 備考;
}
