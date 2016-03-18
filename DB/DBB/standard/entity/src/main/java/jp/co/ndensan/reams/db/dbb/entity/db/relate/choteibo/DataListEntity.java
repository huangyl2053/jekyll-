/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import java.util.ArrayList;
import java.util.List;

/**
 * データリストEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class DataListEntity {

    private List<KibetsuShokeiEntity> 期別小計Entity;
    private List<DankaiShokeiEntity> 段階小計Entity;
    private List<KibetsuGokeiEntity> 期別合計Entity;
    private List<DankaiGokeiEntity> 段階合計Entity;

    /**
     * コンストラクタです。
     */
    public DataListEntity() {
        期別小計Entity = new ArrayList<>();
        段階小計Entity = new ArrayList<>();
        期別合計Entity = new ArrayList<>();
        段階合計Entity = new ArrayList<>();
    }
}
