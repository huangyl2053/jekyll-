/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Value;

/**
 * 保険料段階の識別子です。
 */
@Value
public class HokenryoDankaiIdentifier implements Serializable {

    private final FlexibleYear 賦課年度;
    private final DankaiIndex 段階インデックス;
    private final RankKubun ランク区分;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param 段階インデックス 段階インデックス
     * @param ランク区分 ランク区分
     */
    public HokenryoDankaiIdentifier(FlexibleYear 賦課年度,
            DankaiIndex 段階インデックス,
            RankKubun ランク区分) {
        this.賦課年度 = 賦課年度;
        this.段階インデックス = 段階インデックス;
        this.ランク区分 = ランク区分;
    }
}
