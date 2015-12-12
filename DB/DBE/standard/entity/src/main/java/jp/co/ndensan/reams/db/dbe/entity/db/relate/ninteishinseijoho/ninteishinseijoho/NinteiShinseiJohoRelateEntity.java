/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseijoho.ninteishinseijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5129TennyuShiboEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5590ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;

/**
 * 要介護認定申請情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteiShinseiJohoRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 要介護認定申請情報Entityを返します。
     *
     * @return 要介護認定申請情報Entity -- SETTER -- 要介護認定申請情報Entityを設定します。
     *
     * @param 要介護認定申請情報Entity 要介護認定申請情報Entity
     */
    private DbT5101NinteiShinseiJohoEntity 要介護認定申請情報Entity;

    /**
     * -- GETTER -- 要介護認定結果情報EntityListを返します。
     *
     * @return 要介護認定結果情報EntityList -- SETTER -- 要介護認定結果情報EntityListを設定します。
     *
     * @param 要介護認定結果情報EntityList 要介護認定結果情報EntityList
     */
    private List<DbT5102NinteiKekkaJohoEntity> 要介護認定結果情報Entity;

    /**
     * -- GETTER -- 要介護認定一次判定結果情報EntityListを返します。
     *
     * @return 要介護認定一次判定結果情報EntityList -- SETTER -- 要介護認定一次判定結果情報EntityListを設定します。
     *
     * @param 要介護認定一次判定結果情報EntityList 要介護認定一次判定結果情報EntityList
     */
    private List<DbT5116IchijiHanteiKekkaJohoEntity> 要介護認定一次判定結果情報Entity;

    /**
     * -- GETTER -- 要介護認定完了情報EntityListを返します。
     *
     * @return 要介護認定完了情報EntityList -- SETTER -- 要介護認定完了情報EntityListを設定します。
     *
     * @param 要介護認定完了情報EntityList 要介護認定完了情報EntityList
     */
    private List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報Entity;

    /**
     * -- GETTER -- イメージ情報EntityListを返します。
     *
     * @return イメージ情報EntityList -- SETTER -- イメージ情報EntityListを設定します。
     *
     * @param イメージ情報EntityList イメージ情報EntityList
     */
    private List<DbT5115ImageEntity> イメージ情報Entity;

    /**
     * -- GETTER -- 申請届出情報EntityListを返します。
     *
     * @return 申請届出情報EntityList -- SETTER -- 申請届出情報EntityListを設定します。
     *
     * @param 申請届出情報EntityList 申請届出情報EntityList
     */
    private List<DbT5120ShinseitodokedeJohoEntity> 申請届出情報Entity;

    /**
     * -- GETTER -- 申請履歴情報EntityListを返します。
     *
     * @return 申請履歴情報EntityList -- SETTER -- 申請履歴情報EntityListを設定します。
     *
     * @param 申請履歴情報EntityList 申請履歴情報EntityList
     */
    private List<DbT5121ShinseiRirekiJohoEntity> 申請履歴情報Entity;

    /**
     * -- GETTER -- 通知書発行情報EntityListを返します。
     *
     * @return 通知書発行情報EntityList -- SETTER -- 通知書発行情報EntityListを設定します。
     *
     * @param 通知書発行情報EntityList 通知書発行情報EntityList
     */
    private List<DbT5122TsuchishoHakkoJohoEntity> 通知書発行情報Entity;

    /**
     * -- GETTER -- 要介護認定計画情報EntityListを返します。
     *
     * @return 要介護認定計画情報EntityList -- SETTER -- 要介護認定計画情報EntityListを設定します。
     *
     * @param 要介護認定計画情報EntityList 要介護認定計画情報EntityList
     */
    private List<DbT5123NinteiKeikakuJohoEntity> 要介護認定計画情報Entity;

    /**
     * -- GETTER -- 転入・死亡情報EntityListを返します。
     *
     * @return 転入・死亡情報EntityList -- SETTER -- 転入・死亡情報EntityListを設定します。
     *
     * @param 転入・死亡情報EntityList 転入・死亡情報EntityList
     */
    private List<DbT5129TennyuShiboEntity> 転入_死亡情報Entity;

    /**
     * -- GETTER -- 介護連絡先情報EntityListを返します。
     *
     * @return 介護連絡先情報EntityList -- SETTER -- 介護連絡先情報EntityListを設定します。
     *
     * @param 介護連絡先情報EntityList 介護連絡先情報EntityList
     */
    private List<DbT5150RenrakusakiJohoEntity> 介護連絡先情報Entity;

    /**
     * -- GETTER -- 要介護認定1.5次判定結果情報EntityListを返します。
     *
     * @return 要介護認定1.5次判定結果情報EntityList -- SETTER -- 要介護認定1.5次判定結果情報EntityListを設定します。
     *
     * @param 要介護認定1.5次判定結果情報EntityList 要介護認定1.5次判定結果情報EntityList
     */
    private List<DbT5510IchiGojiHanteiKekkaJohoEntity> 要介護認定1_5次判定結果情報Entity;

    /**
     * -- GETTER -- 審査会委員除外情報EntityListを返します。
     *
     * @return 審査会委員除外情報EntityList -- SETTER -- 審査会委員除外情報EntityListを設定します。
     *
     * @param 審査会委員除外情報EntityList 審査会委員除外情報EntityList
     */
    private List<DbT5590ShinsakaiIinJogaiJohoEntity> 審査会委員除外情報Entity;

    /**
     * コンストラクタです。
     */
    public NinteiShinseiJohoRelateEntity() {

        要介護認定結果情報Entity = new ArrayList<>();
        要介護認定一次判定結果情報Entity = new ArrayList<>();
        要介護認定完了情報Entity = new ArrayList<>();
        イメージ情報Entity = new ArrayList<>();
        申請届出情報Entity = new ArrayList<>();
        申請履歴情報Entity = new ArrayList<>();
        通知書発行情報Entity = new ArrayList<>();
        要介護認定計画情報Entity = new ArrayList<>();
        転入_死亡情報Entity = new ArrayList<>();
        介護連絡先情報Entity = new ArrayList<>();
        要介護認定1_5次判定結果情報Entity = new ArrayList<>();
        審査会委員除外情報Entity = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteiShinseiJohoRelateEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link 要介護認定申請情報Entity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.要介護認定申請情報Entity.initializeMd5();
        for (DbT5102NinteiKekkaJohoEntity entity : this.要介護認定結果情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5116IchijiHanteiKekkaJohoEntity entity : this.要介護認定一次判定結果情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5105NinteiKanryoJohoEntity entity : this.要介護認定完了情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5115ImageEntity entity : this.イメージ情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5120ShinseitodokedeJohoEntity entity : this.申請届出情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5121ShinseiRirekiJohoEntity entity : this.申請履歴情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5122TsuchishoHakkoJohoEntity entity : this.通知書発行情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5123NinteiKeikakuJohoEntity entity : this.要介護認定計画情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5129TennyuShiboEntity entity : this.転入_死亡情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5150RenrakusakiJohoEntity entity : this.介護連絡先情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5510IchiGojiHanteiKekkaJohoEntity entity : this.要介護認定1_5次判定結果情報Entity) {
            entity.initializeMd5();
        }
        for (DbT5590ShinsakaiIinJogaiJohoEntity entity : this.審査会委員除外情報Entity) {
            entity.initializeMd5();
        }
    }
}
