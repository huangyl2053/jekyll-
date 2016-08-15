/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会審査結果登録（OCR)CSVファイルの項目のクラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiEntityCollection implements Serializable {

    private static final long serialVersionUID = 4404764509769398475L;
    private List<TorikomiEntity> dataList;

    /**
     * コンストラクタです。
     *
     * @param dataList 介護認定審査会審査結果登録（OCR)CSVファイル
     */
    public TorikomiEntityCollection(List<TorikomiEntity> dataList) {
        this.dataList = dataList;
    }
}
