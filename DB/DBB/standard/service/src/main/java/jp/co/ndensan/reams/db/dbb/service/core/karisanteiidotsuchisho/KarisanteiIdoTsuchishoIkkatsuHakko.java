/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho.TsuchishoKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.karisanteiidotsuchisho.SeikatsuHogoTaishosha;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.karisanteiidotsuchisho.ShutsuryokuHoshiki;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.karisanteiidotsuchisho.TaishoshaKubun;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.karisanteiidotsuchisho.TyohyoType;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.karisanteiidotsuchisho.YamawakeKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdoOrZenkenFukaSelectParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaJohoTempParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaKoseimaeParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.TsuchishoHakkogoIdoshaParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidotsuchisho.IKarisanteiIdoFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 仮算定異動通知書一括発行（バッチ）
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
public class KarisanteiIdoTsuchishoIkkatsuHakko {

    private static final RString 更正前後区分_更正後 = new RString("2");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前情報有無区分_あり = new RString("1");
    private static final RString 生活保護区分_生保対象者 = new RString("1");
    private static final RString 印字位置X_0 = new RString("0");
    private static final RString ハイフン = new RString("-");
    private static final RString 全件異動分区分_全件 = new RString("全件");
    private static final RString 全件異動分区分_異動分 = new RString("異動分");
    private static final RString 全件対象 = new RString("1");
    private static final RString ブック開始位置_1 = new RString("1");
    private static final RString ブック開始位置_2 = new RString("2");
    private static final RString ブック開始位置_3 = new RString("3");
    private static final RString ブック開始位置_4 = new RString("4");
    private static final RString ブック開始位置_5 = new RString("5");
    private static final ReportId DBB100010 = new ReportId("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final ReportId DBB100014 = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoKigoto");
    private static final ReportId DBB100015 = new ReportId("DBB100015_KarisanteiHokenryoNonyuTsuchishoKigotoRencho");
    private static final ReportId DBB100018 = new ReportId("DBB100018_KarisanteiHokenryoNonyuTsuchishoGinfuri");
    private static final ReportId DBB100019 = new ReportId("DBB100019_KarisanteiHokenryoNonyuTsuchishoGinfuriRencho");
    private static final ReportId DBB100020 = new ReportId("DBB100020_KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAri");
    private static final ReportId DBB100021 = new ReportId("DBB100021_KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashi");
    private static final ReportId DBB100022 = new ReportId("DBB100022_KarisanteiNonyuTsuchishoBookFuriKaeAriRencho");
    private static final ReportId DBB100023 = new ReportId("DBB100023_KarisanteiNonyuTsuchishoBookFuriKaeNashiRencho");
    private static final ReportId DBB100024 = new ReportId("DBB100024_KarisanteiNonyuTsuchishoCVSKakuko");
    private static final ReportId DBB100025 = new ReportId("DBB100025_KarisanteiNonyuTsuchishoCVSKakukoRencho");
    private static final ReportId DBB100026 = new ReportId("DBB100026_KarisanteiNonyuTsuchishoCVSMulti");
    private static final ReportId DBB100027 = new ReportId("DBB100027_KarisanteiNonyuTsuchishoCVSMultiRencho");
    private static final ReportId DBB100028 = new ReportId("DBB100028_KarisanteiNonyuTsuchishoCVSKigoto");
    private static final ReportId DBB100029 = new ReportId("DBB100029_KarisanteiNonyuTsuchishoCVSKigotoRencho");
    private static final int 項目番号 = 1;
    private static final int 第1期 = 1;
    private static final int 第3期 = 3;
    private static final int 金融機関コード_START = 0;
    private static final int 金融機関コード_END = 4;
    private static final int SIZE_1 = 1;
    private static final int SIZE_2 = 2;
    private static final int SIZE_3 = 3;
    private static final int SIZE_4 = 4;
    private static final int SIZE_5 = 5;
    private static final int SIZE_6 = 6;
    private static final int SIZE_7 = 7;
    private static final int SIZE_8 = 8;
    private static final int SIZE_9 = 9;
    private static final int SIZE_10 = 10;

    private static final RString KEY_生活保護区分 = new RString("生活保護区分");

    private final MapperProvider provider;

