/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5610001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5610001.KoshinTaishoshaKanriProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5610001.KoshinTaishoshaKanriEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT7202KaigoNinteiHokaiseiKanriMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * バッチ設計_DBD511001_更新対象者抽出事前準備_process処理クラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public class KoshinTaishoshaKanriSelectTableProcess extends BatchProcessBase<KoshinTaishoshaKanriEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinsehhinseirirekininteikekkajoho."
                    + "INinteishinsehhinseirirekininteikekkajohoMapper.get更新申請対象者情報");
    private static final EdabanCode 認定申請枝番コード = new EdabanCode(new RString("000"));
    private static final Code 認定申請区分申請時コード = new Code(new RString("B"));
    private static final Code 広域内転居区分 = new Code(new RString("0"));
    private static final Code 認定申請有効区分 = new Code(new RString("1"));
    private static final RString 認定年度内連番 = new RString("0012");
    private static final RString 新年度内連番 = new RString("0001");
    private static final RString 更新申請対象者管理 = new RString("更新申請対象者管理");
    private static final RString 処理枝番 = new RString("0001");
    private static final Code 処理状態区分 = new Code(new RString("0"));
    private static final Code 取下区分コード = new Code(new RString("1"));
    private KoshinTaishoshaKanriProcessParameter parameter;
    private boolean isInsert = false;
    private RString 厚労省IF識別コード;
    private IDbT7202KaigoNinteiHokaiseiKanriMapper mapper;

    @BatchWriter
    private BatchPermanentTableWriter<DbT4101NinteiShinseiJohoEntity> dbT4101tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4123NinteiKeikakuJohoEntity> dbT4123tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5105NinteiKanryoJohoEntity> dbT5105tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4121ShinseiRirekiJohoEntity> dbT4121tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022tableWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IDbT7202KaigoNinteiHokaiseiKanriMapper.class);
        FlexibleDate date = FlexibleDate.getNowDate();
        DbT7202KaigoNinteiHokaiseiKanriEntity dbT7202Entity = mapper.get厚労省IF識別コード(date);
        厚労省IF識別コード = dbT7202Entity.getKoroshoIfShikibetsuCode();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toKoshinTaishoshaKanriMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT4101tableWriter = new BatchPermanentTableWriter<>(DbT4101NinteiShinseiJohoEntity.class);
        dbT4121tableWriter = new BatchPermanentTableWriter<>(DbT4121ShinseiRirekiJohoEntity.class);
        dbT4123tableWriter = new BatchPermanentTableWriter<>(DbT4123NinteiKeikakuJohoEntity.class);
        dbT5105tableWriter = new BatchPermanentTableWriter<>(DbT5105NinteiKanryoJohoEntity.class);
        dbT7022tableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(KoshinTaishoshaKanriEntity entity) {
        isInsert = true;
        DbT4101NinteiShinseiJohoEntity dbT4101Entity = entity.getDbT4101NinteiShinseiJohoEntity();
        DbT4102NinteiKekkaJohoEntity dbT4102Entity = entity.getDbT4102NinteiKekkaJohoEntity();
        RString 申請書管理番号 = new RString(getCountedItem(SubGyomuCode.DBD介護受給,
                parameter.get市町村コード()).next());
        DbT4101NinteiShinseiJohoEntity insertDbT4101Entity = new DbT4101NinteiShinseiJohoEntity();
        setDbT4101Entity(insertDbT4101Entity, dbT4102Entity, dbT4101Entity, 申請書管理番号);
        dbT4101tableWriter.insert(insertDbT4101Entity);
        DbT4121ShinseiRirekiJohoEntity insertDbT4121Entity = new DbT4121ShinseiRirekiJohoEntity();
        setDbT4121ShinseiRirekiJohoEntity(insertDbT4121Entity, dbT4102Entity, 申請書管理番号);
        dbT4121tableWriter.insert(insertDbT4121Entity);
        dbT4123tableWriter.insert(getDbT4123NinteiKeikakuJohoEntity(申請書管理番号));
        dbT5105tableWriter.insert(getDbT5105NinteiKanryoJohoEntity(申請書管理番号));
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(申請書管理番号), new RString("0001"), 申請書管理番号);
        AccessLogger.log(AccessLogType.更新, PersonalData.withHojinNo(ShikibetsuCode.EMPTY, expandedInfo));

    }

    @Override
    protected void afterExecute() {
        if (isInsert) {
            dbT7022tableWriter.insert(getDbT7022ShoriDateKanriEntity(parameter.get条件指定()));
        }
    }

    private CountedItem getCountedItem(SubGyomuCode subGyomuCode, LasdecCode 市町村コード) {
        RDate rDate = RDate.getNowDate();
        return Saiban.get(subGyomuCode,
                new RString(市町村コード.toString() + rDate.getYear().getYearValue() + rDate.getMonthValue()));
    }

    private void setDbT4101Entity(DbT4101NinteiShinseiJohoEntity entity, DbT4102NinteiKekkaJohoEntity ninteiEntity,
            DbT4101NinteiShinseiJohoEntity dbEntity, RString 申請書管理番号) {
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード));
        entity.setShinseiNendo(FlexibleDate.getNowDate().getNendo());
        entity.setNinteiShinseiYMD(FlexibleDate.EMPTY);
        entity.setNinteiShinseiEdabanCode(認定申請枝番コード);
        entity.setShoKisaiHokenshaNo(dbEntity.getShoKisaiHokenshaNo());
        entity.setHihokenshaNo(dbEntity.getHihokenshaNo());
        entity.setHihokenshaKubunCode(dbEntity.getHihokenshaKubunCode());
        entity.setSeinengappiYMD(dbEntity.getSeinengappiYMD());
        entity.setSeibetsu(dbEntity.getSeibetsu());
        entity.setHihokenshaKana(dbEntity.getHihokenshaKana());
        entity.setHihokenshaName(dbEntity.getHihokenshaName());
        entity.setYubinNo(dbEntity.getYubinNo());
        entity.setJusho(dbEntity.getJusho());
        entity.setTelNo(dbEntity.getTelNo());
        entity.setShishoCode(dbEntity.getShishoCode());
        entity.setShikibetsuCode(dbEntity.getShikibetsuCode());
        entity.setShienShinseiKubun(dbEntity.getShienShinseiKubun());
        entity.setNinteiShinseiRiyu(dbEntity.getNinteiShinseiRiyu());
        entity.setNigoIryoHokenshaName(dbEntity.getNigoIryoHokenshaName());
        entity.setNigoIryoHokenKigoBango(dbEntity.getNigoIryoHokenKigoBango());
        entity.setNigoTokuteiShippeiCode(dbEntity.getNigoTokuteiShippeiCode());
        entity.setJidoWariateJogaishaKubun(dbEntity.getJidoWariateJogaishaKubun());
        entity.setJohoteikyoDoiFlag(dbEntity.getJohoteikyoDoiFlag());
        entity.setRenrakuJikoToChosain(dbEntity.getRenrakuJikoToChosain());
        entity.setRenrakuJikoToShujii(dbEntity.getRenrakuJikoToShujii());
        entity.setEnkitsuchiNashiDoiFlag(dbEntity.getEnkitsuchiNashiDoiFlag());
        entity.setShisetsuNyushoFlag(dbEntity.getShisetsuNyushoFlag());
        entity.setNyushoShisetsuCode(dbEntity.getNyushoShisetsuCode());
        entity.setKateiHomonFlag(dbEntity.getKateiHomonFlag());
        entity.setHomonChosasakiYubinNo(dbEntity.getHomonChosasakiYubinNo());
        entity.setHomonChosasakiJusho(dbEntity.getHomonChosasakiJusho());
        entity.setHomonChosasakiName(dbEntity.getHomonChosasakiName());
        entity.setHomonChosasakiTelNo(dbEntity.getHomonChosasakiTelNo());
        entity.setShichosonRenrakuJiko(dbEntity.getShichosonRenrakuJiko());
        entity.setShinsakaiYusenWaritsukeKubunCode(dbEntity.getShinsakaiYusenWaritsukeKubunCode());
        entity.setNinteiShinseiHoreiKubunCode(Code.EMPTY);
        entity.setNinteiShinseiShinseijiKubunCode(認定申請区分申請時コード);
        entity.setTorisageKubunCode(取下区分コード);
        entity.setAge(FlexibleDate.getNowDate().getYearValue() - entity.getSeinengappiYMD().getYearValue());
        entity.setChikuCode(ChikuCode.EMPTY);
        entity.setMinashiNigoEtcTaishoFlag(false);
        entity.setKoikinaiTenkyoKubun(広域内転居区分);
        entity.setNinteiShinseiYukoKubunCode(認定申請有効区分);
        entity.setShinseiServiceDeleteRiyu(RString.EMPTY);
        entity.setZenYokaigoKubunCode(ninteiEntity.getNijiHanteiYokaigoJotaiKubunCode());
        entity.setZenkaiNinteiYMD(ninteiEntity.getNijiHanteiYMD());
        entity.setZenkaiYukoKikanStart(ninteiEntity.getNijiHanteiNinteiYukoKaishiYMD());
        entity.setZenkaiYukoKikanEnd(ninteiEntity.getNijiHanteiNinteiYukoShuryoYMD());
        entity.setJohoteikyoSiryoOutputYMD(FlexibleDate.EMPTY);
        entity.setChosaKubun(Code.EMPTY);
        entity.setNinteiChosaItakusakiCode(ChosaItakusakiCode.EMPTY);
        entity.setNinteiChosainCode(ChosainCode.EMPTY);
        entity.setShujiiIryokikanCode(RString.EMPTY);
        entity.setShujiiCode(RString.EMPTY);
        entity.setShiteiiFlag(false);
        entity.setIkenshoDataShubetsu(Code.EMPTY);
        entity.setShoriJotaiKubun(処理状態区分);
        entity.setTorisageYMD(FlexibleDate.EMPTY);
        entity.setTorisageRiyu(RString.EMPTY);
        entity.setKyakkaYMD(FlexibleDate.EMPTY);
        entity.setEnkiTsuchiHakkoKaisu(0);
        entity.setKyakkaRiyu(RString.EMPTY);
        entity.setEnkiKetteiYMD(FlexibleDate.EMPTY);
        entity.setEnkiRiyu(RString.EMPTY);
        entity.setEnkiTsuchiHakkoYMD(FlexibleDate.EMPTY);
        entity.setEnkiMikomiKaishiYMD(FlexibleDate.EMPTY);
        entity.setEnkiMikomiShuryoYMD(FlexibleDate.EMPTY);
        entity.setShinsaKeizokuFlag(true);
        entity.setKoshinTsuchiHakkoYMD(FlexibleDate.EMPTY);
        entity.setKoshinTsuchiHakkoKanryoYMD(FlexibleDate.EMPTY);
        entity.setNinteiShinseiJohoTorokuYMD(FlexibleDate.getNowDate());
        entity.setSaiChosaIraiKaisu(0);
        entity.setSaiSakuseiIraiKaisu(0);
        entity.setIfSofuYMD(FlexibleDate.EMPTY);
        entity.setLogicalDeletedFlag(false);

    }

    private void setDbT4121ShinseiRirekiJohoEntity(DbT4121ShinseiRirekiJohoEntity entity,
            DbT4102NinteiKekkaJohoEntity ninteiEntity, RString 申請書管理番号) {
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setZenkaiShinseishoKanriNo(ninteiEntity.getShinseishoKanriNo());
    }

    private FlexibleYear get年度(FlexibleYear 年度) {
        if (!parameter.get年度内連番().isNullOrEmpty()) {
            if (parameter.get年度内連番().equals(認定年度内連番)) {
                年度 = new FlexibleYear(new RString((parameter.get年度().getYearValue() + 1)));
                return 年度;
            } else {
                return parameter.get年度();
            }
        } else {
            return FlexibleDate.getNowDate().getYear();
        }
    }

    private RString get年度内連番(RString 年度内連番) {
        if (!年度内連番.isNullOrEmpty()) {
            if (年度内連番.equals(認定年度内連番)) {
                return 新年度内連番;
            }
            int i = 0;
            while (i < 年度内連番.length()) {
                i++;
                if (年度内連番.toString().charAt(i) != '0') {
                    break;
                }
            }
            RString result = new RString(Integer.parseInt(年度内連番.toString().replaceFirst("^0*", "")) + 1);
            for (int j = 0; j < i; j++) {
                result = new RString("0" + result.toString());
            }
            return result;
        }
        return 新年度内連番;
    }

    private DbT4123NinteiKeikakuJohoEntity getDbT4123NinteiKeikakuJohoEntity(RString 申請書管理番号) {
        DbT4123NinteiKeikakuJohoEntity dbT4123Entity = new DbT4123NinteiKeikakuJohoEntity();
        dbT4123Entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        dbT4123Entity.setCenterSoshinYoteiYMD(FlexibleDate.EMPTY);
        dbT4123Entity.setIchijiHanteiYoteiYMD(FlexibleDate.EMPTY);
        dbT4123Entity.setIkenshoSakuseiIraiYoteiYMD(FlexibleDate.EMPTY);
        dbT4123Entity.setIkenshoTorokuYoteiYMD(FlexibleDate.EMPTY);
        dbT4123Entity.setNinteiShinsakaiWariateYoteiYMD(FlexibleDate.EMPTY);
        dbT4123Entity.setNinteiShinsakaiYoteiYMD(FlexibleDate.EMPTY);
        dbT4123Entity.setNinteichosaIraiYoteiYMD(FlexibleDate.EMPTY);
        dbT4123Entity.setNinteichosaYoteiYMD(FlexibleDate.EMPTY);
        return dbT4123Entity;
    }

    private DbT5105NinteiKanryoJohoEntity getDbT5105NinteiKanryoJohoEntity(RString 申請書管理番号) {
        DbT5105NinteiKanryoJohoEntity entity = new DbT5105NinteiKanryoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setCenterSoshinYMD(FlexibleDate.EMPTY);
        entity.setIchijiHanteiKanryoYMD(FlexibleDate.EMPTY);
        entity.setIkenshoTorokuKanryoYMD(FlexibleDate.EMPTY);
        entity.setMaskingKanryoYMD(FlexibleDate.EMPTY);
        entity.setNinteiShinsakaiKanryoYMD(FlexibleDate.EMPTY);
        entity.setNinteiShinsakaiWariateKanryoYMD(FlexibleDate.EMPTY);
        entity.setNinteiShinseiJohoTorokuKanryoYMD(FlexibleDate.EMPTY);
        entity.setNinteichosaKanryoYMD(FlexibleDate.EMPTY);
        entity.setNinteichosaIraiKanryoYMD(FlexibleDate.EMPTY);
        entity.setNinteichosaKanryoYMD(FlexibleDate.EMPTY);
        return entity;
    }

    private DbT7022ShoriDateKanriEntity getDbT7022ShoriDateKanriEntity(RString 条件指定) {
        if (条件指定.equals(parameter.get前回以降の未処理分())) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBD介護受給);
            entity.setShichosonCode(AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_());
            entity.setShoriName(更新申請対象者管理);
            entity.setShoriEdaban(処理枝番);
            entity.setNendo(get年度(parameter.get年度()));
            entity.setNendoNaiRenban(get年度内連番(parameter.get年度内連番()));
            entity.setKijunYMD(FlexibleDate.EMPTY);
            entity.setKijunTimestamp(YMDHMS.now());
            entity.setTaishoKaishiYMD(FlexibleDate.EMPTY);
            entity.setTaishoKaishiTimestamp(YMDHMS.now().plusMonth(parameter.get対象月().getMonthValue()));
            entity.setTaishoShuryoYMD(FlexibleDate.EMPTY);
            entity.setTaishoShuryoTimestamp(YMDHMS.now().plusMonth(parameter.get対象月().getMonthValue()));
            return entity;
        } else {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBD介護受給);
            entity.setShichosonCode(AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_());
            entity.setShoriName(更新申請対象者管理);
            entity.setShoriEdaban(処理枝番);
            entity.setNendo(get年度(parameter.get年度()));
            entity.setNendoNaiRenban(get年度内連番(parameter.get年度内連番()));
            entity.setKijunYMD(FlexibleDate.EMPTY);
            entity.setKijunTimestamp(YMDHMS.now());
            entity.setTaishoKaishiYMD(FlexibleDate.EMPTY);
            entity.setTaishoKaishiTimestamp(YMDHMS.now().plusDay(parameter.get有効期間終了日From().getDayValue()));
            entity.setTaishoShuryoYMD(FlexibleDate.EMPTY);
            entity.setTaishoKaishiTimestamp(YMDHMS.now().plusDay(parameter.get有効期間終了日To().getDayValue()));
            return entity;
        }
    }
}
