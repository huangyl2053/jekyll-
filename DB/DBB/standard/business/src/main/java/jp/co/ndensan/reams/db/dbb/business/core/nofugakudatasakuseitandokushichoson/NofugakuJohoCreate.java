/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nofugakudatasakuseitandokushichoson.NofugakuDataProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.BbKakuteiShinkokuDataCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DE940110DatEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DE940200DatEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DbT2016NofugakuJohoTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.NofugakuJohoResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.NofugakuJohoTempEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 納付額データ作成クラスです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
public class NofugakuJohoCreate {

    private static final int 期1 = 1;
    private static final int 期2 = 2;
    private static final int 期3 = 3;
    private static final int 期4 = 4;
    private static final int 期5 = 5;
    private static final int 期6 = 6;
    private static final int 期7 = 7;
    private static final int 期8 = 8;
    private static final int 期9 = 9;
    private static final int 期10 = 10;
    private static final int 期11 = 11;
    private static final int 期12 = 12;
    private static final int 期13 = 13;
    private static final RString 数字_0 = new RString("0");
    private static final RString 数字_1 = new RString("1");
    private static final RString 数字_2 = new RString("2");
    private static final RString 数字_3 = new RString("3");
    private static final RString 識別ＩＤ = new RString("DE13");
    private static final int 期14 = 14;
    private static final RString 調定額 = new RString("+0000");
    private static final RString 負号 = new RString("-");
    private static final RString 正号 = new RString("+");

    /**
     * get納付額情報TempEntity
     *
     * @param entity NofugakuJohoResultEntity
     * @return NofugakuJohoTempEntity
     */
    public NofugakuJohoTempEntity get納付額情報TempEntity(NofugakuJohoResultEntity entity) {
        NofugakuJohoTempEntity tempEntity = new NofugakuJohoTempEntity();
        tempEntity.setChoteiNendo(entity.get調定年度());
        tempEntity.setFukaNendo(entity.get賦課年度());
        tempEntity.setTsuchishoNo(entity.get通知書番号());
        tempEntity.setHihokenshaNo(entity.get被保険者番号());
        tempEntity.setShikibetsuCode(entity.get識別コード());
        tempEntity.setFukaShichosonCode(entity.get賦課市町村コード());
        tempEntity.setFuSaishutsuKampuGaku(entity.get普徴歳出還付額());
        tempEntity.setTkSaishutsuKampuGaku(entity.get特徴歳出還付額());
        return tempEntity;
    }

    /**
     * set期別金額
     *
     * @param entity NofugakuJohoResultEntity
     * @param tempEntity NofugakuJohoTempEntity
     */
    public void set期別金額(NofugakuJohoResultEntity entity, NofugakuJohoTempEntity tempEntity) {
        if (ChoshuHohoKibetsu.特別徴収.getコード().equals(entity.get徴収方法())) {
            set特徴期期別金額(entity.get調定額(), entity.get期(), tempEntity);
        }
        if (ChoshuHohoKibetsu.普通徴収.getコード().equals(entity.get徴収方法())) {
            set普徴期期別金額(entity.get調定額(), entity.get期(), tempEntity);
        }
    }

    /**
     * set特徴期期別金額
     *
     * @param 調定額 Decimal
     * @param ki int
     * @param tempEntity NofugakuJohoTempEntity
     */
    private void set特徴期期別金額(Decimal 調定額, int ki, NofugakuJohoTempEntity tempEntity) {
        switch (ki) {
            case 1:
                tempEntity.setTkChoteiGaku01(調定額);
                break;
            case 2:
                tempEntity.setTkChoteiGaku02(調定額);
                break;
            case 期3:
                tempEntity.setTkChoteiGaku03(調定額);
                break;
            case 期4:
                tempEntity.setTkChoteiGaku04(調定額);
                break;
            case 期5:
                tempEntity.setTkChoteiGaku05(調定額);
                break;
            case 期6:
                tempEntity.setTkChoteiGaku06(調定額);
                break;
            default:
                break;
        }
    }

    private void set普徴期期別金額(Decimal 調定額, int ki, NofugakuJohoTempEntity tempEntity) {
        switch (ki) {
            case 1:
                tempEntity.setFuChoteiGaku01(調定額);
                break;
            case 2:
                tempEntity.setFuChoteiGaku02(調定額);
                break;
            case 期3:
                tempEntity.setFuChoteiGaku03(調定額);
                break;
            case 期4:
                tempEntity.setFuChoteiGaku04(調定額);
                break;
            case 期5:
                tempEntity.setFuChoteiGaku05(調定額);
                break;
            case 期6:
                tempEntity.setFuChoteiGaku06(調定額);
                break;
            case 期7:
                tempEntity.setFuChoteiGaku07(調定額);
                break;
            case 期8:
                tempEntity.setFuChoteiGaku08(調定額);
                break;
            case 期9:
                tempEntity.setFuChoteiGaku09(調定額);
                break;
            case 期10:
                tempEntity.setFuChoteiGaku10(調定額);
                break;
            case 期11:
                tempEntity.setFuChoteiGaku11(調定額);
                break;
            case 期12:
                tempEntity.setFuChoteiGaku12(調定額);
                break;
            case 期13:
                tempEntity.setFuChoteiGaku13(調定額);
                break;
            case 期14:
                tempEntity.setFuChoteiGaku14(調定額);
                break;
            default:
                break;
        }
    }