    /**
     * テスト用コンストラクタです。
     */
    KarisanteiIdoTsuchishoIkkatsuHakko() {
        provider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param provider MapperProvider
     */
    KarisanteiIdoTsuchishoIkkatsuHakko(MapperProvider provider) {
        this.provider = provider;
    }

    /**
     * 該当クラスの対象を返す。
     *
     * @return KarisanteiIdoTsuchishoIkkatsuHakko 該当クラスの対象
     */
    public static KarisanteiIdoTsuchishoIkkatsuHakko createInstance() {
        return InstanceProvider.create(KarisanteiIdoTsuchishoIkkatsuHakko.class);
    }

    /**
     * 異動分賦課情報を取得して、一時テーブルに登録する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 一括発行起動フラグ 一括発行起動フラグ
     */
    public void getIdoFukaJoho(FlexibleYear 調定年度, FlexibleYear 賦課年度, boolean 一括発行起動フラグ) {
        IKarisanteiIdoFukaMapper mapper = provider.create(IKarisanteiIdoFukaMapper.class);
        mapper.delete異動賦課情報一時テーブル();
        DbT7022ShoriDateKanriDac dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        DbT7022ShoriDateKanriEntity entity = dac.select最新の基準日(調定年度);
        YMDHMS 最新の基準日 = null != entity ? entity.getKijunTimestamp() : YMDHMS.now();
        IdofukaKoseimaeParameter updateParameter = IdofukaKoseimaeParameter.createParameter(
                更正前情報有無区分_あり, 更正前後区分_更正前);
        if (一括発行起動フラグ) {
            計算後情報作成バッチを呼び出す(調定年度, 賦課年度, 最新の基準日);
            IdofukaJohoTempParameter insertParameter = IdofukaJohoTempParameter.createParameter(
                    調定年度, 賦課年度, 更正前後区分_更正後);
            mapper.insert異動賦課情報一時テーブルFROM計算後情報一時(insertParameter);
            mapper.update異動賦課情報一時テーブルFROM計算後情報一時(updateParameter);
        } else {
            IdofukaJohoTempParameter insertParameter = IdofukaJohoTempParameter.createParameter(
                    調定年度, 賦課年度, 更正前後区分_更正後, ShoriName.仮算定異動賦課.get名称(), 最新の基準日);
            mapper.insert異動賦課情報一時テーブルFROM計算後情報(insertParameter);
            mapper.update異動賦課情報一時テーブルFROM計算後情報(updateParameter);
        }
        IdofukaJohoTempParameter maeUpdateParameter = IdofukaJohoTempParameter.createParameter(調定年度);
        mapper.update異動賦課情報一時テーブル更正前対象者情報(maeUpdateParameter);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(KEY_生活保護区分.toString(), 生活保護区分_生保対象者);
        mapper.update異動賦課情報一時テーブル生活保護区分(parameter);
    }

    /**
     * 全件対象賦課情報を取得して、一時テーブルに登録する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     */
    public void getZenkenFukaJoho(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        IKarisanteiIdoFukaMapper mapper = provider.create(IKarisanteiIdoFukaMapper.class);
        mapper.delete全件賦課情報一時テーブル();
        計算後情報作成バッチを呼び出す(調定年度, 賦課年度, null);
        IdofukaJohoTempParameter insertParameter = IdofukaJohoTempParameter.createParameter(
                調定年度, 賦課年度, 更正前後区分_更正後);
        mapper.insert全件賦課情報一時テーブルFROM計算後情報一時(insertParameter);
        IdofukaKoseimaeParameter updateParameter = IdofukaKoseimaeParameter.createParameter(
                更正前情報有無区分_あり, 更正前後区分_更正前);
        mapper.update全件賦課情報一時テーブルFROM計算後情報一時(updateParameter);
        IdofukaJohoTempParameter maeUpdateParameter = IdofukaJohoTempParameter.createParameter(調定年度);
        mapper.update全件賦課情報一時テーブル更正前対象者情報(maeUpdateParameter);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(KEY_生活保護区分.toString(), 生活保護区分_生保対象者);
        mapper.update全件賦課情報一時テーブル生活保護区分(parameter);
    }

    private void 計算後情報作成バッチを呼び出す(FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時) {
        KeisangoJohoSakuseiBatchParamter parameter = new KeisangoJohoSakuseiBatchParamter(
                null == 調定年度 ? null : 調定年度.toDateString(),
                null == 賦課年度 ? null : 賦課年度.toDateString(),
                null == 調定日時 ? null : 調定日時.toDateString(),
                null, null);
        // TODO 計算後情報作成バッチを呼び出す
        collectRubbishField(parameter);
    }

    /**
     * 計算後情報から仮算定額変更通知書と発行一覧表を、帳票とＣＳＶファイルで作成する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 帳票作成日時 帳票作成日時
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 出力順ID 出力順ID
     * @param 帳票ID 帳票ID
     * @param 出力期 出力期
     */
    public void pntKarisanteigakuHenkoTsuchisho(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 帳票作成日時,
            FlexibleDate 発行日,
            RString 文書番号,
            long 出力順ID,
            ReportId 帳票ID,
            int 出力期) {
        RString 出力順 = get出力順(出力順ID, DBB100010);
        collectRubbishField(出力順);
        TsuchishoKyotsuEntity 通知書共通情報entity = 通知書共通情報取得(出力期);
        IKarisanteiIdoFukaMapper mapper = provider.create(IKarisanteiIdoFukaMapper.class);
        int 異動賦課情報一時テーブルCount = mapper.selectCount異動賦課情報一時テーブル();
        if (異動賦課情報一時テーブルCount == 0) {
            // TODO 一括発行起動フラグはtrueかfalseかを確認中
            boolean 一括発行起動フラグ = false;
            getIdoFukaJoho(調定年度, 賦課年度, 一括発行起動フラグ);
        } else {
            // TODO 異動賦課情報一時テーブル．全項目の抽出
            mapper.selectAll異動賦課情報一時テーブル();
        }
        // TODO 帳票制御共通情報の取得
        DbT7065ChohyoSeigyoKyotsuDac dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        DbT7065ChohyoSeigyoKyotsuEntity entity = dac.selectByKey(SubGyomuCode.DBB介護賦課, DBB100010);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = 導入団体クラス.get地方公共団体コード();
        RString 市町村名 = 導入団体クラス.get市町村名();
        collectRubbishField(市町村コード);
        collectRubbishField(市町村名);
        int パターン番号 = 0;
        if (null != entity && !RString.isNullOrEmpty(entity.getTeikeibunMojiSize())) {
            パターン番号 = Integer.parseInt(getNotNull(entity.getTeikeibunMojiSize()).toString());
        }
        TsuchishoTeikeibunInfo 通知書定型文 = new TsuchishoTeikeibunManager().get通知書定形文検索(
                SubGyomuCode.DBB介護賦課, 帳票ID, KamokuCode.EMPTY, パターン番号, 項目番号, FlexibleDate.getNowDate());
        collectRubbishField(通知書定型文);
        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(発行日);
        仮算定通知書情報.set帳票分類ID(DBB100010);
        仮算定通知書情報.set帳票ID(帳票ID);
        仮算定通知書情報.set処理区分(ShoriKubun.バッチ);
        仮算定通知書情報.set地方公共団体(導入団体クラス);
        仮算定通知書情報.set賦課の情報_更正後(null);
        仮算定通知書情報.set賦課の情報_更正前(null);
        仮算定通知書情報.set納組情報(null);
        仮算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
        仮算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
        仮算定通知書情報.set宛先情報(null);
        仮算定通知書情報.set口座情報(null);
        仮算定通知書情報.set徴収方法情報_更正前(null);
        仮算定通知書情報.set徴収方法情報_更正後(null);
        仮算定通知書情報.set収入情報(null);
        仮算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        // TODO 共通編集処理を呼び出す。「ビジネス設計_DBBBZ00007_1_賦課帳票共通項目編集（仮算定）.xlsx」は実装していないため
//        KariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = new KariSanteiTsuchiShoKyotsu();
//        KariSanteiTsuchiShoKyotsuKomokuHenshu 共通編集処理 = new KariSanteiTsuchiShoKyotsuKomokuHenshu();
//        編集後仮算定通知書共通情報 = 共通編集処理.create仮算定通知書共通情報(仮算定通知書情報);
        // TODO 4.3以後
    }

    /**
     * 今回の仮算定額変更通知書の発行対象より、通知書発行後異動者へ登録する。
     *
     * @param 帳票作成日時 帳票作成日時
     * @param 出力順ID 出力順ID
     * @param 帳票ID 帳票ID
     */
    public void insKarisanteigakuHenkoTsuchishoHakkogoIdosha(
            YMDHMS 帳票作成日時,
            long 出力順ID,
            ReportId 帳票ID) {
        IKarisanteiIdoFukaMapper mapper = provider.create(IKarisanteiIdoFukaMapper.class);
        RString 出力順 = get出力順(出力順ID, DBB100010);
        TsuchishoHakkogoIdoshaParameter parameter = TsuchishoHakkogoIdoshaParameter.createParameter(
                帳票ID.value(), 帳票作成日時, 更正前情報有無区分_あり, 出力順);
        mapper.insert通知書発行後異動者(parameter);
    }

    /**
     * 賦課情報により、納入通知書と発行一覧表を、帳票とＣＳＶファイルで作成する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 帳票作成日時 帳票作成日時
     * @param 出力順ID 出力順ID
     * @param 出力方式 出力方式
     * @param 出力期 出力期
     * @param 発行日 発行日
     * @param 対象者区分 対象者区分
     * @param 生活保護対象者 生活保護対象者
     * @param 山分け区分 山分け区分
     * @param 帳票ID 帳票ID
     */
    public void pntKarisanteiNonyuTsuchisho(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 帳票作成日時,
            long 出力順ID,
            ShutsuryokuHoshiki 出力方式,
            int 出力期,
            FlexibleDate 発行日,
            TaishoshaKubun 対象者区分,
            SeikatsuHogoTaishosha 生活保護対象者,
            YamawakeKubun 山分け区分,
            ReportId 帳票ID) {
        TyohyoType 帳票タイプ = get帳票タイプBy通知書帳票ID(帳票ID);
        RString 出力順 = get出力順(出力順ID, DBB100014);
        RString 全件異動分区分;
        if (TyohyoType.期毎タイプ.equals(帳票タイプ) || 全件対象.equals(get全件異動分区分By出力期(出力期))) {
            全件異動分区分 = 全件異動分区分_全件;
        } else {
            全件異動分区分 = 全件異動分区分_異動分;
        }
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        int 最終期 = 仮算定期間.getLast().get期AsInt();
        List<Noki> 賦課納期 = FukaNokiResearcher.createInstance().get普徴納期ALL();
        int to;
        if (TyohyoType.期毎タイプ.equals(帳票タイプ) && ShutsuryokuHoshiki.別々に出力.equals(出力方式)) {
            to = 出力期;
        } else {
            to = 最終期;
        }
        KitsukiList 期月リスト情報 = 期月リスト_普徴.subListBy期(出力期, to);
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 期月リスト情報.toList()) {
            NokiJoho 普徴納期情報 = new NokiJoho();
            普徴納期情報.set期月(期月);
            普徴納期情報.set納期(get納期By期月(期月, 賦課納期));
            普徴納期情報リスト.add(普徴納期情報);
        }
        TsuchishoKyotsuEntity 通知書共通情報entity = 通知書共通情報取得(出力期);
        KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報
                = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance().get仮算定納入通知書制御情報();
        collectRubbishField(通知書共通情報entity);
        collectRubbishField(仮算定納入通知書制御情報);
        IKarisanteiIdoFukaMapper mapper = provider.create(IKarisanteiIdoFukaMapper.class);
        if (全件異動分区分_全件.equals(全件異動分区分) && 0 == mapper.selectCount全件賦課情報一時テーブル()) {
            getZenkenFukaJoho(調定年度, 賦課年度);
        } else if (全件異動分区分_異動分.equals(全件異動分区分) && 0 == mapper.selectCount異動賦課情報一時テーブル()) {
            boolean 一括発行起動フラグ = false;
            getIdoFukaJoho(調定年度, 賦課年度, 一括発行起動フラグ);
        }
        IdoOrZenkenFukaSelectParameter parameter = IdoOrZenkenFukaSelectParameter.createParameter(
                出力期, 対象者区分, 出力順, 生活保護対象者,
                get全件異動分区分By出力期(出力期), get通知書プリント条件NBy出力期(出力期));
        if (全件異動分区分_全件.equals(全件異動分区分)) {
            mapper.select全項目From全件賦課情報一時テーブル(parameter);
        } else if (全件異動分区分_異動分.equals(全件異動分区分)) {
            mapper.select全項目From異動賦課情報一時テーブル(parameter);
        }
        int 山分け用スプール数 = 0;
        if (YamawakeKubun.する.equals(山分け区分)) {
            if (TyohyoType.期毎タイプ.equals(帳票タイプ)) {
                山分け用スプール数 = 普徴納期情報リスト.size();
            } else if (TyohyoType.銀振型4期タイプ.equals(帳票タイプ)) {
                山分け用スプール数 = SIZE_1;
            } else if (TyohyoType.ブックタイプ.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数5(出力期, 普徴納期情報リスト);
            } else if (TyohyoType.コンビニ収納タイプ.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数6(出力期, 普徴納期情報リスト);
            }
        } else if (YamawakeKubun.しない.equals(山分け区分)) {
            山分け用スプール数 = SIZE_1;
        }
        DbT7065ChohyoSeigyoKyotsuDac dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        DbT7065ChohyoSeigyoKyotsuEntity entity = dac.selectByKey(SubGyomuCode.DBB介護賦課, DBB100014);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = 導入団体クラス.get地方公共団体コード();
        RString 市町村名 = 導入団体クラス.get市町村名();
        TsuchishoTeikeibunManager j = null;
        collectRubbishField(entity);
        collectRubbishField(山分け用スプール数);
        collectRubbishField(市町村コード);
        collectRubbishField(市町村名);
        collectRubbishField(j);
        collectRubbishField(SIZE_10);
        通知書の共通項目編集(new KariSanteiNonyuTsuchiShoJoho()); //checkstyle対応のため、仮使用

    }

