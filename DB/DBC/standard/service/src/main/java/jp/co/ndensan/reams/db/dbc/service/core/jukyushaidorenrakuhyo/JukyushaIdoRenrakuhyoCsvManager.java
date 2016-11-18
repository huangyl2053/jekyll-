/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.JukyushaIdoRenrakuhyoCsvControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.JukyushaIdoRenrakuhyoCsvDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.JukyushaIdoRenrakuhyoCsvEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票設計_DBCZV00001_受給者異動連絡票（CSV）CsvManager
 *
 * @reamsid_L DBC-2720-090 surun
 */
public class JukyushaIdoRenrakuhyoCsvManager {

    private static final RString カンマ = new RString(",");
    private static final RString ダブルクォート = new RString("\"");
    private static final RString 定数ファイル名 = new RString("10_531");
    private static final RString 出力CSV = new RString(".csv");
    private static final RString 定数_ZERO = new RString("0");
    private static final RString 定数_ONE = new RString("1");
    private static final RString 定数_TWO = new RString("2");
    private static final RString 定数_THREE = new RString("3");
    private static final RString 定数 = new RString("5311");
    private static final RString 受給者異動情報 = new RString("531");
    private static final RString 改行 = new RString("0x0D0A");
    private static final int INDEX_TWO = 2;
    private CsvWriter csvWriter;
    private RString filePath;
    private int 総出力件数;
    private RString 入力ファイルパス;

    /**
     * 帳票設計_DBCZV00001_受給者異動連絡票（CSV）のコンストラクタ。
     *
     * @return JukyushaIdoRenrakuhyoCsvManager
     */
    public static JukyushaIdoRenrakuhyoCsvManager createInstance() {
        return InstanceProvider.create(JukyushaIdoRenrakuhyoCsvManager.class);
    }

    /**
     * csvの出力
     *
     * @param entityList List<JukyushaIdoRenrakuhyoCsvEntity>
     * @param 処理対象年月 RYearMonth
     * @return JukyushaIdoRenrakuhyoEntity
     */
    public JukyushaIdoRenrakuhyoEntity csvの出力(List<JukyushaIdoRenrakuhyoCsvEntity> entityList, RYearMonth 処理対象年月) {
        JukyushaIdoRenrakuhyoEntity resultEntity = new JukyushaIdoRenrakuhyoEntity();
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 出力ファイル名1 = 定数ファイル名.concat(保険者番号);
        if (処理対象年月 != null) {
            出力ファイル名1 = 出力ファイル名1.concat(処理対象年月.toDateString());
        }
        RString 出力ファイル名 = 出力ファイル名1.concat(出力CSV);
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        filePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(filePath)
                .setDelimiter(カンマ)
                .setEnclosure(ダブルクォート)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
        csvWriter.writeLine(editorControlRecord());
        for (JukyushaIdoRenrakuhyoCsvEntity entity : entityList) {
            csvWriter.writeLine(editorDataRecord(entity));
        }
        csvWriter.writeLine(editorEndRecord());
        csvWriter.close();
        総出力件数 = entityList.size() + INDEX_TWO;
        入力ファイルパス = filePath;
        resultEntity.set出力ファイルパス(filePath);
        resultEntity.set入力ファイルパス(入力ファイルパス);
        resultEntity.set総出力件数(総出力件数);
        return resultEntity;
    }

    /**
     * editorControlRecord
     *
     * @return JukyushaIdoRenrakuhyoCsvControlEntity
     */
    private JukyushaIdoRenrakuhyoCsvControlEntity editorControlRecord() {
        JukyushaIdoRenrakuhyoCsvControlEntity csvControlEntity = new JukyushaIdoRenrakuhyoCsvControlEntity();
        csvControlEntity.setレコード種別(定数_ONE);
        csvControlEntity.setレコード番号連(定数_ONE);
        csvControlEntity.setボリュム通番(定数_ZERO);
        csvControlEntity.setレコード件数(定数_ONE);
        csvControlEntity.setデータ種別(受給者異動情報);
        csvControlEntity.set福祉事務所特定番号(定数_ZERO);
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        csvControlEntity.set保険者番号(保険者番号);
        csvControlEntity.set事業所番号(定数_ZERO);
        csvControlEntity.set都道府県番号(定数_ZERO);
        RString 国保連送付媒体_受給異動Ｆ_媒体区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_受給異動Ｆ_媒体区分,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        csvControlEntity.set媒体区分(国保連送付媒体_受給異動Ｆ_媒体区分);
        csvControlEntity.set処理対象年月(RDateTime.now().format西暦("YYYYMM"));
        csvControlEntity.setファイル管理番号(定数_ONE);
        csvControlEntity.setブランク(改行);
        return csvControlEntity;
    }

