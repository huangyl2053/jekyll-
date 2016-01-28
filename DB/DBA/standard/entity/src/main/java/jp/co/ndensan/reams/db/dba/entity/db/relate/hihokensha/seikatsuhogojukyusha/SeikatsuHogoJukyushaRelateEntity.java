/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.seikatsuhogojukyusha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0528SeikatsuHogoTeishikikanEntity;

/**
 * 生活保護受給者RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class SeikatsuHogoJukyushaRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 生活保護受給者Entityを返します。
     *
     * @return 生活保護受給者Entity -- SETTER -- 生活保護受給者Entityを設定します。
     *
     * @param 生活保護受給者Entity 生活保護受給者Entity
     */
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;

    /**
     * -- GETTER -- 生活保護扶助種類EntityListを返します。
     *
     * @return 生活保護扶助種類EntityList -- SETTER -- 生活保護扶助種類EntityListを設定します。
     *
     * @param 生活保護扶助種類EntityList 生活保護扶助種類EntityList
     */
    private List<UrT0526SeikatsuHogoFujoShuruiEntity> 生活保護扶助種類Entity;

    /**
     * -- GETTER -- 生活保護停止期間EntityListを返します。
     *
     * @return 生活保護停止期間EntityList -- SETTER -- 生活保護停止期間EntityListを設定します。
     *
     * @param 生活保護停止期間EntityList 生活保護停止期間EntityList
     */
    private List<UrT0528SeikatsuHogoTeishikikanEntity> 生活保護停止期間Entity;

    /**
     * コンストラクタです。
     */
    public SeikatsuHogoJukyushaRelateEntity() {
        生活保護受給者Entity = new UrT0508SeikatsuHogoJukyushaEntity();
        生活保護扶助種類Entity = new ArrayList<>();
        生活保護停止期間Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * SeikatsuHogoJukyushaEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/>
     * {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.生活保護受給者Entity.initializeMd5();
        for (UrT0526SeikatsuHogoFujoShuruiEntity entity : this.生活保護扶助種類Entity) {
            entity.initializeMd5();
        }
        for (UrT0528SeikatsuHogoTeishikikanEntity entity : this.生活保護停止期間Entity) {
            entity.initializeMd5();
        }
    }
}
