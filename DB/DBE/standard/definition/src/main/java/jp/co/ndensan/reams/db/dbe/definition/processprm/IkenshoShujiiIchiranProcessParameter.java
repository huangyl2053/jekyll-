/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 医療機関・主治医一覧表作成_バッチ処理クラスパラメータクラス
 */
public class IkenshoShujiiIchiranProcessParameter implements IMyBatisParameter{

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
    public IkenshoShujiiIchiranProcessParameter(RString shichosonCode, RString shichosonName, RString iryoKikanCodeFrom, RString iryoKikanCodeTo, RString shujiiCodeFrom, RString shujiiCodeTo, RString jyokyo, RString outputSort, RString nextpage) {

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
     * @return 医療機関・主治医一覧表作成Mybatisパラメータークラス
     */
    public IkenshoShujiiIchiranProcessParameter to主治医一覧表作成RelateParameter() {
        return new IkenshoShujiiIchiranProcessParameter(shichosonCode,
                shichosonName, iryoKikanCodeFrom, iryoKikanCodeTo, shujiiCodeFrom, shujiiCodeTo, jyokyo, outputSort, nextpage);
    }
}
