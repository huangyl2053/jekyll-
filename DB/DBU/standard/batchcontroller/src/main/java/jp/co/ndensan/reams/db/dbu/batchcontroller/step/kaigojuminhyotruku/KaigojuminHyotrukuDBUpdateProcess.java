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
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.service.core.idoruiseki.ShikibetsuTaishoIdoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
public class KaigojuminHyotrukuDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojuminhyotruku.IKaigojuminHyotrukuMapper"
            + ".get宛名連動介護保険更新");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 導入形態コード_122 = new RString("120");
    private static final RString 導入形態コード_111 = new RString("111");
    private KaigojuminHyotrukuProcessParameter processParameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;
    private RDateTime 処理日時;
    private List<ShikibetsuTaishoIdoJoho> idoJohos;
    private List<DbT7022ShoriDateKanriEntity> dbT7022List;
    private List<RString> shichosonCodeList;

    @Override
    protected void beforeExecute() {
        処理日時 = RDateTime.now();
        idoJohos = new ArrayList<>();
        dbT7022List = new ArrayList<>();
        shichosonCodeList = new ArrayList<>();
    }

    @Override
    protected void initialize() {
        KoikiShichosonJohoFinder 全市町村情報取得 = KoikiShichosonJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報.get導入形態コード() == null || 市町村セキュリティ情報.get介護導入区分().isEmpty()) {
            afterExecute();
        } else if (導入形態コード_120.equals(市町村セキュリティ情報.get導入形態コード().value())
                || 導入形態コード_122.equals(市町村セキュリティ情報.get導入形態コード().value())) {
            List<KoikiZenShichosonJoho> 広域用情報リスト = 全市町村情報取得.getGenShichosonJoho().records();
            List<RString> shichosonCode = new ArrayList<>();
            for (int i = 0; i < 広域用情報リスト.size(); i++) {
//                if (!shichosonCode.contains(広域用情報リスト.get(i).get市町村コード().value())) {
                shichosonCode.add(広域用情報リスト.get(i).get市町村コード().value());
//                }
            }
            processParameter.setShichosonCode(shichosonCode);
        } else if (導入形態コード_111.equals(市町村セキュリティ情報.get導入形態コード().value())) {
            List<ShichosonCodeYoriShichoson> 単一用情報リスト = 全市町村情報取得.shichosonCodeYoriShichosonJoho(市町村セキュリティ情報.get市町村情報()
                    .get市町村コード()).records();
            List<RString> 市町村コード = new ArrayList<>();
            for (int i = 0; i < 単一用情報リスト.size(); i++) {
                市町村コード.add(単一用情報リスト.get(i).get市町村コード().value());
                processParameter.setShichosonCode(市町村コード);
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaigojuminHyotrukuMapperParameter());
    }

    @Override
    protected void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity item) {
        dbT7022List.add(item);
        shichosonCodeList.add(item.getShichosonCode().value());
        宛名識別対象異動分取得PSM(item);
    }

    private List<ShikibetsuTaishoIdoJoho> 宛名識別対象異動分取得PSM(DbT7022ShoriDateKanriEntity entity) {
        KaigojuminHyotrukuProcess process = new KaigojuminHyotrukuProcess();
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = process.宛名識別対象異動分取得PSM(entity);
        ShikibetsuTaishoIdoFinder finder = ShikibetsuTaishoIdoFinder.createInstance();
        idoJohos = finder.get宛名識別対象異動(keyBuilder.build());
        if (idoJohos == null || idoJohos.isEmpty()) {
            return idoJohos;
        }
        return idoJohos;
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
        for (int i = 0; i < processParameter.getShichosonCode().size(); i++) {

            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            processParameter.setShoriTimestamp(YMDHMS.now().getRDateTime());
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShichosonCode(new LasdecCode(processParameter.getShichosonCode().get(i).toString()));
            if (shichosonCodeList.contains(processParameter.getShichosonCode().get(i))) {
                entity.setShoriEdaban(new RString(String.valueOf(Integer.valueOf(dbT7022List.get(a).getShoriEdaban().toString()) + 1)));
                entity.setNendoNaiRenban(new RString(String.valueOf(Integer.valueOf(dbT7022List.get(a).getNendoNaiRenban().toString()) + 1)));
                a++;
            } else {
                entity.setShoriEdaban(new RString("1"));
                entity.setNendoNaiRenban(new RString("1"));
            }
            entity.setShoriName(ShoriName.住民異動連携情報登録_他社住基用.get名称());
            entity.setNendo(new FlexibleYear("0000"));
            entity.setKijunYMD(new FlexibleDate(processParameter.getShoriTimestamp().getDate().toString()));
            entity.setKijunTimestamp(new YMDHMS(処理日時));
            entity.setTaishoKaishiYMD(new FlexibleDate(processParameter.getShoriTimestamp().getDate().toString()));
            entity.setTaishoShuryoYMD(new FlexibleDate(処理日時.getDate().toString()));
            entity.setTaishoKaishiTimestamp(new YMDHMS(processParameter.getShoriTimestamp()));
            対象開始日時(entity);
            tableWrite.insert(entity);
        }
    }

    private void 対象開始日時(DbT7022ShoriDateKanriEntity entity) {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(処理日時.getDate());
        日時.append(処理日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setTaishoShuryoTimestamp(new YMDHMS(日時.toString().replace(":", "")));
    }
}
