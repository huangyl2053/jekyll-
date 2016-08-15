/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.idochecklist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.idochecklist.IdoCheckListBatch;
import jp.co.ndensan.reams.db.dba.business.report.idochecklist.IdoCheckListReport;
import jp.co.ndensan.reams.db.dba.definition.core.idochecklist.IdochecklistTitle;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.idochecklist.IdoCheckListGetDataParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.idochecklist.IdoCheckListGetDataProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoCheckListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoInfoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.idochecklist.IdoCheckListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist.IIdoCheckListMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 異動チェックリスト帳票データ作成のプロセスクラス
 *
 * @reamsid_L DBA-0530-020 chengsanyuan
 */
public class IdoCheckListReportProcess extends BatchProcessBase<RString> {

    private List<IdoInfoEntity> list;
    private IIdoCheckListMapper mapper;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist.IIdoCheckListMapper."
            + "getListForProcess");
    private IdoCheckListEntity idoCheckListEntity;
    private static final Code FUJOSHURUI_CODE_SEIKATU = new Code(new RString("01"));
    private static final Code FUJOSHURUI_CODE_KYOUIKU = new Code(new RString("02"));
    private static final Code FUJOSHURUI_CODE_JUUTAKU = new Code(new RString("03"));
    private static final Code FUJOSHURUI_CODE_IRYOU = new Code(new RString("04"));
    private static final Code FUJOSHURUI_CODE_KAIGO = new Code(new RString("05"));
    private static final Code FUJOSHURUI_CODE_SHUSSAN = new Code(new RString("06"));
    private static final Code FUJOSHURUI_CODE_NARIWAI = new Code(new RString("07"));
    private static final Code FUJOSHURUI_CODE_SOUSAI = new Code(new RString("08"));
    private static final Code FUJOSHURUI_CODE_ZANRYUU_HOUZIN = new Code(new RString("A1"));
    private static final RString IDO_DATA_TEKIYOU_IDO = new RString("適用異動");
    private static final RString IDO_DATA_NYUUSHO_IDO = new RString("入所異動");
    private static final RString IDO_DATA_TAISHO_IDO = new RString("退所異動");
    private static final RString IDO_DATA_KAIJO_IDO = new RString("解除異動");
    private static final RString IDO_DATA_TEKIYOU_SAKUJYO = new RString("適用削除");
    private static final RString IDO_DATA_KAIJO_KAIJO = new RString("解除解除");
    private static final RString IDO_DATA_KAISHI_IDO = new RString("開始異動");
    private static final RString IDO_DATA_HAISHI_IDO = new RString("廃止異動");
    private static final int TITLE_JOHO_3 = 3;
    private static final int TITLE_JOHO_4 = 4;
    private static final int TITLE_JOHO_5 = 5;
    private IdoCheckListGetDataProcessParameter param;

    @BatchWriter
    private BatchReportWriter<IdoCheckListReportSource> batchWrite;
    private ReportSourceWriter<IdoCheckListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        list = new ArrayList<>();
        mapper = getMapper(IIdoCheckListMapper.class);
        idoCheckListEntity = new IdoCheckListEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200006.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void afterExecute() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();

        Association association = finder.getAssociation();
        idoCheckListEntity.set市町村コード(association.get地方公共団体コード());
        idoCheckListEntity.set市町村名(association.get市町村名());
        // TODO QA#73393未回答により(並び順と改頁を設定しない)

        getHihokenshaDaichouList();
        getJushochiTokureiList();
        getTekiyoJogaishaDaichouList();
        getSeikatsuHogoList();
        getRoreiFukushiNenkinList();
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        SetaiCode 世帯コード = SetaiCode.EMPTY;
        AtenaMeisho 被保険者氏名 = AtenaMeisho.EMPTY;
        AtenaKanaMeisho 被保険者カナ氏名 = AtenaKanaMeisho.EMPTY;

        for (IdoInfoEntity entity : list) {

            if (entity.get識別コード() != null && 識別コード.compareTo(entity.get識別コード()) == 0) {
                entity.set世帯コード(世帯コード);
                entity.set被保険者カナ氏名(被保険者カナ氏名);
                entity.set被保険者氏名(被保険者氏名);
                識別コード = entity.get識別コード();
                continue;
            }
            if (entity.get識別コード() != null && !entity.get識別コード().isEmpty()) {
                ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                        ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
                key.setデータ取得区分(DataShutokuKubun.直近レコード);
                key.set識別コード(entity.get識別コード());
                List<JuminShubetsu> 住民種別List = new ArrayList<>();
                住民種別List.add(JuminShubetsu.日本人);
                住民種別List.add(JuminShubetsu.外国人);
                住民種別List.add(JuminShubetsu.住登外個人_日本人);
                住民種別List.add(JuminShubetsu.住登外個人_外国人);
                key.set住民種別(住民種別List);
                List<JuminJotai> 住民状態List = new ArrayList<>();
                住民状態List.add(JuminJotai.住民);
                住民状態List.add(JuminJotai.住登外);
                住民状態List.add(JuminJotai.消除者);
                住民状態List.add(JuminJotai.転出者);
                住民状態List.add(JuminJotai.死亡者);
                key.set住民状態(住民状態List);
                UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
                UaFt200FindShikibetsuTaishoEntity ft200Entity = mapper.getShikibetsuTaishoPsm(
                        IdoCheckListGetDataParameter.createShikibetsuTaishoPsmParameter(
                                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()))
                );
                if (ft200Entity != null) {
                    IKojin 識別対象 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
                    entity.set世帯コード(識別対象.get世帯コード());
                    entity.set被保険者カナ氏名(識別対象.get名称().getKana());
                    entity.set被保険者氏名(識別対象.get名称().getName());
                    世帯コード = 識別対象.get世帯コード();
                    被保険者カナ氏名 = 識別対象.get名称().getKana();
                    被保険者氏名 = 識別対象.get名称().getName();
                } else {
                    entity.set世帯コード(SetaiCode.EMPTY);
                    entity.set被保険者カナ氏名(AtenaKanaMeisho.EMPTY);
                    entity.set被保険者氏名(AtenaMeisho.EMPTY);
                }

                識別コード = entity.get識別コード();
            }
        }
        idoCheckListEntity.setIdoInfoList(list);
        IdoCheckListBatch idoCheckbatch = new IdoCheckListBatch();
        IdoCheckListReport report = IdoCheckListReport.createFrom(idoCheckbatch.getIdoCheckChohyoData(idoCheckListEntity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void process(RString item) {
    }

    private static class DateComparator implements Comparator<ShisetsuNyutaishoEntity>, Serializable {

        @Override
        public int compare(ShisetsuNyutaishoEntity o1, ShisetsuNyutaishoEntity o2) {
            return o1.get更新日時().compareTo(o2.get更新日時());
        }
    }

    private void getHihokenshaDaichouList() {
        if (param.isHihokenshaDaichouFlag()) {
            List<IdoInfoEntity> hihokenshaDaichouList = mapper.getHihokenshaDaichouList(
                    param.toIdoCheckListGetDataParameter());
            if (hihokenshaDaichouList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set識別コード(ShikibetsuCode.EMPTY);
                idoInfoEntity.set対象情報(1);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_被保険者.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_取得.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_喪失.get名称());
                idoInfoEntity.set区分タイトル(IdochecklistTitle.区分タイトル_資格.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                list.add(idoInfoEntity);
            } else {
                list.addAll(hihokenshaDaichouList);
            }
        }
    }

    private void getJushochiTokureiList() {
        if (param.isJushochiTokureiKanriFlag()) {
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode08List = mapper.getJushochiTokureiListByCode08(
                    param.toIdoCheckListGetDataParameter());
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode11List = mapper.getJushochiTokureiListByCode11(
                    param.toIdoCheckListGetDataParameter());
            // TODO QA512 Redmine：#74264(「他市町村住所地特例者の異動を伴わずの場合」の取得方式が知らない、一時固定値を使用します)
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoList = new ArrayList<>();
            if (shisetsuNyutaishoCode08List.isEmpty() && shisetsuNyutaishoCode11List.isEmpty()) {
                shisetsuNyutaishoList = mapper.getShisetsuNyutaishoList(
                        IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
                                param.getKonkaiKaishi(), param.getKonkaiShuryo(), DaichoType.他市町村住所地特例者.getコード(),
                                ShikibetsuCode.EMPTY,
                                GyomuCode.EMPTY,
                                FlexibleDate.EMPTY));
            }
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode08List);
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode11List);
            Collections.sort(shisetsuNyutaishoList, new DateComparator());

            for (ShisetsuNyutaishoEntity entity : shisetsuNyutaishoList) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(2);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_他市町村.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_適用.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_解除.get名称());
                idoInfoEntity.set異動情報タイトル1(IdochecklistTitle.異動情報タイトル1_施設.get名称());
                idoInfoEntity.set開始年月日タイトル(IdochecklistTitle.開始年月日タイトル_入所.get名称());
                idoInfoEntity.set終了年月日タイトル(IdochecklistTitle.終了年月日タイトル_退所.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                idoInfoEntity.set異動情報データ1(entity.get入所施設コード().value());
                idoInfoEntity.set識別コード(entity.get識別コード());
                setJushochiTokurei(idoInfoEntity, entity);
                list.add(idoInfoEntity);
            }
            if (shisetsuNyutaishoList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(2);
                idoInfoEntity.set識別コード(ShikibetsuCode.EMPTY);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_他市町村.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_適用.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_解除.get名称());
                idoInfoEntity.set異動情報タイトル1(IdochecklistTitle.異動情報タイトル1_施設.get名称());
                idoInfoEntity.set開始年月日タイトル(IdochecklistTitle.開始年月日タイトル_入所.get名称());
                idoInfoEntity.set終了年月日タイトル(IdochecklistTitle.終了年月日タイトル_退所.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                list.add(idoInfoEntity);
            }
        }
    }

    private void setJushochiTokurei(IdoInfoEntity idoInfoEntity, ShisetsuNyutaishoEntity entity) {
        RString コード略称 = RString.EMPTY;
        if (!entity.is論理削除フラグ()) {
            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_他特例者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set取得情報_後_事由(コード略称);
                idoInfoEntity.set取得情報_後_異動年月日(entity.get適用年月日());
                idoInfoEntity.set取得情報_後_届出年月日(entity.get適用届出年月日());
                idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_TEKIYOU_IDO);
            }

            if (RString.isNullOrEmpty(entity.get異動事由コード())
                    && (entity.get入所年月日() != null && !entity.get入所年月日().isEmpty())
                    && (entity.get退所年月日() == null || entity.get退所年月日().isEmpty())) {
                idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_NYUUSHO_IDO);
            }

            if (RString.isNullOrEmpty(entity.get異動事由コード())
                    && (entity.get入所年月日() != null && !entity.get入所年月日().isEmpty())
                    && (entity.get退所年月日() != null && !entity.get退所年月日().isEmpty())) {
                idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_TAISHO_IDO);
            }

            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_他特例者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set喪失情報_後_事由(コード略称);
                idoInfoEntity.set喪失情報_後_異動年月日(entity.get解除年月日());
                idoInfoEntity.set喪失情報_後_届出年月日(entity.get解除届出年月日());
                idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_KAIJO_IDO);
            }
        } else {
            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_他特例者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set取得情報_前_事由(コード略称);
                idoInfoEntity.set取得情報_前_異動年月日(entity.get適用年月日());
                idoInfoEntity.set取得情報_前_届出年月日(entity.get適用届出年月日());
                idoInfoEntity.set開始年月日データ_前(entity.get入所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_TEKIYOU_SAKUJYO);
            }
            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_他特例者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set喪失情報_前_事由(コード略称);
                idoInfoEntity.set喪失情報_前_異動年月日(entity.get解除年月日());
                idoInfoEntity.set喪失情報_前_届出年月日(entity.get解除届出年月日());
                idoInfoEntity.set終了年月日データ_前(entity.get退所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_KAIJO_KAIJO);
            }

        }
    }

    private RString getCodeNameByCode(CodeShubetsu codeShubetsu, RString code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBA介護資格,
                codeShubetsu,
                new Code(code),
                FlexibleDate.getNowDate());
    }

    private void getTekiyoJogaishaDaichouList() {
        if (param.isTekiyoJogaishaDaichouFlag()) {
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode09List = mapper.getJushochiTokureiListByCode08(
                    param.toIdoCheckListGetDataParameter());
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode12List = mapper.getJushochiTokureiListByCode11(
                    param.toIdoCheckListGetDataParameter());
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoList = new ArrayList<>();
            if (shisetsuNyutaishoCode09List.isEmpty() && shisetsuNyutaishoCode12List.isEmpty()) {
                shisetsuNyutaishoList = mapper.getShisetsuNyutaishoList(
                        IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
                                param.getKonkaiKaishi(), param.getKonkaiShuryo(), DaichoType.適用除外者.getコード(),
                                ShikibetsuCode.EMPTY,
                                GyomuCode.EMPTY,
                                FlexibleDate.EMPTY));
            }
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode09List);
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode12List);
            Collections.sort(shisetsuNyutaishoList, new DateComparator());

            for (ShisetsuNyutaishoEntity entity : shisetsuNyutaishoList) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(TITLE_JOHO_3);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_適用除外者.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_適用.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_解除.get名称());
                idoInfoEntity.set異動情報タイトル1(IdochecklistTitle.異動情報タイトル1_施設.get名称());
                idoInfoEntity.set開始年月日タイトル(IdochecklistTitle.開始年月日タイトル_入所.get名称());
                idoInfoEntity.set終了年月日タイトル(IdochecklistTitle.終了年月日タイトル_退所.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                idoInfoEntity.set異動情報データ1(entity.get入所施設コード().value());
                idoInfoEntity.set識別コード(entity.get識別コード());
                setTekiyoJogaishaDaichou(idoInfoEntity, entity);
                list.add(idoInfoEntity);
            }
            if (shisetsuNyutaishoList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(TITLE_JOHO_3);
                idoInfoEntity.set識別コード(ShikibetsuCode.EMPTY);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_適用除外者.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_適用.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_解除.get名称());
                idoInfoEntity.set異動情報タイトル1(IdochecklistTitle.異動情報タイトル1_施設.get名称());
                idoInfoEntity.set開始年月日タイトル(IdochecklistTitle.開始年月日タイトル_入所.get名称());
                idoInfoEntity.set終了年月日タイトル(IdochecklistTitle.終了年月日タイトル_退所.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                list.add(idoInfoEntity);
            }
        }
    }

    private void setTekiyoJogaishaDaichou(IdoInfoEntity idoInfoEntity, ShisetsuNyutaishoEntity entity) {
        RString コード略称 = RString.EMPTY;
        if (!entity.is論理削除フラグ()) {
            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_除外者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set取得情報_後_事由(コード略称);
                idoInfoEntity.set取得情報_後_異動年月日(entity.get適用年月日());
                idoInfoEntity.set取得情報_後_届出年月日(entity.get適用届出年月日());
                idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_TEKIYOU_IDO);
            }

            if (RString.isNullOrEmpty(entity.get異動事由コード())
                    && (entity.get入所年月日() != null && !entity.get入所年月日().isEmpty())
                    && (entity.get退所年月日() == null || entity.get退所年月日().isEmpty())) {
                idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_NYUUSHO_IDO);
            }

            if (RString.isNullOrEmpty(entity.get異動事由コード())
                    && (entity.get入所年月日() != null && !entity.get入所年月日().isEmpty())
                    && (entity.get退所年月日() != null && !entity.get退所年月日().isEmpty())) {
                idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_TAISHO_IDO);
            }

            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_除外者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set喪失情報_後_事由(コード略称);
                idoInfoEntity.set喪失情報_後_異動年月日(entity.get解除年月日());
                idoInfoEntity.set喪失情報_後_届出年月日(entity.get解除届出年月日());
                idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_KAIJO_IDO);
            }
        } else {
            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_除外者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set取得情報_前_事由(コード略称);
                idoInfoEntity.set取得情報_前_異動年月日(entity.get適用年月日());
                idoInfoEntity.set取得情報_前_届出年月日(entity.get適用届出年月日());
                idoInfoEntity.set開始年月日データ_前(entity.get入所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_TEKIYOU_SAKUJYO);
            }
            コード略称 = getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_除外者.getコード(), entity.get異動事由コード());
            if (!RString.isNullOrEmpty(コード略称)) {
                idoInfoEntity.set喪失情報_前_事由(コード略称);
                idoInfoEntity.set喪失情報_前_異動年月日(entity.get解除年月日());
                idoInfoEntity.set喪失情報_前_届出年月日(entity.get解除届出年月日());
                idoInfoEntity.set終了年月日データ_前(entity.get退所年月日());
                idoInfoEntity.set異動情報データ4(IDO_DATA_KAIJO_KAIJO);
            }

        }
    }

    private void getSeikatsuHogoList() {
        if (param.isSeikatsuHogoFlag()) {
            List<UrT0508SeikatsuHogoJukyushaEntity> seikatsuHogoList = mapper.getSeikatsuHogoList(param.toIdoCheckListGetDataParameter());
            for (UrT0508SeikatsuHogoJukyushaEntity entity : seikatsuHogoList) {
                List<RString> fujoShuruiCodeList = mapper.getFujoShuruiCodeList(IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
                        null, null, null,
                        entity.getShikibetsuCode(), entity.getGyomuCode(), entity.getJukyuKaishiYMD()));
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(TITLE_JOHO_4);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_生活保護.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_開始.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_廃止.get名称());
                idoInfoEntity.set異動情報タイトル1(IdochecklistTitle.異動情報タイトル1_扶助.get名称());
                idoInfoEntity.set開始年月日タイトル(IdochecklistTitle.開始年月日タイトル_開始.get名称());
                idoInfoEntity.set終了年月日タイトル(IdochecklistTitle.終了年月日タイトル_廃止.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                if (entity.getJukyuKaishiYMD() != null && entity.getJukyuHaishiYMD() == null) {
                    idoInfoEntity.set開始年月日データ_後(entity.getJukyuKaishiYMD());
                    idoInfoEntity.set異動情報データ4(IDO_DATA_KAISHI_IDO);
                }
                if (entity.getJukyuKaishiYMD() != null && entity.getJukyuHaishiYMD() != null) {
                    idoInfoEntity.set終了年月日データ_後(entity.getJukyuHaishiYMD());
                    idoInfoEntity.set異動情報データ4(IDO_DATA_HAISHI_IDO);
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_SEIKATU.value())) {
                    idoInfoEntity.set異動情報データ1(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_SEIKATU).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ1(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_KYOUIKU.value())) {
                    idoInfoEntity.set異動情報データ1(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_KYOUIKU).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ1(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_JUUTAKU.value())) {
                    idoInfoEntity.set異動情報データ2(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_JUUTAKU).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ2(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_IRYOU.value())) {
                    idoInfoEntity.set異動情報データ2(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_IRYOU).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ2(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_KAIGO.value())) {
                    idoInfoEntity.set異動情報データ3(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_KAIGO).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ3(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_SHUSSAN.value())) {
                    idoInfoEntity.set異動情報データ3(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_SHUSSAN).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ3(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_NARIWAI.value())) {
                    idoInfoEntity.set異動情報データ5(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_NARIWAI).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ5(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_SOUSAI.value())) {
                    idoInfoEntity.set異動情報データ5(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_SOUSAI).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ5(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(FUJOSHURUI_CODE_ZANRYUU_HOUZIN.value())) {
                    idoInfoEntity.set異動情報データ6(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                                    FUJOSHURUI_CODE_ZANRYUU_HOUZIN).getコード略称());
                }
                idoInfoEntity.set識別コード(entity.getShikibetsuCode());
                list.add(idoInfoEntity);
            }
            if (seikatsuHogoList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(TITLE_JOHO_4);
                idoInfoEntity.set識別コード(ShikibetsuCode.EMPTY);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_生活保護.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_開始.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_廃止.get名称());
                idoInfoEntity.set異動情報タイトル1(IdochecklistTitle.異動情報タイトル1_扶助.get名称());
                idoInfoEntity.set開始年月日タイトル(IdochecklistTitle.開始年月日タイトル_開始.get名称());
                idoInfoEntity.set終了年月日タイトル(IdochecklistTitle.終了年月日タイトル_廃止.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                list.add(idoInfoEntity);
            }
        }
    }

    private void getRoreiFukushiNenkinList() {
        if (param.isRoreiFukushiNenkinFlag()) {
            List<IdoInfoEntity> roreiFukushiNenkinList = mapper.getRoreiFukushiNenkinList(param.toIdoCheckListGetDataParameter());
            if (roreiFukushiNenkinList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(TITLE_JOHO_5);
                idoInfoEntity.set識別コード(ShikibetsuCode.EMPTY);
                idoInfoEntity.set対象情報タイトル(IdochecklistTitle.対象情報タイトル_老齢福祉.get名称());
                idoInfoEntity.set開始タイトル(IdochecklistTitle.開始タイトル_開始.get名称());
                idoInfoEntity.set終了タイトル(IdochecklistTitle.終了タイトル_終了.get名称());
                idoInfoEntity.set開始年月日タイトル(IdochecklistTitle.開始年月日タイトル_開始.get名称());
                idoInfoEntity.set終了年月日タイトル(IdochecklistTitle.終了年月日タイトル_終了.get名称());
                idoInfoEntity.set異動情報タイトル4(IdochecklistTitle.異動情報タイトル4_異動.get名称());
                list.add(idoInfoEntity);
            } else {
                list.addAll(roreiFukushiNenkinList);
            }
        }
    }
}
