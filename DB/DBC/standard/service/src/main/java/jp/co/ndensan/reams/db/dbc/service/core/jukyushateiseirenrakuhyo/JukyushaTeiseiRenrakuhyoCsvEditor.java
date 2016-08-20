/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 帳票設計_DBCZV00002_受給者訂正連絡票（CSV）editor
 *
 * @reamsid_L DBC-2101-070 lijian
 */
public class JukyushaTeiseiRenrakuhyoCsvEditor {

    private static final RString 定数_THREE = new RString("3");
    private static final RString 定数_TWO = new RString("2");
    private static final RString 定数_ONE = new RString("1");
    private static final RString 定数_ZERO = new RString("0");
    private static final RString データ種別 = new RString("532");
    private static final RString ブランク = new RString("0x0D0A");
    private static final RString 交換情報識別番号 = new RString("5321");
    private static final RString レコード種別コード = new RString("H1");

    /**
     * editor
     *
     * @param entity JukyushaIdoRenrakuhyoTorokuEntity
     * @return JukyushaTeiseiRenrakuhyoCsvEntity
     */
    public JukyushaTeiseiRenrakuhyoCsvEntity editor(JukyushaIdoRenrakuhyoTorokuEntity entity) {
        JukyushaTeiseiRenrakuhyoCsvEntity csvEntity = new JukyushaTeiseiRenrakuhyoCsvEntity();
        editorファイルの第一レコード(csvEntity);
        editorファイルの第二レコード(csvEntity, entity);
        editorファイルの最終レコード(csvEntity);
        return csvEntity;
    }

    private void editorファイルの第一レコード(JukyushaTeiseiRenrakuhyoCsvEntity csvEntity) {
        csvEntity.setレコード種別1(定数_ONE);
        csvEntity.setレコード番号連1(定数_ONE);
        csvEntity.setボリュム通番(定数_ZERO);
        csvEntity.setレコード件数(定数_ONE);
        csvEntity.setデータ種別(データ種別);
        csvEntity.set福祉事務所特定番号(定数_ZERO);

        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<KoikiZenShichosonJoho> list = finder.koseiShichosonJoho();
        RString 証記載保険者番号 = RString.EMPTY;
        if (list != null && !list.records().isEmpty()) {
            証記載保険者番号 = list.records().get(0).get証記載保険者番号().getColumnValue();

        }
        csvEntity.set保険者番号(証記載保険者番号);

        csvEntity.set事業所番号(定数_ZERO);
        csvEntity.set都道府県番号(定数_ZERO);

        RString 媒体区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_媒体区分,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        csvEntity.set媒体区分(媒体区分);

        csvEntity.set処理対象年月(RDate.getNowDate().getYearMonth().toDateString());
        csvEntity.setファイル管理番号(定数_ONE);
        csvEntity.setブランク1(ブランク);

    }

