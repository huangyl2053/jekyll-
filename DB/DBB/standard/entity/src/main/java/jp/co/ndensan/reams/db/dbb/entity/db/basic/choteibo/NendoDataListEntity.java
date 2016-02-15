/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import java.util.ArrayList;
import java.util.List;

/**
 * 年度データリストEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NendoDataListEntity {

    private List<DataListEntity> 当年度データリストEntity;
    private List<DataListEntity> 前年度データリストEntity;
    private List<DataListEntity> 前々年度データリストEntity;

    /**
     * コンストラクタです。
     */
    public NendoDataListEntity() {
        当年度データリストEntity = new ArrayList<>();
        前年度データリストEntity = new ArrayList<>();
        前々年度データリストEntity = new ArrayList<>();
    }
}
