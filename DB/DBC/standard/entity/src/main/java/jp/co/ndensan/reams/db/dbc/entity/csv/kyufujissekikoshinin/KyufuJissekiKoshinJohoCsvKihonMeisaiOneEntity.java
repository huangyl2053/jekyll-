/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績更新結果情報取込の基本情報レコード（交換情報識別番号＝1141～1144）のCsvMeisaiEntity
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity {
    
    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 50, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 60, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 70, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 100, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 110, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 120, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 130, name = "公費1負担者番号")
    private RString 公費1負担者番号;
    @CsvField(order = 140, name = "公費1受給者番号")
    private RString 公費1受給者番号;
    @CsvField(order = 150, name = "公費2負担者番号")
    private RString 公費2負担者番号;
    @CsvField(order = 160, name = "公費2受給者番号")
    private RString 公費2受給者番号;
    @CsvField(order = 170, name = "公費3負担者番号")
    private RString 公費3負担者番号;
    @CsvField(order = 180, name = "公費3受給者番号")
    private RString 公費3受給者番号;
    @CsvField(order = 190, name = "被保険者情報生年月日")
    private RString 被保険者情報生年月日;
    @CsvField(order = 200, name = "被保険者情報性別コード")
    private RString 被保険者情報性別コード;
    @CsvField(order = 210, name = "被保険者情報要介護状態区分コード")
    private RString 被保険者情報要介護状態区分コード;
    @CsvField(order = 220, name = "被保険者情報旧措置入所者特例コード")
    private RString 被保険者情報旧措置入所者特例コード;
    @CsvField(order = 230, name = "被保険者情報認定有効期間 開始年月日")
    private RString 被保険者情報認定有効期間開始年月日;
    @CsvField(order = 240, name = "被保険者情報認定有効期間 終了年がぴ")
    private RString 被保険者情報認定有効期間終了年がぴ;
    @CsvField(order = 250, name = "被保険者情報老人保健市町村番号")
    private RString 被保険者情報老人保健市町村番号;
    @CsvField(order = 260, name = "被保険者情報老人保健受給者番号")
    private RString 被保険者情報老人保健受給者番号;
    @CsvField(order = 270, name = "居宅サービス計画居宅サービス計画作成区分コード")
    private RString 居宅サービス計画居宅サービス計画作成区分コード;
    @CsvField(order = 280, name = "居宅サービス計画事業所番号（居宅介護支援事業所等）")
    private RString 居宅サービス計画事業所番号_居宅介護支援事業所等;
    @CsvField(order = 290, name = "開始年月日")
    private RString 開始年月日;
    @CsvField(order = 300, name = "中止年月日")
    private RString 中止年月日;
    @CsvField(order = 310, name = "中止理由・入所（院）前の状況コード")
    private RString 中止理由又は入所院前の状況コード;
    @CsvField(order = 320, name = "入所（院）年月日")
    private RString 入所院年月日;
    @CsvField(order = 330, name = "退所（院）年月日")
    private RString 退所院年月日;
    @CsvField(order = 340, name = "入所（院）実日数")
    private RString 入所院実日数;
    @CsvField(order = 350, name = "外泊日数")
    private RString 外泊日数;
    @CsvField(order = 360, name = "退所（院）後の状態コード")
    private RString 退所院後の状態コード;
    @CsvField(order = 370, name = "保険給付率")
    private RString 保険給付率;
    @CsvField(order = 380, name = "公費１給付率")
    private RString 公費１給付率;
    @CsvField(order = 390, name = "公費２給付率")
    private RString 公費２給付率;
    @CsvField(order = 400, name = "公費３給付率")
    private RString 公費３給付率;
    @CsvField(order = 410, name = "合計情報（決定前）保険サービス単位数")
    private RString 合計情報決定前保険サービス単位数;
    @CsvField(order = 420, name = "合計情報（決定前）保険請求額")
    private RString 合計情報決定前保険請求額;
    @CsvField(order = 430, name = "合計情報（決定前）保険利用者負担額")
    private RString 合計情報決定前保険利用者負担額;
    @CsvField(order = 440, name = "合計情報（決定前）保険緊急時施設療養費請求額")
    private RString 合計情報決定前保険緊急時施設療養費請求額;
    @CsvField(order = 450, name = "合計情報（決定前）保険特定診療費請求額")
    private RString 合計情報決定前保険特定診療費請求額;
    @CsvField(order = 460, name = "合計情報（決定前）保険特定入所者介護サービス費等請求額")
    private RString 合計情報決定前保険特定入所者介護サービス費等請求額;
    @CsvField(order = 470, name = "合計情報（決定前）公費１サービス単位数")
    private RString 合計情報決定前公費１サービス単位数;
    @CsvField(order = 480, name = "合計情報（決定前）公費１請求額")
    private RString 合計情報決定前公費１請求額;
    @CsvField(order = 490, name = "合計情報（決定前）公費１本人負担額")
    private RString 合計情報決定前公費１本人負担額;
    @CsvField(order = 500, name = "合計情報（決定前）公費１緊急時施設療養費請求額")
    private RString 合計情報決定前公費１緊急時施設療養費請求額;
    @CsvField(order = 510, name = "合計情報（決定前）公費１特定診療費請求額")
    private RString 合計情報決定前公費１特定診療費請求額;
    @CsvField(order = 520, name = "合計情報（決定前）公費１特定入所者介護サービス費等請求額")
    private RString 合計情報決定前公費１特定入所者介護サービス費等請求額;
    @CsvField(order = 530, name = "合計情報（決定前）公費2サービス単位数")
    private RString 合計情報決定前公費2サービス単位数;
    @CsvField(order = 540, name = "合計情報（決定前）公費2請求額")
    private RString 合計情報決定前公費2請求額;
    @CsvField(order = 550, name = "合計情報（決定前）公費2本人負担額")
    private RString 合計情報決定前公費2本人負担額;
    @CsvField(order = 560, name = "合計情報（決定前）公費2緊急時施設療養費請求額")
    private RString 合計情報決定前公費2緊急時施設療養費請求額;
    @CsvField(order = 570, name = "合計情報（決定前）公費2特定診療費請求額")
    private RString 合計情報決定前公費2特定診療費請求額;
    @CsvField(order = 580, name = "合計情報（決定前）公費2特定入所者介護サービス費等請求額")
    private RString 合計情報決定前公費2特定入所者介護サービス費等請求額;
    @CsvField(order = 590, name = "合計情報（決定前）公費3サービス単位数")
    private RString 合計情報決定前公費3サービス単位数;
    @CsvField(order = 600, name = "合計情報（決定前）公費3請求額")
    private RString 合計情報決定前公費3請求額;
    @CsvField(order = 610, name = "合計情報（決定前）公費3本人負担額")
    private RString 合計情報決定前公費3本人負担額;
    @CsvField(order = 620, name = "合計情報（決定前）公費3緊急時施設療養費請求額")
    private RString 合計情報決定前公費3緊急時施設療養費請求額;
    @CsvField(order = 630, name = "合計情報（決定前）公費3特定診療費請求額")
    private RString 合計情報決定前公費3特定診療費請求額;
    @CsvField(order = 640, name = "合計情報（決定前）公費3特定入所者介護サービス費等請求額")
    private RString 合計情報決定前公費3特定入所者介護サービス費等請求額;
    @CsvField(order = 650, name = "合計情報（決定後）保険サービス単位数")
    private RString 合計情報決定後保険サービス単位数;
    @CsvField(order = 660, name = "合計情報（決定後）保険請求額")
    private RString 合計情報決定後保険請求額;
    @CsvField(order = 670, name = "合計情報（決定後）保険利用者負担額")
    private RString 合計情報決定後保険利用者負担額;
    @CsvField(order = 680, name = "合計情報（決定後）保険緊急時施設療養費請求額")
    private RString 合計情報決定後保険緊急時施設療養費請求額;
    @CsvField(order = 690, name = "合計情報（決定後）保険特定診療費請求額")
    private RString 合計情報決定後保険特定診療費請求額;
    @CsvField(order = 700, name = "合計情報（決定後）保険特定入所者介護サービス費等請求額")
    private RString 合計情報決定後保険特定入所者介護サービス費等請求額;
    @CsvField(order = 710, name = "合計情報（決定後）公費1サービス単位数")
    private RString 合計情報決定後公費1サービス単位数;
    @CsvField(order = 720, name = "合計情報（決定後）公費1請求額")
    private RString 合計情報決定後公費1請求額;
    @CsvField(order = 730, name = "合計情報（決定後）公費1本人負担額")
    private RString 合計情報決定後公費1本人負担額;
    @CsvField(order = 740, name = "合計情報（決定後）公費1緊急時施設療養費請求額")
    private RString 合計情報決定後公費1緊急時施設療養費請求額;
    @CsvField(order = 750, name = "合計情報（決定後）公費1特定診療費請求額")
    private RString 合計情報決定後公費1特定診療費請求額;
    @CsvField(order = 760, name = "合計情報（決定後）公費1特定入所者介護サービス費等請求額")
    private RString 合計情報決定後公費1特定入所者介護サービス費等請求額;
    @CsvField(order = 770, name = "合計情報（決定後）公費2サービス単位数")
    private RString 合計情報決定後公費2サービス単位数;
    @CsvField(order = 780, name = "合計情報（決定後）公費2請求額")
    private RString 合計情報決定後公費2請求額;
    @CsvField(order = 790, name = "合計情報（決定後）公費2本人負担額")
    private RString 合計情報決定後公費2本人負担額;
    @CsvField(order = 800, name = "合計情報（決定後）公費2緊急時施設療養費請求額")
    private RString 合計情報決定後公費2緊急時施設療養費請求額;
    @CsvField(order = 810, name = "合計情報（決定後）公費2特定診療費請求額")
    private RString 合計情報決定後公費2特定診療費請求額;
    @CsvField(order = 820, name = "合計情報（決定後）公費2特定入所者介護サービス費等請求額")
    private RString 合計情報決定後公費2特定入所者介護サービス費等請求額;
    @CsvField(order = 830, name = "合計情報（決定後）公費3サービス単位数")
    private RString 合計情報決定後公費3サービス単位数;
    @CsvField(order = 840, name = "合計情報（決定後）公費3請求額")
    private RString 合計情報決定後公費3請求額;
    @CsvField(order = 850, name = "合計情報（決定後）公費3本人負担額")
    private RString 合計情報決定後公費3本人負担額;
    @CsvField(order = 860, name = "合計情報（決定後）公費3緊急時施設療養費請求額")
    private RString 合計情報決定後公費3緊急時施設療養費請求額;
    @CsvField(order = 870, name = "合計情報（決定後）公費3特定診療費請求額")
    private RString 合計情報決定後公費3特定診療費請求額;
    @CsvField(order = 880, name = "合計情報（決定後）公費3特定入所者介護サービス費等請求額")
    private RString 合計情報決定後公費3特定入所者介護サービス費等請求額;
    @CsvField(order = 890, name = "警告区分コード")
    private RString 警告区分コード;
    @CsvField(order = 900, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 910, name = "ブランク")
    private RString ブランク;
    
}
