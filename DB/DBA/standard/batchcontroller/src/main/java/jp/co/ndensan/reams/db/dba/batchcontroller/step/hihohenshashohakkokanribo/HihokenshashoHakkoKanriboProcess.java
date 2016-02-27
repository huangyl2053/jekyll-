/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.hihohenshashohakkokanribo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei.HihohenshashoHakkoKanriboChohyoDataSakusei;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakokanribocsvdatasakusei.HihohenshashoHakoKanriboCsvDataSakusei;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakoKanriboCsvDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshashohakkokanribo.IHihokenshashoHakkoKanriboMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;

/**
 *
 * 被保険者証発行管理簿_バッチ処理クラスです
 */
public class HihokenshashoHakkoKanriboProcess extends SimpleBatchProcessBase {

    private static final RString 証発行モード_001 = new RString("001");
    private static final RString 証発行モード_002 = new RString("002");
    private static final RString 発行管理リスト = new RString("1");
    private static final RString 被保険者証発行 = new RString("介護保険　被保険者証発行管理一覧表");
    private static final RString 資格者証発行 = new RString("介護保険　資格者証発行管理一覧表");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("sakusei"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private HihokenshashoHakkoKanriboProcessParameter processParameter;
    private HihokenshashoHakkoKanriboMybatisParameter mybatisParameter;
    private IHihokenshashoHakkoKanriboMapper mapper;
    private AkasiHakouKanriRelateEntity relateEntityList;

    @BatchWriter
    private EucCsvWriter<HihohenshashoHakoKanriboCsvDataSakuseiEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IHihokenshashoHakkoKanriboMapper.class);
        // TODO  QA377 AccessLogの実装方式 回復待ち　2016/01/20まで
        AccessLogger.log(AccessLogType.照会);
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        relateEntityList = new AkasiHakouKanriRelateEntity();
        relateEntityList.setAkasihakoumode(processParameter.getAkasihakoumod());
        if (証発行モード_001.equals(processParameter.getAkasihakoumod())) {
            relateEntityList.setChouhouTitle(被保険者証発行);
        } else if (証発行モード_002.equals(processParameter.getAkasihakoumod())) {
            relateEntityList.setChouhouTitle(資格者証発行);
        }
        // TODO QA #73393 出力順ID実装方式 回復待ち  2016/01/20まで
        relateEntityList.setSortJun(processParameter.getSyuturyokujunid());
        relateEntityList.setKayiPeji(processParameter.getSyuturyokujunid());
        relateEntityList.setShichosonCode(new LasdecCode(association.get地方公共団体コード().getColumnValue()));
        relateEntityList.setShichosonMeisho(association.get市町村名());
        relateEntityList.setKoumukumeyifukaflg(processParameter.isKoumukumeyifukaflg());
        relateEntityList.setRenbanfukaflg(processParameter.isRenbanfukaflg());
        relateEntityList.setHizikehensyuuflg(processParameter.isHizikehensyuuflg());
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        mybatisParameter = HihokenshashoHakkoKanriboMybatisParameter.create_Param(
                processParameter.getAkasihakoumod(),
                processParameter.getKoufukayisihi(),
                processParameter.getKoufusiuryouhi(),
                processParameter.getKasyuukayisihi(),
                processParameter.getKasyuusiuryouhi(),
                processParameter.getKofuJiyulist(),
                processParameter.getKaishuJiyulist(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        List<AkasiHakouKanriEntity> akaEntityList = mapper.get証発行管理リスト情報(mybatisParameter);
        List<AkasiHakouKanriEntity> akaEntityList1 = new ArrayList<>();
        AkasiHakouKanriEntity akasiEntity = new AkasiHakouKanriEntity();
        int akaEntityListSize = akaEntityList.size();
        if (発行管理リスト.equals(processParameter.getSiyuturiyokudaysyou()) && processParameter.isSeyisinjyohoflg()) {
            akaEntityListSize = 1;
        }
        for (int i = 0; i < akaEntityListSize; i++) {
            akasiEntity.setRenban(i);
            akasiEntity.setHihokenshaNo(akaEntityList.get(i).getHihokenshaNo());
            akasiEntity.setShikibetsuCode(akaEntityList.get(i).getShikibetsuCode());
            akasiEntity.setShichosonCode(akaEntityList.get(i).getShichosonCode());
            akasiEntity.setKofuYMD(akaEntityList.get(i).getKofuYMD());
            akasiEntity.setKofuJiyu(akaEntityList.get(i).getKofuJiyu());
            akasiEntity.setKaishuYMD(akaEntityList.get(i).getKaishuYMD());
            akasiEntity.setKaishuJiyu(akaEntityList.get(i).getKaishuJiyu());
            akasiEntity.setYukoKigenYMD(akaEntityList.get(i).getYukoKigenYMD());
            akasiEntity.setShoYoshikiKubunCode(akaEntityList.get(i).getShoYoshikiKubunCode());
            akasiEntity.setYubinNo(akaEntityList.get(i).getYubinNo());
            akasiEntity.setMeisho(akaEntityList.get(i).getMeisho());
            akasiEntity.setJusho(akaEntityList.get(i).getJusho());
            akaEntityList1.add(akasiEntity);
        }
        relateEntityList.setAkasiHakouKanriEntityList(akaEntityList1);
    }

    @Override
    protected void process() {
        // TODO QA499 証発行管理リスト帳票用データリストを確認　　QA待ち　2016/01/20まで。
        HihohenshashoHakkoKanriboChohyoDataSakusei chohyoDataSakusei = new HihohenshashoHakkoKanriboChohyoDataSakusei();
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataSakuseiEntityList
                = chohyoDataSakusei.getShohakkoKanriChohyoDataList(relateEntityList);
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        this.eucFilePath = Path.combinePath(spoolWorkPath, new RString("被保険者証発行管理簿CSV.csv"));
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(this.eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(relateEntityList.isKoumukumeyifukaflg()).
                build();
        HihohenshashoHakoKanriboCsvDataSakusei checkListCsv = new HihohenshashoHakoKanriboCsvDataSakusei();
        List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> eucCsvEntityList;
        if (processParameter.isRenbanfukaflg()) {
            eucCsvEntityList = checkListCsv.getShohakkoKanriCSVDataListAddRenban(
                    chohyoDataSakuseiEntityList,
                    processParameter.isKoumukumeyifukaflg(),
                    processParameter.isHizikehensyuuflg());
        } else {
            eucCsvEntityList = checkListCsv.getShohakkoKanriCSVDataList(chohyoDataSakuseiEntityList,
                    processParameter.isKoumukumeyifukaflg(),
                    processParameter.isHizikehensyuuflg());
        }
        for (HihohenshashoHakoKanriboCsvDataSakuseiEntity csvEntity : eucCsvEntityList) {
            eucCsvWriter.writeLine(csvEntity);
        }
        // TODO QA458 被保険者証発行管理簿帳票フォームあります。　帳票は3/25纳品　

    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
    }
}
