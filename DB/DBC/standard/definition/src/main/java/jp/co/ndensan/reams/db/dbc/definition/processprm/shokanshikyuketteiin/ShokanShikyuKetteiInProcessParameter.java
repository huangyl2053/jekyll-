/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.shokanshikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 取り込み処のバッチのプロセス用パラメータクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiInProcessParameter implements IBatchProcessParameter {

    private RDate shoriYearMonth;
    private RString saishoriKubun;
    private RString shutsuryoKujun;
    private RString filePath;
    private RString sharedName;
    private IcchiJoken icchijoken;
    private RString saveFilePath;
    private List<RString> fileNameList;

    /**
     * コンストラクタ
     *
     * @param shoriYearMonth 処理年月
     * @param saishoriKubun 再処理区分
     * @param shutsuryoKujun 出力順
     * @param filePath filePatch
     * @param sharedName sharedName
     * @param icchijoken 前方一致
     * @param saveFilePath saveFilePath
     * @param fileNameList List＜csvFileName＞
     */
    public ShokanShikyuKetteiInProcessParameter(RDate shoriYearMonth, RString saishoriKubun, RString shutsuryoKujun,
            RString filePath, RString sharedName, IcchiJoken icchijoken, RString saveFilePath, List<RString> fileNameList) {
        this.shoriYearMonth = shoriYearMonth;
        this.saishoriKubun = saishoriKubun;
        this.shutsuryoKujun = shutsuryoKujun;
        this.filePath = filePath;
        this.sharedName = sharedName;
        this.icchijoken = icchijoken;
        this.saveFilePath = saveFilePath;
        this.fileNameList = fileNameList;
    }
}
