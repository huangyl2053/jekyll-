/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShujiiIkenshoProcessParamter implements IBatchProcessParameter {

    private final RString shujiiikenshoSakuseiIrai;
    private final RString shujiiIkensho;
    private final List<GridParameter> shujiiIkenshoSakuseiIraiList;
    private final boolean shujiiIkenshoSakuseiIraisho;
    private final boolean ikenshoSakuseiIraiIchiran;
    private final boolean ikenshoKinyu;
    private final boolean ikenshoSakuseiSeikyusho;
    private final boolean ikenshoSakuseiSeikyuIchiran;
    private final boolean ikenshoSakuseiHakkoIchiran;
    private final boolean ikenshoSakuseiRirekiIchiran;
    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hakkobi;
    private final RString teishutsuKigen;
    private final RString kyotsuHizuke;
    private final RString bunshoNo;
    private final RString shichosonCode;

    /**
     * コンストラクタです。
     *
     * @param shujiiikenshoSakuseiIrai 主治医意見書作成依頼印刷区分
     * @param shujiiIkensho 意見書印刷区分
     * @param shujiiIkenshoSakuseiIraiList 主治医意見書作成依頼リスト
     * @param shujiiIkenshoSakuseiIraisho 主治医意見書作成依頼書出力区分
     * @param ikenshoSakuseiIraiIchiran
     * @param ikenshoKinyu
     * @param ikenshoSakuseiSeikyusho
     * @param ikenshoSakuseiSeikyuIchiran
     * @param ikenshoSakuseiHakkoIchiran
     * @param ikenshoSakuseiRirekiIchiran
     * @param iraiFromYMD 依頼開始日
     * @param iraiToYMD 依頼終了日
     * @param hakkobi 発行日
     * @param teishutsuKigen 提出期限
     * @param kyotsuHizuke 共通日付
     * @param bunshoNo 文書番号
     * @param shichosonCode
     *
     */
    public ShujiiIkenshoProcessParamter(RString shujiiikenshoSakuseiIrai,
            RString shujiiIkensho,
            List<GridParameter> shujiiIkenshoSakuseiIraiList,
            boolean shujiiIkenshoSakuseiIraisho,
            boolean ikenshoSakuseiIraiIchiran,
            boolean ikenshoKinyu,
            boolean ikenshoSakuseiSeikyusho,
            boolean ikenshoSakuseiSeikyuIchiran,
            boolean ikenshoSakuseiHakkoIchiran,
            boolean ikenshoSakuseiRirekiIchiran,
            RString iraiFromYMD,
            RString iraiToYMD,
            RString hakkobi,
            RString teishutsuKigen,
            RString kyotsuHizuke,
            RString bunshoNo,
            RString shichosonCode) {
        this.shujiiikenshoSakuseiIrai = shujiiikenshoSakuseiIrai;
        this.shujiiIkensho = shujiiIkensho;
        this.shujiiIkenshoSakuseiIraiList = shujiiIkenshoSakuseiIraiList;
        this.shujiiIkenshoSakuseiIraisho = shujiiIkenshoSakuseiIraisho;
        this.ikenshoSakuseiIraiIchiran = ikenshoSakuseiIraiIchiran;
        this.ikenshoKinyu = ikenshoKinyu;
        this.ikenshoSakuseiSeikyusho = ikenshoSakuseiSeikyusho;
        this.ikenshoSakuseiSeikyuIchiran = ikenshoSakuseiSeikyuIchiran;
        this.ikenshoSakuseiHakkoIchiran = ikenshoSakuseiHakkoIchiran;
        this.ikenshoSakuseiRirekiIchiran = ikenshoSakuseiRirekiIchiran;
        this.iraiFromYMD = iraiFromYMD;
        this.iraiToYMD = iraiToYMD;
        this.hakkobi = hakkobi;
        this.teishutsuKigen = teishutsuKigen;
        this.kyotsuHizuke = kyotsuHizuke;
        this.bunshoNo = bunshoNo;
        this.shichosonCode = shichosonCode;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public ShujiiIkenMybatisParameter toShujiiIkenMybatisParameter() {
        return ShujiiIkenMybatisParameter.createSelectByKeyParam(shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList,
                iraiFromYMD,
                iraiToYMD);
    }
}
