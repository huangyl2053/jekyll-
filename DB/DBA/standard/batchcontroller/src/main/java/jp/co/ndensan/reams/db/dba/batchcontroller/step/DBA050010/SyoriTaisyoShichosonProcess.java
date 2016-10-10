/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA050010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.syoritaisyoshichoson.SyoriTaisyoShichoson;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba050010.JuminkirokuIdojohoTorokuKoikiProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.euc.juminidorendoshikakutoroku.FuseigoListCsvEntity;
import jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakutoroku.JuminIdoRendoShikakuToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.idoruiseki.ShikibetsuTaishoIdoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 住民異動連携情報登録【広域保険者用】のProcessのクラス。
 *
 * @reamsid_L DBA-1390-010 wanghuafeng
 */
public class SyoriTaisyoShichosonProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate."
            + "syoritaisyoshichoson.ISyoriTaisyoShichosonMapper.get宛名連動介護保険更新");
    private static final RString 異動後 = new RString("2");
    private static final RString FILENAME = new RString("fuseigoList.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBA050010");
    private JuminkirokuIdojohoTorokuKoikiProcessParameter processParameter;
    private final List<DbT7022ShoriDateKanriEntity> dbT7022List = new ArrayList();
    private final List<RString> shichosonCodeList = new ArrayList();
    private FileSpoolManager manager;
    private RString filePath;
    @BatchWriter
    private CsvWriter<FuseigoListCsvEntity> csvWriter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;

    @Override
    protected void initialize() {
        KoikiShichosonJohoFinder 全市町村情報取得 = KoikiShichosonJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
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
            }
            processParameter.setShichosonCode(市町村コード);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toJuminkirokuIdojohoTorokuKoikiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        filePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
        csvWriter = new CsvWriter.InstanceBuilder(filePath).build();
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity item) {
        dbT7022List.add(item);
        shichosonCodeList.add(item.getShichosonCode().value());
        宛名識別対象異動分取得PSM(item);
    }

    private void 宛名識別対象異動分取得PSM(DbT7022ShoriDateKanriEntity entity) {
        SyoriTaisyoShichoson syoritaisyoshichoson = new SyoriTaisyoShichoson();
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = syoritaisyoshichoson.宛名識別対象異動分取得PSM(entity);
        ShikibetsuTaishoIdoFinder finder = ShikibetsuTaishoIdoFinder.createInstance();
        List<ShikibetsuTaishoIdoJoho> 宛名累積マスタデータリスト = finder.get宛名識別対象異動(keyBuilder.build());
        JuminIdoRendoShikakuToroku juminidorendoshikakutoroku = new JuminIdoRendoShikakuToroku();
        for (ShikibetsuTaishoIdoJoho 宛名識別対象 : 宛名累積マスタデータリスト) {
            if (異動後.equals(宛名識別対象.get異動前後区分())) {
                juminidorendoshikakutoroku.juminIdoRendoKyotsu(to住民異動情報(宛名識別対象), csvWriter);
            }
        }
    }

    @Override
    protected void afterExecute() {
        int a = 0;
        SyoriTaisyoShichoson syoritaisyoshichoson = new SyoriTaisyoShichoson();
        for (int i = 0; i < processParameter.getShichosonCode().size(); i++) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setShichosonCode(new LasdecCode(processParameter.getShichosonCode().get(i).toString()));
            processParameter.setSyorinichiji(YMDHMS.now());
            if (shichosonCodeList.contains(processParameter.getShichosonCode().get(i))) {
                syoritaisyoshichoson.データ更新(processParameter, a, dbT7022List, entity);
                tableWrite.update(entity);
            } else {
                syoritaisyoshichoson.データ登録(processParameter, entity);
                tableWrite.insert(entity);
            }
        }
    }

    private UaFt200FindShikibetsuTaishoEntity to住民異動情報(ShikibetsuTaishoIdoJoho 宛名識別対象) {
        UaFt200FindShikibetsuTaishoEntity 住民異動情報 = new UaFt200FindShikibetsuTaishoEntity();
        住民異動情報.setShikibetsuCode(宛名識別対象.get識別コード());
        住民異動情報.setGenLasdecCode(宛名識別対象.get現地方公共団体コード());
        住民異動情報.setKyuLasdecCode(宛名識別対象.get旧地方公共団体コード());
        住民異動情報.setKyuLasdecCodeRenban(宛名識別対象.get旧地方公共団体コード連番());
        住民異動情報.setGyomuCode(宛名識別対象.get業務コード());
        住民異動情報.setRirekiNo(宛名識別対象.get履歴番号());
        住民異動情報.setCurrentFlag(宛名識別対象.is最新());
        住民異動情報.setJuminShubetsuCode(宛名識別対象.get住民種別コード());
        住民異動情報.setKojinNo(宛名識別対象.get個人番号());
        住民異動情報.setShoriYMD(宛名識別対象.get処理年月日());
        住民異動情報.setIdoJiyuCode(宛名識別対象.get届出事由コード());
        住民異動情報.setIdoYMD(宛名識別対象.get異動年月日());
        住民異動情報.setTodokedeJiyuCode(宛名識別対象.get届出事由コード());
        住民異動情報.setTodokedeYMD(宛名識別対象.get届出年月日());
        住民異動情報.setIdoRiyuCode(宛名識別対象.get異動理由コード().value());
        住民異動情報.setKannaiKangaiKubun(宛名識別対象.get管内管外区分());
        住民異動情報.setYubinNo(宛名識別対象.get郵便番号());
        住民異動情報.setChoikiCode(宛名識別対象.get町域コード());
        住民異動情報.setZenkokuJushoCode(宛名識別対象.get全国住所コード());
        住民異動情報.setJusho(宛名識別対象.get住所());
        住民異動情報.setBanchiCode1(宛名識別対象.get番地コード１());
        住民異動情報.setBanchiCode2(宛名識別対象.get番地コード２());
        住民異動情報.setBanchiCode3(宛名識別対象.get番地コード３());
        住民異動情報.setBanchiCode4(宛名識別対象.get番地コード４());
        住民異動情報.setBanchi(宛名識別対象.get番地());
        住民異動情報.setKatagaki(宛名識別対象.get方書());
        住民異動情報.setKatagakiInjiFlag(宛名識別対象.is方書印字());
        住民異動情報.setGyoseikuCode(宛名識別対象.get行政区コード());
        住民異動情報.setGyoseikuName(宛名識別対象.get行政区());
        住民異動情報.setChikuCode1(宛名識別対象.get地区の分類コード１());
        住民異動情報.setChikuCode2(宛名識別対象.get地区の分類コード２());
        住民異動情報.setChikuCode3(宛名識別対象.get地区の分類コード３());
        住民異動情報.setChikuName1(宛名識別対象.get地区の分類１());
        住民異動情報.setChikuName2(宛名識別対象.get地区の分類２());
        住民異動情報.setChikuName3(宛名識別対象.get地区の分類３());
        住民異動情報.setShogakkokuCode(宛名識別対象.get小学校区コード());
        住民異動情報.setShogakkokuName(宛名識別対象.get小学校区());
        住民異動情報.setChugakkokuCode(宛名識別対象.get中学校区コード());
        住民異動情報.setChugakkokuName(宛名識別対象.get中学校区());
        住民異動情報.setTohyokuCode(宛名識別対象.get投票区コード());
        住民異動情報.setTohyokuName(宛名識別対象.get投票区());
        住民異動情報.setJuminJotaiCode(宛名識別対象.get住民状態コード());
        住民異動情報.setSetaiCode(宛名識別対象.get世帯コード());
        住民異動情報.setSeinengappiYMD(宛名識別対象.get生年月日());
        住民異動情報.setSeinengappiFushoKubun(宛名識別対象.get生年月日不詳区分());
        住民異動情報.setSeibetsuCode(宛名識別対象.get性別コード());
        住民異動情報.setTsuzukigaraCode(宛名識別対象.get続柄コード());
        住民異動情報.setTsuzukigara(宛名識別対象.get続柄());
        住民異動情報.setKazokuNo(宛名識別対象.get家族番号());
        住民異動情報.setJuminhyoHyojijun(宛名識別対象.get住民票表示順());
        住民異動情報.setKikaYMD(宛名識別対象.get帰化年月日());
        住民異動情報.setKanjiShimei(宛名識別対象.get漢字氏名());
        住民異動情報.setKanaShimei(宛名識別対象.getカナ氏名());
        住民異動情報.setJuminhyoCode(宛名識別対象.get住民票コード());
        住民異動情報.setHonsekiZenkokuJushoCode(宛名識別対象.get本籍全国住所コード());
        住民異動情報.setHonsekiJusho(宛名識別対象.get本籍住所());
        住民異動情報.setHonsekiBanchi(宛名識別対象.get本籍番地());
        住民異動情報.setHittosha(宛名識別対象.get筆頭者());
        住民異動情報.setGaikokujinShimei(宛名識別対象.get外国人氏名());
        住民異動情報.setGaikokujinHeikimei(宛名識別対象.get外国人併記名());
        住民異動情報.setGaikokujinKanaShimei(宛名識別対象.get外国人カナ氏名());
        住民異動情報.setTsushomei(宛名識別対象.get通称名());
        住民異動情報.setShimeiRiyoKubun(宛名識別対象.get氏名利用区分());
        住民異動情報.setKanaTsushomei(宛名識別対象.getカナ通称名());
        住民異動情報.setKatakanaHyoki(宛名識別対象.getカタカナ表記());
        住民異動情報.setKokusekiChiikiCode(宛名識別対象.get国籍地域コード().value());
        住民異動情報.setZairyuShikakuCode(宛名識別対象.get在留資格コード().value());
        住民異動情報.setZairyuKikanCode(宛名識別対象.get在留期間コード());
        住民異動情報.setZairyuKikantoManryoYMD(宛名識別対象.get在留期間等満了年月日());
        住民異動情報.setZairyuCardtoNo(宛名識別対象.get在留カード等番号());
        住民異動情報.setZairyuCardtoYukoYMD(宛名識別対象.get在留カード等有効年月日());
        住民異動情報.setDai30Jono45niKiteisuruKubun(宛名識別対象.get第30条の45に規定する区分());
        住民異動情報.setSetainushiShikibetsuCode(宛名識別対象.get世帯主識別コード());
        住民異動情報.setSetainushiMei(宛名識別対象.get世帯主名());
        住民異動情報.setKojinHojinKBN(宛名識別対象.get個人法人区分());
        住民異動情報.setTorokuJiyuCode(宛名識別対象.get登録事由コード());
        住民異動情報.setTorokuIdoYMD(宛名識別対象.get登録異動年月日());
        住民異動情報.setTorokuTodokedeYMD(宛名識別対象.get登録届出年月日());
        住民異動情報.setJuteiJiyuCode(宛名識別対象.get住定事由コード());
        住民異動情報.setJuteiTodokedeYMD(宛名識別対象.get住定届出年月日());
        住民異動情報.setShojoJiyuCode(宛名識別対象.get消除事由コード());
        住民異動情報.setShojoIdoYMD(宛名識別対象.get消除異動年月日());
        住民異動情報.setShojoTodokedeYMD(宛名識別対象.get消除届出年月日());
        住民異動情報.setAimaiShojobiMongon(宛名識別対象.getあいまい消除日文言());
        住民異動情報.setTennyumaeYubinNo(宛名識別対象.get転入前郵便番号());
        住民異動情報.setTennyumaeZenkokuJushoCode(宛名識別対象.get転入前全国住所コード());
        住民異動情報.setTennyumaeJusho(宛名識別対象.get転入前住所());
        住民異動情報.setTennyumaeBanchi(宛名識別対象.get転入前番地());
        住民異動情報.setTennyumaeKatagaki(宛名識別対象.get転入前方書());
        住民異動情報.setTennyumaeSetainushimei(宛名識別対象.get転入前世帯主名());
        住民異動情報.setTennyumaeKyusei(new AtenaMeisho(宛名識別対象.get転入前旧姓()));
        住民異動情報.setJuteiTodokedeYMD(宛名識別対象.get住定届出年月日());
        住民異動情報.setShojoJiyuCode(宛名識別対象.get消除事由コード());
        住民異動情報.setShojoIdoYMD(宛名識別対象.get消除異動年月日());
        住民異動情報.setShojoTodokedeYMD(宛名識別対象.get消除届出年月日());
        住民異動情報.setAimaiShojobiMongon(宛名識別対象.getあいまい消除日文言());
        住民異動情報.setTennyumaeYubinNo(宛名識別対象.get転入前郵便番号());
        住民異動情報.setTennyumaeZenkokuJushoCode(宛名識別対象.get転入前全国住所コード());
        住民異動情報.setTennyumaeJusho(宛名識別対象.get転入前住所());
        住民異動情報.setTennyumaeBanchi(宛名識別対象.get転入前番地());
        住民異動情報.setSaishuJutochiYubinNo(宛名識別対象.get最終住登地郵便番号());
        住民異動情報.setSaishuJutochiZenkokuJushoCode(宛名識別対象.get最終住登地全国住所コード());
        住民異動情報.setSaishuJutochiJusho(宛名識別対象.get最終住登地住所());
        住民異動情報.setSaishuJutochiBanchi(宛名識別対象.get最終住登地番地());
        住民異動情報.setSaishuJutochiKatagaki(宛名識別対象.get最終住登地方書());
        住民異動情報.setSaishuJutochiSetainushimei(宛名識別対象.get最終住登地世帯主名());
        住民異動情報.setTenshutsuYoteiIdoYMD(宛名識別対象.get転出予定異動年月日());
        住民異動情報.setTenshutsuYoteiYubinNo(宛名識別対象.get最終住登地郵便番号());
        住民異動情報.setTenshutsuYoteiZenkokuJushoCode(宛名識別対象.get転出予定全国住所コード());
        住民異動情報.setTenshutsuYoteiJusho(宛名識別対象.get転出予定住所());
        住民異動情報.setTenshutsuYoteiBanchi(宛名識別対象.get転出予定番地());
        住民異動情報.setTenshutsuYoteiKatagaki(宛名識別対象.get転出予定方書());
        住民異動情報.setTenshutsuYoteiSetainushimei(宛名識別対象.get転出予定世帯主名());
        住民異動情報.setTenshutsuKakuteiIdoYMD(宛名識別対象.get転出確定異動年月日());
        住民異動情報.setTenshutsuKakuteiTsuchiYMD(宛名識別対象.get転出確定通知年月日());
        住民異動情報.setTenshutsuKakuteiYubinNo(宛名識別対象.get転出確定郵便番号());
        住民異動情報.setTenshutsuKakuteiZenkokuJushoCode(宛名識別対象.get転出確定全国住所コード());
        住民異動情報.setTenshutsuKakuteiJusho(宛名識別対象.get転出確定住所());
        住民異動情報.setTenshutsuKakuteiBanchi(宛名識別対象.get転出確定番地());
        住民異動情報.setTenshutsuKakuteiKatagaki(宛名識別対象.get転出確定方書());
        住民異動情報.setTenshutsuKakuteiSetainushimei(宛名識別対象.get転出確定世帯主名());
        住民異動情報.setJuminhyoUtsushiHakkoSeigyoKubun(宛名識別対象.has住民票写し発行制御());
        住民異動情報.setRenrakusaki1(宛名識別対象.get連絡先１());
        住民異動情報.setRenrakusaki2(宛名識別対象.get連絡先２());
        住民異動情報.setRenrakusaki3(宛名識別対象.get連絡先３());
        住民異動情報.setKensakuRenrakusaki1(宛名識別対象.get検索連絡先１());
        住民異動情報.setKensakuRenrakusaki2(宛名識別対象.get検索連絡先２());
        住民異動情報.setKensakuRenrakusaki3(宛名識別対象.get検索連絡先３());
        住民異動情報.setRenrakusakiKubun1(宛名識別対象.get連絡先区分１().value());
        住民異動情報.setRenrakusakiKubun2(宛名識別対象.get連絡先区分２().value());
        住民異動情報.setRenrakusakiKubun3(宛名識別対象.get連絡先区分３().value());
        住民異動情報.setMailAddress(宛名識別対象.getメールアドレス());
        住民異動情報.setBiko(宛名識別対象.get備考());
//        TODO QA1810再提出ので、実装しない
//        住民異動情報.setKanaName(宛名識別対象.getカナ名());
//        住民異動情報.setGaikokujinKanaName(宛名識別対象.get外国人カナ名());
//        住民異動情報.setKanaTsushoName(宛名識別対象.getカナ通称名のみ());
        return 住民異動情報;
    }
}
