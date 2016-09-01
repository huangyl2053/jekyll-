/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA020010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho.HihokenshaDaichoReport;
import jp.co.ndensan.reams.db.dba.definition.core.hihokenshadaicho.HihokenshaDaichoRelateItem;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.IkkatsuSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba020010.IkkatsuSusakuseiProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiinJohoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichosakusei.HihokenshaDaichoSakuseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator.MyBatisOrderByCreator;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票_被保険者台帳の処理クラスです
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 */
public class HihokenshaDaichoProcess extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IIkkatsuSakuseiMapper.get被保険者台帳管理");
    private static final ReportId 帳票ID = ReportIdDBA.DBA100009.getReportId();
    private static final RString TITLE = new RString("介護保険　被保険者台帳");
    private static final RString HIHOKENSHANOTITLE = new RString("被保険者番号");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_03 = new RString("03");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_05 = new RString("05");
    private static final RString STATE_適用除外者 = new RString("適用除外者");
    private static final RString STATE_他市町村住所地特例者 = new RString("他市町村住所地特例者");
    private static final RString STATE_資格取得者 = new RString("資格取得者");
    private static final RString STATE_資格喪失者 = new RString("資格喪失者");
    private static final RString SOCHIHOKENSHATITLE = new RString("措置保険者");
    private static final RString KYUHOKENSHATITLE = new RString("旧保険者");
    private static final RString JUSHO_TITLE = new RString("住所");
    private static final RString GYOSEIKU_TITLE = new RString("行政区");
    private static final RString NYUSHOSHISETSUSHURUI_11 = new RString("11");
    private static final RString TELEPHONENOTITLE = new RString("連絡先");
    private IkkatsuSusakuseiProcessParameter processPrm;
    private IkkatsuSakuseiMybatisParameter mybatisPrm;
    private IIkkatsuSakuseiMapper iIkkatsuSakuseiMapper;
    private List<HihokenshaDaichoSakusei> 被保険者台帳EntityList;
    @BatchWriter
    private BatchReportWriter<HihokenshaDaichoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshaDaichoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        iIkkatsuSakuseiMapper = getMapper(IIkkatsuSakuseiMapper.class);
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        被保険者台帳EntityList = new ArrayList<>();
        get出力順();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisPrm);

    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity entity) {
        被保険者台帳EntityList.addAll(HihokenshaDaichoSakuseiManager.createInstance().
                getHihokenshaDaichoHenshu(set被保険者Entity(entity)).records());
    }

    @Override
    protected void afterExecute() {
        if (被保険者台帳EntityList != null && !被保険者台帳EntityList.isEmpty()) {
            HihokenshaDaichoReport report = HihokenshaDaichoReport.createReport(被保険者台帳EntityList);
            report.writeBy(reportSourceWriter);
        }
    }

    private HihokenshaEntity set被保険者Entity(DbT1001HihokenshaDaichoEntity entity) {
        HihokenshaEntity 被保険者Entity = new HihokenshaEntity();
        被保険者Entity.setPrintDate(RDateTime.now());
        被保険者Entity.setPage(RString.EMPTY);
        被保険者Entity.setTitle(TITLE);
        被保険者Entity.setShichosonCode(entity.getShichosonCode());
        被保険者Entity.setShichosonMeisho(get市町村名称(entity));
        被保険者Entity.setHihokenshaNoTitle(HIHOKENSHANOTITLE);
        被保険者Entity.setHihokenshaNo(entity.getHihokenshaNo());
        被保険者Entity.setShikibetsuCode(entity.getShikibetsuCode());
        UaFt200FindShikibetsuTaishoEntity 識別対象Entity = get宛名識別対象取得(entity.getShikibetsuCode());
        if (識別対象Entity != null) {
            IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(識別対象Entity);
            IKojin iKojin = shikibetsuTaisho.to個人();
            被保険者Entity.setKanaMeisho(shikibetsuTaisho.get名称().getKana());
            被保険者Entity.setMeisho(shikibetsuTaisho.get名称().getName());
            被保険者Entity.setSeinengappiYMD(iKojin.get生年月日().toFlexibleDate());
            被保険者Entity.setSeibetsuCode(Seibetsu.toValue(iKojin.get性別().getCode()).get名称());
            被保険者Entity.setSetaiCode(iKojin.get世帯コード());
            被保険者Entity.setShikibetsuCode(iKojin.get識別コード());
            IGyoseiKukaku iGyoseiKukaku = iKojin.get行政区画();
            被保険者Entity.setChikucodeTitle1(iGyoseiKukaku.getChiku1().get名称());
            被保険者Entity.setChikuCode1(iGyoseiKukaku.getChiku1().getコード());
            被保険者Entity.setChikucodeTitle2(iGyoseiKukaku.getChiku2().get名称());
            被保険者Entity.setChikuCode2(iGyoseiKukaku.getChiku2().getコード());
            被保険者Entity.setChikucodeTitle3(iGyoseiKukaku.getChiku3().get名称());
            被保険者Entity.setChikuCode3(iGyoseiKukaku.getChiku3().getコード());
            被保険者Entity.setZenkokuJushoCode(iKojin.get住所().get全国住所コード() != null
                    ? iKojin.get住所().get全国住所コード().value() : RString.EMPTY);
            被保険者Entity.setGyoseikuCode(iGyoseiKukaku.getGyoseiku().getコード());
            被保険者Entity.setTelephoneNo1(iKojin.get連絡先１().value());
            被保険者Entity.setJusho(shikibetsuTaisho.get住所().get住所());
        }
        被保険者Entity.setTelephoneNoTitle(TELEPHONENOTITLE);
        被保険者Entity.setJushoTitle(JUSHO_TITLE);
        被保険者Entity.setGyoseikuTitle(GYOSEIKU_TITLE);
        被保険者Entity.setTelephoneNo2(RString.EMPTY);
        被保険者Entity.setSochiHokenshaTitle(SOCHIHOKENSHATITLE);
        被保険者Entity.setKyuHokenshaTitle(KYUHOKENSHATITLE);
        被保険者Entity.setState(get状態(entity));
        if (get入所施設(entity) != null) {
            被保険者Entity.setJigyoshaNo(get入所施設(entity).getJigyoshaNo());
            if (NYUSHOSHISETSUSHURUI_11.equals(get入所施設(entity).getNyushoShisetsuShurui())) {
                被保険者Entity.setJigyoshaMeisho(get入所施設(entity).getJigyoshaName());
            }
            被保険者Entity.setJigyoshaMeisho(!RString.isNullOrEmpty(get入所施設(entity).getJigyoshaMeisho())
                    ? new AtenaMeisho(get入所施設(entity).getJigyoshaMeisho()) : AtenaMeisho.EMPTY);
        }
        if (get医療保険(entity) != null) {
            被保険者Entity.setIryoHokenShubetsu(get医療保険(entity).getIryoHokenShubetsuCode());
            被保険者Entity.setIryoHokenshaMeisho(get医療保険(entity).getIryoHokenshaMeisho());
            被保険者Entity.setIryoHokenKigoNo(get医療保険(entity).getIryoHokenKigoNo());
        }
        IkkatsuSakuseiMybatisParameter mybatisParameter = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(processPrm.isChushutsuFlag(),
                        processPrm.getShichosonCode(),
                        被保険者Entity.getShikibetsuCode(),
                        processPrm.getPsmShikibetsuTaisho(),
                        RString.EMPTY);
        被保険者Entity.setDbT1001HihokenshaDaichoEntityList(iIkkatsuSakuseiMapper.get被保険者台帳管理情報(mybatisParameter));
        被保険者Entity.setShisetsuNyutaishoEntityList(iIkkatsuSakuseiMapper.get生活保護受給者(mybatisParameter));
        被保険者Entity.setDbT7006RoreiFukushiNenkinJukyushaEntityList(iIkkatsuSakuseiMapper.get老齢福祉年金受給者(mybatisParameter));
        被保険者Entity.setDbT7037ShoKofuKaishuEntityList(iIkkatsuSakuseiMapper.get証交付回収(mybatisParameter));
        被保険者Entity.setSetaiinJohoEntityList(get世帯一覧情報(entity.getShikibetsuCode()));
        return 被保険者Entity;
    }

    private List<SetaiinJohoEntity> get世帯一覧情報(ShikibetsuCode shikibetsuCode) {
        List<SetaiinJohoEntity> setaiinJohoEntityList = new ArrayList<>();
        List<SetaiinJoho> setaiinJohoList = SetaiinFinder.createInstance().
                get世帯員情報By識別コード(shikibetsuCode, FlexibleDate.getNowDate());
        for (SetaiinJoho setaiinJoho : setaiinJohoList) {
            SetaiinJohoEntity setaiinJohoEntity = new SetaiinJohoEntity();
            if (setaiinJoho.get識別対象() != null) {
                setaiinJohoEntity.setUaFt200Entity(setaiinJoho.get識別対象().toEntity());
            }
            setaiinJohoEntity.set本人区分(setaiinJoho.get本人区分());
            setaiinJohoEntityList.add(setaiinJohoEntity);
        }
        return setaiinJohoEntityList;
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        if (processPrm.getShutsuryokujunId() != null) {
            IOutputOrder shutsuryokujunId = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBA介護資格,
                    帳票ID,
                    reamsLoginID,
                    Long.valueOf(processPrm.getShutsuryokujunId().toString()));
            if (shutsuryokujunId != null) {
                RString orderBy = MyBatisOrderByCreator.createWithOutOrderBy(HihokenshaDaichoRelateItem.class, shutsuryokujunId);
                mybatisPrm = IkkatsuSakuseiMybatisParameter.
                        createSelectByKeyParam(processPrm.isChushutsuFlag(),
                                processPrm.getShichosonCode(),
                                processPrm.getShikibetsuCode(),
                                processPrm.getPsmShikibetsuTaisho(),
                                orderBy);
            }
        }
    }

    private RString get市町村名称(DbT1001HihokenshaDaichoEntity entity) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務,
                processPrm.getLoginUserId());
        IkkatsuSakuseiMybatisParameter mybatisParameter = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(processPrm.isChushutsuFlag(),
                        entity.getShichosonCode(),
                        processPrm.getShikibetsuCode(),
                        processPrm.getPsmShikibetsuTaisho(),
                        RString.EMPTY);
        RString shichosonMeisho = RString.EMPTY;
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード) || DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード)) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            shichosonMeisho = association.get市町村名();
        }
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード) || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード)
                || DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            HihokenshaEntity shichosonMeishoEntity = iIkkatsuSakuseiMapper.get市町村名称(mybatisParameter);
            if (shichosonMeishoEntity != null) {
                shichosonMeisho = shichosonMeishoEntity.getShichosonMeisho();
            }
        }
        return shichosonMeisho;
    }

    private RString get状態(DbT1001HihokenshaDaichoEntity entity) {
        RString 資格喪失事由コード = entity.getShikakuSoshitsuJiyuCode();
        RString state;
        if (SHIKAKUSOSHITSUJIYUCODE_03.equals(資格喪失事由コード)) {
            state = STATE_適用除外者;
        } else if (SHIKAKUSOSHITSUJIYUCODE_05.equals(資格喪失事由コード)) {
            state = STATE_他市町村住所地特例者;
        } else if (資格喪失事由コード == null) {
            state = STATE_資格取得者;
        } else {
            state = STATE_資格喪失者;
        }
        return state;
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名識別対象取得(ShikibetsuCode shikibetsuCode) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        List<JuminShubetsu> juminShubetsu = new ArrayList<>();
        juminShubetsu.add(JuminShubetsu.外国人);
        juminShubetsu.add(JuminShubetsu.日本人);
        juminShubetsu.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsu.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsu);
        key.set識別コード(shikibetsuCode);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        IkkatsuSakuseiMybatisParameter mybatisParameter = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(processPrm.isChushutsuFlag(),
                        processPrm.getShichosonCode(),
                        processPrm.getShikibetsuCode(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        RString.EMPTY);
        return iIkkatsuSakuseiMapper.get識別対象(mybatisParameter);
    }

    private ShisetsuNyutaishoEntity get入所施設(DbT1001HihokenshaDaichoEntity entity) {
        IkkatsuSakuseiMybatisParameter mybatisParameter = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(processPrm.isChushutsuFlag(),
                        processPrm.getShichosonCode(),
                        entity.getShikibetsuCode(),
                        processPrm.getPsmShikibetsuTaisho(),
                        RString.EMPTY);
        return iIkkatsuSakuseiMapper.get入所施設(mybatisParameter);
    }

    private DbT1008IryohokenKanyuJokyoEntity get医療保険(DbT1001HihokenshaDaichoEntity entity) {
        IkkatsuSakuseiMybatisParameter mybatisParameter = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(processPrm.isChushutsuFlag(),
                        processPrm.getShichosonCode(),
                        entity.getShikibetsuCode(),
                        processPrm.getPsmShikibetsuTaisho(),
                        RString.EMPTY);
        return iIkkatsuSakuseiMapper.get介護保険医療保険加入状況(mybatisParameter);
    }

}
