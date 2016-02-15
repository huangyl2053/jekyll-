/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import java.util.ArrayList;
import java.util.List;

/**
 * 調定簿作成帳票用Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChoteiboChohyoEntity {

    private List<NendoDataListEntity> 年度データリストEntity;
    private List<GokeiDataListEntity> 年度合計データリストEntity;

    /**
     * コンストラクタです。
     */
    public ChoteiboChohyoEntity() {
        年度データリストEntity = new ArrayList<>();
        年度合計データリストEntity = new ArrayList<>();
    }
}
