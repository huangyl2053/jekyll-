/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd492001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ShinchokuNoTorikomiRisutoFairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.TorikomiErarisutofairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.ErrordataIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.JinbunoQurirumirisutofairuYishiteburuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイルの出力の編集ビジネスクラスです。
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class Csvfileeditbusiness {

    /**
     * ファイルの出力の編集ファイルをセット
     *
     * @param csventity ShinchokuNoTorikomiRisutoFairuCSVEntity
     * @param entity DbT4003YokaigoNinteiInterfaceEntity
     */
    public void editFairuCSV(ShinchokuNoTorikomiRisutoFairuCSVEntity csventity, JinbunoQurirumirisutofairuYishiteburuEntity entity) {
        csventity.set識別コード(entity.getShikibetsukodo());
        csventity.set識別コード名称(entity.getShikibetsukodo_meisho());
        csventity.set保険者番号(entity.getHokenshabango());
        csventity.set被保険者番号(entity.getHihokenjabango());
        csventity.set認定申請日(new RString(entity.getNinteishinseibi().toString()));
        csventity.set枝番(entity.getEdaban());
        csventity.set申請区分_法令_コード(entity.getShinseikubunhorei());
        csventity.set申請区分_法令_コード名称(entity.getShinseikubunhorei_meisho());
        csventity.set申請区分_申請時_コード(entity.getShinseikubunshinseiji());
        csventity.set申請区分_申請時_コード名称(entity.getShinseikubunshinseiji_meisho());
        csventity.set取下区分コード(entity.getTorisakubunkodo());
        csventity.set取下区分コード名称(entity.getTorisakubunkodo_meisho());
        csventity.set被保険者区分コード(entity.getHihokenjakubun());
        csventity.set被保険者区分コード名称(entity.getHihokenjakubun_meisho());
        csventity.set申請代行区分コード(entity.getShinseidaikokubun());
        csventity.set申請代行区分コード名称(entity.getShinseidaikokubun_meisho());
        if (entity.getSeinengappi() != null && !entity.getSeinengappi().isEmpty()) {
            csventity.set生年月日(new RString(entity.getSeinengappi().toString()));
        } else {
            csventity.set生年月日(RString.EMPTY);
        }
        csventity.set年齢(entity.getNenrei());
        csventity.set性別コード(entity.getSeibetsukodo());
        csventity.set性別コード名称(entity.getSeibetsukodo_meisho());
        csventity.set被保険者ｶﾅ氏名(entity.getHihokenjakanashimei());
        csventity.set被保険者漢字氏名(entity.getHihokenjakanjishimei());
        csventity.set郵便番号(entity.getYubenbango());
        csventity.set住所(entity.getJusho());
        csventity.set電話番号(entity.getTenwabango());
        csventity.set病院施設等の名称(entity.getByoinshisetsutonomeisho());
        csventity.set病院施設等の所在地(entity.getByoinshisetsutonoshozaichi());
        csventity.set前回の認定審査会結果(entity.getZenkainoninteishinsakaikekka());
        csventity.set前回の認定審査会結果名称(entity.getZenkainoninteishinsakaikekka_meisho());
        if (entity.getZenkainoninteiyukokigenkaishi() != null && !entity.getZenkainoninteiyukokigenkaishi().isEmpty()) {
            csventity.set前回の認定有効期間_開始(new RString(entity.getZenkainoninteiyukokigenkaishi().toString()));
        } else {
            csventity.set前回の認定有効期間_開始(RString.EMPTY);
        }
        if (entity.getZenkainoninteiyukokigenshuryo() != null && !entity.getZenkainoninteiyukokigenshuryo().isEmpty()) {
            csventity.set前回の認定有効期間_終了(new RString(entity.getZenkainoninteiyukokigenshuryo().toString()));
        } else {
            csventity.set前回の認定有効期間_終了(RString.EMPTY);
        }
        csventity.set主治医医療機関番号(entity.getShujiiiryokikanbango());
        csventity.set主治医番号(entity.getShujiibango());
        if (entity.getLkenshoiraibi() != null && !entity.getLkenshoiraibi().isEmpty()) {
            csventity.set意見書依頼日(new RString(entity.getLkenshoiraibi().toString()));
        } else {
            csventity.set意見書依頼日(RString.EMPTY);
        }
        if (entity.getLkenshonyushubi() != null && !entity.getLkenshonyushubi().isEmpty()) {
            csventity.set意見書入手日(new RString(entity.getLkenshonyushubi().toString()));
        } else {
            csventity.set意見書入手日(RString.EMPTY);
        }
        csventity.set意見書_短期記憶(entity.getLkensho_tankikioku());
        csventity.set意見書_認知能力(entity.getLkensho_ninchinoryoku());
        csventity.set意見書_伝達能力(entity.getLkensho_dentatsunoryoku());
        csventity.set意見書_食事行為(entity.getLkensho_shokujikoi());
        csventity.set意見書_認知症高齢者の日常生活自立度(entity.getLkensho_ninshishokoreishajiritsudo());
        if (entity.getChosairaibi() != null && !entity.getChosairaibi().isEmpty()) {
            csventity.set調査依頼日(new RString(entity.getChosairaibi().toString()));
        } else {
            csventity.set調査依頼日(RString.EMPTY);
        }
        if (entity.getChosajisshibi() != null && !entity.getChosajisshibi().isEmpty()) {
            csventity.set調査実施日(new RString(entity.getChosajisshibi().toString()));
        } else {
            csventity.set調査実施日(RString.EMPTY);
        }
        csventity.set指定居宅介護支援事業者等番号(entity.getShiteikyotakukaigoshienjigyoshatobango());
        csventity.set委託区分(entity.getLtakukubun());
        csventity.set委託区分名称(entity.getLtakukubun_meisho());
        csventity.set認定調査員番号(entity.getNinteichosainbango());
        csventity.set認定調査員資格コード(entity.getNinteichosainshikakukodo());
        csventity.set認定調査員資格コード名称(entity.getNinteichosainshikakukodo_meisho());
        if (entity.getLchijihanteibi() != null && !entity.getLchijihanteibi().isEmpty()) {
            csventity.set一次判定日(new RString(entity.getLchijihanteibi().toString()));
        } else {
            csventity.set一次判定日(RString.EMPTY);
        }
        csventity.set一次判定結果(entity.getLchijihanteikekka());
        csventity.set一次判定結果名称(entity.getLchijihanteikekka_meisho());
        csventity.set一次判定結果_認知症加算(entity.getLchijihanteikekka_ninshishokasan());
        csventity.set一次判定結果_認知症加算_名称(entity.getLchijihanteikekka_ninshishokasan_meisho());
        editFairuCSV2(csventity, entity);
    }

    /**
     * ファイルの出力の編集ファイルをセット
     *
     * @param csventity TorikomiErarisutofairuCSVEntity
     * @param entity ErrordataIchijiTeburuEntity
     */
    public void editErarCsv(TorikomiErarisutofairuCSVEntity csventity, ErrordataIchijiTeburuEntity entity) {
        csventity.set識別コード(entity.getShikibetsukodo());
        csventity.set保険者番号(entity.getHokenshabango());
        csventity.set被保険者番号(entity.getHihokenjabango());
        if (entity.getNinteishinseibi() != null && !entity.getNinteishinseibi().isEmpty()) {
            csventity.set認定申請日(new RString(entity.getNinteishinseibi().toString()));
        } else {
            csventity.set認定申請日(RString.EMPTY);
        }
        csventity.set枝番(entity.getEdaban());
        if (entity.getShinseikubunhorei() != null && !entity.getShinseikubunhorei().isEmpty()) {
            csventity.set申請区分_法令_コード(new RString(entity.getShinseikubunhorei().toString()));
        } else {
            csventity.set申請区分_法令_コード(RString.EMPTY);
        }
        csventity.set枝番(entity.getEdaban());
        if (entity.getShinseikubunshinseiji() != null && !entity.getShinseikubunshinseiji().isEmpty()) {
            csventity.set申請区分_申請時_コード(new RString(entity.getShinseikubunshinseiji().toString()));
        } else {
            csventity.set申請区分_申請時_コード(RString.EMPTY);
        }
        if (entity.getTorisakubunkodo() != null && !entity.getTorisakubunkodo().isEmpty()) {
            csventity.set取下区分コード(new RString(entity.getTorisakubunkodo().toString()));
        } else {
            csventity.set取下区分コード(RString.EMPTY);
        }
        if (entity.getHihokenjakubun() != null && !entity.getHihokenjakubun().isEmpty()) {
            csventity.set被保険者区分コード(new RString(entity.getHihokenjakubun().toString()));
        } else {
            csventity.set被保険者区分コード(RString.EMPTY);
        }
        if (entity.getShinseidaikokubun() != null && !entity.getShinseidaikokubun().isEmpty()) {
            csventity.set申請代行区分コード(new RString(entity.getShinseidaikokubun().toString()));
        } else {
            csventity.set申請代行区分コード(RString.EMPTY);
        }
        if (entity.getSeinengappi() != null && !entity.getSeinengappi().isEmpty()) {
            csventity.set生年月日(new RString(entity.getSeinengappi().toString()));
        } else {
            csventity.set生年月日(RString.EMPTY);
        }
        csventity.set年齢(new RString(entity.getNenrei()));
        editErarCsv2(csventity, entity);
    }

    private void editFairuCSV2(ShinchokuNoTorikomiRisutoFairuCSVEntity csventity, JinbunoQurirumirisutofairuYishiteburuEntity entity) {
        if (entity.getNinteishinsakaishiryosakuseibi() != null && !entity.getNinteishinsakaishiryosakuseibi().isEmpty()) {
            csventity.set認定審査会資料作成日(new RString(entity.getNinteishinsakaishiryosakuseibi().toString()));
        } else {
            csventity.set認定審査会資料作成日(RString.EMPTY);
        }
        if (entity.getNinteishinsakaiyoteibi() != null && !entity.getNinteishinsakaiyoteibi().isEmpty()) {
            csventity.set認定審査会予定日(new RString(entity.getNinteishinsakaiyoteibi().toString()));
        } else {
            csventity.set認定審査会予定日(RString.EMPTY);
        }
        csventity.set合議体番号(entity.getGogitaibango());
        csventity.set審査会資料番号(entity.getShinsakaishiryobango());
        if (entity.getNijihanteibi() != null && !entity.getNijihanteibi().isEmpty()) {
            csventity.set二次判定日(new RString(entity.getNijihanteibi().toString()));
        } else {
            csventity.set二次判定日(RString.EMPTY);
        }
        csventity.set二次判定結果(entity.getNijihanteikekka());
        csventity.set二次判定結果名称(entity.getNijihanteikekka_meisho());
        if (entity.getNinteiyukokigen_kaishi() != null && !entity.getNinteiyukokigen_kaishi().isEmpty()) {
            csventity.set認定有効期間_開始(new RString(entity.getNinteiyukokigen_kaishi().toString()));
        } else {
            csventity.set認定有効期間_開始(RString.EMPTY);
        }
        if (entity.getNinteiyukokigen_shuryo() != null && !entity.getNinteiyukokigen_shuryo().isEmpty()) {
            csventity.set認定有効期間_終了(new RString(entity.getNinteiyukokigen_shuryo().toString()));
        } else {
            csventity.set認定有効期間_終了(RString.EMPTY);
        }
        csventity.set特定疾病コード(entity.getTokuteishippeikodo());
        csventity.set特定疾病コード名称(entity.getTokuteishippeikodo_meisho());
        csventity.set要介護１の場合の状態像(entity.getYokaigo1nobaainojotaizo());
        csventity.set要介護１の場合の状態像名称(entity.getYokaigo1nobaainojotaizo_meisho());
        csventity.set現在のサービス区分コード(entity.getGenzainosabisukubunkodo());
        csventity.set現在のサービス区分コード名称(entity.getGenzainosabisukubunkodo_meisho());
        csventity.set現在の状況(entity.getGenzainojokyo());
        csventity.set現在の状況名称(entity.getGenzainojokyo_meisho());
    }

    private void editErarCsv2(TorikomiErarisutofairuCSVEntity csventity, ErrordataIchijiTeburuEntity entity) {
        if (entity.getSeibetsukodo() != null && !entity.getSeibetsukodo().isEmpty()) {
            csventity.set性別コード(new RString(entity.getSeibetsukodo().toString()));
        } else {
            csventity.set性別コード(RString.EMPTY);
        }
        if (entity.getHihokenjakanashimei() != null && !entity.getHihokenjakanashimei().isEmpty()) {
            csventity.set被保険者ｶﾅ氏名(new RString(entity.getHihokenjakanashimei().toString()));
        } else {
            csventity.set被保険者ｶﾅ氏名(RString.EMPTY);
        }
        if (entity.getHihokenjakanjishimei() != null && !entity.getHihokenjakanjishimei().isEmpty()) {
            csventity.set被保険者漢字氏名(new RString(entity.getHihokenjakanjishimei().toString()));
        } else {
            csventity.set被保険者漢字氏名(RString.EMPTY);
        }
        if (entity.getYubenbango() != null && !entity.getYubenbango().isEmpty()) {
            csventity.set郵便番号(new RString(entity.getYubenbango().toString()));
        } else {
            csventity.set郵便番号(RString.EMPTY);
        }
        if (entity.getJusho() != null && !entity.getJusho().isEmpty()) {
            csventity.set住所(new RString(entity.getJusho().toString()));
        } else {
            csventity.set住所(RString.EMPTY);
        }
        if (entity.getTenwabango() != null && !entity.getTenwabango().isEmpty()) {
            csventity.set電話番号(new RString(entity.getTenwabango().toString()));
        } else {
            csventity.set電話番号(RString.EMPTY);
        }
        csventity.set病院施設等の名称(entity.getByoinshisetsutonomeisho());
        csventity.set病院施設等の所在地(entity.getByoinshisetsutonoshozaichi());
        csventity.setエラーメッセージ(entity.getEramesseji());
    }
}
