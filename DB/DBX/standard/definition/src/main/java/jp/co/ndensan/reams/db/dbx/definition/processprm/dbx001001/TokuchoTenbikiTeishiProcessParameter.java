/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.processprm.dbx001001;

import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.dbx001001.TokuchoTenbikiTeishiMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * TokuchoTenbikiTeishiProcessParameterのクラスです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoTenbikiTeishiProcessParameter implements IBatchProcessParameter {

    private RString 日付関連調定年度;
    private RString 天引月;
    private RString 年度;

    /**
     * TokuchoTenbikiTeishiProcessParameterのコンストラクタです。
     */
    public TokuchoTenbikiTeishiProcessParameter() {
    }

    /**
     * TokuchoTenbikiTeishiProcessParameterのコンストラクタです。
     *
     * @param 日付関連調定年度 RString
     * @param 天引月 RString
     * @param 年度 RString
     */
    public TokuchoTenbikiTeishiProcessParameter(RString 日付関連調定年度, RString 天引月, RString 年度) {
        this.日付関連調定年度 = 日付関連調定年度;
        this.天引月 = 天引月;
        this.年度 = 年度;
    }

    /**
     * TokuchoTenbikiTeishiMyBatisParameterのメソドです。
     *
     * @return TokuchoTenbikiTeishiMyBatisParameter
     */
    public TokuchoTenbikiTeishiMyBatisParameter toMyBatisParameter() {
        return new TokuchoTenbikiTeishiMyBatisParameter(日付関連調定年度, 天引月, 年度);
    }
}
