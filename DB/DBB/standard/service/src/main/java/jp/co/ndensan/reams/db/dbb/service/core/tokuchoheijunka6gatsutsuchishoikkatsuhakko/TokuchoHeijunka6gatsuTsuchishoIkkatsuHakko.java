/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6gatsutsuchishoikkatsuhakko.DbT2002FukaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbbt35003.ChohyoHakkoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6gatsu.ITokuchoHeijunka6gatsuMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki._Atesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaTorokuKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt310FindKozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
public class TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko {

    private final MapperProvider mapperProvider;
    private final ITokuchoHeijunka6gatsuMapper mapper;
    private static final ReportId REPORT_ID_DBB100012 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
//    private BatchEntityCreatedTempTableWriter<SampleTempTableEntity> batchEntityCreatedTempTableWriter;  //TODO 一時テーブルのEntity;

    private static final int INDEX_6 = 6;
    private final List<NokiJoho> 普徴納期情報リスト;
    private final List<NokiJoho> 特徴納期情報リスト;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko() {
        this.普徴納期情報リスト = new ArrayList<>();
        this.特徴納期情報リスト = new ArrayList<>();
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(ITokuchoHeijunka6gatsuMapper.class);
        //TODO 一時テーブルのEntity;
//        batchEntityCreatedTempTableWriter = new BatchEntityCreatedTempTableWriter<>(SampleTempTableEntity.TABLE_NAME, SampleTempTableEntity.class);
    }

    /**
     * 賦課情報取得
     *
     * @param 調定年度 調定年度
     * @param 一括発行起動フラグ 一括発行起動フラグ
     */
    public void getFukaJoho(RString 調定年度, boolean 一括発行起動フラグ) {

        TokuchoHeijunka6gatsuMyBatisParameter param = new TokuchoHeijunka6gatsuMyBatisParameter();
        param.set調定年度(調定年度);
        param.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        param.set処理名(ShoriName.特徴平準化計算_6月分);

        if (一括発行起動フラグ) {

            仮算定額変更情報一時テーブル_変更情報登録(調定年度);
            仮算定額変更情報一時テーブル_更正前情報の更新();
        } else {
            mapper.select特徴平準化_6月分更新後のデータ();
//            mapper.update仮算定額変更情報一時テーブルの計算後情報更正前情報2(param);
        }
        mapper.update更正前の対象者_追加含む_情報();
        //TODO 普徴納期情報リストと特徴納期情報リストの作成
        mapper.select全ての賦課情報();
        mapper.update前年度特徴期別金額06();
        mapper.update継続の被保険者区分();
        mapper.update4月開始の被保険者区分();
        mapper.update6月開始の被保険者区分();
    }

    private void 仮算定額変更情報一時テーブル_変更情報登録(RString 調定年度) {
        TokuchoHeijunka6gatsuMyBatisParameter param = new TokuchoHeijunka6gatsuMyBatisParameter();
        List<RString> 通知内容コード = new ArrayList<>();
        param.set調定年度(調定年度);
        通知内容コード.add(TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード());
        通知内容コード.add(TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード());
        param.set通知内容コード(通知内容コード);
        mapper.select特徴平準化_6月分更新後とリアルのデータ(param);
    }

    private void 仮算定額変更情報一時テーブル_更正前情報の更新() {

    }

