/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD560001;

import jp.co.ndensan.reams.db.dbd.business.core.dbd560001.NinteiTanitsuProcessDataManager;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceShurui;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd560001.DBD560001ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001.YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
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
public class NinteidetaikkatsukousinKoukiProcess extends BatchProcessBase<YokaigoNinteiInterfaceEntity> {

    private static final RString MYBATIS_SELECT_ID_要介護認定 = new RString("jp.co.ndensan.reams.db.dbd.persistence"
            + ".db.mapper.relate.ninteidetaikatsukousin.INinteidetaikkatsukousinMapper.get要介護認定インターフェース情報");
    private DBD560001ProcessParameter parameter;
    private FlexibleDate 認定日;
    private RString configValue_種類情報;
    private RString configValue_医調取込み情報;
    private boolean state;
    private RString 今回の要介護度;
    private RString 前回の要介護度;
    private final RString 厚労省 = YokaigoInterfaceShurui.厚労省.getコード();
    private final RString 電算 = YokaigoInterfaceShurui.電算.getコード();
    private final RString 富士通2 = YokaigoInterfaceShurui.富士通２.getコード();

    @BatchWriter
    private BatchPermanentTableWriter<DbT4001JukyushaDaichoEntity> dbt4001tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4101NinteiShinseiJohoEntity> dbt4101tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4102NinteiKekkaJohoEntity> dbt4102tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_要介護認定);
    }

    @Override
    protected void createWriter() {
        dbt4001tableWriter = new BatchPermanentTableWriter<>(DbT4001JukyushaDaichoEntity.class);
        dbt4101tableWriter = new BatchPermanentTableWriter<>(DbT4101NinteiShinseiJohoEntity.class);
        dbt4102tableWriter = new BatchPermanentTableWriter<>(DbT4102NinteiKekkaJohoEntity.class);
    }

    @Override
    protected void process(YokaigoNinteiInterfaceEntity entity) {
        if (parameter.get認定日() == null || parameter.get認定日().isEmpty()) {
            認定日 = entity.get二次判定日();
        } else {
            認定日 = parameter.get認定日();
        }
        configValue_種類情報 = getタイトル(ConfigNameDBD.要介護ＩＦ_ＩＦ種類);
        configValue_医調取込み情報 = getタイトル(ConfigNameDBD.要介護ＩＦ_医調取込み);
        NinteiTanitsuProcessDataManager manager = new NinteiTanitsuProcessDataManager();
        set受給者台帳の一括(entity, manager);
        set要介護認定結果情報(entity, manager);
    }

    private void set要介護認定申請情報(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {

        if (null == entity.get予備区分4() || entity.get予備区分4().isEmpty()) {
            entity.get要介護認定申請情報Entity().setNinteiShinseiHoreiKubunCode(Code.EMPTY);
        } else {
            entity.get要介護認定申請情報Entity().setNinteiShinseiHoreiKubunCode(new Code(entity.get予備区分4()));
        }
        if (null == entity.get申請種別コード() || entity.get申請種別コード().isEmpty()) {
            entity.get要介護認定申請情報Entity().setNinteiShinseiShinseijiKubunCode(Code.EMPTY);
        } else {
            entity.get要介護認定申請情報Entity().setNinteiShinseiShinseijiKubunCode(new Code(entity.get申請種別コード()));
        }

        if (configValue_種類情報.equals(厚労省)) {
            manager.set医調取込み情報厚労省(entity, configValue_医調取込み情報);
            dbt4101tableWriter.update(entity.get要介護認定申請情報Entity());
        } else if (configValue_種類情報.equals(電算)) {
            manager.set医調取込み情報電算(entity);
            dbt4101tableWriter.update(entity.get要介護認定申請情報Entity());
        }
    }

    private void set要介護認定結果情報(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {
        if (entity.get要介護認定結果情報Entity().getNijiHanteiYMD() != null) {
            if (get要介護認定更新比較結果(entity, manager)) {
                upDate要介護認定結果情報(entity, manager);
            }
        } else {
            insert要介護認定結果情報(entity, manager);
        }
    }

    private void upDate要介護認定結果情報(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {
        manager.upDate要介護認定結果情報広域(entity);
        dbt4102tableWriter.update(entity.get要介護認定結果情報Entity());
    }

    private void insert要介護認定結果情報(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {
        dbt4102tableWriter.insert(manager.insert要介護認定結果情報(entity));
    }

    private void set受給者台帳の一括(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {
        if (get要介護認定更新比較結果(entity, manager)) {
            upDate受給者台帳(entity, manager);
        }
        set要介護認定申請情報(entity, manager);
    }

    private void upDate受給者台帳(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {
        if (configValue_種類情報.equals(富士通2)) {
            upDate受給者台帳Detial(entity, manager);
        } else {
            if (entity.get受給者台帳Entity().getShinsakaiIraiYMD() == null) {
                entity.get受給者台帳Entity().setShinsakaiIraiYMD(entity.get審査会資料作成年月日());
            }
            upDate受給者台帳Detial(entity, manager);
        }
    }

    private void upDate受給者台帳Detial(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {
        dbt4001tableWriter.delete(entity.get受給者台帳Entity());
        dbt4001tableWriter.insert(manager.upDate受給者台帳Detial(entity, 認定日));
    }

    private boolean get要介護認定更新比較結果(YokaigoNinteiInterfaceEntity entity, NinteiTanitsuProcessDataManager manager) {
        state = false;
        Code 前回要介護状態区分コード = entity.get要介護認定申請情報Entity().getZenYokaigoKubunCode();
        if (前回要介護状態区分コード != null) {
            前回の要介護度 = 前回要介護状態区分コード.value();
        } else {
            前回の要介護度 = RString.EMPTY;
        }
        if (entity.get二次判定結果() == null) {
            今回の要介護度 = RString.EMPTY;
        } else {
            今回の要介護度 = entity.get二次判定結果();
        }

        state = manager.set要介護認定更新比較結果1(前回の要介護度, 今回の要介護度);

        return state;
    }

    private RString getタイトル(ConfigNameDBD configName) {
        RString タイトル = DbBusinessConfig.get(configName, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        return null != タイトル ? タイトル : RString.EMPTY;
    }
}
