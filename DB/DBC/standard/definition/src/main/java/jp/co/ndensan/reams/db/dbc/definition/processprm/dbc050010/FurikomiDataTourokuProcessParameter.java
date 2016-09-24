/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込データ登録処理_Processパラメタークラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiDataTourokuProcessParameter implements IBatchProcessParameter {

    private RString 委託者コード;
    private KinyuKikanCode 代表金融機関コード;
    private RString 振込グループコード;
    private RDate 振込指定年月日;
    private boolean 再処理フラグ;
    private Furikomi_ShoriKubun 処理区分;
    private RDate 誤振込指定年月日;

    /**
     * コンストラクタ
     *
     * @param 委託者コード 委託者コード
     * @param 代表金融機関コード 代表金融機関コード
     * @param 振込グループコード 振込グループコード
     * @param 振込指定年月日 振込指定年月日
     * @param 再処理フラグ 再処理フラグ
     * @param 処理区分 処理区分
     * @param 誤振込指定年月日 誤振込指定年月日
     */
    public FurikomiDataTourokuProcessParameter(RString 委託者コード,
            KinyuKikanCode 代表金融機関コード,
            RString 振込グループコード,
            RDate 振込指定年月日,
            boolean 再処理フラグ,
            Furikomi_ShoriKubun 処理区分,
            RDate 誤振込指定年月日) {
        this.委託者コード = 委託者コード;
        this.代表金融機関コード = 代表金融機関コード;
        this.振込グループコード = 振込グループコード;
        this.振込指定年月日 = 振込指定年月日;
        this.再処理フラグ = 再処理フラグ;
        this.誤振込指定年月日 = 誤振込指定年月日;
    }
}
