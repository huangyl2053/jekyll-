/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * ビジネス設計_DBBBZ33001_1_特徴仮算定賦課（バッチ）
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
public class TokuchoKariSanteiFukaManager {

    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200002");
    private static final RString EUCファイル名 = new RString("TokubetsuChoshuKarisanteiKekkaIchiranData.csv");
    private static final ReportId 特別徴収仮算定結果一覧表_帳票分類ID = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int 整数_0 = 0;
    private static final int 整数_1 = 1;
    private static final int 整数_3 = 3;
    private static final RString 継続 = new RString("継続");
    private static final RString 開始月_6月 = new RString("6月");
    private static final RString 特徴停止 = new RString("特徴停止");
    private static final CodeShubetsu コード_0008 = new CodeShubetsu("0008");
    private static final CodeShubetsu コード_0046 = new CodeShubetsu("0046");
    private static final CodeShubetsu コード_0047 = new CodeShubetsu("0047");

    /**
     * コンストラクタです。
     */
    TokuchoKariSanteiFukaManager() {
        帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mProvider mProvider
     */
    TokuchoKariSanteiFukaManager(DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac) {
        this.帳票制御共通Dac = 帳票制御共通Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFukaManagerBatch}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFukaManagerBatch}のインスタンス
     */
    public static TokuchoKariSanteiFukaManager createInstance() {
        return InstanceProvider.create(TokuchoKariSanteiFukaManager.class);
    }

