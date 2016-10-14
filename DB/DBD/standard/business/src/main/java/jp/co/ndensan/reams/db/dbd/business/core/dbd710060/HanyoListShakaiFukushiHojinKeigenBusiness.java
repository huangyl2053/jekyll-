/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd710060;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.SakujoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseishaKankeiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 汎用リスト出力(社会福祉法人軽減)_Businessクラスです。
 *
 * @reamsid_L DBD-3900-030 panxiaobo
 */
public class HanyoListShakaiFukushiHojinKeigenBusiness {

    private static final RString 住所地特例 = new RString("住特");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final RString 初回申請 = new RString("初回申請　　");
    private static final RString 再申請内 = new RString("再申請内　　");
    private static final RString 再申請外 = new RString("再申請外　　");
    private static final RString 支援から申請 = new RString("支援から申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString サ変更申請 = new RString("サ変更申請　");
    private static final RString 施行前申請 = new RString("施行前申請　");
    private static final RString 追加 = new RString("追加　　　　");
    private static final RString ARI = new RString("有効");
    private static final RString MURI = new RString("無効");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString MINASHI = new RString("みなし");
    private static final RString 種類 = new RString(" etc.");
    private static final RString 要支援 = new RString("要支援申請");
    private static final RString 要介護 = new RString("要介護申請");
    private static final RString 追加_認定 = new RString("認定　　　　　");
    private static final RString 要介護度変更申請認定 = new RString("変更申請認定　");
    private static final RString 要介護度変更申請却下 = new RString("変更申請却下　");
    private static final RString サービス種類変更申請認定 = new RString("サ変更申請認定");
    private static final RString サービス種類変更申請却下 = new RString("サ変更申請却下");
    private static final RString 削除 = new RString("削除　　　　　");
    private static final RString 修正 = new RString("修正　　　　　");
    private static final RString 受給申請却下 = new RString("受給申請却下　");
    private static final RString 削除回復 = new RString("削除回復　　　");
    private static final RString 職権記載 = new RString("職権記載　　　");
    private static final RString 職権修正 = new RString("職権修正　　　");
    private static final RString 職権取消 = new RString("職権取消　　　");
    private static final RString 履歴修正 = new RString("履歴修正　　　");
    private static final RString SHIKAKUSYUTOKU = new RString("資格取得前申請");
    private static final RString SHITEII = new RString("指定医");
    private static final RString 介護保険施設 = new RString("11");
    private static final RString 住所地特例対象施設 = new RString("12");
    private static final RString 適用除外施設 = new RString("21");
    private static final RString SHINKI = new RString("新規");
    private static final RString HENKO = new RString("変更");
    private static final RString ZATEI = new RString("暫定");
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private static final RString 居宅サービス限定 = new RString("居宅サービス限定");
    private static final RString 居住費_食費のみ = new RString("居住費・食費のみ");
    private static final RString 旧措置ユ個のみ = new RString("旧措置ユ個のみ");
    private boolean isCsvhitsukesurasyuhensyu;

    /**
     * ＣＳＶ情報
     *
     * @param eucCsvEntity 出力ＣＳＶ情報
     * @param entity SQL検索結果情報
     * @param association 地方公共団体情報
     * @param hokenshaList 保険者リスト
     * @param Csvhitsukesurasyuhensyu 日付スラッシュ付加
     */
    public void setEucCsvEntity(Association association, boolean Csvhitsukesurasyuhensyu,
            ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity, HokenshaList hokenshaList) {
        isCsvhitsukesurasyuhensyu = Csvhitsukesurasyuhensyu;
        setPsmEntityNotNull(eucCsvEntity, entity);
        eucCsvEntity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        eucCsvEntity.set市町村名(get地方公共団体(new LasdecCode(entity.get被保険者台帳管理_市町村コード())).get市町村名());
        eucCsvEntity.set保険者コード(association.get地方公共団体コード().value());
        eucCsvEntity.set保険者名(association.getShichosonName_());
        eucCsvEntity.set空白(RString.EMPTY);
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            eucCsvEntity.set送付先氏名(atesaki.get宛先名称().getName().value());
            eucCsvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().value());
            eucCsvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().value());
            eucCsvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            RStringBuilder 送付address = new RStringBuilder();
            送付address.append(atesaki.get宛先住所().get住所()).append(atesaki.get宛先住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(atesaki.get宛先住所().get方書().value());
            eucCsvEntity.set送付先住所番地方書(送付address.toRString());
            eucCsvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            eucCsvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
            eucCsvEntity.set送付先方書(atesaki.get宛先住所().get方書().value());
            eucCsvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().value());
            eucCsvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
        }
        eucCsvEntity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        eucCsvEntity.set資格取得事由(set資格取得事由(entity.get被保険者台帳管理_資格取得事由コード()));
        eucCsvEntity.set資格取得日(set年月日(entity.get被保険者台帳管理_資格取得年月日()));
        eucCsvEntity.set資格取得届出日(set年月日(entity.get被保険者台帳管理_資格取得届出年月日()));
        eucCsvEntity.set喪失事由(set喪失事由(entity.get被保険者台帳管理_資格喪失事由コード()));
        eucCsvEntity.set資格喪失日(set年月日(entity.get被保険者台帳管理_資格喪失年月日()));
        eucCsvEntity.set資格喪失届日(set年月日(entity.get被保険者台帳管理_資格喪失届出年月日()));
        eucCsvEntity.set資格区分(set資格区分(entity.get被保険者台帳管理_被保険者区分コード()));
        eucCsvEntity.set住所地特例状態(new RString("1").equals(entity.get被保険者台帳管理_住所地特例フラグ()) ? 住所地特例 : RString.EMPTY);
        LasdecCode lasdecCode;
        if (new RString("1").equals(entity.get被保険者台帳管理_広域内住所地特例フラグ())) {
            lasdecCode = entity.get被保険者台帳管理_広住特措置元市町村コード() != null
                    ? new LasdecCode(entity.get被保険者台帳管理_広住特措置元市町村コード()) : LasdecCode.EMPTY;
        } else {
            lasdecCode = entity.get被保険者台帳管理_市町村コード() != null
                    ? new LasdecCode(entity.get被保険者台帳管理_市町村コード()) : LasdecCode.EMPTY;
        }
        eucCsvEntity.set資格証記載保険者番号(!lasdecCode.isEmpty()
                ? hokenshaList.get(lasdecCode).get証記載保険者番号().value() : RString.EMPTY);
        setEucCsvEntityLow(eucCsvEntity, entity);
        setEucCsvEntity2(eucCsvEntity, entity);
    }

    /**
     * ＣＳＶ情報
     *
     * @return eucCsvEntity eucCsvEntity
     */
    public ShakaiFukushiHojinKeigenEucCsvEntity setNewBlank() {
        ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity = new ShakaiFukushiHojinKeigenEucCsvEntity();
        eucCsvEntity.set連番(RString.EMPTY);
        eucCsvEntity.set識別コード(RString.EMPTY);
        eucCsvEntity.set住民種別(RString.EMPTY);
        eucCsvEntity.set氏名(RString.EMPTY);
        eucCsvEntity.set氏名カナ(RString.EMPTY);
        eucCsvEntity.set生年月日(RString.EMPTY);
        eucCsvEntity.set年齢(RString.EMPTY);
        eucCsvEntity.set性別(RString.EMPTY);
        eucCsvEntity.set続柄コード(RString.EMPTY);
        eucCsvEntity.set世帯コード(RString.EMPTY);
        eucCsvEntity.set世帯主名(RString.EMPTY);
        eucCsvEntity.set住所コード(RString.EMPTY);
        eucCsvEntity.set郵便番号(RString.EMPTY);
        eucCsvEntity.set住所番地方書(RString.EMPTY);
        eucCsvEntity.set住所(RString.EMPTY);
        eucCsvEntity.set番地(RString.EMPTY);
        eucCsvEntity.set方書(RString.EMPTY);
        eucCsvEntity.set行政区コード(RString.EMPTY);
        eucCsvEntity.set行政区名(RString.EMPTY);
        eucCsvEntity.set地区１(RString.EMPTY);
        eucCsvEntity.set地区２(RString.EMPTY);
        eucCsvEntity.set地区３(RString.EMPTY);
        eucCsvEntity.set連絡先１(RString.EMPTY);
        eucCsvEntity.set連絡先２(RString.EMPTY);
        eucCsvEntity.set登録異動日(RString.EMPTY);
        eucCsvEntity.set登録事由(RString.EMPTY);
        eucCsvEntity.set登録届出日(RString.EMPTY);
        eucCsvEntity.set住定異動日(RString.EMPTY);
        eucCsvEntity.set住定事由(RString.EMPTY);
        eucCsvEntity.set住定届出日(RString.EMPTY);
        eucCsvEntity.set消除異動日(RString.EMPTY);
        eucCsvEntity.set消除事由(RString.EMPTY);
        eucCsvEntity.set消除届出日(RString.EMPTY);
        eucCsvEntity.set転出入理由(RString.EMPTY);
        eucCsvEntity.set前住所郵便番号(RString.EMPTY);
        eucCsvEntity.set前住所番地方書(RString.EMPTY);
        eucCsvEntity.set前住所(RString.EMPTY);
        eucCsvEntity.set前住所番地(RString.EMPTY);
        eucCsvEntity.set前住所方書(RString.EMPTY);
        eucCsvEntity.set市町村コード(RString.EMPTY);
        eucCsvEntity.set市町村名(RString.EMPTY);
        eucCsvEntity.set保険者コード(RString.EMPTY);
        eucCsvEntity.set保険者名(RString.EMPTY);
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set送付先氏名(RString.EMPTY);
        eucCsvEntity.set送付先氏名カナ(RString.EMPTY);
        eucCsvEntity.set送付先住所コード(RString.EMPTY);
        eucCsvEntity.set送付先郵便番号(RString.EMPTY);
        eucCsvEntity.set送付先住所番地方書(RString.EMPTY);
        eucCsvEntity.set送付先住所(RString.EMPTY);
        eucCsvEntity.set送付先番地(RString.EMPTY);
        eucCsvEntity.set送付先方書(RString.EMPTY);
        eucCsvEntity.set送付先行政区コード(RString.EMPTY);
        eucCsvEntity.set送付先行政区名(RString.EMPTY);
        eucCsvEntity.set被保険者番号(RString.EMPTY);
        eucCsvEntity.set資格取得事由(RString.EMPTY);
        eucCsvEntity.set資格取得日(RString.EMPTY);
        eucCsvEntity.set資格取得届出日(RString.EMPTY);
        eucCsvEntity.set喪失事由(RString.EMPTY);
        eucCsvEntity.set資格喪失日(RString.EMPTY);
        eucCsvEntity.set資格喪失届日(RString.EMPTY);
        eucCsvEntity.set資格区分(RString.EMPTY);
        eucCsvEntity.set住所地特例状態(RString.EMPTY);
        eucCsvEntity.set資格証記載保険者番号(RString.EMPTY);
        eucCsvEntity.set医療保険種別(RString.EMPTY);
        eucCsvEntity.set医療保険番号(RString.EMPTY);
        eucCsvEntity.set医療保険者名(RString.EMPTY);
        eucCsvEntity.set医療保険記号番号(RString.EMPTY);
        eucCsvEntity.set特定疾病(RString.EMPTY);
        eucCsvEntity.set受給申請事由(RString.EMPTY);
        eucCsvEntity.set申請理由(RString.EMPTY);
        eucCsvEntity.set申請関係者(RString.EMPTY);
        eucCsvEntity.set本人関係(RString.EMPTY);
        eucCsvEntity.set申請氏名(RString.EMPTY);
        eucCsvEntity.set申請氏名カナ(RString.EMPTY);
        eucCsvEntity.set申請代行事業者名(RString.EMPTY);
        eucCsvEntity.set申請代行事業者名カナ(RString.EMPTY);
        eucCsvEntity.set申請者郵便番号(RString.EMPTY);
        eucCsvEntity.set申請住所(RString.EMPTY);
        eucCsvEntity.set申請連絡先(RString.EMPTY);
        eucCsvEntity.set申請事業コード(RString.EMPTY);
        eucCsvEntity.set受給申請日(RString.EMPTY);
        eucCsvEntity.set調査委託先コード(RString.EMPTY);
        eucCsvEntity.set調査員コード(RString.EMPTY);
        eucCsvEntity.set委託先名(RString.EMPTY);
        eucCsvEntity.set委託先名カナ(RString.EMPTY);
        eucCsvEntity.set委託先代表者名(RString.EMPTY);
        eucCsvEntity.set委託先代表者名カナ(RString.EMPTY);
        eucCsvEntity.set委託先郵便番号(RString.EMPTY);
        eucCsvEntity.set委託先住所(RString.EMPTY);
        eucCsvEntity.set委託先連絡先(RString.EMPTY);
        eucCsvEntity.set委託先状況(RString.EMPTY);
        eucCsvEntity.set調査員氏名(RString.EMPTY);
        eucCsvEntity.set調査員氏名カナ(RString.EMPTY);
        eucCsvEntity.set調査員性別(RString.EMPTY);
        eucCsvEntity.set調査員郵便(RString.EMPTY);
        eucCsvEntity.set調査員住所(RString.EMPTY);
        eucCsvEntity.set調査員連絡先(RString.EMPTY);
        eucCsvEntity.set調査員資格(RString.EMPTY);
        eucCsvEntity.set調査員所属機関名(RString.EMPTY);
        eucCsvEntity.set調査員状況(RString.EMPTY);
        eucCsvEntity.set医療機関コード(RString.EMPTY);
        eucCsvEntity.set主治医コード(RString.EMPTY);
        eucCsvEntity.set医療機関名称(RString.EMPTY);
        eucCsvEntity.set医療機関名称カナ(RString.EMPTY);
        eucCsvEntity.set医療機関代表者名(RString.EMPTY);
        eucCsvEntity.set医療機関代表者名カナ(RString.EMPTY);
        eucCsvEntity.set医療機関郵便番号(RString.EMPTY);
        eucCsvEntity.set医療機関住所(RString.EMPTY);
        eucCsvEntity.set医療機関連絡先(RString.EMPTY);
        eucCsvEntity.set医療機関状況(RString.EMPTY);
        eucCsvEntity.set主治医名(RString.EMPTY);
        eucCsvEntity.set主治医名カナ(RString.EMPTY);
        eucCsvEntity.set主治医性別(RString.EMPTY);
        eucCsvEntity.set主治医所属(RString.EMPTY);
        eucCsvEntity.set主治医状況(RString.EMPTY);
        eucCsvEntity.set一次判定要介護度(RString.EMPTY);
        eucCsvEntity.set調査委託日(RString.EMPTY);
        eucCsvEntity.set調査予定日(RString.EMPTY);
        eucCsvEntity.set調査終了日(RString.EMPTY);
        eucCsvEntity.set意見依頼日(RString.EMPTY);
        eucCsvEntity.set意見予定日(RString.EMPTY);
        eucCsvEntity.set意見取寄日(RString.EMPTY);
        eucCsvEntity.set資料作成日(RString.EMPTY);
        eucCsvEntity.set審査予定日(RString.EMPTY);
        eucCsvEntity.set審査回答日(RString.EMPTY);
        eucCsvEntity.set一次判定日(RString.EMPTY);
        eucCsvEntity.set要介護度(RString.EMPTY);
        eucCsvEntity.set認定開始日(RString.EMPTY);
        eucCsvEntity.set認定終了日(RString.EMPTY);
        eucCsvEntity.set認定日(RString.EMPTY);
        eucCsvEntity.set旧措置(RString.EMPTY);
        eucCsvEntity.setみなし更新認定(RString.EMPTY);
        eucCsvEntity.set審査会意見(RString.EMPTY);
        eucCsvEntity.set指定サービス種類(RString.EMPTY);
        eucCsvEntity.set受給喪失日(RString.EMPTY);
        eucCsvEntity.set直近事由(RString.EMPTY);
        setBlank2(eucCsvEntity);
        return eucCsvEntity;
    }

    private void setBlank2(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity) {
        eucCsvEntity.set受給状況(RString.EMPTY);
        eucCsvEntity.set異動事由コード(RString.EMPTY);
        eucCsvEntity.set異動事由追加文(RString.EMPTY);
        eucCsvEntity.set削除理由コード(RString.EMPTY);
        eucCsvEntity.set異動事由文言(RString.EMPTY);
        eucCsvEntity.set削除理由文言(RString.EMPTY);
        eucCsvEntity.set支援申請区分(RString.EMPTY);
        eucCsvEntity.set初回申請日(RString.EMPTY);
        eucCsvEntity.set初回認定日(RString.EMPTY);
        eucCsvEntity.set初回要介護度(RString.EMPTY);
        eucCsvEntity.set初回認定開始日(RString.EMPTY);
        eucCsvEntity.set初回認定終了日(RString.EMPTY);
        eucCsvEntity.set初回申請事由(RString.EMPTY);
        eucCsvEntity.set初回みなし更新(RString.EMPTY);
        eucCsvEntity.set初回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set初回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set初回支援申請事由(RString.EMPTY);
        eucCsvEntity.set前回申請日(RString.EMPTY);
        eucCsvEntity.set前回認定日(RString.EMPTY);
        eucCsvEntity.set前回要介護度(RString.EMPTY);
        eucCsvEntity.set前回認定開始日(RString.EMPTY);
        eucCsvEntity.set前回認定終了日(RString.EMPTY);
        eucCsvEntity.set前回受給申請事由(RString.EMPTY);
        eucCsvEntity.set前回みなし更新(RString.EMPTY);
        eucCsvEntity.set前回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set前回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set前回支援申請事由(RString.EMPTY);
        eucCsvEntity.set前々回申請日(RString.EMPTY);
        eucCsvEntity.set前々回認定日(RString.EMPTY);
        eucCsvEntity.set前々回要介護度(RString.EMPTY);
        eucCsvEntity.set前々回認定開始日(RString.EMPTY);
        eucCsvEntity.set前々回認定終了日(RString.EMPTY);
        eucCsvEntity.set前々回受給申請事由(RString.EMPTY);
        eucCsvEntity.set前々回みなし更新(RString.EMPTY);
        eucCsvEntity.set前々回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set前々回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set前々回支援申請事由(RString.EMPTY);
        eucCsvEntity.set障害高齢者自立度(RString.EMPTY);
        eucCsvEntity.set認知症高齢者自立度(RString.EMPTY);
        eucCsvEntity.set訪問支給限度額単位数(RString.EMPTY);
        eucCsvEntity.set訪問支給限度有効開始年月日(RString.EMPTY);
        eucCsvEntity.set訪問支給限度有効終了年月日(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度日数(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度有効開始年月日(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度有効終了年月日(RString.EMPTY);
        eucCsvEntity.set当初認定有効開始年月日(RString.EMPTY);
        eucCsvEntity.set当初認定有効終了年月日(RString.EMPTY);
        eucCsvEntity.set認定延期通知書発行年月日(RString.EMPTY);
        eucCsvEntity.set認定延期通知書発行回数(RString.EMPTY);
        eucCsvEntity.set延期処理見込み開始年月日(RString.EMPTY);
        eucCsvEntity.set延期処理見込み終了年月日(RString.EMPTY);
        eucCsvEntity.set受給資格証明書発行日１(RString.EMPTY);
        eucCsvEntity.set受給資格証明書発行日２(RString.EMPTY);
        eucCsvEntity.set資格取得前申請区分(RString.EMPTY);
        eucCsvEntity.set一次判定結果重み(RString.EMPTY);
        eucCsvEntity.set指定医区分(RString.EMPTY);
        eucCsvEntity.set訪問調査先郵便番号(RString.EMPTY);
        eucCsvEntity.set訪問調査先住所(RString.EMPTY);
        eucCsvEntity.set訪問調査先名称(RString.EMPTY);
        eucCsvEntity.set訪問調査先電話番号(RString.EMPTY);
        eucCsvEntity.set指定事業者コード(RString.EMPTY);
        eucCsvEntity.set施設入所日(RString.EMPTY);
        eucCsvEntity.set施設退所日(RString.EMPTY);
        eucCsvEntity.set指定事業者名(RString.EMPTY);
        eucCsvEntity.set指定事業者名カナ(RString.EMPTY);
        eucCsvEntity.set指定事業者郵便番号(RString.EMPTY);
        eucCsvEntity.set指定事業者住所(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者名(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者名カナ(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者役職(RString.EMPTY);
        eucCsvEntity.set指定事業者電話番号(RString.EMPTY);
        eucCsvEntity.set指定事業者ＦＡＸ番号(RString.EMPTY);
        eucCsvEntity.set指定事業者ケアマネ数(RString.EMPTY);
        eucCsvEntity.set指定事業者利用者数(RString.EMPTY);
        eucCsvEntity.set指定事業者認定日(RString.EMPTY);
        eucCsvEntity.set指定事業者取消日(RString.EMPTY);
        eucCsvEntity.set指定事業者実施地域(RString.EMPTY);
        eucCsvEntity.set転出先保険者番号(RString.EMPTY);
        eucCsvEntity.set確認番号(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減申請日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減決定日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減承認区分(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減開始日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減終了日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減率(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減事由(RString.EMPTY);
        eucCsvEntity.set居宅サービス区分(RString.EMPTY);
        eucCsvEntity.set居住費_食費限定区分(RString.EMPTY);
        eucCsvEntity.set旧措置ユニット型個室限定区分(RString.EMPTY);
        eucCsvEntity.set被保険者番号_総合事業対象者(RString.EMPTY);
        eucCsvEntity.set履歴番号(RString.EMPTY);
        eucCsvEntity.set事業適用開始日(RString.EMPTY);
        eucCsvEntity.set事業適用終了日(RString.EMPTY);
        eucCsvEntity.set事業チェック実施日(RString.EMPTY);
        eucCsvEntity.set事業決定日(RString.EMPTY);
        eucCsvEntity.set届出区分(RString.EMPTY);
        eucCsvEntity.set居宅計画作成区分(RString.EMPTY);
        eucCsvEntity.set計画事業者番号(RString.EMPTY);
        eucCsvEntity.set計画事業者名(RString.EMPTY);
        eucCsvEntity.set計画事業者カナ(RString.EMPTY);
        eucCsvEntity.set計画管理者名(RString.EMPTY);
        eucCsvEntity.set計画管理者カナ(RString.EMPTY);
        eucCsvEntity.set計画適用開始日(RString.EMPTY);
        eucCsvEntity.set計画適用終了日(RString.EMPTY);
        eucCsvEntity.set計画届出日(RString.EMPTY);
        eucCsvEntity.set計画作成日(RString.EMPTY);
        eucCsvEntity.set計画変更日(RString.EMPTY);
        eucCsvEntity.set変更理由(RString.EMPTY);
    }

    private void setEucCsvEntityLow(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity) {
        eucCsvEntity.set医療保険種別(set医療保険種別(entity.get医療保険加入状況_医療保険種別コード()));
        eucCsvEntity.set医療保険番号(entity.get医療保険加入状況_医療保険者番号());
        eucCsvEntity.set医療保険者名(entity.get医療保険加入状況_医療保険者名称());
        eucCsvEntity.set医療保険記号番号(entity.get医療保険加入状況_医療保険記号番号());
        eucCsvEntity.set特定疾病(RString.isNullOrEmpty(entity.get受給者台帳_２号特定疾病コード()) ? RString.EMPTY
                : TokuteiShippei.toValue(entity.get受給者台帳_２号特定疾病コード()).get名称());
        eucCsvEntity.set受給申請事由(set受給申請事由(entity.get受給者台帳_受給申請事由(), entity.get受給者台帳_要支援者認定申請区分()));
        eucCsvEntity.set申請理由(entity.get受給者台帳_申請理由());
        eucCsvEntity.set申請関係者(RString.isNullOrEmpty(entity.get受給者台帳_届出者申請者関係コード()) ? RString.EMPTY
                : ShinseishaKankeiCode.toValue(entity.get受給者台帳_届出者申請者関係コード()).get名称());
        eucCsvEntity.set本人関係(entity.get受給者台帳_届出者本人との関係());
        eucCsvEntity.set申請氏名(entity.get今回申請届出_申請届出者氏名());
        eucCsvEntity.set申請氏名カナ(entity.get今回申請届出_申請届出者氏名カナ());
        eucCsvEntity.set申請代行事業者名(entity.get申請届出事業者_事業者名称());
        eucCsvEntity.set申請代行事業者名カナ(entity.get申請届出事業者_事業者名称カナ());
        eucCsvEntity.set申請者郵便番号(set郵便番号(entity.get今回申請届出_申請届出者郵便番号()));
        eucCsvEntity.set申請住所(entity.get今回申請届出_申請届出者住所());
        eucCsvEntity.set申請連絡先(entity.get今回申請届出_申請届出者電話番号());
        eucCsvEntity.set申請事業コード(entity.get今回申請届出_申請届出代行事業者番号());
        eucCsvEntity.set受給申請日(set年月日(entity.get受給者台帳_受給申請年月日()));
        eucCsvEntity.set調査委託先コード(entity.get今回申請_認定調査委託先コード());
        eucCsvEntity.set調査員コード(entity.get今回申請_認定調査員コード());
        eucCsvEntity.set委託先名(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set委託先名カナ(entity.get今回調査委託先_事業者名称カナ());
        eucCsvEntity.set委託先代表者名(entity.get今回調査委託先_代表者名());
        eucCsvEntity.set委託先代表者名カナ(entity.get今回調査委託先_代表者名カナ());
        eucCsvEntity.set委託先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set委託先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set委託先連絡先(entity.get今回調査委託先_電話番号());
        eucCsvEntity.set委託先状況(entity.is今回調査委託先_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set調査員氏名(entity.get今回調査員_調査員氏名());
        eucCsvEntity.set調査員氏名カナ(entity.get今回調査員_調査員氏名カナ());
        eucCsvEntity.set調査員性別(set性別(entity.get今回調査員_性別()));
        eucCsvEntity.set調査員郵便(set郵便番号(entity.get今回調査員_郵便番号()));
        eucCsvEntity.set調査員住所(entity.get今回調査員_住所());
        eucCsvEntity.set調査員連絡先(entity.get今回調査員_電話番号());
        eucCsvEntity.set調査員資格(RString.isNullOrEmpty(entity.get今回調査員_調査員資格()) ? RString.EMPTY
                : Sikaku.toValue(entity.get今回調査員_調査員資格()).get名称());
        eucCsvEntity.set調査員所属機関名(entity.get今回調査員_所属機関名称());
        eucCsvEntity.set調査員状況(entity.is今回調査員_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set医療機関コード(entity.get今回申請_主治医医療機関コード());
        eucCsvEntity.set主治医コード(entity.get今回申請_主治医コード());
        eucCsvEntity.set医療機関名称(entity.get今回主治医医療機関_医療機関名称());
        eucCsvEntity.set医療機関名称カナ(entity.get今回主治医医療機関_医療機関名称カナ());
        eucCsvEntity.set医療機関代表者名(entity.get今回主治医医療機関_代表者名());
        eucCsvEntity.set医療機関代表者名カナ(entity.get今回主治医医療機関_代表者名カナ());
        eucCsvEntity.set医療機関郵便番号(set郵便番号(entity.get今回主治医医療機関_郵便番号()));
        eucCsvEntity.set医療機関住所(entity.get今回主治医医療機関_住所());
        eucCsvEntity.set医療機関連絡先(entity.get今回主治医医療機関_電話番号());
        eucCsvEntity.set医療機関状況(entity.is今回主治医医療機関_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set主治医名(entity.get今回主治医_主治医氏名());
        eucCsvEntity.set主治医名カナ(entity.get今回主治医_主治医カナ());
        eucCsvEntity.set主治医性別(set性別(entity.get今回主治医_性別()));
        eucCsvEntity.set主治医所属(entity.get今回主治医_診療科名称());
        eucCsvEntity.set主治医状況(entity.is今回主治医_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set一次判定要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(),
                entity.get今回一次判定結果_要介護認定一次判定結果コード()));
        eucCsvEntity.set調査委託日(set年月日(entity.get今回調査依頼_認定調査依頼年月日()));
        eucCsvEntity.set調査予定日(set年月日(entity.get今回計画情報_認定調査予定年月日()));
        eucCsvEntity.set調査終了日(set年月日(entity.get今回完了情報_認定調査完了年月日()));
    }

    private void setPsmEntityNotNull(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity) {
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.set氏名カナ(kojin.get名称().getKana().value());
            eucCsvEntity.set生年月日(set年月日(kojin.get生年月日().toFlexibleDate()));
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set性別(kojin.get性別().getName().getShortJapanese());
            eucCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            eucCsvEntity.set世帯コード(kojin.get世帯コード().value());
            eucCsvEntity.set世帯主名(kojin.get世帯主名().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            eucCsvEntity.set住所番地方書(address.toRString());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            eucCsvEntity.set方書(kojin.get住所().get方書().value());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            eucCsvEntity.set地区１(kojin.get行政区画().getChiku1().get名称());
            eucCsvEntity.set地区２(kojin.get行政区画().getChiku2().get名称());
            eucCsvEntity.set地区３(kojin.get行政区画().getChiku3().get名称());
            eucCsvEntity.set連絡先１(kojin.get連絡先１().value());
            eucCsvEntity.set連絡先２(kojin.get連絡先２().value());
            eucCsvEntity.set登録異動日(set年月日(kojin.get登録異動年月日()));
            eucCsvEntity.set登録事由(kojin.get登録事由().get異動事由略称());
            eucCsvEntity.set登録届出日(set年月日(kojin.get登録届出年月日()));
            eucCsvEntity.set住定異動日(set年月日(kojin.get住定異動年月日()));
            eucCsvEntity.set住定事由(kojin.get住定事由().get異動事由略称());
            eucCsvEntity.set住定届出日(set年月日(kojin.get住定届出年月日()));
            eucCsvEntity.set消除異動日(set年月日(kojin.get消除異動年月日()));
            eucCsvEntity.set消除事由(kojin.get消除事由().get異動事由略称());
            eucCsvEntity.set消除届出日(set年月日(kojin.get消除届出年月日()));
            eucCsvEntity.set転出入理由(RString.EMPTY);
            eucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            eucCsvEntity.set前住所番地方書(addressZen.toRString());
            eucCsvEntity.set前住所(kojin.get転入前().get住所());
            eucCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            eucCsvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
    }

    private void setEucCsvEntity2(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity) {
        eucCsvEntity.set意見依頼日(set年月日(entity.get今回意見書作成依頼_主治医意見書作成依頼()));
        eucCsvEntity.set意見予定日(set年月日(entity.get今回計画情報_主治医意見書登録予定年月日()));
        eucCsvEntity.set意見取寄日(set年月日(entity.get今回意見書情報_主治医意見書受領年月日()));
        eucCsvEntity.set資料作成日(set年月日(entity.get今回結果情報_介護認定審査会資料作成年月日()));
        eucCsvEntity.set審査予定日(set年月日(entity.get今回計画情報_認定審査会予定年月日()));
        eucCsvEntity.set審査回答日(set年月日(entity.get受給者台帳_認定年月日()));
        eucCsvEntity.set認定開始日(set年月日(entity.get受給者台帳_認定有効期間開始年月日()));
        eucCsvEntity.set認定終了日(set年月日(entity.get受給者台帳_認定有効期間終了年月日()));
        eucCsvEntity.set認定日(set年月日(entity.get受給者台帳_認定年月日()));
        eucCsvEntity.set旧措置(entity.is受給者台帳_旧措置者フラグ() ? 旧措置者 : RString.EMPTY);
//        eucCsvEntity.setみなし更新認定(setみなし更新認定(entity.get受給者台帳_みなし要介護区分コード()));
        eucCsvEntity.set審査会意見(entity.get今回結果情報_介護認定審査会意見());
        RStringBuilder サービス種類 = new RStringBuilder();
        サービス種類.append(entity.get受給者台帳_指定サービス種類01())
                .append(entity.get受給者台帳_指定サービス種類01())
                .append(entity.get受給者台帳_指定サービス種類02())
                .append(entity.get受給者台帳_指定サービス種類03())
                .append(entity.get受給者台帳_指定サービス種類04())
                .append(entity.get受給者台帳_指定サービス種類05());
        if (!RString.isNullOrEmpty(entity.get受給者台帳_指定サービス種類06())) {
            サービス種類.append(種類);
        }
        eucCsvEntity.set指定サービス種類(サービス種類.toRString());
        eucCsvEntity.set受給喪失日(set年月日(entity.get受給者台帳_喪失年月日()));
        eucCsvEntity.set直近事由(entity.get受給者台帳_直近異動事由コード());
        eucCsvEntity.set受給状況(set受給状況(entity.get受給者台帳_有効無効区分()));
        eucCsvEntity.set異動事由コード(set異動事由コード(entity.get受給者台帳_データ区分()));
        eucCsvEntity.set異動事由追加文(entity.get受給者台帳_異動理由());
        eucCsvEntity.set削除理由コード(entity.get受給者台帳_削除事由コード());
        eucCsvEntity.set異動事由文言(set異動事由文言(entity.get受給者台帳_直近異動事由コード()));
        eucCsvEntity.set削除理由文言(set削除理由文言(entity.get受給者台帳_削除事由コード()));
        eucCsvEntity.set支援申請区分(set申請区分(entity.get受給者台帳_要支援者認定申請区分()));
        eucCsvEntity.set初回申請日(set年月日(entity.get初回受給情報_受給申請年月日()));
        eucCsvEntity.set初回認定日(set年月日(entity.get初回受給情報_認定年月日()));
        eucCsvEntity.set初回要介護度(set要介護度(entity.get初回申請_厚労省IF識別コード(),
                entity.get初回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set初回認定開始日(set年月日(entity.get初回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set初回認定終了日(set年月日(entity.get初回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set初回申請事由(set受給申請事由(entity.get初回受給情報_受給申請事由(), entity.get初回申請_要支援者認定申請区分()));
        eucCsvEntity.set初回みなし更新(setみなし更新認定(entity.get初回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set初回当初認定有効開始日(set年月日(entity.get初回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set初回当初認定有効終了日(set年月日(entity.get初回受給情報_当初認定有効終了年月日()));
        eucCsvEntity.set初回支援申請事由(set申請区分(entity.get初回申請_要支援者認定申請区分()));
        eucCsvEntity.set前回申請日(set年月日(entity.get前回受給情報_受給申請年月日()));
        eucCsvEntity.set前回認定日(set年月日(entity.get前回受給情報_認定年月日()));
        eucCsvEntity.set前回要介護度(set要介護度(entity.get前回申請_厚労省IF識別コード(),
                entity.get前回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前回認定開始日(set年月日(entity.get前回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set前回認定終了日(set年月日(entity.get前回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set前回受給申請事由(set受給申請事由(entity.get前回受給情報_受給申請事由(),
                entity.get前回申請_要支援者認定申請区分()));
        eucCsvEntity.set前回みなし更新(setみなし更新認定(entity.get前回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set前回当初認定有効開始日(set年月日(entity.get前回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set前回当初認定有効終了日(set年月日(entity.get前回受給情報_当初認定有効終了年月日()));
        eucCsvEntity.set前回支援申請事由(set申請区分(entity.get前回申請_要支援者認定申請区分()));
        eucCsvEntity.set前々回申請日(set年月日(entity.get前々回受給情報_受給申請年月日()));
        eucCsvEntity.set前々回認定日(set年月日(entity.get前々回受給情報_認定年月日()));
        eucCsvEntity.set前々回要介護度(set要介護度(entity.get前々回申請_厚労省IF識別コード(),
                entity.get前々回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前々回認定開始日(set年月日(entity.get前々回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set前々回認定終了日(set年月日(entity.get前々回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set前々回受給申請事由(set受給申請事由(entity.get前々回受給情報_受給申請事由(),
                entity.get前々回申請_要支援者認定申請区分()));
        eucCsvEntity.set前々回みなし更新(setみなし更新認定(entity.get前々回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set前々回当初認定有効開始日(set年月日(entity.get前々回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set前々回当初認定有効終了日(set年月日(entity.get前々回受給情報_当初認定有効終了年月日()));
        eucCsvEntity.set前々回支援申請事由(set申請区分(entity.get前々回受給情報_要支援者認定申請区分()));
        eucCsvEntity.set障害高齢者自立度(set障害高齢者自立度(entity.get今回調査結果_基本障害高齢者自立度コード()));
        eucCsvEntity.set認知症高齢者自立度(set認知症高齢者自立度(entity.get今回調査結果_基本認知症高齢者自立度コード()));
        eucCsvEntity.set訪問支給限度額単位数(entity.get受給者台帳_支給限度単位数());
        eucCsvEntity.set訪問支給限度有効開始年月日(set年月日(entity.get受給者台帳_支給限度有効開始年月日()));
        eucCsvEntity.set訪問支給限度有効終了年月日(set年月日(entity.get受給者台帳_支給限度有効終了年月日()));
        eucCsvEntity.set短期入所支給限度日数(entity.get受給者台帳_短期入所支給限度日数());
        eucCsvEntity.set短期入所支給限度有効開始年月日(set年月日(entity.get受給者台帳_短期入所支給限度開始年月日()));
        eucCsvEntity.set短期入所支給限度有効終了年月日(set年月日(entity.get受給者台帳_短期入所支給限度終了年月日()));
        eucCsvEntity.set当初認定有効開始年月日(set年月日(entity.get受給者台帳_当初認定有効開始年月日()));
        eucCsvEntity.set当初認定有効終了年月日(set年月日(entity.get受給者台帳_当初認定有効終了年月日()));
        eucCsvEntity.set認定延期通知書発行年月日(set年月日(entity.get今回申請_延期通知発行年月日()));
        eucCsvEntity.set認定延期通知書発行回数(entity.get今回申請_延期通知発行回数());
        eucCsvEntity.set延期処理見込み開始年月日(set年月日(entity.get今回申請_延期見込期間開始年月日()));
        eucCsvEntity.set延期処理見込み終了年月日(set年月日(entity.get今回申請_延期見込期間終了年月日()));
        eucCsvEntity.set受給資格証明書発行日１(set年月日(entity.get受給者台帳_受給資格証明書発行年月日１()));
        eucCsvEntity.set受給資格証明書発行日２(set年月日(entity.get受給者台帳_受給資格証明書発行年月日２()));
        eucCsvEntity.set資格取得前申請区分(entity.is受給者台帳_資格取得前申請フラグ() ? SHIKAKUSYUTOKU : RString.EMPTY);
        eucCsvEntity.set一次判定結果重み(RString.EMPTY);
        eucCsvEntity.set指定医区分(entity.is今回申請_指定医フラグ() ? SHITEII : RString.EMPTY);
        eucCsvEntity.set訪問調査先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set訪問調査先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set訪問調査先名称(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set訪問調査先電話番号(entity.get今回調査委託先_電話番号());
        eucCsvEntity.set指定事業者コード(entity.get施設入所_入所施設コード());
        eucCsvEntity.set施設入所日(set年月日(entity.get施設入所_入所年月日()));
        eucCsvEntity.set施設退所日(set年月日(entity.get施設入所_退所年月日()));
        set指定事業者(eucCsvEntity, entity);
        eucCsvEntity.set確認番号(entity.get社会福祉法人等利用者負担軽減_確認番号());
        eucCsvEntity.set社会福祉法人軽減申請日(set年月日(entity.get社会福祉法人等利用者負担軽減_申請年月日()));
        eucCsvEntity.set社会福祉法人軽減決定日(set年月日(entity.get社会福祉法人等利用者負担軽減_決定年月日()));
        eucCsvEntity.set社会福祉法人軽減承認区分(entity.get社会福祉法人等利用者負担軽減_決定区分().equals(区分_0) ? 却下 : 承認);
        eucCsvEntity.set社会福祉法人軽減開始日(set年月日(entity.get社会福祉法人等利用者負担軽減_適用開始年月日()));
        eucCsvEntity.set社会福祉法人軽減終了日(set年月日(entity.get社会福祉法人等利用者負担軽減_適用終了年月日()));
        eucCsvEntity.set社会福祉法人軽減率(entity.get社会福祉法人等利用者負担軽減_軽減率_分子() == null
                ? RString.EMPTY : entity.get社会福祉法人等利用者負担軽減_軽減率_分子().concat("/")
                .concat(entity.get社会福祉法人等利用者負担軽減_軽減率_分母()));
        eucCsvEntity.set社会福祉法人軽減事由(entity.get社会福祉法人等利用者負担軽減_減免区分());
        eucCsvEntity.set居宅サービス区分(entity.is社会福祉法人等利用者負担軽減_居宅サービス限定() ? 居宅サービス限定 : RString.EMPTY);
        eucCsvEntity.set居住費_食費限定区分(entity.is社会福祉法人等利用者負担軽減_居住費_食費のみ() ? 居住費_食費のみ : RString.EMPTY);
        eucCsvEntity.set旧措置ユニット型個室限定区分(entity.is社会福祉法人等利用者負担軽減_旧措置者ユニット型個室のみ() ? 旧措置ユ個のみ : RString.EMPTY);
        eucCsvEntity.set被保険者番号_総合事業対象者(entity.get総合事業対象者_被保険者番号());
        eucCsvEntity.set履歴番号(entity.get総合事業対象者_履歴番号());
        eucCsvEntity.set事業適用開始日(set年月日(entity.get総合事業対象者_適用開始年月日()));
        eucCsvEntity.set事業適用終了日(set年月日(entity.get総合事業対象者_適用終了年月日()));
        eucCsvEntity.set事業チェック実施日(set年月日(entity.get総合事業対象者_チェックリスト実施日()));
        eucCsvEntity.set事業決定日(set年月日(entity.get総合事業対象者_決定年月日()));
        eucCsvEntity.set転出先保険者番号(RString.EMPTY);
        eucCsvEntity.set届出区分(set届出区分(entity.get居宅届出_届出区分()));
        eucCsvEntity.set居宅計画作成区分(set居宅計画作成区分(entity.get事業者作成_作成区分コード()));
        eucCsvEntity.set計画事業者番号(entity.get事業者作成_計画事業者番号());
        eucCsvEntity.set計画事業者名(entity.get計画事業者_事業者名称());
        eucCsvEntity.set計画事業者カナ(entity.get計画事業者_事業者名称カナ());
        eucCsvEntity.set計画管理者名(entity.get計画事業者代表者_代表者名());
        eucCsvEntity.set計画管理者カナ(entity.get計画事業者代表者_代表者名カナ());
        eucCsvEntity.set計画適用開始日(set年月日(entity.get事業者作成_適用開始年月日()));
        eucCsvEntity.set計画適用終了日(set年月日(entity.get事業者作成_適用終了年月日()));
        eucCsvEntity.set計画届出日(set年月日(entity.get居宅届出_届出年月日()));
        eucCsvEntity.set計画作成日(set年月日(entity.get自己作成_計画作成年月日()));
        eucCsvEntity.set計画変更日(set年月日(entity.get自己作成_計画変更年月日()));
        eucCsvEntity.set変更理由(entity.get自己作成_計画変更事由());
        eucCsvEntity.set一次判定日(set年月日(entity.get今回一次判定結果_要介護認定一次判定年月日()));
        eucCsvEntity.set要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(), entity.get受給者台帳_要介護認定状態区分コード()));
    }

    private RString set年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (isCsvhitsukesurasyuhensyu) {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        }

    }

    private RString set要介護度(RString koroshoIfCode, RString code) {
        if (RString.isNullOrEmpty(koroshoIfCode) || RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(koroshoIfCode), code).getName();
    }

    private RString set資格取得事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 資格取得事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), new Code(事由コード));
        if (資格取得事由 == null) {
            return RString.EMPTY;
        }
        return 資格取得事由.getコード略称();
    }

    private RString set喪失事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 喪失事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), new Code(事由コード));
        if (喪失事由 == null) {
            return RString.EMPTY;
        }
        return 喪失事由.getコード略称();
    }

    private RString set医療保険種別(RString 医療保険種別コード) {
        if (RString.isNullOrEmpty(医療保険種別コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 医療保険種別 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.医療保険種類.getCodeShubetsu(), new Code(医療保険種別コード));
        if (医療保険種別 == null) {
            return RString.EMPTY;
        }
        return 医療保険種別.getコード略称();
    }

    private RString set郵便番号(RString 郵便番号) {
        if (RString.isNullOrEmpty(郵便番号)) {
            return RString.EMPTY;
        }
        return new YubinNo(郵便番号).getEditedYubinNo();
    }

    private RString set受給状況(RString 受給者台帳_有効無効区分) {
        if (RString.isNullOrEmpty(受給者台帳_有効無効区分)) {
            return RString.EMPTY;
        }
        RString 有効無効区分;
        try {
            有効無効区分 = YukoMukoKubun.toValue(受給者台帳_有効無効区分).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (YukoMukoKubun.有効.get名称().equals(有効無効区分)) {
            return ARI;
        } else if (YukoMukoKubun.無効.get名称().equals(有効無効区分)) {
            return MURI;
        }
        return RString.EMPTY;
    }

    private RString set受給申請事由(RString 受給申請事由原, RString 要支援者認定申請区分) {
        if (RString.isNullOrEmpty(受給申請事由原) || RString.isNullOrEmpty(要支援者認定申請区分)) {
            return RString.EMPTY;
        }
        RString 受給申請事由;
        try {
            受給申請事由 = JukyuShinseiJiyu.toValue(受給申請事由原).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (JukyuShinseiJiyu.初回申請.get名称().equals(受給申請事由)) {
            return 初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.get名称().equals(受給申請事由)) {
            return 再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.get名称().equals(受給申請事由)) {
            return 再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.get名称().equals(受給申請事由)) {
            if (NinteiShienShinseiKubun.認定支援申請.get名称().equals(
                    NinteiShienShinseiKubun.toValue(要支援者認定申請区分).get名称())) {
                return 支援から申請;
            } else {
                return 区分変更申請;
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.get名称().equals(受給申請事由)) {
            return サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.get名称().equals(受給申請事由)) {
            return 施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.get名称().equals(受給申請事由)) {
            return 追加;
        }
        return RString.EMPTY;
    }

    private RString setみなし更新認定(RString みなし要介護区分コード) {
        if (RString.isNullOrEmpty(みなし要介護区分コード)) {
            return RString.EMPTY;
        }
        RString みなし要介護区分;
        try {
            みなし要介護区分 = MinashiCode.toValue(みなし要介護区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (MinashiCode.通常の認定.get名称().equals(みなし要介護区分)) {
            return RString.EMPTY;
        } else {
            return MINASHI;
        }
    }

    private RString set異動事由コード(RString データ区分) {
        if (RString.isNullOrEmpty(データ区分)) {
            return RString.EMPTY;
        }
        RString 異動事由コード = Datakubun.toValue(データ区分).get名称();
        if (Datakubun.通常_認定.get名称().equals(異動事由コード)) {
            return RString.EMPTY;
        } else {
            return 異動事由コード;
        }
    }

    private RString set異動事由文言(RString 異動事由コード) {
        if (RString.isNullOrEmpty(異動事由コード)) {
            return RString.EMPTY;
        }
        RString 直近異動事由 = ChokkinIdoJiyuCode.toValue(異動事由コード).get名称();
        if (ChokkinIdoJiyuCode.未登録.get名称().equals(直近異動事由)) {
            return RString.EMPTY;
        } else if (ChokkinIdoJiyuCode.追加_認定.get名称().equals(直近異動事由)) {
            return 追加_認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請認定.get名称().equals(直近異動事由)) {
            return 要介護度変更申請認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請却下.get名称().equals(直近異動事由)) {
            return 要介護度変更申請却下;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請認定.get名称().equals(直近異動事由)) {
            return サービス種類変更申請認定;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請却下.get名称().equals(直近異動事由)) {
            return サービス種類変更申請却下;
        } else if (ChokkinIdoJiyuCode.削除.get名称().equals(直近異動事由)) {
            return 削除;
        } else if (ChokkinIdoJiyuCode.修正.get名称().equals(直近異動事由)) {
            return 修正;
        } else if (ChokkinIdoJiyuCode.受給申請却下.get名称().equals(直近異動事由)) {
            return 受給申請却下;
        } else if (ChokkinIdoJiyuCode.削除回復.get名称().equals(直近異動事由)) {
            return 削除回復;
        } else if (ChokkinIdoJiyuCode.職権記載.get名称().equals(直近異動事由)) {
            return 職権記載;
        } else if (ChokkinIdoJiyuCode.職権修正.get名称().equals(直近異動事由)) {
            return 職権修正;
        } else if (ChokkinIdoJiyuCode.職権取消.get名称().equals(直近異動事由)) {
            return 職権取消;
        } else if (ChokkinIdoJiyuCode.履歴修正.get名称().equals(直近異動事由)) {
            return 履歴修正;
        }
        return RString.EMPTY;
    }

    private RString set申請区分(RString 認定申請区分) {
        if (RString.isNullOrEmpty(認定申請区分)) {
            return RString.EMPTY;
        }
        RString 申請区分;
        try {
            申請区分 = NinteiShienShinseiKubun.toValue(認定申請区分).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (NinteiShienShinseiKubun.認定支援申請.get名称().equals(申請区分)) {
            return 要支援;
        } else {
            return 要介護;
        }
    }

    private RString set障害高齢者自立度(RString 障害高齢者の日常生活自立度コード) {
        if (RString.isNullOrEmpty(障害高齢者の日常生活自立度コード)) {
            return RString.EMPTY;
        }
        return ShogaiNichijoSeikatsuJiritsudoCode.toValue(障害高齢者の日常生活自立度コード).get名称();
    }

    private RString set認知症高齢者自立度(RString 認知症高齢者の日常生活自立度コード) {
        if (RString.isNullOrEmpty(認知症高齢者の日常生活自立度コード)) {
            return RString.EMPTY;
        }
        return NinchishoNichijoSeikatsuJiritsudoCode.toValue(認知症高齢者の日常生活自立度コード).get名称();
    }

    private void set指定事業者(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity) {
        if (介護保険施設.equals(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者名(entity.get指定事業者_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get指定事業者_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(set郵便番号(entity.get指定事業者_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get指定事業者_事業者住所());
            eucCsvEntity.set指定事業者代表者名(entity.get指定事業者代表者_代表者名());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get指定事業者代表者_代表者名カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get指定事業者代表者_代表者役職名());
            eucCsvEntity.set指定事業者電話番号(entity.get指定事業者_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get指定事業者_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(entity.get指定事業者_所属人数());
            eucCsvEntity.set指定事業者利用者数(entity.get指定事業者_利用者数());
            eucCsvEntity.set指定事業者認定日(set年月日(entity.get指定事業者_有効開始日()));
            eucCsvEntity.set指定事業者取消日(set年月日(entity.get指定事業者_有効終了日()));
            eucCsvEntity.set指定事業者実施地域(entity.get指定事業者_サービス実施地域());
        } else if (住所地特例対象施設.equals(entity.get施設入所_入所施設種類()) || 適用除外施設.equals(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者名(entity.get除外他特適用施設_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get除外他特適用施設_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(set郵便番号(entity.get除外他特適用施設_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get除外他特適用施設_事業者住所());
            eucCsvEntity.set指定事業者代表者名(entity.get除外他特適用施設_代表者名称());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get除外他特適用施設_代表者名称カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get除外他特適用施設_役職());
            eucCsvEntity.set指定事業者電話番号(entity.get除外他特適用施設_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get除外他特適用施設_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            eucCsvEntity.set指定事業者利用者数(RString.EMPTY);
            eucCsvEntity.set指定事業者認定日(set年月日(entity.get除外他特適用施設_有効開始年月日()));
            eucCsvEntity.set指定事業者取消日(set年月日(entity.get除外他特適用施設_有効終了年月日()));
            eucCsvEntity.set指定事業者実施地域(RString.EMPTY);
        }
    }

    private RString set届出区分(RString 届出区分) {
        if (区分_1.equals(届出区分)) {
            return SHINKI;
        } else if (区分_2.equals(届出区分)) {
            return HENKO;
        } else if (区分_3.equals(届出区分)) {
            return ZATEI;
        }
        return RString.EMPTY;
    }

    private RString set居宅計画作成区分(RString 作成区分コード) {
        if (RString.isNullOrEmpty(作成区分コード)) {
            return RString.EMPTY;
        }
        return KyotakuservicekeikakuSakuseikubunCode.toValue(作成区分コード).get名称();
    }

    private PersonalData toPersonalData(ShakaiFukushiHojinKeigenEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者台帳管理_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private RString set性別(RString 性別コード) {
        if (RString.isNullOrEmpty(性別コード)) {
            return RString.EMPTY;
        }
        return Seibetsu.toValue(性別コード).get名称();
    }

    private RString set削除理由文言(RString 削除事由コード) {
        if (RString.isNullOrEmpty(削除事由コード)) {
            return RString.EMPTY;
        }
        return SakujoJiyuCode.toValue(削除事由コード).get名称();
    }

    private RString set資格区分(RString 被保険者区分コード) {
        if (RString.isNullOrEmpty(被保険者区分コード)) {
            return RString.EMPTY;
        }
        return HihokenshaKubunCode.toValue(被保険者区分コード).get名称();
    }

    private Association get地方公共団体(LasdecCode 市町村コード) {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        return finder.getAssociation(市町村コード);
    }
}
