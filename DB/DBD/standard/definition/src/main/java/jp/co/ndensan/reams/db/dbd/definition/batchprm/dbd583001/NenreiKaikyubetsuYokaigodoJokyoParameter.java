/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd583001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 年齢階級別要介護度状況（統計表）のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiKaikyubetsuYokaigodoJokyoParameter extends BatchParameterBase {

    private RDate 基準日;
    private RDate 基準年月;
    private RString 地区区分;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private RString 旧市町村コード;
    private RString 旧市町村名称;

    /**
     * バッチProcessパラメターを取得します．
     *
     * @return NenreiKaikyubetsuYokaigodoJokyoProcessParameter
     */
    public NenreiKaikyubetsuYokaigodoJokyoProcessParameter toNenreiKaikyubetsuYokaigodoJokyoProcessParameter() {

        return new NenreiKaikyubetsuYokaigodoJokyoProcessParameter(基準日, 基準年月, 地区区分, 開始地区コード,
                終了地区コード, 旧市町村コード, 旧市町村名称);
    }

}
