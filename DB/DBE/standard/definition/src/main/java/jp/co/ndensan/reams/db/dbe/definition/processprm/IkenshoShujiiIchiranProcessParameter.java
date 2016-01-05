/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm;

import jp.co.ndensan.reams.db.dbe.definition.core.ikenshoshujiiichiran.IkenshoShujiiIchiranMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 医療機関・主治医一覧表作成_バッチ処理クラスパラメータクラス
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoShujiiIchiranProcessParameter implements IBatchProcessParameter {

    private final RString shichosonCode;
    private final RString shichosonName;
    private final RString iryoKikanCodeFrom;
    private final RString iryoKikanCodeTo;
    private final RString shujiiCodeFrom;
    private final RString shujiiCodeTo;
    private final RString jyokyo;
    private final RString outputSort;
    private final RString nextpage;

    /**
     * コンストラクタ作成
     *
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名
     * @param iryoKikanCodeFrom 主治医医療機関コードFrom
     * @param iryoKikanCodeTo 主治医医療機関コードTo
     * @param shujiiCodeFrom 主治医コードFrom
     * @param shujiiCodeTo 主治医コードTo
     * @param jyokyo 状況
     * @param outputSort 並び順
     * @param nextpage 改頁
     */
    public IkenshoShujiiIchiranProcessParameter(RString shichosonCode,
            RString shichosonName, RString iryoKikanCodeFrom,
            RString iryoKikanCodeTo, RString shujiiCodeFrom,
            RString shujiiCodeTo, RString jyokyo, RString outputSort,
            RString nextpage) {

        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.iryoKikanCodeFrom = iryoKikanCodeFrom;
        this.iryoKikanCodeTo = iryoKikanCodeTo;
        this.shujiiCodeFrom = shujiiCodeFrom;
        this.shujiiCodeTo = shujiiCodeTo;
        this.jyokyo = jyokyo;
        this.outputSort = outputSort;
        this.nextpage = nextpage;
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
    public static IkenshoShujiiIchiranProcessParameter to主治医一覧表作成ProcessParameter(
            RString shichosonCode, RString shichosonName, RString iryoKikanCodeFrom,
            RString iryoKikanCodeTo, RString shujiiCodeFrom,
            RString shujiiCodeTo, RString jyokyo,
            RString outputSort, RString nextpage) {


        return new IkenshoShujiiIchiranProcessParameter(shichosonCode,
                shichosonName, iryoKikanCodeFrom, iryoKikanCodeTo,
                shujiiCodeFrom, shujiiCodeTo, jyokyo, outputSort, nextpage);
    }
    
    
    /**
     * 医療機関・主治医一覧表作成Mybatisパラメータークラス作成
     *
     * @param processParameter 医療機関・主治医一覧表作成プロセスパラメータークラス
     * @return 医療機関・主治医一覧表作成Mybatisパラメータークラス
     */
    public static IkenshoShujiiIchiranMybatisParameter to主治医一覧表作成MybatisParameter(IkenshoShujiiIchiranProcessParameter processParameter) {

        return IkenshoShujiiIchiranMybatisParameter.to主治医一覧表作成RelateParameter(
                processParameter.getShichosonCode(),
                processParameter.getShichosonName(), processParameter.getIryoKikanCodeFrom(),
                processParameter.getIryoKikanCodeTo(), processParameter.getShujiiCodeFrom(),
                processParameter.getShujiiCodeTo(), processParameter.getJyokyo(),
                processParameter.getOutputSort(), processParameter.getNextpage());
    }
}
