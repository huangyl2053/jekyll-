/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.euc.dbe010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.Renban;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.KihonJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout.DBE010001_KihonJohoEucEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
     * @param 意見項目List DbT5304ShujiiIkenshoIkenItemEntityのリスト
     * @return DBE010001_KihonJohoEucEntity
     */
    public static DBE010001_KihonJohoEucEntity edit(KihonJohoEntity entity,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List) {
        DBE010001_KihonJohoEucEntity eucEntity = new DBE010001_KihonJohoEucEntity();
        eucEntity.set申請書管理番号(entity.getShinseishoKanriNo());
        eucEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        eucEntity.set保険者名(entity.getShichosonMeisho());
        eucEntity.set被保険者番号(entity.getHihokenshaNo());
        eucEntity.set被保険者氏名(nullToEmpty(entity.getHihokenshaName()));
        eucEntity.set被保険者氏名カナ(nullToEmpty(entity.getHihokenshaKana()));
        eucEntity.set性別コード(nullToEmpty(entity.getSeibetsu()));
        eucEntity.set性別((entity.getSeibetsu() != null && !entity.getSeibetsu().isEmpty())
                ? Gender.toValue(entity.getSeibetsu().value()).getCommonName() : RString.EMPTY);
        eucEntity.set生年月日(format日付(entity.getSeinengappiYMD()));
        eucEntity.set年齢(new RString(entity.getAge()));
        eucEntity.set被保険者区分コード(entity.getHihokenshaKubunCode());
        eucEntity.set被保険者区分((!RString.isNullOrEmpty(entity.getHihokenshaKubunCode()))
                ? HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称() : RString.EMPTY);
        eucEntity.set_２号特定疾病コード(entity.getNigoTokuteiShippeiCode());
        eucEntity.set_２号特定疾病名((!RString.isNullOrEmpty(entity.getNigoTokuteiShippeiCode()))
                ? TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode()).get名称() : RString.EMPTY);
        eucEntity.set郵便番号(nullToEmpty(entity.getYubinNo()));
        eucEntity.set住所(nullToEmpty(entity.getJusho()));
        eucEntity.set電話番号(nullToEmpty(entity.getTelNo()));
        eucEntity.set地区コード(nullToEmpty(entity.getChikuCode()));
        eucEntity.set地区名(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                DBECodeShubetsu.調査地区コード.getコード(), new Code(entity.getChikuCode().value())));
        eucEntity.set申請日(format日付(entity.getNinteiShinseiYMD()));
        eucEntity.set申請書区分コード(entity.getShienShinseiKubun());
        eucEntity.set申請書区分((!RString.isNullOrEmpty(entity.getShienShinseiKubun()))
                ? ShienShinseiKubun.toValue(entity.getShienShinseiKubun()).get名称() : RString.EMPTY);
        eucEntity.set申請区分_法令_コード(nullToEmpty(entity.getNinteiShinseiHoreiKubunCode()));
        eucEntity.set申請区分_法令((entity.getNinteiShinseiHoreiKubunCode() != null && !entity.getNinteiShinseiHoreiKubunCode().isEmpty())
                ? NinteiShinseiHoreiCode.toValue(entity.getNinteiShinseiHoreiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set申請区分_申請時_コード(nullToEmpty(entity.getNinteiShinseiShinseijiKubunCode()));
        eucEntity.set申請区分_申請時((entity.getNinteiShinseiShinseijiKubunCode() != null && !entity.getNinteiShinseiShinseijiKubunCode().isEmpty())
                ? NinteiShinseiShinseijiKubunCode.toValue(entity.getNinteiShinseiShinseijiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set処理状態区分コード(nullToEmpty(entity.getShoriJotaiKubun()));
        eucEntity.set処理状態区分((entity.getShoriJotaiKubun() != null && !entity.getShoriJotaiKubun().isEmpty())
                ? ShoriJotaiKubun.toValue(entity.getShoriJotaiKubun().value()).get名称() : RString.EMPTY);
        eucEntity.set在宅or施設((entity.isShisetsuNyushoFlag()) ? ZaitakuShisetsuKubun.施設.get名称() : ZaitakuShisetsuKubun.在宅.get名称());
        eucEntity.set入所施設コード((entity.getNyushoShisetsuCode() != null && Integer.parseInt(entity.getNyushoShisetsuCode().toString()) == 0)
                ? entity.getNyushoShisetsuCode().value() : RString.EMPTY);
        eucEntity.set入所施設名称(nullToEmpty(entity.getNyushoShisetsuMeisho()));
        eucEntity.set連絡先氏名(nullToEmpty(entity.getRenrakusakiShimei()));
        eucEntity.set連絡先郵便番号(nullToEmpty(entity.getRenrakusakiYubinNo()));
        eucEntity.set連絡先住所(nullToEmpty(entity.getRenrakusakiJusho()));
        eucEntity.set連絡先電話番号(nullToEmpty(entity.getRenrakusakiTelNo()));
        eucEntity.set連絡先携帯番号(nullToEmpty(entity.getRenrakusakiKeitaiTelNo()));
        eucEntity.set連絡先続柄コード(entity.getRenrakusakiTuzukigara());
        eucEntity.set連絡先続柄((!RString.isNullOrEmpty(entity.getRenrakusakiTuzukigara()))
                ? RensakusakiTsuzukigara.toValue(entity.getRenrakusakiTuzukigara()).get名称() : RString.EMPTY);
        eucEntity.set代行区分コード(nullToEmpty(entity.getShinseiTodokedeDaikoKubunCode()));
        eucEntity.set代行区分((entity.getShinseiTodokedeDaikoKubunCode() != null && !entity.getShinseiTodokedeDaikoKubunCode().isEmpty())
                ? ShinseiTodokedeDaikoKubunCode.toValue(entity.getShinseiTodokedeDaikoKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set届出者氏名(nullToEmpty(entity.getShinseiTodokedeshaShimei()));
        eucEntity.set届出者郵便番号(nullToEmpty(entity.getShinseiTodokedeshaYubinNo()));
        eucEntity.set届出者住所(nullToEmpty(entity.getShinseiTodokedeshaJusho()));
        eucEntity.set届出者電話番号(nullToEmpty(entity.getShinseiTodokedeshaTelNo()));
        eucEntity.set届出者続柄(entity.getShinseiTodokedeshaTsuzukigara());
        eucEntity.set事業者区分コード(entity.getJigyoshaKubun());
        eucEntity.set事業者区分((!RString.isNullOrEmpty(entity.getJigyoshaKubun()))
                ? JigyoshaKubun.toValue(entity.getJigyoshaKubun()).get名称() : RString.EMPTY);
        eucEntity.set事業者番号(entity.getShinseiTodokedeDaikoJigyoshaNo());
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
        eucEntity.set調査区分コード(nullToEmpty(entity.getNinteiChosaKubunCode()));
        eucEntity.set調査区分((entity.getNinteiChosaKubunCode() != null && !entity.getNinteiChosaKubunCode().isEmpty())
                ? ChosaKubun.toValue(entity.getNinteiChosaKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set調査実施日(format日付(entity.getNinteichosaJisshiYMD()));
        eucEntity.set調査委託先コード(nullToEmpty(entity.getChosaItakusakiCode()));
        eucEntity.set調査委託先名称(entity.getJigyoshaMeisho());
        eucEntity.set調査員コード(entity.getChosainCode());
        eucEntity.set調査員名(entity.getChosainShimei());
        eucEntity.set実施場所コード(nullToEmpty(entity.getChosaJisshiBashoCode()));
        eucEntity.set実施場所((entity.getChosaJisshiBashoCode() != null && !entity.getChosaJisshiBashoCode().isEmpty())
                ? ChosaJisshiBashoCode.toValue(entity.getChosaJisshiBashoCode().value()).get名称() : RString.EMPTY);
        eucEntity.set実施場所名称(entity.getChosaJisshiBashoMeisho());
        eucEntity.set調査_障害高齢者の日常生活自立度コード(nullToEmpty(entity.getShogaiNichijoSeikatsuJiritsudoCode()));
        eucEntity.set調査_障害高齢者の日常生活自立度(
                (entity.getShogaiNichijoSeikatsuJiritsudoCode() != null && !entity.getShogaiNichijoSeikatsuJiritsudoCode().isEmpty())
                ? ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.getShogaiNichijoSeikatsuJiritsudoCode().value()).get名称() : RString.EMPTY);
        eucEntity.set調査_認知症高齢者の日常生活自立度コード(nullToEmpty(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        eucEntity.set調査_認知症高齢者の日常生活自立度(
                (entity.getNinchishoNichijoSeikatsuJiritsudoCode() != null && !entity.getNinchishoNichijoSeikatsuJiritsudoCode().isEmpty())
                ? NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getNinchishoNichijoSeikatsuJiritsudoCode().value()).get名称()
                : RString.EMPTY);
        eucEntity.set医療機関コード(entity.getShujiiIryoKikanCode());
        eucEntity.set医療機関名称(entity.getIryoKikanMeisho());
        eucEntity.set主治医コード(entity.getShujiiCode());
        eucEntity.set主治医名(entity.getShujiiName());
        eucEntity.set記入日(format日付(entity.getIkenshoKinyuYMD()));
        eucEntity.set最終診療日(format日付(entity.getSaishuShinryoYMD()));
        eucEntity.set意見書同意(IsIkenshoDoiUmu.toValue(entity.isIkenshoDoiFlag()).get名称());
        eucEntity.set意見書作成回数区分コード(nullToEmpty(entity.getIkenshoSakuseiKaisuKubun()));
        eucEntity.set意見書作成回数区分((entity.getIkenshoSakuseiKaisuKubun() != null && !entity.getIkenshoSakuseiKaisuKubun().isEmpty())
                ? IkenshoSakuseiKaisuKubun.toValue(entity.getIkenshoSakuseiKaisuKubun().value()).get名称() : RString.EMPTY);
        eucEntity.set一次判定日(format日付(entity.getIchijiHanteiYMD()));
        eucEntity.set一次判定結果コード(nullToEmpty(entity.getIchijiHanteiKekkaCode()));
        eucEntity.set一次判定結果コード_認知症加算(nullToEmpty(entity.getIchijiHanteiKekkaNinchishoKasanCode()));
        eucEntity.set一_五次判定日(format日付(entity.getIchiGojiHanteiYMD()));
        eucEntity.set一_五次判定結果コード(nullToEmpty(entity.getIchiGojiHanteiKekkaCode()));
        eucEntity.set一_五次判定結果コード_認知症加算(nullToEmpty(entity.getIchiGojiHanteiKekkaNinchishoKasanCode()));
        eucEntity.set二次判定日(format日付(entity.getNijiHanteiYMD()));
        eucEntity.set二次判定結果コード(nullToEmpty(entity.getNijiHanteiYokaigoJotaiKubunCode()));
        eucEntity.set認定有効期間(new RString(entity.getNijiHanteiNinteiYukoKikan()));
        eucEntity.set認定有効開始日(format日付(entity.getNijiHanteiNinteiYukoKaishiYMD()));
        eucEntity.set認定有効終了日(format日付(entity.getNijiHanteiNinteiYukoShuryoYMD()));
        eucEntity.set要介護状態像例コード(nullToEmpty(entity.getYokaigoJotaizoReiCode()));
        eucEntity.set要介護状態像例((entity.getYokaigoJotaizoReiCode() != null && !entity.getYokaigoJotaizoReiCode().isEmpty())
                ? YokaigoJotaizoReiCode.toValue(entity.getYokaigoJotaizoReiCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一次判定結果変更理由(convert改行(entity.getIchijiHanteiKekkaHenkoRiyu()));
        eucEntity.set審査会意見種類コード(entity.getNinteishinsakaiIkenShurui());
        eucEntity.set審査会意見種類((!RString.isNullOrEmpty(entity.getNinteishinsakaiIkenShurui()))
                ? NinteiShinsakaiIkenShurui.toValue(entity.getNinteishinsakaiIkenShurui()).get名称() : RString.EMPTY);
        eucEntity.set審査会意見(convert改行(entity.getShinsakaiIken()));
        eucEntity.set審査会メモ(convert改行(entity.getShinsakaiMemo()));
        eucEntity.set審査会開催番号(entity.getShinsakaiKaisaiNo());
        eucEntity.set予定_合議体番号(new RString(entity.getYoteiGogitaiNo()));
        eucEntity.set予定_開催日(format日付(entity.getShinsakaiKaisaiYoteiYMD()));
        eucEntity.set結果_合議体番号(new RString(entity.getKekkaGogitaiNo()));
        eucEntity.set結果_開催日(format日付(entity.getShinsakaiKaisaiYMD()));
        eucEntity.set判定結果コード(nullToEmpty(entity.getHanteiKekkaCode()));
        eucEntity.set判定結果((entity.getHanteiKekkaCode() != null && !entity.getHanteiKekkaCode().isEmpty())
                ? HanteiKekkaCode.toValue(entity.getHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定日(format日付(entity.getZenkaiIchijiHanteiYMD()));
        eucEntity.set前回_一次判定結果コード(nullToEmpty(entity.getZenkaiIchijiHanteiKekkaCode()));
        eucEntity.set前回_一次判定結果コード_認知症加算(nullToEmpty(entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode()));
        eucEntity.set前回_一_五次判定日(format日付(entity.getZenkaiIchiGojiHanteiYMD()));
        eucEntity.set前回_一_五次判定結果コード(nullToEmpty(entity.getZenkaiIchiGojiHanteiKekkaCode()));
        eucEntity.set前回_一_五次判定結果コード_認知症加算(nullToEmpty(entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode()));
        eucEntity.set前回_二次判定日(format日付(entity.getZenkaiNijiHanteiYMD()));
        eucEntity.set前回_二次判定結果コード(nullToEmpty(entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode()));
        eucEntity.set前回_認定有効期間(new RString(entity.getZenkaiNijiHanteiNinteiYukoKikan()));
        eucEntity.set前回_認定有効開始日(format日付(entity.getZenkaiNijiHanteiNinteiYukoKaishiYMD()));
        eucEntity.set前回_認定有効終了日(format日付(entity.getZenkaiNijiHanteiNinteiYukoShuryoYMD()));
        eucEntity.set情報提供同意有無(IsExistJohoTeikyoDoui.toValue(entity.isJohoteikyoDoiFlag()).get名称());
        eucEntity.set厚労省IF識別コード(nullToEmpty(entity.getKoroshoIfShikibetsuCode()));
        eucEntity.set認定申請情報抽出日(format日付(entity.getNinteiShinseiJohoChushutsuYMD()));
        eucEntity.set認定調査結果情報抽出日(format日付(entity.getNinteiChosaKekkaJohoChushutsuYMD()));
        eucEntity.set認定調査_意見書結果情報抽出日(format日付(entity.getNinteiChosaIkenshoKekkaJohoChushutsuYMD()));
        eucEntity.set一次判定情報抽出日(format日付(entity.getIchijihanteiChushutsuYMD()));
        eucEntity.set審査会結果情報抽出日(format日付(entity.getShinsakaiKekkaJohoChushutsuYMD()));
        eucEntity.setセンター送信情報抽出日(format日付(entity.getCenterSoshinChushutsuYMD()));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.asCode().equals(entity.getKoroshoIfShikibetsuCode())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_09(eucEntity, entity, 意見項目List);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_06(eucEntity, entity, 意見項目List);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_02(eucEntity, entity, 意見項目List);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.asCode().equals(entity.getKoroshoIfShikibetsuCode())) {
            set判定結果_99(eucEntity, entity, 意見項目List);
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

    private static void set判定結果_09(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List) {
        RString 意見_障害高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._13.getValue());
        eucEntity.set意見_障害高齢者の日常生活自立度コード(意見_障害高齢者の日常生活自立度コード);
        eucEntity.set意見_障害高齢者の日常生活自立度(get意見項目02名称(意見_障害高齢者の日常生活自立度コード));
        RString 意見_認知症高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._14.getValue());
        eucEntity.set意見_認知症高齢者の日常生活自立度コード(意見_認知症高齢者の日常生活自立度コード);
        eucEntity.set意見_認知症高齢者の日常生活自立度(get意見項目03名称(意見_認知症高齢者の日常生活自立度コード));
        eucEntity.set一次判定結果((entity.getIchijiHanteiKekkaCode() != null && !entity.getIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一次判定結果_認知症加算(
                (entity.getIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果((entity.getIchiGojiHanteiKekkaCode() != null && !entity.getIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果_認知症加算(
                (entity.getIchiGojiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set二次判定結果((entity.getNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun09.toValue(entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果((entity.getZenkaiIchijiHanteiKekkaCode() != null && !entity.getZenkaiIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果_認知症加算(
                (entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果((entity.getZenkaiIchiGojiHanteiKekkaCode() != null && !entity.getZenkaiIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果_認知症加算((entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode() != null
                && !entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode09.toValue(entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_二次判定結果(
                (entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun09.toValue(entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
    }

    private static void set判定結果_06(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List) {
        RString 意見_障害高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._13.getValue());
        eucEntity.set意見_障害高齢者の日常生活自立度コード(意見_障害高齢者の日常生活自立度コード);
        eucEntity.set意見_障害高齢者の日常生活自立度(get意見項目02名称(意見_障害高齢者の日常生活自立度コード));
        RString 意見_認知症高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._14.getValue());
        eucEntity.set意見_認知症高齢者の日常生活自立度コード(意見_認知症高齢者の日常生活自立度コード);
        eucEntity.set意見_認知症高齢者の日常生活自立度(get意見項目03名称(意見_認知症高齢者の日常生活自立度コード));
        eucEntity.set一次判定結果((entity.getIchijiHanteiKekkaCode() != null && !entity.getIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一次判定結果_認知症加算(
                (entity.getIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果((entity.getIchiGojiHanteiKekkaCode() != null && !entity.getIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果_認知症加算(
                (entity.getIchiGojiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set二次判定結果((entity.getNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun06.toValue(entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果((entity.getZenkaiIchijiHanteiKekkaCode() != null && !entity.getZenkaiIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果_認知症加算(
                (entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果((entity.getZenkaiIchiGojiHanteiKekkaCode() != null && !entity.getZenkaiIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果_認知症加算(
                (entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode() != null
                && !entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode06.toValue(entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_二次判定結果(
                (entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun06.toValue(entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
    }

    private static void set判定結果_02(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List) {
        RString 意見_障害高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._14.getValue());
        eucEntity.set意見_障害高齢者の日常生活自立度コード(意見_障害高齢者の日常生活自立度コード);
        eucEntity.set意見_障害高齢者の日常生活自立度(get意見項目02名称(意見_障害高齢者の日常生活自立度コード));
        RString 意見_認知症高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._15.getValue());
        eucEntity.set意見_認知症高齢者の日常生活自立度コード(意見_認知症高齢者の日常生活自立度コード);
        eucEntity.set意見_認知症高齢者の日常生活自立度(get意見項目03名称(意見_認知症高齢者の日常生活自立度コード));
        eucEntity.set一次判定結果((entity.getIchijiHanteiKekkaCode() != null && !entity.getIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一次判定結果_認知症加算(
                (entity.getIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果((entity.getIchiGojiHanteiKekkaCode() != null && !entity.getIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果_認知症加算(
                (entity.getIchiGojiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set二次判定結果((entity.getNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun02.toValue(entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果((entity.getZenkaiIchijiHanteiKekkaCode() != null && !entity.getZenkaiIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果_認知症加算(
                (entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果((entity.getZenkaiIchiGojiHanteiKekkaCode() != null && !entity.getZenkaiIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果_認知症加算(
                (entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode() != null
                && !entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode02.toValue(entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_二次判定結果(
                (entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun02.toValue(entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
    }

    private static void set判定結果_99(DBE010001_KihonJohoEucEntity eucEntity, KihonJohoEntity entity,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List) {
        RString 意見_障害高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._14.getValue());
        eucEntity.set意見_障害高齢者の日常生活自立度コード(意見_障害高齢者の日常生活自立度コード);
        eucEntity.set意見_障害高齢者の日常生活自立度(get意見項目02名称(意見_障害高齢者の日常生活自立度コード));
        RString 意見_認知症高齢者の日常生活自立度コード = get意見項目(意見項目List, Renban._15.getValue());
        eucEntity.set意見_認知症高齢者の日常生活自立度コード(意見_認知症高齢者の日常生活自立度コード);
        eucEntity.set意見_認知症高齢者の日常生活自立度(get意見項目03名称(意見_認知症高齢者の日常生活自立度コード));
        eucEntity.set一次判定結果((entity.getIchijiHanteiKekkaCode() != null && !entity.getIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一次判定結果_認知症加算(
                (entity.getIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果((entity.getIchiGojiHanteiKekkaCode() != null && !entity.getIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set一_五次判定結果_認知症加算(
                (entity.getIchiGojiHanteiKekkaNinchishoKasanCode() != null && !entity.getIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set二次判定結果((entity.getNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun99.toValue(entity.getNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果((entity.getZenkaiIchijiHanteiKekkaCode() != null && !entity.getZenkaiIchijiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getZenkaiIchijiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一次判定結果_認知症加算(
                (entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode() != null && !entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getZenkaiIchijiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果((entity.getZenkaiIchiGojiHanteiKekkaCode() != null && !entity.getZenkaiIchiGojiHanteiKekkaCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getZenkaiIchiGojiHanteiKekkaCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_一_五次判定結果_認知症加算(
                (entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode() != null
                && !entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().isEmpty())
                ? IchijiHanteiKekkaCode99.toValue(entity.getZenkaiIchiGojiHanteiKekkaNinchishoKasanCode().value()).get名称() : RString.EMPTY);
        eucEntity.set前回_二次判定結果(
                (entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode() != null && !entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().isEmpty())
                ? YokaigoJotaiKubun99.toValue(entity.getZenkaiNijiHanteiYokaigoJotaiKubunCode().value()).get名称() : RString.EMPTY);
    }

    private static RString get意見項目(List<DbT5304ShujiiIkenshoIkenItemEntity> 意見項目List, int 連番) {
        for (DbT5304ShujiiIkenshoIkenItemEntity 意見項目 : 意見項目List) {
            if (意見項目.getRemban() == 連番) {
                return 意見項目.getIkenItem();
            }
        }
        return RString.EMPTY;
    }

    private static RString get意見項目02名称(RString code) {
        return (!RString.isNullOrEmpty(code)) ? IkenKomoku02.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString get意見項目03名称(RString code) {
        return (!RString.isNullOrEmpty(code)) ? IkenKomoku03.toValue(code).get名称() : RString.EMPTY;
    }

    private static RString format日付(FlexibleDate value) {
        return (value != null)
                ? value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString()
                : RString.EMPTY;
    }

    private static RString convert改行(RString text) {
        return (text != null)
                ? new RStringBuilder(text).replace(改行, 下矢印).toRString()
                : RString.EMPTY;
    }

    private static RString nullToEmpty(Code item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(AtenaMeisho item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(AtenaKanaMeisho item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(AtenaJusho item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(TelNo item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(ChikuCode item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(JigyoshaNo item) {
        return (item != null) ? item.value() : RString.EMPTY;
    }

    private static RString nullToEmpty(YubinNo item) {
        return (item != null) ? item.getEditedYubinNo() : RString.EMPTY;
    }
}
