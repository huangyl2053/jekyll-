/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanshinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;

/**
 * 高額合算申請書エンティティクラスです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoRelateEntity {

    private DbT3068KogakuGassanShinseishoEntity 高額合算申請書;
    private List<DbT3069KogakuGassanShinseishoKanyurekiEntity> 高額合算申請書加入歴リスト;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShinseishoRelateEntity() {
        高額合算申請書 = new DbT3068KogakuGassanShinseishoEntity();
        高額合算申請書加入歴リスト = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * KogakuGassanShinseishoRelateEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        if (高額合算申請書 != null) {
            this.高額合算申請書.initializeMd5();
        }
        if (this.高額合算申請書加入歴リスト != null) {
            for (DbT3069KogakuGassanShinseishoKanyurekiEntity entity : this.高額合算申請書加入歴リスト) {
                entity.initializeMd5();
            }
        }
    }
}
