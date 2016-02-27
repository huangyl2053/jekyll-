/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.DankaiGokeigo;
import jp.co.ndensan.reams.db.dbb.definition.core.choteibo.KibetsuGokeigo;

/**
 *
 * 合計後用Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class GokeigoEntity {

    private List<KibetsuGokeigo> 期別合計Parameter;
    private List<DankaiGokeigo> 段階合計Parameter;

    /**
     * コンストラクタです。
     */
    public GokeigoEntity() {
        期別合計Parameter = new ArrayList<>();
        段階合計Parameter = new ArrayList<>();
    }
}
