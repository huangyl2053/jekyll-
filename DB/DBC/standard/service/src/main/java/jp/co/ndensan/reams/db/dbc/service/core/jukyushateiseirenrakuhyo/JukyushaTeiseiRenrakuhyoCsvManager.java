/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.JukyushaTeiseiRenrakuhyoCsvControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.JukyushaTeiseiRenrakuhyoCsvDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.JukyushaTeiseiRenrakuhyoCsvEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
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
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票設計_DBCZV00002_受給者訂正連絡票（CSV）CsvManager
 *
 * @reamsid_L DBC-2720-091 surun
 */
public class JukyushaTeiseiRenrakuhyoCsvManager {

    private static final RString カンマ = new RString(",");
    private static final RString ダブルクォート = new RString("\"");
    private static final RString 出力ファイル名 = new RString("jktei0.csv");
    private static final RString 定数_ZERO = new RString("0");
    private static final int INDEX_ZERO = 0;
    private static final RString 定数_ONE = new RString("1");
    private static final RString 定数_TWO = new RString("2");
    private static final RString 定数_THREE = new RString("3");
    private static final RString 受給者訂正情報 = new RString("532");
    private static final RString 定数 = new RString("5321");
    private static final RString レコード種別コード = new RString("H1");
    private static final RString 改行 = new RString("0x0D0A");
    private CsvWriter csvWriter;
    private RString filePath;

    /**
     * コンストラクタ。
     *
     * @return JukyushaTeiseiRenrakuhyoCsvManager
     */
    public static JukyushaTeiseiRenrakuhyoCsvManager createInstance() {
        return InstanceProvider.create(JukyushaTeiseiRenrakuhyoCsvManager.class);
    }

    /**
     * csvの出力
     *
     * @param entityList List<JukyushaTeiseiRenrakuhyoCsvEntity>
     */
    public void csvの出力(List<JukyushaTeiseiRenrakuhyoCsvEntity> entityList) {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        filePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(filePath)
                .setDelimiter(カンマ)
                .setEnclosure(ダブルクォート)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
        csvWriter.writeLine(editorControlRecord());
        for (JukyushaTeiseiRenrakuhyoCsvEntity csvEntity : entityList) {
            csvWriter.writeLine(editorDataRecord(csvEntity));
        }
        csvWriter.writeLine(editorEndRecord());
        csvWriter.close();
    }

    /**
     * ファイルのコントロールレド
     *
     * @return JukyushaTeiseiRenrakuhyoCsvControlEntity
     */
    private JukyushaTeiseiRenrakuhyoCsvControlEntity editorControlRecord() {
        JukyushaTeiseiRenrakuhyoCsvControlEntity csvControlEntity = new JukyushaTeiseiRenrakuhyoCsvControlEntity();
        csvControlEntity.setレコード種別(定数_ONE);
        csvControlEntity.setレコード番号連(定数_ONE);
        csvControlEntity.setボリュム通番(定数_ZERO);
        csvControlEntity.setレコード件数(定数_ONE);
        csvControlEntity.setデータ種別(受給者訂正情報);
        csvControlEntity.set福祉事務所特定番号(定数_ZERO);
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        List<KoikiZenShichosonJoho> 広域市町村情報 = finder.koseiShichosonJoho().records();
        if (広域市町村情報 != null && 広域市町村情報.size() > INDEX_ZERO) {
            ShoKisaiHokenshaNo 証記載保険者番号 = 広域市町村情報.get(INDEX_ZERO).get証記載保険者番号();
            if (証記載保険者番号 != null) {
                csvControlEntity.set保険者番号(証記載保険者番号.getColumnValue());
            }
        }
        csvControlEntity.set事業所番号(定数_ZERO);
        csvControlEntity.set都道府県番号(定数_ZERO);
        RString 国保連送付媒体_受給異動Ｆ_媒体区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_媒体区分,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        csvControlEntity.set媒体区分(国保連送付媒体_受給異動Ｆ_媒体区分);
        csvControlEntity.set処理対象年月(RDateTime.now().format西暦("YYYYMM"));
        csvControlEntity.setファイル管理番号(定数_ONE);
        csvControlEntity.setブランク(改行);
        return csvControlEntity;
    }

    /**
     * ファイルのデータレコード
     *
     * @param entity JukyushaTeiseiRenrakuhyoCsvEntity
     * @return JukyushaTeiseiRenrakuhyoCsvDataEntity
     */
    private JukyushaTeiseiRenrakuhyoCsvDataEntity editorDataRecord(JukyushaTeiseiRenrakuhyoCsvEntity entity) {
        JukyushaTeiseiRenrakuhyoCsvDataEntity csvDataEntity = new JukyushaTeiseiRenrakuhyoCsvDataEntity();
        if (entity != null) {
            csvDataEntity.setレコード種別(定数_TWO);
            csvDataEntity.setレコード番号連(定数_TWO);
            csvDataEntity.set交換情報識別番号(定数);
            csvDataEntity.setレコード種別コード(レコード種別コード);
            csvDataEntity.set異動年月日(set西暦(entity.get異動年月日()));
            csvDataEntity.set異動事由(entity.get異動事由());
            csvDataEntity.set訂正年月日(set西暦(entity.get訂正年月日()));
            csvDataEntity.set訂正区分コード(entity.get訂正区分コード());
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
            csvDataEntity.set利用者負担減免_旧措置入所者_給付率(new RString(entity.get利用給付率().toString()));
            csvDataEntity.set利用者負担減免_旧措置入所者_適用開始年月日(set西暦(entity.get利用適用開始年月日()));
            csvDataEntity.set利用者負担減免_旧措置入所者_適用終了年月日(set西暦(entity.get利用適用終了年月日()));
            csvDataEntity.set特定標準負担_標準負担_標準負担区分コード(entity.get標準負担区分());
            csvDataEntity.set特定標準負担_標準負担_負担額(new RString(entity.get標準負担額().toString()));
            csvDataEntity.set特定標準負担_標準負担_負担額適用開始年月日(set西暦(entity.get標準適用開始年月日()));
            csvDataEntity.set特定標準負担_標準負担_負担額適用終了年月日(set西暦(entity.get標準適用終了年月日()));
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
     * ファイルのエンドレコード
     *
     * @return JukyushaTeiseiRenrakuhyoCsvEndEntity
     */
    private JukyushaTeiseiRenrakuhyoCsvEndEntity editorEndRecord() {
        JukyushaTeiseiRenrakuhyoCsvEndEntity csvEndEntity = new JukyushaTeiseiRenrakuhyoCsvEndEntity();
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