    /**
     * set収入情報
     *
     * @param entity NofugakuJohoResultEntity
     * @param 納付額情報TempEntity NofugakuJohoTempEntity
     */
    public void set収入情報(NofugakuJohoResultEntity entity, NofugakuJohoTempEntity 納付額情報TempEntity) {
        納付額情報TempEntity.setChoteiNendo(entity.get調定年度());
        納付額情報TempEntity.setTsuchishoNo(entity.get通知書番号());
        if (ChoshuHohoKibetsu.特別徴収.getコード().equals(entity.get徴収方法())) {
            set特徴収入額(entity.get収入額(), entity.get期(), 納付額情報TempEntity);
            set特徴日(entity.get収入日(), entity.get領収日(), entity.get期(), 納付額情報TempEntity);
        }
        if (ChoshuHohoKibetsu.普通徴収.getコード().equals(entity.get徴収方法())) {
            set普徴収入額(entity.get収入額(), entity.get期(), 納付額情報TempEntity);
            set普徴日(entity.get収入日(), entity.get領収日(), entity.get期(), 納付額情報TempEntity);
        }
    }

    private void set特徴収入額(Decimal 収入額, int ki, NofugakuJohoTempEntity 納付額情報TempEntity) {
        switch (ki) {
            case 期1:
                納付額情報TempEntity.setTkShunyuGaku01(収入額);
                break;
            case 期2:
                納付額情報TempEntity.setTkShunyuGaku02(収入額);
                break;
            case 期3:
                納付額情報TempEntity.setTkShunyuGaku03(収入額);
                break;
            case 期4:
                納付額情報TempEntity.setTkShunyuGaku04(収入額);
                break;
            case 期5:
                納付額情報TempEntity.setTkShunyuGaku05(収入額);
                break;
            case 期6:
                納付額情報TempEntity.setTkShunyuGaku06(収入額);
                break;
            default:
                break;
        }

    }

    private void set普徴収入額(Decimal 収入額, int ki, NofugakuJohoTempEntity 納付額情報TempEntity) {
        switch (ki) {
            case 期1:
                納付額情報TempEntity.setFuShunyuGaku01(収入額);
                break;
            case 期2:
                納付額情報TempEntity.setFuShunyuGaku02(収入額);
                break;
            case 期3:
                納付額情報TempEntity.setFuShunyuGaku03(収入額);
                break;
            case 期4:
                納付額情報TempEntity.setFuShunyuGaku04(収入額);
                break;
            case 期5:
                納付額情報TempEntity.setFuShunyuGaku05(収入額);
                break;
            case 期6:
                納付額情報TempEntity.setFuShunyuGaku06(収入額);
                break;
            case 期7:
                納付額情報TempEntity.setFuShunyuGaku07(収入額);
                break;
            case 期8:
                納付額情報TempEntity.setFuShunyuGaku08(収入額);
                break;
            case 期9:
                納付額情報TempEntity.setFuShunyuGaku09(収入額);
                break;
            case 期10:
                納付額情報TempEntity.setFuShunyuGaku10(収入額);
                break;
            case 期11:
                納付額情報TempEntity.setFuShunyuGaku11(収入額);
                break;
            case 期12:
                納付額情報TempEntity.setFuShunyuGaku12(収入額);
                break;
            case 期13:
                納付額情報TempEntity.setFuShunyuGaku13(収入額);
                break;
            case 期14:
                納付額情報TempEntity.setFuShunyuGaku14(収入額);
                break;
            default:
                break;
        }
    }

    private void set特徴日(FlexibleDate 収入日, FlexibleDate 領収日, int ki, NofugakuJohoTempEntity 納付額情報TempEntity) {
        switch (ki) {
            case 期1:
                納付額情報TempEntity.setTkShunyuYMD01(収入日);
                納付額情報TempEntity.setTkRyoshuYMD01(領収日);
                break;
            case 期2:
                納付額情報TempEntity.setTkShunyuYMD02(収入日);
                納付額情報TempEntity.setTkRyoshuYMD02(領収日);
                break;
            case 期3:
                納付額情報TempEntity.setTkShunyuYMD03(収入日);
                納付額情報TempEntity.setTkRyoshuYMD03(領収日);
                break;
            case 期4:
                納付額情報TempEntity.setTkShunyuYMD04(収入日);
                納付額情報TempEntity.setTkRyoshuYMD04(領収日);
                break;
            case 期5:
                納付額情報TempEntity.setTkShunyuYMD05(収入日);
                納付額情報TempEntity.setTkRyoshuYMD05(領収日);
                break;
            case 期6:
                納付額情報TempEntity.setTkShunyuYMD06(収入日);
                納付額情報TempEntity.setTkRyoshuYMD06(領収日);
                break;
            default:
                break;
        }

    }

