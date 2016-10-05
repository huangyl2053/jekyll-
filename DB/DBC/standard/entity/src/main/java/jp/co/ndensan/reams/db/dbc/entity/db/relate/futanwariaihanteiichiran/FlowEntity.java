/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担割合判定一覧エンティティのクラスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FlowEntity {

    private RString ファイルパス;
    private boolean 類字;

    /**
     * コンストラクタです。
     *
     * @param ファイルパス ファイルパス
     * @param 類字 類字
     */
    public FlowEntity(RString ファイルパス, boolean 類字) {
        this.ファイルパス = ファイルパス;
        this.類字 = 類字;
    }

}
