/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd710090;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseishaKankeiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト出力(施設入退所)ビジネスクラスです。
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
public class HanyoListShiharaiHohoHenkoBusiness {

    private static final RString 届出区分_1 = new RString("1");
    private static final RString 届出区分_2 = new RString("2");
    private static final RString 届出区分_3 = new RString("3");
    private static final RString 住特 = new RString("住特");
    private static final RString 住所地特例フラグ_TRUE = new RString("0");

    private static final RString 資格取得前申請区分_資格取得前申請 = new RString("資格取得前申請");
    private static final RString 指定医区分_指定医 = new RString("指定医");
    private static final RString 入所施設種類_11 = new RString("11");
    private static final RString 入所施設種類_12 = new RString("12");
    private static final RString 入所施設種類_21 = new RString("21");

    private static final RString 新規 = new RString("新規");
    private static final RString 変更 = new RString("変更");
    private static final RString 暫定 = new RString("暫定");

    private static final RString TRUE = new RString("true");
    private static final RString FALSE = new RString("false");
    private static final RString 有効 = new RString("有効");
    private static final RString 無効 = new RString("無効");
    private static final RString 有効無効区分_有効_コード = new RString("1");
    private static final RString 有効無効区分_無効_コード = new RString("2");

    private static final RString 未登録 = RString.EMPTY;
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

    private static final RString ETC = new RString("etc.");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;

    private static final RString みなし要介護区分_通常の認定_コード = new RString("1");
    private static final RString みなし = new RString("みなし");

    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString 要支援申請 = new RString("要支援申請");
    private static final RString 要介護申請 = new RString("要介護申請");

