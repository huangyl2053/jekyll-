/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010;

import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 利用状況統計表（明細リスト）作成_受給者台帳データ取得のMyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ToukeiJukyushaTaichoDataSakuseiMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth 開始年月;
    private FlexibleYearMonth 終了年月;
    private RString 有効 = YukoMukoKubun.有効.getコード();
    private RString 無効 = YukoMukoKubun.無効.getコード();
    private RString 要介護認定状態区分コード = YokaigoJotaiKubun.非該当.getコード();

    /**
     * コンストラクタです。
     *
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     */
    public ToukeiJukyushaTaichoDataSakuseiMybatisParameter(FlexibleYearMonth 開始年月, FlexibleYearMonth 終了年月) {
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
    }
}
