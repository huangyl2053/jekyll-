/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.NinteiChosaMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NinteiChosaProcessParamter implements IBatchProcessParameter {

    private final RString ninteioChosaIraisho;
    private final RString ninteiChosahyo;
    private final List<GridParameter> ninteiChosaIraiList;
    private final boolean 認定調査依頼書;
    private final boolean 認定調査依頼一覧表;
    private final boolean 認定調査票_概況調査;
    private final boolean 認定調査票_基本調査;
    private final boolean 認定調査票_特記事項;
    private final boolean 認定調査票_概況基本;
    private final boolean 認定調査票_概況特記;
    private final boolean 認定調査差異チェック票;
    private final boolean 特記事項_調査群;
    private final boolean 特記事項_フリータイプ;
    private final boolean is認定調査依頼発行一覧;
    private final boolean is認定調査依頼履歴一覧;
    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hakkobi;
    private final RString teishutsuKigen;
    private final RString kyotsuHizuke;
    private final RString 文書番号;
    private final RString shichosonCode;
    private final RString shoKisaiHokenshaNo;
    private final RString hokenshaName;

    /**
     * コンストラクタです。
     *
     * @param ninteioChosaIraisho 認定調査依頼書印刷区分
     * @param ninteiChosahyo 認定調査票印刷区分
     * @param ninteiChosaIraiList 認定調査依頼リスト
     * @param 認定調査依頼書 認定調査依頼書出力区分
     * @param 認定調査依頼一覧表
     * @param 認定調査票_概況調査
     * @param 認定調査票_基本調査
     * @param 認定調査票_特記事項
     * @param 認定調査票_概況基本
     * @param 認定調査票_概況特記
     * @param 認定調査差異チェック票 認定調査差異チェック票出力区分
     * @param 特記事項_調査群
     * @param 特記事項_フリータイプ 特記事項_フリータイプ出力区分
     * @param is認定調査依頼発行一覧
     * @param is認定調査依頼履歴一覧 認定調査依頼履歴一覧
     * @param iraiFromYMD 依頼開始日
     * @param iraiToYMD 依頼終了日
     * @param hakkobi 発行日
     * @param teishutsuKigen 提出期限
     * @param kyotsuHizuke 共通日付
     * @param 文書番号
     * @param shichosonCode
     *
     */
    public NinteiChosaProcessParamter(
            RString ninteioChosaIraisho,
            RString ninteiChosahyo,
            List<GridParameter> ninteiChosaIraiList,
            boolean 認定調査依頼書,
            boolean 認定調査依頼一覧表,
            boolean 認定調査票_概況調査,
            boolean 認定調査票_基本調査,
            boolean 認定調査票_特記事項,
            boolean 認定調査票_概況基本,
            boolean 認定調査票_概況特記,
            boolean 認定調査差異チェック票,
            boolean 特記事項_調査群,
            boolean 特記事項_フリータイプ,
            boolean is認定調査依頼発行一覧,
            boolean is認定調査依頼履歴一覧,
            RString iraiFromYMD,
            RString iraiToYMD,
            RString hakkobi,
            RString teishutsuKigen,
            RString kyotsuHizuke,
            RString 文書番号,
            RString shichosonCode) {
        this.ninteioChosaIraisho = ninteioChosaIraisho;
        this.ninteiChosahyo = ninteiChosahyo;
        this.ninteiChosaIraiList = ninteiChosaIraiList;
        this.認定調査依頼書 = 認定調査依頼書;
        this.認定調査依頼一覧表 = 認定調査依頼一覧表;
        this.認定調査票_概況調査 = 認定調査票_概況調査;
        this.認定調査票_基本調査 = 認定調査票_基本調査;
        this.認定調査票_特記事項 = 認定調査票_特記事項;
        this.認定調査票_概況基本 = 認定調査票_概況基本;
        this.認定調査票_概況特記 = 認定調査票_概況特記;
        this.認定調査差異チェック票 = 認定調査差異チェック票;
        this.特記事項_調査群 = 特記事項_調査群;
        this.特記事項_フリータイプ = 特記事項_フリータイプ;
        this.is認定調査依頼発行一覧 = is認定調査依頼発行一覧;
        this.is認定調査依頼履歴一覧 = is認定調査依頼履歴一覧;
        this.iraiFromYMD = iraiFromYMD;
        this.iraiToYMD = iraiToYMD;
        this.hakkobi = hakkobi;
        this.teishutsuKigen = teishutsuKigen;
        this.kyotsuHizuke = kyotsuHizuke;
        this.文書番号 = 文書番号;
        this.shichosonCode = shichosonCode;
        this.shoKisaiHokenshaNo = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param ninteioChosaIraisho 認定調査依頼書印刷区分
     * @param ninteiChosahyo 認定調査票印刷区分
     * @param ninteiChosaIraiList 認定調査依頼リスト
     * @param 認定調査依頼書 認定調査依頼書出力区分
     * @param 認定調査依頼一覧表
     * @param 認定調査票_概況調査
     * @param 認定調査票_基本調査
     * @param 認定調査票_特記事項
     * @param 認定調査票_概況基本
     * @param 認定調査票_概況特記
     * @param 認定調査差異チェック票 認定調査差異チェック票出力区分
     * @param 特記事項_調査群
     * @param 特記事項_フリータイプ 特記事項_フリータイプ出力区分
     * @param is認定調査依頼発行一覧
     * @param is認定調査依頼履歴一覧 認定調査依頼履歴一覧
     * @param iraiFromYMD 依頼開始日
     * @param iraiToYMD 依頼終了日
     * @param hakkobi 発行日
     * @param teishutsuKigen 提出期限
     * @param kyotsuHizuke 共通日付
     * @param 文書番号
     * @param shichosonCode
     * @param shoKisaiHokenshaNo
     * @param hokenshaName
     *
     */
    public NinteiChosaProcessParamter(
            RString ninteioChosaIraisho,
            RString ninteiChosahyo,
            List<GridParameter> ninteiChosaIraiList,
            boolean 認定調査依頼書,
            boolean 認定調査依頼一覧表,
            boolean 認定調査票_概況調査,
            boolean 認定調査票_基本調査,
            boolean 認定調査票_特記事項,
            boolean 認定調査票_概況基本,
            boolean 認定調査票_概況特記,
            boolean 認定調査差異チェック票,
            boolean 特記事項_調査群,
            boolean 特記事項_フリータイプ,
            boolean is認定調査依頼発行一覧,
            boolean is認定調査依頼履歴一覧,
            RString iraiFromYMD,
            RString iraiToYMD,
            RString hakkobi,
            RString teishutsuKigen,
            RString kyotsuHizuke,
            RString 文書番号,
            RString shichosonCode,
            RString shoKisaiHokenshaNo,
            RString hokenshaName) {
        this.ninteioChosaIraisho = ninteioChosaIraisho;
        this.ninteiChosahyo = ninteiChosahyo;
        this.ninteiChosaIraiList = ninteiChosaIraiList;
        this.認定調査依頼書 = 認定調査依頼書;
        this.認定調査依頼一覧表 = 認定調査依頼一覧表;
        this.認定調査票_概況調査 = 認定調査票_概況調査;
        this.認定調査票_基本調査 = 認定調査票_基本調査;
        this.認定調査票_特記事項 = 認定調査票_特記事項;
        this.認定調査票_概況基本 = 認定調査票_概況基本;
        this.認定調査票_概況特記 = 認定調査票_概況特記;
        this.認定調査差異チェック票 = 認定調査差異チェック票;
        this.特記事項_調査群 = 特記事項_調査群;
        this.特記事項_フリータイプ = 特記事項_フリータイプ;
        this.is認定調査依頼発行一覧 = is認定調査依頼発行一覧;
        this.is認定調査依頼履歴一覧 = is認定調査依頼履歴一覧;
        this.iraiFromYMD = iraiFromYMD;
        this.iraiToYMD = iraiToYMD;
        this.hakkobi = hakkobi;
        this.teishutsuKigen = teishutsuKigen;
        this.kyotsuHizuke = kyotsuHizuke;
        this.文書番号 = 文書番号;
        this.shichosonCode = shichosonCode;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.hokenshaName = hokenshaName;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public NinteiChosaMybitisParamter toNinteiChosaMybitisParamter() {
        return NinteiChosaMybitisParamter.createSelectByKeyParam(iraiFromYMD,
                iraiToYMD,
                ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaIraiList);
    }
}