    private void set普徴日(FlexibleDate 収入日, FlexibleDate 領収日, int ki, NofugakuJohoTempEntity 納付額情報TempEntity) {
        switch (ki) {
            case 期1:
                納付額情報TempEntity.setFuShunyuYMD01(収入日);
                納付額情報TempEntity.setFuRyoshuYMD01(領収日);
                break;
            case 期2:
                納付額情報TempEntity.setFuShunyuYMD02(収入日);
                納付額情報TempEntity.setFuRyoshuYMD02(領収日);
                break;
            case 期3:
                納付額情報TempEntity.setFuShunyuYMD03(収入日);
                納付額情報TempEntity.setFuRyoshuYMD03(領収日);
                break;
            case 期4:
                納付額情報TempEntity.setFuShunyuYMD04(収入日);
                納付額情報TempEntity.setFuRyoshuYMD04(領収日);
                break;
            case 期5:
                納付額情報TempEntity.setFuShunyuYMD05(収入日);
                納付額情報TempEntity.setFuRyoshuYMD05(領収日);
                break;
            case 期6:
                納付額情報TempEntity.setFuShunyuYMD06(収入日);
                納付額情報TempEntity.setFuRyoshuYMD06(領収日);
                break;
            case 期7:
                納付額情報TempEntity.setFuShunyuYMD07(収入日);
                納付額情報TempEntity.setFuRyoshuYMD07(領収日);
                break;
            case 期8:
                納付額情報TempEntity.setFuShunyuYMD08(収入日);
                納付額情報TempEntity.setFuRyoshuYMD08(領収日);
                break;
            case 期9:
                納付額情報TempEntity.setFuShunyuYMD09(収入日);
                納付額情報TempEntity.setFuRyoshuYMD09(領収日);
                break;
            case 期10:
                納付額情報TempEntity.setFuShunyuYMD10(収入日);
                納付額情報TempEntity.setFuRyoshuYMD10(領収日);
                break;
            case 期11:
                納付額情報TempEntity.setFuShunyuYMD11(収入日);
                納付額情報TempEntity.setFuRyoshuYMD11(領収日);
                break;
            case 期12:
                納付額情報TempEntity.setFuShunyuYMD12(収入日);
                納付額情報TempEntity.setFuRyoshuYMD12(領収日);
                break;
            case 期13:
                納付額情報TempEntity.setFuShunyuYMD13(収入日);
                納付額情報TempEntity.setFuRyoshuYMD13(領収日);
                break;
            case 期14:
                納付額情報TempEntity.setFuShunyuYMD14(収入日);
                納付額情報TempEntity.setFuRyoshuYMD14(領収日);
                break;
            default:
                break;
        }
    }

