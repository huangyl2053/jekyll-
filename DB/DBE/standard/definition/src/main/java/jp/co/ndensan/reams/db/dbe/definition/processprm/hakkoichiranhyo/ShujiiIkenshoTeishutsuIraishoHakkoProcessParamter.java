/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書提出依頼書発行ですためのProcess用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter implements IBatchProcessParameter {

    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hihokenshaNo;
    private final RString shujiiIkenshoSakuseiIraisho;
    private final RString shujiiIkensho;
    private final List<RString> shujiiIryokikanCodeList;
    private final List<RString> shujiiCodeList;
    private final RString hakkobi;
    private final RString teishutsuKigen;
    private final RString kyotsuHizuke;
    private final RString ninteioChosaIraisho;
    private final RString ninteiChosaIraiChohyo;
    private final RString ikenshoKinyuu;
    private final RString ikenshoKinyuuOCR;
    private final RString ikenshoSakuseiSeikyuusho;
    private final RString ikenshoTeishutu;
    private final RString ikenshoSakuseiIraiHakkou;

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 保険者番号 保険者番号
     * @param 主治医意見書作成依頼書 主治医意見書作成依頼書
     * @param 主治医意見書 主治医意見書
     * @param 主治医医療機関コードリスト 主治医医療機関コードリスト
     * @param 主治医コードリスト 主治医コードリスト
     * @param 発行日 発行日
     * @param 提出期限 提出期限
     * @param 共通日付 共通日付
     * @param 認定調査依頼一覧表 認定調査依頼一覧表
     * @param 認定調査依頼 認定調査依頼
     * @param 主治医意見書記入用紙 主治医意見書記入用紙
     * @param 主治医意見書記入用紙OCR 主治医意見書記入用紙OCR
     * @param 主治医意見書作成料請求書 主治医意見書作成料請求書
     * @param 主治医意見書提出依頼書 主治医意見書提出依頼書
     * @param 主治医意見書作成依頼発行一覧表 主治医意見書作成依頼発行一覧表
     */
    public ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter(RString 依頼日From,
            RString 依頼日To,
            RString 保険者番号,
            RString 主治医意見書作成依頼書,
            RString 主治医意見書,
            List<RString> 主治医医療機関コードリスト,
            List<RString> 主治医コードリスト,
            RString 発行日,
            RString 提出期限,
            RString 共通日付,
            RString 認定調査依頼一覧表,
            RString 認定調査依頼,
            RString 主治医意見書記入用紙,
            RString 主治医意見書記入用紙OCR,
            RString 主治医意見書作成料請求書,
            RString 主治医意見書提出依頼書,
            RString 主治医意見書作成依頼発行一覧表) {
        this.iraiFromYMD = 依頼日From;
        this.iraiToYMD = 依頼日To;
        this.hihokenshaNo = 保険者番号;
        this.shujiiIkenshoSakuseiIraisho = 主治医意見書作成依頼書;
        this.shujiiIkensho = 主治医意見書;
        this.shujiiIryokikanCodeList = 主治医医療機関コードリスト;
        this.shujiiCodeList = 主治医コードリスト;
        this.hakkobi = 発行日;
        this.teishutsuKigen = 提出期限;
        this.kyotsuHizuke = 共通日付;
        this.ninteioChosaIraisho = 認定調査依頼一覧表;
        this.ninteiChosaIraiChohyo = 認定調査依頼;
        this.ikenshoKinyuu = 主治医意見書記入用紙;
        this.ikenshoKinyuuOCR = 主治医意見書記入用紙OCR;
        this.ikenshoSakuseiSeikyuusho = 主治医意見書作成料請求書;
        this.ikenshoTeishutu = 主治医意見書提出依頼書;
        this.ikenshoSakuseiIraiHakkou = 主治医意見書作成依頼発行一覧表;

    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter toShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter() {
        return ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter.createSelectByKeyParam(iraiFromYMD,
                iraiToYMD,
                hihokenshaNo,
                shujiiIkenshoSakuseiIraisho,
                shujiiIkensho,
                shujiiIryokikanCodeList,
                shujiiCodeList);
    }
}
