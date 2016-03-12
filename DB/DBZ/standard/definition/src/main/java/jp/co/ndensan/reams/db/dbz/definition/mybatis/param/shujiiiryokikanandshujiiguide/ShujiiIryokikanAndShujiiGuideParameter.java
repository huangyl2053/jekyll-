/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.shujiiiryokikanandshujiiguide;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関＆主治医情報検索パラメータークラス
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIryokikanAndShujiiGuideParameter {

    private final RString hokensha;
    private final boolean subGyomuCodeFlag;
    private final RString shujiiIryokikanCodeFrom;
    private final boolean shujiiIryokikanCodeFromFlag;
    private final RString shujiiIryokikanCodeTo;
    private final boolean shujiiIryokikanCodeToFlag;
    private final boolean shujiiIryokikanCodeJokyoFlag;
    private final RString iryoKikanMeisho;
    private final boolean iryoKikanMeishoFlag;
    private final RString iryoKikanMeishoKana;
    private final boolean iryoKikanMeishoKanaFlag;
    private final RString shujiiCodeFrom;
    private final boolean shujiiCodeFromFlag;
    private final RString shujiiCodeTo;
    private final boolean shujiiCodeToFlag;
    private final boolean shujiiJokyoFlag;
    private final RString shujiiName;
    private final boolean shujiiNameFlag;
    private final RString shujiiKana;
    private final boolean shujiiKanaFlag;
    private final int maxCount;

    /**
     * コンストラクタです。
     *
     * @param hokensha 保険者
     * @param subGyomuCodeFlag サブ業務コードフラグ
     * @param shujiiIryokikanCodeFrom 主治医医療機関コードFROM
     * @param shujiiIryokikanCodeFromFlag 主治医医療機関コードFROMフラグ
     * @param shujiiIryokikanCodeTo 主治医医療機関コードTO
     * @param shujiiIryokikanCodeToFlag 主治医医療機関コードTOフラグ
     * @param shujiiIryokikanCodeJokyoFlag 主治医医療機関状況フラグ
     * @param iryoKikanMeisho 主治医医療機関名称
     * @param iryoKikanMeishoFlag 主治医医療機関名称フラグ
     * @param iryoKikanMeishoKana 主治医医療機関カナ名称
     * @param iryoKikanMeishoKanaFlag 主治医医療機関カナ名称フラグ
     * @param shujiiCodeFrom 主治医コードFROM
     * @param shujiiCodeFromFlag 主治医コードFROMフラグ
     * @param shujiiCodeTo 主治医コードTO
     * @param shujiiCodeToFlag 主治医コードTOフラグ
     * @param shujiiJokyoFlag 主治医状況フラグ
     * @param shujiiName 主治医名称
     * @param shujiiNameFlag 主治医名称フラグ
     * @param shujiiKana 主治医カナ氏名
     * @param shujiiKanaFlag 主治医カナ氏名フラグ
     * @param maxCount 最大表示件数
     */
    private ShujiiIryokikanAndShujiiGuideParameter(
            RString hokensha,
            boolean subGyomuCodeFlag,
            RString shujiiIryokikanCodeFrom,
            boolean shujiiIryokikanCodeFromFlag,
            RString shujiiIryokikanCodeTo,
            boolean shujiiIryokikanCodeToFlag,
            boolean shujiiIryokikanCodeJokyoFlag,
            RString iryoKikanMeisho,
            boolean iryoKikanMeishoFlag,
            RString iryoKikanMeishoKana,
            boolean iryoKikanMeishoKanaFlag,
            RString shujiiCodeFrom,
            boolean shujiiCodeFromFlag,
            RString shujiiCodeTo,
            boolean shujiiCodeToFlag,
            boolean shujiiJokyoFlag,
            RString shujiiName,
            boolean shujiiNameFlag,
            RString shujiiKana,
            boolean shujiiKanaFlag,
            int maxCount) {
        this.hokensha = hokensha;
        this.subGyomuCodeFlag = subGyomuCodeFlag;
        this.shujiiIryokikanCodeFromFlag = shujiiIryokikanCodeFromFlag;
        this.shujiiIryokikanCodeFrom = shujiiIryokikanCodeFrom;
        this.shujiiIryokikanCodeTo = shujiiIryokikanCodeTo;
        this.shujiiIryokikanCodeToFlag = shujiiIryokikanCodeToFlag;
        this.shujiiIryokikanCodeJokyoFlag = shujiiIryokikanCodeJokyoFlag;
        this.iryoKikanMeisho = iryoKikanMeisho;
        this.iryoKikanMeishoFlag = iryoKikanMeishoFlag;
        this.iryoKikanMeishoKana = iryoKikanMeishoKana;
        this.iryoKikanMeishoKanaFlag = iryoKikanMeishoKanaFlag;
        this.shujiiCodeFrom = shujiiCodeFrom;
        this.shujiiCodeFromFlag = shujiiCodeFromFlag;
        this.shujiiCodeTo = shujiiCodeTo;
        this.shujiiCodeToFlag = shujiiCodeToFlag;
        this.shujiiJokyoFlag = shujiiJokyoFlag;
        this.shujiiName = shujiiName;
        this.shujiiNameFlag = shujiiNameFlag;
        this.shujiiKana = shujiiKana;
        this.shujiiKanaFlag = shujiiKanaFlag;
        this.maxCount = maxCount;

    }

    /**
     * 主治医医療機関＆主治医情報検索パラメータークラス作成
     *
     * @param hokensha 保険者
     * @param subGyomuCodeFlag サブ業務コードフラグ
     * @param shujiiIryokikanCodeFrom 主治医医療機関コードFROM
     * @param shujiiIryokikanCodeTo 主治医医療機関コードTO
     * @param shujiiIryokikanCodeJokyoFlag 主治医医療機関状況フラグ
     * @param iryoKikanMeisho 主治医医療機関名称
     * @param iryoKikanMeishoKana 主治医医療機関カナ名称
     * @param shujiiCodeFrom 主治医コードFROM
     * @param shujiiCodeTo 主治医コードTO
     * @param shujiiJokyoFlag 主治医状況フラグ
     * @param shujiiName 主治医名称
     * @param shujiiKana 主治医カナ氏名
     * @param maxCount 最大表示件数
     * @return 主治医医療機関＆主治医情報検索パラメータークラス
     */
    public static ShujiiIryokikanAndShujiiGuideParameter createKensakuJokenParameter(
            RString hokensha,
            boolean subGyomuCodeFlag,
            RString shujiiIryokikanCodeFrom,
            RString shujiiIryokikanCodeTo,
            boolean shujiiIryokikanCodeJokyoFlag,
            RString iryoKikanMeisho,
            RString iryoKikanMeishoKana,
            RString shujiiCodeFrom,
            RString shujiiCodeTo,
            boolean shujiiJokyoFlag,
            RString shujiiName,
            RString shujiiKana,
            int maxCount) {
        boolean shujiiIryokikanCodeFromFlag = false;
        boolean shujiiIryokikanCodeToFlag = false;
        boolean iryoKikanMeishoFlag = false;
        boolean iryoKikanMeishoKanaFlag = false;
        boolean shujiiCodeFromFlag = false;
        boolean shujiiCodeToFlag = false;
        boolean shujiiNameFlag = false;
        boolean shujiiKanaFlag = false;
        if (!RString.isNullOrEmpty(shujiiIryokikanCodeFrom)) {
            shujiiIryokikanCodeFromFlag = true;
        }
        if (!RString.isNullOrEmpty(shujiiIryokikanCodeTo)) {
            shujiiIryokikanCodeToFlag = true;
        }
        if (!RString.isNullOrEmpty(iryoKikanMeisho)) {
            iryoKikanMeishoFlag = true;
        }
        if (!RString.isNullOrEmpty(iryoKikanMeishoKana)) {
            iryoKikanMeishoKanaFlag = true;
        }
        if (!RString.isNullOrEmpty(shujiiCodeFrom)) {
            shujiiCodeFromFlag = true;
        }
        if (!RString.isNullOrEmpty(shujiiCodeTo)) {
            shujiiCodeToFlag = true;
        }
        if (!RString.isNullOrEmpty(shujiiName)) {
            shujiiNameFlag = true;
        }
        if (!RString.isNullOrEmpty(shujiiKana)) {
            shujiiKanaFlag = true;
        }
        return new ShujiiIryokikanAndShujiiGuideParameter(
                hokensha,
                subGyomuCodeFlag,
                shujiiIryokikanCodeFrom,
                shujiiIryokikanCodeFromFlag,
                shujiiIryokikanCodeTo,
                shujiiIryokikanCodeToFlag,
                shujiiIryokikanCodeJokyoFlag,
                iryoKikanMeisho,
                iryoKikanMeishoFlag,
                iryoKikanMeishoKana,
                iryoKikanMeishoKanaFlag,
                shujiiCodeFrom,
                shujiiCodeFromFlag,
                shujiiCodeTo,
                shujiiCodeToFlag,
                shujiiJokyoFlag,
                shujiiName,
                shujiiNameFlag,
                shujiiKana,
                shujiiKanaFlag,
                maxCount);
    }
}