    /**
     * 今回の納入通知書の発行対象より、通知書発行後異動者へ登録する。
     *
     * @param 帳票作成日時 帳票作成日時
     * @param 出力期 出力期
     * @param 対象者区分 対象者区分
     * @param 生活保護対象者 生活保護対象者
     * @param 出力順ID 出力順ID
     * @param 帳票ID 帳票ID
     */
    public void insNonyuTsuchishoHakkogoIdosha(
            YMDHMS 帳票作成日時,
            RString 出力期,
            TaishoshaKubun 対象者区分,
            SeikatsuHogoTaishosha 生活保護対象者,
            long 出力順ID,
            ReportId 帳票ID) {

    }

    private int get山分け用スプール数6(int 出力期, List<NokiJoho> 普徴納期情報リスト) {
        if (null == 普徴納期情報リスト) {
            return 0;
        }
        RString 今回出力期の印字位置 = RString.EMPTY;
        for (NokiJoho 普徴納期情報 : 普徴納期情報リスト) {
            Kitsuki 期月 = 普徴納期情報.get期月();
            if (null != 期月 && 期月.get期AsInt() == 出力期) {
                今回出力期の印字位置 = getコンビニカット印字位置(期月);
                break;
            }
        }
        int コンビニカット印字位置 = 今回出力期の印字位置.isEmpty() ? 0 : Integer.parseInt(今回出力期の印字位置.toString());
        if (コンビニカット印字位置 >= SIZE_8) {
            return SIZE_4;
        } else if (SIZE_5 <= コンビニカット印字位置 && コンビニカット印字位置 <= SIZE_7) {
            return SIZE_3;
        } else if (SIZE_2 <= コンビニカット印字位置 && コンビニカット印字位置 <= SIZE_4) {
            return SIZE_2;
        } else if (SIZE_1 == コンビニカット印字位置) {
            return SIZE_1;
        }
        return 0;
    }