    /**
     * 通知書の発行
     *
     * @param param 帳票発行のパラメータ
     */
    public void printTsuchisho(ChohyoHakkoEntity param) {
        // 出力対象データの取得
        List<DbT2002FukaTempEntity> fukaJohoList = 出力対象情報の取得(param);

        //TODO 帳票制御共通情報の取得
//        DbT7065ChohyoSeigyoKyotsuDac dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
//        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報 = dac.selectByKey(SubGyomuCode.DBB介護賦課, REPORT_ID_DBB100012);
        // 共通的な項目の編集を行う
        Association association = AssociationFinderFactory.createInstance().getAssociation();
//        RString 市町村コード = association.get地方公共団体コード().value();
//        RString 市町村名 = association.get市町村名();
        for (DbT2002FukaTempEntity tmpEntity : fukaJohoList) {

            TsuchishoNo 知書番号 = tmpEntity.get更正後_計算後情報().getTsuchishoNo();
            if (知書番号 == null || 知書番号.isEmpty()) {
                continue;
            }

            // 仮算定額変更通知書共通情報の編集処理
            KariSanteiTsuchiShoKyotsu kariSanteiTsuchiShoKyotsu = new KariSanteiTsuchiShoKyotsu();
            kariSanteiTsuchiShoKyotsu.set発行日(new FlexibleDate(param.get発行日().toDateString()));
            kariSanteiTsuchiShoKyotsu.set帳票分類ID(REPORT_ID_DBB100012);
            kariSanteiTsuchiShoKyotsu.set処理区分(ShoriKubun.バッチ);
            kariSanteiTsuchiShoKyotsu.set地方公共団体(association);
            kariSanteiTsuchiShoKyotsu.set賦課の情報_更正後(null);  // KariSanteiTsuchiShoKyotsu有TODO  [仮算定額変更情報一時テーブルentityにより、「更正後」計算後情報の賦課情報の項目を設定]
//            kariSanteiTsuchiShoKyotsu.set  // TODO 納組情報  KariSanteiTsuchiShoKyotsu有TODO
            // 普徴納期情報リスト   特徴納期情報リスト  74487
            kariSanteiTsuchiShoKyotsu.set宛先情報(new _Atesaki(tmpEntity.get宛先Entity()));
            kariSanteiTsuchiShoKyotsu.set口座情報(set口座(tmpEntity.get口座Entity()));
            kariSanteiTsuchiShoKyotsu.set徴収方法情報_更正前(set徴収方法情報(tmpEntity.get更正前_計算後情報()));
            kariSanteiTsuchiShoKyotsu.set徴収方法情報_更正後(set徴収方法情報(tmpEntity.get更正後_計算後情報()));
            // TODO 業務概念「業務概念.特徴の情報.対象者（追加含む）」なし　転換先がない   「更正後」対象者（追加含む）情報に対応する項目

            // 4.2共通編集処理を呼び出す。  TODO  ビジネス設計_DBBBZ00007_1_賦課帳票共通項目編集（仮算定）.xlsx  未作成
            // 4.3通知書一覧について、ＣＳＶファイルに出力する項目を編集する。  //TODO 引数QA待ち
            // 4.4通知書一覧について、ＣＳＶファイルに出力する項目を編集する。  //TODO 必要な「編集後仮算定通知書共通情報」QA待ち
            // 4.5通知書について、帳票に出力する項目を編集する。  //TODO 「帳票設計_DBBRP35003_1_Ⅱ_特別徴収平準化仮算定額変更通知書.xlsx」がない  QA
        }

//        // 4.6 通知書帳票をスプール登録する   //TODO QA引数の確認
//        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, RString.EMPTY, UzUDE0831EucAccesslogFileType.Csv);
//        // 4.7 通知書一覧帳票をスプール登録する  　　
//        IChohyoShutsuryokujunFinder chohyouFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
//        IUrControlData urData = UrControlDataFactory.createInstance();
//        IOutputOrder outputOrder = chohyouFinder.get出力順(SubGyomuCode.DBB介護賦課, REPORT_ID_DBB100012, Long.parseLong(param.get出力順ID().toString()));
//        RString 改頁項目ID = outputOrder.get改頁項目ID();
//        // 4.8 CSVファイルの文字コードを指定された文字コードに変換する
//        // 4.9 CSVファイルをスプール登録する（TechwikiのEUC用CSVファイル出力API利用ガイドライン参照）
//
//        // 5 発行履歴の登録
//        IHakkoRirekiManager iHakkoRirekiManager = HakkoRirekiManagerFactory.createInstance();
//        // 1:SourceData   3:初期発行状態  4:発行履歴固有情報Map  5:識別コードList
//        BatchReportManager batchManager = new BatchReportManager();
//        ReportAssemblerBuilder build = batchManager.reportAssembler(REPORT_ID_DBB100012.value(), SubGyomuCode.DBB介護賦課);  // 帳票ID  サブ業務コード
//        ReportAssembler assemble = build.create();
//        BatchReportWriter writer = new BatchReportWriter(new BatchReportManager(), assemble);
//        iHakkoRirekiManager.insert帳票発行履歴(null, new FlexibleDate(param.get発行日().toDateString()), ChohyoHakkoRirekiJotai.未定, null, null);
//
    }

    private List<DbT2002FukaTempEntity> 出力対象情報の取得(ChohyoHakkoEntity param) {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, REPORT_ID_DBB100012, Long.parseLong(param.get出力順ID().toString()));

