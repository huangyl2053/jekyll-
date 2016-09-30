/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE591001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshoshujiiichiran.IkenshoShujiiIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 医療機関・主治医一覧表作成_バッチフロークラスパラメータクラスです。
 *
 * @reamsid_L DBE-0260-030 zuotao
 */
@Setter
@Getter
public class DBE591001_IryokikanShujiiParameter extends BatchParameterBase {

    /**
     * 市町村コード
     */
    public static final String SHICHOSONCODE = "shichosonCode";

    /**
     * 市町村名
     */
    public static final String SHICHOSONNAME = "shichosonName";

    /**
     * 主治医医療機関コードFrom
     */
    public static final String IRYOKIKANCODEFROM = "iryoKikanCodeFrom";

    /**
     * 主治医医療機関コードTo
     */
    public static final String IRYOKIKANCODETO = "iryoKikanCodeTo";

    /**
     * 主治医コードFrom
     */
    public static final String SHUJIICODEFROM = "shujiiCodeFrom";

    /**
     * 主治医コードTO
     */
    public static final String SHUJIICODETO = "shujiiCodeTo";

    /**
     * 状況
     */
    public static final String JYOKYO = "jyokyo";

    /**
     * 並び順
     */
    public static final String OUTPUTSORT = "outputSort";

    /**
     * 改頁
     */
    public static final String NEXTPAGE = "nextpage";

    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString shichosonCode;
    @BatchParameter(key = SHICHOSONNAME, name = "市町村名")
    private RString shichosonName;
    @BatchParameter(key = IRYOKIKANCODEFROM, name = "主治医医療機関コードFrom")
    private RString iryoKikanCodeFrom;
    @BatchParameter(key = IRYOKIKANCODETO, name = "主治医医療機関コードTo")
    private RString iryoKikanCodeTo;
    @BatchParameter(key = SHUJIICODEFROM, name = "主治医コードFrom")
    private RString shujiiCodeFrom;
    @BatchParameter(key = SHUJIICODETO, name = "主治医コードTo")
    private RString shujiiCodeTo;
    @BatchParameter(key = JYOKYO, name = "状況")
    private RString jyokyo;
    @BatchParameter(key = OUTPUTSORT, name = "並び順")
    private RString outputSort;
    @BatchParameter(key = NEXTPAGE, name = "改頁")
    private RString nextpage;

    /**
     * 医療機関・主治医一覧表作成プロセスパラメータークラス作成
     *
     * @return 医療機関・主治医一覧表作成プロセスパラメータークラス
     */
    public IkenshoShujiiIchiranProcessParameter to主治医一覧情報プロセスparameter() {
        return IkenshoShujiiIchiranProcessParameter.to主治医一覧表作成ProcessParameter(
                this.shichosonCode,
                this.shichosonName,
                this.iryoKikanCodeFrom,
                this.iryoKikanCodeTo,
                this.shujiiCodeFrom,
                this.shujiiCodeTo,
                this.jyokyo,
                this.outputSort,
                this.nextpage);
    }
}
