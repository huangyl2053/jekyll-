/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohokeizokuRelateEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * 賦課の情報一時テーブルに登録（6月開始）processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class InsFukaTemp3Process extends BatchProcessBase<FukaJohokeizokuRelateEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select賦課情報_6月開始");
    private TokuchoKarisanteiFukaProcessParameter processParameter;
    private static final RString 賦課情報一時テーブル_NAME = new RString("DbT2002FukaJohoTemp");
    private static final int 整数_14 = 14;
    private static final int 整数_16 = 16;

    private List<SeikatsuHogoJukyusha> 生保の情報;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private List<UrT0526SeikatsuHogoFujoShuruiEntity> 生活保護扶助種類EntityList;
    private ChoshuHoho 徴収方法の情報;
    private HihokenshaDaicho 資格の情報;
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 賦課年度;
    private RString 前年度保険料段階;
    private FlexibleDate 前年度生保開始日;
    private FlexibleDate 前年度生保廃止日;
    private FlexibleDate 前年度老年開始日;
    private FlexibleDate 前年度老年廃止日;
    private RString 前年度世帯課税区分;
    private RString 前年度課税区分;
    private Decimal 前年度合計所得金額;
    private Decimal 前年度公的年金収入額;
    private ShikibetsuCode 識別コード;
    private GyomuCode 業務コード;
    private FlexibleDate 受給開始日;
    private Map<HihokenshaNo, Integer> 被保険者番号Map;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        super.initialize();
        生保の情報 = new ArrayList<>();
        老齢の情報 = new ArrayList<>();
        生活保護受給者Entity = new UrT0508SeikatsuHogoJukyushaEntity();
        生活保護扶助種類EntityList = new ArrayList<>();
        徴収方法の情報 = null;
        資格の情報 = null;
        被保険者番号 = null;
        前年度保険料段階 = null;
        前年度生保開始日 = null;
        前年度生保廃止日 = null;
        前年度老年開始日 = null;
        前年度老年廃止日 = null;
        前年度世帯課税区分 = null;
        前年度課税区分 = null;
        前年度合計所得金額 = null;
        前年度公的年金収入額 = null;
        識別コード = null;
        業務コード = null;
        受給開始日 = null;
        被保険者番号Map = new HashMap<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(賦課情報一時テーブル_NAME, FukaJohoTempEntity.class);
    }

    @Override
    protected void process(FukaJohokeizokuRelateEntity entity) {
        if (被保険者番号 == null) {
            set老齢の情報(entity.get老齢の情報());
            set徴収方法の情報(entity.get徴収方法の情報());
            set資格の情報(entity.get資格の情報());
            set被保険者番号(entity);
            set識別コード(entity);
            set生活保護受給者Entity(entity.get生活保護受給者Entity());
            set生活保護扶助種類EntityList(entity.get生活保護扶助種類Entity());
        } else if (!被保険者番号.equals(entity.getHihokenshaNo()) || !賦課年度.equals(entity.getFukaNendo())) {
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            FukaJohoTempEntity 賦課情報一時Entity = new FukaJohoTempEntity();
            TokuchoKariSanteiFukaManagerBatch.createInstance().createFukaJohoJune(processParameter.get調定年度(), processParameter.get調定日時(),
                    資格の情報, 徴収方法の情報, 生保の情報, 老齢の情報, 前年度生保開始日, 前年度生保廃止日, 前年度老年開始日, 前年度老年廃止日,
                    前年度世帯課税区分, 前年度課税区分, 前年度合計所得金額, 前年度公的年金収入額, null, 被保険者番号Map, 賦課情報一時Entity, 前年度保険料段階);
            set被保険者番号Map(被保険者番号Map, 賦課情報一時Entity);
            tempDbWriter.insert(賦課情報一時Entity);
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
        if (被保険者番号 != null) {
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            FukaJohoTempEntity 賦課情報一時Entity = new FukaJohoTempEntity();
            TokuchoKariSanteiFukaManagerBatch.createInstance().createFukaJohoJune(processParameter.get調定年度(), processParameter.get調定日時(),
                    資格の情報, 徴収方法の情報, 生保の情報, 老齢の情報, 前年度生保開始日, 前年度生保廃止日, 前年度老年開始日, 前年度老年廃止日,
                    前年度世帯課税区分, 前年度課税区分, 前年度合計所得金額, 前年度公的年金収入額, null, 被保険者番号Map, 賦課情報一時Entity, 前年度保険料段階);
            tempDbWriter.insert(賦課情報一時Entity);
        }
    }

    private void set老齢の情報(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        if (entity != null) {
            entity.initializeMd5();
            if (!老齢の情報.contains(new RoreiFukushiNenkinJukyusha(entity))) {
                老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity));
            }
        }
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

    private void set被保険者番号(FukaJohokeizokuRelateEntity entity) {
        被保険者番号 = entity.getHihokenshaNo();
        賦課年度 = entity.getFukaNendo();
        前年度保険料段階 = entity.getHokenryoDankai();
        前年度生保開始日 = entity.getSeihoKaishiYMD();
        前年度生保廃止日 = entity.getSeihoHaishiYMD();
        前年度老年開始日 = entity.getRonenKaishiYMD();
        前年度老年廃止日 = entity.getSeihoKaishiYMD();
        前年度世帯課税区分 = entity.getSetaikazeiKubun();
        前年度課税区分 = entity.getKazeiKubun();
        前年度合計所得金額 = entity.getGokeiShotokuGaku();
        前年度公的年金収入額 = entity.getNenkinShunyuGaku();
    }

    private void set識別コード(FukaJohokeizokuRelateEntity entity) {
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
        if (entity != null && !生活保護扶助種類EntityList.contains(entity)) {
            生活保護扶助種類EntityList.add(entity);
        }
    }

    private void set生保の情報List(FukaJohokeizokuRelateEntity entity) {
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

    private void set被保険者番号Map(Map<HihokenshaNo, Integer> 被保険者番号Map, FukaJohoTempEntity 賦課情報一時Entity) {
        if (被保険者番号Map.containsKey(賦課情報一時Entity.getHihokenshaNo())) {
            被保険者番号Map.remove(賦課情報一時Entity.getHihokenshaNo());
            int 枝番号 = Integer.valueOf(賦課情報一時Entity.getHihokenshaNo().value().substring(整数_14, 整数_16).toString());
            被保険者番号Map.put(賦課情報一時Entity.getHihokenshaNo(), 枝番号);
        } else {
            int 枝番号 = Integer.valueOf(賦課情報一時Entity.getHihokenshaNo().value().substring(整数_14, 整数_16).toString());
            被保険者番号Map.put(賦課情報一時Entity.getHihokenshaNo(), 枝番号);
        }
    }

}
