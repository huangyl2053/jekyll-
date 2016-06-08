/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmenEntity;

/**
 * 特別地域加算減免RelateEntityクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class TokubetsuchiikiKasanGemmenEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 特別地域加算減免Entityを返します。
     *
     * @return 特別地域加算減免Entity -- SETTER -- 特別地域加算減免Entityを設定します。
     *
     * @param 特別地域加算減免Entity 特別地域加算減免Entity
     */
    private DbT4020TokubetsuchiikiKasanGemmenEntity 特別地域加算減免Entity;
    /**
     * -- GETTER -- 減免減額申請EntityListを返します。
     *
     * @return 減免減額申請EntityList -- SETTER -- 減免減額申請EntityListを設定します。
     *
     * @param 減免減額申請EntityList 減免減額申請EntityList
     */
    private List<DbT4010GemmenGengakuShinseiEntity> 減免減額申請Entity;

    /**
     * コンストラクタです。
     */
    public TokubetsuchiikiKasanGemmenEntity() {
        特別地域加算減免Entity = new DbT4020TokubetsuchiikiKasanGemmenEntity();
        減免減額申請Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TokubetsuchiikiKasanGemmenEntityが持つ{@link DbT4020TokubetsuchiikiKasanGemmenEntity}と<br/>
     * {@link DbT4010GemmenGengakuShinseiEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.特別地域加算減免Entity.initializeMd5();
        for (DbT4010GemmenGengakuShinseiEntity entity : this.減免減額申請Entity) {
            entity.initializeMd5();
        }
    }
}
