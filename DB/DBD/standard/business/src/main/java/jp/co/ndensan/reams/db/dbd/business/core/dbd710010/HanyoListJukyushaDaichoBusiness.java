/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd710010;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusya.HanyoRisutoJyukyusyaCsv2Entity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusya.HanyoRisutoJyukyusyaCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusya.HanyoRisutoJyukyusyaEntity;
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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShienShinseiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 汎用リスト受給者台帳_businessクラスです。
 *
 * @reamsid_L DBD-1800-020 x_youyj
 */
public class HanyoListJukyushaDaichoBusiness {

    private int i = 0;
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
    private static final RString 住所地特例 = new RString("住特");
    private static final RString 情報区分_受給 = new RString("受給");
    private static final RString 情報区分_申請 = new RString("申請");
    private static final RString SHIKAKUSYUTOKU = new RString("資格取得前申請");
    private static final RString 旧措置 = new RString("旧措置者");
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
    private static final RString SHITEII = new RString("指定医");
    private static final RString 介護保険施設 = new RString("11");
    private static final RString 住所地特例対象施設 = new RString("12");
    private static final RString 適用除外施設 = new RString("21");
    private static final RString 画面登録 = new RString("1");
    private static final RString データ連携 = new RString("0");
    private static final RString GAMENTOROKU = new RString("画面登録");
    private static final RString DATARENKEI = new RString("データ連携");
    private static final RString SHINKI = new RString("新規");
    private static final RString HENKO = new RString("変更");
    private static final RString ZATEI = new RString("暫定");
    private static final RString 住基_1 = new RString("1");
    private static final RString 住基 = new RString("住基");
    private static final RString 外国人_2 = new RString("2");
    private static final RString 外国人 = new RString("外国人");
    private static final RString 住登外_3 = new RString("3");
    private static final RString 住登外 = new RString("住登外");

