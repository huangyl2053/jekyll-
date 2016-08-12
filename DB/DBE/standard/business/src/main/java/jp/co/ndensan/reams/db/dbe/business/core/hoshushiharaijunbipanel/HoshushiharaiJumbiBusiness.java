/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.hoshushiharaijunbipanel;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelBatchRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 支払いデータ作成CSVEntity設定のビジネスです。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
public class HoshushiharaiJumbiBusiness {

    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final int FOUR = 4;
    private static final int 番号_7 = 7;
    private static final int TEN = 10;
    private static final int FIFTEEN = 15;
    private static final int SEVENTEEN = 17;
    private static final int TWENTY = 20;
    private static final RString SEVEN = new RString("7");
    private static final RString TWENTYONE = new RString("21");

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entity batchEntity
     * @param 口座情報 口座情報
     * @param flexibleDate 振込指定日
     * @return HoshushiharaiJumbiPanelEucCsvEntity
     */
    public RString setEucCsvEntity(HoshushiharaiJumbiPanelBatchRelateEntity entity, List<Koza> 口座情報, FlexibleDate flexibleDate) {
        HoshushiharaiJumbiPanelEucCsvEntity eucCsvEntity = new HoshushiharaiJumbiPanelEucCsvEntity();
        eucCsvEntity.setデータ区分1(ONE);
        eucCsvEntity.set種別コード(TWENTYONE);
        eucCsvEntity.setコード区分(ZERO);
        eucCsvEntity.set会社コード(DbBusinessConfig.get(ConfigNameDBE.会社コード, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        eucCsvEntity.set会社名(DbBusinessConfig.get(ConfigNameDBE.会社名, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        eucCsvEntity.set振込指定日(new RString(flexibleDate.toString().substring(FOUR)));
        eucCsvEntity.set仕向銀行番号(DbBusinessConfig.get(ConfigNameDBE.仕向銀行番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        if (RString.isNullOrEmpty(DbBusinessConfig.get(ConfigNameDBE.仕向銀行名, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            eucCsvEntity.set仕向銀行名(RString.EMPTY.padRight(RString.HALF_SPACE, FIFTEEN));
        } else {
            eucCsvEntity.set仕向銀行名(DbBusinessConfig.get(ConfigNameDBE.仕向銀行名, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        }
        eucCsvEntity.set仕向支店番号(DbBusinessConfig.get(ConfigNameDBE.仕向支店番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        if (RString.isNullOrEmpty(DbBusinessConfig.get(ConfigNameDBE.仕向支店名, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            eucCsvEntity.set仕向支店名(RString.EMPTY.padRight(RString.HALF_SPACE, FIFTEEN));
        } else {
            eucCsvEntity.set仕向支店名(DbBusinessConfig.get(ConfigNameDBE.仕向支店名, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        }
        eucCsvEntity.set預金種別(DbBusinessConfig.get(ConfigNameDBE.預金種別, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        eucCsvEntity.set口座番号(DbBusinessConfig.get(ConfigNameDBE.口座番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        eucCsvEntity.setダミー1(RString.EMPTY.padRight(RString.HALF_SPACE, SEVENTEEN));
        eucCsvEntity.setデータ区分2(TWO);
        if (口座情報 != null) {
            eucCsvEntity.set被仕向銀行番号(口座情報.get(0).get金融機関コード().value());
            eucCsvEntity.set被仕向銀行名(口座情報.get(0).get金融機関().get金融機関名称());
            eucCsvEntity.set被仕向支店番号(口座情報.get(0).get支店コード().value());
            eucCsvEntity.set被仕向支店名(口座情報.get(0).get支店().get支店名称());
        }
        eucCsvEntity.set手形交換所番号(ZERO);
        if (口座情報 != null) {
            eucCsvEntity.set預金種別2(口座情報.get(0).get預金種別().get預金種別コード());
            eucCsvEntity.set口座番号2(口座情報.get(0).get口座番号());
            eucCsvEntity.set受取人名(口座情報.get(0).get口座名義人漢字().value());
        }
        eucCsvEntity.set振込金額(new RString(entity.getShinsakaiHoshuGokei()));
        eucCsvEntity.set新規コード(ZERO);
        eucCsvEntity.set顧客コード1(entity.getShinsakaiIinCode());
        eucCsvEntity.set顧客コード2(RString.EMPTY.padRight(RString.HALF_SPACE, TEN));
        eucCsvEntity.setEdi情報(RString.EMPTY.padRight(RString.HALF_SPACE, TWENTY));
        eucCsvEntity.set振込指定区分(SEVEN);
        eucCsvEntity.set識別表示(new RString(""));
        eucCsvEntity.setダミー2(RString.EMPTY.padRight(RString.HALF_SPACE, 番号_7));
        RStringBuilder builder = new RStringBuilder();
        builder.append(ONE);
        builder.append(TWENTYONE);
        builder.append(ZERO);
        builder.append(DbBusinessConfig.get(ConfigNameDBE.会社コード, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        builder.append(DbBusinessConfig.get(ConfigNameDBE.会社名, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        builder.append(new RString(flexibleDate.toString().substring(FOUR)));
        builder.append(DbBusinessConfig.get(ConfigNameDBE.仕向銀行番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        if (RString.isNullOrEmpty(DbBusinessConfig.get(ConfigNameDBE.仕向銀行名, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, FIFTEEN));
        } else {
            builder.append(DbBusinessConfig.get(ConfigNameDBE.仕向銀行名, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        }
        builder.append(DbBusinessConfig.get(ConfigNameDBE.仕向支店番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        if (RString.isNullOrEmpty(DbBusinessConfig.get(ConfigNameDBE.仕向支店名, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, FIFTEEN));
        } else {
            builder.append(DbBusinessConfig.get(ConfigNameDBE.仕向支店名, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        }
        builder.append(DbBusinessConfig.get(ConfigNameDBE.預金種別, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        builder.append(DbBusinessConfig.get(ConfigNameDBE.口座番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, SEVENTEEN));
        builder.append(TWO);
        if (口座情報 != null) {
            builder.append(口座情報.get(0).get金融機関コード().value());
            builder.append(口座情報.get(0).get支店コード().value());
            builder.append(口座情報.get(0).get支店().get支店名称());
        }
        builder.append(ZERO);
        if (口座情報 != null) {
            builder.append(口座情報.get(0).get預金種別().get預金種別コード());
            builder.append(口座情報.get(0).get口座番号());
            builder.append(口座情報.get(0).get口座名義人漢字().value());
        }
        builder.append(new RString(entity.getShinsakaiHoshuGokei()));
        builder.append(ZERO);
        builder.append(entity.getShinsakaiIinCode());
        builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, TEN));
        builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, TWENTY));
        builder.append(SEVEN);
        builder.append(new RString(""));
        builder.append(RString.EMPTY.padRight(RString.HALF_SPACE, 番号_7));
        return builder.toRString();
    }

    /**
     * 出力件数を取得するメッソドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(HoshushiharaiJumbiPanelProcessParamter processParamter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【実績期間From】"));
        jokenBuilder.append(processParamter.getJissekidaterangefrom());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【実績期間To】"));
        jokenBuilder.append(processParamter.getJissekidaterangeto());
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }
}