    /**
     * ファイル出力（BBKAKUTEISHINKOKUDATA）
     *
     * @param 納付額情報 DbT2016NofugakuJohoTemp
     * @param processParameter NofugakuDataProcessParameter
     * @param 連番 int
     * @param 期月リスト_特徴 KitsukiList
     * @param 期月リスト_普徴 KitsukiList
     * @return BbKakuteiShinkokuDataCsvEntity
     */
    public BbKakuteiShinkokuDataCsvEntity setCSV情報(DbT2016NofugakuJohoTemp 納付額情報,
            NofugakuDataProcessParameter processParameter,
            int 連番, KitsukiList 期月リスト_特徴, KitsukiList 期月リスト_普徴) {
        BbKakuteiShinkokuDataCsvEntity csvEntity = new BbKakuteiShinkokuDataCsvEntity();
        //TODO
        csvEntity.set市町村コード１(getColumnValue(納付額情報.get賦課市町村コード()));
        csvEntity.set識別ＩＤ(識別ＩＤ);
        csvEntity.setタイムスタンプ(YMDHMS.now().toDateString());
        csvEntity.set最終レコード区分(RString.EMPTY);
        csvEntity.set連番(new RString(連番));
        csvEntity.setFiller(RString.HALF_SPACE);
        //TODO
        csvEntity.set市町村コード２(getColumnValue(納付額情報.get賦課市町村コード()));
        csvEntity.set識別コード(getColumnValue(納付額情報.get識別コード()));
        csvEntity.set被保険者番号(getColumnValue(納付額情報.get被保険者番号()));
        if (processParameter.get対象年() != null) {
            csvEntity.set申告年(processParameter.get対象年().toDateString());
        }
        if (processParameter.get抽出条件() != null) {
            csvEntity.set普通徴収抽出開始日(dateToRString(processParameter.get抽出条件().get抽出開始日()));
            csvEntity.set普通徴収抽出終了日(dateToRString(processParameter.get抽出条件().get抽出終了日()));
        }
        Decimal 特別徴収調定額合計 = get徴収額合計(true, false, false, false, 納付額情報);
        Decimal 特別徴収収入額合計 = get徴収額合計(false, true, false, false, 納付額情報);
        Decimal 普通徴収調定額合計 = get徴収額合計(false, false, true, false, 納付額情報);
        Decimal 普通徴収収入額合計 = get徴収額合計(false, false, false, true, 納付額情報);
        csvEntity.set年間調定額合計(プラス符号(特別徴収調定額合計.add(普通徴収調定額合計)));
        csvEntity.set年間収入額合計(プラス符号(特別徴収収入額合計.add(普通徴収収入額合計)));
        csvEntity.set特別徴収調定額_１月(調定額);
        csvEntity.set特別徴収収入額_１月(調定額);
        csvEntity.set特別徴収調定額_２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報, true));
        csvEntity.set特別徴収収入額_２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報, false));
        csvEntity.set特別徴収調定額_３月(調定額);
        csvEntity.set特別徴収収入額_３月(調定額);
        csvEntity.set特別徴収調定額_４月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報, true));
        csvEntity.set特別徴収収入額_４月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報, false));
        csvEntity.set特別徴収調定額_５月(調定額);
        csvEntity.set特別徴収収入額_５月(調定額);
        csvEntity.set特別徴収調定額_６月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報, true));
        csvEntity.set特別徴収収入額_６月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報, false));
        csvEntity.set特別徴収調定額_７月(調定額);
        csvEntity.set特別徴収収入額_７月(調定額);
        csvEntity.set特別徴収調定額_８月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報, true));
        csvEntity.set特別徴収収入額_８月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報, false));
        csvEntity.set特別徴収調定額_９月(調定額);
        csvEntity.set特別徴収収入額_９月(調定額);
        csvEntity.set特別徴収調定額_１０月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報, true));
        csvEntity.set特別徴収収入額_１０月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報, false));
        csvEntity.set特別徴収調定額_１１月(調定額);
        csvEntity.set特別徴収収入額_１１月(調定額);
        csvEntity.set特別徴収調定額_１２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報, true));
        csvEntity.set特別徴収収入額_１２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報, false));
        csvEntity.set特別徴収過年度分調定額(調定額);
        csvEntity.set特別徴収過年度分収入額(プラス符号(get特別徴収過年度分収入額(納付額情報, processParameter)));
        csvEntity.set普通徴収調定額_１月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._1月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_３月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._3月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_４月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_５月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._5月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_６月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_７月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._7月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_８月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_９月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._9月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_１０月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_１１月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._11月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収調定額_１２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_１月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._1月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_２月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_３月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._3月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_４月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_５月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._5月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_６月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_７月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._7月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_８月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_９月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._9月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_１０月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_１１月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._11月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収収入額_１２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報));
        csvEntity.set普通徴収過年度分調定額(調定額);
        csvEntity.set普通徴収過年度分収入額(プラス符号(get普通徴収過年度分収入額(納付額情報, processParameter)));
        csvEntity.set徴収区分(get徴収区分(納付額情報));
        if (processParameter.get抽出条件() != null) {
            csvEntity.set普通徴収集計日区分(processParameter.get抽出条件().get集計日区分());
        }
        csvEntity.set予備(RString.HALF_SPACE);
        csvEntity.set作成日時(YMDHMS.now().toDateString());
        return csvEntity;
    }

    /**
     * ファイル出力（他社住民税用固定長ファイル）
     *
     * @param 納付額情報 DbT2016NofugakuJohoTemp
     * @param processParameter NofugakuDataProcessParameter
     * @param 連番 int
     * @param 期月リスト_特徴 KitsukiList
     * @param 期月リスト_普徴 KitsukiList
     * @return DE940110DatEntity
     */
    public DE940110DatEntity setDE940110Dat情報(DbT2016NofugakuJohoTemp 納付額情報,
            NofugakuDataProcessParameter processParameter,
            int 連番, KitsukiList 期月リスト_特徴, KitsukiList 期月リスト_普徴) {
        DE940110DatEntity dataEntity = new DE940110DatEntity();
        //TODO
        dataEntity.set市町村コード１(getColumnValue(納付額情報.get賦課市町村コード()));
        dataEntity.set識別ＩＤ(識別ＩＤ);
        dataEntity.setタイムスタンプ(YMDHMS.now().toDateString());
        dataEntity.set最終レコード区分(RString.EMPTY);
        dataEntity.set連番(new RString(連番));
        dataEntity.setFiller(RString.HALF_SPACE);
        //TODO
        dataEntity.set市町村コード２(getColumnValue(納付額情報.get賦課市町村コード()));
        dataEntity.set識別コード(getColumnValue(納付額情報.get識別コード()));
        dataEntity.set被保険者番号(getColumnValue(納付額情報.get被保険者番号()));
        if (processParameter.get対象年() != null) {
            dataEntity.set申告年(processParameter.get対象年().toDateString());
        }
        if (processParameter.get抽出条件() != null) {
            dataEntity.set普通徴収抽出開始日(dateToRString(processParameter.get抽出条件().get抽出開始日()));
            dataEntity.set普通徴収抽出終了日(dateToRString(processParameter.get抽出条件().get抽出終了日()));
        }
        Decimal 特別徴収調定額合計 = get徴収額合計(true, false, false, false, 納付額情報);
        Decimal 特別徴収収入額合計 = get徴収額合計(false, true, false, false, 納付額情報);
        Decimal 普通徴収調定額合計 = get徴収額合計(false, false, true, false, 納付額情報);
        Decimal 普通徴収収入額合計 = get徴収額合計(false, false, false, true, 納付額情報);
        dataEntity.set年間調定額合計(プラス符号(特別徴収調定額合計.add(普通徴収調定額合計)));
        dataEntity.set年間収入額合計(プラス符号(特別徴収収入額合計.add(普通徴収収入額合計)));
        dataEntity.set特別徴収調定額_１月(調定額);
        dataEntity.set特別徴収収入額_１月(調定額);
        dataEntity.set特別徴収調定額_２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_３月(調定額);
        dataEntity.set特別徴収収入額_３月(調定額);
        dataEntity.set特別徴収調定額_４月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_４月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_５月(調定額);
        dataEntity.set特別徴収収入額_５月(調定額);
        dataEntity.set特別徴収調定額_６月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_６月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_７月(調定額);
        dataEntity.set特別徴収収入額_７月(調定額);
        dataEntity.set特別徴収調定額_８月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_８月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_９月(調定額);
        dataEntity.set特別徴収収入額_９月(調定額);
        dataEntity.set特別徴収調定額_１０月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_１０月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_１１月(調定額);
        dataEntity.set特別徴収収入額_１１月(調定額);
        dataEntity.set特別徴収調定額_１２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_１２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収過年度分調定額(調定額);
        dataEntity.set特別徴収過年度分収入額(プラス符号(get特別徴収過年度分収入額(納付額情報, processParameter)));
        dataEntity.set普通徴収調定額_１月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._1月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_３月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._3月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_４月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_５月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._5月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_６月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_７月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._7月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_８月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_９月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._9月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_１０月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_１１月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._11月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_１２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._1月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_２月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_３月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._3月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_４月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_５月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._5月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_６月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_７月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._7月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_８月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_９月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._9月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１０月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１１月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._11月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収過年度分調定額(調定額);
        dataEntity.set普通徴収過年度分収入額(プラス符号(get普通徴収過年度分収入額(納付額情報, processParameter)));
        dataEntity.set徴収区分(get徴収区分(納付額情報));
        if (processParameter.get抽出条件() != null) {
            dataEntity.set普通徴収集計日区分(processParameter.get抽出条件().get集計日区分());
        }
        dataEntity.set通知書番号(getColumnValue(納付額情報.get通知書番号()));
        dataEntity.set予備(RString.HALF_SPACE);
        dataEntity.set作成日時(YMDHMS.now().toDateString());
        return dataEntity;
    }

    /**
     * ファイル出力（他社住民税用固定長ファイル（拡張））
     *
     * @param 納付額情報 DbT2016NofugakuJohoTemp
     * @param processParameter NofugakuDataProcessParameter
     * @param 連番 int
     * @param 期月リスト_特徴 KitsukiList
     * @param 期月リスト_普徴 KitsukiList
     * @return DE940200DatEntity
     */
    public DE940200DatEntity set940200Dat情報(DbT2016NofugakuJohoTemp 納付額情報,
            NofugakuDataProcessParameter processParameter,
            int 連番, KitsukiList 期月リスト_特徴, KitsukiList 期月リスト_普徴) {
        DE940200DatEntity dataEntity = new DE940200DatEntity();
        //TODO
        dataEntity.set市町村コード１(getColumnValue(納付額情報.get賦課市町村コード()));
        dataEntity.set識別ＩＤ(識別ＩＤ);
        dataEntity.setタイムスタンプ(YMDHMS.now().toDateString());
        dataEntity.set最終レコード区分(RString.EMPTY);
        dataEntity.set連番(new RString(連番));
        dataEntity.setFiller(RString.HALF_SPACE);
        //TODO
        dataEntity.set市町村コード２(getColumnValue(納付額情報.get賦課市町村コード()));
        dataEntity.set識別コード(getColumnValue(納付額情報.get識別コード()));
        dataEntity.set被保険者番号(getColumnValue(納付額情報.get被保険者番号()));
        if (processParameter.get対象年() != null) {
            dataEntity.set申告年(processParameter.get対象年().toDateString());
        }
        if (processParameter.get抽出条件() != null) {
            dataEntity.set普通徴収抽出開始日(dateToRString(processParameter.get抽出条件().get抽出開始日()));
            dataEntity.set普通徴収抽出終了日(dateToRString(processParameter.get抽出条件().get抽出終了日()));
        }
        Decimal 特別徴収調定額合計 = get徴収額合計(true, false, false, false, 納付額情報);
        Decimal 特別徴収収入額合計 = get徴収額合計(false, true, false, false, 納付額情報);
        Decimal 普通徴収調定額合計 = get徴収額合計(false, false, true, false, 納付額情報);
        Decimal 普通徴収収入額合計 = get徴収額合計(false, false, false, true, 納付額情報);
        dataEntity.set年間調定額合計(プラス符号(特別徴収調定額合計.add(普通徴収調定額合計)));
        dataEntity.set年間収入額合計(プラス符号(特別徴収収入額合計.add(普通徴収収入額合計)));
        dataEntity.set特別徴収調定額_１月(調定額);
        dataEntity.set特別徴収収入額_１月(調定額);
        dataEntity.set特別徴収調定額_２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_３月(調定額);
        dataEntity.set特別徴収収入額_３月(調定額);
        dataEntity.set特別徴収調定額_４月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_４月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_５月(調定額);
        dataEntity.set特別徴収収入額_５月(調定額);
        dataEntity.set特別徴収調定額_６月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_６月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_７月(調定額);
        dataEntity.set特別徴収収入額_７月(調定額);
        dataEntity.set特別徴収調定額_８月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_８月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_９月(調定額);
        dataEntity.set特別徴収収入額_９月(調定額);
        dataEntity.set特別徴収調定額_１０月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_１０月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収調定額_１１月(調定額);
        dataEntity.set特別徴収収入額_１１月(調定額);
        dataEntity.set特別徴収調定額_１２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報, true));
        dataEntity.set特別徴収収入額_１２月(set特別徴収額(期月リスト_特徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報, false));
        dataEntity.set特別徴収過年度分調定額(調定額);
        dataEntity.set特別徴収過年度分収入額(プラス符号(get特別徴収過年度分収入額(納付額情報, processParameter)));
        dataEntity.set普通徴収調定額_１月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._1月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_３月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._3月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_４月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_５月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._5月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_６月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_７月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._7月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_８月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_９月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._9月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_１０月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_１１月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._11月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収調定額_１２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._1月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_２月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._2月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_３月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._3月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_４月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._4月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_５月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._5月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_６月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._6月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_７月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._7月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_８月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._8月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_９月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._9月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１０月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._10月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１１月(set普徴収入額(期月リスト_普徴.get月の期(Tsuki._11月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収収入額_１２月(set普徴調定額(期月リスト_普徴.get月の期(Tsuki._12月).get期AsInt(), 納付額情報));
        dataEntity.set普通徴収過年度分調定額(調定額);
        dataEntity.set普通徴収過年度分収入額(プラス符号(get普通徴収過年度分収入額(納付額情報, processParameter)));
        dataEntity.set徴収区分(get徴収区分(納付額情報));
        if (processParameter.get抽出条件() != null) {
            dataEntity.set普通徴収集計日区分(processParameter.get抽出条件().get集計日区分());
        }
        dataEntity.set通知書番号(getColumnValue(納付額情報.get通知書番号()));
        dataEntity.set予備(RString.HALF_SPACE);
        dataEntity.set作成日時(YMDHMS.now().toDateString());
        return dataEntity;
    }

    private Decimal get特別徴収過年度分収入額(DbT2016NofugakuJohoTemp 納付額情報, NofugakuDataProcessParameter processParameter) {
        RString 調定年度 = 納付額情報.get調定年度() != null ? 納付額情報.get調定年度().toDateString() : RString.EMPTY;
        RString 賦課年度 = 納付額情報.get賦課年度() != null ? 納付額情報.get賦課年度().toDateString() : RString.EMPTY;
        RString 対象年 = processParameter.get対象年() != null ? processParameter.get対象年().toDateString() : RString.EMPTY;
        RString 対象年minus1 = processParameter.get対象年() != null ? processParameter.get対象年().minusYear(期1).toDateString() : RString.EMPTY;

        if (調定年度.equals(対象年minus1) && 賦課年度.equals(対象年minus1)) {
            return nullToDecimal(納付額情報.get特徴収入額01())
                    .add(nullToDecimal(納付額情報.get特徴収入額02()))
                    .add(nullToDecimal(納付額情報.get特徴収入額03()))
                    .add(nullToDecimal(納付額情報.get特徴収入額04()))
                    .add(nullToDecimal(納付額情報.get特徴収入額05()));

        } else if (調定年度.equals(対象年) && 賦課年度.equals(対象年)) {
            return nullToDecimal(納付額情報.get特徴収入額06());

        } else if (調定年度.equals(対象年) && 賦課年度.compareTo(対象年) == -1) {
            return nullToDecimal(納付額情報.get特徴収入額01())
                    .add(nullToDecimal(納付額情報.get特徴収入額02()))
                    .add(nullToDecimal(納付額情報.get特徴収入額03()))
                    .add(nullToDecimal(納付額情報.get特徴収入額04()))
                    .add(nullToDecimal(納付額情報.get特徴収入額05()))
                    .add(nullToDecimal(納付額情報.get特徴収入額06()));
        } else {
            return Decimal.ZERO;
        }
    }

    private Decimal get普通徴収過年度分収入額(DbT2016NofugakuJohoTemp 納付額情報, NofugakuDataProcessParameter processParameter) {
        RString 調定年度 = 納付額情報.get調定年度() != null ? 納付額情報.get調定年度().toDateString() : RString.EMPTY;
        RString 賦課年度 = 納付額情報.get賦課年度() != null ? 納付額情報.get賦課年度().toDateString() : RString.EMPTY;
        RString 対象年 = processParameter.get対象年() != null ? processParameter.get対象年().toDateString() : RString.EMPTY;
        RString 対象年minus1 = processParameter.get対象年() != null ? processParameter.get対象年().minusYear(期1).toDateString() : RString.EMPTY;

        if (調定年度.equals(対象年minus1) && 賦課年度.equals(対象年minus1)) {
            return nullToDecimal(納付額情報.get普徴収入額01())
                    .add(nullToDecimal(納付額情報.get普徴収入額02()))
                    .add(nullToDecimal(納付額情報.get普徴収入額03()))
                    .add(nullToDecimal(納付額情報.get普徴収入額04()))
                    .add(nullToDecimal(納付額情報.get普徴収入額05()))
                    .add(nullToDecimal(納付額情報.get普徴収入額06()))
                    .add(nullToDecimal(納付額情報.get普徴収入額07()))
                    .add(nullToDecimal(納付額情報.get普徴収入額08()))
                    .add(nullToDecimal(納付額情報.get普徴収入額09()));

        } else if (調定年度.equals(対象年minus1) && 賦課年度.compareTo(対象年minus1) == -1) {
            return nullToDecimal(納付額情報.get普徴収入額01())
                    .add(nullToDecimal(納付額情報.get普徴収入額02()))
                    .add(nullToDecimal(納付額情報.get普徴収入額03()))
                    .add(nullToDecimal(納付額情報.get普徴収入額04()))
                    .add(nullToDecimal(納付額情報.get普徴収入額05()))
                    .add(nullToDecimal(納付額情報.get普徴収入額06()))
                    .add(nullToDecimal(納付額情報.get普徴収入額07()))
                    .add(nullToDecimal(納付額情報.get普徴収入額08()))
                    .add(nullToDecimal(納付額情報.get普徴収入額09()));

        } else if (調定年度.equals(対象年) && 賦課年度.equals(対象年)) {
            return nullToDecimal(納付額情報.get普徴収入額10())
                    .add(nullToDecimal(納付額情報.get普徴収入額11()))
                    .add(nullToDecimal(納付額情報.get普徴収入額12()));
        } else if (調定年度.equals(対象年) && 賦課年度.compareTo(対象年) == -1) {
            return nullToDecimal(納付額情報.get普徴収入額10())
                    .add(nullToDecimal(納付額情報.get普徴収入額11()))
                    .add(nullToDecimal(納付額情報.get普徴収入額12()));
        } else if (!調定年度.equals(対象年) || 賦課年度.compareTo(対象年) == 1 || 賦課年度.compareTo(対象年) == 0) {
            return nullToDecimal(納付額情報.get普徴収入額01())
                    .add(nullToDecimal(納付額情報.get普徴収入額02()))
                    .add(nullToDecimal(納付額情報.get普徴収入額03()))
                    .add(nullToDecimal(納付額情報.get普徴収入額04()))
                    .add(nullToDecimal(納付額情報.get普徴収入額05()))
                    .add(nullToDecimal(納付額情報.get普徴収入額06()))
                    .add(nullToDecimal(納付額情報.get普徴収入額07()))
                    .add(nullToDecimal(納付額情報.get普徴収入額08()))
                    .add(nullToDecimal(納付額情報.get普徴収入額09()))
                    .add(nullToDecimal(納付額情報.get普徴収入額10()))
                    .add(nullToDecimal(納付額情報.get普徴収入額11()))
                    .add(nullToDecimal(納付額情報.get普徴収入額12()));
        } else {
            return Decimal.ZERO;
        }
    }

    private RString get徴収区分(DbT2016NofugakuJohoTemp 納付額情報) {
        Decimal 特別徴収調定額合計 = get徴収額合計(true, false, false, false, 納付額情報);
        Decimal 特別徴収収入額合計 = get徴収額合計(false, true, false, false, 納付額情報);
        Decimal 普通徴収調定額合計 = get徴収額合計(false, false, true, false, 納付額情報);
        Decimal 普通徴収収入額合計 = get徴収額合計(false, false, false, true, 納付額情報);
        if ((!Decimal.ZERO.equals(特別徴収調定額合計) || !Decimal.ZERO.equals(特別徴収収入額合計))
                && Decimal.ZERO.equals(普通徴収調定額合計) && Decimal.ZERO.equals(普通徴収収入額合計)) {
            return 数字_1;
        } else if (Decimal.ZERO.equals(特別徴収調定額合計) && Decimal.ZERO.equals(特別徴収収入額合計)
                && (!Decimal.ZERO.equals(普通徴収調定額合計) || !Decimal.ZERO.equals(普通徴収収入額合計))) {
            return 数字_2;
        } else if ((!Decimal.ZERO.equals(特別徴収調定額合計) || !Decimal.ZERO.equals(特別徴収収入額合計))
                && (!Decimal.ZERO.equals(普通徴収調定額合計) || !Decimal.ZERO.equals(普通徴収収入額合計))) {
            return 数字_3;
        } else {
            return RString.EMPTY;
        }

    }

    private Decimal get徴収額合計(boolean 特徴調定額flag, boolean 特徴収入額flag,
            boolean 普徴調定額flag, boolean 普徴収入額flag,
            DbT2016NofugakuJohoTemp 納付額情報) {
        if (特徴調定額flag) {
            return nullToDecimal(納付額情報.get特徴調定額01())
                    .add(nullToDecimal(納付額情報.get特徴調定額02()))
                    .add(nullToDecimal(納付額情報.get特徴調定額03()))
                    .add(nullToDecimal(納付額情報.get特徴調定額04()))
                    .add(nullToDecimal(納付額情報.get特徴調定額05()))
                    .add(nullToDecimal(納付額情報.get特徴調定額06()));
        } else if (特徴収入額flag) {
            return nullToDecimal(納付額情報.get特徴収入額01())
                    .add(nullToDecimal(納付額情報.get特徴収入額02()))
                    .add(nullToDecimal(納付額情報.get特徴収入額03()))
                    .add(nullToDecimal(納付額情報.get特徴収入額04()))
                    .add(nullToDecimal(納付額情報.get特徴収入額05()))
                    .add(nullToDecimal(納付額情報.get特徴収入額06()));
        } else if (普徴調定額flag) {
            return nullToDecimal(納付額情報.get普徴調定額01())
                    .add(nullToDecimal(納付額情報.get普徴調定額02()))
                    .add(nullToDecimal(納付額情報.get普徴調定額03()))
                    .add(nullToDecimal(納付額情報.get普徴調定額04()))
                    .add(nullToDecimal(納付額情報.get普徴調定額05()))
                    .add(nullToDecimal(納付額情報.get普徴調定額06()))
                    .add(nullToDecimal(納付額情報.get普徴調定額07()))
                    .add(nullToDecimal(納付額情報.get普徴調定額08()))
                    .add(nullToDecimal(納付額情報.get普徴調定額09()))
                    .add(nullToDecimal(納付額情報.get普徴調定額10()))
                    .add(nullToDecimal(納付額情報.get普徴調定額11()))
                    .add(nullToDecimal(納付額情報.get普徴調定額12()));
        } else if (普徴収入額flag) {
            return nullToDecimal(納付額情報.get普徴収入額01())
                    .add(nullToDecimal(納付額情報.get普徴収入額02()))
                    .add(nullToDecimal(納付額情報.get普徴収入額03()))
                    .add(nullToDecimal(納付額情報.get普徴収入額04()))
                    .add(nullToDecimal(納付額情報.get普徴収入額05()))
                    .add(nullToDecimal(納付額情報.get普徴収入額06()))
                    .add(nullToDecimal(納付額情報.get普徴収入額07()))
                    .add(nullToDecimal(納付額情報.get普徴収入額08()))
                    .add(nullToDecimal(納付額情報.get普徴収入額09()))
                    .add(nullToDecimal(納付額情報.get普徴収入額10()))
                    .add(nullToDecimal(納付額情報.get普徴収入額11()))
                    .add(nullToDecimal(納付額情報.get普徴収入額12()));
        } else {
            return Decimal.ZERO;
        }

    }

    private RString set特別徴収額(int 期, DbT2016NofugakuJohoTemp 納付額情報, boolean 調定額flag) {
        switch (期) {
            case 期1:
                if (調定額flag) {
                    return プラス符号(納付額情報.get特徴調定額01());
                } else {
                    return プラス符号(納付額情報.get特徴収入額01());
                }
            case 期2:
                if (調定額flag) {
                    return プラス符号(納付額情報.get特徴調定額02());
                } else {
                    return プラス符号(納付額情報.get特徴収入額02());
                }
            case 期3:
                if (調定額flag) {
                    return プラス符号(納付額情報.get特徴調定額03());
                } else {
                    return プラス符号(納付額情報.get特徴収入額03());
                }
            case 期4:
                if (調定額flag) {
                    return プラス符号(納付額情報.get特徴調定額04());
                } else {
                    return プラス符号(納付額情報.get特徴収入額04());
                }
            case 期5:
                if (調定額flag) {
                    return プラス符号(納付額情報.get特徴調定額05());
                } else {
                    return プラス符号(納付額情報.get特徴収入額05());
                }
            case 期6:
                if (調定額flag) {
                    return プラス符号(納付額情報.get特徴調定額06());
                } else {
                    return プラス符号(納付額情報.get特徴収入額06());
                }
            default:
                break;
        }
        return 調定額;
    }

    private RString set普徴調定額(int 期, DbT2016NofugakuJohoTemp 納付額情報) {
        switch (期) {
            case 期1:
                return プラス符号(納付額情報.get普徴調定額01());

            case 期2:
                return プラス符号(納付額情報.get普徴調定額02());

            case 期3:
                return プラス符号(納付額情報.get普徴調定額03());
            case 期4:
                return プラス符号(納付額情報.get普徴調定額04());
            case 期5:
                return プラス符号(納付額情報.get普徴調定額05());
            case 期6:
                return プラス符号(納付額情報.get普徴調定額06());
            case 期7:
                return プラス符号(納付額情報.get普徴調定額07());
            case 期8:
                return プラス符号(納付額情報.get普徴調定額08());
            case 期9:
                return プラス符号(納付額情報.get普徴調定額09());
            case 期10:
                return プラス符号(納付額情報.get普徴調定額10());
            case 期11:
                return プラス符号(納付額情報.get普徴調定額11());
            case 期12:
                return プラス符号(納付額情報.get普徴調定額12());

            default:
                break;
        }
        return 調定額;
    }

    private RString set普徴収入額(int 期, DbT2016NofugakuJohoTemp 納付額情報) {
        switch (期) {
            case 期1:
                return プラス符号(納付額情報.get普徴収入額01());
            case 期2:
                return プラス符号(納付額情報.get普徴収入額02());
            case 期3:
                return プラス符号(納付額情報.get普徴収入額03());
            case 期4:
                return プラス符号(納付額情報.get普徴収入額04());
            case 期5:
                return プラス符号(納付額情報.get普徴収入額05());
            case 期6:
                return プラス符号(納付額情報.get普徴収入額06());
            case 期7:
                return プラス符号(納付額情報.get普徴収入額07());
            case 期8:
                return プラス符号(納付額情報.get普徴収入額08());
            case 期9:
                return プラス符号(納付額情報.get普徴収入額09());
            case 期10:
                return プラス符号(納付額情報.get普徴収入額10());
            case 期11:
                return プラス符号(納付額情報.get普徴収入額11());
            case 期12:
                return プラス符号(納付額情報.get普徴収入額12());
            default:
                break;
        }
        return 調定額;
    }

    private RString プラス符号(Decimal 金額) {
        if (金額 == null) {
            return 調定額;
        }
        if (金額.compareTo(Decimal.ZERO) == -1) {
            return 負号.concat(new RString(金額.toString()));
        } else if (金額.compareTo(Decimal.ZERO) == 1) {
            return 正号.concat(new RString(金額.toString()));
        }
        return 調定額;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString dateToRString(RDate 日期) {
        if (日期 == null) {
            return RString.EMPTY;
        }
        return 日期.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
    }

    private Decimal nullToDecimal(Decimal 金額) {
        if (金額 == null) {
            return Decimal.ZERO;
        }
        return 金額;
    }

}
