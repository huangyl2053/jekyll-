/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書提出依頼書発行ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter implements IBatchProcessParameter {

    private final RString shujiiikenshoSakuseiIrai;
    private final RString shujiiIkensho;
    private final List<GridParameter> shujiiIkenshoSakuseiIraiList;
    private final boolean ikenshoSakuseiirai;
    private final boolean ikenshoSakuseiSeikyuu;
    private final boolean shujiiIkenshoSakuseiIraisho;
    private final boolean ikenshoKinyuu;
    private final boolean ikenshoKinyuuOCR;
    private final boolean ikenshoKinyuuDesign;
    private final boolean ikenshoSakuseiSeikyuusho;
    private final boolean ikenshoTeishutu;
    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hakkobi;
    private final RString teishutsuKigen;
    private final RString kyotsuHizuke;

    /**
     * コンストラクタです。
     *
     * @param shujiiikenshoSakuseiIrai 主治医意見書作成依頼印刷区分
     * @param shujiiIkensho 意見書印刷区分
     * @param shujiiIkenshoSakuseiIraiList 主治医意見書作成依頼リスト
     * @param ikenshoSakuseiirai 主治医意見書作成依頼一覧表出力区分
     * @param ikenshoSakuseiSeikyuu 主治医意見書作成料請求一覧表出力区分
     * @param shujiiIkenshoSakuseiIraisho 主治医意見書作成依頼書出力区分
     * @param ikenshoKinyuu 主治医意見書記入用紙出力区分
     * @param ikenshoKinyuuOCR 主治医意見書記入用紙OCR出力区分
     * @param ikenshoKinyuuDesign　主治医意見書記入用紙デザイン出力区分
     * @param ikenshoSakuseiSeikyuusho 主治医意見書作成料請求書出力区分
     * @param ikenshoTeishutu 介護保険指定医依頼兼主治医意見書提出依頼書出力区分
     * @param iraiFromYMD 依頼開始日
     * @param iraiToYMD 依頼終了日
     * @param hakkobi 発行日
     * @param teishutsuKigen 提出期限
     * @param kyotsuHizuke 共通日付
     *
     */
    public ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter(RString shujiiikenshoSakuseiIrai,
            RString shujiiIkensho,
            List<GridParameter> shujiiIkenshoSakuseiIraiList,
            boolean ikenshoSakuseiirai,
            boolean ikenshoSakuseiSeikyuu,
            boolean shujiiIkenshoSakuseiIraisho,
            boolean ikenshoKinyuu,
            boolean ikenshoKinyuuOCR,
            boolean ikenshoKinyuuDesign,
            boolean ikenshoSakuseiSeikyuusho,
            boolean ikenshoTeishutu,
            RString iraiFromYMD,
            RString iraiToYMD,
            RString hakkobi,
            RString teishutsuKigen,
            RString kyotsuHizuke) {
        this.shujiiikenshoSakuseiIrai = shujiiikenshoSakuseiIrai;
        this.shujiiIkensho = shujiiIkensho;
        this.shujiiIkenshoSakuseiIraiList = shujiiIkenshoSakuseiIraiList;
        this.ikenshoSakuseiirai = ikenshoSakuseiirai;
        this.ikenshoSakuseiSeikyuu = ikenshoSakuseiSeikyuu;
        this.shujiiIkenshoSakuseiIraisho = shujiiIkenshoSakuseiIraisho;
        this.ikenshoKinyuu = ikenshoKinyuu;
        this.ikenshoKinyuuOCR = ikenshoKinyuuOCR;
        this.ikenshoKinyuuDesign = ikenshoKinyuuDesign;
        this.ikenshoSakuseiSeikyuusho = ikenshoSakuseiSeikyuusho;
        this.ikenshoTeishutu = ikenshoTeishutu;
        this.iraiFromYMD = iraiFromYMD;
        this.iraiToYMD = iraiToYMD;
        this.hakkobi = hakkobi;
        this.teishutsuKigen = teishutsuKigen;
        this.kyotsuHizuke = kyotsuHizuke;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter toShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter() {
        return ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter.createSelectByKeyParam(shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList,
                iraiFromYMD,
                iraiToYMD);
    }
}
