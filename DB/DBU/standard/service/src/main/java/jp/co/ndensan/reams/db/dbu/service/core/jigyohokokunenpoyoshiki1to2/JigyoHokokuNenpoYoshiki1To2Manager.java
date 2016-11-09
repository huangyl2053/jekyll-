/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpoyoshiki1to2;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuTokeiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.TempIchijiTable2MybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.TempIchijiTableMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.Yoshiki1To2ComMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2ProcessParameter;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoyoshiki1to2.IJigyoHokokuNenpoYoshiki1To2Mapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告年報　様式１・２のManagerクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public class JigyoHokokuNenpoYoshiki1To2Manager {

    private static final int 所得段階_28 = 28;
    private static final int 所得段階_29 = 29;
    private static final int X集計INDEX_10 = 10;
    private static final int X集計INDEX_11 = 11;
    private static final int X集計INDEX_14 = 14;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final RString 集計項目名称_合計 = new RString("合計");

    /**
     * 市町村コードにて、事業報告統計データにデータを追加する
     *
     * @param processParameter Process用パラメータクラス
     * @param mapper Mapperクラス
     */
    public void ins事業報告統計データFor市町村コード(
            JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper) {
        for (int i = 1; i < 所得段階_28; i++) {
            int 一時テーブルCount = mapper.get一時テーブルCount(
                    TempIchijiTableMybatisParameter.createTempIchijiTableParam(
                            LasdecCode.EMPTY, LasdecCode.EMPTY, false, false, true, i));
            mapper.insert事業報告統計データ(
                    Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_一般状況.getコード()),
                            new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(i), Decimal.ONE, new Decimal(一時テーブルCount),
                            RString.EMPTY, processParameter.get市町村コード()));
        }

        mapper.insert事業報告統計データ(
                Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_一般状況.getコード()),
                        new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(所得段階_28), Decimal.ONE, mapper.get第５段階の保険料率(new FlexibleYear(processParameter.get集計年度())),
                        RString.EMPTY, processParameter.get市町村コード()));

        int 一時テーブルCount29 = mapper.get一時テーブルCount(
                TempIchijiTableMybatisParameter.createTempIchijiTableParam(
                        LasdecCode.EMPTY, LasdecCode.EMPTY, false, false, false, 0));
        mapper.insert事業報告統計データ(
                Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_一般状況.getコード()),
                        new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(所得段階_29), Decimal.ONE, new Decimal(一時テーブルCount29),
                        RString.EMPTY, processParameter.get市町村コード()));
    }

    /**
     * 構成市町村コードにて、事業報告統計データにデータを追加する
     *
     * @param processParameter Process用パラメータクラス
     * @param mapper Mapperクラス
     */
    public void ins事業報告統計データFor構成市町村コード(
            JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper) {
        for (RString 構成市町村コード : processParameter.get構成市町村コードリスト()) {
            for (int i = 1; i < 所得段階_28; i++) {
                int 一時テーブルCount = mapper.get一時テーブルCount(
                        TempIchijiTableMybatisParameter.createTempIchijiTableParam(
                                new LasdecCode(構成市町村コード), LasdecCode.EMPTY, true, false, true, i));
                mapper.insert事業報告統計データ(
                        Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                                processParameter.get集計年度(), new Code(HyoNo.現物_一般状況.getコード()),
                                new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                                processParameter.get報告年度(),
                                new Decimal(i), Decimal.ONE, new Decimal(一時テーブルCount),
                                RString.EMPTY, 構成市町村コード));
            }
            mapper.insert事業報告統計データ(
                    Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_一般状況.getコード()),
                            new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(所得段階_28), Decimal.ONE, mapper.get第５段階の保険料率(new FlexibleYear(processParameter.get集計年度())),
                            RString.EMPTY, 構成市町村コード));

            int 一時テーブルCount29 = mapper.get一時テーブルCount(
                    TempIchijiTableMybatisParameter.createTempIchijiTableParam(
                            new LasdecCode(構成市町村コード), LasdecCode.EMPTY, true, false, false, 0));
            mapper.insert事業報告統計データ(
                    Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_一般状況.getコード()),
                            new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(所得段階_29), Decimal.ONE, new Decimal(一時テーブルCount29),
                            RString.EMPTY, 構成市町村コード));
        }
    }

    /**
     * 旧市町村コードにて、事業報告統計データにデータを追加する
     *
     * @param processParameter Process用パラメータクラス
     * @param mapper Mapperクラス
     */
    public void ins事業報告統計データFor旧市町村コード(
            JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper) {
        for (RString 旧市町村コード : processParameter.get旧市町村コードリスト()) {
            for (int i = 1; i < 所得段階_28; i++) {
                int 一時テーブルCount = mapper.get一時テーブルCount(
                        TempIchijiTableMybatisParameter.createTempIchijiTableParam(
                                LasdecCode.EMPTY, new LasdecCode(旧市町村コード), false, true, true, i));
                mapper.insert事業報告統計データ(
                        Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                                processParameter.get集計年度(), new Code(HyoNo.現物_一般状況_旧市町村.getコード()),
                                new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                                processParameter.get報告年度(),
                                new Decimal(i), Decimal.ONE, new Decimal(一時テーブルCount),
                                new RString("合計"), 旧市町村コード));
            }
            mapper.insert事業報告統計データ(
                    Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_一般状況_旧市町村.getコード()),
                            new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(所得段階_28), Decimal.ONE, mapper.get第５段階の保険料率(new FlexibleYear(processParameter.get集計年度())),
                            RString.EMPTY, 旧市町村コード));

            int 一時テーブルCount29 = mapper.get一時テーブルCount(
                    TempIchijiTableMybatisParameter.createTempIchijiTableParam(
                            LasdecCode.EMPTY, new LasdecCode(旧市町村コード), false, true, false, 0));
            mapper.insert事業報告統計データ(
                    Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_一般状況_旧市町村.getコード()),
                            new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(所得段階_29), Decimal.ONE, new Decimal(一時テーブルCount29),
                            RString.EMPTY, 旧市町村コード));
        }
    }

    /**
     * 市町村コードにて、事業報告統計データにデータを追加する
     *
     * @param processParameter Process用パラメータクラス
     * @param mapper Mapperクラス
     * @param サービス項目コードList サービス項目コード
     */
    public void ins事業報告統計データFor全体(
            JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper, List<ServiceKomokuCode> サービス項目コードList) {
        int count = 1;
        for (ServiceKomokuCode komokuCode : サービス項目コードList) {
            for (int i = 1; i < X集計INDEX_14; i++) {
                if (i == X集計INDEX_10) {
                    RString サービス名 = mapper.getサービス名(TempIchijiTable2MybatisParameter.createGetサービス名Param(null, null, komokuCode));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, processParameter.get市町村コード()));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()), processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, processParameter.get市町村コード()));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, processParameter.get市町村コード()));
                    continue;
                }
                if (i == X集計INDEX_11) {
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, processParameter.get市町村コード()));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()), processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, processParameter.get市町村コード()));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, processParameter.get市町村コード()));
                    continue;
                }
                int 集計結果値_0601 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, null, i,
                                ShukeiNoyoshiki2.市町村特別給付_件数.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0601), null, processParameter.get市町村コード()));
                int 集計結果値_0602 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, null, i,
                                ShukeiNoyoshiki2.市町村特別給付_費用額.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()), processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0602), null, processParameter.get市町村コード()));

                int 集計結果値_0603 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                                null, null, i, ShukeiNoyoshiki2.市町村特別給付_給付額.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0603), null, processParameter.get市町村コード()));
            }
            count = count + 1;
        }
        for (int i = 1; i < X集計INDEX_14; i++) {
            if (i == X集計INDEX_10) {
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, processParameter.get市町村コード()));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, processParameter.get市町村コード()));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, processParameter.get市町村コード()));
                continue;
            }
            if (i == X集計INDEX_11) {
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, processParameter.get市町村コード()));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, processParameter.get市町村コード()));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, processParameter.get市町村コード()));
                continue;
            }
            int 集計結果値_0601 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, null, i,
                            ShukeiNoyoshiki2.市町村特別給付_件数.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                    processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0601), null, processParameter.get市町村コード()));
            int 集計結果値_0602 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, null, i,
                            ShukeiNoyoshiki2.市町村特別給付_費用額.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                    processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0602), null, processParameter.get市町村コード()));

            int 集計結果値_0603 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                            null, null, i, ShukeiNoyoshiki2.市町村特別給付_給付額.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                    processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0603), null, processParameter.get市町村コード()));
        }
    }

    /**
     * 構成市町村コードにて、事業報告統計データにデータを追加する
     *
     * @param processParameter Process用パラメータクラス
     * @param mapper Mapperクラス
     * @param 構成項目コードList 構成項目コード
     * @param 構成市町村コード 構成市町村コード
     */
    public void ins事業報告統計データFor市町村別(
            JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper, List<ServiceKomokuCode> 構成項目コードList,
            RString 構成市町村コード) {
        int count = 1;
        for (ServiceKomokuCode komokuCode : 構成項目コードList) {
            for (int i = 1; i < X集計INDEX_14; i++) {
                if (i == X集計INDEX_10) {
                    RString サービス名 = mapper.getサービス名(TempIchijiTable2MybatisParameter.createGetサービス名Param(new LasdecCode(構成市町村コード), null, komokuCode));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, 構成市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, 構成市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, 構成市町村コード));
                    continue;
                }
                if (i == X集計INDEX_11) {
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, 構成市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, 構成市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, 構成市町村コード));
                    continue;
                }
                int 集計結果値_0601 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                                new LasdecCode(構成市町村コード), null, i, ShukeiNoyoshiki2.市町村特別給付_件数.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0601), null, 構成市町村コード));
                int 集計結果値_0602 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                                new LasdecCode(構成市町村コード), null, i, ShukeiNoyoshiki2.市町村特別給付_費用額.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0602), null, 構成市町村コード));

                int 集計結果値_0603 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                                new LasdecCode(構成市町村コード), null, i, ShukeiNoyoshiki2.市町村特別給付_給付額.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0603), null, 構成市町村コード));
            }
            count = count + 1;
        }
        for (int i = 1; i < X集計INDEX_14; i++) {
            if (i == X集計INDEX_10) {
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, 構成市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, 構成市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, 構成市町村コード));
                continue;
            }
            if (i == X集計INDEX_11) {
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, 構成市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, 構成市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, 構成市町村コード));
                continue;
            }
            int 集計結果値_0601 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                            new LasdecCode(構成市町村コード), null, i,
                            ShukeiNoyoshiki2.市町村特別給付_件数.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0601), null, 構成市町村コード));
            int 集計結果値_0602 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                            new LasdecCode(構成市町村コード), null, i, ShukeiNoyoshiki2.市町村特別給付_費用額.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                    processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0602), null, 構成市町村コード));

            int 集計結果値_0603 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                            new LasdecCode(構成市町村コード), null, i, ShukeiNoyoshiki2.市町村特別給付_給付額.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                    processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0603), null, 構成市町村コード));
        }
    }

    /**
     * 旧構成市町村コードにて、事業報告統計データにデータを追加する
     *
     * @param processParameter Process用パラメータクラス
     * @param mapper Mapperクラス
     * @param 旧項目コードList 旧項目コード
     * @param 旧市町村コード 旧市町村コード
     */
    public void ins事業報告統計データFor旧市町村別(
            JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper, List<ServiceKomokuCode> 旧項目コードList,
            RString 旧市町村コード) {
        int count = 1;
        for (ServiceKomokuCode komokuCode : 旧項目コードList) {
            for (int i = 1; i < X集計INDEX_14; i++) {
                if (i == X集計INDEX_10) {
                    RString サービス名 = mapper.getサービス名(TempIchijiTable2MybatisParameter.createGetサービス名Param(null, new LasdecCode(旧市町村コード), komokuCode));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, 旧市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, 旧市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), Decimal.ZERO, サービス名, 旧市町村コード));
                    continue;
                }
                if (i == X集計INDEX_11) {
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, 旧市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, 旧市町村コード));
                    mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                            processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                            new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                            processParameter.get報告年度(),
                            new Decimal(count), new Decimal(i), null, null, 旧市町村コード));
                    continue;
                }
                int 集計結果値_0601 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, new LasdecCode(旧市町村コード), i,
                                ShukeiNoyoshiki2.市町村特別給付_件数.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0601), null, 旧市町村コード));
                int 集計結果値_0602 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                                null, new LasdecCode(旧市町村コード), i, ShukeiNoyoshiki2.市町村特別給付_費用額.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0602), null, 旧市町村コード));

                int 集計結果値_0603 = mapper.get一時テーブル2Count(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                                null, new LasdecCode(旧市町村コード), i, ShukeiNoyoshiki2.市町村特別給付_給付額.getコード(), komokuCode));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), new Decimal(集計結果値_0603), null, 旧市町村コード));
            }
            count = count + 1;
        }
        for (int i = 1; i < X集計INDEX_14; i++) {
            if (i == X集計INDEX_10) {
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, 旧市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, 旧市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), Decimal.ZERO, 集計項目名称_合計, 旧市町村コード));
                continue;
            }
            if (i == X集計INDEX_11) {
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, 旧市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, 旧市町村コード));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                        new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(count), new Decimal(i), null, null, 旧市町村コード));
                continue;
            }
            int 集計結果値_0601 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, new LasdecCode(旧市町村コード), i,
                            ShukeiNoyoshiki2.市町村特別給付_件数.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()), processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0601), null, 旧市町村コード));
            int 集計結果値_0602 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                            null, new LasdecCode(旧市町村コード), i, ShukeiNoyoshiki2.市町村特別給付_費用額.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()),
                    processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0602), null, 旧市町村コード));

            int 集計結果値_0603 = mapper.get一時テーブル2Count(
                    TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(
                            null, new LasdecCode(旧市町村コード), i, ShukeiNoyoshiki2.市町村特別給付_給付額.getコード(), null));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), new Code(HyoNo.現物_保険給付決定状況_旧市町村.getコード()),
                    new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()),
                    processParameter.get報告年度(),
                    new Decimal(count), new Decimal(i), new Decimal(集計結果値_0603), null, 旧市町村コード));
        }
    }

    /**
     * 全然の市町村コードにて、事業報告統計データにデータを追加する
     *
     * @param processParameter Process用パラメータクラス
     * @param mapper Mapperクラス
     * @param 市町村コードList 市町村コードリスト
     */
    public void ins事業報告統計データFor被保険者数(JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper, List<RString> 市町村コードList) {
        Code 表番号 = new Code(HyoNo.現物_一般状況.getコード());
        for (RString 市町村コード : 市町村コードList) {
            if (市町村コード.equals(RString.HALF_SPACE)) {
                表番号 = new Code(HyoNo.現物_一般状況_旧市町村.getコード());
                continue;
            }
            Decimal 集計結果値1011 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                    createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                            null, new LasdecCode(市町村コード),
                            表番号, new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()), 1, 1, false));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), 表番号,
                    new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()),
                    processParameter.get報告年度(),
                    Decimal.ONE, Decimal.ONE, 集計結果値1011, null, 市町村コード));
            Decimal 集計結果値1012 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                    createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                            new FlexibleDate(processParameter.get報告終了年月()),
                            new LasdecCode(市町村コード),
                            表番号, new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()), 1, 2, true));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), 表番号,
                    new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()), processParameter.get報告年度(),
                    Decimal.ONE, new Decimal(2), 集計結果値1012, null, 市町村コード));
            Decimal 集計結果値1013 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                    createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                            new FlexibleDate(processParameter.get報告終了年月()),
                            new LasdecCode(市町村コード),
                            表番号, new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()), 1, INDEX_3, true));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), 表番号,
                    new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()),
                    processParameter.get報告年度(),
                    Decimal.ONE, new Decimal(INDEX_3), 集計結果値1013, null, 市町村コード));
            Decimal 集計結果値1014 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                    createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告終了年月()),
                            null,
                            new LasdecCode(市町村コード),
                            表番号, new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()), 1, INDEX_4, false));
            mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                    processParameter.get集計年度(), 表番号,
                    new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()),
                    processParameter.get報告年度(),
                    Decimal.ONE, new Decimal(INDEX_4), 集計結果値1014, null, 市町村コード));
            int 横番号 = 1;
            for (int 縦番号 = 1; 縦番号 < INDEX_6; 縦番号++) {
                switch (横番号) {
                    case 1:
                        Decimal 集計結果値2011 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                                createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                                        null,
                                        new LasdecCode(市町村コード),
                                        表番号, new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()), 縦番号, 横番号, false));
                        mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                                processParameter.get集計年度(), 表番号,
                                new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()),
                                processParameter.get報告年度(),
                                new Decimal(縦番号), new Decimal(横番号), 集計結果値2011, null, 市町村コード));
                        break;
                    case 2:
                        Decimal 集計結果値2021 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                                createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                                        new FlexibleDate(processParameter.get報告終了年月()),
                                        new LasdecCode(市町村コード),
                                        表番号, new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()), 縦番号, 横番号, true));
                        mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                                processParameter.get集計年度(), 表番号,
                                new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()),
                                processParameter.get報告年度(),
                                new Decimal(縦番号), new Decimal(横番号), 集計結果値2021, null, 市町村コード));
                        break;
                    case INDEX_3:
                        Decimal 集計結果値2031 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                                createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                                        new FlexibleDate(processParameter.get報告終了年月()),
                                        new LasdecCode(市町村コード),
                                        表番号, new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()), 縦番号, 横番号, true));
                        mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                                processParameter.get集計年度(), 表番号,
                                new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()),
                                processParameter.get報告年度(),
                                new Decimal(縦番号), new Decimal(横番号), 集計結果値2031, null, 市町村コード));
                        break;
                    case INDEX_4:
                        Decimal 集計結果値2041 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                                createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告終了年月()),
                                        null,
                                        new LasdecCode(市町村コード),
                                        表番号, new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()), 縦番号, 横番号, false));
                        mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                                processParameter.get集計年度(), 表番号,
                                new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()),
                                processParameter.get報告年度(),
                                new Decimal(縦番号), new Decimal(横番号), 集計結果値2041, null, 市町村コード));
                        break;
                    default:
                        break;
                }
                if (縦番号 == INDEX_5 && 横番号 != INDEX_4) {
                    縦番号 = 1;
                    横番号 = 横番号 + 1;
                }
            }
            ins事業報告統計データFor03(processParameter, mapper, 市町村コード, 表番号);
        }
    }

    private void ins事業報告統計データFor03(JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter,
            IJigyoHokokuNenpoYoshiki1To2Mapper mapper, RString 市町村コード, Code 表番号) {
        for (int 縦番号 = 1; 縦番号 < INDEX_3; 縦番号++) {
            for (int 横番号 = 1; 横番号 < INDEX_6 + 1; 横番号++) {
                Decimal 集計結果値0301 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                        createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                                new FlexibleDate(processParameter.get報告終了年月()),
                                new LasdecCode(市町村コード), 表番号,
                                new Code(ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード()), 縦番号, 横番号, true));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), 表番号,
                        new Code(ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(縦番号), new Decimal(横番号), 集計結果値0301, null, 市町村コード));
                Decimal 集計結果値0302 = mapper.get集計結果値(JigyoHokokuTokeiMybatisParameter.
                        createJigyoHokokuTokeiParam(new FlexibleDate(processParameter.get報告開始年月()),
                                new FlexibleDate(processParameter.get報告終了年月()),
                                new LasdecCode(市町村コード), 表番号,
                                new Code(ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード()), 縦番号, 横番号, true));
                mapper.insert事業報告統計データ(Yoshiki1To2ComMybatisParameter.createInsJigyoHokokuTokeiParam(
                        processParameter.get集計年度(), 表番号,
                        new Code(ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード()),
                        processParameter.get報告年度(),
                        new Decimal(縦番号), new Decimal(横番号), 集計結果値0302, null, 市町村コード));
            }
        }
    }
}