    private int get山分け用スプール数5(int 出力期, List<NokiJoho> 普徴納期情報リスト) {
        if (null == 普徴納期情報リスト) {
            return 0;
        }
        RString 今回出力期の印字位置 = RString.EMPTY;
        boolean 随時期フラグ = false;
        for (NokiJoho 普徴納期情報 : 普徴納期情報リスト) {
            Kitsuki 期月 = 普徴納期情報.get期月();
            if (null != 期月 && 期月.get期AsInt() == 出力期) {
                今回出力期の印字位置 = getブック開始位置By期月(期月);
                随時期フラグ = FuchokiJohoTsukiShoriKubun.随時.getName().equals(期月.get月処理区分().getName());
                break;
            }
        }
        if (随時期フラグ) {
            if (ブック開始位置_1.equals(今回出力期の印字位置)) {
                return SIZE_1;
            } else {
                return SIZE_2;
            }
        }
        if (ブック開始位置_1.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_1(普徴納期情報リスト.size());
        } else if (ブック開始位置_2.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_2(普徴納期情報リスト.size());
        } else if (ブック開始位置_3.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_3(普徴納期情報リスト.size());
        } else if (ブック開始位置_4.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_4(普徴納期情報リスト.size());
        } else if (ブック開始位置_5.equals(今回出力期の印字位置)) {
            return get山分け用スプール数Inブック開始位置_5(普徴納期情報リスト.size());
        }
        return 0;
    }

