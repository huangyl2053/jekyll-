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
    private final boolean ninteiChosaIraisyo;
    private final boolean ninteiChosahyoKihon;
    private final boolean ninteiChosahyoTokki;
    private final boolean ninteiChosahyoGaikyou;
    private final boolean ninteiChosahyoOCRKihon;
    private final boolean ninteiChosahyoOCRTokki;
    private final boolean ninteiChosahyoOCRGaikyou;
    private final boolean ninteiChosaCheckHyo;
    private final boolean zenkoNinteiChosahyo;
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
     * @param ninteiChosaIraisyo 認定調査依頼書出力区分
     * @param ninteiChosahyoKihon 認定調査票(基本調査)出力区分
     * @param ninteiChosahyoTokki 認定調査票(特記事項)出力区分
     * @param ninteiChosahyoGaikyou 認定調査票(概況調査)出力区分
     * @param ninteiChosahyoOCRKihon 認定調査票OCR(基本調査)出力区分
     * @param ninteiChosahyoOCRTokki 認定調査票OCR(特記事項)出力区分
     * @param ninteiChosahyoOCRGaikyou 認定調査票OCR(概況調査)出力区分
     * @param ninteiChosaCheckHyo 認定調査差異チェック表出力区分
     * @param zenkoNinteiChosahyo 前回認定調査結果との比較表出力区分
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
            boolean ninteiChosaIraisyo,
            boolean ninteiChosahyoKihon,
            boolean ninteiChosahyoTokki,
            boolean ninteiChosahyoGaikyou,
            boolean ninteiChosahyoOCRKihon,
            boolean ninteiChosahyoOCRTokki,
            boolean ninteiChosahyoOCRGaikyou,
            boolean ninteiChosaCheckHyo,
            boolean zenkoNinteiChosahyo,
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
        this.ninteiChosaIraisyo = ninteiChosaIraisyo;
        this.ninteiChosahyoKihon = ninteiChosahyoKihon;
        this.ninteiChosahyoTokki = ninteiChosahyoTokki;
        this.ninteiChosahyoGaikyou = ninteiChosahyoGaikyou;
        this.ninteiChosahyoOCRKihon = ninteiChosahyoOCRKihon;
        this.ninteiChosahyoOCRTokki = ninteiChosahyoOCRTokki;
        this.ninteiChosahyoOCRGaikyou = ninteiChosahyoOCRGaikyou;
        this.ninteiChosaCheckHyo = ninteiChosaCheckHyo;
        this.zenkoNinteiChosahyo = zenkoNinteiChosahyo;
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
