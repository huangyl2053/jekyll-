/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshikinenno202;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告年報（様式2）のパラメータクラスです。
 *
 * @reamsid_L DBU-5600-190 zhaoran
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshikiNenho202Data {

    private RString 年報月報区分;
    private RDateTime 処理日時;
    private RString 保険者番号;
    private RString 保険者名;
    private FlexibleYear 集計年度;
    private FlexibleYearMonth 集計期間FROM;
    private FlexibleYearMonth 集計期間TO;
    private RString 様式;
    private RString タイトル1;
    private RString タイトル2;
    private RString 給付集計区分;
    private RString 居宅_介護予防_サービス_要支援１;
    private RString 居宅_介護予防_サービス_要支援２;
    private RString 居宅_介護予防_サービス_予防計;
    private RString 居宅_介護予防_サービス_非該当;
    private RString 居宅_介護予防_サービス_経過的要介護;
    private RString 居宅_介護予防_サービス_要介護１;
    private RString 居宅_介護予防_サービス_要介護２;
    private RString 居宅_介護予防_サービス_要介護３;
    private RString 居宅_介護予防_サービス_要介護４;
    private RString 居宅_介護予防_サービス_要介護５;
    private RString 居宅_介護予防_サービス_介護計;
    private RString 居宅_介護予防_サービス_合計;
    private RString 訪問サービス_要支援１;
    private RString 訪問サービス_要支援２;
    private RString 訪問サービス_予防計;
    private RString 訪問サービス_非該当;
    private RString 訪問サービス_経過的要介護;
    private RString 訪問サービス_要介護１;
    private RString 訪問サービス_要介護２;
    private RString 訪問サービス_要介護３;
    private RString 訪問サービス_要介護４;
    private RString 訪問サービス_要介護５;
    private RString 訪問サービス_介護計;
    private RString 訪問サービス_合計;
    private RString 訪問介護_要支援１;
    private RString 訪問介護_要支援２;
    private RString 訪問介護_予防計;
    private RString 訪問介護_非該当;
    private RString 訪問介護_経過的要介護;
    private RString 訪問介護_要介護１;
    private RString 訪問介護_要介護２;
    private RString 訪問介護_要介護３;
    private RString 訪問介護_要介護４;
    private RString 訪問介護_要介護５;
    private RString 訪問介護_介護計;
    private RString 訪問介護_合計;
    private RString 訪問入浴介護_要支援１;
    private RString 訪問入浴介護_要支援２;
    private RString 訪問入浴介護_予防計;
    private RString 訪問入浴介護_非該当;
    private RString 訪問入浴介護_経過的要介護;
    private RString 訪問入浴介護_要介護１;
    private RString 訪問入浴介護_要介護２;
    private RString 訪問入浴介護_要介護３;
    private RString 訪問入浴介護_要介護４;
    private RString 訪問入浴介護_要介護５;
    private RString 訪問入浴介護_介護計;
    private RString 訪問入浴介護_合計;
    private RString 訪問看護_要支援１;
    private RString 訪問看護_要支援２;
    private RString 訪問看護_予防計;
    private RString 訪問看護_非該当;
    private RString 訪問看護_経過的要介護;
    private RString 訪問看護_要介護１;
    private RString 訪問看護_要介護２;
    private RString 訪問看護_要介護３;
    private RString 訪問看護_要介護４;
    private RString 訪問看護_要介護５;
    private RString 訪問看護_介護計;
    private RString 訪問看護_合計;
    private RString 訪問リハビリテーション_要支援１;
    private RString 訪問リハビリテーション_要支援２;
    private RString 訪問リハビリテーション_予防計;
    private RString 訪問リハビリテーション_非該当;
    private RString 訪問リハビリテーション_経過的要介護;
    private RString 訪問リハビリテーション_要介護１;
    private RString 訪問リハビリテーション_要介護２;
    private RString 訪問リハビリテーション_要介護３;
    private RString 訪問リハビリテーション_要介護４;
    private RString 訪問リハビリテーション_要介護５;
    private RString 訪問リハビリテーション_介護計;
    private RString 訪問リハビリテーション_合計;
    private RString 居宅療養管理指導_要支援１;
    private RString 居宅療養管理指導_要支援２;
    private RString 居宅療養管理指導_予防計;
    private RString 居宅療養管理指導_非該当;
    private RString 居宅療養管理指導_経過的要介護;
    private RString 居宅療養管理指導_要介護１;
    private RString 居宅療養管理指導_要介護２;
    private RString 居宅療養管理指導_要介護３;
    private RString 居宅療養管理指導_要介護４;
    private RString 居宅療養管理指導_要介護５;
    private RString 居宅療養管理指導_介護計;
    private RString 居宅療養管理指導_合計;
    private RString 通所サービス_要支援１;
    private RString 通所サービス_要支援２;
    private RString 通所サービス_予防計;
    private RString 通所サービス_非該当;
    private RString 通所サービス_経過的要介護;
    private RString 通所サービス_要介護１;
    private RString 通所サービス_要介護２;
    private RString 通所サービス_要介護３;
    private RString 通所サービス_要介護４;
    private RString 通所サービス_要介護５;
    private RString 通所サービス_介護計;
    private RString 通所サービス_合計;
    private RString 通所介護_要支援１;
    private RString 通所介護_要支援２;
    private RString 通所介護_予防計;
    private RString 通所介護_非該当;
    private RString 通所介護_経過的要介護;
    private RString 通所介護_要介護１;
    private RString 通所介護_要介護２;
    private RString 通所介護_要介護３;
    private RString 通所介護_要介護４;
    private RString 通所介護_要介護５;
    private RString 通所介護_介護計;
    private RString 通所介護_合計;
    private RString 通所リハビリテーション_要支援１;
    private RString 通所リハビリテーション_要支援２;
    private RString 通所リハビリテーション_予防計;
    private RString 通所リハビリテーション_非該当;
    private RString 通所リハビリテーション_経過的要介護;
    private RString 通所リハビリテーション_要介護１;
    private RString 通所リハビリテーション_要介護２;
    private RString 通所リハビリテーション_要介護３;
    private RString 通所リハビリテーション_要介護４;
    private RString 通所リハビリテーション_要介護５;
    private RString 通所リハビリテーション_介護計;
    private RString 通所リハビリテーション_合計;
    private RString 短期入所サービス_要支援１;
    private RString 短期入所サービス_要支援２;
    private RString 短期入所サービス_予防計;
    private RString 短期入所サービス_非該当;
    private RString 短期入所サービス_経過的要介護;
    private RString 短期入所サービス_要介護１;
    private RString 短期入所サービス_要介護２;
    private RString 短期入所サービス_要介護３;
    private RString 短期入所サービス_要介護４;
    private RString 短期入所サービス_要介護５;
    private RString 短期入所サービス_介護計;
    private RString 短期入所サービス_合計;
    private RString 短期入所生活介護_要支援１;
    private RString 短期入所生活介護_要支援２;
    private RString 短期入所生活介護_予防計;
    private RString 短期入所生活介護_非該当;
    private RString 短期入所生活介護_経過的要介護;
    private RString 短期入所生活介護_要介護１;
    private RString 短期入所生活介護_要介護２;
    private RString 短期入所生活介護_要介護３;
    private RString 短期入所生活介護_要介護４;
    private RString 短期入所生活介護_要介護５;
    private RString 短期入所生活介護_介護計;
    private RString 短期入所生活介護_合計;
    private RString 短期入所療養介護_介護老人保健施設_要支援１;
    private RString 短期入所療養介護_介護老人保健施設_要支援２;
    private RString 短期入所療養介護_介護老人保健施設_予防計;
    private RString 短期入所療養介護_介護老人保健施設_非該当;
    private RString 短期入所療養介護_介護老人保健施設_経過的要介護;
    private RString 短期入所療養介護_介護老人保健施設_要介護１;
    private RString 短期入所療養介護_介護老人保健施設_要介護２;
    private RString 短期入所療養介護_介護老人保健施設_要介護３;
    private RString 短期入所療養介護_介護老人保健施設_要介護４;
    private RString 短期入所療養介護_介護老人保健施設_要介護５;
    private RString 短期入所療養介護_介護老人保健施設_介護計;
    private RString 短期入所療養介護_介護老人保健施設_合計;
    private RString 短期入所療養介護_介護療養型医療施設等_要支援１;
    private RString 短期入所療養介護_介護療養型医療施設等_要支援２;
    private RString 短期入所療養介護_介護療養型医療施設等_予防計;
    private RString 短期入所療養介護_介護療養型医療施設等_非該当;
    private RString 短期入所療養介護_介護療養型医療施設等_経過的要介護;
    private RString 短期入所療養介護_介護療養型医療施設等_要介護１;
    private RString 短期入所療養介護_介護療養型医療施設等_要介護２;
    private RString 短期入所療養介護_介護療養型医療施設等_要介護３;
    private RString 短期入所療養介護_介護療養型医療施設等_要介護４;
    private RString 短期入所療養介護_介護療養型医療施設等_要介護５;
    private RString 短期入所療養介護_介護療養型医療施設等_介護計;
    private RString 短期入所療養介護_介護療養型医療施設等_合計;
    private RString 福祉用具_住宅改修サービス_要支援１;
    private RString 福祉用具_住宅改修サービス_要支援２;
    private RString 福祉用具_住宅改修サービス_予防計;
    private RString 福祉用具_住宅改修サービス_非該当;
    private RString 福祉用具_住宅改修サービス_経過的要介護;
    private RString 福祉用具_住宅改修サービス_要介護１;
    private RString 福祉用具_住宅改修サービス_要介護２;
    private RString 福祉用具_住宅改修サービス_要介護３;
    private RString 福祉用具_住宅改修サービス_要介護４;
    private RString 福祉用具_住宅改修サービス_要介護５;
    private RString 福祉用具_住宅改修サービス_介護計;
    private RString 福祉用具_住宅改修サービス_合計;
    private RString 福祉用具貸与_要支援１;
    private RString 福祉用具貸与_要支援２;
    private RString 福祉用具貸与_予防計;
    private RString 福祉用具貸与_非該当;
    private RString 福祉用具貸与_経過的要介護;
    private RString 福祉用具貸与_要介護１;
    private RString 福祉用具貸与_要介護２;
    private RString 福祉用具貸与_要介護３;
    private RString 福祉用具貸与_要介護４;
    private RString 福祉用具貸与_要介護５;
    private RString 福祉用具貸与_介護計;
    private RString 福祉用具貸与_合計;
    private RString 特定施設入居者生活介護_要支援１;
    private RString 特定施設入居者生活介護_要支援２;
    private RString 特定施設入居者生活介護_予防計;
    private RString 特定施設入居者生活介護_非該当;
    private RString 特定施設入居者生活介護_経過的要介護;
    private RString 特定施設入居者生活介護_要介護１;
    private RString 特定施設入居者生活介護_要介護２;
    private RString 特定施設入居者生活介護_要介護３;
    private RString 特定施設入居者生活介護_要介護４;
    private RString 特定施設入居者生活介護_要介護５;
    private RString 特定施設入居者生活介護_介護計;
    private RString 特定施設入居者生活介護_合計;
    private RString 介護予防支援_居宅介護支援_要支援１;
    private RString 介護予防支援_居宅介護支援_要支援２;
    private RString 介護予防支援_居宅介護支援_予防計;
    private RString 介護予防支援_居宅介護支援_非該当;
    private RString 介護予防支援_居宅介護支援_経過的要介護;
    private RString 介護予防支援_居宅介護支援_要介護１;
    private RString 介護予防支援_居宅介護支援_要介護２;
    private RString 介護予防支援_居宅介護支援_要介護３;
    private RString 介護予防支援_居宅介護支援_要介護４;
    private RString 介護予防支援_居宅介護支援_要介護５;
    private RString 介護予防支援_居宅介護支援_介護計;
    private RString 介護予防支援_居宅介護支援_合計;
    private RString 地域密着型_介護予防_サービス_要支援１;
    private RString 地域密着型_介護予防_サービス_要支援２;
    private RString 地域密着型_介護予防_サービス_予防計;
    private RString 地域密着型_介護予防_サービス_非該当;
    private RString 地域密着型_介護予防_サービス_経過的要介護;
    private RString 地域密着型_介護予防_サービス_要介護１;
    private RString 地域密着型_介護予防_サービス_要介護２;
    private RString 地域密着型_介護予防_サービス_要介護３;
    private RString 地域密着型_介護予防_サービス_要介護４;
    private RString 地域密着型_介護予防_サービス_要介護５;
    private RString 地域密着型_介護予防_サービス_介護計;
    private RString 地域密着型_介護予防_サービス_合計;
    private RString 定期巡回_随時対応型訪問介護看護_要支援１;
    private RString 定期巡回_随時対応型訪問介護看護_要支援２;
    private RString 定期巡回_随時対応型訪問介護看護_予防計;
    private RString 定期巡回_随時対応型訪問介護看護_非該当;
    private RString 定期巡回_随時対応型訪問介護看護_経過的要介護;
    private RString 定期巡回_随時対応型訪問介護看護_要介護１;
    private RString 定期巡回_随時対応型訪問介護看護_要介護２;
    private RString 定期巡回_随時対応型訪問介護看護_要介護３;
    private RString 定期巡回_随時対応型訪問介護看護_要介護４;
    private RString 定期巡回_随時対応型訪問介護看護_要介護５;
    private RString 定期巡回_随時対応型訪問介護看護_介護計;
    private RString 定期巡回_随時対応型訪問介護看護_合計;
    private RString 夜間対応型訪問介護_要支援１;
    private RString 夜間対応型訪問介護_要支援２;
    private RString 夜間対応型訪問介護_予防計;
    private RString 夜間対応型訪問介護_非該当;
    private RString 夜間対応型訪問介護_経過的要介護;
    private RString 夜間対応型訪問介護_要介護１;
    private RString 夜間対応型訪問介護_要介護２;
    private RString 夜間対応型訪問介護_要介護３;
    private RString 夜間対応型訪問介護_要介護４;
    private RString 夜間対応型訪問介護_要介護５;
    private RString 夜間対応型訪問介護_介護計;
    private RString 夜間対応型訪問介護_合計;
    private RString 地域密着型通所介護_要支援１;
    private RString 地域密着型通所介護_要支援２;
    private RString 地域密着型通所介護_予防計;
    private RString 地域密着型通所介護_非該当;
    private RString 地域密着型通所介護_経過的要介護;
    private RString 地域密着型通所介護_要介護１;
    private RString 地域密着型通所介護_要介護２;
    private RString 地域密着型通所介護_要介護３;
    private RString 地域密着型通所介護_要介護４;
    private RString 地域密着型通所介護_要介護５;
    private RString 地域密着型通所介護_介護計;
    private RString 地域密着型通所介護_合計;
    private RString 認知症対応型通所介護_要支援１;
    private RString 認知症対応型通所介護_要支援２;
    private RString 認知症対応型通所介護_予防計;
    private RString 認知症対応型通所介護_非該当;
    private RString 認知症対応型通所介護_経過的要介護;
    private RString 認知症対応型通所介護_要介護１;
    private RString 認知症対応型通所介護_要介護２;
    private RString 認知症対応型通所介護_要介護３;
    private RString 認知症対応型通所介護_要介護４;
    private RString 認知症対応型通所介護_要介護５;
    private RString 認知症対応型通所介護_介護計;
    private RString 認知症対応型通所介護_合計;
    private RString 小規模多機能型居宅介護_要支援１;
    private RString 小規模多機能型居宅介護_要支援２;
    private RString 小規模多機能型居宅介護_予防計;
    private RString 小規模多機能型居宅介護_非該当;
    private RString 小規模多機能型居宅介護_経過的要介護;
    private RString 小規模多機能型居宅介護_要介護１;
    private RString 小規模多機能型居宅介護_要介護２;
    private RString 小規模多機能型居宅介護_要介護３;
    private RString 小規模多機能型居宅介護_要介護４;
    private RString 小規模多機能型居宅介護_要介護５;
    private RString 小規模多機能型居宅介護_介護計;
    private RString 小規模多機能型居宅介護_合計;
    private RString 認知症対応型共同生活介護_要支援１;
    private RString 認知症対応型共同生活介護_要支援２;
    private RString 認知症対応型共同生活介護_予防計;
    private RString 認知症対応型共同生活介護_非該当;
    private RString 認知症対応型共同生活介護_経過的要介護;
    private RString 認知症対応型共同生活介護_要介護１;
    private RString 認知症対応型共同生活介護_要介護２;
    private RString 認知症対応型共同生活介護_要介護３;
    private RString 認知症対応型共同生活介護_要介護４;
    private RString 認知症対応型共同生活介護_要介護５;
    private RString 認知症対応型共同生活介護_介護計;
    private RString 認知症対応型共同生活介護_合計;
    private RString 地域密着型特定施設入居者生活介護_要支援１;
    private RString 地域密着型特定施設入居者生活介護_要支援２;
    private RString 地域密着型特定施設入居者生活介護_予防計;
    private RString 地域密着型特定施設入居者生活介護_非該当;
    private RString 地域密着型特定施設入居者生活介護_経過的要介護;
    private RString 地域密着型特定施設入居者生活介護_要介護１;
    private RString 地域密着型特定施設入居者生活介護_要介護２;
    private RString 地域密着型特定施設入居者生活介護_要介護３;
    private RString 地域密着型特定施設入居者生活介護_要介護４;
    private RString 地域密着型特定施設入居者生活介護_要介護５;
    private RString 地域密着型特定施設入居者生活介護_介護計;
    private RString 地域密着型特定施設入居者生活介護_合計;
    private RString 地域密着型介護老人福祉施設入居者生活介護_要支援１;
    private RString 地域密着型介護老人福祉施設入居者生活介護_要支援２;
    private RString 地域密着型介護老人福祉施設入居者生活介護_予防計;
    private RString 地域密着型介護老人福祉施設入居者生活介護_非該当;
    private RString 地域密着型介護老人福祉施設入居者生活介護_経過的要介護;
    private RString 地域密着型介護老人福祉施設入居者生活介護_要介護１;
    private RString 地域密着型介護老人福祉施設入居者生活介護_要介護２;
    private RString 地域密着型介護老人福祉施設入居者生活介護_要介護３;
    private RString 地域密着型介護老人福祉施設入居者生活介護_要介護４;
    private RString 地域密着型介護老人福祉施設入居者生活介護_要介護５;
    private RString 地域密着型介護老人福祉施設入居者生活介護_介護計;
    private RString 地域密着型介護老人福祉施設入居者生活介護_合計;
    private RString 複合型サービス_看護小規模多機能型居宅介護_要支援１;
    private RString 複合型サービス_看護小規模多機能型居宅介護_要支援２;
    private RString 複合型サービス_看護小規模多機能型居宅介護_予防計;
    private RString 複合型サービス_看護小規模多機能型居宅介護_非該当;
    private RString 複合型サービス_看護小規模多機能型居宅介護_経過的要介護;
    private RString 複合型サービス_看護小規模多機能型居宅介護_要介護１;
    private RString 複合型サービス_看護小規模多機能型居宅介護_要介護２;
    private RString 複合型サービス_看護小規模多機能型居宅介護_要介護３;
    private RString 複合型サービス_看護小規模多機能型居宅介護_要介護４;
    private RString 複合型サービス_看護小規模多機能型居宅介護_要介護５;
    private RString 複合型サービス_看護小規模多機能型居宅介護_介護計;
    private RString 複合型サービス_看護小規模多機能型居宅介護_合計;
    private RString 施設介護サービス_要支援１;
    private RString 施設介護サービス_要支援２;
    private RString 施設介護サービス_予防計;
    private RString 施設介護サービス_非該当;
    private RString 施設介護サービス_経過的要介護;
    private RString 施設介護サービス_要介護１;
    private RString 施設介護サービス_要介護２;
    private RString 施設介護サービス_要介護３;
    private RString 施設介護サービス_要介護４;
    private RString 施設介護サービス_要介護５;
    private RString 施設介護サービス_介護計;
    private RString 施設介護サービス_合計;
    private RString 介護老人福祉施設_要支援１;
    private RString 介護老人福祉施設_要支援２;
    private RString 介護老人福祉施設_予防計;
    private RString 介護老人福祉施設_非該当;
    private RString 介護老人福祉施設_経過的要介護;
    private RString 介護老人福祉施設_要介護１;
    private RString 介護老人福祉施設_要介護２;
    private RString 介護老人福祉施設_要介護３;
    private RString 介護老人福祉施設_要介護４;
    private RString 介護老人福祉施設_要介護５;
    private RString 介護老人福祉施設_介護計;
    private RString 介護老人福祉施設_合計;
    private RString 介護老人保健施設_要支援１;
    private RString 介護老人保健施設_要支援２;
    private RString 介護老人保健施設_予防計;
    private RString 介護老人保健施設_非該当;
    private RString 介護老人保健施設_経過的要介護;
    private RString 介護老人保健施設_要介護１;
    private RString 介護老人保健施設_要介護２;
    private RString 介護老人保健施設_要介護３;
    private RString 介護老人保健施設_要介護４;
    private RString 介護老人保健施設_要介護５;
    private RString 介護老人保健施設_介護計;
    private RString 介護老人保健施設_合計;
    private RString 介護療養型医療施設_要支援１;
    private RString 介護療養型医療施設_要支援２;
    private RString 介護療養型医療施設_予防計;
    private RString 介護療養型医療施設_非該当;
    private RString 介護療養型医療施設_経過的要介護;
    private RString 介護療養型医療施設_要介護１;
    private RString 介護療養型医療施設_要介護２;
    private RString 介護療養型医療施設_要介護３;
    private RString 介護療養型医療施設_要介護４;
    private RString 介護療養型医療施設_要介護５;
    private RString 介護療養型医療施設_介護計;
    private RString 介護療養型医療施設_合計;
    private RString 総計_要支援１;
    private RString 総計_要支援２;
    private RString 総計_予防計;
    private RString 総計_非該当;
    private RString 総計_経過的要介護;
    private RString 総計_要介護１;
    private RString 総計_要介護２;
    private RString 総計_要介護３;
    private RString 総計_要介護４;
    private RString 総計_要介護５;
    private RString 総計_介護計;
    private RString 総計_合計;

}
