/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import java.util.ArrayList;
import java.util.List;

/**
 * 年度合計データリストEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class GokeiDataListEntity {

    private List<GokeiBubunEntity> 合計部分Entity;
    private List<GokeiBubunSoukeiEntity> 合計部分総計Entity;

    /**
     * コンストラクタです。
     */
    public GokeiDataListEntity() {
        合計部分Entity = new ArrayList<>();
        合計部分総計Entity = new ArrayList<>();
    }
}
