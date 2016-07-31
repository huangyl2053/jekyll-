/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6batch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchFuchJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchFukaJohoResult;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaRokuBatchFukaGakuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kaigofukatokuchoheijunka6batch.IKaigoFukaTokuchoHeijunka6BatchMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特徴平準化（特徴6月分）（バッチ）クラスです。
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
public class KaigoFukaTokuchoHeijunka6Batch {

    private static final RString 備考コード_併徴者 = new RString("1");
    private static final RString 備考コード_特徴6月開始者 = new RString("6");
    private static final RString 備考コード_仮徴収額修正者 = new RString("2");
    private static final RString 調定事由_平準化による変更6月 = new RString("E3");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 編集コード_併徴者 = new RString("併徴者");
    private static final RString 編集コード_仮徴収額修正者 = new RString("仮徴収額修正者");
    private static final RString 編集コード_対象外_減額 = new RString("対象外_減額");
    private static final RString 編集コード_対象外_増額 = new RString("象外_増額");
    private static final RString 編集コード_特徴6月開始者 = new RString("特徴6月開始者");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString タイトル_対象者一覧表 = new RString("介護保険　特徴仮算定平準化対象者一覧表");
    private static final RString タイトル_対象外一覧表 = new RString("介護保険　特徴仮算定平準化対象外一覧表");
    private static final RString 英数字ファイル名 = new RString("TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranData.csv");
    private static final RString CSVファイル = new RString(".csv");
    private static final RString ファイル名_対象者一覧表 = new RString("介護保険特徴仮算定平準化対象者一覧表_");
    private static final RString ファイル名_対象外一覧表 = new RString("介護保険特徴仮算定平準化対象外一覧表_");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200003"));
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    private static final int 仮算定期間_期1 = 1;
    private static final int 仮算定期間_期2 = 2;
    private static final int 仮算定期間_期3 = 3;
    private static final int 仮算定期間_期4 = 4;
    private static final int 仮算定期間_期5 = 5;
    private static final int 仮算定期間_期6 = 6;
    private static final int 仮算定期間_期7 = 7;
    private static final int 仮算定期間_期8 = 8;
    private static final int 仮算定期間_期9 = 9;
    private static final int 仮算定期間_期10 = 10;
    private static final int 仮算定期間_期11 = 11;
    private static final int 仮算定期間_期12 = 12;
    private static final int 仮算定期間_期13 = 13;
    private static final int 仮算定期間_期14 = 14;
    private static final int NUM_期1 = 1;
    private static final int NUM_期2 = 2;
    private static final int NUM_期3 = 3;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 出力条件_左括弧 = new RString("【");
    private static final RString 出力条件_右括弧 = new RString("】");
    private static final RString パラメータ名_調定年度 = new RString("調定年度");
    private static final RString パラメータ名_賦課年度 = new RString("賦課年度");
    private static final RString 年度 = new RString("年度");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString SIGN_GT = new RString("＞");
//    private static final RString 平準化対象外理由区分_最小値未満 = new RString("1");
//    private static final RString 平準化対象外理由区分_計算方法より = new RString("2");
//    private static final RString 備考コード_結果0円以下 = new RString("3");
//    private static final RString 備考コード_対象外減額 = new RString("4");
//    private static final RString 備考コード_対象外増額 = new RString("5");
    private static final RString 計算後情報_テーブル = new RString("計算後情報.");
    private static final RString 対象外データテンプ_テーブル = new RString("対象外データTemp.");
    private static final RString 識別コード = new RString("\"shikibetsuCode\"");
    private static final RString 被保険者番号 = new RString("\"hihokenshaNo\"");
    private static final RString 世帯コード = new RString("\"setaiCode\"");
    private static final RString 賦課_識別コード = new RString("\"dbT2002Fuka_shikibetsuCode\"");
    private static final RString 賦課_被保険者番号 = new RString("\"dbT2002Fuka_hihokenshaNo\"");
    private static final RString 賦課_世帯コード = new RString("\"dbT2002Fuka_setaiCode\"");
    private final MapperProvider mapperProvider;
    private final DbT2002FukaDac dbT2002FukaDac;
    private final DbT2003KibetsuDac dbT2003KibetsuDac;
    private final UrT0705ChoteiKyotsuDac urT0705ChoteiKyotsuDac;

