/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.SikakuSaisinnsikiRelateEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課の情報一時テーブルを更新（4月開始最新化）processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class UpdFukaTemp1Process extends BatchProcessBase<SikakuSaisinnsikiRelateEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select資格等最新化_４月開更新");
    private TokuchoKarisanteiFukaProcessParameter processParameter;
    private static final RString 賦課情報一時テーブル_NAME = new RString("DbT2002FukaJohoTemp");
    private static final int INT_1 = 1;
    private List<SeikatsuHogoJukyusha> 生保の情報;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報;
    private FukaJohoTempEntity 賦課情報一時Entity;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private List<UrT0526SeikatsuHogoFujoShuruiEntity> 生活保護扶助種類EntityList;
    private ChoshuHoho 徴収方法の情報;
    private HihokenshaDaicho 資格の情報;
    private FlexibleDate 前年度生保開始日;
    private FlexibleDate 前年度生保廃止日;
    private FlexibleDate 前年度老年開始日;
    private FlexibleDate 前年度老年廃止日;
    private RString 前年度世帯課税区分;
    private RString 前年度課税区分;
    private Decimal 前年度合計所得金額;
    private Decimal 前年度公的年金収入額;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private ShikibetsuCode 識別コード;
    private GyomuCode 業務コード;
    private FlexibleDate 受給開始日;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        super.initialize();
        賦課情報一時Entity = null;
        生保の情報 = new ArrayList<>();
        老齢の情報 = new ArrayList<>();
        生活保護受給者Entity = new UrT0508SeikatsuHogoJukyushaEntity();
        生活保護扶助種類EntityList = new ArrayList<>();
        徴収方法の情報 = null;
        資格の情報 = null;
        前年度生保開始日 = null;
        前年度生保廃止日 = null;
        前年度老年開始日 = null;
        前年度老年廃止日 = null;
        前年度世帯課税区分 = null;
        前年度課税区分 = null;
        前年度合計所得金額 = null;
        前年度公的年金収入額 = null;
        調定年度 = null;
        賦課年度 = null;
        通知書番号 = null;
        識別コード = null;
        業務コード = null;
        受給開始日 = null;
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoKarisanteiFukaMyBatisParameter parameter = new TokuchoKarisanteiFukaMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        parameter.set調定年度BeforeYear(processParameter.get調定年度().minusYear(INT_1));
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(賦課情報一時テーブル_NAME, FukaJohoTempEntity.class);
    }

    @Override
    protected void process(SikakuSaisinnsikiRelateEntity entity) {
        if (賦課情報一時Entity == null) {
            賦課情報一時Entity = entity.get賦課情報一時Entity();
            set老齢の情報(entity.get老齢の情報());
            set徴収方法の情報(entity.get徴収方法の情報());
            set資格の情報(entity.get資格の情報());
            set被保険者番号(entity);
            set識別コード(entity);
            set生活保護受給者Entity(entity.get生活保護受給者Entity());
            set生活保護扶助種類EntityList(entity.get生活保護扶助種類Entity());
        } else if (!調定年度.equals(entity.get賦課情報一時Entity().getChoteiNendo())
                || !賦課年度.equals(entity.get賦課情報一時Entity().getFukaNendo())
                || !通知書番号.equals(entity.get賦課情報一時Entity().getTsuchishoNo())) {
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            賦課情報一時Entity = TokuchoKariSanteiFukaManagerBatch.createInstance().reflectShikakuToSaishinApril(
                    processParameter.get調定年度(), processParameter.get調定日時(), 資格の情報, 徴収方法の情報, 生保の情報, 老齢の情報, 前年度生保開始日,
                    前年度生保廃止日, 前年度老年開始日, 前年度老年廃止日, 前年度世帯課税区分, 前年度課税区分, 前年度合計所得金額,
                    前年度公的年金収入額, 賦課情報一時Entity);
            tempDbWriter.update(賦課情報一時Entity);
            set識別コード(entity);
            賦課情報一時Entity = entity.get賦課情報一時Entity();
            老齢の情報 = new ArrayList<>();
            set老齢の情報(entity.get老齢の情報());
            set徴収方法の情報(entity.get徴収方法の情報());
            set資格の情報(entity.get資格の情報());
            set被保険者番号(entity);
            set生活保護受給者Entity(entity.get生活保護受給者Entity());
            生活保護扶助種類EntityList = new ArrayList<>();
            set生活保護扶助種類EntityList(entity.get生活保護扶助種類Entity());
            生保の情報 = new ArrayList<>();
        } else {
            set老齢の情報(entity.get老齢の情報());
            set生保の情報List(entity);
        }
    }

    @Override
    protected void afterExecute() {
        if (通知書番号 != null) {
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            賦課情報一時Entity = TokuchoKariSanteiFukaManagerBatch.createInstance().reflectShikakuToSaishinApril(
                    processParameter.get調定年度(), processParameter.get調定日時(), 資格の情報, 徴収方法の情報, 生保の情報, 老齢の情報, 前年度生保開始日,
                    前年度生保廃止日, 前年度老年開始日, 前年度老年廃止日, 前年度世帯課税区分, 前年度課税区分, 前年度合計所得金額,
                    前年度公的年金収入額, 賦課情報一時Entity);
            tempDbWriter.update(賦課情報一時Entity);
        }
    }

    private void set老齢の情報(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        if (entity != null && (老齢の情報.isEmpty() || isContain(entity))
                && entity.getShikibetsuCode() != null && entity.getJukyuKaishiYMD() != null) {
            entity.initializeMd5();
            老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity));
        }
    }

    private boolean isContain(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        boolean flag = true;
        for (RoreiFukushiNenkinJukyusha 老齢 : 老齢の情報) {
            if (老齢.get識別コード().equals(entity.getShikibetsuCode()) && 老齢.get受給開始年月日().equals(entity.getJukyuKaishiYMD())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void set生保の情報(SeikatsuHogoJukyushaRelateEntity entity) {
        if (entity != null) {
            entity.initializeMd5ToEntities();
            生保の情報.add(new SeikatsuHogoJukyusha(entity));
        }
    }

    private void set徴収方法の情報(DbT2001ChoshuHohoEntity entity) {
        if (entity != null) {
            entity.initializeMd5();
            徴収方法の情報 = new ChoshuHoho(entity);
        }
    }

    private void set資格の情報(DbT1001HihokenshaDaichoEntity entity) {
        if (entity != null) {
            entity.initializeMd5();
            資格の情報 = new HihokenshaDaicho(entity);
        }
    }

    private void set被保険者番号(SikakuSaisinnsikiRelateEntity entity) {
        調定年度 = entity.get賦課情報一時Entity().getChoteiNendo();
        賦課年度 = entity.get賦課情報一時Entity().getFukaNendo();
        通知書番号 = entity.get賦課情報一時Entity().getTsuchishoNo();
    }

    private void set識別コード(SikakuSaisinnsikiRelateEntity entity) {
        if (entity.get生活保護受給者Entity() != null) {
            識別コード = entity.get生活保護受給者Entity().getShikibetsuCode();
            業務コード = entity.get生活保護受給者Entity().getGyomuCode();
            受給開始日 = entity.get生活保護受給者Entity().getJukyuKaishiYMD();
        }
    }

    private void set生活保護受給者Entity(UrT0508SeikatsuHogoJukyushaEntity entity) {
        if (entity != null) {
            生活保護受給者Entity = entity;
        }
    }

    private void set生活保護扶助種類EntityList(UrT0526SeikatsuHogoFujoShuruiEntity entity) {
        if (entity != null && (生活保護扶助種類EntityList.isEmpty() || isContain生活保護扶助種類(entity))) {
            生活保護扶助種類EntityList.add(entity);
        }
    }

    private boolean isContain生活保護扶助種類(UrT0526SeikatsuHogoFujoShuruiEntity entity) {
        boolean flag = true;
        for (UrT0526SeikatsuHogoFujoShuruiEntity urt0526Entity : 生活保護扶助種類EntityList) {
            if (urt0526Entity.getShikibetsuCode().equals(entity.getShikibetsuCode())
                    && urt0526Entity.getGyomuCode().equals(entity.getGyomuCode())
                    && urt0526Entity.getJukyuKaishiYMD().equals(entity.getJukyuKaishiYMD())
                    && urt0526Entity.getFujoShuruiCode().equals(entity.getFujoShuruiCode())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void set生保の情報List(SikakuSaisinnsikiRelateEntity entity) {
        if (entity.get生活保護受給者Entity() != null) {
            if (!entity.get生活保護受給者Entity().getShikibetsuCode().equals(識別コード)
                    || !entity.get生活保護受給者Entity().getGyomuCode().equals(業務コード)
                    || !entity.get生活保護受給者Entity().getJukyuKaishiYMD().equals(受給開始日)) {
                SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
                生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
                生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
                set生保の情報(生活保護受給者RelateEntity);
                set生活保護受給者Entity(entity.get生活保護受給者Entity());
                生活保護扶助種類EntityList = new ArrayList<>();
                set生活保護扶助種類EntityList(entity.get生活保護扶助種類Entity());
                set識別コード(entity);
            } else {
                set生活保護扶助種類EntityList(entity.get生活保護扶助種類Entity());
            }
        }
    }

}