    /**
     * 特別徴収開始通知書発行一覧表
     *
     * @param 特徴仮算定計算後賦課情報EntityList List<TokuchoKariKeisangoFukaEntity>
     * @param 調定日時 YMDHMS
     */
    public void publish特別徴収開始通知書発行一覧表(List<TokuchoKariKeisangoFukaEntity> 特徴仮算定計算後賦課情報EntityList,
            YMDHMS 調定日時) {
        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(false)
                .build()) {
            int i = 整数_1;
            for (TokuchoKariKeisangoFukaEntity entity : 特徴仮算定計算後賦課情報EntityList) {
                List<RString> bodyList = new ArrayList<>();
                bodyList.add(new RString(String.valueOf(i)));
                if (調定日時 == null || 調定日時.isEmpty()) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(調定日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
                    bodyList.add(調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                }
                if (isNull(entity.get宛名())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(get郵便番号(entity.get宛名().getYubinNo()));
                    IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
                    ChohyoSeigyoKyotsu 帳票制御共通情報 = load帳票制御共通(特別徴収仮算定結果一覧表_帳票分類ID);
                    RString 住所編集 = JushoHenshu.editJusho(帳票制御共通情報, 宛名情報,
                            AssociationFinderFactory.createInstance().getAssociation());
                    bodyList.add(住所編集);
                    bodyList.add(get住所(entity.get宛名().getJusho()));
                    bodyList.add(get番地(entity.get宛名().getBanchi()));
                    bodyList.add(get行政区コード(entity.get宛名().getGyoseikuCode()));
                    bodyList.add(entity.get宛名().getGyoseikuName());
                    bodyList.add(get生年月日(entity.get宛名().getSeinengappiYMD()));
                    bodyList.add(宛名情報.get性別().getCommonName());
                }
                RString 特別徴収停止事由コード = entity.get特別徴収停止事由コード();
                Decimal 特徴期期別金額01 = entity.get特徴期期別金額01();
                Decimal 特徴期期別金額02 = entity.get特徴期期別金額02();
                Decimal 特徴期期別金額03 = entity.get特徴期期別金額03();
                bodyList.add(get開始月(特別徴収停止事由コード, 特徴期期別金額01, 特徴期期別金額02, 特徴期期別金額03));
                RString 前年度保険料段階 = entity.get前年度保険料段階();
                HokenryoDankaiList 保険料段階リスト = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
                bodyList.add(保険料段階リスト.getBy段階区分(前年度保険料段階).get表記());
                RString 前年度保険料 = DecimalFormatter.toコンマ区切りRString(保険料段階リスト.getBy段階区分(前年度保険料段階).get保険料率(), 整数_0);
                bodyList.add(前年度保険料);
                bodyList.add(get通知書番号(entity.get通知書番号()));
                bodyList.add(get世帯コード(entity.get世帯コード()));
                bodyList.add(get漢字氏名(entity.get宛名().getKanjiShimei()));
                bodyList.add(get特別徴収業務者コード(entity.get特別徴収義務者コード()));
                if (entity.get特別徴収義務者コード() != null) {
                    bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, コード_0047, entity.get特別徴収義務者コード()));
                } else {
                    bodyList.add(RString.EMPTY);
                }
                bodyList.add(entity.get仮徴収_年金コード());
                RString 特別徴収対象年金コード = RString.EMPTY;
                if (entity.get仮徴収_年金コード() != null && !entity.get仮徴収_年金コード().isEmpty()) {
                    特別徴収対象年金コード = entity.get仮徴収_年金コード().substring(整数_0, 整数_3);
                }
                if (特別徴収対象年金コード != null) {
                    bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, コード_0046, new Code(特別徴収対象年金コード)));
                } else {
                    bodyList.add(RString.EMPTY);
                }
                if (entity.get特別徴収停止事由コード() == null || entity.get特別徴収停止事由コード().isEmpty()) {
                    set特徴期期別金額01(entity, bodyList);
                    set特徴期期別金額02(entity, bodyList);
                    set特徴期期別金額03(entity, bodyList);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(特徴停止);
                    if (entity.get特別徴収停止事由コード() != null) {
                        bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, コード_0008, new Code(entity.get特別徴収停止事由コード())));
                    } else {
                        bodyList.add(RString.EMPTY);
                    }
                }
                for (int j = 整数_0; j < bodyList.size(); j++) {
                    if (bodyList.get(j) == null) {
                        bodyList.remove(bodyList.get(j));
                        bodyList.add(j, RString.EMPTY);
                    }
                }
                i++;
                csvListWriter.writeLine(bodyList);
            }
            csvListWriter.close();
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        }
    }

    private void set特徴期期別金額03(TokuchoKariKeisangoFukaEntity entity, List<RString> bodyList) {
        if (entity.get特徴期期別金額03() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(entity.get特徴期期別金額03(), 整数_0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void set特徴期期別金額02(TokuchoKariKeisangoFukaEntity entity, List<RString> bodyList) {
        if (entity.get特徴期期別金額02() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(entity.get特徴期期別金額02(), 整数_0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void set特徴期期別金額01(TokuchoKariKeisangoFukaEntity entity, List<RString> bodyList) {
        if (entity.get特徴期期別金額01() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(entity.get特徴期期別金額01(), 整数_0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private boolean isNull(Object 項目) {
        return 項目 == null;
    }

    private RString get郵便番号(YubinNo 郵便番号) {
        if (郵便番号 == null) {
            return RString.EMPTY;
        }
        return 郵便番号.value();
    }

    private RString get住所(AtenaJusho 住所) {
        if (住所 == null) {
            return RString.EMPTY;
        }
        return 住所.value();
    }

    private RString get番地(AtenaBanchi 番地) {
        if (番地 == null) {
            return RString.EMPTY;
        }
        return 番地.value();
    }

    private RString get行政区コード(GyoseikuCode 行政区コード) {
        if (行政区コード == null) {
            return RString.EMPTY;
        }
        return 行政区コード.value();
    }

    private RString get生年月日(FlexibleDate 生年月日) {
        if (生年月日 == null) {
            return RString.EMPTY;
        }
        return new RString(生年月日.toString());
    }

    private RString get開始月(RString 特別徴収停止事由コード,
            Decimal 特徴期期別金額01,
            Decimal 特徴期期別金額02,
            Decimal 特徴期期別金額03) {
        if (特別徴収停止事由コード == null || 特別徴収停止事由コード.isEmpty()) {
            if (set開始月_継続(特徴期期別金額01, 特徴期期別金額02, 特徴期期別金額03)) {
                return 継続;
            }
            if (set開始月_6月(特徴期期別金額01, 特徴期期別金額02, 特徴期期別金額03)) {
                return 開始月_6月;
            }
        }
        return RString.EMPTY;
    }

    private boolean set開始月_6月(Decimal 特徴期期別金額01, Decimal 特徴期期別金額02, Decimal 特徴期期別金額03) {
        if (特徴期期別金額01 != null && 特徴期期別金額02 != null && 特徴期期別金額03 != null && 特徴期期別金額01.equals(Decimal.ZERO)
                && 特徴期期別金額02.intValue() > 整数_0 && 特徴期期別金額03.intValue() > 整数_0) {
            return true;
        }
        return false;
    }

    private boolean set開始月_継続(Decimal 特徴期期別金額01, Decimal 特徴期期別金額02, Decimal 特徴期期別金額03) {
        if (特徴期期別金額01 != null && 特徴期期別金額02 != null && 特徴期期別金額03 != null && 特徴期期別金額01.intValue() > 整数_0
                && 特徴期期別金額02.intValue() > 整数_0 && 特徴期期別金額03.intValue() > 整数_0) {
            return true;
        }
        return false;
    }

    private RString get通知書番号(TsuchishoNo 通知書番号) {
        if (通知書番号 == null) {
            return RString.EMPTY;
        }
        return 通知書番号.value();
    }

    private RString get世帯コード(SetaiCode 世帯コード) {
        if (世帯コード == null) {
            return RString.EMPTY;
        }
        return 世帯コード.value();
    }

    private RString get漢字氏名(AtenaMeisho 漢字氏名) {
        if (漢字氏名 == null) {
            return RString.EMPTY;
        }
        return 漢字氏名.value();
    }

    private RString get特別徴収業務者コード(Code 特別徴収業務者コード) {
        if (特別徴収業務者コード == null) {
            return RString.EMPTY;
        }
        return 特別徴収業務者コード.value();
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類Id) throws NullPointerException {
        requireNonNull(帳票分類Id, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類Id.toString()));

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類Id);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }
}
