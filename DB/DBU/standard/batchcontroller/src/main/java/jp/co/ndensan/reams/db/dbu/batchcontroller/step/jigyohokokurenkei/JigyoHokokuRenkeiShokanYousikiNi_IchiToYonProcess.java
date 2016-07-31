/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.IJigyoHokokuRenkeiEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei24or26EucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiFooterEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiHead2EucCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 様式別連携情報作成のバッチ処理・保険給付決定状況現物分に対応するのCSV出力のプロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkeiShokanYousikiNi_IchiToYonProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

    private RString myBatisSelsectId;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("JigyoHokokuRenkeiEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private static final RString H1 = new RString("H1");
    private static final RString 国民健康保険団体連合会 = new RString("国民健康保険団体連合会");
    private static final RString 番号_1 = new RString("1");
    private static final RString 番号_2 = new RString("2");
    private static final RString 番号_3 = new RString("3");
    private static final RString 番号_4 = new RString("4");
    private static final RString 番号_5 = new RString("5");
    private static final RString 番号_6 = new RString("6");
    private static final RString 番号_7 = new RString("7");
    private static final RString 番号_8 = new RString("8");
    private static final RString 番号_9 = new RString("9");
    private static final RString 番号_10 = new RString("10");
    private static final RString 番号_11 = new RString("11");
    private static final RString 番号_12 = new RString("12");
    private static final RString 番号_13 = new RString("13");
    private static final RString 番号_14 = new RString("14");
    private static final RString 番号_15 = new RString("15");
    private static final RString 番号_16 = new RString("16");
    private static final RString 番号_17 = new RString("17");
    private static final RString 番号_18 = new RString("18");
    private static final RString 番号_19 = new RString("19");
    private static final RString 番号_20 = new RString("20");
    private static final RString 番号_21 = new RString("21");
    private static final RString 番号_22 = new RString("22");
    private static final RString 番号_23 = new RString("23");
    private static final RString 番号_24 = new RString("24");
    private static final RString 番号_25 = new RString("25");
    private static final RString 番号_26 = new RString("26");
    private static final RString 番号_27 = new RString("27");
    private static final RString 番号_28 = new RString("28");
    private static final RString 番号_29 = new RString("29");
    private static final RString 番号_30 = new RString("30");
    private static final RString 番号_31 = new RString("31");
    private static final RString 番号_32 = new RString("32");
    private static final RString 番号_33 = new RString("33");
    private static final RString 番号_34 = new RString("34");
    private static final RString 番号_35 = new RString("35");
    private static final RString 番号_36 = new RString("36");
    private static final RString 集計番号_0101 = new RString("0101");
    private static final RString 集計番号_0102 = new RString("0102");
    private static final RString 集計番号_0103 = new RString("0103");
    private static final RString 集計番号_0104 = new RString("0104");
    private static final RString 集計番号_0201 = new RString("0201");
    private static final RString 集計番号_0202 = new RString("0202");
    private static final RString 集計番号_0203 = new RString("0203");
    private static final RString 集計番号_0204 = new RString("0204");
    private static final RString 集計番号_0301 = new RString("0301");
    private static final RString 集計番号_0302 = new RString("0302");
    private static final RString 集計番号_0303 = new RString("0303");
    private static final RString 集計番号_0304 = new RString("0304");
    private static final RString 集計番号_0401 = new RString("0401");
    private static final RString 集計番号_0402 = new RString("0402");
    private static final RString 集計番号_0403 = new RString("0403");
    private static final RString 集計番号_0404 = new RString("0404");
    private static final RString ア_件数 = new RString("ア　件数");
    private static final RString イ_単位数 = new RString("イ　単位数");
    private static final RString ウ_費用額 = new RString("ウ　費用額");
    private static final RString エ_給付費 = new RString("エ　給付費");
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_件数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_単位数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_費用額_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_給付費_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_件数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_単位数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_費用額_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_給付費_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_件数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_単位数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_費用額_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 総数_再掲_給付費_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_件数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_単位数_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_費用額_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_居宅介護_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_訪問サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_訪問入浴介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_訪問看護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_訪問リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_居宅療養管理指導Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_通所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_通所リハビリテーションEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_短期入所サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_短期入所生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_短期入所療養_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_短期入所療養_介護療養型医療施設等Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_福祉用具住宅改修サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_福祉用具貸与Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_福祉用具購入費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_住宅改修費Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_特定施設入居者生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_介護予防支援居宅介護支援Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_地域密着型_介護予防Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_夜間対応型訪問介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_認知症対応型通所介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_小規模多機能型居宅介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_認知症対応型共同生活介護Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_地域密着型特定施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_地域密着型介護老人福祉Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_施設サービスEntity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_介護老人福祉施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_介護老人保健施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_介護療養型医療施設Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private final JigyoHokokuRenkei24or26EucCsvEntity 第２号_再掲_給付費_総計Entity = new JigyoHokokuRenkei24or26EucCsvEntity();
    private RString csvFileName;
    private RDate 基準日;
    private JigyoHokokuRenkeiProcessParameter processParameter;
    private final JigyoHokokuRenkei24or26EucCsvEntity eucCsvEntity = new JigyoHokokuRenkei24or26EucCsvEntity();

    @Override
    protected void initialize() {
        if (processParameter.is出力_保険給付決定状況償還分_審査年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get保険給付決定状況償還分審査年月情報の取得");
        }
        if (processParameter.is出力_保険給付決定状況償還分_決定年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get保険給付決定状況償還分決定年月情報の取得");
        }
        csvFileName = new RString("DUJRENF10_" + processParameter.get過去集計年月()
                + "_" + DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援) + ".csv");
    }

    @BatchWriter
    private EucCsvWriter<IJigyoHokokuRenkeiEucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(myBatisSelsectId, processParameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, csvFileName);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).
                build();
    }

    @Override
    protected void process(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get総数_件数のデータ編集(entity);
        get総数_単位数のデータ編集(entity);
        get総数_費用額のデータ編集(entity);
        get総数_給付費のデータ編集(entity);
        get第２号被保険者分_再掲_件数のデータ編集(entity);
        get第２号被保険者分_再掲_単位数のデータ編集(entity);
        get第２号被保険者分_再掲_費用額のデータ編集(entity);
        get第２号被保険者分_再掲_給付費のデータ編集(entity);
        get総数_再掲_特例分_件数のデータ編集(entity);
        get総数_再掲_特例分_単位数のデータ編集(entity);
        get総数_再掲_特例分_費用額のデータ編集(entity);
        get総数_再掲_特例分_給付費のデータ編集(entity);
        get第２号被保険者分_再掲_特例分_件数のデータ編集(entity);
        get第２号被保険者分_再掲_特例分_単位数のデータ編集(entity);
        get第２号被保険者分_再掲_特例分_費用額のデータ編集(entity);
        get第２号被保険者分_再掲_特例分_給付費のデータ編集(entity);
    }

    @Override
    protected void afterExecute() {
        get様式２_様式２の４のCSV出力();
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    private void get様式２_様式２の４のCSV出力() {
        eucCsvWriter.writeLine(setヘッダレコード(ア_件数, イ_単位数));
        get総数_件数のCSV出力();
        get総数_単位数のCSV出力();
        eucCsvWriter.writeLine(setヘッダレコード(ウ_費用額, エ_給付費));
        get総数_費用額のCSV出力();
        get総数_給付費のCSV出力();
        eucCsvWriter.writeLine(setヘッダレコード(ア_件数, イ_単位数));
        get第２号被保険者分_再掲_件数のCSV出力();
        get第２号被保険者分_再掲_単位数のCSV出力();
        eucCsvWriter.writeLine(setヘッダレコード(ウ_費用額, エ_給付費));
        get第２号被保険者分_再掲_費用額のCSV出力();
        get第２号被保険者分_再掲_給付費のCSV出力();
        eucCsvWriter.writeLine(setヘッダレコード(ア_件数, イ_単位数));
        get総数_再掲_特例分_件数のCSV出力();
        get総数_再掲_特例分_単位数のCSV出力();
        eucCsvWriter.writeLine(setヘッダレコード(ウ_費用額, エ_給付費));
        get総数_再掲_特例分_費用額のCSV出力();
        get総数_再掲_特例分_給付費のCSV出力();
        eucCsvWriter.writeLine(setヘッダレコード(ア_件数, イ_単位数));
        get第２号被保険者分_再掲_特例分_件数のCSV出力();
        get第２号被保険者分_再掲_特例分_単位数のCSV出力();
        eucCsvWriter.writeLine(setヘッダレコード(ウ_費用額, エ_給付費));
        get第２号被保険者分_再掲_特例分_費用額のCSV出力();
        get第２号被保険者分_再掲_特例分_給付費のCSV出力();
        eucCsvWriter.writeLine(set終了レコード());
    }

    private JigyoHokokuRenkeiHead2EucCsvEntity setヘッダレコード(RString 先頭項目_件数, RString 先頭項目_給付費) {
        return new JigyoHokokuRenkeiHead2EucCsvEntity(
                先頭項目_件数,
                先頭項目_給付費,
                RString.EMPTY,
                H1,
                dateFomart(new RString(processParameter.get過去集計年月() + "01")),
                dateFomart(RDate.getNowDate().toDateString()),
                国民健康保険団体連合会,
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援),
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, 基準日, SubGyomuCode.DBE認定支援)
        );
    }

    private JigyoHokokuRenkeiFooterEucCsvEntity set終了レコード() {
        return new JigyoHokokuRenkeiFooterEucCsvEntity(
                RString.EMPTY,
                new RString("E")
        );
    }

    private void get総数_件数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_件数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_件数_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_件数_訪問介護Entity);
        eucCsvWriter.writeLine(総数_件数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_件数_訪問看護Entity);
        eucCsvWriter.writeLine(総数_件数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_件数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_件数_通所サービスEntity);
        eucCsvWriter.writeLine(総数_件数_通所介護Entity);
        eucCsvWriter.writeLine(総数_件数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_件数_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_件数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_件数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_件数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_件数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_件数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_件数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_件数_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_件数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_件数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_件数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_件数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_件数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_件数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_件数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_件数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_件数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_件数_施設サービスEntity);
        eucCsvWriter.writeLine(総数_件数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_件数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_件数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_件数_総計Entity);
    }

    private void get総数_単位数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_単位数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_単位数_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_単位数_訪問介護Entity);
        eucCsvWriter.writeLine(総数_単位数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_単位数_訪問看護Entity);
        eucCsvWriter.writeLine(総数_単位数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_単位数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_単位数_通所サービスEntity);
        eucCsvWriter.writeLine(総数_単位数_通所介護Entity);
        eucCsvWriter.writeLine(総数_単位数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_単位数_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_単位数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_単位数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_単位数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_単位数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_単位数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_単位数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_単位数_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_単位数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_単位数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_単位数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_単位数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_単位数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_単位数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_単位数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_単位数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_単位数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_単位数_施設サービスEntity);
        eucCsvWriter.writeLine(総数_単位数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_単位数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_単位数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_単位数_総計Entity);
    }

    private void get総数_費用額のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_費用額_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_費用額_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_費用額_訪問介護Entity);
        eucCsvWriter.writeLine(総数_費用額_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_費用額_訪問看護Entity);
        eucCsvWriter.writeLine(総数_費用額_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_費用額_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_費用額_通所サービスEntity);
        eucCsvWriter.writeLine(総数_費用額_通所介護Entity);
        eucCsvWriter.writeLine(総数_費用額_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_費用額_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_費用額_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_費用額_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_費用額_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_費用額_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_費用額_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_費用額_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_費用額_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_費用額_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_費用額_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_費用額_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_費用額_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_費用額_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_費用額_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_費用額_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_費用額_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_費用額_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_費用額_施設サービスEntity);
        eucCsvWriter.writeLine(総数_費用額_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_費用額_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_費用額_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_費用額_総計Entity);
    }

    private void get総数_給付費のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_給付費_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_給付費_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_給付費_訪問介護Entity);
        eucCsvWriter.writeLine(総数_給付費_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_給付費_訪問看護Entity);
        eucCsvWriter.writeLine(総数_給付費_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_給付費_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_給付費_通所サービスEntity);
        eucCsvWriter.writeLine(総数_給付費_通所介護Entity);
        eucCsvWriter.writeLine(総数_給付費_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_給付費_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_給付費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_給付費_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_給付費_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_給付費_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_給付費_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_給付費_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_給付費_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_給付費_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_給付費_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_給付費_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_給付費_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_給付費_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_給付費_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_給付費_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_給付費_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_給付費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_給付費_施設サービスEntity);
        eucCsvWriter.writeLine(総数_給付費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_給付費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_給付費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_給付費_総計Entity);
    }

    private void get第２号被保険者分_再掲_件数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_件数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_件数_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_件数_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_件数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_件数_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_件数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_件数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_件数_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_件数_通所介護Entity);
        eucCsvWriter.writeLine(第２号_件数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_件数_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_件数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_件数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_件数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_件数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_件数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_件数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_件数_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_件数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_件数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_件数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_件数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_件数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_件数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_件数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_件数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_件数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_件数_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_件数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_件数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_件数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_件数_総計Entity);
    }

    private void get第２号被保険者分_再掲_単位数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_単位数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_単位数_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_単位数_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_単位数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_単位数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_単位数_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_単位数_通所介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_単位数_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_単位数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_単位数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_単位数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_単位数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_単位数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_単位数_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_単位数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_単位数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_単位数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_単位数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_単位数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_単位数_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_単位数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_単位数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_単位数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_単位数_総計Entity);
    }

    private void get第２号被保険者分_再掲_費用額のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_費用額_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_費用額_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_費用額_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_費用額_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_費用額_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_費用額_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_費用額_通所介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_費用額_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_費用額_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_費用額_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_費用額_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_費用額_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_費用額_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_費用額_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_費用額_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_費用額_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_費用額_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_費用額_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_費用額_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_費用額_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_費用額_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_費用額_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_費用額_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_費用額_総計Entity);
    }

    private void get第２号被保険者分_再掲_給付費のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_給付費_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_給付費_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_給付費_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_給付費_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_給付費_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_給付費_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_給付費_通所介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_給付費_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_給付費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_給付費_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_給付費_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_給付費_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_給付費_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_給付費_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_給付費_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_給付費_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_給付費_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_給付費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_総計Entity);
    }

    private void get総数_再掲_特例分_件数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_訪問看護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_通所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_施設サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_件数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_再掲_件数_総計Entity);
    }

    private void get総数_再掲_特例分_単位数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_訪問看護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_通所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_施設サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_単位数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_再掲_単位数_総計Entity);
    }

    private void get総数_再掲_特例分_費用額のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_訪問看護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_通所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_施設サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_費用額_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_再掲_費用額_総計Entity);
    }

    private void get総数_再掲_特例分_給付費のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_訪問サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_訪問入浴介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_訪問看護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_通所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_短期入所サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_福祉用具貸与Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_福祉用具購入費Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_住宅改修費Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_施設サービスEntity);
        eucCsvWriter.writeLine(総数_再掲_給付費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(総数_再掲_給付費_総計Entity);
    }

    private void get第２号被保険者分_再掲_特例分_件数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_件数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_件数_総計Entity);
    }

    private void get第２号被保険者分_再掲_特例分_単位数のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_単位数_総計Entity);
    }

    private void get第２号被保険者分_再掲_特例分_費用額のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_費用額_総計Entity);
    }

    private void get第２号被保険者分_再掲_特例分_給付費のCSV出力() {
        eucCsvWriter.writeLine(eucCsvEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_居宅介護_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_訪問サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_訪問入浴介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_訪問看護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_訪問リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_居宅療養管理指導Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_通所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_通所リハビリテーションEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_短期入所サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_短期入所療養_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_短期入所療養_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_福祉用具住宅改修サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_福祉用具貸与Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_福祉用具購入費Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_住宅改修費Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_特定施設入居者生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_介護予防支援居宅介護支援Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_地域密着型_介護予防Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_夜間対応型訪問介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_認知症対応型通所介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_小規模多機能型居宅介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_認知症対応型共同生活介護Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_地域密着型特定施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_施設サービスEntity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_再掲_給付費_総計Entity);
    }

    private void get総数_件数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_15, 総数_件数_居宅介護_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_1, 総数_件数_訪問サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_16, 総数_件数_訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_17, 総数_件数_訪問入浴介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_18, 総数_件数_訪問看護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_19, 総数_件数_訪問リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_26, 総数_件数_居宅療養管理指導Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_30, 総数_件数_通所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_20, 総数_件数_通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_21, 総数_件数_通所リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_2, 総数_件数_短期入所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_23, 総数_件数_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_24, 総数_件数_短期入所療養_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_25, 総数_件数_短期入所療養_介護療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_3, 総数_件数_福祉用具住宅改修サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_22, 総数_件数_福祉用具貸与Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_4, 総数_件数_福祉用具購入費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_5, 総数_件数_住宅改修費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_28, 総数_件数_特定施設入居者生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_29, 総数_件数_介護予防支援居宅介護支援Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_31, 総数_件数_地域密着型_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_32, 総数_件数_夜間対応型訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_33, 総数_件数_認知症対応型通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_34, 総数_件数_小規模多機能型居宅介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_27, 総数_件数_認知症対応型共同生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_35, 総数_件数_地域密着型特定施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_36, 総数_件数_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_6, 総数_件数_施設サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_7, 総数_件数_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_8, 総数_件数_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_9, 総数_件数_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0101, 番号_14, 総数_件数_総計Entity, ア_件数);
    }

    private void get総数_単位数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_15, 総数_単位数_居宅介護_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_1, 総数_単位数_訪問サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_16, 総数_単位数_訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_17, 総数_単位数_訪問入浴介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_18, 総数_単位数_訪問看護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_19, 総数_単位数_訪問リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_26, 総数_単位数_居宅療養管理指導Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_30, 総数_単位数_通所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_20, 総数_単位数_通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_21, 総数_単位数_通所リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_2, 総数_単位数_短期入所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_23, 総数_単位数_短期入所生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_24, 総数_単位数_短期入所療養_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_25, 総数_単位数_短期入所療養_介護療養型医療施設等Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_3, 総数_単位数_福祉用具住宅改修サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_22, 総数_単位数_福祉用具貸与Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_4, 総数_単位数_福祉用具購入費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_5, 総数_単位数_住宅改修費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_28, 総数_単位数_特定施設入居者生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_29, 総数_単位数_介護予防支援居宅介護支援Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_31, 総数_単位数_地域密着型_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_32, 総数_単位数_夜間対応型訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_33, 総数_単位数_認知症対応型通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_34, 総数_単位数_小規模多機能型居宅介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_27, 総数_単位数_認知症対応型共同生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_35, 総数_単位数_地域密着型特定施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_36, 総数_単位数_地域密着型介護老人福祉Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_6, 総数_単位数_施設サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_7, 総数_単位数_介護老人福祉施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_8, 総数_単位数_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_9, 総数_単位数_介護療養型医療施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0102, 番号_14, 総数_単位数_総計Entity, イ_単位数);
    }

    private void get総数_費用額のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_15, 総数_費用額_居宅介護_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_1, 総数_費用額_訪問サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_16, 総数_費用額_訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_17, 総数_費用額_訪問入浴介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_18, 総数_費用額_訪問看護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_19, 総数_費用額_訪問リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_26, 総数_費用額_居宅療養管理指導Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_30, 総数_費用額_通所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_20, 総数_費用額_通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_21, 総数_費用額_通所リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_2, 総数_費用額_短期入所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_23, 総数_費用額_短期入所生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_24, 総数_費用額_短期入所療養_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_25, 総数_費用額_短期入所療養_介護療養型医療施設等Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_3, 総数_費用額_福祉用具住宅改修サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_22, 総数_費用額_福祉用具貸与Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_4, 総数_費用額_福祉用具購入費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_5, 総数_費用額_住宅改修費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_28, 総数_費用額_特定施設入居者生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_29, 総数_費用額_介護予防支援居宅介護支援Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_31, 総数_費用額_地域密着型_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_32, 総数_費用額_夜間対応型訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_33, 総数_費用額_認知症対応型通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_34, 総数_費用額_小規模多機能型居宅介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_27, 総数_費用額_認知症対応型共同生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_35, 総数_費用額_地域密着型特定施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_36, 総数_費用額_地域密着型介護老人福祉Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_6, 総数_費用額_施設サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_7, 総数_費用額_介護老人福祉施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_8, 総数_費用額_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_9, 総数_費用額_介護療養型医療施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0103, 番号_14, 総数_費用額_総計Entity, ウ_費用額);
    }

    private void get総数_給付費のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_15, 総数_給付費_居宅介護_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_1, 総数_給付費_訪問サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_16, 総数_給付費_訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_17, 総数_給付費_訪問入浴介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_18, 総数_給付費_訪問看護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_19, 総数_給付費_訪問リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_26, 総数_給付費_居宅療養管理指導Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_30, 総数_給付費_通所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_20, 総数_給付費_通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_21, 総数_給付費_通所リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_2, 総数_給付費_短期入所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_23, 総数_給付費_短期入所生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_24, 総数_給付費_短期入所療養_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_25, 総数_給付費_短期入所療養_介護療養型医療施設等Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_3, 総数_給付費_福祉用具住宅改修サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_22, 総数_給付費_福祉用具貸与Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_4, 総数_給付費_福祉用具購入費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_5, 総数_給付費_住宅改修費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_28, 総数_給付費_特定施設入居者生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_29, 総数_給付費_介護予防支援居宅介護支援Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_31, 総数_給付費_地域密着型_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_32, 総数_給付費_夜間対応型訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_33, 総数_給付費_認知症対応型通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_34, 総数_給付費_小規模多機能型居宅介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_27, 総数_給付費_認知症対応型共同生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_35, 総数_給付費_地域密着型特定施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_36, 総数_給付費_地域密着型介護老人福祉Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_6, 総数_給付費_施設サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_7, 総数_給付費_介護老人福祉施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_8, 総数_給付費_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_9, 総数_給付費_介護療養型医療施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0104, 番号_14, 総数_給付費_総計Entity, エ_給付費);
    }

    private void get第２号被保険者分_再掲_件数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_15, 第２号_件数_居宅介護_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_1, 第２号_件数_訪問サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_16, 第２号_件数_訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_17, 第２号_件数_訪問入浴介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_18, 第２号_件数_訪問看護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_19, 第２号_件数_訪問リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_26, 第２号_件数_居宅療養管理指導Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_30, 第２号_件数_通所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_20, 第２号_件数_通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_21, 第２号_件数_通所リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_2, 第２号_件数_短期入所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_23, 第２号_件数_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_24, 第２号_件数_短期入所療養_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_25, 第２号_件数_短期入所療養_介護療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_3, 第２号_件数_福祉用具住宅改修サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_22, 第２号_件数_福祉用具貸与Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_4, 第２号_件数_福祉用具購入費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_5, 第２号_件数_住宅改修費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_28, 第２号_件数_特定施設入居者生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_29, 第２号_件数_介護予防支援居宅介護支援Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_31, 第２号_件数_地域密着型_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_32, 第２号_件数_夜間対応型訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_33, 第２号_件数_認知症対応型通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_34, 第２号_件数_小規模多機能型居宅介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_27, 第２号_件数_認知症対応型共同生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_35, 第２号_件数_地域密着型特定施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_36, 第２号_件数_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_6, 第２号_件数_施設サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_7, 第２号_件数_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_8, 第２号_件数_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_9, 第２号_件数_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0201, 番号_14, 第２号_件数_総計Entity, ア_件数);
    }

    private void get第２号被保険者分_再掲_単位数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_15, 第２号_単位数_居宅介護_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_1, 第２号_単位数_訪問サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_16, 第２号_単位数_訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_17, 第２号_単位数_訪問入浴介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_18, 第２号_単位数_訪問看護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_19, 第２号_単位数_訪問リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_26, 第２号_単位数_居宅療養管理指導Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_30, 第２号_単位数_通所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_20, 第２号_単位数_通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_21, 第２号_単位数_通所リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_2, 第２号_単位数_短期入所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_23, 第２号_単位数_短期入所生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_24, 第２号_単位数_短期入所療養_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_25, 第２号_単位数_短期入所療養_介護療養型医療施設等Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_3, 第２号_単位数_福祉用具住宅改修サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_22, 第２号_単位数_福祉用具貸与Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_4, 第２号_単位数_福祉用具購入費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_5, 第２号_単位数_住宅改修費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_28, 第２号_単位数_特定施設入居者生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_29, 第２号_単位数_介護予防支援居宅介護支援Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_31, 第２号_単位数_地域密着型_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_32, 第２号_単位数_夜間対応型訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_33, 第２号_単位数_認知症対応型通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_34, 第２号_単位数_小規模多機能型居宅介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_27, 第２号_単位数_認知症対応型共同生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_35, 第２号_単位数_地域密着型特定施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_36, 第２号_単位数_地域密着型介護老人福祉Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_6, 第２号_単位数_施設サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_7, 第２号_単位数_介護老人福祉施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_8, 第２号_単位数_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_9, 第２号_単位数_介護療養型医療施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0202, 番号_14, 第２号_単位数_総計Entity, イ_単位数);
    }

    private void get第２号被保険者分_再掲_費用額のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_15, 第２号_費用額_居宅介護_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_1, 第２号_費用額_訪問サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_16, 第２号_費用額_訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_17, 第２号_費用額_訪問入浴介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_18, 第２号_費用額_訪問看護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_19, 第２号_費用額_訪問リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_26, 第２号_費用額_居宅療養管理指導Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_30, 第２号_費用額_通所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_20, 第２号_費用額_通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_21, 第２号_費用額_通所リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_2, 第２号_費用額_短期入所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_23, 第２号_費用額_短期入所生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_24, 第２号_費用額_短期入所療養_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_25, 第２号_費用額_短期入所療養_介護療養型医療施設等Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_3, 第２号_費用額_福祉用具住宅改修サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_22, 第２号_費用額_福祉用具貸与Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_4, 第２号_費用額_福祉用具購入費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_5, 第２号_費用額_住宅改修費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_28, 第２号_費用額_特定施設入居者生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_29, 第２号_費用額_介護予防支援居宅介護支援Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_31, 第２号_費用額_地域密着型_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_32, 第２号_費用額_夜間対応型訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_33, 第２号_費用額_認知症対応型通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_34, 第２号_費用額_小規模多機能型居宅介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_27, 第２号_費用額_認知症対応型共同生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_35, 第２号_費用額_地域密着型特定施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_36, 第２号_費用額_地域密着型介護老人福祉Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_6, 第２号_費用額_施設サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_7, 第２号_費用額_介護老人福祉施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_8, 第２号_費用額_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_9, 第２号_費用額_介護療養型医療施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0203, 番号_14, 第２号_費用額_総計Entity, ウ_費用額);
    }

    private void get第２号被保険者分_再掲_給付費のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_15, 第２号_給付費_居宅介護_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_1, 第２号_給付費_訪問サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_16, 第２号_給付費_訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_17, 第２号_給付費_訪問入浴介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_18, 第２号_給付費_訪問看護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_19, 第２号_給付費_訪問リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_26, 第２号_給付費_居宅療養管理指導Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_30, 第２号_給付費_通所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_20, 第２号_給付費_通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_21, 第２号_給付費_通所リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_2, 第２号_給付費_短期入所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_23, 第２号_給付費_短期入所生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_24, 第２号_給付費_短期入所療養_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_25, 第２号_給付費_短期入所療養_介護療養型医療施設等Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_3, 第２号_給付費_福祉用具住宅改修サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_22, 第２号_給付費_福祉用具貸与Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_4, 第２号_給付費_福祉用具購入費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_5, 第２号_給付費_住宅改修費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_28, 第２号_給付費_特定施設入居者生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_29, 第２号_給付費_介護予防支援居宅介護支援Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_31, 第２号_給付費_地域密着型_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_32, 第２号_給付費_夜間対応型訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_33, 第２号_給付費_認知症対応型通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_34, 第２号_給付費_小規模多機能型居宅介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_27, 第２号_給付費_認知症対応型共同生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_35, 第２号_給付費_地域密着型特定施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_36, 第２号_給付費_地域密着型介護老人福祉Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_6, 第２号_給付費_施設サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_7, 第２号_給付費_介護老人福祉施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_8, 第２号_給付費_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_9, 第２号_給付費_介護療養型医療施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0204, 番号_14, 第２号_給付費_総計Entity, エ_給付費);
    }

    private void get総数_再掲_特例分_件数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_15, 総数_再掲_件数_居宅介護_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_1, 総数_再掲_件数_訪問サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_16, 総数_再掲_件数_訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_17, 総数_再掲_件数_訪問入浴介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_18, 総数_再掲_件数_訪問看護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_19, 総数_再掲_件数_訪問リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_26, 総数_再掲_件数_居宅療養管理指導Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_30, 総数_再掲_件数_通所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_20, 総数_再掲_件数_通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_21, 総数_再掲_件数_通所リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_2, 総数_再掲_件数_短期入所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_23, 総数_再掲_件数_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_24, 総数_再掲_件数_短期入所療養_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_25, 総数_再掲_件数_短期入所療養_介護療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_3, 総数_再掲_件数_福祉用具住宅改修サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_22, 総数_再掲_件数_福祉用具貸与Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_4, 総数_再掲_件数_福祉用具購入費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_5, 総数_再掲_件数_住宅改修費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_28, 総数_再掲_件数_特定施設入居者生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_29, 総数_再掲_件数_介護予防支援居宅介護支援Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_31, 総数_再掲_件数_地域密着型_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_32, 総数_再掲_件数_夜間対応型訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_33, 総数_再掲_件数_認知症対応型通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_34, 総数_再掲_件数_小規模多機能型居宅介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_27, 総数_再掲_件数_認知症対応型共同生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_35, 総数_再掲_件数_地域密着型特定施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_36, 総数_再掲_件数_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_6, 総数_再掲_件数_施設サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_7, 総数_再掲_件数_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_8, 総数_再掲_件数_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_9, 総数_再掲_件数_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0301, 番号_14, 総数_再掲_件数_総計Entity, ア_件数);
    }

    private void get総数_再掲_特例分_単位数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_15, 総数_再掲_単位数_居宅介護_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_1, 総数_再掲_単位数_訪問サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_16, 総数_再掲_単位数_訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_17, 総数_再掲_単位数_訪問入浴介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_18, 総数_再掲_単位数_訪問看護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_19, 総数_再掲_単位数_訪問リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_26, 総数_再掲_単位数_居宅療養管理指導Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_30, 総数_再掲_単位数_通所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_20, 総数_再掲_単位数_通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_21, 総数_再掲_単位数_通所リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_2, 総数_再掲_単位数_短期入所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_23, 総数_再掲_単位数_短期入所生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_24, 総数_再掲_単位数_短期入所療養_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_25, 総数_再掲_単位数_短期入所療養_介護療養型医療施設等Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_3, 総数_再掲_単位数_福祉用具住宅改修サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_22, 総数_再掲_単位数_福祉用具貸与Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_4, 総数_再掲_単位数_福祉用具購入費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_5, 総数_再掲_単位数_住宅改修費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_28, 総数_再掲_単位数_特定施設入居者生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_29, 総数_再掲_単位数_介護予防支援居宅介護支援Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_31, 総数_再掲_単位数_地域密着型_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_32, 総数_再掲_単位数_夜間対応型訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_33, 総数_再掲_単位数_認知症対応型通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_34, 総数_再掲_単位数_小規模多機能型居宅介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_27, 総数_再掲_単位数_認知症対応型共同生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_35, 総数_再掲_単位数_地域密着型特定施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_36, 総数_再掲_単位数_地域密着型介護老人福祉Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_6, 総数_再掲_単位数_施設サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_7, 総数_再掲_単位数_介護老人福祉施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_8, 総数_再掲_単位数_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_9, 総数_再掲_単位数_介護療養型医療施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0302, 番号_14, 総数_再掲_単位数_総計Entity, イ_単位数);
    }

    private void get総数_再掲_特例分_費用額のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_15, 総数_再掲_費用額_居宅介護_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_1, 総数_再掲_費用額_訪問サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_16, 総数_再掲_費用額_訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_17, 総数_再掲_費用額_訪問入浴介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_18, 総数_再掲_費用額_訪問看護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_19, 総数_再掲_費用額_訪問リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_26, 総数_再掲_費用額_居宅療養管理指導Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_30, 総数_再掲_費用額_通所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_20, 総数_再掲_費用額_通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_21, 総数_再掲_費用額_通所リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_2, 総数_再掲_費用額_短期入所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_23, 総数_再掲_費用額_短期入所生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_24, 総数_再掲_費用額_短期入所療養_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_25, 総数_再掲_費用額_短期入所療養_介護療養型医療施設等Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_3, 総数_再掲_費用額_福祉用具住宅改修サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_22, 総数_再掲_費用額_福祉用具貸与Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_4, 総数_再掲_費用額_福祉用具購入費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_5, 総数_再掲_費用額_住宅改修費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_28, 総数_再掲_費用額_特定施設入居者生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_29, 総数_再掲_費用額_介護予防支援居宅介護支援Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_31, 総数_再掲_費用額_地域密着型_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_32, 総数_再掲_費用額_夜間対応型訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_33, 総数_再掲_費用額_認知症対応型通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_34, 総数_再掲_費用額_小規模多機能型居宅介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_27, 総数_再掲_費用額_認知症対応型共同生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_35, 総数_再掲_費用額_地域密着型特定施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_36, 総数_再掲_費用額_地域密着型介護老人福祉Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_6, 総数_再掲_費用額_施設サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_7, 総数_再掲_費用額_介護老人福祉施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_8, 総数_再掲_費用額_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_9, 総数_再掲_費用額_介護療養型医療施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0303, 番号_14, 総数_再掲_費用額_総計Entity, ウ_費用額);
    }

    private void get総数_再掲_特例分_給付費のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_15, 総数_再掲_給付費_居宅介護_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_1, 総数_再掲_給付費_訪問サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_16, 総数_再掲_給付費_訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_17, 総数_再掲_給付費_訪問入浴介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_18, 総数_再掲_給付費_訪問看護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_19, 総数_再掲_給付費_訪問リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_26, 総数_再掲_給付費_居宅療養管理指導Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_30, 総数_再掲_給付費_通所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_20, 総数_再掲_給付費_通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_21, 総数_再掲_給付費_通所リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_2, 総数_再掲_給付費_短期入所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_23, 総数_再掲_給付費_短期入所生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_24, 総数_再掲_給付費_短期入所療養_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_25, 総数_再掲_給付費_短期入所療養_介護療養型医療施設等Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_3, 総数_再掲_給付費_福祉用具住宅改修サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_22, 総数_再掲_給付費_福祉用具貸与Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_4, 総数_再掲_給付費_福祉用具購入費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_5, 総数_再掲_給付費_住宅改修費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_28, 総数_再掲_給付費_特定施設入居者生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_29, 総数_再掲_給付費_介護予防支援居宅介護支援Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_31, 総数_再掲_給付費_地域密着型_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_32, 総数_再掲_給付費_夜間対応型訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_33, 総数_再掲_給付費_認知症対応型通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_34, 総数_再掲_給付費_小規模多機能型居宅介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_27, 総数_再掲_給付費_認知症対応型共同生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_35, 総数_再掲_給付費_地域密着型特定施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_36, 総数_再掲_給付費_地域密着型介護老人福祉Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_6, 総数_再掲_給付費_施設サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_7, 総数_再掲_給付費_介護老人福祉施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_8, 総数_再掲_給付費_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_9, 総数_再掲_給付費_介護療養型医療施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0304, 番号_14, 総数_再掲_給付費_総計Entity, エ_給付費);
    }

    private void get第２号被保険者分_再掲_特例分_件数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_15, 第２号_再掲_件数_居宅介護_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_1, 第２号_再掲_件数_訪問サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_16, 第２号_再掲_件数_訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_17, 第２号_再掲_件数_訪問入浴介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_18, 第２号_再掲_件数_訪問看護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_19, 第２号_再掲_件数_訪問リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_26, 第２号_再掲_件数_居宅療養管理指導Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_30, 第２号_再掲_件数_通所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_20, 第２号_再掲_件数_通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_21, 第２号_再掲_件数_通所リハビリテーションEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_2, 第２号_再掲_件数_短期入所サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_23, 第２号_再掲_件数_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_24, 第２号_再掲_件数_短期入所療養_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_25, 第２号_再掲_件数_短期入所療養_介護療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_3, 第２号_再掲_件数_福祉用具住宅改修サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_22, 第２号_再掲_件数_福祉用具貸与Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_4, 第２号_再掲_件数_福祉用具購入費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_5, 第２号_再掲_件数_住宅改修費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_28, 第２号_再掲_件数_特定施設入居者生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_29, 第２号_再掲_件数_介護予防支援居宅介護支援Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_31, 第２号_再掲_件数_地域密着型_介護予防Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_32, 第２号_再掲_件数_夜間対応型訪問介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_33, 第２号_再掲_件数_認知症対応型通所介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_34, 第２号_再掲_件数_小規模多機能型居宅介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_27, 第２号_再掲_件数_認知症対応型共同生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_35, 第２号_再掲_件数_地域密着型特定施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_36, 第２号_再掲_件数_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_6, 第２号_再掲_件数_施設サービスEntity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_7, 第２号_再掲_件数_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_8, 第２号_再掲_件数_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_9, 第２号_再掲_件数_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0401, 番号_14, 第２号_再掲_件数_総計Entity, ア_件数);
    }

    private void get第２号被保険者分_再掲_特例分_単位数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_15, 第２号_再掲_単位数_居宅介護_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_1, 第２号_再掲_単位数_訪問サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_16, 第２号_再掲_単位数_訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_17, 第２号_再掲_単位数_訪問入浴介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_18, 第２号_再掲_単位数_訪問看護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_19, 第２号_再掲_単位数_訪問リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_26, 第２号_再掲_単位数_居宅療養管理指導Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_30, 第２号_再掲_単位数_通所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_20, 第２号_再掲_単位数_通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_21, 第２号_再掲_単位数_通所リハビリテーションEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_2, 第２号_再掲_単位数_短期入所サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_23, 第２号_再掲_単位数_短期入所生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_24, 第２号_再掲_単位数_短期入所療養_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_25, 第２号_再掲_単位数_短期入所療養_介護療養型医療施設等Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_3, 第２号_再掲_単位数_福祉用具住宅改修サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_22, 第２号_再掲_単位数_福祉用具貸与Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_4, 第２号_再掲_単位数_福祉用具購入費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_5, 第２号_再掲_単位数_住宅改修費Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_28, 第２号_再掲_単位数_特定施設入居者生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_29, 第２号_再掲_単位数_介護予防支援居宅介護支援Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_31, 第２号_再掲_単位数_地域密着型_介護予防Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_32, 第２号_再掲_単位数_夜間対応型訪問介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_33, 第２号_再掲_単位数_認知症対応型通所介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_34, 第２号_再掲_単位数_小規模多機能型居宅介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_27, 第２号_再掲_単位数_認知症対応型共同生活介護Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_35, 第２号_再掲_単位数_地域密着型特定施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_36, 第２号_再掲_単位数_地域密着型介護老人福祉Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_6, 第２号_再掲_単位数_施設サービスEntity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_7, 第２号_再掲_単位数_介護老人福祉施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_8, 第２号_再掲_単位数_介護老人保健施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_9, 第２号_再掲_単位数_介護療養型医療施設Entity, イ_単位数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0402, 番号_14, 第２号_再掲_単位数_総計Entity, イ_単位数);
    }

    private void get第２号被保険者分_再掲_特例分_費用額のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_15, 第２号_再掲_費用額_居宅介護_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_1, 第２号_再掲_費用額_訪問サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_16, 第２号_再掲_費用額_訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_17, 第２号_再掲_費用額_訪問入浴介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_18, 第２号_再掲_費用額_訪問看護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_19, 第２号_再掲_費用額_訪問リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_26, 第２号_再掲_費用額_居宅療養管理指導Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_30, 第２号_再掲_費用額_通所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_20, 第２号_再掲_費用額_通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_21, 第２号_再掲_費用額_通所リハビリテーションEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_2, 第２号_再掲_費用額_短期入所サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_23, 第２号_再掲_費用額_短期入所生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_24, 第２号_再掲_費用額_短期入所療養_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_25, 第２号_再掲_費用額_短期入所療養_介護療養型医療施設等Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_3, 第２号_再掲_費用額_福祉用具住宅改修サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_22, 第２号_再掲_費用額_福祉用具貸与Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_4, 第２号_再掲_費用額_福祉用具購入費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_5, 第２号_再掲_費用額_住宅改修費Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_28, 第２号_再掲_費用額_特定施設入居者生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_29, 第２号_再掲_費用額_介護予防支援居宅介護支援Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_31, 第２号_再掲_費用額_地域密着型_介護予防Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_32, 第２号_再掲_費用額_夜間対応型訪問介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_33, 第２号_再掲_費用額_認知症対応型通所介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_34, 第２号_再掲_費用額_小規模多機能型居宅介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_27, 第２号_再掲_費用額_認知症対応型共同生活介護Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_35, 第２号_再掲_費用額_地域密着型特定施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_36, 第２号_再掲_費用額_地域密着型介護老人福祉Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_6, 第２号_再掲_費用額_施設サービスEntity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_7, 第２号_再掲_費用額_介護老人福祉施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_8, 第２号_再掲_費用額_介護老人保健施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_9, 第２号_再掲_費用額_介護療養型医療施設Entity, ウ_費用額);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0403, 番号_14, 第２号_再掲_費用額_総計Entity, ウ_費用額);
    }

    private void get第２号被保険者分_再掲_特例分_給付費のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_15, 第２号_再掲_給付費_居宅介護_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_1, 第２号_再掲_給付費_訪問サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_16, 第２号_再掲_給付費_訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_17, 第２号_再掲_給付費_訪問入浴介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_18, 第２号_再掲_給付費_訪問看護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_19, 第２号_再掲_給付費_訪問リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_26, 第２号_再掲_給付費_居宅療養管理指導Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_30, 第２号_再掲_給付費_通所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_20, 第２号_再掲_給付費_通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_21, 第２号_再掲_給付費_通所リハビリテーションEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_2, 第２号_再掲_給付費_短期入所サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_23, 第２号_再掲_給付費_短期入所生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_24, 第２号_再掲_給付費_短期入所療養_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_25, 第２号_再掲_給付費_短期入所療養_介護療養型医療施設等Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_3, 第２号_再掲_給付費_福祉用具住宅改修サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_22, 第２号_再掲_給付費_福祉用具貸与Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_4, 第２号_再掲_給付費_福祉用具購入費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_5, 第２号_再掲_給付費_住宅改修費Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_28, 第２号_再掲_給付費_特定施設入居者生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_29, 第２号_再掲_給付費_介護予防支援居宅介護支援Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_31, 第２号_再掲_給付費_地域密着型_介護予防Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_32, 第２号_再掲_給付費_夜間対応型訪問介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_33, 第２号_再掲_給付費_認知症対応型通所介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_34, 第２号_再掲_給付費_小規模多機能型居宅介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_27, 第２号_再掲_給付費_認知症対応型共同生活介護Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_35, 第２号_再掲_給付費_地域密着型特定施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_36, 第２号_再掲_給付費_地域密着型介護老人福祉Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_6, 第２号_再掲_給付費_施設サービスEntity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_7, 第２号_再掲_給付費_介護老人福祉施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_8, 第２号_再掲_給付費_介護老人保健施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_9, 第２号_再掲_給付費_介護療養型医療施設Entity, エ_給付費);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0404, 番号_14, 第２号_再掲_給付費_総計Entity, エ_給付費);
    }

    private void get様式２から様式２の６のデータ編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号,
            RString 縦番号,
            JigyoHokokuRenkei24or26EucCsvEntity eucCsvEntity, RString 先頭項目) {
        eucCsvEntity.setレコード種別番号(new RString("D1"));
        eucCsvEntity.set交換情報識別番号(RString.EMPTY);
        eucCsvEntity.set先頭項目(先頭項目);
        if (集計番号.equals(entity.getShukeiNo().getColumnValue()) && 縦番号.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要支援１(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要支援２(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set計_予防給付(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set経過的要介護(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護１(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護２(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護３(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護４(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護５(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set計_介護給付(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set計(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
    }

    private RString dateFomart(RString 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        FlexibleDate flexibleDate = new FlexibleDate(年月日);
        return flexibleDate.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }
}
