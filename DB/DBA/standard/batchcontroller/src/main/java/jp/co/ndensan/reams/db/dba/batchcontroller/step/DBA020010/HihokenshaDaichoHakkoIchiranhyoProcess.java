/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA020010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichoikkatsu.HihokenshaDaichoIkkatsu;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.IkkatsuSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba020010.IkkatsuSusakuseiProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaicho.HihokenshaDaichoIchiranHyoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiinJohoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaDaichoIchiranHyoFinder;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichosakusei.HihokenshaDaichoSakuseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票_保険者台帳発行一覧表の処理クラスです
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 */
public class HihokenshaDaichoHakkoIchiranhyoProcess extends BatchKeyBreakBase<ShisetsuNyutaishoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IIkkatsuSakuseiMapper.get被保険者台帳管理");
    private static final ReportId 帳票ID = ReportIdDBA.DBA200002.getReportId();
    private ShutsuryokujunRelateEntity 出力順Entity;
    private IkkatsuSusakuseiProcessParameter processPrm;
    private HihokenshaDaichoIkkatsu business;
    private int リストNO;
    @BatchWriter
    private BatchReportWriter<HihokenshaDaichoHakkoIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshaDaichoHakkoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        リストNO = 0;
        getHihokenshaDaichoIkkatsu();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, setMybatisParameter());
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = Collections.unmodifiableList(出力順Entity.getPageBreakKeys());
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).
                    addBreak(new BreakerCatalog<HihokenshaDaichoHakkoIchiranhyoReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(ShisetsuNyutaishoEntity current) {
    }

    @Override
    protected void usualProcess(ShisetsuNyutaishoEntity entity) {
        HihokenshaEntity 被保険者Entity = business.set被保険者Entity(entity);
        被保険者Entity.setShichosonMeisho(get市町村名称(entity));
        被保険者Entity.setSetaiinJohoEntityList(get世帯一覧情報(entity.get被保険者台帳管理Entity().getShikibetsuCode()));
        HihokenshaDaichoSakusei hihokenshaDaichoSakusei = HihokenshaDaichoSakuseiManager.createInstance().
                getHihokenshaDaichoHenshu(被保険者Entity).records().get(0);
        HihokenshaDaichoIchiranHyoRelateEntity relateEntity = HihokenshaDaichoIchiranHyoFinder.
                createInstance().getChohyoIchiran(hihokenshaDaichoSakusei, entity.get宛名Entity(), リストNO++);
        relateEntity.set番地コード(entity.get番地コード());
        HihokenshaDaichoHakkoIchiranhyoReport report = HihokenshaDaichoHakkoIchiranhyoReport.createReport(business.setHeadItem(relateEntity),
                business.setBodyItem(relateEntity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {

    }

    private void getHihokenshaDaichoIkkatsu() {
        IIkkatsuSakuseiMapper iIkkatsuSakuseiMapper = getMapper(IIkkatsuSakuseiMapper.class);
        出力順Entity = ReportUtil.get出力順情報(HihokenshaDaichoIkkatsu.ShutsuryokujunEnum.class,
                SubGyomuCode.DBA介護資格,
                帳票ID,
                processPrm.getShutsuryokujunId());
        business = new HihokenshaDaichoIkkatsu(iIkkatsuSakuseiMapper.get被保険者台帳管理情報(setMybatisParameter()),
                iIkkatsuSakuseiMapper.get生活保護受給者(),
                iIkkatsuSakuseiMapper.get老齢福祉年金受給者(),
                iIkkatsuSakuseiMapper.get証交付回収(),
                出力順Entity);
    }

    private IkkatsuSakuseiMybatisParameter setMybatisParameter() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        List<JuminShubetsu> juminShubetsu = new ArrayList<>();
        juminShubetsu.add(JuminShubetsu.外国人);
        juminShubetsu.add(JuminShubetsu.日本人);
        juminShubetsu.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsu.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsu);
        return IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(processPrm.isChushutsuFlag(),
                        processPrm.getShichosonCode(),
                        processPrm.getShikibetsuCode(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        出力順Entity.get出力順OrderBy());
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

    private RString get市町村名称(ShisetsuNyutaishoEntity entity) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務,
                processPrm.getLoginUserId());
        RString shichosonMeisho = RString.EMPTY;
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード) || DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード)) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            shichosonMeisho = association.get市町村名();
        }
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード) || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード)
                || DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            shichosonMeisho = entity.getShichosonMeisho();
        }
        return shichosonMeisho;
    }
}
