/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110020;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110020.JukyushaIdoRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 受給者異動連絡票作成のパラメータクラスです。
 *
 * @reamsid_L DBC-2720-030 chenhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoRenrakuhyoOutProcessParameter implements IBatchProcessParameter {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 抽出条件;
    private RString ファイル名;
    private int 異動連絡票件数;

    /**
     * コンストラクタ
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 抽出条件 RString
     * @param ファイル名 RString
     */
    public JukyushaIdoRenrakuhyoOutProcessParameter(
            RYearMonth 処理年月,
            RString 再処理区分,
            RString 抽出条件,
            RString ファイル名) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.抽出条件 = 抽出条件;
        this.ファイル名 = ファイル名;
    }

    /**
     * toMybatisParameterのメソッドです。
     *
     * @return JukyushaIdoRenrakuhyoOutMybatisParameter
     */
    public JukyushaIdoRenrakuhyoOutMybatisParameter toMybatisParameter() {
        JukyushaIdoRenrakuhyoOutMybatisParameter parameter = new JukyushaIdoRenrakuhyoOutMybatisParameter();
        parameter.set再処理区分(再処理区分);
        parameter.set処理年月(処理年月);
        parameter.set抽出条件(抽出条件);
        parameter.setファイル名(ファイル名);
        return parameter;
    }
}
