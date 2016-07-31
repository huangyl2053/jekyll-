/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * イメージ取込み（規定・規定外）CSVファイルの項目のクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorokuDataCollection implements Serializable {

    private static final long serialVersionUID = 4404764509769398475L;
    private List<TorokuData> dataList;

    /**
     * コンストラクタです。
     *
     * @param dataList メージ取込み（規定・規定外）CSVファイル
     */
    public TorokuDataCollection(List<TorokuData> dataList) {
        this.dataList = dataList;
    }
}