    /**
     * コンストラクタです。
     */
    public KaigoFukaTokuchoHeijunka6Batch() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT2002FukaDac = InstanceProvider.create(DbT2002FukaDac.class);
        this.dbT2003KibetsuDac = InstanceProvider.create(DbT2003KibetsuDac.class);
        this.urT0705ChoteiKyotsuDac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoFukaTokuchoHeijunka6Batch}のインスタンスを返します。
     *
     * @return FuchoKariTsuchishoIkkatsuHakko
     */
    public static KaigoFukaTokuchoHeijunka6Batch createInstance() {
        return InstanceProvider.create(KaigoFukaTokuchoHeijunka6Batch.class);
    }

    /**
     * 調定年度、賦課年度より、賦課情報を取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     */
    public void getMaeFukaJohoList(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        TokuchoHeijunkaRokuBatchFuchJohoParameter parameter = TokuchoHeijunkaRokuBatchFuchJohoParameter.createParam(調定年度, 賦課年度);
        IKaigoFukaTokuchoHeijunka6BatchMapper mapper = mapperProvider.create(IKaigoFukaTokuchoHeijunka6BatchMapper.class);
        mapper.insert平準化前賦課Temp(parameter);
    }

    /**
     * 平準化計算後で、賦課情報を取得するメソッドです。
     */
    public void getAtoFukaJohoList() {
        IKaigoFukaTokuchoHeijunka6BatchMapper mapper = mapperProvider.create(IKaigoFukaTokuchoHeijunka6BatchMapper.class);
        List<FukaJohoRelateEntity> 賦課情報リスト = mapper.get平準化前賦課Temp();

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        List<Kitsuki> 普徴仮算定期間リスト = 普徴仮算定期間.toList();
        int 仮算定期間_最大期 = 普徴仮算定期間リスト.get(0).get期AsInt();
        int 仮算定期間_最小期 = 普徴仮算定期間リスト.get(普徴仮算定期間リスト.size() - 1).get期AsInt();
        mapper.create対象外データTemp();
        mapper.alter対象外データTemp備考コード();
        mapper.create対象者データTemp();
        mapper.alter対象者データTemp備考コード();
        for (FukaJohoRelateEntity 賦課情報 : 賦課情報リスト) {
            RString 備考コード = RString.EMPTY;
            FukaJoho fukaJoho = new FukaJoho(賦課情報);
            TokuchoHeijyunkaRokuBatchFukaGakuEntity fukaGakuEntity = new TokuchoHeijyunkaRokuBatchFukaGakuEntity();
            Decimal 特徴期別金額合計 = Decimal.ZERO;
            final Decimal 特徴期別金額01 = fukaJoho.get特徴期別金額01();
            final Decimal 特徴期別金額02 = fukaJoho.get特徴期別金額02();
            final Decimal 特徴期別金額03 = fukaJoho.get特徴期別金額03();
            if (特徴期別金額01 != null) {
                特徴期別金額合計 = 特徴期別金額合計.add(特徴期別金額01);
            }
            if (特徴期別金額02 != null) {
                特徴期別金額合計 = 特徴期別金額合計.add(特徴期別金額02);
            }
            if (特徴期別金額03 != null) {
                特徴期別金額合計 = 特徴期別金額合計.add(特徴期別金額03);
            }
            Decimal 普徴期別金額合計 = Decimal.ZERO;
            for (int i = 仮算定期間_最小期; i <= 仮算定期間_最大期; i++) {
                普徴期別金額合計 = 普徴期別金額合計.add(普徴期別金額取得(i, fukaJoho));
            }
            TokuchoHeijunkaRokuBatchTaishogaiTempEntity 対象外データTempEntity = null;
            TokuchoHeijunkaRokuBatchTaishogaiTempEntity 対象者データTempEntity = null;
            if (Decimal.ZERO.compareTo(特徴期別金額合計) < 0 && Decimal.ZERO.compareTo(普徴期別金額合計) < 0) {
                備考コード = 備考コード_併徴者;
            } else if (Decimal.ZERO.equals(普徴期別金額合計) && Decimal.ZERO.equals(特徴期別金額01)) {
                備考コード = 備考コード_特徴6月開始者;
            } else if (特徴期別金額比較(特徴期別金額01, 特徴期別金額02, 特徴期別金額03)) {
                備考コード = 備考コード_仮徴収額修正者;
            }
            fukaGakuEntity.set保険料段階仮算定時(fukaJoho.get保険料段階_仮算定時());
            fukaGakuEntity.set特徴期期別金額01(特徴期別金額01);
            fukaGakuEntity.set特徴期期別金額02(特徴期別金額02);
            fukaGakuEntity.set特徴期期別金額03(特徴期別金額03);
            普徴期別金額設定(fukaGakuEntity, fukaJoho);
            if (!備考コード.isEmpty()) {
                対象外データTempEntity = new TokuchoHeijunkaRokuBatchTaishogaiTempEntity(賦課情報, 備考コード, fukaGakuEntity);
                mapper.insert対象外データTemp(対象外データTempEntity);
            } else {
                対象者データTempEntity = new TokuchoHeijunkaRokuBatchTaishogaiTempEntity(賦課情報, RString.EMPTY, fukaGakuEntity);
                mapper.insert対象者データTemp(対象者データTempEntity);
            }
        }
    }

    private void 普徴期別金額設定(TokuchoHeijyunkaRokuBatchFukaGakuEntity fukaGakuEntity, FukaJoho fukaJoho) {
        fukaGakuEntity.set普徴期期別金額01(fukaJoho.get普徴期別金額01());
        fukaGakuEntity.set普徴期期別金額02(fukaJoho.get普徴期別金額02());
        fukaGakuEntity.set普徴期期別金額03(fukaJoho.get普徴期別金額03());
        fukaGakuEntity.set普徴期期別金額04(fukaJoho.get普徴期別金額04());
        fukaGakuEntity.set普徴期期別金額05(fukaJoho.get普徴期別金額05());
        fukaGakuEntity.set普徴期期別金額06(fukaJoho.get普徴期別金額06());
        fukaGakuEntity.set普徴期期別金額07(fukaJoho.get普徴期別金額07());
        fukaGakuEntity.set普徴期期別金額08(fukaJoho.get普徴期別金額08());
        fukaGakuEntity.set普徴期期別金額09(fukaJoho.get普徴期別金額09());
        fukaGakuEntity.set普徴期期別金額10(fukaJoho.get普徴期別金額10());
        fukaGakuEntity.set普徴期期別金額11(fukaJoho.get普徴期別金額11());
        fukaGakuEntity.set普徴期期別金額12(fukaJoho.get普徴期別金額12());
    }

    private boolean 特徴期別金額比較(final Decimal 特徴期別金額01, final Decimal 特徴期別金額02, final Decimal 特徴期別金額03) {
        return (特徴期別金額01 != null && 特徴期別金額02 != null && !特徴期別金額01.equals(特徴期別金額02))
                || (特徴期別金額02 != null && 特徴期別金額03 != null && !特徴期別金額02.equals(特徴期別金額03))
                || (特徴期別金額01 != null && 特徴期別金額03 != null && !特徴期別金額01.equals(特徴期別金額03));
    }

    /**
     * 平準化計算後で、抽出した賦課情報によって、ＤＢ項目を編集するメソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 平準化計算方法_増額 RString
     * @param 平準化計算方法_減額 RString
     */
    public void editAtoFukaJohoList(FlexibleYear 賦課年度, YMDHMS 調定日時, RString 平準化計算方法_増額, RString 平準化計算方法_減額) {
        IKaigoFukaTokuchoHeijunka6BatchMapper mapper = mapperProvider.create(IKaigoFukaTokuchoHeijunka6BatchMapper.class);
        List<TokuchoHeijunkaRokuBatchTaishogaiTempEntity> taishoshaTempEntityList = mapper.get対象者データTemp();
        mapper.create平準化計算結果Temp();
//        Heijunka heijunka = new Heijunka();
//        HokenryoDankaiManager 保険料段階取得 = new HokenryoDankaiManager();
//        RDate effectiveDate = new RDate(賦課年度.toDateString().toString());
        // QA990
        for (TokuchoHeijunkaRokuBatchTaishogaiTempEntity entity : taishoshaTempEntityList) {
//            HeijunkaInput heijunkaInput = new HeijunkaInput();
//            平準化入力設定(保険料段階取得, 賦課年度, entity, heijunkaInput, 平準化計算方法_増額, 平準化計算方法_減額, effectiveDate);
//            HeijunkaOutput 平準化結果 = heijunka.calculateHeijunka(heijunkaInput);
//            if (平準化結果.is平準化済フラグ()) {
            TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity tmpEntity = new TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity(
                    Decimal.TEN, Decimal.TEN, Decimal.TEN, entity.getDbT2002Fuka_tsuchishoNo());
            mapper.insert平準化計算結果Temp(tmpEntity);
//            } else {
//                entity.set備考コード(get備考コード(平準化結果));
//                mapper.insert対象外データTemp(entity);
//            }
        }
    }