        RString 出力順 = MyBatisOrderByClauseCreator.create(null, outputOrder);  //TODO  帳票出力順・改ページ項目一覧（DBB介護賦課）.xlsx
        param.set出力順(出力順);
        return mapper.select出力対象情報(param);
    }

    private IKoza set口座(UaFt310FindKozaEntity uaFt310Entity) {
        KozaRelateEntity releteEntity = new KozaRelateEntity();
        UaT0310KozaEntity kozaEntity = new UaT0310KozaEntity();

//        kozaEntity.setGyomubetsuPrimaryKey(); //ない  uaFt310EntityにUaFt310FindKozaEntityにとって必要な項目がない
        uaFt310Entity.getサブ業務コード();
        kozaEntity.setKozaId(uaFt310Entity.get口座ID().longValue());
        kozaEntity.setKozaMeiginin(uaFt310Entity.get口座名義人());
        kozaEntity.setKozaMeigininKanji(uaFt310Entity.get口座名義人漢字());
        kozaEntity.setKozaMeigininShikibetsuCode(uaFt310Entity.get口座名義人識別コード());
        kozaEntity.setKozaNo(uaFt310Entity.get口座番号());
        kozaEntity.setKozaTorokuKubunCode(new KozaTorokuKubunCodeValue(uaFt310Entity.get口座登録区分コード()));
        kozaEntity.setKozaTorokuYMD(new FlexibleDate(uaFt310Entity.get口座登録年月日().toDateString()));
        kozaEntity.setKozaTorokuNo(uaFt310Entity.get口座登録番号());
        kozaEntity.setKozaShuryoUketsukeYMD(new FlexibleDate(uaFt310Entity.get口座終了受付年月日().toDateString()));
        kozaEntity.setKozaHyojiKubun(uaFt310Entity.get口座表示区分());
        kozaEntity.setKozaKaishiUketsukeYMD(new FlexibleDate(uaFt310Entity.get口座開始受付年月日().toDateString()));
        kozaEntity.setTemban(uaFt310Entity.get店番());
        kozaEntity.setKinyuKikanShitenCode(uaFt310Entity.get支店コード());
        // uaFt310Entity.get支店名称();
        kozaEntity.setKensakuyoMeiginin(uaFt310Entity.get検索用名義人());
//        uaFt310Entity.get業務コード();
        kozaEntity.setGyomuKoyuKey(uaFt310Entity.get業務固有キー());
        kozaEntity.setYotoKubun(new KozaYotoKubunCodeValue(uaFt310Entity.get用途区分()));
//        uaFt310Entity.get用途区分名称();
//        uaFt310Entity.get科目コード();
        kozaEntity.setShuryoYMD(new FlexibleDate(uaFt310Entity.get終了年月日().toDateString()));
        kozaEntity.setShikibetsuCode(uaFt310Entity.get識別コード());
        kozaEntity.setTsuchoNo(uaFt310Entity.get通帳番号());
        kozaEntity.setTsuchoKigo(uaFt310Entity.get通帳記号());
        kozaEntity.setKinyuKikanCode(uaFt310Entity.get金融機関コード());
//        uaFt310Entity.get金融機関名称();
        kozaEntity.setKaishiYMD(new FlexibleDate(uaFt310Entity.get開始年月日().toDateString()));
        kozaEntity.setYokinShubetsu(uaFt310Entity.get預金種別());
//        uaFt310Entity.get預金種別名称();

        releteEntity.setUaT0310KozaEntity(kozaEntity);
        return new Koza(releteEntity);
    }

    private ChoshuHoho set徴収方法情報(DbT2015KeisangoJohoEntity entity) {
        ChoshuHoho choshuHoho = new ChoshuHoho(entity.getFukaNendo(), entity.getHihokenshaNo(), entity.getFukaRirekiNo());
        ChoshuHohoBuilder builder = choshuHoho.createBuilderForEdit();
        builder.set仮徴収_基礎年金番号(entity.getKariNenkinNo());
        builder.set仮徴収_年金コード(entity.getKariNenkinCode());
        builder.set仮徴収_捕捉月(entity.getKariHosokuM());
        builder.set依頼情報送付済みフラグ(entity.getIraiSohuzumiFlag());
        builder.set履歴番号(entity.getFukaRirekiNo());
        builder.set徴収方法10月(entity.getChoshuHoho10gatsu());
        builder.set徴収方法11月(entity.getChoshuHoho11gatsu());
        builder.set徴収方法12月(entity.getChoshuHoho12gatsu());
        builder.set徴収方法1月(entity.getChoshuHoho1gatsu());
        builder.set徴収方法2月(entity.getChoshuHoho2gatsu());
        builder.set徴収方法3月(entity.getChoshuHoho3gatsu());
        builder.set徴収方法4月(entity.getChoshuHoho4gatsu());
        builder.set徴収方法5月(entity.getChoshuHoho5gatsu());
        builder.set徴収方法6月(entity.getChoshuHoho6gatsu());
        builder.set徴収方法7月(entity.getChoshuHoho7gatsu());
        builder.set徴収方法8月(entity.getChoshuHoho8gatsu());
        builder.set徴収方法9月(entity.getChoshuHoho9gatsu());
        builder.set徴収方法翌4月(entity.getChoshuHohoYoku4gatsu());
        builder.set徴収方法翌5月(entity.getChoshuHohoYoku5gatsu());
        builder.set徴収方法翌6月(entity.getChoshuHohoYoku6gatsu());
        builder.set徴収方法翌7月(entity.getChoshuHohoYoku7gatsu());
        builder.set徴収方法翌8月(entity.getChoshuHohoYoku8gatsu());
        builder.set徴収方法翌9月(entity.getChoshuHohoYoku9gatsu());
        builder.set本徴収_基礎年金番号(entity.getHonNenkinNo());
        builder.set本徴収_年金コード(entity.getHonNenkinCode());
        builder.set本徴収_捕捉月(entity.getHonHosokuM());
        builder.set特別徴収停止事由コード(entity.getTokuchoTeishiJiyuCode());
        builder.set特別徴収停止日時(entity.getTokuchoTeishiNichiji());
        builder.set翌年度仮徴収_基礎年金番号(entity.getYokunendoKariNenkinNo());
        builder.set翌年度仮徴収_年金コード(entity.getYokunendoKariNenkinCode());
        builder.set被保険者番号(entity.getHihokenshaNo());
        builder.set賦課年度(entity.getFukaNendo());
        builder.set追加依頼情報送付済みフラグ(entity.getTsuikaIraiSohuzumiFlag());
        return builder.build();

    }

    /**
     * 通知書発行後異動者登録
     *
     * @param 帳票作成日時 帳票作成日時
     * @param 出力順ID 出力順ID
     * @param 出力対象区分 出力対象区分
     * @param 帳票ID 帳票ID
     */
    public void insTsuchishoHakkogoIdosha(RString 帳票作成日時, Long 出力順ID, RString 出力対象区分, ReportId 帳票ID) {

        RString 出力順 = RString.EMPTY;

        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();

        if (出力順ID != null) {
            IOutputOrder chohyoShutsuyokujun = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, 帳票ID, reamsLoginID, 出力順ID);
            if (chohyoShutsuyokujun != null) {
                出力順 = MyBatisOrderByClauseCreator.create(null, chohyoShutsuyokujun); // TODO
            }
        }
        TokuchoHeijunka6gatsuMyBatisParameter param = new TokuchoHeijunka6gatsuMyBatisParameter();
        param.set出力順(出力順);
        mapper.insert通知書発行後異動者(param);

    }

    /**
     * 普徴納期情報リストと特徴納期情報リストを作成します。
     *
     * @param 調定年度 調定年度
     */
    public void 普徴納期情報リストと特徴納期情報リストの作成(RYear 調定年度) {

        FukaNokiResearcher 賦課納期取得 = new FukaNokiResearcher(調定年度);
        Noki noki;
        NokiJoho nokiJoho;

        for (Kitsuki 期月 : new FuchoKiUtil().get期月リスト().filtered仮算定期間().toList()) {
            noki = 賦課納期取得.get普徴納期(期月.get期AsInt());
            nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月);
            nokiJoho.set納期(noki);
            this.普徴納期情報リスト.add(nokiJoho);
        }

        for (int i = 1; i <= INDEX_6; i++) {
            Kitsuki 期月 = new TokuchoKiUtil().get期月リスト().get期の最初月(i);
            noki = 賦課納期取得.get普徴納期(期月.get期AsInt());
            nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月);
            nokiJoho.set納期(noki);
            this.特徴納期情報リスト.add(nokiJoho);
        }
    }

}