    /**
     * 連番付加が「True」の時、列を出力する
     *
     * @param entity HanyoRisutoJyukyusyaEntity
     * @param 日付スラッシュ付加 boolean
     * @param 地方公共団体 Association
     * @param 保険者リスト HokenshaList
     * @return HanyoRisutoJyukyusyaCsvEntity
     */
    public HanyoRisutoJyukyusyaCsvEntity set連番あり(boolean 日付スラッシュ付加,
            HanyoRisutoJyukyusyaEntity entity, Association 地方公共団体, HokenshaList 保険者リスト) {

        HanyoRisutoJyukyusyaCsvEntity csvEntity = new HanyoRisutoJyukyusyaCsvEntity();
        csvEntity.set連番(new RString(String.valueOf(++i)));
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            csvEntity.set識別コード(kojin.get識別コード().value());
            csvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            csvEntity.set氏名(kojin.get名称().getName().value());
            csvEntity.set氏名カナ(kojin.get名称().getKana().value());
            csvEntity.set生年月日(set年月日(日付スラッシュ付加, kojin.get生年月日().toFlexibleDate()));
            csvEntity.set年齢(kojin.get年齢算出().get年齢());
            csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
            csvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            csvEntity.set世帯コード(kojin.get世帯コード().value());
            csvEntity.set世帯主名(kojin.get世帯主名().value());
            csvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            csvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            csvEntity.set住所番地方書(address.toRString());
            csvEntity.set住所(kojin.get住所().get住所());
            csvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            csvEntity.set方書(kojin.get住所().get方書().value());
            csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            csvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            csvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
            csvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
            csvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
            csvEntity.set連絡先１(kojin.get連絡先１().value());
            csvEntity.set連絡先２(kojin.get連絡先２().value());
            csvEntity.set登録異動日(set年月日(日付スラッシュ付加, kojin.get登録異動年月日()));
            csvEntity.set登録事由(kojin.get登録事由().get異動事由略称());
            csvEntity.set登録届出日(set年月日(日付スラッシュ付加, kojin.get登録届出年月日()));
            csvEntity.set住定異動日(set年月日(日付スラッシュ付加, kojin.get住定異動年月日()));
            csvEntity.set住定事由(kojin.get住定事由().get異動事由略称());
            csvEntity.set住定届出日(set年月日(日付スラッシュ付加, kojin.get住定届出年月日()));
            csvEntity.set消除異動日(set年月日(日付スラッシュ付加, kojin.get消除異動年月日()));
            csvEntity.set消除事由(kojin.get消除事由().get異動事由略称());
            csvEntity.set消除届出日(set年月日(日付スラッシュ付加, kojin.get消除届出年月日()));
            csvEntity.set転出入理由(RString.EMPTY);
            csvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            csvEntity.set前住所番地方書(addressZen.toRString());
            csvEntity.set前住所(kojin.get転入前().get住所());
            csvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            csvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
        csvEntity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        csvEntity.set市町村名(地方公共団体.get市町村名());
        csvEntity.set保険者コード(地方公共団体.get地方公共団体コード().value());
        csvEntity.set保険者名(地方公共団体.getShichosonName_());
        csvEntity.set空白(RString.EMPTY);
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            csvEntity.set送付先氏名(atesaki.get宛先名称().getName().value());
            csvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().value());
            csvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().value());
            csvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            RStringBuilder 送付address = new RStringBuilder();
            送付address.append(atesaki.get宛先住所().get住所()).append(atesaki.get宛先住所().get番地().getBanchi().value())
                    .append(RString.FULL_SPACE).append(atesaki.get宛先住所().get方書().value());
            csvEntity.set送付先住所番地方書(送付address.toRString());
            csvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            csvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
            csvEntity.set送付先方書(atesaki.get宛先住所().get方書().value());
            csvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().value());
            csvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
        }
        csvEntity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        csvEntity.set資格取得事由(set資格取得事由(entity.get被保険者台帳管理_資格取得事由コード()));
        csvEntity.set資格取得日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格取得年月日()));
        csvEntity.set資格取得届出日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格取得届出年月日()));
        csvEntity.set喪失事由(set喪失事由(entity.get被保険者台帳管理_資格喪失事由コード()));
        csvEntity.set資格喪失日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格喪失年月日()));
        csvEntity.set資格喪失届日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格喪失届出年月日()));
        csvEntity.set資格区分(set資格区分(entity.get被保険者台帳管理_被保険者区分コード()));
        csvEntity.set住所地特例状態(new RString("1").equals(entity.get被保険者台帳管理_住所地特例フラグ()) ? 住所地特例 : RString.EMPTY);
        LasdecCode lasdecCode;
        if (new RString("1").equals(entity.get被保険者台帳管理_広域内住所地特例フラグ())) {
            lasdecCode = new LasdecCode(entity.get被保険者台帳管理_広住特措置元市町村コード() == null ? RString.EMPTY : entity
                    .get被保険者台帳管理_広住特措置元市町村コード());
        } else {
            lasdecCode = new LasdecCode(entity.get被保険者台帳管理_市町村コード() == null ? RString.EMPTY : entity
                    .get被保険者台帳管理_市町村コード());
        }
        if (!lasdecCode.isEmpty()) {
            csvEntity.set資格証記載保険者番号(保険者リスト.get(lasdecCode).get証記載保険者番号().value());
        }
        csvEntity.set医療保険種別(set医療保険種別(entity.get医療保険加入状況_医療保険種別コード()));
        csvEntity.set医療保険番号(entity.get医療保険加入状況_医療保険番号());
        csvEntity.set医療保険者名(entity.get医療保険加入状況_医療保険者名称());
        csvEntity.set医療保険記号番号(entity.get医療保険加入状況_医療保険記号番号());
        csvEntity.set特定疾病(RString.isNullOrEmpty(entity.get受給者台帳_2号特定疾病コード()) ? RString.EMPTY
                : TokuteiShippei.toValue(entity.get受給者台帳_2号特定疾病コード()).get名称());
        csvEntity.set受給申請事由(set受給申請事由(
                entity.get受給者台帳_受給申請事由(), entity.get受給者台帳_要支援者認定申請区分(), 情報区分_受給));
        csvEntity.set申請理由(entity.get受給者台帳_申請理由());
        csvEntity.set申請関係者(RString.isNullOrEmpty(entity.get受給者台帳_申請者関係コード()) ? RString.EMPTY
                : ShinseishaKankeiCode.toValue(entity.get受給者台帳_申請者関係コード()).get名称());
        csvEntity.set本人関係(entity.get受給者台帳_本人との関係());
        csvEntity.set申請氏名(entity.get今回申請届出_申請届出者氏名());
        csvEntity.set申請氏名カナ(entity.get今回申請届出_申請届出者氏名カナ());
        csvEntity.set申請代行事業者名(entity.get申請届出事業者_事業者名称());
        csvEntity.set申請代行事業者名カナ(entity.get申請届出事業者_事業者名称カナ());
        csvEntity.set申請者郵便番号(set郵便番号(entity.get今回申請届出_申請届出者郵便番号()));
        csvEntity.set申請住所(entity.get今回申請届出_申請届出者住所());
        csvEntity.set申請連絡先(entity.get今回申請届出_申請届出者電話番号());
        csvEntity.set申請事業コード(entity.get今回申請届出_申請届出代行事業者番号());
        csvEntity.set受給申請日(set年月日(日付スラッシュ付加, entity.get受給者台帳_受給申請年月日()));
        csvEntity.set調査委託先コード(entity.get今回申請_認定調査委託先コード());
        csvEntity.set調査員コード(entity.get今回申請_認定調査員コード());
        csvEntity.set委託先名(entity.get今回調査委託先_事業者名称());
        csvEntity.set委託先名カナ(entity.get今回調査委託先_事業者名称カナ());
        csvEntity.set委託先代表者名(entity.get今回調査委託先_代表者名());
        csvEntity.set委託先代表者名カナ(entity.get今回調査委託先_代表者名カナ());
        csvEntity.set委託先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        csvEntity.set委託先住所(entity.get今回調査委託先_住所());
        csvEntity.set委託先連絡先(entity.get今回調査委託先_電話番号());
        csvEntity.set委託先状況(entity.is今回調査委託先_状況フラグ() ? ARI : MURI);
        csvEntity.set調査員氏名(entity.get今回調査員_調査員氏名());
        csvEntity.set調査員氏名カナ(entity.get今回調査員_調査員氏名カナ());
        csvEntity.set調査員性別(set性別(entity.get今回調査員_性別()));
        csvEntity.set調査員郵便(set郵便番号(entity.get今回調査員_郵便番号()));
        csvEntity.set調査員住所(entity.get今回調査員_住所());
        csvEntity.set調査員連絡先(entity.get今回調査員_電話番号());
        csvEntity.set調査員資格((entity.get今回調査員_調査員資格() == null || entity.get今回調査員_調査員資格().trim().isEmpty()) ? RString.EMPTY
                : Sikaku.toValue(entity.get今回調査員_調査員資格()).get名称());
        csvEntity.set調査員所属機関名(entity.get今回調査員_所属機関名称());
        csvEntity.set調査員状況(entity.is今回調査員_状況フラグ() ? ARI : MURI);
        csvEntity.set医療機関コード(entity.get今回申請_主治医医療機関コード());
        csvEntity.set主治医コード(entity.get今回申請_主治医コード());
        csvEntity.set医療機関名称(entity.get今回主治医医療機関_医療機関名称());
        csvEntity.set医療機関名称カナ(entity.get今回主治医医療機関_医療機関名称カナ());
        csvEntity.set医療機関代表者名(entity.get今回主治医医療機関_代表者名());
        csvEntity.set医療機関代表者名カナ(entity.get今回主治医医療機関_代表者名カナ());
        csvEntity.set医療機関郵便番号(set郵便番号(entity.get今回主治医医療機関_郵便番号()));
        csvEntity.set医療機関住所(entity.get今回主治医医療機関_住所());
        csvEntity.set医療機関連絡先(entity.get今回主治医医療機関_電話番号());
        csvEntity.set医療機関状況(entity.is今回主治医医療機関_状況フラグ() ? ARI : MURI);
        csvEntity.set主治医名(entity.get今回主治医_主治医氏名());
        csvEntity.set主治医名カナ(entity.get今回主治医_主治医カナ());
        csvEntity.set主治医性別(set性別(entity.get今回主治医_性別()));
        csvEntity.set主治医所属(entity.get今回主治医_診療科名称());
        setCsvEntity2(日付スラッシュ付加, csvEntity, entity);
        return csvEntity;
    }

    private HanyoRisutoJyukyusyaCsvEntity setCsvEntity2(
            boolean 日付スラッシュ付加, HanyoRisutoJyukyusyaCsvEntity csvEntity, HanyoRisutoJyukyusyaEntity entity) {
        csvEntity.set主治医状況(entity.is今回主治医_状況フラグ() ? ARI : MURI);
        csvEntity.set一次判定要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(),
                entity.get今回一次判定結果_要介護認定一次判定結果コード()));
        csvEntity.set調査委託日(set年月日(日付スラッシュ付加, entity.get今回調査依頼_認定調査依頼年月日()));
        csvEntity.set調査予定日(set年月日(日付スラッシュ付加, entity.get今回計画情報_認定調査予定年月日()));
        csvEntity.set調査終了日(set年月日(日付スラッシュ付加, entity.get今回完了情報_認定調査完了年月日()));
        csvEntity.set意見依頼日(set年月日(日付スラッシュ付加, entity.get今回意見書作成依頼_主治医意見書作成依頼年月日()));
        csvEntity.set意見予定日(set年月日(日付スラッシュ付加, entity.get今回計画情報_主治医意見書登録予定年月日()));
        csvEntity.set意見取寄日(set年月日(日付スラッシュ付加, entity.get今回意見書情報_主治医意見書受領年月日()));
        csvEntity.set資料作成日(set年月日(日付スラッシュ付加, entity.get今回結果情報_介護認定審査会資料作成年月日()));
        csvEntity.set審査予定日(set年月日(日付スラッシュ付加, entity.get今回計画情報_認定審査会予定年月日()));
        csvEntity.set審査回答日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定年月日()));
        csvEntity.set一次判定日(set年月日(日付スラッシュ付加, entity.get今回一次判定結果_要介護認定一次判定年月日()));
        csvEntity.set要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(), entity.get受給者台帳_要介護認定状態区分コード()));
        csvEntity.set認定開始日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定有効期間開始年月日()));
        csvEntity.set認定終了日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定有効期間終了年月日()));
        csvEntity.set認定日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定年月日()));
        csvEntity.set旧措置(entity.is受給者台帳_旧措置者フラグ() ? 旧措置 : RString.EMPTY);
        csvEntity.setみなし更新認定(setみなし更新認定(entity.get受給者台帳_みなし要介護区分コード()));
        csvEntity.set審査会意見(entity.get今回結果情報_介護認定審査会意見());
        RStringBuilder サービス種類 = new RStringBuilder();
        サービス種類.append(entity.get受給者台帳_指定サービス種類01()).append(entity.get受給者台帳_指定サービス種類01())
                .append(entity.get受給者台帳_指定サービス種類02()).append(entity.get受給者台帳_指定サービス種類03())
                .append(entity.get受給者台帳_指定サービス種類04()).append(entity.get受給者台帳_指定サービス種類05());
        if (!RString.isNullOrEmpty(entity.get受給者台帳_指定サービス種類06())) {
            サービス種類.append(種類);
        }
        csvEntity.set指定サービス種類(サービス種類.toRString());
        csvEntity.set受給喪失日(set年月日(日付スラッシュ付加, entity.get受給者台帳_喪失年月日()));
        csvEntity.set直近事由(entity.get受給者台帳_直近異動事由コード());
        csvEntity.set受給状況(set受給状況(entity.get受給者台帳_有効無効区分()));
        csvEntity.set異動事由コード(set異動事由コード(entity.get受給者台帳_データ区分()));
        csvEntity.set異動事由追加文(entity.get受給者台帳_異動理由());
        csvEntity.set削除理由コード(entity.get受給者台帳_削除事由コード());
        csvEntity.set異動事由文言(set異動事由文言(entity.get受給者台帳_直近異動事由コード()));
        csvEntity.set削除理由文言(set削除理由文言(entity.get受給者台帳_削除事由コード()));
        csvEntity.set支援申請区分(set申請区分(entity.get受給者台帳_要支援者認定申請区分()));
        csvEntity.set初回申請日(set年月日(日付スラッシュ付加, entity.get初回受給情報_受給申請年月日()));
        csvEntity.set初回認定日(set年月日(日付スラッシュ付加, entity.get初回受給情報_認定年月日()));
        csvEntity.set初回要介護度(set要介護度(entity.get初回申請_厚労省IF識別コード(),
                entity.get初回受給情報_要介護認定状態区分コード()));
        csvEntity.set初回認定開始日(set年月日(日付スラッシュ付加, entity.get初回受給情報_認定有効期間開始年月日()));
        csvEntity.set初回認定終了日(set年月日(日付スラッシュ付加, entity.get初回受給情報_認定有効期間終了年月日()));
        csvEntity.set初回申請事由(set受給申請事由(
                entity.get初回受給情報_受給申請事由(), entity.get初回申請_要支援者認定申請区分(), 情報区分_申請));
        csvEntity.set初回みなし更新(setみなし更新認定(entity.get初回受給情報_みなし要介護区分コード()));
        csvEntity.set初回当初認定有効開始日(set年月日(日付スラッシュ付加, entity.get初回受給情報_当初認定有効開始年月日()));
        csvEntity.set初回当初認定有効終了日(set年月日(日付スラッシュ付加, entity.get初回受給情報_当初認定有効終了年月日()));
        csvEntity.set初回支援申請事由(set申請区分(entity.get初回申請_要支援者認定申請区分()));
        csvEntity.set前回申請日(set年月日(日付スラッシュ付加, entity.get前回受給情報_受給申請年月日()));
        csvEntity.set前回認定日(set年月日(日付スラッシュ付加, entity.get前回受給情報_認定年月日()));
        csvEntity.set前回要介護度(set要介護度(entity.get前回申請_厚労省IF識別コード(),
                entity.get前回受給情報_要介護認定状態区分コード()));
        csvEntity.set前回認定開始日(set年月日(日付スラッシュ付加, entity.get前回受給情報_認定有効期間開始年月日()));
        csvEntity.set前回認定終了日(set年月日(日付スラッシュ付加, entity.get前回受給情報_認定有効期間終了年月日()));
        csvEntity.set前回受給申請事由(set受給申請事由(entity.get前回受給情報_受給申請事由(),
                entity.get前回申請_要支援者認定申請区分(), 情報区分_申請));
        csvEntity.set前回みなし更新(setみなし更新認定(entity.get前回受給情報_みなし要介護区分コード()));
        csvEntity.set前回当初認定有効開始日(set年月日(日付スラッシュ付加, entity.get前回受給情報_当初認定有効開始年月日()));
        csvEntity.set前回当初認定有効終了日(set年月日(日付スラッシュ付加, entity.get前回受給情報_当初認定有効終了年月日()));
        csvEntity.set前回支援申請事由(set申請区分(entity.get前回申請_要支援者認定申請区分()));
        csvEntity.set前回調査委託先コード(entity.get前回申請_認定調査委託先コード());
        csvEntity.set前回調査員コード(entity.get前回申請_認定調査員コード());
        csvEntity.set前回委託先名(entity.get前回調査委託先_事業者名称());
        csvEntity.set前回調査員氏名(entity.get前回調査員_調査員氏名());
        csvEntity.set前々回申請日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_受給申請年月日()));
        csvEntity.set前々回認定日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_認定年月日()));
        csvEntity.set前々回要介護度(set要介護度(entity.get前々回申請_厚労省IF識別コード(),
                entity.get前々回受給情報_要介護認定状態区分コード()));
        csvEntity.set前々回認定開始日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_認定有効期間開始年月日()));
        csvEntity.set前々回認定終了日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_認定有効期間終了年月日()));
        csvEntity.set前々回受給申請事由(set受給申請事由(entity.get前々回受給情報_受給申請事由(),
                entity.get前々回申請_要支援者認定申請区分(), 情報区分_申請));
        csvEntity.set前々回みなし更新(setみなし更新認定(entity.get前々回受給情報_みなし要介護区分コード()));
        csvEntity.set前々回当初認定有効開始日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_当初認定有効開始年月日()));
        csvEntity.set前々回当初認定有効終了日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_当初認定有効終了年月日()));
        csvEntity.set前々回支援申請事由(set申請区分(entity.get前々回受給情報_要支援者認定申請区分()));
        csvEntity.set前々回調査委託先コード(entity.get前々回申請_認定調査委託先コード());
        csvEntity.set前々回調査員コード(entity.get前々回申請_認定調査員コード());
        csvEntity.set前々回委託先名(entity.get前々回調査委託先_事業者名称());
        csvEntity.set前々回調査員氏名(entity.get前々回調査員_調査員氏名());
        csvEntity.set障害高齢者自立度(set障害高齢者自立度(entity.get今回調査結果_基本_認定調査_障害高齢者の日常生活自立度コード()));
        csvEntity.set認知症高齢者自立度(set認知症高齢者自立度(entity.get今回調査結果_基本_認定調査_認知症高齢者の日常生活自立度コード()));
        csvEntity.set訪問支給限度額単位数(entity.get受給者台帳_支給限度単位数());
        csvEntity.set訪問支給限度有効開始年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_支給限度有効開始年月日()));
        csvEntity.set訪問支給限度有効終了年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_支給限度有効終了年月日()));
        csvEntity.set短期入所支給限度日数(entity.get受給者台帳_短期入所支給限度日数());
        csvEntity.set短期入所支給限度有効開始年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_短期入所支給限度開始年月日()));
        csvEntity.set短期入所支給限度有効終了年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_短期入所支給限度終了年月日()));
        csvEntity.set当初認定有効開始年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_当初認定有効開始年月日()));
        csvEntity.set当初認定有効終了年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_当初認定有効終了年月日()));
        csvEntity.set認定延期通知書発行年月日(set年月日(日付スラッシュ付加, entity.get今回申請_延期通知発行年月日()));
        csvEntity.set認定延期通知書発行回数(entity.get今回申請_延期通知発行回数());
        csvEntity.set延期処理見込み開始年月日(set年月日(日付スラッシュ付加, entity.get今回申請_延期見込期間開始年月日()));
        csvEntity.set延期処理見込み終了年月日(set年月日(日付スラッシュ付加, entity.get今回申請_延期見込期間終了年月日()));
        csvEntity.set受給資格証明書発行日１(set年月日(日付スラッシュ付加, entity.get受給者台帳_受給資格証明書発行年月日１()));
        csvEntity.set受給資格証明書発行日２(set年月日(日付スラッシュ付加, entity.get受給者台帳_受給資格証明書発行年月日２()));
        csvEntity.set資格取得前申請区分(entity.is受給者台帳_資格取得前申請フラグ() ? SHIKAKUSYUTOKU : RString.EMPTY);
        csvEntity.set一次判定結果重み(RString.EMPTY);
        csvEntity.set指定医区分(entity.is今回申請_指定医フラグ() ? SHITEII : RString.EMPTY);
        csvEntity.set訪問調査先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        csvEntity.set訪問調査先住所(entity.get今回調査委託先_住所());
        csvEntity.set訪問調査先名称(entity.get今回調査委託先_事業者名称());
        csvEntity.set訪問調査先電話番号(entity.get今回調査委託先_電話番号());
        csvEntity.set申請区分申請時(set申請区分申請時(entity.get今回申請_認定申請区分申請時コード()));
        csvEntity.set申請区分法令(set申請区分法令(entity.get今回申請_認定申請区分法令コード()));
        csvEntity.set指定事業者コード(entity.get施設入所_入所施設コード());
        csvEntity.set施設入所日(set年月日(日付スラッシュ付加, entity.get施設入所_入所年月日()));
        csvEntity.set施設退所日(set年月日(日付スラッシュ付加, entity.get施設入所_退所年月日()));
        set指定事業者(日付スラッシュ付加, csvEntity, entity);
        csvEntity.set転出先保険者番号(RString.EMPTY);
        csvEntity.set所得段階(RString.EMPTY);
        csvEntity.set後期保険者番号(entity.get後期高齢者情報_後期高齢保険者番号市町村());
        csvEntity.set後期被保険者番号(entity.get後期高齢者情報_後期高齢被保険者番号());
        csvEntity.set後期取得日(set年月日(日付スラッシュ付加, entity.get後期高齢者情報_資格取得日()));
        csvEntity.set後期喪失日(set年月日(日付スラッシュ付加, entity.get後期高齢者情報_資格喪失日()));
        csvEntity.set後期登録区分(set後期登録区分(entity.get後期高齢者情報_登録区分()));
        csvEntity.set国保番号(entity.get国保資格情報_国保番号());
        csvEntity.set国保保険者番号(entity.get国保資格情報_国保保険者番号());
        csvEntity.set国保保険証番号(entity.get国保資格情報_国保保険証番号());
        csvEntity.set国保個人番号(entity.get国保資格情報_国保個人番号());
        csvEntity.set国保取得日(set年月日(日付スラッシュ付加, entity.get国保資格情報_資格取得日()));
        csvEntity.set国保喪失日(set年月日(日付スラッシュ付加, entity.get国保資格情報_資格喪失日()));
        csvEntity.set国保登録区分(set登録区分(entity.get国保資格情報_登録区分()));
        csvEntity.set二次予防適用開始日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_適用開始年月日()));
        csvEntity.set二次予防適用終了日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_適用終了年月日()));
        csvEntity.set二次予防調査実施日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_調査実施日()));
        csvEntity.set二次予防決定日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_決定年月日()));
        csvEntity.set届出区分(set届出区分(entity.get居宅届出_届出区分()));
        csvEntity.set居宅計画作成区分(set居宅計画作成区分(entity.get事業者作成_作成区分コード()));
        csvEntity.set計画事業者番号(entity.get事業者作成_計画事業者番号());
        csvEntity.set計画事業者名(entity.get計画事業者_事業者名称());
        csvEntity.set計画事業者カナ(entity.get計画事業者_事業者名称カナ());
        csvEntity.set計画管理者名(entity.get計画事業者代表者_代表者名());
        csvEntity.set計画管理者カナ(entity.get計画事業者代表者_代表者名カナ());
        csvEntity.set計画適用開始日(set年月日(日付スラッシュ付加, entity.get事業者作成_適用開始年月日()));
        csvEntity.set計画適用終了日(set年月日(日付スラッシュ付加, entity.get事業者作成_適用終了年月日()));
        csvEntity.set計画届出日(set年月日(日付スラッシュ付加, entity.get居宅届出_届出年月日()));
        csvEntity.set計画作成日(set年月日(日付スラッシュ付加, entity.get自己作成_計画作成年月日()));
        csvEntity.set計画変更日(set年月日(日付スラッシュ付加, entity.get自己作成_計画変更年月日()));
        csvEntity.set変更理由(entity.get自己作成_計画変更事由());
        csvEntity.set委託先計画事業者番号(entity.get計画事業者_委託先事業者番号());
        csvEntity.set委託先計画事業者名(entity.get委託先事業者_事業者名称());
        csvEntity.set委託先計画事業者カナ(entity.get委託先事業者_事業者名称カナ());
        csvEntity.set委託先計画管理者名(entity.get委託先事業者代表者_代表者名());
        csvEntity.set委託先計画管理者カナ(entity.get委託先事業者代表者_代表者名カナ());
        return csvEntity;
    }

    /**
     * 連番付加が「False」の時、列を出力しない
     *
     * @param 地方公共団体 Association
     * @param 保険者リスト HokenshaList
     * @param 日付スラッシュ付加 boolean
     * @param entity HanyoRisutoJyukyusyaEntity
     * @return HanyoRisutoJyukyusyaCsv2Entity
     */
    public HanyoRisutoJyukyusyaCsv2Entity set連番なし(boolean 日付スラッシュ付加,
            HanyoRisutoJyukyusyaEntity entity, Association 地方公共団体, HokenshaList 保険者リスト) {
        HanyoRisutoJyukyusyaCsv2Entity csvEntity = new HanyoRisutoJyukyusyaCsv2Entity();
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            csvEntity.set識別コード(kojin.get識別コード().value());
            csvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            csvEntity.set氏名(kojin.get名称().getName().value());
            csvEntity.set氏名カナ(kojin.get名称().getKana().value());
            csvEntity.set生年月日(set年月日(日付スラッシュ付加, kojin.get生年月日().toFlexibleDate()));
            csvEntity.set年齢(kojin.get年齢算出().get年齢());
            csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
            csvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            csvEntity.set世帯コード(kojin.get世帯コード().value());
            csvEntity.set世帯主名(kojin.get世帯主名().value());
            csvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            csvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            csvEntity.set住所番地方書(address.toRString());
            csvEntity.set住所(kojin.get住所().get住所());
            csvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            csvEntity.set方書(kojin.get住所().get方書().value());
            csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            csvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            csvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
            csvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
            csvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
            csvEntity.set連絡先１(kojin.get連絡先１().value());
            csvEntity.set連絡先２(kojin.get連絡先２().value());
            csvEntity.set登録異動日(set年月日(日付スラッシュ付加, kojin.get登録異動年月日()));
            csvEntity.set登録事由(kojin.get登録事由().get異動事由略称());
            csvEntity.set登録届出日(set年月日(日付スラッシュ付加, kojin.get登録届出年月日()));
            csvEntity.set住定異動日(set年月日(日付スラッシュ付加, kojin.get住定異動年月日()));
            csvEntity.set住定事由(kojin.get住定事由().get異動事由略称());
            csvEntity.set住定届出日(set年月日(日付スラッシュ付加, kojin.get住定届出年月日()));
            csvEntity.set消除異動日(set年月日(日付スラッシュ付加, kojin.get消除異動年月日()));
            csvEntity.set消除事由(kojin.get消除事由().get異動事由略称());
            csvEntity.set消除届出日(set年月日(日付スラッシュ付加, kojin.get消除届出年月日()));
            csvEntity.set転出入理由(RString.EMPTY);
            csvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            csvEntity.set前住所番地方書(addressZen.toRString());
            csvEntity.set前住所(kojin.get転入前().get住所());
            csvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            csvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
        csvEntity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        csvEntity.set市町村名(地方公共団体.get市町村名());
        csvEntity.set保険者コード(地方公共団体.get地方公共団体コード().value());
        csvEntity.set保険者名(地方公共団体.getShichosonName_());
        csvEntity.set空白(RString.EMPTY);
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            csvEntity.set送付先氏名(atesaki.get宛先名称().getName().value());
            csvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().value());
            csvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().value());
            csvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            RStringBuilder 送付address = new RStringBuilder();
            送付address.append(atesaki.get宛先住所().get住所()).append(atesaki.get宛先住所().get番地().getBanchi().value())
                    .append(RString.FULL_SPACE).append(atesaki.get宛先住所().get方書().value());
            csvEntity.set送付先住所番地方書(送付address.toRString());
            csvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            csvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
            csvEntity.set送付先方書(atesaki.get宛先住所().get方書().value());
            csvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().value());
            csvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
        }
        csvEntity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        csvEntity.set資格取得事由(set資格取得事由(entity.get被保険者台帳管理_資格取得事由コード()));
        csvEntity.set資格取得日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格取得年月日()));
        csvEntity.set資格取得届出日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格取得届出年月日()));
        csvEntity.set喪失事由(set喪失事由(entity.get被保険者台帳管理_資格喪失事由コード()));
        csvEntity.set資格喪失日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格喪失年月日()));
        csvEntity.set資格喪失届日(set年月日(日付スラッシュ付加, entity.get被保険者台帳管理_資格喪失届出年月日()));
        csvEntity.set資格区分(set資格区分(entity.get被保険者台帳管理_被保険者区分コード()));
        csvEntity.set住所地特例状態(new RString("1").equals(entity.get被保険者台帳管理_住所地特例フラグ()) ? 住所地特例 : RString.EMPTY);
        LasdecCode lasdecCode;
        if (new RString("1").equals(entity.get被保険者台帳管理_広域内住所地特例フラグ())) {
            lasdecCode = new LasdecCode(entity.get被保険者台帳管理_広住特措置元市町村コード() == null ? RString.EMPTY : entity
                    .get被保険者台帳管理_広住特措置元市町村コード());
        } else {
            lasdecCode = new LasdecCode(
                    entity.get被保険者台帳管理_市町村コード() == null ? RString.EMPTY : entity.get被保険者台帳管理_市町村コード());
        }
        if (!lasdecCode.isEmpty()) {
            csvEntity.set資格証記載保険者番号(保険者リスト.get(lasdecCode).get証記載保険者番号().value());
        }
        csvEntity.set医療保険種別(set医療保険種別(entity.get医療保険加入状況_医療保険種別コード()));
        csvEntity.set医療保険番号(entity.get医療保険加入状況_医療保険番号());
        csvEntity.set医療保険者名(entity.get医療保険加入状況_医療保険者名称());
        csvEntity.set医療保険記号番号(entity.get医療保険加入状況_医療保険記号番号());
        csvEntity.set特定疾病(RString.isNullOrEmpty(entity.get受給者台帳_2号特定疾病コード()) ? RString.EMPTY
                : TokuteiShippei.toValue(entity.get受給者台帳_2号特定疾病コード()).get名称());
        csvEntity.set受給申請事由(set受給申請事由(
                entity.get受給者台帳_受給申請事由(), entity.get受給者台帳_要支援者認定申請区分(), 情報区分_受給));
        csvEntity.set申請理由(entity.get受給者台帳_申請理由());
        csvEntity.set申請関係者(RString.isNullOrEmpty(entity.get受給者台帳_申請者関係コード()) ? RString.EMPTY
                : ShinseishaKankeiCode.toValue(entity.get受給者台帳_申請者関係コード()).get名称());
        csvEntity.set本人関係(entity.get受給者台帳_本人との関係());
        csvEntity.set申請氏名(entity.get今回申請届出_申請届出者氏名());
        csvEntity.set申請氏名カナ(entity.get今回申請届出_申請届出者氏名カナ());
        csvEntity.set申請代行事業者名(entity.get申請届出事業者_事業者名称());
        csvEntity.set申請代行事業者名カナ(entity.get申請届出事業者_事業者名称カナ());
        csvEntity.set申請者郵便番号(set郵便番号(entity.get今回申請届出_申請届出者郵便番号()));
        csvEntity.set申請住所(entity.get今回申請届出_申請届出者住所());
        csvEntity.set申請連絡先(entity.get今回申請届出_申請届出者電話番号());
        csvEntity.set申請事業コード(entity.get今回申請届出_申請届出代行事業者番号());
        csvEntity.set受給申請日(set年月日(日付スラッシュ付加, entity.get受給者台帳_受給申請年月日()));
        csvEntity.set調査委託先コード(entity.get今回申請_認定調査委託先コード());
        csvEntity.set調査員コード(entity.get今回申請_認定調査員コード());
        csvEntity.set委託先名(entity.get今回調査委託先_事業者名称());
        csvEntity.set委託先名カナ(entity.get今回調査委託先_事業者名称カナ());
        csvEntity.set委託先代表者名(entity.get今回調査委託先_代表者名());
        csvEntity.set委託先代表者名カナ(entity.get今回調査委託先_代表者名カナ());
        csvEntity.set委託先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        csvEntity.set委託先住所(entity.get今回調査委託先_住所());
        csvEntity.set委託先連絡先(entity.get今回調査委託先_電話番号());
        csvEntity.set委託先状況(entity.is今回調査委託先_状況フラグ() ? ARI : MURI);
        csvEntity.set調査員氏名(entity.get今回調査員_調査員氏名());
        csvEntity.set調査員氏名カナ(entity.get今回調査員_調査員氏名カナ());
        csvEntity.set調査員性別(set性別(entity.get今回調査員_性別()));
        csvEntity.set調査員郵便(set郵便番号(entity.get今回調査員_郵便番号()));
        csvEntity.set調査員住所(entity.get今回調査員_住所());
        csvEntity.set調査員連絡先(entity.get今回調査員_電話番号());
        csvEntity.set調査員資格((entity.get今回調査員_調査員資格() == null || entity.get今回調査員_調査員資格().trim().isEmpty()) ? RString.EMPTY
                : Sikaku.toValue(entity.get今回調査員_調査員資格()).get名称());
        csvEntity.set調査員所属機関名(entity.get今回調査員_所属機関名称());
        csvEntity.set調査員状況(entity.is今回調査員_状況フラグ() ? ARI : MURI);
        csvEntity.set医療機関コード(entity.get今回申請_主治医医療機関コード());
        csvEntity.set主治医コード(entity.get今回申請_主治医コード());
        csvEntity.set医療機関名称(entity.get今回主治医医療機関_医療機関名称());
        csvEntity.set医療機関名称カナ(entity.get今回主治医医療機関_医療機関名称カナ());
        csvEntity.set医療機関代表者名(entity.get今回主治医医療機関_代表者名());
        csvEntity.set医療機関代表者名カナ(entity.get今回主治医医療機関_代表者名カナ());
        csvEntity.set医療機関郵便番号(set郵便番号(entity.get今回主治医医療機関_郵便番号()));
        csvEntity.set医療機関住所(entity.get今回主治医医療機関_住所());
        csvEntity.set医療機関連絡先(entity.get今回主治医医療機関_電話番号());
        csvEntity.set医療機関状況(entity.is今回主治医医療機関_状況フラグ() ? ARI : MURI);
        csvEntity.set主治医名(entity.get今回主治医_主治医氏名());
        csvEntity.set主治医名カナ(entity.get今回主治医_主治医カナ());
        csvEntity.set主治医性別(set性別(entity.get今回主治医_性別()));
        csvEntity.set主治医所属(entity.get今回主治医_診療科名称());
        csvEntity.set主治医状況(entity.is今回主治医_状況フラグ() ? ARI : MURI);
        setCsvEntityNashi2(日付スラッシュ付加, csvEntity, entity);
        return csvEntity;
    }

    private HanyoRisutoJyukyusyaCsv2Entity setCsvEntityNashi2(
            boolean 日付スラッシュ付加, HanyoRisutoJyukyusyaCsv2Entity csvEntity, HanyoRisutoJyukyusyaEntity entity) {
        csvEntity.set一次判定要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(),
                entity.get今回一次判定結果_要介護認定一次判定結果コード()));
        csvEntity.set調査委託日(set年月日(日付スラッシュ付加, entity.get今回調査依頼_認定調査依頼年月日()));
        csvEntity.set調査予定日(set年月日(日付スラッシュ付加, entity.get今回計画情報_認定調査予定年月日()));
        csvEntity.set調査終了日(set年月日(日付スラッシュ付加, entity.get今回完了情報_認定調査完了年月日()));
        csvEntity.set意見依頼日(set年月日(日付スラッシュ付加, entity.get今回意見書作成依頼_主治医意見書作成依頼年月日()));
        csvEntity.set意見予定日(set年月日(日付スラッシュ付加, entity.get今回計画情報_主治医意見書登録予定年月日()));
        csvEntity.set意見取寄日(set年月日(日付スラッシュ付加, entity.get今回意見書情報_主治医意見書受領年月日()));
        csvEntity.set資料作成日(set年月日(日付スラッシュ付加, entity.get今回結果情報_介護認定審査会資料作成年月日()));
        csvEntity.set審査予定日(set年月日(日付スラッシュ付加, entity.get今回計画情報_認定審査会予定年月日()));
        csvEntity.set審査回答日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定年月日()));
        csvEntity.set一次判定日(set年月日(日付スラッシュ付加, entity.get今回一次判定結果_要介護認定一次判定年月日()));
        csvEntity.set要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(), entity.get受給者台帳_要介護認定状態区分コード()));
        csvEntity.set認定開始日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定有効期間開始年月日()));
        csvEntity.set認定終了日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定有効期間終了年月日()));
        csvEntity.set認定日(set年月日(日付スラッシュ付加, entity.get受給者台帳_認定年月日()));
        csvEntity.set旧措置(entity.is受給者台帳_旧措置者フラグ() ? 旧措置 : RString.EMPTY);
        csvEntity.setみなし更新認定(setみなし更新認定(entity.get受給者台帳_みなし要介護区分コード()));
        csvEntity.set審査会意見(entity.get今回結果情報_介護認定審査会意見());
        RStringBuilder サービス種類 = new RStringBuilder();
        サービス種類.append(entity.get受給者台帳_指定サービス種類01()).append(entity.get受給者台帳_指定サービス種類01())
                .append(entity.get受給者台帳_指定サービス種類02()).append(entity.get受給者台帳_指定サービス種類03())
                .append(entity.get受給者台帳_指定サービス種類04()).append(entity.get受給者台帳_指定サービス種類05());
        if (!RString.isNullOrEmpty(entity.get受給者台帳_指定サービス種類06())) {
            サービス種類.append(種類);
        }
        csvEntity.set指定サービス種類(サービス種類.toRString());
        csvEntity.set受給喪失日(set年月日(日付スラッシュ付加, entity.get受給者台帳_喪失年月日()));
        csvEntity.set直近事由(entity.get受給者台帳_直近異動事由コード());
        csvEntity.set受給状況(set受給状況(entity.get受給者台帳_有効無効区分()));
        csvEntity.set異動事由コード(set異動事由コード(entity.get受給者台帳_データ区分()));
        csvEntity.set異動事由追加文(entity.get受給者台帳_異動理由());
        csvEntity.set削除理由コード(entity.get受給者台帳_削除事由コード());
        csvEntity.set異動事由文言(set異動事由文言(entity.get受給者台帳_直近異動事由コード()));
        csvEntity.set削除理由文言(set削除理由文言(entity.get受給者台帳_削除事由コード()));
        csvEntity.set支援申請区分(set申請区分(entity.get受給者台帳_要支援者認定申請区分()));
        csvEntity.set初回申請日(set年月日(日付スラッシュ付加, entity.get初回受給情報_受給申請年月日()));
        csvEntity.set初回認定日(set年月日(日付スラッシュ付加, entity.get初回受給情報_認定年月日()));
        csvEntity.set初回要介護度(set要介護度(entity.get初回申請_厚労省IF識別コード(),
                entity.get初回受給情報_要介護認定状態区分コード()));
        csvEntity.set初回認定開始日(set年月日(日付スラッシュ付加, entity.get初回受給情報_認定有効期間開始年月日()));
        csvEntity.set初回認定終了日(set年月日(日付スラッシュ付加, entity.get初回受給情報_認定有効期間終了年月日()));
        csvEntity.set初回申請事由(set受給申請事由(
                entity.get初回受給情報_受給申請事由(), entity.get初回申請_要支援者認定申請区分(), 情報区分_申請));
        csvEntity.set初回みなし更新(setみなし更新認定(entity.get初回受給情報_みなし要介護区分コード()));
        csvEntity.set初回当初認定有効開始日(set年月日(日付スラッシュ付加, entity.get初回受給情報_当初認定有効開始年月日()));
        csvEntity.set初回当初認定有効終了日(set年月日(日付スラッシュ付加, entity.get初回受給情報_当初認定有効終了年月日()));
        csvEntity.set初回支援申請事由(set申請区分(entity.get初回申請_要支援者認定申請区分()));
        csvEntity.set前回申請日(set年月日(日付スラッシュ付加, entity.get前回受給情報_受給申請年月日()));
        csvEntity.set前回認定日(set年月日(日付スラッシュ付加, entity.get前回受給情報_認定年月日()));
        csvEntity.set前回要介護度(set要介護度(entity.get前回申請_厚労省IF識別コード(),
                entity.get前回受給情報_要介護認定状態区分コード()));
        csvEntity.set前回認定開始日(set年月日(日付スラッシュ付加, entity.get前回受給情報_認定有効期間開始年月日()));
        csvEntity.set前回認定終了日(set年月日(日付スラッシュ付加, entity.get前回受給情報_認定有効期間終了年月日()));
        csvEntity.set前回受給申請事由(set受給申請事由(entity.get前回受給情報_受給申請事由(),
                entity.get前回申請_要支援者認定申請区分(), 情報区分_申請));
        csvEntity.set前回みなし更新(setみなし更新認定(entity.get前回受給情報_みなし要介護区分コード()));
        csvEntity.set前回当初認定有効開始日(set年月日(日付スラッシュ付加, entity.get前回受給情報_当初認定有効開始年月日()));
        csvEntity.set前回当初認定有効終了日(set年月日(日付スラッシュ付加, entity.get前回受給情報_当初認定有効終了年月日()));
        csvEntity.set前回支援申請事由(set申請区分(entity.get前回申請_要支援者認定申請区分()));
        csvEntity.set前回調査委託先コード(entity.get前回申請_認定調査委託先コード());
        csvEntity.set前回調査員コード(entity.get前回申請_認定調査員コード());
        csvEntity.set前回委託先名(entity.get前回調査委託先_事業者名称());
        csvEntity.set前回調査員氏名(entity.get前回調査員_調査員氏名());
        csvEntity.set前々回申請日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_受給申請年月日()));
        csvEntity.set前々回認定日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_認定年月日()));
        csvEntity.set前々回要介護度(set要介護度(entity.get前々回申請_厚労省IF識別コード(),
                entity.get前々回受給情報_要介護認定状態区分コード()));
        csvEntity.set前々回認定開始日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_認定有効期間開始年月日()));
        csvEntity.set前々回認定終了日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_認定有効期間終了年月日()));
        csvEntity.set前々回受給申請事由(set受給申請事由(entity.get前々回受給情報_受給申請事由(),
                entity.get前々回申請_要支援者認定申請区分(), 情報区分_申請));
        csvEntity.set前々回みなし更新(setみなし更新認定(entity.get前々回受給情報_みなし要介護区分コード()));
        csvEntity.set前々回当初認定有効開始日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_当初認定有効開始年月日()));
        csvEntity.set前々回当初認定有効終了日(set年月日(日付スラッシュ付加, entity.get前々回受給情報_当初認定有効終了年月日()));
        csvEntity.set前々回支援申請事由(set申請区分(entity.get前々回受給情報_要支援者認定申請区分()));
        csvEntity.set前々回調査委託先コード(entity.get前々回申請_認定調査委託先コード());
        csvEntity.set前々回調査員コード(entity.get前々回申請_認定調査員コード());
        csvEntity.set前々回委託先名(entity.get前々回調査委託先_事業者名称());
        csvEntity.set前々回調査員氏名(entity.get前々回調査員_調査員氏名());
        csvEntity.set障害高齢者自立度(set障害高齢者自立度(entity.get今回調査結果_基本_認定調査_障害高齢者の日常生活自立度コード()));
        csvEntity.set認知症高齢者自立度(set認知症高齢者自立度(entity.get今回調査結果_基本_認定調査_認知症高齢者の日常生活自立度コード()));
        csvEntity.set訪問支給限度額単位数(entity.get受給者台帳_支給限度単位数());
        csvEntity.set訪問支給限度有効開始年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_支給限度有効開始年月日()));
        csvEntity.set訪問支給限度有効終了年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_支給限度有効終了年月日()));
        csvEntity.set短期入所支給限度日数(entity.get受給者台帳_短期入所支給限度日数());
        csvEntity.set短期入所支給限度有効開始年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_短期入所支給限度開始年月日()));
        csvEntity.set短期入所支給限度有効終了年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_短期入所支給限度終了年月日()));
        csvEntity.set当初認定有効開始年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_当初認定有効開始年月日()));
        csvEntity.set当初認定有効終了年月日(set年月日(日付スラッシュ付加, entity.get受給者台帳_当初認定有効終了年月日()));
        csvEntity.set認定延期通知書発行年月日(set年月日(日付スラッシュ付加, entity.get今回申請_延期通知発行年月日()));
        csvEntity.set認定延期通知書発行回数(entity.get今回申請_延期通知発行回数());
        csvEntity.set延期処理見込み開始年月日(set年月日(日付スラッシュ付加, entity.get今回申請_延期見込期間開始年月日()));
        csvEntity.set延期処理見込み終了年月日(set年月日(日付スラッシュ付加, entity.get今回申請_延期見込期間終了年月日()));
        csvEntity.set受給資格証明書発行日１(set年月日(日付スラッシュ付加, entity.get受給者台帳_受給資格証明書発行年月日１()));
        csvEntity.set受給資格証明書発行日２(set年月日(日付スラッシュ付加, entity.get受給者台帳_受給資格証明書発行年月日２()));
        csvEntity.set資格取得前申請区分(entity.is受給者台帳_資格取得前申請フラグ() ? SHIKAKUSYUTOKU : RString.EMPTY);
        csvEntity.set一次判定結果重み(RString.EMPTY);
        csvEntity.set指定医区分(entity.is今回申請_指定医フラグ() ? SHITEII : RString.EMPTY);
        csvEntity.set訪問調査先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        csvEntity.set訪問調査先住所(entity.get今回調査委託先_住所());
        csvEntity.set訪問調査先名称(entity.get今回調査委託先_事業者名称());
        csvEntity.set訪問調査先電話番号(entity.get今回調査委託先_電話番号());
        csvEntity.set申請区分申請時(set申請区分申請時(entity.get今回申請_認定申請区分申請時コード()));
        csvEntity.set申請区分法令(set申請区分法令(entity.get今回申請_認定申請区分法令コード()));
        csvEntity.set指定事業者コード(entity.get施設入所_入所施設コード());
        csvEntity.set施設入所日(set年月日(日付スラッシュ付加, entity.get施設入所_入所年月日()));
        csvEntity.set施設退所日(set年月日(日付スラッシュ付加, entity.get施設入所_退所年月日()));
        set指定事業者2(日付スラッシュ付加, csvEntity, entity);
        csvEntity.set転出先保険者番号(RString.EMPTY);
        csvEntity.set所得段階(RString.EMPTY);
        csvEntity.set後期保険者番号(entity.get後期高齢者情報_後期高齢保険者番号市町村());
        csvEntity.set後期被保険者番号(entity.get後期高齢者情報_後期高齢被保険者番号());
        csvEntity.set後期取得日(set年月日(日付スラッシュ付加, entity.get後期高齢者情報_資格取得日()));
        csvEntity.set後期喪失日(set年月日(日付スラッシュ付加, entity.get後期高齢者情報_資格喪失日()));
        csvEntity.set後期登録区分(set後期登録区分(entity.get後期高齢者情報_登録区分()));
        csvEntity.set国保番号(entity.get国保資格情報_国保番号());
        csvEntity.set国保保険者番号(entity.get国保資格情報_国保保険者番号());
        csvEntity.set国保保険証番号(entity.get国保資格情報_国保保険証番号());
        csvEntity.set国保個人番号(entity.get国保資格情報_国保個人番号());
        csvEntity.set国保取得日(set年月日(日付スラッシュ付加, entity.get国保資格情報_資格取得日()));
        csvEntity.set国保喪失日(set年月日(日付スラッシュ付加, entity.get国保資格情報_資格喪失日()));
        csvEntity.set国保登録区分(set登録区分(entity.get国保資格情報_登録区分()));
        csvEntity.set二次予防適用開始日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_適用開始年月日()));
        csvEntity.set二次予防適用終了日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_適用終了年月日()));
        csvEntity.set二次予防調査実施日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_調査実施日()));
        csvEntity.set二次予防決定日(set年月日(日付スラッシュ付加, entity.get二次予防事業対象情報_決定年月日()));
        csvEntity.set届出区分(set届出区分(entity.get居宅届出_届出区分()));
        csvEntity.set居宅計画作成区分(set居宅計画作成区分(entity.get事業者作成_作成区分コード()));
        csvEntity.set計画事業者番号(entity.get事業者作成_計画事業者番号());
        csvEntity.set計画事業者名(entity.get計画事業者_事業者名称());
        csvEntity.set計画事業者カナ(entity.get計画事業者_事業者名称カナ());
        csvEntity.set計画管理者名(entity.get計画事業者代表者_代表者名());
        csvEntity.set計画管理者カナ(entity.get計画事業者代表者_代表者名カナ());
        csvEntity.set計画適用開始日(set年月日(日付スラッシュ付加, entity.get事業者作成_適用開始年月日()));
        csvEntity.set計画適用終了日(set年月日(日付スラッシュ付加, entity.get事業者作成_適用終了年月日()));
        csvEntity.set計画届出日(set年月日(日付スラッシュ付加, entity.get居宅届出_届出年月日()));
        csvEntity.set計画作成日(set年月日(日付スラッシュ付加, entity.get自己作成_計画作成年月日()));
        csvEntity.set計画変更日(set年月日(日付スラッシュ付加, entity.get自己作成_計画変更年月日()));
        csvEntity.set変更理由(entity.get自己作成_計画変更事由());
        csvEntity.set委託先計画事業者番号(entity.get計画事業者_委託先事業者番号());
        csvEntity.set委託先計画事業者名(entity.get委託先事業者_事業者名称());
        csvEntity.set委託先計画事業者カナ(entity.get委託先事業者_事業者名称カナ());
        csvEntity.set委託先計画管理者名(entity.get委託先事業者代表者_代表者名());
        csvEntity.set委託先計画管理者カナ(entity.get委託先事業者代表者_代表者名カナ());
        return csvEntity;
    }

    private RString set資格取得事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 資格取得事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0007"), new Code(事由コード));
        if (資格取得事由 == null) {
            return RString.EMPTY;
        }
        return 資格取得事由.getコード略称();
    }

    private RString set喪失事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 喪失事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0010"), new Code(事由コード));
        if (喪失事由 == null) {
            return RString.EMPTY;
        }
        return 喪失事由.getコード略称();
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

    private RString set受給申請事由(RString 受給申請事由原, RString 要支援者認定申請区分, RString 情報区分) {
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
            if (要支援者認定申請区分 != null && !要支援者認定申請区分.trim().isEmpty()) {
                return setNinteShinseiKubun(情報区分, 要支援者認定申請区分);
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

    private RString set要介護度(RString koroshoIfCode, RString code) {
        if (RString.isNullOrEmpty(koroshoIfCode) || RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(koroshoIfCode), code).getName();
    }

    private RString setNinteShinseiKubun(RString 情報区分, RString 要支援者認定申請区分) {
        if (要支援者認定申請区分 == null || 要支援者認定申請区分.isEmpty()) {
            return RString.EMPTY;
        }
        if (情報区分.equals(情報区分_受給)) {
            if (NinteiShienShinseiKubun.認定支援申請.get名称().equals(
                    NinteiShienShinseiKubun.toValue(要支援者認定申請区分).get名称())) {
                return 支援から申請;
            } else {
                return 区分変更申請;
            }
        } else {
            return ShienShinseiKubun.toValue(要支援者認定申請区分).get名称();
        }
    }

    private RString set性別(RString 性別コード) {
        if (性別コード == null || 性別コード.trim().isEmpty()) {
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

    private RString set医療保険種別(RString 医療保険種別コード) {
        if (RString.isNullOrEmpty(医療保険種別コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 医療保険種別 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0001"), new Code(医療保険種別コード));
        if (医療保険種別 == null) {
            return RString.EMPTY;
        }
        return 医療保険種別.getコード略称();
    }

    private void set指定事業者(boolean 日付スラッシュ付加, HanyoRisutoJyukyusyaCsvEntity csvEntity, HanyoRisutoJyukyusyaEntity entity) {
        if (介護保険施設.equals(entity.get施設入所_入所施設種類())) {
            csvEntity.set指定事業者名(entity.get指定事業者_事業者名称());
            csvEntity.set指定事業者名カナ(entity.get指定事業者_事業者名称カナ());
            csvEntity.set指定事業者郵便番号(set郵便番号(entity.get指定事業者_郵便番号()));
            csvEntity.set指定事業者住所(entity.get指定事業者_事業者住所());
            csvEntity.set指定事業者代表者名(entity.get指定事業者代表者_代表者名());
            csvEntity.set指定事業者代表者名カナ(entity.get指定事業者代表者_代表者名カナ());
            csvEntity.set指定事業者代表者役職(entity.get指定事業者代表者_代表者役職名());
            csvEntity.set指定事業者電話番号(entity.get指定事業者_電話番号());
            csvEntity.set指定事業者ＦＡＸ番号(entity.get指定事業者_ＦＡＸ番号());
            csvEntity.set指定事業者ケアマネ数(entity.get指定事業者_所属人数());
            csvEntity.set指定事業者利用者数(entity.get指定事業者_利用者数());
            csvEntity.set指定事業者認定日(set年月日(日付スラッシュ付加, entity.get指定事業者_有効開始日()));
            csvEntity.set指定事業者取消日(set年月日(日付スラッシュ付加, entity.get指定事業者_有効終了日()));
            csvEntity.set指定事業者実施地域(entity.get指定事業者_サービス実施地域());
        } else if (住所地特例対象施設.equals(entity.get施設入所_入所施設種類()) || 適用除外施設.equals(entity.get施設入所_入所施設種類())) {
            csvEntity.set指定事業者名(entity.get除外他特適用施設_事業者名称());
            csvEntity.set指定事業者名カナ(entity.get除外他特適用施設_事業者名称カナ());
            csvEntity.set指定事業者郵便番号(set郵便番号(entity.get除外他特適用施設_郵便番号()));
            csvEntity.set指定事業者住所(entity.get除外他特適用施設_事業者住所());
            csvEntity.set指定事業者代表者名(entity.get除外他特適用施設_代表者名称());
            csvEntity.set指定事業者代表者名カナ(entity.get除外他特適用施設_代表者名称カナ());
            csvEntity.set指定事業者代表者役職(entity.get除外他特適用施設_役職());
            csvEntity.set指定事業者電話番号(entity.get除外他特適用施設_電話番号());
            csvEntity.set指定事業者ＦＡＸ番号(entity.get除外他特適用施設_ＦＡＸ番号());
            csvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            csvEntity.set指定事業者利用者数(RString.EMPTY);
            csvEntity.set指定事業者認定日(set年月日(日付スラッシュ付加, entity.get除外他特適用施設_有効開始年月日()));
            csvEntity.set指定事業者取消日(set年月日(日付スラッシュ付加, entity.get除外他特適用施設_有効終了年月日()));
            csvEntity.set指定事業者実施地域(RString.EMPTY);
        }
    }

    private void set指定事業者2(boolean 日付スラッシュ付加, HanyoRisutoJyukyusyaCsv2Entity csvEntity, HanyoRisutoJyukyusyaEntity entity) {
        if (介護保険施設.equals(entity.get施設入所_入所施設種類())) {
            csvEntity.set指定事業者名(entity.get指定事業者_事業者名称());
            csvEntity.set指定事業者名カナ(entity.get指定事業者_事業者名称カナ());
            csvEntity.set指定事業者郵便番号(set郵便番号(entity.get指定事業者_郵便番号()));
            csvEntity.set指定事業者住所(entity.get指定事業者_事業者住所());
            csvEntity.set指定事業者代表者名(entity.get指定事業者代表者_代表者名());
            csvEntity.set指定事業者代表者名カナ(entity.get指定事業者代表者_代表者名カナ());
            csvEntity.set指定事業者代表者役職(entity.get指定事業者代表者_代表者役職名());
            csvEntity.set指定事業者電話番号(entity.get指定事業者_電話番号());
            csvEntity.set指定事業者ＦＡＸ番号(entity.get指定事業者_ＦＡＸ番号());
            csvEntity.set指定事業者ケアマネ数(entity.get指定事業者_所属人数());
            csvEntity.set指定事業者利用者数(entity.get指定事業者_利用者数());
            csvEntity.set指定事業者認定日(set年月日(日付スラッシュ付加, entity.get指定事業者_有効開始日()));
            csvEntity.set指定事業者取消日(set年月日(日付スラッシュ付加, entity.get指定事業者_有効終了日()));
            csvEntity.set指定事業者実施地域(entity.get指定事業者_サービス実施地域());
        } else if (住所地特例対象施設.equals(entity.get施設入所_入所施設種類()) || 適用除外施設.equals(entity.get施設入所_入所施設種類())) {
            csvEntity.set指定事業者名(entity.get除外他特適用施設_事業者名称());
            csvEntity.set指定事業者名カナ(entity.get除外他特適用施設_事業者名称カナ());
            csvEntity.set指定事業者郵便番号(set郵便番号(entity.get除外他特適用施設_郵便番号()));
            csvEntity.set指定事業者住所(entity.get除外他特適用施設_事業者住所());
            csvEntity.set指定事業者代表者名(entity.get除外他特適用施設_代表者名称());
            csvEntity.set指定事業者代表者名カナ(entity.get除外他特適用施設_代表者名称カナ());
            csvEntity.set指定事業者代表者役職(entity.get除外他特適用施設_役職());
            csvEntity.set指定事業者電話番号(entity.get除外他特適用施設_電話番号());
            csvEntity.set指定事業者ＦＡＸ番号(entity.get除外他特適用施設_ＦＡＸ番号());
            csvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            csvEntity.set指定事業者利用者数(RString.EMPTY);
            csvEntity.set指定事業者認定日(set年月日(日付スラッシュ付加, entity.get除外他特適用施設_有効開始年月日()));
            csvEntity.set指定事業者取消日(set年月日(日付スラッシュ付加, entity.get除外他特適用施設_有効終了年月日()));
            csvEntity.set指定事業者実施地域(RString.EMPTY);
        }
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

    private RString set申請区分申請時(RString 認定申請区分申請時コード) {
        if (RString.isNullOrEmpty(認定申請区分申請時コード)) {
            return RString.EMPTY;
        }
        return NinteiShinseiShinseijiKubunCode.toValue(認定申請区分申請時コード).get名称();
    }

    private RString set申請区分法令(RString 認定申請区分法令コード) {
        if (RString.isNullOrEmpty(認定申請区分法令コード)) {
            return RString.EMPTY;
        }
        return NinteiShinseiHoreiCode.toValue(認定申請区分法令コード).get名称();
    }

    private RString set後期登録区分(RString 後期登録区分) {
        if (住基_1.equals(後期登録区分)) {
            return 住基;
        } else if (外国人_2.equals(後期登録区分)) {
            return 外国人;
        } else if (住登外_3.equals(後期登録区分)) {
            return 住登外;
        }
        return RString.EMPTY;
    }

    private RString set登録区分(RString 登録区分) {
        if (画面登録.equals(登録区分)) {
            return GAMENTOROKU;
        } else if (データ連携.equals(登録区分)) {
            return DATARENKEI;
        }
        return RString.EMPTY;
    }

    private RString set届出区分(RString 届出区分) {
        if (new RString("1").equals(届出区分)) {
            return SHINKI;
        } else if (new RString("2").equals(届出区分)) {
            return HENKO;
        } else if (new RString("3").equals(届出区分)) {
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

    private RString set年月日(boolean 日付スラッシュ付加, FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (日付スラッシュ付加) {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        }

    }
}