    /**
     * editorDataRecord
     *
     * @param entity JukyushaIdoRenrakuhyoCsvEntity
     * @return JukyushaIdoRenrakuhyoCsvDataEntity
     */
    private JukyushaIdoRenrakuhyoCsvDataEntity editorDataRecord(JukyushaIdoRenrakuhyoCsvEntity entity) {
        JukyushaIdoRenrakuhyoCsvDataEntity csvDataEntity = new JukyushaIdoRenrakuhyoCsvDataEntity();
        if (entity != null) {
            csvDataEntity.setレコード種別(定数_TWO);
            csvDataEntity.setレコード番号連(定数_TWO);
            csvDataEntity.set交換情報識別番号(定数);
            csvDataEntity.set異動年月日(set西暦(entity.get異動年月日()));
            csvDataEntity.set異動区分コード(entity.get異動区分());
            csvDataEntity.set異動事由(entity.get異動事由());
            if (entity.get証記載保険者番号() != null) {
                csvDataEntity.set証記載保険者番号(entity.get証記載保険者番号().getColumnValue());
            }
            if (entity.get被保険者番号() != null) {
                csvDataEntity.set被保険者番号(entity.get被保険者番号().getColumnValue());
            }
            csvDataEntity.set被保険者氏名カナ(entity.get被保険者氏名カナ());
            csvDataEntity.set生年月日(set西暦(entity.get生年月日()));
            csvDataEntity.set性別コード(entity.get性別());
            csvDataEntity.set資格取得年月日(set西暦(entity.get資格取得年月日()));
            csvDataEntity.set資格喪失年月日(set西暦(entity.get資格喪失年月日()));
            csvDataEntity.set老人保健市町村番号(entity.get老人保健市町村番号());
            csvDataEntity.set老人保健受給者番号(entity.get老人保健受給者番号());
            if (entity.get広域保険者番号() != null) {
                csvDataEntity.set広域連合政令市保険者番号(entity.get広域保険者番号().getColumnValue());
            }
            csvDataEntity.set申請種別コード(entity.get申請種別());
            csvDataEntity.set変更申請中区分コード(entity.get変更申請中区分());
            csvDataEntity.set申請年月日(set西暦(entity.get申請年月日()));
            csvDataEntity.setみなし要介護区分コード(entity.getみなし区分());
            csvDataEntity.set要介護状態区分コード(entity.get要介護状態区分());
            csvDataEntity.set認定有効期間開始年月日(set西暦(entity.get有効期間開始年月日()));
            csvDataEntity.set認定有効期間終了年月日(set西暦(entity.get有効期間終了年月日()));
            csvDataEntity.set居宅サービス計画作成区分コード(entity.get計画作成区分());
            csvDataEntity.set居宅介護支援事業所番号(entity.get居宅支援事業所番号());
            csvDataEntity.set居宅サービス計画適用開始年月日(set西暦(entity.get居宅適用開始年月日()));
            csvDataEntity.set居宅サービス計画適用終了年月日(set西暦(entity.get居宅適用終了年月日()));
            csvDataEntity.set訪問通所サービス_支給限度基準額(new RString(entity.get支給限度基準額1()));
            csvDataEntity.set訪問通所サービス_上限管理適用期間開始年月日(set西暦(entity.get上限管理適用開始年月日1()));
            csvDataEntity.set訪問通所サービス_上限管理適用期間終了年月日(set西暦(entity.get上限管理適用終了年月日1()));
            csvDataEntity.set短期入所サービス_支給限度基準額(new RString(entity.get支給限度基準額2()));
            csvDataEntity.set短期入所サービス_上限管理適用期間開始年月日(set西暦(entity.get上限管理適用開始年月日2()));
            csvDataEntity.set短期入所サービス_上限管理適用期間終了年月日(set西暦(entity.get上限管理適用終了年月日2()));
            csvDataEntity.set公費負担上限額減額の有無(entity.get公費負担上限額減額の有無());
            csvDataEntity.set償還払化開始年月日(set西暦(entity.get償還払化適用開始年月日()));
            csvDataEntity.set償還払化終了年月日(set西暦(entity.get償還払化適用終了年月日()));
            csvDataEntity.set給付率引下げ開始年月日(set西暦(entity.get給付率引下げ適用開始年月日()));
            csvDataEntity.set給付率引下げ終了年月日(set西暦(entity.get給付率引下げ適用終了年月日()));
            csvDataEntity.set利用者負担減免_旧措置入所者_減免申請中区分コード(entity.get減免申請中区分());
            csvDataEntity.set利用者負担減免_旧措置入所者_利用者負担区分コード(entity.get利用者負担区分());
            if (entity.get利用給付率() != null) {
                csvDataEntity.set利用者負担減免_旧措置入所者_給付率(new RString(entity.get利用給付率().toString()));
            }
            csvDataEntity.set利用者負担減免_旧措置入所者_適用開始年月日(set西暦(entity.get利用適用開始年月日()));
            csvDataEntity.set利用者負担減免_旧措置入所者_適用終了年月日(set西暦(entity.get利用適用終了年月日()));
            csvDataEntity.set標準負担_特定標準負担_標準負担区分コード(entity.get標準負担区分());
            if (entity.get標準負担額() != null) {
                csvDataEntity.set標準負担_特定標準負担_標準負担額(new RString(entity.get標準負担額().toString()));
            }
            csvDataEntity.set標準負担_特定標準負担_負担額適用開始年月日(set西暦(entity.get標準適用開始年月日()));
            csvDataEntity.set標準負担_特定標準負担_負担額適用終了年月日(set西暦(entity.get標準適用終了年月日()));
            csvDataEntity.set特定入所者介護サービス_特定入所者認定申請中区分コード(entity.get認定申請中区分());
            csvDataEntity.set特定入所者介護サービス_特定入所者介護サービス区分コード(entity.getサービス区分());
            csvDataEntity.set特定入所者介護サービス_課税層の特例減額措置対象(entity.get特例減額措置対象());
            csvDataEntity.set特定入所者介護サービス_食費負担限度額(entity.get食費負担限度額());
            csvDataEntity.set特定入所者介護サービス_居住費ユニット型個室負担限度額(entity.getユニット型個室());
            csvDataEntity.set特定入所者介護サービス_居住費ユニット型準個室負担限度額(entity.getユニット型準個室());
            csvDataEntity.set特定入所者介護サービス_居住費従来型個室特養等負担限度額(entity.get従来型個室特());
            csvDataEntity.set特定入所者介護サービス_居住費従来型個室老健療養等負担限度額(entity.get従来型個室老療());
            csvDataEntity.set特定入所者介護サービス_居住費多床室負担限度額(entity.get多床室());
            csvDataEntity.set特定入所者介護サービス_負担限度額適用開始年月日(set西暦(entity.get特定入所者適用開始年月日()));
            csvDataEntity.set特定入所者介護サービス_負担限度額適用終了年月日(set西暦(entity.get特定入所者適用終了年月日()));
            csvDataEntity.set社会福祉法人軽減情報_軽減率(entity.get軽減率());
            csvDataEntity.set社会福祉法人軽減情報_軽減率適用開始年月日(set西暦(entity.get軽減率適用開始年月日()));
            csvDataEntity.set社会福祉法人軽減情報_軽減率適用終了年月日(set西暦(entity.get軽減率適用終了年月日()));
            csvDataEntity.set小規模多機能型居宅介護の利用開始月における居宅サービス等の利用の有無(entity.get小規模居宅ｻｰﾋﾞｽ利用());
            csvDataEntity.set医療資格_後期高齢視者_保険者番号後期(entity.get後期高齢保険者番号());
            csvDataEntity.set医療資格_後期高齢視者_被保険者番号後期(entity.get後期高齢被保険者番号());
            csvDataEntity.set国民健康保険資格_保険者番号国保(entity.get国保保険者番号());
            csvDataEntity.set国民健康保険資格_被保険者証番号国保(entity.get国保被保険者証番号());
            csvDataEntity.set国民健康保険資格_個人番号国保(entity.get国保個人番号());
            csvDataEntity.set二次予防事業区分コード(entity.get二次予防事業区分());
            csvDataEntity.set二次予防事業有効期間開始年月日(set西暦(entity.get二次予防有効期間開始年月日()));
            csvDataEntity.set二次予防事業有効期間終了年月日(set西暦(entity.get二次予防有効期間終了年月日()));
            csvDataEntity.set住所地特例_住所地特例対象者区分コード(entity.get住特対象者区分());
            csvDataEntity.set住所地特例_施設所在保険者番号(entity.get住特施設所在保険者番号());
            csvDataEntity.set住所地特例_住所地特例適用開始年月日(set西暦(entity.get住特適用開始年月日()));
            csvDataEntity.set住所地特例_住所地特例適用終了年月日(set西暦(entity.get住特適用終了年月日()));
            csvDataEntity.set特定入所者介護サービス_居住費新１負担限度額(entity.get新１());
            csvDataEntity.set特定入所者介護サービス_居住費新２負担限度額(entity.get新２());
            csvDataEntity.set特定入所者介護サービス_居住費新３負担限度額(entity.get新３());
            csvDataEntity.set二割負担_適用開始年月日(set西暦(entity.get二割負担適用開始年月日()));
            csvDataEntity.set二割負担_適用終了年月日(set西暦(entity.get二割負担適用終了年月日()));
            csvDataEntity.setブランク(改行);
        }
        return csvDataEntity;
    }

    /**
     * editorEndRecord
     *
     * @return JukyushaIdoRenrakuhyoCsvEndEntity
     */
    private JukyushaIdoRenrakuhyoCsvEndEntity editorEndRecord() {
        JukyushaIdoRenrakuhyoCsvEndEntity csvEndEntity = new JukyushaIdoRenrakuhyoCsvEndEntity();
        csvEndEntity.setレコード種別(定数_THREE);
        csvEndEntity.setレコード番号連(定数_THREE);
        csvEndEntity.setブランク(改行);
        return csvEndEntity;
    }

    private RString set西暦(FlexibleDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

}
