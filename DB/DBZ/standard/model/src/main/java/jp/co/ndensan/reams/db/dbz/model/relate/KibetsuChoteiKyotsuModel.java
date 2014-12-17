/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.model.KibetsuModel;
import jp.co.ndensan.reams.db.dbz.model.ChoteiKyotsuModel;

// TODO N8156 宮本 康 別ブランチで対応中。マージ時に差し替える。
public class KibetsuChoteiKyotsuModel implements Serializable {

    private KibetsuModel 介護期別モデル;
    private ChoteiKyotsuModel 調定共通モデル;

    public KibetsuChoteiKyotsuModel(KibetsuModel 介護期別モデル, ChoteiKyotsuModel 調定共通モデル) {
        this.介護期別モデル = 介護期別モデル;
        this.調定共通モデル = 調定共通モデル;
    }

    public KibetsuModel get介護期別モデル() {
        return 介護期別モデル;
    }

    public ChoteiKyotsuModel get調定共通モデル() {
        return 調定共通モデル;
    }
}
