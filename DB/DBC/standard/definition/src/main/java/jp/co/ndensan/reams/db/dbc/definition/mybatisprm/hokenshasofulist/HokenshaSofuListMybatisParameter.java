/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshasofulist;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 国保連情報データ媒体取込のクラスです。
 *
 * @reamsid_L DBC-3030-010 lihang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaSofuListMybatisParameter implements IMyBatisParameter {

    private boolean 同月過誤取下分フラグ;
    private RString 審査年月;

    /**
     * コンストラクタです。
     */
    public HokenshaSofuListMybatisParameter() {
        同月過誤取下分フラグ = false;
    }

    /**
     * コンストラクタです。
     *
     * @param 同月過誤取下分フラグ Boolean
     */
    public HokenshaSofuListMybatisParameter(boolean 同月過誤取下分フラグ) {

        this.同月過誤取下分フラグ = 同月過誤取下分フラグ;
    }
}