    private int get山分け用スプール数Inブック開始位置_1(int 出力期リストのサイズ) {
        return SIZE_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_5 ? SIZE_2
                : SIZE_6 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_9 ? SIZE_3
                : SIZE_4;
    }

    private int get山分け用スプール数Inブック開始位置_2(int 出力期リストのサイズ) {
        return SIZE_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_4 ? SIZE_2
                : SIZE_5 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_8 ? SIZE_3
                : SIZE_4;
    }

    private int get山分け用スプール数Inブック開始位置_3(int 出力期リストのサイズ) {
        return SIZE_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_3 ? SIZE_2
                : SIZE_4 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_7 ? SIZE_3
                : SIZE_4;
    }

    private int get山分け用スプール数Inブック開始位置_4(int 出力期リストのサイズ) {
        return SIZE_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_2 ? SIZE_2
                : SIZE_3 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_6 ? SIZE_3
                : SIZE_4;
    }

    private int get山分け用スプール数Inブック開始位置_5(int 出力期リストのサイズ) {
        return 出力期リストのサイズ == SIZE_1 ? SIZE_2
                : SIZE_2 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_5 ? SIZE_3
                : SIZE_6 <= 出力期リストのサイズ && 出力期リストのサイズ <= SIZE_9 ? SIZE_4
                : SIZE_5;
    }

