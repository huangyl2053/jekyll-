/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;

/**
 * 利用者負担割合情報クラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
@lombok.Getter
@lombok.Setter
public class FutanWariaiSokujiKouseiRelateEntity {

    private DbT3113RiyoshaFutanWariaiEntity 利用者負担割合;
    private List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細;

    /**
     * コンストラクタです。
     */
    public FutanWariaiSokujiKouseiRelateEntity() {
        利用者負担割合 = new DbT3113RiyoshaFutanWariaiEntity();
        利用者負担割合明細 = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * ShikyuTeishiRelateEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        if (利用者負担割合 != null) {
            this.利用者負担割合.initializeMd5();
        }
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity entity : this.利用者負担割合明細) {
            entity.initializeMd5();
        }
    }
}
