/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD560001;

import jp.co.ndensan.reams.db.dbd.business.core.dbd560001.NinteiTanitsuProcessDataManager;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceShurui;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd560001.DBD560001ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001.NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定データ一括更新のprocessクラスです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
public class NinteidetaikkatsukousinTanitsuProcess extends BatchProcessBase<NinteiKekkaJohoEntity> {

    private static final RString MYBATIS_SELECT_ID_要介護認定結果情報 = new RString("jp.co.ndensan.reams.db.dbd.persistence"
            + ".db.mapper.relate.ninteidetaikatsukousin.INinteidetaikkatsukousinMapper.get要介護認定結果情報");
    private DBD560001ProcessParameter parameter;
    private FlexibleDate 認定日;
    private RString configValue_種類情報;
    private boolean state;
    private RString 今回の要介護度;
    private RString 前回の要介護度;
    private final RString 富士通2 = YokaigoInterfaceShurui.富士通２.getコード();

    @BatchWriter
    private BatchPermanentTableWriter<DbT4001JukyushaDaichoEntity> dbt4001tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_要介護認定結果情報);
    }

    @Override
    protected void createWriter() {
        dbt4001tableWriter = new BatchPermanentTableWriter<>(DbT4001JukyushaDaichoEntity.class);
    }

    @Override
    protected void process(NinteiKekkaJohoEntity entity) {
        if (parameter.get認定日() == null || parameter.get認定日().isEmpty()) {
            認定日 = entity.get二次判定年月日();
        } else {
            認定日 = parameter.get認定日();
        }
        configValue_種類情報 = getタイトル(ConfigNameDBD.要介護ＩＦ_ＩＦ種類);
        NinteiTanitsuProcessDataManager manager = new NinteiTanitsuProcessDataManager();
        set受給者台帳の一括(entity, manager);

    }

    private void set受給者台帳の一括(NinteiKekkaJohoEntity entity, NinteiTanitsuProcessDataManager manager) {
        if (get要介護認定更新比較結果(entity, manager)) {
            upDate受給者台帳(entity, manager);
        }
    }

    private void upDate受給者台帳(NinteiKekkaJohoEntity entity, NinteiTanitsuProcessDataManager manager) {
        if (富士通2.equals(configValue_種類情報)) {
            upDate受給者台帳Detial(entity, manager);
        } else {
            if (entity.get受給者台帳Entity() == null || entity.get受給者台帳Entity().getShinsakaiIraiYMD() == null) {
                entity.get受給者台帳Entity().setShinsakaiIraiYMD(entity.get介護認定審査会資料作成年月日());
            }
            upDate受給者台帳Detial(entity, manager);
        }
    }

    private void upDate受給者台帳Detial(NinteiKekkaJohoEntity entity, NinteiTanitsuProcessDataManager manager) {
        dbt4001tableWriter.delete(entity.get受給者台帳Entity());
        dbt4001tableWriter.insert(manager.set受給者台帳Detail(entity, 認定日));
    }

    private boolean get要介護認定更新比較結果(NinteiKekkaJohoEntity entity, NinteiTanitsuProcessDataManager manager) {
        state = false;
        Code 前回要介護状態区分コード = entity.get要介護認定申請情報Entity().getZenYokaigoKubunCode();
        if (前回要介護状態区分コード != null) {
            前回の要介護度 = 前回要介護状態区分コード.value();
        } else {
            前回の要介護度 = RString.EMPTY;
        }
        if (entity.get二次判定要介護状態区分コード() == null) {
            今回の要介護度 = RString.EMPTY;
        } else {
            今回の要介護度 = entity.get二次判定要介護状態区分コード();
        }
        state = manager.set要介護認定更新比較結果1(前回の要介護度, 今回の要介護度);

        return state;
    }

    private RString getタイトル(ConfigNameDBD configName) {
        RString タイトル = DbBusinessConfig.get(configName, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        return null != タイトル ? タイトル : RString.EMPTY;
    }
}