//    private void 平準化入力設定(HokenryoDankaiManager 保険料段階取得, FlexibleYear 賦課年度,
//            TokuchoHeijunkaRokuBatchTaishogaiTempEntity entity, HeijunkaInput heijunkaInput,
//            RString 平準化計算方法_増額, RString 平準化計算方法_減額, RDate effectiveDate) {
//        Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(賦課年度, entity.getHokenryoDankaiKarisanntei());
//        heijunkaInput.set年保険料額(今年度保険料率取得(保険料段階));
//        List<Decimal> 特徴期別額リスト = new ArrayList<>();
//        特徴期別額リスト.add(entity.getTokuchoKibetsuChoteigaku1());
//        特徴期別額リスト.add(entity.getTokuchoKibetsuChoteigaku2());
//        特徴期別額リスト.add(entity.getTokuchoKibetsuChoteigaku3());
//        heijunkaInput.set特徴期別額(特徴期別額リスト);
//        heijunkaInput.set平準化開始期idx(NUM_1);
//        heijunkaInput.set八月特徴開始者(NUM_0);
//        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
//        業務コンフィグ情報.set特徴定期数(Integer.parseInt(
//                コンフィグ値取得(ConfigNameDBB.特徴期情報_設定納期数, effectiveDate).toString()));
//        業務コンフィグ情報.set特徴仮算定期数(Integer.parseInt(
//                コンフィグ値取得(ConfigNameDBB.特徴期情報_仮算定期数, effectiveDate).toString()));
//        業務コンフィグ情報.set平準化計算方法増額分(Integer.parseInt(平準化計算方法_増額.toString()));
//        業務コンフィグ情報.set平準化計算方法減額分(Integer.parseInt(平準化計算方法_減額.toString()));
//        業務コンフィグ情報.set端数区分特徴期別額(Integer.parseInt(
//                コンフィグ値取得(ConfigNameDBB.特別徴収_期別端数, effectiveDate).toString()));
//        業務コンフィグ情報.set基準となる差額幅(Decimal.ZERO);
//        業務コンフィグ情報.set基準となる差額率(Decimal.ZERO);
//        業務コンフィグ情報.set平準化対象期別額最小値(Decimal.ONE);
//        List<jp.co.ndensan.reams.ur.urd.business.core.heijunka.Kibetsu> 期別リスト = new ArrayList<>();
//        期別リスト作成(effectiveDate, 期別リスト);
//        業務コンフィグ情報.set期別クラス(期別リスト);
//        heijunkaInput.set業務コンフィグ情報(業務コンフィグ情報);
//    }
//    private void 期別リスト作成(RDate effectiveDate, List<jp.co.ndensan.reams.ur.urd.business.core.heijunka.Kibetsu> 期別リスト) throws NumberFormatException {
//        jp.co.ndensan.reams.ur.urd.business.core.heijunka.Kibetsu 期別 = new jp.co.ndensan.reams.ur.urd.business.core.heijunka.Kibetsu();
//        int 月の期1 = Integer.parseInt(コンフィグ値取得(ConfigNameDBB.特徴期情報_月の期1, effectiveDate).toString());
//        int 月の期2 = Integer.parseInt(コンフィグ値取得(ConfigNameDBB.特徴期情報_月の期2, effectiveDate).toString());
//        int 月の期3 = Integer.parseInt(コンフィグ値取得(ConfigNameDBB.特徴期情報_月の期3, effectiveDate).toString());
//        int 月の期4 = Integer.parseInt(コンフィグ値取得(ConfigNameDBB.特徴期情報_月の期4, effectiveDate).toString());
//        int 月処理区分1 = 一行目のレコード変換(コンフィグ値取得(ConfigNameDBB.特徴期情報_月処理区分1, effectiveDate));
//        int 月処理区分2 = 一行目のレコード変換(コンフィグ値取得(ConfigNameDBB.特徴期情報_月処理区分2, effectiveDate));
//        int 月処理区分3 = 一行目のレコード変換(コンフィグ値取得(ConfigNameDBB.特徴期情報_月処理区分3, effectiveDate));
//        int 月処理区分4 = 一行目のレコード変換(コンフィグ値取得(ConfigNameDBB.特徴期情報_月処理区分4, effectiveDate));
//        期別.set特徴期(月の期1);
//        期別.set特徴期区分(月処理区分1);
//        期別リスト.add(期別);
//        期別 = new jp.co.ndensan.reams.ur.urd.business.core.heijunka.Kibetsu();
//        期別.set特徴期(月の期2);
//        期別.set特徴期区分(月処理区分2);
//        期別リスト.add(期別);
//        期別 = new jp.co.ndensan.reams.ur.urd.business.core.heijunka.Kibetsu();
//        期別.set特徴期(月の期3);
//        期別.set特徴期区分(月処理区分3);
//        期別リスト.add(期別);
//        期別 = new jp.co.ndensan.reams.ur.urd.business.core.heijunka.Kibetsu();
//        期別.set特徴期(月の期4);
//        期別.set特徴期区分(月処理区分4);
//        期別リスト.add(期別);
//    }
//    private RString コンフィグ値取得(Enum key, RDate effectiveDate) {
//        return DbBusinessConfig.get(key, effectiveDate, SubGyomuCode.DBB介護賦課);
//    }
//    private int 一行目のレコード変換(RString 特徴期情報_月処理区分) {
//        int 月処理区分 = NUM_0;
//        int i = Integer.parseInt(特徴期情報_月処理区分.toString());
//        switch (i) {
//            case NUM_0:
//                break;
//            case NUM_1:
//                月処理区分 = NUM_1;
//                break;
//            case NUM_2:
//                月処理区分 = NUM_2;
//                break;
//            case NUM_3:
//                break;
//            case NUM_4:
//                月処理区分 = NUM_3;
//                break;
//            case NUM_5:
//                月処理区分 = NUM_4;
//                break;
//            default:
//                break;
//        }
//        return 月処理区分;
//    }
//    private RString get備考コード(HeijunkaOutput 平準化結果) {
//        RString 平準化対象外理由区分 = 平準化結果.get平準化対象外理由区分();
//        RString 備考コード = RString.EMPTY;
//        List<Decimal> 変更後特徴期別額 = 平準化結果.get変更後特徴期別額();
//        final Decimal 変更後特徴期別額ひとつ = 変更後特徴期別額.get(NUM_0);
//        final Decimal 変更後特徴期別額ふたつ = 変更後特徴期別額.get(NUM_1);
//        if (平準化対象外理由区分_最小値未満.equals(平準化対象外理由区分)) {
//            備考コード = 備考コード_結果0円以下;
//        } else if (変更後特徴期別額ひとつ != null && 変更後特徴期別額ふたつ != null) {
//            final boolean is平準化対象外理由区分計算方法より = 平準化対象外理由区分_計算方法より.equals(平準化対象外理由区分);
//            if (is平準化対象外理由区分計算方法より && 変更後特徴期別額ふたつ.compareTo(変更後特徴期別額ひとつ) < 0) {
//                備考コード = 備考コード_対象外減額;
//            } else if (is平準化対象外理由区分計算方法より && 変更後特徴期別額ひとつ.compareTo(変更後特徴期別額ふたつ) < 0) {
//                備考コード = 備考コード_対象外増額;
//            }
//        }
//        return 備考コード;
//    }
    /**
     * 平準化計算後の結果より、介護賦課テーブルを挿入するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void insertKaigoFukaTbl(FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時) {
        IKaigoFukaTokuchoHeijunka6BatchMapper mapper = mapperProvider.create(IKaigoFukaTokuchoHeijunka6BatchMapper.class);
        List<TokuchoHeijunkaRokuBatchFukaJohoResult> 賦課の情報 = mapper.get賦課の情報();
        Map<Long, Long> 調定IDMap = new HashMap<>();
        for (TokuchoHeijunkaRokuBatchFukaJohoResult 賦課情報 : 賦課の情報) {
            FukaJoho fukaJoho = new FukaJoho(賦課情報.get賦課の情報());
            TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity 平準化計算結果 = 賦課情報.get平準化計算結果();
            FukaJohoBuilder builder = fukaJoho.createBuilderForEdit();
            特徴期別金額設定(fukaJoho, 平準化計算結果, builder, 調定IDMap);
            fukaJoho = builder.set履歴番号(fukaJoho.get履歴番号() + 1).set調定日時(調定日時).set異動基準日時(調定日時).set調定事由1(調定事由_平準化による変更6月).
                    set調定事由2(RString.EMPTY).set調定事由3(RString.EMPTY).set調定事由4(RString.EMPTY).build();
            dbT2002FukaDac.save(fukaJoho.toEntity());
        }
    }

    /**
     * 平準化計算後の結果より、介護期別登録テーブルを挿入するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID Long
     */
    public void insertKaigoKibetsuTbl(FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時, Long 出力順ID) {
        IKaigoFukaTokuchoHeijunka6BatchMapper mapper = mapperProvider.create(IKaigoFukaTokuchoHeijunka6BatchMapper.class);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200003.getReportId(), 出力順ID);
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(
                    TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty.DBB200003_HeijunkaKeisanJuneKekkaIchiran.class, outputOrder);
        }
        RString 対象者出力順 = 出力順設定(出力順);
        TokuchoHeijunkaRokuBatchTaishoParameter parameter = new TokuchoHeijunkaRokuBatchTaishoParameter(
                調定年度, 賦課年度, 調定日時, 調定年度.minusYear(NUM_1), 対象者出力順);
        List<TokuchoHeijunkaRokuBatchTaishoshaEntity> 対象者データリスト = mapper.get対象者データ(parameter);
        List<TokuchoHeijyunkaTaishoshaEntity> 特徴平準化結果対象者一覧表リスト = new ArrayList<>();
        if (対象者データリスト != null && !対象者データリスト.isEmpty()) {
            for (int i = 0; i < 対象者データリスト.size(); i++) {
                int nextIdx = i + 1;
                TokuchoHeijunkaRokuBatchTaishoshaEntity 対象者データ前 = 対象者データリスト.get(i);
                DbT2015KeisangoJohoEntity 計算後情報前 = 対象者データ前.get計算後情報();
                if (計算後情報前 != null) {
                    特徴平準化計算対象者リスト作成(計算後情報前, 対象者データ前, 対象者データリスト, 特徴平準化結果対象者一覧表リスト, nextIdx);
                }
            }
        }
        TokuChoHeijunkaKeisanJuneKekkaIchiranPrintService printService = new TokuChoHeijunkaKeisanJuneKekkaIchiranPrintService();
        HokenryoDankaiManager 保険料段階取得 = new HokenryoDankaiManager();
        ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200003.getReportId());
        List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> taishoshaList = new ArrayList<>();
        for (TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者 : 特徴平準化結果対象者一覧表リスト) {
            Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(賦課年度, 特徴平準化結果対象者.get保険料段階仮算定時());
            Decimal 今年度保険料率 = 今年度保険料率取得(保険料段階);
            int 調整金額 = 調整金額取得(今年度保険料率, 賦課年度);
            TokuchoHeijunkaRokuBatchTaishoshaIchiran entity = new TokuchoHeijunkaRokuBatchTaishoshaIchiran(
                    特徴平準化結果対象者, 今年度保険料率, new Decimal(調整金額));
            taishoshaList.add(entity);
        }
        SourceDataCollection taishoshaSourceData = null;
        if (!taishoshaList.isEmpty()) {
            taishoshaSourceData = printService.printTaishosha(taishoshaList, 出力順ID, 調定日時, 賦課年度);
        }
        RString 対象外出力順 = 出力順再設定(出力順);
        TokuchoHeijunkaRokuBatchTaishoParameter 対象外param = new TokuchoHeijunkaRokuBatchTaishoParameter(
                調定年度, 賦課年度, 調定日時, 調定年度.minusYear(NUM_1), 対象外出力順);
        List<TokuchoHeijunkaRokuBatchTaishogaiEntity> 対象外データリスト = mapper.get対象外データ(対象外param);
        List<TokuchoHeijyunkaTaishogaiEntity> 特徴平準化結果対象外一覧表リスト = new ArrayList<>();
        for (TokuchoHeijunkaRokuBatchTaishogaiEntity 対象外データ : 対象外データリスト) {
            FukaJohoRelateEntity 対象外データTemp = 対象外データ.get対象外データTemp();
            if (対象外データTemp != null) {
                特徴平準化計算対象外リスト作成(対象外データTemp, 対象外データ, 特徴平準化結果対象外一覧表リスト);
            }
        }
        List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> taishogaiList = new ArrayList<>();
        for (TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外 : 特徴平準化結果対象外一覧表リスト) {
            Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(賦課年度, 特徴平準化結果対象外.get保険料段階仮算定時());
            Decimal 今年度保険料率 = 今年度保険料率取得(保険料段階);
            int 調整金額 = 調整金額取得(今年度保険料率, 賦課年度);
            TokuchoHeijunkaRokuBatchTaishogaiIchiran entity = new TokuchoHeijunkaRokuBatchTaishogaiIchiran(
                    特徴平準化結果対象外, 今年度保険料率, new Decimal(調整金額));
            taishogaiList.add(entity);
        }
        SourceDataCollection taishogaiSourceData = null;
        if (!taishogaiList.isEmpty()) {
            taishogaiSourceData = printService.printTaishogai(taishogaiList, 出力順ID, 調定日時, 賦課年度);
        }
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = 導入団体クラス.get地方公共団体コード();
        RString 市町村名 = 導入団体クラス.get市町村名();

        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath,
                ファイル名_対象者一覧表.concat(調定日時.toString()).concat(CSVファイル));
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(false)
                .build()) {
            for (TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者 : 特徴平準化結果対象者一覧表リスト) {
                Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(賦課年度, 特徴平準化結果対象者.get保険料段階仮算定時());
                Decimal 今年度保険料率 = 今年度保険料率取得(保険料段階);
                int 調整金額 = 調整金額取得(今年度保険料率, 賦課年度);
                RString 編集備考 = 備考名を転換(特徴平準化結果対象者.get備考コード());
                IKojin iKojin = ShikibetsuTaishoFactory.createKojin(特徴平準化結果対象者.get宛名の情報());
                RString 編集後住所 = JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体クラス);
                List<RString> bodyList = new ArrayList<>();
                特徴平準化対象者CSV項目編集(bodyList, 調定日時, 賦課年度, 特徴平準化結果対象者,
                        編集後住所, 今年度保険料率, 調整金額, 編集備考);
                toBodyList(bodyList);
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        }
        FileSpoolManager managerTaishogai = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPathTaishogai = managerTaishogai.getEucOutputDirectry();
        RString eucFilePathTaishogai = Path.combinePath(spoolWorkPathTaishogai,
                ファイル名_対象外一覧表.concat(調定日時.toString()).concat(CSVファイル));
        try (CsvListWriter csvListWrite = new CsvListWriter.InstanceBuilder(eucFilePathTaishogai).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(false)
                .build()) {
            for (TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外 : 特徴平準化結果対象外一覧表リスト) {
                Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(賦課年度, 特徴平準化結果対象外.get保険料段階仮算定時());
                Decimal 今年度保険料率 = 今年度保険料率取得(保険料段階);
                int 調整金額 = 調整金額取得(今年度保険料率, 賦課年度);
                RString 備考名 = 備考名を転換(特徴平準化結果対象外.get備考コード());
                IKojin iKojin = ShikibetsuTaishoFactory.createKojin(特徴平準化結果対象外.get宛名の情報());
                RString 編集後住所 = JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体クラス);
                List<RString> bodyList = new ArrayList<>();
                特徴平準化対象外CSV項目編集(bodyList, 調定日時, 賦課年度, 特徴平準化結果対象外,
                        編集後住所, 今年度保険料率, 調整金額, 備考名);
                toBodyList(bodyList);
                csvListWrite.writeLine(bodyList);
                csvListWrite.close();
            }
            managerTaishogai.spool(SubGyomuCode.DBB介護賦課, eucFilePathTaishogai);
        }
        int 対象外出力ページ数 = taishogaiSourceData == null ? NUM_0 : taishogaiSourceData.iterator().next().getPageCount();
        int 対象者出力ページ数 = taishoshaSourceData == null ? NUM_0 : taishoshaSourceData.iterator().next().getPageCount();
        RString 出力ページ数 = new RString(対象外出力ページ数 + 対象者出力ページ数);
        バッチ出力条件リストの出力(調定年度, 賦課年度, 市町村コード, 市町村名, 出力ページ数, 出力順ID);
    }

    private RString 出力順設定(RString 出力順) {
        if (出力順.contains(世帯コード)) {
            出力順 = 出力順.replace(世帯コード, 計算後情報_テーブル.concat(世帯コード));
        }
        if (出力順.contains(識別コード)) {
            出力順 = 出力順.replace(識別コード, 計算後情報_テーブル.concat(識別コード));
        }
        if (出力順.contains(被保険者番号)) {
            出力順 = 出力順.replace(被保険者番号, 計算後情報_テーブル.concat(被保険者番号));
        }
        return 出力順;
    }

    private RString 出力順再設定(RString 出力順) {
        if (出力順.contains(世帯コード)) {
            出力順 = 出力順.replace(世帯コード, 対象外データテンプ_テーブル.concat(賦課_世帯コード));
        }
        if (出力順.contains(識別コード)) {
            出力順 = 出力順.replace(識別コード, 対象外データテンプ_テーブル.concat(賦課_識別コード));
        }
        if (出力順.contains(被保険者番号)) {
            出力順 = 出力順.replace(被保険者番号, 対象外データテンプ_テーブル.concat(賦課_被保険者番号));
        }
        return 出力順;
    }

    private void バッチ出力条件リストの出力(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            LasdecCode 市町村コード, RString 市町村名, RString ページ数, Long 出力順ID) {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(定数_出力条件);
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_調定年度).concat(出力条件_右括弧).concat(
                調定年度.wareki().toDateString()).concat(年度));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_賦課年度).concat(出力条件_右括弧).concat(
                賦課年度.wareki().toDateString()).concat(年度));
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200003.getReportId(), 出力順ID);
        RStringBuilder builder = new RStringBuilder(出力条件_左括弧.concat(定数_出力順).concat(出力条件_右括弧).concat(RString.FULL_SPACE));
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - 1)) {
                    builder.append(iSetSortItem.get項目名());
                } else {
                    builder.append(iSetSortItem.get項目名()).append(SIGN_GT);
                }
            }
        }
        出力条件リスト.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200003.getReportId().value(),
                市町村コード.value(),
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200003.getReportName(),
                ページ数,
                CSV出力有無_有り,
                英数字ファイル名,
                出力条件リスト
        );
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void 特徴平準化対象外CSV項目編集(List<RString> bodyList, YMDHMS 調定日時, FlexibleYear 賦課年度,
            TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外, RString 編集後住所, Decimal 今年度保険料率,
            int 調整金額, RString 編集備考) {
        bodyList.add(調定日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(new RString(調定日時.toString()));
        bodyList.add(タイトル_対象外一覧表);
        bodyList.add(賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString());
        bodyList.add(特徴平準化結果対象外.get通知書番号().value());
        if (特徴平準化結果対象外.get識別コード() != null) {
            bodyList.add(特徴平準化結果対象外.get識別コード().value());
        } else {
            bodyList.add(RString.EMPTY);
        }
        final UaFt200FindShikibetsuTaishoEntity 宛名の情報 = 特徴平準化結果対象外.get宛名の情報();
        if (宛名の情報 != null) {
            GyoseikuCode 行政区コード = 宛名の情報.getGyoseikuCode();
            if (行政区コード != null) {
                bodyList.add(行政区コード.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (編集後住所 != null) {
            bodyList.add(編集後住所);
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaJusho 住所 = 宛名の情報.getJusho();
            if (住所 != null) {
                bodyList.add(住所.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaBanchi 番地 = 宛名の情報.getBanchi();
            if (番地 != null) {
                bodyList.add(番地.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        final RString 特別徴収業務者コード = 特徴平準化結果対象外.get特別徴収業務者コード();
        bodyList.add(特別徴収業務者コード);
        if (特別徴収業務者コード != null) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(特徴平準化結果対象外.get保険料段階仮算定時());
        bodyList.add(DecimalFormatter.toコンマ区切りRString(今年度保険料率, 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(new Decimal(調整金額), 0));
        bodyList.add(編集備考);
        bodyList.add(特徴平準化結果対象外.get被保険者番号().value());
        if (特徴平準化結果対象外.get世帯コード() != null) {
            bodyList.add(特徴平準化結果対象外.get世帯コード().value());
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            ChoikiCode 町域コード = 宛名の情報.getChoikiCode();
            if (町域コード != null) {
                bodyList.add(町域コード.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaMeisho 氏名 = 宛名の情報.getKanjiShimei();
            if (氏名 != null) {
                bodyList.add(氏名.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        RString 仮徴収年金コード = 特徴平準化結果対象外.get仮徴収年金コード();
        bodyList.add(仮徴収年金コード);
        if (仮徴収年金コード != null && (NUM_3 <= 仮徴収年金コード.length())) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(仮徴収年金コード.substring(NUM_0, NUM_3)), FlexibleDate.getNowDate()));
        }
        特徴期期別金額設定(特徴平準化結果対象外, bodyList);
    }

    private void 特徴期期別金額設定(TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外, List<RString> bodyList) {
        if (特徴平準化結果対象外.get特徴期期別金額01() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額01(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額02() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額02(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額03() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額03(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額04() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額04(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額05() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額05(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額06() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額06(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void 特徴平準化対象者CSV項目編集(List<RString> bodyList, YMDHMS 調定日時, FlexibleYear 賦課年度,
            TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者, RString 編集後住所, Decimal 今年度保険料率,
            int 調整金額, RString 編集備考) {
        bodyList.add(調定日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(new RString(調定日時.toString()));
        bodyList.add(タイトル_対象者一覧表);
        bodyList.add(賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString());
        bodyList.add(特徴平準化結果対象者.get通知書番号().value());
        if (特徴平準化結果対象者.get識別コード() != null) {
            bodyList.add(特徴平準化結果対象者.get識別コード().value());
        } else {
            bodyList.add(RString.EMPTY);
        }
        final UaFt200FindShikibetsuTaishoEntity 宛名の情報 = 特徴平準化結果対象者.get宛名の情報();
        if (宛名の情報 != null) {
            GyoseikuCode 行政区コード = 宛名の情報.getGyoseikuCode();
            if (行政区コード != null) {
                bodyList.add(行政区コード.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (編集後住所 != null) {
            bodyList.add(編集後住所);
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaJusho 住所 = 宛名の情報.getJusho();
            if (住所 != null) {
                bodyList.add(住所.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaBanchi 番地 = 宛名の情報.getBanchi();
            if (番地 != null) {
                bodyList.add(番地.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        final RString 特別徴収業務者コード = 特徴平準化結果対象者.get特別徴収業務者コード();
        bodyList.add(特別徴収業務者コード);
        if (特別徴収業務者コード != null) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        変更前特徴額設定(特徴平準化結果対象者, bodyList);
        bodyList.add(特徴平準化結果対象者.get保険料段階仮算定時());
        bodyList.add(DecimalFormatter.toコンマ区切りRString(今年度保険料率, 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(new Decimal(調整金額), 0));
        bodyList.add(編集備考);
        bodyList.add(特徴平準化結果対象者.get被保険者番号().value());
        if (特徴平準化結果対象者.get世帯コード() != null) {
            bodyList.add(特徴平準化結果対象者.get世帯コード().value());
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            ChoikiCode 町域コード = 宛名の情報.getChoikiCode();
            if (町域コード != null) {
                bodyList.add(町域コード.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaMeisho 氏名 = 宛名の情報.getKanjiShimei();
            if (氏名 != null) {
                bodyList.add(氏名.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        RString 仮徴収年金コード = 特徴平準化結果対象者.get仮徴収年金コード();
        bodyList.add(仮徴収年金コード);
        if (仮徴収年金コード != null && (NUM_3 <= 仮徴収年金コード.length())) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(仮徴収年金コード.substring(NUM_0, NUM_3)), FlexibleDate.getNowDate()));
        }
        特徴期期別金額設定(特徴平準化結果対象者, bodyList);
    }

    private void 特徴期期別金額設定(TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者, List<RString> bodyList) {
        if (特徴平準化結果対象者.get特徴期期別金額01() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額01(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額02() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額02(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額03() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額03(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額04() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額04(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額05() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額05(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額06() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額06(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void 変更前特徴額設定(TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者, List<RString> bodyList) {
        if (特徴平準化結果対象者.get変更前特徴額_１期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_１期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_２期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_２期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_３期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_３期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_４期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_４期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_５期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_５期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_６期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_６期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private RString 備考名を転換(RString 編集コード) {
        RString 備考名 = RString.EMPTY;
        if (!RString.isNullOrEmpty(編集コード)) {
            switch (Integer.parseInt(編集コード.toString())) {
                case NUM_1:
                    備考名 = 編集コード_併徴者;
                    break;
                case NUM_2:
                    備考名 = 編集コード_仮徴収額修正者;
                    break;
                case NUM_3:
                    備考名 = 編集コード_仮徴収額修正者;
                    break;
                case NUM_4:
                    備考名 = 編集コード_対象外_減額;
                    break;
                case NUM_5:
                    備考名 = 編集コード_対象外_増額;
                    break;
                case NUM_6:
                    備考名 = 編集コード_特徴6月開始者;
                    break;
                default:
                    break;
            }
            return 備考名;
        }
        return RString.EMPTY;
    }

    private int 調整金額取得(Decimal 今年度保険料率, FlexibleYear 賦課年度) {
        Decimal 調整金額 = 今年度保険料率.divide(NUM_6);
        RString 期別端数 = DbBusinessConfig.get(
                ConfigNameDBB.普通徴収_期別端数, new RDate(賦課年度.getYearValue()), SubGyomuCode.DBB介護賦課);
        int 期別端数int = 0;
        if (!RString.isNullOrEmpty(期別端数)) {
            期別端数int = Integer.parseInt(期別端数.toString());
        }
        return 調整金額.divide(期別端数int).intValue() * 期別端数int;
    }

    private Decimal 今年度保険料率取得(Optional<HokenryoDankai> 保険料段階) {
        Decimal 今年度保険料率 = Decimal.ZERO;
        if (保険料段階.isPresent()) {
            今年度保険料率 = 保険料段階.get().get保険料率();
        }
        return 今年度保険料率;
    }

    private void 特徴平準化計算対象者リスト作成(DbT2015KeisangoJohoEntity 計算後情報前, TokuchoHeijunkaRokuBatchTaishoshaEntity 対象者データ前,
            List<TokuchoHeijunkaRokuBatchTaishoshaEntity> 対象者データ, List<TokuchoHeijyunkaTaishoshaEntity> 特徴平準化結果対象者一覧表リスト, int nextIdx) {
        for (int j = nextIdx; j < 対象者データ.size(); j++) {
            TokuchoHeijunkaRokuBatchTaishoshaEntity 対象者データ後 = 対象者データ.get(j);
            DbT2015KeisangoJohoEntity 計算後情報後 = 対象者データ後.get計算後情報();
            if (計算後情報後 != null && 計算後情報後.getTsuchishoNo().equals(計算後情報前.getTsuchishoNo())) {
                対象者データ.remove(j);
                TokuchoHeijyunkaTaishoshaEntity taishoshaEntity = new TokuchoHeijyunkaTaishoshaEntity();
                特徴平準化計算対象者entity作成(計算後情報前, 対象者データ前, 計算後情報後, 対象者データ後,
                        taishoshaEntity);
                特徴平準化結果対象者一覧表リスト.add(taishoshaEntity);
            }
        }
    }

    private void 特徴平準化計算対象外リスト作成(FukaJohoRelateEntity 対象外データTemp, TokuchoHeijunkaRokuBatchTaishogaiEntity 対象外データ,
            List<TokuchoHeijyunkaTaishogaiEntity> 特徴平準化結果対象外一覧表リスト) {
        FukaJoho 賦課情報 = new FukaJoho(対象外データTemp);
        TokuchoHeijyunkaTaishogaiEntity taishogaiEntity = new TokuchoHeijyunkaTaishogaiEntity();
        taishogaiEntity.set調定年度(賦課情報.get調定年度());
        taishogaiEntity.set賦課年度(賦課情報.get賦課年度());
        taishogaiEntity.set通知書番号(賦課情報.get通知書番号());
        taishogaiEntity.set履歴番号(賦課情報.get履歴番号());
        taishogaiEntity.set被保険者番号(賦課情報.get被保険者番号());
        taishogaiEntity.set識別コード(賦課情報.get識別コード());
        taishogaiEntity.set世帯コード(賦課情報.get世帯コード());
        taishogaiEntity.set世帯員数(賦課情報.get世帯員数());
        taishogaiEntity.set資格取得日(賦課情報.get資格取得日());
        taishogaiEntity.set資格取得事由(賦課情報.get資格取得事由());
        taishogaiEntity.set資格喪失日(賦課情報.get資格喪失日());
        taishogaiEntity.set資格喪失事由(賦課情報.get資格喪失事由());
        taishogaiEntity.set生活保護扶助種類(賦課情報.get生活保護扶助種類());
        taishogaiEntity.set生保開始日(賦課情報.get生保開始日());
        taishogaiEntity.set生保廃止日(賦課情報.get生保廃止日());
        taishogaiEntity.set老齢開始日(賦課情報.get老年開始日());
        taishogaiEntity.set老齢廃止日(賦課情報.get老年廃止日());
        taishogaiEntity.set賦課期日(賦課情報.get賦課期日());
        taishogaiEntity.set課税区分(賦課情報.get課税区分());
        taishogaiEntity.set世帯課税区分(賦課情報.get世帯課税区分());
        taishogaiEntity.set合計所得金額(賦課情報.get合計所得金額());
        taishogaiEntity.set公的年金収入額(賦課情報.get公的年金収入額());
        taishogaiEntity.set保険料段階(賦課情報.get保険料段階());
        taishogaiEntity.set保険料算定段階1(賦課情報.get保険料算定段階1());
        taishogaiEntity.set算定年額保険料1(賦課情報.get算定年額保険料1());
        taishogaiEntity.set月割開始年月1(賦課情報.get月割開始年月1());
        taishogaiEntity.set月割終了年月1(賦課情報.get月割終了年月1());
        taishogaiEntity.set保険料算定段階2(賦課情報.get保険料算定段階2());
        taishogaiEntity.set算定年額保険料2(賦課情報.get算定年額保険料2());
        taishogaiEntity.set月割開始年月2(賦課情報.get月割開始年月2());
        taishogaiEntity.set月割終了年月2(賦課情報.get月割終了年月2());
        taishogaiEntity.set調定日時(賦課情報.get調定日時());
        taishogaiEntity.set調定事由1(賦課情報.get調定事由1());
        taishogaiEntity.set調定事由2(賦課情報.get調定事由2());
        taishogaiEntity.set調定事由3(賦課情報.get調定事由3());
        taishogaiEntity.set調定事由4(賦課情報.get調定事由4());
        taishogaiEntity.set更正月(賦課情報.get更正月());
        taishogaiEntity.set減免前介護保険料年額(賦課情報.get減免前介護保険料_年額());
        taishogaiEntity.set減免額(賦課情報.get減免額());
        taishogaiEntity.set確定介護保険料年額(賦課情報.get確定介護保険料_年額());
        taishogaiEntity.set保険料段階仮算定時(賦課情報.get保険料段階_仮算定時());
        taishogaiEntity.set徴収方法履歴番号(賦課情報.get徴収方法履歴番号());
        taishogaiEntity.set異動基準日時(賦課情報.get異動基準日時());
        taishogaiEntity.set口座区分(賦課情報.get口座区分());
        taishogaiEntity.set境界層区分(賦課情報.get境界層区分());
        taishogaiEntity.set職権区分(賦課情報.get職権区分());
        taishogaiEntity.set賦課市町村コード(賦課情報.get賦課市町村コード());
        taishogaiEntity.set特徴歳出還付額(賦課情報.get特徴歳出還付額());
        taishogaiEntity.set普徴歳出還付額(賦課情報.get普徴歳出還付額());
        taishogaiEntity.set特徴期期別金額01(賦課情報.get特徴期別金額01());
        taishogaiEntity.set特徴期期別金額02(賦課情報.get特徴期別金額02());
        taishogaiEntity.set特徴期期別金額03(賦課情報.get特徴期別金額03());
        taishogaiEntity.set特徴期期別金額04(賦課情報.get特徴期別金額04());
        taishogaiEntity.set特徴期期別金額05(賦課情報.get特徴期別金額05());
        taishogaiEntity.set特徴期期別金額06(賦課情報.get特徴期別金額06());
        taishogaiEntity.set普徴期期別金額01(賦課情報.get普徴期別金額01());
        taishogaiEntity.set普徴期期別金額02(賦課情報.get普徴期別金額02());
        taishogaiEntity.set普徴期期別金額03(賦課情報.get普徴期別金額03());
        taishogaiEntity.set普徴期期別金額04(賦課情報.get普徴期別金額04());
        taishogaiEntity.set普徴期期別金額05(賦課情報.get普徴期別金額05());
        taishogaiEntity.set普徴期期別金額06(賦課情報.get普徴期別金額06());
        taishogaiEntity.set普徴期期別金額07(賦課情報.get普徴期別金額07());
        taishogaiEntity.set普徴期期別金額08(賦課情報.get普徴期別金額08());
        taishogaiEntity.set普徴期期別金額09(賦課情報.get普徴期別金額09());
        taishogaiEntity.set普徴期期別金額10(賦課情報.get普徴期別金額10());
        taishogaiEntity.set普徴期期別金額11(賦課情報.get普徴期別金額11());
        taishogaiEntity.set普徴期期別金額12(賦課情報.get普徴期別金額12());
        taishogaiEntity.set普徴期期別金額13(賦課情報.get普徴期別金額13());
        taishogaiEntity.set普徴期期別金額14(賦課情報.get普徴期別金額14());
        taishogaiEntity.set備考コード(対象外データ.get備考コード());
        taishogaiEntity.set仮徴収年金コード(対象外データ.get徴収方法Newest_仮徴収_年金コード());
        taishogaiEntity.set宛名の情報(対象外データ.get宛名());
        taishogaiEntity.set特別徴収業務者コード(対象外データ.get特別徴収義務者コード());
        taishogaiEntity.set平準化済フラグ(false);
        特徴平準化結果対象外一覧表リスト.add(taishogaiEntity);
    }

    private void 特徴平準化計算対象者entity作成(DbT2015KeisangoJohoEntity 計算後情報前, TokuchoHeijunkaRokuBatchTaishoshaEntity 対象者データ前,
            DbT2015KeisangoJohoEntity 計算後情報後, TokuchoHeijunkaRokuBatchTaishoshaEntity 対象者データ後,
            TokuchoHeijyunkaTaishoshaEntity taishoshaEntity) {
        if (更正前後区分_更正前.equals(計算後情報前.getKoseiZengoKubun())) {
            変更後項目設定(taishoshaEntity, 計算後情報後, 対象者データ後);
            taishoshaEntity.set平準化済フラグ(true);
            変更前項目設定(taishoshaEntity, 計算後情報前);
        } else if (更正前後区分_更正前.equals(計算後情報後.getKoseiZengoKubun())) {
            変更後項目設定(taishoshaEntity, 計算後情報前, 対象者データ前);
            taishoshaEntity.set平準化済フラグ(false);
            変更前項目設定(taishoshaEntity, 計算後情報後);
        }
        taishoshaEntity.set備考コード(RString.EMPTY);
    }

    private void 変更後項目設定(TokuchoHeijyunkaTaishoshaEntity taishoshaEntity,
            DbT2015KeisangoJohoEntity 計算後情報, TokuchoHeijunkaRokuBatchTaishoshaEntity 対象者データ) {
        taishoshaEntity.set調定年度(計算後情報.getChoteiNendo());
        taishoshaEntity.set賦課年度(計算後情報.getFukaNendo());
        taishoshaEntity.set通知書番号(計算後情報.getTsuchishoNo());
        taishoshaEntity.set更正前後区分(計算後情報.getKoseiZengoKubun());
        taishoshaEntity.set作成処理名(計算後情報.getSakuseiShoriName());
        taishoshaEntity.set賦課履歴番号(計算後情報.getFukaRirekiNo());
        taishoshaEntity.set被保険者番号(計算後情報.getHihokenshaNo());
        taishoshaEntity.set識別コード(計算後情報.getShikibetsuCode());
        taishoshaEntity.set世帯コード(計算後情報.getSetaiCode());
        taishoshaEntity.set世帯員数(計算後情報.getSetaiInsu());
        taishoshaEntity.set資格取得日(計算後情報.getShikakuShutokuYMD());
        taishoshaEntity.set資格取得事由(計算後情報.getShikakuShutokuJiyu());
        taishoshaEntity.set資格喪失日(計算後情報.getShikakuSoshitsuYMD());
        taishoshaEntity.set資格喪失事由(計算後情報.getShikakuSoshitsuJiyu());
        taishoshaEntity.set生活保護扶助種類(計算後情報.getSeihofujoShurui());
        taishoshaEntity.set生保開始日(計算後情報.getSeihoKaishiYMD());
        taishoshaEntity.set生保廃止日(計算後情報.getSeihoHaishiYMD());
        taishoshaEntity.set老齢開始日(計算後情報.getRonenKaishiYMD());
        taishoshaEntity.set老齢廃止日(計算後情報.getRonenHaishiYMD());
        taishoshaEntity.set賦課期日(計算後情報.getFukaYMD());
        taishoshaEntity.set課税区分(計算後情報.getKazeiKubun());
        taishoshaEntity.set世帯課税区分(計算後情報.getSetaikazeiKubun());
        taishoshaEntity.set合計所得金額(計算後情報.getGokeiShotokuGaku());
        taishoshaEntity.set公的年金収入額(計算後情報.getNenkinShunyuGaku());
        taishoshaEntity.set保険料段階(計算後情報.getHokenryoDankai());
        taishoshaEntity.set保険料算定段階1(計算後情報.getHokenryoDankai1());
        taishoshaEntity.set算定年額保険料1(計算後情報.getNengakuHokenryo1());
        taishoshaEntity.set月割開始年月1(計算後情報.getTsukiwariStartYM1());
        taishoshaEntity.set月割終了年月1(計算後情報.getTsukiwariEndYM1());
        taishoshaEntity.set保険料算定段階2(計算後情報.getHokenryoDankai2());
        taishoshaEntity.set算定年額保険料2(計算後情報.getNengakuHokenryo2());
        taishoshaEntity.set月割開始年月2(計算後情報.getTsukiwariStartYM2());
        taishoshaEntity.set月割終了年月2(計算後情報.getTsukiwariEndYM2());
        taishoshaEntity.set調定日時(計算後情報.getChoteiNichiji());
        taishoshaEntity.set調定事由1(計算後情報.getChoteiJiyu1());
        taishoshaEntity.set調定事由2(計算後情報.getChoteiJiyu2());
        taishoshaEntity.set調定事由3(計算後情報.getChoteiJiyu3());
        taishoshaEntity.set調定事由4(計算後情報.getChoteiJiyu4());
        taishoshaEntity.set更正月(計算後情報.getKoseiM());
        taishoshaEntity.set減免前介護保険料年額(計算後情報.getGemmenMaeHokenryo());
        taishoshaEntity.set減免額(計算後情報.getGemmenGaku());
        taishoshaEntity.set確定介護保険料年額(計算後情報.getKakuteiHokenryo());
        taishoshaEntity.set保険料段階仮算定時(計算後情報.getHokenryoDankaiKarisanntei());
        taishoshaEntity.set徴収方法履歴番号(計算後情報.getChoshuHohoRirekiNo());
        taishoshaEntity.set異動基準日時(計算後情報.getIdoKijunNichiji());
        taishoshaEntity.set口座区分(計算後情報.getKozaKubun());
        taishoshaEntity.set境界層区分(計算後情報.getKyokaisoKubun());
        taishoshaEntity.set職権区分(計算後情報.getShokkenKubun());
        taishoshaEntity.set賦課市町村コード(計算後情報.getFukaShichosonCode());
        taishoshaEntity.set特徴歳出還付額(計算後情報.getTkSaishutsuKampuGaku());
        taishoshaEntity.set普徴歳出還付額(計算後情報.getFuSaishutsuKampuGaku());
        taishoshaEntity.set特徴期期別金額01(計算後情報.getTkKibetsuGaku01());
        taishoshaEntity.set特徴期期別金額02(計算後情報.getTkKibetsuGaku02());
        taishoshaEntity.set特徴期期別金額03(計算後情報.getTkKibetsuGaku03());
        taishoshaEntity.set特徴期期別金額04(計算後情報.getTkKibetsuGaku04());
        taishoshaEntity.set特徴期期別金額05(計算後情報.getTkKibetsuGaku05());
        taishoshaEntity.set特徴期期別金額06(計算後情報.getTkKibetsuGaku06());
        taishoshaEntity.set普徴期期別金額01(計算後情報.getFuKibetsuGaku01());
        taishoshaEntity.set普徴期期別金額02(計算後情報.getFuKibetsuGaku02());
        taishoshaEntity.set普徴期期別金額03(計算後情報.getFuKibetsuGaku03());
        taishoshaEntity.set普徴期期別金額04(計算後情報.getFuKibetsuGaku04());
        taishoshaEntity.set普徴期期別金額05(計算後情報.getFuKibetsuGaku05());
        taishoshaEntity.set普徴期期別金額06(計算後情報.getFuKibetsuGaku06());
        taishoshaEntity.set普徴期期別金額07(計算後情報.getFuKibetsuGaku07());
        taishoshaEntity.set普徴期期別金額08(計算後情報.getFuKibetsuGaku08());
        taishoshaEntity.set普徴期期別金額09(計算後情報.getFuKibetsuGaku09());
        taishoshaEntity.set普徴期期別金額10(計算後情報.getFuKibetsuGaku10());
        taishoshaEntity.set普徴期期別金額11(計算後情報.getFuKibetsuGaku11());
        taishoshaEntity.set普徴期期別金額12(計算後情報.getFuKibetsuGaku12());
        taishoshaEntity.set普徴期期別金額13(計算後情報.getFuKibetsuGaku13());
        taishoshaEntity.set普徴期期別金額14(計算後情報.getFuKibetsuGaku14());
        taishoshaEntity.set徴収方法4月(計算後情報.getChoshuHoho4gatsu());
        taishoshaEntity.set徴収方法5月(計算後情報.getChoshuHoho5gatsu());
        taishoshaEntity.set徴収方法6月(計算後情報.getChoshuHoho6gatsu());
        taishoshaEntity.set徴収方法7月(計算後情報.getChoshuHoho7gatsu());
        taishoshaEntity.set徴収方法8月(計算後情報.getChoshuHoho8gatsu());
        taishoshaEntity.set徴収方法9月(計算後情報.getChoshuHoho9gatsu());
        taishoshaEntity.set徴収方法10月(計算後情報.getChoshuHoho10gatsu());
        taishoshaEntity.set徴収方法11月(計算後情報.getChoshuHoho11gatsu());
        taishoshaEntity.set徴収方法12月(計算後情報.getChoshuHoho12gatsu());
        taishoshaEntity.set徴収方法1月(計算後情報.getChoshuHoho1gatsu());
        taishoshaEntity.set徴収方法2月(計算後情報.getChoshuHoho2gatsu());
        taishoshaEntity.set徴収方法3月(計算後情報.getChoshuHoho3gatsu());
        taishoshaEntity.set徴収方法翌4月(計算後情報.getChoshuHohoYoku4gatsu());
        taishoshaEntity.set徴収方法翌5月(計算後情報.getChoshuHohoYoku5gatsu());
        taishoshaEntity.set徴収方法翌6月(計算後情報.getChoshuHohoYoku6gatsu());
        taishoshaEntity.set徴収方法翌7月(計算後情報.getChoshuHohoYoku7gatsu());
        taishoshaEntity.set徴収方法翌8月(計算後情報.getChoshuHohoYoku8gatsu());
        taishoshaEntity.set徴収方法翌9月(計算後情報.getChoshuHohoYoku9gatsu());
        taishoshaEntity.set仮徴収基礎年金番号(計算後情報.getKariNenkinNo());
        taishoshaEntity.set仮徴収年金コード(計算後情報.getKariNenkinCode());
        taishoshaEntity.set仮徴収捕捉月(計算後情報.getKariHosokuM());
        taishoshaEntity.set本徴収基礎年金番号(計算後情報.getHonNenkinNo());
        taishoshaEntity.set本徴収年金コード(計算後情報.getHonNenkinCode());
        taishoshaEntity.set本徴収捕捉月(計算後情報.getHonHosokuM());
        taishoshaEntity.set翌年度仮徴収基礎年金番号(計算後情報.getYokunendoKariNenkinNo());
        taishoshaEntity.set翌年度仮徴収年金コード(計算後情報.getYokunendoKariNenkinCode());
        taishoshaEntity.set翌年度仮徴収捕捉月(計算後情報.getYokunendoKariHosokuM());
        taishoshaEntity.set依頼情報送付済みフラグ(計算後情報.getIraiSohuzumiFlag());
        taishoshaEntity.set追加依頼情報送付済みフラグ(計算後情報.getTsuikaIraiSohuzumiFlag());
        taishoshaEntity.set特別徴収停止日時(計算後情報.getTokuchoTeishiNichiji());
        taishoshaEntity.set特別徴収停止事由コード(計算後情報.getTokuchoTeishiJiyuCode());
        taishoshaEntity.set特徴収入額01(計算後情報.getTkShunyuGaku01());
        taishoshaEntity.set特徴収入額02(計算後情報.getTkShunyuGaku02());
        taishoshaEntity.set特徴収入額03(計算後情報.getTkShunyuGaku03());
        taishoshaEntity.set特徴収入額04(計算後情報.getTkShunyuGaku04());
        taishoshaEntity.set特徴収入額05(計算後情報.getTkShunyuGaku05());
        taishoshaEntity.set特徴収入額06(計算後情報.getTkShunyuGaku06());
        taishoshaEntity.set普徴収入額01(計算後情報.getFuShunyuGaku01());
        taishoshaEntity.set普徴収入額02(計算後情報.getFuShunyuGaku02());
        taishoshaEntity.set普徴収入額03(計算後情報.getFuShunyuGaku03());
        taishoshaEntity.set普徴収入額04(計算後情報.getFuShunyuGaku04());
        taishoshaEntity.set普徴収入額05(計算後情報.getFuShunyuGaku05());
        taishoshaEntity.set普徴収入額06(計算後情報.getFuShunyuGaku06());
        taishoshaEntity.set普徴収入額07(計算後情報.getFuShunyuGaku07());
        taishoshaEntity.set普徴収入額08(計算後情報.getFuShunyuGaku08());
        taishoshaEntity.set普徴収入額09(計算後情報.getFuShunyuGaku09());
        taishoshaEntity.set普徴収入額10(計算後情報.getFuShunyuGaku10());
        taishoshaEntity.set普徴収入額11(計算後情報.getFuShunyuGaku11());
        taishoshaEntity.set普徴収入額12(計算後情報.getFuShunyuGaku12());
        taishoshaEntity.set普徴収入額13(計算後情報.getFuShunyuGaku13());
        taishoshaEntity.set普徴収入額14(計算後情報.getFuShunyuGaku14());
        taishoshaEntity.set宛名の情報(対象者データ.get宛名());
        taishoshaEntity.set特別徴収業務者コード(対象者データ.get特別徴収義務者コード());
    }

    private void 変更前項目設定(TokuchoHeijyunkaTaishoshaEntity taishoshaEntity,
            DbT2015KeisangoJohoEntity 計算後情報) {
        taishoshaEntity.set変更前特徴額_１期(計算後情報.getTkKibetsuGaku01());
        taishoshaEntity.set変更前特徴額_２期(計算後情報.getTkKibetsuGaku02());
        taishoshaEntity.set変更前特徴額_３期(計算後情報.getTkKibetsuGaku03());
        taishoshaEntity.set変更前特徴額_４期(計算後情報.getTkKibetsuGaku04());
        taishoshaEntity.set変更前特徴額_５期(計算後情報.getTkKibetsuGaku05());
        taishoshaEntity.set変更前特徴額_６期(計算後情報.getTkKibetsuGaku06());
    }

    private void 特徴期別金額設定(FukaJoho fukaJoho, TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity 平準化計算結果,
            FukaJohoBuilder builder, Map<Long, Long> 調定IDMap) {
        List<Kibetsu> kibetsuList = fukaJoho.getKibetsuList();
        for (Kibetsu 介護期別 : kibetsuList) {
            for (ChoteiKyotsu 調定共通情報 : 介護期別.getChoteiKyotsuList()) {
                Long 調定ID = 調定共通情報.get調定ID();
                if (!調定IDMap.containsKey(調定ID)) {
                    ChoteiKyotsuBuilder 調定共通builder = 調定共通情報.createBuilderForEdit();
                    調定IDMap.put(調定ID, 調定ID);
                    調定共通期より調定額の設定(介護期別, 調定共通builder, 平準化計算結果);
                    調定共通情報 = 調定共通builder.build();
                    介護期別 = 介護期別.createBuilderForEdit().setKibetsu(調定共通情報).build();
                    UrT0705ChoteiKyotsuEntity 調定共通Entity = 調定共通情報.toEntity();
                    調定共通Entity.setState(EntityDataState.Modified);
                    urT0705ChoteiKyotsuDac.save(調定共通Entity);
                    DbT2003KibetsuEntity 介護期別Entity = 介護期別.toEntity();
                    介護期別Entity.setRirekiNo(介護期別Entity.getRirekiNo() + 1);
                    dbT2003KibetsuDac.save(介護期別Entity);
                    builder.setKibetsu(介護期別);
                }
            }
        }
    }

    private void 調定共通期より調定額の設定(Kibetsu 介護期別, ChoteiKyotsuBuilder 調定共通builder,
            TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity 平準化計算結果) {
        if (NUM_期1 == 介護期別.get期()) {
            調定共通builder.set調定額(平準化計算結果.get変更後特徴期別額_１期());
        } else if (NUM_期2 == 介護期別.get期()) {
            調定共通builder.set調定額(平準化計算結果.get変更後特徴期別額_２期());
        } else if (NUM_期3 == 介護期別.get期()) {
            調定共通builder.set調定額(平準化計算結果.get変更後特徴期別額_３期());
        }
    }

    private Decimal 普徴期別金額取得(int 仮算定期間_期, FukaJoho fukaJoho) {
        Decimal 普徴期別金額 = Decimal.ZERO;
        switch (仮算定期間_期) {
            case 仮算定期間_期1:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額01());
                break;
            case 仮算定期間_期2:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額02());
                break;
            case 仮算定期間_期3:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額03());
                break;
            case 仮算定期間_期4:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額04());
                break;
            case 仮算定期間_期5:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額05());
                break;
            case 仮算定期間_期6:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額06());
                break;
            case 仮算定期間_期7:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額07());
                break;
            case 仮算定期間_期8:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額08());
                break;
            case 仮算定期間_期9:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額09());
                break;
            case 仮算定期間_期10:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額10());
                break;
            case 仮算定期間_期11:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額11());
                break;
            case 仮算定期間_期12:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額12());
                break;
            case 仮算定期間_期13:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額13());
                break;
            case 仮算定期間_期14:
                普徴期別金額 = get普徴期別金額合計(普徴期別金額, fukaJoho.get普徴期別金額14());
                break;
            default:
                break;
        }
        return 普徴期別金額;
    }

    private Decimal get普徴期別金額合計(Decimal 普徴期別金額合計, Decimal 普徴期別金額) {
        if (普徴期別金額 != null) {
            普徴期別金額合計 = 普徴期別金額合計.add(普徴期別金額);
        }
        return 普徴期別金額合計;
    }

    /**
     * 処理日付管理テーブル更新
     *
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @param システム日時 YMDHMS
     */
    public void update処理日付管理(RString 処理名, RString 処理枝番, FlexibleYear 年度, RString 年度内連番, YMDHMS システム日時) {
        List<DbT7022ShoriDateKanriEntity> entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                処理名, 処理枝番, 年度, 年度内連番);
        if (entityList != null) {
            update処理日付管理(entityList, システム日時);
        }
    }

    private void update処理日付管理(List<DbT7022ShoriDateKanriEntity> entityList, YMDHMS システム日時) {
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.setKijunTimestamp(システム日時);
            entity.setState(EntityDataState.Modified);
            処理日付管理Dac.save(entity);
        }
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = NUM_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }
}
