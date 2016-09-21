/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還口座払の口座情報取得の業務別主キー取得のMybatisパラメータ。
 *
 * @reamsid_L DBC-2180-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KozaJohoMybatisParameter extends KozaSearchParameter implements IMyBatisParameter {

    private RString データ区分;
    private RString 支払方法区分コード;
    private boolean is口座払;
    private boolean is受領委任払;

    /**
     * コンストラクタです。
     *
     * @param key 口座検索用の検索キークラス
     * @param list 科目コードリスト
     * @param データ区分 RString
     * @param 支払方法区分コード RString
     */
    public KozaJohoMybatisParameter(IKozaSearchKey key, List<KamokuCode> list, RString データ区分, RString 支払方法区分コード) {
        super(key, list);
        this.データ区分 = データ区分;
        this.支払方法区分コード = 支払方法区分コード;
        this.is口座払 = new RString("2").equals(支払方法区分コード);
        this.is受領委任払 = new RString("3").equals(支払方法区分コード);
    }

}