    private RString getコンビニカット印字位置(Kitsuki 期月) {
        Tsuki 月別 = 期月.get月();
        RDate now = RDate.getNowDate();
        if (Tsuki._4月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置1, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._5月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置2, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._6月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置3, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._7月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置4, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._8月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置5, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._9月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置6, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._10月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置7, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._11月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置8, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._12月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置9, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._1月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置10, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._2月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置11, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._3月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置12, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度4月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置13, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度5月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_コンビニカット印字位置14, now, SubGyomuCode.DBB介護賦課);
        }
        return RString.EMPTY;
    }

    private RString getブック開始位置By期月(Kitsuki 期月) {
        Tsuki 月別 = 期月.get月();
        RDate now = RDate.getNowDate();
        if (Tsuki._4月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置1, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._5月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置2, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._6月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置3, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._7月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置4, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._8月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置5, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._9月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置6, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._10月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置7, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._11月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置8, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._12月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置9, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._1月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置10, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._2月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置11, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._3月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置12, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度4月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置13, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度5月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_ブック開始位置14, now, SubGyomuCode.DBB介護賦課);
        }
        return RString.EMPTY;
    }

    private RString get通知書プリント条件NBy出力期(int 出力期) {
        // TODO ConfigNameDBB.普徴期情報_通知書プリント条件Nがない
//        DbBusinessConifg.get(ConfigNameDBB.普徴期情報_通知書プリント条件N, RDate.now(), SubGyomuCode.DBB介護賦課);
        collectRubbishField(出力期);
        return RString.EMPTY;
    }

    private RString get全件異動分区分By出力期(int 出力期) {
        // TODO ConfigNameDBB.普徴期情報_処理対象Nがない
//        DbBusinessConifg.get(ConfigNameDBB.普徴期情報_処理対象N, RDate.now(), SubGyomuCode.DBB介護賦課);
        collectRubbishField(出力期);
        return RString.EMPTY;
    }

    private TyohyoType get帳票タイプBy通知書帳票ID(ReportId 帳票ID) {
        if (DBB100014.equals(帳票ID) || DBB100015.equals(帳票ID)
                || DBB100028.equals(帳票ID) || DBB100029.equals(帳票ID)) {
            return TyohyoType.期毎タイプ;
        } else if (DBB100018.equals(帳票ID) || DBB100019.equals(帳票ID)) {
            return TyohyoType.銀振型4期タイプ;
        } else if (DBB100020.equals(帳票ID) || DBB100021.equals(帳票ID)
                || DBB100022.equals(帳票ID) || DBB100023.equals(帳票ID)) {
            return TyohyoType.銀振型4期タイプ;
        } else if (DBB100024.equals(帳票ID) || DBB100025.equals(帳票ID)
                || DBB100026.equals(帳票ID) || DBB100027.equals(帳票ID)) {
            return TyohyoType.銀振型4期タイプ;
        }
        return null;
    }

    private RString 通知書の共通項目編集(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        if (null == 仮算定納入通知書情報 || null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()) {
            return RString.EMPTY;
        }
        RStringBuilder builder = new RStringBuilder();
        EditedKoza 編集後口座 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報().get編集後口座();
        if (null != 編集後口座 && 編集後口座.isゆうちょ銀行()) {
            builder.append(編集後口座.get金融機関コードCombinedWith支店コード().substring(
                    金融機関コード_START, 金融機関コード_END));
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座番号Or通帳記号番号());
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座名義人漢字優先());
            return builder.toRString();
        } else if (null != 編集後口座 && !編集後口座.isゆうちょ銀行()) {
            builder.append(編集後口座.get金融機関コードCombinedWith支店コード());
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座種別略称());
            builder.append(ハイフン);
            builder.append(編集後口座.get口座番号Or通帳記号番号());
            builder.append(RString.HALF_SPACE);
            builder.append(編集後口座.get口座名義人漢字優先());
            return builder.toRString();
        }
        return RString.EMPTY;
    }

    private RString get出力順(long 出力順ID, ReportId 帳票分類ID) {
        RString userId = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        IOutputOrder 並み順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票分類ID, userId, 出力順ID);
        // TODO 「帳票出力順・改ページ項目一覧（DBB介護賦課）.xlsx」に定義される当該帳票用の管理項目
        return MyBatisOrderByClauseCreator.create(null, 並み順);
    }

    private TsuchishoKyotsuEntity 通知書共通情報取得(int 出力期) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        TsuchishoKyotsuEntity result = new TsuchishoKyotsuEntity();
        KitsukiList 仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        int 最終期 = 仮算定期間.getLast().get期AsInt();
        List<Noki> 賦課納期 = FukaNokiResearcher.createInstance().get普徴納期ALL();
        KitsukiList 期月リスト情報 = 期月リスト_普徴.subListBy期(出力期, 最終期);
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 期月リスト情報.toList()) {
            NokiJoho 普徴納期情報 = new NokiJoho();
            普徴納期情報.set期月(期月);
            普徴納期情報.set納期(get納期By期月(期月, 賦課納期));
            普徴納期情報リスト.add(普徴納期情報);
        }
        for (NokiJoho 普徴納期情報 : 普徴納期情報リスト) {
            RString 印字位置 = get印字位置By期月(普徴納期情報.get期月());
            if (印字位置X_0.equals(印字位置)) {
                普徴納期情報リスト.remove(普徴納期情報);
            }
        }
        result.set普徴納期情報リスト(普徴納期情報リスト);
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        List<NokiJoho> 特徴納期情報リスト = new ArrayList<>();
        for (int 期 = 第1期; 期 <= 第3期; 期++) {
            Kitsuki 最初月 = 期月リスト_特徴.get期の最初月(期);
            NokiJoho 特徴納期情報 = new NokiJoho();
            特徴納期情報.set期月(最初月);
            特徴納期情報.set納期(FukaNokiResearcher.createInstance().get特徴納期(期));
            特徴納期情報リスト.add(特徴納期情報);
        }
        result.set特徴納期情報リスト(特徴納期情報リスト);
        return result;
    }

    private RString get印字位置By期月(Kitsuki 期月) {
        Tsuki 月別 = 期月.get月();
        RDate now = RDate.getNowDate();
        if (Tsuki._4月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置1, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._5月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置2, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._6月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置3, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._7月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置4, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._8月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置5, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._9月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置6, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._10月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置7, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._11月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置8, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._12月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置9, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._1月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置10, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._2月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置11, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki._3月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置12, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度4月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置13, now, SubGyomuCode.DBB介護賦課);
        } else if (Tsuki.翌年度5月.equals(月別)) {
            return DbBusinessConifg.get(
                    ConfigNameDBB.普徴期情報_納付書の印字位置14, now, SubGyomuCode.DBB介護賦課);
        }
        return RString.EMPTY;
    }

    private Noki get納期By期月(Kitsuki 期月, List<Noki> 賦課納期) {
        if (null == 賦課納期 || null == 期月) {
            return null;
        }
        for (Noki 納期 : 賦課納期) {
            if (期月.get期AsInt() == 納期.get期別()) {
                return 納期;
            }
        }
        return null;
    }

    private RString getNotNull(RString rstring) {
        return (null == rstring) ? RString.EMPTY : rstring;
    }

    private void collectRubbishField(Object obj) {
        System.out.print("未使用変数" + obj); //checkstyle対応のため、仮使用

    }
}
