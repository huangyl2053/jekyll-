/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.hihokenshadaicho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;

/**
 * 被保険者台帳管理RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class HihokenshaDaichoRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 被保険者台帳管理Entityを返します。
     *
     * @return 被保険者台帳管理Entity -- SETTER -- 被保険者台帳管理Entityを設定します。
     *
     * @param 被保険者台帳管理Entity 被保険者台帳管理Entity
     */
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity;

    /**
     * -- GETTER -- 受給者台帳EntityListを返します。
     *
     * @return 受給者台帳EntityList -- SETTER -- 受給者台帳EntityListを設定します。
     *
     * @param 受給者台帳EntityList 受給者台帳EntityList
     */
    private List<DbT4001JukyushaDaichoEntity> 受給者台帳Entity;

    /**
     * -- GETTER -- 介護保険施設入退所EntityListを返します。
     *
     * @return 介護保険施設入退所EntityList -- SETTER -- 介護保険施設入退所EntityListを設定します。
     *
     * @param 介護保険施設入退所EntityList 介護保険施設入退所EntityList
     */
    private List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所Entity;

    /**
     * -- GETTER -- 介護保険医療保険加入状況EntityListを返します。
     *
     * @return 介護保険医療保険加入状況EntityList -- SETTER -- 介護保険医療保険加入状況EntityListを設定します。
     *
     * @param 介護保険医療保険加入状況EntityList 介護保険医療保険加入状況EntityList
     */
    private List<DbT1008IryohokenKanyuJokyoEntity> 介護保険医療保険加入状況Entity;

    /**
     * -- GETTER -- 老齢福祉年金受給者EntityListを返します。
     *
     * @return 老齢福祉年金受給者EntityList -- SETTER -- 老齢福祉年金受給者EntityListを設定します。
     *
     * @param 老齢福祉年金受給者EntityList 老齢福祉年金受給者EntityList
     */
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢福祉年金受給者Entity;

    /**
     * -- GETTER -- 生活保護受給者EntityListを返します。
     *
     * @return 生活保護受給者EntityList -- SETTER -- 生活保護受給者EntityListを設定します。
     *
     * @param 生活保護受給者EntityList 生活保護受給者EntityList
     */
    private List<SeikatsuHogoJukyushaRelateEntity> 生活保護受給者Entity;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoRelateEntity() {
        被保険者台帳管理Entity = new DbT1001HihokenshaDaichoEntity();
        受給者台帳Entity = new ArrayList<>();
        介護保険施設入退所Entity = new ArrayList<>();
        介護保険医療保険加入状況Entity = new ArrayList<>();
        老齢福祉年金受給者Entity = new ArrayList<>();
        生活保護受給者Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * HihokenshaDaichoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.被保険者台帳管理Entity.initializeMd5();
        for (DbT4001JukyushaDaichoEntity entity : this.受給者台帳Entity) {
            entity.initializeMd5();
        }
        for (DbT1004ShisetsuNyutaishoEntity entity : this.介護保険施設入退所Entity) {
            entity.initializeMd5();
        }
        for (DbT1008IryohokenKanyuJokyoEntity entity : this.介護保険医療保険加入状況Entity) {
            entity.initializeMd5();
        }
        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : this.老齢福祉年金受給者Entity) {
            entity.initializeMd5();
        }
        for (SeikatsuHogoJukyushaRelateEntity entity : this.生活保護受給者Entity) {
            entity.initializeMd5ToEntities();
        }
    }
}