    private void editorファイルの第二レコード(JukyushaTeiseiRenrakuhyoCsvEntity csvEntity, JukyushaIdoRenrakuhyoTorokuEntity entity) {
        csvEntity.setレコード種別2(定数_TWO);
        csvEntity.setレコード番号連2(定数_TWO);
        csvEntity.set交換情報識別番号(交換情報識別番号);
        csvEntity.setレコード種別コード(レコード種別コード);
        csvEntity.set異動年月日(formatYMD(entity.get異動年月日()));
        csvEntity.set異動事由(entity.get異動事由());
        csvEntity.set訂正年月日(formatYMD(entity.get訂正年月日()));
        csvEntity.set訂正区分コード(entity.get訂正区分コード());
        csvEntity.set証記載保険者番号(entity.get証記載保険者番号());
        csvEntity.set被保険者番号(entity.get被保険者番号());
        csvEntity.set被保険者氏名カナ(entity.get被保険者氏名カナ());
        csvEntity.set生年月日(formatYMD(entity.get生年月日()));
        csvEntity.set性別コード(entity.get性別());
        csvEntity.set資格取得年月日(formatYMD(entity.get資格取得年月日()));
        csvEntity.set資格喪失年月日(formatYMD(entity.get資格喪失年月日()));
        csvEntity.set老人保健市町村番号(entity.get老人保健市町村番号());
        csvEntity.set老人保健受給者番号(entity.get老人保健受給者番号());
        csvEntity.set申請種別コード(entity.get申請種別());
        csvEntity.set変更申請中区分コード(entity.get変更申請中区分());
        csvEntity.set申請年月日(formatYMD(entity.get申請年月日()));
        csvEntity.setみなし要介護区分コード(entity.getみなし区分());
        csvEntity.set要介護状態区分コード(entity.get要介護状態区分());
        csvEntity.set認定有効期間開始年月日(formatYMD(entity.get有効期間開始年月日()));
        csvEntity.set認定有効期間終了年月日(formatYMD(entity.get有効期間終了年月日()));
        csvEntity.set居宅サービス計画作成区分コード(entity.get計画作成区分());
        csvEntity.set居宅介護支援事業所番号(entity.get居宅支援事業者番号());
        csvEntity.set居宅サービス計画適用開始年月日(formatYMD(entity.get居宅適用開始年月日()));
        csvEntity.set居宅サービス計画適用終了年月日(formatYMD(entity.get居宅適用終了年月日()));
        csvEntity.set訪問通所支給限度基準額(entity.get支給限度基準額1());
        csvEntity.set訪問通所上限管理適用期間開始年月日(formatYMD(entity.get上限管理適用開始年月日１()));
        csvEntity.set訪問通所上限管理適用期間終了年月日(formatYMD(entity.get上限管理終了年月日１()));
        csvEntity.set短期入所支給限度基準額(entity.get支給限度基準額２());
        csvEntity.set短期入所上限管理適用期間開始年月日(formatYMD(entity.get上限管理適用開始年月日２()));
        csvEntity.set短期入所上限管理適用期間終了年月日(formatYMD(entity.get上限管理終了年月日２()));
        csvEntity.set公費負担上限額減額の有無(new RString(entity.get公費負担上限額減額().toString()));
        csvEntity.set償還払化開始年月日(formatYMD(entity.get償還払化適用開始年月日()));
        csvEntity.set償還払化終了年月日(formatYMD(entity.get償還払化適用終了年月日()));
        csvEntity.set給付率引下げ開始年月日(formatYMD(entity.get給付率引下げ適用開始年月日()));
        csvEntity.set給付率引下げ終了年月日(formatYMD(entity.get給付率引下げ適用終了年月日()));
        csvEntity.set旧措置入所者減免申請中区分コード(entity.get減免申請中区分());
        csvEntity.set旧措置入所者利用者負担区分コード(entity.get利用者負担区分());
        csvEntity.set旧措置入所者給付率(entity.get利用給付率());
        csvEntity.set旧措置入所者適用開始年月日(formatYMD(entity.get利用適用開始年月日()));
        csvEntity.set旧措置入所者適用終了年月日(formatYMD(entity.get利用適用終了年月日()));
        csvEntity.set特定標準負担標準負担区分コード(entity.get標準負担区分());
        csvEntity.set特定標準負担標準負担額(entity.get標準負担額());
        csvEntity.set特定標準負担負担額適用開始年月日(formatYMD(entity.get標準適用開始年月日()));
        csvEntity.set特定標準負担負担額適用終了年月日(formatYMD(entity.get標準適用終了年月日()));
        csvEntity.set特定入所者認定申請中区分コード(entity.get認定申請中区分());
        csvEntity.set特定入所者介護サービス区分コード(entity.getｻｰﾋﾞｽ区分());
        csvEntity.set課税層の特例減額措置対象(entity.get特例減額措置対象());
        csvEntity.set食費負担限度額(entity.get食費負担限度額());
        csvEntity.set居住費ユニット型個室負担限度額(entity.getﾕﾆｯﾄ型個室());
        csvEntity.set居住費ユニット型準個室負担限度額(entity.getﾕﾆｯﾄ型準個室());
        csvEntity.set居住費従来型個室特養等負担限度額(entity.get従来型個室特());
        csvEntity.set居住費従来型個室老健療養等負担限度額(entity.get従来型個室老療());
        csvEntity.set居住費多床室負担限度額(entity.get多床室());
        csvEntity.set負担限度額適用開始年月日(formatYMD(entity.get特定入所者適用開始年月日()));
        csvEntity.set負担限度額適用終了年月日(formatYMD(entity.get特定入所者適用終了年月日()));
        csvEntity.set社会福祉法人軽減情報軽減率(entity.get軽減率());
        csvEntity.set軽減率適用開始年月日(formatYMD(entity.get軽減率適用開始年月日()));
        csvEntity.set軽減率適用終了年月日(formatYMD(entity.get軽減率適用終了年月日()));
        csvEntity.set小規模多機能型居宅介護利用の有無(new RString(entity.get小規模居宅ｻｰﾋﾞｽ利用().toString()));
        csvEntity.set後期高齢視者保険者番号後期(entity.get後期高齢保険者番号());
        csvEntity.set後期高齢視者被保険者番号後期(entity.get後期高齢被保険者番号());
        csvEntity.set国民健康保険資格保険者番号国保(entity.get国保保険者番号());
        csvEntity.set国民健康保険資格被保険者証番号国保(entity.get国保被保険者証番号());
        csvEntity.set国民健康保険資格個人番号国保(entity.get国保個人番号());
        csvEntity.set二次予防事業区分コード(entity.get二次予防事業区分());
        csvEntity.set二次予防事業有効期間開始年月日(formatYMD(entity.get二次予防有効期間開始年月日()));
        csvEntity.set二次予防事業有効期間終了年月日(formatYMD(entity.get二次予防有効期間終了年月日()));
        csvEntity.set住所地特例住所地特例対象者区分コード(entity.get住特対象者区分());
        csvEntity.set住所地特例施設所在保険者番号(entity.get住特施設所在保険者番号());
        csvEntity.set住所地特例住所地特例適用開始年月日(formatYMD(entity.get住特適用開始年月日()));
        csvEntity.set住所地特例住所地特例適用終了年月日(formatYMD(entity.get住特適用終了年月日()));
        csvEntity.set居住費新１負担限度額(entity.get新１());
        csvEntity.set居住費新２負担限度額(entity.get新２());
        csvEntity.set居住費新３負担限度額(entity.get新３());
        csvEntity.set二割負担適用開始年月日(formatYMD(entity.get二割負担適用開始年月日()));
        csvEntity.set二割負担適用終了年月日(formatYMD(entity.get二割負担適用終了年月日()));
        csvEntity.setブランク2(ブランク);

    }

    private void editorファイルの最終レコード(JukyushaTeiseiRenrakuhyoCsvEntity csvEntity) {
        csvEntity.setレコード種別3(定数_THREE);
        csvEntity.setレコード番号連3(定数_THREE);
        csvEntity.setブランク3(ブランク);
    }

    private RString formatYMD(FlexibleDate yearMonthDay) {
        return yearMonthDay.seireki().separator(Separator.NONE)
                .fillType(FillType.NONE).toDateString();
    }
}
