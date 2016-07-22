/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.DBDBT13011;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（汎用リスト　施設入退所）CSV用データEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GeneralPurposeListOutputEucCsvEntity {

    @CsvField(order = 1, name = "連番")
    private RString 連番;
    @CsvField(order = 2, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 3, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 4, name = "氏名")
    private RString 氏名;
    @CsvField(order = 5, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 6, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 7, name = "年齢")
    private RString 年齢;
    @CsvField(order = 8, name = "性別")
    private RString 性別;
    @CsvField(order = 9, name = "続柄コード")
    private RString 続柄コード;
    @CsvField(order = 10, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 11, name = "世帯主名")
    private RString 世帯主名;
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
    private RString 行政区コード;
    @CsvField(order = 19, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 20, name = "地区１")
    private RString 地区１;
    @CsvField(order = 21, name = "地区２")
    private RString 地区２;
    @CsvField(order = 22, name = "地区３")
    private RString 地区３;
    @CsvField(order = 23, name = "連絡先１")
    private RString 連絡先１;
    @CsvField(order = 24, name = "連絡先２")
    private RString 連絡先２;
    @CsvField(order = 25, name = "登録異動日")
    private RString 登録異動日;
    @CsvField(order = 26, name = "登録事由")
    private RString 登録事由;
    @CsvField(order = 27, name = "登録届出日")
    private RString 登録届出日;
    @CsvField(order = 28, name = "住定異動日")
    private RString 住定異動日;
    @CsvField(order = 29, name = "住定事由")
    private RString 住定事由;
    @CsvField(order = 30, name = "住定届出日")
    private RString 住定届出日;
    @CsvField(order = 31, name = "消除異動日")
    private RString 消除異動日;
    @CsvField(order = 32, name = "消除事由")
    private RString 消除事由;
    @CsvField(order = 33, name = "消除届出日")
    private RString 消除届出日;
    @CsvField(order = 34, name = "転出入理由")
    private RString 転出入理由;
    @CsvField(order = 35, name = "前住所郵便番号")
    private RString 前住所郵便番号;
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
    private RString 保険者コード;
    @CsvField(order = 43, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 44, name = "空白")
    private RString 空白;
    @CsvField(order = 45, name = "送付先氏名")
    private RString 送付先氏名;
    @CsvField(order = 46, name = "送付先氏名カナ")
    private RString 送付先氏名カナ;
    @CsvField(order = 47, name = "送付先住所コード")
    private RString 送付先住所コード;
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
    private RString 送付先行政区コード;
    @CsvField(order = 54, name = "送付先行政区名")
    private RString 送付先行政区名;
    @CsvField(order = 55, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 56, name = "資格取得事由")
    private RString 資格取得事由;
    @CsvField(order = 57, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 58, name = "資格取得届出日")
    private RString 資格取得届出日;
    @CsvField(order = 59, name = "喪失事由")
    private RString 喪失事由;
    @CsvField(order = 60, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 61, name = "資格喪失届日")
    private RString 資格喪失届日;
    @CsvField(order = 62, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 63, name = "住所地特例状態")
    private RString 住所地特例状態;
    @CsvField(order = 64, name = "（資格）証記載保険者番号")
    private RString 資格_証記載保険者番号;
    @CsvField(order = 65, name = "医療保険種別")
    private RString 医療保険種別;
    @CsvField(order = 66, name = "医療保険番号")
    private RString 医療保険番号;
    @CsvField(order = 67, name = "医療保険者名")
    private RString 医療保険者名;
    @CsvField(order = 68, name = "医療保険記号番号")
    private RString 医療保険記号番号;
    @CsvField(order = 69, name = "特定疾病")
    private RString 特定疾病;
    @CsvField(order = 70, name = "受給申請事由")
    private RString 受給申請事由;
    @CsvField(order = 71, name = "申請理由")
    private RString 申請理由;
    @CsvField(order = 72, name = "申請関係者")
    private RString 申請関係者;
    @CsvField(order = 73, name = "本人関係")
    private RString 本人関係;
    @CsvField(order = 74, name = "申請氏名")
    private RString 申請氏名;
    @CsvField(order = 75, name = "申請氏名カナ")
    private RString 申請氏名カナ;
    @CsvField(order = 76, name = "申請代行事業者名")
    private RString 申請代行事業者名;
    @CsvField(order = 77, name = "申請代行事業者名カナ")
    private RString 申請代行事業者名カナ;
    @CsvField(order = 78, name = "申請者郵便番号")
    private RString 申請者郵便番号;
    @CsvField(order = 79, name = "申請住所")
    private RString 申請住所;
    @CsvField(order = 80, name = "申請連絡先")
    private RString 申請連絡先;
    @CsvField(order = 81, name = "申請事業コード")
    private RString 申請事業コード;
    @CsvField(order = 82, name = "受給申請日")
    private RString 受給申請日;
    @CsvField(order = 83, name = "調査委託先コード")
    private RString 調査委託先コード;
    @CsvField(order = 84, name = "調査員コード")
    private RString 調査員コード;
    @CsvField(order = 85, name = "委託先名")
    private RString 委託先名;
    @CsvField(order = 86, name = "委託先名カナ")
    private RString 委託先名カナ;
    @CsvField(order = 87, name = "委託先代表者名")
    private RString 委託先代表者名;
    @CsvField(order = 88, name = "委託先代表者名カナ")
    private RString 委託先代表者名カナ;
    @CsvField(order = 89, name = "委託先郵便番号")
    private RString 委託先郵便番号;
    @CsvField(order = 90, name = "委託先住所")
    private RString 委託先住所;
    @CsvField(order = 91, name = "委託先連絡先")
    private RString 委託先連絡先;
    @CsvField(order = 92, name = "委託先状況")
    private RString 委託先状況;
    @CsvField(order = 93, name = "調査員氏名")
    private RString 調査員氏名;
    @CsvField(order = 94, name = "調査員氏名カナ")
    private RString 調査員氏名カナ;
    @CsvField(order = 95, name = "調査員性別")
    private RString 調査員性別;
    @CsvField(order = 96, name = "調査員郵便")
    private RString 調査員郵便;
    @CsvField(order = 97, name = "調査員住所")
    private RString 調査員住所;
    @CsvField(order = 98, name = "調査員連絡先")
    private RString 調査員連絡先;
    @CsvField(order = 99, name = "調査員資格")
    private RString 調査員資格;
    @CsvField(order = 100, name = "調査員所属機関名")
    private RString 調査員所属機関名;
    @CsvField(order = 101, name = "調査員状況")
    private RString 調査員状況;
    @CsvField(order = 102, name = "医療機関コード")
    private RString 医療機関コード;
    @CsvField(order = 103, name = "主治医コード")
    private RString 主治医コード;
    @CsvField(order = 104, name = "医療機関名称")
    private RString 医療機関名称;
    @CsvField(order = 105, name = "医療機関名称カナ")
    private RString 医療機関名称カナ;
    @CsvField(order = 106, name = "医療機関代表者名")
    private RString 医療機関代表者名;
    @CsvField(order = 107, name = "医療機関代表者名カナ")
    private RString 医療機関代表者名カナ;
    @CsvField(order = 108, name = "医療機関郵便番号")
    private RString 医療機関郵便番号;
    @CsvField(order = 109, name = "医療機関住所")
    private RString 医療機関住所;
    @CsvField(order = 110, name = "医療機関連絡先")
    private RString 医療機関連絡先;
    @CsvField(order = 111, name = "医療機関状況")
    private RString 医療機関状況;
    @CsvField(order = 112, name = "主治医名")
    private RString 主治医名;
    @CsvField(order = 113, name = "主治医名カナ")
    private RString 主治医名カナ;
    @CsvField(order = 114, name = "主治医性別")
    private RString 主治医性別;
    @CsvField(order = 115, name = "主治医所属")
    private RString 主治医所属;
    @CsvField(order = 116, name = "主治医状況")
    private RString 主治医状況;
    @CsvField(order = 117, name = "一次判定要介護度")
    private RString 一次判定要介護度;
    @CsvField(order = 118, name = "調査委託日")
    private RString 調査委託日;
    @CsvField(order = 119, name = "調査予定日")
    private RString 調査予定日;
    @CsvField(order = 120, name = "調査終了日")
    private RString 調査終了日;
    @CsvField(order = 121, name = "意見依頼日")
    private RString 意見依頼日;
    @CsvField(order = 122, name = "意見予定日")
    private RString 意見予定日;
    @CsvField(order = 123, name = "意見取寄日")
    private RString 意見取寄日;
    @CsvField(order = 124, name = "資料作成日")
    private RString 資料作成日;
    @CsvField(order = 125, name = "審査予定日")
    private RString 審査予定日;
    @CsvField(order = 126, name = "審査回答日")
    private RString 審査回答日;
    @CsvField(order = 127, name = "一次判定日")
    private RString 一次判定日;
    @CsvField(order = 128, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 129, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 130, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 131, name = "認定日")
    private RString 認定日;
    @CsvField(order = 132, name = "旧措置")
    private RString 旧措置;
    @CsvField(order = 133, name = "みなし更新認定")
    private RString みなし更新認定;
    @CsvField(order = 134, name = "審査会意見")
    private RString 審査会意見;
    @CsvField(order = 135, name = "指定サービス種類")
    private RString 指定サービス種類;
    @CsvField(order = 136, name = "受給喪失日")
    private RString 受給喪失日;
    @CsvField(order = 137, name = "直近事由")
    private RString 直近事由;
    @CsvField(order = 138, name = "受給状況")
    private RString 受給状況;
    @CsvField(order = 139, name = "異動事由コード")
    private RString 異動事由コード;
    @CsvField(order = 140, name = "異動事由追加文")
    private RString 異動事由追加文;
    @CsvField(order = 141, name = "削除理由コード")
    private RString 削除理由コード;
    @CsvField(order = 142, name = "異動事由文言")
    private RString 異動事由文言;
    @CsvField(order = 143, name = "削除理由文言")
    private RString 削除理由文言;
    @CsvField(order = 144, name = "支援申請区分")
    private RString 支援申請区分;
    @CsvField(order = 145, name = "初回申請日")
    private RString 初回申請日;
    @CsvField(order = 146, name = "初回認定日")
    private RString 初回認定日;
    @CsvField(order = 147, name = "初回要介護度")
    private RString 初回要介護度;
    @CsvField(order = 148, name = "初回認定開始日")
    private RString 初回認定開始日;
    @CsvField(order = 149, name = "初回認定終了日")
    private RString 初回認定終了日;
    @CsvField(order = 150, name = "初回申請事由")
    private RString 初回申請事由;
    @CsvField(order = 151, name = "初回みなし更新")
    private RString 初回みなし更新;
    @CsvField(order = 152, name = "初回当初認定有効開始日")
    private RString 初回当初認定有効開始日;
    @CsvField(order = 153, name = "初回当初認定有効終了日")
    private RString 初回当初認定有効終了日;
    @CsvField(order = 154, name = "初回支援申請事由")
    private RString 初回支援申請事由;
    @CsvField(order = 155, name = "前回申請日")
    private RString 前回申請日;
    @CsvField(order = 156, name = "前回認定日")
    private RString 前回認定日;
    @CsvField(order = 157, name = "前回要介護度")
    private RString 前回要介護度;
    @CsvField(order = 158, name = "前回認定開始日")
    private RString 前回認定開始日;
    @CsvField(order = 159, name = "前回認定終了日")
    private RString 前回認定終了日;
    @CsvField(order = 160, name = "前回受給申請事由")
    private RString 前回受給申請事由;
    @CsvField(order = 161, name = "前回みなし更新")
    private RString 前回みなし更新;
    @CsvField(order = 162, name = "前回当初認定有効開始日")
    private RString 前回当初認定有効開始日;
    @CsvField(order = 163, name = "前回当初認定有効終了日")
    private RString 前回当初認定有効終了日;
    @CsvField(order = 164, name = "前回支援申請事由")
    private RString 前回支援申請事由;
    @CsvField(order = 165, name = "前々回申請日")
    private RString 前々回申請日;
    @CsvField(order = 166, name = "前々回認定日")
    private RString 前々回認定日;
    @CsvField(order = 167, name = "前々回要介護度")
    private RString 前々回要介護度;
    @CsvField(order = 168, name = "前々回認定開始日")
    private RString 前々回認定開始日;
    @CsvField(order = 169, name = "前々回認定終了日")
    private RString 前々回認定終了日;
    @CsvField(order = 170, name = "前々回受給申請事由")
    private RString 前々回受給申請事由;
    @CsvField(order = 171, name = "前々回みなし更新")
    private RString 前々回みなし更新;
    @CsvField(order = 172, name = "前々回当初認定有効開始日")
    private RString 前々回当初認定有効開始日;
    @CsvField(order = 173, name = "前々回当初認定有効終了日")
    private RString 前々回当初認定有効終了日;
    @CsvField(order = 174, name = "前々回支援申請事由")
    private RString 前々回支援申請事由;
    @CsvField(order = 175, name = "障害高齢者自立度")
    private RString 障害高齢者自立度;
    @CsvField(order = 176, name = "認知症高齢者自立度")
    private RString 認知症高齢者自立度;
    @CsvField(order = 177, name = "訪問支給限度額単位数")
    private RString 訪問支給限度額単位数;
    @CsvField(order = 178, name = "訪問支給限度有効開始年月日")
    private RString 訪問支給限度有効開始年月日;
    @CsvField(order = 179, name = "訪問支給限度有効終了年月日")
    private RString 訪問支給限度有効終了年月日;
    @CsvField(order = 180, name = "短期入所支給限度日数")
    private RString 短期入所支給限度日数;
    @CsvField(order = 181, name = "短期入所支給限度有効開始年月日")
    private RString 短期入所支給限度有効開始年月日;
    @CsvField(order = 182, name = "短期入所支給限度有効終了年月日")
    private RString 短期入所支給限度有効終了年月日;
    @CsvField(order = 183, name = "当初認定有効開始年月日")
    private RString 当初認定有効開始年月日;
    @CsvField(order = 184, name = "当初認定有効終了年月日")
    private RString 当初認定有効終了年月日;
    @CsvField(order = 185, name = "認定延期通知書発行年月日")
    private RString 認定延期通知書発行年月日;
    @CsvField(order = 186, name = "認定延期通知書発行回数")
    private RString 認定延期通知書発行回数;
    @CsvField(order = 187, name = "延期処理見込み開始年月日")
    private RString 延期処理見込み開始年月日;
    @CsvField(order = 188, name = "延期処理見込み終了年月日")
    private RString 延期処理見込み終了年月日;
    @CsvField(order = 189, name = "受給資格証明書発行日１")
    private RString 受給資格証明書発行日１;
    @CsvField(order = 190, name = "受給資格証明書発行日２")
    private RString 受給資格証明書発行日２;
    @CsvField(order = 191, name = "一次判定結果（重み）")
    private RString 一次判定結果_重み;
    @CsvField(order = 192, name = "資格取得前申請区分")
    private RString 資格取得前申請区分;
    @CsvField(order = 193, name = "指定医区分")
    private RString 指定医区分;
    @CsvField(order = 194, name = "訪問調査先郵便番号")
    private RString 訪問調査先郵便番号;
    @CsvField(order = 195, name = "訪問調査先住所")
    private RString 訪問調査先住所;
    @CsvField(order = 196, name = "訪問調査先名称")
    private RString 訪問調査先名称;
    @CsvField(order = 197, name = "訪問調査先電話番号")
    private RString 訪問調査先電話番号;
    @CsvField(order = 198, name = "指定事業者コード")
    private RString 指定事業者コード;
    @CsvField(order = 199, name = "施設入所日")
    private RString 施設入所日;
    @CsvField(order = 200, name = "施設退所日")
    private RString 施設退所日;
    @CsvField(order = 201, name = "指定事業者名")
    private RString 指定事業者名;
    @CsvField(order = 202, name = "指定事業者名カナ")
    private RString 指定事業者名カナ;
    @CsvField(order = 203, name = "指定事業者郵便番号")
    private RString 指定事業者郵便番号;
    @CsvField(order = 204, name = "指定事業者住所")
    private RString 指定事業者住所;
    @CsvField(order = 205, name = "指定事業者代表者名")
    private RString 指定事業者代表者名;
    @CsvField(order = 206, name = "指定事業者代表者名カナ")
    private RString 指定事業者代表者名カナ;
    @CsvField(order = 207, name = "指定事業者代表者役職")
    private RString 指定事業者代表者役職;
    @CsvField(order = 208, name = "指定事業者電話番号")
    private RString 指定事業者電話番号;
    @CsvField(order = 209, name = "指定事業者ＦＡＸ番号")
    private RString 指定事業者ＦＡＸ番号;
    @CsvField(order = 210, name = "指定事業者ケアマネ数")
    private RString 指定事業者ケアマネ数;
    @CsvField(order = 211, name = "指定事業者利用者数")
    private RString 指定事業者利用者数;
    @CsvField(order = 212, name = "指定事業者認定日")
    private RString 指定事業者認定日;
    @CsvField(order = 213, name = "指定事業者取消日")
    private RString 指定事業者取消日;
    @CsvField(order = 214, name = "指定事業者実施地域")
    private RString 指定事業者実施地域;
    @CsvField(order = 215, name = "転出先保険者番号")
    private RString 転出先保険者番号;
    @CsvField(order = 216, name = "届出区分")
    private RString 届出区分;
    @CsvField(order = 217, name = "居宅計画作成区分")
    private RString 居宅計画作成区分;
    @CsvField(order = 218, name = "計画事業者番号")
    private RString 計画事業者番号;
    @CsvField(order = 219, name = "計画事業者名")
    private RString 計画事業者名;
    @CsvField(order = 220, name = "計画事業者カナ")
    private RString 計画事業者カナ;
    @CsvField(order = 221, name = "計画管理者名")
    private RString 計画管理者名;
    @CsvField(order = 222, name = "計画管理者カナ")
    private RString 計画管理者カナ;
    @CsvField(order = 223, name = "計画適用開始日")
    private RString 計画適用開始日;
    @CsvField(order = 224, name = "計画適用終了日")
    private RString 計画適用終了日;
    @CsvField(order = 225, name = "計画届出日")
    private RString 計画届出日;
    @CsvField(order = 226, name = "計画作成日")
    private RString 計画作成日;
    @CsvField(order = 227, name = "計画変更日")
    private RString 計画変更日;
    @CsvField(order = 228, name = "変更理由")
    private RString 変更理由;
}
