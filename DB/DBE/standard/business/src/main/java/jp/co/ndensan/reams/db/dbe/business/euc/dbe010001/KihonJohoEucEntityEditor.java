/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.euc.dbe010001;

import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.KihonJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010001_KihonJohoEucEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.KanryoInfoPhase;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsIkenshoDoiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.NinteiShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.IsExistJohoTeikyoDoui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 申請者基本情報CSVエンティティ編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class KihonJohoEucEntityEditor {

    private static final RString 改行 = new RString("<br/>");
    private static final RString 下矢印 = new RString("↓");

    private KihonJohoEucEntityEditor() {
    }

    /**
     * DBE010001_KihonJohoEucEntityを編集して返します。
     *
     * @param entity KihonJohoEntity
     * @return DBE010001_KihonJohoEucEntity
     */
    public static DBE010001_KihonJohoEucEntity edit(KihonJohoEntity entity) {
        DBE010001_KihonJohoEucEntity eucEntity = new DBE010001_KihonJohoEucEntity();
        eucEntity.set申請書管理番号(entity.getShinseishoKanriNo());
        eucEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        eucEntity.set保険者名(entity.getShichosonMeisho());
        eucEntity.set被保険者番号(entity.getHihokenshaNo());
        eucEntity.set被保険者氏名(entity.getHihokenshaName().value());
        eucEntity.set被保険者氏名カナ(entity.getHihokenshaKana().value());
        eucEntity.set性別コード(entity.getSeibetsu().value());
        eucEntity.set性別(Gender.toValue(entity.getSeibetsu().value()).getCommonName());
        eucEntity.set生年月日(format日付(entity.getSeinengappiYMD()));
        eucEntity.set年齢(new RString(entity.getAge()));
        eucEntity.set被保険者区分コード(entity.getHihokenshaKubunCode());
        eucEntity.set被保険者区分(HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称());
        eucEntity.set_２号特定疾病コード(entity.getNigoTokuteiShippeiCode());
        eucEntity.set_２号特定疾病名(TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode()).get名称());
        eucEntity.set郵便番号(entity.getYubinNo().getEditedYubinNo());
        eucEntity.set住所(entity.getJusho().value());
        eucEntity.set電話番号(entity.getTelNo().value());
        eucEntity.set地区コード(entity.getChikuCode().value());
        eucEntity.set地区名(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                DBECodeShubetsu.調査地区コード.getコード(), new Code(entity.getChikuCode().value())));
        eucEntity.set申請日(format日付(entity.getNinteiShinseiYMD()));
        eucEntity.set申請書区分コード(entity.getShienShinseiKubun());
        eucEntity.set申請書区分(ShienShinseiKubun.toValue(entity.getShienShinseiKubun()).get名称());
        eucEntity.set申請区分_法令_コード(entity.getNinteiShinseiHoreiKubunCode().value());
        eucEntity.set申請区分_法令(NinteiShinseiHoreiCode.toValue(entity.getNinteiShinseiHoreiKubunCode().value()).get名称());
        eucEntity.set申請区分_申請時_コード(entity.getNinteiShinseiShinseijiKubunCode().value());
        eucEntity.set申請区分_申請時(NinteiShinseiShinseijiKubunCode.toValue(entity.getNinteiShinseiShinseijiKubunCode().value()).get名称());
        eucEntity.set処理状態区分コード(entity.getShoriJotaiKubun().value());
        eucEntity.set処理状態区分(ShoriJotaiKubun.toValue(entity.getShoriJotaiKubun().value()).get名称());
        eucEntity.set在宅or施設((entity.isShisetsuNyushoFlag()) ? ZaitakuShisetsuKubun.施設.get名称() : ZaitakuShisetsuKubun.在宅.get名称());
        eucEntity.set入所施設コード(
                (Integer.parseInt(entity.getNyushoShisetsuCode().toString()) == 0) ? entity.getNyushoShisetsuCode().value() : RString.EMPTY);
        eucEntity.set入所施設名称(entity.getNyushoShisetsuMeisho().value());
        eucEntity.set連絡先氏名(entity.getRenrakusakiShimei().value());
        eucEntity.set連絡先郵便番号(entity.getRenrakusakiYubinNo().getEditedYubinNo());
        eucEntity.set連絡先住所(entity.getRenrakusakiJusho().value());
        eucEntity.set連絡先電話番号(entity.getRenrakusakiTelNo().value());
        eucEntity.set連絡先携帯番号(entity.getRenrakusakiKeitaiTelNo().value());
        eucEntity.set連絡先続柄コード(entity.getRenrakusakiTuzukigara());
        eucEntity.set連絡先続柄(RensakusakiTsuzukigara.toValue(entity.getRenrakusakiTuzukigara()).get名称());
        eucEntity.set代行区分コード(entity.getShinseiTodokedeDaikoKubunCode().value());
        eucEntity.set代行区分(ShinseiTodokedeDaikoKubunCode.toValue(entity.getShinseiTodokedeDaikoKubunCode().value()).get名称());
        eucEntity.set届出者氏名(entity.getShinseiTodokedeshaShimei().value());
        eucEntity.set届出者郵便番号(entity.getShinseiTodokedeshaYubinNo().getEditedYubinNo());
        eucEntity.set届出者住所(entity.getShinseiTodokedeshaJusho().value());
        eucEntity.set届出者電話番号(entity.getShinseiTodokedeshaTelNo().value());
        eucEntity.set届出者続柄(entity.getShinseiTodokedeshaTsuzukigara());
        eucEntity.set事業者区分コード(entity.getJigyoshaKubun());
        eucEntity.set事業者区分(JigyoshaKubun.toValue(entity.getJigyoshaKubun()).get名称());
        eucEntity.set事業者番号(entity.getJigyoshaNo());
        eucEntity.set現在の段階(get現在の段階(entity));
        eucEntity.set申請登録完了日(format日付(entity.getNinteiShinseiJohoTorokuKanryoYMD()));
        eucEntity.set調査依頼完了日(format日付(entity.getNinteichosaIraiKanryoYMD()));
        eucEntity.set調査完了日(format日付(entity.getNinteichosaKanryoYMD()));
        eucEntity.set意見書依頼完了日(format日付(entity.getIkenshoSakuseiIraiKanryoYMD()));
        eucEntity.set意見書入手完了日(format日付(entity.getIkenshoTorokuKanryoYMD()));
        eucEntity.set一次判定完了日(format日付(entity.getIchijiHanteiKanryoYMD()));
        eucEntity.setマスキング完了日(format日付(entity.getMaskingKanryoYMD()));
        eucEntity.set審査会登録完了日(format日付(entity.getNinteiShinsakaiWariateKanryoYMD()));
        eucEntity.set二次判定完了日(format日付(entity.getNinteiShinsakaiKanryoYMD()));
        eucEntity.setセンター送信完了日(format日付(entity.getCenterSoshinYMD()));
        eucEntity.set調査区分コード(entity.getNinteiChosaKubunCode().value());
        eucEntity.set調査区分(ChosaKubun.toValue(entity.getNinteiChosaKubunCode().value()).get名称());
        eucEntity.set調査実施日(format日付(entity.getNinteichosaJisshiYMD()));
        eucEntity.set調査委託先コード(entity.getChosaItakusakiCode().value());
        eucEntity.set調査委託先名称(entity.getJigyoshaMeisho());
        eucEntity.set調査員コード(entity.getChosainCode());
        eucEntity.set調査員名(entity.getChosainShimei());
        eucEntity.set実施場所コード(entity.getChosaJisshiBashoCode().value());
        eucEntity.set実施場所(ChosaJisshiBashoCode.toValue(entity.getChosaJisshiBashoCode().value()).get名称());
        eucEntity.set実施場所名称(entity.getChosaJisshiBashoMeisho());
        eucEntity.set調査_障害高齢者の日常生活自立度コード(entity.getShogaiNichijoSeikatsuJiritsudoCode().value());
        eucEntity.set調査_障害高齢者の日常生活自立度(
                ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.getShogaiNichijoSeikatsuJiritsudoCode().value()).get名称());
        eucEntity.set調査_認知症高齢者の日常生活自立度コード(entity.getNinchishoNichijoSeikatsuJiritsudoCode().value());
        eucEntity.set調査_認知症高齢者の日常生活自立度(
                NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getNinchishoNichijoSeikatsuJiritsudoCode().value()).get名称());
        eucEntity.set医療機関コード(entity.getShujiiIryoKikanCode());
        eucEntity.set医療機関名称(entity.getIryoKikanMeisho());
        eucEntity.set主治医コード(entity.getShujiiCode());
        eucEntity.set主治医名(entity.getShujiiName());
        eucEntity.set記入日(format日付(entity.getIkenshoKinyuYMD()));
        eucEntity.set最終診療日(format日付(entity.getSaishuShinryoYMD()));
        eucEntity.set意見書同意(IsIkenshoDoiUmu.toValue(entity.isIkenshoDoiFlag()).get名称());
        eucEntity.set意見書作成回数区分コード(entity.getIkenshoSakuseiKaisuKubun().value());
        eucEntity.set意見書作成回数区分(IkenshoSakuseiKaisuKubun.toValue(entity.getIkenshoSakuseiKaisuKubun().value()).get名称());
        eucEntity.set意見_障害高齢者の日常生活自立度コード(entity.getIkenshoNetakirido());
        eucEntity.set意見_障害高齢者の日常生活自立度(IkenKomoku02.toValue(entity.getIkenshoNetakirido()).get名称());
        eucEntity.set意見_認知症高齢者の日常生活自立度コード(entity.getIkenshoNinchido());
        eucEntity.set意見_認知症高齢者の日常生活自立度(IkenKomoku03.toValue(entity.getIkenshoNinchido()).get名称());
        eucEntity.set一次判定日(format日付(entity.getIchijiHanteiYMD()));
        eucEntity.set一次判定結果コード(entity.getIchijiHanteiKekkaCode().value());
        eucEntity.set一次判定結果コード_認知症加算(entity.getIchijiHanteiKekkaNinchishoKasanCode().value());
        eucEntity.set一_五次判定日(format日付(entity.getIchiGojiHanteiYMD()));
        eucEntity.set一_五次判定結果コード(entity.getIchiGojiHanteiKekkaCode().value());
        eucEntity.set一_五次判定結果コード_認知症加算(entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value());
        eucEntity.set二次判定日(format日付(entity.getNijiHanteiYMD()));
        eucEntity.set二次判定結果コード(entity.getNijiHanteiYokaigoJotaiKubunCode().value());
        eucEntity.set認定有効期間(new RString(entity.getNijiHanteiNinteiYukoKikan()));
        eucEntity.set認定有効開始日(format日付(entity.getNijiHanteiNinteiYukoKaishiYMD()));
        eucEntity.set認定有効終了日(format日付(entity.getNijiHanteiNinteiYukoShuryoYMD()));
        eucEntity.set要介護状態像例コード(entity.getYokaigoJotaizoReiCode().value());
        eucEntity.set要介護状態像例(YokaigoJotaizoReiCode.toValue(entity.getYokaigoJotaizoReiCode().value()).get名称());
        eucEntity.set一次判定結果変更理由(convert改行(entity.getIchijiHanteiKekkaHenkoRiyu()));
        eucEntity.set審査会意見種類コード(entity.getNinteishinsakaiIkenShurui());
        eucEntity.set審査会意見種類(NinteiShinsakaiIkenShurui.toValue(entity.getNinteishinsakaiIkenShurui()).get名称());
        eucEntity.set審査会意見(convert改行(entity.getShinsakaiIken()));
        eucEntity.set審査会メモ(convert改行(entity.getShinsakaiMemo()));
        eucEntity.set審査会開催番号(entity.getShinsakaiKaisaiNo());
        eucEntity.set予定_合議体番号(new RString(entity.getYoteiGogitaiNo()));
        eucEntity.set予定_開催日(format日付(entity.getShinsakaiKaisaiYoteiYMD()));
        eucEntity.set結果_合議体番号(new RString(entity.getKekkaGogitaiNo()));
        eucEntity.set結果_開催日(format日付(entity.getShinsakaiKaisaiYMD()));
        eucEntity.set判定結果コード(entity.getHanteiKekkaCode().value());
        eucEntity.set判定結果(HanteiKekkaCode.toValue(entity.getHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一次判定日(format日付(entity.getZenkaiIchijiHanteiYMD()));
        eucEntity.set前回_一次判定結果コード(entity.getZenkaiIchijiHanteiKekkaCode().value());
        eucEntity.set前回_一次判定結果コード_認知症加算(entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value());
        eucEntity.set前回_一_五次判定日(format日付(entity.getZenkaiIchiGojiHanteiYMD()));
        eucEntity.set前回_一_五次判定結果コード(entity.getZenkaiIchiGojiHanteiKekkaCode().value());
        eucEntity.set前回_一_五次判定結果コード_認知症加算(entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value());
        eucEntity.set前回_二次判定日(format日付(entity.getZenkaiNijiHanteiYMD()));
        eucEntity.set前回_二次判定結果コード(entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value());
        eucEntity.set前回_認定有効期間(new RString(entity.getZenkaiNijiHanteiNinteiYukoKikan()));
        eucEntity.set前回_認定有効開始日(format日付(entity.getZenkaiNijiHanteiNinteiYukoKaishiYMD()));
        eucEntity.set前回_認定有効終了日(format日付(entity.getZenkaiNijiHanteiNinteiYukoShuryoYMD()));
        eucEntity.set情報提供同意有無(IsExistJohoTeikyoDoui.toValue(entity.isJohoteikyoDoiFlag()).get名称());
        eucEntity.set厚労省IF識別コード(entity.getKoroshoIfShikibetsuCode().value());
        eucEntity.set認定申請情報抽出日(format日付(entity.getNinteiShinseiJohoChushutsuYMD()));
        eucEntity.set認定調査結果情報抽出日(format日付(entity.getNinteiChosaKekkaJohoChushutsuYMD()));
        eucEntity.set認定調査_意見書結果情報抽出日(format日付(entity.getNinteiChosaIkenshoKekkaJohoChushutsuYMD()));
        eucEntity.set一次判定情報抽出日(format日付(entity.getIchijihanteiChushutsuYMD()));
        eucEntity.set審査会結果情報抽出日(format日付(entity.getShinsakaiKekkaJohoChushutsuYMD()));
        eucEntity.setセンター送信情報抽出日(format日付(entity.getCenterSoshinChushutsuYMD()));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.asCode().equals(entity.getKoroshoIfShikibetsuCode())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_09(eucEntity, entity);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_06(eucEntity, entity);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_02(eucEntity, entity);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_99(eucEntity, entity);
        }
        return eucEntity;
    }

    private static RString get現在の段階(KihonJohoEntity entity) {
        if (entity.getNinteiShinseiJohoTorokuKanryoYMD() == null) {
            return KanryoInfoPhase.申請受付.get名称();
        } else if (entity.getNinteichosaIraiKanryoYMD() == null) {
            return KanryoInfoPhase.調査依頼.get名称();
        } else if (entity.getIkenshoSakuseiIraiKanryoYMD() == null) {
            return KanryoInfoPhase.意見書依頼.get名称();
        } else if (entity.getNinteichosaKanryoYMD() == null) {
            return KanryoInfoPhase.調査入手.get名称();
        } else if (entity.getIkenshoTorokuKanryoYMD() == null) {
            return KanryoInfoPhase.意見書入手.get名称();
        } else if (entity.getIchijiHanteiKanryoYMD() == null) {
            return KanryoInfoPhase.一次判定.get名称();
        } else if (entity.getMaskingKanryoYMD() == null) {
            return KanryoInfoPhase.マスキング.get名称();
        } else if (entity.getNinteiShinsakaiWariateKanryoYMD() == null) {
            return KanryoInfoPhase.審査会登録.get名称();
        } else if (entity.getNinteiShinsakaiKanryoYMD() == null) {
            return KanryoInfoPhase.二次判定.get名称();
        } else if (entity.getCenterSoshinYMD() == null) {
            return KanryoInfoPhase.月例処理.get名称();
        }
        return new RString("完了");
    }

    private static void set判定結果_09(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity) {
        eucEntity.set一次判定結果(IchijiHanteiKekkaCode09.toValue(
                entity.getIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set一次判定結果_認知症加算(IchijiHanteiKekkaCode09.toValue(
                entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set一_五次判定結果(IchijiHanteiKekkaCode09.toValue(
                entity.getIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set一_五次判定結果_認知症加算(IchijiHanteiKekkaCode09.toValue(
                entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set二次判定結果(YokaigoJotaiKubun09.toValue(
                entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
        eucEntity.set前回_一次判定結果(IchijiHanteiKekkaCode09.toValue(
                entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一次判定結果_認知症加算(IchijiHanteiKekkaCode09.toValue(
                entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果(IchijiHanteiKekkaCode09.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果_認知症加算(IchijiHanteiKekkaCode09.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_二次判定結果(YokaigoJotaiKubun09.toValue(
                entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
    }

    private static void set判定結果_06(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity) {
        eucEntity.set一次判定結果(IchijiHanteiKekkaCode06.toValue(
                entity.getIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set一次判定結果_認知症加算(IchijiHanteiKekkaCode06.toValue(
                entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set一_五次判定結果(IchijiHanteiKekkaCode06.toValue(
                entity.getIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set一_五次判定結果_認知症加算(IchijiHanteiKekkaCode06.toValue(
                entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set二次判定結果(YokaigoJotaiKubun06.toValue(
                entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
        eucEntity.set前回_一次判定結果(IchijiHanteiKekkaCode06.toValue(
                entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一次判定結果_認知症加算(IchijiHanteiKekkaCode06.toValue(
                entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果(IchijiHanteiKekkaCode06.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果_認知症加算(IchijiHanteiKekkaCode06.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_二次判定結果(YokaigoJotaiKubun06.toValue(
                entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
    }

    private static void set判定結果_02(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity) {
        eucEntity.set一次判定結果(IchijiHanteiKekkaCode02.toValue(
                entity.getIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set一次判定結果_認知症加算(IchijiHanteiKekkaCode02.toValue(
                entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set一_五次判定結果(IchijiHanteiKekkaCode02.toValue(
                entity.getIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set一_五次判定結果_認知症加算(IchijiHanteiKekkaCode02.toValue(
                entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set二次判定結果(YokaigoJotaiKubun02.toValue(
                entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
        eucEntity.set前回_一次判定結果(IchijiHanteiKekkaCode02.toValue(
                entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一次判定結果_認知症加算(IchijiHanteiKekkaCode02.toValue(
                entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果(IchijiHanteiKekkaCode02.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果_認知症加算(IchijiHanteiKekkaCode02.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_二次判定結果(YokaigoJotaiKubun02.toValue(
                entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
    }

    private static void set判定結果_99(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity) {
        eucEntity.set一次判定結果(IchijiHanteiKekkaCode99.toValue(
                entity.getIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set一次判定結果_認知症加算(IchijiHanteiKekkaCode99.toValue(
                entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set一_五次判定結果(IchijiHanteiKekkaCode99.toValue(
                entity.getIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set一_五次判定結果_認知症加算(IchijiHanteiKekkaCode99.toValue(
                entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set二次判定結果(YokaigoJotaiKubun99.toValue(
                entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
        eucEntity.set前回_一次判定結果(IchijiHanteiKekkaCode99.toValue(
                entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一次判定結果_認知症加算(IchijiHanteiKekkaCode99.toValue(
                entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果(IchijiHanteiKekkaCode99.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称());
        eucEntity.set前回_一_五次判定結果_認知症加算(IchijiHanteiKekkaCode99.toValue(
                entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称());
        eucEntity.set前回_二次判定結果(YokaigoJotaiKubun99.toValue(
                entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称());
    }

    private static RString format日付(FlexibleDate value) {
        return value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private static RString convert改行(RString text) {
        return new RStringBuilder(text).replace(改行, 下矢印).toRString();
    }
}
