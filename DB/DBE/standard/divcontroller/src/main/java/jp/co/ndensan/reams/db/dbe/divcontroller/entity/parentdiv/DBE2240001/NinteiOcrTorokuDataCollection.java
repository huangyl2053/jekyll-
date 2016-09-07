/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査結果取込み（規定・規定外）CSVファイルの項目のクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiOcrTorokuDataCollection implements Serializable {

    private static final long serialVersionUID = 4527592483876631073L;
    private List<NinteiTorokuData> dataList;

    /**
     * コンストラクタです。
     *
     * @param dataList メージ取込み（規定・規定外）CSVファイル
     */
    public NinteiOcrTorokuDataCollection(List<NinteiTorokuData> dataList) {
        this.dataList = dataList;
    }
}
