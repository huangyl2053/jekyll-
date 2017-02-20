/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout.ShinseishaDataOutProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請データ出力のバチパラメータクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE010002_ShinseishaDataOutParameter extends BatchParameterBase {

    private static final long serialVersionUID = -2681788327063428184L;

    private static final String KIHONJOHO_OUTPUT = "基本情報出力";
    private static final String CHOSAHYOJOHO_OUTPUT = "調査票情報出力";
    private static final String IKENSHOJOHO_OUTPUT = "意見書情報出力";
    private static final String KENSAKUJIKKO = "検索実行";
    private static final String KENSAKUJOKEN = "検索条件";
    private static final String SHINSEISHOKANRINOLIST = "申請書管理番号リスト";

    @BatchParameter(key = KIHONJOHO_OUTPUT, name = "基本情報出力")
    private boolean 基本情報出力;
    @BatchParameter(key = CHOSAHYOJOHO_OUTPUT, name = "調査票情報出力")
    private boolean 調査票情報出力;
    @BatchParameter(key = IKENSHOJOHO_OUTPUT, name = "意見書情報出力")
    private boolean 意見書情報出力;
    @BatchParameter(key = KENSAKUJIKKO, name = "検索実行")
    private boolean 検索実行;
    @BatchParameter(key = KENSAKUJOKEN, name = "検索条件")
    private ShinseiKensakuMapperParameter 検索条件;
    @BatchParameter(key = SHINSEISHOKANRINOLIST, name = "申請書管理番号リスト")
    private List<RString> 申請書管理番号リスト;

    /**
     * processパラメータを生成します。
     *
     * @return ShinseishaDataOutProcessParameter
     */
    public ShinseishaDataOutProcessParameter toProcessParameter() {
        return new ShinseishaDataOutProcessParameter(検索実行, 検索条件, 申請書管理番号リスト);
    }
}
