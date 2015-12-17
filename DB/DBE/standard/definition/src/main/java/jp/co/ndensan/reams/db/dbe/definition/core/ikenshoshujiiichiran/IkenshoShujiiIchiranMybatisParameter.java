/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ikenshoshujiiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.dokuji.ShujiiOutputSort;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 医療機関・主治医一覧表作成_バッチ処理クラスパラメータクラス
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoShujiiIchiranMybatisParameter implements IMyBatisParameter {

    private final RString shichosonCode;
    private final RString shichosonName;
    private final RString iryoKikanCodeFrom;
    private final RString iryoKikanCodeTo;
    private final RString shujiiCodeFrom;
    private final RString shujiiCodeTo;
    private final boolean isJyoukyouYukoFlag;
    private final boolean isJyoukyouMukoFlag;
    private final boolean isIryoKikanCodeShujiiCodeFlag;
    private final boolean isIryoKikanCodeShujiiNameFlag;
    private final boolean isIryoKikanNameShujiiCodeFlag;
    private final boolean isIryoKikanNameShujiiNameFlag;

    /**
     * コンストラクタ作成
     *
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名
     * @param iryoKikanCodeFrom 主治医医療機関コードFrom
     * @param iryoKikanCodeTo 主治医医療機関コードTo
     * @param shujiiCodeFrom 主治医コードFrom
     * @param shujiiCodeTo 主治医コードTo
     * @param isJyoukyouYukoFlag 有効状況フラグ
     * @param isJyoukyouMukoFlag 無効状況フラグ
     * @param isIryoKikanCodeShujiiCodeFlag 並び順(主治医医療機関コード+主治医コード)
     * @param isIryoKikanCodeShujiiNameFlag 並び順(主治医医療機関コード+主治医名称)
     * @param isIryoKikanNameShujiiCodeFlag 並び順(主治医医療機関名称+主治医コード)
     * @param isIryoKikanNameShujiiNameFlag 並び順(主治医医療機関名称+主治医名称)
     */
    public IkenshoShujiiIchiranMybatisParameter(RString shichosonCode,
            RString shichosonName, RString iryoKikanCodeFrom,
            RString iryoKikanCodeTo, RString shujiiCodeFrom,
            RString shujiiCodeTo, boolean isJyoukyouYukoFlag,
            boolean isJyoukyouMukoFlag, boolean isIryoKikanCodeShujiiCodeFlag,
            boolean isIryoKikanCodeShujiiNameFlag,
            boolean isIryoKikanNameShujiiCodeFlag,
            boolean isIryoKikanNameShujiiNameFlag) {

        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.iryoKikanCodeFrom = iryoKikanCodeFrom;
        this.iryoKikanCodeTo = iryoKikanCodeTo;
        this.shujiiCodeFrom = shujiiCodeFrom;
        this.shujiiCodeTo = shujiiCodeTo;
        this.isJyoukyouYukoFlag = isJyoukyouYukoFlag;
        this.isJyoukyouMukoFlag = isJyoukyouMukoFlag;
        this.isIryoKikanCodeShujiiCodeFlag = isIryoKikanCodeShujiiCodeFlag;
        this.isIryoKikanCodeShujiiNameFlag = isIryoKikanCodeShujiiNameFlag;
        this.isIryoKikanNameShujiiCodeFlag = isIryoKikanNameShujiiCodeFlag;
        this.isIryoKikanNameShujiiNameFlag = isIryoKikanNameShujiiNameFlag;
    }

    /**
     * 医療機関・主治医一覧表作成Mybatisパラメータークラス作成
     *
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名
     * @param iryoKikanCodeFrom 主治医医療機関コードFrom
     * @param iryoKikanCodeTo 主治医医療機関コードTo
     * @param shujiiCodeFrom 主治医コードFrom
     * @param shujiiCodeTo 主治医コードTo
     * @param jyokyo 状況
     * @param outputSort 出力順
     * @param nextpage 改頁
     * @return 医療機関・主治医一覧表作成Mybatisパラメータークラス
     */
    public static IkenshoShujiiIchiranMybatisParameter to主治医一覧表作成RelateParameter(
            RString shichosonCode, RString shichosonName, RString iryoKikanCodeFrom,
            RString iryoKikanCodeTo, RString shujiiCodeFrom,
            RString shujiiCodeTo, RString jyokyo,
            RString outputSort, RString nextpage) {

        boolean isYukoFlag = false;
        boolean isMokuFlag = false;
        boolean isOutPutSortIryoKikanCodeShujiiCodeFlag = false;
        boolean isOutputSortIryoKikanCodeShujiiNameFlag = false;
        boolean isOutputSortIryoKikanNameShujiiCodeFlag = false;
        boolean isOutputSortIryoKikanNameShujiiNameFlag = false;
        if (new RString("1").equals(jyokyo)) {
            isYukoFlag = true;
        } else if (new RString("2").equals(jyokyo)) {
            isMokuFlag = true;
        }

        if (ShujiiOutputSort.医療機関コード主治医コード.getコード().equals(outputSort)) {
            isOutPutSortIryoKikanCodeShujiiCodeFlag = true;
        } else if (ShujiiOutputSort.医療機関コード主治医名称.getコード().equals(outputSort)) {
            isOutputSortIryoKikanCodeShujiiNameFlag = true;
        } else if (ShujiiOutputSort.医療機関名称主治医コード.getコード().equals(outputSort)) {
            isOutputSortIryoKikanNameShujiiCodeFlag = true;
        } else {
            isOutputSortIryoKikanNameShujiiNameFlag = true;
        }

        return new IkenshoShujiiIchiranMybatisParameter(shichosonCode,
                shichosonName, iryoKikanCodeFrom, iryoKikanCodeTo,
                shujiiCodeFrom, shujiiCodeTo, isYukoFlag, isMokuFlag,
                isOutPutSortIryoKikanCodeShujiiCodeFlag, isOutputSortIryoKikanCodeShujiiNameFlag,
                isOutputSortIryoKikanNameShujiiCodeFlag, isOutputSortIryoKikanNameShujiiNameFlag);
    }
}
