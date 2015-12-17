/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ikenshoshujiiichiran;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji.ShujiiOutputSort;
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
    private final boolean isIryoKikanCodeFromEmpty;
    private final RString iryoKikanCodeTo;
    private final boolean isIryoKikanCodeToEmpty;
    private final RString shujiiCodeFrom;
    private final boolean isShujiiCodeFromEmpty;
    private final RString shujiiCodeTo;
    private final boolean isShujiiCodeToEmpty;
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
     * @param isIryoKikanCodeFromEmpty 主治医医療機関コードFrom有無
     * @param iryoKikanCodeTo 主治医医療機関コードTo
     * @param isIryoKikanCodeToEmpty 主治医医療機関コードTo有無
     * @param shujiiCodeFrom 主治医コードFrom
     * @param shujiiCodeTo 主治医コードTo
     * @param isShujiiCodeFromEmpty 主治医コードFrom有無
     * @param isJyoukyouYukoFlag 有効状況フラグ
     * @param isShujiiCodeToEmpty 主治医コードFrom有無
     * @param isJyoukyouMukoFlag 無効状況フラグ
     * @param isIryoKikanCodeShujiiCodeFlag 並び順(主治医医療機関コード+主治医コード)
     * @param isIryoKikanCodeShujiiNameFlag 並び順(主治医医療機関コード+主治医名称)
     * @param isIryoKikanNameShujiiCodeFlag 並び順(主治医医療機関名称+主治医コード)
     * @param isIryoKikanNameShujiiNameFlag 並び順(主治医医療機関名称+主治医名称)
     */
    public IkenshoShujiiIchiranMybatisParameter(RString shichosonCode, RString shichosonName, RString iryoKikanCodeFrom, boolean isIryoKikanCodeFromEmpty, RString iryoKikanCodeTo, boolean isIryoKikanCodeToEmpty, RString shujiiCodeFrom, boolean isShujiiCodeFromEmpty, RString shujiiCodeTo, boolean isShujiiCodeToEmpty, boolean isJyoukyouYukoFlag, boolean isJyoukyouMukoFlag, boolean isIryoKikanCodeShujiiCodeFlag, boolean isIryoKikanCodeShujiiNameFlag, boolean isIryoKikanNameShujiiCodeFlag, boolean isIryoKikanNameShujiiNameFlag) {
        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.iryoKikanCodeFrom = iryoKikanCodeFrom;
        this.isIryoKikanCodeFromEmpty = isIryoKikanCodeFromEmpty;
        this.iryoKikanCodeTo = iryoKikanCodeTo;
        this.isIryoKikanCodeToEmpty = isIryoKikanCodeToEmpty;
        this.shujiiCodeFrom = shujiiCodeFrom;
        this.isShujiiCodeFromEmpty = isShujiiCodeFromEmpty;
        this.shujiiCodeTo = shujiiCodeTo;
        this.isShujiiCodeToEmpty = isShujiiCodeToEmpty;
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
        boolean isIryoKikanCodeFromFlag = false;
        boolean isIryoKikanCodeToFlag = false;
        boolean isShujiiCodeFromFlag = false;
        boolean isShujiiCodeToFlag = false;

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
        
        if (iryoKikanCodeFrom == null) {
            isIryoKikanCodeFromFlag = true;
        }
        if (iryoKikanCodeTo == null) {
            isIryoKikanCodeToFlag = true;
        }
          if (shujiiCodeFrom == null) {
            isShujiiCodeFromFlag = true;
        }
        if (shujiiCodeTo == null) {
            isShujiiCodeToFlag = true;
        }

        return new IkenshoShujiiIchiranMybatisParameter(shichosonCode,
                shichosonName, iryoKikanCodeFrom, isIryoKikanCodeFromFlag, iryoKikanCodeTo,
                isIryoKikanCodeToFlag, shujiiCodeFrom, isShujiiCodeFromFlag, shujiiCodeTo, isShujiiCodeToFlag, isYukoFlag, isMokuFlag,
                isOutPutSortIryoKikanCodeShujiiCodeFlag, isOutputSortIryoKikanCodeShujiiNameFlag,
                isOutputSortIryoKikanNameShujiiCodeFlag, isOutputSortIryoKikanNameShujiiNameFlag);
    }
}
