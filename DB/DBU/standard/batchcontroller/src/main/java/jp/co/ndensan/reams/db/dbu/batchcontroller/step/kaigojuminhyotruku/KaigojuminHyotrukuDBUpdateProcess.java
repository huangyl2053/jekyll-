/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.kaigojuminhyotruku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyotruku.KaigojuminHyotrukuProcess;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyotruku.KaigojuminHyotrukuProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.service.core.idoruiseki.ShikibetsuTaishoIdoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
public class KaigojuminHyotrukuDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojuminhyotruku.IKaigojuminHyotrukuMapper"
            + ".get宛名連動介護保険更新");
    private KaigojuminHyotrukuProcessParameter processParameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;
    private RDateTime 処理日時;
    private List<ShikibetsuTaishoIdoJoho> idoJohoslist;
    private List<DbT7022ShoriDateKanriEntity> dbT7022List;
    private List<RString> shichosonCodeList;

    @Override
    protected void beforeExecute() {
        処理日時 = RDateTime.now();
        idoJohoslist = new ArrayList<>();
        dbT7022List = new ArrayList<>();
        shichosonCodeList = new ArrayList<>();
    }

    @Override
    protected void initialize() {
        KoikiShichosonJohoFinder 全市町村情報取得 = KoikiShichosonJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報.get導入形態コード() == null || 市町村セキュリティ情報.get介護導入区分().isEmpty()) {
            afterExecute();
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
            List<KoikiZenShichosonJoho> 広域用情報リスト = 全市町村情報取得.getGenShichosonJoho().records();
            List<RString> shichosonCode = new ArrayList<>();
            for (KoikiZenShichosonJoho 広域情報リスト : 広域用情報リスト) {
                shichosonCode.add(広域情報リスト.get市町村コード().value());
            }
            processParameter.setShichosonCode(shichosonCode);
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
            List<ShichosonCodeYoriShichoson> 単一用情報リスト = 全市町村情報取得.shichosonCodeYoriShichosonJoho(市町村セキュリティ情報.get市町村情報()
                    .get市町村コード()).records();
            List<RString> 市町村コード = new ArrayList<>();
            for (ShichosonCodeYoriShichoson 単一 : 単一用情報リスト) {
                市町村コード.add(単一.get市町村コード().value());
                processParameter.setShichosonCode(市町村コード);
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaigojuminHyotrukuMapperParameter());
    }

    @Override
    protected
            void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class
        );
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity item) {
        dbT7022List.add(item);
        shichosonCodeList.add(item.getShichosonCode().value());
        宛名識別対象異動分取得PSM(item);
    }

    private void 宛名識別対象異動分取得PSM(DbT7022ShoriDateKanriEntity entity) {
        KaigojuminHyotrukuProcess process = new KaigojuminHyotrukuProcess();
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = process.宛名識別対象異動分取得PSM(entity);
        ShikibetsuTaishoIdoFinder finder = ShikibetsuTaishoIdoFinder.createInstance();
        List<ShikibetsuTaishoIdoJoho> 宛名識別対象list = finder.get宛名識別対象異動(keyBuilder.build());
        for (ShikibetsuTaishoIdoJoho 宛名識別対象 : 宛名識別対象list) {
            idoJohoslist.add(宛名識別対象);
        }
    }

    @Override
    protected void afterExecute() {
//TODO 「宛名連動介護保険更新」のシートがあります。QA:1248 実装なし。
//        List<ShikibetsuTaishoIdoJoho> 現地方公共団体コード = new ArrayList<>();
//        for (int i = 0; i < idoJohos.size(); i++) {
//            if (processParameter.getShichosonCode().contains(idoJohos.get(i).get現地方公共団体コード().value())) {
//                現地方公共団体コード.add(idoJohos.get(i));
//            }
//        };
        int a = 0;
        KaigojuminHyotrukuProcess process = new KaigojuminHyotrukuProcess();
        for (int i = 0; i < processParameter.getShichosonCode().size(); i++) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            a = process.データ編集(processParameter, a, i, dbT7022List, shichosonCodeList, 処理日時, entity);
            tableWrite.insert(entity);
        }
    }
}
