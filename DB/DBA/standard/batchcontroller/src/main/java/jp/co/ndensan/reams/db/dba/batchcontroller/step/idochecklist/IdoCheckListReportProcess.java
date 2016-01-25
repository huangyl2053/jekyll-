/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.idochecklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.idochecklist.IdoCheckListBatch;
import jp.co.ndensan.reams.db.dba.business.report.idochecklist.IdoCheckListReport;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoCheckListEntity;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.idochecklist.IdoCheckListGetDataParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.idochecklist.IdoCheckListGetDataProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoInfoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.idochecklist.IdoCheckListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist.IIdoCheckListMapper;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 異動チェックリスト帳票データ作成のプロセスクラス
 */
public class IdoCheckListReportProcess extends BatchProcessBase<IdoInfoEntity> {

    private List<IdoInfoEntity> list;
    private IIdoCheckListMapper mapper;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist.IIdoCheckListMapper."
            + "getHihokenshaDaichouList");
    private IdoCheckListEntity idoCheckListEntity;
    private static final ReportId REPORT_ID = new ReportId(new RString("DBA200006"));
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
        return new BatchDbReader(MYBATIS_SELECT_ID, param.toIdoCheckListGetDataParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
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
        // TODO 並び順と改頁を作成する

        getHihokenshaDaichouList();
        getJushochiTokureiList();
        getTekiyoJogaishaDaichouList();
        getSeikatsuHogoList();
        getRoreiFukushiNenkinList();
        for (IdoInfoEntity entity : list) {
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
                    IdoCheckListGetDataParameter.createShikibetsuTaishoPsmParameter(uaFt200Psm));
            IKojin 識別対象 = ShikibetsuTaishoFactory.createKojin(ft200Entity);
            entity.set世帯コード(識別対象.get世帯コード());
            entity.set被保険者カナ氏名(識別対象.get名称().getKana());
            entity.set被保険者氏名(識別対象.get名称().getName());
        }
        idoCheckListEntity.setIdoInfoList(list);
        IdoCheckListBatch idoCheckbatch = new IdoCheckListBatch();
        IdoCheckListReport report = IdoCheckListReport.createFrom(idoCheckbatch.getIdoCheckChohyoData(idoCheckListEntity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void process(IdoInfoEntity item) {
    }

    private static class DateComparator implements Comparator<ShisetsuNyutaishoEntity> {

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
                idoInfoEntity.set対象情報(1);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：被保険者台帳"));
                idoInfoEntity.set開始タイトル(new RString("取得情報"));
                idoInfoEntity.set終了タイトル(new RString("喪失情報"));
                idoInfoEntity.set区分タイトル(new RString("資格"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
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
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoList = mapper.getShisetsuNyutaishoList(
                    IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
                            param.getKonkaiKaishi(), param.getKonkaiShuryo(), DaichoType.他市町村住所地特例者.getコード(),
                            ShikibetsuCode.EMPTY,
                            GyomuCode.EMPTY,
                            FlexibleDate.EMPTY));
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode08List);
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode11List);
            Collections.sort(shisetsuNyutaishoList, new DateComparator());

            for (ShisetsuNyutaishoEntity entity : shisetsuNyutaishoList) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
//                idoInfoEntity.set世帯コード(null);
//                idoInfoEntity.set被保険者カナ氏名(null);
//                idoInfoEntity.set被保険者氏名(null);
                idoInfoEntity.set対象情報(2);
//                idoInfoEntity.set改頁１(null);
//                idoInfoEntity.set改頁２(null);
//                idoInfoEntity.set改頁３(null);
//                idoInfoEntity.set改頁４(null);
//                idoInfoEntity.set改頁５(null);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：他市町村住所地特例者台帳"));
                idoInfoEntity.set開始タイトル(new RString("適用情報"));
                idoInfoEntity.set終了タイトル(new RString("解除情報"));
//                idoInfoEntity.set区分タイトル(null);
                idoInfoEntity.set異動情報タイトル1(new RString("施設コード"));
//                idoInfoEntity.set異動情報タイトル2(null);
//                idoInfoEntity.set異動情報タイトル3(null);
                idoInfoEntity.set開始年月日タイトル(new RString("入所年月日"));
                idoInfoEntity.set終了年月日タイトル(new RString("退所年月日"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
//                idoInfoEntity.set異動情報タイトル5(null);
//                idoInfoEntity.set異動情報タイトル6(null);
                idoInfoEntity.set異動情報データ1(entity.get入所施設コード().value());
//                idoInfoEntity.set被保険者番号(null);
                idoInfoEntity.set識別コード(entity.get識別コード());
//                idoInfoEntity.set区分_前_資格(null);
//                idoInfoEntity.set区分_後_資格(null);
//                idoInfoEntity.set異動情報データ2(null);
//                idoInfoEntity.set異動情報データ3(null);
//                idoInfoEntity.set異動情報データ5(null);
//                idoInfoEntity.set異動情報データ6(null);
                if (!entity.is論理削除フラグ()) {
//                    idoInfoEntity.set取得情報_前_事由(null);
//                    idoInfoEntity.set取得情報_前_異動年月日(null);
//                    idoInfoEntity.set取得情報_前_届出年月日(null);
//                    idoInfoEntity.set開始年月日データ_前(null);
//                    idoInfoEntity.set喪失情報_前_事由(null);
//                    idoInfoEntity.set喪失情報_前_異動年月日(null);
//                    idoInfoEntity.set喪失情報_前_届出年月日(null);
//                    idoInfoEntity.set終了年月日データ_前(null);
                    UzT0007CodeEntity codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0008")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
                        idoInfoEntity.set取得情報_後_事由(codeEntity.getコード名称());
                        idoInfoEntity.set取得情報_後_異動年月日(entity.get適用年月日());
                        idoInfoEntity.set取得情報_後_届出年月日(entity.get適用届出年月日());
                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_後_事由(null);
//                        idoInfoEntity.set喪失情報_後_異動年月日(null);
//                        idoInfoEntity.set喪失情報_後_届出年月日(null);
//                        idoInfoEntity.set終了年月日データ_後(null);
                        idoInfoEntity.set異動情報データ4(new RString("適用異動"));
                    }

                    if (entity.get異動事由コード() == null
                            && entity.get入所年月日() != null
                            && entity.get退所年月日() == null) {
//                        idoInfoEntity.set取得情報_後_事由(null);
//                        idoInfoEntity.set取得情報_後_異動年月日(null);
//                        idoInfoEntity.set取得情報_後_届出年月日(null);
                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_後_事由(null);
//                        idoInfoEntity.set喪失情報_後_異動年月日(null);
//                        idoInfoEntity.set喪失情報_後_届出年月日(null);
//                        idoInfoEntity.set終了年月日データ_後(null);
                        idoInfoEntity.set異動情報データ4(new RString("入所異動"));
                    }

                    if (entity.get異動事由コード() == null
                            && entity.get入所年月日() != null
                            && entity.get退所年月日() != null) {
//                        idoInfoEntity.set取得情報_後_事由(null);
//                        idoInfoEntity.set取得情報_後_異動年月日(null);
//                        idoInfoEntity.set取得情報_後_届出年月日(null);
                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_後_事由(null);
//                        idoInfoEntity.set喪失情報_後_異動年月日(null);
//                        idoInfoEntity.set喪失情報_後_届出年月日(null);
                        idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("退所異動"));
                    }

                    codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0011")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
//                        idoInfoEntity.set取得情報_後_事由(null);
//                        idoInfoEntity.set取得情報_後_異動年月日(null);
//                        idoInfoEntity.set取得情報_後_届出年月日(null);
//                        idoInfoEntity.set開始年月日データ_後(null);
                        idoInfoEntity.set喪失情報_後_事由(codeEntity.getコード名称());
                        idoInfoEntity.set喪失情報_後_異動年月日(entity.get解除年月日());
                        idoInfoEntity.set喪失情報_後_届出年月日(entity.get解除届出年月日());
                        idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("解除異動"));
                    }
                } else {
//                    idoInfoEntity.set取得情報_後_事由(null);
//                    idoInfoEntity.set取得情報_後_異動年月日(null);
//                    idoInfoEntity.set取得情報_後_届出年月日(null);
//                    idoInfoEntity.set開始年月日データ_後(null);
//                    idoInfoEntity.set喪失情報_後_事由(null);
//                    idoInfoEntity.set喪失情報_後_異動年月日(null);
//                    idoInfoEntity.set喪失情報_後_届出年月日(null);
//                    idoInfoEntity.set終了年月日データ_後(null);
                    UzT0007CodeEntity codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0008")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
                        idoInfoEntity.set取得情報_前_事由(codeEntity.getコード名称());
                        idoInfoEntity.set取得情報_前_異動年月日(entity.get適用年月日());
                        idoInfoEntity.set取得情報_前_届出年月日(entity.get適用届出年月日());
                        idoInfoEntity.set開始年月日データ_前(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_前_事由(null);
//                        idoInfoEntity.set喪失情報_前_異動年月日(null);
//                        idoInfoEntity.set喪失情報_前_届出年月日(null);
//                        idoInfoEntity.set終了年月日データ_前(null);
                        idoInfoEntity.set異動情報データ4(new RString("適用削除"));
                    }
                    codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0011")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
//                        idoInfoEntity.set取得情報_前_事由(null);
//                        idoInfoEntity.set取得情報_前_異動年月日(null);
//                        idoInfoEntity.set取得情報_前_届出年月日(null);
//                        idoInfoEntity.set開始年月日データ_前(null);
                        idoInfoEntity.set喪失情報_前_事由(codeEntity.getコード名称());
                        idoInfoEntity.set喪失情報_前_異動年月日(entity.get解除年月日());
                        idoInfoEntity.set喪失情報_前_届出年月日(entity.get解除届出年月日());
                        idoInfoEntity.set終了年月日データ_前(entity.get退所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("解除解除"));
                    }

                }
                list.add(idoInfoEntity);
            }
            if (shisetsuNyutaishoList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
//                idoInfoEntity.set世帯コード(null);
//                idoInfoEntity.set被保険者カナ氏名(null);
//                idoInfoEntity.set被保険者氏名(null);
                idoInfoEntity.set対象情報(2);
//                idoInfoEntity.set改頁１(null);
//                idoInfoEntity.set改頁２(null);
//                idoInfoEntity.set改頁３(null);
//                idoInfoEntity.set改頁４(null);
//                idoInfoEntity.set改頁５(null);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：他市町村住所地特例者台帳"));
                idoInfoEntity.set開始タイトル(new RString("適用情報"));
                idoInfoEntity.set終了タイトル(new RString("解除情報"));
//                idoInfoEntity.set区分タイトル(null);
                idoInfoEntity.set異動情報タイトル1(new RString("施設コード"));
//                idoInfoEntity.set異動情報タイトル2(null);
//                idoInfoEntity.set異動情報タイトル3(null);
                idoInfoEntity.set開始年月日タイトル(new RString("入所年月日"));
                idoInfoEntity.set終了年月日タイトル(new RString("退所年月日"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
//                idoInfoEntity.set異動情報タイトル5(null);
//                idoInfoEntity.set異動情報タイトル6(null);
//                idoInfoEntity.set開始年月日データ_前(null);
//                idoInfoEntity.set終了年月日データ_前(null);
//                idoInfoEntity.set開始年月日データ_後(null);
//                idoInfoEntity.set終了年月日データ_後(null);
//                idoInfoEntity.set異動情報データ1(null);
//                idoInfoEntity.set異動情報データ2(null);
//                idoInfoEntity.set異動情報データ3(null);
//                idoInfoEntity.set異動情報データ4(null);
//                idoInfoEntity.set異動情報データ5(null);
//                idoInfoEntity.set異動情報データ6(null);
//                idoInfoEntity.set被保険者番号(null);
//                idoInfoEntity.set識別コード(null);
//                idoInfoEntity.set取得情報_前_事由(null);
//                idoInfoEntity.set取得情報_前_異動年月日(null);
//                idoInfoEntity.set取得情報_前_届出年月日(null);
//                idoInfoEntity.set喪失情報_前_事由(null);
//                idoInfoEntity.set喪失情報_前_異動年月日(null);
//                idoInfoEntity.set喪失情報_前_届出年月日(null);
//                idoInfoEntity.set取得情報_後_事由(null);
//                idoInfoEntity.set取得情報_後_異動年月日(null);
//                idoInfoEntity.set取得情報_後_届出年月日(null);
//                idoInfoEntity.set喪失情報_後_事由(null);
//                idoInfoEntity.set喪失情報_後_異動年月日(null);
//                idoInfoEntity.set喪失情報_後_届出年月日(null);
//                idoInfoEntity.set区分_前_資格(null);
//                idoInfoEntity.set区分_後_資格(null);
                list.add(idoInfoEntity);
            }
        }
    }

    private void getTekiyoJogaishaDaichouList() {
        if (param.isTekiyoJogaishaDaichouFlag()) {
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode09List = mapper.getJushochiTokureiListByCode08(
                    param.toIdoCheckListGetDataParameter());
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode12List = mapper.getJushochiTokureiListByCode11(
                    param.toIdoCheckListGetDataParameter());
            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoList = mapper.getShisetsuNyutaishoList(
                    IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
                            param.getKonkaiKaishi(), param.getKonkaiShuryo(), DaichoType.適用除外者.getコード(),
                            ShikibetsuCode.EMPTY,
                            GyomuCode.EMPTY,
                            FlexibleDate.EMPTY));
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode09List);
            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode12List);
            Collections.sort(shisetsuNyutaishoList, new DateComparator());

            for (ShisetsuNyutaishoEntity entity : shisetsuNyutaishoList) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(3);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：適用除外者台帳"));
                idoInfoEntity.set開始タイトル(new RString("適用情報"));
                idoInfoEntity.set終了タイトル(new RString("解除情報"));
                idoInfoEntity.set異動情報タイトル1(new RString("施設コード"));
                idoInfoEntity.set開始年月日タイトル(new RString("入所年月日"));
                idoInfoEntity.set終了年月日タイトル(new RString("退所年月日"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
                idoInfoEntity.set異動情報データ1(entity.get入所施設コード().value());
                idoInfoEntity.set識別コード(entity.get識別コード());
                if (!entity.is論理削除フラグ()) {
                    UzT0007CodeEntity codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0009")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
                        idoInfoEntity.set取得情報_後_事由(codeEntity.getコード名称());
                        idoInfoEntity.set取得情報_後_異動年月日(entity.get適用年月日());
                        idoInfoEntity.set取得情報_後_届出年月日(entity.get適用届出年月日());
                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("適用異動"));
                    }

                    if (entity.get異動事由コード() == null
                            && entity.get入所年月日() != null
                            && entity.get退所年月日() == null) {
                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("入所異動"));
                    }

                    if (entity.get異動事由コード() == null
                            && entity.get入所年月日() != null
                            && entity.get退所年月日() != null) {
                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
                        idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("退所異動"));
                    }

                    codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0012")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
                        idoInfoEntity.set喪失情報_後_事由(codeEntity.getコード名称());
                        idoInfoEntity.set喪失情報_後_異動年月日(entity.get解除年月日());
                        idoInfoEntity.set喪失情報_後_届出年月日(entity.get解除届出年月日());
                        idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("解除異動"));
                    }
                } else {
                    UzT0007CodeEntity codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0009")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
                        idoInfoEntity.set取得情報_前_事由(codeEntity.getコード名称());
                        idoInfoEntity.set取得情報_前_異動年月日(entity.get適用年月日());
                        idoInfoEntity.set取得情報_前_届出年月日(entity.get適用届出年月日());
                        idoInfoEntity.set開始年月日データ_前(entity.get入所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("適用削除"));
                    }
                    codeEntity = CodeMaster.getCode(
                            SubGyomuCode.DBA介護資格,
                            new CodeShubetsu(new RString("0012")),
                            new Code(entity.get異動事由コード()));
                    if (codeEntity != null) {
                        idoInfoEntity.set喪失情報_前_事由(codeEntity.getコード名称());
                        idoInfoEntity.set喪失情報_前_異動年月日(entity.get解除年月日());
                        idoInfoEntity.set喪失情報_前_届出年月日(entity.get解除届出年月日());
                        idoInfoEntity.set終了年月日データ_前(entity.get退所年月日());
                        idoInfoEntity.set異動情報データ4(new RString("解除解除"));
                    }

                }
                list.add(idoInfoEntity);
            }
            if (shisetsuNyutaishoList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(3);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：適用除外者台帳"));
                idoInfoEntity.set開始タイトル(new RString("適用情報"));
                idoInfoEntity.set終了タイトル(new RString("解除情報"));
                idoInfoEntity.set異動情報タイトル1(new RString("施設コード"));
                idoInfoEntity.set開始年月日タイトル(new RString("入所年月日"));
                idoInfoEntity.set終了年月日タイトル(new RString("退所年月日"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
                list.add(idoInfoEntity);
            }
        }
    }

    private void getSeikatsuHogoList() {
        if (param.isSeikatsuHogoFlag()) {
            List<UrT0508SeikatsuHogoJukyushaEntity> seikatsuHogoList = mapper.getSeikatsuHogoList(param.toIdoCheckListGetDataParameter());
            for (UrT0508SeikatsuHogoJukyushaEntity entity : seikatsuHogoList) {
                List<RString> fujoShuruiCodeList = mapper.getFujoShuruiCodeList(IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
                        RDateTime.MAX, RDateTime.MAX, RString.HALF_SPACE,
                        entity.getShikibetsuCode(), entity.getGyomuCode(), entity.getJukyuKaishiYMD()));
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(4);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：生活保護情報"));
                idoInfoEntity.set開始タイトル(new RString("開始情報"));
                idoInfoEntity.set終了タイトル(new RString("廃止情報"));
                idoInfoEntity.set異動情報タイトル1(new RString("扶助種類"));
                idoInfoEntity.set開始年月日タイトル(new RString("開始年月日"));
                idoInfoEntity.set終了年月日タイトル(new RString("廃止年月日"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
                if (entity.getJukyuKaishiYMD() != null && entity.getJukyuHaishiYMD() == null) {
                    idoInfoEntity.set開始年月日データ_後(entity.getJukyuKaishiYMD());
                    idoInfoEntity.set異動情報データ4(new RString("開始異動"));
                }
                if (entity.getJukyuKaishiYMD() != null && entity.getJukyuHaishiYMD() != null) {
                    idoInfoEntity.set終了年月日データ_後(entity.getJukyuHaishiYMD());
                    idoInfoEntity.set異動情報データ4(new RString("廃止異動"));
                }
                if (fujoShuruiCodeList.contains(new RString("01"))) {
                    idoInfoEntity.set異動情報データ1(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("01")).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ1(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(new RString("02"))) {
                    idoInfoEntity.set異動情報データ1(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("02")).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ1(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(new RString("03"))) {
                    idoInfoEntity.set異動情報データ2(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("03")).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ2(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(new RString("04"))) {
                    idoInfoEntity.set異動情報データ2(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("04")).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ2(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(new RString("05"))) {
                    idoInfoEntity.set異動情報データ3(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("05")).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ3(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(new RString("06"))) {
                    idoInfoEntity.set異動情報データ3(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("06")).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ3(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(new RString("07"))) {
                    idoInfoEntity.set異動情報データ5(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("07")).getコード略称());
                } else {
                    idoInfoEntity.set異動情報データ5(RString.FULL_SPACE.concat(RString.FULL_SPACE));
                }
                if (fujoShuruiCodeList.contains(new RString("08"))) {
                    idoInfoEntity.set異動情報データ5(RString.FULL_SPACE.concat(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("08")).getコード略称()));
                } else {
                    idoInfoEntity.set異動情報データ5(RString.FULL_SPACE.concat(RString.FULL_SPACE.concat(RString.FULL_SPACE)));
                }
                if (fujoShuruiCodeList.contains(new RString("A1"))) {
                    idoInfoEntity.set異動情報データ6(
                            CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu(new RString("0017")), new Code("A1")).getコード略称());
                }
                idoInfoEntity.set識別コード(entity.getShikibetsuCode());
                list.add(idoInfoEntity);
            }
            if (seikatsuHogoList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(4);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：生活保護情報"));
                idoInfoEntity.set開始タイトル(new RString("開始情報"));
                idoInfoEntity.set終了タイトル(new RString("廃止情報"));
                idoInfoEntity.set異動情報タイトル1(new RString("扶助種類"));
                idoInfoEntity.set開始年月日タイトル(new RString("開始年月日"));
                idoInfoEntity.set終了年月日タイトル(new RString("廃止年月日"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
                list.add(idoInfoEntity);
            }
        }
    }

    private void getRoreiFukushiNenkinList() {
        if (param.isRoreiFukushiNenkinFlag()) {
            List<IdoInfoEntity> roreiFukushiNenkinList = mapper.getRoreiFukushiNenkinList(param.toIdoCheckListGetDataParameter());
            if (roreiFukushiNenkinList.isEmpty()) {
                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
                idoInfoEntity.set対象情報(5);
                idoInfoEntity.set対象情報タイトル(new RString("データ種別：老齢福祉年金情報"));
                idoInfoEntity.set開始タイトル(new RString("開始情報"));
                idoInfoEntity.set終了タイトル(new RString("終了情報"));
                idoInfoEntity.set開始年月日タイトル(new RString("開始年月日"));
                idoInfoEntity.set終了年月日タイトル(new RString("終了年月日"));
                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
                list.add(idoInfoEntity);
            } else {
                list.addAll(roreiFukushiNenkinList);
            }
        }
    }
}
