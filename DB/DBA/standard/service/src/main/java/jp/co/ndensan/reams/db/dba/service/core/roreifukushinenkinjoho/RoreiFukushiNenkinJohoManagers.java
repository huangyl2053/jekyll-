/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.roreifukushinenkinjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.roreifukushinenkinjoho.BRoreiFukushiNenkinJoho;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金情報の取得処理です.
 *
 *
 */
public class RoreiFukushiNenkinJohoManagers {

    private final DbT7006RoreiFukushiNenkinJukyushaDac dbT7006dac;

    /**
     * コンストラクタです。
     */
    RoreiFukushiNenkinJohoManagers() {
        this.dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @return
     */
    public static RoreiFukushiNenkinJohoManagers createInstance() {
        return InstanceProvider.create(RoreiFukushiNenkinJohoManagers.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @paramMapperProvider mapperProvider
     */
    RoreiFukushiNenkinJohoManagers(DbT7006RoreiFukushiNenkinJukyushaDac dbT7006dac) {
        this.dbT7006dac = dbT7006dac;
    }

    /**
     * 老齢福祉年金情報の取得処理です.
     *
     * @param param
     * @return 老齢福祉年金情報の取得
     */
    @Transaction
    public List<BRoreiFukushiNenkinJoho> getRoreiFukushiNenkinJoho(RoreiFukushiNenkinJohoMapperParameter param) {

        List<BRoreiFukushiNenkinJoho> bRoreilist = new ArrayList();
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = dbT7006dac.selectfor老齢福祉年金履歴情報を取得(param.getShikibetsuCode());
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList();
        }
        for (DbT7006RoreiFukushiNenkinJukyushaEntity temp : entityList) {
            bRoreilist.add(new BRoreiFukushiNenkinJoho(temp));
        }
        return bRoreilist;
    }

    /**
     * 老齢福祉年金履歴情報を登録するです.
     *
     * @param addParam
     * @return
     */
    @Transaction
    public int regRoreiFukushiNenkinJoho(RoreiFukushiNenkinJohoMapperParameter addParam) {

        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setShikibetsuCode(addParam.getShikibetsuCode());
        dbT7006entity.setJukyuKaishiYMD(addParam.getJukyuKaishiYMD());
        dbT7006entity.setJukyuShuryoYMD(addParam.getJukyuShuryoYMD());
        dbT7006entity.setHihokenshaNo(addParam.getHihokenshaNo());

        return dbT7006dac.save(dbT7006entity);

    }

    /**
     * 老齢福祉年金履歴情報を登録前重複チェックするです.
     *
     * @param checkparam
     * @return BRoreiFukushiNenkinJoho
     */
    @Transaction
    public BRoreiFukushiNenkinJoho checkSameJukyuKaishibi(RoreiFukushiNenkinJohoMapperParameter checkparam) {
        DbT7006RoreiFukushiNenkinJukyushaEntity entity = dbT7006dac.countfor老齢福祉年金履歴情報を取得(checkparam.getShikibetsuCode(),
                checkparam.getJukyuKaishiYMD());

        return new BRoreiFukushiNenkinJoho(entity);

    }

    /**
     * 老齢福祉年金情報の更新処理するです.
     *
     * @param updateParam
     * @return
     */
    @Transaction
    public int updRoreiFukushiNenkinJoho(RoreiFukushiNenkinJohoMapperParameter updateParam) {

        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setJukyuKaishiYMD(updateParam.getJukyuKaishiYMD());
        dbT7006entity.setJukyuShuryoYMD(updateParam.getJukyuShuryoYMD());
        dbT7006entity.setShikibetsuCode(updateParam.getShikibetsuCode());
        dbT7006entity.setHihokenshaNo(updateParam.getHihokenshaNo());

        return dbT7006dac.save(dbT7006entity);
    }

    /**
     * 老齢福祉年金履歴情報を論理削除するです.
     *
     * @param deleteParam
     * @return
     */
    @Transaction
    public int delRoreiFukushiNenkinJoho(RoreiFukushiNenkinJohoMapperParameter deleteParam) {

        requireNonNull(deleteParam, UrSystemErrorMessages.値がnull.getReplacedMessage("deleteParam"));
        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setJukyuKaishiYMD(deleteParam.getJukyuKaishiYMD());
        dbT7006entity.setShikibetsuCode(deleteParam.getShikibetsuCode());
        dbT7006entity.setIsDeleted(true);

        return dbT7006dac.save(dbT7006entity);
    }

    /**
     * 受給期間の重複チェックします。
     *
     * @param checkKikanParam
     * @return
     */
    @Transaction
    public Boolean checkKikanJuku(List<RoreiFukushiNenkinJohoMapperParameter> checkKikanParam) {

        List<RoreiFukushiNenkinJohoMapperParameter> list = new ArrayList();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getJukyuKaishiYMD().isBefore(list.get(i).getJukyuShuryoYMD())) {
                return true;
            }
        }
        return false;
    }
}
