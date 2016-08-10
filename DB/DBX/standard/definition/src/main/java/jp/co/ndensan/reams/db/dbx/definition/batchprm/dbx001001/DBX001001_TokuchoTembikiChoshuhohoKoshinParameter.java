/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.batchprm.dbx001001;

import jp.co.ndensan.reams.db.dbx.definition.processprm.dbx001001.TokuchoTenbikiTeishiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * TokuchoTenbikiTeishiBatchParameterのクラスです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBX001001_TokuchoTembikiChoshuhohoKoshinParameter extends BatchParameterBase {

    @BatchParameter(key = "tenbikiGetu", name = "天引月")
    private RString tenbikiGetu;
    @BatchParameter(key = "nendo", name = "年度")
    private RString nendo;

    /**
     * DBX001001_TokuchoTembikiChoshuhohoKoshinParameterのコンストラクタです。
     */
    public DBX001001_TokuchoTembikiChoshuhohoKoshinParameter() {
    }

    /**
     * toProcessParameterのメソドです。
     *
     * @param 日付関連調定年度 RString
     * @return TokuchoTenbikiTeishiProcessParameter
     */
    public TokuchoTenbikiTeishiProcessParameter toProcessParameter(RString 日付関連調定年度) {
        return new TokuchoTenbikiTeishiProcessParameter(日付関連調定年度, tenbikiGetu, nendo);
    }
}
