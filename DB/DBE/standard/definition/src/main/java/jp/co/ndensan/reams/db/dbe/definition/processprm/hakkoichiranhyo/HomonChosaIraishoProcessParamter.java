/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.HomonChosaIraishoMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 訪問調査依頼書発行ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HomonChosaIraishoProcessParamter implements IBatchProcessParameter {

    private final RString ninteioChosaIraisho;
    private final RString ninteiChosahyo;
    private final List<GridParameter> ninteiChosaIraiList;
    private final boolean ninteiChosaIraiChohyo;
    private final boolean 認定調査依頼書;
    private final boolean 認定調査票_デザイン用紙;
    private final boolean 特記事項_デザイン用紙;
    private final boolean 認定調査票OCR;
    private final boolean 特記事項OCR;
    private final boolean 認定調査差異チェック票;
    private final boolean 概況特記;
    private final boolean 前回認定調査結果との比較表;
    private final boolean 特記事項_項目あり;
    private final boolean 特記事項_項目無し;
    private final boolean 特記事項_フリータイプ;
    private final boolean 手入力タイプ;
    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hakkobi;
    private final RString teishutsuKigen;
    private final RString kyotsuHizuke;
    private final boolean is認定調査依頼履歴一覧;

    /**
     * コンストラクタです。
     *
     * @param ninteioChosaIraisho 認定調査依頼書印刷区分
     * @param ninteiChosahyo 認定調査票印刷区分
     * @param ninteiChosaIraiList 認定調査依頼リスト
     * @param ninteiChosaIraiChohyo 認定調査依頼一覧表出力区分
     * @param 認定調査依頼書 認定調査依頼書出力区分
     * @param 認定調査票_デザイン用紙 認定調査デザイン用紙出力区分
     * @param 特記事項_デザイン用紙 特記事項デザイン用紙出力区分
     * @param 認定調査票OCR 認定調査票OCR出力区分
     * @param 特記事項OCR 特記事項OCR出力区分
     * @param 認定調査差異チェック票 認定調査差異チェック票出力区分
     * @param 概況特記 概況特記出力区分
     * @param 前回認定調査結果との比較表 前回認定調査結果との比較表出力区分
     * @param 特記事項_項目あり 特記事項_項目あり出力区分
     * @param 特記事項_項目無し 特記事項_項目無し出力区分
     * @param 特記事項_フリータイプ 特記事項_フリータイプ出力区分
     * @param 手入力タイプ 手入力タイプ出力区分
     * @param iraiFromYMD 依頼開始日
     * @param iraiToYMD 依頼終了日
     * @param hakkobi 発行日
     * @param teishutsuKigen 提出期限
     * @param kyotsuHizuke 共通日付
     * @param is認定調査依頼履歴一覧 認定調査依頼履歴一覧
     *
     */
    public HomonChosaIraishoProcessParamter(RString ninteioChosaIraisho,
            RString ninteiChosahyo,
            List<GridParameter> ninteiChosaIraiList,
            boolean ninteiChosaIraiChohyo,
            boolean 認定調査依頼書,
            boolean 認定調査票_デザイン用紙,
            boolean 特記事項_デザイン用紙,
            boolean 認定調査票OCR,
            boolean 特記事項OCR,
            boolean 認定調査差異チェック票,
            boolean 概況特記,
            boolean 前回認定調査結果との比較表,
            boolean 特記事項_項目あり,
            boolean 特記事項_項目無し,
            boolean 特記事項_フリータイプ,
            boolean 手入力タイプ,
            RString iraiFromYMD,
            RString iraiToYMD,
            RString hakkobi,
            RString teishutsuKigen,
            RString kyotsuHizuke,
            boolean is認定調査依頼履歴一覧) {
        this.ninteioChosaIraisho = ninteioChosaIraisho;
        this.ninteiChosahyo = ninteiChosahyo;
        this.ninteiChosaIraiList = ninteiChosaIraiList;
        this.ninteiChosaIraiChohyo = ninteiChosaIraiChohyo;
        this.認定調査依頼書 = 認定調査依頼書;
        this.認定調査票_デザイン用紙 = 認定調査票_デザイン用紙;
        this.特記事項_デザイン用紙 = 特記事項_デザイン用紙;
        this.認定調査票OCR = 認定調査票OCR;
        this.特記事項OCR = 特記事項OCR;
        this.認定調査差異チェック票 = 認定調査差異チェック票;
        this.概況特記 = 概況特記;
        this.前回認定調査結果との比較表 = 前回認定調査結果との比較表;
        this.特記事項_項目あり = 特記事項_項目あり;
        this.特記事項_項目無し = 特記事項_項目無し;
        this.特記事項_フリータイプ = 特記事項_フリータイプ;
        this.手入力タイプ = 手入力タイプ;
        this.iraiFromYMD = iraiFromYMD;
        this.iraiToYMD = iraiToYMD;
        this.hakkobi = hakkobi;
        this.teishutsuKigen = teishutsuKigen;
        this.kyotsuHizuke = kyotsuHizuke;
        this.is認定調査依頼履歴一覧 = is認定調査依頼履歴一覧;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public HomonChosaIraishoMybitisParamter toHomonChosaIraishoMybitisParamter() {
        return HomonChosaIraishoMybitisParamter.createSelectByKeyParam(iraiFromYMD,
                iraiToYMD,
                ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaIraiList);
    }
}
