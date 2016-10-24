/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb241001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みのprocessパラメーターです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHaishinDataTorikomiProcessParameter implements IBatchProcessParameter {

    private RString fileName;
    private RDateTime fileID;
    private RDateTime shoriYMDHM;
    private FlexibleYearMonth shoriTaishoYM;
    private FlexibleYear shoriNendo;
    private RString hosokuTsuki;
    private RString tenbikiTsuki;
    private RString filePath;

    /**
     * コンストラクタです
     *
     * @param fileName RString
     * @param fileID FlexibleYear
     * @param shoriYMDHM RDateTime
     * @param shoriTaishoYM FlexibleYearMonth
     * @param shoriNendo FlexibleYear
     * @param hosokuTsuki RString
     * @param tenbikiTsuki RString
     * @param filePath RString
     */
    public TokuchoHaishinDataTorikomiProcessParameter(RString fileName, RDateTime fileID, RDateTime shoriYMDHM,
            FlexibleYearMonth shoriTaishoYM, FlexibleYear shoriNendo, RString hosokuTsuki, RString tenbikiTsuki, RString filePath) {
        this.fileName = fileName;
        this.fileID = fileID;
        this.shoriYMDHM = shoriYMDHM;
        this.shoriTaishoYM = shoriTaishoYM;
        this.shoriNendo = shoriNendo;
        this.hosokuTsuki = hosokuTsuki;
        this.tenbikiTsuki = tenbikiTsuki;
        this.filePath = filePath;
    }
}
