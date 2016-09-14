/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd560001;

import static java.lang.String.format;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd560001.DBD560001ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001.YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteidetaikatsukousin.INinteidetaikkatsukousinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
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
    private List<DbT4001JukyushaDaichoEntity> 受給者台帳List;
    private RString configValue_種類情報;
    private RString configValue_医調取込み情報;
    private int 月数;
    private boolean state;
    private RString 今回の要介護度;
    private RString 前回の要介護度;
    private final RString 支1 = new RString("12");
    private final RString 支2 = new RString("13");
    private final RString 介1 = new RString("21");
    private final RString 介2 = new RString("22");
    private final RString 介3 = new RString("23");
    private final RString 介4 = new RString("24");
    private final RString 介5 = new RString("25");
    private final RString 厚労省 = new RString("1");
    private final RString 電算 = new RString("2");
    private final RString 富士通2 = new RString("7");
    private final RString 主治医のみ = new RString("2");
    private final RString 調査員のみ = new RString("3");
    private final RString 両方取込む = new RString("4");

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
    protected void beforeExecute() {
        受給者台帳List = getMapper(INinteidetaikkatsukousinMapper.class).get受給者台帳更新対象データ();
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
        set受給者台帳の一括(entity);
        set要介護認定結果情報(entity);

    }

    private void set要介護認定申請情報(YokaigoNinteiInterfaceEntity entity) {
        if (configValue_種類情報.equals(厚労省)) {
            set医調取込み情報_主治医のみ(entity);
            set医調取込み情報_調査員のみ(entity);
            set医調取込み情報_両方取込む(entity);
            dbt4101tableWriter.update(entity.get要介護認定申請情報Entity());
        } else if (configValue_種類情報.equals(電算)) {
            entity.get要介護認定申請情報Entity().setShujiiIryokikanCode(entity.get医療機関コード());
            entity.get要介護認定申請情報Entity().setShujiiCode(entity.get主治医コード());
            entity.get要介護認定申請情報Entity().setNinteiChosaItakusakiCode(new ChosaItakusakiCode(entity.get調査委託先コード()));
            entity.get要介護認定申請情報Entity().setNinteiChosainCode(new ChosainCode(entity.get調査員コード()));
            dbt4101tableWriter.update(entity.get要介護認定申請情報Entity());
        }
    }

    private void set要介護認定結果情報(YokaigoNinteiInterfaceEntity entity) {
        if (entity.get二次判定結果() != null) {
            if (get要介護認定更新比較結果(entity)) {
                upDate要介護認定結果情報(entity);
            }
        } else {
            DbT4102NinteiKekkaJohoEntity newEntity = new DbT4102NinteiKekkaJohoEntity();
            insert要介護認定結果情報(newEntity, entity);
        }
    }

    private void upDate要介護認定結果情報(YokaigoNinteiInterfaceEntity entity) {
        entity.get要介護認定結果情報Entity().setNijiHanteiYokaigoJotaiKubunCode(new Code(entity.get二次判定結果()));
        entity.get要介護認定結果情報Entity().setNijiHanteiNinteiYukoKaishiYMD(entity.get認定有効開始年月日());
        entity.get要介護認定結果情報Entity().setNijiHanteiNinteiYukoShuryoYMD(entity.get認定有効終了年月日());
        if (entity.get要介護認定結果情報Entity().getShinsakaiShiryoSakuseiYMD() == null) {
            entity.get要介護認定結果情報Entity().setShinsakaiShiryoSakuseiYMD(entity.get審査会資料作成年月日());
        }
        entity.get要介護認定結果情報Entity().setShinsakaiIken(entity.get審査会意見());
        dbt4102tableWriter.update(entity.get要介護認定結果情報Entity());
    }

    private void insert要介護認定結果情報(DbT4102NinteiKekkaJohoEntity newEntity, YokaigoNinteiInterfaceEntity entity) {

        newEntity.setShinseishoKanriNo(entity.get申請書管理番号());
        if (entity.get二次判定日() == null) {
            newEntity.setNijiHanteiYMD(FlexibleDate.EMPTY);
        } else {
            newEntity.setNijiHanteiYMD(entity.get二次判定日());
        }
        if (entity.get二次判定結果() == null) {
            newEntity.setNijiHanteiYokaigoJotaiKubunCode(Code.EMPTY);
        } else {
            newEntity.setNijiHanteiYokaigoJotaiKubunCode(new Code(entity.get二次判定結果()));
        }
        if (entity.get認定有効終了年月日() == null || entity.get認定有効終了年月日() == null) {
            月数 = 0;
        } else {
            月数 = entity.get認定有効終了年月日().getBetweenMonths(entity.get認定有効開始年月日());
            if (entity.get認定有効開始年月日().getDayValue() == 1) {
                月数++;
            }
        }

        newEntity.setNijiHanteiNinteiYukoKikan(月数);
        newEntity.setNijiHanteiNinteiYukoKaishiYMD(entity.get認定有効開始年月日());
        newEntity.setNijiHanteiNinteiYukoShuryoYMD(entity.get認定有効終了年月日());
        newEntity.setShinsakaiShiryoSakuseiYMD(entity.get審査会資料作成年月日());
        newEntity.setShinsakaiIken(entity.get審査会意見());
        dbt4102tableWriter.insert(newEntity);
    }

    private void set受給者台帳の一括(YokaigoNinteiInterfaceEntity entity) {
        for (DbT4001JukyushaDaichoEntity item : 受給者台帳List) {
            ShinseishoKanriNo 申請書管理番号 = item.getShinseishoKanriNo();
            if (item.getHihokenshaNo().equals(entity.get被保険者番号()) && 申請書管理番号 != null
                    && 申請書管理番号.equals(entity.get申請書管理番号())) {
                if (get要介護認定更新比較結果(entity)) {
                    upDate受給者台帳(item, entity);
                }
                set要介護認定申請情報(entity);
            }
        }
    }

    private void upDate受給者台帳(DbT4001JukyushaDaichoEntity item, YokaigoNinteiInterfaceEntity entity) {
        if (configValue_種類情報.equals(富士通2)) {
            upDate受給者台帳Detial(item, entity);
        } else {
            if (item.getShinsakaiIraiYMD() == null) {
                item.setShinsakaiIraiYMD(entity.get審査会資料作成年月日());
            }
            upDate受給者台帳Detial(item, entity);
        }
    }

    private void upDate受給者台帳Detial(DbT4001JukyushaDaichoEntity item, YokaigoNinteiInterfaceEntity entity) {
        item.setShinsakaiIraiYMD(entity.get審査会資料作成年月日());
        item.setRirekiNo(new RString(format("%04d", Integer.valueOf(item.getRirekiNo().toString().replaceFirst("^0*", "")) + 1)));
        RString 受給申請事由 = item.getJukyuShinseiJiyu().value();
        if (受給申請事由 != null && (受給申請事由.equals(new RString("2")) || 受給申請事由.equals(new RString("3")))) {
            item.setShinseiJokyoKubun(new RString("1"));
        }
        item.setChokkinFlag(true);

        item.setYokaigoJotaiKubunCode(new Code(entity.get二次判定結果()));
        item.setNinteiYukoKikanKaishiYMD(entity.get認定有効開始年月日());
        item.setNinteiYukoKikanShuryoYMD(entity.get認定有効終了年月日());
        item.setNinteiYMD(認定日);
        item.setMinashiCode(new Code(String.valueOf(entity.get要介護認定申請情報Entity().getMinashiNigoEtcTaishoFlag())));
        item.setChokkinIdoYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
        item.setChokkinIdoJiyuCode(new Code("01"));
        item.setYukoMukoKubun(new Code("1"));
        item.setDataKubun(new Code("00"));
        item.setRemban(item.getRirekiNo());
        dbt4001tableWriter.update(item);
    }

    private boolean get要介護認定更新比較結果(YokaigoNinteiInterfaceEntity entity) {
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

        set要介護認定更新比較結果1(前回の要介護度, 今回の要介護度);

        return state;
    }

    private void set要介護認定更新比較結果1(RString 前回の要介護度, RString 今回の要介護度) {
        if (前回の要介護度 != null && 前回の要介護度.equals(支1) && (今回の要介護度 != null && get今回の要介護度支1State(今回の要介護度))) {
            state = true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(支2) && (今回の要介護度 != null && get今回の要介護度支2State(今回の要介護度))) {
            state = true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(介1) && (今回の要介護度 != null && get今回の要介護度介1State(今回の要介護度))) {
            state = true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(介2) && (今回の要介護度 != null && get今回の要介護度介2State(今回の要介護度))) {
            state = true;
        }
        set要介護認定更新比較結果2(前回の要介護度, 今回の要介護度);
    }

    private void set要介護認定更新比較結果2(RString 前回の要介護度, RString 今回の要介護度) {
        if (前回の要介護度 != null && 前回の要介護度.equals(介3) && (今回の要介護度 != null && get今回の要介護度介3State(今回の要介護度))) {
            state = true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(介4) && (今回の要介護度 != null && get今回の要介護度介4State(今回の要介護度))) {
            state = true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(介5) && (今回の要介護度 != null && get今回の要介護度介5State(今回の要介護度))) {
            state = true;
        }
    }

    private boolean get今回の要介護度支1State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支1) || 今回の要介護度.equals(支2)
                || 今回の要介護度.equals(介1);
    }

    private boolean get今回の要介護度支2State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支1) || 今回の要介護度.equals(支2)
                || 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2);
    }

    private boolean get今回の要介護度介1State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支1) || 今回の要介護度.equals(支2)
                || 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2) || 今回の要介護度.equals(介3);
    }

    private boolean get今回の要介護度介2State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支2) || 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2)
                || 今回の要介護度.equals(介3) || 今回の要介護度.equals(介4);
    }

    private boolean get今回の要介護度介3State(RString 今回の要介護度) {
        return 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2) || 今回の要介護度.equals(介3)
                || 今回の要介護度.equals(介4) || 今回の要介護度.equals(介5);
    }

    private boolean get今回の要介護度介4State(RString 今回の要介護度) {
        return 今回の要介護度.equals(介2) || 今回の要介護度.equals(介3) || 今回の要介護度.equals(介4) || 今回の要介護度.equals(介5);
    }

    private boolean get今回の要介護度介5State(RString 今回の要介護度) {
        return 今回の要介護度.equals(介3) || 今回の要介護度.equals(介4) || 今回の要介護度.equals(介5);
    }

    private RString getタイトル(ConfigNameDBD configName) {
        RString タイトル = DbBusinessConfig.get(configName, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        return null != タイトル ? タイトル : RString.EMPTY;
    }

    private void set医調取込み情報_主治医のみ(YokaigoNinteiInterfaceEntity entity) {
        if (configValue_医調取込み情報.equals(主治医のみ)) {
            entity.get要介護認定申請情報Entity().setShujiiIryokikanCode(entity.get医療機関コード());
            entity.get要介護認定申請情報Entity().setShujiiCode(entity.get主治医コード());
        }
    }

    private void set医調取込み情報_調査員のみ(YokaigoNinteiInterfaceEntity entity) {
        if (configValue_医調取込み情報.equals(調査員のみ)) {
            entity.get要介護認定申請情報Entity().setNinteiChosaItakusakiCode(new ChosaItakusakiCode(entity.get調査委託先コード()));
            entity.get要介護認定申請情報Entity().setNinteiChosainCode(new ChosainCode(entity.get調査員コード()));
        }
    }

    private void set医調取込み情報_両方取込む(YokaigoNinteiInterfaceEntity entity) {
        if (configValue_医調取込み情報.equals(両方取込む)) {
            entity.get要介護認定申請情報Entity().setShujiiIryokikanCode(entity.get医療機関コード());
            entity.get要介護認定申請情報Entity().setShujiiCode(entity.get主治医コード());
            entity.get要介護認定申請情報Entity().setNinteiChosaItakusakiCode(new ChosaItakusakiCode(entity.get調査委託先コード()));
            entity.get要介護認定申請情報Entity().setNinteiChosainCode(new ChosainCode(entity.get調査員コード()));
        }
    }

}
