/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書提出依頼書発行ですためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter implements IMyBatisParameter {

    private static final RString 未印刷 = new RString("1");
    private static final RString 印刷済 = new RString("2");
    private static final RString 未印刷_印刷済 = new RString("3");
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();
    private final RString 転入 = NinteiShinseiShinseijiKubunCode.転入申請.getコード();
    private final RString 喪失 = NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード();
    private final RString shujiiikenshoSakuseiIrai;
    private final RString shujiiIkensho;
    private final List<GridParameter> shujiiIkenshoSakuseiIraiList;
    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final boolean is意見書作成未印刷;
    private final boolean is意見書作成印刷済;
    private final boolean is意見書作成未印刷_印刷済;
    private final boolean is意見書未印刷;
    private final boolean is意見書印刷済;
    private final boolean is意見書未印刷_印刷済;
    private final boolean is依頼日From;
    private final boolean is依頼日To;

    /**
     * コンストラクタです。
     *
     * @param shujiiikenshoSakuseiIrai 主治医意見書作成依頼印刷区分
     * @param shujiiIkensho 意見書印刷区分
     * @param shujiiIkenshoSakuseiIraiList 主治医意見書作成依頼リスト
     * @param iraiFromYMD 依頼開始日
     * @param iraiToYMD 依頼終了日
     * @param is意見書作成未印刷 is意見書作成未印刷
     * @param is意見書作成印刷済 is意見書作成印刷済
     * @param is意見書未印刷 is意見書未印刷
     * @param is意見書印刷済 is意見書印刷済
     * @param is依頼日From is依頼日From
     * @param is依頼日To is依頼日To
     */
    private ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter(
            RString shujiiikenshoSakuseiIrai,
            RString shujiiIkensho,
            List<GridParameter> shujiiIkenshoSakuseiIraiList,
            RString iraiFromYMD,
            RString iraiToYMD,
            boolean is意見書作成未印刷,
            boolean is意見書作成印刷済,
            boolean is意見書作成未印刷_印刷済,
            boolean is意見書未印刷,
            boolean is意見書印刷済,
            boolean is意見書未印刷_印刷済,
            boolean is依頼日From,
            boolean is依頼日To) {
        this.shujiiikenshoSakuseiIrai = shujiiikenshoSakuseiIrai;
        this.shujiiIkensho = shujiiIkensho;
        this.shujiiIkenshoSakuseiIraiList = shujiiIkenshoSakuseiIraiList;
        this.iraiFromYMD = iraiFromYMD;
        this.iraiToYMD = iraiToYMD;
        this.is意見書作成未印刷 = is意見書作成未印刷;
        this.is意見書作成印刷済 = is意見書作成印刷済;
        this.is意見書作成未印刷_印刷済 = is意見書作成未印刷_印刷済;
        this.is意見書未印刷 = is意見書未印刷;
        this.is意見書印刷済 = is意見書印刷済;
        this.is意見書未印刷_印刷済 = is意見書未印刷_印刷済;
        this.is依頼日From = is依頼日From;
        this.is依頼日To = is依頼日To;
    }

    /**
     * コンストラクタです。
     *
     * @param shujiiikenshoSakuseiIrai 主治医意見書作成依頼印刷区分
     * @param shujiiIkensho 意見書印刷区分
     * @param shujiiIkenshoSakuseiIraiList 主治医意見書作成依頼リスト
     * @param iraiFromYMD 依頼開始日
     * @param iraiToYMD 依頼終了日
     *
     * @return ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter
     */
    public static ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter createSelectByKeyParam(
            RString shujiiikenshoSakuseiIrai,
            RString shujiiIkensho,
            List<GridParameter> shujiiIkenshoSakuseiIraiList,
            RString iraiFromYMD,
            RString iraiToYMD) {
        boolean is意見書作成未印刷 = false;
        boolean is意見書作成印刷済 = false;
        boolean is意見書作成未印刷_印刷済 = false;
        boolean is意見書未印刷 = false;
        boolean is意見書印刷済 = false;
        boolean is意見書未印刷_印刷済 = false;
        boolean is依頼日From = false;
        boolean is依頼日To = false;

        if (!RString.isNullOrEmpty(iraiFromYMD)) {
            is依頼日From = true;
        }
        if (!RString.isNullOrEmpty(iraiToYMD)) {
            is依頼日To = true;
        }
        if (!RString.isNullOrEmpty(shujiiikenshoSakuseiIrai) && shujiiikenshoSakuseiIrai.equals(未印刷)) {
            is意見書作成未印刷 = true;
        }
        if (!RString.isNullOrEmpty(shujiiikenshoSakuseiIrai) && shujiiikenshoSakuseiIrai.equals(印刷済)) {
            is意見書作成印刷済 = true;
        }
        if (!RString.isNullOrEmpty(shujiiikenshoSakuseiIrai) && shujiiikenshoSakuseiIrai.equals(未印刷_印刷済)) {
            is意見書作成未印刷_印刷済 = true;
        }
        if (!RString.isNullOrEmpty(shujiiIkensho) && shujiiIkensho.equals(未印刷)) {
            is意見書未印刷 = true;
        }
        if (!RString.isNullOrEmpty(shujiiIkensho) && shujiiIkensho.equals(印刷済)) {
            is意見書印刷済 = true;
        }
        if (!RString.isNullOrEmpty(shujiiIkensho) && shujiiIkensho.equals(未印刷_印刷済)) {
            is意見書未印刷_印刷済 = true;
        }
        return new ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter(shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList,
                iraiFromYMD,
                iraiToYMD,
                is意見書作成未印刷,
                is意見書作成印刷済,
                is意見書作成未印刷_印刷済,
                is意見書未印刷,
                is意見書印刷済,
                is意見書未印刷_印刷済,
                is依頼日From,
                is依頼日To);
    }
}