    private static final RString 初回申請 = new RString("初回申請");
    private static final RString 再申請内 = new RString("再申請内");
    private static final RString 再申請外 = new RString("再申請外");
    private static final RString 支援から申請 = new RString("支援から申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString サ変更申請 = new RString("サ変更申請");
    private static final RString 施行前申請 = new RString("施行前申請");
    private static final RString 追加 = new RString("追加");

    /**
     * 蓮番有ＣＳＶ情報
     *
     * @param eucCsvEntity 出力ＣＳＶ情報
     * @param entity SQL検索結果情報
     * @param count 連番
     * @param 地方公共団体情報 地方公共団体情報
     * @param 保険者リスト 保険者リスト
     * @param 日付スラッシュ付加 日付スラッシュ付加
     */
    public void setEucCsvEntity(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, int count, Association 地方公共団体情報, HokenshaList 保険者リスト,
            boolean 日付スラッシュ付加) {

        eucCsvEntity.set連番(new RString(String.valueOf(count)));
        set宛名情報について(eucCsvEntity, entity, 地方公共団体情報, 日付スラッシュ付加);
        set宛先情報について(eucCsvEntity, entity);
        set被保険者台帳管理について(eucCsvEntity, entity, 保険者リスト, 日付スラッシュ付加);
        set医療保険加入状況について(eucCsvEntity, entity);
        set受給者台帳(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回申請届出について(eucCsvEntity, entity);
        set申請届出事業者について(eucCsvEntity, entity);
        set今回申請について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回調査委託先について(eucCsvEntity, entity);
        set今回調査員について(eucCsvEntity, entity);
        set今回主治医医療機関について(eucCsvEntity, entity);
        set今回主治医について(eucCsvEntity, entity);
        set今回調査依頼について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回計画情報について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回完了情報について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回意見書作成依頼について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回意見書情報について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回一次判定結果について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回結果情報について(eucCsvEntity, entity, 日付スラッシュ付加);
        set初回受給情報について(eucCsvEntity, entity, 日付スラッシュ付加);
        set初回申請について(eucCsvEntity, entity);
        set前回受給情報について(eucCsvEntity, entity, 日付スラッシュ付加);
        set前回申請について(eucCsvEntity, entity);
        set前々回受給情報について(eucCsvEntity, entity, 日付スラッシュ付加);
        set今回調査結果_基本について(eucCsvEntity, entity);
        set介護保険施設入退所について(eucCsvEntity, entity, 日付スラッシュ付加);
        set居宅届出について(eucCsvEntity, entity, 日付スラッシュ付加);
        set事業者作成について(eucCsvEntity, entity, 日付スラッシュ付加);
        set計画事業者について(eucCsvEntity, entity);
        set計画事業者代表者について(eucCsvEntity, entity);
        set自己作成について(eucCsvEntity, entity, 日付スラッシュ付加);
        set指定事業者について(eucCsvEntity, entity, 日付スラッシュ付加);
        set除外他特適用施設について(eucCsvEntity, entity, 日付スラッシュ付加);
    }

    private void set宛名情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, Association 地方公共団体情報, boolean 日付スラッシュ付加) {
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            eucCsvEntity.set識別コード(kojin.get識別コード().getColumnValue());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set氏名(kojin.get名称().getName().getColumnValue());
            eucCsvEntity.set氏名カナ(kojin.get名称().getKana().getColumnValue());
            eucCsvEntity.set生年月日(edit年月日_yyyymmdd(kojin.get生年月日().toFlexibleDate(), 日付スラッシュ付加));
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set性別(kojin.get性別().getName().getShortJapanese());

            eucCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().getColumnValue());
            eucCsvEntity.set世帯コード(kojin.get世帯コード().getColumnValue());
            eucCsvEntity.set世帯主名(kojin.get世帯主名().getColumnValue());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            eucCsvEntity.set住所_番地_方書(get住所_番地_方書(kojin.get住所().get住所(),
                    kojin.get住所().get番地().getBanchi().value(),
                    kojin.get住所().get方書().getColumnValue()));
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            eucCsvEntity.set方書(kojin.get住所().get方書().getColumnValue());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
            eucCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            eucCsvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
            eucCsvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
            eucCsvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
            eucCsvEntity.set連絡先１(kojin.get連絡先１().getColumnValue());
            eucCsvEntity.set連絡先２(kojin.get連絡先２().getColumnValue());
            eucCsvEntity.set登録異動日(edit年月日_yyyymmdd(kojin.get登録異動年月日(), 日付スラッシュ付加));
            eucCsvEntity.set登録事由(kojin.get登録事由().get異動事由略称());
            eucCsvEntity.set登録届出日(edit年月日_yyyymmdd(kojin.get登録届出年月日(), 日付スラッシュ付加));
            eucCsvEntity.set住定異動日(edit年月日_yyyymmdd(kojin.get住定異動年月日(), 日付スラッシュ付加));
            eucCsvEntity.set住定事由(kojin.get住定事由().get異動事由略称());
            eucCsvEntity.set住定届出日(edit年月日_yyyymmdd(kojin.get住定届出年月日(), 日付スラッシュ付加));
            eucCsvEntity.set消除異動日(edit年月日_yyyymmdd(kojin.get消除異動年月日(), 日付スラッシュ付加));
            eucCsvEntity.set消除事由(kojin.get消除事由().get異動事由略称());
            eucCsvEntity.set消除届出日(edit年月日_yyyymmdd(kojin.get消除届出年月日(), 日付スラッシュ付加));
            eucCsvEntity.set転出入理由(RString.EMPTY);
            eucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            eucCsvEntity.set前住所_番地_方書(get住所_番地_方書(kojin.get転入前().get住所(),
                    kojin.get転入前().get番地().getBanchi().value(),
                    kojin.get転入前().get方書().getColumnValue()));
            eucCsvEntity.set前住所(kojin.get転入前().get住所());
            eucCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            eucCsvEntity.set前住所方書(kojin.get転入前().get方書().getColumnValue());

            eucCsvEntity.set保険者コード(地方公共団体情報.get地方公共団体コード().getColumnValue());
            eucCsvEntity.set保険者名(地方公共団体情報.get市町村名());
            eucCsvEntity.set空白(RString.EMPTY);
        }
    }

    private void set宛先情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            eucCsvEntity.set送付先氏名(atesaki.get宛先名称().getName().getColumnValue());
            eucCsvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().getColumnValue());
            eucCsvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().getColumnValue());
            eucCsvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            eucCsvEntity.set送付先住所_番地_方書(get住所_番地_方書(atesaki.get宛先住所().get住所(),
                    atesaki.get宛先住所().get番地().getBanchi().value(),
                    atesaki.get宛先住所().get方書().getColumnValue()));
            eucCsvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            eucCsvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
            eucCsvEntity.set送付先方書(atesaki.get宛先住所().get方書().getColumnValue());
            eucCsvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().getColumnValue());
            eucCsvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
        }
    }

    private void set被保険者台帳管理について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {

        eucCsvEntity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        eucCsvEntity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        if (entity.get被保険者台帳管理_資格取得事由コード() != null && !entity.get被保険者台帳管理_資格取得事由コード().isEmpty()) {
            eucCsvEntity.set資格取得事由(getコードマスタ(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(),
                    new Code(entity.get被保険者台帳管理_資格取得事由コード())));
        }

        eucCsvEntity.set資格取得日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格取得年月日(), 日付スラッシュ付加));
        eucCsvEntity.set資格取得届出日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格取得届出年月日(), 日付スラッシュ付加));
        eucCsvEntity.set喪失事由(entity.get被保険者台帳管理_資格喪失事由コード());
        eucCsvEntity.set資格喪失日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格喪失年月日(), 日付スラッシュ付加));
        eucCsvEntity.set資格喪失届日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格喪失届出年月日(), 日付スラッシュ付加));
        eucCsvEntity.set資格区分(entity.get被保険者台帳管理_被保険者区分コード());

        eucCsvEntity.set住所地特例状態(edit住所地特例フラグ(entity.get被保険者台帳管理_住所地特例フラグ()));
        if (住所地特例フラグ_TRUE.equals(entity.get被保険者台帳管理_広域内住所地特例フラグ())) {
            if (entity.get被保険者台帳管理_広住特措置元市町村コード() != null && !entity.get被保険者台帳管理_広住特措置元市町村コード().isEmpty()) {
                eucCsvEntity.set資格_証記載保険者番号(保険者リスト.get(new LasdecCode(entity.get被保険者台帳管理_広住特措置元市町村コード()))
                        .get証記載保険者番号().getColumnValue());
            } else {
                eucCsvEntity.set資格_証記載保険者番号(RString.EMPTY);
            }
        } else {
            if (entity.get被保険者台帳管理_市町村コード() != null && !entity.get被保険者台帳管理_市町村コード().isEmpty()) {
                eucCsvEntity.set資格_証記載保険者番号(保険者リスト.get(new LasdecCode(entity.get被保険者台帳管理_市町村コード()))
                        .get証記載保険者番号().getColumnValue());
            } else {
                eucCsvEntity.set資格_証記載保険者番号(RString.EMPTY);
            }
        }
    }

    private void set医療保険加入状況について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        if (entity.get医療保険加入状況_医療保険種別コード() != null && !entity.get医療保険加入状況_医療保険種別コード().isEmpty()) {
            eucCsvEntity.set医療保険種別(getコードマスタ(DBACodeShubetsu.医療保険種類.getコード(),
                    new Code(entity.get医療保険加入状況_医療保険種別コード())));
        }

        eucCsvEntity.set医療保険番号(entity.get医療保険加入状況_医療保険番号());
        eucCsvEntity.set医療保険者名(entity.get医療保険加入状況_医療保険者名称());
        eucCsvEntity.set医療保険記号番号(entity.get医療保険加入状況_医療保険記号番号());
    }

    private void set受給者台帳(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set特定疾病(entity.get受給者台帳_2号特定疾病コード());
        eucCsvEntity.set受給申請事由(edit受給申請事由(entity.get受給者台帳_受給申請事由(), entity.get受給者台帳_要支援者認定申請区分()));
        eucCsvEntity.set申請理由(entity.get受給者台帳_申請理由());
        eucCsvEntity.set申請関係者(RString.isNullOrEmpty(entity.get受給者台帳_申請者関係コード()) ? RString.EMPTY
                : ShinseishaKankeiCode.toValue(entity.get受給者台帳_申請者関係コード()).get名称());
        eucCsvEntity.set本人関係(entity.get受給者台帳_本人との関係());
        eucCsvEntity.set受給申請日(edit年月日_yyyymmdd(entity.get受給者台帳_受給申請年月日(), 日付スラッシュ付加));
        eucCsvEntity.set審査回答日(edit年月日_yyyymmdd(entity.get受給者台帳_認定年月日(), 日付スラッシュ付加));
        eucCsvEntity.set認定開始日(edit年月日_yyyymmdd(entity.get受給者台帳_認定有効期間開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set認定終了日(edit年月日_yyyymmdd(entity.get受給者台帳_認定有効期間終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set認定日(edit年月日_yyyymmdd(entity.get受給者台帳_認定年月日(), 日付スラッシュ付加));
        eucCsvEntity.set旧措置(edit旧措置(entity.is受給者台帳_旧措置者フラグ()));
        eucCsvEntity.setみなし更新認定(editみなし更新(entity.get受給者台帳_みなし要介護区分コード()));

        eucCsvEntity.set指定サービス種類(edit指定サービス種類(entity.get受給者台帳_指定サービス種類01(),
                entity.get受給者台帳_指定サービス種類02(),
                entity.get受給者台帳_指定サービス種類03(),
                entity.get受給者台帳_指定サービス種類04(),
                entity.get受給者台帳_指定サービス種類05(),
                entity.get受給者台帳_指定サービス種類06()
        ));
        eucCsvEntity.set受給喪失日(edit年月日_yyyymmdd(entity.get受給者台帳_喪失年月日(), 日付スラッシュ付加));
        eucCsvEntity.set直近事由(entity.get受給者台帳_直近異動事由コード());
        eucCsvEntity.set受給状況(edit受給状況(entity.get受給者台帳_有効無効区分()));
        eucCsvEntity.set異動事由コード(edit異動事由コード(entity.get受給者台帳_データ区分()));
        eucCsvEntity.set異動事由追加文(entity.get受給者台帳_異動理由());
        eucCsvEntity.set削除理由コード(entity.get受給者台帳_削除事由コード());
        eucCsvEntity.set異動事由文言(edit異動事由文言(entity.get受給者台帳_直近異動事由コード()));
        eucCsvEntity.set削除理由文言(entity.get受給者台帳_削除事由コード());
        eucCsvEntity.set支援申請区分(edit支援申請(entity.get受給者台帳_要支援者認定申請区分()));

        eucCsvEntity.set訪問支給限度額単位数(entity.get受給者台帳_支給限度単位数());
        eucCsvEntity.set訪問支給限度有効開始年月日(edit年月日_yyyymmdd(entity.get受給者台帳_支給限度有効開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set訪問支給限度有効終了年月日(edit年月日_yyyymmdd(entity.get受給者台帳_支給限度有効終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set短期入所支給限度日数(entity.get受給者台帳_短期入所支給限度日数());
        eucCsvEntity.set短期入所支給限度有効開始年月日(edit年月日_yyyymmdd(entity.get受給者台帳_短期入所支給限度開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set短期入所支給限度有効終了年月日(edit年月日_yyyymmdd(entity.get受給者台帳_短期入所支給限度終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set当初認定有効開始年月日(edit年月日_yyyymmdd(entity.get受給者台帳_当初認定有効開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set当初認定有効終了年月日(edit年月日_yyyymmdd(entity.get受給者台帳_当初認定有効終了年月日(), 日付スラッシュ付加));

        eucCsvEntity.set受給資格証明書発行日１(edit年月日_yyyymmdd(entity.get受給者台帳_受給資格証明書発行年月日１(), 日付スラッシュ付加));
        eucCsvEntity.set受給資格証明書発行日２(edit年月日_yyyymmdd(entity.get受給者台帳_受給資格証明書発行年月日２(), 日付スラッシュ付加));
        eucCsvEntity.set資格取得前申請区分(edit資格取得前申請区分(entity.is受給者台帳_資格取得前申請フラグ()));
        eucCsvEntity.set一次判定結果_重み(RString.EMPTY);

    }

    private void set今回申請届出について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set申請氏名(entity.get今回申請届出_申請届出者氏名());
        eucCsvEntity.set申請氏名カナ(entity.get今回申請届出_申請届出者氏名カナ());
        eucCsvEntity.set申請者郵便番号(edit郵便番号(entity.get今回申請届出_申請届出者郵便番号()));

        eucCsvEntity.set申請住所(entity.get今回申請届出_申請届出者住所());
        eucCsvEntity.set申請連絡先(entity.get今回申請届出_申請届出者電話番号());
        eucCsvEntity.set申請事業コード(entity.get今回申請届出_申請届出代行事業者番号());
    }

    private void set申請届出事業者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set申請代行事業者名(entity.get申請届出事業者_事業者名称());
        eucCsvEntity.set申請代行事業者名カナ(entity.get申請届出事業者_事業者名称カナ());
    }

    private void set今回申請について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set調査委託先コード(entity.get今回申請_認定調査委託先コード());
        eucCsvEntity.set調査員コード(entity.get今回申請_認定調査員コード());

        eucCsvEntity.set医療機関コード(entity.get今回申請_主治医医療機関コード());
        eucCsvEntity.set主治医コード(entity.get今回申請_主治医コード());

        eucCsvEntity.set認定延期通知書発行年月日(edit年月日_yyyymmdd(entity.get今回申請_延期通知発行年月日(), 日付スラッシュ付加));
        eucCsvEntity.set認定延期通知書発行回数(entity.get今回申請_延期通知発行回数());
        eucCsvEntity.set延期処理見込み開始年月日(edit年月日_yyyymmdd(entity.get今回申請_延期見込期間開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set延期処理見込み終了年月日(edit年月日_yyyymmdd(entity.get今回申請_延期見込期間終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set指定医区分(edit指定医区分(entity.is今回申請_指定医フラグ()));
        entity.get今回一次判定結果_要介護認定一次判定結果コード();

        eucCsvEntity.set一次判定要介護度(edit要介護度(entity.get今回申請_厚労省IF識別コード(),
                entity.get今回一次判定結果_要介護認定一次判定結果コード()));
        eucCsvEntity.set要介護度(edit要介護度(entity.get今回申請_厚労省IF識別コード(),
                entity.get受給者台帳_要介護認定状態区分コード()));
    }

    private void set今回調査委託先について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set委託先名(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set委託先名カナ(entity.get今回調査委託先_事業者名称カナ());
        eucCsvEntity.set委託先代表者名(entity.get今回調査委託先_代表者名());
        eucCsvEntity.set委託先代表者名カナ(entity.get今回調査委託先_代表者名カナ());
        eucCsvEntity.set委託先郵便番号(edit郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set委託先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set委託先連絡先(entity.get今回調査委託先_電話番号());
        if (entity.is今回調査委託先_状況フラグ()) {
            eucCsvEntity.set委託先状況(TRUE);
        } else {
            eucCsvEntity.set委託先状況(FALSE);
        }
        eucCsvEntity.set訪問調査先郵便番号(edit郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set訪問調査先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set訪問調査先名称(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set訪問調査先電話番号(entity.get今回調査委託先_電話番号());
    }

    private void set今回調査員について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set調査員氏名(entity.get今回調査員_調査員氏名());
        eucCsvEntity.set調査員氏名カナ(entity.get今回調査員_調査員氏名カナ());
        eucCsvEntity.set調査員性別(entity.get今回調査員_性別());
        eucCsvEntity.set調査員郵便(edit郵便番号(entity.get今回調査員_郵便番号()));
        eucCsvEntity.set調査員住所(entity.get今回調査員_住所());
        eucCsvEntity.set調査員連絡先(entity.get今回調査員_電話番号());
        eucCsvEntity.set調査員資格(entity.get今回調査員_調査員資格());
        eucCsvEntity.set調査員所属機関名(entity.get今回調査員_所属機関名称());
        if (entity.is今回調査員_状況フラグ()) {
            eucCsvEntity.set調査員状況(TRUE);
        } else {
            eucCsvEntity.set調査員状況(FALSE);
        }
    }

    private void set今回主治医医療機関について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set医療機関名称(entity.get今回主治医医療機関_医療機関名称());
        eucCsvEntity.set医療機関名称カナ(entity.get今回主治医医療機関_医療機関名称カナ());
        eucCsvEntity.set医療機関代表者名(entity.get今回主治医医療機関_代表者名());
        eucCsvEntity.set医療機関代表者名カナ(entity.get今回主治医医療機関_代表者名カナ());
        eucCsvEntity.set医療機関郵便番号(edit郵便番号(entity.get今回主治医医療機関_郵便番号()));
        eucCsvEntity.set医療機関住所(entity.get今回主治医医療機関_住所());
        eucCsvEntity.set医療機関連絡先(entity.get今回主治医医療機関_電話番号());
        eucCsvEntity.set医療機関状況(edit状況(entity.is今回主治医医療機関_状況フラグ()));
    }

    private void set今回主治医について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set主治医名(entity.get今回主治医_主治医氏名());
        eucCsvEntity.set主治医名カナ(entity.get今回主治医_主治医カナ());
        eucCsvEntity.set主治医性別(entity.get今回主治医_性別());
        eucCsvEntity.set主治医所属(entity.get今回主治医_診療科名称());
        eucCsvEntity.set主治医状況(edit状況(entity.is今回主治医_状況フラグ()));
    }

    private void set今回調査依頼について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set調査委託日(edit年月日_yyyymmdd(entity.get今回調査依頼_認定調査依頼年月日(), 日付スラッシュ付加));
    }

    private void set今回計画情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set調査予定日(edit年月日_yyyymmdd(entity.get今回計画情報_認定調査予定年月日(), 日付スラッシュ付加));
        eucCsvEntity.set意見予定日(edit年月日_yyyymmdd(entity.get今回計画情報_主治医意見書登録予定年月日(), 日付スラッシュ付加));
        eucCsvEntity.set審査予定日(edit年月日_yyyymmdd(entity.get今回計画情報_認定審査会予定年月日(), 日付スラッシュ付加));

    }

    private void set今回完了情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set調査終了日(edit年月日_yyyymmdd(entity.get今回完了情報_認定調査完了年月日(), 日付スラッシュ付加));
    }

    private void set今回意見書作成依頼について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set意見依頼日(edit年月日_yyyymmdd(entity.get今回意見書作成依頼_主治医意見書作成依頼年月日(), 日付スラッシュ付加));
    }

    private void set今回意見書情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set意見取寄日(edit年月日_yyyymmdd(entity.get今回意見書情報_主治医意見書受領年月日(), 日付スラッシュ付加));
    }

    private void set今回一次判定結果について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set一次判定日(edit年月日_yyyymmdd(entity.get今回一次判定結果_要介護認定一次判定年月日(), 日付スラッシュ付加));
    }

    private void set今回結果情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set資料作成日(edit年月日_yyyymmdd(entity.get今回結果情報_介護認定審査会資料作成年月日(), 日付スラッシュ付加));
        eucCsvEntity.set審査会意見(entity.get今回結果情報_介護認定審査会意見());
    }

    private void set初回受給情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set初回申請日(edit年月日_yyyymmdd(entity.get初回受給情報_受給申請年月日(), 日付スラッシュ付加));
        eucCsvEntity.set初回認定日(edit年月日_yyyymmdd(entity.get初回受給情報_認定年月日(), 日付スラッシュ付加));

        eucCsvEntity.set初回要介護度(edit要介護度(entity.get初回申請_厚労省IF識別コード(),
                entity.get初回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set初回認定開始日(edit年月日_yyyymmdd(entity.get初回受給情報_認定有効期間開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set初回認定終了日(edit年月日_yyyymmdd(entity.get初回受給情報_認定有効期間終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set初回申請事由(edit受給申請事由(entity.get初回受給情報_受給申請事由(), entity.get初回申請_要支援者認定申請区分()));
        eucCsvEntity.set初回みなし更新(editみなし更新(entity.get初回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set初回当初認定有効開始日(edit年月日_yyyymmdd(entity.get初回受給情報_当初認定有効開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set初回当初認定有効終了日(edit年月日_yyyymmdd(entity.get初回受給情報_当初認定有効終了年月日(), 日付スラッシュ付加));
    }

    private void set初回申請について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set初回支援申請事由(edit支援申請(entity.get初回申請_要支援者認定申請区分()));
    }

    private void set前回受給情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set前回申請日(edit年月日_yyyymmdd(entity.get前回受給情報_受給申請年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前回認定日(edit年月日_yyyymmdd(entity.get前回受給情報_認定年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前回要介護度(edit要介護度(entity.get前回申請_厚労省IF識別コード(),
                entity.get前回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前回認定開始日(edit年月日_yyyymmdd(entity.get前回受給情報_認定有効期間開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前回認定終了日(edit年月日_yyyymmdd(entity.get前回受給情報_認定有効期間終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前回受給申請事由(edit受給申請事由(entity.get前回受給情報_受給申請事由(),
                entity.get前回申請_要支援者認定申請区分()));
        eucCsvEntity.set前回みなし更新(editみなし更新(entity.get前回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set前回当初認定有効開始日(edit年月日_yyyymmdd(entity.get前回受給情報_当初認定有効開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前回当初認定有効終了日(edit年月日_yyyymmdd(entity.get前回受給情報_当初認定有効終了年月日(), 日付スラッシュ付加));
    }

    private void set前回申請について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set前回支援申請事由(edit支援申請(entity.get前回申請_要支援者認定申請区分()));
    }

    private void set前々回受給情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set前々回申請日(edit年月日_yyyymmdd(entity.get前々回受給情報_受給申請年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前々回認定日(edit年月日_yyyymmdd(entity.get前々回受給情報_認定年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前々回要介護度(edit要介護度(entity.get前々回申請_厚労省IF識別コード(),
                entity.get前々回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前々回認定開始日(edit年月日_yyyymmdd(entity.get前々回受給情報_認定有効期間開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前々回認定終了日(edit年月日_yyyymmdd(entity.get前々回受給情報_認定有効期間終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前々回受給申請事由(edit受給申請事由(entity.get前々回受給情報_受給申請事由(),
                entity.get前々回申請_要支援者認定申請区分()));
        eucCsvEntity.set前々回みなし更新(editみなし更新(entity.get前々回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set前々回当初認定有効開始日(edit年月日_yyyymmdd(entity.get前々回受給情報_当初認定有効開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前々回当初認定有効終了日(edit年月日_yyyymmdd(entity.get前々回受給情報_当初認定有効終了年月日(), 日付スラッシュ付加));
        eucCsvEntity.set前々回支援申請事由(edit支援申請(entity.get前々回受給情報_要支援者認定申請区分()));
    }

    private void set今回調査結果_基本について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set障害高齢者自立度(edit障害高齢者自立度(entity.get今回調査結果_基本_認定調査_障害高齢者の日常生活自立度コード()));
        eucCsvEntity.set認知症高齢者自立度(edit認知症高齢者自立度(entity.get今回調査結果_基本_認定調査_認知症高齢者の日常生活自立度コード()));
    }

    private void set介護保険施設入退所について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set指定事業者コード(entity.get施設入所_入所施設コード());
        eucCsvEntity.set施設入所日(edit年月日_yyyymmdd(entity.get施設入所_入所年月日(), 日付スラッシュ付加));
        eucCsvEntity.set施設退所日(edit年月日_yyyymmdd(entity.get施設入所_退所年月日(), 日付スラッシュ付加));
        eucCsvEntity.set転出先保険者番号(RString.EMPTY);

    }

    private void set居宅届出について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set届出区分(edit届出区分(entity.get居宅届出_届出区分()));
        eucCsvEntity.set計画届出日(edit年月日_yyyymmdd(entity.get居宅届出_届出年月日(), 日付スラッシュ付加));
    }

    private void set事業者作成について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set居宅計画作成区分(edit居宅計画作成区分(entity.get事業者作成_作成区分コード()));
        eucCsvEntity.set計画事業者番号(entity.get事業者作成_計画事業者番号());
        eucCsvEntity.set計画適用開始日(edit年月日_yyyymmdd(entity.get事業者作成_適用開始年月日(), 日付スラッシュ付加));
        eucCsvEntity.set計画適用終了日(edit年月日_yyyymmdd(entity.get事業者作成_適用終了年月日(), 日付スラッシュ付加));
    }

    private void set計画事業者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set計画事業者名(entity.get計画事業者_事業者名称());
        eucCsvEntity.set計画事業者カナ(entity.get計画事業者_事業者名称カナ());
    }

    private void set計画事業者代表者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        eucCsvEntity.set計画管理者名(entity.get計画事業者代表者_代表者名());
        eucCsvEntity.set計画管理者カナ(entity.get計画事業者代表者_代表者名カナ());
    }

    private void set自己作成について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        eucCsvEntity.set計画作成日(edit年月日_yyyymmdd(entity.get自己作成_計画作成年月日(), 日付スラッシュ付加));
        eucCsvEntity.set計画変更日(edit年月日_yyyymmdd(entity.get自己作成_計画変更年月日(), 日付スラッシュ付加));
        eucCsvEntity.set変更理由(entity.get自己作成_計画変更事由());
    }

    private void set指定事業者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        if (is入所施設種類_11(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者代表者名(entity.get指定事業者代表者_代表者名());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get指定事業者代表者_代表者名カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get指定事業者代表者_代表者役職名());

            eucCsvEntity.set指定事業者名(entity.get指定事業者_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get指定事業者_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(edit郵便番号(entity.get指定事業者_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get指定事業者_事業者住所());
            eucCsvEntity.set指定事業者電話番号(entity.get指定事業者_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get指定事業者_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(entity.get指定事業者_所属人数());
            eucCsvEntity.set指定事業者利用者数(entity.get指定事業者_利用者数());
            eucCsvEntity.set指定事業者認定日(edit年月日_yyyymmdd(entity.get指定事業者_有効開始日(), 日付スラッシュ付加));
            eucCsvEntity.set指定事業者取消日(edit年月日_yyyymmdd(entity.get指定事業者_有効終了日(), 日付スラッシュ付加));
            eucCsvEntity.set指定事業者実施地域(entity.get指定事業者_サービス実施地域());

        }
    }

    private void set除外他特適用施設について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity, boolean 日付スラッシュ付加) {
        if (is入所施設種類_12_21(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者名(entity.get除外他特適用施設_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get除外他特適用施設_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(edit郵便番号(entity.get除外他特適用施設_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get除外他特適用施設_事業者住所());
            eucCsvEntity.set指定事業者代表者名(entity.get除外他特適用施設_代表者名称());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get除外他特適用施設_代表者名称カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get除外他特適用施設_役職());
            eucCsvEntity.set指定事業者電話番号(entity.get除外他特適用施設_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get除外他特適用施設_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            eucCsvEntity.set指定事業者利用者数(RString.EMPTY);
            eucCsvEntity.set指定事業者認定日(edit年月日_yyyymmdd(entity.get除外他特適用施設_有効開始年月日(), 日付スラッシュ付加));
            eucCsvEntity.set指定事業者取消日(edit年月日_yyyymmdd(entity.get除外他特適用施設_有効終了年月日(), 日付スラッシュ付加));
            eucCsvEntity.set指定事業者実施地域(RString.EMPTY);
        }
    }

    private RString edit年月日_yyyymmdd(FlexibleDate date, boolean 日付スラッシュ付加) {

        if (date == null || FlexibleDate.EMPTY.equals(date)) {
            return RString.EMPTY;
        }

        if (!日付スラッシュ付加) {
            return date.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
        }
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private RString get住所_番地_方書(RString 住所, RString 番地, RString 方書) {

        StringBuilder builder = new StringBuilder();
        if (!住所.isNullOrEmpty()) {
            builder.append(住所);
        }
        if (!番地.isNullOrEmpty()) {
            builder.append(番地);
        }
        builder.append(RString.FULL_SPACE);
        if (!方書.isNullOrEmpty()) {
            builder.append(方書);
        }
        return new RString(builder.toString());
    }

    private RString edit届出区分(RString todokedeKubun) {
        if (届出区分_1.equals(todokedeKubun)) {
            return 新規;
        } else if (届出区分_2.equals(todokedeKubun)) {
            return 変更;
        } else if (届出区分_3.equals(todokedeKubun)) {
            return 暫定;
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit住所地特例フラグ(RString jushochiTokureiFlag) {
        if (住所地特例フラグ_TRUE.equals(jushochiTokureiFlag)) {
            return 住特;
        }
        return RString.EMPTY;
    }

    private RString edit状況(boolean jokyoFlag) {
        if (jokyoFlag) {
            return 有効;
        }
        return 無効;
    }

    private RString edit資格取得前申請区分(boolean shikakuShutokuMaeShinseiFlag) {
        if (shikakuShutokuMaeShinseiFlag) {
            return 資格取得前申請区分_資格取得前申請;
        }
        return RString.EMPTY;
    }

    private RString edit指定医区分(boolean shiteiiFlag) {
        if (shiteiiFlag) {
            return 指定医区分_指定医;
        }
        return RString.EMPTY;
    }

    private boolean is入所施設種類_11(RString nyushoShisetsuShurui) {
        return 入所施設種類_11.equals(nyushoShisetsuShurui);
    }

    private boolean is入所施設種類_12_21(RString nyushoShisetsuShurui) {
        return 入所施設種類_12.equals(nyushoShisetsuShurui) || 入所施設種類_21.equals(nyushoShisetsuShurui);
    }

    private RString edit要介護度(RString koroshoIfCode, RString code) {
        if ((koroshoIfCode != null && !koroshoIfCode.isEmpty()) && (code != null && !code.isEmpty())) {
            return YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(koroshoIfCode), code).getName();
        }
        return RString.EMPTY;

    }

    private RString edit旧措置(boolean kyuSochishaFlag) {
        if (kyuSochishaFlag) {
            return 旧措置者;
        }
        return RString.EMPTY;
    }

    private RString getコードマスタ(CodeShubetsu コード種別, Code コード) {
        return CodeMaster.getCodeRyakusho(コード種別, コード);
    }

    private RString edit受給申請事由(RString jukyuShinseiJiyu, RString shienShinseiKubun) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(jukyuShinseiJiyu)) {
            return 初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(jukyuShinseiJiyu)) {
            return 再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(jukyuShinseiJiyu)) {
            return 再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(jukyuShinseiJiyu)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(shienShinseiKubun)) {
                return 支援から申請;
            }
            return 区分変更申請;
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(jukyuShinseiJiyu)) {
            return サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(jukyuShinseiJiyu)) {
            return 施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(jukyuShinseiJiyu)) {
            return 追加;
        }
        return RString.EMPTY;
    }

    private RString edit支援申請(RString ninteiShinseiHoreiKubunCode) {
        try {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(ninteiShinseiHoreiKubunCode)) {
                return 要支援申請;
            }
            return 要介護申請;
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

    private RString edit指定サービス種類(RString shiteiServiceShurui01,
            RString shiteiServiceShurui02,
            RString shiteiServiceShurui03,
            RString shiteiServiceShurui04,
            RString shiteiServiceShurui05,
            RString shiteiServiceShurui06) {

        StringBuilder builder = new StringBuilder();

        if (!RString.isNullOrEmpty(shiteiServiceShurui01)) {
            builder.append(shiteiServiceShurui01.subSequence(INDEX_0, INDEX_2));
        }
        if (!RString.isNullOrEmpty(shiteiServiceShurui02)) {
            builder.append(shiteiServiceShurui02.subSequence(INDEX_0, INDEX_2));
        }
        if (!RString.isNullOrEmpty(shiteiServiceShurui03)) {
            builder.append(shiteiServiceShurui03.subSequence(INDEX_0, INDEX_2));
        }
        if (!RString.isNullOrEmpty(shiteiServiceShurui04)) {
            builder.append(shiteiServiceShurui04.subSequence(INDEX_0, INDEX_2));
        }
        if (!RString.isNullOrEmpty(shiteiServiceShurui05)) {
            builder.append(shiteiServiceShurui05.subSequence(INDEX_0, INDEX_2));
        }
        if (!RString.isNullOrEmpty(shiteiServiceShurui06)) {
            builder.append(ETC);
        }
        return new RString(builder.toString());
    }

    private RString edit障害高齢者自立度(RString code) {
        RString result = RString.EMPTY;
        try {
            result = ShogaiNichijoSeikatsuJiritsudoCode.toValue(code).get名称();
        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    private RString edit認知症高齢者自立度(RString code) {
        RString result = RString.EMPTY;
        try {
            result = NinchishoNichijoSeikatsuJiritsudoCode.toValue(code).get名称();
        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    private RString edit居宅計画作成区分(RString sakuseiKubunCode) {
        if (sakuseiKubunCode == null) {
            return RString.EMPTY;
        }
        return KyotakuservicekeikakuSakuseikubunCode.toValue(sakuseiKubunCode).get名称();

    }

    private RString editみなし更新(RString minashiCode) {
        try {
            if (みなし要介護区分_通常の認定_コード.equals(MinashiCode.toValue(minashiCode).getコード())) {
                return RString.EMPTY;
            } else {
                return みなし;
            }
        } catch (Exception ex) {
            return RString.EMPTY;
        }
    }

    private RString edit受給状況(RString yukoMukoKubun) {

        try {
            if (有効無効区分_有効_コード.equals(yukoMukoKubun)) {
                return 有効;
            } else if (有効無効区分_無効_コード.equals(yukoMukoKubun)) {
                return 無効;
            } else {
                return RString.EMPTY;
            }
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

    private RString edit郵便番号(RString yubinNo) {

        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return new YubinNo(yubinNo).getEditedYubinNo();
    }

    private RString edit異動事由コード(RString dataKubun) {

        if (Datakubun.通常_認定.getコード().equals(dataKubun)) {
            return RString.EMPTY;
        }
        try {
            return Datakubun.toValue(dataKubun).get名称();
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

    private RString edit異動事由文言(RString chokkinIdoJiyuCode) {
        if (ChokkinIdoJiyuCode.未登録.getコード().equals(chokkinIdoJiyuCode)) {
            return 未登録;
        } else if (ChokkinIdoJiyuCode.追加_認定.getコード().equals(chokkinIdoJiyuCode)) {
            return 追加_認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請認定.getコード().equals(chokkinIdoJiyuCode)) {
            return 要介護度変更申請認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請却下.getコード().equals(chokkinIdoJiyuCode)) {
            return 要介護度変更申請却下;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請認定.getコード().equals(chokkinIdoJiyuCode)) {
            return サービス種類変更申請認定;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請却下.getコード().equals(chokkinIdoJiyuCode)) {
            return サービス種類変更申請却下;
        } else if (ChokkinIdoJiyuCode.削除.getコード().equals(chokkinIdoJiyuCode)) {
            return 削除;
        } else if (ChokkinIdoJiyuCode.修正.getコード().equals(chokkinIdoJiyuCode)) {
            return 修正;
        } else if (ChokkinIdoJiyuCode.受給申請却下.getコード().equals(chokkinIdoJiyuCode)) {
            return 受給申請却下;
        } else if (ChokkinIdoJiyuCode.削除回復.getコード().equals(chokkinIdoJiyuCode)) {
            return 削除回復;
        } else if (ChokkinIdoJiyuCode.職権記載.getコード().equals(chokkinIdoJiyuCode)) {
            return 職権記載;
        } else if (ChokkinIdoJiyuCode.職権修正.getコード().equals(chokkinIdoJiyuCode)) {
            return 職権修正;
        } else if (ChokkinIdoJiyuCode.職権取消.getコード().equals(chokkinIdoJiyuCode)) {
            return 職権取消;
        } else if (ChokkinIdoJiyuCode.履歴修正.getコード().equals(chokkinIdoJiyuCode)) {
            return 履歴修正;
        }
        return RString.EMPTY;
    }
}
